package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzlx {
    private final zzpb zza;
    private final zzlw zze;
    private final zzmp zzh;
    private final zzew zzi;
    private boolean zzj;
    private zzhy zzk;
    private zzwk zzl = new zzwk(0);
    private final IdentityHashMap zzc = new IdentityHashMap();
    private final Map zzd = new HashMap();
    private final List zzb = new ArrayList();
    private final HashMap zzf = new HashMap();
    private final Set zzg = new HashSet();

    public zzlx(zzlw zzlwVar, zzmp zzmpVar, zzew zzewVar, zzpb zzpbVar) {
        this.zza = zzpbVar;
        this.zze = zzlwVar;
        this.zzh = zzmpVar;
        this.zzi = zzewVar;
    }

    private final void zzr(int i, int i2) {
        while (i < this.zzb.size()) {
            ((zzlv) this.zzb.get(i)).zzd += i2;
            i++;
        }
    }

    private final void zzs(zzlv zzlvVar) {
        zzlu zzluVar = (zzlu) this.zzf.get(zzlvVar);
        if (zzluVar != null) {
            zzluVar.zza.zzi(zzluVar.zzb);
        }
    }

    private final void zzt() {
        Iterator it = this.zzg.iterator();
        while (it.hasNext()) {
            zzlv zzlvVar = (zzlv) it.next();
            if (zzlvVar.zzc.isEmpty()) {
                zzs(zzlvVar);
                it.remove();
            }
        }
    }

    private final void zzu(zzlv zzlvVar) {
        if (zzlvVar.zze && zzlvVar.zzc.isEmpty()) {
            zzlu zzluVar = (zzlu) this.zzf.remove(zzlvVar);
            zzluVar.getClass();
            zzluVar.zza.zzp(zzluVar.zzb);
            zzluVar.zza.zzs(zzluVar.zzc);
            zzluVar.zza.zzr(zzluVar.zzc);
            this.zzg.remove(zzlvVar);
        }
    }

    private final void zzv(zzlv zzlvVar) {
        zzum zzumVar = zzlvVar.zza;
        zzus zzusVar = new zzus() { // from class: com.google.android.gms.internal.ads.zzln
            @Override // com.google.android.gms.internal.ads.zzus
            public final void zza(zzut zzutVar, zzcx zzcxVar) {
                zzlx.this.zzf(zzutVar, zzcxVar);
            }
        };
        zzlt zzltVar = new zzlt(this, zzlvVar);
        this.zzf.put(zzlvVar, new zzlu(zzumVar, zzusVar, zzltVar));
        zzumVar.zzh(new Handler(zzfy.zzx(), null), zzltVar);
        zzumVar.zzg(new Handler(zzfy.zzx(), null), zzltVar);
        zzumVar.zzm(zzusVar, this.zzk, this.zza);
    }

    private final void zzw(int i, int i2) {
        while (true) {
            i2--;
            if (i2 < i) {
                return;
            }
            zzlv zzlvVar = (zzlv) this.zzb.remove(i2);
            this.zzd.remove(zzlvVar.zzb);
            zzr(i2, -zzlvVar.zza.zzC().zzc());
            zzlvVar.zze = true;
            if (this.zzj) {
                zzu(zzlvVar);
            }
        }
    }

    public final int zza() {
        return this.zzb.size();
    }

    public final zzcx zzb() {
        if (!this.zzb.isEmpty()) {
            int i = 0;
            for (int i2 = 0; i2 < this.zzb.size(); i2++) {
                zzlv zzlvVar = (zzlv) this.zzb.get(i2);
                zzlvVar.zzd = i;
                i += zzlvVar.zza.zzC().zzc();
            }
            return new zzmd(this.zzb, this.zzl);
        }
        return zzcx.zza;
    }

    public final zzcx zzc(int i, int i2, List list) {
        zzek.zzd(i >= 0 && i <= i2 && i2 <= zza());
        zzek.zzd(list.size() == i2 - i);
        for (int i3 = i; i3 < i2; i3++) {
            ((zzlv) this.zzb.get(i3)).zza.zzt((zzbp) list.get(i3 - i));
        }
        return zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzut zzutVar, zzcx zzcxVar) {
        this.zze.zzh();
    }

    public final void zzg(zzhy zzhyVar) {
        zzek.zzf(!this.zzj);
        this.zzk = zzhyVar;
        for (int i = 0; i < this.zzb.size(); i++) {
            zzlv zzlvVar = (zzlv) this.zzb.get(i);
            zzv(zzlvVar);
            this.zzg.add(zzlvVar);
        }
        this.zzj = true;
    }

    public final void zzh() {
        for (zzlu zzluVar : this.zzf.values()) {
            try {
                zzluVar.zza.zzp(zzluVar.zzb);
            } catch (RuntimeException e) {
                zzff.zzd("MediaSourceList", "Failed to release child source.", e);
            }
            zzluVar.zza.zzs(zzluVar.zzc);
            zzluVar.zza.zzr(zzluVar.zzc);
        }
        this.zzf.clear();
        this.zzg.clear();
        this.zzj = false;
    }

    public final void zzi(zzup zzupVar) {
        zzlv zzlvVar = (zzlv) this.zzc.remove(zzupVar);
        zzlvVar.getClass();
        zzlvVar.zza.zzG(zzupVar);
        zzlvVar.zzc.remove(((zzuj) zzupVar).zza);
        if (!this.zzc.isEmpty()) {
            zzt();
        }
        zzu(zzlvVar);
    }

    public final boolean zzj() {
        return this.zzj;
    }

    public final zzcx zzk(int i, List list, zzwk zzwkVar) {
        if (!list.isEmpty()) {
            this.zzl = zzwkVar;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                zzlv zzlvVar = (zzlv) list.get(i2 - i);
                if (i2 > 0) {
                    zzlv zzlvVar2 = (zzlv) this.zzb.get(i2 - 1);
                    zzlvVar.zzc(zzlvVar2.zzd + zzlvVar2.zza.zzC().zzc());
                } else {
                    zzlvVar.zzc(0);
                }
                zzr(i2, zzlvVar.zza.zzC().zzc());
                this.zzb.add(i2, zzlvVar);
                this.zzd.put(zzlvVar.zzb, zzlvVar);
                if (this.zzj) {
                    zzv(zzlvVar);
                    if (this.zzc.isEmpty()) {
                        this.zzg.add(zzlvVar);
                    } else {
                        zzs(zzlvVar);
                    }
                }
            }
        }
        return zzb();
    }

    public final zzcx zzl(int i, int i2, int i3, zzwk zzwkVar) {
        zzek.zzd(zza() >= 0);
        this.zzl = null;
        return zzb();
    }

    public final zzcx zzm(int i, int i2, zzwk zzwkVar) {
        boolean z = false;
        if (i >= 0 && i <= i2 && i2 <= zza()) {
            z = true;
        }
        zzek.zzd(z);
        this.zzl = zzwkVar;
        zzw(i, i2);
        return zzb();
    }

    public final zzcx zzn(List list, zzwk zzwkVar) {
        zzw(0, this.zzb.size());
        return zzk(this.zzb.size(), list, zzwkVar);
    }

    public final zzcx zzo(zzwk zzwkVar) {
        int zza = zza();
        if (zzwkVar.zzc() != zza) {
            zzwkVar = zzwkVar.zzf().zzg(0, zza);
        }
        this.zzl = zzwkVar;
        return zzb();
    }

    public final zzup zzp(zzur zzurVar, zzyx zzyxVar, long j) {
        int i = zzmd.zzc;
        Object obj = ((Pair) zzurVar.zza).first;
        zzur zza = zzurVar.zza(((Pair) zzurVar.zza).second);
        zzlv zzlvVar = (zzlv) this.zzd.get(obj);
        zzlvVar.getClass();
        this.zzg.add(zzlvVar);
        zzlu zzluVar = (zzlu) this.zzf.get(zzlvVar);
        if (zzluVar != null) {
            zzluVar.zza.zzk(zzluVar.zzb);
        }
        zzlvVar.zzc.add(zza);
        zzuj zzI = zzlvVar.zza.zzI(zza, zzyxVar, j);
        this.zzc.put(zzI, zzlvVar);
        zzt();
        return zzI;
    }

    public final zzwk zzq() {
        return this.zzl;
    }
}
