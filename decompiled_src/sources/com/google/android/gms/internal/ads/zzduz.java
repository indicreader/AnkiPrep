package com.google.android.gms.internal.ads;

import androidx.core.location.LocationRequestCompat;
import com.google.mlkit.common.MlKitException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzduz implements zzdds, zzdcl, zzdba, zzdbr, com.google.android.gms.ads.internal.client.zza, zzdge {
    private final zzbbp zza;
    private boolean zzb = false;

    public zzduz(zzbbp zzbbpVar, @Nullable zzfeh zzfehVar) {
        this.zza = zzbbpVar;
        zzbbpVar.zzc(2);
        if (zzfehVar != null) {
            zzbbpVar.zzc(1101);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final synchronized void onAdClicked() {
        if (!this.zzb) {
            this.zza.zzc(7);
            this.zzb = true;
        } else {
            this.zza.zzc(8);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdba
    public final void zzbK(com.google.android.gms.ads.internal.client.zze zzeVar) {
        switch (zzeVar.zza) {
            case 1:
                this.zza.zzc(MlKitException.NOT_ENOUGH_SPACE);
                return;
            case 2:
                this.zza.zzc(102);
                return;
            case 3:
                this.zza.zzc(5);
                return;
            case 4:
                this.zza.zzc(103);
                return;
            case 5:
                this.zza.zzc(LocationRequestCompat.QUALITY_LOW_POWER);
                return;
            case 6:
                this.zza.zzc(105);
                return;
            case 7:
                this.zza.zzc(106);
                return;
            default:
                this.zza.zzc(4);
                return;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdds
    public final void zzbw(zzbze zzbzeVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdds
    public final void zzbx(final zzfgy zzfgyVar) {
        this.zza.zzb(new zzbbo() { // from class: com.google.android.gms.internal.ads.zzduv
            @Override // com.google.android.gms.internal.ads.zzbbo
            public final void zza(zzbde zzbdeVar) {
                zzbca zzbcaVar = (zzbca) zzbdeVar.zza().zzaB();
                zzbcs zzbcsVar = (zzbcs) zzbdeVar.zza().zzd().zzaB();
                zzbcsVar.zza(zzfgy.this.zzb.zzb.zzb);
                zzbcaVar.zzb(zzbcsVar);
                zzbdeVar.zze(zzbcaVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdge
    public final void zzh() {
        this.zza.zzc(1109);
    }

    @Override // com.google.android.gms.internal.ads.zzdge
    public final void zzi(final zzbck zzbckVar) {
        this.zza.zzb(new zzbbo() { // from class: com.google.android.gms.internal.ads.zzduy
            @Override // com.google.android.gms.internal.ads.zzbbo
            public final void zza(zzbde zzbdeVar) {
                zzbdeVar.zzf(zzbck.this);
            }
        });
        this.zza.zzc(1103);
    }

    @Override // com.google.android.gms.internal.ads.zzdge
    public final void zzj(final zzbck zzbckVar) {
        this.zza.zzb(new zzbbo() { // from class: com.google.android.gms.internal.ads.zzduw
            @Override // com.google.android.gms.internal.ads.zzbbo
            public final void zza(zzbde zzbdeVar) {
                zzbdeVar.zzf(zzbck.this);
            }
        });
        this.zza.zzc(1102);
    }

    @Override // com.google.android.gms.internal.ads.zzdge
    public final void zzl(boolean z) {
        this.zza.zzc(true != z ? 1108 : 1107);
    }

    @Override // com.google.android.gms.internal.ads.zzdge
    public final void zzm(final zzbck zzbckVar) {
        this.zza.zzb(new zzbbo() { // from class: com.google.android.gms.internal.ads.zzdux
            @Override // com.google.android.gms.internal.ads.zzbbo
            public final void zza(zzbde zzbdeVar) {
                zzbdeVar.zzf(zzbck.this);
            }
        });
        this.zza.zzc(1104);
    }

    @Override // com.google.android.gms.internal.ads.zzdge
    public final void zzn(boolean z) {
        this.zza.zzc(true != z ? 1106 : 1105);
    }

    @Override // com.google.android.gms.internal.ads.zzdbr
    public final synchronized void zzq() {
        this.zza.zzc(6);
    }

    @Override // com.google.android.gms.internal.ads.zzdcl
    public final void zzr() {
        this.zza.zzc(3);
    }
}
