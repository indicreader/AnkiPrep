package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzaku implements zzaea {
    private final zzaea zza;
    private final zzakp zzb;
    private zzakr zzh;
    private zzam zzi;
    private final zzaki zzc = new zzaki();
    private int zze = 0;
    private int zzf = 0;
    private byte[] zzg = zzfy.zzf;
    private final zzfp zzd = new zzfp();

    public zzaku(zzaea zzaeaVar, zzakp zzakpVar) {
        this.zza = zzaeaVar;
        this.zzb = zzakpVar;
    }

    private final void zzb(int i) {
        int length = this.zzg.length;
        int i2 = this.zzf;
        if (length - i2 >= i) {
            return;
        }
        int i3 = i2 - this.zze;
        int max = Math.max(i3 + i3, i + i3);
        byte[] bArr = this.zzg;
        byte[] bArr2 = max <= bArr.length ? bArr : new byte[max];
        System.arraycopy(bArr, this.zze, bArr2, 0, i3);
        this.zze = 0;
        this.zzf = i3;
        this.zzg = bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(long j, int i, zzakj zzakjVar) {
        zzek.zzb(this.zzi);
        zzgaa zzgaaVar = zzakjVar.zza;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(zzgaaVar.size());
        Iterator<E> it = zzgaaVar.iterator();
        while (it.hasNext()) {
            arrayList.add(((zzec) it.next()).zza());
        }
        long j2 = zzakjVar.zzc;
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayList);
        bundle.putLong("d", j2);
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        zzfp zzfpVar = this.zzd;
        int length = marshall.length;
        zzfpVar.zzI(marshall, length);
        this.zza.zzr(this.zzd, length);
        int i2 = i & Integer.MAX_VALUE;
        long j3 = zzakjVar.zzb;
        if (j3 == -9223372036854775807L) {
            zzek.zzf(this.zzi.zzq == Long.MAX_VALUE);
        } else {
            long j4 = this.zzi.zzq;
            j = j4 == Long.MAX_VALUE ? j + j3 : j3 + j4;
        }
        this.zza.zzt(j, i2, length, 0, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final /* synthetic */ int zzf(zzu zzuVar, int i, boolean z) {
        return zzady.zza(this, zzuVar, i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final int zzg(zzu zzuVar, int i, boolean z, int i2) throws IOException {
        if (this.zzh == null) {
            return this.zza.zzg(zzuVar, i, z, 0);
        }
        zzb(i);
        int zza = zzuVar.zza(this.zzg, this.zzf, i);
        if (zza != -1) {
            this.zzf += zza;
            return zza;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final void zzl(zzam zzamVar) {
        String str = zzamVar.zzm;
        str.getClass();
        zzek.zzd(zzcb.zzb(str) == 3);
        if (!zzamVar.equals(this.zzi)) {
            this.zzi = zzamVar;
            this.zzh = this.zzb.zzc(zzamVar) ? this.zzb.zzb(zzamVar) : null;
        }
        if (this.zzh == null) {
            this.zza.zzl(zzamVar);
            return;
        }
        zzaea zzaeaVar = this.zza;
        zzak zzb = zzamVar.zzb();
        zzb.zzW("application/x-media3-cues");
        zzb.zzz(zzamVar.zzm);
        zzb.zzaa(Long.MAX_VALUE);
        zzb.zzD(this.zzb.zza(zzamVar));
        zzaeaVar.zzl(zzb.zzac());
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final /* synthetic */ void zzr(zzfp zzfpVar, int i) {
        zzady.zzb(this, zzfpVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final void zzs(zzfp zzfpVar, int i, int i2) {
        if (this.zzh == null) {
            this.zza.zzs(zzfpVar, i, i2);
            return;
        }
        zzb(i);
        zzfpVar.zzG(this.zzg, this.zzf, i);
        this.zzf += i;
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final void zzt(final long j, final int i, int i2, int i3, zzadz zzadzVar) {
        if (this.zzh == null) {
            this.zza.zzt(j, i, i2, i3, zzadzVar);
            return;
        }
        zzek.zze(zzadzVar == null, "DRM on subtitles is not supported");
        int i4 = (this.zzf - i3) - i2;
        this.zzh.zza(this.zzg, i4, i2, zzakq.zza(), new zzep() { // from class: com.google.android.gms.internal.ads.zzakt
            @Override // com.google.android.gms.internal.ads.zzep
            public final void zza(Object obj) {
                zzaku.this.zza(j, i, (zzakj) obj);
            }
        });
        int i5 = i4 + i2;
        this.zze = i5;
        if (i5 == this.zzf) {
            this.zze = 0;
            this.zzf = 0;
        }
    }
}
