package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzawx extends zzaxx {
    private static final zzaxy zzi = new zzaxy();
    private final Context zzj;

    public zzawx(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, int i, int i2, Context context, zzarz zzarzVar) {
        super(zzawjVar, "CbnHJiUmcb7bV3nHtVfkQJESWUzuF9spYS2HkpVPEQ4sOQCQUFomcsL6vpMTm+JY", "m4BHDSYRnsEEIrYlgM0yy1C5NfyYnIIeJvwgjuCY5HY=", zzasgVar, i, 27);
        this.zzj = context;
    }

    private final String zzc() {
        try {
            if (this.zzb.zzl() != null) {
                this.zzb.zzl().get();
            }
            zzatd zzc = this.zzb.zzc();
            if (zzc == null || !zzc.zzaj()) {
                return null;
            }
            return zzc.zzh();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        Boolean bool;
        int i;
        zzatu zzatuVar;
        AtomicReference zza = zzi.zza(this.zzj.getPackageName());
        synchronized (zza) {
            zzatu zzatuVar2 = (zzatu) zza.get();
            if (zzatuVar2 == null || zzawm.zzd(zzatuVar2.zza) || zzatuVar2.zza.equals(ExifInterface.LONGITUDE_EAST) || zzatuVar2.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                if (zzawm.zzd(null)) {
                    if (zzawm.zzd(null)) {
                        bool = false;
                    } else {
                        bool = false;
                    }
                    bool.booleanValue();
                    i = 3;
                } else {
                    i = 5;
                }
                Boolean valueOf = Boolean.valueOf(i == 3);
                Boolean bool2 = (Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcm);
                String zzb = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcl)).booleanValue() ? zzb() : null;
                if (bool2.booleanValue() && this.zzb.zzp() && zzawm.zzd(zzb)) {
                    zzb = zzc();
                }
                zzatu zzatuVar3 = new zzatu((String) this.zzf.invoke(null, this.zzj, valueOf, zzb));
                if (zzawm.zzd(zzatuVar3.zza) || zzatuVar3.zza.equals(ExifInterface.LONGITUDE_EAST)) {
                    int i2 = i - 1;
                    if (i2 == 3) {
                        String zzc = zzc();
                        if (!zzawm.zzd(zzc)) {
                            zzatuVar3.zza = zzc;
                        }
                    } else if (i2 == 4) {
                        throw null;
                    }
                }
                zza.set(zzatuVar3);
            }
            zzatuVar = (zzatu) zza.get();
        }
        synchronized (this.zze) {
            if (zzatuVar != null) {
                this.zze.zzx(zzatuVar.zza);
                this.zze.zzX(zzatuVar.zzb);
                this.zze.zzZ(zzatuVar.zzc);
                this.zze.zzi(zzatuVar.zzd);
                this.zze.zzw(zzatuVar.zze);
            }
        }
    }

    protected final String zzb() {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            byte[] zzf = zzawm.zzf((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcn));
            ArrayList arrayList = new ArrayList();
            arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(zzf)));
            if (!Build.TYPE.equals("user")) {
                arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(zzawm.zzf((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzco)))));
            }
            Context context = this.zzj;
            String packageName = context.getPackageName();
            this.zzb.zzk();
            if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals(ExifInterface.LATITUDE_SOUTH)) {
                return null;
            }
            final zzgfg zze = zzgfg.zze();
            context.getPackageManager().requestChecksums(packageName, false, 8, arrayList, new PackageManager.OnChecksumsReadyListener() { // from class: com.google.android.gms.internal.ads.zzaxz
                @Override // android.content.pm.PackageManager.OnChecksumsReadyListener
                public final void onChecksumsReady(List list) {
                    zzgfg zzgfgVar = zzgfg.this;
                    if (list == null) {
                        zzgfgVar.zzc(null);
                        return;
                    }
                    try {
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            ApkChecksum apkChecksum = (ApkChecksum) list.get(i);
                            if (apkChecksum.getType() == 8) {
                                zzgfgVar.zzc(zzawm.zzb(apkChecksum.getValue()));
                                return;
                            }
                        }
                        zzgfgVar.zzc(null);
                    } catch (Throwable unused) {
                        zzgfgVar.zzc(null);
                    }
                }
            });
            return (String) zze.get();
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }
}
