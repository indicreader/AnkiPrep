package com.google.android.gms.internal.ads;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzchz extends zzchw {
    public static final /* synthetic */ int zzd = 0;
    private static final Set zze = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzf = new DecimalFormat("#,###");
    private File zzg;
    private boolean zzh;

    public zzchz(zzcgl zzcglVar) {
        super(zzcglVar);
        File cacheDir = this.zza.getCacheDir();
        if (cacheDir == null) {
            zzcec.zzj("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(cacheDir, "admobVideoStreams");
        this.zzg = file;
        if (file.isDirectory() || this.zzg.mkdirs()) {
            if (this.zzg.setReadable(true, false) && this.zzg.setExecutable(true, false)) {
                return;
            }
            zzcec.zzj("Could not set cache file permissions at ".concat(String.valueOf(this.zzg.getAbsolutePath())));
            this.zzg = null;
            return;
        }
        zzcec.zzj("Could not create preload cache directory at ".concat(String.valueOf(this.zzg.getAbsolutePath())));
        this.zzg = null;
    }

    private final File zza(File file) {
        return new File(this.zzg, String.valueOf(file.getName()).concat(".done"));
    }

    @Override // com.google.android.gms.internal.ads.zzchw
    public final void zzf() {
        this.zzh = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:164:0x0344, code lost:
    
        r26 = r4;
        r24 = r14;
        r21 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x034a, code lost:
    
        r26.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0352, code lost:
    
        if (com.google.android.gms.ads.internal.util.zze.zzm(3) == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0354, code lost:
    
        com.google.android.gms.internal.ads.zzcec.zze("Preloaded " + com.google.android.gms.internal.ads.zzchz.zzf.format(r13) + " bytes from " + r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0377, code lost:
    
        r12.setReadable(true, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0380, code lost:
    
        if (r0.isFile() == false) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0382, code lost:
    
        r0.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x038a, code lost:
    
        r0.createNewFile();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:72:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03ea  */
    @Override // com.google.android.gms.internal.ads.zzchw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzt(final java.lang.String r30) {
        /*
            Method dump skipped, instructions count: 1077
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzchz.zzt(java.lang.String):boolean");
    }
}
