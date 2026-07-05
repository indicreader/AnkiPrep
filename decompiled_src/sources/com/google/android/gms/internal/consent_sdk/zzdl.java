package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.2.0 */
/* loaded from: classes3.dex */
public final class zzdl implements zzdn {
    private zzdq zza;

    public static void zzb(zzdq zzdqVar, zzdq zzdqVar2) {
        zzdl zzdlVar = (zzdl) zzdqVar;
        if (zzdlVar.zza != null) {
            throw new IllegalStateException();
        }
        zzdlVar.zza = zzdqVar2;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdr
    public final Object zza() {
        zzdq zzdqVar = this.zza;
        if (zzdqVar == null) {
            throw new IllegalStateException();
        }
        return zzdqVar.zza();
    }
}
