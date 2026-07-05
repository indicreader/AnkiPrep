package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhd implements zzgw {
    private final Context zza;
    private final List zzb = new ArrayList();
    private final zzgw zzc;
    private zzgw zzd;
    private zzgw zze;
    private zzgw zzf;
    private zzgw zzg;
    private zzgw zzh;
    private zzgw zzi;
    private zzgw zzj;
    private zzgw zzk;

    public zzhd(Context context, zzgw zzgwVar) {
        this.zza = context.getApplicationContext();
        this.zzc = zzgwVar;
    }

    private final zzgw zzg() {
        if (this.zze == null) {
            zzgp zzgpVar = new zzgp(this.zza);
            this.zze = zzgpVar;
            zzh(zzgpVar);
        }
        return this.zze;
    }

    private final void zzh(zzgw zzgwVar) {
        for (int i = 0; i < this.zzb.size(); i++) {
            zzgwVar.zzf((zzhy) this.zzb.get(i));
        }
    }

    private static final void zzi(zzgw zzgwVar, zzhy zzhyVar) {
        if (zzgwVar != null) {
            zzgwVar.zzf(zzhyVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final long zzb(zzhb zzhbVar) throws IOException {
        zzgw zzgwVar;
        zzek.zzf(this.zzk == null);
        String scheme = zzhbVar.zza.getScheme();
        Uri uri = zzhbVar.zza;
        int i = zzfy.zza;
        String scheme2 = uri.getScheme();
        if (TextUtils.isEmpty(scheme2) || "file".equals(scheme2)) {
            String path = zzhbVar.zza.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.zzd == null) {
                    zzhm zzhmVar = new zzhm();
                    this.zzd = zzhmVar;
                    zzh(zzhmVar);
                }
                this.zzk = this.zzd;
            } else {
                this.zzk = zzg();
            }
        } else if ("asset".equals(scheme)) {
            this.zzk = zzg();
        } else if ("content".equals(scheme)) {
            if (this.zzf == null) {
                zzgt zzgtVar = new zzgt(this.zza);
                this.zzf = zzgtVar;
                zzh(zzgtVar);
            }
            this.zzk = this.zzf;
        } else if ("rtmp".equals(scheme)) {
            if (this.zzg == null) {
                try {
                    zzgw zzgwVar2 = (zzgw) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                    this.zzg = zzgwVar2;
                    zzh(zzgwVar2);
                } catch (ClassNotFoundException unused) {
                    zzff.zzf("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating RTMP extension", e);
                }
                if (this.zzg == null) {
                    this.zzg = this.zzc;
                }
            }
            this.zzk = this.zzg;
        } else if ("udp".equals(scheme)) {
            if (this.zzh == null) {
                zzia zziaVar = new zzia(2000);
                this.zzh = zziaVar;
                zzh(zziaVar);
            }
            this.zzk = this.zzh;
        } else if ("data".equals(scheme)) {
            if (this.zzi == null) {
                zzgu zzguVar = new zzgu();
                this.zzi = zzguVar;
                zzh(zzguVar);
            }
            this.zzk = this.zzi;
        } else {
            if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
                if (this.zzj == null) {
                    zzhw zzhwVar = new zzhw(this.zza);
                    this.zzj = zzhwVar;
                    zzh(zzhwVar);
                }
                zzgwVar = this.zzj;
            } else {
                zzgwVar = this.zzc;
            }
            this.zzk = zzgwVar;
        }
        return this.zzk.zzb(zzhbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final Uri zzc() {
        zzgw zzgwVar = this.zzk;
        if (zzgwVar == null) {
            return null;
        }
        return zzgwVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzd() throws IOException {
        zzgw zzgwVar = this.zzk;
        if (zzgwVar != null) {
            try {
                zzgwVar.zzd();
            } finally {
                this.zzk = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final Map zze() {
        zzgw zzgwVar = this.zzk;
        return zzgwVar == null ? Collections.emptyMap() : zzgwVar.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzu
    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        zzgw zzgwVar = this.zzk;
        zzgwVar.getClass();
        return zzgwVar.zza(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzf(zzhy zzhyVar) {
        zzhyVar.getClass();
        this.zzc.zzf(zzhyVar);
        this.zzb.add(zzhyVar);
        zzi(this.zzd, zzhyVar);
        zzi(this.zze, zzhyVar);
        zzi(this.zzf, zzhyVar);
        zzi(this.zzg, zzhyVar);
        zzi(this.zzh, zzhyVar);
        zzi(this.zzi, zzhyVar);
        zzi(this.zzj, zzhyVar);
    }
}
