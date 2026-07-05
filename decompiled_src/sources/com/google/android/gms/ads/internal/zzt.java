package com.google.android.gms.ads.internal;

import android.os.Build;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.util.zzab;
import com.google.android.gms.ads.internal.util.zzac;
import com.google.android.gms.ads.internal.util.zzay;
import com.google.android.gms.ads.internal.util.zzbx;
import com.google.android.gms.ads.internal.util.zzby;
import com.google.android.gms.ads.internal.util.zzcm;
import com.google.android.gms.ads.internal.util.zzw;
import com.google.android.gms.ads.internal.util.zzy;
import com.google.android.gms.ads.internal.util.zzz;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzbax;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbgl;
import com.google.android.gms.internal.ads.zzbqd;
import com.google.android.gms.internal.ads.zzbro;
import com.google.android.gms.internal.ads.zzbsq;
import com.google.android.gms.internal.ads.zzbzm;
import com.google.android.gms.internal.ads.zzcch;
import com.google.android.gms.internal.ads.zzcdl;
import com.google.android.gms.internal.ads.zzcev;
import com.google.android.gms.internal.ads.zzcfc;
import com.google.android.gms.internal.ads.zzchp;
import com.google.android.gms.internal.ads.zzcjx;
import com.google.android.gms.internal.ads.zzeif;
import com.google.android.gms.internal.ads.zzeig;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzt {
    private static final zzt zza = new zzt();
    private final zzcch zzA;
    private final zzcm zzB;
    private final zzchp zzC;
    private final zzcfc zzD;
    private final com.google.android.gms.ads.internal.overlay.zza zzb;
    private final com.google.android.gms.ads.internal.overlay.zzn zzc;
    private final com.google.android.gms.ads.internal.util.zzt zzd;
    private final zzcjx zze;
    private final zzab zzf;
    private final zzazk zzg;
    private final zzcdl zzh;
    private final zzac zzi;
    private final zzbax zzj;
    private final Clock zzk;
    private final zze zzl;
    private final zzbgl zzm;
    private final zzay zzn;
    private final zzbzm zzo;
    private final zzbqd zzp;
    private final zzcev zzq;
    private final zzbro zzr;
    private final zzx zzs;
    private final zzbx zzt;
    private final com.google.android.gms.ads.internal.overlay.zzab zzu;
    private final com.google.android.gms.ads.internal.overlay.zzac zzv;
    private final zzbsq zzw;
    private final zzby zzx;
    private final zzeig zzy;
    private final zzbbm zzz;

    protected zzt() {
        zzab zzyVar;
        com.google.android.gms.ads.internal.overlay.zza zzaVar = new com.google.android.gms.ads.internal.overlay.zza();
        com.google.android.gms.ads.internal.overlay.zzn zznVar = new com.google.android.gms.ads.internal.overlay.zzn();
        com.google.android.gms.ads.internal.util.zzt zztVar = new com.google.android.gms.ads.internal.util.zzt();
        zzcjx zzcjxVar = new zzcjx();
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            zzyVar = new zzz();
        } else {
            zzyVar = i >= 28 ? new zzy() : new zzw();
        }
        zzazk zzazkVar = new zzazk();
        zzcdl zzcdlVar = new zzcdl();
        zzac zzacVar = new zzac();
        zzbax zzbaxVar = new zzbax();
        Clock defaultClock = DefaultClock.getInstance();
        zze zzeVar = new zze();
        zzbgl zzbglVar = new zzbgl();
        zzay zzayVar = new zzay();
        zzbzm zzbzmVar = new zzbzm();
        zzbqd zzbqdVar = new zzbqd();
        zzcev zzcevVar = new zzcev();
        zzbro zzbroVar = new zzbro();
        zzx zzxVar = new zzx();
        zzbx zzbxVar = new zzbx();
        com.google.android.gms.ads.internal.overlay.zzab zzabVar = new com.google.android.gms.ads.internal.overlay.zzab();
        com.google.android.gms.ads.internal.overlay.zzac zzacVar2 = new com.google.android.gms.ads.internal.overlay.zzac();
        zzbsq zzbsqVar = new zzbsq();
        zzby zzbyVar = new zzby();
        zzeif zzeifVar = new zzeif();
        zzbbm zzbbmVar = new zzbbm();
        zzcch zzcchVar = new zzcch();
        zzcm zzcmVar = new zzcm();
        zzchp zzchpVar = new zzchp();
        zzcfc zzcfcVar = new zzcfc();
        this.zzb = zzaVar;
        this.zzc = zznVar;
        this.zzd = zztVar;
        this.zze = zzcjxVar;
        this.zzf = zzyVar;
        this.zzg = zzazkVar;
        this.zzh = zzcdlVar;
        this.zzi = zzacVar;
        this.zzj = zzbaxVar;
        this.zzk = defaultClock;
        this.zzl = zzeVar;
        this.zzm = zzbglVar;
        this.zzn = zzayVar;
        this.zzo = zzbzmVar;
        this.zzp = zzbqdVar;
        this.zzq = zzcevVar;
        this.zzr = zzbroVar;
        this.zzt = zzbxVar;
        this.zzs = zzxVar;
        this.zzu = zzabVar;
        this.zzv = zzacVar2;
        this.zzw = zzbsqVar;
        this.zzx = zzbyVar;
        this.zzy = zzeifVar;
        this.zzz = zzbbmVar;
        this.zzA = zzcchVar;
        this.zzB = zzcmVar;
        this.zzC = zzchpVar;
        this.zzD = zzcfcVar;
    }

    public static zzeig zzA() {
        return zza.zzy;
    }

    public static Clock zzB() {
        return zza.zzk;
    }

    public static zze zza() {
        return zza.zzl;
    }

    public static zzazk zzb() {
        return zza.zzg;
    }

    public static zzbax zzc() {
        return zza.zzj;
    }

    public static zzbbm zzd() {
        return zza.zzz;
    }

    public static zzbgl zze() {
        return zza.zzm;
    }

    public static zzbro zzf() {
        return zza.zzr;
    }

    public static zzbsq zzg() {
        return zza.zzw;
    }

    public static com.google.android.gms.ads.internal.overlay.zza zzh() {
        return zza.zzb;
    }

    public static com.google.android.gms.ads.internal.overlay.zzn zzi() {
        return zza.zzc;
    }

    public static zzx zzj() {
        return zza.zzs;
    }

    public static com.google.android.gms.ads.internal.overlay.zzab zzk() {
        return zza.zzu;
    }

    public static com.google.android.gms.ads.internal.overlay.zzac zzl() {
        return zza.zzv;
    }

    public static zzbzm zzm() {
        return zza.zzo;
    }

    public static zzcch zzn() {
        return zza.zzA;
    }

    public static zzcdl zzo() {
        return zza.zzh;
    }

    public static com.google.android.gms.ads.internal.util.zzt zzp() {
        return zza.zzd;
    }

    public static zzab zzq() {
        return zza.zzf;
    }

    public static zzac zzr() {
        return zza.zzi;
    }

    public static zzay zzs() {
        return zza.zzn;
    }

    public static zzbx zzt() {
        return zza.zzt;
    }

    public static zzby zzu() {
        return zza.zzx;
    }

    public static zzcm zzv() {
        return zza.zzB;
    }

    public static zzcev zzw() {
        return zza.zzq;
    }

    public static zzcfc zzx() {
        return zza.zzD;
    }

    public static zzchp zzy() {
        return zza.zzC;
    }

    public static zzcjx zzz() {
        return zza.zze;
    }
}
