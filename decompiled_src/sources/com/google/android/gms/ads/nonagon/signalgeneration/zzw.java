package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import coil.disk.DiskLruCache;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbht;
import com.google.android.gms.internal.ads.zzccq;
import com.google.android.gms.internal.ads.zzccx;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzcei;
import com.google.android.gms.internal.ads.zzdwa;
import com.google.android.gms.internal.ads.zzdwk;
import com.google.android.gms.internal.ads.zzfmo;
import com.google.android.gms.internal.ads.zzfmz;
import com.google.android.gms.internal.ads.zzgej;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzw implements zzgej {
    final /* synthetic */ ListenableFuture zza;
    final /* synthetic */ zzccx zzb;
    final /* synthetic */ zzccq zzc;
    final /* synthetic */ zzfmo zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ zzaa zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzw(zzaa zzaaVar, ListenableFuture listenableFuture, zzccx zzccxVar, zzccq zzccqVar, zzfmo zzfmoVar, long j) {
        this.zza = listenableFuture;
        this.zzb = zzccxVar;
        this.zzc = zzccqVar;
        this.zzd = zzfmoVar;
        this.zze = j;
        this.zzf = zzaaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        zzdwk zzdwkVar;
        zzdwa zzdwaVar;
        long currentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - this.zze;
        String message = th.getMessage();
        com.google.android.gms.ads.internal.zzt.zzo().zzw(th, "SignalGeneratorImpl.generateSignals");
        zzaa zzaaVar = this.zzf;
        zzdwkVar = zzaaVar.zzs;
        zzdwaVar = zzaaVar.zzk;
        zzf.zzc(zzdwkVar, zzdwaVar, "sgf", new Pair("sgf_reason", message), new Pair("tqgt", String.valueOf(currentTimeMillis)));
        zzfmz zzs = zzaa.zzs(this.zza, this.zzb);
        if (((Boolean) zzbht.zze.zze()).booleanValue() && zzs != null) {
            zzfmo zzfmoVar = this.zzd;
            zzfmoVar.zzg(th);
            zzfmoVar.zzf(false);
            zzs.zza(zzfmoVar);
            zzs.zzg();
        }
        try {
            if (!"Unknown format is no longer supported.".equals(message)) {
                message = "Internal error. " + message;
            }
            this.zzc.zzb(message);
        } catch (RemoteException e) {
            zzcec.zzh("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        AtomicBoolean atomicBoolean;
        zzdwk zzdwkVar;
        zzdwa zzdwaVar;
        zzdwa zzdwaVar2;
        boolean z;
        boolean z2;
        zzdwk zzdwkVar2;
        zzdwa zzdwaVar3;
        String str;
        String str2;
        String str3;
        String str4;
        Context context;
        zzcei zzceiVar;
        String str5;
        String str6;
        AtomicInteger atomicInteger;
        zzdwk zzdwkVar3;
        zzdwa zzdwaVar4;
        zzdwk zzdwkVar4;
        zzdwa zzdwaVar5;
        zzam zzamVar = (zzam) obj;
        zzfmz zzs = zzaa.zzs(this.zza, this.zzb);
        atomicBoolean = this.zzf.zzJ;
        atomicBoolean.set(true);
        if (!((Boolean) zzba.zzc().zza(zzbgc.zzhD)).booleanValue()) {
            try {
                this.zzc.zzb("QueryInfo generation has been disabled.");
            } catch (RemoteException e) {
                zzcec.zzg("QueryInfo generation has been disabled.".concat(e.toString()));
            }
            if (!((Boolean) zzbht.zze.zze()).booleanValue() || zzs == null) {
                return;
            }
            zzfmo zzfmoVar = this.zzd;
            zzfmoVar.zzc("QueryInfo generation has been disabled.");
            zzfmoVar.zzf(false);
            zzs.zza(zzfmoVar);
            zzs.zzg();
            return;
        }
        long currentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - this.zze;
        try {
            try {
                if (zzamVar == null) {
                    this.zzc.zzc(null, null, null);
                    zzaa zzaaVar = this.zzf;
                    zzdwkVar4 = zzaaVar.zzs;
                    zzdwaVar5 = zzaaVar.zzk;
                    zzf.zzc(zzdwkVar4, zzdwaVar5, "sgs", new Pair("rid", "-1"));
                    this.zzd.zzf(true);
                    if (!((Boolean) zzbht.zze.zze()).booleanValue() || zzs == null) {
                        return;
                    }
                    zzs.zza(this.zzd);
                    zzs.zzg();
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(zzamVar.zzb);
                    String optString = jSONObject.optString("request_id", "");
                    if (TextUtils.isEmpty(optString)) {
                        zzcec.zzj("The request ID is empty in request JSON.");
                        this.zzc.zzb("Internal error: request ID is empty in request JSON.");
                        zzaa zzaaVar2 = this.zzf;
                        zzdwkVar3 = zzaaVar2.zzs;
                        zzdwaVar4 = zzaaVar2.zzk;
                        zzf.zzc(zzdwkVar3, zzdwaVar4, "sgf", new Pair("sgf_reason", "rid_missing"));
                        zzfmo zzfmoVar2 = this.zzd;
                        zzfmoVar2.zzc("Request ID empty");
                        zzfmoVar2.zzf(false);
                        if (!((Boolean) zzbht.zze.zze()).booleanValue() || zzs == null) {
                            return;
                        }
                        zzs.zza(this.zzd);
                        zzs.zzg();
                        return;
                    }
                    zzaa zzaaVar3 = this.zzf;
                    String str7 = zzamVar.zzb;
                    zzdwaVar2 = zzaaVar3.zzk;
                    zzaa.zzK(zzaaVar3, optString, str7, zzdwaVar2);
                    Bundle bundle = zzamVar.zzc;
                    zzaa zzaaVar4 = this.zzf;
                    z = zzaaVar4.zzx;
                    if (z && bundle != null) {
                        str5 = zzaaVar4.zzz;
                        if (bundle.getInt(str5, -1) == -1) {
                            zzaa zzaaVar5 = this.zzf;
                            str6 = zzaaVar5.zzz;
                            atomicInteger = zzaaVar5.zzA;
                            bundle.putInt(str6, atomicInteger.get());
                        }
                    }
                    zzaa zzaaVar6 = this.zzf;
                    z2 = zzaaVar6.zzw;
                    if (z2 && bundle != null) {
                        str = zzaaVar6.zzy;
                        if (TextUtils.isEmpty(bundle.getString(str))) {
                            str2 = this.zzf.zzC;
                            if (TextUtils.isEmpty(str2)) {
                                zzaa zzaaVar7 = this.zzf;
                                com.google.android.gms.ads.internal.util.zzt zzp = com.google.android.gms.ads.internal.zzt.zzp();
                                zzaa zzaaVar8 = this.zzf;
                                context = zzaaVar8.zzg;
                                zzceiVar = zzaaVar8.zzB;
                                zzaaVar7.zzC = zzp.zzc(context, zzceiVar.zza);
                            }
                            zzaa zzaaVar9 = this.zzf;
                            str3 = zzaaVar9.zzy;
                            str4 = zzaaVar9.zzC;
                            bundle.putString(str3, str4);
                        }
                    }
                    this.zzc.zzc(zzamVar.zza, zzamVar.zzb, bundle);
                    zzaa zzaaVar10 = this.zzf;
                    zzdwkVar2 = zzaaVar10.zzs;
                    zzdwaVar3 = zzaaVar10.zzk;
                    Pair[] pairArr = new Pair[2];
                    pairArr[0] = new Pair("tqgt", String.valueOf(currentTimeMillis));
                    String str8 = "na";
                    if (((Boolean) zzba.zzc().zza(zzbgc.zzju)).booleanValue()) {
                        try {
                            str8 = jSONObject.getJSONObject("extras").getBoolean("accept_3p_cookie") ? DiskLruCache.VERSION : "0";
                        } catch (JSONException e2) {
                            zzcec.zzh("Error retrieving JSONObject from the requestJson, ", e2);
                        }
                    }
                    pairArr[1] = new Pair("tpc", str8);
                    zzf.zzc(zzdwkVar2, zzdwaVar3, "sgs", pairArr);
                    this.zzd.zzf(true);
                    if (!((Boolean) zzbht.zze.zze()).booleanValue() || zzs == null) {
                        return;
                    }
                    zzs.zza(this.zzd);
                    zzs.zzg();
                } catch (JSONException e3) {
                    zzcec.zzj("Failed to create JSON object from the request string.");
                    this.zzc.zzb("Internal error for request JSON: " + e3.toString());
                    zzaa zzaaVar11 = this.zzf;
                    zzdwkVar = zzaaVar11.zzs;
                    zzdwaVar = zzaaVar11.zzk;
                    zzf.zzc(zzdwkVar, zzdwaVar, "sgf", new Pair("sgf_reason", "request_invalid"));
                    zzfmo zzfmoVar3 = this.zzd;
                    zzfmoVar3.zzg(e3);
                    zzfmoVar3.zzf(false);
                    com.google.android.gms.ads.internal.zzt.zzo().zzw(e3, "SignalGeneratorImpl.generateSignals.onSuccess");
                    if (!((Boolean) zzbht.zze.zze()).booleanValue() || zzs == null) {
                        return;
                    }
                    zzs.zza(this.zzd);
                    zzs.zzg();
                }
            } catch (Throwable th) {
                if (((Boolean) zzbht.zze.zze()).booleanValue() && zzs != null) {
                    zzs.zza(this.zzd);
                    zzs.zzg();
                }
                throw th;
            }
        } catch (RemoteException e4) {
            zzfmo zzfmoVar4 = this.zzd;
            zzfmoVar4.zzg(e4);
            zzfmoVar4.zzf(false);
            zzcec.zzh("", e4);
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e4, "SignalGeneratorImpl.generateSignals.onSuccess");
            if (!((Boolean) zzbht.zze.zze()).booleanValue() || zzs == null) {
                return;
            }
            zzs.zza(this.zzd);
            zzs.zzg();
        }
    }
}
