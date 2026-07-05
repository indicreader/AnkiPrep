package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.compose.animation.core.AnimationKt;
import androidx.work.WorkRequest;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzqf {
    private long zzA;
    private long zzB;
    private long zzC;
    private boolean zzD;
    private long zzE;
    private long zzF;
    private boolean zzG;
    private long zzH;
    private zzel zzI;
    private final zzqe zza;
    private final long[] zzb;
    private AudioTrack zzc;
    private int zzd;
    private zzqd zze;
    private int zzf;
    private boolean zzg;
    private long zzh;
    private float zzi;
    private boolean zzj;
    private long zzk;
    private long zzl;
    private Method zzm;
    private long zzn;
    private boolean zzo;
    private boolean zzp;
    private long zzq;
    private long zzr;
    private long zzs;
    private long zzt;
    private long zzu;
    private int zzv;
    private int zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    public zzqf(zzqe zzqeVar) {
        this.zza = zzqeVar;
        int i = zzfy.zza;
        try {
            this.zzm = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.zzb = new long[10];
        this.zzI = zzel.zza;
    }

    private final long zzl() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = 2;
        if (this.zzx != -9223372036854775807L) {
            AudioTrack audioTrack = this.zzc;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 2) {
                return this.zzz;
            }
            return Math.min(this.zzA, this.zzz + zzfy.zzn(zzfy.zzo(zzfy.zzq(elapsedRealtime) - this.zzx, this.zzi), this.zzf));
        }
        if (elapsedRealtime - this.zzr >= 5) {
            AudioTrack audioTrack2 = this.zzc;
            audioTrack2.getClass();
            int playState = audioTrack2.getPlayState();
            if (playState != 1) {
                long playbackHeadPosition = audioTrack2.getPlaybackHeadPosition() & 4294967295L;
                long j = 0;
                if (this.zzg) {
                    if (playState != 2) {
                        i = playState;
                    } else if (playbackHeadPosition == 0) {
                        this.zzu = this.zzs;
                    }
                    playbackHeadPosition += this.zzu;
                    playState = i;
                }
                if (zzfy.zza <= 29) {
                    if (playbackHeadPosition != 0) {
                        j = playbackHeadPosition;
                    } else if (this.zzs > 0 && playState == 3) {
                        if (this.zzy == -9223372036854775807L) {
                            this.zzy = elapsedRealtime;
                        }
                    }
                    this.zzy = -9223372036854775807L;
                    playbackHeadPosition = j;
                }
                if (this.zzs > playbackHeadPosition) {
                    this.zzt++;
                }
                this.zzs = playbackHeadPosition;
            }
            this.zzr = elapsedRealtime;
        }
        return this.zzs + this.zzH + (this.zzt << 32);
    }

    private final long zzm() {
        return zzfy.zzr(zzl(), this.zzf);
    }

    private final void zzn() {
        this.zzk = 0L;
        this.zzw = 0;
        this.zzv = 0;
        this.zzl = 0L;
        this.zzC = 0L;
        this.zzF = 0L;
        this.zzj = false;
    }

    public final void zzb(long j) {
        this.zzz = zzl();
        this.zzx = zzfy.zzq(SystemClock.elapsedRealtime());
        this.zzA = j;
    }

    public final void zzc() {
        zzn();
        this.zzc = null;
        this.zze = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzd(android.media.AudioTrack r3, boolean r4, int r5, int r6, int r7) {
        /*
            r2 = this;
            r2.zzc = r3
            r2.zzd = r7
            com.google.android.gms.internal.ads.zzqd r0 = new com.google.android.gms.internal.ads.zzqd
            r0.<init>(r3)
            r2.zze = r0
            int r3 = r3.getSampleRate()
            r2.zzf = r3
            r3 = 0
            if (r4 == 0) goto L23
            int r4 = com.google.android.gms.internal.ads.zzfy.zza
            r0 = 23
            if (r4 >= r0) goto L23
            r4 = 5
            r0 = 1
            if (r5 == r4) goto L24
            r4 = 6
            if (r5 != r4) goto L23
            r5 = r4
            goto L24
        L23:
            r0 = r3
        L24:
            r2.zzg = r0
            boolean r4 = com.google.android.gms.internal.ads.zzfy.zzH(r5)
            r2.zzp = r4
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L3c
            int r7 = r7 / r6
            long r4 = (long) r7
            int r6 = r2.zzf
            long r4 = com.google.android.gms.internal.ads.zzfy.zzr(r4, r6)
            goto L3d
        L3c:
            r4 = r0
        L3d:
            r2.zzh = r4
            r4 = 0
            r2.zzs = r4
            r2.zzt = r4
            r2.zzG = r3
            r2.zzH = r4
            r2.zzu = r4
            r2.zzo = r3
            r2.zzx = r0
            r2.zzy = r0
            r2.zzq = r4
            r2.zzn = r4
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.zzi = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqf.zzd(android.media.AudioTrack, boolean, int, int, int):void");
    }

    public final void zze(zzel zzelVar) {
        this.zzI = zzelVar;
    }

    public final void zzf() {
        if (this.zzx != -9223372036854775807L) {
            this.zzx = zzfy.zzq(SystemClock.elapsedRealtime());
        }
        zzqd zzqdVar = this.zze;
        zzqdVar.getClass();
        zzqdVar.zze();
    }

    public final boolean zzg(long j) {
        if (j > zzfy.zzn(zza(false), this.zzf)) {
            return true;
        }
        if (this.zzg) {
            AudioTrack audioTrack = this.zzc;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 2 && zzl() == 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzi(long j) {
        return this.zzy != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.zzy >= 200;
    }

    public final boolean zzk() {
        zzn();
        if (this.zzx == -9223372036854775807L) {
            zzqd zzqdVar = this.zze;
            zzqdVar.getClass();
            zzqdVar.zze();
            return true;
        }
        this.zzz = zzl();
        return false;
    }

    public final boolean zzh() {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        return audioTrack.getPlayState() == 3;
    }

    public final boolean zzj(long j) {
        zzpy zzpyVar;
        long j2;
        zzpy zzpyVar2;
        zzpt zzptVar;
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        int playState = audioTrack.getPlayState();
        if (this.zzg) {
            if (playState == 2) {
                this.zzo = false;
                return false;
            }
            if (playState == 1) {
                if (zzl() == 0) {
                    return false;
                }
                playState = 1;
            }
        }
        boolean z = this.zzo;
        boolean zzg = zzg(j);
        this.zzo = zzg;
        if (z && !zzg && playState != 1) {
            zzqe zzqeVar = this.zza;
            int i = this.zzd;
            long zzt = zzfy.zzt(this.zzh);
            zzqy zzqyVar = (zzqy) zzqeVar;
            zzrd zzrdVar = zzqyVar.zza;
            zzpyVar = zzrdVar.zzp;
            if (zzpyVar != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                j2 = zzrdVar.zzS;
                zzpyVar2 = zzqyVar.zza.zzp;
                zzptVar = ((zzri) zzpyVar2).zza.zzc;
                zzptVar.zzx(i, zzt, elapsedRealtime - j2);
            }
        }
        return true;
    }

    public final long zza(boolean z) {
        long zzo;
        zzpy zzpyVar;
        zzpy zzpyVar2;
        zzpt zzptVar;
        Method method;
        long zzI;
        long zzJ;
        long zzI2;
        long zzJ2;
        zzqf zzqfVar = this;
        AudioTrack audioTrack = zzqfVar.zzc;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 3) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - zzqfVar.zzl >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                long zzm = zzm();
                if (zzm != 0) {
                    zzqfVar.zzb[zzqfVar.zzv] = zzfy.zzp(zzm, zzqfVar.zzi) - nanoTime;
                    zzqfVar.zzv = (zzqfVar.zzv + 1) % 10;
                    int i = zzqfVar.zzw;
                    if (i < 10) {
                        zzqfVar.zzw = i + 1;
                    }
                    zzqfVar.zzl = nanoTime;
                    zzqfVar.zzk = 0L;
                    int i2 = 0;
                    while (true) {
                        int i3 = zzqfVar.zzw;
                        if (i2 >= i3) {
                            break;
                        }
                        zzqfVar.zzk += zzqfVar.zzb[i2] / i3;
                        i2++;
                    }
                }
            }
            if (!zzqfVar.zzg) {
                zzqd zzqdVar = zzqfVar.zze;
                zzqdVar.getClass();
                if (zzqdVar.zzg(nanoTime)) {
                    long zzb = zzqdVar.zzb();
                    long zza = zzqdVar.zza();
                    long zzm2 = zzm();
                    if (Math.abs(zzb - nanoTime) > 5000000) {
                        zzrd zzrdVar = ((zzqy) zzqfVar.zza).zza;
                        zzI2 = zzrdVar.zzI();
                        zzJ2 = zzrdVar.zzJ();
                        zzff.zzf("DefaultAudioSink", "Spurious audio timestamp (system clock mismatch): " + zza + ", " + zzb + ", " + nanoTime + ", " + zzm2 + ", " + zzI2 + ", " + zzJ2);
                        zzqdVar.zzd();
                    } else if (Math.abs(zzfy.zzr(zza, zzqfVar.zzf) - zzm2) > 5000000) {
                        zzrd zzrdVar2 = ((zzqy) zzqfVar.zza).zza;
                        zzI = zzrdVar2.zzI();
                        zzJ = zzrdVar2.zzJ();
                        zzff.zzf("DefaultAudioSink", "Spurious audio timestamp (frame position mismatch): " + zza + ", " + zzb + ", " + nanoTime + ", " + zzm2 + ", " + zzI + ", " + zzJ);
                        zzqdVar.zzd();
                    } else {
                        zzqdVar.zzc();
                    }
                    zzqfVar = this;
                }
                if (zzqfVar.zzp && (method = zzqfVar.zzm) != null && nanoTime - zzqfVar.zzq >= 500000) {
                    try {
                        AudioTrack audioTrack2 = zzqfVar.zzc;
                        audioTrack2.getClass();
                        Integer num = (Integer) method.invoke(audioTrack2, new Object[0]);
                        int i4 = zzfy.zza;
                        long intValue = (num.intValue() * 1000) - zzqfVar.zzh;
                        zzqfVar.zzn = intValue;
                        long max = Math.max(intValue, 0L);
                        zzqfVar.zzn = max;
                        if (max > 5000000) {
                            zzff.zzf("DefaultAudioSink", "Ignoring impossibly large audio latency: " + max);
                            zzqfVar.zzn = 0L;
                        }
                    } catch (Exception unused) {
                        zzqfVar.zzm = null;
                    }
                    zzqfVar.zzq = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        zzqd zzqdVar2 = zzqfVar.zze;
        zzqdVar2.getClass();
        boolean zzf = zzqdVar2.zzf();
        if (zzf) {
            zzo = zzfy.zzr(zzqdVar2.zza(), zzqfVar.zzf) + zzfy.zzo(nanoTime2 - zzqdVar2.zzb(), zzqfVar.zzi);
        } else {
            if (zzqfVar.zzw == 0) {
                zzo = zzm();
            } else {
                zzo = zzfy.zzo(zzqfVar.zzk + nanoTime2, zzqfVar.zzi);
            }
            if (!z) {
                zzo = Math.max(0L, zzo - zzqfVar.zzn);
            }
        }
        if (zzqfVar.zzD != zzf) {
            zzqfVar.zzF = zzqfVar.zzC;
            zzqfVar.zzE = zzqfVar.zzB;
        }
        long j = nanoTime2 - zzqfVar.zzF;
        if (j < AnimationKt.MillisToNanos) {
            long zzo2 = zzqfVar.zzE + zzfy.zzo(j, zzqfVar.zzi);
            long j2 = (j * 1000) / AnimationKt.MillisToNanos;
            zzo = ((zzo * j2) + ((1000 - j2) * zzo2)) / 1000;
        }
        if (!zzqfVar.zzj) {
            long j3 = zzqfVar.zzB;
            if (zzo > j3) {
                zzqfVar.zzj = true;
                int i5 = zzfy.zza;
                long currentTimeMillis = System.currentTimeMillis() - zzfy.zzt(zzfy.zzp(zzfy.zzt(zzo - j3), zzqfVar.zzi));
                zzrd zzrdVar3 = ((zzqy) zzqfVar.zza).zza;
                zzpyVar = zzrdVar3.zzp;
                if (zzpyVar != null) {
                    zzpyVar2 = zzrdVar3.zzp;
                    zzptVar = ((zzri) zzpyVar2).zza.zzc;
                    zzptVar.zzv(currentTimeMillis);
                }
            }
        }
        zzqfVar.zzC = nanoTime2;
        zzqfVar.zzB = zzo;
        zzqfVar.zzD = zzf;
        return zzo;
    }
}
