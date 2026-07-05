package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import coil.disk.DiskLruCache;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.Objects;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes3.dex */
public final class zzcfz extends FrameLayout implements zzcfq {
    final zzcgn zza;
    private final zzcgl zzb;
    private final FrameLayout zzc;
    private final View zzd;
    private final zzbgu zze;
    private final long zzf;
    private final zzcfr zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private String zzn;
    private String[] zzo;
    private Bitmap zzp;
    private final ImageView zzq;
    private boolean zzr;

    public zzcfz(Context context, zzcgl zzcglVar, int i, boolean z, zzbgu zzbguVar, zzcgk zzcgkVar) {
        super(context);
        zzcfr zzcfpVar;
        this.zzb = zzcglVar;
        this.zze = zzbguVar;
        FrameLayout frameLayout = new FrameLayout(context);
        this.zzc = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzcglVar.zzj());
        zzcfs zzcfsVar = zzcglVar.zzj().zza;
        zzcgm zzcgmVar = new zzcgm(context, zzcglVar.zzn(), zzcglVar.zzbr(), zzbguVar, zzcglVar.zzk());
        if (i != 2) {
            zzcfpVar = new zzcfp(context, zzcglVar, z, zzcgd.zza(zzcglVar), zzcgkVar, new zzcgm(context, zzcglVar.zzn(), zzcglVar.zzbr(), zzbguVar, zzcglVar.zzk()));
        } else {
            zzcfpVar = new zzchd(context, zzcgmVar, zzcglVar, z, zzcgd.zza(zzcglVar), zzcgkVar);
        }
        this.zzg = zzcfpVar;
        View view = new View(context);
        this.zzd = view;
        view.setBackgroundColor(0);
        frameLayout.addView(zzcfpVar, new FrameLayout.LayoutParams(-1, -1, 17));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzF)).booleanValue()) {
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(view);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzC)).booleanValue()) {
            zzn();
        }
        this.zzq = new ImageView(context);
        this.zzf = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzI)).longValue();
        boolean booleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzE)).booleanValue();
        this.zzk = booleanValue;
        if (zzbguVar != null) {
            zzbguVar.zzd("spinner_used", true != booleanValue ? "0" : DiskLruCache.VERSION);
        }
        this.zza = new zzcgn(this);
        zzcfpVar.zzr(this);
    }

    private final void zzJ() {
        if (this.zzb.zzi() == null || !this.zzi || this.zzj) {
            return;
        }
        this.zzb.zzi().getWindow().clearFlags(128);
        this.zzi = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzK(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        Integer zzl = zzl();
        if (zzl != null) {
            hashMap.put("playerId", zzl.toString());
        }
        hashMap.put(NotificationCompat.CATEGORY_EVENT, str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.zzb.zzd("onVideoEvent", hashMap);
    }

    private final boolean zzL() {
        return this.zzq.getParent() != null;
    }

    public final void finalize() throws Throwable {
        try {
            this.zza.zza();
            final zzcfr zzcfrVar = this.zzg;
            if (zzcfrVar != null) {
                zzgey zzgeyVar = zzcep.zze;
                Objects.requireNonNull(zzcfrVar);
                zzgeyVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcft
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcfr.this.zzt();
                    }
                });
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(final boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.zza.zzb();
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfv
            @Override // java.lang.Runnable
            public final void run() {
                zzcfz.this.zzq(z);
            }
        });
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzcfq
    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.zza.zzb();
            z = true;
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
            z = false;
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcfy(this, z));
    }

    public final void zzA(int i) {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzz(i);
    }

    public final void zzB(int i) {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzA(i);
    }

    public final void zzC(int i) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzF)).booleanValue()) {
            this.zzc.setBackgroundColor(i);
            this.zzd.setBackgroundColor(i);
        }
    }

    public final void zzD(int i) {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzB(i);
    }

    public final void zzE(String str, String[] strArr) {
        this.zzn = str;
        this.zzo = strArr;
    }

    public final void zzF(int i, int i2, int i3, int i4) {
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Set video bounds to x:" + i + ";y:" + i2 + ";w:" + i3 + ";h:" + i4);
        }
        if (i3 == 0 || i4 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        this.zzc.setLayoutParams(layoutParams);
        requestLayout();
    }

    public final void zzG(float f) {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzb.zze(f);
        zzcfrVar.zzn();
    }

    public final void zzH(float f, float f2) {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar != null) {
            zzcfrVar.zzu(f, f2);
        }
    }

    public final void zzI() {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzb.zzd(false);
        zzcfrVar.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbS)).booleanValue()) {
            this.zza.zza();
        }
        zzK("ended", new String[0]);
        zzJ();
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zzb(String str, String str2) {
        zzK("error", "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zzc(String str, String str2) {
        zzK("exception", "what", "ExoPlayerAdapter exception", "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zzd() {
        zzK("pause", new String[0]);
        zzJ();
        this.zzh = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zze() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbS)).booleanValue()) {
            this.zza.zzb();
        }
        if (this.zzb.zzi() != null && !this.zzi) {
            boolean z = (this.zzb.zzi().getWindow().getAttributes().flags & 128) != 0;
            this.zzj = z;
            if (!z) {
                this.zzb.zzi().getWindow().addFlags(128);
                this.zzi = true;
            }
        }
        this.zzh = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zzf() {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar != null && this.zzm == 0) {
            float zzc = zzcfrVar.zzc();
            zzcfr zzcfrVar2 = this.zzg;
            zzK("canplaythrough", "duration", String.valueOf(zzc / 1000.0f), "videoWidth", String.valueOf(zzcfrVar2.zze()), "videoHeight", String.valueOf(zzcfrVar2.zzd()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zzg() {
        this.zzd.setVisibility(4);
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfu
            @Override // java.lang.Runnable
            public final void run() {
                zzcfz.this.zzp();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zzh() {
        this.zza.zzb();
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcfw(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zzi() {
        if (this.zzr && this.zzp != null && !zzL()) {
            this.zzq.setImageBitmap(this.zzp);
            this.zzq.invalidate();
            this.zzc.addView(this.zzq, new FrameLayout.LayoutParams(-1, -1));
            this.zzc.bringChildToFront(this.zzq);
        }
        this.zza.zza();
        this.zzm = this.zzl;
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcfx(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zzj(int i, int i2) {
        if (this.zzk) {
            int max = Math.max(i / ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzH)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzH)).intValue(), 1);
            Bitmap bitmap = this.zzp;
            if (bitmap != null && bitmap.getWidth() == max && this.zzp.getHeight() == max2) {
                return;
            }
            this.zzp = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
            this.zzr = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zzk() {
        if (this.zzh && zzL()) {
            this.zzc.removeView(this.zzq);
        }
        if (this.zzg == null || this.zzp == null) {
            return;
        }
        long elapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
        if (this.zzg.getBitmap(this.zzp) != null) {
            this.zzr = true;
        }
        long elapsedRealtime2 = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - elapsedRealtime;
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Spinner frame grab took " + elapsedRealtime2 + "ms");
        }
        if (elapsedRealtime2 > this.zzf) {
            zzcec.zzj("Spinner frame grab crossed jank threshold! Suspending spinner.");
            this.zzk = false;
            this.zzp = null;
            zzbgu zzbguVar = this.zze;
            if (zzbguVar != null) {
                zzbguVar.zzd("spinner_jank", Long.toString(elapsedRealtime2));
            }
        }
    }

    public final Integer zzl() {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar != null) {
            return zzcfrVar.zzw();
        }
        return null;
    }

    public final void zzn() {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        TextView textView = new TextView(zzcfrVar.getContext());
        Resources zze = com.google.android.gms.ads.internal.zzt.zzo().zze();
        textView.setText(String.valueOf(zze == null ? "AdMob - " : zze.getString(R.string.watermark_label_prefix)).concat(this.zzg.zzj()));
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
        this.zzc.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        this.zzc.bringChildToFront(textView);
    }

    public final void zzo() {
        this.zza.zza();
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar != null) {
            zzcfrVar.zzt();
        }
        zzJ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzp() {
        zzK("firstFrameRendered", new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(boolean z) {
        zzK("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }

    public final void zzr(Integer num) {
        if (this.zzg == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.zzn)) {
            this.zzg.zzC(this.zzn, this.zzo, num);
        } else {
            zzK("no_src", new String[0]);
        }
    }

    public final void zzs() {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzb.zzd(true);
        zzcfrVar.zzn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzt() {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        long zza = zzcfrVar.zza();
        if (this.zzl == zza || zza <= 0) {
            return;
        }
        float f = ((float) zza) / 1000.0f;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbQ)).booleanValue()) {
            zzK("timeupdate", "time", String.valueOf(f), "totalBytes", String.valueOf(this.zzg.zzh()), "qoeCachedBytes", String.valueOf(this.zzg.zzf()), "qoeLoadedBytes", String.valueOf(this.zzg.zzg()), "droppedFrames", String.valueOf(this.zzg.zzb()), "reportTime", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()));
        } else {
            zzK("timeupdate", "time", String.valueOf(f));
        }
        this.zzl = zza;
    }

    public final void zzu() {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzo();
    }

    public final void zzv() {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzp();
    }

    public final void zzw(int i) {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzq(i);
    }

    public final void zzx(MotionEvent motionEvent) {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.dispatchTouchEvent(motionEvent);
    }

    public final void zzy(int i) {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzx(i);
    }

    public final void zzz(int i) {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzy(i);
    }
}
