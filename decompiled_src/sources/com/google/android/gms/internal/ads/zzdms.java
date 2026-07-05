package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdms implements zzayq {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdmv zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdms(zzdmv zzdmvVar, String str) {
        this.zza = str;
        this.zzb = zzdmvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzayq
    public final void zzby(zzayp zzaypVar) {
        Map map;
        zzdow zzdowVar;
        zzdow zzdowVar2;
        zzdow zzdowVar3;
        zzdow zzdowVar4;
        Map map2;
        zzdow zzdowVar5;
        zzdow zzdowVar6;
        zzdow zzdowVar7;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbJ)).booleanValue()) {
            if (zzaypVar.zzj) {
                zzdmv zzdmvVar = this.zzb;
                String str = this.zza;
                map = zzdmvVar.zzy;
                map.put(str, true);
                zzdmv zzdmvVar2 = this.zzb;
                zzdowVar = zzdmvVar2.zzo;
                View zzf = zzdowVar.zzf();
                zzdowVar2 = this.zzb.zzo;
                Map zzl = zzdowVar2.zzl();
                zzdowVar3 = this.zzb.zzo;
                zzdmvVar2.zzA(zzf, zzl, zzdowVar3.zzm(), true);
                return;
            }
            return;
        }
        synchronized (this) {
            if (zzaypVar.zzj) {
                zzdmv zzdmvVar3 = this.zzb;
                zzdowVar4 = zzdmvVar3.zzo;
                if (zzdowVar4 == null) {
                    return;
                }
                map2 = zzdmvVar3.zzy;
                map2.put(this.zza, true);
                zzdmv zzdmvVar4 = this.zzb;
                zzdowVar5 = zzdmvVar4.zzo;
                View zzf2 = zzdowVar5.zzf();
                zzdowVar6 = this.zzb.zzo;
                Map zzl2 = zzdowVar6.zzl();
                zzdowVar7 = this.zzb.zzo;
                zzdmvVar4.zzA(zzf2, zzl2, zzdowVar7.zzm(), true);
            }
        }
    }
}
