package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzawh implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzawj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawh(zzawj zzawjVar, int i, boolean z) {
        this.zzb = zzawjVar;
        this.zza = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzatd zzatdVar;
        int i = this.zza;
        zzawj zzawjVar = this.zzb;
        if (i > 0) {
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException unused) {
            }
        }
        try {
            PackageInfo packageInfo = zzawjVar.zza.getPackageManager().getPackageInfo(zzawjVar.zza.getPackageName(), 0);
            Context context = zzawjVar.zza;
            zzatdVar = zzfqz.zza(context, context.getPackageName(), Integer.toString(packageInfo.versionCode));
        } catch (Throwable unused2) {
            zzatdVar = null;
        }
        this.zzb.zzm = zzatdVar;
        if (this.zza < 4) {
            if (zzatdVar != null && zzatdVar.zzaj() && !zzatdVar.zzh().equals("0000000000000000000000000000000000000000000000000000000000000000") && zzatdVar.zzak() && zzatdVar.zzf().zze() && zzatdVar.zzf().zza() != -2) {
                return;
            }
            this.zzb.zzo(this.zza + 1, true);
        }
    }
}
