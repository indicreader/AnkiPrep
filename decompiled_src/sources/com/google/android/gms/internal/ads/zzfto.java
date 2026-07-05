package com.google.android.gms.internal.ads;

import android.net.Network;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfto extends zzftc {
    private zzfxu<Integer> zza;
    private zzfxu<Integer> zzb;
    private zzftn zzc;
    private HttpURLConnection zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfto() {
        this(new zzfxu() { // from class: com.google.android.gms.internal.ads.zzfte
            @Override // com.google.android.gms.internal.ads.zzfxu
            public final Object zza() {
                return zzfto.zzf();
            }
        }, new zzfxu() { // from class: com.google.android.gms.internal.ads.zzftf
            @Override // com.google.android.gms.internal.ads.zzfxu
            public final Object zza() {
                return zzfto.zzg();
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfto(zzfxu<Integer> zzfxuVar, zzfxu<Integer> zzfxuVar2, zzftn zzftnVar) {
        this.zza = zzfxuVar;
        this.zzb = zzfxuVar2;
        this.zzc = zzftnVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Integer zzf() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Integer zzg() {
        return -1;
    }

    public static void zzs(HttpURLConnection httpURLConnection) {
        zzftd.zza();
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        zzs(this.zzd);
    }

    public HttpURLConnection zzm() throws IOException {
        zzftd.zzb(((Integer) this.zza.zza()).intValue(), ((Integer) this.zzb.zza()).intValue());
        zzftn zzftnVar = this.zzc;
        zzftnVar.getClass();
        HttpURLConnection httpURLConnection = (HttpURLConnection) zzftnVar.zza();
        this.zzd = httpURLConnection;
        return httpURLConnection;
    }

    public HttpURLConnection zzn(zzftn zzftnVar, final int i, final int i2) throws IOException {
        this.zza = new zzfxu() { // from class: com.google.android.gms.internal.ads.zzftg
            @Override // com.google.android.gms.internal.ads.zzfxu
            public final Object zza() {
                Integer valueOf;
                valueOf = Integer.valueOf(i);
                return valueOf;
            }
        };
        this.zzb = new zzfxu() { // from class: com.google.android.gms.internal.ads.zzfth
            @Override // com.google.android.gms.internal.ads.zzfxu
            public final Object zza() {
                Integer valueOf;
                valueOf = Integer.valueOf(i2);
                return valueOf;
            }
        };
        this.zzc = zzftnVar;
        return zzm();
    }

    public HttpURLConnection zzo(final Network network, final URL url, final int i, final int i2) throws IOException {
        this.zza = new zzfxu() { // from class: com.google.android.gms.internal.ads.zzfti
            @Override // com.google.android.gms.internal.ads.zzfxu
            public final Object zza() {
                Integer valueOf;
                valueOf = Integer.valueOf(i);
                return valueOf;
            }
        };
        this.zzb = new zzfxu() { // from class: com.google.android.gms.internal.ads.zzftj
            @Override // com.google.android.gms.internal.ads.zzfxu
            public final Object zza() {
                Integer valueOf;
                valueOf = Integer.valueOf(i2);
                return valueOf;
            }
        };
        this.zzc = new zzftn() { // from class: com.google.android.gms.internal.ads.zzftk
            @Override // com.google.android.gms.internal.ads.zzftn
            public final URLConnection zza() {
                URLConnection openConnection;
                openConnection = network.openConnection(url);
                return openConnection;
            }
        };
        return zzm();
    }

    public URLConnection zzr(final URL url, final int i) throws IOException {
        this.zza = new zzfxu() { // from class: com.google.android.gms.internal.ads.zzftl
            @Override // com.google.android.gms.internal.ads.zzfxu
            public final Object zza() {
                Integer valueOf;
                valueOf = Integer.valueOf(i);
                return valueOf;
            }
        };
        this.zzc = new zzftn() { // from class: com.google.android.gms.internal.ads.zzftm
            @Override // com.google.android.gms.internal.ads.zzftn
            public final URLConnection zza() {
                URLConnection openConnection;
                openConnection = url.openConnection();
                return openConnection;
            }
        };
        return zzm();
    }
}
