package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhaw implements zzhbz {
    private static final zzhbc zza = new zzhau();
    private final zzhbc zzb;

    public zzhaw() {
        zzhbc zzhbcVar;
        zzhbc[] zzhbcVarArr = new zzhbc[2];
        zzhbcVarArr[0] = zzgzo.zza();
        try {
            zzhbcVar = (zzhbc) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzhbcVar = zza;
        }
        zzhbcVarArr[1] = zzhbcVar;
        zzhav zzhavVar = new zzhav(zzhbcVarArr);
        byte[] bArr = zzhae.zzd;
        this.zzb = zzhavVar;
    }

    private static boolean zzb(zzhbb zzhbbVar) {
        return zzhbbVar.zzc() + (-1) != 1;
    }

    @Override // com.google.android.gms.internal.ads.zzhbz
    public final zzhby zza(Class cls) {
        zzhca.zzr(cls);
        zzhbb zzb = this.zzb.zzb(cls);
        if (!zzb.zzb()) {
            if (zzgzu.class.isAssignableFrom(cls)) {
                if (zzb(zzb)) {
                    return zzhbh.zzl(cls, zzb, zzhbk.zzb(), zzhas.zze(), zzhca.zzn(), zzgzi.zzb(), zzhba.zzb());
                }
                return zzhbh.zzl(cls, zzb, zzhbk.zzb(), zzhas.zze(), zzhca.zzn(), null, zzhba.zzb());
            }
            if (zzb(zzb)) {
                return zzhbh.zzl(cls, zzb, zzhbk.zza(), zzhas.zzd(), zzhca.zzm(), zzgzi.zza(), zzhba.zza());
            }
            return zzhbh.zzl(cls, zzb, zzhbk.zza(), zzhas.zzd(), zzhca.zzm(), null, zzhba.zza());
        }
        if (zzgzu.class.isAssignableFrom(cls)) {
            return zzhbi.zzc(zzhca.zzn(), zzgzi.zzb(), zzb.zza());
        }
        return zzhbi.zzc(zzhca.zzm(), zzgzi.zza(), zzb.zza());
    }
}
