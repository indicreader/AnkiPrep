package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R;
import com.google.common.net.HttpHeaders;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbvt extends zzbvw {
    private final Map zza;
    private final Context zzb;

    public zzbvt(zzcjk zzcjkVar, Map map) {
        super(zzcjkVar, "storePicture");
        this.zza = map;
        this.zzb = zzcjkVar.zzi();
    }

    public final void zzb() {
        if (this.zzb == null) {
            zzh("Activity context is not available");
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        if (!new zzbfm(this.zzb).zzc()) {
            zzh("Feature is not supported by the device.");
            return;
        }
        String str = (String) this.zza.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzh("Image url cannot be empty.");
            return;
        }
        if (URLUtil.isValidUrl(str)) {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            com.google.android.gms.ads.internal.zzt.zzp();
            if (TextUtils.isEmpty(lastPathSegment) || !lastPathSegment.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)")) {
                zzh("Image type not recognized: ".concat(String.valueOf(lastPathSegment)));
                return;
            }
            Resources zze = com.google.android.gms.ads.internal.zzt.zzo().zze();
            com.google.android.gms.ads.internal.zzt.zzp();
            AlertDialog.Builder zzJ = com.google.android.gms.ads.internal.util.zzt.zzJ(this.zzb);
            zzJ.setTitle(zze != null ? zze.getString(R.string.s1) : "Save image");
            zzJ.setMessage(zze != null ? zze.getString(R.string.s2) : "Allow Ad to store image in Picture gallery?");
            zzJ.setPositiveButton(zze != null ? zze.getString(R.string.s3) : HttpHeaders.ACCEPT, new zzbvr(this, str, lastPathSegment));
            zzJ.setNegativeButton(zze != null ? zze.getString(R.string.s4) : "Decline", new zzbvs(this));
            zzJ.create().show();
            return;
        }
        zzh("Invalid image url: ".concat(String.valueOf(str)));
    }
}
