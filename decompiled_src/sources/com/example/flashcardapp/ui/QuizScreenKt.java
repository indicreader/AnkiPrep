package com.example.flashcardapp.ui;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRightKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ChipColors;
import androidx.compose.material3.ChipElevation;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldDefaults;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SuggestionChipDefaults;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.example.flashcardapp.data.TranslationManager;
import com.example.flashcardapp.data.core.ParsedCard;
import com.example.flashcardapp.data.core.StructuredParser;
import com.example.flashcardapp.data.entities.CardEntity;
import com.example.flashcardapp.session.McqSessionMode;
import com.example.flashcardapp.session.McqSessionState;
import com.example.flashcardapp.ui.theme.ThemeKt;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* compiled from: QuizScreen.kt */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a7\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001aE\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0010\u001aI\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0003¢\u0006\u0002\u0010\u0019\u001a[\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00152\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u0015H\u0003¢\u0006\u0002\u0010$\u001as\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010(\u001a\u00020)2\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010#\u001a\u00020\u00152\u0014\b\u0002\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010/\u001a\u001d\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020'2\u0006\u00102\u001a\u00020\u0015H\u0003¢\u0006\u0002\u00103\u001a\u0010\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020'H\u0002¨\u00066²\u0006\n\u00107\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u00108\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\u0010\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u000bX\u008a\u008e\u0002²\u0006\n\u0010;\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010<\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\f\u0010=\u001a\u0004\u0018\u00010:X\u008a\u008e\u0002²\u0006\n\u0010>\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010?\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010@\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010A\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010B\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\f\u0010C\u001a\u0004\u0018\u00010\fX\u008a\u008e\u0002²\u0006\u0010\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u008a\u0084\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010D\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010E\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010F\u001a\u00020-X\u008a\u008e\u0002²\u0006\n\u0010G\u001a\u00020HX\u008a\u0084\u0002²\u0006\n\u0010I\u001a\u00020'X\u008a\u008e\u0002²\u0006\n\u0010J\u001a\u00020KX\u008a\u008e\u0002²\u0006\n\u0010L\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010M\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010N\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010O\u001a\u00020'X\u008a\u008e\u0002²\u0006\n\u0010P\u001a\u00020HX\u008a\u0084\u0002²\u0006\n\u0010Q\u001a\u00020KX\u008a\u008e\u0002²\u0006\n\u0010R\u001a\u00020HX\u008a\u008e\u0002²\u0006\f\u0010=\u001a\u0004\u0018\u00010:X\u008a\u008e\u0002²\u0006\n\u0010S\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u0010T\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010U\u001a\u00020:X\u008a\u008e\u0002²\u0006\n\u0010V\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010W\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010X\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010Y\u001a\u00020HX\u008a\u0084\u0002²\u0006\n\u0010Z\u001a\u00020HX\u008a\u0084\u0002²\u0006\n\u0010[\u001a\u00020\tX\u008a\u008e\u0002"}, d2 = {"EditModeSelectionDialog", "", "onDismiss", "Lkotlin/Function0;", "onEditCurrent", "onEditWholePack", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "EditWholePackScreen", "deckName", "", "cards", "", "Lcom/example/flashcardapp/data/entities/CardEntity;", "onCardClick", "Lkotlin/Function1;", "onBackPressed", "(Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "QuizNavRow", "sessionState", "Lcom/example/flashcardapp/session/McqSessionState;", "isQuestionAnswered", "", "onPrevious", "onNext", "onEdit", "(Lcom/example/flashcardapp/session/McqSessionState;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "QuizOptionCard", "label", "text", "isSelected", "isCorrect", "isWrong", "isEnabled", "onClick", "vibrationEnabled", "isDarkMode", "(Ljava/lang/String;Ljava/lang/String;ZZZZLkotlin/jvm/functions/Function0;ZZLandroidx/compose/runtime/Composer;I)V", "QuizScreen", "deckId", "", "sessionManager", "Lcom/example/flashcardapp/session/McqSessionManager;", "showExplanations", "showTags", "timeLimitSeconds", "", "onDarkModeToggle", "(JLjava/lang/String;Lcom/example/flashcardapp/session/McqSessionManager;ZZZIZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "TimerChip", "remainingSecs", "isUrgent", "(JZLandroidx/compose/runtime/Composer;I)V", "formatTime", "seconds", "app_release", "isWhiteBoardActive", "showTagsState", "currentStrokePoints", "Landroidx/compose/ui/geometry/Offset;", "isWhiteboardPenMode", "isEraserMode", "eraserIndicatorPosition", "autoStylusMode", "showEditDialog", "showSubmitConfirm", "showEditSelectionDialog", "showWholePackScreen", "cardToEditFromPack", "isLoading", "isStarred", "userRating", "alpha", "", "questionTimeMs", "flashColor", "Landroidx/compose/ui/graphics/Color;", "showAddDialog", "showDeleteConfirm", "optionsMenuExpanded", "elapsedSeconds", "animatedProgress", "activePenColor", "activePenSize", "penType", "showColorPickerDialog", "whiteboardToolbarOffset", "showColorDropdown", "showToolDropdown", "showThicknessDropdown", "scale", "pulseAlpha", "searchQuery"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class QuizScreenKt {
    /* JADX WARN: Code restructure failed: missing block: B:266:0x114e, code lost:
    
        if (r0 == null) goto L296;
     */
    /* JADX WARN: Removed duplicated region for block: B:414:0x1467  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x146c  */
    /* JADX WARN: Type inference failed for: r1v138 */
    /* JADX WARN: Type inference failed for: r1v139, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r1v317 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void QuizScreen(final long r71, final java.lang.String r73, final com.example.flashcardapp.session.McqSessionManager r74, final boolean r75, final boolean r76, final boolean r77, final int r78, boolean r79, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r80, final kotlin.jvm.functions.Function0<kotlin.Unit> r81, androidx.compose.runtime.Composer r82, final int r83, final int r84) {
        /*
            Method dump skipped, instructions count: 6661
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.ui.QuizScreenKt.QuizScreen(long, java.lang.String, com.example.flashcardapp.session.McqSessionManager, boolean, boolean, boolean, int, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean QuizScreen$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean QuizScreen$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Offset> QuizScreen$lambda$9(MutableState<List<Offset>> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean QuizScreen$lambda$12(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$13(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean QuizScreen$lambda$15(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$16(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean QuizScreen$lambda$22(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$23(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean QuizScreen$lambda$26(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$27(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean QuizScreen$lambda$29(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$30(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean QuizScreen$lambda$32(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$33(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean QuizScreen$lambda$35(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$36(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final CardEntity QuizScreen$lambda$38(MutableState<CardEntity> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final McqSessionState QuizScreen$lambda$49(MutableState<McqSessionState> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean QuizScreen$lambda$52(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$53(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean QuizScreen$lambda$56(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$57(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int QuizScreen$lambda$59(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$60(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long QuizScreen$lambda$67(MutableState<Long> mutableState) {
        return mutableState.getValue().longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$68(MutableState<Long> mutableState, long j) {
        mutableState.setValue(Long.valueOf(j));
    }

    private static final long QuizScreen$lambda$70(MutableState<Color> mutableState) {
        return mutableState.getValue().m3427unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$71(MutableState<Color> mutableState, long j) {
        mutableState.setValue(Color.m3407boximpl(j));
    }

    private static final boolean QuizScreen$lambda$73(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$74(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean QuizScreen$lambda$76(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$77(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean QuizScreen$lambda$79(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$80(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long QuizScreen$lambda$82(MutableState<Long> mutableState) {
        return mutableState.getValue().longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$83(MutableState<Long> mutableState, long j) {
        mutableState.setValue(Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long QuizScreen$lambda$129$lambda$96(MutableState<Color> mutableState) {
        return mutableState.getValue().m3427unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$129$lambda$97(MutableState<Color> mutableState, long j) {
        mutableState.setValue(Color.m3407boximpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float QuizScreen$lambda$129$lambda$99(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset QuizScreen$lambda$129$lambda$102(MutableState<Offset> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String QuizScreen$lambda$129$lambda$105(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean QuizScreen$lambda$129$lambda$109(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$129$lambda$110(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long QuizScreen$lambda$129$lambda$112(MutableState<Offset> mutableState) {
        return mutableState.getValue().getPackedValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$129$lambda$113(MutableState<Offset> mutableState, long j) {
        mutableState.setValue(Offset.m3165boximpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean QuizScreen$lambda$129$lambda$115(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$129$lambda$116(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean QuizScreen$lambda$129$lambda$118(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$129$lambda$119(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean QuizScreen$lambda$129$lambda$121(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizScreen$lambda$129$lambda$122(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizOptionCard(final String str, final String str2, final boolean z, final boolean z2, final boolean z3, final boolean z4, final Function0<Unit> function0, final boolean z5, final boolean z6, Composer composer, final int i) {
        int i2;
        long surface;
        long outlineVariant;
        long surfaceVariant;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(757045447);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= startRestartGroup.changed(z3) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= startRestartGroup.changed(z4) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i2 |= startRestartGroup.changed(z5) ? 8388608 : 4194304;
        }
        if ((234881024 & i) == 0) {
            i2 |= startRestartGroup.changed(z6) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((191739611 & i2) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(757045447, i2, -1, "com.example.flashcardapp.ui.QuizOptionCard (QuizScreen.kt:1480)");
            }
            final ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable);
            ProvidableCompositionLocal<HapticFeedback> localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localHapticFeedback);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final HapticFeedback hapticFeedback = (HapticFeedback) consume;
            startRestartGroup.startReplaceableGroup(-1782855296);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(1.0f, AnimationSpecKt.spring$default(0.5f, 200.0f, null, 4, null), 0.0f, "optionScale", null, startRestartGroup, 3120, 20);
            if (z2) {
                surface = z6 ? ColorKt.Color(4279983648L) : ThemeKt.getCorrectBg();
            } else if (z3) {
                surface = z6 ? ColorKt.Color(4290190364L) : ThemeKt.getIncorrectBg();
            } else if (z) {
                surface = colorScheme.getPrimaryContainer();
            } else {
                surface = colorScheme.getSurface();
            }
            if (z2) {
                outlineVariant = z6 ? ColorKt.Color(4291356361L) : ThemeKt.getCorrectColor();
            } else if (z3) {
                outlineVariant = z6 ? ColorKt.Color(4294954450L) : ThemeKt.getIncorrectColor();
            } else if (z) {
                outlineVariant = colorScheme.getPrimary();
            } else {
                outlineVariant = colorScheme.getOutlineVariant();
            }
            long j = outlineVariant;
            float m5738constructorimpl = (z2 || z3 || z) ? Dp.m5738constructorimpl(2) : Dp.m5738constructorimpl(1);
            if (z2) {
                surfaceVariant = z6 ? ColorKt.Color(4291356361L) : ThemeKt.getCorrectColor();
            } else if (z3) {
                surfaceVariant = z6 ? ColorKt.Color(4294954450L) : ThemeKt.getIncorrectColor();
            } else if (z) {
                surfaceVariant = colorScheme.getPrimary();
            } else {
                surfaceVariant = colorScheme.getSurfaceVariant();
            }
            final long j2 = surfaceVariant;
            if (z2) {
                Color.m3416copywmQWz5c$default(z6 ? ColorKt.Color(4291356361L) : ThemeKt.getCorrectColor(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null);
            } else if (z3) {
                Color.m3416copywmQWz5c$default(z6 ? ColorKt.Color(4294954450L) : ThemeKt.getIncorrectColor(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null);
            } else if (z) {
                colorScheme.getOnPrimary();
            } else {
                colorScheme.getOnSurfaceVariant();
            }
            composer2 = startRestartGroup;
            CardKt.Card(ClickableKt.m249clickableO2vRcR0$default(ScaleKt.scale(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), QuizOptionCard$lambda$131(animateFloatAsState)), mutableInteractionSource, null, z4, null, null, new Function0<Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$QuizOptionCard$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (z5) {
                        try {
                            hapticFeedback.mo4088performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4097getTextHandleMove5zf0vsI());
                        } catch (Exception unused) {
                        }
                    }
                    function0.invoke();
                }
            }, 24, null), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getLarge(), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(surface, 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14), CardDefaults.INSTANCE.m1296cardElevationaqJV_2Y(Dp.m5738constructorimpl((z || z2 || z3) ? 0 : 2), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, CardDefaults.$stable << 18, 62), BorderStrokeKt.m244BorderStrokecXLIe8U(m5738constructorimpl, j), ComposableLambdaKt.composableLambda(composer2, -356585067, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$QuizOptionCard$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:40:0x02f9  */
                /* JADX WARN: Removed duplicated region for block: B:45:0x0379  */
                /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:49:0x030c  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void invoke(androidx.compose.foundation.layout.ColumnScope r33, androidx.compose.runtime.Composer r34, int r35) {
                    /*
                        Method dump skipped, instructions count: 893
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.ui.QuizScreenKt$QuizOptionCard$2.invoke(androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):void");
                }
            }), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$QuizOptionCard$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    QuizScreenKt.QuizOptionCard(str, str2, z, z2, z3, z4, function0, z5, z6, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuizNavRow(final McqSessionState mcqSessionState, final boolean z, final Function0<Unit> function0, final Function0<Unit> function02, Function0<Unit> function03, Composer composer, final int i, final int i2) {
        Composer startRestartGroup = composer.startRestartGroup(-568465969);
        final Function0<Unit> function04 = (i2 & 16) != 0 ? new Function0<Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$QuizNavRow$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : function03;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-568465969, i, -1, "com.example.flashcardapp.ui.QuizNavRow (QuizScreen.kt:1595)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable);
        final boolean z2 = mcqSessionState.getCurrentQuestionIndex() >= mcqSessionState.getQuestions().size() - 1;
        boolean z3 = mcqSessionState.getMode() == McqSessionMode.TEST ? true : z;
        Modifier m571paddingVpY3zN4$default = PaddingKt.m571paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m5738constructorimpl(8), 1, null);
        float f = 12;
        Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f));
        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
        startRestartGroup.startReplaceableGroup(693286680);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m478spacedBy0680j_4, centerVertically, startRestartGroup, 54);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m571paddingVpY3zN4$default);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        Composer m2947constructorimpl = Updater.m2947constructorimpl(startRestartGroup);
        Updater.m2954setimpl(m2947constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl.getInserting() || !Intrinsics.areEqual(m2947constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m2947constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m2947constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        modifierMaterializerOf.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        boolean z4 = mcqSessionState.getCurrentQuestionIndex() > 0;
        float f2 = 1;
        float f3 = 48;
        ButtonKt.OutlinedButton(function0, SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f3)), z4, MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getMedium(), ButtonDefaults.INSTANCE.m1284outlinedButtonColorsro_MJ88(0L, colorScheme.getPrimary(), 0L, 0L, startRestartGroup, ButtonDefaults.$stable << 12, 13), null, BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(f2), mcqSessionState.getCurrentQuestionIndex() > 0 ? colorScheme.getPrimary() : Color.m3416copywmQWz5c$default(colorScheme.getOutline(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null)), null, null, ComposableSingletons$QuizScreenKt.INSTANCE.m6225getLambda26$app_release(), startRestartGroup, ((i >> 6) & 14) | 805306416, 416);
        startRestartGroup.startReplaceableGroup(1471026700);
        if (mcqSessionState.getMode() == McqSessionMode.PRACTICE && z) {
            Function0<Unit> function05 = function04;
            ButtonKt.OutlinedButton(function05, PaddingKt.m571paddingVpY3zN4$default(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f3)), Dp.m5738constructorimpl(4), 0.0f, 2, null), false, MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getMedium(), ButtonDefaults.INSTANCE.m1284outlinedButtonColorsro_MJ88(0L, colorScheme.getPrimary(), 0L, 0L, startRestartGroup, ButtonDefaults.$stable << 12, 13), null, BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(f2), colorScheme.getPrimary()), PaddingKt.m564PaddingValuesYgX7TsA$default(Dp.m5738constructorimpl(f), 0.0f, 2, null), null, ComposableSingletons$QuizScreenKt.INSTANCE.m6226getLambda27$app_release(), startRestartGroup, ((i >> 12) & 14) | 817889328, 292);
        }
        startRestartGroup.endReplaceableGroup();
        ButtonKt.Button(function02, SizeKt.m604height3ABfNKs(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m5738constructorimpl(f3)), z3, MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getMedium(), ButtonDefaults.INSTANCE.m1274buttonColorsro_MJ88(colorScheme.getPrimary(), colorScheme.getOnPrimary(), colorScheme.getSurfaceVariant(), colorScheme.getOnSurfaceVariant(), startRestartGroup, ButtonDefaults.$stable << 12, 0), null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 410433787, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$QuizNavRow$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                invoke(rowScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RowScope Button, Composer composer2, int i3) {
                String string;
                Intrinsics.checkNotNullParameter(Button, "$this$Button");
                if ((i3 & 81) != 16 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(410433787, i3, -1, "com.example.flashcardapp.ui.QuizNavRow.<anonymous>.<anonymous> (QuizScreen.kt:1653)");
                    }
                    if (z2) {
                        string = TranslationManager.INSTANCE.getString("finish_quiz");
                    } else {
                        string = TranslationManager.INSTANCE.getString("next_question");
                    }
                    TextKt.m2133Text4IGK_g(string, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelLarge(), composer2, 0, 0, 65534);
                    SpacerKt.Spacer(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(4)), composer2, 6);
                    IconKt.m1605Iconww6aTOc(KeyboardArrowRightKt.getKeyboardArrowRight(Icons.AutoMirrored.Filled.INSTANCE), (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(20)), 0L, composer2, 432, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, ((i >> 9) & 14) | 805306368, 480);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$QuizNavRow$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    QuizScreenKt.QuizNavRow(McqSessionState.this, z, function0, function02, function04, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimerChip(final long j, final boolean z, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(167668068);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(167668068, i2, -1, "com.example.flashcardapp.ui.TimerChip (QuizScreen.kt:1669)");
            }
            ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable);
            State<Float> animateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("pulse", startRestartGroup, 6, 0), 1.0f, z ? 0.5f : 1.0f, AnimationSpecKt.m131infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(500, 0, EasingKt.getFastOutSlowInEasing(), 2, null), RepeatMode.Reverse, 0L, 4, null), "timerPulse", startRestartGroup, (InfiniteRepeatableSpec.$stable << 9) | InfiniteTransition.$stable | 24624, 0);
            ChipColors m1983suggestionChipColors5tl4gsc = SuggestionChipDefaults.INSTANCE.m1983suggestionChipColors5tl4gsc(z ? colorScheme.getErrorContainer() : colorScheme.getSurfaceVariant(), z ? colorScheme.getError() : colorScheme.getOnSurfaceVariant(), z ? colorScheme.getError() : colorScheme.getOnSurfaceVariant(), 0L, 0L, 0L, startRestartGroup, SuggestionChipDefaults.$stable << 18, 56);
            BorderStroke m244BorderStrokecXLIe8U = BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(z ? 1 : 0), z ? Color.m3416copywmQWz5c$default(colorScheme.getError(), TimerChip$lambda$133(animateFloat), 0.0f, 0.0f, 0.0f, 14, null) : Color.INSTANCE.m3452getTransparent0d7_KjU());
            composer2 = startRestartGroup;
            ChipKt.SuggestionChip((Function0<Unit>) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$TimerChip$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -413605850, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$TimerChip$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    if ((i3 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-413605850, i3, -1, "com.example.flashcardapp.ui.TimerChip.<anonymous> (QuizScreen.kt:1685)");
                        }
                        TextKt.m2133Text4IGK_g(TranslationManager.INSTANCE.getString("time_limit_sec_short", Long.valueOf(j)), (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getLabelMedium(), composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65502);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), PaddingKt.m573paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m5738constructorimpl(8), 0.0f, 11, null), false, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$QuizScreenKt.INSTANCE.m6227getLambda28$app_release(), (Shape) null, m1983suggestionChipColors5tl4gsc, (ChipElevation) null, m244BorderStrokecXLIe8U, (MutableInteractionSource) null, startRestartGroup, 25014, 680);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$TimerChip$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    QuizScreenKt.TimerChip(j, z, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String formatTime(long j) {
        long j2 = 60;
        long j3 = j / j2;
        long j4 = j % j2;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j3), Long.valueOf(j4)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final void EditModeSelectionDialog(final Function0<Unit> onDismiss, final Function0<Unit> onEditCurrent, final Function0<Unit> onEditWholePack, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onEditCurrent, "onEditCurrent");
        Intrinsics.checkNotNullParameter(onEditWholePack, "onEditWholePack");
        Composer startRestartGroup = composer.startRestartGroup(-557340920);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(onDismiss) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(onEditCurrent) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(onEditWholePack) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-557340920, i3, -1, "com.example.flashcardapp.ui.EditModeSelectionDialog (QuizScreen.kt:1719)");
            }
            composer2 = startRestartGroup;
            AndroidAlertDialog_androidKt.m1232AlertDialogOix01E0(onDismiss, ComposableSingletons$QuizScreenKt.INSTANCE.m6228getLambda29$app_release(), null, null, null, ComposableSingletons$QuizScreenKt.INSTANCE.m6230getLambda30$app_release(), ComposableLambdaKt.composableLambda(startRestartGroup, 1445628315, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$EditModeSelectionDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    if ((i4 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1445628315, i4, -1, "com.example.flashcardapp.ui.EditModeSelectionDialog.<anonymous> (QuizScreen.kt:1730)");
                        }
                        Modifier m571paddingVpY3zN4$default = PaddingKt.m571paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m5738constructorimpl(8), 1, null);
                        Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(12));
                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                        final Function0<Unit> function0 = onEditCurrent;
                        final Function0<Unit> function02 = onDismiss;
                        final Function0<Unit> function03 = onEditWholePack;
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_4, centerHorizontally, composer3, 54);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m571paddingVpY3zN4$default);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer m2947constructorimpl = Updater.m2947constructorimpl(composer3);
                        Updater.m2954setimpl(m2947constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl.getInserting() || !Intrinsics.areEqual(m2947constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m2947constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m2947constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        composer3.startReplaceableGroup(-34768927);
                        boolean changedInstance = composer3.changedInstance(function0) | composer3.changedInstance(function02);
                        Object rememberedValue = composer3.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$EditModeSelectionDialog$1$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function0.invoke();
                                    function02.invoke();
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        composer3.endReplaceableGroup();
                        float f = 48;
                        ButtonKt.Button((Function0) rememberedValue, SizeKt.m604height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(f)), false, RoundedCornerShapeKt.RoundedCornerShape(50), null, null, null, null, null, ComposableSingletons$QuizScreenKt.INSTANCE.m6231getLambda31$app_release(), composer3, 805306416, 500);
                        composer3.startReplaceableGroup(-34768513);
                        boolean changedInstance2 = composer3.changedInstance(function03) | composer3.changedInstance(function02);
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$EditModeSelectionDialog$1$1$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function03.invoke();
                                    function02.invoke();
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        ButtonKt.OutlinedButton((Function0) rememberedValue2, SizeKt.m604height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(f)), false, RoundedCornerShapeKt.RoundedCornerShape(50), null, null, BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(1), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOutline()), null, null, ComposableSingletons$QuizScreenKt.INSTANCE.m6232getLambda32$app_release(), composer3, 805306416, 436);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getLarge(), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getSurface(), 0L, 0L, 0L, 0.0f, null, composer2, (i3 & 14) | 1772592, 0, 15892);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$EditModeSelectionDialog$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    QuizScreenKt.EditModeSelectionDialog(onDismiss, onEditCurrent, onEditWholePack, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void EditWholePackScreen(final String deckName, final List<CardEntity> cards, final Function1<? super CardEntity, Unit> onCardClick, final Function0<Unit> onBackPressed, Composer composer, final int i) {
        List emptyList;
        Intrinsics.checkNotNullParameter(deckName, "deckName");
        Intrinsics.checkNotNullParameter(cards, "cards");
        Intrinsics.checkNotNullParameter(onCardClick, "onCardClick");
        Intrinsics.checkNotNullParameter(onBackPressed, "onBackPressed");
        Composer startRestartGroup = composer.startRestartGroup(-514980523);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-514980523, i, -1, "com.example.flashcardapp.ui.EditWholePackScreen (QuizScreen.kt:1772)");
        }
        final ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable);
        startRestartGroup.startReplaceableGroup(-737035908);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        String EditWholePackScreen$lambda$135 = EditWholePackScreen$lambda$135(mutableState);
        startRestartGroup.startReplaceableGroup(-737035851);
        boolean changed = startRestartGroup.changed(EditWholePackScreen$lambda$135) | startRestartGroup.changed(cards);
        ArrayList rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            if (StringsKt.isBlank(EditWholePackScreen$lambda$135(mutableState))) {
                rememberedValue2 = cards;
            } else {
                ArrayList arrayList = new ArrayList();
                for (Object obj : cards) {
                    CardEntity cardEntity = (CardEntity) obj;
                    ParsedCard parseCard = StructuredParser.INSTANCE.parseCard(cardEntity.getFront(), cardEntity.getBack());
                    String question = parseCard.getQuestion();
                    if (question.length() == 0) {
                        question = cardEntity.getFront();
                    }
                    String str = question;
                    String answer = parseCard.getAnswer();
                    String explanation = parseCard.getExplanation();
                    try {
                        emptyList = (List) new Gson().fromJson(cardEntity.getTags(), new TypeToken<List<? extends String>>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$EditWholePackScreen$filteredCards$1$1$tags$type$1
                        }.getType());
                        if (emptyList == null) {
                            emptyList = CollectionsKt.emptyList();
                        } else {
                            Intrinsics.checkNotNull(emptyList);
                        }
                    } catch (Exception unused) {
                        emptyList = CollectionsKt.emptyList();
                    }
                    if (!StringsKt.contains((CharSequence) str, (CharSequence) EditWholePackScreen$lambda$135(mutableState), true) && !StringsKt.contains((CharSequence) answer, (CharSequence) EditWholePackScreen$lambda$135(mutableState), true) && !StringsKt.contains((CharSequence) explanation, (CharSequence) EditWholePackScreen$lambda$135(mutableState), true)) {
                        List list = emptyList;
                        if (!(list instanceof Collection) || !list.isEmpty()) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                if (StringsKt.contains((CharSequence) it.next(), (CharSequence) EditWholePackScreen$lambda$135(mutableState), true)) {
                                }
                            }
                        }
                    }
                    arrayList.add(obj);
                }
                rememberedValue2 = arrayList;
            }
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        final List list2 = (List) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        ScaffoldKt.m1788ScaffoldTvnljyQ(null, ComposableLambdaKt.composableLambda(startRestartGroup, 1792721689, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$EditWholePackScreen$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                if ((i2 & 11) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1792721689, i2, -1, "com.example.flashcardapp.ui.EditWholePackScreen.<anonymous> (QuizScreen.kt:1802)");
                    }
                    final String str2 = deckName;
                    final ColorScheme colorScheme2 = ColorScheme.this;
                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, -549869611, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$EditWholePackScreen$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i3) {
                            TextStyle m5264copyp1EtxEg;
                            if ((i3 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-549869611, i3, -1, "com.example.flashcardapp.ui.EditWholePackScreen.<anonymous>.<anonymous> (QuizScreen.kt:1804)");
                                }
                                String str3 = str2;
                                ColorScheme colorScheme3 = colorScheme2;
                                composer3.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                Modifier.Companion companion = Modifier.INSTANCE;
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m2947constructorimpl = Updater.m2947constructorimpl(composer3);
                                Updater.m2954setimpl(m2947constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m2954setimpl(m2947constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m2947constructorimpl.getInserting() || !Intrinsics.areEqual(m2947constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m2947constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m2947constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                m5264copyp1EtxEg = r16.m5264copyp1EtxEg((r48 & 1) != 0 ? r16.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r16.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r16.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r16.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r16.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r16.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r16.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r16.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r16.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r16.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r16.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r16.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r16.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r16.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r16.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r16.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r16.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r16.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r16.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r16.platformStyle : null, (r48 & 1048576) != 0 ? r16.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r16.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r16.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getTitleMedium().paragraphStyle.getTextMotion() : null);
                                TextKt.m2133Text4IGK_g("Edit Pack: " + str3, (Modifier) null, colorScheme3.getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg, composer3, 0, 0, 65530);
                                TextKt.m2133Text4IGK_g("All the questions in this pack", (Modifier) null, colorScheme3.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getLabelSmall(), composer3, 6, 0, 65530);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    });
                    final Function0<Unit> function0 = onBackPressed;
                    AppBarKt.TopAppBar(composableLambda, null, ComposableLambdaKt.composableLambda(composer2, -2052967917, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$EditWholePackScreen$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i3) {
                            if ((i3 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2052967917, i3, -1, "com.example.flashcardapp.ui.EditWholePackScreen.<anonymous>.<anonymous> (QuizScreen.kt:1818)");
                                }
                                IconButtonKt.IconButton(function0, null, false, null, null, ComposableSingletons$QuizScreenKt.INSTANCE.m6233getLambda33$app_release(), composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), null, null, TopAppBarDefaults.INSTANCE.m2292topAppBarColorszjMxDiM(ColorScheme.this.getBackground(), 0L, 0L, 0L, 0L, composer2, TopAppBarDefaults.$stable << 15, 30), null, composer2, 390, 90);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), null, null, null, 0, colorScheme.getBackground(), 0L, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1781576028, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$EditWholePackScreen$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer2, Integer num) {
                invoke(paddingValues, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PaddingValues paddingValues, Composer composer2, int i2) {
                String EditWholePackScreen$lambda$1352;
                TextStyle m5264copyp1EtxEg;
                TextStyle m5264copyp1EtxEg2;
                TextStyle m5264copyp1EtxEg3;
                TextStyle m5264copyp1EtxEg4;
                List emptyList2;
                Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                int i3 = (i2 & 14) == 0 ? i2 | (composer2.changed(paddingValues) ? 4 : 2) : i2;
                if ((i3 & 91) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1781576028, i3, -1, "com.example.flashcardapp.ui.EditWholePackScreen.<anonymous> (QuizScreen.kt:1830)");
                    }
                    float f = 8;
                    Modifier m570paddingVpY3zN4 = PaddingKt.m570paddingVpY3zN4(PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues), Dp.m5738constructorimpl(16), Dp.m5738constructorimpl(f));
                    ColorScheme colorScheme2 = ColorScheme.this;
                    final MutableState<String> mutableState2 = mutableState;
                    List<CardEntity> list3 = list2;
                    Function1<CardEntity, Unit> function1 = onCardClick;
                    composer2.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m570paddingVpY3zN4);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer m2947constructorimpl = Updater.m2947constructorimpl(composer2);
                    Updater.m2954setimpl(m2947constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl.getInserting() || !Intrinsics.areEqual(m2947constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m2947constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m2947constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    EditWholePackScreen$lambda$1352 = QuizScreenKt.EditWholePackScreen$lambda$135(mutableState2);
                    float f2 = 12;
                    Modifier m573paddingqDBjuR0$default = PaddingKt.m573paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m5738constructorimpl(f2), 7, null);
                    Function1<CardEntity, Unit> function12 = function1;
                    TextFieldColors m1735colors0hiis_0 = OutlinedTextFieldDefaults.INSTANCE.m1735colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, colorScheme2.getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, colorScheme2.getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, 0, 0, 0, 3072, 2139092991, 4095);
                    composer2.startReplaceableGroup(838736559);
                    Object rememberedValue3 = composer2.rememberedValue();
                    if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = (Function1) new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$EditWholePackScreen$2$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                                invoke2(str2);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String it2) {
                                Intrinsics.checkNotNullParameter(it2, "it");
                                mutableState2.setValue(it2);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue3);
                    }
                    composer2.endReplaceableGroup();
                    OutlinedTextFieldKt.OutlinedTextField(EditWholePackScreen$lambda$1352, (Function1<? super String, Unit>) rememberedValue3, m573paddingqDBjuR0$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$QuizScreenKt.INSTANCE.m6234getLambda34$app_release(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$QuizScreenKt.INSTANCE.m6235getLambda35$app_release(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, m1735colors0hiis_0, composer2, 102236592, 12582912, 0, 4062904);
                    Modifier m570paddingVpY3zN42 = PaddingKt.m570paddingVpY3zN4(BackgroundKt.m216backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), colorScheme2.getSurfaceVariant(), null, 2, null), Dp.m5738constructorimpl(f), Dp.m5738constructorimpl(f2));
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f));
                    composer2.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m478spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m570paddingVpY3zN42);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    Composer m2947constructorimpl2 = Updater.m2947constructorimpl(composer2);
                    Updater.m2954setimpl(m2947constructorimpl2, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl2.getInserting() || !Intrinsics.areEqual(m2947constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m2947constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m2947constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    modifierMaterializerOf2.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    m5264copyp1EtxEg = r29.m5264copyp1EtxEg((r48 & 1) != 0 ? r29.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r29.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r29.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r29.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r29.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r29.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r29.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r29.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r29.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r29.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r29.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r29.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r29.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r29.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r29.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r29.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r29.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r29.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r29.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r29.platformStyle : null, (r48 & 1048576) != 0 ? r29.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r29.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r29.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelMedium().paragraphStyle.getTextMotion() : null);
                    String str2 = "C92@4661L9:Row.kt#2w3rfo";
                    String str3 = "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo";
                    TextKt.m2133Text4IGK_g("Question", RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 0.3f, false, 2, null), colorScheme2.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg, composer2, 6, 0, 65528);
                    m5264copyp1EtxEg2 = r29.m5264copyp1EtxEg((r48 & 1) != 0 ? r29.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r29.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r29.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r29.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r29.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r29.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r29.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r29.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r29.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r29.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r29.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r29.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r29.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r29.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r29.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r29.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r29.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r29.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r29.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r29.platformStyle : null, (r48 & 1048576) != 0 ? r29.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r29.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r29.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelMedium().paragraphStyle.getTextMotion() : null);
                    TextKt.m2133Text4IGK_g("Answer", RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 0.25f, false, 2, null), colorScheme2.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg2, composer2, 6, 0, 65528);
                    m5264copyp1EtxEg3 = r29.m5264copyp1EtxEg((r48 & 1) != 0 ? r29.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r29.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r29.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r29.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r29.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r29.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r29.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r29.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r29.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r29.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r29.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r29.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r29.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r29.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r29.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r29.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r29.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r29.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r29.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r29.platformStyle : null, (r48 & 1048576) != 0 ? r29.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r29.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r29.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelMedium().paragraphStyle.getTextMotion() : null);
                    TextKt.m2133Text4IGK_g("Explanation", RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 0.25f, false, 2, null), colorScheme2.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg3, composer2, 6, 0, 65528);
                    m5264copyp1EtxEg4 = r29.m5264copyp1EtxEg((r48 & 1) != 0 ? r29.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r29.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r29.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r29.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r29.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r29.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r29.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r29.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r29.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r29.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r29.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r29.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r29.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r29.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r29.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r29.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r29.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r29.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r29.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r29.platformStyle : null, (r48 & 1048576) != 0 ? r29.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r29.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r29.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelMedium().paragraphStyle.getTextMotion() : null);
                    TextKt.m2133Text4IGK_g("Tags", RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 0.2f, false, 2, null), colorScheme2.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg4, composer2, 6, 0, 65528);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    int i4 = 1;
                    Object obj2 = null;
                    float f3 = 0.0f;
                    int i5 = 0;
                    Modifier verticalScroll$default = ScrollKt.verticalScroll$default(ColumnScope.weight$default(columnScopeInstance, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null), ScrollKt.rememberScrollState(0, composer2, 0, 1), false, null, false, 14, null);
                    composer2.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                    int i6 = -1323940314;
                    composer2.startReplaceableGroup(-1323940314);
                    String str4 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
                    ComposerKt.sourceInformation(composer2, str4);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(verticalScroll$default);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    Composer m2947constructorimpl3 = Updater.m2947constructorimpl(composer2);
                    Updater.m2954setimpl(m2947constructorimpl3, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                    int i7 = 2058660585;
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    if (list3.isEmpty()) {
                        composer2.startReplaceableGroup(-651407130);
                        Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(48));
                        Alignment center = Alignment.INSTANCE.getCenter();
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, str4);
                        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor4);
                        } else {
                            composer2.useNode();
                        }
                        Composer m2947constructorimpl4 = Updater.m2947constructorimpl(composer2);
                        Updater.m2954setimpl(m2947constructorimpl4, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                        }
                        modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        TextKt.m2133Text4IGK_g("No questions found in this pack.", (Modifier) null, colorScheme2.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 6, 0, 65530);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                    } else {
                        Composer composer3 = composer2;
                        composer3.startReplaceableGroup(-651406634);
                        int i8 = 0;
                        for (Object obj3 : list3) {
                            int i9 = i8 + 1;
                            if (i8 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            final CardEntity cardEntity2 = (CardEntity) obj3;
                            String front = cardEntity2.getFront();
                            String back = cardEntity2.getBack();
                            composer3.startReplaceableGroup(-228403488);
                            boolean changed2 = composer3.changed(front) | composer3.changed(back);
                            Object rememberedValue4 = composer2.rememberedValue();
                            if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = StructuredParser.INSTANCE.parseCard(cardEntity2.getFront(), cardEntity2.getBack());
                                composer3.updateRememberedValue(rememberedValue4);
                            }
                            ParsedCard parsedCard = (ParsedCard) rememberedValue4;
                            composer2.endReplaceableGroup();
                            String question2 = parsedCard.getQuestion();
                            if (question2.length() == 0) {
                                question2 = StringsKt.trim((CharSequence) cardEntity2.getFront()).toString();
                            }
                            String str5 = question2;
                            String answer2 = parsedCard.getAnswer();
                            String explanation2 = parsedCard.getExplanation();
                            String tags = cardEntity2.getTags();
                            composer3.startReplaceableGroup(-228403058);
                            boolean changed3 = composer3.changed(tags);
                            Object rememberedValue5 = composer2.rememberedValue();
                            if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                try {
                                    emptyList2 = (List) new Gson().fromJson(cardEntity2.getTags(), new TypeToken<List<? extends String>>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$EditWholePackScreen$2$1$3$2$tagsList$1$type$1
                                    }.getType());
                                    if (emptyList2 == null) {
                                        emptyList2 = CollectionsKt.emptyList();
                                    } else {
                                        Intrinsics.checkNotNull(emptyList2);
                                    }
                                } catch (Exception unused2) {
                                    emptyList2 = CollectionsKt.emptyList();
                                }
                                rememberedValue5 = emptyList2;
                                composer3.updateRememberedValue(rememberedValue5);
                            }
                            List list4 = (List) rememberedValue5;
                            composer2.endReplaceableGroup();
                            Modifier m216backgroundbw27NRU$default = BackgroundKt.m216backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, f3, i4, obj2), i8 % 2 == 0 ? colorScheme2.getSurface() : Color.m3416copywmQWz5c$default(colorScheme2.getSurface(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
                            composer3.startReplaceableGroup(-228402288);
                            final Function1<CardEntity, Unit> function13 = function12;
                            boolean changedInstance = composer3.changedInstance(function13) | composer3.changed(cardEntity2);
                            Object rememberedValue6 = composer2.rememberedValue();
                            if (changedInstance || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue6 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$EditWholePackScreen$2$1$3$2$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        function13.invoke(cardEntity2);
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue6);
                            }
                            composer2.endReplaceableGroup();
                            Modifier m570paddingVpY3zN43 = PaddingKt.m570paddingVpY3zN4(ClickableKt.m251clickableXHw0xAI$default(m216backgroundbw27NRU$default, false, null, null, (Function0) rememberedValue6, 7, null), Dp.m5738constructorimpl(f), Dp.m5738constructorimpl(f2));
                            Arrangement.HorizontalOrVertical m478spacedBy0680j_42 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f));
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            composer3.startReplaceableGroup(693286680);
                            String str6 = str3;
                            ComposerKt.sourceInformation(composer3, str6);
                            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m478spacedBy0680j_42, centerVertically, composer3, 54);
                            composer3.startReplaceableGroup(i6);
                            ComposerKt.sourceInformation(composer3, str4);
                            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer3, i5);
                            CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(m570paddingVpY3zN43);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer3.createNode(constructor5);
                            } else {
                                composer2.useNode();
                            }
                            Composer m2947constructorimpl5 = Updater.m2947constructorimpl(composer2);
                            Updater.m2954setimpl(m2947constructorimpl5, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m2954setimpl(m2947constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m2947constructorimpl5.getInserting() || !Intrinsics.areEqual(m2947constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                                m2947constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                                m2947constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                            }
                            modifierMaterializerOf5.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer3, Integer.valueOf(i5));
                            composer3.startReplaceableGroup(i7);
                            String str7 = str2;
                            ComposerKt.sourceInformationMarkerStart(composer3, -326681643, str7);
                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                            String str8 = str4;
                            int i10 = i5;
                            int i11 = i4;
                            Object obj4 = obj2;
                            float f4 = f3;
                            int i12 = i7;
                            TextKt.m2133Text4IGK_g(str5, RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 0.3f, false, 2, null), colorScheme2.getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m5680getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBodyMedium(), composer2, 0, 3120, 55288);
                            TextKt.m2133Text4IGK_g(answer2, RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 0.25f, false, 2, null), colorScheme2.getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m5680getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 0, 3120, 55288);
                            String str9 = explanation2;
                            String str10 = "None";
                            if (str9.length() == 0) {
                                str9 = "None";
                            }
                            TextKt.m2133Text4IGK_g(str9, RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 0.25f, false, 2, null), colorScheme2.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m5680getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 0, 3120, 55288);
                            String joinToString$default = CollectionsKt.joinToString$default(list4, ", ", null, null, 0, null, null, 62, null);
                            if (joinToString$default.length() != 0) {
                                str10 = joinToString$default;
                            }
                            TextKt.m2133Text4IGK_g(str10, RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 0.2f, false, 2, null), colorScheme2.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m5680getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 0, 3120, 55288);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            DividerKt.m1532HorizontalDivider9IZ8Weo(null, 0.0f, Color.m3416copywmQWz5c$default(colorScheme2.getOutlineVariant(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), composer2, 0, 3);
                            composer3 = composer2;
                            i8 = i9;
                            str3 = str6;
                            function12 = function13;
                            str4 = str8;
                            str2 = str7;
                            i6 = -1323940314;
                            i5 = i10;
                            i4 = i11;
                            obj2 = obj4;
                            f3 = f4;
                            i7 = i12;
                        }
                        composer2.endReplaceableGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, 805306416, 445);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$EditWholePackScreen$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    QuizScreenKt.EditWholePackScreen(deckName, cards, onCardClick, onBackPressed, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String EditWholePackScreen$lambda$135(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final List<CardEntity> QuizScreen$lambda$41(State<? extends List<CardEntity>> state) {
        return state.getValue();
    }

    private static final float QuizScreen$lambda$63$lambda$62$lambda$61(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float QuizScreen$lambda$84(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float QuizOptionCard$lambda$131(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float TimerChip$lambda$133(State<Float> state) {
        return state.getValue().floatValue();
    }
}
