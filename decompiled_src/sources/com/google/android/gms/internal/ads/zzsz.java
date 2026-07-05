package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Trace;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzsz extends zziq {
    private static final byte[] zzb = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, 49, -61, 39, 93, 120};
    private int zzA;
    private boolean zzB;
    private boolean zzC;
    private boolean zzD;
    private boolean zzE;
    private boolean zzF;
    private boolean zzG;
    private long zzH;
    private int zzI;
    private int zzJ;
    private ByteBuffer zzK;
    private boolean zzL;
    private boolean zzM;
    private boolean zzN;
    private boolean zzO;
    private boolean zzP;
    private boolean zzQ;
    private int zzR;
    private int zzS;
    private int zzT;
    private boolean zzU;
    private boolean zzV;
    private boolean zzW;
    private long zzX;
    private long zzY;
    private boolean zzZ;
    protected zzir zza;
    private boolean zzaa;
    private boolean zzab;
    private zzsy zzac;
    private long zzad;
    private boolean zzae;
    private zzrz zzaf;
    private zzrz zzag;
    private final zzsq zzc;
    private final zztb zzd;
    private final float zze;
    private final zzih zzf;
    private final zzih zzg;
    private final zzih zzh;
    private final zzsn zzi;
    private final MediaCodec.BufferInfo zzj;
    private final ArrayDeque zzk;
    private final zzrk zzl;
    private zzam zzm;
    private zzam zzn;
    private MediaCrypto zzo;
    private boolean zzp;
    private long zzq;
    private float zzr;
    private zzsr zzs;
    private zzam zzt;
    private MediaFormat zzu;
    private boolean zzv;
    private float zzw;
    private ArrayDeque zzx;
    private zzsx zzy;
    private zzsv zzz;

    public zzsz(int i, zzsq zzsqVar, zztb zztbVar, boolean z, float f) {
        super(i);
        this.zzc = zzsqVar;
        zztbVar.getClass();
        this.zzd = zztbVar;
        this.zze = f;
        this.zzf = new zzih(0, 0);
        this.zzg = new zzih(0, 0);
        this.zzh = new zzih(2, 0);
        zzsn zzsnVar = new zzsn();
        this.zzi = zzsnVar;
        this.zzj = new MediaCodec.BufferInfo();
        this.zzr = 1.0f;
        this.zzq = -9223372036854775807L;
        this.zzk = new ArrayDeque();
        this.zzac = zzsy.zza;
        zzsnVar.zzi(0);
        zzsnVar.zzc.order(ByteOrder.nativeOrder());
        this.zzl = new zzrk();
        this.zzw = -1.0f;
        this.zzA = 0;
        this.zzR = 0;
        this.zzI = -1;
        this.zzJ = -1;
        this.zzH = -9223372036854775807L;
        this.zzX = -9223372036854775807L;
        this.zzY = -9223372036854775807L;
        this.zzad = -9223372036854775807L;
        this.zzS = 0;
        this.zzT = 0;
        this.zza = new zzir();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean zzaJ(zzam zzamVar) {
        return zzamVar.zzG == 0;
    }

    private final void zzaL() {
        this.zzI = -1;
        this.zzg.zzc = null;
    }

    private final void zzaM() {
        this.zzJ = -1;
        this.zzK = null;
    }

    private final void zzaN(zzsy zzsyVar) {
        this.zzac = zzsyVar;
        if (zzsyVar.zzd != -9223372036854775807L) {
            this.zzae = true;
        }
    }

    private final void zzaO() throws zziz {
        zzrz zzrzVar = this.zzag;
        zzrzVar.getClass();
        this.zzaf = zzrzVar;
        this.zzS = 0;
        this.zzT = 0;
    }

    private final boolean zzaP() throws zziz {
        if (this.zzU) {
            this.zzS = 1;
            if (this.zzC) {
                this.zzT = 3;
                return false;
            }
            this.zzT = 2;
        } else {
            zzaO();
        }
        return true;
    }

    private final boolean zzaQ() throws zziz {
        zzsr zzsrVar = this.zzs;
        if (zzsrVar == null || this.zzS == 2 || this.zzZ) {
            return false;
        }
        if (this.zzI < 0) {
            int zza = zzsrVar.zza();
            this.zzI = zza;
            if (zza < 0) {
                return false;
            }
            this.zzg.zzc = zzsrVar.zzf(zza);
            this.zzg.zzb();
        }
        if (this.zzS == 1) {
            if (!this.zzG) {
                this.zzV = true;
                zzsrVar.zzj(this.zzI, 0, 0, 0L, 4);
                zzaL();
            }
            this.zzS = 2;
            return false;
        }
        if (this.zzE) {
            this.zzE = false;
            ByteBuffer byteBuffer = this.zzg.zzc;
            byteBuffer.getClass();
            byteBuffer.put(zzb);
            zzsrVar.zzj(this.zzI, 0, 38, 0L, 0);
            zzaL();
            this.zzU = true;
            return true;
        }
        if (this.zzR == 1) {
            int i = 0;
            while (true) {
                zzam zzamVar = this.zzt;
                zzamVar.getClass();
                if (i >= zzamVar.zzo.size()) {
                    break;
                }
                byte[] bArr = (byte[]) this.zzt.zzo.get(i);
                ByteBuffer byteBuffer2 = this.zzg.zzc;
                byteBuffer2.getClass();
                byteBuffer2.put(bArr);
                i++;
            }
            this.zzR = 2;
        }
        ByteBuffer byteBuffer3 = this.zzg.zzc;
        byteBuffer3.getClass();
        int position = byteBuffer3.position();
        zzlb zzbi = zzbi();
        try {
            int zzbg = zzbg(zzbi, this.zzg, 0);
            if (zzbg == -3) {
                if (zzP()) {
                    this.zzY = this.zzX;
                }
                return false;
            }
            if (zzbg == -5) {
                if (this.zzR == 2) {
                    this.zzg.zzb();
                    this.zzR = 1;
                }
                zzab(zzbi);
                return true;
            }
            zzih zzihVar = this.zzg;
            if (zzihVar.zzf()) {
                this.zzY = this.zzX;
                if (this.zzR == 2) {
                    zzihVar.zzb();
                    this.zzR = 1;
                }
                this.zzZ = true;
                if (!this.zzU) {
                    zzaK();
                    return false;
                }
                try {
                    if (!this.zzG) {
                        this.zzV = true;
                        zzsrVar.zzj(this.zzI, 0, 0, 0L, 4);
                        zzaL();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e) {
                    throw zzi(e, this.zzm, false, zzfy.zzi(e.getErrorCode()));
                }
            }
            if (this.zzU || zzihVar.zzg()) {
                boolean zzk = zzihVar.zzk();
                if (zzk) {
                    zzihVar.zzb.zzb(position);
                }
                long j = this.zzg.zze;
                if (this.zzab) {
                    if (!this.zzk.isEmpty()) {
                        zzfv zzfvVar = ((zzsy) this.zzk.peekLast()).zze;
                        zzam zzamVar2 = this.zzm;
                        zzamVar2.getClass();
                        zzfvVar.zzd(j, zzamVar2);
                    } else {
                        zzfv zzfvVar2 = this.zzac.zze;
                        zzam zzamVar3 = this.zzm;
                        zzamVar3.getClass();
                        zzfvVar2.zzd(j, zzamVar3);
                    }
                    this.zzab = false;
                }
                long max = Math.max(this.zzX, j);
                this.zzX = max;
                if (zzP() || this.zzg.zzh()) {
                    this.zzY = max;
                }
                this.zzg.zzj();
                zzih zzihVar2 = this.zzg;
                if (zzihVar2.zze()) {
                    zzah(zzihVar2);
                }
                zzaz(this.zzg);
                zzar(this.zzg);
                try {
                    if (zzk) {
                        zzsrVar.zzk(this.zzI, 0, this.zzg.zzb, j, 0);
                    } else {
                        int i2 = this.zzI;
                        ByteBuffer byteBuffer4 = this.zzg.zzc;
                        byteBuffer4.getClass();
                        zzsrVar.zzj(i2, 0, byteBuffer4.limit(), j, 0);
                    }
                    zzaL();
                    this.zzU = true;
                    this.zzR = 0;
                    this.zza.zzc++;
                    return true;
                } catch (MediaCodec.CryptoException e2) {
                    throw zzi(e2, this.zzm, false, zzfy.zzi(e2.getErrorCode()));
                }
            }
            zzihVar.zzb();
            if (this.zzR == 2) {
                this.zzR = 1;
            }
            return true;
        } catch (zzig e3) {
            zzai(e3);
            zzaT(0);
            zzag();
            return true;
        }
    }

    private final boolean zzaR() {
        return this.zzJ >= 0;
    }

    private final boolean zzaS(long j, long j2) {
        if (j2 >= j) {
            return false;
        }
        zzam zzamVar = this.zzn;
        if (zzamVar == null || !Objects.equals(zzamVar.zzm, "audio/opus")) {
            return true;
        }
        return !zzadq.zzf(j, j2);
    }

    private final boolean zzaT(int i) throws zziz {
        zzih zzihVar = this.zzf;
        zzlb zzbi = zzbi();
        zzihVar.zzb();
        int zzbg = zzbg(zzbi, this.zzf, i | 4);
        if (zzbg == -5) {
            zzab(zzbi);
            return true;
        }
        if (zzbg != -4 || !this.zzf.zzf()) {
            return false;
        }
        this.zzZ = true;
        zzaK();
        return false;
    }

    private final boolean zzaU(long j) {
        if (this.zzq == -9223372036854775807L) {
            return true;
        }
        zzh();
        return SystemClock.elapsedRealtime() - j < this.zzq;
    }

    private final boolean zzaV(zzam zzamVar) throws zziz {
        if (zzfy.zza >= 23 && this.zzs != null && this.zzT != 3 && zzbf() != 0) {
            float f = this.zzr;
            zzamVar.getClass();
            float zzY = zzY(f, zzamVar, zzS());
            float f2 = this.zzw;
            if (f2 != zzY) {
                if (zzY == -1.0f) {
                    zzad();
                    return false;
                }
                if (f2 != -1.0f || zzY > this.zze) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", zzY);
                    zzsr zzsrVar = this.zzs;
                    zzsrVar.getClass();
                    zzsrVar.zzp(bundle);
                    this.zzw = zzY;
                }
            }
        }
        return true;
    }

    private final void zzac() {
        this.zzP = false;
        this.zzi.zzb();
        this.zzh.zzb();
        this.zzO = false;
        this.zzN = false;
        this.zzl.zzb();
    }

    private final void zzad() throws zziz {
        if (this.zzU) {
            this.zzS = 1;
            this.zzT = 3;
        } else {
            zzaB();
            zzax();
        }
    }

    private final void zzag() {
        try {
            zzsr zzsrVar = this.zzs;
            zzek.zzb(zzsrVar);
            zzsrVar.zzi();
        } finally {
            zzaC();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zziq
    public void zzB() {
        try {
            zzac();
            zzaB();
        } finally {
            this.zzag = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        if (r5 >= r1) goto L14;
     */
    @Override // com.google.android.gms.internal.ads.zziq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void zzE(com.google.android.gms.internal.ads.zzam[] r13, long r14, long r16, com.google.android.gms.internal.ads.zzur r18) throws com.google.android.gms.internal.ads.zziz {
        /*
            r12 = this;
            r0 = r12
            com.google.android.gms.internal.ads.zzsy r1 = r0.zzac
            long r1 = r1.zzd
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L20
            com.google.android.gms.internal.ads.zzsy r1 = new com.google.android.gms.internal.ads.zzsy
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = r1
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.zzaN(r1)
            return
        L20:
            java.util.ArrayDeque r1 = r0.zzk
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L55
            long r1 = r0.zzX
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L38
            long r5 = r0.zzad
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 == 0) goto L55
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 < 0) goto L55
        L38:
            com.google.android.gms.internal.ads.zzsy r1 = new com.google.android.gms.internal.ads.zzsy
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = r1
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.zzaN(r1)
            com.google.android.gms.internal.ads.zzsy r1 = r0.zzac
            long r1 = r1.zzd
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L54
            r12.zzan()
        L54:
            return
        L55:
            java.util.ArrayDeque r1 = r0.zzk
            com.google.android.gms.internal.ads.zzsy r9 = new com.google.android.gms.internal.ads.zzsy
            long r3 = r0.zzX
            r2 = r9
            r5 = r14
            r7 = r16
            r2.<init>(r3, r5, r7)
            r1.add(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsz.zzE(com.google.android.gms.internal.ads.zzam[], long, long, com.google.android.gms.internal.ads.zzur):void");
    }

    @Override // com.google.android.gms.internal.ads.zziq, com.google.android.gms.internal.ads.zzmf
    public void zzL(float f, float f2) throws zziz {
        this.zzr = f2;
        zzaV(this.zzt);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    @Override // com.google.android.gms.internal.ads.zzmf
    public void zzU(long r24, long r26) throws com.google.android.gms.internal.ads.zziz {
        /*
            Method dump skipped, instructions count: 1073
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsz.zzU(long, long):void");
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public boolean zzV() {
        return this.zzaa;
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public boolean zzW() {
        if (this.zzm == null) {
            return false;
        }
        if (zzR() || zzaR()) {
            return true;
        }
        if (this.zzH == -9223372036854775807L) {
            return false;
        }
        zzh();
        return SystemClock.elapsedRealtime() < this.zzH;
    }

    @Override // com.google.android.gms.internal.ads.zzmh
    public final int zzX(zzam zzamVar) throws zziz {
        try {
            return zzZ(this.zzd, zzamVar);
        } catch (zzth e) {
            throw zzi(e, zzamVar, false, 4002);
        }
    }

    protected float zzY(float f, zzam zzamVar, zzam[] zzamVarArr) {
        throw null;
    }

    protected abstract int zzZ(zztb zztbVar, zzam zzamVar) throws zzth;

    protected void zzaA(zzam zzamVar) throws zziz {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zzaB() {
        try {
            zzsr zzsrVar = this.zzs;
            if (zzsrVar != null) {
                zzsrVar.zzl();
                this.zza.zzb++;
                zzsv zzsvVar = this.zzz;
                zzsvVar.getClass();
                zzak(zzsvVar.zza);
            }
        } finally {
            this.zzs = null;
            this.zzo = null;
            this.zzaf = null;
            zzaD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzaC() {
        zzaL();
        zzaM();
        this.zzH = -9223372036854775807L;
        this.zzV = false;
        this.zzU = false;
        this.zzE = false;
        this.zzF = false;
        this.zzL = false;
        this.zzM = false;
        this.zzX = -9223372036854775807L;
        this.zzY = -9223372036854775807L;
        this.zzad = -9223372036854775807L;
        this.zzS = 0;
        this.zzT = 0;
        this.zzR = this.zzQ ? 1 : 0;
    }

    protected final void zzaD() {
        zzaC();
        this.zzx = null;
        this.zzz = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = false;
        this.zzW = false;
        this.zzw = -1.0f;
        this.zzA = 0;
        this.zzB = false;
        this.zzC = false;
        this.zzD = false;
        this.zzG = false;
        this.zzQ = false;
        this.zzR = 0;
        this.zzp = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzaE() throws zziz {
        boolean zzaF = zzaF();
        if (zzaF) {
            zzax();
        }
        return zzaF;
    }

    protected final boolean zzaF() {
        if (this.zzs == null) {
            return false;
        }
        int i = this.zzT;
        if (i != 3 && ((!this.zzB || this.zzW) && (!this.zzC || !this.zzV))) {
            if (i == 2) {
                zzek.zzf(zzfy.zza >= 23);
                if (zzfy.zza >= 23) {
                    try {
                        zzaO();
                    } catch (zziz e) {
                        zzff.zzg("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
                        zzaB();
                        return true;
                    }
                }
            }
            zzag();
            return false;
        }
        zzaB();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzaG() {
        return this.zzN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzaH(zzam zzamVar) {
        return this.zzag == null && zzaq(zzamVar);
    }

    protected boolean zzaI(zzsv zzsvVar) {
        return true;
    }

    protected zzis zzaa(zzsv zzsvVar, zzam zzamVar, zzam zzamVar2) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0068, code lost:
    
        if (zzaP() == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0094, code lost:
    
        if (zzaP() == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a7, code lost:
    
        if (zzaP() == false) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.gms.internal.ads.zzis zzab(com.google.android.gms.internal.ads.zzlb r12) throws com.google.android.gms.internal.ads.zziz {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsz.zzab(com.google.android.gms.internal.ads.zzlb):com.google.android.gms.internal.ads.zzis");
    }

    protected abstract zzsp zzae(zzsv zzsvVar, zzam zzamVar, MediaCrypto mediaCrypto, float f);

    protected abstract List zzaf(zztb zztbVar, zzam zzamVar, boolean z) throws zzth;

    protected void zzah(zzih zzihVar) throws zziz {
        throw null;
    }

    protected void zzai(Exception exc) {
        throw null;
    }

    protected void zzaj(String str, zzsp zzspVar, long j, long j2) {
        throw null;
    }

    protected void zzak(String str) {
        throw null;
    }

    protected void zzal(zzam zzamVar, MediaFormat mediaFormat) throws zziz {
        throw null;
    }

    protected void zzan() {
    }

    protected void zzao() throws zziz {
    }

    protected abstract boolean zzap(long j, long j2, zzsr zzsrVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzam zzamVar) throws zziz;

    protected boolean zzaq(zzam zzamVar) {
        return false;
    }

    protected int zzar(zzih zzihVar) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long zzas() {
        return this.zzac.zzd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long zzat() {
        return this.zzac.zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzsr zzau() {
        return this.zzs;
    }

    protected zzst zzav(Throwable th, zzsv zzsvVar) {
        return new zzst(th, zzsvVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzsv zzaw() {
        return this.zzz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00eb A[Catch: zzsx -> 0x010a, TryCatch #3 {zzsx -> 0x010a, blocks: (B:25:0x005a, B:27:0x005f, B:76:0x0064, B:78:0x007a, B:79:0x0085, B:30:0x0092, B:32:0x009a, B:34:0x009f, B:35:0x00a5, B:37:0x00a9, B:39:0x00b2, B:53:0x00d1, B:55:0x00eb, B:56:0x00f4, B:61:0x00fb, B:62:0x00fd, B:63:0x00ee, B:71:0x00fe, B:73:0x0101, B:74:0x0109, B:82:0x0089, B:83:0x0091, B:50:0x00c1, B:65:0x00cf, B:42:0x00b8), top: B:24:0x005a, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ee A[Catch: zzsx -> 0x010a, TryCatch #3 {zzsx -> 0x010a, blocks: (B:25:0x005a, B:27:0x005f, B:76:0x0064, B:78:0x007a, B:79:0x0085, B:30:0x0092, B:32:0x009a, B:34:0x009f, B:35:0x00a5, B:37:0x00a9, B:39:0x00b2, B:53:0x00d1, B:55:0x00eb, B:56:0x00f4, B:61:0x00fb, B:62:0x00fd, B:63:0x00ee, B:71:0x00fe, B:73:0x0101, B:74:0x0109, B:82:0x0089, B:83:0x0091, B:50:0x00c1, B:65:0x00cf, B:42:0x00b8), top: B:24:0x005a, inners: #0, #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzax() throws com.google.android.gms.internal.ads.zziz {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsz.zzax():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzay(long j) {
        this.zzad = j;
        while (!this.zzk.isEmpty() && j >= ((zzsy) this.zzk.peek()).zzb) {
            zzsy zzsyVar = (zzsy) this.zzk.poll();
            zzsyVar.getClass();
            zzaN(zzsyVar);
            zzan();
        }
    }

    protected void zzaz(zzih zzihVar) throws zziz {
    }

    @Override // com.google.android.gms.internal.ads.zziq, com.google.android.gms.internal.ads.zzmh
    public final int zze() {
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zziq
    public void zzw() {
        this.zzm = null;
        zzaN(zzsy.zza);
        this.zzk.clear();
        zzaF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zziq
    public void zzx(boolean z, boolean z2) throws zziz {
        this.zza = new zzir();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zziq
    public void zzz(long j, boolean z) throws zziz {
        this.zzZ = false;
        this.zzaa = false;
        if (this.zzN) {
            this.zzi.zzb();
            this.zzh.zzb();
            this.zzO = false;
            this.zzl.zzb();
        } else {
            zzaE();
        }
        zzfv zzfvVar = this.zzac.zze;
        if (zzfvVar.zza() > 0) {
            this.zzab = true;
        }
        zzfvVar.zze();
        this.zzk.clear();
    }

    private final void zzaK() throws zziz {
        int i = this.zzT;
        if (i == 1) {
            zzag();
            return;
        }
        if (i == 2) {
            zzag();
            zzaO();
        } else if (i == 3) {
            zzaB();
            zzax();
        } else {
            this.zzaa = true;
            zzao();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzam(zzsv zzsvVar, MediaCrypto mediaCrypto) throws Exception {
        MediaCodec createByCodecName;
        zzsr zztpVar;
        long j;
        zzsp zzspVar;
        int i;
        int i2;
        long j2;
        zzam zzamVar = this.zzm;
        zzamVar.getClass();
        String str = zzsvVar.zza;
        float zzY = zzfy.zza < 23 ? -1.0f : zzY(this.zzr, zzamVar, zzS());
        if (zzY <= this.zze) {
            zzY = -1.0f;
        }
        zzaA(zzamVar);
        zzh();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        MediaCodec mediaCodec = null;
        zzsp zzae = zzae(zzsvVar, zzamVar, null, zzY);
        if (zzfy.zza >= 31) {
            zzsw.zza(zzae, zzn());
        }
        try {
            Trace.beginSection("createCodec:" + str);
            if (zzfy.zza >= 23 && zzfy.zza >= 31) {
                int zzb2 = zzcb.zzb(zzae.zzc.zzm);
                zzff.zze("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type ".concat(zzfy.zzB(zzb2)));
                zzse zzseVar = new zzse(zzb2);
                zzseVar.zzd(true);
                zztpVar = zzseVar.zzc(zzae);
            } else {
                try {
                    String str2 = zzae.zza.zza;
                    Trace.beginSection("createCodec:".concat(str2));
                    createByCodecName = MediaCodec.createByCodecName(str2);
                    Trace.endSection();
                } catch (IOException e) {
                    e = e;
                } catch (RuntimeException e2) {
                    e = e2;
                }
                try {
                    Trace.beginSection("configureCodec");
                    createByCodecName.configure(zzae.zzb, zzae.zzd, (MediaCrypto) null, 0);
                    Trace.endSection();
                    Trace.beginSection("startCodec");
                    createByCodecName.start();
                    Trace.endSection();
                    zztpVar = new zztp(createByCodecName, null);
                } catch (IOException | RuntimeException e3) {
                    e = e3;
                    mediaCodec = createByCodecName;
                    if (mediaCodec != null) {
                        mediaCodec.release();
                    }
                    throw e;
                }
            }
            this.zzs = zztpVar;
            Trace.endSection();
            zzh();
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            if (zzsvVar.zze(zzamVar)) {
                j = elapsedRealtime;
                zzspVar = zzae;
                i = 0;
            } else {
                Object[] objArr = new Object[2];
                StringBuilder sb = new StringBuilder();
                sb.append("id=");
                sb.append(zzamVar.zzb);
                sb.append(", mimeType=");
                sb.append(zzamVar.zzm);
                if (zzamVar.zzl != null) {
                    sb.append(", container=");
                    sb.append(zzamVar.zzl);
                }
                if (zzamVar.zzi != -1) {
                    sb.append(", bitrate=");
                    sb.append(zzamVar.zzi);
                }
                if (zzamVar.zzj != null) {
                    sb.append(", codecs=");
                    sb.append(zzamVar.zzj);
                }
                if (zzamVar.zzp != null) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    int i3 = 0;
                    while (true) {
                        zzae zzaeVar = zzamVar.zzp;
                        zzspVar = zzae;
                        if (i3 >= zzaeVar.zzb) {
                            break;
                        }
                        UUID uuid = zzaeVar.zza(i3).zza;
                        if (uuid.equals(zzo.zzb)) {
                            linkedHashSet.add("cenc");
                        } else if (uuid.equals(zzo.zzc)) {
                            linkedHashSet.add("clearkey");
                        } else if (uuid.equals(zzo.zze)) {
                            linkedHashSet.add("playready");
                        } else if (uuid.equals(zzo.zzd)) {
                            linkedHashSet.add("widevine");
                        } else if (uuid.equals(zzo.zza)) {
                            linkedHashSet.add("universal");
                        } else {
                            j2 = elapsedRealtime;
                            linkedHashSet.add("unknown (" + uuid.toString() + ")");
                            i3++;
                            zzae = zzspVar;
                            elapsedRealtime = j2;
                        }
                        j2 = elapsedRealtime;
                        i3++;
                        zzae = zzspVar;
                        elapsedRealtime = j2;
                    }
                    j = elapsedRealtime;
                    sb.append(", drm=[");
                    zzfwt.zzb(sb, linkedHashSet, ",");
                    sb.append(']');
                } else {
                    j = elapsedRealtime;
                    zzspVar = zzae;
                }
                if (zzamVar.zzr != -1 && zzamVar.zzs != -1) {
                    sb.append(", res=");
                    sb.append(zzamVar.zzr);
                    sb.append("x");
                    sb.append(zzamVar.zzs);
                }
                zzt zztVar = zzamVar.zzy;
                if (zztVar != null && (zztVar.zze() || zztVar.zzf())) {
                    sb.append(", color=");
                    sb.append(zzamVar.zzy.zzd());
                }
                if (zzamVar.zzt != -1.0f) {
                    sb.append(", fps=");
                    sb.append(zzamVar.zzt);
                }
                if (zzamVar.zzz != -1) {
                    sb.append(", channels=");
                    sb.append(zzamVar.zzz);
                }
                if (zzamVar.zzA != -1) {
                    sb.append(", sample_rate=");
                    sb.append(zzamVar.zzA);
                }
                if (zzamVar.zzd != null) {
                    sb.append(", language=");
                    sb.append(zzamVar.zzd);
                }
                if (zzamVar.zzc != null) {
                    sb.append(", label=");
                    sb.append(zzamVar.zzc);
                }
                if (zzamVar.zze != 0) {
                    sb.append(", selectionFlags=[");
                    int i4 = zzamVar.zze;
                    ArrayList arrayList = new ArrayList();
                    if ((i4 & 1) != 0) {
                        arrayList.add("default");
                    }
                    if ((i4 & 2) != 0) {
                        arrayList.add("forced");
                    }
                    zzfwt.zzb(sb, arrayList, ",");
                    sb.append("]");
                }
                if (zzamVar.zzf != 0) {
                    sb.append(", roleFlags=[");
                    int i5 = zzamVar.zzf;
                    ArrayList arrayList2 = new ArrayList();
                    if ((i5 & 1) != 0) {
                        arrayList2.add("main");
                    }
                    if ((i5 & 2) != 0) {
                        arrayList2.add("alt");
                    }
                    if ((i5 & 4) != 0) {
                        arrayList2.add("supplementary");
                    }
                    if ((i5 & 8) != 0) {
                        arrayList2.add("commentary");
                    }
                    if ((i5 & 16) != 0) {
                        arrayList2.add("dub");
                    }
                    if ((i5 & 32) != 0) {
                        arrayList2.add("emergency");
                    }
                    if ((i5 & 64) != 0) {
                        arrayList2.add("caption");
                    }
                    if ((i5 & 128) != 0) {
                        arrayList2.add("subtitle");
                    }
                    if ((i5 & 256) != 0) {
                        arrayList2.add("sign");
                    }
                    if ((i5 & 512) != 0) {
                        arrayList2.add("describes-video");
                    }
                    if ((i5 & 1024) != 0) {
                        arrayList2.add("describes-music");
                    }
                    if ((i5 & 2048) != 0) {
                        arrayList2.add("enhanced-intelligibility");
                    }
                    if ((i5 & 4096) != 0) {
                        arrayList2.add("transcribes-dialog");
                    }
                    if ((i5 & 8192) != 0) {
                        arrayList2.add("easy-read");
                    }
                    if ((i5 & 16384) != 0) {
                        arrayList2.add("trick-play");
                    }
                    zzfwt.zzb(sb, arrayList2, ",");
                    sb.append("]");
                }
                i = 0;
                objArr[0] = sb.toString();
                objArr[1] = str;
                zzff.zzf("MediaCodecRenderer", String.format(Locale.US, "Format exceeds selected codec's capabilities [%s, %s]", objArr));
            }
            this.zzz = zzsvVar;
            this.zzw = zzY;
            this.zzt = zzamVar;
            if (zzfy.zza <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (zzfy.zzd.startsWith("SM-T585") || zzfy.zzd.startsWith("SM-A510") || zzfy.zzd.startsWith("SM-A520") || zzfy.zzd.startsWith("SM-J700"))) {
                i2 = 2;
            } else {
                i2 = (zzfy.zza >= 24 || !(("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) && ("flounder".equals(zzfy.zzb) || "flounder_lte".equals(zzfy.zzb) || "grouper".equals(zzfy.zzb) || "tilapia".equals(zzfy.zzb)))) ? i : 1;
            }
            this.zzA = i2;
            this.zzt.getClass();
            this.zzB = (zzfy.zza == 29 && "c2.android.aac.decoder".equals(str)) ? 1 : i;
            this.zzC = (zzfy.zza > 23 || !"OMX.google.vorbis.decoder".equals(str)) ? i : 1;
            this.zzD = (zzfy.zza == 21 && "OMX.google.aac.decoder".equals(str)) ? 1 : i;
            this.zzt.getClass();
            String str3 = zzsvVar.zza;
            this.zzG = ((zzfy.zza > 25 || !"OMX.rk.video_decoder.avc".equals(str3)) && (zzfy.zza > 29 || !("OMX.broadcom.video_decoder.tunnel".equals(str3) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str3) || "OMX.bcm.vdec.avc.tunnel".equals(str3) || "OMX.bcm.vdec.avc.tunnel.secure".equals(str3) || "OMX.bcm.vdec.hevc.tunnel".equals(str3) || "OMX.bcm.vdec.hevc.tunnel.secure".equals(str3))) && !("Amazon".equals(zzfy.zzc) && "AFTS".equals(zzfy.zzd) && zzsvVar.zzf)) ? i : 1;
            this.zzs.getClass();
            if (zzbf() == 2) {
                zzh();
                this.zzH = SystemClock.elapsedRealtime() + 1000;
            }
            this.zza.zza++;
            zzaj(str, zzspVar, elapsedRealtime2, elapsedRealtime2 - j);
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }
}
