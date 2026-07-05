package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public class zzcum {
    private final zzcwf zza;
    private final View zzb;
    private final zzfgn zzc;
    private final zzcjk zzd;

    public zzcum(View view, zzcjk zzcjkVar, zzcwf zzcwfVar, zzfgn zzfgnVar) {
        this.zzb = view;
        this.zzd = zzcjkVar;
        this.zza = zzcwfVar;
        this.zzc = zzfgnVar;
    }

    public static final zzdim zzf(final Context context, final zzcei zzceiVar, final zzfgm zzfgmVar, final zzfhh zzfhhVar) {
        return new zzdim(new zzdcl() { // from class: com.google.android.gms.internal.ads.zzcuk
            @Override // com.google.android.gms.internal.ads.zzdcl
            public final void zzr() {
                com.google.android.gms.ads.internal.zzt.zzs().zzn(context, zzceiVar.zza, zzfgmVar.zzD.toString(), zzfhhVar.zzf);
            }
        }, zzcep.zzf);
    }

    public static final Set zzg(zzcvw zzcvwVar) {
        return Collections.singleton(new zzdim(zzcvwVar, zzcep.zzf));
    }

    public static final zzdim zzh(zzcvu zzcvuVar) {
        return new zzdim(zzcvuVar, zzcep.zze);
    }

    public final View zza() {
        return this.zzb;
    }

    public final zzcjk zzb() {
        return this.zzd;
    }

    public final zzcwf zzc() {
        return this.zza;
    }

    public zzdcj zzd(Set set) {
        return new zzdcj(set);
    }

    public final zzfgn zze() {
        return this.zzc;
    }
}
