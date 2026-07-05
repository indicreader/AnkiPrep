package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzelw implements zzein {
    private static Bundle zzd(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final ListenableFuture zza(zzfgy zzfgyVar, zzfgm zzfgmVar) {
        String optString = zzfgmVar.zzw.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzfhh zzfhhVar = zzfgyVar.zza.zza;
        zzfhf zzfhfVar = new zzfhf();
        zzfhfVar.zzp(zzfhhVar);
        zzfhfVar.zzs(optString);
        Bundle zzd = zzd(zzfhhVar.zzd.zzm);
        Bundle zzd2 = zzd(zzd.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        zzd2.putInt("gw", 1);
        String optString2 = zzfgmVar.zzw.optString("mad_hac", null);
        if (optString2 != null) {
            zzd2.putString("mad_hac", optString2);
        }
        String optString3 = zzfgmVar.zzw.optString("adJson", null);
        if (optString3 != null) {
            zzd2.putString("_ad", optString3);
        }
        zzd2.putBoolean("_noRefresh", true);
        Iterator<String> keys = zzfgmVar.zzE.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString4 = zzfgmVar.zzE.optString(next, null);
            if (next != null) {
                zzd2.putString(next, optString4);
            }
        }
        zzd.putBundle("com.google.ads.mediation.admob.AdMobAdapter", zzd2);
        com.google.android.gms.ads.internal.client.zzl zzlVar = zzfhhVar.zzd;
        Bundle bundle = zzlVar.zzn;
        List list = zzlVar.zzo;
        String str = zzlVar.zzp;
        int i = zzlVar.zzd;
        String str2 = zzlVar.zzq;
        List list2 = zzlVar.zze;
        boolean z = zzlVar.zzr;
        boolean z2 = zzlVar.zzf;
        com.google.android.gms.ads.internal.client.zzc zzcVar = zzlVar.zzs;
        int i2 = zzlVar.zzg;
        int i3 = zzlVar.zzt;
        boolean z3 = zzlVar.zzh;
        String str3 = zzlVar.zzu;
        String str4 = zzlVar.zzi;
        List list3 = zzlVar.zzv;
        zzfhfVar.zzE(new com.google.android.gms.ads.internal.client.zzl(zzlVar.zza, zzlVar.zzb, zzd2, i, list2, z2, i2, z3, str4, zzlVar.zzj, zzlVar.zzk, zzlVar.zzl, zzd, bundle, list, str, str2, z, zzcVar, i3, str3, list3, zzlVar.zzw, zzlVar.zzx, zzlVar.zzy));
        zzfhh zzG = zzfhfVar.zzG();
        Bundle bundle2 = new Bundle();
        zzfgp zzfgpVar = zzfgyVar.zzb.zzb;
        Bundle bundle3 = new Bundle();
        bundle3.putStringArrayList("nofill_urls", new ArrayList<>(zzfgpVar.zza));
        bundle3.putInt("refresh_interval", zzfgpVar.zzc);
        bundle3.putString("gws_query_id", zzfgpVar.zzb);
        bundle2.putBundle("parent_common_config", bundle3);
        zzfhh zzfhhVar2 = zzfgyVar.zza.zza;
        Bundle bundle4 = new Bundle();
        bundle4.putString("initial_ad_unit_id", zzfhhVar2.zzf);
        bundle4.putString("allocation_id", zzfgmVar.zzx);
        bundle4.putStringArrayList("click_urls", new ArrayList<>(zzfgmVar.zzc));
        bundle4.putStringArrayList("imp_urls", new ArrayList<>(zzfgmVar.zzd));
        bundle4.putStringArrayList("manual_tracking_urls", new ArrayList<>(zzfgmVar.zzq));
        bundle4.putStringArrayList("fill_urls", new ArrayList<>(zzfgmVar.zzn));
        bundle4.putStringArrayList("video_start_urls", new ArrayList<>(zzfgmVar.zzh));
        bundle4.putStringArrayList("video_reward_urls", new ArrayList<>(zzfgmVar.zzi));
        bundle4.putStringArrayList("video_complete_urls", new ArrayList<>(zzfgmVar.zzj));
        bundle4.putString("transaction_id", zzfgmVar.zzk);
        bundle4.putString("valid_from_timestamp", zzfgmVar.zzl);
        bundle4.putBoolean("is_closable_area_disabled", zzfgmVar.zzQ);
        bundle4.putString("recursive_server_response_data", zzfgmVar.zzap);
        if (zzfgmVar.zzm != null) {
            Bundle bundle5 = new Bundle();
            bundle5.putInt("rb_amount", zzfgmVar.zzm.zzb);
            bundle5.putString("rb_type", zzfgmVar.zzm.zza);
            bundle4.putParcelableArray("rewards", new Bundle[]{bundle5});
        }
        bundle2.putBundle("parent_ad_config", bundle4);
        return zzc(zzG, bundle2, zzfgmVar, zzfgyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final boolean zzb(zzfgy zzfgyVar, zzfgm zzfgmVar) {
        return !TextUtils.isEmpty(zzfgmVar.zzw.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    protected abstract ListenableFuture zzc(zzfhh zzfhhVar, Bundle bundle, zzfgm zzfgmVar, zzfgy zzfgyVar);
}
