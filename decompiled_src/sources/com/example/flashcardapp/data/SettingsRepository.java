package com.example.flashcardapp.data;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.session.McqSessionMode;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* compiled from: SettingsRepository.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 \u008e\u00012\u00020\u0001:\u0002\u008e\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010r\u001a\b\u0012\u0004\u0012\u00020t0sJ\u0015\u0010u\u001a\u0004\u0018\u00010l2\u0006\u0010v\u001a\u00020t¢\u0006\u0002\u0010wJ\u0015\u0010x\u001a\u0004\u0018\u00010l2\u0006\u0010v\u001a\u00020t¢\u0006\u0002\u0010wJ\u0010\u0010y\u001a\u0004\u0018\u00010B2\u0006\u0010v\u001a\u00020tJ\u0015\u0010z\u001a\u0004\u0018\u00010\u001f2\u0006\u0010v\u001a\u00020t¢\u0006\u0002\u0010{J\u0015\u0010|\u001a\u0004\u0018\u00010\u001f2\u0006\u0010v\u001a\u00020t¢\u0006\u0002\u0010{J\u001c\u0010}\u001a\u00020~2\u0006\u0010v\u001a\u00020t2\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020t0sJ\u001d\u0010\u0080\u0001\u001a\u00020~2\u0006\u0010v\u001a\u00020t2\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020t0sJ\u0016\u0010\u0081\u0001\u001a\u00020~2\r\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020t0sJ \u0010\u0083\u0001\u001a\u00020~2\u0006\u0010v\u001a\u00020t2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010l¢\u0006\u0003\u0010\u0085\u0001J \u0010\u0086\u0001\u001a\u00020~2\u0006\u0010v\u001a\u00020t2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010l¢\u0006\u0003\u0010\u0085\u0001J\u001a\u0010\u0087\u0001\u001a\u00020~2\u0006\u0010v\u001a\u00020t2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010BJ \u0010\u0089\u0001\u001a\u00020~2\u0006\u0010v\u001a\u00020t2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u001f¢\u0006\u0003\u0010\u008b\u0001J \u0010\u008c\u0001\u001a\u00020~2\u0006\u0010v\u001a\u00020t2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u001f¢\u0006\u0003\u0010\u008b\u0001R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR$\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R$\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R$\u0010 \u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010'\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010\"\"\u0004\b)\u0010$R0\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060*2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060*8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00100\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R$\u00103\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u0010\"\"\u0004\b5\u0010$R$\u00106\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b7\u0010\"\"\u0004\b8\u0010$R$\u00109\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b:\u0010\u0015\"\u0004\b;\u0010\u0017R$\u0010<\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b=\u0010\u0015\"\u0004\b>\u0010\u0017R$\u0010?\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u0010\u0015\"\u0004\bA\u0010\u0017R$\u0010C\u001a\u00020B2\u0006\u0010\u0005\u001a\u00020B8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010H\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010\t\"\u0004\bJ\u0010\u000bR$\u0010K\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u0010\"\"\u0004\bM\u0010$R$\u0010N\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bO\u0010\u0015\"\u0004\bP\u0010\u0017R$\u0010Q\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bR\u0010\t\"\u0004\bS\u0010\u000bR$\u0010T\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bU\u0010\t\"\u0004\bV\u0010\u000bR$\u0010W\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bX\u0010\t\"\u0004\bY\u0010\u000bR$\u0010Z\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b[\u0010\t\"\u0004\b\\\u0010\u000bR$\u0010]\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u0010\t\"\u0004\b_\u0010\u000bR$\u0010`\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\ba\u0010\t\"\u0004\bb\u0010\u000bR$\u0010c\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bd\u0010\u0015\"\u0004\be\u0010\u0017R$\u0010f\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bg\u0010\u0015\"\u0004\bh\u0010\u0017R$\u0010i\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bj\u0010\t\"\u0004\bk\u0010\u000bR$\u0010m\u001a\u00020l2\u0006\u0010\u0005\u001a\u00020l8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bn\u0010o\"\u0004\bp\u0010q¨\u0006\u008f\u0001"}, d2 = {"Lcom/example/flashcardapp/data/SettingsRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "appLanguage", "getAppLanguage", "()Ljava/lang/String;", "setAppLanguage", "(Ljava/lang/String;)V", "customFontPath", "getCustomFontPath", "setCustomFontPath", "defaultAlgorithm", "getDefaultAlgorithm", "setDefaultAlgorithm", "", "deleteImagesOnCardDelete", "getDeleteImagesOnCardDelete", "()Z", "setDeleteImagesOnCardDelete", "(Z)V", "fontFamilyType", "getFontFamilyType", "setFontFamilyType", "isDarkMode", "setDarkMode", "isPremium", "setPremium", "", "numberOfOptions", "getNumberOfOptions", "()I", "setNumberOfOptions", "(I)V", "prefs", "Landroid/content/SharedPreferences;", "questionLimit", "getQuestionLimit", "setQuestionLimit", "", "reminderDays", "getReminderDays", "()Ljava/util/Set;", "setReminderDays", "(Ljava/util/Set;)V", "reminderEnabled", "getReminderEnabled", "setReminderEnabled", "reminderHour", "getReminderHour", "setReminderHour", "reminderMinute", "getReminderMinute", "setReminderMinute", "showExplanations", "getShowExplanations", "setShowExplanations", "showTags", "getShowTags", "setShowTags", "shuffleQuestions", "getShuffleQuestions", "setShuffleQuestions", "Lcom/example/flashcardapp/session/McqSessionMode;", "studyMode", "getStudyMode", "()Lcom/example/flashcardapp/session/McqSessionMode;", "setStudyMode", "(Lcom/example/flashcardapp/session/McqSessionMode;)V", "themePreset", "getThemePreset", "setThemePreset", "timeLimitSeconds", "getTimeLimitSeconds", "setTimeLimitSeconds", "useDynamicWallpaperTheme", "getUseDynamicWallpaperTheme", "setUseDynamicWallpaperTheme", "userDateOfBirth", "getUserDateOfBirth", "setUserDateOfBirth", "userEmail", "getUserEmail", "setUserEmail", "userImportantDatesJson", "getUserImportantDatesJson", "setUserImportantDatesJson", "userName", "getUserName", "setUserName", "userProfileImageUri", "getUserProfileImageUri", "setUserProfileImageUri", "userTarget", "getUserTarget", "setUserTarget", "vibrationEnabled", "getVibrationEnabled", "setVibrationEnabled", "whiteboardAutoStylusMode", "getWhiteboardAutoStylusMode", "setWhiteboardAutoStylusMode", "whiteboardDefaultPenColor", "getWhiteboardDefaultPenColor", "setWhiteboardDefaultPenColor", "", "whiteboardHighlighterAlpha", "getWhiteboardHighlighterAlpha", "()F", "setWhiteboardHighlighterAlpha", "(F)V", "getDeckOrderList", "", "", "getNegativeMarksForDeck", "deckId", "(J)Ljava/lang/Float;", "getPositiveMarksForDeck", "getPreferredModeForDeck", "getQuestionLimitForDeck", "(J)Ljava/lang/Integer;", "getTimeLimitSecondsForDeck", "moveDeckDown", "", "allDeckIds", "moveDeckUp", "setDeckOrderList", "list", "setNegativeMarksForDeck", "marks", "(JLjava/lang/Float;)V", "setPositiveMarksForDeck", "setPreferredModeForDeck", "mode", "setQuestionLimitForDeck", "limit", "(JLjava/lang/Integer;)V", "setTimeLimitSecondsForDeck", "timeLimit", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class SettingsRepository {
    private static volatile SettingsRepository INSTANCE;
    private final SharedPreferences prefs;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ SettingsRepository(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private SettingsRepository(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ankiprep_settings", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.prefs = sharedPreferences;
        String string = sharedPreferences.getString("app_language", "en");
        TranslationManager.INSTANCE.setLanguageByCode(string != null ? string : "en");
    }

    /* compiled from: SettingsRepository.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/example/flashcardapp/data/SettingsRepository$Companion;", "", "()V", "INSTANCE", "Lcom/example/flashcardapp/data/SettingsRepository;", "getInstance", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SettingsRepository getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            SettingsRepository settingsRepository = SettingsRepository.INSTANCE;
            if (settingsRepository == null) {
                synchronized (this) {
                    settingsRepository = SettingsRepository.INSTANCE;
                    if (settingsRepository == null) {
                        Context applicationContext = context.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                        settingsRepository = new SettingsRepository(applicationContext, null);
                        Companion companion = SettingsRepository.INSTANCE;
                        SettingsRepository.INSTANCE = settingsRepository;
                    }
                }
            }
            return settingsRepository;
        }
    }

    public final McqSessionMode getStudyMode() {
        String str = "PRACTICE";
        try {
            String string = this.prefs.getString("study_mode", "PRACTICE");
            if (string != null) {
                str = string;
            }
            return McqSessionMode.valueOf(str);
        } catch (Exception unused) {
            return McqSessionMode.PRACTICE;
        }
    }

    public final void setStudyMode(McqSessionMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.prefs.edit().putString("study_mode", value.name()).apply();
    }

    public final boolean isPremium() {
        return this.prefs.getBoolean("is_premium", false);
    }

    public final void setPremium(boolean z) {
        this.prefs.edit().putBoolean("is_premium", z).apply();
    }

    public final boolean getVibrationEnabled() {
        return this.prefs.getBoolean("vibration_enabled", true);
    }

    public final void setVibrationEnabled(boolean z) {
        this.prefs.edit().putBoolean("vibration_enabled", z).apply();
    }

    public final int getQuestionLimit() {
        return this.prefs.getInt("question_limit", 20);
    }

    public final void setQuestionLimit(int i) {
        this.prefs.edit().putInt("question_limit", i).apply();
    }

    public final boolean getShuffleQuestions() {
        return this.prefs.getBoolean("shuffle_questions", true);
    }

    public final void setShuffleQuestions(boolean z) {
        this.prefs.edit().putBoolean("shuffle_questions", z).apply();
    }

    public final int getNumberOfOptions() {
        return this.prefs.getInt("number_of_options", 4);
    }

    public final void setNumberOfOptions(int i) {
        this.prefs.edit().putInt("number_of_options", i).apply();
    }

    public final boolean getShowExplanations() {
        return this.prefs.getBoolean("show_explanations", true);
    }

    public final void setShowExplanations(boolean z) {
        this.prefs.edit().putBoolean("show_explanations", z).apply();
    }

    public final boolean getShowTags() {
        return this.prefs.getBoolean("show_tags", true);
    }

    public final void setShowTags(boolean z) {
        this.prefs.edit().putBoolean("show_tags", z).apply();
    }

    public final int getTimeLimitSeconds() {
        return this.prefs.getInt("time_limit_seconds", 0);
    }

    public final void setTimeLimitSeconds(int i) {
        this.prefs.edit().putInt("time_limit_seconds", i).apply();
    }

    public final String getThemePreset() {
        String string = this.prefs.getString("theme_preset", "EMERALD");
        return string == null ? "EMERALD" : string;
    }

    public final void setThemePreset(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.prefs.edit().putString("theme_preset", value).apply();
    }

    public final boolean getUseDynamicWallpaperTheme() {
        return this.prefs.getBoolean("use_dynamic_wallpaper_theme", false);
    }

    public final void setUseDynamicWallpaperTheme(boolean z) {
        this.prefs.edit().putBoolean("use_dynamic_wallpaper_theme", z).apply();
    }

    public final String getFontFamilyType() {
        String string = this.prefs.getString("font_family_type", "DEFAULT");
        return string == null ? "DEFAULT" : string;
    }

    public final void setFontFamilyType(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.prefs.edit().putString("font_family_type", value).apply();
    }

    public final String getCustomFontPath() {
        return this.prefs.getString("custom_font_path", null);
    }

    public final void setCustomFontPath(String str) {
        this.prefs.edit().putString("custom_font_path", str).apply();
    }

    public final boolean isDarkMode() {
        return this.prefs.getBoolean("is_dark_mode", false);
    }

    public final void setDarkMode(boolean z) {
        this.prefs.edit().putBoolean("is_dark_mode", z).apply();
    }

    public final boolean getWhiteboardAutoStylusMode() {
        return this.prefs.getBoolean("whiteboard_auto_stylus_mode", true);
    }

    public final void setWhiteboardAutoStylusMode(boolean z) {
        this.prefs.edit().putBoolean("whiteboard_auto_stylus_mode", z).apply();
    }

    public final float getWhiteboardHighlighterAlpha() {
        return this.prefs.getFloat("whiteboard_highlighter_alpha", 0.45f);
    }

    public final void setWhiteboardHighlighterAlpha(float f) {
        this.prefs.edit().putFloat("whiteboard_highlighter_alpha", f).apply();
    }

    public final String getWhiteboardDefaultPenColor() {
        String string = this.prefs.getString("whiteboard_default_pen_color", "DEFAULT");
        return string == null ? "DEFAULT" : string;
    }

    public final void setWhiteboardDefaultPenColor(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.prefs.edit().putString("whiteboard_default_pen_color", value).apply();
    }

    public final String getAppLanguage() {
        String string = this.prefs.getString("app_language", "en");
        return string == null ? "en" : string;
    }

    public final void setAppLanguage(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.prefs.edit().putString("app_language", value).apply();
        TranslationManager.INSTANCE.setLanguageByCode(value);
    }

    public final String getUserName() {
        String string = this.prefs.getString("user_name", "");
        return string == null ? "" : string;
    }

    public final void setUserName(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.prefs.edit().putString("user_name", value).apply();
    }

    public final String getUserEmail() {
        String string = this.prefs.getString("user_email", "");
        return string == null ? "" : string;
    }

    public final void setUserEmail(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.prefs.edit().putString("user_email", value).apply();
    }

    public final String getUserTarget() {
        String string = this.prefs.getString("user_target", "");
        return string == null ? "" : string;
    }

    public final void setUserTarget(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.prefs.edit().putString("user_target", value).apply();
    }

    public final McqSessionMode getPreferredModeForDeck(long deckId) {
        String string = this.prefs.getString("deck_" + deckId + "_preferred_mode", null);
        if (string == null) {
            return null;
        }
        try {
            return McqSessionMode.valueOf(string);
        } catch (Exception unused) {
            return null;
        }
    }

    public final void setPreferredModeForDeck(long deckId, McqSessionMode mode) {
        if (mode == null) {
            this.prefs.edit().remove("deck_" + deckId + "_preferred_mode").apply();
        } else {
            this.prefs.edit().putString("deck_" + deckId + "_preferred_mode", mode.name()).apply();
        }
    }

    public final Integer getQuestionLimitForDeck(long deckId) {
        if (this.prefs.contains("deck_" + deckId + "_question_limit")) {
            return Integer.valueOf(this.prefs.getInt("deck_" + deckId + "_question_limit", 0));
        }
        return null;
    }

    public final void setQuestionLimitForDeck(long deckId, Integer limit) {
        if (limit == null) {
            this.prefs.edit().remove("deck_" + deckId + "_question_limit").apply();
        } else {
            this.prefs.edit().putInt("deck_" + deckId + "_question_limit", limit.intValue()).apply();
        }
    }

    public final Integer getTimeLimitSecondsForDeck(long deckId) {
        if (this.prefs.contains("deck_" + deckId + "_time_limit_seconds")) {
            return Integer.valueOf(this.prefs.getInt("deck_" + deckId + "_time_limit_seconds", 0));
        }
        return null;
    }

    public final void setTimeLimitSecondsForDeck(long deckId, Integer timeLimit) {
        if (timeLimit == null) {
            this.prefs.edit().remove("deck_" + deckId + "_time_limit_seconds").apply();
        } else {
            this.prefs.edit().putInt("deck_" + deckId + "_time_limit_seconds", timeLimit.intValue()).apply();
        }
    }

    public final Float getPositiveMarksForDeck(long deckId) {
        if (this.prefs.contains("deck_" + deckId + "_positive_marks")) {
            return Float.valueOf(this.prefs.getFloat("deck_" + deckId + "_positive_marks", 1.0f));
        }
        return null;
    }

    public final void setPositiveMarksForDeck(long deckId, Float marks) {
        if (marks == null) {
            this.prefs.edit().remove("deck_" + deckId + "_positive_marks").apply();
        } else {
            this.prefs.edit().putFloat("deck_" + deckId + "_positive_marks", marks.floatValue()).apply();
        }
    }

    public final Float getNegativeMarksForDeck(long deckId) {
        if (this.prefs.contains("deck_" + deckId + "_negative_marks")) {
            return Float.valueOf(this.prefs.getFloat("deck_" + deckId + "_negative_marks", 0.0f));
        }
        return null;
    }

    public final void setNegativeMarksForDeck(long deckId, Float marks) {
        if (marks == null) {
            this.prefs.edit().remove("deck_" + deckId + "_negative_marks").apply();
        } else {
            this.prefs.edit().putFloat("deck_" + deckId + "_negative_marks", marks.floatValue()).apply();
        }
    }

    public final String getUserProfileImageUri() {
        String string = this.prefs.getString("user_profile_image_uri", "");
        return string == null ? "" : string;
    }

    public final void setUserProfileImageUri(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.prefs.edit().putString("user_profile_image_uri", value).apply();
    }

    public final String getUserDateOfBirth() {
        String string = this.prefs.getString("user_date_of_birth", "");
        return string == null ? "" : string;
    }

    public final void setUserDateOfBirth(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.prefs.edit().putString("user_date_of_birth", value).apply();
    }

    public final String getUserImportantDatesJson() {
        String string = this.prefs.getString("user_important_dates_json", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        return string == null ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : string;
    }

    public final void setUserImportantDatesJson(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.prefs.edit().putString("user_important_dates_json", value).apply();
    }

    public final boolean getReminderEnabled() {
        return this.prefs.getBoolean("reminder_enabled", false);
    }

    public final void setReminderEnabled(boolean z) {
        this.prefs.edit().putBoolean("reminder_enabled", z).apply();
    }

    public final int getReminderHour() {
        return this.prefs.getInt("reminder_hour", 20);
    }

    public final void setReminderHour(int i) {
        this.prefs.edit().putInt("reminder_hour", i).apply();
    }

    public final int getReminderMinute() {
        return this.prefs.getInt("reminder_minute", 0);
    }

    public final void setReminderMinute(int i) {
        this.prefs.edit().putInt("reminder_minute", i).apply();
    }

    public final Set<String> getReminderDays() {
        Set<String> stringSet = this.prefs.getStringSet("reminder_days", SetsKt.setOf((Object[]) new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"}));
        return stringSet == null ? SetsKt.setOf((Object[]) new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"}) : stringSet;
    }

    public final void setReminderDays(Set<String> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.prefs.edit().putStringSet("reminder_days", value).apply();
    }

    public final boolean getDeleteImagesOnCardDelete() {
        return this.prefs.getBoolean("delete_images_on_card_delete", true);
    }

    public final void setDeleteImagesOnCardDelete(boolean z) {
        this.prefs.edit().putBoolean("delete_images_on_card_delete", z).apply();
    }

    public final String getDefaultAlgorithm() {
        String string = this.prefs.getString("default_algorithm", "FSRS");
        return string == null ? "FSRS" : string;
    }

    public final void setDefaultAlgorithm(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.prefs.edit().putString("default_algorithm", value).apply();
    }

    public final List<Long> getDeckOrderList() {
        SharedPreferences sharedPreferences = this.prefs;
        String str = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        String string = sharedPreferences.getString("deck_order_json", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        if (string != null) {
            str = string;
        }
        try {
            List split$default = StringsKt.split$default((CharSequence) StringsKt.removeSurrounding(str, (CharSequence) "[", (CharSequence) "]"), new String[]{","}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList();
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                Long longOrNull = StringsKt.toLongOrNull(StringsKt.trim((CharSequence) it.next()).toString());
                if (longOrNull != null) {
                    arrayList.add(longOrNull);
                }
            }
            return arrayList;
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }

    public final void setDeckOrderList(List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.prefs.edit().putString("deck_order_json", list.toString()).apply();
    }

    public final void moveDeckUp(long deckId, List<Long> allDeckIds) {
        Intrinsics.checkNotNullParameter(allDeckIds, "allDeckIds");
        List<Long> mutableList = CollectionsKt.toMutableList((Collection) getDeckOrderList());
        Iterator<T> it = allDeckIds.iterator();
        while (it.hasNext()) {
            long longValue = ((Number) it.next()).longValue();
            if (!mutableList.contains(Long.valueOf(longValue))) {
                mutableList.add(Long.valueOf(longValue));
            }
        }
        int indexOf = mutableList.indexOf(Long.valueOf(deckId));
        if (indexOf > 0) {
            long longValue2 = mutableList.get(indexOf).longValue();
            int i = indexOf - 1;
            mutableList.set(indexOf, mutableList.get(i));
            mutableList.set(i, Long.valueOf(longValue2));
            setDeckOrderList(mutableList);
        }
    }

    public final void moveDeckDown(long deckId, List<Long> allDeckIds) {
        Intrinsics.checkNotNullParameter(allDeckIds, "allDeckIds");
        List<Long> mutableList = CollectionsKt.toMutableList((Collection) getDeckOrderList());
        Iterator<T> it = allDeckIds.iterator();
        while (it.hasNext()) {
            long longValue = ((Number) it.next()).longValue();
            if (!mutableList.contains(Long.valueOf(longValue))) {
                mutableList.add(Long.valueOf(longValue));
            }
        }
        int indexOf = mutableList.indexOf(Long.valueOf(deckId));
        if (indexOf < 0 || indexOf >= mutableList.size() - 1) {
            return;
        }
        long longValue2 = mutableList.get(indexOf).longValue();
        int i = indexOf + 1;
        mutableList.set(indexOf, mutableList.get(i));
        mutableList.set(i, Long.valueOf(longValue2));
        setDeckOrderList(mutableList);
    }
}
