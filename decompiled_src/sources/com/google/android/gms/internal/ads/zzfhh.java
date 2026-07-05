package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfhh {
    public final com.google.android.gms.ads.internal.client.zzfk zza;
    public final zzbpp zzb;
    public final zzeqe zzc;
    public final com.google.android.gms.ads.internal.client.zzl zzd;
    public final com.google.android.gms.ads.internal.client.zzq zze;
    public final String zzf;
    public final ArrayList zzg;
    public final ArrayList zzh;
    public final zzbjb zzi;
    public final com.google.android.gms.ads.internal.client.zzw zzj;
    public final int zzk;
    public final AdManagerAdViewOptions zzl;
    public final PublisherAdViewOptions zzm;
    public final com.google.android.gms.ads.internal.client.zzcb zzn;
    public final zzfgu zzo;
    public final boolean zzp;
    public final boolean zzq;
    public final com.google.android.gms.ads.internal.client.zzcf zzr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfhh(zzfhf zzfhfVar, zzfhg zzfhgVar) {
        com.google.android.gms.ads.internal.client.zzfk zzfkVar;
        zzbjb zzbjbVar;
        this.zze = zzfhf.zzf(zzfhfVar);
        this.zzf = zzfhf.zzH(zzfhfVar);
        this.zzr = zzfhf.zzP(zzfhfVar);
        int i = zzfhf.zzd(zzfhfVar).zza;
        long j = zzfhf.zzd(zzfhfVar).zzb;
        Bundle bundle = zzfhf.zzd(zzfhfVar).zzc;
        int i2 = zzfhf.zzd(zzfhfVar).zzd;
        List list = zzfhf.zzd(zzfhfVar).zze;
        boolean z = zzfhf.zzd(zzfhfVar).zzf;
        int i3 = zzfhf.zzd(zzfhfVar).zzg;
        boolean z2 = true;
        if (!zzfhf.zzd(zzfhfVar).zzh && !zzfhf.zzN(zzfhfVar)) {
            z2 = false;
        }
        this.zzd = new com.google.android.gms.ads.internal.client.zzl(i, j, bundle, i2, list, z, i3, z2, zzfhf.zzd(zzfhfVar).zzi, zzfhf.zzd(zzfhfVar).zzj, zzfhf.zzd(zzfhfVar).zzk, zzfhf.zzd(zzfhfVar).zzl, zzfhf.zzd(zzfhfVar).zzm, zzfhf.zzd(zzfhfVar).zzn, zzfhf.zzd(zzfhfVar).zzo, zzfhf.zzd(zzfhfVar).zzp, zzfhf.zzd(zzfhfVar).zzq, zzfhf.zzd(zzfhfVar).zzr, zzfhf.zzd(zzfhfVar).zzs, zzfhf.zzd(zzfhfVar).zzt, zzfhf.zzd(zzfhfVar).zzu, zzfhf.zzd(zzfhfVar).zzv, com.google.android.gms.ads.internal.util.zzt.zza(zzfhf.zzd(zzfhfVar).zzw), zzfhf.zzd(zzfhfVar).zzx, zzfhf.zzd(zzfhfVar).zzy);
        if (zzfhf.zzj(zzfhfVar) != null) {
            zzfkVar = zzfhf.zzj(zzfhfVar);
        } else {
            zzfkVar = zzfhf.zzk(zzfhfVar) != null ? zzfhf.zzk(zzfhfVar).zzf : null;
        }
        this.zza = zzfkVar;
        this.zzg = zzfhf.zzJ(zzfhfVar);
        this.zzh = zzfhf.zzK(zzfhfVar);
        if (zzfhf.zzJ(zzfhfVar) == null) {
            zzbjbVar = null;
        } else {
            zzbjbVar = zzfhf.zzk(zzfhfVar) == null ? new zzbjb(new NativeAdOptions.Builder().build()) : zzfhf.zzk(zzfhfVar);
        }
        this.zzi = zzbjbVar;
        this.zzj = zzfhf.zzh(zzfhfVar);
        this.zzk = zzfhf.zza(zzfhfVar);
        this.zzl = zzfhf.zzb(zzfhfVar);
        this.zzm = zzfhf.zzc(zzfhfVar);
        this.zzn = zzfhf.zzi(zzfhfVar);
        this.zzb = zzfhf.zzl(zzfhfVar);
        this.zzo = new zzfgu(zzfhf.zzn(zzfhfVar), null);
        this.zzp = zzfhf.zzL(zzfhfVar);
        this.zzc = zzfhf.zzm(zzfhfVar);
        this.zzq = zzfhf.zzM(zzfhfVar);
    }

    public final zzbld zza() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzm;
        if (publisherAdViewOptions == null && this.zzl == null) {
            return null;
        }
        if (publisherAdViewOptions != null) {
            return publisherAdViewOptions.zzb();
        }
        return this.zzl.zza();
    }

    public final boolean zzb() {
        return this.zzf.matches((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcW));
    }
}
