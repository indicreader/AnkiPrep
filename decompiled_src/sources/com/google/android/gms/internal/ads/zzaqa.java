package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzaqa implements Comparable {
    private final zzaql zza;
    private final int zzb;
    private final String zzc;
    private final int zzd;
    private final Object zze;
    private final zzaqe zzf;
    private Integer zzg;
    private zzaqd zzh;
    private boolean zzi;
    private zzapj zzj;
    private zzapz zzk;
    private final zzapo zzl;

    public zzaqa(int i, String str, zzaqe zzaqeVar) {
        Uri parse;
        String host;
        this.zza = zzaql.zza ? new zzaql() : null;
        this.zze = new Object();
        int i2 = 0;
        this.zzi = false;
        this.zzj = null;
        this.zzb = i;
        this.zzc = str;
        this.zzf = zzaqeVar;
        this.zzl = new zzapo();
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && (host = parse.getHost()) != null) {
            i2 = host.hashCode();
        }
        this.zzd = i2;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzg.intValue() - ((zzaqa) obj).zzg.intValue();
    }

    public final String toString() {
        String valueOf = String.valueOf(Integer.toHexString(this.zzd));
        zzw();
        return "[ ] " + this.zzc + " " + "0x".concat(valueOf) + " NORMAL " + this.zzg;
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzl.zzb();
    }

    public final int zzc() {
        return this.zzd;
    }

    public final zzapj zzd() {
        return this.zzj;
    }

    public final zzaqa zze(zzapj zzapjVar) {
        this.zzj = zzapjVar;
        return this;
    }

    public final zzaqa zzf(zzaqd zzaqdVar) {
        this.zzh = zzaqdVar;
        return this;
    }

    public final zzaqa zzg(int i) {
        this.zzg = Integer.valueOf(i);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract zzaqg zzh(zzapw zzapwVar);

    public final String zzj() {
        int i = this.zzb;
        String str = this.zzc;
        if (i == 0) {
            return str;
        }
        return Integer.toString(1) + "-" + str;
    }

    public final String zzk() {
        return this.zzc;
    }

    public Map zzl() throws zzapi {
        return Collections.emptyMap();
    }

    public final void zzm(String str) {
        if (zzaql.zza) {
            this.zza.zza(str, Thread.currentThread().getId());
        }
    }

    public final void zzn(zzaqj zzaqjVar) {
        zzaqe zzaqeVar;
        synchronized (this.zze) {
            zzaqeVar = this.zzf;
        }
        zzaqeVar.zza(zzaqjVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void zzo(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzp(String str) {
        zzaqd zzaqdVar = this.zzh;
        if (zzaqdVar != null) {
            zzaqdVar.zzb(this);
        }
        if (zzaql.zza) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzapy(this, str, id));
            } else {
                this.zza.zza(str, id);
                this.zza.zzb(toString());
            }
        }
    }

    public final void zzq() {
        synchronized (this.zze) {
            this.zzi = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzr() {
        zzapz zzapzVar;
        synchronized (this.zze) {
            zzapzVar = this.zzk;
        }
        if (zzapzVar != null) {
            zzapzVar.zza(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzs(zzaqg zzaqgVar) {
        zzapz zzapzVar;
        synchronized (this.zze) {
            zzapzVar = this.zzk;
        }
        if (zzapzVar != null) {
            zzapzVar.zzb(this, zzaqgVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzt(int i) {
        zzaqd zzaqdVar = this.zzh;
        if (zzaqdVar != null) {
            zzaqdVar.zzc(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzu(zzapz zzapzVar) {
        synchronized (this.zze) {
            this.zzk = zzapzVar;
        }
    }

    public final boolean zzv() {
        boolean z;
        synchronized (this.zze) {
            z = this.zzi;
        }
        return z;
    }

    public final boolean zzw() {
        synchronized (this.zze) {
        }
        return false;
    }

    public byte[] zzx() throws zzapi {
        return null;
    }

    public final zzapo zzy() {
        return this.zzl;
    }
}
