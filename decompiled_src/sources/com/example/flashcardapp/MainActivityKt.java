package com.example.flashcardapp;

import android.content.Context;
import android.net.Uri;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.util.Emoji;
import com.example.flashcardapp.data.AnkiDataRepository;
import com.example.flashcardapp.data.AnkiDeck;
import com.example.flashcardapp.data.AnkiDroidBridge;
import com.example.flashcardapp.data.AppLanguage;
import com.example.flashcardapp.data.entities.AliasEntity;
import com.example.flashcardapp.data.entities.CardAttemptEntity;
import com.example.flashcardapp.data.entities.DeckEntity;
import com.example.flashcardapp.data.entities.SessionRecordEntity;
import com.example.flashcardapp.mcq.Mcq;
import com.example.flashcardapp.session.McqSessionMode;
import com.example.flashcardapp.session.McqSessionState;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001a-\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001a}\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0014\u001a\u00020\n2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0016\u001a\u00020\u00012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0011H\u0007¢\u0006\u0002\u0010\u0018\u001a5\u0010\u0019\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u001c\u001a!\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u0010\"\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#²\u0006\n\u0010$\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010%\u001a\u00020&X\u008a\u008e\u0002²\u0006\n\u0010'\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010(\u001a\u00020\nX\u008a\u008e\u0002²\u0006\u0010\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u0003X\u008a\u0084\u0002²\u0006\n\u0010+\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010,\u001a\u00020-X\u008a\u008e\u0002²\u0006\n\u0010.\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u00100\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u00101\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u00102\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u00103\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u00104\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u00105\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u00106\u001a\u000207X\u008a\u0084\u0002²\u0006\n\u00108\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u00109\u001a\u00020\fX\u008a\u008e\u0002²\u0006\u0010\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0003X\u008a\u0084\u0002²\u0006\u0010\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u0003X\u008a\u0084\u0002²\u0006\f\u0010>\u001a\u0004\u0018\u00010?X\u008a\u008e\u0002²\u0006\f\u0010@\u001a\u0004\u0018\u00010\u0001X\u008a\u008e\u0002²\u0006\n\u0010A\u001a\u00020\nX\u008a\u008e\u0002²\u0006\f\u0010B\u001a\u0004\u0018\u00010CX\u008a\u008e\u0002²\u0006\u0010\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u0003X\u008a\u0084\u0002²\u0006\u0012\u0010F\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u0003X\u008a\u008e\u0002²\u0006\n\u0010H\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u0010I\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u0010J\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u0010K\u001a\u00020LX\u008a\u008e\u0002"}, d2 = {"ADMOB_INTERSTITIAL_AD_UNIT_ID", "", "MOCK_ADS", "", "Lcom/example/flashcardapp/MockAdContent;", "FullscreenMockAd", "", "onAdDismissed", "Lkotlin/Function0;", "isQuizReady", "", "adIndex", "", "(Lkotlin/jvm/functions/Function0;ZILandroidx/compose/runtime/Composer;II)V", "MainLayout", "themePreset", "onThemePresetChange", "Lkotlin/Function1;", "isDarkMode", "onDarkModeToggle", "useDynamicWallpaper", "onUseDynamicWallpaperToggle", "fontFamilyType", "onFontFamilyTypeChange", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "RealAdmobInterstitialAd", "adSessionKey", "", "(Lkotlin/jvm/functions/Function0;ZJILandroidx/compose/runtime/Composer;II)V", "shimmerBrush", "Landroidx/compose/ui/graphics/Brush;", "showShimmer", "targetValue", "", "(ZFLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/Brush;", "app_release", "countdown", "currentScreen", "Lcom/example/flashcardapp/Screen;", "userMode", "hasPermission", "cachedDecks", "Lcom/example/flashcardapp/data/entities/DeckEntity;", "deckOrderTrigger", "currentMode", "Lcom/example/flashcardapp/session/McqSessionMode;", "vibrationEnabled", "numberOfOptions", "questionLimit", "shuffleQuestions", "showExplanations", "showTags", "timeLimitSeconds", "deleteImagesOnCardDelete", "currentLanguage", "Lcom/example/flashcardapp/data/AppLanguage;", "deckCount", "cardCount", "sessionRecords", "Lcom/example/flashcardapp/data/entities/SessionRecordEntity;", "attemptsToday", "Lcom/example/flashcardapp/data/entities/CardAttemptEntity;", "pendingImportUri", "Landroid/net/Uri;", "pendingImportType", "showImportDialog", "deckToExport", "Lcom/example/flashcardapp/data/AnkiDeck;", "aliases", "Lcom/example/flashcardapp/data/entities/AliasEntity;", "mcqsState", "Lcom/example/flashcardapp/mcq/Mcq;", "showAbandonDialog", "showCapacityAlert", "adDismissed", "sessionState", "Lcom/example/flashcardapp/session/McqSessionState;"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class MainActivityKt {
    public static final String ADMOB_INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-6846875306917122/8090484835";
    private static final List<MockAdContent> MOCK_ADS = CollectionsKt.listOf((Object[]) new MockAdContent[]{new MockAdContent("🎮", "WordQuest: Daily Puzzle", "Train your brain & expand your vocabulary", CollectionsKt.listOf((Object[]) new String[]{"★ Over 5,000 Challenging Levels", "★ Learn New Words & Meanings Daily", "★ Fun Minigames & Brain Teasers", "★ Play Offline Anytime, Anywhere", "★ Over 10 Million Players Globally"}), "PLAY FREE NOW", ColorKt.Color(4279179050L), ColorKt.Color(4280171146L), ColorKt.Color(4282090230L), null), new MockAdContent("📚", "ReadFast: Speed Reading", "Read 3× faster with proven RSVP technique", CollectionsKt.listOf((Object[]) new String[]{"★ Personalized reading speed goals", "★ 1,000+ curated book summaries", "★ Daily streak & comprehension tests", "★ Offline mode for commuters", "★ Trusted by 2M+ students"}), "START READING FREE", ColorKt.Color(4278603323L), ColorKt.Color(4278607686L), ColorKt.Color(4279286145L), null), new MockAdContent(Emoji.BRAIN, "BrainBoost: Memory Trainer", "Sharpen memory with science-backed exercises", CollectionsKt.listOf((Object[]) new String[]{"★ 20-minute daily brain workout", "★ Memory, focus & processing speed", "★ Gamified challenges & leaderboards", "★ Neuroscientist-designed curriculum", "★ 4.8 ★ on Play Store (500K reviews)"}), "TRAIN YOUR BRAIN", ColorKt.Color(4283178389L), ColorKt.Color(4284162486L), ColorKt.Color(4286331629L), null), new MockAdContent("✈️", "LinguaLeap: Language Fast", "Learn Spanish, French & 12 more languages", CollectionsKt.listOf((Object[]) new String[]{"★ Conversational fluency in 90 days", "★ AI pronunciation feedback", "★ Native-speaker audio lessons", "★ 5-min bite-sized daily lessons", "★ Certificates recognized worldwide"}), "LEARN FOR FREE", ColorKt.Color(4286328082L), ColorKt.Color(4288295954L), ColorKt.Color(4294538006L), null)});

    public static final Brush shimmerBrush(boolean z, float f, Composer composer, int i, int i2) {
        Brush m3368linearGradientmHitzGk$default;
        composer.startReplaceableGroup(933379187);
        boolean z2 = (i2 & 1) != 0 ? true : z;
        float f2 = (i2 & 2) != 0 ? 1000.0f : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(933379187, i, -1, "com.example.flashcardapp.shimmerBrush (MainActivity.kt:287)");
        }
        if (z2) {
            List listOf = CollectionsKt.listOf((Object[]) new Color[]{Color.m3407boximpl(Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurfaceVariant(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m3407boximpl(Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurfaceVariant(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m3407boximpl(Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurfaceVariant(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null))});
            State<Float> animateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("shimmer", composer, 6, 0), 0.0f, f2, AnimationSpecKt.m131infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1000, 0, EasingKt.getFastOutLinearInEasing(), 2, null), RepeatMode.Restart, 0L, 4, null), "shimmerTranslation", composer, ((i << 3) & 896) | InfiniteTransition.$stable | 24624 | (InfiniteRepeatableSpec.$stable << 9), 0);
            m3368linearGradientmHitzGk$default = Brush.Companion.m3368linearGradientmHitzGk$default(Brush.INSTANCE, listOf, Offset.INSTANCE.m3192getZeroF1C5BW0(), OffsetKt.Offset(animateFloat.getValue().floatValue(), animateFloat.getValue().floatValue()), 0, 8, (Object) null);
        } else {
            m3368linearGradientmHitzGk$default = Brush.Companion.m3368linearGradientmHitzGk$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m3407boximpl(Color.INSTANCE.m3452getTransparent0d7_KjU()), Color.m3407boximpl(Color.INSTANCE.m3452getTransparent0d7_KjU())}), Offset.INSTANCE.m3192getZeroF1C5BW0(), Offset.INSTANCE.m3192getZeroF1C5BW0(), 0, 8, (Object) null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m3368linearGradientmHitzGk$default;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x09be  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0a25  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0a98  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0a28  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x09c2  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x07a0  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x068f  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x058d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0498  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0aa3  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x057d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0589  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x067f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x068b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0790  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x079c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x09b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void FullscreenMockAd(final kotlin.jvm.functions.Function0<kotlin.Unit> r44, final boolean r45, int r46, androidx.compose.runtime.Composer r47, final int r48, final int r49) {
        /*
            Method dump skipped, instructions count: 2743
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.MainActivityKt.FullscreenMockAd(kotlin.jvm.functions.Function0, boolean, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int FullscreenMockAd$lambda$1(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FullscreenMockAd$lambda$2(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void RealAdmobInterstitialAd(final kotlin.jvm.functions.Function0<kotlin.Unit> r22, final boolean r23, final long r24, int r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instructions count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.MainActivityKt.RealAdmobInterstitialAd(kotlin.jvm.functions.Function0, boolean, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:177:0x19df  */
    /* JADX WARN: Type inference failed for: r3v189 */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v40, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object, kotlin.coroutines.CoroutineContext] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void MainLayout(final java.lang.String r59, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r60, final boolean r61, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r62, final boolean r63, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r64, final java.lang.String r65, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r66, androidx.compose.runtime.Composer r67, final int r68) {
        /*
            Method dump skipped, instructions count: 6662
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.MainActivityKt.MainLayout(java.lang.String, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Screen MainLayout$lambda$13(MutableState<Screen> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MainLayout$lambda$19(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainLayout$lambda$20(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MainLayout$lambda$25(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainLayout$lambda$26(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MainLayout$lambda$30$lambda$28(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final McqSessionMode MainLayout$lambda$32(MutableState<McqSessionMode> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean MainLayout$lambda$35(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainLayout$lambda$36(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MainLayout$lambda$38(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainLayout$lambda$39(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MainLayout$lambda$41(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainLayout$lambda$42(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MainLayout$lambda$44(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainLayout$lambda$45(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean MainLayout$lambda$47(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainLayout$lambda$48(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean MainLayout$lambda$50(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainLayout$lambda$51(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final int MainLayout$lambda$53(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainLayout$lambda$54(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final int MainLayout$lambda$60(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainLayout$lambda$61(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final int MainLayout$lambda$63(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainLayout$lambda$64(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainLayout$reloadDbStats(CoroutineScope coroutineScope, AnkiDataRepository ankiDataRepository, MutableState<Integer> mutableState, MutableState<Integer> mutableState2) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MainActivityKt$MainLayout$reloadDbStats$1(ankiDataRepository, mutableState, mutableState2, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainLayout$refreshState(Context context, CoroutineScope coroutineScope, MutableState<Boolean> mutableState, AnkiDataRepository ankiDataRepository, MutableState<Integer> mutableState2, MutableState<Integer> mutableState3) {
        MainLayout$lambda$20(mutableState, AnkiDroidBridge.INSTANCE.hasPermission(context));
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MainActivityKt$MainLayout$refreshState$1(ankiDataRepository, mutableState, coroutineScope, mutableState2, mutableState3, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri MainLayout$lambda$71(MutableState<Uri> mutableState) {
        return mutableState.getValue();
    }

    private static final String MainLayout$lambda$74(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean MainLayout$lambda$77(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainLayout$lambda$78(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnkiDeck MainLayout$lambda$83(MutableState<AnkiDeck> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Mcq> MainLayout$lambda$96(MutableState<List<Mcq>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainLayout$lambda$100(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean MainLayout$lambda$99(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MainLayout$lambda$102(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainLayout$lambda$103(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MainLayout$lambda$105(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainLayout$lambda$106(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final McqSessionState MainLayout$lambda$123(MutableState<McqSessionState> mutableState) {
        return mutableState.getValue();
    }

    private static final List<DeckEntity> MainLayout$lambda$22(State<? extends List<DeckEntity>> state) {
        return state.getValue();
    }

    private static final AppLanguage MainLayout$lambda$58(State<? extends AppLanguage> state) {
        return state.getValue();
    }

    private static final List<SessionRecordEntity> MainLayout$lambda$66(State<? extends List<SessionRecordEntity>> state) {
        return state.getValue();
    }

    private static final List<CardAttemptEntity> MainLayout$lambda$69(State<? extends List<CardAttemptEntity>> state) {
        return state.getValue();
    }

    private static final List<AliasEntity> MainLayout$lambda$91(State<? extends List<AliasEntity>> state) {
        return state.getValue();
    }
}
