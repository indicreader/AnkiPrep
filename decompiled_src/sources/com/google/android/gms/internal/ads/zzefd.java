package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzefd implements zzfkp {
    private static final Pattern zza = Pattern.compile("([^;]+=[^;]+)(;\\s|$)", 2);
    private final String zzb;
    private final zzfmo zzc;
    private final zzfmz zzd;

    public zzefd(String str, zzfmz zzfmzVar, zzfmo zzfmoVar) {
        this.zzb = str;
        this.zzd = zzfmzVar;
        this.zzc = zzfmoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfkp
    public final /* bridge */ /* synthetic */ Object zza(Object obj) throws Exception {
        JSONObject jSONObject;
        zzbzh zzbzhVar;
        zzead zzeadVar;
        zzbzh zzbzhVar2;
        zzbzh zzbzhVar3;
        zzbzh zzbzhVar4;
        zzbzh zzbzhVar5;
        zzbzh zzbzhVar6;
        zzbzh zzbzhVar7;
        zzbzh zzbzhVar8;
        JSONObject jSONObject2;
        String str;
        zzefc zzefcVar = (zzefc) obj;
        jSONObject = zzefcVar.zza;
        int optInt = jSONObject.optInt("http_timeout_millis", 60000);
        zzbzhVar = zzefcVar.zzb;
        String str2 = "";
        if (zzbzhVar.zza() == -2) {
            HashMap hashMap = new HashMap();
            zzbzhVar2 = zzefcVar.zzb;
            if (zzbzhVar2.zzh() && !TextUtils.isEmpty(this.zzb)) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaO)).booleanValue()) {
                    String str3 = this.zzb;
                    if (TextUtils.isEmpty(str3)) {
                        str = "";
                    } else {
                        Matcher matcher = zza.matcher(str3);
                        str = "";
                        while (matcher.find()) {
                            String group = matcher.group(1);
                            if (group != null && (group.toLowerCase(Locale.ROOT).startsWith("id=") || group.toLowerCase(Locale.ROOT).startsWith("ide="))) {
                                if (!TextUtils.isEmpty(str)) {
                                    str = str.concat("; ");
                                }
                                str = str.concat(group);
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        hashMap.put(HttpHeaders.COOKIE, str);
                    }
                } else {
                    hashMap.put(HttpHeaders.COOKIE, this.zzb);
                }
            }
            zzbzhVar3 = zzefcVar.zzb;
            if (zzbzhVar3.zzi()) {
                jSONObject2 = zzefcVar.zza;
                zzefe.zza(hashMap, jSONObject2);
            }
            zzbzhVar4 = zzefcVar.zzb;
            if (zzbzhVar4 != null) {
                zzbzhVar7 = zzefcVar.zzb;
                if (!TextUtils.isEmpty(zzbzhVar7.zzd())) {
                    zzbzhVar8 = zzefcVar.zzb;
                    str2 = zzbzhVar8.zzd();
                }
            }
            zzfmz zzfmzVar = this.zzd;
            zzfmo zzfmoVar = this.zzc;
            zzfmoVar.zzf(true);
            zzfmzVar.zza(zzfmoVar);
            zzbzhVar5 = zzefcVar.zzb;
            String zze = zzbzhVar5.zze();
            byte[] bytes = str2.getBytes(zzfwq.zzc);
            zzbzhVar6 = zzefcVar.zzb;
            return new zzeey(zze, optInt, hashMap, bytes, "", zzbzhVar6.zzi());
        }
        if (zzbzhVar.zza() == 1) {
            if (zzbzhVar.zzf() != null) {
                str2 = TextUtils.join(", ", zzbzhVar.zzf());
                zzcec.zzg(str2);
            }
            zzeadVar = new zzead(2, "Error building request URL: ".concat(String.valueOf(str2)));
        } else {
            zzeadVar = new zzead(1);
        }
        zzfmz zzfmzVar2 = this.zzd;
        zzfmo zzfmoVar2 = this.zzc;
        zzfmoVar2.zzg(zzeadVar);
        zzfmoVar2.zzf(false);
        zzfmzVar2.zza(zzfmoVar2);
        throw zzeadVar;
    }
}
