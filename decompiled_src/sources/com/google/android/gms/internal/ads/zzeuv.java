package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.ViewGroup;
import android.view.Window;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeuv implements zzexq {
    private final zzgey zza;
    private final ViewGroup zzb;
    private final Context zzc;
    private final Set zzd;

    public zzeuv(zzgey zzgeyVar, ViewGroup viewGroup, Context context, Set set) {
        this.zza = zzgeyVar;
        this.zzd = set;
        this.zzb = viewGroup;
        this.zzc = context;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 22;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeuu
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeuv.this.zzc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzeuw zzc() throws Exception {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfT)).booleanValue() || this.zzb == null || !this.zzd.contains("banner")) {
            Boolean bool = null;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfU)).booleanValue() && this.zzd.contains("native")) {
                Context context = this.zzc;
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    Window window = activity.getWindow();
                    boolean z = true;
                    if (window == null || (window.getAttributes().flags & 16777216) == 0) {
                        try {
                            if ((activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).flags & 512) == 0) {
                                z = false;
                            }
                            bool = Boolean.valueOf(z);
                        } catch (PackageManager.NameNotFoundException unused) {
                        }
                    } else {
                        bool = true;
                    }
                    return new zzeuw(bool);
                }
            }
            return new zzeuw(null);
        }
        return new zzeuw(Boolean.valueOf(this.zzb.isHardwareAccelerated()));
    }
}
