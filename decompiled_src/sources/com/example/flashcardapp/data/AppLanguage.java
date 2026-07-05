package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: TranslationManager.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/example/flashcardapp/data/AppLanguage;", "", "code", "", "displayName", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getDisplayName", "EN", "HI", "TA", HttpHeaders.TE, "KN", "MR", "AS", "BN", "GU", "OR", "PA", "UR", "MI", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class AppLanguage {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AppLanguage[] $VALUES;
    private final String code;
    private final String displayName;
    public static final AppLanguage EN = new AppLanguage("EN", 0, "en", "English");
    public static final AppLanguage HI = new AppLanguage("HI", 1, "hi", "हिन्दी (Hindi)");
    public static final AppLanguage TA = new AppLanguage("TA", 2, "ta", "தமிழ் (Tamil)");
    public static final AppLanguage TE = new AppLanguage(HttpHeaders.TE, 3, "te", "తెలుగు (Telugu)");
    public static final AppLanguage KN = new AppLanguage("KN", 4, "kn", "ಕನ್ನಡ (Kannada)");
    public static final AppLanguage MR = new AppLanguage("MR", 5, "mr", "मराठी (Marathi)");
    public static final AppLanguage AS = new AppLanguage("AS", 6, "as", "অসমীয়া (Assamese)");
    public static final AppLanguage BN = new AppLanguage("BN", 7, "bn", "বাংলা (Bengali)");
    public static final AppLanguage GU = new AppLanguage("GU", 8, "gu", "ગુજરાતી (Gujarati)");
    public static final AppLanguage OR = new AppLanguage("OR", 9, "or", "ଓଡ଼ಿଆ (Odia)");
    public static final AppLanguage PA = new AppLanguage("PA", 10, "pa", "ਪੰਜਾਬੀ (Punjabi)");
    public static final AppLanguage UR = new AppLanguage("UR", 11, "ur", "اردو (Urdu)");
    public static final AppLanguage MI = new AppLanguage("MI", 12, "mi", "भोजपुरी (Bhojpuri)");

    private static final /* synthetic */ AppLanguage[] $values() {
        return new AppLanguage[]{EN, HI, TA, TE, KN, MR, AS, BN, GU, OR, PA, UR, MI};
    }

    public static EnumEntries<AppLanguage> getEntries() {
        return $ENTRIES;
    }

    public static AppLanguage valueOf(String str) {
        return (AppLanguage) Enum.valueOf(AppLanguage.class, str);
    }

    public static AppLanguage[] values() {
        return (AppLanguage[]) $VALUES.clone();
    }

    public final String getCode() {
        return this.code;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    private AppLanguage(String str, int i, String str2, String str3) {
        this.code = str2;
        this.displayName = str3;
    }

    static {
        AppLanguage[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
