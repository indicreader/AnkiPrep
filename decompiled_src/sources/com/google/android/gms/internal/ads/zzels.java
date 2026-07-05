package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzels {
    private final zzgfg zzc;
    private zzemi zzf;
    private final String zzh;
    private final int zzi;
    private final zzemh zzj;
    private zzfgm zzk;
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final List zzd = new ArrayList();
    private final Set zze = new HashSet();
    private int zzg = Integer.MAX_VALUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzels(zzfgy zzfgyVar, zzemh zzemhVar, zzgfg zzgfgVar) {
        this.zzi = zzfgyVar.zzb.zzb.zzp;
        this.zzj = zzemhVar;
        this.zzc = zzgfgVar;
        this.zzh = zzemo.zzc(zzfgyVar);
        List list = zzfgyVar.zzb.zza;
        for (int i = 0; i < list.size(); i++) {
            this.zza.put((zzfgm) list.get(i), Integer.valueOf(i));
        }
        this.zzb.addAll(list);
    }

    private final synchronized void zzf() {
        this.zzj.zzi(this.zzk);
        zzemi zzemiVar = this.zzf;
        if (zzemiVar != null) {
            this.zzc.zzc(zzemiVar);
        } else {
            this.zzc.zzd(new zzeml(3, this.zzh));
        }
    }

    private final synchronized boolean zzg(boolean z) {
        for (zzfgm zzfgmVar : this.zzb) {
            Integer num = (Integer) this.zza.get(zzfgmVar);
            Integer valueOf = Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE);
            if (z || !this.zze.contains(zzfgmVar.zzat)) {
                if (valueOf.intValue() < this.zzg) {
                    return true;
                }
                if (valueOf.intValue() > this.zzg) {
                    break;
                }
            }
        }
        return false;
    }

    private final synchronized boolean zzh() {
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) this.zza.get((zzfgm) it.next());
            if (Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE).intValue() < this.zzg) {
                return true;
            }
        }
        return false;
    }

    private final synchronized boolean zzi() {
        if (!zzg(true)) {
            if (!zzh()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final synchronized zzfgm zza() {
        for (int i = 0; i < this.zzb.size(); i++) {
            zzfgm zzfgmVar = (zzfgm) this.zzb.get(i);
            String str = zzfgmVar.zzat;
            if (!this.zze.contains(str)) {
                if (!TextUtils.isEmpty(str)) {
                    this.zze.add(str);
                }
                this.zzd.add(zzfgmVar);
                return (zzfgm) this.zzb.remove(i);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zzb(Throwable th, zzfgm zzfgmVar) {
        this.zzd.remove(zzfgmVar);
        this.zze.remove(zzfgmVar.zzat);
        if (zzd() || zzi()) {
            return;
        }
        zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zzc(zzemi zzemiVar, zzfgm zzfgmVar) {
        this.zzd.remove(zzfgmVar);
        if (zzd()) {
            zzemiVar.zzq();
            return;
        }
        Integer num = (Integer) this.zza.get(zzfgmVar);
        Integer valueOf = Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE);
        if (valueOf.intValue() > this.zzg) {
            this.zzj.zzm(zzfgmVar);
            return;
        }
        if (this.zzf != null) {
            this.zzj.zzm(this.zzk);
        }
        this.zzg = valueOf.intValue();
        this.zzf = zzemiVar;
        this.zzk = zzfgmVar;
        if (zzi()) {
            return;
        }
        zzf();
    }

    final synchronized boolean zzd() {
        return this.zzc.isDone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean zze() {
        if (!zzd()) {
            List list = this.zzd;
            if (list.size() < this.zzi) {
                if (zzg(false)) {
                    return true;
                }
            }
        }
        return false;
    }
}
