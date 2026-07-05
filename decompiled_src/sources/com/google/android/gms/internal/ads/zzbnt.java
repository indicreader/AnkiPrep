package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbnt implements zzbnu {
    final /* synthetic */ zzceu zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbnt(zzbnv zzbnvVar, zzceu zzceuVar) {
        this.zza = zzceuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnu
    public final void zza(String str) {
        this.zza.zzd(new zzbrm(str));
    }

    @Override // com.google.android.gms.internal.ads.zzbnu
    public final void zzb(JSONObject jSONObject) {
        this.zza.zzc(jSONObject);
    }
}
