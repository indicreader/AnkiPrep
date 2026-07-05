package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public class zzdg {
    private static final String zzF;
    private static final String zzG;
    private static final String zzH;
    private static final String zzI;
    private static final String zzJ;
    private static final String zzK;
    private static final String zzL;
    private static final String zzM;
    private static final String zzN;
    private static final String zzO;
    private static final String zzP;
    private static final String zzQ;
    private static final String zzR;
    private static final String zzS;
    private static final String zzT;
    private static final String zzU;
    private static final String zzV;
    private static final String zzW;
    private static final String zzX;
    private static final String zzY;
    private static final String zzZ;
    public static final zzdg zza;
    private static final String zzaa;
    private static final String zzab;
    private static final String zzac;
    private static final String zzad;
    private static final String zzae;
    private static final String zzaf;
    private static final String zzag;
    private static final String zzah;
    private static final String zzai;
    private static final String zzaj;

    @Deprecated
    public static final zzdg zzb;

    @Deprecated
    public static final zzn zzc;
    public final boolean zzA;
    public final boolean zzB;
    public final boolean zzC;
    public final zzgad zzD;
    public final zzgaf zzE;
    public final int zzd = Integer.MAX_VALUE;
    public final int zze = Integer.MAX_VALUE;
    public final int zzf = Integer.MAX_VALUE;
    public final int zzg = Integer.MAX_VALUE;
    public final int zzh = 0;
    public final int zzi = 0;
    public final int zzj = 0;
    public final int zzk = 0;
    public final int zzl;
    public final int zzm;
    public final boolean zzn;
    public final zzgaa zzo;
    public final int zzp;
    public final zzgaa zzq;
    public final int zzr;
    public final int zzs;
    public final int zzt;
    public final zzgaa zzu;
    public final zzde zzv;
    public final zzgaa zzw;
    public final int zzx;
    public final int zzy;
    public final boolean zzz;

    static {
        zzdg zzdgVar = new zzdg(new zzdf());
        zza = zzdgVar;
        zzb = zzdgVar;
        zzF = Integer.toString(1, 36);
        zzG = Integer.toString(2, 36);
        zzH = Integer.toString(3, 36);
        zzI = Integer.toString(4, 36);
        zzJ = Integer.toString(5, 36);
        zzK = Integer.toString(6, 36);
        zzL = Integer.toString(7, 36);
        zzM = Integer.toString(8, 36);
        zzN = Integer.toString(9, 36);
        zzO = Integer.toString(10, 36);
        zzP = Integer.toString(11, 36);
        zzQ = Integer.toString(12, 36);
        zzR = Integer.toString(13, 36);
        zzS = Integer.toString(14, 36);
        zzT = Integer.toString(15, 36);
        zzU = Integer.toString(16, 36);
        zzV = Integer.toString(17, 36);
        zzW = Integer.toString(18, 36);
        zzX = Integer.toString(19, 36);
        zzY = Integer.toString(20, 36);
        zzZ = Integer.toString(21, 36);
        zzaa = Integer.toString(22, 36);
        zzab = Integer.toString(23, 36);
        zzac = Integer.toString(24, 36);
        zzad = Integer.toString(25, 36);
        zzae = Integer.toString(26, 36);
        zzaf = Integer.toString(27, 36);
        zzag = Integer.toString(28, 36);
        zzah = Integer.toString(29, 36);
        zzai = Integer.toString(30, 36);
        zzaj = Integer.toString(31, 36);
        zzc = new zzn() { // from class: com.google.android.gms.internal.ads.zzdc
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzdg(zzdf zzdfVar) {
        int i;
        int i2;
        boolean z;
        zzgaa zzgaaVar;
        zzgaa zzgaaVar2;
        zzgaa zzgaaVar3;
        zzde zzdeVar;
        zzgaa zzgaaVar4;
        int i3;
        HashMap hashMap;
        HashSet hashSet;
        i = zzdfVar.zze;
        this.zzl = i;
        i2 = zzdfVar.zzf;
        this.zzm = i2;
        z = zzdfVar.zzg;
        this.zzn = z;
        zzgaaVar = zzdfVar.zzh;
        this.zzo = zzgaaVar;
        this.zzp = 0;
        zzgaaVar2 = zzdfVar.zzi;
        this.zzq = zzgaaVar2;
        this.zzr = 0;
        this.zzs = Integer.MAX_VALUE;
        this.zzt = Integer.MAX_VALUE;
        zzgaaVar3 = zzdfVar.zzl;
        this.zzu = zzgaaVar3;
        zzdeVar = zzdfVar.zzm;
        this.zzv = zzdeVar;
        zzgaaVar4 = zzdfVar.zzn;
        this.zzw = zzgaaVar4;
        i3 = zzdfVar.zzo;
        this.zzx = i3;
        this.zzy = 0;
        this.zzz = false;
        this.zzA = false;
        this.zzB = false;
        this.zzC = false;
        hashMap = zzdfVar.zzp;
        this.zzD = zzgad.zzc(hashMap);
        hashSet = zzdfVar.zzq;
        this.zzE = zzgaf.zzl(hashSet);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzdg zzdgVar = (zzdg) obj;
            if (this.zzn == zzdgVar.zzn && this.zzl == zzdgVar.zzl && this.zzm == zzdgVar.zzm && this.zzo.equals(zzdgVar.zzo) && this.zzq.equals(zzdgVar.zzq) && this.zzu.equals(zzdgVar.zzu) && this.zzv.equals(zzdgVar.zzv) && this.zzw.equals(zzdgVar.zzw) && this.zzx == zzdgVar.zzx && this.zzD.equals(zzdgVar.zzD) && this.zzE.equals(zzdgVar.zzE)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.zzn ? 1 : 0) - 1048002209) * 31) + this.zzl) * 31) + this.zzm) * 31) + this.zzo.hashCode()) * 961) + this.zzq.hashCode()) * 961) + Integer.MAX_VALUE) * 31) + Integer.MAX_VALUE) * 31) + this.zzu.hashCode()) * 31) + 29791) * 31) + this.zzw.hashCode()) * 31) + this.zzx) * 887503681) + this.zzD.hashCode()) * 31) + this.zzE.hashCode();
    }
}
