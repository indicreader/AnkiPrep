package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdrg implements zzbja {
    final /* synthetic */ String zza = NativeCustomFormatAd.ASSET_NAME_VIDEO;
    final /* synthetic */ zzdrh zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdrg(zzdrh zzdrhVar, String str) {
        this.zzb = zzdrhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbja
    public final JSONObject zza() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbja
    public final JSONObject zzb() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbja
    public final void zzc() {
        zzdmv zzdmvVar;
        zzdmv zzdmvVar2;
        zzdrh zzdrhVar = this.zzb;
        zzdmvVar = zzdrhVar.zzd;
        if (zzdmvVar != null) {
            String str = this.zza;
            zzdmvVar2 = zzdrhVar.zzd;
            zzdmvVar2.zzE(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbja
    public final void zzd(MotionEvent motionEvent) {
    }
}
