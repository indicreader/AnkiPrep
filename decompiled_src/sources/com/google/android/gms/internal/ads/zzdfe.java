package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdfe implements AppEventListener, OnAdMetadataChangedListener, zzdax, com.google.android.gms.ads.internal.client.zza, zzddi, zzdbr, zzdcw, com.google.android.gms.ads.internal.overlay.zzp, zzdbn, zzdiu {
    private final zzdfc zza = new zzdfc(this, null);

    @Nullable
    private zzeqe zzb;

    @Nullable
    private zzeqi zzc;

    @Nullable
    private zzfck zzd;

    @Nullable
    private zzffp zze;

    public static /* bridge */ /* synthetic */ void zzj(zzdfe zzdfeVar, zzeqe zzeqeVar) {
        zzdfeVar.zzb = zzeqeVar;
    }

    public static /* bridge */ /* synthetic */ void zzk(zzdfe zzdfeVar, zzfck zzfckVar) {
        zzdfeVar.zzd = zzfckVar;
    }

    public static /* bridge */ /* synthetic */ void zzl(zzdfe zzdfeVar, zzeqi zzeqiVar) {
        zzdfeVar.zzc = zzeqiVar;
    }

    public static /* bridge */ /* synthetic */ void zzm(zzdfe zzdfeVar, zzffp zzffpVar) {
        zzdfeVar.zze = zzffpVar;
    }

    private static void zzn(Object obj, zzdfd zzdfdVar) {
        if (obj != null) {
            zzdfdVar.zza(obj);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzn(this.zzb, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzddu
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzeqe) obj).onAdClicked();
            }
        });
        zzn(this.zzc, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzddv
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzeqi) obj).onAdClicked();
            }
        });
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void onAdMetadataChanged() {
        zzn(this.zze, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdea
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzffp) obj).onAdMetadataChanged();
            }
        });
    }

    @Override // com.google.android.gms.ads.admanager.AppEventListener
    public final void onAppEvent(final String str, final String str2) {
        zzn(this.zzb, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdeg
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzeqe) obj).onAppEvent(str, str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zza() {
        zzn(this.zzb, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdez
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzeqe) obj).zza();
            }
        });
        zzn(this.zze, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdfa
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzffp) obj).zza();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzb() {
        zzn(this.zzb, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdes
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzeqe) obj).zzb();
            }
        });
        zzn(this.zze, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdet
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzffp) obj).zzb();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbA() {
        zzn(this.zzd, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdei
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzfck) obj).zzbA();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzbB(final zzbzu zzbzuVar, final String str, final String str2) {
        zzn(this.zzb, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzded
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
            }
        });
        zzn(this.zze, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdef
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzffp) obj).zzbB(zzbzu.this, str, str2);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbC() {
        zzn(this.zzd, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdeo
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzfck) obj).zzbC();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbD(final int i) {
        zzn(this.zzd, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdeq
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzfck) obj).zzbD(i);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbP() {
        zzn(this.zzd, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzden
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdiu
    public final void zzbo() {
        zzn(this.zzb, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdeh
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzeqe) obj).zzbo();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbt() {
        zzn(this.zzd, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzddz
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbz() {
        zzn(this.zzd, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdem
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzfck) obj).zzbz();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzc() {
        zzn(this.zzb, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdeb
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzeqe) obj).zzc();
            }
        });
        zzn(this.zze, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdec
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzffp) obj).zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zze() {
        zzn(this.zzb, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzddt
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
            }
        });
        zzn(this.zze, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdee
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzffp) obj).zze();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzf() {
        zzn(this.zzb, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzddw
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
            }
        });
        zzn(this.zze, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzddx
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzffp) obj).zzf();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdcw
    public final void zzg() {
        zzn(this.zzd, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzder
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzfck) obj).zzg();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzddi
    public final void zzh(final com.google.android.gms.ads.internal.client.zzs zzsVar) {
        zzn(this.zzb, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdej
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzeqe) obj).zzh(com.google.android.gms.ads.internal.client.zzs.this);
            }
        });
        zzn(this.zze, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdek
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzffp) obj).zzh(com.google.android.gms.ads.internal.client.zzs.this);
            }
        });
        zzn(this.zzd, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdel
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzfck) obj).zzh(com.google.android.gms.ads.internal.client.zzs.this);
            }
        });
    }

    public final zzdfc zzi() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzdbn
    public final void zzp(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzn(this.zze, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdex
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzffp) obj).zzp(com.google.android.gms.ads.internal.client.zze.this);
            }
        });
        zzn(this.zzb, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdey
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzeqe) obj).zzp(com.google.android.gms.ads.internal.client.zze.this);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdbr
    public final void zzq() {
        zzn(this.zzb, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzddy
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzeqe) obj).zzq();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdiu
    public final void zzs() {
        zzn(this.zzb, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdep
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzeqe) obj).zzs();
            }
        });
        zzn(this.zzc, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdeu
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzeqi) obj).zzs();
            }
        });
        zzn(this.zze, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdev
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzffp) obj).zzs();
            }
        });
        zzn(this.zzd, new zzdfd() { // from class: com.google.android.gms.internal.ads.zzdew
            @Override // com.google.android.gms.internal.ads.zzdfd
            public final void zza(Object obj) {
                ((zzfck) obj).zzs();
            }
        });
    }
}
