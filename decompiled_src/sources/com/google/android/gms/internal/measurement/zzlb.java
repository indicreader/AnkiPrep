package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
/* loaded from: classes3.dex */
public final class zzlb implements zzlv {
    private static final zzlh zza = new zzkz();
    private final zzlh zzb;

    public zzlb() {
        zzlh zzlhVar;
        zzlh[] zzlhVarArr = new zzlh[2];
        zzlhVarArr[0] = zzjx.zza();
        try {
            zzlhVar = (zzlh) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzlhVar = zza;
        }
        zzlhVarArr[1] = zzlhVar;
        zzla zzlaVar = new zzla(zzlhVarArr);
        zzkk.zzf(zzlaVar, "messageInfoFactory");
        this.zzb = zzlaVar;
    }

    private static boolean zzb(zzlg zzlgVar) {
        return zzlgVar.zzc() == 1;
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final zzlu zza(Class cls) {
        zzlw.zzG(cls);
        zzlg zzb = this.zzb.zzb(cls);
        if (!zzb.zzb()) {
            if (zzkc.class.isAssignableFrom(cls)) {
                if (zzb(zzb)) {
                    return zzlm.zzl(cls, zzb, zzlp.zzb(), zzkx.zzd(), zzlw.zzB(), zzjr.zzb(), zzlf.zzb());
                }
                return zzlm.zzl(cls, zzb, zzlp.zzb(), zzkx.zzd(), zzlw.zzB(), null, zzlf.zzb());
            }
            if (zzb(zzb)) {
                return zzlm.zzl(cls, zzb, zzlp.zza(), zzkx.zzc(), zzlw.zzz(), zzjr.zza(), zzlf.zza());
            }
            return zzlm.zzl(cls, zzb, zzlp.zza(), zzkx.zzc(), zzlw.zzA(), null, zzlf.zza());
        }
        if (zzkc.class.isAssignableFrom(cls)) {
            return zzln.zzc(zzlw.zzB(), zzjr.zzb(), zzb.zza());
        }
        return zzln.zzc(zzlw.zzz(), zzjr.zza(), zzb.zza());
    }
}
