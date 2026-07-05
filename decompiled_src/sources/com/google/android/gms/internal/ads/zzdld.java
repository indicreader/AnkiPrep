package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzdld implements zzcwk {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final zzhhu zzd;
    private final zzdnl zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdld(Map map, Map map2, Map map3, zzhhu zzhhuVar, zzdnl zzdnlVar) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = map3;
        this.zzd = zzhhuVar;
        this.zze = zzdnlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcwk
    public final zzein zza(int i, String str) {
        zzein zza;
        zzein zzeinVar = (zzein) this.zza.get(str);
        if (zzeinVar != null) {
            return zzeinVar;
        }
        if (i != 1) {
            if (i != 4) {
                return null;
            }
            zzelb zzelbVar = (zzelb) this.zzc.get(str);
            if (zzelbVar != null) {
                return new zzeio(zzelbVar, new zzfws() { // from class: com.google.android.gms.internal.ads.zzcwm
                    @Override // com.google.android.gms.internal.ads.zzfws
                    public final Object apply(Object obj) {
                        return new zzcwp((List) obj);
                    }
                });
            }
            zza = (zzein) this.zzb.get(str);
            if (zza == null) {
                return null;
            }
        } else if (this.zze.zze() == null || (zza = ((zzcwk) this.zzd.zzb()).zza(i, str)) == null) {
            return null;
        }
        return new zzeio(zza, new zzfws() { // from class: com.google.android.gms.internal.ads.zzcwn
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                return new zzcwp((zzcwh) obj);
            }
        });
    }
}
