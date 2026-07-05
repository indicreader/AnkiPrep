package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzami implements zzakr {
    private final zzfp zza = new zzfp();
    private final zzaly zzb = new zzaly();

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(byte[] bArr, int i, int i2, zzakq zzakqVar, zzep zzepVar) {
        this.zza.zzI(bArr, i2 + i);
        this.zza.zzK(i);
        ArrayList arrayList = new ArrayList();
        try {
            zzfp zzfpVar = this.zza;
            int zzd = zzfpVar.zzd();
            String zzy = zzfpVar.zzy(zzfwq.zzc);
            if (zzy == null || !zzy.startsWith("WEBVTT")) {
                zzfpVar.zzK(zzd);
                throw zzcc.zza("Expected WEBVTT. Got ".concat(String.valueOf(zzfpVar.zzy(zzfwq.zzc))), null);
            }
            do {
            } while (!TextUtils.isEmpty(this.zza.zzy(zzfwq.zzc)));
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                zzfp zzfpVar2 = this.zza;
                char c = 65535;
                int i3 = 0;
                while (c == 65535) {
                    i3 = zzfpVar2.zzd();
                    String zzy2 = zzfpVar2.zzy(zzfwq.zzc);
                    if (zzy2 == null) {
                        c = 0;
                    } else if ("STYLE".equals(zzy2)) {
                        c = 2;
                    } else {
                        c = zzy2.startsWith("NOTE") ? (char) 1 : (char) 3;
                    }
                }
                zzfpVar2.zzK(i3);
                if (c == 0) {
                    zzakl.zza(new zzaml(arrayList2), zzakqVar, zzepVar);
                    return;
                }
                if (c == 1) {
                    do {
                    } while (!TextUtils.isEmpty(this.zza.zzy(zzfwq.zzc)));
                } else if (c == 2) {
                    if (arrayList2.isEmpty()) {
                        this.zza.zzy(zzfwq.zzc);
                        arrayList.addAll(this.zzb.zzb(this.zza));
                    } else {
                        throw new IllegalArgumentException("A style block was found after the first cue.");
                    }
                } else {
                    zzama zzc = zzamh.zzc(this.zza, arrayList);
                    if (zzc != null) {
                        arrayList2.add(zzc);
                    }
                }
            }
        } catch (zzcc e) {
            throw new IllegalArgumentException(e);
        }
    }
}
