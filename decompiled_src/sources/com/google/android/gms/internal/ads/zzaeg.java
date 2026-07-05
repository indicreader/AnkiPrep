package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzaeg {
    public static int zza(int i) {
        int i2 = 0;
        while (i > 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    public static zzby zzb(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            int i2 = zzfy.zza;
            String[] split = str.split("=", 2);
            if (split.length != 2) {
                zzff.zzf("VorbisUtil", "Failed to parse Vorbis comment: ".concat(String.valueOf(str)));
            } else if (split[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(zzafw.zzb(new zzfp(Base64.decode(split[1], 0))));
                } catch (RuntimeException e) {
                    zzff.zzg("VorbisUtil", "Failed to parse vorbis picture", e);
                }
            } else {
                arrayList.add(new zzaho(split[0], split[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzby(arrayList);
    }

    public static zzaed zzc(zzfp zzfpVar, boolean z, boolean z2) throws zzcc {
        if (z) {
            zzd(3, zzfpVar, false);
        }
        String zzA = zzfpVar.zzA((int) zzfpVar.zzs(), zzfwq.zzc);
        int length = zzA.length();
        long zzs = zzfpVar.zzs();
        String[] strArr = new String[(int) zzs];
        int i = length + 15;
        for (int i2 = 0; i2 < zzs; i2++) {
            String zzA2 = zzfpVar.zzA((int) zzfpVar.zzs(), zzfwq.zzc);
            strArr[i2] = zzA2;
            i = i + 4 + zzA2.length();
        }
        if (z2 && (zzfpVar.zzm() & 1) == 0) {
            throw zzcc.zza("framing bit expected to be set", null);
        }
        return new zzaed(zzA, strArr, i + 1);
    }

    public static boolean zzd(int i, zzfp zzfpVar, boolean z) throws zzcc {
        if (zzfpVar.zzb() < 7) {
            if (z) {
                return false;
            }
            throw zzcc.zza("too short header: " + zzfpVar.zzb(), null);
        }
        if (zzfpVar.zzm() != i) {
            if (z) {
                return false;
            }
            throw zzcc.zza("expected header type ".concat(String.valueOf(Integer.toHexString(i))), null);
        }
        if (zzfpVar.zzm() == 118 && zzfpVar.zzm() == 111 && zzfpVar.zzm() == 114 && zzfpVar.zzm() == 98 && zzfpVar.zzm() == 105 && zzfpVar.zzm() == 115) {
            return true;
        }
        if (z) {
            return false;
        }
        throw zzcc.zza("expected characters 'vorbis'", null);
    }
}
