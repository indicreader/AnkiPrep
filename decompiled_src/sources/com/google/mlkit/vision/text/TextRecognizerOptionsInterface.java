package com.google.mlkit.vision.text;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes4.dex */
public interface TextRecognizerOptionsInterface {
    public static final int CREDIT_CARD = 6;
    public static final int DOCUMENT = 7;
    public static final int LATIN = 1;
    public static final int LATIN_AND_CHINESE = 2;
    public static final int LATIN_AND_DEVANAGARI = 3;
    public static final int LATIN_AND_JAPANESE = 4;
    public static final int LATIN_AND_KOREAN = 5;

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes4.dex */
    public @interface LanguageOption {
    }

    String getConfigLabel();

    Executor getExecutor();

    boolean getIsThickClient();

    String getLanguageHint();

    int getLoggingEventId();

    int getLoggingLanguageOption();

    String getLoggingLibraryName();

    String getLoggingLibraryNameForOptionalModule();

    String getModuleId();
}
