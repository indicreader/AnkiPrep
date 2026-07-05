package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.api.Releasable;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes3.dex */
public abstract class zzchw implements Releasable {
    protected final Context zza;
    protected final String zzb;
    protected final WeakReference zzc;

    public zzchw(zzcgl zzcglVar) {
        Context context = zzcglVar.getContext();
        this.zza = context;
        this.zzb = com.google.android.gms.ads.internal.zzt.zzp().zzc(context, zzcglVar.zzn().zza);
        this.zzc = new WeakReference(zzcglVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zze(zzchw zzchwVar, String str, Map map) {
        zzcgl zzcglVar = (zzcgl) zzchwVar.zzc.get();
        if (zzcglVar != null) {
            zzcglVar.zzd("onPrecacheEvent", map);
        }
    }

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }

    public abstract void zzf();

    public final void zzg(String str, String str2, String str3, String str4) {
        zzcdv.zza.post(new zzchv(this, str, str2, str3, str4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzh(String str, String str2, int i) {
        zzcdv.zza.post(new zzcht(this, str, str2, i));
    }

    public final void zzj(String str, String str2, long j) {
        zzcdv.zza.post(new zzchu(this, str, str2, j));
    }

    public final void zzn(String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        zzcdv.zza.post(new zzchs(this, str, str2, i, i2, j, j2, z, i3, i4));
    }

    public final void zzo(String str, String str2, long j, long j2, boolean z, long j3, long j4, long j5, int i, int i2) {
        zzcdv.zza.post(new zzchr(this, str, str2, j, j2, j3, j4, j5, z, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzp(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzq(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzr(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzs(int i) {
    }

    public abstract boolean zzt(String str);

    public boolean zzu(String str, String[] strArr) {
        return zzt(str);
    }

    public boolean zzw(String str, String[] strArr, zzcho zzchoVar) {
        return zzt(str);
    }
}
