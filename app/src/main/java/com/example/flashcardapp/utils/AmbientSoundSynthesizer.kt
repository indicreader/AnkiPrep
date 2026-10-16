package com.example.flashcardapp.utils

import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioTrack
import kotlinx.coroutines.*
import java.util.Random

enum class AmbientSoundType(val displayName: String) {
    OFF("Off"),
    RAIN("Gentle Rain (Pink Noise)"),
    WATERFALL("Deep Waterfall (Brown Noise)"),
    WHITE_NOISE("White Noise"),
    CLOCK_TICK("Clock Tick (1 Hz)")
}

/**
 * 100% Offline Procedural Sound Synthesizer.
 * Generates continuous ambient noise in real-time via [AudioTrack] without requiring any MP3/WAV assets.
 */
object AmbientSoundSynthesizer {

    private const val SAMPLE_RATE = 22050
    private var audioTrack: AudioTrack? = null
    private var synthJob: Job? = null
    private val scope = CoroutineScope(Dispatchers.Default + SupervisorJob())

    @Volatile
    private var isPlaying = false

    @Volatile
    private var currentType = AmbientSoundType.OFF

    @Volatile
    private var volume = 0.5f

    fun play(type: AmbientSoundType, soundVolume: Float = 0.5f) {
        if (type == AmbientSoundType.OFF) {
            stop()
            return
        }

        volume = soundVolume
        currentType = type

        if (isPlaying) return
        isPlaying = true

        val minBufferSize = AudioTrack.getMinBufferSize(
            SAMPLE_RATE,
            AudioFormat.CHANNEL_OUT_MONO,
            AudioFormat.ENCODING_PCM_16BIT
        )
        val bufferSize = maxOf(minBufferSize, SAMPLE_RATE)

        audioTrack = AudioTrack.Builder()
            .setAudioAttributes(
                AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build()
            )
            .setAudioFormat(
                AudioFormat.Builder()
                    .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                    .setSampleRate(SAMPLE_RATE)
                    .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                    .build()
            )
            .setBufferSizeInBytes(bufferSize)
            .setTransferMode(AudioTrack.MODE_STREAM)
            .build()

        audioTrack?.play()

        synthJob = scope.launch {
            val random = Random()
            val shortBuffer = ShortArray(1024)
            var lastBrown = 0f
            var tickPhase = 0

            while (isActive && isPlaying) {
                for (i in shortBuffer.indices) {
                    val rawSample = when (currentType) {
                        AmbientSoundType.WHITE_NOISE -> {
                            (random.nextFloat() * 2f - 1f) * 0.4f
                        }
                        AmbientSoundType.RAIN -> {
                            // Pink noise approximation
                            val white = random.nextFloat() * 2f - 1f
                            lastBrown = (lastBrown * 0.85f) + (white * 0.15f)
                            lastBrown * 0.6f
                        }
                        AmbientSoundType.WATERFALL -> {
                            // Brown noise approximation
                            val white = random.nextFloat() * 2f - 1f
                            lastBrown = (lastBrown * 0.96f) + (white * 0.04f)
                            lastBrown * 1.8f
                        }
                        AmbientSoundType.CLOCK_TICK -> {
                            tickPhase = (tickPhase + 1) % SAMPLE_RATE
                            if (tickPhase < 400) {
                                (random.nextFloat() * 2f - 1f) * (1f - tickPhase / 400f) * 0.7f
                            } else {
                                0f
                            }
                        }
                        AmbientSoundType.OFF -> 0f
                    }

                    val scaled = (rawSample * volume).coerceIn(-1f, 1f)
                    shortBuffer[i] = (scaled * 32767).toInt().toShort()
                }

                audioTrack?.write(shortBuffer, 0, shortBuffer.size)
            }
        }
    }

    fun setVolumeLevel(newVolume: Float) {
        volume = newVolume.coerceIn(0f, 1f)
    }

    fun stop() {
        isPlaying = false
        currentType = AmbientSoundType.OFF
        synthJob?.cancel()
        synthJob = null
        try {
            audioTrack?.stop()
            audioTrack?.release()
        } catch (_: Exception) {}
        audioTrack = null
    }
}
