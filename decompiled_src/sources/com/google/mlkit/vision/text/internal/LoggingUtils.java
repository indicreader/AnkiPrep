package com.google.mlkit.vision.text.internal;

import com.google.android.gms.internal.mlkit_vision_text_common.zzmu;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmv;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmw;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmx;
import com.google.android.gms.internal.mlkit_vision_text_common.zzpb;
import com.google.android.gms.internal.mlkit_vision_text_common.zzpi;
import com.google.android.gms.internal.mlkit_vision_text_common.zzqs;
import com.google.android.gms.internal.mlkit_vision_text_common.zzrc;
import com.google.android.gms.internal.mlkit_vision_text_common.zzrd;
import com.google.android.gms.internal.mlkit_vision_text_common.zzrg;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes4.dex */
public final class LoggingUtils {
    private LoggingUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(zzrd zzrdVar, final boolean z, final zzmv zzmvVar) {
        zzrdVar.zzf(new zzrc() { // from class: com.google.mlkit.vision.text.internal.zzk
            @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzrc
            public final zzqs zza() {
                boolean z2 = z;
                zzmv zzmvVar2 = zzmvVar;
                zzmx zzmxVar = new zzmx();
                zzmxVar.zze(z2 ? zzmu.TYPE_THICK : zzmu.TYPE_THIN);
                zzpb zzpbVar = new zzpb();
                zzpbVar.zzb(zzmvVar2);
                zzmxVar.zzg(zzpbVar.zzc());
                return zzrg.zzf(zzmxVar);
            }
        }, zzmw.ON_DEVICE_TEXT_LOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzpi zza(int i) {
        switch (i) {
            case 1:
                return zzpi.LATIN;
            case 2:
                return zzpi.LATIN_AND_CHINESE;
            case 3:
                return zzpi.LATIN_AND_DEVANAGARI;
            case 4:
                return zzpi.LATIN_AND_JAPANESE;
            case 5:
                return zzpi.LATIN_AND_KOREAN;
            case 6:
                return zzpi.CREDIT_CARD;
            case 7:
                return zzpi.DOCUMENT;
            default:
                return zzpi.TYPE_UNKNOWN;
        }
    }
}
