package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.ads.zzcdv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzp {
    public static final zzp zza = new zzp();

    protected zzp() {
    }

    public final zzl zza(Context context, zzdx zzdxVar) {
        Context context2;
        List list;
        String str;
        String zzj = zzdxVar.zzj();
        Set zzo = zzdxVar.zzo();
        if (zzo.isEmpty()) {
            context2 = context;
            list = null;
        } else {
            list = Collections.unmodifiableList(new ArrayList(zzo));
            context2 = context;
        }
        boolean zzq = zzdxVar.zzq(context2);
        Bundle zze = zzdxVar.zze(AdMobAdapter.class);
        String zzk = zzdxVar.zzk();
        SearchAdRequest zzh = zzdxVar.zzh();
        zzfh zzfhVar = zzh != null ? new zzfh(zzh) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzay.zzb();
            str = zzcdv.zzq(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        boolean zzp = zzdxVar.zzp();
        RequestConfiguration zzc = zzej.zzf().zzc();
        return new zzl(8, -1L, zze, -1, list, zzq, Math.max(zzdxVar.zzb(), zzc.getTagForChildDirectedTreatment()), false, zzk, zzfhVar, null, zzj, zzdxVar.zzf(), zzdxVar.zzd(), Collections.unmodifiableList(new ArrayList(zzdxVar.zzn())), zzdxVar.zzl(), str, zzp, null, zzc.getTagForUnderAgeOfConsent(), (String) Collections.max(Arrays.asList(null, zzc.getMaxAdContentRating()), new Comparator() { // from class: com.google.android.gms.ads.internal.client.zzo
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return RequestConfiguration.zza.indexOf((String) obj) - RequestConfiguration.zza.indexOf((String) obj2);
            }
        }), zzdxVar.zzm(), zzdxVar.zza(), zzdxVar.zzi(), zzc.getPublisherPrivacyPersonalizationState().getValue());
    }
}
