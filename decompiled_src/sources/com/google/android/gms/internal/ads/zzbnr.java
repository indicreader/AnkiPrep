package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import coil.disk.DiskLruCache;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbnr implements zzbng {
    private final com.google.android.gms.ads.internal.zzb zza;
    private final zzdwf zzb;
    private final zzflw zzc;
    private final zzbvq zze;
    private final zzehh zzf;
    private final zzcse zzg;
    private com.google.android.gms.ads.internal.overlay.zzy zzh = null;
    private final zzgey zzi = zzcep.zzf;
    private final zzceh zzd = new zzceh(null);

    public zzbnr(com.google.android.gms.ads.internal.zzb zzbVar, zzbvq zzbvqVar, zzehh zzehhVar, zzdwf zzdwfVar, zzflw zzflwVar, zzcse zzcseVar) {
        this.zza = zzbVar;
        this.zze = zzbvqVar;
        this.zzf = zzehhVar;
        this.zzb = zzdwfVar;
        this.zzc = zzflwVar;
        this.zzg = zzcseVar;
    }

    public static int zzb(Map map) {
        String str = (String) map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        return "c".equalsIgnoreCase(str) ? 14 : -1;
    }

    static Uri zzc(Context context, zzavi zzaviVar, Uri uri, View view, Activity activity, zzfhl zzfhlVar) {
        if (zzaviVar == null) {
            return uri;
        }
        try {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlr)).booleanValue() && zzfhlVar != null) {
                if (zzaviVar.zze(uri)) {
                    uri = zzfhlVar.zza(uri, context, view, activity);
                }
            } else if (zzaviVar.zze(uri)) {
                uri = zzaviVar.zza(uri, context, view, activity);
            }
        } catch (zzavj unused) {
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
        }
        return uri;
    }

    static Uri zzd(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            zzcec.zzh("Error adding click uptime parameter to url: ".concat(String.valueOf(uri.toString())), e);
        }
        return uri;
    }

    public static boolean zzf(Map map) {
        return DiskLruCache.VERSION.equals(map.get("custom_close"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzh(String str, com.google.android.gms.ads.internal.client.zza zzaVar, Map map, String str2) {
        String str3;
        boolean z;
        Object obj;
        Object obj2;
        HashMap hashMap;
        boolean z2;
        zzcjk zzcjkVar = (zzcjk) zzaVar;
        zzfgm zzD = zzcjkVar.zzD();
        zzfgp zzP = zzcjkVar.zzP();
        boolean z3 = false;
        if (zzD == null || zzP == null) {
            str3 = "";
            z = false;
        } else {
            String str4 = zzP.zzb;
            z = zzD.zzaj;
            str3 = str4;
        }
        boolean z4 = (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkk)).booleanValue() && map.containsKey("sc") && ((String) map.get("sc")).equals("0")) ? false : true;
        if ("expand".equalsIgnoreCase(str2)) {
            if (zzcjkVar.zzaC()) {
                zzcec.zzj("Cannot expand WebView that is already expanded.");
                return;
            } else {
                zzk(false);
                ((zzckq) zzaVar).zzaH(zzf(map), zzb(map), z4);
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(str2)) {
            zzk(false);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlm)).booleanValue() && Objects.equals(map.get("is_allowed_for_lock_screen"), DiskLruCache.VERSION)) {
                z3 = true;
            }
            if (str != null) {
                ((zzckq) zzaVar).zzaJ(zzf(map), zzb(map), str, z4, z3);
                return;
            } else {
                ((zzckq) zzaVar).zzaI(zzf(map), zzb(map), (String) map.get("html"), (String) map.get("baseurl"), z4);
                return;
            }
        }
        if ("chrome_custom_tab".equalsIgnoreCase(str2)) {
            zzcjkVar.getContext();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzew)).booleanValue()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeA)).booleanValue()) {
                    com.google.android.gms.ads.internal.util.zze.zza("User opt out chrome custom tab.");
                } else {
                    z3 = true;
                }
            }
            boolean zzg = zzbhd.zzg(zzcjkVar.getContext());
            if (z3) {
                if (!zzg) {
                    zzm(4);
                } else {
                    zzk(true);
                    if (TextUtils.isEmpty(str)) {
                        zzcec.zzj("Cannot open browser with null or empty url");
                        zzm(7);
                        return;
                    }
                    Uri zzd = zzd(zzc(zzcjkVar.getContext(), zzcjkVar.zzI(), Uri.parse(str), zzcjkVar.zzF(), zzcjkVar.zzi(), zzcjkVar.zzQ()));
                    if (z && this.zzf != null && zzl(zzaVar, zzcjkVar.getContext(), zzd.toString(), str3)) {
                        return;
                    }
                    this.zzh = new zzbno(this);
                    ((zzckq) zzaVar).zzaF(new com.google.android.gms.ads.internal.overlay.zzc(null, zzd.toString(), null, null, null, null, null, null, ObjectWrapper.wrap(this.zzh).asBinder(), true), z4);
                    return;
                }
            }
            map.put("use_first_package", "true");
            map.put("use_running_process", "true");
            zzj(zzaVar, map, z, str3, z4);
            return;
        }
        if (!"app".equalsIgnoreCase(str2) || !"true".equalsIgnoreCase((String) map.get("system_browser"))) {
            if ("open_app".equalsIgnoreCase(str2)) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzid)).booleanValue()) {
                    zzk(true);
                    String str5 = (String) map.get("p");
                    if (str5 == null) {
                        zzcec.zzj("Package name missing from open app action.");
                        return;
                    }
                    if (z && this.zzf != null && zzl(zzaVar, zzcjkVar.getContext(), str5, str3)) {
                        return;
                    }
                    PackageManager packageManager = zzcjkVar.getContext().getPackageManager();
                    if (packageManager == null) {
                        zzcec.zzj("Cannot get package manager from open app action.");
                        return;
                    }
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str5);
                    if (launchIntentForPackage != null) {
                        ((zzckq) zzaVar).zzaF(new com.google.android.gms.ads.internal.overlay.zzc(launchIntentForPackage, this.zzh), z4);
                        return;
                    }
                    return;
                }
                return;
            }
            zzk(true);
            String str6 = (String) map.get("intent_url");
            Intent intent = null;
            if (!TextUtils.isEmpty(str6)) {
                try {
                    intent = Intent.parseUri(str6, 0);
                } catch (URISyntaxException e) {
                    zzcec.zzh("Error parsing the url: ".concat(String.valueOf(str6)), e);
                }
            }
            Intent intent2 = intent;
            if (intent2 != null && intent2.getData() != null) {
                Uri data = intent2.getData();
                if (!Uri.EMPTY.equals(data)) {
                    Uri zzd2 = zzd(zzc(zzcjkVar.getContext(), zzcjkVar.zzI(), data, zzcjkVar.zzF(), zzcjkVar.zzi(), zzcjkVar.zzQ()));
                    if (!TextUtils.isEmpty(intent2.getType())) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzie)).booleanValue()) {
                            intent2.setDataAndType(zzd2, intent2.getType());
                        }
                    }
                    intent2.setData(zzd2);
                }
            }
            boolean z5 = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziv)).booleanValue() && "intent_async".equalsIgnoreCase(str2) && map.containsKey("event_id");
            HashMap hashMap2 = new HashMap();
            if (z5) {
                obj = "event_id";
                obj2 = "p";
                hashMap = hashMap2;
                this.zzh = new zzbnp(this, z4, zzaVar, hashMap2, map);
                z2 = false;
            } else {
                obj = "event_id";
                obj2 = "p";
                hashMap = hashMap2;
                z2 = z4;
            }
            if (intent2 != null) {
                if (!z || this.zzf == null || !zzl(zzaVar, zzcjkVar.getContext(), intent2.getData().toString(), str3)) {
                    ((zzckq) zzaVar).zzaF(new com.google.android.gms.ads.internal.overlay.zzc(intent2, this.zzh), z2);
                    return;
                } else {
                    if (z5) {
                        hashMap.put((String) map.get(obj), true);
                        ((zzbqa) zzaVar).zzd("openIntentAsync", hashMap);
                        return;
                    }
                    return;
                }
            }
            String uri = !TextUtils.isEmpty(str) ? zzd(zzc(zzcjkVar.getContext(), zzcjkVar.zzI(), Uri.parse(str), zzcjkVar.zzF(), zzcjkVar.zzi(), zzcjkVar.zzQ())).toString() : str;
            if (!z || this.zzf == null || !zzl(zzaVar, zzcjkVar.getContext(), uri, str3)) {
                ((zzckq) zzaVar).zzaF(new com.google.android.gms.ads.internal.overlay.zzc((String) map.get("i"), uri, (String) map.get("m"), (String) map.get(obj2), (String) map.get("c"), (String) map.get("f"), (String) map.get("e"), this.zzh), z2);
                return;
            } else {
                if (z5) {
                    hashMap.put((String) map.get(obj), true);
                    ((zzbqa) zzaVar).zzd("openIntentAsync", hashMap);
                    return;
                }
                return;
            }
        }
        zzj(zzaVar, map, z, str3, z4);
    }

    private final void zzi(Context context, String str, String str2) {
        this.zzf.zzc(str);
        zzdwf zzdwfVar = this.zzb;
        if (zzdwfVar != null) {
            zzehs.zzc(context, zzdwfVar, this.zzc, this.zzf, str, "dialog_not_shown", zzgad.zze("dialog_not_shown_reason", str2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0105, code lost:
    
        if (com.google.android.gms.internal.ads.zzbnq.zzc(r2, r11, r12, r13, r14) == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0152, code lost:
    
        r21 = r6;
        r10 = r15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzj(com.google.android.gms.ads.internal.client.zza r20, java.util.Map r21, boolean r22, java.lang.String r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbnr.zzj(com.google.android.gms.ads.internal.client.zza, java.util.Map, boolean, java.lang.String, boolean):void");
    }

    private final void zzk(boolean z) {
        zzbvq zzbvqVar = this.zze;
        if (zzbvqVar != null) {
            zzbvqVar.zza(z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0091, code lost:
    
        if (r2 != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zzl(com.google.android.gms.ads.internal.client.zza r9, android.content.Context r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbnr.zzl(com.google.android.gms.ads.internal.client.zza, android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzm(int i) {
        if (this.zzb == null) {
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziz)).booleanValue()) {
            zzflw zzflwVar = this.zzc;
            String zza = zzbhc.zza(i);
            zzflv zzb = zzflv.zzb("cct_action");
            zzb.zza("cct_open_status", zza);
            zzflwVar.zzb(zzb);
            return;
        }
        zzdwe zza2 = this.zzb.zza();
        zza2.zzb("action", "cct_action");
        zza2.zzb("cct_open_status", zzbhc.zza(i));
        zza2.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        ListenableFuture zzh;
        com.google.android.gms.ads.internal.client.zza zzaVar = (com.google.android.gms.ads.internal.client.zza) obj;
        String zzc = zzccj.zzc((String) map.get("u"), ((zzcjk) zzaVar).getContext(), true);
        String str = (String) map.get("a");
        if (str == null) {
            zzcec.zzj("Action missing from an open GMSG.");
            return;
        }
        com.google.android.gms.ads.internal.zzb zzbVar = this.zza;
        if (zzbVar == null || zzbVar.zzc()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjL)).booleanValue() || this.zzg == null || !zzcse.zzh(zzc)) {
                zzh = zzgen.zzh(zzc);
            } else {
                zzh = this.zzg.zzb(zzc, com.google.android.gms.ads.internal.client.zzay.zze());
            }
            zzgen.zzr(zzh, new zzbnn(this, zzaVar, map, str), this.zzi);
            return;
        }
        zzbVar.zzb(zzc);
    }
}
