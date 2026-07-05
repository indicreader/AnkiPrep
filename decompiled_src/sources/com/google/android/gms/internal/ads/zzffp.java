package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzffp implements OnAdMetadataChangedListener, zzdcl, zzdba, zzdax, zzdbn, zzddi, zzfea, zzdiu {
    private final zzfir zza;
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private final AtomicReference zzh = new AtomicReference();

    public zzffp(zzfir zzfirVar) {
        this.zza = zzfirVar;
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void onAdMetadataChanged() {
        zzfdr.zza(this.zzb, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzffd
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((OnAdMetadataChangedListener) obj).onAdMetadataChanged();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zza() {
        this.zza.zza();
        zzfdr.zza(this.zzd, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzffl
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzcaq) obj).zzg();
            }
        });
        zzfdr.zza(this.zze, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzffm
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzcaa) obj).zzf();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzb() {
        zzfdr.zza(this.zze, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzffn
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzcaa) obj).zzh();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzbB(final zzbzu zzbzuVar, final String str, final String str2) {
        zzfdr.zza(this.zzd, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzffo
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                zzbzu zzbzuVar2 = zzbzu.this;
                ((zzcaq) obj).zzk(new zzcbe(zzbzuVar2.zzc(), zzbzuVar2.zzb()));
            }
        });
        zzfdr.zza(this.zzf, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfeu
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                zzbzu zzbzuVar2 = zzbzu.this;
                ((zzcav) obj).zze(new zzcbe(zzbzuVar2.zzc(), zzbzuVar2.zzb()), str, str2);
            }
        });
        zzfdr.zza(this.zze, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfev
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzcaa) obj).zze(zzbzu.this);
            }
        });
        zzfdr.zza(this.zzg, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfew
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzbzv) obj).zze(zzbzu.this, str, str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdba
    public final void zzbK(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        final int i = zzeVar.zza;
        zzfdr.zza(this.zzc, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzffi
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzcau) obj).zzf(com.google.android.gms.ads.internal.client.zze.this);
            }
        });
        zzfdr.zza(this.zzc, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzffj
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzcau) obj).zze(i);
            }
        });
        zzfdr.zza(this.zze, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzffk
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzcaa) obj).zzg(i);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdiu
    public final void zzbo() {
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzc() {
        zzfdr.zza(this.zzd, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfex
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzcaq) obj).zzj();
            }
        });
        zzfdr.zza(this.zze, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfey
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzcaa) obj).zzj();
            }
        });
        zzfdr.zza(this.zzd, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfez
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzcaq) obj).zzf();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zze() {
        zzfdr.zza(this.zze, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzffh
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzcaa) obj).zzk();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzf() {
        zzfdr.zza(this.zze, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfet
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzcaa) obj).zzl();
            }
        });
    }

    public final void zzg(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzb.set(onAdMetadataChangedListener);
    }

    @Override // com.google.android.gms.internal.ads.zzddi
    public final void zzh(final com.google.android.gms.ads.internal.client.zzs zzsVar) {
        zzfdr.zza(this.zzh, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzffa
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzdg) obj).zze(com.google.android.gms.ads.internal.client.zzs.this);
            }
        });
    }

    public final void zzi(com.google.android.gms.ads.internal.client.zzdg zzdgVar) {
        this.zzh.set(zzdgVar);
    }

    public final void zzj(zzcaq zzcaqVar) {
        this.zzd.set(zzcaqVar);
    }

    public final void zzk(zzcau zzcauVar) {
        this.zzc.set(zzcauVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfea
    public final void zzl(zzfea zzfeaVar) {
        throw null;
    }

    @Deprecated
    public final void zzm(zzcaa zzcaaVar) {
        this.zze.set(zzcaaVar);
    }

    @Deprecated
    public final void zzn(zzbzv zzbzvVar) {
        this.zzg.set(zzbzvVar);
    }

    public final void zzo(zzcav zzcavVar) {
        this.zzf.set(zzcavVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbn
    public final void zzp(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzfdr.zza(this.zzd, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfff
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzcaq) obj).zzi(com.google.android.gms.ads.internal.client.zze.this);
            }
        });
        zzfdr.zza(this.zzd, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzffg
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzcaq) obj).zzh(com.google.android.gms.ads.internal.client.zze.this.zza);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdcl
    public final void zzr() {
        zzfdr.zza(this.zzc, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzffb
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzcau) obj).zzg();
            }
        });
        zzfdr.zza(this.zze, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzffc
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzcaa) obj).zzi();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdiu
    public final void zzs() {
        zzfdr.zza(this.zzd, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzffe
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzcaq) obj).zze();
            }
        });
    }
}
