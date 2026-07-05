package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import android.view.Surface;
import androidx.work.WorkRequest;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzaah extends zzsz implements zzaan {
    private static final int[] zzb = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean zzc;
    private static boolean zzd;
    private boolean zzA;
    private boolean zzB;
    private int zzC;
    private zzaal zzD;
    private zzabo zzE;
    private final Context zze;
    private final zzabp zzf;
    private final zzabj zzg;
    private final boolean zzh;
    private final zzaao zzi;
    private final zzaam zzj;
    private zzaag zzk;
    private boolean zzl;
    private boolean zzm;
    private Surface zzn;
    private zzaak zzo;
    private boolean zzp;
    private int zzq;
    private long zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private long zzv;
    private int zzw;
    private long zzx;
    private zzdp zzy;
    private zzdp zzz;

    public zzaah(Context context, zzsq zzsqVar, zztb zztbVar, long j, boolean z, Handler handler, zzabk zzabkVar, int i, float f) {
        super(2, zzsqVar, zztbVar, false, 30.0f);
        Context applicationContext = context.getApplicationContext();
        this.zze = applicationContext;
        this.zzg = new zzabj(handler, zzabkVar);
        zzzs zzzsVar = new zzzs(applicationContext);
        zzzsVar.zzc(new zzaao(applicationContext, this, 0L));
        zzaab zzd2 = zzzsVar.zzd();
        this.zzf = zzd2;
        this.zzi = zzd2.zza();
        this.zzj = new zzaam();
        this.zzh = "NVIDIA".equals(zzfy.zzc);
        this.zzq = 1;
        this.zzy = zzdp.zza;
        this.zzC = 0;
        this.zzz = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x04c3, code lost:
    
        if (r13.equals("deb") != false) goto L506;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x079e, code lost:
    
        if (r0.equals("JSN-L21") == false) goto L514;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0080 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected static final boolean zzaM(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 2926
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaah.zzaM(java.lang.String):boolean");
    }

    private static List zzaN(Context context, zztb zztbVar, zzam zzamVar, boolean z, boolean z2) throws zzth {
        if (zzamVar.zzm == null) {
            return zzgaa.zzl();
        }
        if (zzfy.zza >= 26 && "video/dolby-vision".equals(zzamVar.zzm) && !zzaaf.zza(context)) {
            List zzd2 = zztn.zzd(zztbVar, zzamVar, z, z2);
            if (!zzd2.isEmpty()) {
                return zzd2;
            }
        }
        return zztn.zzf(zztbVar, zzamVar, z, z2);
    }

    private final void zzaO() {
        zzdp zzdpVar = this.zzz;
        if (zzdpVar != null) {
            this.zzg.zzt(zzdpVar);
        }
    }

    private final void zzaP() {
        Surface surface = this.zzn;
        zzaak zzaakVar = this.zzo;
        if (surface == zzaakVar) {
            this.zzn = null;
        }
        if (zzaakVar != null) {
            zzaakVar.release();
            this.zzo = null;
        }
    }

    private final boolean zzaQ(zzsv zzsvVar) {
        if (zzfy.zza < 23 || zzaM(zzsvVar.zza)) {
            return false;
        }
        return !zzsvVar.zzf || zzaak.zzb(this.zze);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0075, code lost:
    
        if (r3.equals("video/av01") != false) goto L41;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x0083. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int zzac(com.google.android.gms.internal.ads.zzsv r10, com.google.android.gms.internal.ads.zzam r11) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaah.zzac(com.google.android.gms.internal.ads.zzsv, com.google.android.gms.internal.ads.zzam):int");
    }

    protected static int zzad(zzsv zzsvVar, zzam zzamVar) {
        if (zzamVar.zzn != -1) {
            int size = zzamVar.zzo.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                i += ((byte[]) zzamVar.zzo.get(i2)).length;
            }
            return zzamVar.zzn + i;
        }
        return zzac(zzsvVar, zzamVar);
    }

    @Override // com.google.android.gms.internal.ads.zziq
    protected final void zzA() {
        if (this.zzf.zzk()) {
            this.zzf.zze();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq
    public final void zzB() {
        try {
            super.zzB();
            this.zzB = false;
            if (this.zzo != null) {
                zzaP();
            }
        } catch (Throwable th) {
            this.zzB = false;
            if (this.zzo != null) {
                zzaP();
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zziq
    protected final void zzC() {
        this.zzs = 0;
        zzh();
        this.zzr = SystemClock.elapsedRealtime();
        this.zzv = 0L;
        this.zzw = 0;
        this.zzi.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zziq
    protected final void zzD() {
        if (this.zzs > 0) {
            zzh();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzg.zzd(this.zzs, elapsedRealtime - this.zzr);
            this.zzs = 0;
            this.zzr = elapsedRealtime;
        }
        int i = this.zzw;
        if (i != 0) {
            this.zzg.zzr(this.zzv, i);
            this.zzv = 0L;
            this.zzw = 0;
        }
        this.zzi.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq, com.google.android.gms.internal.ads.zzmf
    public final void zzL(float f, float f2) throws zziz {
        super.zzL(f, f2);
        this.zzi.zzn(f);
        if (this.zzE != null) {
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmf, com.google.android.gms.internal.ads.zzmh
    public final String zzT() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zzmf
    public final void zzU(long j, long j2) throws zziz {
        super.zzU(j, j2);
        if (this.zzE == null) {
            return;
        }
        try {
            throw null;
        } catch (zzabn e) {
            throw zzi(e, e.zza, false, 7001);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zzmf
    public final boolean zzV() {
        if (!super.zzV()) {
            return false;
        }
        if (this.zzE == null) {
            return true;
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zzmf
    public final boolean zzW() {
        boolean z;
        zzaak zzaakVar;
        if (!super.zzW()) {
            z = false;
        } else {
            if (this.zzE != null) {
                throw null;
            }
            z = true;
        }
        if (!z || (((zzaakVar = this.zzo) == null || this.zzn != zzaakVar) && zzau() != null)) {
            return this.zzi.zzo(z);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final float zzY(float f, zzam zzamVar, zzam[] zzamVarArr) {
        float f2 = -1.0f;
        for (zzam zzamVar2 : zzamVarArr) {
            float f3 = zzamVar2.zzt;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final int zzZ(zztb zztbVar, zzam zzamVar) throws zzth {
        boolean z;
        if (!zzcb.zzh(zzamVar.zzm)) {
            return 128;
        }
        int i = 1;
        int i2 = 0;
        boolean z2 = zzamVar.zzp != null;
        List zzaN = zzaN(this.zze, zztbVar, zzamVar, z2, false);
        if (z2 && zzaN.isEmpty()) {
            zzaN = zzaN(this.zze, zztbVar, zzamVar, false, false);
        }
        if (!zzaN.isEmpty()) {
            if (zzaJ(zzamVar)) {
                zzsv zzsvVar = (zzsv) zzaN.get(0);
                boolean zze = zzsvVar.zze(zzamVar);
                if (!zze) {
                    for (int i3 = 1; i3 < zzaN.size(); i3++) {
                        zzsv zzsvVar2 = (zzsv) zzaN.get(i3);
                        if (zzsvVar2.zze(zzamVar)) {
                            zze = true;
                            z = false;
                            zzsvVar = zzsvVar2;
                            break;
                        }
                    }
                }
                z = true;
                int i4 = true != zze ? 3 : 4;
                int i5 = true != zzsvVar.zzf(zzamVar) ? 8 : 16;
                int i6 = true != zzsvVar.zzg ? 0 : 64;
                int i7 = true != z ? 0 : 128;
                if (zzfy.zza >= 26 && "video/dolby-vision".equals(zzamVar.zzm) && !zzaaf.zza(this.zze)) {
                    i7 = 256;
                }
                if (zze) {
                    List zzaN2 = zzaN(this.zze, zztbVar, zzamVar, z2, true);
                    if (!zzaN2.isEmpty()) {
                        zzsv zzsvVar3 = (zzsv) zztn.zzg(zzaN2, zzamVar).get(0);
                        if (zzsvVar3.zze(zzamVar) && zzsvVar3.zzf(zzamVar)) {
                            i2 = 32;
                        }
                    }
                }
                return i4 | i5 | i2 | i6 | i7;
            }
            i = 2;
        }
        return i | 128;
    }

    @Override // com.google.android.gms.internal.ads.zzaan
    public final boolean zza(long j, long j2, boolean z) {
        return j < -30000 && !z;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzaA(zzam zzamVar) throws zziz {
        if (this.zzA && !this.zzB && !this.zzf.zzk()) {
            try {
                this.zzf.zzd(zzamVar);
                this.zzf.zzh(zzas());
                zzaal zzaalVar = this.zzD;
                if (zzaalVar != null) {
                    this.zzf.zzj(zzaalVar);
                }
            } catch (zzabn e) {
                throw zzi(e, zzamVar, false, 7000);
            }
        }
        if (this.zzE != null || !this.zzf.zzk()) {
            this.zzB = true;
        } else {
            this.zzE = this.zzf.zzb();
            zzgfe.zzb();
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzsz
    public final void zzaC() {
        super.zzaC();
        this.zzu = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final boolean zzaI(zzsv zzsvVar) {
        return this.zzn != null || zzaQ(zzsvVar);
    }

    protected final void zzaK(int i, int i2) {
        zzir zzirVar = this.zza;
        zzirVar.zzh += i;
        int i3 = i + i2;
        zzirVar.zzg += i3;
        this.zzs += i3;
        int i4 = this.zzt + i3;
        this.zzt = i4;
        zzirVar.zzi = Math.max(i4, zzirVar.zzi);
    }

    protected final void zzaL(long j) {
        zzir zzirVar = this.zza;
        zzirVar.zzk += j;
        zzirVar.zzl++;
        this.zzv += j;
        this.zzw++;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final zzis zzaa(zzsv zzsvVar, zzam zzamVar, zzam zzamVar2) {
        int i;
        int i2;
        zzis zzb2 = zzsvVar.zzb(zzamVar, zzamVar2);
        int i3 = zzb2.zze;
        zzaag zzaagVar = this.zzk;
        zzaagVar.getClass();
        if (zzamVar2.zzr > zzaagVar.zza || zzamVar2.zzs > zzaagVar.zzb) {
            i3 |= 256;
        }
        if (zzad(zzsvVar, zzamVar2) > zzaagVar.zzc) {
            i3 |= 64;
        }
        String str = zzsvVar.zza;
        if (i3 != 0) {
            i2 = i3;
            i = 0;
        } else {
            i = zzb2.zzd;
            i2 = 0;
        }
        return new zzis(str, zzamVar, zzamVar2, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzsz
    public final zzis zzab(zzlb zzlbVar) throws zziz {
        zzis zzab = super.zzab(zzlbVar);
        zzam zzamVar = zzlbVar.zza;
        zzamVar.getClass();
        this.zzg.zzf(zzamVar, zzab);
        return zzab;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0220  */
    @Override // com.google.android.gms.internal.ads.zzsz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final com.google.android.gms.internal.ads.zzsp zzae(com.google.android.gms.internal.ads.zzsv r20, com.google.android.gms.internal.ads.zzam r21, android.media.MediaCrypto r22, float r23) {
        /*
            Method dump skipped, instructions count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaah.zzae(com.google.android.gms.internal.ads.zzsv, com.google.android.gms.internal.ads.zzam, android.media.MediaCrypto, float):com.google.android.gms.internal.ads.zzsp");
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final List zzaf(zztb zztbVar, zzam zzamVar, boolean z) throws zzth {
        return zztn.zzg(zzaN(this.zze, zztbVar, zzamVar, false, false), zzamVar);
    }

    protected final void zzag(zzsr zzsrVar, int i, long j, long j2) {
        Surface surface;
        int i2 = zzfy.zza;
        Trace.beginSection("releaseOutputBuffer");
        zzsrVar.zzm(i, j2);
        Trace.endSection();
        this.zza.zze++;
        this.zzt = 0;
        if (this.zzE == null) {
            zzdp zzdpVar = this.zzy;
            if (!zzdpVar.equals(zzdp.zza) && !zzdpVar.equals(this.zzz)) {
                this.zzz = zzdpVar;
                this.zzg.zzt(zzdpVar);
            }
            if (!this.zzi.zzp() || (surface = this.zzn) == null) {
                return;
            }
            this.zzg.zzq(surface);
            this.zzp = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzah(zzih zzihVar) throws zziz {
        if (this.zzm) {
            ByteBuffer byteBuffer = zzihVar.zzf;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4) {
                    if (b3 == 0 || b3 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        zzsr zzau = zzau();
                        zzau.getClass();
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        zzau.zzp(bundle);
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzai(Exception exc) {
        zzff.zzd("MediaCodecVideoRenderer", "Video codec error", exc);
        this.zzg.zzs(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzaj(String str, zzsp zzspVar, long j, long j2) {
        this.zzg.zza(str, j, j2);
        this.zzl = zzaM(str);
        zzsv zzaw = zzaw();
        zzaw.getClass();
        boolean z = false;
        if (zzfy.zza >= 29 && "video/x-vnd.on2.vp9".equals(zzaw.zzb)) {
            MediaCodecInfo.CodecProfileLevel[] zzh = zzaw.zzh();
            int length = zzh.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (zzh[i].profile == 16384) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        this.zzm = z;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzak(String str) {
        this.zzg.zzb(str);
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzal(zzam zzamVar, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        zzsr zzau = zzau();
        if (zzau != null) {
            zzau.zzq(this.zzq);
        }
        mediaFormat.getClass();
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        float f = zzamVar.zzv;
        int i = zzfy.zza;
        int i2 = zzamVar.zzu;
        if (i2 == 90 || i2 == 270) {
            f = 1.0f / f;
            int i3 = integer2;
            integer2 = integer;
            integer = i3;
        }
        this.zzy = new zzdp(integer, integer2, 0, f);
        this.zzi.zzl(zzamVar.zzt);
        if (this.zzE == null) {
            return;
        }
        zzak zzb2 = zzamVar.zzb();
        zzb2.zzab(integer);
        zzb2.zzI(integer2);
        zzb2.zzV(0);
        zzb2.zzS(f);
        zzb2.zzac();
        throw null;
    }

    protected final void zzam(zzsr zzsrVar, int i, long j) {
        int i2 = zzfy.zza;
        Trace.beginSection("skipVideoBuffer");
        zzsrVar.zzn(i, false);
        Trace.endSection();
        this.zza.zzf++;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzan() {
        this.zzi.zzf();
        int i = zzfy.zza;
        if (this.zzf.zzk()) {
            this.zzf.zzh(zzas());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final int zzar(zzih zzihVar) {
        int i = zzfy.zza;
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final zzst zzav(Throwable th, zzsv zzsvVar) {
        return new zzaae(th, zzsvVar, this.zzn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzsz
    public final void zzay(long j) {
        super.zzay(j);
        this.zzu--;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzaz(zzih zzihVar) throws zziz {
        this.zzu++;
        int i = zzfy.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaan
    public final boolean zzb(long j, long j2) {
        return j < -30000 && j2 > 100000;
    }

    @Override // com.google.android.gms.internal.ads.zzaan
    public final boolean zzc(long j, long j2, long j3, boolean z, boolean z2) throws zziz {
        int zzd2;
        if (j >= -500000 || z || (zzd2 = zzd(j2)) == 0) {
            return false;
        }
        if (z2) {
            zzir zzirVar = this.zza;
            zzirVar.zzd += zzd2;
            zzirVar.zzf += this.zzu;
        } else {
            this.zza.zzj++;
            zzaK(zzd2, this.zzu);
        }
        zzaE();
        if (this.zzE == null) {
            return true;
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zziq, com.google.android.gms.internal.ads.zzmf
    public final void zzs() {
        this.zzi.zzb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq
    public final void zzw() {
        this.zzz = null;
        this.zzi.zzd();
        int i = zzfy.zza;
        this.zzp = false;
        try {
            super.zzw();
        } finally {
            this.zzg.zzc(this.zza);
            this.zzg.zzt(zzdp.zza);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq
    public final void zzx(boolean z, boolean z2) throws zziz {
        super.zzx(z, z2);
        zzm();
        this.zzg.zze(this.zza);
        this.zzi.zze(z2);
    }

    @Override // com.google.android.gms.internal.ads.zziq
    protected final void zzy() {
        zzaao zzaaoVar = this.zzi;
        zzel zzh = zzh();
        zzaaoVar.zzk(zzh);
        this.zzf.zzf(zzh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq
    public final void zzz(long j, boolean z) throws zziz {
        if (this.zzE != null) {
            throw null;
        }
        super.zzz(j, z);
        if (this.zzf.zzk()) {
            this.zzf.zzh(zzas());
        }
        this.zzi.zzi();
        if (z) {
            this.zzi.zzc();
        }
        int i = zzfy.zza;
        this.zzt = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final boolean zzap(long j, long j2, zzsr zzsrVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzam zzamVar) throws zziz {
        zzsrVar.getClass();
        long zzas = j3 - zzas();
        int zza = this.zzi.zza(j3, j, j2, zzat(), z2, this.zzj);
        if (z && !z2) {
            zzam(zzsrVar, i, zzas);
            return true;
        }
        if (this.zzn == this.zzo) {
            if (this.zzj.zzc() < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                zzam(zzsrVar, i, zzas);
                zzaL(this.zzj.zzc());
                return true;
            }
        } else {
            if (this.zzE != null) {
                try {
                    throw null;
                } catch (zzabn e) {
                    throw zzi(e, e.zza, false, 7001);
                }
            }
            if (zza == 0) {
                zzh();
                long nanoTime = System.nanoTime();
                int i4 = zzfy.zza;
                zzag(zzsrVar, i, zzas, nanoTime);
                zzaL(this.zzj.zzc());
                return true;
            }
            if (zza == 1) {
                zzaam zzaamVar = this.zzj;
                long zzd2 = zzaamVar.zzd();
                long zzc2 = zzaamVar.zzc();
                int i5 = zzfy.zza;
                if (zzd2 != this.zzx) {
                    zzag(zzsrVar, i, zzas, zzd2);
                } else {
                    zzam(zzsrVar, i, zzas);
                }
                zzaL(zzc2);
                this.zzx = zzd2;
                return true;
            }
            if (zza == 2) {
                int i6 = zzfy.zza;
                Trace.beginSection("dropVideoBuffer");
                zzsrVar.zzn(i, false);
                Trace.endSection();
                zzaK(0, 1);
                zzaL(this.zzj.zzc());
                return true;
            }
            if (zza == 3) {
                zzam(zzsrVar, i, zzas);
                zzaL(this.zzj.zzc());
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v12, types: [android.view.Surface] */
    @Override // com.google.android.gms.internal.ads.zziq, com.google.android.gms.internal.ads.zzma
    public final void zzt(int i, Object obj) throws zziz {
        Surface surface;
        if (i != 1) {
            if (i == 7) {
                obj.getClass();
                zzaal zzaalVar = (zzaal) obj;
                this.zzD = zzaalVar;
                this.zzf.zzj(zzaalVar);
                return;
            }
            if (i == 10) {
                obj.getClass();
                int intValue = ((Integer) obj).intValue();
                if (this.zzC != intValue) {
                    this.zzC = intValue;
                    return;
                }
                return;
            }
            if (i == 4) {
                obj.getClass();
                int intValue2 = ((Integer) obj).intValue();
                this.zzq = intValue2;
                zzsr zzau = zzau();
                if (zzau != null) {
                    zzau.zzq(intValue2);
                    return;
                }
                return;
            }
            if (i == 5) {
                zzaao zzaaoVar = this.zzi;
                obj.getClass();
                zzaaoVar.zzj(((Integer) obj).intValue());
                return;
            } else if (i == 13) {
                obj.getClass();
                this.zzf.zzi((List) obj);
                this.zzA = true;
                return;
            } else {
                if (i != 14) {
                    return;
                }
                obj.getClass();
                zzfq zzfqVar = (zzfq) obj;
                if (zzfqVar.zzb() == 0 || zzfqVar.zza() == 0 || (surface = this.zzn) == null) {
                    return;
                }
                this.zzf.zzg(surface, zzfqVar);
                return;
            }
        }
        zzaak zzaakVar = obj instanceof Surface ? (Surface) obj : null;
        if (zzaakVar == null) {
            zzaak zzaakVar2 = this.zzo;
            if (zzaakVar2 != null) {
                zzaakVar = zzaakVar2;
            } else {
                zzsv zzaw = zzaw();
                if (zzaw != null && zzaQ(zzaw)) {
                    zzaakVar = zzaak.zza(this.zze, zzaw.zzf);
                    this.zzo = zzaakVar;
                }
            }
        }
        if (this.zzn == zzaakVar) {
            if (zzaakVar == null || zzaakVar == this.zzo) {
                return;
            }
            zzaO();
            Surface surface2 = this.zzn;
            if (surface2 == null || !this.zzp) {
                return;
            }
            this.zzg.zzq(surface2);
            return;
        }
        this.zzn = zzaakVar;
        this.zzi.zzm(zzaakVar);
        this.zzp = false;
        int zzbf = zzbf();
        zzsr zzau2 = zzau();
        zzaak zzaakVar3 = zzaakVar;
        if (zzau2 != null) {
            zzaakVar3 = zzaakVar;
            if (!this.zzf.zzk()) {
                zzaak zzaakVar4 = zzaakVar;
                if (zzfy.zza >= 23) {
                    if (zzaakVar != null) {
                        zzaakVar4 = zzaakVar;
                        if (!this.zzl) {
                            zzau2.zzo(zzaakVar);
                            zzaakVar3 = zzaakVar;
                        }
                    } else {
                        zzaakVar4 = null;
                    }
                }
                zzaB();
                zzax();
                zzaakVar3 = zzaakVar4;
            }
        }
        if (zzaakVar3 == null || zzaakVar3 == this.zzo) {
            this.zzz = null;
            if (this.zzf.zzk()) {
                this.zzf.zzc();
            }
        } else {
            zzaO();
            if (zzbf == 2) {
                this.zzi.zzc();
            }
            if (this.zzf.zzk()) {
                this.zzf.zzg(zzaakVar3, zzfq.zza);
            }
        }
        int i2 = zzfy.zza;
    }
}
