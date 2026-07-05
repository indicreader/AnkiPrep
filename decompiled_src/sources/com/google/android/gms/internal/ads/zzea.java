package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.text.Layout;
import androidx.core.view.ViewCompat;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzea {
    private CharSequence zza;
    private Bitmap zzb;
    private Layout.Alignment zzc;
    private Layout.Alignment zzd;
    private float zze;
    private int zzf;
    private int zzg;
    private float zzh;
    private int zzi;
    private int zzj;
    private float zzk;
    private float zzl;
    private float zzm;
    private int zzn;
    private float zzo;

    public zzea() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = -3.4028235E38f;
        this.zzf = Integer.MIN_VALUE;
        this.zzg = Integer.MIN_VALUE;
        this.zzh = -3.4028235E38f;
        this.zzi = Integer.MIN_VALUE;
        this.zzj = Integer.MIN_VALUE;
        this.zzk = -3.4028235E38f;
        this.zzl = -3.4028235E38f;
        this.zzm = -3.4028235E38f;
        this.zzn = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzea(zzec zzecVar, zzdz zzdzVar) {
        this.zza = zzecVar.zzc;
        this.zzb = zzecVar.zzf;
        this.zzc = zzecVar.zzd;
        this.zzd = zzecVar.zze;
        this.zze = zzecVar.zzg;
        this.zzf = zzecVar.zzh;
        this.zzg = zzecVar.zzi;
        this.zzh = zzecVar.zzj;
        this.zzi = zzecVar.zzk;
        this.zzj = zzecVar.zzn;
        this.zzk = zzecVar.zzo;
        this.zzl = zzecVar.zzl;
        this.zzm = zzecVar.zzm;
        this.zzn = zzecVar.zzp;
        this.zzo = zzecVar.zzq;
    }

    @Pure
    public final int zza() {
        return this.zzg;
    }

    @Pure
    public final int zzb() {
        return this.zzi;
    }

    public final zzea zzc(Bitmap bitmap) {
        this.zzb = bitmap;
        return this;
    }

    public final zzea zzd(float f) {
        this.zzm = f;
        return this;
    }

    public final zzea zze(float f, int i) {
        this.zze = f;
        this.zzf = i;
        return this;
    }

    public final zzea zzf(int i) {
        this.zzg = i;
        return this;
    }

    public final zzea zzg(Layout.Alignment alignment) {
        this.zzd = alignment;
        return this;
    }

    public final zzea zzh(float f) {
        this.zzh = f;
        return this;
    }

    public final zzea zzi(int i) {
        this.zzi = i;
        return this;
    }

    public final zzea zzj(float f) {
        this.zzo = f;
        return this;
    }

    public final zzea zzk(float f) {
        this.zzl = f;
        return this;
    }

    public final zzea zzl(CharSequence charSequence) {
        this.zza = charSequence;
        return this;
    }

    public final zzea zzm(Layout.Alignment alignment) {
        this.zzc = alignment;
        return this;
    }

    public final zzea zzn(float f, int i) {
        this.zzk = f;
        this.zzj = i;
        return this;
    }

    public final zzea zzo(int i) {
        this.zzn = i;
        return this;
    }

    public final zzec zzp() {
        return new zzec(this.zza, this.zzc, this.zzd, this.zzb, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, false, ViewCompat.MEASURED_STATE_MASK, this.zzn, this.zzo, null);
    }

    @Pure
    public final CharSequence zzq() {
        return this.zza;
    }
}
