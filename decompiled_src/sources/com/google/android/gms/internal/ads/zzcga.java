package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcga {
    private final Context zza;
    private final zzcgl zzb;
    private final ViewGroup zzc;
    private zzcfz zzd;

    public zzcga(Context context, ViewGroup viewGroup, zzcjk zzcjkVar) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = viewGroup;
        this.zzb = zzcjkVar;
        this.zzd = null;
    }

    public final zzcfz zza() {
        return this.zzd;
    }

    public final Integer zzb() {
        zzcfz zzcfzVar = this.zzd;
        if (zzcfzVar != null) {
            return zzcfzVar.zzl();
        }
        return null;
    }

    public final void zzc(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzcfz zzcfzVar = this.zzd;
        if (zzcfzVar != null) {
            zzcfzVar.zzF(i, i2, i3, i4);
        }
    }

    public final void zzd(int i, int i2, int i3, int i4, int i5, boolean z, zzcgk zzcgkVar) {
        if (this.zzd != null) {
            return;
        }
        zzbgm.zza(this.zzb.zzm().zza(), this.zzb.zzk(), "vpr2");
        Context context = this.zza;
        zzcgl zzcglVar = this.zzb;
        zzcfz zzcfzVar = new zzcfz(context, zzcglVar, i5, z, zzcglVar.zzm().zza(), zzcgkVar);
        this.zzd = zzcfzVar;
        this.zzc.addView(zzcfzVar, 0, new ViewGroup.LayoutParams(-1, -1));
        this.zzd.zzF(i, i2, i3, i4);
        this.zzb.zzz(false);
    }

    public final void zze() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzcfz zzcfzVar = this.zzd;
        if (zzcfzVar != null) {
            zzcfzVar.zzo();
            this.zzc.removeView(this.zzd);
            this.zzd = null;
        }
    }

    public final void zzf() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzcfz zzcfzVar = this.zzd;
        if (zzcfzVar != null) {
            zzcfzVar.zzu();
        }
    }

    public final void zzg(int i) {
        zzcfz zzcfzVar = this.zzd;
        if (zzcfzVar != null) {
            zzcfzVar.zzC(i);
        }
    }
}
