package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfck implements zzdba, zzdcw, zzfea, com.google.android.gms.ads.internal.overlay.zzp, zzddi, zzdbn, zzdiu {
    private final zzfir zza;
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private zzfck zzh = null;

    public zzfck(zzfir zzfirVar) {
        this.zza = zzfirVar;
    }

    public static zzfck zzi(zzfck zzfckVar) {
        zzfck zzfckVar2 = new zzfck(zzfckVar.zza);
        zzfckVar2.zzh = zzfckVar;
        return zzfckVar2;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbA() {
        zzfck zzfckVar = this.zzh;
        if (zzfckVar != null) {
            zzfckVar.zzbA();
            return;
        }
        zzfdr.zza(this.zzf, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfcj
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.overlay.zzp) obj).zzbA();
            }
        });
        zzfdr.zza(this.zzd, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfbw
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzbaq) obj).zzf();
            }
        });
        zzfdr.zza(this.zzd, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfbx
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzbaq) obj).zze();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbC() {
        zzfck zzfckVar = this.zzh;
        if (zzfckVar != null) {
            zzfckVar.zzbC();
        } else {
            zzfdr.zza(this.zzf, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfci
                @Override // com.google.android.gms.internal.ads.zzfdq
                public final void zza(Object obj) {
                    ((com.google.android.gms.ads.internal.overlay.zzp) obj).zzbC();
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbD(final int i) {
        zzfck zzfckVar = this.zzh;
        if (zzfckVar != null) {
            zzfckVar.zzbD(i);
        } else {
            zzfdr.zza(this.zzf, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfce
                @Override // com.google.android.gms.internal.ads.zzfdq
                public final void zza(Object obj) {
                    ((com.google.android.gms.ads.internal.overlay.zzp) obj).zzbD(i);
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbP() {
    }

    @Override // com.google.android.gms.internal.ads.zzdiu
    public final void zzbo() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbt() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbz() {
        zzfck zzfckVar = this.zzh;
        if (zzfckVar != null) {
            zzfckVar.zzbz();
        } else {
            zzfdr.zza(this.zzf, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfby
                @Override // com.google.android.gms.internal.ads.zzfdq
                public final void zza(Object obj) {
                    ((com.google.android.gms.ads.internal.overlay.zzp) obj).zzbz();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcw
    public final void zzg() {
        zzfck zzfckVar = this.zzh;
        if (zzfckVar != null) {
            zzfckVar.zzg();
        } else {
            zzfdr.zza(this.zze, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfch
                @Override // com.google.android.gms.internal.ads.zzfdq
                public final void zza(Object obj) {
                    ((zzdcw) obj).zzg();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddi
    public final void zzh(final com.google.android.gms.ads.internal.client.zzs zzsVar) {
        zzfck zzfckVar = this.zzh;
        if (zzfckVar != null) {
            zzfckVar.zzh(zzsVar);
        } else {
            zzfdr.zza(this.zzg, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfbv
                @Override // com.google.android.gms.internal.ads.zzfdq
                public final void zza(Object obj) {
                    ((com.google.android.gms.ads.internal.client.zzdg) obj).zze(com.google.android.gms.ads.internal.client.zzs.this);
                }
            });
        }
    }

    public final void zzj() {
        zzfck zzfckVar = this.zzh;
        if (zzfckVar != null) {
            zzfckVar.zzj();
            return;
        }
        this.zza.zza();
        zzfdr.zza(this.zzc, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfcc
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzban) obj).zza();
            }
        });
        zzfdr.zza(this.zzd, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfcd
            @Override // com.google.android.gms.internal.ads.zzfdq
            public final void zza(Object obj) {
                ((zzbaq) obj).zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfea
    public final void zzl(zzfea zzfeaVar) {
        this.zzh = (zzfck) zzfeaVar;
    }

    public final void zzm(com.google.android.gms.ads.internal.overlay.zzp zzpVar) {
        this.zzf.set(zzpVar);
    }

    public final void zzn(com.google.android.gms.ads.internal.client.zzdg zzdgVar) {
        this.zzg.set(zzdgVar);
    }

    public final void zzo(zzbam zzbamVar) {
        this.zzb.set(zzbamVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbn
    public final void zzp(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzfck zzfckVar = this.zzh;
        if (zzfckVar != null) {
            zzfckVar.zzp(zzeVar);
        } else {
            zzfdr.zza(this.zzd, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfbz
                @Override // com.google.android.gms.internal.ads.zzfdq
                public final void zza(Object obj) {
                    ((zzbaq) obj).zzd(com.google.android.gms.ads.internal.client.zze.this);
                }
            });
        }
    }

    public final void zzq(zzbaq zzbaqVar) {
        this.zzd.set(zzbaqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdiu
    public final void zzs() {
        zzfck zzfckVar = this.zzh;
        if (zzfckVar != null) {
            zzfckVar.zzs();
        } else {
            zzfdr.zza(this.zzd, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfcb
                @Override // com.google.android.gms.internal.ads.zzfdq
                public final void zza(Object obj) {
                    ((zzbaq) obj).zzb();
                }
            });
        }
    }

    public final void zzk(final zzbaj zzbajVar) {
        zzfck zzfckVar = this.zzh;
        if (zzfckVar == null) {
            zzfdr.zza(this.zzb, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfca
                @Override // com.google.android.gms.internal.ads.zzfdq
                public final void zza(Object obj) {
                    ((zzbam) obj).zzd(zzbaj.this);
                }
            });
        } else {
            zzfckVar.zzk(zzbajVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdba
    public final void zzbK(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzfck zzfckVar = this.zzh;
        if (zzfckVar == null) {
            zzfdr.zza(this.zzb, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfcf
                @Override // com.google.android.gms.internal.ads.zzfdq
                public final void zza(Object obj) {
                    ((zzbam) obj).zzc(com.google.android.gms.ads.internal.client.zze.this);
                }
            });
            zzfdr.zza(this.zzb, new zzfdq() { // from class: com.google.android.gms.internal.ads.zzfcg
                @Override // com.google.android.gms.internal.ads.zzfdq
                public final void zza(Object obj) {
                    ((zzbam) obj).zzb(com.google.android.gms.ads.internal.client.zze.this.zza);
                }
            });
        } else {
            zzfckVar.zzbK(zzeVar);
        }
    }
}
