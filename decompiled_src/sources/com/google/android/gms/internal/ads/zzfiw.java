package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzfiw implements zzfiv {
    private final ConcurrentHashMap zza;
    private final zzfjc zzb;
    private final zzfiy zzc = new zzfiy();

    public zzfiw(zzfjc zzfjcVar) {
        this.zza = new ConcurrentHashMap(zzfjcVar.zzd);
        this.zzb = zzfjcVar;
    }

    private final void zzf() {
        Parcelable.Creator<zzfjc> creator = zzfjc.CREATOR;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgs)).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.zzb.zzb);
            sb.append(" PoolCollection");
            sb.append(this.zzc.zzb());
            int i = 0;
            for (Map.Entry entry : this.zza.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(((zzfjf) entry.getKey()).hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < ((zzfiu) entry.getValue()).zzb(); i2++) {
                    sb.append("[O]");
                }
                for (int zzb = ((zzfiu) entry.getValue()).zzb(); zzb < this.zzb.zzd; zzb++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(((zzfiu) entry.getValue()).zzg());
                sb.append("\n");
            }
            while (i < this.zzb.zzc) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            zzcec.zze(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfiv
    public final zzfjc zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfiv
    public final synchronized zzfje zzb(zzfjf zzfjfVar) {
        zzfje zzfjeVar;
        zzfiu zzfiuVar = (zzfiu) this.zza.get(zzfjfVar);
        if (zzfiuVar != null) {
            zzfjeVar = zzfiuVar.zze();
            if (zzfjeVar == null) {
                this.zzc.zze();
            }
            zzfjs zzf = zzfiuVar.zzf();
            if (zzfjeVar != null) {
                zzbce zza = zzbck.zza();
                zzbcc zza2 = zzbcd.zza();
                zza2.zzd(2);
                zzbcg zza3 = zzbch.zza();
                zza3.zza(zzf.zza);
                zza3.zzb(zzf.zzb);
                zza2.zza(zza3);
                zza.zza(zza2);
                zzfjeVar.zza.zzb().zzc().zzi((zzbck) zza.zzal());
            }
            zzf();
        } else {
            this.zzc.zzf();
            zzf();
            zzfjeVar = null;
        }
        return zzfjeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfiv
    @Deprecated
    public final zzfjf zzc(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, com.google.android.gms.ads.internal.client.zzw zzwVar) {
        return new zzfjg(zzlVar, str, new zzbzi(this.zzb.zza).zza().zzk, this.zzb.zzf, zzwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfiv
    public final synchronized boolean zzd(zzfjf zzfjfVar, zzfje zzfjeVar) {
        boolean zzh;
        zzfiu zzfiuVar = (zzfiu) this.zza.get(zzfjfVar);
        zzfjeVar.zzd = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
        if (zzfiuVar == null) {
            zzfjc zzfjcVar = this.zzb;
            zzfiu zzfiuVar2 = new zzfiu(zzfjcVar.zzd, zzfjcVar.zze * 1000);
            if (this.zza.size() == this.zzb.zzc) {
                int i = this.zzb.zzg;
                int i2 = i - 1;
                zzfjf zzfjfVar2 = null;
                if (i == 0) {
                    throw null;
                }
                long j = Long.MAX_VALUE;
                if (i2 == 0) {
                    for (Map.Entry entry : this.zza.entrySet()) {
                        if (((zzfiu) entry.getValue()).zzc() < j) {
                            j = ((zzfiu) entry.getValue()).zzc();
                            zzfjfVar2 = (zzfjf) entry.getKey();
                        }
                    }
                    if (zzfjfVar2 != null) {
                        this.zza.remove(zzfjfVar2);
                    }
                } else if (i2 == 1) {
                    for (Map.Entry entry2 : this.zza.entrySet()) {
                        if (((zzfiu) entry2.getValue()).zzd() < j) {
                            j = ((zzfiu) entry2.getValue()).zzd();
                            zzfjfVar2 = (zzfjf) entry2.getKey();
                        }
                    }
                    if (zzfjfVar2 != null) {
                        this.zza.remove(zzfjfVar2);
                    }
                } else if (i2 == 2) {
                    int i3 = Integer.MAX_VALUE;
                    for (Map.Entry entry3 : this.zza.entrySet()) {
                        if (((zzfiu) entry3.getValue()).zza() < i3) {
                            i3 = ((zzfiu) entry3.getValue()).zza();
                            zzfjfVar2 = (zzfjf) entry3.getKey();
                        }
                    }
                    if (zzfjfVar2 != null) {
                        this.zza.remove(zzfjfVar2);
                    }
                }
                this.zzc.zzg();
            }
            this.zza.put(zzfjfVar, zzfiuVar2);
            this.zzc.zzd();
            zzfiuVar = zzfiuVar2;
        }
        zzh = zzfiuVar.zzh(zzfjeVar);
        this.zzc.zzc();
        zzfix zza = this.zzc.zza();
        zzfjs zzf = zzfiuVar.zzf();
        if (zzfjeVar != null) {
            zzbce zza2 = zzbck.zza();
            zzbcc zza3 = zzbcd.zza();
            zza3.zzd(2);
            zzbci zza4 = zzbcj.zza();
            zza4.zza(zza.zza);
            zza4.zzb(zza.zzb);
            zza4.zzc(zzf.zzb);
            zza3.zzc(zza4);
            zza2.zza(zza3);
            zzfjeVar.zza.zzb().zzc().zzj((zzbck) zza2.zzal());
        }
        zzf();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzfiv
    public final synchronized boolean zze(zzfjf zzfjfVar) {
        zzfiu zzfiuVar = (zzfiu) this.zza.get(zzfjfVar);
        if (zzfiuVar == null) {
            return true;
        }
        return zzfiuVar.zzb() < this.zzb.zzd;
    }
}
