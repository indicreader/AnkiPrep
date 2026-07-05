package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhw extends zzgq {
    private final Context zza;
    private zzhb zzb;
    private AssetFileDescriptor zzc;
    private InputStream zzd;
    private long zze;
    private boolean zzf;

    public zzhw(Context context) {
        super(false);
        this.zza = context.getApplicationContext();
    }

    @Deprecated
    public static Uri buildRawResourceUri(int i) {
        return Uri.parse("rawresource:///" + i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x003b, code lost:
    
        if (r0.matches("\\d+") != false) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.content.res.AssetFileDescriptor zzk(android.content.Context r7, com.google.android.gms.internal.ads.zzhb r8) throws com.google.android.gms.internal.ads.zzhv {
        /*
            android.net.Uri r8 = r8.zza
            android.net.Uri r8 = r8.normalizeScheme()
            java.lang.String r0 = r8.getScheme()
            java.lang.String r1 = "rawresource"
            boolean r0 = android.text.TextUtils.equals(r1, r0)
            r1 = 1004(0x3ec, float:1.407E-42)
            r2 = 2005(0x7d5, float:2.81E-42)
            r3 = 0
            if (r0 != 0) goto Ld1
            java.lang.String r0 = r8.getScheme()
            java.lang.String r4 = "android.resource"
            boolean r0 = android.text.TextUtils.equals(r4, r0)
            r5 = 1
            if (r0 == 0) goto L3f
            java.util.List r0 = r8.getPathSegments()
            int r0 = r0.size()
            if (r0 != r5) goto L3f
            java.lang.String r0 = r8.getLastPathSegment()
            r0.getClass()
            java.lang.String r6 = "\\d+"
            boolean r0 = r0.matches(r6)
            if (r0 == 0) goto L3f
            goto Ld1
        L3f:
            java.lang.String r0 = r8.getScheme()
            boolean r0 = android.text.TextUtils.equals(r4, r0)
            if (r0 == 0) goto Lb4
            java.lang.String r0 = r8.getPath()
            r0.getClass()
            java.lang.String r1 = "/"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L5c
            java.lang.String r0 = r0.substring(r5)
        L5c:
            java.lang.String r1 = r8.getHost()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L6b
            java.lang.String r1 = r7.getPackageName()
            goto L6f
        L6b:
            java.lang.String r1 = r8.getHost()
        L6f:
            java.lang.String r4 = r7.getPackageName()
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L7e
            android.content.res.Resources r7 = r7.getResources()
            goto L86
        L7e:
            android.content.pm.PackageManager r7 = r7.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lab
            android.content.res.Resources r7 = r7.getResourcesForApplication(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lab
        L86:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r1 = ":"
            r4.append(r1)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.String r1 = "raw"
            int r0 = r7.getIdentifier(r0, r1, r3)
            if (r0 == 0) goto La3
            goto Le0
        La3:
            com.google.android.gms.internal.ads.zzhv r7 = new com.google.android.gms.internal.ads.zzhv
            java.lang.String r8 = "Resource not found."
            r7.<init>(r8, r3, r2)
            throw r7
        Lab:
            r7 = move-exception
            com.google.android.gms.internal.ads.zzhv r8 = new com.google.android.gms.internal.ads.zzhv
            java.lang.String r0 = "Package in android.resource:// URI not found. Check http://g.co/dev/packagevisibility."
            r8.<init>(r0, r7, r2)
            throw r8
        Lb4:
            com.google.android.gms.internal.ads.zzhv r7 = new com.google.android.gms.internal.ads.zzhv
            java.lang.String r8 = r8.getScheme()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Unsupported URI scheme ("
            r0.<init>(r2)
            r0.append(r8)
            java.lang.String r8 = "). Only android.resource is supported."
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.<init>(r8, r3, r1)
            throw r7
        Ld1:
            android.content.res.Resources r7 = r7.getResources()
            java.lang.String r0 = r8.getLastPathSegment()     // Catch: java.lang.NumberFormatException -> L104
            r0.getClass()
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L104
        Le0:
            android.content.res.AssetFileDescriptor r7 = r7.openRawResourceFd(r0)     // Catch: android.content.res.Resources.NotFoundException -> Lfd
            if (r7 == 0) goto Le7
            return r7
        Le7:
            com.google.android.gms.internal.ads.zzhv r7 = new com.google.android.gms.internal.ads.zzhv
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r0 = "Resource is compressed: "
            java.lang.String r8 = r0.concat(r8)
            r0 = 2000(0x7d0, float:2.803E-42)
            r7.<init>(r8, r3, r0)
            throw r7
        Lfd:
            r7 = move-exception
            com.google.android.gms.internal.ads.zzhv r8 = new com.google.android.gms.internal.ads.zzhv
            r8.<init>(r3, r7, r2)
            throw r8
        L104:
            com.google.android.gms.internal.ads.zzhv r7 = new com.google.android.gms.internal.ads.zzhv
            java.lang.String r8 = "Resource identifier must be an integer."
            r7.<init>(r8, r3, r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhw.zzk(android.content.Context, com.google.android.gms.internal.ads.zzhb):android.content.res.AssetFileDescriptor");
    }

    @Override // com.google.android.gms.internal.ads.zzu
    public final int zza(byte[] bArr, int i, int i2) throws zzhv {
        if (i2 == 0) {
            return 0;
        }
        long j = this.zze;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new zzhv(null, e, 2000);
            }
        }
        InputStream inputStream = this.zzd;
        int i3 = zzfy.zza;
        int read = inputStream.read(bArr, i, i2);
        if (read == -1) {
            if (this.zze == -1) {
                return -1;
            }
            throw new zzhv("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
        long j2 = this.zze;
        if (j2 != -1) {
            this.zze = j2 - read;
        }
        zzg(read);
        return read;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final long zzb(zzhb zzhbVar) throws zzhv {
        long j;
        this.zzb = zzhbVar;
        zzi(zzhbVar);
        AssetFileDescriptor zzk = zzk(this.zza, zzhbVar);
        this.zzc = zzk;
        long length = zzk.getLength();
        FileInputStream fileInputStream = new FileInputStream(this.zzc.getFileDescriptor());
        this.zzd = fileInputStream;
        if (length != -1) {
            try {
                if (zzhbVar.zzf > length) {
                    throw new zzhv(null, null, 2008);
                }
            } catch (zzhv e) {
                throw e;
            } catch (IOException e2) {
                throw new zzhv(null, e2, 2000);
            }
        }
        long startOffset = this.zzc.getStartOffset();
        long skip = fileInputStream.skip(zzhbVar.zzf + startOffset) - startOffset;
        if (skip != zzhbVar.zzf) {
            throw new zzhv(null, null, 2008);
        }
        if (length == -1) {
            FileChannel channel = fileInputStream.getChannel();
            if (channel.size() == 0) {
                this.zze = -1L;
                j = -1;
            } else {
                j = channel.size() - channel.position();
                this.zze = j;
                if (j < 0) {
                    throw new zzhv(null, null, 2008);
                }
            }
        } else {
            j = length - skip;
            this.zze = j;
            if (j < 0) {
                throw new zzgx(2008);
            }
        }
        long j2 = zzhbVar.zzg;
        if (j2 != -1) {
            if (j != -1) {
                j2 = Math.min(j, j2);
            }
            this.zze = j2;
        }
        this.zzf = true;
        zzj(zzhbVar);
        long j3 = zzhbVar.zzg;
        return j3 != -1 ? j3 : this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final Uri zzc() {
        zzhb zzhbVar = this.zzb;
        if (zzhbVar != null) {
            return zzhbVar.zza;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzd() throws zzhv {
        this.zzb = null;
        try {
            try {
                try {
                    InputStream inputStream = this.zzd;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    this.zzd = null;
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.zzc;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                        this.zzc = null;
                        if (this.zzf) {
                            this.zzf = false;
                            zzh();
                        }
                    } catch (IOException e) {
                        throw new zzhv(null, e, 2000);
                    }
                } catch (IOException e2) {
                    throw new zzhv(null, e2, 2000);
                }
            } catch (Throwable th) {
                this.zzc = null;
                if (this.zzf) {
                    this.zzf = false;
                    zzh();
                }
                throw th;
            }
        } catch (Throwable th2) {
            this.zzd = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.zzc;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.zzc = null;
                if (this.zzf) {
                    this.zzf = false;
                    zzh();
                }
                throw th2;
            } catch (IOException e3) {
                throw new zzhv(null, e3, 2000);
            }
        }
    }
}
