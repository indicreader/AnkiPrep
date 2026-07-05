package com.google.android.gms.internal.mlkit_vision_text_common;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
public enum zzpi implements zzcy {
    TYPE_UNKNOWN(0),
    LATIN(1),
    LATIN_AND_CHINESE(2),
    LATIN_AND_DEVANAGARI(3),
    LATIN_AND_JAPANESE(4),
    LATIN_AND_KOREAN(5),
    CREDIT_CARD(6),
    DOCUMENT(7);

    private final int zzj;

    zzpi(int i) {
        this.zzj = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzcy
    public final int zza() {
        return this.zzj;
    }
}
