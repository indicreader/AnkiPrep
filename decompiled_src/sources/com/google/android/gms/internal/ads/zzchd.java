package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzchd extends zzcfr implements TextureView.SurfaceTextureListener, zzcgb {
    private final zzcgl zzc;
    private final zzcgm zzd;
    private final zzcgk zze;
    private zzcfq zzf;
    private Surface zzg;
    private zzcgc zzh;
    private String zzi;
    private String[] zzj;
    private boolean zzk;
    private int zzl;
    private zzcgj zzm;
    private final boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;
    private float zzs;

    public zzchd(Context context, zzcgm zzcgmVar, zzcgl zzcglVar, boolean z, boolean z2, zzcgk zzcgkVar) {
        super(context);
        this.zzl = 1;
        this.zzc = zzcglVar;
        this.zzd = zzcgmVar;
        this.zzn = z;
        this.zze = zzcgkVar;
        setSurfaceTextureListener(this);
        zzcgmVar.zza(this);
    }

    private static String zzT(String str, Exception exc) {
        return str + "/" + exc.getClass().getCanonicalName() + ":" + exc.getMessage();
    }

    private final void zzU() {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            zzcgcVar.zzQ(true);
        }
    }

    private final void zzV() {
        if (this.zzo) {
            return;
        }
        this.zzo = true;
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchc
            @Override // java.lang.Runnable
            public final void run() {
                zzchd.this.zzI();
            }
        });
        zzn();
        this.zzd.zzb();
        if (this.zzp) {
            zzp();
        }
    }

    private final void zzX() {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            zzcgcVar.zzQ(false);
        }
    }

    private final void zzY() {
        if (this.zzh != null) {
            zzZ(null, true);
            zzcgc zzcgcVar = this.zzh;
            if (zzcgcVar != null) {
                zzcgcVar.zzL(null);
                this.zzh.zzH();
                this.zzh = null;
            }
            this.zzl = 1;
            this.zzk = false;
            this.zzo = false;
            this.zzp = false;
        }
    }

    private final void zzZ(Surface surface, boolean z) {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            try {
                zzcgcVar.zzS(surface, z);
                return;
            } catch (IOException e) {
                zzcec.zzk("", e);
                return;
            }
        }
        zzcec.zzj("Trying to set surface before player is initialized.");
    }

    private final void zzaa() {
        zzab(this.zzq, this.zzr);
    }

    private final void zzab(int i, int i2) {
        float f = i2 > 0 ? i / i2 : 1.0f;
        if (this.zzs != f) {
            this.zzs = f;
            requestLayout();
        }
    }

    private final boolean zzac() {
        return zzad() && this.zzl != 1;
    }

    private final boolean zzad() {
        zzcgc zzcgcVar = this.zzh;
        return (zzcgcVar == null || !zzcgcVar.zzV() || this.zzk) ? false : true;
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = this.zzs;
        if (f != 0.0f && this.zzm == null) {
            float f2 = measuredWidth;
            float f3 = f2 / measuredHeight;
            if (f > f3) {
                measuredHeight = (int) (f2 / f);
            }
            if (f < f3) {
                measuredWidth = (int) (measuredHeight * f);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzcgj zzcgjVar = this.zzm;
        if (zzcgjVar != null) {
            zzcgjVar.zzc(measuredWidth, measuredHeight);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzn) {
            zzcgj zzcgjVar = new zzcgj(getContext());
            this.zzm = zzcgjVar;
            zzcgjVar.zzd(surfaceTexture, i, i2);
            this.zzm.start();
            SurfaceTexture zzb = this.zzm.zzb();
            if (zzb != null) {
                surfaceTexture = zzb;
            } else {
                this.zzm.zze();
                this.zzm = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzg = surface;
        if (this.zzh == null) {
            zzW(false, null);
        } else {
            zzZ(surface, true);
            if (!this.zze.zza) {
                zzU();
            }
        }
        if (this.zzq == 0 || this.zzr == 0) {
            zzab(i, i2);
        } else {
            zzaa();
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgz
            @Override // java.lang.Runnable
            public final void run() {
                zzchd.this.zzM();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzo();
        zzcgj zzcgjVar = this.zzm;
        if (zzcgjVar != null) {
            zzcgjVar.zze();
            this.zzm = null;
        }
        if (this.zzh != null) {
            zzX();
            Surface surface = this.zzg;
            if (surface != null) {
                surface.release();
            }
            this.zzg = null;
            zzZ(null, true);
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgv
            @Override // java.lang.Runnable
            public final void run() {
                zzchd.this.zzN();
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i, final int i2) {
        zzcgj zzcgjVar = this.zzm;
        if (zzcgjVar != null) {
            zzcgjVar.zzc(i, i2);
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgu
            @Override // java.lang.Runnable
            public final void run() {
                zzchd.this.zzO(i, i2);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzd.zzf(this);
        this.zza.zza(surfaceTexture, this.zzf);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i) {
        com.google.android.gms.ads.internal.util.zze.zza("AdExoPlayerView3 window visibility changed to " + i);
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgt
            @Override // java.lang.Runnable
            public final void run() {
                zzchd.this.zzQ(i);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzA(int i) {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            zzcgcVar.zzN(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzB(int i) {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            zzcgcVar.zzR(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzD(int i, int i2) {
        this.zzq = i;
        this.zzr = i2;
        zzaa();
    }

    final zzcgc zzE(Integer num) {
        zzcgk zzcgkVar = this.zze;
        zzcgl zzcglVar = this.zzc;
        zzcix zzcixVar = new zzcix(zzcglVar.getContext(), zzcgkVar, zzcglVar, num);
        zzcec.zzi("ExoPlayerAdapter initialized.");
        return zzcixVar;
    }

    final String zzF() {
        zzcgl zzcglVar = this.zzc;
        return com.google.android.gms.ads.internal.zzt.zzp().zzc(zzcglVar.getContext(), zzcglVar.zzn().zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzG(String str) {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.zzb("ExoPlayerAdapter error", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzH() {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.zza();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzI() {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.zzf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzJ(boolean z, long j) {
        this.zzc.zzv(z, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzK(String str) {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.zzc("ExoPlayerAdapter exception", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzL() {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.zzg();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzM() {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.zzh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzN() {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.zzi();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzO(int i, int i2) {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.zzj(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzP() {
        float zza = this.zzb.zza();
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            try {
                zzcgcVar.zzT(zza, false);
                return;
            } catch (IOException e) {
                zzcec.zzk("", e);
                return;
            }
        }
        zzcec.zzj("Trying to set volume before player is initialized.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzQ(int i) {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.onWindowVisibilityChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzR() {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.zzd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzS() {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final int zza() {
        if (zzac()) {
            return (int) this.zzh.zzy();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final int zzb() {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            return zzcgcVar.zzr();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final int zzc() {
        if (zzac()) {
            return (int) this.zzh.zzz();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final int zzd() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final int zze() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final long zzf() {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            return zzcgcVar.zzx();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final long zzg() {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            return zzcgcVar.zzA();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final long zzh() {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            return zzcgcVar.zzB();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzi(final boolean z, final long j) {
        if (this.zzc != null) {
            zzcep.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgw
                @Override // java.lang.Runnable
                public final void run() {
                    zzchd.this.zzJ(z, j);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final String zzj() {
        return "ExoPlayer/2".concat(true != this.zzn ? "" : " spherical");
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzk(String str, Exception exc) {
        final String zzT = zzT(str, exc);
        zzcec.zzj("ExoPlayerAdapter error: ".concat(zzT));
        this.zzk = true;
        if (this.zze.zza) {
            zzX();
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcha
            @Override // java.lang.Runnable
            public final void run() {
                zzchd.this.zzG(zzT);
            }
        });
        com.google.android.gms.ads.internal.zzt.zzo().zzv(exc, "AdExoPlayerView.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzl(String str, Exception exc) {
        final String zzT = zzT("onLoadException", exc);
        zzcec.zzj("ExoPlayerAdapter exception: ".concat(zzT));
        com.google.android.gms.ads.internal.zzt.zzo().zzv(exc, "AdExoPlayerView.onException");
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgx
            @Override // java.lang.Runnable
            public final void run() {
                zzchd.this.zzK(zzT);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzm(int i) {
        if (this.zzl != i) {
            this.zzl = i;
            if (i == 3) {
                zzV();
                return;
            }
            if (i != 4) {
                return;
            }
            if (this.zze.zza) {
                zzX();
            }
            this.zzd.zze();
            this.zzb.zzc();
            com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchb
                @Override // java.lang.Runnable
                public final void run() {
                    zzchd.this.zzH();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr, com.google.android.gms.internal.ads.zzcgo
    public final void zzn() {
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgs
            @Override // java.lang.Runnable
            public final void run() {
                zzchd.this.zzP();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzo() {
        if (zzac()) {
            if (this.zze.zza) {
                zzX();
            }
            this.zzh.zzO(false);
            this.zzd.zze();
            this.zzb.zzc();
            com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgy
                @Override // java.lang.Runnable
                public final void run() {
                    zzchd.this.zzR();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzp() {
        if (!zzac()) {
            this.zzp = true;
            return;
        }
        if (this.zze.zza) {
            zzU();
        }
        this.zzh.zzO(true);
        this.zzd.zzc();
        this.zzb.zzb();
        this.zza.zzb();
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgr
            @Override // java.lang.Runnable
            public final void run() {
                zzchd.this.zzS();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzq(int i) {
        if (zzac()) {
            this.zzh.zzI(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzr(zzcfq zzcfqVar) {
        this.zzf = zzcfqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzs(String str) {
        if (str != null) {
            zzC(str, null, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzt() {
        if (zzad()) {
            this.zzh.zzU();
            zzY();
        }
        this.zzd.zze();
        this.zzb.zzc();
        this.zzd.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzu(float f, float f2) {
        zzcgj zzcgjVar = this.zzm;
        if (zzcgjVar != null) {
            zzcgjVar.zzf(f, f2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzv() {
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgq
            @Override // java.lang.Runnable
            public final void run() {
                zzchd.this.zzL();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final Integer zzw() {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            return zzcgcVar.zzC();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzx(int i) {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            zzcgcVar.zzJ(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzy(int i) {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            zzcgcVar.zzK(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzz(int i) {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            zzcgcVar.zzM(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzC(String str, String[] strArr, Integer num) {
        if (str == null) {
            return;
        }
        if (strArr != null) {
            this.zzj = (String[]) Arrays.copyOf(strArr, strArr.length);
        } else {
            this.zzj = new String[]{str};
        }
        String str2 = this.zzi;
        boolean z = false;
        if (this.zze.zzl && str2 != null && !str.equals(str2) && this.zzl == 4) {
            z = true;
        }
        this.zzi = str;
        zzW(z, num);
    }

    private final void zzW(boolean z, Integer num) {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null && !z) {
            zzcgcVar.zzP(num);
            return;
        }
        if (this.zzi == null || this.zzg == null) {
            return;
        }
        if (z) {
            if (zzad()) {
                zzcgcVar.zzU();
                zzY();
            } else {
                zzcec.zzj("No valid ExoPlayerAdapter exists when switch source.");
                return;
            }
        }
        if (this.zzi.startsWith("cache:")) {
            zzchw zzp = this.zzc.zzp(this.zzi);
            if (zzp instanceof zzcif) {
                zzcgc zza = ((zzcif) zzp).zza();
                this.zzh = zza;
                zza.zzP(num);
                if (!this.zzh.zzV()) {
                    zzcec.zzj("Precached video player has been released.");
                    return;
                }
            } else if (zzp instanceof zzcic) {
                zzcic zzcicVar = (zzcic) zzp;
                String zzF = zzF();
                ByteBuffer zzk = zzcicVar.zzk();
                boolean zzl = zzcicVar.zzl();
                String zzi = zzcicVar.zzi();
                if (zzi == null) {
                    zzcec.zzj("Stream cache URL is null.");
                    return;
                } else {
                    zzcgc zzE = zzE(num);
                    this.zzh = zzE;
                    zzE.zzG(new Uri[]{Uri.parse(zzi)}, zzF, zzk, zzl);
                }
            } else {
                zzcec.zzj("Stream cache miss: ".concat(String.valueOf(this.zzi)));
                return;
            }
        } else {
            this.zzh = zzE(num);
            String zzF2 = zzF();
            Uri[] uriArr = new Uri[this.zzj.length];
            int i = 0;
            while (true) {
                String[] strArr = this.zzj;
                if (i >= strArr.length) {
                    break;
                }
                uriArr[i] = Uri.parse(strArr[i]);
                i++;
            }
            this.zzh.zzF(uriArr, zzF2);
        }
        this.zzh.zzL(this);
        zzZ(this.zzg, false);
        if (this.zzh.zzV()) {
            int zzt = this.zzh.zzt();
            this.zzl = zzt;
            if (zzt == 3) {
                zzV();
            }
        }
    }
}
