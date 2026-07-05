package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes3.dex */
public final class zzbsb implements zzbrn {
    private final zzbrp zza;
    private final zzbrq zzb;
    private final zzbrj zzc;
    private final String zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbsb(zzbrj zzbrjVar, String str, zzbrq zzbrqVar, zzbrp zzbrpVar) {
        this.zzc = zzbrjVar;
        this.zzd = str;
        this.zzb = zzbrqVar;
        this.zza = zzbrpVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzd(zzbsb zzbsbVar, zzbrd zzbrdVar, zzbrk zzbrkVar, Object obj, zzceu zzceuVar) {
        try {
            com.google.android.gms.ads.internal.zzt.zzp();
            String uuid = UUID.randomUUID().toString();
            zzbnf.zzo.zzc(uuid, new zzbsa(zzbsbVar, zzbrdVar, zzceuVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", uuid);
            jSONObject.put("args", zzbsbVar.zzb.zzb(obj));
            zzbrkVar.zzl(zzbsbVar.zzd, jSONObject);
        } catch (Exception e) {
            try {
                zzceuVar.zzd(e);
                zzcec.zzh("Unable to invokeJavascript", e);
            } finally {
                zzbrdVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final ListenableFuture zza(Object obj) throws Exception {
        return zzb(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzbrn
    public final ListenableFuture zzb(Object obj) {
        zzceu zzceuVar = new zzceu();
        zzbrd zzb = this.zzc.zzb(null);
        com.google.android.gms.ads.internal.util.zze.zza("callJs > getEngine: Promise created");
        zzb.zzi(new zzbry(this, zzb, obj, zzceuVar), new zzbrz(this, zzceuVar, zzb));
        return zzceuVar;
    }
}
