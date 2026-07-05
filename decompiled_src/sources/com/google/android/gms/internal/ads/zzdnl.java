package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdnl {
    public static final zzdnl zza = new zzdnl(new zzdnj());
    private final zzbkn zzb;
    private final zzbkk zzc;
    private final zzbla zzd;
    private final zzbkx zze;
    private final zzbpy zzf;
    private final SimpleArrayMap zzg;
    private final SimpleArrayMap zzh;

    private zzdnl(zzdnj zzdnjVar) {
        this.zzb = zzdnjVar.zza;
        this.zzc = zzdnjVar.zzb;
        this.zzd = zzdnjVar.zzc;
        this.zzg = new SimpleArrayMap(zzdnjVar.zzf);
        this.zzh = new SimpleArrayMap(zzdnjVar.zzg);
        this.zze = zzdnjVar.zzd;
        this.zzf = zzdnjVar.zze;
    }

    public final zzbkk zza() {
        return this.zzc;
    }

    public final zzbkn zzb() {
        return this.zzb;
    }

    public final zzbkq zzc(String str) {
        return (zzbkq) this.zzh.get(str);
    }

    public final zzbkt zzd(String str) {
        return (zzbkt) this.zzg.get(str);
    }

    public final zzbkx zze() {
        return this.zze;
    }

    public final zzbla zzf() {
        return this.zzd;
    }

    public final zzbpy zzg() {
        return this.zzf;
    }

    public final ArrayList zzh() {
        ArrayList arrayList = new ArrayList(this.zzg.getSize());
        for (int i = 0; i < this.zzg.getSize(); i++) {
            arrayList.add((String) this.zzg.keyAt(i));
        }
        return arrayList;
    }

    public final ArrayList zzi() {
        ArrayList arrayList = new ArrayList();
        if (this.zzd != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzb != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzc != null) {
            arrayList.add(Integer.toString(2));
        }
        if (!this.zzg.isEmpty()) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzf != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }
}
