package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzebf implements zzgej {
    final /* synthetic */ zzebg zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzebf(zzebg zzebgVar) {
        this.zza = zzebgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        Pattern pattern;
        zzegc zzegcVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgj)).booleanValue()) {
            pattern = zzebg.zza;
            Matcher matcher = pattern.matcher(th.getMessage());
            if (matcher.matches()) {
                String group = matcher.group(1);
                zzegcVar = this.zza.zzf;
                zzegcVar.zzi(Integer.parseInt(group));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzegc zzegcVar;
        zzegc zzegcVar2;
        zzfgy zzfgyVar = (zzfgy) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgj)).booleanValue()) {
            zzegcVar = this.zza.zzf;
            zzegcVar.zzi(zzfgyVar.zzb.zzb.zze);
            zzegcVar2 = this.zza.zzf;
            zzegcVar2.zzj(zzfgyVar.zzb.zzb.zzf);
        }
    }
}
