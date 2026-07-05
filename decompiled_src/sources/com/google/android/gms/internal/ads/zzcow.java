package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzcow implements zzfgf {
    private final zzcnc zza;
    private Context zzb;
    private String zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcow(zzcnc zzcncVar, zzcov zzcovVar) {
        this.zza = zzcncVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfgf
    public final /* synthetic */ zzfgf zza(String str) {
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfgf
    public final /* synthetic */ zzfgf zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfgf
    public final zzfgg zzc() {
        zzhhl.zzc(this.zzb, Context.class);
        return new zzcoy(this.zza, this.zzb, this.zzc, null);
    }
}
