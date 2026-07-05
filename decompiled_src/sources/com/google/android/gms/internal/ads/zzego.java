package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzego implements zzfln {
    private final zzegc zza;
    private final zzegg zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzego(zzegc zzegcVar, zzegg zzeggVar) {
        this.zza = zzegcVar;
        this.zzb = zzeggVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfln
    public final void zzbL(zzflg zzflgVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzfln
    public final void zzbM(zzflg zzflgVar, String str, Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgj)).booleanValue() && zzflg.RENDERER == zzflgVar && this.zza.zzc() != 0) {
            this.zza.zzf(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zza.zzc());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfln
    public final void zzbN(zzflg zzflgVar, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgj)).booleanValue()) {
            if (zzflg.RENDERER == zzflgVar) {
                this.zza.zzg(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime());
                return;
            }
            if (zzflg.PRELOADED_LOADER == zzflgVar || zzflg.SERVER_TRANSACTION == zzflgVar) {
                this.zza.zzh(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime());
                final zzegg zzeggVar = this.zzb;
                final long zzd = this.zza.zzd();
                zzeggVar.zza.zza(new zzfkp() { // from class: com.google.android.gms.internal.ads.zzegf
                    @Override // com.google.android.gms.internal.ads.zzfkp
                    public final Object zza(Object obj) {
                        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                        if (zzegg.this.zzf()) {
                            return null;
                        }
                        long j = zzd;
                        zzbdx zzg = zzbdy.zzg();
                        zzg.zzh(j);
                        byte[] zzax = ((zzbdy) zzg.zzal()).zzax();
                        zzegn.zzg(sQLiteDatabase, false, false);
                        zzegn.zzd(sQLiteDatabase, j, zzax);
                        return null;
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfln
    public final void zzd(zzflg zzflgVar, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgj)).booleanValue() && zzflg.RENDERER == zzflgVar && this.zza.zzc() != 0) {
            this.zza.zzf(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zza.zzc());
        }
    }
}
