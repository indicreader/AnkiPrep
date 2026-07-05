package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.SparseArray;
import androidx.compose.animation.core.AnimationKt;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzahy implements zzacu {
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzahu
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i = zzada.zza;
            zzadb zzadbVar = zzahy.zza;
            return new zzacu[]{new zzahy(0)};
        }
    };
    private static final byte[] zzb = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzc;
    private static final byte[] zzd;
    private static final byte[] zze;
    private static final UUID zzf;
    private static final Map zzg;
    private long zzA;
    private zzahx zzB;
    private boolean zzC;
    private int zzD;
    private long zzE;
    private boolean zzF;
    private long zzG;
    private long zzH;
    private long zzI;
    private zzfg zzJ;
    private zzfg zzK;
    private boolean zzL;
    private boolean zzM;
    private int zzN;
    private long zzO;
    private long zzP;
    private int zzQ;
    private int zzR;
    private int[] zzS;
    private int zzT;
    private int zzU;
    private int zzV;
    private int zzW;
    private boolean zzX;
    private long zzY;
    private int zzZ;
    private int zzaa;
    private int zzab;
    private boolean zzac;
    private boolean zzad;
    private boolean zzae;
    private int zzaf;
    private byte zzag;
    private boolean zzah;
    private zzacx zzai;
    private final zzaht zzh;
    private final zzaia zzi;
    private final SparseArray zzj;
    private final boolean zzk;
    private final zzfp zzl;
    private final zzfp zzm;
    private final zzfp zzn;
    private final zzfp zzo;
    private final zzfp zzp;
    private final zzfp zzq;
    private final zzfp zzr;
    private final zzfp zzs;
    private final zzfp zzt;
    private final zzfp zzu;
    private ByteBuffer zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        int i = zzfy.zza;
        zzc = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(zzfwq.zzc);
        zzd = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        zze = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        zzf = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        zzg = Collections.unmodifiableMap(hashMap);
    }

    public zzahy() {
        this(0);
    }

    @RequiresNonNull({"#2.output"})
    private final int zzn(zzacv zzacvVar, zzahx zzahxVar, int i, boolean z) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(zzahxVar.zzb)) {
            zzv(zzacvVar, zzb, i);
            int i3 = this.zzaa;
            zzu();
            return i3;
        }
        if ("S_TEXT/ASS".equals(zzahxVar.zzb)) {
            zzv(zzacvVar, zzd, i);
            int i4 = this.zzaa;
            zzu();
            return i4;
        }
        if ("S_TEXT/WEBVTT".equals(zzahxVar.zzb)) {
            zzv(zzacvVar, zze, i);
            int i5 = this.zzaa;
            zzu();
            return i5;
        }
        zzaea zzaeaVar = zzahxVar.zzW;
        if (!this.zzac) {
            if (zzahxVar.zzg) {
                this.zzV &= -1073741825;
                if (!this.zzad) {
                    ((zzack) zzacvVar).zzn(this.zzn.zzM(), 0, 1, false);
                    this.zzZ++;
                    if ((this.zzn.zzM()[0] & 128) == 128) {
                        throw zzcc.zza("Extension bit is set in signal byte", null);
                    }
                    this.zzag = this.zzn.zzM()[0];
                    this.zzad = true;
                }
                byte b = this.zzag;
                if ((b & 1) == 1) {
                    int i6 = b & 2;
                    this.zzV |= 1073741824;
                    if (!this.zzah) {
                        ((zzack) zzacvVar).zzn(this.zzs.zzM(), 0, 8, false);
                        this.zzZ += 8;
                        this.zzah = true;
                        this.zzn.zzM()[0] = (byte) ((i6 != 2 ? 0 : 128) | 8);
                        this.zzn.zzK(0);
                        zzaeaVar.zzs(this.zzn, 1, 1);
                        this.zzaa++;
                        this.zzs.zzK(0);
                        zzaeaVar.zzs(this.zzs, 8, 1);
                        this.zzaa += 8;
                    }
                    if (i6 == 2) {
                        if (!this.zzae) {
                            ((zzack) zzacvVar).zzn(this.zzn.zzM(), 0, 1, false);
                            this.zzZ++;
                            this.zzn.zzK(0);
                            this.zzaf = this.zzn.zzm();
                            this.zzae = true;
                        }
                        int i7 = this.zzaf * 4;
                        this.zzn.zzH(i7);
                        ((zzack) zzacvVar).zzn(this.zzn.zzM(), 0, i7, false);
                        this.zzZ += i7;
                        int i8 = (this.zzaf >> 1) + 1;
                        int i9 = (i8 * 6) + 2;
                        ByteBuffer byteBuffer = this.zzv;
                        if (byteBuffer == null || byteBuffer.capacity() < i9) {
                            this.zzv = ByteBuffer.allocate(i9);
                        }
                        this.zzv.position(0);
                        this.zzv.putShort((short) i8);
                        int i10 = 0;
                        int i11 = 0;
                        while (true) {
                            i2 = this.zzaf;
                            if (i10 >= i2) {
                                break;
                            }
                            int zzp = this.zzn.zzp();
                            int i12 = zzp - i11;
                            if (i10 % 2 == 0) {
                                this.zzv.putShort((short) i12);
                            } else {
                                this.zzv.putInt(i12);
                            }
                            i10++;
                            i11 = zzp;
                        }
                        int i13 = (i - this.zzZ) - i11;
                        if ((i2 & 1) == 1) {
                            this.zzv.putInt(i13);
                        } else {
                            this.zzv.putShort((short) i13);
                            this.zzv.putInt(0);
                        }
                        this.zzt.zzI(this.zzv.array(), i9);
                        zzaeaVar.zzs(this.zzt, i9, 1);
                        this.zzaa += i9;
                    }
                }
            } else {
                byte[] bArr = zzahxVar.zzh;
                if (bArr != null) {
                    this.zzq.zzI(bArr, bArr.length);
                }
            }
            if (!"A_OPUS".equals(zzahxVar.zzb) ? zzahxVar.zzf > 0 : z) {
                this.zzV |= 268435456;
                this.zzu.zzH(0);
                int zze2 = (this.zzq.zze() + i) - this.zzZ;
                this.zzn.zzH(4);
                this.zzn.zzM()[0] = (byte) ((zze2 >> 24) & 255);
                this.zzn.zzM()[1] = (byte) ((zze2 >> 16) & 255);
                this.zzn.zzM()[2] = (byte) ((zze2 >> 8) & 255);
                this.zzn.zzM()[3] = (byte) (zze2 & 255);
                zzaeaVar.zzs(this.zzn, 4, 2);
                this.zzaa += 4;
            }
            this.zzac = true;
        }
        int zze3 = i + this.zzq.zze();
        if ("V_MPEG4/ISO/AVC".equals(zzahxVar.zzb) || "V_MPEGH/ISO/HEVC".equals(zzahxVar.zzb)) {
            byte[] zzM = this.zzm.zzM();
            zzM[0] = 0;
            zzM[1] = 0;
            zzM[2] = 0;
            int i14 = zzahxVar.zzX;
            int i15 = 4 - i14;
            while (this.zzZ < zze3) {
                int i16 = this.zzab;
                if (i16 == 0) {
                    int min = Math.min(i14, this.zzq.zzb());
                    ((zzack) zzacvVar).zzn(zzM, i15 + min, i14 - min, false);
                    if (min > 0) {
                        this.zzq.zzG(zzM, i15, min);
                    }
                    this.zzZ += i14;
                    this.zzm.zzK(0);
                    this.zzab = this.zzm.zzp();
                    this.zzl.zzK(0);
                    zzady.zzb(zzaeaVar, this.zzl, 4);
                    this.zzaa += 4;
                } else {
                    int zzo = zzo(zzacvVar, zzaeaVar, i16);
                    this.zzZ += zzo;
                    this.zzaa += zzo;
                    this.zzab -= zzo;
                }
            }
        } else {
            if (zzahxVar.zzT != null) {
                zzek.zzf(this.zzq.zze() == 0);
                zzahxVar.zzT.zzd(zzacvVar);
            }
            while (true) {
                int i17 = this.zzZ;
                if (i17 >= zze3) {
                    break;
                }
                int zzo2 = zzo(zzacvVar, zzaeaVar, zze3 - i17);
                this.zzZ += zzo2;
                this.zzaa += zzo2;
            }
        }
        if ("A_VORBIS".equals(zzahxVar.zzb)) {
            this.zzo.zzK(0);
            zzady.zzb(zzaeaVar, this.zzo, 4);
            this.zzaa += 4;
        }
        int i18 = this.zzaa;
        zzu();
        return i18;
    }

    private final int zzo(zzacv zzacvVar, zzaea zzaeaVar, int i) throws IOException {
        int zzb2 = this.zzq.zzb();
        if (zzb2 <= 0) {
            return zzady.zza(zzaeaVar, zzacvVar, i, false);
        }
        int min = Math.min(i, zzb2);
        zzady.zzb(zzaeaVar, this.zzq, min);
        return min;
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    private final void zzq(int i) throws zzcc {
        if (this.zzJ == null || this.zzK == null) {
            throw zzcc.zza("Element " + i + " must be in a Cues", null);
        }
    }

    @EnsuresNonNull({"currentTrack"})
    private final void zzr(int i) throws zzcc {
        if (this.zzB != null) {
            return;
        }
        throw zzcc.zza("Element " + i + " must be in a TrackEntry", null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e0 A[EDGE_INSN: B:50:0x00e0->B:49:0x00e0 BREAK  A[LOOP:0: B:42:0x00c5->B:46:0x00dd], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b3  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"#1.output"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzs(com.google.android.gms.internal.ads.zzahx r18, long r19, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahy.zzs(com.google.android.gms.internal.ads.zzahx, long, int, int, int):void");
    }

    private final void zzt(zzacv zzacvVar, int i) throws IOException {
        if (this.zzn.zze() >= i) {
            return;
        }
        if (this.zzn.zzc() < i) {
            zzfp zzfpVar = this.zzn;
            int zzc2 = zzfpVar.zzc();
            zzfpVar.zzE(Math.max(zzc2 + zzc2, i));
        }
        zzfp zzfpVar2 = this.zzn;
        ((zzack) zzacvVar).zzn(zzfpVar2.zzM(), zzfpVar2.zze(), i - zzfpVar2.zze(), false);
        this.zzn.zzJ(i);
    }

    private final void zzu() {
        this.zzZ = 0;
        this.zzaa = 0;
        this.zzab = 0;
        this.zzac = false;
        this.zzad = false;
        this.zzae = false;
        this.zzaf = 0;
        this.zzag = (byte) 0;
        this.zzah = false;
        this.zzq.zzH(0);
    }

    private final void zzv(zzacv zzacvVar, byte[] bArr, int i) throws IOException {
        int length = bArr.length;
        int i2 = length + i;
        if (this.zzr.zzc() < i2) {
            zzfp zzfpVar = this.zzr;
            byte[] copyOf = Arrays.copyOf(bArr, i2 + i);
            zzfpVar.zzI(copyOf, copyOf.length);
        } else {
            System.arraycopy(bArr, 0, this.zzr.zzM(), 0, length);
        }
        ((zzack) zzacvVar).zzn(this.zzr.zzM(), length, i, false);
        this.zzr.zzK(0);
        this.zzr.zzJ(i2);
    }

    private static byte[] zzw(long j, String str, long j2) {
        zzek.zzd(j != -9223372036854775807L);
        Locale locale = Locale.US;
        int i = (int) (j / 3600000000L);
        Integer valueOf = Integer.valueOf(i);
        long j3 = j - (i * 3600000000L);
        int i2 = (int) (j3 / 60000000);
        Integer valueOf2 = Integer.valueOf(i2);
        long j4 = j3 - (i2 * 60000000);
        int i3 = (int) (j4 / AnimationKt.MillisToNanos);
        String format = String.format(locale, str, valueOf, valueOf2, Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (i3 * AnimationKt.MillisToNanos)) / j2)));
        int i4 = zzfy.zza;
        return format.getBytes(zzfwq.zzc);
    }

    private static int[] zzx(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        return length >= i ? iArr : new int[Math.max(length + length, i)];
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        this.zzM = false;
        while (!this.zzM) {
            if (!this.zzh.zzc(zzacvVar)) {
                for (int i = 0; i < this.zzj.size(); i++) {
                    zzahx zzahxVar = (zzahx) this.zzj.valueAt(i);
                    zzahx.zzd(zzahxVar);
                    zzaeb zzaebVar = zzahxVar.zzT;
                    if (zzaebVar != null) {
                        zzaebVar.zza(zzahxVar.zzW, zzahxVar.zzi);
                    }
                }
                return -1;
            }
            long zzf2 = zzacvVar.zzf();
            if (this.zzF) {
                this.zzH = zzf2;
                zzadrVar.zza = this.zzG;
                this.zzF = false;
                return 1;
            }
            if (this.zzC) {
                long j = this.zzH;
                if (j != -1) {
                    zzadrVar.zza = j;
                    this.zzH = -1L;
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzai = zzacxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j, long j2) {
        this.zzI = -9223372036854775807L;
        this.zzN = 0;
        this.zzh.zzb();
        this.zzi.zze();
        zzu();
        for (int i = 0; i < this.zzj.size(); i++) {
            zzaeb zzaebVar = ((zzahx) this.zzj.valueAt(i)).zzT;
            if (zzaebVar != null) {
                zzaebVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        return new zzahz().zza(zzacvVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01e6, code lost:
    
        if (r5.equals("V_MPEGH/ISO/HEVC") != false) goto L188;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzh(int r22) throws com.google.android.gms.internal.ads.zzcc {
        /*
            Method dump skipped, instructions count: 1146
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahy.zzh(int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzk(int i, long j, long j2) throws zzcc {
        zzek.zzb(this.zzai);
        if (i == 160) {
            this.zzX = false;
            this.zzY = 0L;
            return;
        }
        if (i == 174) {
            this.zzB = new zzahx();
            return;
        }
        if (i == 187) {
            this.zzL = false;
            return;
        }
        if (i == 19899) {
            this.zzD = -1;
            this.zzE = -1L;
            return;
        }
        if (i == 20533) {
            zzr(i);
            this.zzB.zzg = true;
            return;
        }
        if (i == 21968) {
            zzr(i);
            this.zzB.zzx = true;
            return;
        }
        if (i == 408125543) {
            long j3 = this.zzx;
            if (j3 != -1 && j3 != j) {
                throw zzcc.zza("Multiple Segment elements not supported", null);
            }
            this.zzx = j;
            this.zzw = j2;
            return;
        }
        if (i == 475249515) {
            this.zzJ = new zzfg(32);
            this.zzK = new zzfg(32);
        } else if (i == 524531317 && !this.zzC) {
            if (this.zzk && this.zzG != -1) {
                this.zzF = true;
            } else {
                this.zzai.zzO(new zzadt(this.zzA, 0L));
                this.zzC = true;
            }
        }
    }

    public zzahy(int i) {
        zzahr zzahrVar = new zzahr();
        this.zzx = -1L;
        this.zzy = -9223372036854775807L;
        this.zzz = -9223372036854775807L;
        this.zzA = -9223372036854775807L;
        this.zzG = -1L;
        this.zzH = -1L;
        this.zzI = -9223372036854775807L;
        this.zzh = zzahrVar;
        zzahrVar.zza(new zzahw(this, null));
        this.zzk = true;
        this.zzi = new zzaia();
        this.zzj = new SparseArray();
        this.zzn = new zzfp(4);
        this.zzo = new zzfp(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzp = new zzfp(4);
        this.zzl = new zzfp(zzgm.zza);
        this.zzm = new zzfp(4);
        this.zzq = new zzfp();
        this.zzr = new zzfp();
        this.zzs = new zzfp(8);
        this.zzt = new zzfp();
        this.zzu = new zzfp();
        this.zzS = new int[1];
    }

    private final long zzp(long j) throws zzcc {
        long j2 = this.zzy;
        if (j2 == -9223372036854775807L) {
            throw zzcc.zza("Can't scale timecode prior to timecodeScale being set.", null);
        }
        return zzfy.zzs(j, j2, 1000L, RoundingMode.FLOOR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzl(int i, String str) throws zzcc {
        if (i == 134) {
            zzr(i);
            this.zzB.zzb = str;
            return;
        }
        if (i == 17026) {
            if ("webm".equals(str) || "matroska".equals(str)) {
                return;
            }
            throw zzcc.zza("DocType " + str + " not supported", null);
        }
        if (i == 21358) {
            zzr(i);
            this.zzB.zza = str;
        } else {
            if (i != 2274716) {
                return;
            }
            zzr(i);
            zzahx.zzc(this.zzB, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x028d, code lost:
    
        throw com.google.android.gms.internal.ads.zzcc.zza("EBML lacing sample size out of range.", null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzg(int r22, int r23, com.google.android.gms.internal.ads.zzacv r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 823
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahy.zzg(int, int, com.google.android.gms.internal.ads.zzacv):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzj(int i, long j) throws zzcc {
        boolean z;
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            throw zzcc.zza("ContentEncodingOrder " + j + " not supported", null);
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            throw zzcc.zza("ContentEncodingScope " + j + " not supported", null);
        }
        switch (i) {
            case 131:
                zzr(i);
                this.zzB.zzd = (int) j;
                return;
            case 136:
                z = j == 1;
                zzr(i);
                this.zzB.zzV = z;
                return;
            case 155:
                this.zzP = zzp(j);
                return;
            case 159:
                zzr(i);
                this.zzB.zzO = (int) j;
                return;
            case 176:
                zzr(i);
                this.zzB.zzl = (int) j;
                return;
            case 179:
                zzq(i);
                this.zzJ.zzc(zzp(j));
                return;
            case 186:
                zzr(i);
                this.zzB.zzm = (int) j;
                return;
            case 215:
                zzr(i);
                this.zzB.zzc = (int) j;
                return;
            case 231:
                this.zzI = zzp(j);
                return;
            case 238:
                this.zzW = (int) j;
                return;
            case 241:
                if (this.zzL) {
                    return;
                }
                zzq(i);
                this.zzK.zzc(j);
                this.zzL = true;
                return;
            case 251:
                this.zzX = true;
                return;
            case 16871:
                zzr(i);
                zzahx.zzb(this.zzB, (int) j);
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                throw zzcc.zza("ContentCompAlgo " + j + " not supported", null);
            case 17029:
                if (j < 1 || j > 2) {
                    throw zzcc.zza("DocTypeReadVersion " + j + " not supported", null);
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                throw zzcc.zza("EBMLReadVersion " + j + " not supported", null);
            case 18401:
                if (j == 5) {
                    return;
                }
                throw zzcc.zza("ContentEncAlgo " + j + " not supported", null);
            case 18408:
                if (j == 1) {
                    return;
                }
                throw zzcc.zza("AESSettingsCipherMode " + j + " not supported", null);
            case 21420:
                this.zzE = j + this.zzx;
                return;
            case 21432:
                int i2 = (int) j;
                zzr(i);
                if (i2 == 0) {
                    this.zzB.zzw = 0;
                    return;
                }
                if (i2 == 1) {
                    this.zzB.zzw = 2;
                    return;
                } else if (i2 == 3) {
                    this.zzB.zzw = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.zzB.zzw = 3;
                    return;
                }
            case 21680:
                zzr(i);
                this.zzB.zzo = (int) j;
                return;
            case 21682:
                zzr(i);
                this.zzB.zzq = (int) j;
                return;
            case 21690:
                zzr(i);
                this.zzB.zzp = (int) j;
                return;
            case 21930:
                z = j == 1;
                zzr(i);
                this.zzB.zzU = z;
                return;
            case 21938:
                zzr(i);
                zzahx zzahxVar = this.zzB;
                zzahxVar.zzx = true;
                zzahxVar.zzn = (int) j;
                return;
            case 21998:
                zzr(i);
                this.zzB.zzf = (int) j;
                return;
            case 22186:
                zzr(i);
                this.zzB.zzR = j;
                return;
            case 22203:
                zzr(i);
                this.zzB.zzS = j;
                return;
            case 25188:
                zzr(i);
                this.zzB.zzP = (int) j;
                return;
            case 30114:
                this.zzY = j;
                return;
            case 30321:
                int i3 = (int) j;
                zzr(i);
                if (i3 == 0) {
                    this.zzB.zzr = 0;
                    return;
                }
                if (i3 == 1) {
                    this.zzB.zzr = 1;
                    return;
                } else if (i3 == 2) {
                    this.zzB.zzr = 2;
                    return;
                } else {
                    if (i3 != 3) {
                        return;
                    }
                    this.zzB.zzr = 3;
                    return;
                }
            case 2352003:
                zzr(i);
                this.zzB.zze = (int) j;
                return;
            case 2807729:
                this.zzy = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        int i4 = (int) j;
                        zzr(i);
                        if (i4 == 1) {
                            this.zzB.zzA = 2;
                            return;
                        } else {
                            if (i4 != 2) {
                                return;
                            }
                            this.zzB.zzA = 1;
                            return;
                        }
                    case 21946:
                        zzr(i);
                        int zzb2 = zzt.zzb((int) j);
                        if (zzb2 != -1) {
                            this.zzB.zzz = zzb2;
                            return;
                        }
                        return;
                    case 21947:
                        zzr(i);
                        this.zzB.zzx = true;
                        int zza2 = zzt.zza((int) j);
                        if (zza2 != -1) {
                            this.zzB.zzy = zza2;
                            return;
                        }
                        return;
                    case 21948:
                        zzr(i);
                        this.zzB.zzB = (int) j;
                        return;
                    case 21949:
                        zzr(i);
                        this.zzB.zzC = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzi(int i, double d) throws zzcc {
        if (i == 181) {
            zzr(i);
            this.zzB.zzQ = (int) d;
            return;
        }
        if (i == 17545) {
            this.zzz = (long) d;
            return;
        }
        switch (i) {
            case 21969:
                zzr(i);
                this.zzB.zzD = (float) d;
                return;
            case 21970:
                zzr(i);
                this.zzB.zzE = (float) d;
                return;
            case 21971:
                zzr(i);
                this.zzB.zzF = (float) d;
                return;
            case 21972:
                zzr(i);
                this.zzB.zzG = (float) d;
                return;
            case 21973:
                zzr(i);
                this.zzB.zzH = (float) d;
                return;
            case 21974:
                zzr(i);
                this.zzB.zzI = (float) d;
                return;
            case 21975:
                zzr(i);
                this.zzB.zzJ = (float) d;
                return;
            case 21976:
                zzr(i);
                this.zzB.zzK = (float) d;
                return;
            case 21977:
                zzr(i);
                this.zzB.zzL = (float) d;
                return;
            case 21978:
                zzr(i);
                this.zzB.zzM = (float) d;
                return;
            default:
                switch (i) {
                    case 30323:
                        zzr(i);
                        this.zzB.zzs = (float) d;
                        return;
                    case 30324:
                        zzr(i);
                        this.zzB.zzt = (float) d;
                        return;
                    case 30325:
                        zzr(i);
                        this.zzB.zzu = (float) d;
                        return;
                    default:
                        return;
                }
        }
    }
}
