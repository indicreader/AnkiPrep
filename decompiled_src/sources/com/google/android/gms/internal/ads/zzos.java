package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzos implements zzmp {
    private final zzel zza;
    private final zzcu zzb;
    private final zzcw zzc;
    private final zzor zzd;
    private final SparseArray zze;
    private zzfc zzf;
    private zzco zzg;
    private zzew zzh;
    private boolean zzi;

    public static /* synthetic */ void zzV(zzos zzosVar) {
        final zzmq zzT = zzosVar.zzT();
        zzosVar.zzY(zzT, 1028, new zzez() { // from class: com.google.android.gms.internal.ads.zzmu
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
        zzosVar.zzf.zze();
    }

    private final zzmq zzab() {
        return zzZ(this.zzd.zzd());
    }

    private final zzmq zzac() {
        return zzZ(this.zzd.zze());
    }

    private final zzmq zzad(zzce zzceVar) {
        zzur zzurVar;
        if (!(zzceVar instanceof zziz) || (zzurVar = ((zziz) zzceVar).zzj) == null) {
            return zzT();
        }
        return zzZ(zzurVar);
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzA(final zzam zzamVar, final zzis zzisVar) {
        final zzmq zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_VERTICAL_TEXT, new zzez() { // from class: com.google.android.gms.internal.ads.zzog
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
                ((zzms) obj).zze(zzmq.this, zzamVar, zzisVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzB(final long j) {
        final zzmq zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_ALIAS, new zzez(j) { // from class: com.google.android.gms.internal.ads.zznk
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzC(final Exception exc) {
        final zzmq zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, new zzez() { // from class: com.google.android.gms.internal.ads.zzoo
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzD(final zzpv zzpvVar) {
        final zzmq zzac = zzac();
        zzY(zzac, 1031, new zzez() { // from class: com.google.android.gms.internal.ads.zzod
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzE(final zzpv zzpvVar) {
        final zzmq zzac = zzac();
        zzY(zzac, 1032, new zzez() { // from class: com.google.android.gms.internal.ads.zzon
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzF(final int i, final long j, final long j2) {
        final zzmq zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_COPY, new zzez(i, j, j2) { // from class: com.google.android.gms.internal.ads.zzng
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzG(final int i, final long j) {
        final zzmq zzab = zzab();
        zzY(zzab, PointerIconCompat.TYPE_ZOOM_IN, new zzez() { // from class: com.google.android.gms.internal.ads.zznq
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
                ((zzms) obj).zzh(zzmq.this, i, j);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzH(final Object obj, final long j) {
        final zzmq zzac = zzac();
        zzY(zzac, 26, new zzez() { // from class: com.google.android.gms.internal.ads.zzok
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj2) {
                ((zzms) obj2).zzn(zzmq.this, obj, j);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzI(final Exception exc) {
        final zzmq zzac = zzac();
        zzY(zzac, 1030, new zzez() { // from class: com.google.android.gms.internal.ads.zznf
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzJ(final String str, final long j, final long j2) {
        final zzmq zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, new zzez(str, j2, j) { // from class: com.google.android.gms.internal.ads.zzom
            public final /* synthetic */ String zzb;

            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzK(final String str) {
        final zzmq zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_ZOOM_OUT, new zzez() { // from class: com.google.android.gms.internal.ads.zznp
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzL(final zzir zzirVar) {
        final zzmq zzab = zzab();
        zzY(zzab, PointerIconCompat.TYPE_GRAB, new zzez() { // from class: com.google.android.gms.internal.ads.zzoc
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
                ((zzms) obj).zzo(zzmq.this, zzirVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzM(final zzir zzirVar) {
        final zzmq zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, new zzez() { // from class: com.google.android.gms.internal.ads.zzoi
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzN(final long j, final int i) {
        final zzmq zzab = zzab();
        zzY(zzab, PointerIconCompat.TYPE_GRABBING, new zzez(j, i) { // from class: com.google.android.gms.internal.ads.zznu
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzO(final zzam zzamVar, final zzis zzisVar) {
        final zzmq zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, new zzez() { // from class: com.google.android.gms.internal.ads.zzob
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
                ((zzms) obj).zzp(zzmq.this, zzamVar, zzisVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzP() {
        zzew zzewVar = this.zzh;
        zzek.zzb(zzewVar);
        zzewVar.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzoj
            @Override // java.lang.Runnable
            public final void run() {
                zzos.zzV(zzos.this);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzQ(zzms zzmsVar) {
        this.zzf.zzf(zzmsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzR(final zzco zzcoVar, Looper looper) {
        zzgaa zzgaaVar;
        boolean z = true;
        if (this.zzg != null) {
            zzgaaVar = this.zzd.zzb;
            if (!zzgaaVar.isEmpty()) {
                z = false;
            }
        }
        zzek.zzf(z);
        zzcoVar.getClass();
        this.zzg = zzcoVar;
        this.zzh = this.zza.zzb(looper, null);
        this.zzf = this.zzf.zza(looper, new zzfa() { // from class: com.google.android.gms.internal.ads.zzni
            @Override // com.google.android.gms.internal.ads.zzfa
            public final void zza(Object obj, zzah zzahVar) {
                zzos.this.zzW(zzcoVar, (zzms) obj, zzahVar);
            }
        });
    }

    protected final zzmq zzT() {
        return zzZ(this.zzd.zzb());
    }

    @RequiresNonNull({"player"})
    protected final zzmq zzU(zzcx zzcxVar, int i, zzur zzurVar) {
        zzur zzurVar2 = true == zzcxVar.zzo() ? null : zzurVar;
        long zza = this.zza.zza();
        boolean z = zzcxVar.equals(this.zzg.zzn()) && i == this.zzg.zzd();
        long j = 0;
        if (zzurVar2 == null || !zzurVar2.zzb()) {
            if (z) {
                j = this.zzg.zzj();
            } else if (!zzcxVar.zzo()) {
                long j2 = zzcxVar.zze(i, this.zzc, 0L).zzn;
                j = zzfy.zzt(0L);
            }
        } else if (z && this.zzg.zzb() == zzurVar2.zzb && this.zzg.zzc() == zzurVar2.zzc) {
            j = this.zzg.zzk();
        }
        return new zzmq(zza, zzcxVar, i, zzurVar2, j, this.zzg.zzn(), this.zzg.zzd(), this.zzd.zzb(), this.zzg.zzk(), this.zzg.zzm());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzW(zzco zzcoVar, zzms zzmsVar, zzah zzahVar) {
        zzmsVar.zzi(zzcoVar, new zzmr(zzahVar, this.zze));
    }

    @Override // com.google.android.gms.internal.ads.zzyv
    public final void zzX(final int i, final long j, final long j2) {
        final zzmq zzZ = zzZ(this.zzd.zzc());
        zzY(zzZ, PointerIconCompat.TYPE_CELL, new zzez() { // from class: com.google.android.gms.internal.ads.zznd
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
                ((zzms) obj).zzf(zzmq.this, i, j, j2);
            }
        });
    }

    protected final void zzY(zzmq zzmqVar, int i, zzez zzezVar) {
        this.zze.put(i, zzmqVar);
        zzfc zzfcVar = this.zzf;
        zzfcVar.zzd(i, zzezVar);
        zzfcVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zza(final zzck zzckVar) {
        final zzmq zzT = zzT();
        zzY(zzT, 13, new zzez() { // from class: com.google.android.gms.internal.ads.zzmz
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final void zzae(int i, zzur zzurVar, final zzun zzunVar) {
        final zzmq zzaa = zzaa(i, zzurVar);
        zzY(zzaa, PointerIconCompat.TYPE_WAIT, new zzez() { // from class: com.google.android.gms.internal.ads.zznv
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
                ((zzms) obj).zzg(zzmq.this, zzunVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final void zzaf(int i, zzur zzurVar, final zzui zzuiVar, final zzun zzunVar) {
        final zzmq zzaa = zzaa(i, zzurVar);
        zzY(zzaa, PointerIconCompat.TYPE_HAND, new zzez() { // from class: com.google.android.gms.internal.ads.zznw
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final void zzag(int i, zzur zzurVar, final zzui zzuiVar, final zzun zzunVar) {
        final zzmq zzaa = zzaa(i, zzurVar);
        zzY(zzaa, 1001, new zzez() { // from class: com.google.android.gms.internal.ads.zzoa
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final void zzah(int i, zzur zzurVar, final zzui zzuiVar, final zzun zzunVar, final IOException iOException, final boolean z) {
        final zzmq zzaa = zzaa(i, zzurVar);
        zzY(zzaa, PointerIconCompat.TYPE_HELP, new zzez() { // from class: com.google.android.gms.internal.ads.zznh
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
                ((zzms) obj).zzj(zzmq.this, zzuiVar, zzunVar, iOException, z);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final void zzai(int i, zzur zzurVar, final zzui zzuiVar, final zzun zzunVar) {
        final zzmq zzaa = zzaa(i, zzurVar);
        zzY(zzaa, 1000, new zzez() { // from class: com.google.android.gms.internal.ads.zzmy
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzb(final boolean z) {
        final zzmq zzT = zzT();
        zzY(zzT, 3, new zzez(z) { // from class: com.google.android.gms.internal.ads.zzmw
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzc(final boolean z) {
        final zzmq zzT = zzT();
        zzY(zzT, 7, new zzez(z) { // from class: com.google.android.gms.internal.ads.zznl
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzd(final zzbp zzbpVar, final int i) {
        final zzmq zzT = zzT();
        zzY(zzT, 1, new zzez(zzbpVar, i) { // from class: com.google.android.gms.internal.ads.zznb
            public final /* synthetic */ zzbp zzb;

            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zze(final zzbv zzbvVar) {
        final zzmq zzT = zzT();
        zzY(zzT, 14, new zzez() { // from class: com.google.android.gms.internal.ads.zzop
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzf(final boolean z, final int i) {
        final zzmq zzT = zzT();
        zzY(zzT, 5, new zzez(z, i) { // from class: com.google.android.gms.internal.ads.zzns
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzg(final zzcg zzcgVar) {
        final zzmq zzT = zzT();
        zzY(zzT, 12, new zzez() { // from class: com.google.android.gms.internal.ads.zzmt
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzh(final int i) {
        final zzmq zzT = zzT();
        zzY(zzT, 4, new zzez() { // from class: com.google.android.gms.internal.ads.zznz
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
                ((zzms) obj).zzk(zzmq.this, i);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzi(final int i) {
        final zzmq zzT = zzT();
        zzY(zzT, 6, new zzez(i) { // from class: com.google.android.gms.internal.ads.zzno
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzj(final zzce zzceVar) {
        final zzmq zzad = zzad(zzceVar);
        zzY(zzad, 10, new zzez() { // from class: com.google.android.gms.internal.ads.zznx
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
                ((zzms) obj).zzl(zzmq.this, zzceVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzk(final zzce zzceVar) {
        final zzmq zzad = zzad(zzceVar);
        zzY(zzad, 10, new zzez() { // from class: com.google.android.gms.internal.ads.zznr
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzl(final boolean z, final int i) {
        final zzmq zzT = zzT();
        zzY(zzT, -1, new zzez(z, i) { // from class: com.google.android.gms.internal.ads.zznj
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzn(final boolean z) {
        final zzmq zzac = zzac();
        zzY(zzac, 23, new zzez(z) { // from class: com.google.android.gms.internal.ads.zznc
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzo(final int i, final int i2) {
        final zzmq zzac = zzac();
        zzY(zzac, 24, new zzez(i, i2) { // from class: com.google.android.gms.internal.ads.zzoq
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzq(final zzdk zzdkVar) {
        final zzmq zzT = zzT();
        zzY(zzT, 2, new zzez() { // from class: com.google.android.gms.internal.ads.zznm
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzr(final zzdp zzdpVar) {
        final zzmq zzac = zzac();
        zzY(zzac, 25, new zzez() { // from class: com.google.android.gms.internal.ads.zzoe
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
                zzmq zzmqVar = zzmq.this;
                zzdp zzdpVar2 = zzdpVar;
                ((zzms) obj).zzq(zzmqVar, zzdpVar2);
                int i = zzdpVar2.zzc;
                int i2 = zzdpVar2.zzd;
                int i3 = zzdpVar2.zze;
                float f = zzdpVar2.zzf;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzs(final float f) {
        final zzmq zzac = zzac();
        zzY(zzac, 22, new zzez(f) { // from class: com.google.android.gms.internal.ads.zzne
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzt(zzms zzmsVar) {
        this.zzf.zzb(zzmsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzu() {
        if (this.zzi) {
            return;
        }
        final zzmq zzT = zzT();
        this.zzi = true;
        zzY(zzT, -1, new zzez() { // from class: com.google.android.gms.internal.ads.zzof
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzv(final Exception exc) {
        final zzmq zzac = zzac();
        zzY(zzac, 1029, new zzez() { // from class: com.google.android.gms.internal.ads.zzol
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzw(final String str, final long j, final long j2) {
        final zzmq zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_TEXT, new zzez(str, j2, j) { // from class: com.google.android.gms.internal.ads.zznn
            public final /* synthetic */ String zzb;

            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzx(final String str) {
        final zzmq zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_NO_DROP, new zzez() { // from class: com.google.android.gms.internal.ads.zzmx
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzy(final zzir zzirVar) {
        final zzmq zzab = zzab();
        zzY(zzab, PointerIconCompat.TYPE_ALL_SCROLL, new zzez() { // from class: com.google.android.gms.internal.ads.zzny
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzz(final zzir zzirVar) {
        final zzmq zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_CROSSHAIR, new zzez() { // from class: com.google.android.gms.internal.ads.zzmv
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmp
    public final void zzS(List list, zzur zzurVar) {
        zzco zzcoVar = this.zzg;
        zzcoVar.getClass();
        this.zzd.zzh(list, zzurVar, zzcoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzm(final zzcn zzcnVar, final zzcn zzcnVar2, final int i) {
        if (i == 1) {
            this.zzi = false;
            i = 1;
        }
        zzor zzorVar = this.zzd;
        zzco zzcoVar = this.zzg;
        zzcoVar.getClass();
        zzorVar.zzg(zzcoVar);
        final zzmq zzT = zzT();
        zzY(zzT, 11, new zzez() { // from class: com.google.android.gms.internal.ads.zzoh
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
                ((zzms) obj).zzm(zzmq.this, zzcnVar, zzcnVar2, i);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzp(zzcx zzcxVar, final int i) {
        zzco zzcoVar = this.zzg;
        zzcoVar.getClass();
        this.zzd.zzi(zzcoVar);
        final zzmq zzT = zzT();
        zzY(zzT, 0, new zzez(i) { // from class: com.google.android.gms.internal.ads.zzna
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
            }
        });
    }

    public zzos(zzel zzelVar) {
        zzelVar.getClass();
        this.zza = zzelVar;
        this.zzf = new zzfc(zzfy.zzx(), zzelVar, new zzfa() { // from class: com.google.android.gms.internal.ads.zznt
            @Override // com.google.android.gms.internal.ads.zzfa
            public final void zza(Object obj, zzah zzahVar) {
            }
        });
        zzcu zzcuVar = new zzcu();
        this.zzb = zzcuVar;
        this.zzc = new zzcw();
        this.zzd = new zzor(zzcuVar);
        this.zze = new SparseArray();
    }

    private final zzmq zzaa(int i, zzur zzurVar) {
        zzco zzcoVar = this.zzg;
        zzcoVar.getClass();
        if (zzurVar != null) {
            if (this.zzd.zza(zzurVar) != null) {
                return zzZ(zzurVar);
            }
            return zzU(zzcx.zza, i, zzurVar);
        }
        zzcx zzn = zzcoVar.zzn();
        if (i >= zzn.zzc()) {
            zzn = zzcx.zza;
        }
        return zzU(zzn, i, null);
    }

    private final zzmq zzZ(zzur zzurVar) {
        this.zzg.getClass();
        zzcx zza = zzurVar == null ? null : this.zzd.zza(zzurVar);
        if (zzurVar == null || zza == null) {
            int zzd = this.zzg.zzd();
            zzcx zzn = this.zzg.zzn();
            if (zzd >= zzn.zzc()) {
                zzn = zzcx.zza;
            }
            return zzU(zzn, zzd, null);
        }
        return zzU(zza, zza.zzn(zzurVar.zza, this.zzb).zzd, zzurVar);
    }
}
