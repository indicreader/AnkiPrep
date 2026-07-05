package com.google.mlkit.vision.text.internal;

import com.google.android.gms.common.Feature;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.text.TextRecognizerOptionsInterface;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes4.dex */
public final class TextOptionalModuleUtils {
    private TextOptionalModuleUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Feature[] zza(TextRecognizerOptionsInterface textRecognizerOptionsInterface) {
        if (textRecognizerOptionsInterface.getIsThickClient()) {
            return OptionalModuleUtils.EMPTY_FEATURES;
        }
        switch (textRecognizerOptionsInterface.getLoggingLanguageOption()) {
            case 2:
                return new Feature[]{OptionalModuleUtils.FEATURE_OCR_CHINESE};
            case 3:
                return new Feature[]{OptionalModuleUtils.FEATURE_OCR_DEVANAGARI};
            case 4:
                return new Feature[]{OptionalModuleUtils.FEATURE_OCR_JAPANESE};
            case 5:
                return new Feature[]{OptionalModuleUtils.FEATURE_OCR_KOREAN};
            case 6:
            case 7:
                return new Feature[]{OptionalModuleUtils.FEATURE_OCR_COMMON};
            default:
                return new Feature[]{OptionalModuleUtils.FEATURE_OCR};
        }
    }
}
