package com.google.android.gms.ads.internal.util;

import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.internal.ads.zzapw;
import com.google.android.gms.internal.ads.zzaqa;
import com.google.android.gms.internal.ads.zzaqg;
import com.google.android.gms.internal.ads.zzaqx;
import com.google.android.gms.internal.ads.zzceb;
import com.google.android.gms.internal.ads.zzceu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbp extends zzaqa {
    private final zzceu zza;
    private final zzceb zzb;

    public zzbp(String str, Map map, zzceu zzceuVar) {
        super(0, str, new zzbo(zzceuVar));
        this.zza = zzceuVar;
        zzceb zzcebVar = new zzceb(null);
        this.zzb = zzcebVar;
        zzcebVar.zzd(str, ShareTarget.METHOD_GET, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzaqa
    public final zzaqg zzh(zzapw zzapwVar) {
        return zzaqg.zzb(zzapwVar, zzaqx.zzb(zzapwVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzaqa
    public final /* bridge */ /* synthetic */ void zzo(Object obj) {
        zzapw zzapwVar = (zzapw) obj;
        this.zzb.zzf(zzapwVar.zzc, zzapwVar.zza);
        byte[] bArr = zzapwVar.zzb;
        if (zzceb.zzk() && bArr != null) {
            this.zzb.zzh(bArr);
        }
        this.zza.zzc(zzapwVar);
    }
}
