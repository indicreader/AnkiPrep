package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzalx implements zzakr {
    private final zzfp zza = new zzfp();

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(byte[] bArr, int i, int i2, zzakq zzakqVar, zzep zzepVar) {
        zzec zzp;
        this.zza.zzI(bArr, i2 + i);
        this.zza.zzK(i);
        ArrayList arrayList = new ArrayList();
        while (true) {
            zzfp zzfpVar = this.zza;
            if (zzfpVar.zzb() > 0) {
                zzek.zze(zzfpVar.zzb() >= 8, "Incomplete Mp4Webvtt Top Level box header found.");
                zzfp zzfpVar2 = this.zza;
                int zzg = zzfpVar2.zzg() - 8;
                if (zzfpVar2.zzg() == 1987343459) {
                    zzfp zzfpVar3 = this.zza;
                    CharSequence charSequence = null;
                    zzea zzeaVar = null;
                    while (zzg > 0) {
                        zzek.zze(zzg >= 8, "Incomplete vtt cue box header found.");
                        int zzg2 = zzfpVar3.zzg();
                        int zzg3 = zzfpVar3.zzg();
                        int i3 = zzg - 8;
                        int i4 = zzg2 - 8;
                        String zzA = zzfy.zzA(zzfpVar3.zzM(), zzfpVar3.zzd(), i4);
                        zzfpVar3.zzL(i4);
                        if (zzg3 == 1937011815) {
                            zzeaVar = zzamh.zzb(zzA);
                        } else if (zzg3 == 1885436268) {
                            charSequence = zzamh.zza(null, zzA.trim(), Collections.emptyList());
                        }
                        zzg = i3 - i4;
                    }
                    if (charSequence == null) {
                        charSequence = "";
                    }
                    if (zzeaVar != null) {
                        zzeaVar.zzl(charSequence);
                        zzp = zzeaVar.zzp();
                    } else {
                        zzamg zzamgVar = new zzamg();
                        zzamgVar.zzc = charSequence;
                        zzp = zzamgVar.zza().zzp();
                    }
                    arrayList.add(zzp);
                } else {
                    this.zza.zzL(zzg);
                }
            } else {
                zzepVar.zza(new zzakj(arrayList, -9223372036854775807L, -9223372036854775807L));
                return;
            }
        }
    }
}
