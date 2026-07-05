package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfqd implements zzfpd {
    private static final zzfqd zza = new zzfqd();
    private static final Handler zzb = new Handler(Looper.getMainLooper());
    private static Handler zzc = null;
    private static final Runnable zzd = new zzfpz();
    private static final Runnable zze = new zzfqa();
    private int zzg;
    private long zzm;
    private final List zzf = new ArrayList();
    private boolean zzh = false;
    private final List zzi = new ArrayList();
    private final zzfpw zzk = new zzfpw();
    private final zzfpf zzj = new zzfpf();
    private final zzfpx zzl = new zzfpx(new zzfqg());

    zzfqd() {
    }

    public static zzfqd zzd() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzg(zzfqd zzfqdVar) {
        zzfqdVar.zzg = 0;
        zzfqdVar.zzi.clear();
        zzfqdVar.zzh = false;
        for (zzfoh zzfohVar : zzfov.zza().zzb()) {
        }
        zzfqdVar.zzm = System.nanoTime();
        zzfqdVar.zzk.zzi();
        long nanoTime = System.nanoTime();
        zzfpe zza2 = zzfqdVar.zzj.zza();
        if (zzfqdVar.zzk.zze().size() > 0) {
            Iterator it = zzfqdVar.zzk.zze().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                JSONObject zza3 = zza2.zza(null);
                View zza4 = zzfqdVar.zzk.zza(str);
                zzfpe zzb2 = zzfqdVar.zzj.zzb();
                String zzc2 = zzfqdVar.zzk.zzc(str);
                if (zzc2 != null) {
                    JSONObject zza5 = zzb2.zza(zza4);
                    zzfpo.zzb(zza5, str);
                    try {
                        zza5.put("notVisibleReason", zzc2);
                    } catch (JSONException e) {
                        zzfpp.zza("Error with setting not visible reason", e);
                    }
                    zzfpo.zzc(zza3, zza5);
                }
                zzfpo.zzf(zza3);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                zzfqdVar.zzl.zzc(zza3, hashSet, nanoTime);
            }
        }
        if (zzfqdVar.zzk.zzf().size() > 0) {
            JSONObject zza6 = zza2.zza(null);
            zzfqdVar.zzk(null, zza2, zza6, 1, false);
            zzfpo.zzf(zza6);
            zzfqdVar.zzl.zzd(zza6, zzfqdVar.zzk.zzf(), nanoTime);
            boolean z = zzfqdVar.zzh;
        } else {
            zzfqdVar.zzl.zzb();
        }
        zzfqdVar.zzk.zzg();
        long nanoTime2 = System.nanoTime() - zzfqdVar.zzm;
        if (zzfqdVar.zzf.size() > 0) {
            for (zzfqc zzfqcVar : zzfqdVar.zzf) {
                int i = zzfqdVar.zzg;
                TimeUnit.NANOSECONDS.toMillis(nanoTime2);
                zzfqcVar.zzb();
                if (zzfqcVar instanceof zzfqb) {
                    int i2 = zzfqdVar.zzg;
                    ((zzfqb) zzfqcVar).zza();
                }
            }
        }
    }

    private final void zzk(View view, zzfpe zzfpeVar, JSONObject jSONObject, int i, boolean z) {
        zzfpeVar.zzb(view, jSONObject, this, i == 1, z);
    }

    private static final void zzl() {
        Handler handler = zzc;
        if (handler != null) {
            handler.removeCallbacks(zze);
            zzc = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfpd
    public final void zza(View view, zzfpe zzfpeVar, JSONObject jSONObject, boolean z) {
        int zzk;
        boolean z2;
        if (zzfpu.zza(view) != null || (zzk = this.zzk.zzk(view)) == 3) {
            return;
        }
        JSONObject zza2 = zzfpeVar.zza(view);
        zzfpo.zzc(jSONObject, zza2);
        String zzd2 = this.zzk.zzd(view);
        if (zzd2 == null) {
            zzfpv zzb2 = this.zzk.zzb(view);
            if (zzb2 != null) {
                zzfoy zza3 = zzb2.zza();
                JSONArray jSONArray = new JSONArray();
                ArrayList zzb3 = zzb2.zzb();
                int size = zzb3.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put((String) zzb3.get(i));
                }
                try {
                    zza2.put("isFriendlyObstructionFor", jSONArray);
                    zza2.put("friendlyObstructionClass", zza3.zzd());
                    zza2.put("friendlyObstructionPurpose", zza3.zza());
                    zza2.put("friendlyObstructionReason", zza3.zzc());
                } catch (JSONException e) {
                    zzfpp.zza("Error with setting friendly obstruction", e);
                }
                z2 = true;
            } else {
                z2 = false;
            }
            zzk(view, zzfpeVar, zza2, zzk, z || z2);
        } else {
            zzfpo.zzb(zza2, zzd2);
            try {
                zza2.put("hasWindowFocus", Boolean.valueOf(this.zzk.zzj(view)));
            } catch (JSONException e2) {
                zzfpp.zza("Error with setting has window focus", e2);
            }
            this.zzk.zzh();
        }
        this.zzg++;
    }

    public final void zzh() {
        zzl();
    }

    public final void zzi() {
        if (zzc == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            zzc = handler;
            handler.post(zzd);
            zzc.postDelayed(zze, 200L);
        }
    }

    public final void zzj() {
        zzl();
        this.zzf.clear();
        zzb.post(new zzfpy(this));
    }
}
