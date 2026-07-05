package com.example.flashcardapp.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.widget.Toast;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
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
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.material.icons.filled.PersonKt;
import androidx.compose.material.icons.outlined.AlarmKt;
import androidx.compose.material.icons.outlined.AutoAwesomeKt;
import androidx.compose.material.icons.outlined.BrushKt;
import androidx.compose.material.icons.outlined.CheckCircleKt;
import androidx.compose.material.icons.outlined.ColorLensKt;
import androidx.compose.material.icons.outlined.ContrastKt;
import androidx.compose.material.icons.outlined.DirectionsRunKt;
import androidx.compose.material.icons.outlined.FolderOpenKt;
import androidx.compose.material.icons.outlined.FontDownloadKt;
import androidx.compose.material.icons.outlined.GestureKt;
import androidx.compose.material.icons.outlined.LibraryBooksKt;
import androidx.compose.material.icons.outlined.PaletteKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldDefaults;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.SliderDefaults;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.SwitchDefaults;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.PointerIconCompat;
import coil.compose.SingletonAsyncImageKt;
import com.example.flashcardapp.data.AppLanguage;
import com.example.flashcardapp.data.SettingsRepository;
import com.example.flashcardapp.data.TranslationManager;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: SettingsTab.kt */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u001av\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010\u0015\u001ao\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\u0018\u001a\u00020\u00032\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\u001a\u001a\u00020\u00032\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001dH\u0007¢\u0006\u0002\u0010\u001e\u001a\u0098\u0002\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u00052\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00052\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u00102\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\f2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\f2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u00101\u001a\u00020\u00102\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a\u0016\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208\u001a\u000e\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006;²\u0006\f\u0010<\u001a\u0004\u0018\u00010\u0003X\u008a\u008e\u0002²\u0006\n\u0010=\u001a\u00020>X\u008a\u0084\u0002²\u0006\f\u0010?\u001a\u0004\u0018\u00010\u0003X\u008a\u008e\u0002²\u0006\u0018\u0010@\u001a\u0010\u0012\f\u0012\n B*\u0004\u0018\u00010A0A0\u0007X\u008a\u008e\u0002²\u0006\n\u0010C\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010D\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010E\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010F\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010G\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010H\u001a\u00020IX\u008a\u008e\u0002²\u0006\n\u0010J\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010K\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010L\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010M\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010N\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010O\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010P\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010Q\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010R\u001a\u00020IX\u008a\u008e\u0002²\u0006\n\u0010S\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010T\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010U\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010V\u001a\u00020WX\u008a\u008e\u0002²\u0006\n\u0010X\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010Y\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010Z\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010[\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\\\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010]\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"PresetDropdownWithManualInput", "", "label", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "presets", "", "presetLabels", "customLabel", "maxCustomValue", "onValueChange", "Lkotlin/Function1;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "isDarkMode", "", "PresetDropdownWithManualInput-lmFMXvc", "(Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;ILkotlin/jvm/functions/Function1;JZLandroidx/compose/runtime/Composer;II)V", "SectionLabel", "text", "(Ljava/lang/String;ZLandroidx/compose/runtime/Composer;II)V", "SettingsTab", "onDarkModeToggle", "themePreset", "onThemePresetChange", "fontFamilyType", "onFontFamilyTypeChange", "onNavigateToProfile", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "StudyModeCard", "title", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "headerBg", "textColor", "questionLimit", "onQuestionLimitChange", "timeLimitSeconds", "onTimeLimitSecondsChange", "timePresets", "timePresetLabels", "timeCustomLabel", "selectedAlgorithm", "algoExpanded", "onAlgoExpandedChange", "onAlgoSelected", "algoOptions", "isPracticeMode", "StudyModeCard-jwffKRY", "(Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;JJILkotlin/jvm/functions/Function1;Ljava/util/List;Ljava/util/List;ILjava/lang/String;ILkotlin/jvm/functions/Function1;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/util/List;ZZLandroidx/compose/runtime/Composer;IIII)V", "getFileName", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "sha256", "input", "app_release", "avatarUriStr", "currentLanguage", "Lcom/example/flashcardapp/data/AppLanguage;", "customFontPath", "addedFonts", "Ljava/io/File;", "kotlin.jvm.PlatformType", "dailyMasteryGoal", "defaultAlgorithm", "hapticEnabled", "showExplanations", "whiteboardAutoStylusMode", "whiteboardHighlighterAlpha", "", "whiteboardDefaultPenColor", "showGuideModal", "practiceAlgorithm", "practiceAlgoExpanded", "mockQuestionLimit", "mockTimeLimitSec", "mockAlgorithm", "mockAlgoExpanded", "revisionBatchSize", "revisionAlgorithm", "revisionAlgoExpanded", "globalModeExpanded", "activeGlobalMode", "Lcom/example/flashcardapp/session/McqSessionMode;", "langExpanded", "tapCount", "showPasswordDialog", "passwordInput", "expanded", "customText"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class SettingsTabKt {
    public static final String sha256(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = input.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] digest = messageDigest.digest(bytes);
        Intrinsics.checkNotNull(digest);
        return ArraysKt.joinToString$default(digest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$sha256$1
            public final CharSequence invoke(byte b) {
                String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                return format;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
                return invoke(b.byteValue());
            }
        }, 30, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0045 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String getFileName(android.content.Context r9, android.net.Uri r10) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = r10.getScheme()
            java.lang.String r1 = "content"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L49
            android.content.ContentResolver r3 = r9.getContentResolver()
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r4 = r10
            android.database.Cursor r9 = r3.query(r4, r5, r6, r7, r8)
            if (r9 == 0) goto L42
            boolean r0 = r9.moveToFirst()     // Catch: java.lang.Throwable -> L3b
            if (r0 == 0) goto L42
            java.lang.String r0 = "_display_name"
            int r0 = r9.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L3b
            if (r0 == r1) goto L42
            java.lang.String r0 = r9.getString(r0)     // Catch: java.lang.Throwable -> L3b
            goto L43
        L3b:
            r10 = move-exception
            if (r9 == 0) goto L41
            r9.close()
        L41:
            throw r10
        L42:
            r0 = r2
        L43:
            if (r9 == 0) goto L4a
            r9.close()
            goto L4a
        L49:
            r0 = r2
        L4a:
            if (r0 != 0) goto L72
            java.lang.String r0 = r10.getPath()
            if (r0 == 0) goto L60
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4 = 47
            r5 = 0
            r6 = 0
            r7 = 6
            r8 = 0
            int r9 = kotlin.text.StringsKt.lastIndexOf$default(r3, r4, r5, r6, r7, r8)
            goto L61
        L60:
            r9 = r1
        L61:
            if (r9 == r1) goto L72
            if (r0 == 0) goto L71
            int r9 = r9 + 1
            java.lang.String r2 = r0.substring(r9)
            java.lang.String r9 = "substring(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)
        L71:
            r0 = r2
        L72:
            if (r0 != 0) goto L8d
            long r9 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "custom_font_"
            r0.<init>(r1)
            java.lang.StringBuilder r9 = r0.append(r9)
            java.lang.String r10 = ".ttf"
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r0 = r9.toString()
        L8d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.ui.SettingsTabKt.getFileName(android.content.Context, android.net.Uri):java.lang.String");
    }

    public static final void SettingsTab(final boolean z, final Function1<? super Boolean, Unit> onDarkModeToggle, final String themePreset, final Function1<? super String, Unit> onThemePresetChange, final String fontFamilyType, final Function1<? super String, Unit> onFontFamilyTypeChange, final Function0<Unit> onNavigateToProfile, Composer composer, final int i) {
        int i2;
        MutableState mutableState;
        MutableState mutableState2;
        MutableState mutableState3;
        MutableState mutableState4;
        MutableState mutableState5;
        int i3;
        SnapshotMutationPolicy snapshotMutationPolicy;
        Composer composer2;
        final MutableState mutableState6;
        ArrayList emptyList;
        MutableState mutableStateOf$default;
        File[] fileArr;
        int i4;
        Intrinsics.checkNotNullParameter(onDarkModeToggle, "onDarkModeToggle");
        Intrinsics.checkNotNullParameter(themePreset, "themePreset");
        Intrinsics.checkNotNullParameter(onThemePresetChange, "onThemePresetChange");
        Intrinsics.checkNotNullParameter(fontFamilyType, "fontFamilyType");
        Intrinsics.checkNotNullParameter(onFontFamilyTypeChange, "onFontFamilyTypeChange");
        Intrinsics.checkNotNullParameter(onNavigateToProfile, "onNavigateToProfile");
        Composer startRestartGroup = composer.startRestartGroup(-1299324905);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(onDarkModeToggle) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(themePreset) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changedInstance(onThemePresetChange) ? 2048 : 1024;
        }
        if ((458752 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(onFontFamilyTypeChange) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(onNavigateToProfile) ? 1048576 : 524288;
        }
        if ((2954971 & i2) != 590994 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1299324905, i2, -1, "com.example.flashcardapp.ui.SettingsTab (SettingsTab.kt:86)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Context context = (Context) consume;
            startRestartGroup.startReplaceableGroup(-1958787796);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SettingsRepository.INSTANCE.getInstance(context);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final SettingsRepository settingsRepository = (SettingsRepository) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958787721);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = context.getSharedPreferences("AnkiPrepProfile", 0);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final SharedPreferences sharedPreferences = (SharedPreferences) rememberedValue2;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958787598);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(sharedPreferences.getString("avatar_uri", null), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            MutableState mutableState7 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(sharedPreferences, new SettingsTabKt$SettingsTab$1(sharedPreferences, mutableState7), startRestartGroup, 8);
            String SettingsTab$lambda$3 = SettingsTab$lambda$3(mutableState7);
            startRestartGroup.startReplaceableGroup(-1958787051);
            boolean changed = startRestartGroup.changed(SettingsTab$lambda$3);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                String SettingsTab$lambda$32 = SettingsTab$lambda$3(mutableState7);
                rememberedValue4 = SettingsTab$lambda$32 != null ? Uri.parse(SettingsTab$lambda$32) : null;
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            Uri uri = (Uri) rememberedValue4;
            startRestartGroup.endReplaceableGroup();
            State collectAsState = SnapshotStateKt.collectAsState(TranslationManager.INSTANCE.getCurrentLanguage(), null, startRestartGroup, 8, 1);
            startRestartGroup.startReplaceableGroup(-1958786840);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(settingsRepository.getCustomFontPath(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState8 = (MutableState) rememberedValue5;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958786763);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                File[] listFiles = new File(context.getFilesDir(), "fonts").listFiles();
                if (listFiles == null) {
                    emptyList = CollectionsKt.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList();
                    int length = listFiles.length;
                    int i5 = 0;
                    while (i5 < length) {
                        File file = listFiles[i5];
                        if (file.isFile()) {
                            fileArr = listFiles;
                            String name = file.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                            i4 = length;
                            if (!StringsKt.endsWith(name, ".ttf", true)) {
                                String name2 = file.getName();
                                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                                if (!StringsKt.endsWith(name2, ".otf", true)) {
                                }
                            }
                            arrayList.add(file);
                        } else {
                            fileArr = listFiles;
                            i4 = length;
                        }
                        i5++;
                        listFiles = fileArr;
                        length = i4;
                    }
                    emptyList = arrayList;
                }
                mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(emptyList, null, 2, null);
                startRestartGroup.updateRememberedValue(mutableStateOf$default);
                rememberedValue6 = mutableStateOf$default;
            }
            final MutableState mutableState9 = (MutableState) rememberedValue6;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958786437);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(settingsRepository.getQuestionLimit()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final MutableState mutableState10 = (MutableState) rememberedValue7;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958786355);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(settingsRepository.getDefaultAlgorithm(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958786273);
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                rememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(settingsRepository.getVibrationEnabled()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958786188);
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                rememberedValue10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(settingsRepository.getShowExplanations()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            final MutableState mutableState11 = (MutableState) rememberedValue10;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958786095);
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                rememberedValue11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(settingsRepository.getWhiteboardAutoStylusMode()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            final MutableState mutableState12 = (MutableState) rememberedValue11;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958785992);
            Object rememberedValue12 = startRestartGroup.rememberedValue();
            if (rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                rememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(settingsRepository.getWhiteboardHighlighterAlpha()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            final MutableState mutableState13 = (MutableState) rememberedValue12;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958785888);
            Object rememberedValue13 = startRestartGroup.rememberedValue();
            if (rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                rememberedValue13 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(settingsRepository.getWhiteboardDefaultPenColor(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue13);
            }
            final MutableState mutableState14 = (MutableState) rememberedValue13;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958785795);
            Object rememberedValue14 = startRestartGroup.rememberedValue();
            if (rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                rememberedValue14 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue14);
            }
            final MutableState mutableState15 = (MutableState) rememberedValue14;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958785700);
            Object rememberedValue15 = startRestartGroup.rememberedValue();
            if (rememberedValue15 == Composer.INSTANCE.getEmpty()) {
                rememberedValue15 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("Spaced Repetition", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue15);
            }
            final MutableState mutableState16 = (MutableState) rememberedValue15;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958785619);
            Object rememberedValue16 = startRestartGroup.rememberedValue();
            if (rememberedValue16 == Composer.INSTANCE.getEmpty()) {
                rememberedValue16 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue16);
            }
            MutableState mutableState17 = (MutableState) rememberedValue16;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958785530);
            Object rememberedValue17 = startRestartGroup.rememberedValue();
            if (rememberedValue17 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState17;
                rememberedValue17 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(settingsRepository.getQuestionLimit()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue17);
            } else {
                mutableState = mutableState17;
            }
            MutableState mutableState18 = (MutableState) rememberedValue17;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958785448);
            Object rememberedValue18 = startRestartGroup.rememberedValue();
            if (rememberedValue18 == Composer.INSTANCE.getEmpty()) {
                mutableState2 = mutableState18;
                rememberedValue18 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(settingsRepository.getTimeLimitSeconds()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue18);
            } else {
                mutableState2 = mutableState18;
            }
            MutableState mutableState19 = (MutableState) rememberedValue18;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958785366);
            Object rememberedValue19 = startRestartGroup.rememberedValue();
            if (rememberedValue19 == Composer.INSTANCE.getEmpty()) {
                mutableState3 = mutableState19;
                rememberedValue19 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("Exam Standard", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue19);
            } else {
                mutableState3 = mutableState19;
            }
            MutableState mutableState20 = (MutableState) rememberedValue19;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958785293);
            Object rememberedValue20 = startRestartGroup.rememberedValue();
            if (rememberedValue20 == Composer.INSTANCE.getEmpty()) {
                mutableState4 = mutableState20;
                rememberedValue20 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue20);
            } else {
                mutableState4 = mutableState20;
            }
            MutableState mutableState21 = (MutableState) rememberedValue20;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958785199);
            Object rememberedValue21 = startRestartGroup.rememberedValue();
            if (rememberedValue21 == Composer.INSTANCE.getEmpty()) {
                mutableState5 = mutableState21;
                rememberedValue21 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(35.0f), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue21);
            } else {
                mutableState5 = mutableState21;
            }
            final MutableState mutableState22 = (MutableState) rememberedValue21;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958785137);
            Object rememberedValue22 = startRestartGroup.rememberedValue();
            if (rememberedValue22 == Composer.INSTANCE.getEmpty()) {
                rememberedValue22 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("Focus on Weak Areas", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue22);
            }
            final MutableState mutableState23 = (MutableState) rememberedValue22;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958785054);
            Object rememberedValue23 = startRestartGroup.rememberedValue();
            if (rememberedValue23 == Composer.INSTANCE.getEmpty()) {
                rememberedValue23 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue23);
            }
            final MutableState mutableState24 = (MutableState) rememberedValue23;
            startRestartGroup.endReplaceableGroup();
            final List listOf = CollectionsKt.listOf((Object[]) new Triple[]{new Triple("Teal", Color.m3407boximpl(ColorKt.Color(4278217052L)), "EMERALD"), new Triple("Blue", Color.m3407boximpl(ColorKt.Color(4282339765L)), "OCEAN"), new Triple("Slate", Color.m3407boximpl(ColorKt.Color(4282735204L)), "LAVENDER"), new Triple("Crimson", Color.m3407boximpl(ColorKt.Color(4292352864L)), "LAVENDER"), new Triple("Orange", Color.m3407boximpl(ColorKt.Color(4293284096L)), "SUNSET")});
            startRestartGroup.startReplaceableGroup(-1958784652);
            boolean z2 = (i2 & 896) == 256;
            Object rememberedValue24 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue24 == Composer.INSTANCE.getEmpty()) {
                Iterator it = listOf.iterator();
                int i6 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i6 = -1;
                        break;
                    } else if (Intrinsics.areEqual(((Triple) it.next()).getThird(), themePreset)) {
                        break;
                    } else {
                        i6++;
                    }
                }
                rememberedValue24 = Integer.valueOf(RangesKt.coerceAtLeast(i6, 0));
                startRestartGroup.updateRememberedValue(rememberedValue24);
            }
            final int intValue = ((Number) rememberedValue24).intValue();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958784536);
            if (SettingsTab$lambda$37(mutableState15)) {
                long surface = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getSurface();
                RoundedCornerShape m839RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(24));
                startRestartGroup.startReplaceableGroup(-1958784462);
                Object rememberedValue25 = startRestartGroup.rememberedValue();
                if (rememberedValue25 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue25 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$2$1
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
                            SettingsTabKt.SettingsTab$lambda$38(mutableState15, false);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue25);
                }
                startRestartGroup.endReplaceableGroup();
                AndroidAlertDialog_androidKt.m1232AlertDialogOix01E0((Function0) rememberedValue25, ComposableLambdaKt.composableLambda(startRestartGroup, -1704215196, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$3
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

                    public final void invoke(Composer composer3, int i7) {
                        if ((i7 & 11) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1704215196, i7, -1, "com.example.flashcardapp.ui.SettingsTab.<anonymous> (SettingsTab.kt:166)");
                            }
                            composer3.startReplaceableGroup(1992943027);
                            final MutableState<Boolean> mutableState25 = mutableState15;
                            Object rememberedValue26 = composer3.rememberedValue();
                            if (rememberedValue26 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue26 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$3$1$1
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
                                        SettingsTabKt.SettingsTab$lambda$38(mutableState25, false);
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue26);
                            }
                            composer3.endReplaceableGroup();
                            ButtonKt.Button((Function0) rememberedValue26, null, false, null, ButtonDefaults.INSTANCE.m1274buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, composer3, ButtonDefaults.$stable << 12, 14), null, null, null, null, ComposableSingletons$SettingsTabKt.INSTANCE.m6308getLambda1$app_release(), composer3, 805306374, 494);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), null, null, null, ComposableSingletons$SettingsTabKt.INSTANCE.m6313getLambda2$app_release(), ComposableSingletons$SettingsTabKt.INSTANCE.m6314getLambda3$app_release(), m839RoundedCornerShape0680j_4, surface, 0L, 0L, 0L, 0.0f, null, startRestartGroup, 1769526, 0, 15900);
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958783243);
            long background = z ? MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getBackground() : ColorKt.Color(4294244342L);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958783147);
            long surfaceVariant = z ? MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getSurfaceVariant() : Color.INSTANCE.m3454getWhite0d7_KjU();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958783047);
            long m3416copywmQWz5c$default = z ? Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOutlineVariant(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null) : ColorKt.Color(4293718001L);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958782923);
            long onBackground = z ? MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnBackground() : ColorKt.Color(4280693304L);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958782822);
            final long onSurfaceVariant = z ? MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant() : ColorKt.Color(4286091420L);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958782713);
            final long onSurface = z ? MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnSurface() : ColorKt.Color(4280693304L);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958782613);
            if (z) {
                MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getPrimary();
            } else {
                ColorKt.Color(4283723386L);
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958782517);
            final long surface2 = z ? MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getSurface() : ColorKt.Color(4294309880L);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1958782421);
            final long m3416copywmQWz5c$default2 = z ? Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOutlineVariant(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null) : ColorKt.Color(4293718001L);
            startRestartGroup.endReplaceableGroup();
            Modifier m216backgroundbw27NRU$default = BackgroundKt.m216backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), background, null, 2, null);
            Alignment topCenter = Alignment.INSTANCE.getTopCenter();
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topCenter, false, startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m216backgroundbw27NRU$default);
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
            Updater.m2954setimpl(m2947constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2954setimpl(m2947constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m2947constructorimpl.getInserting() || !Intrinsics.areEqual(m2947constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m2947constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m2947constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            float f = 20;
            Modifier m571paddingVpY3zN4$default = PaddingKt.m571paddingVpY3zN4$default(ScrollKt.verticalScroll$default(SizeKt.m625widthInVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m5738constructorimpl(600), 1, null), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, null, false, 14, null), Dp.m5738constructorimpl(f), 0.0f, 2, null);
            Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(12));
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_4, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m571paddingVpY3zN4$default);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m2947constructorimpl2 = Updater.m2947constructorimpl(startRestartGroup);
            Updater.m2954setimpl(m2947constructorimpl2, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2954setimpl(m2947constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m2947constructorimpl2.getInserting() || !Intrinsics.areEqual(m2947constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m2947constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m2947constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            modifierMaterializerOf2.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(16)), startRestartGroup, 6);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, startRestartGroup, 54);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer m2947constructorimpl3 = Updater.m2947constructorimpl(startRestartGroup);
            Updater.m2954setimpl(m2947constructorimpl3, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            float f2 = 10;
            Arrangement.HorizontalOrVertical m478spacedBy0680j_42 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f2));
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m478spacedBy0680j_42, centerVertically2, startRestartGroup, 54);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor4);
            } else {
                startRestartGroup.useNode();
            }
            Composer m2947constructorimpl4 = Updater.m2947constructorimpl(startRestartGroup);
            Updater.m2954setimpl(m2947constructorimpl4, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            Modifier m216backgroundbw27NRU$default2 = BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(38)), RoundedCornerShapeKt.getCircleShape()), Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getPrimary(), 0.15f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
            startRestartGroup.startReplaceableGroup(-686184764);
            boolean z3 = (3670016 & i2) == 1048576;
            Object rememberedValue26 = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue26 == Composer.INSTANCE.getEmpty()) {
                rememberedValue26 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$1$1$1$1
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
                        onNavigateToProfile.invoke();
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue26);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier m251clickableXHw0xAI$default = ClickableKt.m251clickableXHw0xAI$default(m216backgroundbw27NRU$default2, false, null, null, (Function0) rememberedValue26, 7, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(m251clickableXHw0xAI$default);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor5);
            } else {
                startRestartGroup.useNode();
            }
            Composer m2947constructorimpl5 = Updater.m2947constructorimpl(startRestartGroup);
            Updater.m2954setimpl(m2947constructorimpl5, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2954setimpl(m2947constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m2947constructorimpl5.getInserting() || !Intrinsics.areEqual(m2947constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                m2947constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                m2947constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            modifierMaterializerOf5.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            if (uri != null) {
                startRestartGroup.startReplaceableGroup(503386499);
                SingletonAsyncImageKt.m6078AsyncImagegl8XCv8(uri, "Profile", ClipKt.clip(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.getCircleShape()), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, false, null, startRestartGroup, 1572920, 0, 4024);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(503386867);
                IconKt.m1605Iconww6aTOc(PersonKt.getPerson(Icons.Filled.INSTANCE), "Profile", SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(22)), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getPrimary(), startRestartGroup, 432, 0);
                startRestartGroup.endReplaceableGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            TextKt.m2133Text4IGK_g("AnkiPrep", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getPrimary(), TextUnitKt.getSp(18), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, 199686, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier m570paddingVpY3zN4 = PaddingKt.m570paddingVpY3zN4(BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.RoundedCornerShape(50)), ColorKt.Color(4294964192L), null, 2, null), Dp.m5738constructorimpl(f2), Dp.m5738constructorimpl(5));
            Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
            float f3 = 4;
            Arrangement.HorizontalOrVertical m478spacedBy0680j_43 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f3));
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m478spacedBy0680j_43, centerVertically3, startRestartGroup, 54);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap6 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(m570paddingVpY3zN4);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor6);
            } else {
                startRestartGroup.useNode();
            }
            Composer m2947constructorimpl6 = Updater.m2947constructorimpl(startRestartGroup);
            Updater.m2954setimpl(m2947constructorimpl6, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2954setimpl(m2947constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m2947constructorimpl6.getInserting() || !Intrinsics.areEqual(m2947constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                m2947constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                m2947constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
            }
            modifierMaterializerOf6.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            TextKt.m2133Text4IGK_g("🔥", (Modifier) null, 0L, TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, 3078, 0, 131062);
            TextKt.m2133Text4IGK_g("12", (Modifier) null, ColorKt.Color(4293284096L), TextUnitKt.getSp(13), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, 200070, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap7 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf7 = LayoutKt.modifierMaterializerOf(companion2);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor7);
            } else {
                startRestartGroup.useNode();
            }
            Composer m2947constructorimpl7 = Updater.m2947constructorimpl(startRestartGroup);
            Updater.m2954setimpl(m2947constructorimpl7, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2954setimpl(m2947constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m2947constructorimpl7.getInserting() || !Intrinsics.areEqual(m2947constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                m2947constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                m2947constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
            }
            modifierMaterializerOf7.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            TextKt.m2133Text4IGK_g("Settings", (Modifier) null, onBackground, TextUnitKt.getSp(30), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, 199686, 0, 131026);
            SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f3)), startRestartGroup, 6);
            TextKt.m2133Text4IGK_g("Manage your professional learning environment.", (Modifier) null, onSurfaceVariant, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, 3078, 0, 131058);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            float f4 = 0;
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f)), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getPrimaryContainer(), 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14), CardDefaults.INSTANCE.m1296cardElevationaqJV_2Y(Dp.m5738constructorimpl(f4), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, (CardDefaults.$stable << 18) | 6, 62), null, ComposableLambdaKt.composableLambda(startRestartGroup, -531366935, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$3
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

                public final void invoke(ColumnScope Card, Composer composer3, int i7) {
                    Intrinsics.checkNotNullParameter(Card, "$this$Card");
                    if ((i7 & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-531366935, i7, -1, "com.example.flashcardapp.ui.SettingsTab.<anonymous>.<anonymous>.<anonymous> (SettingsTab.kt:258)");
                    }
                    Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(12));
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_44 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(8));
                    final MutableState<Boolean> mutableState25 = mutableState15;
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_44, Alignment.INSTANCE.getStart(), composer3, 6);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap8 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf8 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor8);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl8 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl8, columnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl8.getInserting() || !Intrinsics.areEqual(m2947constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
                        m2947constructorimpl8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                        m2947constructorimpl8.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
                    }
                    modifierMaterializerOf8.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                    TextKt.m2133Text4IGK_g("How to Use Guide", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnPrimaryContainer(), TextUnitKt.getSp(18), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199686, 0, 131026);
                    TextKt.m2133Text4IGK_g("Master the \"Spine\" system, daily mastery goals, and active recall triggers for optimal exam preparation.", (Modifier) null, Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnPrimaryContainer(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null), TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(19), 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3078, 6, 130034);
                    SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(4)), composer3, 6);
                    ButtonColors m1274buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1274buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, composer3, ButtonDefaults.$stable << 12, 14);
                    RoundedCornerShape RoundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape(50);
                    Modifier m604height3ABfNKs = SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(40));
                    composer3.startReplaceableGroup(-686181786);
                    Object rememberedValue27 = composer3.rememberedValue();
                    if (rememberedValue27 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue27 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$3$1$1$1
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
                                SettingsTabKt.SettingsTab$lambda$38(mutableState25, true);
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue27);
                    }
                    composer3.endReplaceableGroup();
                    ButtonKt.Button((Function0) rememberedValue27, m604height3ABfNKs, false, RoundedCornerShape, m1274buttonColorsro_MJ88, null, null, null, null, ComposableSingletons$SettingsTabKt.INSTANCE.m6315getLambda4$app_release(), composer3, 805306422, 484);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, 196614, 16);
            float f5 = 8;
            Arrangement.HorizontalOrVertical m478spacedBy0680j_44 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f5));
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_44, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap8 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf8 = LayoutKt.modifierMaterializerOf(companion3);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor8);
            } else {
                startRestartGroup.useNode();
            }
            Composer m2947constructorimpl8 = Updater.m2947constructorimpl(startRestartGroup);
            Updater.m2954setimpl(m2947constructorimpl8, columnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2954setimpl(m2947constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m2947constructorimpl8.getInserting() || !Intrinsics.areEqual(m2947constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
                m2947constructorimpl8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                m2947constructorimpl8.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
            }
            modifierMaterializerOf8.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
            int i7 = ((i2 << 3) & 112) | 6;
            SectionLabel("TYPOGRAPHY & FONTS", z, startRestartGroup, i7, 0);
            float f6 = 1;
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f)), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(surfaceVariant, 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14), CardDefaults.INSTANCE.m1296cardElevationaqJV_2Y(Dp.m5738constructorimpl(f4), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, (CardDefaults.$stable << 18) | 6, 62), BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(f6), m3416copywmQWz5c$default), ComposableLambdaKt.composableLambda(startRestartGroup, -1595203300, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$4$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope Card, Composer composer3, int i8) {
                    String SettingsTab$lambda$9;
                    String SettingsTab$lambda$92;
                    String str;
                    List SettingsTab$lambda$13;
                    List<File> SettingsTab$lambda$132;
                    String SettingsTab$lambda$93;
                    Intrinsics.checkNotNullParameter(Card, "$this$Card");
                    if ((i8 & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1595203300, i8, -1, "com.example.flashcardapp.ui.SettingsTab.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsTab.kt:288)");
                    }
                    float f7 = 12;
                    Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f7));
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_45 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f7));
                    long j = m3416copywmQWz5c$default2;
                    long j2 = onSurface;
                    long j3 = onSurfaceVariant;
                    MutableState<String> mutableState25 = mutableState8;
                    SettingsRepository settingsRepository2 = settingsRepository;
                    Function1<String, Unit> function1 = onFontFamilyTypeChange;
                    final Context context2 = context;
                    final MutableState<List<File>> mutableState26 = mutableState9;
                    long j4 = surface2;
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_45, Alignment.INSTANCE.getStart(), composer3, 6);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash9 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap9 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor9 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf9 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor9);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl9 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl9, columnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash9 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl9.getInserting() || !Intrinsics.areEqual(m2947constructorimpl9.rememberedValue(), Integer.valueOf(currentCompositeKeyHash9))) {
                        m2947constructorimpl9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash9));
                        m2947constructorimpl9.apply(Integer.valueOf(currentCompositeKeyHash9), setCompositeKeyHash9);
                    }
                    modifierMaterializerOf9.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                    Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                    Arrangement.HorizontalOrVertical spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
                    Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(spaceBetween2, centerVertically4, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash10 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap10 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor10 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf10 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default2);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor10);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl10 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl10, rowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl10, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash10 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl10.getInserting() || !Intrinsics.areEqual(m2947constructorimpl10.rememberedValue(), Integer.valueOf(currentCompositeKeyHash10))) {
                        m2947constructorimpl10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash10));
                        m2947constructorimpl10.apply(Integer.valueOf(currentCompositeKeyHash10), setCompositeKeyHash10);
                    }
                    modifierMaterializerOf10.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                    Alignment.Vertical centerVertically5 = Alignment.INSTANCE.getCenterVertically();
                    float f8 = 10;
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_46 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f8));
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    Modifier.Companion companion4 = Modifier.INSTANCE;
                    MeasurePolicy rowMeasurePolicy5 = RowKt.rowMeasurePolicy(m478spacedBy0680j_46, centerVertically5, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash11 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap11 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor11 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf11 = LayoutKt.modifierMaterializerOf(companion4);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor11);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl11 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl11, rowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash11 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl11.getInserting() || !Intrinsics.areEqual(m2947constructorimpl11.rememberedValue(), Integer.valueOf(currentCompositeKeyHash11))) {
                        m2947constructorimpl11.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash11));
                        m2947constructorimpl11.apply(Integer.valueOf(currentCompositeKeyHash11), setCompositeKeyHash11);
                    }
                    modifierMaterializerOf11.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                    final Function1<String, Unit> function12 = function1;
                    final SettingsRepository settingsRepository3 = settingsRepository2;
                    IconKt.m1605Iconww6aTOc(FontDownloadKt.getFontDownload(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), composer3, 48, 4);
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    Modifier.Companion companion5 = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash12 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap12 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor12 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf12 = LayoutKt.modifierMaterializerOf(companion5);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor12);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl12 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl12, columnMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash12 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl12.getInserting() || !Intrinsics.areEqual(m2947constructorimpl12.rememberedValue(), Integer.valueOf(currentCompositeKeyHash12))) {
                        m2947constructorimpl12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash12));
                        m2947constructorimpl12.apply(Integer.valueOf(currentCompositeKeyHash12), setCompositeKeyHash12);
                    }
                    modifierMaterializerOf12.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                    final MutableState<String> mutableState27 = mutableState25;
                    TextKt.m2133Text4IGK_g("Active Font", (Modifier) null, j2, TextUnitKt.getSp(15), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199686, 0, 131026);
                    SettingsTab$lambda$9 = SettingsTabKt.SettingsTab$lambda$9(mutableState27);
                    String str2 = SettingsTab$lambda$9;
                    TextKt.m2133Text4IGK_g((str2 == null || str2.length() == 0) ? "Inter (Default System Font)" : "Custom Font (Active)", (Modifier) null, j3, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3072, 0, 131058);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    SettingsTab$lambda$92 = SettingsTabKt.SettingsTab$lambda$9(mutableState27);
                    String str3 = SettingsTab$lambda$92;
                    if (str3 == null || str3.length() == 0) {
                        composer3.startReplaceableGroup(1107126598);
                        Modifier m570paddingVpY3zN42 = PaddingKt.m570paddingVpY3zN4(BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(6))), Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0.15f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m5738constructorimpl(8), Dp.m5738constructorimpl(2));
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash13 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap13 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor13 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf13 = LayoutKt.modifierMaterializerOf(m570paddingVpY3zN42);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor13);
                        } else {
                            composer3.useNode();
                        }
                        Composer m2947constructorimpl13 = Updater.m2947constructorimpl(composer3);
                        Updater.m2954setimpl(m2947constructorimpl13, rememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash13 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl13.getInserting() || !Intrinsics.areEqual(m2947constructorimpl13.rememberedValue(), Integer.valueOf(currentCompositeKeyHash13))) {
                            m2947constructorimpl13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash13));
                            m2947constructorimpl13.apply(Integer.valueOf(currentCompositeKeyHash13), setCompositeKeyHash13);
                        }
                        modifierMaterializerOf13.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        str = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
                        TextKt.m2133Text4IGK_g("Active", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199686, 0, 131026);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(1107126035);
                        ButtonKt.TextButton(new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$4$1$1$1$2
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
                                SettingsRepository.this.setCustomFontPath(null);
                                mutableState27.setValue(null);
                                function12.invoke("DEFAULT");
                            }
                        }, null, false, null, null, null, null, null, null, ComposableSingletons$SettingsTabKt.INSTANCE.m6316getLambda5$app_release(), composer3, 805306368, 510);
                        composer3.endReplaceableGroup();
                        str = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    composer3.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composer3, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composer3, "CC(remember):Composables.kt#9igjgp");
                    Object rememberedValue27 = composer3.rememberedValue();
                    if (rememberedValue27 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3));
                        composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                        rememberedValue27 = compositionScopedCoroutineScopeCanceller;
                    }
                    composer3.endReplaceableGroup();
                    final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue27).getCoroutineScope();
                    composer3.endReplaceableGroup();
                    final ManagedActivityResultLauncher rememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(new ActivityResultContracts.GetContent(), new Function1<Uri, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$4$1$1$fontFilePickerLauncher$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Uri uri2) {
                            invoke2(uri2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: SettingsTab.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        @DebugMetadata(c = "com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$4$1$1$fontFilePickerLauncher$1$1", f = "SettingsTab.kt", i = {}, l = {345, 357}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$4$1$1$fontFilePickerLauncher$1$1, reason: invalid class name */
                        /* loaded from: classes2.dex */
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ MutableState<List<File>> $addedFonts$delegate;
                            final /* synthetic */ Context $context;
                            final /* synthetic */ MutableState<String> $customFontPath$delegate;
                            final /* synthetic */ Function1<String, Unit> $onFontFamilyTypeChange;
                            final /* synthetic */ SettingsRepository $repository;
                            final /* synthetic */ Uri $uri;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            AnonymousClass1(Context context, Uri uri, SettingsRepository settingsRepository, Function1<? super String, Unit> function1, MutableState<List<File>> mutableState, MutableState<String> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$context = context;
                                this.$uri = uri;
                                this.$repository = settingsRepository;
                                this.$onFontFamilyTypeChange = function1;
                                this.$addedFonts$delegate = mutableState;
                                this.$customFontPath$delegate = mutableState2;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$context, this.$uri, this.$repository, this.$onFontFamilyTypeChange, this.$addedFonts$delegate, this.$customFontPath$delegate, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                try {
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        File file = new File(this.$context.getFilesDir(), "fonts");
                                        if (!file.exists()) {
                                            file.mkdirs();
                                        }
                                        File file2 = new File(file, SettingsTabKt.getFileName(this.$context, this.$uri));
                                        InputStream openInputStream = this.$context.getContentResolver().openInputStream(this.$uri);
                                        if (openInputStream != null) {
                                            FileOutputStream fileOutputStream = openInputStream;
                                            try {
                                                InputStream inputStream = fileOutputStream;
                                                fileOutputStream = new FileOutputStream(file2);
                                                try {
                                                    long copyTo$default = ByteStreamsKt.copyTo$default(inputStream, fileOutputStream, 0, 2, null);
                                                    CloseableKt.closeFinally(fileOutputStream, null);
                                                    Boxing.boxLong(copyTo$default);
                                                    CloseableKt.closeFinally(fileOutputStream, null);
                                                } finally {
                                                }
                                            } finally {
                                            }
                                        }
                                        this.label = 1;
                                        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(file, this.$repository, file2, this.$onFontFamilyTypeChange, this.$context, this.$addedFonts$delegate, this.$customFontPath$delegate, null), this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else if (i == 1) {
                                        ResultKt.throwOnFailure(obj);
                                    } else {
                                        if (i != 2) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                } catch (Exception e) {
                                    this.label = 2;
                                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(this.$context, e, null), this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* compiled from: SettingsTab.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                            @DebugMetadata(c = "com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$4$1$1$fontFilePickerLauncher$1$1$2", f = "SettingsTab.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$4$1$1$fontFilePickerLauncher$1$1$2, reason: invalid class name */
                            /* loaded from: classes2.dex */
                            public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ MutableState<List<File>> $addedFonts$delegate;
                                final /* synthetic */ Context $context;
                                final /* synthetic */ MutableState<String> $customFontPath$delegate;
                                final /* synthetic */ File $destinationFile;
                                final /* synthetic */ File $fontsDir;
                                final /* synthetic */ Function1<String, Unit> $onFontFamilyTypeChange;
                                final /* synthetic */ SettingsRepository $repository;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                AnonymousClass2(File file, SettingsRepository settingsRepository, File file2, Function1<? super String, Unit> function1, Context context, MutableState<List<File>> mutableState, MutableState<String> mutableState2, Continuation<? super AnonymousClass2> continuation) {
                                    super(2, continuation);
                                    this.$fontsDir = file;
                                    this.$repository = settingsRepository;
                                    this.$destinationFile = file2;
                                    this.$onFontFamilyTypeChange = function1;
                                    this.$context = context;
                                    this.$addedFonts$delegate = mutableState;
                                    this.$customFontPath$delegate = mutableState2;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass2(this.$fontsDir, this.$repository, this.$destinationFile, this.$onFontFamilyTypeChange, this.$context, this.$addedFonts$delegate, this.$customFontPath$delegate, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    ArrayList emptyList;
                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    if (this.label == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        MutableState<List<File>> mutableState = this.$addedFonts$delegate;
                                        File[] listFiles = this.$fontsDir.listFiles();
                                        if (listFiles == null) {
                                            emptyList = CollectionsKt.emptyList();
                                        } else {
                                            ArrayList arrayList = new ArrayList();
                                            for (File file : listFiles) {
                                                if (file.isFile()) {
                                                    String name = file.getName();
                                                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                                                    if (!StringsKt.endsWith(name, ".ttf", true)) {
                                                        String name2 = file.getName();
                                                        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                                                        if (!StringsKt.endsWith(name2, ".otf", true)) {
                                                        }
                                                    }
                                                    arrayList.add(file);
                                                }
                                            }
                                            emptyList = arrayList;
                                        }
                                        mutableState.setValue(emptyList);
                                        this.$repository.setCustomFontPath(this.$destinationFile.getAbsolutePath());
                                        this.$customFontPath$delegate.setValue(this.$destinationFile.getAbsolutePath());
                                        this.$onFontFamilyTypeChange.invoke("CUSTOM_" + this.$destinationFile.getName() + "_" + System.currentTimeMillis());
                                        Toast.makeText(this.$context, "Font loaded successfully", 0).show();
                                        return Unit.INSTANCE;
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* compiled from: SettingsTab.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                            @DebugMetadata(c = "com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$4$1$1$fontFilePickerLauncher$1$1$3", f = "SettingsTab.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$4$1$1$fontFilePickerLauncher$1$1$3, reason: invalid class name */
                            /* loaded from: classes2.dex */
                            public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ Context $context;
                                final /* synthetic */ Exception $e;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass3(Context context, Exception exc, Continuation<? super AnonymousClass3> continuation) {
                                    super(2, continuation);
                                    this.$context = context;
                                    this.$e = exc;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass3(this.$context, this.$e, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    if (this.label == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        Toast.makeText(this.$context, "Failed to load font file: " + this.$e.getMessage(), 1).show();
                                        return Unit.INSTANCE;
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            }
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Uri uri2) {
                            if (uri2 != null) {
                                BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, Dispatchers.getIO(), null, new AnonymousClass1(context2, uri2, settingsRepository3, function12, mutableState26, mutableState27, null), 2, null);
                            }
                        }
                    }, composer3, 8);
                    Alignment.Vertical centerVertically6 = Alignment.INSTANCE.getCenterVertically();
                    Arrangement.HorizontalOrVertical spaceBetween3 = Arrangement.INSTANCE.getSpaceBetween();
                    Modifier fillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy6 = RowKt.rowMeasurePolicy(spaceBetween3, centerVertically6, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    String str4 = str;
                    ComposerKt.sourceInformation(composer3, str4);
                    int currentCompositeKeyHash14 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap14 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor14 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf14 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default3);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor14);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl14 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl14, rowMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl14, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash14 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl14.getInserting() || !Intrinsics.areEqual(m2947constructorimpl14.rememberedValue(), Integer.valueOf(currentCompositeKeyHash14))) {
                        m2947constructorimpl14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash14));
                        m2947constructorimpl14.apply(Integer.valueOf(currentCompositeKeyHash14), setCompositeKeyHash14);
                    }
                    modifierMaterializerOf14.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
                    Alignment.Vertical centerVertically7 = Alignment.INSTANCE.getCenterVertically();
                    float f9 = 8;
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_47 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f9));
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    Modifier.Companion companion6 = Modifier.INSTANCE;
                    MeasurePolicy rowMeasurePolicy7 = RowKt.rowMeasurePolicy(m478spacedBy0680j_47, centerVertically7, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, str4);
                    int currentCompositeKeyHash15 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap15 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor15 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf15 = LayoutKt.modifierMaterializerOf(companion6);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor15);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl15 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl15, rowMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl15, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash15 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl15.getInserting() || !Intrinsics.areEqual(m2947constructorimpl15.rememberedValue(), Integer.valueOf(currentCompositeKeyHash15))) {
                        m2947constructorimpl15.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash15));
                        m2947constructorimpl15.apply(Integer.valueOf(currentCompositeKeyHash15), setCompositeKeyHash15);
                    }
                    modifierMaterializerOf15.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance7 = RowScopeInstance.INSTANCE;
                    float f10 = 18;
                    IconKt.m1605Iconww6aTOc(FolderOpenKt.getFolderOpen(Icons.Outlined.INSTANCE), (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f10)), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), composer3, 432, 0);
                    String str5 = "C92@4661L9:Row.kt#2w3rfo";
                    String str6 = "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo";
                    TextKt.m2133Text4IGK_g("Load Local Font File (.ttf/.otf)", (Modifier) null, j2, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199686, 0, 131026);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    ButtonKt.Button(new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$4$1$1$2$2
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
                            rememberLauncherForActivityResult.launch("*/*");
                        }
                    }, SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(28)), false, RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(6)), ButtonDefaults.INSTANCE.m1274buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, composer3, ButtonDefaults.$stable << 12, 14), null, null, PaddingKt.m564PaddingValuesYgX7TsA$default(Dp.m5738constructorimpl(f7), 0.0f, 2, null), null, ComposableSingletons$SettingsTabKt.INSTANCE.m6317getLambda6$app_release(), composer3, 817889328, 356);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    composer3.startReplaceableGroup(-686173827);
                    SettingsTab$lambda$13 = SettingsTabKt.SettingsTab$lambda$13(mutableState26);
                    if (!SettingsTab$lambda$13.isEmpty()) {
                        DividerKt.m1532HorizontalDivider9IZ8Weo(null, 0.0f, j, composer3, 0, 3);
                        TextKt.m2133Text4IGK_g("Added Fonts", (Modifier) null, j2, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199686, 0, 131026);
                        Arrangement.HorizontalOrVertical m478spacedBy0680j_48 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f9));
                        Composer composer4 = composer3;
                        composer4.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        Modifier.Companion companion7 = Modifier.INSTANCE;
                        MeasurePolicy columnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_48, Alignment.INSTANCE.getStart(), composer4, 6);
                        int i9 = -1323940314;
                        composer4.startReplaceableGroup(-1323940314);
                        String str7 = str4;
                        ComposerKt.sourceInformation(composer4, str7);
                        int i10 = 0;
                        int currentCompositeKeyHash16 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                        CompositionLocalMap currentCompositionLocalMap16 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor16 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf16 = LayoutKt.modifierMaterializerOf(companion7);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer4.createNode(constructor16);
                        } else {
                            composer3.useNode();
                        }
                        Composer m2947constructorimpl16 = Updater.m2947constructorimpl(composer3);
                        Updater.m2954setimpl(m2947constructorimpl16, columnMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl16, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash16 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl16.getInserting() || !Intrinsics.areEqual(m2947constructorimpl16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash16))) {
                            m2947constructorimpl16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash16));
                            m2947constructorimpl16.apply(Integer.valueOf(currentCompositeKeyHash16), setCompositeKeyHash16);
                        }
                        modifierMaterializerOf16.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer4, 0);
                        int i11 = 2058660585;
                        composer4.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
                        composer4.startReplaceableGroup(503397629);
                        SettingsTab$lambda$132 = SettingsTabKt.SettingsTab$lambda$13(mutableState26);
                        for (final File file2 : SettingsTab$lambda$132) {
                            SettingsTab$lambda$93 = SettingsTabKt.SettingsTab$lambda$9(mutableState27);
                            final boolean areEqual = Intrinsics.areEqual(SettingsTab$lambda$93, file2.getAbsolutePath());
                            Alignment.Vertical centerVertically8 = Alignment.INSTANCE.getCenterVertically();
                            Arrangement.HorizontalOrVertical spaceBetween4 = Arrangement.INSTANCE.getSpaceBetween();
                            Modifier clip = ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f8)));
                            composer4.startReplaceableGroup(1107132393);
                            long m3416copywmQWz5c$default3 = areEqual ? Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getPrimary(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
                            composer3.endReplaceableGroup();
                            final MutableState<String> mutableState28 = mutableState27;
                            final Function1<String, Unit> function13 = function12;
                            final SettingsRepository settingsRepository4 = settingsRepository3;
                            Modifier m570paddingVpY3zN43 = PaddingKt.m570paddingVpY3zN4(ClickableKt.m251clickableXHw0xAI$default(BackgroundKt.m216backgroundbw27NRU$default(clip, m3416copywmQWz5c$default3, null, 2, null), false, null, null, new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$4$1$1$3$1$1
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
                                    SettingsRepository.this.setCustomFontPath(file2.getAbsolutePath());
                                    mutableState28.setValue(file2.getAbsolutePath());
                                    function13.invoke("CUSTOM_" + file2.getName() + "_" + System.currentTimeMillis());
                                }
                            }, 7, null), Dp.m5738constructorimpl(f7), Dp.m5738constructorimpl(f9));
                            composer4.startReplaceableGroup(693286680);
                            String str8 = str6;
                            ComposerKt.sourceInformation(composer4, str8);
                            MeasurePolicy rowMeasurePolicy8 = RowKt.rowMeasurePolicy(spaceBetween4, centerVertically8, composer4, 54);
                            composer4.startReplaceableGroup(i9);
                            ComposerKt.sourceInformation(composer4, str7);
                            int currentCompositeKeyHash17 = ComposablesKt.getCurrentCompositeKeyHash(composer4, i10);
                            CompositionLocalMap currentCompositionLocalMap17 = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor17 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf17 = LayoutKt.modifierMaterializerOf(m570paddingVpY3zN43);
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer4.createNode(constructor17);
                            } else {
                                composer3.useNode();
                            }
                            Composer m2947constructorimpl17 = Updater.m2947constructorimpl(composer3);
                            Updater.m2954setimpl(m2947constructorimpl17, rowMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m2954setimpl(m2947constructorimpl17, currentCompositionLocalMap17, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash17 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m2947constructorimpl17.getInserting() || !Intrinsics.areEqual(m2947constructorimpl17.rememberedValue(), Integer.valueOf(currentCompositeKeyHash17))) {
                                m2947constructorimpl17.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash17));
                                m2947constructorimpl17.apply(Integer.valueOf(currentCompositeKeyHash17), setCompositeKeyHash17);
                            }
                            modifierMaterializerOf17.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer4, Integer.valueOf(i10));
                            composer4.startReplaceableGroup(i11);
                            String str9 = str5;
                            ComposerKt.sourceInformationMarkerStart(composer4, -326681643, str9);
                            RowScopeInstance rowScopeInstance8 = RowScopeInstance.INSTANCE;
                            Alignment.Vertical centerVertically9 = Alignment.INSTANCE.getCenterVertically();
                            Arrangement.HorizontalOrVertical m478spacedBy0680j_49 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f9));
                            Modifier weight$default = RowScope.weight$default(rowScopeInstance8, Modifier.INSTANCE, 1.0f, false, 2, null);
                            composer4.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer4, str8);
                            MeasurePolicy rowMeasurePolicy9 = RowKt.rowMeasurePolicy(m478spacedBy0680j_49, centerVertically9, composer4, 54);
                            composer4.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer4, str7);
                            int currentCompositeKeyHash18 = ComposablesKt.getCurrentCompositeKeyHash(composer4, i10);
                            CompositionLocalMap currentCompositionLocalMap18 = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor18 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf18 = LayoutKt.modifierMaterializerOf(weight$default);
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer4.createNode(constructor18);
                            } else {
                                composer3.useNode();
                            }
                            Composer m2947constructorimpl18 = Updater.m2947constructorimpl(composer3);
                            Updater.m2954setimpl(m2947constructorimpl18, rowMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m2954setimpl(m2947constructorimpl18, currentCompositionLocalMap18, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash18 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m2947constructorimpl18.getInserting() || !Intrinsics.areEqual(m2947constructorimpl18.rememberedValue(), Integer.valueOf(currentCompositeKeyHash18))) {
                                m2947constructorimpl18.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash18));
                                m2947constructorimpl18.apply(Integer.valueOf(currentCompositeKeyHash18), setCompositeKeyHash18);
                            }
                            modifierMaterializerOf18.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer4, Integer.valueOf(i10));
                            composer4.startReplaceableGroup(i11);
                            ComposerKt.sourceInformationMarkerStart(composer4, -326681643, str9);
                            RowScopeInstance rowScopeInstance9 = RowScopeInstance.INSTANCE;
                            Icons.Outlined outlined = Icons.Outlined.INSTANCE;
                            ImageVector checkCircle = areEqual ? CheckCircleKt.getCheckCircle(outlined) : FontDownloadKt.getFontDownload(outlined);
                            composer4.startReplaceableGroup(1527106877);
                            long primary = areEqual ? MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getPrimary() : j3;
                            composer3.endReplaceableGroup();
                            IconKt.m1605Iconww6aTOc(checkCircle, (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f10)), primary, composer3, 432, 0);
                            String name3 = file2.getName();
                            long sp = TextUnitKt.getSp(13);
                            FontWeight.Companion companion8 = FontWeight.INSTANCE;
                            FontWeight bold = areEqual ? companion8.getBold() : companion8.getNormal();
                            composer4.startReplaceableGroup(1527107431);
                            long primary2 = areEqual ? MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getPrimary() : j2;
                            composer3.endReplaceableGroup();
                            Intrinsics.checkNotNull(name3);
                            TextKt.m2133Text4IGK_g(name3, (Modifier) null, primary2, sp, (FontStyle) null, bold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3072, 0, 131026);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$4$1$1$3$1$2$2
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
                                    ArrayList emptyList2;
                                    file2.delete();
                                    File file3 = new File(context2.getFilesDir(), "fonts");
                                    MutableState<List<File>> mutableState29 = mutableState26;
                                    File[] listFiles2 = file3.listFiles();
                                    if (listFiles2 == null) {
                                        emptyList2 = CollectionsKt.emptyList();
                                    } else {
                                        ArrayList arrayList2 = new ArrayList();
                                        for (File file4 : listFiles2) {
                                            if (file4.isFile()) {
                                                String name4 = file4.getName();
                                                Intrinsics.checkNotNullExpressionValue(name4, "getName(...)");
                                                if (!StringsKt.endsWith(name4, ".ttf", true)) {
                                                    String name5 = file4.getName();
                                                    Intrinsics.checkNotNullExpressionValue(name5, "getName(...)");
                                                    if (!StringsKt.endsWith(name5, ".otf", true)) {
                                                    }
                                                }
                                                arrayList2.add(file4);
                                            }
                                        }
                                        emptyList2 = arrayList2;
                                    }
                                    mutableState29.setValue(emptyList2);
                                    if (areEqual) {
                                        settingsRepository4.setCustomFontPath(null);
                                        mutableState28.setValue(null);
                                        function13.invoke("DEFAULT");
                                    }
                                }
                            }, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(24)), false, null, null, ComposableSingletons$SettingsTabKt.INSTANCE.m6318getLambda7$app_release(), composer3, 196656, 28);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer4 = composer3;
                            settingsRepository3 = settingsRepository4;
                            mutableState27 = mutableState28;
                            str6 = str8;
                            i11 = i11;
                            i10 = i10;
                            str7 = str7;
                            str5 = str9;
                            i9 = -1323940314;
                            function12 = function13;
                        }
                        composer3.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                    }
                    composer3.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, 196614, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Arrangement.HorizontalOrVertical m478spacedBy0680j_45 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f5));
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            Modifier.Companion companion4 = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_45, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash9 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap9 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor9 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf9 = LayoutKt.modifierMaterializerOf(companion4);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor9);
            } else {
                startRestartGroup.useNode();
            }
            Composer m2947constructorimpl9 = Updater.m2947constructorimpl(startRestartGroup);
            Updater.m2954setimpl(m2947constructorimpl9, columnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2954setimpl(m2947constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash9 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m2947constructorimpl9.getInserting() || !Intrinsics.areEqual(m2947constructorimpl9.rememberedValue(), Integer.valueOf(currentCompositeKeyHash9))) {
                m2947constructorimpl9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash9));
                m2947constructorimpl9.apply(Integer.valueOf(currentCompositeKeyHash9), setCompositeKeyHash9);
            }
            modifierMaterializerOf9.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
            SectionLabel("QUIZ & STUDY MODES", z, startRestartGroup, i7, 0);
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f)), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(surfaceVariant, 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14), CardDefaults.INSTANCE.m1296cardElevationaqJV_2Y(Dp.m5738constructorimpl(f4), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, (CardDefaults.$stable << 18) | 6, 62), BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(f6), m3416copywmQWz5c$default), ComposableLambdaKt.composableLambda(startRestartGroup, -643371461, true, new SettingsTabKt$SettingsTab$4$1$5$1(onSurface, onSurfaceVariant, settingsRepository, surface2)), startRestartGroup, 196614, 0);
            ImageVector directionsRun = DirectionsRunKt.getDirectionsRun(Icons.Outlined.INSTANCE);
            startRestartGroup.startReplaceableGroup(2029330894);
            long primaryContainer = z ? MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getPrimaryContainer() : ColorKt.Color(4292932337L);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(2029331009);
            long onPrimaryContainer = z ? MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer() : ColorKt.Color(4278209856L);
            startRestartGroup.endReplaceableGroup();
            int SettingsTab$lambda$16 = SettingsTab$lambda$16(mutableState10);
            Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$5$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i8) {
                    SettingsTabKt.SettingsTab$lambda$17(mutableState10, i8);
                    SettingsRepository.this.setQuestionLimit(i8);
                }
            };
            List listOf2 = CollectionsKt.listOf((Object[]) new Integer[]{20, 30, 50, 80});
            List listOf3 = CollectionsKt.listOf((Object[]) new String[]{"20 Qs", "30 Qs", "50 Qs", "80 Qs"});
            SettingsTabKt$SettingsTab$4$1$5$3 settingsTabKt$SettingsTab$4$1$5$3 = new Function1<Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$5$3
                public final void invoke(int i8) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }
            };
            List emptyList2 = CollectionsKt.emptyList();
            List emptyList3 = CollectionsKt.emptyList();
            String SettingsTab$lambda$40 = SettingsTab$lambda$40(mutableState16);
            boolean SettingsTab$lambda$43 = SettingsTab$lambda$43(mutableState);
            startRestartGroup.startReplaceableGroup(2029331895);
            Object rememberedValue27 = startRestartGroup.rememberedValue();
            if (rememberedValue27 == Composer.INSTANCE.getEmpty()) {
                final MutableState mutableState25 = mutableState;
                rememberedValue27 = (Function1) new Function1<Boolean, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$5$4$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z4) {
                        SettingsTabKt.SettingsTab$lambda$44(mutableState25, z4);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue27);
            }
            Function1 function12 = (Function1) rememberedValue27;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(2029331963);
            Object rememberedValue28 = startRestartGroup.rememberedValue();
            if (rememberedValue28 == Composer.INSTANCE.getEmpty()) {
                rememberedValue28 = (Function1) new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$5$5$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        mutableState16.setValue(it2);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue28);
            }
            startRestartGroup.endReplaceableGroup();
            m6346StudyModeCardjwffKRY("PRACTICE MODE", directionsRun, primaryContainer, onPrimaryContainer, SettingsTab$lambda$16, function1, listOf2, listOf3, 500, "Manual (1-500)", 0, settingsTabKt$SettingsTab$4$1$5$3, emptyList2, emptyList3, null, SettingsTab$lambda$40, SettingsTab$lambda$43, function12, (Function1) rememberedValue28, CollectionsKt.listOf((Object[]) new String[]{"Spaced Repetition", "FSRS", "Leitner"}), true, z, startRestartGroup, 920125446, 918556086, i7, 16384);
            ImageVector alarm = AlarmKt.getAlarm(Icons.Outlined.INSTANCE);
            startRestartGroup.startReplaceableGroup(2029332365);
            long surfaceVariant2 = z ? MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getSurfaceVariant() : ColorKt.Color(4293718001L);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(2029332478);
            long onSurfaceVariant2 = z ? MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant() : ColorKt.Color(4281812815L);
            startRestartGroup.endReplaceableGroup();
            int SettingsTab$lambda$46 = SettingsTab$lambda$46(mutableState2);
            final MutableState mutableState26 = mutableState2;
            Function1<Integer, Unit> function13 = new Function1<Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$5$6
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i8) {
                    SettingsTabKt.SettingsTab$lambda$47(mutableState26, i8);
                    SettingsRepository.this.setQuestionLimit(i8);
                }
            };
            List listOf4 = CollectionsKt.listOf((Object[]) new Integer[]{20, 30, 50, 80});
            List listOf5 = CollectionsKt.listOf((Object[]) new String[]{"20 Qs", "30 Qs", "50 Qs", "80 Qs"});
            int SettingsTab$lambda$49 = SettingsTab$lambda$49(mutableState3);
            final MutableState mutableState27 = mutableState3;
            Function1<Integer, Unit> function14 = new Function1<Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$5$7
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i8) {
                    SettingsTabKt.SettingsTab$lambda$50(mutableState27, i8);
                    SettingsRepository.this.setTimeLimitSeconds(i8);
                }
            };
            List listOf6 = CollectionsKt.listOf((Object[]) new Integer[]{15, 30, 60, 90});
            List listOf7 = CollectionsKt.listOf((Object[]) new String[]{"15s", "30s", "60s", "90s"});
            String SettingsTab$lambda$52 = SettingsTab$lambda$52(mutableState4);
            boolean SettingsTab$lambda$55 = SettingsTab$lambda$55(mutableState5);
            startRestartGroup.startReplaceableGroup(2029333582);
            Object rememberedValue29 = startRestartGroup.rememberedValue();
            if (rememberedValue29 == Composer.INSTANCE.getEmpty()) {
                final MutableState mutableState28 = mutableState5;
                rememberedValue29 = (Function1) new Function1<Boolean, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$5$8$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z4) {
                        SettingsTabKt.SettingsTab$lambda$56(mutableState28, z4);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue29);
            }
            Function1 function15 = (Function1) rememberedValue29;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(2029333646);
            Object rememberedValue30 = startRestartGroup.rememberedValue();
            if (rememberedValue30 == Composer.INSTANCE.getEmpty()) {
                final MutableState mutableState29 = mutableState4;
                rememberedValue30 = (Function1) new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$5$9$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        mutableState29.setValue(it2);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue30);
            }
            startRestartGroup.endReplaceableGroup();
            m6346StudyModeCardjwffKRY("MOCK TEST", alarm, surfaceVariant2, onSurfaceVariant2, SettingsTab$lambda$46, function13, listOf4, listOf5, 500, "Manual (1-500)", SettingsTab$lambda$49, function14, listOf6, listOf7, "Manual Secs", SettingsTab$lambda$52, SettingsTab$lambda$55, function15, (Function1) rememberedValue30, CollectionsKt.listOf((Object[]) new String[]{"Exam Standard", "FSRS", "Random"}), false, z, startRestartGroup, 920125446, 918580608, i7, 0);
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f)), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(surfaceVariant, 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14), CardDefaults.INSTANCE.m1296cardElevationaqJV_2Y(Dp.m5738constructorimpl(f4), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, (CardDefaults.$stable << 18) | 6, 62), BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(f6), m3416copywmQWz5c$default), ComposableLambdaKt.composableLambda(startRestartGroup, -1346362268, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$5$10
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

                public final void invoke(ColumnScope Card, Composer composer3, int i8) {
                    float SettingsTab$lambda$58;
                    float SettingsTab$lambda$582;
                    final MutableState<Boolean> mutableState30;
                    String SettingsTab$lambda$61;
                    boolean SettingsTab$lambda$64;
                    final MutableState<Boolean> mutableState31;
                    Intrinsics.checkNotNullParameter(Card, "$this$Card");
                    if ((i8 & 81) != 16 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1346362268, i8, -1, "com.example.flashcardapp.ui.SettingsTab.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsTab.kt:583)");
                        }
                        boolean z4 = z;
                        long j = onSurface;
                        final MutableState<Float> mutableState32 = mutableState22;
                        long j2 = surface2;
                        MutableState<Boolean> mutableState33 = mutableState24;
                        final MutableState<String> mutableState34 = mutableState23;
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        Modifier.Companion companion5 = Modifier.INSTANCE;
                        MeasurePolicy columnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash10 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap10 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor10 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf10 = LayoutKt.modifierMaterializerOf(companion5);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor10);
                        } else {
                            composer3.useNode();
                        }
                        Composer m2947constructorimpl10 = Updater.m2947constructorimpl(composer3);
                        Updater.m2954setimpl(m2947constructorimpl10, columnMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl10, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash10 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl10.getInserting() || !Intrinsics.areEqual(m2947constructorimpl10.rememberedValue(), Integer.valueOf(currentCompositeKeyHash10))) {
                            m2947constructorimpl10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash10));
                            m2947constructorimpl10.apply(Integer.valueOf(currentCompositeKeyHash10), setCompositeKeyHash10);
                        }
                        modifierMaterializerOf10.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                        Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        composer3.startReplaceableGroup(503410062);
                        long surfaceVariant3 = z4 ? MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getSurfaceVariant() : ColorKt.Color(4293718001L);
                        composer3.endReplaceableGroup();
                        float f7 = 8;
                        Modifier m570paddingVpY3zN42 = PaddingKt.m570paddingVpY3zN4(BackgroundKt.m216backgroundbw27NRU$default(fillMaxWidth$default2, surfaceVariant3, null, 2, null), Dp.m5738constructorimpl(16), Dp.m5738constructorimpl(f7));
                        Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                        Arrangement.HorizontalOrVertical m478spacedBy0680j_46 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f7));
                        composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(m478spacedBy0680j_46, centerVertically4, composer3, 54);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash11 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap11 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor11 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf11 = LayoutKt.modifierMaterializerOf(m570paddingVpY3zN42);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor11);
                        } else {
                            composer3.useNode();
                        }
                        Composer m2947constructorimpl11 = Updater.m2947constructorimpl(composer3);
                        Updater.m2954setimpl(m2947constructorimpl11, rowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash11 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl11.getInserting() || !Intrinsics.areEqual(m2947constructorimpl11.rememberedValue(), Integer.valueOf(currentCompositeKeyHash11))) {
                            m2947constructorimpl11.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash11));
                            m2947constructorimpl11.apply(Integer.valueOf(currentCompositeKeyHash11), setCompositeKeyHash11);
                        }
                        modifierMaterializerOf11.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                        ImageVector autoAwesome = AutoAwesomeKt.getAutoAwesome(Icons.Outlined.INSTANCE);
                        composer3.startReplaceableGroup(1107144677);
                        long onSurfaceVariant3 = z4 ? MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurfaceVariant() : ColorKt.Color(4282735204L);
                        composer3.endReplaceableGroup();
                        IconKt.m1605Iconww6aTOc(autoAwesome, (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(18)), onSurfaceVariant3, composer3, 432, 0);
                        long sp = TextUnitKt.getSp(12);
                        FontWeight bold = FontWeight.INSTANCE.getBold();
                        composer3.startReplaceableGroup(1107144900);
                        long onSurfaceVariant4 = z4 ? MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurfaceVariant() : ColorKt.Color(4282735204L);
                        composer3.endReplaceableGroup();
                        TextKt.m2133Text4IGK_g("SMART REVISION", (Modifier) null, onSurfaceVariant4, sp, (FontStyle) null, bold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199686, 0, 131026);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        float f8 = 12;
                        Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f8));
                        Arrangement.HorizontalOrVertical m478spacedBy0680j_47 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f8));
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_47, Alignment.INSTANCE.getStart(), composer3, 6);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash12 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap12 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor12 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf12 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor12);
                        } else {
                            composer3.useNode();
                        }
                        Composer m2947constructorimpl12 = Updater.m2947constructorimpl(composer3);
                        Updater.m2954setimpl(m2947constructorimpl12, columnMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash12 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl12.getInserting() || !Intrinsics.areEqual(m2947constructorimpl12.rememberedValue(), Integer.valueOf(currentCompositeKeyHash12))) {
                            m2947constructorimpl12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash12));
                            m2947constructorimpl12.apply(Integer.valueOf(currentCompositeKeyHash12), setCompositeKeyHash12);
                        }
                        modifierMaterializerOf12.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        Modifier.Companion companion6 = Modifier.INSTANCE;
                        MeasurePolicy columnMeasurePolicy7 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash13 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap13 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor13 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf13 = LayoutKt.modifierMaterializerOf(companion6);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor13);
                        } else {
                            composer3.useNode();
                        }
                        Composer m2947constructorimpl13 = Updater.m2947constructorimpl(composer3);
                        Updater.m2954setimpl(m2947constructorimpl13, columnMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash13 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl13.getInserting() || !Intrinsics.areEqual(m2947constructorimpl13.rememberedValue(), Integer.valueOf(currentCompositeKeyHash13))) {
                            m2947constructorimpl13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash13));
                            m2947constructorimpl13.apply(Integer.valueOf(currentCompositeKeyHash13), setCompositeKeyHash13);
                        }
                        modifierMaterializerOf13.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance7 = ColumnScopeInstance.INSTANCE;
                        Modifier fillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
                        Alignment.Vertical centerVertically5 = Alignment.INSTANCE.getCenterVertically();
                        composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy5 = RowKt.rowMeasurePolicy(spaceBetween2, centerVertically5, composer3, 54);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash14 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap14 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor14 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf14 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default3);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor14);
                        } else {
                            composer3.useNode();
                        }
                        Composer m2947constructorimpl14 = Updater.m2947constructorimpl(composer3);
                        Updater.m2954setimpl(m2947constructorimpl14, rowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl14, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash14 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl14.getInserting() || !Intrinsics.areEqual(m2947constructorimpl14.rememberedValue(), Integer.valueOf(currentCompositeKeyHash14))) {
                            m2947constructorimpl14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash14));
                            m2947constructorimpl14.apply(Integer.valueOf(currentCompositeKeyHash14), setCompositeKeyHash14);
                        }
                        modifierMaterializerOf14.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                        TextKt.m2133Text4IGK_g("Daily Review Batch", (Modifier) null, j, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3078, 0, 131058);
                        SettingsTab$lambda$58 = SettingsTabKt.SettingsTab$lambda$58(mutableState32);
                        TextKt.m2133Text4IGK_g(String.valueOf((int) SettingsTab$lambda$58), (Modifier) null, j, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199680, 0, 131026);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        SettingsTab$lambda$582 = SettingsTabKt.SettingsTab$lambda$58(mutableState32);
                        composer3.startReplaceableGroup(234949643);
                        Object rememberedValue31 = composer3.rememberedValue();
                        if (rememberedValue31 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue31 = (Function1) new Function1<Float, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$5$10$1$2$1$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Float f9) {
                                    invoke(f9.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f9) {
                                    SettingsTabKt.SettingsTab$lambda$59(mutableState32, f9);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue31);
                        }
                        composer3.endReplaceableGroup();
                        SliderKt.Slider(SettingsTab$lambda$582, (Function1) rememberedValue31, null, false, RangesKt.rangeTo(5.0f, 100.0f), 0, null, SliderDefaults.INSTANCE.m1877colorsq0g_0yA(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOutlineVariant(), 0L, 0L, 0L, 0L, 0L, 0L, composer3, 0, 6, PointerIconCompat.TYPE_NO_DROP), null, composer3, 48, 364);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        Modifier fillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical spaceBetween3 = Arrangement.INSTANCE.getSpaceBetween();
                        Alignment.Vertical centerVertically6 = Alignment.INSTANCE.getCenterVertically();
                        composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy6 = RowKt.rowMeasurePolicy(spaceBetween3, centerVertically6, composer3, 54);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash15 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap15 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor15 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf15 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default4);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor15);
                        } else {
                            composer3.useNode();
                        }
                        Composer m2947constructorimpl15 = Updater.m2947constructorimpl(composer3);
                        Updater.m2954setimpl(m2947constructorimpl15, rowMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl15, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash15 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl15.getInserting() || !Intrinsics.areEqual(m2947constructorimpl15.rememberedValue(), Integer.valueOf(currentCompositeKeyHash15))) {
                            m2947constructorimpl15.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash15));
                            m2947constructorimpl15.apply(Integer.valueOf(currentCompositeKeyHash15), setCompositeKeyHash15);
                        }
                        modifierMaterializerOf15.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
                        TextKt.m2133Text4IGK_g("Algorithm", (Modifier) null, j, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3078, 0, 131058);
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        Modifier.Companion companion7 = Modifier.INSTANCE;
                        MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash16 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap16 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor16 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf16 = LayoutKt.modifierMaterializerOf(companion7);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor16);
                        } else {
                            composer3.useNode();
                        }
                        Composer m2947constructorimpl16 = Updater.m2947constructorimpl(composer3);
                        Updater.m2954setimpl(m2947constructorimpl16, rememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl16, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash16 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl16.getInserting() || !Intrinsics.areEqual(m2947constructorimpl16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash16))) {
                            m2947constructorimpl16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash16));
                            m2947constructorimpl16.apply(Integer.valueOf(currentCompositeKeyHash16), setCompositeKeyHash16);
                        }
                        modifierMaterializerOf16.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        Modifier m216backgroundbw27NRU$default3 = BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f7))), j2, null, 2, null);
                        composer3.startReplaceableGroup(865976020);
                        Object rememberedValue32 = composer3.rememberedValue();
                        if (rememberedValue32 == Composer.INSTANCE.getEmpty()) {
                            mutableState30 = mutableState33;
                            rememberedValue32 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$5$10$1$2$2$1$1$1
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
                                    SettingsTabKt.SettingsTab$lambda$65(mutableState30, true);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue32);
                        } else {
                            mutableState30 = mutableState33;
                        }
                        composer3.endReplaceableGroup();
                        Modifier m570paddingVpY3zN43 = PaddingKt.m570paddingVpY3zN4(ClickableKt.m251clickableXHw0xAI$default(m216backgroundbw27NRU$default3, false, null, null, (Function0) rememberedValue32, 7, null), Dp.m5738constructorimpl(f8), Dp.m5738constructorimpl(6));
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash17 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap17 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor17 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf17 = LayoutKt.modifierMaterializerOf(m570paddingVpY3zN43);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor17);
                        } else {
                            composer3.useNode();
                        }
                        Composer m2947constructorimpl17 = Updater.m2947constructorimpl(composer3);
                        Updater.m2954setimpl(m2947constructorimpl17, rememberBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl17, currentCompositionLocalMap17, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash17 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl17.getInserting() || !Intrinsics.areEqual(m2947constructorimpl17.rememberedValue(), Integer.valueOf(currentCompositeKeyHash17))) {
                            m2947constructorimpl17.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash17));
                            m2947constructorimpl17.apply(Integer.valueOf(currentCompositeKeyHash17), setCompositeKeyHash17);
                        }
                        modifierMaterializerOf17.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                        SettingsTab$lambda$61 = SettingsTabKt.SettingsTab$lambda$61(mutableState34);
                        MutableState<Boolean> mutableState35 = mutableState30;
                        TextKt.m2133Text4IGK_g(SettingsTab$lambda$61, (Modifier) null, j, TextUnitKt.getSp(13), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199680, 0, 131026);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        SettingsTab$lambda$64 = SettingsTabKt.SettingsTab$lambda$64(mutableState35);
                        composer3.startReplaceableGroup(865976461);
                        Object rememberedValue33 = composer3.rememberedValue();
                        if (rememberedValue33 == Composer.INSTANCE.getEmpty()) {
                            mutableState31 = mutableState35;
                            rememberedValue33 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$5$10$1$2$2$1$3$1
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
                                    SettingsTabKt.SettingsTab$lambda$65(mutableState31, false);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue33);
                        } else {
                            mutableState31 = mutableState35;
                        }
                        composer3.endReplaceableGroup();
                        AndroidMenu_androidKt.m1233DropdownMenu4kj_NE(SettingsTab$lambda$64, (Function0) rememberedValue33, null, 0L, null, null, ComposableLambdaKt.composableLambda(composer3, 1597674043, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$5$10$1$2$2$1$4
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer4, Integer num) {
                                invoke(columnScope, composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ColumnScope DropdownMenu, Composer composer4, int i9) {
                                Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
                                if ((i9 & 81) != 16 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1597674043, i9, -1, "com.example.flashcardapp.ui.SettingsTab.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsTab.kt:637)");
                                    }
                                    List<String> listOf8 = CollectionsKt.listOf((Object[]) new String[]{"Focus on Weak Areas", "FSRS", "Leitner"});
                                    final MutableState<String> mutableState36 = mutableState34;
                                    final MutableState<Boolean> mutableState37 = mutableState31;
                                    for (final String str : listOf8) {
                                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer4, 2053495739, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$5$10$1$2$2$1$4$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                invoke(composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer5, int i10) {
                                                if ((i10 & 11) == 2 && composer5.getSkipping()) {
                                                    composer5.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(2053495739, i10, -1, "com.example.flashcardapp.ui.SettingsTab.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsTab.kt:638)");
                                                }
                                                TextKt.m2133Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer5, 0, 0, 131070);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        });
                                        composer4.startReplaceableGroup(856432698);
                                        boolean changed2 = composer4.changed(str);
                                        Object rememberedValue34 = composer4.rememberedValue();
                                        if (changed2 || rememberedValue34 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue34 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$5$10$1$2$2$1$4$1$2$1
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
                                                    mutableState36.setValue(str);
                                                    SettingsTabKt.SettingsTab$lambda$65(mutableState37, false);
                                                }
                                            };
                                            composer4.updateRememberedValue(rememberedValue34);
                                        }
                                        composer4.endReplaceableGroup();
                                        AndroidMenu_androidKt.DropdownMenuItem(composableLambda, (Function0) rememberedValue34, null, null, null, false, null, null, null, composer4, 6, 508);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), composer3, 1572912, 60);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
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
            }), startRestartGroup, 196614, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Arrangement.HorizontalOrVertical m478spacedBy0680j_46 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f5));
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            Modifier.Companion companion5 = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_46, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash10 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap10 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor10 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf10 = LayoutKt.modifierMaterializerOf(companion5);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor10);
            } else {
                startRestartGroup.useNode();
            }
            Composer m2947constructorimpl10 = Updater.m2947constructorimpl(startRestartGroup);
            Updater.m2954setimpl(m2947constructorimpl10, columnMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2954setimpl(m2947constructorimpl10, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash10 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m2947constructorimpl10.getInserting() || !Intrinsics.areEqual(m2947constructorimpl10.rememberedValue(), Integer.valueOf(currentCompositeKeyHash10))) {
                m2947constructorimpl10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash10));
                m2947constructorimpl10.apply(Integer.valueOf(currentCompositeKeyHash10), setCompositeKeyHash10);
            }
            modifierMaterializerOf10.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
            SectionLabel("VISUALS & EXPERIENCE", z, startRestartGroup, i7, 0);
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f)), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(surfaceVariant, 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14), CardDefaults.INSTANCE.m1296cardElevationaqJV_2Y(Dp.m5738constructorimpl(f4), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, (CardDefaults.$stable << 18) | 6, 62), BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(f6), m3416copywmQWz5c$default), ComposableLambdaKt.composableLambda(startRestartGroup, 308460378, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$6$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope Card, Composer composer3, int i8) {
                    boolean SettingsTab$lambda$25;
                    Intrinsics.checkNotNullParameter(Card, "$this$Card");
                    if ((i8 & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(308460378, i8, -1, "com.example.flashcardapp.ui.SettingsTab.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsTab.kt:661)");
                    }
                    float f7 = 12;
                    Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f7));
                    float f8 = 10;
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_47 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f8));
                    boolean z4 = z;
                    long j = onSurface;
                    long j2 = onSurfaceVariant;
                    final Function1<Boolean, Unit> function16 = onDarkModeToggle;
                    final SettingsRepository settingsRepository2 = settingsRepository;
                    final MutableState<Boolean> mutableState30 = mutableState11;
                    List<Triple<String, Color, String>> list = listOf;
                    int i9 = intValue;
                    Function1<String, Unit> function17 = onThemePresetChange;
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_47, Alignment.INSTANCE.getStart(), composer3, 6);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash11 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap11 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor11 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf11 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor11);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl11 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl11, columnMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash11 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl11.getInserting() || !Intrinsics.areEqual(m2947constructorimpl11.rememberedValue(), Integer.valueOf(currentCompositeKeyHash11))) {
                        m2947constructorimpl11.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash11));
                        m2947constructorimpl11.apply(Integer.valueOf(currentCompositeKeyHash11), setCompositeKeyHash11);
                    }
                    modifierMaterializerOf11.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
                    Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                    Arrangement.HorizontalOrVertical spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
                    Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(spaceBetween2, centerVertically4, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash12 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap12 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor12 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf12 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default2);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor12);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl12 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl12, rowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash12 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl12.getInserting() || !Intrinsics.areEqual(m2947constructorimpl12.rememberedValue(), Integer.valueOf(currentCompositeKeyHash12))) {
                        m2947constructorimpl12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash12));
                        m2947constructorimpl12.apply(Integer.valueOf(currentCompositeKeyHash12), setCompositeKeyHash12);
                    }
                    modifierMaterializerOf12.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                    Alignment.Vertical centerVertically5 = Alignment.INSTANCE.getCenterVertically();
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_48 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f8));
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    Modifier.Companion companion6 = Modifier.INSTANCE;
                    MeasurePolicy rowMeasurePolicy5 = RowKt.rowMeasurePolicy(m478spacedBy0680j_48, centerVertically5, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash13 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap13 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor13 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf13 = LayoutKt.modifierMaterializerOf(companion6);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor13);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl13 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl13, rowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash13 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl13.getInserting() || !Intrinsics.areEqual(m2947constructorimpl13.rememberedValue(), Integer.valueOf(currentCompositeKeyHash13))) {
                        m2947constructorimpl13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash13));
                        m2947constructorimpl13.apply(Integer.valueOf(currentCompositeKeyHash13), setCompositeKeyHash13);
                    }
                    modifierMaterializerOf13.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                    int i10 = i9;
                    IconKt.m1605Iconww6aTOc(ContrastKt.getContrast(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), composer3, 48, 4);
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    Modifier.Companion companion7 = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy7 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash14 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap14 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor14 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf14 = LayoutKt.modifierMaterializerOf(companion7);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor14);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl14 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl14, columnMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl14, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash14 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl14.getInserting() || !Intrinsics.areEqual(m2947constructorimpl14.rememberedValue(), Integer.valueOf(currentCompositeKeyHash14))) {
                        m2947constructorimpl14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash14));
                        m2947constructorimpl14.apply(Integer.valueOf(currentCompositeKeyHash14), setCompositeKeyHash14);
                    }
                    modifierMaterializerOf14.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance7 = ColumnScopeInstance.INSTANCE;
                    Function1<String, Unit> function18 = function17;
                    TextKt.m2133Text4IGK_g("Appearance", (Modifier) null, j, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199686, 0, 131026);
                    TextKt.m2133Text4IGK_g("Switch between Dark and Light mode", (Modifier) null, j2, TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3078, 0, 131058);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    SwitchKt.Switch(z4, new Function1<Boolean, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$6$1$1$1$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z5) {
                            function16.invoke(Boolean.valueOf(z5));
                            settingsRepository2.setDarkMode(z5);
                        }
                    }, null, null, false, SwitchDefaults.INSTANCE.m2016colorsV1nXRL4(Color.INSTANCE.m3454getWhite0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer3, 6, SwitchDefaults.$stable << 18, 65532), null, composer3, 0, 92);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    Alignment.Vertical centerVertically6 = Alignment.INSTANCE.getCenterVertically();
                    Arrangement.HorizontalOrVertical spaceBetween3 = Arrangement.INSTANCE.getSpaceBetween();
                    Modifier fillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy6 = RowKt.rowMeasurePolicy(spaceBetween3, centerVertically6, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash15 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap15 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor15 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf15 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default3);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor15);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl15 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl15, rowMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl15, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash15 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl15.getInserting() || !Intrinsics.areEqual(m2947constructorimpl15.rememberedValue(), Integer.valueOf(currentCompositeKeyHash15))) {
                        m2947constructorimpl15.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash15));
                        m2947constructorimpl15.apply(Integer.valueOf(currentCompositeKeyHash15), setCompositeKeyHash15);
                    }
                    modifierMaterializerOf15.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
                    Alignment.Vertical centerVertically7 = Alignment.INSTANCE.getCenterVertically();
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_49 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f8));
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    Modifier.Companion companion8 = Modifier.INSTANCE;
                    MeasurePolicy rowMeasurePolicy7 = RowKt.rowMeasurePolicy(m478spacedBy0680j_49, centerVertically7, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash16 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap16 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor16 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf16 = LayoutKt.modifierMaterializerOf(companion8);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor16);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl16 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl16, rowMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl16, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash16 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl16.getInserting() || !Intrinsics.areEqual(m2947constructorimpl16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash16))) {
                        m2947constructorimpl16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash16));
                        m2947constructorimpl16.apply(Integer.valueOf(currentCompositeKeyHash16), setCompositeKeyHash16);
                    }
                    modifierMaterializerOf16.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance7 = RowScopeInstance.INSTANCE;
                    IconKt.m1605Iconww6aTOc(LibraryBooksKt.getLibraryBooks(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), composer3, 48, 4);
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    Modifier.Companion companion9 = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy8 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash17 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap17 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor17 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf17 = LayoutKt.modifierMaterializerOf(companion9);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor17);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl17 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl17, columnMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl17, currentCompositionLocalMap17, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash17 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl17.getInserting() || !Intrinsics.areEqual(m2947constructorimpl17.rememberedValue(), Integer.valueOf(currentCompositeKeyHash17))) {
                        m2947constructorimpl17.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash17));
                        m2947constructorimpl17.apply(Integer.valueOf(currentCompositeKeyHash17), setCompositeKeyHash17);
                    }
                    modifierMaterializerOf17.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance8 = ColumnScopeInstance.INSTANCE;
                    TextKt.m2133Text4IGK_g("Show Explanations", (Modifier) null, j, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199686, 0, 131026);
                    TextKt.m2133Text4IGK_g("Auto-reveal logic after answering", (Modifier) null, j2, TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3078, 0, 131058);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    SettingsTab$lambda$25 = SettingsTabKt.SettingsTab$lambda$25(mutableState30);
                    SwitchKt.Switch(SettingsTab$lambda$25, new Function1<Boolean, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$6$1$1$2$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z5) {
                            SettingsTabKt.SettingsTab$lambda$26(mutableState30, z5);
                            SettingsRepository.this.setShowExplanations(z5);
                        }
                    }, null, null, false, SwitchDefaults.INSTANCE.m2016colorsV1nXRL4(Color.INSTANCE.m3454getWhite0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer3, 6, SwitchDefaults.$stable << 18, 65532), null, composer3, 0, 92);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_410 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(8));
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    Modifier.Companion companion10 = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy9 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_410, Alignment.INSTANCE.getStart(), composer3, 6);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash18 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap18 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor18 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf18 = LayoutKt.modifierMaterializerOf(companion10);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor18);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl18 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl18, columnMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl18, currentCompositionLocalMap18, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash18 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl18.getInserting() || !Intrinsics.areEqual(m2947constructorimpl18.rememberedValue(), Integer.valueOf(currentCompositeKeyHash18))) {
                        m2947constructorimpl18.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash18));
                        m2947constructorimpl18.apply(Integer.valueOf(currentCompositeKeyHash18), setCompositeKeyHash18);
                    }
                    modifierMaterializerOf18.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance9 = ColumnScopeInstance.INSTANCE;
                    Alignment.Vertical centerVertically8 = Alignment.INSTANCE.getCenterVertically();
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_411 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f8));
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    Modifier.Companion companion11 = Modifier.INSTANCE;
                    MeasurePolicy rowMeasurePolicy8 = RowKt.rowMeasurePolicy(m478spacedBy0680j_411, centerVertically8, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash19 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap19 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor19 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf19 = LayoutKt.modifierMaterializerOf(companion11);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor19);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl19 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl19, rowMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl19, currentCompositionLocalMap19, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash19 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl19.getInserting() || !Intrinsics.areEqual(m2947constructorimpl19.rememberedValue(), Integer.valueOf(currentCompositeKeyHash19))) {
                        m2947constructorimpl19.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash19));
                        m2947constructorimpl19.apply(Integer.valueOf(currentCompositeKeyHash19), setCompositeKeyHash19);
                    }
                    modifierMaterializerOf19.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance8 = RowScopeInstance.INSTANCE;
                    IconKt.m1605Iconww6aTOc(PaletteKt.getPalette(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), composer3, 48, 4);
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    Modifier.Companion companion12 = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy10 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash20 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap20 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor20 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf20 = LayoutKt.modifierMaterializerOf(companion12);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor20);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl20 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl20, columnMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl20, currentCompositionLocalMap20, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash20 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl20.getInserting() || !Intrinsics.areEqual(m2947constructorimpl20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash20))) {
                        m2947constructorimpl20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash20));
                        m2947constructorimpl20.apply(Integer.valueOf(currentCompositeKeyHash20), setCompositeKeyHash20);
                    }
                    modifierMaterializerOf20.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance10 = ColumnScopeInstance.INSTANCE;
                    TextKt.m2133Text4IGK_g("Theme Color", (Modifier) null, j, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199686, 0, 131026);
                    TextKt.m2133Text4IGK_g("Personalize your workspace palette", (Modifier) null, j2, TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3078, 0, 131058);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    Modifier m573paddingqDBjuR0$default = PaddingKt.m573paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m5738constructorimpl(4), 0.0f, 0.0f, 13, null);
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_412 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f7));
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy9 = RowKt.rowMeasurePolicy(m478spacedBy0680j_412, Alignment.INSTANCE.getTop(), composer3, 6);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash21 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap21 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor21 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf21 = LayoutKt.modifierMaterializerOf(m573paddingqDBjuR0$default);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor21);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl21 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl21, rowMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl21, currentCompositionLocalMap21, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash21 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl21.getInserting() || !Intrinsics.areEqual(m2947constructorimpl21.rememberedValue(), Integer.valueOf(currentCompositeKeyHash21))) {
                        m2947constructorimpl21.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash21));
                        m2947constructorimpl21.apply(Integer.valueOf(currentCompositeKeyHash21), setCompositeKeyHash21);
                    }
                    modifierMaterializerOf21.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance9 = RowScopeInstance.INSTANCE;
                    composer3.startReplaceableGroup(1107153035);
                    int i11 = 0;
                    for (Object obj : list) {
                        int i12 = i11 + 1;
                        if (i11 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        final Triple triple = (Triple) obj;
                        int i13 = i10;
                        boolean z5 = i13 == i11;
                        Modifier m228borderxT4_qwU = BorderKt.m228borderxT4_qwU(BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(36)), RoundedCornerShapeKt.getCircleShape()), ((Color) triple.getSecond()).m3427unboximpl(), null, 2, null), Dp.m5738constructorimpl(z5 ? 3 : 0), z5 ? j : Color.INSTANCE.m3452getTransparent0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
                        composer3.startReplaceableGroup(865982587);
                        final Function1<String, Unit> function19 = function18;
                        boolean changedInstance = composer3.changedInstance(function19) | composer3.changed(triple);
                        Object rememberedValue31 = composer3.rememberedValue();
                        if (changedInstance || rememberedValue31 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue31 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$6$1$1$3$2$1$1$1
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
                                    function19.invoke(triple.getThird());
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue31);
                        }
                        composer3.endReplaceableGroup();
                        BoxKt.Box(ClickableKt.m251clickableXHw0xAI$default(m228borderxT4_qwU, false, null, null, (Function0) rememberedValue31, 7, null), composer3, 0);
                        i11 = i12;
                        i10 = i13;
                        function18 = function19;
                    }
                    composer3.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, 196614, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Arrangement.HorizontalOrVertical m478spacedBy0680j_47 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f5));
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            Modifier.Companion companion6 = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_47, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash11 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap11 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor11 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf11 = LayoutKt.modifierMaterializerOf(companion6);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor11);
            } else {
                startRestartGroup.useNode();
            }
            Composer m2947constructorimpl11 = Updater.m2947constructorimpl(startRestartGroup);
            Updater.m2954setimpl(m2947constructorimpl11, columnMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2954setimpl(m2947constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash11 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m2947constructorimpl11.getInserting() || !Intrinsics.areEqual(m2947constructorimpl11.rememberedValue(), Integer.valueOf(currentCompositeKeyHash11))) {
                m2947constructorimpl11.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash11));
                m2947constructorimpl11.apply(Integer.valueOf(currentCompositeKeyHash11), setCompositeKeyHash11);
            }
            modifierMaterializerOf11.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
            SectionLabel("WHITEBOARD SETTINGS", z, startRestartGroup, i7, 0);
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f)), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(surfaceVariant, 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14), CardDefaults.INSTANCE.m1296cardElevationaqJV_2Y(Dp.m5738constructorimpl(f4), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, (CardDefaults.$stable << 18) | 6, 62), BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(f6), m3416copywmQWz5c$default), ComposableLambdaKt.composableLambda(startRestartGroup, 1260292217, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$7$1
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

                /* JADX WARN: Type inference failed for: r8v24 */
                /* JADX WARN: Type inference failed for: r8v25, types: [boolean, int] */
                /* JADX WARN: Type inference failed for: r8v27 */
                public final void invoke(ColumnScope Card, Composer composer3, int i8) {
                    boolean SettingsTab$lambda$28;
                    float SettingsTab$lambda$31;
                    float SettingsTab$lambda$312;
                    String SettingsTab$lambda$34;
                    Intrinsics.checkNotNullParameter(Card, "$this$Card");
                    if ((i8 & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1260292217, i8, -1, "com.example.flashcardapp.ui.SettingsTab.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsTab.kt:752)");
                    }
                    Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(12));
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_48 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(14));
                    long j = m3416copywmQWz5c$default2;
                    long j2 = onSurface;
                    long j3 = onSurfaceVariant;
                    final MutableState<Boolean> mutableState30 = mutableState12;
                    final SettingsRepository settingsRepository2 = settingsRepository;
                    final MutableState<Float> mutableState31 = mutableState13;
                    long j4 = surface2;
                    MutableState<String> mutableState32 = mutableState14;
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy7 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_48, Alignment.INSTANCE.getStart(), composer3, 6);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash12 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap12 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor12 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf12 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor12);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl12 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl12, columnMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash12 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl12.getInserting() || !Intrinsics.areEqual(m2947constructorimpl12.rememberedValue(), Integer.valueOf(currentCompositeKeyHash12))) {
                        m2947constructorimpl12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash12));
                        m2947constructorimpl12.apply(Integer.valueOf(currentCompositeKeyHash12), setCompositeKeyHash12);
                    }
                    modifierMaterializerOf12.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance7 = ColumnScopeInstance.INSTANCE;
                    Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                    Arrangement.HorizontalOrVertical spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
                    Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(spaceBetween2, centerVertically4, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash13 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap13 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor13 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf13 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default2);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor13);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl13 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl13, rowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash13 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl13.getInserting() || !Intrinsics.areEqual(m2947constructorimpl13.rememberedValue(), Integer.valueOf(currentCompositeKeyHash13))) {
                        m2947constructorimpl13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash13));
                        m2947constructorimpl13.apply(Integer.valueOf(currentCompositeKeyHash13), setCompositeKeyHash13);
                    }
                    modifierMaterializerOf13.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                    Alignment.Vertical centerVertically5 = Alignment.INSTANCE.getCenterVertically();
                    float f7 = 10;
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_49 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f7));
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    Modifier.Companion companion7 = Modifier.INSTANCE;
                    MeasurePolicy rowMeasurePolicy5 = RowKt.rowMeasurePolicy(m478spacedBy0680j_49, centerVertically5, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash14 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap14 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor14 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf14 = LayoutKt.modifierMaterializerOf(companion7);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor14);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl14 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl14, rowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl14, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash14 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl14.getInserting() || !Intrinsics.areEqual(m2947constructorimpl14.rememberedValue(), Integer.valueOf(currentCompositeKeyHash14))) {
                        m2947constructorimpl14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash14));
                        m2947constructorimpl14.apply(Integer.valueOf(currentCompositeKeyHash14), setCompositeKeyHash14);
                    }
                    modifierMaterializerOf14.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                    MutableState<String> mutableState33 = mutableState32;
                    IconKt.m1605Iconww6aTOc(GestureKt.getGesture(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), composer3, 48, 4);
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    Modifier.Companion companion8 = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy8 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash15 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap15 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor15 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf15 = LayoutKt.modifierMaterializerOf(companion8);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor15);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl15 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl15, columnMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl15, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash15 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl15.getInserting() || !Intrinsics.areEqual(m2947constructorimpl15.rememberedValue(), Integer.valueOf(currentCompositeKeyHash15))) {
                        m2947constructorimpl15.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash15));
                        m2947constructorimpl15.apply(Integer.valueOf(currentCompositeKeyHash15), setCompositeKeyHash15);
                    }
                    modifierMaterializerOf15.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance8 = ColumnScopeInstance.INSTANCE;
                    TextKt.m2133Text4IGK_g("Stylus Auto-Switch", (Modifier) null, j2, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199686, 0, 131026);
                    TextKt.m2133Text4IGK_g("Stylus automatically draws, finger scrolls", (Modifier) null, j3, TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3078, 0, 131058);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    SettingsTab$lambda$28 = SettingsTabKt.SettingsTab$lambda$28(mutableState30);
                    SwitchKt.Switch(SettingsTab$lambda$28, new Function1<Boolean, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$7$1$1$1$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z4) {
                            SettingsTabKt.SettingsTab$lambda$29(mutableState30, z4);
                            SettingsRepository.this.setWhiteboardAutoStylusMode(z4);
                        }
                    }, null, null, false, SwitchDefaults.INSTANCE.m2016colorsV1nXRL4(Color.INSTANCE.m3454getWhite0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer3, 6, SwitchDefaults.$stable << 18, 65532), null, composer3, 0, 92);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    float f8 = (float) 0.5d;
                    DividerKt.m1532HorizontalDivider9IZ8Weo(null, Dp.m5738constructorimpl(f8), j, composer3, 48, 1);
                    float f9 = 4;
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_410 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f9));
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    Modifier.Companion companion9 = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy9 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_410, Alignment.INSTANCE.getStart(), composer3, 6);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash16 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap16 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor16 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf16 = LayoutKt.modifierMaterializerOf(companion9);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor16);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl16 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl16, columnMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl16, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash16 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl16.getInserting() || !Intrinsics.areEqual(m2947constructorimpl16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash16))) {
                        m2947constructorimpl16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash16));
                        m2947constructorimpl16.apply(Integer.valueOf(currentCompositeKeyHash16), setCompositeKeyHash16);
                    }
                    modifierMaterializerOf16.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance9 = ColumnScopeInstance.INSTANCE;
                    Modifier fillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical spaceBetween3 = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Vertical centerVertically6 = Alignment.INSTANCE.getCenterVertically();
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy6 = RowKt.rowMeasurePolicy(spaceBetween3, centerVertically6, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash17 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap17 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor17 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf17 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default3);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor17);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl17 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl17, rowMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl17, currentCompositionLocalMap17, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash17 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl17.getInserting() || !Intrinsics.areEqual(m2947constructorimpl17.rememberedValue(), Integer.valueOf(currentCompositeKeyHash17))) {
                        m2947constructorimpl17.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash17));
                        m2947constructorimpl17.apply(Integer.valueOf(currentCompositeKeyHash17), setCompositeKeyHash17);
                    }
                    modifierMaterializerOf17.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
                    Alignment.Vertical centerVertically7 = Alignment.INSTANCE.getCenterVertically();
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_411 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f7));
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    Modifier.Companion companion10 = Modifier.INSTANCE;
                    MeasurePolicy rowMeasurePolicy7 = RowKt.rowMeasurePolicy(m478spacedBy0680j_411, centerVertically7, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash18 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap18 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor18 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf18 = LayoutKt.modifierMaterializerOf(companion10);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor18);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl18 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl18, rowMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl18, currentCompositionLocalMap18, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash18 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl18.getInserting() || !Intrinsics.areEqual(m2947constructorimpl18.rememberedValue(), Integer.valueOf(currentCompositeKeyHash18))) {
                        m2947constructorimpl18.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash18));
                        m2947constructorimpl18.apply(Integer.valueOf(currentCompositeKeyHash18), setCompositeKeyHash18);
                    }
                    modifierMaterializerOf18.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance7 = RowScopeInstance.INSTANCE;
                    IconKt.m1605Iconww6aTOc(BrushKt.getBrush(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), composer3, 48, 4);
                    TextKt.m2133Text4IGK_g("Highlighter Opacity", (Modifier) null, j2, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199686, 0, 131026);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    SettingsTab$lambda$31 = SettingsTabKt.SettingsTab$lambda$31(mutableState31);
                    TextKt.m2133Text4IGK_g(((int) (SettingsTab$lambda$31 * 100)) + "%", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), TextUnitKt.getSp(13), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199680, 0, 131026);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    SettingsTab$lambda$312 = SettingsTabKt.SettingsTab$lambda$31(mutableState31);
                    SettingsRepository settingsRepository3 = settingsRepository2;
                    SliderKt.Slider(SettingsTab$lambda$312, new Function1<Float, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$7$1$1$2$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Float f10) {
                            invoke(f10.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f10) {
                            SettingsTabKt.SettingsTab$lambda$32(mutableState31, f10);
                            SettingsRepository.this.setWhiteboardHighlighterAlpha(f10);
                        }
                    }, null, false, RangesKt.rangeTo(0.15f, 0.85f), 0, null, SliderDefaults.INSTANCE.m1877colorsq0g_0yA(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOutlineVariant(), 0L, 0L, 0L, 0L, 0L, 0L, composer3, 0, 6, PointerIconCompat.TYPE_NO_DROP), null, composer3, 0, 364);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    DividerKt.m1532HorizontalDivider9IZ8Weo(null, Dp.m5738constructorimpl(f8), j, composer3, 48, 1);
                    float f10 = 8;
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_412 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f10));
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    Modifier.Companion companion11 = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy10 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_412, Alignment.INSTANCE.getStart(), composer3, 6);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash19 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap19 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor19 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf19 = LayoutKt.modifierMaterializerOf(companion11);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor19);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl19 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl19, columnMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl19, currentCompositionLocalMap19, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash19 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl19.getInserting() || !Intrinsics.areEqual(m2947constructorimpl19.rememberedValue(), Integer.valueOf(currentCompositeKeyHash19))) {
                        m2947constructorimpl19.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash19));
                        m2947constructorimpl19.apply(Integer.valueOf(currentCompositeKeyHash19), setCompositeKeyHash19);
                    }
                    modifierMaterializerOf19.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance10 = ColumnScopeInstance.INSTANCE;
                    Alignment.Vertical centerVertically8 = Alignment.INSTANCE.getCenterVertically();
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_413 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f7));
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    Modifier.Companion companion12 = Modifier.INSTANCE;
                    MeasurePolicy rowMeasurePolicy8 = RowKt.rowMeasurePolicy(m478spacedBy0680j_413, centerVertically8, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash20 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap20 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor20 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf20 = LayoutKt.modifierMaterializerOf(companion12);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor20);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl20 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl20, rowMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl20, currentCompositionLocalMap20, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash20 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl20.getInserting() || !Intrinsics.areEqual(m2947constructorimpl20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash20))) {
                        m2947constructorimpl20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash20));
                        m2947constructorimpl20.apply(Integer.valueOf(currentCompositeKeyHash20), setCompositeKeyHash20);
                    }
                    modifierMaterializerOf20.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance8 = RowScopeInstance.INSTANCE;
                    IconKt.m1605Iconww6aTOc(ColorLensKt.getColorLens(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), composer3, 48, 4);
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    Modifier.Companion companion13 = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy11 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash21 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap21 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor21 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf21 = LayoutKt.modifierMaterializerOf(companion13);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor21);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl21 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl21, columnMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl21, currentCompositionLocalMap21, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash21 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl21.getInserting() || !Intrinsics.areEqual(m2947constructorimpl21.rememberedValue(), Integer.valueOf(currentCompositeKeyHash21))) {
                        m2947constructorimpl21.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash21));
                        m2947constructorimpl21.apply(Integer.valueOf(currentCompositeKeyHash21), setCompositeKeyHash21);
                    }
                    modifierMaterializerOf21.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance11 = ColumnScopeInstance.INSTANCE;
                    TextKt.m2133Text4IGK_g("Default Pen Color", (Modifier) null, j2, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199686, 0, 131026);
                    TextKt.m2133Text4IGK_g("Initial brush color on screen open", (Modifier) null, j3, TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3078, 0, 131058);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    boolean z4 = 0;
                    int i9 = 1;
                    List<Pair> listOf8 = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("DEFAULT", "Adaptive Contrast"), TuplesKt.to("RED", "Bright Red"), TuplesKt.to("BLUE", "Electric Blue"), TuplesKt.to("GREEN", "Sage Green")});
                    float f11 = 0.0f;
                    Object obj = null;
                    Modifier m573paddingqDBjuR0$default = PaddingKt.m573paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m5738constructorimpl(f9), 0.0f, 0.0f, 13, null);
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_414 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f10));
                    Composer composer4 = composer3;
                    composer4.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    int i10 = 6;
                    MeasurePolicy rowMeasurePolicy9 = RowKt.rowMeasurePolicy(m478spacedBy0680j_414, Alignment.INSTANCE.getTop(), composer4, 6);
                    int i11 = -1323940314;
                    composer4.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash22 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap22 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(m573paddingqDBjuR0$default);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer4.createNode(constructor22);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2947constructorimpl22 = Updater.m2947constructorimpl(composer3);
                    Updater.m2954setimpl(m2947constructorimpl22, rowMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl22, currentCompositionLocalMap22, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl22.getInserting() || !Intrinsics.areEqual(m2947constructorimpl22.rememberedValue(), Integer.valueOf(currentCompositeKeyHash22))) {
                        m2947constructorimpl22.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash22));
                        m2947constructorimpl22.apply(Integer.valueOf(currentCompositeKeyHash22), setCompositeKeyHash22);
                    }
                    modifierMaterializerOf22.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer4, 0);
                    int i12 = 2058660585;
                    composer4.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance9 = RowScopeInstance.INSTANCE;
                    composer4.startReplaceableGroup(1107159929);
                    for (final Pair pair : listOf8) {
                        SettingsTab$lambda$34 = SettingsTabKt.SettingsTab$lambda$34(mutableState33);
                        boolean areEqual = Intrinsics.areEqual(SettingsTab$lambda$34, pair.getFirst());
                        Modifier clip = ClipKt.clip(RowScope.weight$default(rowScopeInstance9, Modifier.INSTANCE, 1.0f, false, 2, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f10)));
                        composer4.startReplaceableGroup(234964019);
                        long m3416copywmQWz5c$default3 = areEqual ? Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getPrimary(), 0.15f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
                        composer3.endReplaceableGroup();
                        Modifier m216backgroundbw27NRU$default3 = BackgroundKt.m216backgroundbw27NRU$default(clip, m3416copywmQWz5c$default3, null, 2, null);
                        float m5738constructorimpl = areEqual ? Dp.m5738constructorimpl((float) 1.5d) : Dp.m5738constructorimpl(f8);
                        composer4.startReplaceableGroup(234964319);
                        long primary = areEqual ? MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getPrimary() : Color.INSTANCE.m3452getTransparent0d7_KjU();
                        composer3.endReplaceableGroup();
                        Modifier m228borderxT4_qwU = BorderKt.m228borderxT4_qwU(m216backgroundbw27NRU$default3, m5738constructorimpl, primary, RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f10)));
                        final MutableState<String> mutableState34 = mutableState33;
                        final SettingsRepository settingsRepository4 = settingsRepository3;
                        Modifier m571paddingVpY3zN4$default2 = PaddingKt.m571paddingVpY3zN4$default(ClickableKt.m251clickableXHw0xAI$default(m228borderxT4_qwU, false, null, null, new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$7$1$1$3$2$1$1
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
                                mutableState34.setValue(pair.getFirst());
                                settingsRepository4.setWhiteboardDefaultPenColor(pair.getFirst());
                            }
                        }, 7, null), f11, Dp.m5738constructorimpl(f10), i9, obj);
                        Alignment center2 = Alignment.INSTANCE.getCenter();
                        composer4.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(center2, z4, composer4, i10);
                        composer4.startReplaceableGroup(i11);
                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash23 = ComposablesKt.getCurrentCompositeKeyHash(composer4, z4);
                        CompositionLocalMap currentCompositionLocalMap23 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor23 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf23 = LayoutKt.modifierMaterializerOf(m571paddingVpY3zN4$default2);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer4.createNode(constructor23);
                        } else {
                            composer3.useNode();
                        }
                        Composer m2947constructorimpl23 = Updater.m2947constructorimpl(composer3);
                        Updater.m2954setimpl(m2947constructorimpl23, rememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl23, currentCompositionLocalMap23, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash23 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl23.getInserting() || !Intrinsics.areEqual(m2947constructorimpl23.rememberedValue(), Integer.valueOf(currentCompositeKeyHash23))) {
                            m2947constructorimpl23.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash23));
                            m2947constructorimpl23.apply(Integer.valueOf(currentCompositeKeyHash23), setCompositeKeyHash23);
                        }
                        modifierMaterializerOf23.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer4, Integer.valueOf((int) z4));
                        composer4.startReplaceableGroup(i12);
                        ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        String str = (String) CollectionsKt.last(StringsKt.split$default((CharSequence) pair.getSecond(), new String[]{" "}, false, 0, 6, (Object) null));
                        long sp = TextUnitKt.getSp(11);
                        FontWeight.Companion companion14 = FontWeight.INSTANCE;
                        FontWeight bold = areEqual ? companion14.getBold() : companion14.getNormal();
                        composer4.startReplaceableGroup(1527135032);
                        long primary2 = areEqual ? MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getPrimary() : j2;
                        composer3.endReplaceableGroup();
                        TextKt.m2133Text4IGK_g(str, (Modifier) null, primary2, sp, (FontStyle) null, bold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3072, 0, 131026);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        composer4 = composer3;
                        obj = null;
                        i9 = 1;
                        settingsRepository3 = settingsRepository4;
                        i11 = i11;
                        i10 = i10;
                        f11 = 0.0f;
                        i12 = i12;
                        z4 = z4;
                        mutableState33 = mutableState34;
                    }
                    composer3.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, 196614, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Arrangement.HorizontalOrVertical m478spacedBy0680j_48 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f5));
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            Modifier.Companion companion7 = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy7 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_48, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash12 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap12 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor12 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf12 = LayoutKt.modifierMaterializerOf(companion7);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor12);
            } else {
                startRestartGroup.useNode();
            }
            Composer m2947constructorimpl12 = Updater.m2947constructorimpl(startRestartGroup);
            Updater.m2954setimpl(m2947constructorimpl12, columnMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2954setimpl(m2947constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash12 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m2947constructorimpl12.getInserting() || !Intrinsics.areEqual(m2947constructorimpl12.rememberedValue(), Integer.valueOf(currentCompositeKeyHash12))) {
                m2947constructorimpl12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash12));
                m2947constructorimpl12.apply(Integer.valueOf(currentCompositeKeyHash12), setCompositeKeyHash12);
            }
            modifierMaterializerOf12.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance7 = ColumnScopeInstance.INSTANCE;
            SectionLabel("STUDY GOAL & LANGUAGE", z, startRestartGroup, i7, 0);
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f)), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(surfaceVariant, 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14), CardDefaults.INSTANCE.m1296cardElevationaqJV_2Y(Dp.m5738constructorimpl(f4), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, (CardDefaults.$stable << 18) | 6, 62), BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(f6), m3416copywmQWz5c$default), ComposableLambdaKt.composableLambda(startRestartGroup, -2082843240, true, new SettingsTabKt$SettingsTab$4$1$8$1(onSurface, surface2, onSurfaceVariant, mutableState10, settingsRepository, collectAsState)), startRestartGroup, 196614, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f5)), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-706671130);
            Object rememberedValue31 = startRestartGroup.rememberedValue();
            if (rememberedValue31 == Composer.INSTANCE.getEmpty()) {
                i3 = 2;
                snapshotMutationPolicy = null;
                rememberedValue31 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue31);
            } else {
                i3 = 2;
                snapshotMutationPolicy = null;
            }
            final MutableState mutableState30 = (MutableState) rememberedValue31;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-706671061);
            Object rememberedValue32 = startRestartGroup.rememberedValue();
            if (rememberedValue32 == Composer.INSTANCE.getEmpty()) {
                rememberedValue32 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, snapshotMutationPolicy, i3, snapshotMutationPolicy);
                startRestartGroup.updateRememberedValue(rememberedValue32);
            }
            final MutableState mutableState31 = (MutableState) rememberedValue32;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-706670984);
            Object rememberedValue33 = startRestartGroup.rememberedValue();
            if (rememberedValue33 == Composer.INSTANCE.getEmpty()) {
                rememberedValue33 = InteractionSourceKt.MutableInteractionSource();
                startRestartGroup.updateRememberedValue(rememberedValue33);
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) rememberedValue33;
            startRestartGroup.endReplaceableGroup();
            long sp = TextUnitKt.getSp(12);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, snapshotMutationPolicy);
            startRestartGroup.startReplaceableGroup(-706670527);
            Object rememberedValue34 = startRestartGroup.rememberedValue();
            if (rememberedValue34 == Composer.INSTANCE.getEmpty()) {
                rememberedValue34 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$9$1
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
                        int SettingsTab$lambda$97$lambda$96$lambda$85;
                        int SettingsTab$lambda$97$lambda$96$lambda$852;
                        SettingsTab$lambda$97$lambda$96$lambda$85 = SettingsTabKt.SettingsTab$lambda$97$lambda$96$lambda$85(mutableState30);
                        SettingsTabKt.SettingsTab$lambda$97$lambda$96$lambda$86(mutableState30, SettingsTab$lambda$97$lambda$96$lambda$85 + 1);
                        SettingsTab$lambda$97$lambda$96$lambda$852 = SettingsTabKt.SettingsTab$lambda$97$lambda$96$lambda$85(mutableState30);
                        if (SettingsTab$lambda$97$lambda$96$lambda$852 >= 7) {
                            SettingsTabKt.SettingsTab$lambda$97$lambda$96$lambda$86(mutableState30, 0);
                            SettingsTabKt.SettingsTab$lambda$97$lambda$96$lambda$89(mutableState31, true);
                        }
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue34);
            }
            startRestartGroup.endReplaceableGroup();
            int i8 = i3;
            TextKt.m2133Text4IGK_g("Made with 💖 in INDIA.", ClickableKt.m249clickableO2vRcR0$default(fillMaxWidth$default2, mutableInteractionSource, null, false, null, null, (Function0) rememberedValue34, 28, null), onSurfaceVariant, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m5623boximpl(TextAlign.INSTANCE.m5630getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, 3078, 0, 130544);
            startRestartGroup.startReplaceableGroup(-706670229);
            if (SettingsTab$lambda$97$lambda$96$lambda$88(mutableState31)) {
                startRestartGroup.startReplaceableGroup(-706670166);
                Object rememberedValue35 = startRestartGroup.rememberedValue();
                if (rememberedValue35 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue35 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, i8, null);
                    startRestartGroup.updateRememberedValue(rememberedValue35);
                }
                final MutableState mutableState32 = (MutableState) rememberedValue35;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-706670066);
                Object rememberedValue36 = startRestartGroup.rememberedValue();
                if (rememberedValue36 == Composer.INSTANCE.getEmpty()) {
                    mutableState6 = mutableState31;
                    rememberedValue36 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$10$1
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
                            SettingsTabKt.SettingsTab$lambda$97$lambda$96$lambda$89(mutableState6, false);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue36);
                } else {
                    mutableState6 = mutableState31;
                }
                startRestartGroup.endReplaceableGroup();
                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, 370680744, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$11
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

                    public final void invoke(Composer composer3, int i9) {
                        if ((i9 & 11) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(370680744, i9, -1, "com.example.flashcardapp.ui.SettingsTab.<anonymous>.<anonymous>.<anonymous> (SettingsTab.kt:989)");
                            }
                            final SharedPreferences sharedPreferences2 = sharedPreferences;
                            final Context context2 = context;
                            final MutableState<String> mutableState33 = mutableState32;
                            final MutableState<Boolean> mutableState34 = mutableState6;
                            ButtonKt.Button(new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$11.1
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
                                    String SettingsTab$lambda$97$lambda$96$lambda$93;
                                    SettingsTab$lambda$97$lambda$96$lambda$93 = SettingsTabKt.SettingsTab$lambda$97$lambda$96$lambda$93(mutableState33);
                                    String sha256 = SettingsTabKt.sha256(StringsKt.trim((CharSequence) SettingsTab$lambda$97$lambda$96$lambda$93).toString());
                                    if (Intrinsics.areEqual(sha256, "870dc23d21836b97b58a7753922edc8512764e83c02586f3d8f14c11f760550b") || Intrinsics.areEqual(sha256, "de5ba444d0d9904310a3bf65fffeca15c520a1eaea937c4c13672551e632ffae")) {
                                        sharedPreferences2.edit().putBoolean("is_premium", true).apply();
                                        Toast.makeText(context2, "Premium Unlocked! 🎉", 0).show();
                                        SettingsTabKt.SettingsTab$lambda$97$lambda$96$lambda$89(mutableState34, false);
                                        return;
                                    }
                                    Toast.makeText(context2, "Invalid password", 0).show();
                                }
                            }, null, false, null, ButtonDefaults.INSTANCE.m1274buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, composer3, ButtonDefaults.$stable << 12, 14), null, null, null, null, ComposableSingletons$SettingsTabKt.INSTANCE.m6319getLambda8$app_release(), composer3, 805306368, 494);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                });
                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(startRestartGroup, -2091904342, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$12
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

                    public final void invoke(Composer composer3, int i9) {
                        if ((i9 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2091904342, i9, -1, "com.example.flashcardapp.ui.SettingsTab.<anonymous>.<anonymous>.<anonymous> (SettingsTab.kt:1007)");
                        }
                        composer3.startReplaceableGroup(2029361258);
                        final MutableState<Boolean> mutableState33 = mutableState6;
                        Object rememberedValue37 = composer3.rememberedValue();
                        if (rememberedValue37 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue37 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$12$1$1
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
                                    SettingsTabKt.SettingsTab$lambda$97$lambda$96$lambda$89(mutableState33, false);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue37);
                        }
                        composer3.endReplaceableGroup();
                        ButtonKt.TextButton((Function0) rememberedValue37, null, false, null, null, null, null, null, null, ComposableSingletons$SettingsTabKt.INSTANCE.m6320getLambda9$app_release(), composer3, 805306374, 510);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                });
                Function2<Composer, Integer, Unit> m6309getLambda10$app_release = ComposableSingletons$SettingsTabKt.INSTANCE.m6309getLambda10$app_release();
                ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(startRestartGroup, -1490814675, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$13
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

                    public final void invoke(Composer composer3, int i9) {
                        String SettingsTab$lambda$97$lambda$96$lambda$93;
                        if ((i9 & 11) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1490814675, i9, -1, "com.example.flashcardapp.ui.SettingsTab.<anonymous>.<anonymous>.<anonymous> (SettingsTab.kt:973)");
                            }
                            Arrangement.HorizontalOrVertical m478spacedBy0680j_49 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(8));
                            final MutableState<String> mutableState33 = mutableState32;
                            composer3.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            Modifier.Companion companion8 = Modifier.INSTANCE;
                            MeasurePolicy columnMeasurePolicy8 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_49, Alignment.INSTANCE.getStart(), composer3, 6);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash13 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap13 = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor13 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf13 = LayoutKt.modifierMaterializerOf(companion8);
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor13);
                            } else {
                                composer3.useNode();
                            }
                            Composer m2947constructorimpl13 = Updater.m2947constructorimpl(composer3);
                            Updater.m2954setimpl(m2947constructorimpl13, columnMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m2954setimpl(m2947constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash13 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m2947constructorimpl13.getInserting() || !Intrinsics.areEqual(m2947constructorimpl13.rememberedValue(), Integer.valueOf(currentCompositeKeyHash13))) {
                                m2947constructorimpl13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash13));
                                m2947constructorimpl13.apply(Integer.valueOf(currentCompositeKeyHash13), setCompositeKeyHash13);
                            }
                            modifierMaterializerOf13.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance8 = ColumnScopeInstance.INSTANCE;
                            TextKt.m2133Text4IGK_g("Enter the password to activate premium features.", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 6, 0, 131070);
                            SettingsTab$lambda$97$lambda$96$lambda$93 = SettingsTabKt.SettingsTab$lambda$97$lambda$96$lambda$93(mutableState33);
                            PasswordVisualTransformation passwordVisualTransformation = new PasswordVisualTransformation((char) 0, 1, null);
                            TextFieldColors m1735colors0hiis_0 = OutlinedTextFieldDefaults.INSTANCE.m1735colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer3, 0, 0, 0, 0, 3072, 2139092991, 4095);
                            composer3.startReplaceableGroup(-686136159);
                            Object rememberedValue37 = composer3.rememberedValue();
                            if (rememberedValue37 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue37 = (Function1) new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$4$1$13$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                        invoke2(str);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(String it2) {
                                        Intrinsics.checkNotNullParameter(it2, "it");
                                        mutableState33.setValue(it2);
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue37);
                            }
                            composer3.endReplaceableGroup();
                            OutlinedTextFieldKt.OutlinedTextField(SettingsTab$lambda$97$lambda$96$lambda$93, (Function1<? super String, Unit>) rememberedValue37, (Modifier) null, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$SettingsTabKt.INSTANCE.m6310getLambda11$app_release(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) passwordVisualTransformation, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, m1735colors0hiis_0, composer3, 1572912, 12582912, 0, 4046780);
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
                composer2 = startRestartGroup;
                AndroidAlertDialog_androidKt.m1232AlertDialogOix01E0((Function0) rememberedValue36, composableLambda, null, composableLambda2, null, m6309getLambda10$app_release, composableLambda3, null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, 1772598, 0, 16276);
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceableGroup();
            SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(24)), composer2, 6);
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
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$SettingsTab$5
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i9) {
                    SettingsTabKt.SettingsTab(z, onDarkModeToggle, themePreset, onThemePresetChange, fontFamilyType, onFontFamilyTypeChange, onNavigateToProfile, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final String SettingsTab$lambda$3(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SettingsTab$lambda$9(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<File> SettingsTab$lambda$13(MutableState<List<File>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int SettingsTab$lambda$16(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsTab$lambda$17(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SettingsTab$lambda$25(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsTab$lambda$26(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SettingsTab$lambda$28(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsTab$lambda$29(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float SettingsTab$lambda$31(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsTab$lambda$32(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SettingsTab$lambda$34(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean SettingsTab$lambda$37(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsTab$lambda$38(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String SettingsTab$lambda$40(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean SettingsTab$lambda$43(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsTab$lambda$44(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final int SettingsTab$lambda$46(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsTab$lambda$47(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final int SettingsTab$lambda$49(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsTab$lambda$50(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final String SettingsTab$lambda$52(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean SettingsTab$lambda$55(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsTab$lambda$56(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float SettingsTab$lambda$58(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsTab$lambda$59(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SettingsTab$lambda$61(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SettingsTab$lambda$64(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsTab$lambda$65(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int SettingsTab$lambda$97$lambda$96$lambda$85(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsTab$lambda$97$lambda$96$lambda$86(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final boolean SettingsTab$lambda$97$lambda$96$lambda$88(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsTab$lambda$97$lambda$96$lambda$89(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SettingsTab$lambda$97$lambda$96$lambda$93(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SectionLabel(final java.lang.String r31, boolean r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.ui.SettingsTabKt.SectionLabel(java.lang.String, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PresetDropdownWithManualInput-lmFMXvc, reason: not valid java name */
    public static final void m6345PresetDropdownWithManualInputlmFMXvc(final String str, final int i, final List<Integer> list, final List<String> list2, final String str2, int i2, final Function1<? super Integer, Unit> function1, final long j, boolean z, Composer composer, final int i3, final int i4) {
        Composer startRestartGroup = composer.startRestartGroup(-559875376);
        int i5 = (i4 & 32) != 0 ? 500 : i2;
        final boolean z2 = (i4 & 256) != 0 ? false : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-559875376, i3, -1, "com.example.flashcardapp.ui.PresetDropdownWithManualInput (SettingsTab.kt:1044)");
        }
        startRestartGroup.startReplaceableGroup(106762346);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        boolean z3 = list.contains(Integer.valueOf(i)) || i == 0;
        startRestartGroup.startReplaceableGroup(106762453);
        boolean z4 = (((i3 & 112) ^ 48) > 32 && startRestartGroup.changed(i)) || (i3 & 48) == 32;
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (z4 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((z3 || i <= 0) ? "" : String.valueOf(i), null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        final MutableState mutableState2 = (MutableState) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(6));
        startRestartGroup.startReplaceableGroup(-483455358);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
        Modifier.Companion companion = Modifier.INSTANCE;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_4, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
        Updater.m2954setimpl(m2947constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl.getInserting() || !Intrinsics.areEqual(m2947constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m2947constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m2947constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        modifierMaterializerOf.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
        Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
        startRestartGroup.startReplaceableGroup(693286680);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, startRestartGroup, 54);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor2);
        } else {
            startRestartGroup.useNode();
        }
        Composer m2947constructorimpl2 = Updater.m2947constructorimpl(startRestartGroup);
        Updater.m2954setimpl(m2947constructorimpl2, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl2.getInserting() || !Intrinsics.areEqual(m2947constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            m2947constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m2947constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        modifierMaterializerOf2.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        long sp = TextUnitKt.getSp(14);
        startRestartGroup.startReplaceableGroup(23747888);
        long onSurface = z2 ? MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnSurface() : ColorKt.Color(4280693304L);
        startRestartGroup.endReplaceableGroup();
        TextKt.m2133Text4IGK_g(str, (Modifier) null, onSurface, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, (i3 & 14) | 3072, 0, 131058);
        TextKt.m2133Text4IGK_g(i == 0 ? "All / Unlimited" : String.valueOf(i), (Modifier) null, j, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, ((i3 >> 15) & 896) | 199680, 0, 131026);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
        float f = 12;
        Arrangement.HorizontalOrVertical m478spacedBy0680j_42 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f));
        Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
        final int i6 = i5;
        startRestartGroup.startReplaceableGroup(693286680);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m478spacedBy0680j_42, centerVertically2, startRestartGroup, 54);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default2);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor3);
        } else {
            startRestartGroup.useNode();
        }
        Composer m2947constructorimpl3 = Updater.m2947constructorimpl(startRestartGroup);
        Updater.m2954setimpl(m2947constructorimpl3, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
            m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
        }
        modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
        Modifier weight$default = RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null);
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(weight$default);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor4);
        } else {
            startRestartGroup.useNode();
        }
        Composer m2947constructorimpl4 = Updater.m2947constructorimpl(startRestartGroup);
        Updater.m2954setimpl(m2947constructorimpl4, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
            m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
            m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
        }
        modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        startRestartGroup.startReplaceableGroup(-1653700871);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$PresetDropdownWithManualInput$1$2$1$1$1
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
                    SettingsTabKt.PresetDropdownWithManualInput_lmFMXvc$lambda$100(mutableState, true);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        Function0 function0 = (Function0) rememberedValue3;
        startRestartGroup.endReplaceableGroup();
        float f2 = 48;
        Modifier m604height3ABfNKs = SizeKt.m604height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(f2));
        RoundedCornerShape m839RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f));
        int i7 = (i3 >> 18) & 112;
        ButtonColors m1284outlinedButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1284outlinedButtonColorsro_MJ88(0L, j, 0L, 0L, startRestartGroup, i7 | (ButtonDefaults.$stable << 12), 13);
        float m5738constructorimpl = Dp.m5738constructorimpl(1);
        startRestartGroup.startReplaceableGroup(-1653700585);
        long outlineVariant = z2 ? MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOutlineVariant() : ColorKt.Color(4293452524L);
        startRestartGroup.endReplaceableGroup();
        ButtonKt.OutlinedButton(function0, m604height3ABfNKs, false, m839RoundedCornerShape0680j_4, m1284outlinedButtonColorsro_MJ88, null, BorderStrokeKt.m244BorderStrokecXLIe8U(m5738constructorimpl, outlineVariant), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -990652441, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$PresetDropdownWithManualInput$1$2$1$2
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

            public final void invoke(RowScope OutlinedButton, Composer composer2, int i8) {
                String valueOf;
                Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
                if ((i8 & 81) != 16 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-990652441, i8, -1, "com.example.flashcardapp.ui.PresetDropdownWithManualInput.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsTab.kt:1082)");
                    }
                    Arrangement.HorizontalOrVertical spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                    Modifier fillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    int i9 = i;
                    List<Integer> list3 = list;
                    long j2 = j;
                    composer2.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(spaceBetween2, centerVertically3, composer2, 54);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default3);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor5);
                    } else {
                        composer2.useNode();
                    }
                    Composer m2947constructorimpl5 = Updater.m2947constructorimpl(composer2);
                    Updater.m2954setimpl(m2947constructorimpl5, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl5.getInserting() || !Intrinsics.areEqual(m2947constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                        m2947constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                        m2947constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                    }
                    modifierMaterializerOf5.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                    if (i9 == 0) {
                        valueOf = "All";
                    } else {
                        valueOf = list3.contains(Integer.valueOf(i9)) ? String.valueOf(i9) : "Custom";
                    }
                    TextKt.m2133Text4IGK_g(valueOf, (Modifier) null, 0L, TextUnitKt.getSp(13), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 199680, 0, 131030);
                    IconKt.m1605Iconww6aTOc(ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE), (String) null, (Modifier) null, j2, composer2, 48, 4);
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
        }), startRestartGroup, 805306422, 420);
        boolean PresetDropdownWithManualInput_lmFMXvc$lambda$99 = PresetDropdownWithManualInput_lmFMXvc$lambda$99(mutableState);
        startRestartGroup.startReplaceableGroup(-1653699602);
        Object rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$PresetDropdownWithManualInput$1$2$1$3$1
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
                    SettingsTabKt.PresetDropdownWithManualInput_lmFMXvc$lambda$100(mutableState, false);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue4);
        }
        startRestartGroup.endReplaceableGroup();
        AndroidMenu_androidKt.m1233DropdownMenu4kj_NE(PresetDropdownWithManualInput_lmFMXvc$lambda$99, (Function0) rememberedValue4, null, 0L, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 540233158, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$PresetDropdownWithManualInput$1$2$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                invoke(columnScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ColumnScope DropdownMenu, Composer composer2, int i8) {
                Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
                if ((i8 & 81) != 16 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(540233158, i8, -1, "com.example.flashcardapp.ui.PresetDropdownWithManualInput.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsTab.kt:1104)");
                    }
                    composer2.startReplaceableGroup(139725268);
                    List<Integer> list3 = list;
                    final Function1<Integer, Unit> function12 = function1;
                    final List<String> list4 = list2;
                    final MutableState<Boolean> mutableState3 = mutableState;
                    final int i9 = 0;
                    for (Object obj : list3) {
                        int i10 = i9 + 1;
                        if (i9 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        final int intValue = ((Number) obj).intValue();
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, -389706914, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$PresetDropdownWithManualInput$1$2$1$4$1$1
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

                            public final void invoke(Composer composer3, int i11) {
                                if ((i11 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-389706914, i11, -1, "com.example.flashcardapp.ui.PresetDropdownWithManualInput.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsTab.kt:1106)");
                                }
                                TextKt.m2133Text4IGK_g(list4.get(i9), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131070);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        composer2.startReplaceableGroup(1045241513);
                        boolean changedInstance = composer2.changedInstance(function12) | composer2.changed(intValue);
                        Object rememberedValue5 = composer2.rememberedValue();
                        if (changedInstance || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue5 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$PresetDropdownWithManualInput$1$2$1$4$1$2$1
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
                                    function12.invoke(Integer.valueOf(intValue));
                                    SettingsTabKt.PresetDropdownWithManualInput_lmFMXvc$lambda$100(mutableState3, false);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue5);
                        }
                        composer2.endReplaceableGroup();
                        AndroidMenu_androidKt.DropdownMenuItem(composableLambda, (Function0) rememberedValue5, null, null, null, false, null, null, null, composer2, 6, 508);
                        i9 = i10;
                        mutableState3 = mutableState3;
                    }
                    composer2.endReplaceableGroup();
                    Function2<Composer, Integer, Unit> m6311getLambda12$app_release = ComposableSingletons$SettingsTabKt.INSTANCE.m6311getLambda12$app_release();
                    composer2.startReplaceableGroup(139725763);
                    boolean changedInstance2 = composer2.changedInstance(function1);
                    final Function1<Integer, Unit> function13 = function1;
                    final MutableState<Boolean> mutableState4 = mutableState;
                    Object rememberedValue6 = composer2.rememberedValue();
                    if (changedInstance2 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue6 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$PresetDropdownWithManualInput$1$2$1$4$2$1
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
                                function13.invoke(0);
                                SettingsTabKt.PresetDropdownWithManualInput_lmFMXvc$lambda$100(mutableState4, false);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue6);
                    }
                    composer2.endReplaceableGroup();
                    AndroidMenu_androidKt.DropdownMenuItem(m6311getLambda12$app_release, (Function0) rememberedValue6, null, null, null, false, null, null, null, composer2, 6, 508);
                    Function2<Composer, Integer, Unit> m6312getLambda13$app_release = ComposableSingletons$SettingsTabKt.INSTANCE.m6312getLambda13$app_release();
                    composer2.startReplaceableGroup(139726029);
                    final MutableState<Boolean> mutableState5 = mutableState;
                    Object rememberedValue7 = composer2.rememberedValue();
                    if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue7 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$PresetDropdownWithManualInput$1$2$1$4$3$1
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
                                SettingsTabKt.PresetDropdownWithManualInput_lmFMXvc$lambda$100(mutableState5, false);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue7);
                    }
                    composer2.endReplaceableGroup();
                    AndroidMenu_androidKt.DropdownMenuItem(m6312getLambda13$app_release, (Function0) rememberedValue7, null, null, null, false, null, null, null, composer2, 54, 508);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, 1572912, 60);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        String PresetDropdownWithManualInput_lmFMXvc$lambda$102 = PresetDropdownWithManualInput_lmFMXvc$lambda$102(mutableState2);
        KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, KeyboardType.INSTANCE.m5466getNumberPjHm6EE(), 0, null, 27, null);
        OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
        startRestartGroup.startReplaceableGroup(23751776);
        long outlineVariant2 = z2 ? MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOutlineVariant() : ColorKt.Color(4293452524L);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(23751899);
        long onSurfaceVariant = z2 ? MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant() : Color.INSTANCE.m3447getGray0d7_KjU();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(23752014);
        long onSurface2 = z2 ? MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnSurface() : Color.INSTANCE.m3443getBlack0d7_KjU();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(23752125);
        long onSurface3 = z2 ? MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnSurface() : Color.INSTANCE.m3443getBlack0d7_KjU();
        startRestartGroup.endReplaceableGroup();
        OutlinedTextFieldKt.OutlinedTextField(PresetDropdownWithManualInput_lmFMXvc$lambda$102, (Function1<? super String, Unit>) new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$PresetDropdownWithManualInput$1$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                invoke2(str3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                String str3 = text;
                StringBuilder sb = new StringBuilder();
                int length = str3.length();
                for (int i8 = 0; i8 < length; i8++) {
                    char charAt = str3.charAt(i8);
                    if (Character.isDigit(charAt)) {
                        sb.append(charAt);
                    }
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                mutableState2.setValue(sb2);
                Integer intOrNull = StringsKt.toIntOrNull(sb2);
                int intValue = intOrNull != null ? intOrNull.intValue() : 0;
                int i9 = i6;
                if (intValue > i9) {
                    intValue = i9;
                }
                if (sb2.length() > 0) {
                    function1.invoke(Integer.valueOf(intValue));
                    return;
                }
                Function1<Integer, Unit> function12 = function1;
                Integer num = (Integer) CollectionsKt.firstOrNull((List) list);
                function12.invoke(Integer.valueOf(num != null ? num.intValue() : 20));
            }
        }, SizeKt.m604height3ABfNKs(RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m5738constructorimpl(f2)), false, false, new TextStyle(0L, TextUnitKt.getSp(13), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777213, (DefaultConstructorMarker) null), (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, 881493509, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$PresetDropdownWithManualInput$1$2$3
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

            public final void invoke(Composer composer2, int i8) {
                if ((i8 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(881493509, i8, -1, "com.example.flashcardapp.ui.PresetDropdownWithManualInput.<anonymous>.<anonymous>.<anonymous> (SettingsTab.kt:1142)");
                }
                TextKt.m2133Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, outlinedTextFieldDefaults.m1735colors0hiis_0(onSurface2, onSurface3, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, j, outlineVariant2, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, j, onSurfaceVariant, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 0, i7, (i3 >> 12) & 7168, 0, 3072, 2122311676, 4095), startRestartGroup, 1769472, 12779520, 0, 4030360);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$PresetDropdownWithManualInput$2
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

                public final void invoke(Composer composer2, int i8) {
                    SettingsTabKt.m6345PresetDropdownWithManualInputlmFMXvc(str, i, list, list2, str2, i6, function1, j, z2, composer2, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PresetDropdownWithManualInput_lmFMXvc$lambda$100(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean PresetDropdownWithManualInput_lmFMXvc$lambda$99(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final String PresetDropdownWithManualInput_lmFMXvc$lambda$102(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: StudyModeCard-jwffKRY, reason: not valid java name */
    public static final void m6346StudyModeCardjwffKRY(final String str, final ImageVector imageVector, final long j, final long j2, final int i, final Function1<? super Integer, Unit> function1, final List<Integer> list, final List<String> list2, int i2, String str2, final int i3, final Function1<? super Integer, Unit> function12, final List<Integer> list3, final List<String> list4, String str3, final String str4, final boolean z, final Function1<? super Boolean, Unit> function13, final Function1<? super String, Unit> function14, final List<String> list5, final boolean z2, boolean z3, Composer composer, final int i4, final int i5, final int i6, final int i7) {
        Composer startRestartGroup = composer.startRestartGroup(-1847574281);
        int i8 = (i7 & 256) != 0 ? 500 : i2;
        String str5 = (i7 & 512) != 0 ? "Manual (1-500)" : str2;
        String str6 = (i7 & 16384) != 0 ? "Manual Secs" : str3;
        boolean z4 = (2097152 & i7) != 0 ? false : z3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1847574281, i4, i5, "com.example.flashcardapp.ui.StudyModeCard (SettingsTab.kt:1186)");
        }
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
        RoundedCornerShape m839RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(20));
        CardDefaults cardDefaults = CardDefaults.INSTANCE;
        startRestartGroup.startReplaceableGroup(-736772461);
        long surfaceVariant = z4 ? MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getSurfaceVariant() : Color.INSTANCE.m3454getWhite0d7_KjU();
        startRestartGroup.endReplaceableGroup();
        CardColors m1295cardColorsro_MJ88 = cardDefaults.m1295cardColorsro_MJ88(surfaceVariant, 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14);
        float m5738constructorimpl = Dp.m5738constructorimpl(1);
        startRestartGroup.startReplaceableGroup(-736772349);
        long m3416copywmQWz5c$default = z4 ? Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOutlineVariant(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null) : ColorKt.Color(4293718001L);
        startRestartGroup.endReplaceableGroup();
        final String str7 = str5;
        final int i9 = i8;
        final boolean z5 = z4;
        final String str8 = str6;
        CardKt.Card(fillMaxWidth$default, m839RoundedCornerShape0680j_4, m1295cardColorsro_MJ88, CardDefaults.INSTANCE.m1296cardElevationaqJV_2Y(Dp.m5738constructorimpl(0), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, (CardDefaults.$stable << 18) | 6, 62), BorderStrokeKt.m244BorderStrokecXLIe8U(m5738constructorimpl, m3416copywmQWz5c$default), ComposableLambdaKt.composableLambda(startRestartGroup, -312521239, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$StudyModeCard$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                invoke(columnScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ColumnScope Card, Composer composer2, int i10) {
                Intrinsics.checkNotNullParameter(Card, "$this$Card");
                if ((i10 & 81) != 16 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-312521239, i10, -1, "com.example.flashcardapp.ui.StudyModeCard.<anonymous> (SettingsTab.kt:1194)");
                    }
                    long j3 = j;
                    ImageVector imageVector2 = imageVector;
                    long j4 = j2;
                    String str9 = str;
                    int i11 = i;
                    List<Integer> list6 = list;
                    List<String> list7 = list2;
                    String str10 = str7;
                    int i12 = i9;
                    Function1<Integer, Unit> function15 = function1;
                    boolean z6 = z5;
                    boolean z7 = z2;
                    int i13 = i3;
                    List<Integer> list8 = list3;
                    List<String> list9 = list4;
                    String str11 = str8;
                    Function1<Integer, Unit> function16 = function12;
                    final Function1<Boolean, Unit> function17 = function13;
                    boolean z8 = z;
                    String str12 = str4;
                    final List<String> list10 = list5;
                    final Function1<String, Unit> function18 = function14;
                    composer2.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                    float f = 8;
                    Modifier m570paddingVpY3zN4 = PaddingKt.m570paddingVpY3zN4(BackgroundKt.m216backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), j3, null, 2, null), Dp.m5738constructorimpl(16), Dp.m5738constructorimpl(f));
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f));
                    composer2.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m478spacedBy0680j_4, centerVertically, composer2, 54);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m570paddingVpY3zN4);
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
                    IconKt.m1605Iconww6aTOc(imageVector2, (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(18)), j4, composer2, 432, 0);
                    TextKt.m2133Text4IGK_g(str9, (Modifier) null, j4, TextUnitKt.getSp(12), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 199680, 0, 131026);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    float f2 = 12;
                    Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f2));
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_42 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(10));
                    composer2.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_42, Alignment.INSTANCE.getStart(), composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
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
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    SettingsTabKt.m6345PresetDropdownWithManualInputlmFMXvc("Question Count", i11, list6, list7, str10, i12, function15, j4, z6, composer2, 4614, 0);
                    composer2.startReplaceableGroup(-1865026239);
                    if (!z7) {
                        SettingsTabKt.m6345PresetDropdownWithManualInputlmFMXvc("Time Limit per Question", i13, list8, list9, str11, 600, function16, j4, z6, composer2, 201222, 0);
                    }
                    composer2.endReplaceableGroup();
                    Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                    composer2.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween, centerVertically2, composer2, 54);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default2);
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
                    Updater.m2954setimpl(m2947constructorimpl4, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    long sp = TextUnitKt.getSp(14);
                    composer2.startReplaceableGroup(6032227);
                    long onSurface = z6 ? MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurface() : ColorKt.Color(4280693304L);
                    composer2.endReplaceableGroup();
                    TextKt.m2133Text4IGK_g("Learning Algorithm", (Modifier) null, onSurface, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 3078, 0, 131058);
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(companion2);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor5);
                    } else {
                        composer2.useNode();
                    }
                    Composer m2947constructorimpl5 = Updater.m2947constructorimpl(composer2);
                    Updater.m2954setimpl(m2947constructorimpl5, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl5.getInserting() || !Intrinsics.areEqual(m2947constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                        m2947constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                        m2947constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                    }
                    modifierMaterializerOf5.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    Modifier clip = ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f)));
                    composer2.startReplaceableGroup(-1916914269);
                    long surface = z6 ? MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getSurface() : ColorKt.Color(4294309880L);
                    composer2.endReplaceableGroup();
                    Modifier m216backgroundbw27NRU$default = BackgroundKt.m216backgroundbw27NRU$default(clip, surface, null, 2, null);
                    composer2.startReplaceableGroup(-1916914152);
                    boolean changedInstance = composer2.changedInstance(function17);
                    Object rememberedValue = composer2.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$StudyModeCard$1$1$2$1$1$1$1
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
                                function17.invoke(true);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    composer2.endReplaceableGroup();
                    Modifier m570paddingVpY3zN42 = PaddingKt.m570paddingVpY3zN4(ClickableKt.m251clickableXHw0xAI$default(m216backgroundbw27NRU$default, false, null, null, (Function0) rememberedValue, 7, null), Dp.m5738constructorimpl(f2), Dp.m5738constructorimpl(6));
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(m570paddingVpY3zN42);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor6);
                    } else {
                        composer2.useNode();
                    }
                    Composer m2947constructorimpl6 = Updater.m2947constructorimpl(composer2);
                    Updater.m2954setimpl(m2947constructorimpl6, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl6.getInserting() || !Intrinsics.areEqual(m2947constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                        m2947constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                        m2947constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
                    }
                    modifierMaterializerOf6.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    long sp2 = TextUnitKt.getSp(13);
                    FontWeight medium = FontWeight.INSTANCE.getMedium();
                    composer2.startReplaceableGroup(-754010448);
                    long onSurface2 = z6 ? MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurface() : j4;
                    composer2.endReplaceableGroup();
                    TextKt.m2133Text4IGK_g(str12, (Modifier) null, onSurface2, sp2, (FontStyle) null, medium, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 199680, 0, 131026);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.startReplaceableGroup(-1916913730);
                    boolean changedInstance2 = composer2.changedInstance(function17);
                    Object rememberedValue2 = composer2.rememberedValue();
                    if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$StudyModeCard$1$1$2$1$1$3$1
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
                                function17.invoke(false);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    composer2.endReplaceableGroup();
                    AndroidMenu_androidKt.m1233DropdownMenu4kj_NE(z8, (Function0) rememberedValue2, null, 0L, null, null, ComposableLambdaKt.composableLambda(composer2, -319929166, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$StudyModeCard$1$1$2$1$1$4
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                            invoke(columnScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ColumnScope DropdownMenu, Composer composer3, int i14) {
                            Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
                            if ((i14 & 81) != 16 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-319929166, i14, -1, "com.example.flashcardapp.ui.StudyModeCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsTab.kt:1251)");
                                }
                                List<String> list11 = list10;
                                final Function1<String, Unit> function19 = function18;
                                final Function1<Boolean, Unit> function110 = function17;
                                for (final String str13 : list11) {
                                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, -188708046, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$StudyModeCard$1$1$2$1$1$4$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i15) {
                                            if ((i15 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-188708046, i15, -1, "com.example.flashcardapp.ui.StudyModeCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsTab.kt:1252)");
                                            }
                                            TextKt.m2133Text4IGK_g(str13, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 0, 0, 131070);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                    composer3.startReplaceableGroup(-1593848275);
                                    boolean changedInstance3 = composer3.changedInstance(function19) | composer3.changed(str13) | composer3.changedInstance(function110);
                                    Object rememberedValue3 = composer3.rememberedValue();
                                    if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$StudyModeCard$1$1$2$1$1$4$1$2$1
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
                                                function19.invoke(str13);
                                                function110.invoke(false);
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue3);
                                    }
                                    composer3.endReplaceableGroup();
                                    AndroidMenu_androidKt.DropdownMenuItem(composableLambda, (Function0) rememberedValue3, null, null, null, false, null, null, null, composer3, 6, 508);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, 1572864, 60);
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
        }), startRestartGroup, 196614, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final int i10 = i8;
            final String str9 = str5;
            final String str10 = str6;
            final boolean z6 = z4;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsTabKt$StudyModeCard$2
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

                public final void invoke(Composer composer2, int i11) {
                    SettingsTabKt.m6346StudyModeCardjwffKRY(str, imageVector, j, j2, i, function1, list, list2, i10, str9, i3, function12, list3, list4, str10, str4, z, function13, function14, list5, z2, z6, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), RecomposeScopeImplKt.updateChangedFlags(i6), i7);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppLanguage SettingsTab$lambda$7(State<? extends AppLanguage> state) {
        return state.getValue();
    }
}
