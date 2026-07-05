package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbsg {
    private final zzbrj zza;
    private ListenableFuture zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbsg(zzbrj zzbrjVar) {
        this.zza = zzbrjVar;
    }

    private final void zzd() {
        if (this.zzb == null) {
            final zzceu zzceuVar = new zzceu();
            this.zzb = zzceuVar;
            this.zza.zzb(null).zzi(new zzcey() { // from class: com.google.android.gms.internal.ads.zzbsd
                @Override // com.google.android.gms.internal.ads.zzcey
                public final void zza(Object obj) {
                    zzceu.this.zzc((zzbrk) obj);
                }
            }, new zzcew() { // from class: com.google.android.gms.internal.ads.zzbse
                @Override // com.google.android.gms.internal.ads.zzcew
                public final void zza() {
                    zzceu.this.zzd(new zzbrm("Cannot get Javascript Engine"));
                }
            });
        }
    }

    public final zzbsj zza(String str, zzbrq zzbrqVar, zzbrp zzbrpVar) {
        zzd();
        return new zzbsj(this.zzb, "google.afma.activeView.handleUpdate", zzbrqVar, zzbrpVar);
    }

    public final void zzb(final String str, final zzbng zzbngVar) {
        zzd();
        this.zzb = zzgen.zzn(this.zzb, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzbsf
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                zzbrk zzbrkVar = (zzbrk) obj;
                zzbrkVar.zzq(str, zzbngVar);
                return zzgen.zzh(zzbrkVar);
            }
        }, zzcep.zzf);
    }

    public final void zzc(final String str, final zzbng zzbngVar) {
        this.zzb = zzgen.zzm(this.zzb, new zzfws() { // from class: com.google.android.gms.internal.ads.zzbsc
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                zzbrk zzbrkVar = (zzbrk) obj;
                zzbrkVar.zzr(str, zzbngVar);
                return zzbrkVar;
            }
        }, zzcep.zzf);
    }
}
