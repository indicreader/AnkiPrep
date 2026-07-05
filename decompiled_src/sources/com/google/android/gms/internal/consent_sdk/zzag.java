package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.ump:user-messaging-platform@@2.2.0 */
/* loaded from: classes3.dex */
public final class zzag extends zza {
    private final zzag zza = this;
    private final zzdq zzb;
    private final zzdq zzc;
    private final zzdq zzd;
    private final zzdq zze;
    private final zzdq zzf;
    private final zzdq zzg;
    private final zzdq zzh;
    private final zzdq zzi;
    private final zzdq zzj;
    private final zzdq zzk;
    private final zzdq zzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzag(Application application, zzaf zzafVar) {
        zzad zzadVar;
        zzau zzauVar;
        zzau zzauVar2;
        zzau zzauVar3;
        zzas zzasVar;
        zzau zzauVar4;
        zzdn zzb = zzdo.zzb(application);
        this.zzb = zzb;
        zzdq zzb2 = zzdm.zzb(new zzaq(zzb));
        this.zzc = zzb2;
        zzadVar = zzac.zza;
        zzdq zzb3 = zzdm.zzb(zzadVar);
        this.zzd = zzb3;
        zzae zzaeVar = new zzae(this);
        this.zze = zzaeVar;
        zzauVar = zzat.zza;
        zzdq zzb4 = zzdm.zzb(new zzbo(zzaeVar, zzauVar));
        this.zzf = zzb4;
        zzo zzoVar = new zzo(zzb, zzb2);
        this.zzg = zzoVar;
        zzauVar2 = zzat.zza;
        zzdq zzb5 = zzdm.zzb(new zzf(zzauVar2));
        this.zzh = zzb5;
        zzauVar3 = zzat.zza;
        zzao zzaoVar = new zzao(zzb, zzb2, zzauVar3);
        this.zzi = zzaoVar;
        zzaa zzaaVar = new zzaa(zzb5, zzaoVar, zzb2);
        this.zzj = zzaaVar;
        zzasVar = zzar.zza;
        zzauVar4 = zzat.zza;
        zzv zzvVar = new zzv(zzb, zzb3, zzasVar, zzauVar4, zzb2, zzb4, zzoVar, zzaaVar, zzb5);
        this.zzk = zzvVar;
        this.zzl = zzdm.zzb(new zzk(zzb2, zzvVar, zzb4));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zza
    public final zzj zzb() {
        return (zzj) this.zzl.zza();
    }

    @Override // com.google.android.gms.internal.consent_sdk.zza
    public final zzbn zzc() {
        return (zzbn) this.zzf.zza();
    }
}
