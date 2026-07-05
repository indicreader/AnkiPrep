package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import androidx.autofill.HintConstants;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzegk extends zzegl {
    private static final SparseArray zzb;
    private final Context zzc;
    private final zzdab zzd;
    private final TelephonyManager zze;
    private final zzegc zzf;
    private int zzg;

    static {
        SparseArray sparseArray = new SparseArray();
        zzb = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzbec.CONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), zzbec.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzbec.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzbec.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzbec.DISCONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), zzbec.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzbec.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzbec.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzbec.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzbec.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzbec.SUSPENDED);
        sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzbec.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzbec.CONNECTING);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzegk(Context context, zzdab zzdabVar, zzegc zzegcVar, zzefy zzefyVar, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        super(zzefyVar, zzgVar);
        this.zzc = context;
        this.zzd = zzdabVar;
        this.zzf = zzegcVar;
        this.zze = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzbdt zza(zzegk zzegkVar, Bundle bundle) {
        zzbdm zza = zzbdt.zza();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        int i3 = 2;
        if (i == -1) {
            zzegkVar.zzg = 2;
        } else {
            zzegkVar.zzg = 1;
            if (i == 0) {
                zza.zzb(2);
            } else if (i == 1) {
                zza.zzb(3);
            } else {
                zza.zzb(1);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    i3 = 3;
                    break;
                case 13:
                    i3 = 5;
                    break;
                default:
                    i3 = 1;
                    break;
            }
            zza.zza(i3);
        }
        return (zzbdt) zza.zzal();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzbec zzb(zzegk zzegkVar, Bundle bundle) {
        return (zzbec) zzb.get(zzfhv.zza(zzfhv.zza(bundle, "device"), "network").getInt("active_network_state", -1), zzbec.UNSPECIFIED);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ byte[] zze(zzegk zzegkVar, boolean z, ArrayList arrayList, zzbdt zzbdtVar, zzbec zzbecVar) {
        zzbdx zzg = zzbdy.zzg();
        zzg.zza(arrayList);
        zzg.zzi(zzg(Settings.Global.getInt(zzegkVar.zzc.getContentResolver(), "airplane_mode_on", 0) != 0));
        zzg.zzj(com.google.android.gms.ads.internal.zzt.zzq().zzi(zzegkVar.zzc, zzegkVar.zze));
        zzg.zzf(zzegkVar.zzf.zze());
        zzg.zze(zzegkVar.zzf.zzb());
        zzg.zzb(zzegkVar.zzf.zza());
        zzg.zzc(zzbecVar);
        zzg.zzd(zzbdtVar);
        zzg.zzk(zzegkVar.zzg);
        zzg.zzl(zzg(z));
        zzg.zzh(zzegkVar.zzf.zzd());
        zzg.zzg(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis());
        zzg.zzm(zzg(Settings.Global.getInt(zzegkVar.zzc.getContentResolver(), "wifi_on", 0) != 0));
        return ((zzbdy) zzg.zzal()).zzax();
    }

    private static final int zzg(boolean z) {
        return z ? 2 : 1;
    }

    public final void zzd(boolean z) {
        zzgen.zzr(this.zzd.zzb(), new zzegj(this, z), zzcep.zzf);
    }
}
