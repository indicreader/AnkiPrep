package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.compose.animation.core.AnimationKt;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;
import kotlin.time.DurationKt;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzrd implements zzqb {
    private static final Object zza = new Object();
    private static ExecutorService zzb;
    private static int zzc;
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private int zzE;
    private boolean zzF;
    private boolean zzG;
    private long zzH;
    private float zzI;
    private ByteBuffer zzJ;
    private int zzK;
    private ByteBuffer zzL;
    private boolean zzM;
    private boolean zzN;
    private boolean zzO;
    private int zzP;
    private zzl zzQ;
    private zzqp zzR;
    private long zzS;
    private boolean zzT;
    private boolean zzU;
    private long zzV;
    private long zzW;
    private Handler zzX;
    private final zzqt zzY;
    private final zzqj zzZ;
    private final zzqg zzd;
    private final zzrn zze;
    private final zzgaa zzf;
    private final zzgaa zzg;
    private final zzeo zzh;
    private final zzqf zzi;
    private final ArrayDeque zzj;
    private zzrb zzk;
    private final zzqw zzl;
    private final zzqw zzm;
    private final zzqq zzn;
    private zzpb zzo;
    private zzpy zzp;
    private zzqs zzq;
    private zzqs zzr;
    private zzdq zzs;
    private AudioTrack zzt;
    private zzpd zzu;
    private zzk zzv = zzk.zza;
    private zzqv zzw;
    private zzqv zzx;
    private zzcg zzy;
    private boolean zzz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzrd(zzqr zzqrVar, zzrc zzrcVar) {
        zzpd zzpdVar;
        zzqt zzqtVar;
        zzqq zzqqVar;
        zzqj zzqjVar;
        zzpdVar = zzqrVar.zza;
        this.zzu = zzpdVar;
        zzqtVar = zzqrVar.zzd;
        this.zzY = zzqtVar;
        int i = zzfy.zza;
        zzqqVar = zzqrVar.zzc;
        this.zzn = zzqqVar;
        zzqjVar = zzqrVar.zze;
        zzqjVar.getClass();
        this.zzZ = zzqjVar;
        zzeo zzeoVar = new zzeo(zzel.zza);
        this.zzh = zzeoVar;
        zzeoVar.zze();
        this.zzi = new zzqf(new zzqy(this, null));
        zzqg zzqgVar = new zzqg();
        this.zzd = zzqgVar;
        zzrn zzrnVar = new zzrn();
        this.zze = zzrnVar;
        this.zzf = zzgaa.zzo(new zzdx(), zzqgVar, zzrnVar);
        this.zzg = zzgaa.zzm(new zzrm());
        this.zzI = 1.0f;
        this.zzP = 0;
        this.zzQ = new zzl(0, 0.0f);
        this.zzx = new zzqv(zzcg.zza, 0L, 0L, null);
        this.zzy = zzcg.zza;
        this.zzz = false;
        this.zzj = new ArrayDeque();
        this.zzl = new zzqw(100L);
        this.zzm = new zzqw(100L);
    }

    public static /* synthetic */ void zzF(zzrd zzrdVar) {
        if (zzrdVar.zzW >= AnimationKt.MillisToNanos) {
            ((zzri) zzrdVar.zzp).zza.zzn = true;
        }
        zzrdVar.zzW = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzG(AudioTrack audioTrack, final zzpy zzpyVar, Handler handler, final zzpv zzpvVar, zzeo zzeoVar) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (zzpyVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzql
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzpt zzptVar;
                        zzptVar = ((zzri) zzpy.this).zza.zzc;
                        zzptVar.zzd(zzpvVar);
                    }
                });
            }
            zzeoVar.zze();
            synchronized (zza) {
                int i = zzc - 1;
                zzc = i;
                if (i == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
            }
        } catch (Throwable th) {
            if (zzpyVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzql
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzpt zzptVar;
                        zzptVar = ((zzri) zzpy.this).zza.zzc;
                        zzptVar.zzd(zzpvVar);
                    }
                });
            }
            zzeoVar.zze();
            synchronized (zza) {
                int i2 = zzc - 1;
                zzc = i2;
                if (i2 == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzI() {
        return this.zzr.zzc == 0 ? this.zzA / r0.zzb : this.zzB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzJ() {
        zzqs zzqsVar = this.zzr;
        if (zzqsVar.zzc != 0) {
            return this.zzD;
        }
        long j = this.zzC;
        long j2 = zzqsVar.zzd;
        int i = zzfy.zza;
        return ((j + j2) - 1) / j2;
    }

    private final AudioTrack zzK(zzqs zzqsVar) throws zzpx {
        try {
            return zzqsVar.zza(this.zzv, this.zzP);
        } catch (zzpx e) {
            zzpy zzpyVar = this.zzp;
            if (zzpyVar != null) {
                zzpyVar.zza(e);
            }
            throw e;
        }
    }

    private final void zzL(long j) {
        zzcg zzcgVar;
        boolean z;
        zzpt zzptVar;
        if (zzW()) {
            zzqt zzqtVar = this.zzY;
            zzcgVar = this.zzy;
            zzqtVar.zzc(zzcgVar);
        } else {
            zzcgVar = zzcg.zza;
        }
        zzcg zzcgVar2 = zzcgVar;
        this.zzy = zzcgVar2;
        if (zzW()) {
            zzqt zzqtVar2 = this.zzY;
            z = this.zzz;
            zzqtVar2.zzd(z);
        } else {
            z = false;
        }
        this.zzz = z;
        this.zzj.add(new zzqv(zzcgVar2, Math.max(0L, j), zzfy.zzr(zzJ(), this.zzr.zze), null));
        zzR();
        zzpy zzpyVar = this.zzp;
        if (zzpyVar != null) {
            boolean z2 = this.zzz;
            zzptVar = ((zzri) zzpyVar).zza.zzc;
            zzptVar.zzw(z2);
        }
    }

    private final void zzM() {
        if (this.zzr.zzc()) {
            this.zzT = true;
        }
    }

    private final void zzN() {
        if (this.zzN) {
            return;
        }
        this.zzN = true;
        this.zzi.zzb(zzJ());
        this.zzt.stop();
    }

    private final void zzO(long j) throws zzqa {
        ByteBuffer zzb2;
        if (!this.zzs.zzh()) {
            ByteBuffer byteBuffer = this.zzJ;
            if (byteBuffer == null) {
                byteBuffer = zzdt.zza;
            }
            zzS(byteBuffer, j);
            return;
        }
        while (!this.zzs.zzg()) {
            do {
                zzb2 = this.zzs.zzb();
                if (zzb2.hasRemaining()) {
                    zzS(zzb2, j);
                } else {
                    ByteBuffer byteBuffer2 = this.zzJ;
                    if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
                        return;
                    } else {
                        this.zzs.zze(this.zzJ);
                    }
                }
            } while (!zzb2.hasRemaining());
            return;
        }
    }

    private final void zzP(zzcg zzcgVar) {
        zzqv zzqvVar = new zzqv(zzcgVar, -9223372036854775807L, -9223372036854775807L, null);
        if (zzU()) {
            this.zzw = zzqvVar;
        } else {
            this.zzx = zzqvVar;
        }
    }

    private final void zzQ() {
        if (zzU()) {
            int i = zzfy.zza;
            this.zzt.setVolume(this.zzI);
        }
    }

    private final void zzR() {
        zzdq zzdqVar = this.zzr.zzi;
        this.zzs = zzdqVar;
        zzdqVar.zzc();
    }

    private final void zzS(ByteBuffer byteBuffer, long j) throws zzqa {
        zzpy zzpyVar;
        zzme zzmeVar;
        zzme zzmeVar2;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.zzL;
            if (byteBuffer2 != null) {
                zzek.zzd(byteBuffer2 == byteBuffer);
            } else {
                this.zzL = byteBuffer;
                int i = zzfy.zza;
            }
            int remaining = byteBuffer.remaining();
            int i2 = zzfy.zza;
            int write = this.zzt.write(byteBuffer, remaining, 1);
            this.zzS = SystemClock.elapsedRealtime();
            if (write < 0) {
                if ((zzfy.zza >= 24 && write == -6) || write == -32) {
                    if (zzJ() <= 0) {
                        if (zzV(this.zzt)) {
                            zzM();
                        }
                    }
                    r10 = true;
                }
                zzqa zzqaVar = new zzqa(write, this.zzr.zza, r10);
                zzpy zzpyVar2 = this.zzp;
                if (zzpyVar2 != null) {
                    zzpyVar2.zza(zzqaVar);
                }
                if (zzqaVar.zzb) {
                    this.zzu = zzpd.zza;
                    throw zzqaVar;
                }
                this.zzm.zzb(zzqaVar);
                return;
            }
            this.zzm.zza();
            if (zzV(this.zzt)) {
                if (this.zzD > 0) {
                    this.zzU = false;
                }
                if (this.zzO && (zzpyVar = this.zzp) != null && write < remaining) {
                    zzrj zzrjVar = ((zzri) zzpyVar).zza;
                    zzmeVar = zzrjVar.zzm;
                    if (zzmeVar != null) {
                        zzmeVar2 = zzrjVar.zzm;
                        zzmeVar2.zza();
                    }
                }
            }
            int i3 = this.zzr.zzc;
            if (i3 == 0) {
                this.zzC += write;
            }
            if (write == remaining) {
                if (i3 != 0) {
                    zzek.zzf(byteBuffer == this.zzJ);
                    this.zzD += this.zzE * this.zzK;
                }
                this.zzL = null;
            }
        }
    }

    private final boolean zzT() throws zzqa {
        if (!this.zzs.zzh()) {
            ByteBuffer byteBuffer = this.zzL;
            if (byteBuffer == null) {
                return true;
            }
            zzS(byteBuffer, Long.MIN_VALUE);
            return this.zzL == null;
        }
        this.zzs.zzd();
        zzO(Long.MIN_VALUE);
        if (!this.zzs.zzg()) {
            return false;
        }
        ByteBuffer byteBuffer2 = this.zzL;
        return byteBuffer2 == null || !byteBuffer2.hasRemaining();
    }

    private final boolean zzU() {
        return this.zzt != null;
    }

    private static boolean zzV(AudioTrack audioTrack) {
        return zzfy.zza >= 29 && audioTrack.isOffloadedPlayback();
    }

    private final boolean zzW() {
        zzqs zzqsVar = this.zzr;
        if (zzqsVar.zzc != 0) {
            return false;
        }
        int i = zzqsVar.zza.zzB;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final int zza(zzam zzamVar) {
        if (!"audio/raw".equals(zzamVar.zzm)) {
            return this.zzu.zza(zzamVar, this.zzv) != null ? 2 : 0;
        }
        if (zzfy.zzH(zzamVar.zzB)) {
            return zzamVar.zzB != 2 ? 1 : 2;
        }
        zzff.zzf("DefaultAudioSink", "Invalid PCM encoding: " + zzamVar.zzB);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final long zzb(boolean z) {
        long zzo;
        if (!zzU() || this.zzG) {
            return Long.MIN_VALUE;
        }
        long min = Math.min(this.zzi.zza(z), zzfy.zzr(zzJ(), this.zzr.zze));
        while (!this.zzj.isEmpty() && min >= ((zzqv) this.zzj.getFirst()).zzc) {
            this.zzx = (zzqv) this.zzj.remove();
        }
        zzqv zzqvVar = this.zzx;
        long j = min - zzqvVar.zzc;
        if (zzqvVar.zza.equals(zzcg.zza)) {
            zzo = this.zzx.zzb + j;
        } else if (this.zzj.isEmpty()) {
            zzo = this.zzY.zza(j) + this.zzx.zzb;
        } else {
            zzqv zzqvVar2 = (zzqv) this.zzj.getFirst();
            zzo = zzqvVar2.zzb - zzfy.zzo(zzqvVar2.zzc - min, this.zzx.zza.zzc);
        }
        long zzb2 = this.zzY.zzb();
        long zzr = zzo + zzfy.zzr(zzb2, this.zzr.zze);
        long j2 = this.zzV;
        if (zzb2 > j2) {
            long zzr2 = zzfy.zzr(zzb2 - j2, this.zzr.zze);
            this.zzV = zzb2;
            this.zzW += zzr2;
            if (this.zzX == null) {
                this.zzX = new Handler(Looper.myLooper());
            }
            this.zzX.removeCallbacksAndMessages(null);
            this.zzX.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqm
                @Override // java.lang.Runnable
                public final void run() {
                    zzrd.zzF(zzrd.this);
                }
            }, 100L);
        }
        return zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final zzcg zzc() {
        return this.zzy;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final zzpg zzd(zzam zzamVar) {
        if (this.zzT) {
            return zzpg.zza;
        }
        return this.zzZ.zza(zzamVar, this.zzv);
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zze(zzam zzamVar, int i, int[] iArr) throws zzpw {
        int intValue;
        zzdq zzdqVar;
        int i2;
        int intValue2;
        int i3;
        int i4;
        int i5;
        int i6;
        int max;
        int zzb2;
        if ("audio/raw".equals(zzamVar.zzm)) {
            zzek.zzd(zzfy.zzH(zzamVar.zzB));
            i2 = zzfy.zzl(zzamVar.zzB, zzamVar.zzz);
            zzfzx zzfzxVar = new zzfzx();
            int i7 = zzamVar.zzB;
            zzfzxVar.zzh(this.zzf);
            zzfzxVar.zzg(this.zzY.zze());
            zzdq zzdqVar2 = new zzdq(zzfzxVar.zzi());
            if (zzdqVar2.equals(this.zzs)) {
                zzdqVar2 = this.zzs;
            }
            this.zze.zzq(zzamVar.zzC, zzamVar.zzD);
            this.zzd.zzo(iArr);
            try {
                zzdr zza2 = zzdqVar2.zza(new zzdr(zzamVar.zzA, zzamVar.zzz, zzamVar.zzB));
                intValue = zza2.zzd;
                i4 = zza2.zzb;
                int i8 = zza2.zzc;
                intValue2 = zzfy.zzg(i8);
                zzdqVar = zzdqVar2;
                i3 = zzfy.zzl(intValue, i8);
                i5 = 0;
            } catch (zzds e) {
                throw new zzpw(e, zzamVar);
            }
        } else {
            zzdq zzdqVar3 = new zzdq(zzgaa.zzl());
            int i9 = zzamVar.zzA;
            zzpg zzpgVar = zzpg.zza;
            Pair zza3 = this.zzu.zza(zzamVar, this.zzv);
            if (zza3 == null) {
                throw new zzpw("Unable to configure passthrough for: ".concat(String.valueOf(String.valueOf(zzamVar))), zzamVar);
            }
            intValue = ((Integer) zza3.first).intValue();
            zzdqVar = zzdqVar3;
            i2 = -1;
            intValue2 = ((Integer) zza3.second).intValue();
            i3 = -1;
            i4 = i9;
            i5 = 2;
        }
        if (intValue == 0) {
            throw new zzpw("Invalid output encoding (mode=" + i5 + ") for: " + String.valueOf(zzamVar), zzamVar);
        }
        if (intValue2 == 0) {
            throw new zzpw("Invalid output channel config (mode=" + i5 + ") for: " + String.valueOf(zzamVar), zzamVar);
        }
        int minBufferSize = AudioTrack.getMinBufferSize(i4, intValue2, intValue);
        zzek.zzf(minBufferSize != -2);
        int i10 = i3 != -1 ? i3 : 1;
        int i11 = zzamVar.zzi;
        int i12 = 250000;
        if (i5 == 0) {
            i6 = i5;
            max = Math.max(zzrf.zza(250000, i4, i10), Math.min(minBufferSize * 4, zzrf.zza(750000, i4, i10)));
        } else if (i5 == 1) {
            i6 = i5;
            max = zzgcu.zza((zzrf.zzb(intValue) * 50000000) / AnimationKt.MillisToNanos);
        } else {
            if (intValue == 5) {
                i12 = 500000;
            } else if (intValue == 8) {
                i12 = DurationKt.NANOS_IN_MILLIS;
                intValue = 8;
            }
            if (i11 != -1) {
                zzb2 = zzgco.zza(i11, 8, RoundingMode.CEILING);
            } else {
                zzb2 = zzrf.zzb(intValue);
            }
            i6 = i5;
            max = zzgcu.zza((i12 * zzb2) / AnimationKt.MillisToNanos);
        }
        this.zzT = false;
        zzqs zzqsVar = new zzqs(zzamVar, i2, i6, i3, i4, intValue2, intValue, (((Math.max(minBufferSize, max) + i10) - 1) / i10) * i10, zzdqVar, false, false, false);
        if (zzU()) {
            this.zzq = zzqsVar;
        } else {
            this.zzr = zzqsVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzf() {
        if (zzU()) {
            this.zzA = 0L;
            this.zzB = 0L;
            this.zzC = 0L;
            this.zzD = 0L;
            this.zzU = false;
            this.zzE = 0;
            this.zzx = new zzqv(this.zzy, 0L, 0L, null);
            this.zzH = 0L;
            this.zzw = null;
            this.zzj.clear();
            this.zzJ = null;
            this.zzK = 0;
            this.zzL = null;
            this.zzN = false;
            this.zzM = false;
            this.zze.zzp();
            zzR();
            if (this.zzi.zzh()) {
                this.zzt.pause();
            }
            if (zzV(this.zzt)) {
                zzrb zzrbVar = this.zzk;
                zzrbVar.getClass();
                zzrbVar.zzb(this.zzt);
            }
            int i = zzfy.zza;
            final zzpv zzb2 = this.zzr.zzb();
            zzqs zzqsVar = this.zzq;
            if (zzqsVar != null) {
                this.zzr = zzqsVar;
                this.zzq = null;
            }
            this.zzi.zzc();
            final AudioTrack audioTrack = this.zzt;
            final zzeo zzeoVar = this.zzh;
            final zzpy zzpyVar = this.zzp;
            zzeoVar.zzc();
            final Handler handler = new Handler(Looper.myLooper());
            synchronized (zza) {
                if (zzb == null) {
                    zzb = zzfy.zzD("ExoPlayer:AudioTrackReleaseThread");
                }
                zzc++;
                zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqk
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzrd.zzG(audioTrack, zzpyVar, handler, zzb2, zzeoVar);
                    }
                });
            }
            this.zzt = null;
        }
        this.zzm.zza();
        this.zzl.zza();
        this.zzV = 0L;
        this.zzW = 0L;
        Handler handler2 = this.zzX;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzg() {
        this.zzF = true;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzh() {
        this.zzO = false;
        if (zzU()) {
            if (this.zzi.zzk() || zzV(this.zzt)) {
                this.zzt.pause();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzi() {
        this.zzO = true;
        if (zzU()) {
            this.zzi.zzf();
            this.zzt.play();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzj() throws zzqa {
        if (!this.zzM && zzU() && zzT()) {
            zzN();
            this.zzM = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzk() {
        zzf();
        zzgaa zzgaaVar = this.zzf;
        int size = zzgaaVar.size();
        for (int i = 0; i < size; i++) {
            ((zzdt) zzgaaVar.get(i)).zzf();
        }
        zzgaa zzgaaVar2 = this.zzg;
        int size2 = zzgaaVar2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((zzdt) zzgaaVar2.get(i2)).zzf();
        }
        zzdq zzdqVar = this.zzs;
        if (zzdqVar != null) {
            zzdqVar.zzf();
        }
        this.zzO = false;
        this.zzT = false;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzl(zzk zzkVar) {
        if (this.zzv.equals(zzkVar)) {
            return;
        }
        this.zzv = zzkVar;
        zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzm(int i) {
        if (this.zzP != i) {
            this.zzP = i;
            zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzn(zzl zzlVar) {
        if (this.zzQ.equals(zzlVar)) {
            return;
        }
        if (this.zzt != null) {
            int i = this.zzQ.zza;
        }
        this.zzQ = zzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzo(zzel zzelVar) {
        this.zzi.zze(zzelVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzp(zzpy zzpyVar) {
        this.zzp = zzpyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzq(int i, int i2) {
        AudioTrack audioTrack = this.zzt;
        if (audioTrack != null) {
            zzV(audioTrack);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzr(zzcg zzcgVar) {
        this.zzy = new zzcg(Math.max(0.1f, Math.min(zzcgVar.zzc, 8.0f)), Math.max(0.1f, Math.min(zzcgVar.zzd, 8.0f)));
        zzP(zzcgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzs(zzpb zzpbVar) {
        this.zzo = zzpbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzu(boolean z) {
        this.zzz = z;
        zzP(this.zzy);
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzv(float f) {
        if (this.zzI != f) {
            this.zzI = f;
            zzQ();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x01a6. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02e1 A[RETURN] */
    @Override // com.google.android.gms.internal.ads.zzqb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzw(java.nio.ByteBuffer r28, long r29, int r31) throws com.google.android.gms.internal.ads.zzpx, com.google.android.gms.internal.ads.zzqa {
        /*
            Method dump skipped, instructions count: 984
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrd.zzw(java.nio.ByteBuffer, long, int):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final boolean zzx() {
        return zzU() && this.zzi.zzg(zzJ());
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final boolean zzy() {
        if (zzU()) {
            return this.zzM && !zzx();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final boolean zzz(zzam zzamVar) {
        return zza(zzamVar) != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzt(AudioDeviceInfo audioDeviceInfo) {
        zzqp zzqpVar = audioDeviceInfo == null ? null : new zzqp(audioDeviceInfo);
        this.zzR = zzqpVar;
        AudioTrack audioTrack = this.zzt;
        if (audioTrack != null) {
            zzqn.zza(audioTrack, zzqpVar);
        }
    }
}
