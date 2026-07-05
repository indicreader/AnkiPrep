package com.example.flashcardapp.ui;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
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
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRightKt;
import androidx.compose.material.icons.automirrored.filled.ListKt;
import androidx.compose.material.icons.filled.CheckCircleKt;
import androidx.compose.material.icons.filled.CheckKt;
import androidx.compose.material.icons.filled.SyncKt;
import androidx.compose.material.icons.filled.WbSunnyKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MenuKt;
import androidx.compose.material3.OutlinedTextFieldDefaults;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.RadioButtonDefaults;
import androidx.compose.material3.RadioButtonKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.example.flashcardapp.data.AnkiDeck;
import com.example.flashcardapp.data.entities.CardAttemptEntity;
import com.example.flashcardapp.data.entities.SessionRecordEntity;
import com.example.flashcardapp.session.McqSessionMode;
import com.example.flashcardapp.ui.theme.ThemeKt;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: ReviewTab.kt */
@Metadata(d1 = {"\u0000°\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a)\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001aK\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0011\u001a/\u0010\u0012\u001a\u00020\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0014\u001a\u008d\u0001\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010 \u001aC\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\u0014\u0010&\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010'\u001a1\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020*2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010,\u001aQ\u0010-\u001a\u00020\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020#0\u00032\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0018\u00100\u001a\u0014\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u00103\u001a)\u00104\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a7\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u00107\u001aµ\u0003\u00108\u001a\u00020\u00012\u0006\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u000e2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020#0\u00032\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u00032\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010=\u001a\u00020\u000e2\u0014\b\u0002\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u001a\b\u0002\u0010D\u001a\u0014\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001012\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\u00132\u0014\b\u0002\u0010F\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\u00132\u001a\b\u0002\u0010G\u001a\u0014\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001012\u0014\b\u0002\u0010H\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\u00132\u0014\b\u0002\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00132F\b\u0002\u0010J\u001a@\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00010K2\u0014\b\u0002\u0010L\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u000e\b\u0002\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010N\u001a9\u0010O\u001a\u00020\u00012\u0006\u0010P\u001a\u00020\n2\u0006\u0010Q\u001a\u00020\n2\b\b\u0002\u0010R\u001a\u00020S2\u0010\b\u0002\u0010T\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0003¢\u0006\u0002\u0010U\u001a\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\f\u0010.\u001a\b\u0012\u0004\u0012\u00020#0\u0003\u001a\"\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\u0006\u0010Y\u001a\u00020\n\u001a\u0014\u0010Z\u001a\b\u0012\u0004\u0012\u0002020[2\u0006\u0010\u0016\u001a\u00020\u0017\u001a\u001c\u0010\\\u001a\u00020*2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u0003\u001a\u000e\u0010]\u001a\u00020*2\u0006\u0010\u0016\u001a\u00020\u0017¨\u0006^²\u0006\n\u0010_\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u0010_\u001a\u00020\nX\u008a\u008e\u0002²\u0006\f\u0010`\u001a\u0004\u0018\u00010%X\u008a\u008e\u0002²\u0006\f\u0010a\u001a\u0004\u0018\u00010#X\u008a\u008e\u0002²\u0006\n\u0010b\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010c\u001a\u00020dX\u008a\u0084\u0002²\u0006\n\u0010e\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u0010f\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010g\u001a\u00020*X\u008a\u008e\u0002²\u0006\n\u0010h\u001a\u00020*X\u008a\u008e\u0002²\u0006\n\u0010i\u001a\u00020jX\u008a\u0084\u0002²\u0006\n\u0010k\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\u0010\u0010l\u001a\b\u0012\u0004\u0012\u00020\n0[X\u008a\u008e\u0002²\u0006\f\u0010m\u001a\u0004\u0018\u00010\u0017X\u008a\u008e\u0002²\u0006\f\u0010n\u001a\u0004\u0018\u00010\u0017X\u008a\u008e\u0002²\u0006\f\u0010o\u001a\u0004\u0018\u00010\u0017X\u008a\u008e\u0002²\u0006\f\u0010p\u001a\u0004\u0018\u00010\u0017X\u008a\u008e\u0002²\u0006\f\u0010q\u001a\u0004\u0018\u00010\u0017X\u008a\u008e\u0002²\u0006\n\u0010r\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\u0018\u0010s\u001a\u0010\u0012\u0004\u0012\u000202\u0012\u0006\u0012\u0004\u0018\u00010%0tX\u008a\u008e\u0002²\u0006\f\u0010u\u001a\u0004\u0018\u000102X\u008a\u008e\u0002²\u0006\n\u0010v\u001a\u00020wX\u008a\u008e\u0002²\u0006\n\u0010x\u001a\u00020*X\u008a\u008e\u0002²\u0006\u001c\u0010y\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020*0{0zX\u008a\u0084\u0002²\u0006\n\u0010|\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010}\u001a\u00020wX\u008a\u0084\u0002²\u0006\n\u0010~\u001a\u00020wX\u008a\u0084\u0002²\u0006\n\u0010\u007f\u001a\u00020jX\u008a\u0084\u0002²\u0006\u0016\u0010\u0080\u0001\u001a\r \u0082\u0001*\u0005\u0018\u00010\u0081\u00010\u0081\u0001X\u008a\u008e\u0002²\u0006\u000b\u0010\u0083\u0001\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\u000b\u0010\u0084\u0001\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\u000b\u0010\u0085\u0001\u001a\u00020wX\u008a\u0084\u0002²\u0006\u000b\u0010\u0086\u0001\u001a\u00020wX\u008a\u0084\u0002"}, d2 = {"CalendarDialog", "", "sessionRecords", "", "Lcom/example/flashcardapp/data/entities/SessionRecordEntity;", "onDismissRequest", "Lkotlin/Function0;", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ConfirmDialog", "title", "", "body", "confirmLabel", "danger", "", "onConfirm", "onDismiss", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "CreateDeckDialog", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DeckOptionsMenu", "node", "Lcom/example/flashcardapp/ui/DeckNode;", "expanded", "onStudy", "onAddCard", "onEditCards", "onRename", "onClearProgress", "onDelete", "onExport", "(Lcom/example/flashcardapp/ui/DeckNode;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DeckSettingsDialog", "deck", "Lcom/example/flashcardapp/data/AnkiDeck;", "currentMode", "Lcom/example/flashcardapp/session/McqSessionMode;", "onModeChanged", "(Lcom/example/flashcardapp/data/AnkiDeck;Lcom/example/flashcardapp/session/McqSessionMode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "LegacyAnalyticsTab", "cardCount", "", "onMenuClicked", "(ILjava/util/List;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "MergeCsvDialog", "decks", "onNewDeck", "onMergeIntoDeck", "Lkotlin/Function2;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "QuizzesRunDialog", "RenameDialog", "currentName", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ReviewTab", "isAnkiInstalled", "hasPermission", "attemptsToday", "Lcom/example/flashcardapp/data/entities/CardAttemptEntity;", "isDarkMode", "onDarkModeToggle", "onRequestPermission", "onRefresh", "onImportApkgClicked", "onImportCsvClicked", "onImportEpubClicked", "onImportCsvMergeClicked", "onSelectDeck", "onDeleteDeck", "onRenameDeck", "onClearDeckProgress", "onCreateDeck", "onAddCardToDeck", "Lkotlin/Function8;", "onExportDeck", "onDeckOrderChanged", "(ZZLjava/util/List;Ljava/util/List;Lcom/example/flashcardapp/session/McqSessionMode;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function8;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;IIII)V", "StatCard", "label", AppMeasurementSdk.ConditionalUserProperty.VALUE, "modifier", "Landroidx/compose/ui/Modifier;", "onClick", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "buildDeckTree", "filterDeckTree", "nodes", SearchIntents.EXTRA_QUERY, "getAllDeckIds", "", "getPracticedCount", "getRecursiveCardCount", "app_release", "text", "selectedMode", "selectedDeck", "mergeMode", "currentLanguage", "Lcom/example/flashcardapp/data/AppLanguage;", "searchQuery", "isFabVisible", "lastScrollOffset", "lastScrollIndex", "fabOffsetY", "Landroidx/compose/ui/unit/Dp;", "showFabMenu", "expandedNodes", "renameNode", "deleteNode", "clearNode", "addCardNode", "settingsNode", "showCreateDialog", "deckModes", "", "draggingNodeId", "draggingOffset", "", "draggingIndex", "visibleNodes", "", "Lkotlin/Pair;", "menuExpanded", "rotationAngle", "scale", "elevation", "displayMonth", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "showCalendarDialog", "showQuizzesDialog", "animatedPct", "animatedFrac"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ReviewTabKt {
    public static final List<DeckNode> buildDeckTree(List<AnkiDeck> decks) {
        Intrinsics.checkNotNullParameter(decks, "decks");
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (AnkiDeck ankiDeck : decks) {
            List split$default = StringsKt.split$default((CharSequence) ankiDeck.getName(), new String[]{"::"}, false, 0, 6, (Object) null);
            int size = split$default.size();
            String str = "";
            int i = 0;
            DeckNode deckNode = null;
            while (i < size) {
                String str2 = (String) split$default.get(i);
                str = str.length() == 0 ? str2 : ((Object) str) + "::" + str2;
                DeckNode deckNode2 = (DeckNode) linkedHashMap.get(str);
                if (deckNode2 == null) {
                    deckNode2 = new DeckNode(i == CollectionsKt.getLastIndex(split$default) ? ankiDeck : null, str2, str, null, 8, null);
                    linkedHashMap.put(str, deckNode2);
                    if (deckNode == null) {
                        arrayList.add(deckNode2);
                    } else {
                        deckNode.getChildren().add(deckNode2);
                    }
                } else if (i == CollectionsKt.getLastIndex(split$default) && deckNode2.getDeck() == null) {
                    DeckNode deckNode3 = new DeckNode(ankiDeck, deckNode2.getShortName(), deckNode2.getFullPath(), deckNode2.getChildren());
                    linkedHashMap.put(str, deckNode3);
                    if (deckNode == null) {
                        Iterator it = arrayList.iterator();
                        int i2 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i2 = -1;
                                break;
                            }
                            if (Intrinsics.areEqual(((DeckNode) it.next()).getFullPath(), str)) {
                                break;
                            }
                            i2++;
                        }
                        if (i2 != -1) {
                            arrayList.set(i2, deckNode3);
                        }
                    } else {
                        Iterator<DeckNode> it2 = deckNode.getChildren().iterator();
                        int i3 = 0;
                        while (true) {
                            if (!it2.hasNext()) {
                                i3 = -1;
                                break;
                            }
                            if (Intrinsics.areEqual(it2.next().getFullPath(), str)) {
                                break;
                            }
                            i3++;
                        }
                        if (i3 != -1) {
                            deckNode.getChildren().set(i3, deckNode3);
                        }
                    }
                    deckNode = deckNode3;
                    i++;
                }
                deckNode = deckNode2;
                i++;
            }
        }
        return arrayList;
    }

    public static final List<DeckNode> filterDeckTree(List<DeckNode> nodes, String query) {
        Intrinsics.checkNotNullParameter(nodes, "nodes");
        Intrinsics.checkNotNullParameter(query, "query");
        String str = query;
        if (StringsKt.isBlank(str)) {
            return nodes;
        }
        ArrayList arrayList = new ArrayList();
        for (DeckNode deckNode : nodes) {
            List<DeckNode> filterDeckTree = filterDeckTree(deckNode.getChildren(), query);
            DeckNode deckNode2 = (StringsKt.contains((CharSequence) deckNode.getShortName(), (CharSequence) str, true) || StringsKt.contains((CharSequence) deckNode.getFullPath(), (CharSequence) str, true) || (filterDeckTree.isEmpty() ^ true)) ? new DeckNode(deckNode.getDeck(), deckNode.getShortName(), deckNode.getFullPath(), CollectionsKt.toMutableList((Collection) filterDeckTree)) : null;
            if (deckNode2 != null) {
                arrayList.add(deckNode2);
            }
        }
        return arrayList;
    }

    public static final int getRecursiveCardCount(DeckNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        AnkiDeck deck = node.getDeck();
        int cardCount = deck != null ? deck.getCardCount() : 0;
        Iterator<DeckNode> it = node.getChildren().iterator();
        while (it.hasNext()) {
            cardCount += getRecursiveCardCount(it.next());
        }
        return cardCount;
    }

    public static final Set<Long> getAllDeckIds(DeckNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        AnkiDeck deck = node.getDeck();
        if (deck != null) {
            linkedHashSet.add(Long.valueOf(deck.getId()));
        }
        Iterator<DeckNode> it = node.getChildren().iterator();
        while (it.hasNext()) {
            linkedHashSet.addAll(getAllDeckIds(it.next()));
        }
        return linkedHashSet;
    }

    public static final int getPracticedCount(DeckNode node, List<CardAttemptEntity> attemptsToday) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(attemptsToday, "attemptsToday");
        Set<Long> allDeckIds = getAllDeckIds(node);
        ArrayList arrayList = new ArrayList();
        for (Object obj : attemptsToday) {
            if (allDeckIds.contains(Long.valueOf(((CardAttemptEntity) obj).getDeckId()))) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(Long.valueOf(((CardAttemptEntity) it.next()).getCardId()));
        }
        return CollectionsKt.distinct(arrayList3).size();
    }

    public static final void DeckOptionsMenu(final DeckNode node, final boolean z, final Function0<Unit> onDismiss, final Function0<Unit> onStudy, final Function0<Unit> onAddCard, final Function0<Unit> onEditCards, final Function0<Unit> onRename, final Function0<Unit> onClearProgress, final Function0<Unit> onDelete, final Function0<Unit> onExport, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onStudy, "onStudy");
        Intrinsics.checkNotNullParameter(onAddCard, "onAddCard");
        Intrinsics.checkNotNullParameter(onEditCards, "onEditCards");
        Intrinsics.checkNotNullParameter(onRename, "onRename");
        Intrinsics.checkNotNullParameter(onClearProgress, "onClearProgress");
        Intrinsics.checkNotNullParameter(onDelete, "onDelete");
        Intrinsics.checkNotNullParameter(onExport, "onExport");
        Composer startRestartGroup = composer.startRestartGroup(-1732684416);
        if ((i & 112) == 0) {
            i2 = (startRestartGroup.changed(z) ? 32 : 16) | i;
        } else {
            i2 = i;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changedInstance(onStudy) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(onAddCard) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(onEditCards) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(onRename) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(onClearProgress) ? 8388608 : 4194304;
        }
        if ((234881024 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(onDelete) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((1879048192 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(onExport) ? 536870912 : 268435456;
        }
        int i3 = i2;
        if ((1533916881 & i3) != 306783376 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1732684416, i3, -1, "com.example.flashcardapp.ui.DeckOptionsMenu (ReviewTab.kt:146)");
            }
            int i4 = i3 >> 3;
            composer2 = startRestartGroup;
            AndroidMenu_androidKt.m1233DropdownMenu4kj_NE(z, onDismiss, BackgroundKt.m216backgroundbw27NRU$default(Modifier.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getSurface(), null, 2, null), 0L, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1784034739, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$DeckOptionsMenu$1
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

                public final void invoke(ColumnScope DropdownMenu, Composer composer3, int i5) {
                    Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
                    if ((i5 & 81) != 16 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1784034739, i5, -1, "com.example.flashcardapp.ui.DeckOptionsMenu.<anonymous> (ReviewTab.kt:152)");
                        }
                        Function2<Composer, Integer, Unit> m6246getLambda1$app_release = ComposableSingletons$ReviewTabKt.INSTANCE.m6246getLambda1$app_release();
                        composer3.startReplaceableGroup(-1559733938);
                        boolean changedInstance = composer3.changedInstance(onDismiss) | composer3.changedInstance(onStudy);
                        final Function0<Unit> function0 = onDismiss;
                        final Function0<Unit> function02 = onStudy;
                        Object rememberedValue = composer3.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$DeckOptionsMenu$1$1$1
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
                        AndroidMenu_androidKt.DropdownMenuItem(m6246getLambda1$app_release, (Function0) rememberedValue, null, ComposableSingletons$ReviewTabKt.INSTANCE.m6257getLambda2$app_release(), null, false, null, null, null, composer3, 3078, 500);
                        Function2<Composer, Integer, Unit> m6268getLambda3$app_release = ComposableSingletons$ReviewTabKt.INSTANCE.m6268getLambda3$app_release();
                        composer3.startReplaceableGroup(-1559733707);
                        boolean changedInstance2 = composer3.changedInstance(onDismiss) | composer3.changedInstance(onAddCard);
                        final Function0<Unit> function03 = onDismiss;
                        final Function0<Unit> function04 = onAddCard;
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$DeckOptionsMenu$1$2$1
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
                                    function04.invoke();
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        AndroidMenu_androidKt.DropdownMenuItem(m6268getLambda3$app_release, (Function0) rememberedValue2, null, ComposableSingletons$ReviewTabKt.INSTANCE.m6279getLambda4$app_release(), null, false, null, null, null, composer3, 3078, 500);
                        Function2<Composer, Integer, Unit> m6290getLambda5$app_release = ComposableSingletons$ReviewTabKt.INSTANCE.m6290getLambda5$app_release();
                        composer3.startReplaceableGroup(-1559733471);
                        boolean changedInstance3 = composer3.changedInstance(onDismiss) | composer3.changedInstance(onEditCards);
                        final Function0<Unit> function05 = onDismiss;
                        final Function0<Unit> function06 = onEditCards;
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$DeckOptionsMenu$1$3$1
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
                                    function05.invoke();
                                    function06.invoke();
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        composer3.endReplaceableGroup();
                        AndroidMenu_androidKt.DropdownMenuItem(m6290getLambda5$app_release, (Function0) rememberedValue3, null, ComposableSingletons$ReviewTabKt.INSTANCE.m6295getLambda6$app_release(), null, false, null, null, null, composer3, 3078, 500);
                        Function2<Composer, Integer, Unit> m6296getLambda7$app_release = ComposableSingletons$ReviewTabKt.INSTANCE.m6296getLambda7$app_release();
                        composer3.startReplaceableGroup(-1559733232);
                        boolean changedInstance4 = composer3.changedInstance(onDismiss) | composer3.changedInstance(onRename);
                        final Function0<Unit> function07 = onDismiss;
                        final Function0<Unit> function08 = onRename;
                        Object rememberedValue4 = composer3.rememberedValue();
                        if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue4 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$DeckOptionsMenu$1$4$1
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
                                    function07.invoke();
                                    function08.invoke();
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue4);
                        }
                        composer3.endReplaceableGroup();
                        AndroidMenu_androidKt.DropdownMenuItem(m6296getLambda7$app_release, (Function0) rememberedValue4, null, ComposableSingletons$ReviewTabKt.INSTANCE.m6297getLambda8$app_release(), null, false, null, null, null, composer3, 3078, 500);
                        Function2<Composer, Integer, Unit> m6298getLambda9$app_release = ComposableSingletons$ReviewTabKt.INSTANCE.m6298getLambda9$app_release();
                        composer3.startReplaceableGroup(-1559732991);
                        boolean changedInstance5 = composer3.changedInstance(onDismiss) | composer3.changedInstance(onClearProgress);
                        final Function0<Unit> function09 = onDismiss;
                        final Function0<Unit> function010 = onClearProgress;
                        Object rememberedValue5 = composer3.rememberedValue();
                        if (changedInstance5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue5 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$DeckOptionsMenu$1$5$1
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
                                    function09.invoke();
                                    function010.invoke();
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue5);
                        }
                        composer3.endReplaceableGroup();
                        AndroidMenu_androidKt.DropdownMenuItem(m6298getLambda9$app_release, (Function0) rememberedValue5, null, ComposableSingletons$ReviewTabKt.INSTANCE.m6247getLambda10$app_release(), null, false, null, null, null, composer3, 3078, 500);
                        Function2<Composer, Integer, Unit> m6248getLambda11$app_release = ComposableSingletons$ReviewTabKt.INSTANCE.m6248getLambda11$app_release();
                        composer3.startReplaceableGroup(-1559732749);
                        boolean changedInstance6 = composer3.changedInstance(onDismiss) | composer3.changedInstance(onExport);
                        final Function0<Unit> function011 = onDismiss;
                        final Function0<Unit> function012 = onExport;
                        Object rememberedValue6 = composer3.rememberedValue();
                        if (changedInstance6 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue6 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$DeckOptionsMenu$1$6$1
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
                                    function011.invoke();
                                    function012.invoke();
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue6);
                        }
                        composer3.endReplaceableGroup();
                        AndroidMenu_androidKt.DropdownMenuItem(m6248getLambda11$app_release, (Function0) rememberedValue6, null, ComposableSingletons$ReviewTabKt.INSTANCE.m6249getLambda12$app_release(), null, false, null, null, null, composer3, 3078, 500);
                        DividerKt.m1532HorizontalDivider9IZ8Weo(null, 0.0f, Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOutlineVariant(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), composer3, 0, 3);
                        Function2<Composer, Integer, Unit> m6250getLambda13$app_release = ComposableSingletons$ReviewTabKt.INSTANCE.m6250getLambda13$app_release();
                        composer3.startReplaceableGroup(-1559732379);
                        boolean changedInstance7 = composer3.changedInstance(onDismiss) | composer3.changedInstance(onDelete);
                        final Function0<Unit> function013 = onDismiss;
                        final Function0<Unit> function014 = onDelete;
                        Object rememberedValue7 = composer3.rememberedValue();
                        if (changedInstance7 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue7 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$DeckOptionsMenu$1$7$1
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
                                    function013.invoke();
                                    function014.invoke();
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue7);
                        }
                        composer3.endReplaceableGroup();
                        AndroidMenu_androidKt.DropdownMenuItem(m6250getLambda13$app_release, (Function0) rememberedValue7, null, ComposableSingletons$ReviewTabKt.INSTANCE.m6251getLambda14$app_release(), null, false, null, null, null, composer3, 3078, 500);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), startRestartGroup, (i4 & 14) | 1572864 | (i4 & 112), 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$DeckOptionsMenu$2
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

                public final void invoke(Composer composer3, int i5) {
                    ReviewTabKt.DeckOptionsMenu(DeckNode.this, z, onDismiss, onStudy, onAddCard, onEditCards, onRename, onClearProgress, onDelete, onExport, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void RenameDialog(final String currentName, final Function1<? super String, Unit> onConfirm, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(currentName, "currentName");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(1587361355);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(currentName) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(onConfirm) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1587361355, i3, -1, "com.example.flashcardapp.ui.RenameDialog (ReviewTab.kt:194)");
            }
            startRestartGroup.startReplaceableGroup(-1381080240);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(currentName, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            AndroidAlertDialog_androidKt.m1232AlertDialogOix01E0(onDismiss, ComposableLambdaKt.composableLambda(startRestartGroup, -526708589, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$RenameDialog$1
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

                public final void invoke(Composer composer3, int i4) {
                    if ((i4 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-526708589, i4, -1, "com.example.flashcardapp.ui.RenameDialog.<anonymous> (ReviewTab.kt:210)");
                        }
                        composer3.startReplaceableGroup(-198123976);
                        boolean changedInstance = composer3.changedInstance(onConfirm);
                        final Function1<String, Unit> function1 = onConfirm;
                        final MutableState<String> mutableState2 = mutableState;
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$RenameDialog$1$1$1
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
                                    String RenameDialog$lambda$7;
                                    String RenameDialog$lambda$72;
                                    RenameDialog$lambda$7 = ReviewTabKt.RenameDialog$lambda$7(mutableState2);
                                    if (!StringsKt.isBlank(RenameDialog$lambda$7)) {
                                        Function1<String, Unit> function12 = function1;
                                        RenameDialog$lambda$72 = ReviewTabKt.RenameDialog$lambda$7(mutableState2);
                                        function12.invoke(StringsKt.trim((CharSequence) RenameDialog$lambda$72).toString());
                                    }
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        ButtonKt.Button((Function0) rememberedValue2, null, false, null, ButtonDefaults.INSTANCE.m1274buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, composer3, ButtonDefaults.$stable << 12, 14), null, null, null, null, ComposableSingletons$ReviewTabKt.INSTANCE.m6252getLambda15$app_release(), composer3, 805306368, 494);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), null, ComposableLambdaKt.composableLambda(startRestartGroup, 2046256021, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$RenameDialog$2
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
                    if ((i4 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2046256021, i4, -1, "com.example.flashcardapp.ui.RenameDialog.<anonymous> (ReviewTab.kt:216)");
                    }
                    ButtonKt.TextButton(onDismiss, null, false, null, null, null, null, null, null, ComposableSingletons$ReviewTabKt.INSTANCE.m6253getLambda16$app_release(), composer3, 805306368, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), null, ComposableSingletons$ReviewTabKt.INSTANCE.m6254getLambda17$app_release(), ComposableLambdaKt.composableLambda(startRestartGroup, 1610735640, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$RenameDialog$3
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
                    String RenameDialog$lambda$7;
                    if ((i4 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1610735640, i4, -1, "com.example.flashcardapp.ui.RenameDialog.<anonymous> (ReviewTab.kt:200)");
                        }
                        RenameDialog$lambda$7 = ReviewTabKt.RenameDialog$lambda$7(mutableState);
                        composer3.startReplaceableGroup(-198124381);
                        final MutableState<String> mutableState2 = mutableState;
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (Function1) new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$RenameDialog$3$1$1
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
                                public final void invoke2(String it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    mutableState2.setValue(it);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        OutlinedTextFieldKt.OutlinedTextField(RenameDialog$lambda$7, (Function1<? super String, Unit>) rememberedValue2, (Modifier) null, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ReviewTabKt.INSTANCE.m6255getLambda18$app_release(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, OutlinedTextFieldDefaults.INSTANCE.m1735colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer3, 0, 0, 0, 0, 3072, 2139092991, 4095), composer3, 1572912, 12582912, 0, 4063164);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, ((i3 >> 6) & 14) | 1772592, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$RenameDialog$4
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

                public final void invoke(Composer composer3, int i4) {
                    ReviewTabKt.RenameDialog(currentName, onConfirm, onDismiss, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String RenameDialog$lambda$7(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ConfirmDialog(final java.lang.String r30, final java.lang.String r31, final java.lang.String r32, boolean r33, final kotlin.jvm.functions.Function0<kotlin.Unit> r34, final kotlin.jvm.functions.Function0<kotlin.Unit> r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.ui.ReviewTabKt.ConfirmDialog(java.lang.String, java.lang.String, java.lang.String, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void CreateDeckDialog(final Function1<? super String, Unit> onConfirm, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(-1641022095);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(onConfirm) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1641022095, i3, -1, "com.example.flashcardapp.ui.CreateDeckDialog (ReviewTab.kt:244)");
            }
            startRestartGroup.startReplaceableGroup(210192480);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            AndroidAlertDialog_androidKt.m1232AlertDialogOix01E0(onDismiss, ComposableLambdaKt.composableLambda(startRestartGroup, -643725271, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$CreateDeckDialog$1
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

                public final void invoke(Composer composer3, int i4) {
                    if ((i4 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-643725271, i4, -1, "com.example.flashcardapp.ui.CreateDeckDialog.<anonymous> (ReviewTab.kt:262)");
                        }
                        composer3.startReplaceableGroup(-185686324);
                        boolean changedInstance = composer3.changedInstance(onConfirm);
                        final Function1<String, Unit> function1 = onConfirm;
                        final MutableState<String> mutableState2 = mutableState;
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$CreateDeckDialog$1$1$1
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
                                    String CreateDeckDialog$lambda$10;
                                    String CreateDeckDialog$lambda$102;
                                    CreateDeckDialog$lambda$10 = ReviewTabKt.CreateDeckDialog$lambda$10(mutableState2);
                                    if (!StringsKt.isBlank(CreateDeckDialog$lambda$10)) {
                                        Function1<String, Unit> function12 = function1;
                                        CreateDeckDialog$lambda$102 = ReviewTabKt.CreateDeckDialog$lambda$10(mutableState2);
                                        function12.invoke(StringsKt.trim((CharSequence) CreateDeckDialog$lambda$102).toString());
                                    }
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        ButtonKt.Button((Function0) rememberedValue2, null, false, null, ButtonDefaults.INSTANCE.m1274buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, composer3, ButtonDefaults.$stable << 12, 14), null, null, null, null, ComposableSingletons$ReviewTabKt.INSTANCE.m6258getLambda20$app_release(), composer3, 805306368, 494);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), null, ComposableLambdaKt.composableLambda(startRestartGroup, 1358160999, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$CreateDeckDialog$2
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
                    if ((i4 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1358160999, i4, -1, "com.example.flashcardapp.ui.CreateDeckDialog.<anonymous> (ReviewTab.kt:268)");
                    }
                    ButtonKt.TextButton(onDismiss, null, false, null, null, null, null, null, null, ComposableSingletons$ReviewTabKt.INSTANCE.m6259getLambda21$app_release(), composer3, 805306368, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), null, ComposableSingletons$ReviewTabKt.INSTANCE.m6260getLambda22$app_release(), ComposableLambdaKt.composableLambda(startRestartGroup, -2081460540, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$CreateDeckDialog$3
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
                    String CreateDeckDialog$lambda$10;
                    if ((i4 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2081460540, i4, -1, "com.example.flashcardapp.ui.CreateDeckDialog.<anonymous> (ReviewTab.kt:250)");
                        }
                        Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(8));
                        final MutableState<String> mutableState2 = mutableState;
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer3, 6);
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
                        TextKt.m2133Text4IGK_g("Use '::' to nest decks. Example: Physics::Mechanics", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBodySmall(), composer3, 6, 0, 65530);
                        CreateDeckDialog$lambda$10 = ReviewTabKt.CreateDeckDialog$lambda$10(mutableState2);
                        composer3.startReplaceableGroup(-1954146746);
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (Function1) new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$CreateDeckDialog$3$1$1$1
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
                                public final void invoke2(String it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    mutableState2.setValue(it);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        OutlinedTextFieldKt.OutlinedTextField(CreateDeckDialog$lambda$10, (Function1<? super String, Unit>) rememberedValue2, (Modifier) null, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ReviewTabKt.INSTANCE.m6261getLambda23$app_release(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, OutlinedTextFieldDefaults.INSTANCE.m1735colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer3, 0, 0, 0, 0, 3072, 2139092991, 4095), composer3, 1572912, 12582912, 0, 4063164);
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
            }), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, ((i3 >> 3) & 14) | 1772592, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$CreateDeckDialog$4
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

                public final void invoke(Composer composer3, int i4) {
                    ReviewTabKt.CreateDeckDialog(onConfirm, onDismiss, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CreateDeckDialog$lambda$10(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    public static final void DeckSettingsDialog(final AnkiDeck deck, final McqSessionMode mcqSessionMode, final Function1<? super McqSessionMode, Unit> onModeChanged, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(deck, "deck");
        Intrinsics.checkNotNullParameter(onModeChanged, "onModeChanged");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(2112373056);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(deck) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(mcqSessionMode) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(onModeChanged) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 2048 : 1024;
        }
        int i3 = i2;
        if ((i3 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2112373056, i3, -1, "com.example.flashcardapp.ui.DeckSettingsDialog (ReviewTab.kt:279)");
            }
            startRestartGroup.startReplaceableGroup(1224539075);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(mcqSessionMode, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            AndroidAlertDialog_androidKt.m1232AlertDialogOix01E0(onDismiss, ComposableLambdaKt.composableLambda(startRestartGroup, 1130714616, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$DeckSettingsDialog$1
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

                public final void invoke(Composer composer3, int i4) {
                    if ((i4 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1130714616, i4, -1, "com.example.flashcardapp.ui.DeckSettingsDialog.<anonymous> (ReviewTab.kt:316)");
                        }
                        composer3.startReplaceableGroup(1899425673);
                        boolean changedInstance = composer3.changedInstance(onModeChanged) | composer3.changedInstance(onDismiss);
                        final Function1<McqSessionMode, Unit> function1 = onModeChanged;
                        final Function0<Unit> function0 = onDismiss;
                        final MutableState<McqSessionMode> mutableState2 = mutableState;
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$DeckSettingsDialog$1$1$1
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
                                    McqSessionMode DeckSettingsDialog$lambda$13;
                                    Function1<McqSessionMode, Unit> function12 = function1;
                                    DeckSettingsDialog$lambda$13 = ReviewTabKt.DeckSettingsDialog$lambda$13(mutableState2);
                                    function12.invoke(DeckSettingsDialog$lambda$13);
                                    function0.invoke();
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        ButtonKt.Button((Function0) rememberedValue2, null, false, null, ButtonDefaults.INSTANCE.m1274buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, composer3, ButtonDefaults.$stable << 12, 14), null, null, null, null, ComposableSingletons$ReviewTabKt.INSTANCE.m6262getLambda24$app_release(), composer3, 805306368, 494);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), null, ComposableLambdaKt.composableLambda(startRestartGroup, 1541324982, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$DeckSettingsDialog$2
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
                    if ((i4 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1541324982, i4, -1, "com.example.flashcardapp.ui.DeckSettingsDialog.<anonymous> (ReviewTab.kt:325)");
                    }
                    ButtonKt.TextButton(onDismiss, null, false, null, null, null, null, null, null, ComposableSingletons$ReviewTabKt.INSTANCE.m6263getLambda25$app_release(), composer3, 805306368, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), null, ComposableLambdaKt.composableLambda(startRestartGroup, 1951935348, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$DeckSettingsDialog$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    if ((i4 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1951935348, i4, -1, "com.example.flashcardapp.ui.DeckSettingsDialog.<anonymous> (ReviewTab.kt:284)");
                    }
                    TextKt.m2133Text4IGK_g("Deck Settings: " + AnkiDeck.this.getName(), (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getTitleLarge(), composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65502);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), ComposableLambdaKt.composableLambda(startRestartGroup, 9756883, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$DeckSettingsDialog$4
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

                /* JADX WARN: Multi-variable type inference failed */
                public final void invoke(Composer composer3, int i4) {
                    final MutableState<McqSessionMode> mutableState2;
                    McqSessionMode DeckSettingsDialog$lambda$13;
                    if ((i4 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(9756883, i4, -1, "com.example.flashcardapp.ui.DeckSettingsDialog.<anonymous> (ReviewTab.kt:286)");
                        }
                        Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(16));
                        MutableState<McqSessionMode> mutableState3 = mutableState;
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer3, 6);
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
                        String str = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
                        MutableState<McqSessionMode> mutableState4 = mutableState3;
                        TextKt.m2133Text4IGK_g("Select Default Study Mode for this deck:", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 6, 0, 131066);
                        Object obj = null;
                        int i5 = 0;
                        int i6 = 1;
                        List<Pair> listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(null, "Global Default"), TuplesKt.to(McqSessionMode.PRACTICE, "Practice Mode"), TuplesKt.to(McqSessionMode.REVISION, "Revision Mode"), TuplesKt.to(McqSessionMode.TEST, "Test Mode")});
                        Composer composer4 = composer3;
                        composer4.startReplaceableGroup(1899424746);
                        for (Pair pair : listOf) {
                            final McqSessionMode mcqSessionMode2 = (McqSessionMode) pair.component1();
                            String str2 = (String) pair.component2();
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, i6, obj);
                            composer4.startReplaceableGroup(647367335);
                            boolean changed = composer4.changed(mcqSessionMode2);
                            Object rememberedValue2 = composer3.rememberedValue();
                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                mutableState2 = mutableState4;
                                rememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$DeckSettingsDialog$4$1$1$1$1
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
                                        mutableState2.setValue(McqSessionMode.this);
                                    }
                                };
                                composer4.updateRememberedValue(rememberedValue2);
                            } else {
                                mutableState2 = mutableState4;
                            }
                            composer3.endReplaceableGroup();
                            float f = 8;
                            Modifier m571paddingVpY3zN4$default = PaddingKt.m571paddingVpY3zN4$default(ClickableKt.m251clickableXHw0xAI$default(fillMaxWidth$default, false, null, null, (Function0) rememberedValue2, 7, null), 0.0f, Dp.m5738constructorimpl(f), i6, obj);
                            composer4.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer4, 48);
                            composer4.startReplaceableGroup(-1323940314);
                            String str3 = str;
                            ComposerKt.sourceInformation(composer4, str3);
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, i5);
                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m571paddingVpY3zN4$default);
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer4.createNode(constructor2);
                            } else {
                                composer3.useNode();
                            }
                            Composer m2947constructorimpl2 = Updater.m2947constructorimpl(composer3);
                            Updater.m2954setimpl(m2947constructorimpl2, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m2954setimpl(m2947constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m2947constructorimpl2.getInserting() || !Intrinsics.areEqual(m2947constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m2947constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m2947constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            modifierMaterializerOf2.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer4, Integer.valueOf(i5));
                            composer4.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            DeckSettingsDialog$lambda$13 = ReviewTabKt.DeckSettingsDialog$lambda$13(mutableState2);
                            int i7 = DeckSettingsDialog$lambda$13 == mcqSessionMode2 ? i6 : i5;
                            composer4.startReplaceableGroup(1304411192);
                            boolean changed2 = composer4.changed(mcqSessionMode2);
                            Object rememberedValue3 = composer3.rememberedValue();
                            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$DeckSettingsDialog$4$1$1$2$1$1
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
                                        mutableState2.setValue(McqSessionMode.this);
                                    }
                                };
                                composer4.updateRememberedValue(rememberedValue3);
                            }
                            composer3.endReplaceableGroup();
                            str = str3;
                            mutableState4 = mutableState2;
                            RadioButtonKt.RadioButton(i7, (Function0) rememberedValue3, null, false, RadioButtonDefaults.INSTANCE.m1779colorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, composer3, RadioButtonDefaults.$stable << 12, 14), null, composer3, 0, 44);
                            SpacerKt.Spacer(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f)), composer4, 6);
                            TextKt.m2133Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodyLarge(), composer3, 0, 0, 65534);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer4 = composer3;
                            i6 = i6;
                            i5 = i5;
                            obj = obj;
                        }
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
            }), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, ((i3 >> 9) & 14) | 1772592, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$DeckSettingsDialog$5
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

                public final void invoke(Composer composer3, int i4) {
                    ReviewTabKt.DeckSettingsDialog(AnkiDeck.this, mcqSessionMode, onModeChanged, onDismiss, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final McqSessionMode DeckSettingsDialog$lambda$13(MutableState<McqSessionMode> mutableState) {
        return mutableState.getValue();
    }

    public static final void MergeCsvDialog(final List<AnkiDeck> decks, final Function0<Unit> onNewDeck, final Function2<? super Long, ? super String, Unit> onMergeIntoDeck, final Function0<Unit> onDismiss, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(decks, "decks");
        Intrinsics.checkNotNullParameter(onNewDeck, "onNewDeck");
        Intrinsics.checkNotNullParameter(onMergeIntoDeck, "onMergeIntoDeck");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(-1212349151);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1212349151, i, -1, "com.example.flashcardapp.ui.MergeCsvDialog (ReviewTab.kt:347)");
        }
        startRestartGroup.startReplaceableGroup(-2076351733);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-2076351608);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        final MutableState mutableState2 = (MutableState) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        AndroidAlertDialog_androidKt.m1232AlertDialogOix01E0(onDismiss, ComposableLambdaKt.composableLambda(startRestartGroup, 1107600745, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$MergeCsvDialog$1
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

            /* JADX WARN: Removed duplicated region for block: B:22:0x00c8  */
            /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void invoke(androidx.compose.runtime.Composer r20, int r21) {
                /*
                    r19 = this;
                    r0 = r19
                    r13 = r20
                    r1 = r21
                    r2 = r1 & 11
                    r3 = 2
                    if (r2 != r3) goto L17
                    boolean r2 = r20.getSkipping()
                    if (r2 != 0) goto L12
                    goto L17
                L12:
                    r20.skipToGroupEnd()
                    goto Lcb
                L17:
                    boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                    if (r2 == 0) goto L26
                    r2 = -1
                    java.lang.String r3 = "com.example.flashcardapp.ui.MergeCsvDialog.<anonymous> (ReviewTab.kt:500)"
                    r4 = 1107600745(0x4204a569, float:33.161533)
                    androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
                L26:
                    r1 = 96953759(0x5c7659f, float:1.87512E-35)
                    r13.startReplaceableGroup(r1)
                    kotlin.jvm.functions.Function2<java.lang.Long, java.lang.String, kotlin.Unit> r1 = r1
                    boolean r1 = r13.changedInstance(r1)
                    kotlin.jvm.functions.Function0<kotlin.Unit> r2 = r2
                    boolean r2 = r13.changedInstance(r2)
                    r1 = r1 | r2
                    kotlin.jvm.functions.Function2<java.lang.Long, java.lang.String, kotlin.Unit> r2 = r1
                    kotlin.jvm.functions.Function0<kotlin.Unit> r3 = r2
                    androidx.compose.runtime.MutableState<java.lang.Boolean> r4 = r3
                    androidx.compose.runtime.MutableState<com.example.flashcardapp.data.AnkiDeck> r5 = r4
                    java.lang.Object r6 = r20.rememberedValue()
                    if (r1 != 0) goto L4f
                    androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.INSTANCE
                    java.lang.Object r1 = r1.getEmpty()
                    if (r6 != r1) goto L5a
                L4f:
                    com.example.flashcardapp.ui.ReviewTabKt$MergeCsvDialog$1$1$1 r1 = new com.example.flashcardapp.ui.ReviewTabKt$MergeCsvDialog$1$1$1
                    r1.<init>()
                    r6 = r1
                    kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
                    r13.updateRememberedValue(r6)
                L5a:
                    r14 = r6
                    kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
                    r20.endReplaceableGroup()
                    androidx.compose.runtime.MutableState<java.lang.Boolean> r1 = r3
                    boolean r1 = com.example.flashcardapp.ui.ReviewTabKt.access$MergeCsvDialog$lambda$19(r1)
                    r12 = 1
                    if (r1 == 0) goto L76
                    androidx.compose.runtime.MutableState<com.example.flashcardapp.data.AnkiDeck> r1 = r4
                    com.example.flashcardapp.data.AnkiDeck r1 = com.example.flashcardapp.ui.ReviewTabKt.access$MergeCsvDialog$lambda$16(r1)
                    if (r1 == 0) goto L72
                    goto L76
                L72:
                    r1 = 0
                    r16 = r1
                    goto L78
                L76:
                    r16 = r12
                L78:
                    r17 = 0
                    androidx.compose.material3.ButtonDefaults r1 = androidx.compose.material3.ButtonDefaults.INSTANCE
                    androidx.compose.material3.MaterialTheme r2 = androidx.compose.material3.MaterialTheme.INSTANCE
                    int r3 = androidx.compose.material3.MaterialTheme.$stable
                    androidx.compose.material3.ColorScheme r2 = r2.getColorScheme(r13, r3)
                    long r2 = r2.getPrimary()
                    r4 = 0
                    r6 = 0
                    r8 = 0
                    int r10 = androidx.compose.material3.ButtonDefaults.$stable
                    int r11 = r10 << 12
                    r18 = 14
                    r10 = r20
                    r15 = r12
                    r12 = r18
                    androidx.compose.material3.ButtonColors r5 = r1.m1274buttonColorsro_MJ88(r2, r4, r6, r8, r10, r11, r12)
                    r6 = 0
                    r7 = 0
                    r8 = 0
                    r9 = 0
                    com.example.flashcardapp.ui.ReviewTabKt$MergeCsvDialog$1$2 r1 = new com.example.flashcardapp.ui.ReviewTabKt$MergeCsvDialog$1$2
                    androidx.compose.runtime.MutableState<java.lang.Boolean> r2 = r3
                    r1.<init>()
                    r2 = -820400807(0xffffffffcf19ad59, float:-2.57827456E9)
                    androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r2, r15, r1)
                    r10 = r1
                    kotlin.jvm.functions.Function3 r10 = (kotlin.jvm.functions.Function3) r10
                    r12 = 805306368(0x30000000, float:4.656613E-10)
                    r15 = 490(0x1ea, float:6.87E-43)
                    r1 = r14
                    r2 = 0
                    r3 = r16
                    r4 = r17
                    r11 = r20
                    r13 = r15
                    androidx.compose.material3.ButtonKt.Button(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                    boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                    if (r1 == 0) goto Lcb
                    androidx.compose.runtime.ComposerKt.traceEventEnd()
                Lcb:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.ui.ReviewTabKt$MergeCsvDialog$1.invoke(androidx.compose.runtime.Composer, int):void");
            }
        }), null, ComposableLambdaKt.composableLambda(startRestartGroup, 673095147, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$MergeCsvDialog$2
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
                        ComposerKt.traceEventStart(673095147, i2, -1, "com.example.flashcardapp.ui.MergeCsvDialog.<anonymous> (ReviewTab.kt:519)");
                    }
                    ButtonKt.TextButton(onDismiss, null, false, null, null, null, null, null, null, ComposableSingletons$ReviewTabKt.INSTANCE.m6264getLambda26$app_release(), composer2, 805306368, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), null, ComposableSingletons$ReviewTabKt.INSTANCE.m6265getLambda27$app_release(), ComposableLambdaKt.composableLambda(startRestartGroup, -2126146898, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$MergeCsvDialog$3
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
                final MutableState<Boolean> mutableState3;
                final MutableState<AnkiDeck> mutableState4;
                boolean MergeCsvDialog$lambda$19;
                long surface;
                boolean MergeCsvDialog$lambda$192;
                int i3;
                float f;
                boolean MergeCsvDialog$lambda$193;
                long outlineVariant;
                boolean MergeCsvDialog$lambda$194;
                long surface2;
                boolean MergeCsvDialog$lambda$195;
                boolean MergeCsvDialog$lambda$196;
                long outlineVariant2;
                if ((i2 & 11) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2126146898, i2, -1, "com.example.flashcardapp.ui.MergeCsvDialog.<anonymous> (ReviewTab.kt:362)");
                    }
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(12));
                    final List<AnkiDeck> list = decks;
                    MutableState<Boolean> mutableState5 = mutableState2;
                    MutableState<AnkiDeck> mutableState6 = mutableState;
                    composer2.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer2, 6);
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
                    TextKt.m2133Text4IGK_g("Choose how to import the selected CSV file:", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 6, 0, 65530);
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    composer2.startReplaceableGroup(-429588918);
                    Object rememberedValue3 = composer2.rememberedValue();
                    if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        mutableState3 = mutableState5;
                        mutableState4 = mutableState6;
                        rememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$MergeCsvDialog$3$1$1$1
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
                                ReviewTabKt.MergeCsvDialog$lambda$20(mutableState3, false);
                                mutableState4.setValue(null);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue3);
                    } else {
                        mutableState3 = mutableState5;
                        mutableState4 = mutableState6;
                    }
                    composer2.endReplaceableGroup();
                    Modifier m251clickableXHw0xAI$default = ClickableKt.m251clickableXHw0xAI$default(fillMaxWidth$default, false, null, null, (Function0) rememberedValue3, 7, null);
                    CardDefaults cardDefaults = CardDefaults.INSTANCE;
                    MergeCsvDialog$lambda$19 = ReviewTabKt.MergeCsvDialog$lambda$19(mutableState3);
                    if (!MergeCsvDialog$lambda$19) {
                        composer2.startReplaceableGroup(-429588709);
                        surface = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimaryContainer();
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(-429588609);
                        surface = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getSurface();
                        composer2.endReplaceableGroup();
                    }
                    final MutableState<AnkiDeck> mutableState7 = mutableState4;
                    final MutableState<Boolean> mutableState8 = mutableState3;
                    CardColors m1295cardColorsro_MJ88 = cardDefaults.m1295cardColorsro_MJ88(surface, 0L, 0L, 0L, composer2, CardDefaults.$stable << 12, 14);
                    MergeCsvDialog$lambda$192 = ReviewTabKt.MergeCsvDialog$lambda$19(mutableState8);
                    if (MergeCsvDialog$lambda$192) {
                        i3 = 2;
                        f = 1;
                    } else {
                        i3 = 2;
                        f = 2;
                    }
                    float m5738constructorimpl = Dp.m5738constructorimpl(f);
                    MergeCsvDialog$lambda$193 = ReviewTabKt.MergeCsvDialog$lambda$19(mutableState8);
                    if (MergeCsvDialog$lambda$193) {
                        composer2.startReplaceableGroup(-429588350);
                        outlineVariant = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOutlineVariant();
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(-429588413);
                        outlineVariant = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary();
                        composer2.endReplaceableGroup();
                    }
                    CardKt.Card(m251clickableXHw0xAI$default, MaterialTheme.INSTANCE.getShapes(composer2, MaterialTheme.$stable).getMedium(), m1295cardColorsro_MJ88, null, BorderStrokeKt.m244BorderStrokecXLIe8U(m5738constructorimpl, outlineVariant), ComposableLambdaKt.composableLambda(composer2, -979125610, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$MergeCsvDialog$3$1$2
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

                        public final void invoke(ColumnScope Card, Composer composer3, int i4) {
                            boolean MergeCsvDialog$lambda$197;
                            Intrinsics.checkNotNullParameter(Card, "$this$Card");
                            if ((i4 & 81) != 16 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-979125610, i4, -1, "com.example.flashcardapp.ui.MergeCsvDialog.<anonymous>.<anonymous>.<anonymous> (ReviewTab.kt:387)");
                                }
                                Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(12));
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Arrangement.HorizontalOrVertical m478spacedBy0680j_42 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(10));
                                final MutableState<Boolean> mutableState9 = mutableState8;
                                final MutableState<AnkiDeck> mutableState10 = mutableState7;
                                composer3.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m478spacedBy0680j_42, centerVertically, composer3, 54);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor2);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m2947constructorimpl2 = Updater.m2947constructorimpl(composer3);
                                Updater.m2954setimpl(m2947constructorimpl2, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m2954setimpl(m2947constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m2947constructorimpl2.getInserting() || !Intrinsics.areEqual(m2947constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m2947constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m2947constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                modifierMaterializerOf2.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                MergeCsvDialog$lambda$197 = ReviewTabKt.MergeCsvDialog$lambda$19(mutableState9);
                                boolean z = !MergeCsvDialog$lambda$197;
                                composer3.startReplaceableGroup(2101670709);
                                Object rememberedValue4 = composer3.rememberedValue();
                                if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue4 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$MergeCsvDialog$3$1$2$1$1$1
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
                                            ReviewTabKt.MergeCsvDialog$lambda$20(mutableState9, false);
                                            mutableState10.setValue(null);
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue4);
                                }
                                composer3.endReplaceableGroup();
                                RadioButtonKt.RadioButton(z, (Function0) rememberedValue4, null, false, RadioButtonDefaults.INSTANCE.m1779colorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, composer3, RadioButtonDefaults.$stable << 12, 14), null, composer3, 48, 44);
                                composer3.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(companion2);
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor3);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m2947constructorimpl3 = Updater.m2947constructorimpl(composer3);
                                Updater.m2954setimpl(m2947constructorimpl3, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                    m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                }
                                modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                TextKt.m2133Text4IGK_g("Create New Deck", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBodyLarge(), composer3, 196614, 0, 65502);
                                TextKt.m2133Text4IGK_g("Deck name is taken from the filename", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBodySmall(), composer3, 6, 0, 65530);
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
                    }), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 8);
                    composer2.startReplaceableGroup(96947835);
                    if (!list.isEmpty()) {
                        Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        composer2.startReplaceableGroup(-429586993);
                        Object rememberedValue4 = composer2.rememberedValue();
                        if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue4 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$MergeCsvDialog$3$1$3$1
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
                                    ReviewTabKt.MergeCsvDialog$lambda$20(mutableState8, true);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue4);
                        }
                        composer2.endReplaceableGroup();
                        Modifier m251clickableXHw0xAI$default2 = ClickableKt.m251clickableXHw0xAI$default(fillMaxWidth$default2, false, null, null, (Function0) rememberedValue4, 7, null);
                        CardDefaults cardDefaults2 = CardDefaults.INSTANCE;
                        MergeCsvDialog$lambda$194 = ReviewTabKt.MergeCsvDialog$lambda$19(mutableState8);
                        if (MergeCsvDialog$lambda$194) {
                            composer2.startReplaceableGroup(-429586795);
                            surface2 = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimaryContainer();
                            composer2.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(-429586687);
                            surface2 = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getSurface();
                            composer2.endReplaceableGroup();
                        }
                        int i4 = i3;
                        CardColors m1295cardColorsro_MJ882 = cardDefaults2.m1295cardColorsro_MJ88(surface2, 0L, 0L, 0L, composer2, CardDefaults.$stable << 12, 14);
                        MergeCsvDialog$lambda$195 = ReviewTabKt.MergeCsvDialog$lambda$19(mutableState8);
                        float m5738constructorimpl2 = MergeCsvDialog$lambda$195 ? Dp.m5738constructorimpl(i4) : Dp.m5738constructorimpl(1);
                        MergeCsvDialog$lambda$196 = ReviewTabKt.MergeCsvDialog$lambda$19(mutableState8);
                        if (MergeCsvDialog$lambda$196) {
                            composer2.startReplaceableGroup(-429586477);
                            outlineVariant2 = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary();
                            composer2.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(-429586410);
                            outlineVariant2 = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOutlineVariant();
                            composer2.endReplaceableGroup();
                        }
                        CardKt.Card(m251clickableXHw0xAI$default2, MaterialTheme.INSTANCE.getShapes(composer2, MaterialTheme.$stable).getMedium(), m1295cardColorsro_MJ882, null, BorderStrokeKt.m244BorderStrokecXLIe8U(m5738constructorimpl2, outlineVariant2), ComposableLambdaKt.composableLambda(composer2, -1324254351, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$MergeCsvDialog$3$1$4
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

                            public final void invoke(ColumnScope Card, Composer composer3, int i5) {
                                boolean MergeCsvDialog$lambda$197;
                                boolean MergeCsvDialog$lambda$198;
                                AnkiDeck MergeCsvDialog$lambda$16;
                                long m3452getTransparent0d7_KjU;
                                final MutableState<AnkiDeck> mutableState9;
                                long onSurfaceVariant;
                                long onSurface;
                                Intrinsics.checkNotNullParameter(Card, "$this$Card");
                                if ((i5 & 81) != 16 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1324254351, i5, -1, "com.example.flashcardapp.ui.MergeCsvDialog.<anonymous>.<anonymous>.<anonymous> (ReviewTab.kt:423)");
                                    }
                                    Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(12));
                                    float f2 = 8;
                                    Arrangement.HorizontalOrVertical m478spacedBy0680j_42 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f2));
                                    final MutableState<Boolean> mutableState10 = mutableState8;
                                    List<AnkiDeck> list2 = list;
                                    MutableState<AnkiDeck> mutableState11 = mutableState7;
                                    composer3.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_42, Alignment.INSTANCE.getStart(), composer3, 6);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor2);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m2947constructorimpl2 = Updater.m2947constructorimpl(composer3);
                                    Updater.m2954setimpl(m2947constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m2954setimpl(m2947constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m2947constructorimpl2.getInserting() || !Intrinsics.areEqual(m2947constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m2947constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m2947constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    modifierMaterializerOf2.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Arrangement.HorizontalOrVertical m478spacedBy0680j_43 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(10));
                                    composer3.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m478spacedBy0680j_43, centerVertically, composer3, 54);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(companion2);
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor3);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m2947constructorimpl3 = Updater.m2947constructorimpl(composer3);
                                    Updater.m2954setimpl(m2947constructorimpl3, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                        m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                        m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                    }
                                    modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    MergeCsvDialog$lambda$197 = ReviewTabKt.MergeCsvDialog$lambda$19(mutableState10);
                                    composer3.startReplaceableGroup(-1068780102);
                                    Object rememberedValue5 = composer3.rememberedValue();
                                    if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue5 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$MergeCsvDialog$3$1$4$1$1$1$1
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
                                                ReviewTabKt.MergeCsvDialog$lambda$20(mutableState10, true);
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue5);
                                    }
                                    composer3.endReplaceableGroup();
                                    MutableState<AnkiDeck> mutableState12 = mutableState11;
                                    String str = "C92@4661L9:Row.kt#2w3rfo";
                                    RadioButtonKt.RadioButton(MergeCsvDialog$lambda$197, (Function0) rememberedValue5, null, false, RadioButtonDefaults.INSTANCE.m1779colorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, composer3, RadioButtonDefaults.$stable << 12, 14), null, composer3, 48, 44);
                                    composer3.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                    MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(companion3);
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor4);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m2947constructorimpl4 = Updater.m2947constructorimpl(composer3);
                                    Updater.m2954setimpl(m2947constructorimpl4, columnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                        m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                        m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                    }
                                    modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                                    TextKt.m2133Text4IGK_g("Merge into Existing Deck", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBodyLarge(), composer3, 196614, 0, 65502);
                                    TextKt.m2133Text4IGK_g("Append cards to a deck you already have", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBodySmall(), composer3, 6, 0, 65530);
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
                                    composer3.startReplaceableGroup(-360129928);
                                    MergeCsvDialog$lambda$198 = ReviewTabKt.MergeCsvDialog$lambda$19(mutableState10);
                                    if (MergeCsvDialog$lambda$198) {
                                        Modifier m573paddingqDBjuR0$default = PaddingKt.m573paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(44), 0.0f, 0.0f, 0.0f, 14, null);
                                        Arrangement.HorizontalOrVertical m478spacedBy0680j_44 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(4));
                                        composer3.startReplaceableGroup(-483455358);
                                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                        MeasurePolicy columnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_44, Alignment.INSTANCE.getStart(), composer3, 6);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap5 = composer3.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(m573paddingqDBjuR0$default);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor5);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer m2947constructorimpl5 = Updater.m2947constructorimpl(composer3);
                                        Updater.m2954setimpl(m2947constructorimpl5, columnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m2954setimpl(m2947constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m2947constructorimpl5.getInserting() || !Intrinsics.areEqual(m2947constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                                            m2947constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                                            m2947constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                                        }
                                        modifierMaterializerOf5.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                        ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                                        String str2 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
                                        TextKt.m2133Text4IGK_g("Select target deck:", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getLabelMedium(), composer3, 6, 0, 65530);
                                        Composer composer4 = composer3;
                                        composer4.startReplaceableGroup(-1068778672);
                                        for (final AnkiDeck ankiDeck : CollectionsKt.take(list2, 8)) {
                                            MergeCsvDialog$lambda$16 = ReviewTabKt.MergeCsvDialog$lambda$16(mutableState12);
                                            boolean z = MergeCsvDialog$lambda$16 != null && MergeCsvDialog$lambda$16.getId() == ankiDeck.getId();
                                            Modifier clip = ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getShapes(composer4, MaterialTheme.$stable).getSmall());
                                            composer4.startReplaceableGroup(-1068778201);
                                            if (z) {
                                                m3452getTransparent0d7_KjU = Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getPrimary(), 0.15f, 0.0f, 0.0f, 0.0f, 14, null);
                                            } else {
                                                m3452getTransparent0d7_KjU = Color.INSTANCE.m3452getTransparent0d7_KjU();
                                            }
                                            composer3.endReplaceableGroup();
                                            Modifier m216backgroundbw27NRU$default = BackgroundKt.m216backgroundbw27NRU$default(clip, m3452getTransparent0d7_KjU, null, 2, null);
                                            composer4.startReplaceableGroup(-1678815546);
                                            boolean changed = composer4.changed(ankiDeck);
                                            Object rememberedValue6 = composer3.rememberedValue();
                                            if (changed || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                mutableState9 = mutableState12;
                                                rememberedValue6 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$MergeCsvDialog$3$1$4$1$2$1$1$1
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
                                                        mutableState9.setValue(AnkiDeck.this);
                                                    }
                                                };
                                                composer4.updateRememberedValue(rememberedValue6);
                                            } else {
                                                mutableState9 = mutableState12;
                                            }
                                            composer3.endReplaceableGroup();
                                            Modifier m570paddingVpY3zN4 = PaddingKt.m570paddingVpY3zN4(ClickableKt.m251clickableXHw0xAI$default(m216backgroundbw27NRU$default, false, null, null, (Function0) rememberedValue6, 7, null), Dp.m5738constructorimpl(f2), Dp.m5738constructorimpl(6));
                                            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                            Arrangement.HorizontalOrVertical m478spacedBy0680j_45 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f2));
                                            composer4.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m478spacedBy0680j_45, centerVertically2, composer4, 54);
                                            composer4.startReplaceableGroup(-1323940314);
                                            String str3 = str2;
                                            ComposerKt.sourceInformation(composer4, str3);
                                            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap6 = composer3.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(m570paddingVpY3zN4);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer4.createNode(constructor6);
                                            } else {
                                                composer3.useNode();
                                            }
                                            Composer m2947constructorimpl6 = Updater.m2947constructorimpl(composer3);
                                            Updater.m2954setimpl(m2947constructorimpl6, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m2954setimpl(m2947constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m2947constructorimpl6.getInserting() || !Intrinsics.areEqual(m2947constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                                                m2947constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                                                m2947constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
                                            }
                                            modifierMaterializerOf6.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer4, 0);
                                            composer4.startReplaceableGroup(2058660585);
                                            String str4 = str;
                                            ComposerKt.sourceInformationMarkerStart(composer4, -326681643, str4);
                                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                            ImageVector check = z ? CheckKt.getCheck(Icons.INSTANCE.getDefault()) : ListKt.getList(Icons.AutoMirrored.Filled.INSTANCE);
                                            if (z) {
                                                composer4.startReplaceableGroup(-819857239);
                                                onSurfaceVariant = MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getPrimary();
                                            } else {
                                                composer4.startReplaceableGroup(-819857200);
                                                onSurfaceVariant = MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getOnSurfaceVariant();
                                            }
                                            composer3.endReplaceableGroup();
                                            MutableState<AnkiDeck> mutableState13 = mutableState9;
                                            IconKt.m1605Iconww6aTOc(check, (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(16)), onSurfaceVariant, composer3, 432, 0);
                                            String str5 = (String) CollectionsKt.last(StringsKt.split$default((CharSequence) ankiDeck.getName(), new String[]{"::"}, false, 0, 6, (Object) null));
                                            TextStyle bodyMedium = MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodyMedium();
                                            if (z) {
                                                composer4.startReplaceableGroup(-819856730);
                                                onSurface = MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getPrimary();
                                            } else {
                                                composer4.startReplaceableGroup(-819856691);
                                                onSurface = MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getOnSurface();
                                            }
                                            composer3.endReplaceableGroup();
                                            long j = onSurface;
                                            FontWeight.Companion companion4 = FontWeight.INSTANCE;
                                            TextKt.m2133Text4IGK_g(str5, (Modifier) null, j, 0L, (FontStyle) null, z ? companion4.getSemiBold() : companion4.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, bodyMedium, composer3, 0, 0, 65498);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer4 = composer3;
                                            str2 = str3;
                                            str = str4;
                                            mutableState12 = mutableState13;
                                        }
                                        composer3.endReplaceableGroup();
                                        composer3.startReplaceableGroup(2101676559);
                                        if (list2.size() > 8) {
                                            TextKt.m2133Text4IGK_g("+ " + (list2.size() - 8) + " more decks (search to filter)", PaddingKt.m573paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m5738constructorimpl(24), Dp.m5738constructorimpl(2), 0.0f, 0.0f, 12, null), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBodySmall(), composer3, 48, 0, 65528);
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
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 8);
                    }
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
        }), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getLarge(), 0L, 0L, 0L, 0L, 0.0f, null, startRestartGroup, ((i >> 9) & 14) | 1772592, 0, 16148);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$MergeCsvDialog$4
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
                    ReviewTabKt.MergeCsvDialog(decks, onNewDeck, onMergeIntoDeck, onDismiss, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnkiDeck MergeCsvDialog$lambda$16(MutableState<AnkiDeck> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MergeCsvDialog$lambda$19(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MergeCsvDialog$lambda$20(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Code restructure failed: missing block: B:132:0x0650, code lost:
    
        if (r6.changedInstance(r1) == false) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0d33, code lost:
    
        if (r6.changedInstance(r0) == false) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0d54, code lost:
    
        if (r6.changed(r10) == false) goto L295;
     */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0d4e  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0d67  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0dcd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0ee7  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0f45  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x15cc  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x15d8  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x1601  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x1674  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x16b6  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x1713  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x171c  */
    /* JADX WARN: Removed duplicated region for block: B:304:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:305:0x1681  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x15dc  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x1492  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0d5f  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0d57  */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v40, types: [androidx.compose.runtime.SnapshotMutationPolicy, kotlin.coroutines.Continuation, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v75 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ReviewTab(final boolean r137, final boolean r138, final java.util.List<com.example.flashcardapp.data.AnkiDeck> r139, java.util.List<com.example.flashcardapp.data.entities.CardAttemptEntity> r140, final com.example.flashcardapp.session.McqSessionMode r141, boolean r142, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r143, final kotlin.jvm.functions.Function0<kotlin.Unit> r144, final kotlin.jvm.functions.Function0<kotlin.Unit> r145, final kotlin.jvm.functions.Function0<kotlin.Unit> r146, final kotlin.jvm.functions.Function0<kotlin.Unit> r147, kotlin.jvm.functions.Function0<kotlin.Unit> r148, kotlin.jvm.functions.Function2<? super java.lang.Long, ? super java.lang.String, kotlin.Unit> r149, final kotlin.jvm.functions.Function1<? super com.example.flashcardapp.data.AnkiDeck, kotlin.Unit> r150, kotlin.jvm.functions.Function1<? super com.example.flashcardapp.data.AnkiDeck, kotlin.Unit> r151, kotlin.jvm.functions.Function2<? super com.example.flashcardapp.data.AnkiDeck, ? super java.lang.String, kotlin.Unit> r152, kotlin.jvm.functions.Function1<? super com.example.flashcardapp.data.AnkiDeck, kotlin.Unit> r153, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r154, kotlin.jvm.functions.Function8<? super com.example.flashcardapp.data.AnkiDeck, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, kotlin.Unit> r155, kotlin.jvm.functions.Function1<? super com.example.flashcardapp.data.AnkiDeck, kotlin.Unit> r156, final kotlin.jvm.functions.Function0<kotlin.Unit> r157, kotlin.jvm.functions.Function0<kotlin.Unit> r158, androidx.compose.runtime.Composer r159, final int r160, final int r161, final int r162, final int r163) {
        /*
            Method dump skipped, instructions count: 5987
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.ui.ReviewTabKt.ReviewTab(boolean, boolean, java.util.List, java.util.List, com.example.flashcardapp.session.McqSessionMode, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function8, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ReviewTab$lambda$23(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ReviewTab$lambda$26(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ReviewTab$lambda$27(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ReviewTab$lambda$29(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ReviewTab$lambda$30(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ReviewTab$lambda$32(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ReviewTab$lambda$33(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final boolean ReviewTab$lambda$37(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ReviewTab$lambda$38(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set<String> ReviewTab$lambda$42(MutableState<Set<String>> mutableState) {
        return mutableState.getValue();
    }

    private static final DeckNode ReviewTab$lambda$45(MutableState<DeckNode> mutableState) {
        return mutableState.getValue();
    }

    private static final DeckNode ReviewTab$lambda$48(MutableState<DeckNode> mutableState) {
        return mutableState.getValue();
    }

    private static final DeckNode ReviewTab$lambda$51(MutableState<DeckNode> mutableState) {
        return mutableState.getValue();
    }

    private static final DeckNode ReviewTab$lambda$54(MutableState<DeckNode> mutableState) {
        return mutableState.getValue();
    }

    private static final DeckNode ReviewTab$lambda$57(MutableState<DeckNode> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ReviewTab$lambda$60(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ReviewTab$lambda$61(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<Long, McqSessionMode> ReviewTab$lambda$65(MutableState<Map<Long, McqSessionMode>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long ReviewTab$lambda$68(MutableState<Long> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ReviewTab$lambda$71(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ReviewTab$lambda$74(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x006b, code lost:
    
        if (r3 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void CalendarDialog(final java.util.List<com.example.flashcardapp.data.entities.SessionRecordEntity> r24, final kotlin.jvm.functions.Function0<kotlin.Unit> r25, androidx.compose.runtime.Composer r26, final int r27) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.ui.ReviewTabKt.CalendarDialog(java.util.List, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Calendar CalendarDialog$lambda$107(MutableState<Calendar> mutableState) {
        return mutableState.getValue();
    }

    public static final void QuizzesRunDialog(final List<SessionRecordEntity> sessionRecords, final Function0<Unit> onDismissRequest, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(sessionRecords, "sessionRecords");
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer startRestartGroup = composer.startRestartGroup(1587948325);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1587948325, i, -1, "com.example.flashcardapp.ui.QuizzesRunDialog (ReviewTab.kt:1232)");
        }
        AndroidAlertDialog_androidKt.m1232AlertDialogOix01E0(onDismissRequest, ComposableLambdaKt.composableLambda(startRestartGroup, 1596378477, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$QuizzesRunDialog$1
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
                        ComposerKt.traceEventStart(1596378477, i2, -1, "com.example.flashcardapp.ui.QuizzesRunDialog.<anonymous> (ReviewTab.kt:1236)");
                    }
                    ButtonKt.TextButton(onDismissRequest, null, false, null, null, null, null, null, null, ComposableSingletons$ReviewTabKt.INSTANCE.m6291getLambda50$app_release(), composer2, 805306368, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), null, null, null, ComposableSingletons$ReviewTabKt.INSTANCE.m6292getLambda51$app_release(), ComposableLambdaKt.composableLambda(startRestartGroup, -1000082958, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$QuizzesRunDialog$2
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
                        ComposerKt.traceEventStart(-1000082958, i2, -1, "com.example.flashcardapp.ui.QuizzesRunDialog.<anonymous> (ReviewTab.kt:1244)");
                    }
                    if (sessionRecords.isEmpty()) {
                        composer2.startReplaceableGroup(1932873834);
                        Modifier m604height3ABfNKs = SizeKt.m604height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(200));
                        Alignment center = Alignment.INSTANCE.getCenter();
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m604height3ABfNKs);
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
                        Updater.m2954setimpl(m2947constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl.getInserting() || !Intrinsics.areEqual(m2947constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m2947constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m2947constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        TextKt.m2133Text4IGK_g("No quiz records found.", (Modifier) null, ThemeKt.getTextSecondaryGray(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 6, 0, 131066);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(1932874119);
                        Modifier m606heightInVpY3zN4$default = SizeKt.m606heightInVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m5738constructorimpl(400), 1, null);
                        Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(8));
                        final List<SessionRecordEntity> list = sessionRecords;
                        LazyDslKt.LazyColumn(m606heightInVpY3zN4$default, null, null, false, m478spacedBy0680j_4, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$QuizzesRunDialog$2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                final List sortedWith = CollectionsKt.sortedWith(list, new Comparator() { // from class: com.example.flashcardapp.ui.ReviewTabKt$QuizzesRunDialog$2$2$invoke$$inlined$sortedByDescending$1
                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // java.util.Comparator
                                    public final int compare(T t, T t2) {
                                        return ComparisonsKt.compareValues(Long.valueOf(((SessionRecordEntity) t2).getTimestamp()), Long.valueOf(((SessionRecordEntity) t).getTimestamp()));
                                    }
                                });
                                final ReviewTabKt$QuizzesRunDialog$2$2$invoke$$inlined$items$default$1 reviewTabKt$QuizzesRunDialog$2$2$invoke$$inlined$items$default$1 = new Function1() { // from class: com.example.flashcardapp.ui.ReviewTabKt$QuizzesRunDialog$2$2$invoke$$inlined$items$default$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Void invoke(SessionRecordEntity sessionRecordEntity) {
                                        return null;
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        return invoke((SessionRecordEntity) obj);
                                    }
                                };
                                LazyColumn.items(sortedWith.size(), null, new Function1<Integer, Object>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$QuizzesRunDialog$2$2$invoke$$inlined$items$default$3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                        return invoke(num.intValue());
                                    }

                                    public final Object invoke(int i3) {
                                        return Function1.this.invoke(sortedWith.get(i3));
                                    }
                                }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$QuizzesRunDialog$2$2$invoke$$inlined$items$default$4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer3, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer3, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope lazyItemScope, int i3, Composer composer3, int i4) {
                                        int i5;
                                        ComposerKt.sourceInformation(composer3, "C148@6730L22:LazyDsl.kt#428nma");
                                        if ((i4 & 14) == 0) {
                                            i5 = i4 | (composer3.changed(lazyItemScope) ? 4 : 2);
                                        } else {
                                            i5 = i4;
                                        }
                                        if ((i4 & 112) == 0) {
                                            i5 |= composer3.changed(i3) ? 32 : 16;
                                        }
                                        if ((i5 & 731) == 146 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-632812321, i5, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:148)");
                                        }
                                        final SessionRecordEntity sessionRecordEntity = (SessionRecordEntity) sortedWith.get(i3);
                                        long timestamp = sessionRecordEntity.getTimestamp();
                                        composer3.startReplaceableGroup(1773663378);
                                        boolean changed = composer3.changed(timestamp);
                                        Object rememberedValue = composer3.rememberedValue();
                                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault()).format(new Date(sessionRecordEntity.getTimestamp()));
                                            composer3.updateRememberedValue(rememberedValue);
                                        }
                                        final String str = (String) rememberedValue;
                                        composer3.endReplaceableGroup();
                                        CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, CardDefaults.INSTANCE.m1295cardColorsro_MJ88(Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getSurfaceVariant(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0L, composer3, CardDefaults.$stable << 12, 14), null, BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(1), Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOutlineVariant(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null)), ComposableLambdaKt.composableLambda(composer3, -1697333504, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$QuizzesRunDialog$2$2$2$1
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

                                            public final void invoke(ColumnScope Card, Composer composer4, int i6) {
                                                Intrinsics.checkNotNullParameter(Card, "$this$Card");
                                                if ((i6 & 81) != 16 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1697333504, i6, -1, "com.example.flashcardapp.ui.QuizzesRunDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ReviewTab.kt:1266)");
                                                    }
                                                    Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(12));
                                                    SessionRecordEntity sessionRecordEntity2 = SessionRecordEntity.this;
                                                    String str2 = str;
                                                    composer4.startReplaceableGroup(-483455358);
                                                    ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                                    composer4.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                    CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
                                                    if (!(composer4.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer4.startReusableNode();
                                                    if (composer4.getInserting()) {
                                                        composer4.createNode(constructor2);
                                                    } else {
                                                        composer4.useNode();
                                                    }
                                                    Composer m2947constructorimpl2 = Updater.m2947constructorimpl(composer4);
                                                    Updater.m2954setimpl(m2947constructorimpl2, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m2954setimpl(m2947constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m2947constructorimpl2.getInserting() || !Intrinsics.areEqual(m2947constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                        m2947constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                        m2947constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                    }
                                                    modifierMaterializerOf2.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                                    composer4.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                                    TextKt.m2133Text4IGK_g(sessionRecordEntity2.getDeckName(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodyMedium(), composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65498);
                                                    float f = 4;
                                                    SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f)), composer4, 6);
                                                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                    Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                                                    composer4.startReplaceableGroup(693286680);
                                                    ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, Alignment.INSTANCE.getTop(), composer4, 6);
                                                    composer4.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                    CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
                                                    if (!(composer4.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer4.startReusableNode();
                                                    if (composer4.getInserting()) {
                                                        composer4.createNode(constructor3);
                                                    } else {
                                                        composer4.useNode();
                                                    }
                                                    Composer m2947constructorimpl3 = Updater.m2947constructorimpl(composer4);
                                                    Updater.m2954setimpl(m2947constructorimpl3, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                        m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                        m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                                    }
                                                    modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                                    composer4.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                                    TextKt.m2133Text4IGK_g("Mode: " + sessionRecordEntity2.getMode(), (Modifier) null, ThemeKt.getTextSecondaryGray(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodySmall(), composer4, 0, 0, 65530);
                                                    TextKt.m2133Text4IGK_g("Score: " + sessionRecordEntity2.getScore() + "/" + sessionRecordEntity2.getTotalQuestions(), (Modifier) null, ThemeKt.getPrimaryPurple(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodySmall(), composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65498);
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    composer4.endReplaceableGroup();
                                                    composer4.endNode();
                                                    composer4.endReplaceableGroup();
                                                    composer4.endReplaceableGroup();
                                                    SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f)), composer4, 6);
                                                    TextStyle labelSmall = MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getLabelSmall();
                                                    long textSecondaryGray = ThemeKt.getTextSecondaryGray();
                                                    Intrinsics.checkNotNull(str2);
                                                    TextKt.m2133Text4IGK_g(str2, (Modifier) null, textSecondaryGray, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, labelSmall, composer4, 0, 0, 65530);
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    composer4.endReplaceableGroup();
                                                    composer4.endNode();
                                                    composer4.endReplaceableGroup();
                                                    composer4.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }), composer3, 196614, 10);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }));
                            }
                        }, composer2, 24582, 238);
                        composer2.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(20)), Color.INSTANCE.m3454getWhite0d7_KjU(), 0L, 0L, 0L, 0.0f, null, startRestartGroup, ((i >> 3) & 14) | 102432816, 0, 15900);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$QuizzesRunDialog$3
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
                    ReviewTabKt.QuizzesRunDialog(sessionRecords, onDismissRequest, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void LegacyAnalyticsTab(final int i, final List<SessionRecordEntity> sessionRecords, final Function0<Unit> onMenuClicked, Composer composer, final int i2) {
        int i3;
        char c;
        Object obj;
        TextStyle m5264copyp1EtxEg;
        Intrinsics.checkNotNullParameter(sessionRecords, "sessionRecords");
        Intrinsics.checkNotNullParameter(onMenuClicked, "onMenuClicked");
        Composer startRestartGroup = composer.startRestartGroup(-20465056);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-20465056, i2, -1, "com.example.flashcardapp.ui.LegacyAnalyticsTab (ReviewTab.kt:1308)");
        }
        final ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable);
        ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
        List<SessionRecordEntity> list = sessionRecords;
        Iterator<T> it = list.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            i4 += ((SessionRecordEntity) it.next()).getTotalQuestions();
        }
        Iterator<T> it2 = list.iterator();
        int i5 = 0;
        while (it2.hasNext()) {
            i5 += ((SessionRecordEntity) it2.next()).getScore();
        }
        float f = i4 > 0 ? (i5 / i4) * 100 : 0.0f;
        int min = i > 0 ? Math.min(100, (i5 * 100) / RangesKt.coerceAtLeast(i, 1)) : 0;
        startRestartGroup.startReplaceableGroup(-1694467317);
        boolean changed = startRestartGroup.changed(sessionRecords);
        Object rememberedValue = startRestartGroup.rememberedValue();
        final float f2 = f;
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            long[] jArr = new long[7];
            Calendar calendar = Calendar.getInstance();
            Iterator<T> it3 = list.iterator();
            while (it3.hasNext()) {
                int i6 = min;
                calendar.setTimeInMillis(((SessionRecordEntity) it3.next()).getTimestamp());
                switch (calendar.get(7)) {
                    case 2:
                        c = 0;
                        break;
                    case 3:
                        c = 1;
                        break;
                    case 4:
                        c = 2;
                        break;
                    case 5:
                        c = 3;
                        break;
                    case 6:
                        c = 4;
                        break;
                    case 7:
                        c = 5;
                        break;
                    default:
                        c = 6;
                        break;
                }
                jArr[c] = jArr[c] + r19.getTotalQuestions();
                min = i6;
                calendar = calendar;
            }
            i3 = min;
            startRestartGroup.updateRememberedValue(jArr);
            obj = jArr;
        } else {
            i3 = min;
            obj = rememberedValue;
        }
        final long[] jArr2 = (long[]) obj;
        startRestartGroup.endReplaceableGroup();
        Long maxOrNull = ArraysKt.maxOrNull(jArr2);
        final long coerceAtLeast = maxOrNull != null ? RangesKt.coerceAtLeast(maxOrNull.longValue(), 1L) : 1L;
        startRestartGroup.startReplaceableGroup(-1694466666);
        boolean changed2 = startRestartGroup.changed(sessionRecords);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj2 : list) {
                String deckName = ((SessionRecordEntity) obj2).getDeckName();
                Object obj3 = linkedHashMap.get(deckName);
                if (obj3 == null) {
                    ArrayList arrayList = new ArrayList();
                    linkedHashMap.put(deckName, arrayList);
                    obj3 = arrayList;
                }
                ((List) obj3).add(obj2);
            }
            ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                List list2 = (List) entry.getValue();
                Iterator it4 = list2.iterator();
                int i7 = 0;
                while (it4.hasNext()) {
                    i7 += ((SessionRecordEntity) it4.next()).getTotalQuestions();
                }
                Iterator it5 = list2.iterator();
                int i8 = 0;
                while (it5.hasNext()) {
                    i8 += ((SessionRecordEntity) it5.next()).getScore();
                }
                arrayList2.add(TuplesKt.to(str, Integer.valueOf(i7 > 0 ? (i8 * 100) / i7 : 50)));
            }
            rememberedValue2 = CollectionsKt.take(CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.example.flashcardapp.ui.ReviewTabKt$LegacyAnalyticsTab$lambda$120$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues((Integer) ((Pair) t).getSecond(), (Integer) ((Pair) t2).getSecond());
                }
            }), 5);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        final List list3 = (List) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1694466257);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        final MutableState mutableState = (MutableState) rememberedValue3;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1694466193);
        Object rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue4);
        }
        final MutableState mutableState2 = (MutableState) rememberedValue4;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1694466154);
        if (LegacyAnalyticsTab$lambda$122(mutableState)) {
            startRestartGroup.startReplaceableGroup(-1694466063);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$LegacyAnalyticsTab$1$1
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
                        ReviewTabKt.LegacyAnalyticsTab$lambda$123(mutableState, false);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceableGroup();
            CalendarDialog(sessionRecords, (Function0) rememberedValue5, startRestartGroup, 56);
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1694466027);
        if (LegacyAnalyticsTab$lambda$125(mutableState2)) {
            startRestartGroup.startReplaceableGroup(-1694465935);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$LegacyAnalyticsTab$2$1
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
                        ReviewTabKt.LegacyAnalyticsTab$lambda$126(mutableState2, false);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceableGroup();
            QuizzesRunDialog(sessionRecords, (Function0) rememberedValue6, startRestartGroup, 56);
        }
        startRestartGroup.endReplaceableGroup();
        final int i9 = i3;
        Modifier verticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), rememberScrollState, false, null, false, 14, null);
        float f3 = 20;
        float f4 = 16;
        Modifier m570paddingVpY3zN4 = PaddingKt.m570paddingVpY3zN4(verticalScroll$default, Dp.m5738constructorimpl(f3), Dp.m5738constructorimpl(f4));
        Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f3));
        startRestartGroup.startReplaceableGroup(-483455358);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_4, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m570paddingVpY3zN4);
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
        m5264copyp1EtxEg = r35.m5264copyp1EtxEg((r48 & 1) != 0 ? r35.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r35.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r35.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r35.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r35.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r35.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r35.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r35.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r35.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r35.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r35.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r35.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r35.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r35.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r35.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r35.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r35.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r35.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r35.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r35.platformStyle : null, (r48 & 1048576) != 0 ? r35.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r35.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r35.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getHeadlineLarge().paragraphStyle.getTextMotion() : null);
        TextKt.m2133Text4IGK_g("Learning Analytics", (Modifier) null, colorScheme.getOnBackground(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg, startRestartGroup, 6, 0, 65530);
        TextKt.m2133Text4IGK_g("A comprehensive breakdown of your cognitive retention and knowledge stability. Data-driven insights to optimize your study sessions.", (Modifier) null, colorScheme.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(20), 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodyMedium(), startRestartGroup, 6, 6, 64506);
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
        startRestartGroup.startReplaceableGroup(-1897531505);
        Object rememberedValue7 = startRestartGroup.rememberedValue();
        if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
            rememberedValue7 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$LegacyAnalyticsTab$3$1$1
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
                    ReviewTabKt.LegacyAnalyticsTab$lambda$126(mutableState2, true);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue7);
        }
        startRestartGroup.endReplaceableGroup();
        Modifier m251clickableXHw0xAI$default = ClickableKt.m251clickableXHw0xAI$default(fillMaxWidth$default, false, null, null, (Function0) rememberedValue7, 7, null);
        CornerBasedShape large = MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getLarge();
        CardColors m1295cardColorsro_MJ88 = CardDefaults.INSTANCE.m1295cardColorsro_MJ88(Color.m3416copywmQWz5c$default(colorScheme.getSurfaceVariant(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14);
        float f5 = 1;
        CardKt.Card(m251clickableXHw0xAI$default, large, m1295cardColorsro_MJ88, null, BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(f5), colorScheme.getOutlineVariant()), ComposableLambdaKt.composableLambda(startRestartGroup, -1187701384, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$LegacyAnalyticsTab$3$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                invoke(columnScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ColumnScope Card, Composer composer2, int i10) {
                TextStyle m5264copyp1EtxEg2;
                TextStyle m5264copyp1EtxEg3;
                Intrinsics.checkNotNullParameter(Card, "$this$Card");
                if ((i10 & 81) == 16 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1187701384, i10, -1, "com.example.flashcardapp.ui.LegacyAnalyticsTab.<anonymous>.<anonymous> (ReviewTab.kt:1377)");
                }
                Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(20));
                float f6 = 8;
                Arrangement.HorizontalOrVertical m478spacedBy0680j_42 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f6));
                ColorScheme colorScheme2 = ColorScheme.this;
                int i11 = i9;
                composer2.startReplaceableGroup(-483455358);
                ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_42, Alignment.INSTANCE.getStart(), composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
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
                Updater.m2954setimpl(m2947constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2954setimpl(m2947constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m2947constructorimpl2.getInserting() || !Intrinsics.areEqual(m2947constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m2947constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m2947constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                modifierMaterializerOf2.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                m5264copyp1EtxEg2 = r16.m5264copyp1EtxEg((r48 & 1) != 0 ? r16.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r16.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r16.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r16.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r16.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r16.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r16.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r16.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r16.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r16.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r16.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r16.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r16.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r16.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r16.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r16.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r16.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r16.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r16.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r16.platformStyle : null, (r48 & 1048576) != 0 ? r16.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r16.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r16.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelSmall().paragraphStyle.getTextMotion() : null);
                TextKt.m2133Text4IGK_g("CARDS MASTERED", (Modifier) null, colorScheme2.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, TextUnitKt.getSp(1.5d), (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg2, composer2, 12582918, 0, 65402);
                Alignment.Vertical bottom = Alignment.INSTANCE.getBottom();
                Arrangement.HorizontalOrVertical m478spacedBy0680j_43 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f6));
                composer2.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m478spacedBy0680j_43, bottom, composer2, 54);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(companion);
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
                Updater.m2954setimpl(m2947constructorimpl3, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                m5264copyp1EtxEg3 = r49.m5264copyp1EtxEg((r48 & 1) != 0 ? r49.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r49.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r49.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r49.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r49.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r49.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r49.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r49.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r49.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r49.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r49.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r49.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r49.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r49.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r49.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r49.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r49.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r49.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r49.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r49.platformStyle : null, (r48 & 1048576) != 0 ? r49.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r49.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r49.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getDisplaySmall().paragraphStyle.getTextMotion() : null);
                TextKt.m2133Text4IGK_g(i11 + "%", (Modifier) null, colorScheme2.getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg3, composer2, 0, 0, 65530);
                TextKt.m2133Text4IGK_g("of deck", PaddingKt.m573paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m5738constructorimpl(6), 7, null), colorScheme2.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 54, 0, 65528);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                ProgressIndicatorKt.m1757LinearProgressIndicator_5eSRE(invoke$lambda$2$lambda$1(AnimateAsStateKt.animateFloatAsState(i11 / 100.0f, AnimationSpecKt.tween$default(1200, 0, null, 6, null), 0.0f, "masteredAnim", null, composer2, 3120, 20)), ClipKt.clip(SizeKt.m604height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(f6)), RoundedCornerShapeKt.RoundedCornerShape(50)), colorScheme2.getPrimary(), colorScheme2.getSurfaceVariant(), 0, composer2, 0, 16);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            private static final float invoke$lambda$2$lambda$1(State<Float> state) {
                return state.getValue().floatValue();
            }
        }), startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 8);
        CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getLarge(), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(Color.m3416copywmQWz5c$default(colorScheme.getSurfaceVariant(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14), null, BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(f5), colorScheme.getOutlineVariant()), ComposableLambdaKt.composableLambda(startRestartGroup, -768945439, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$LegacyAnalyticsTab$3$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                invoke(columnScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ColumnScope Card, Composer composer2, int i10) {
                TextStyle m5264copyp1EtxEg2;
                TextStyle m5264copyp1EtxEg3;
                Intrinsics.checkNotNullParameter(Card, "$this$Card");
                if ((i10 & 81) == 16 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-768945439, i10, -1, "com.example.flashcardapp.ui.LegacyAnalyticsTab.<anonymous>.<anonymous> (ReviewTab.kt:1418)");
                }
                Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(20));
                Arrangement.HorizontalOrVertical m478spacedBy0680j_42 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(6));
                ColorScheme colorScheme2 = ColorScheme.this;
                float f6 = f2;
                composer2.startReplaceableGroup(-483455358);
                ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_42, Alignment.INSTANCE.getStart(), composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
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
                Updater.m2954setimpl(m2947constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2954setimpl(m2947constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m2947constructorimpl2.getInserting() || !Intrinsics.areEqual(m2947constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m2947constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m2947constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                modifierMaterializerOf2.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                m5264copyp1EtxEg2 = r16.m5264copyp1EtxEg((r48 & 1) != 0 ? r16.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r16.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r16.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r16.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r16.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r16.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r16.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r16.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r16.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r16.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r16.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r16.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r16.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r16.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r16.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r16.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r16.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r16.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r16.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r16.platformStyle : null, (r48 & 1048576) != 0 ? r16.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r16.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r16.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelSmall().paragraphStyle.getTextMotion() : null);
                TextKt.m2133Text4IGK_g("RETENTION RATE", (Modifier) null, colorScheme2.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, TextUnitKt.getSp(1.5d), (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg2, composer2, 12582918, 0, 65402);
                m5264copyp1EtxEg3 = r49.m5264copyp1EtxEg((r48 & 1) != 0 ? r49.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r49.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r49.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r49.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r49.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r49.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r49.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r49.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r49.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r49.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r49.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r49.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r49.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r49.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r49.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r49.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r49.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r49.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r49.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r49.platformStyle : null, (r48 & 1048576) != 0 ? r49.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r49.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r49.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getDisplaySmall().paragraphStyle.getTextMotion() : null);
                TextKt.m2133Text4IGK_g(((int) f6) + "." + (((int) (f6 * 10)) % 10) + "%", (Modifier) null, colorScheme2.getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg3, composer2, 0, 0, 65530);
                TextKt.m2133Text4IGK_g("+2.4% from last week", (Modifier) null, ColorKt.Color(4283215696L), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, 390, 0, 65530);
                Arrangement.HorizontalOrVertical m478spacedBy0680j_43 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(4));
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                composer2.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m478spacedBy0680j_43, centerVertically, composer2, 54);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(companion);
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
                Updater.m2954setimpl(m2947constructorimpl3, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                IconKt.m1605Iconww6aTOc(CheckCircleKt.getCheckCircle(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(14)), ColorKt.Color(4283215696L), composer2, 3504, 0);
                TextKt.m2133Text4IGK_g("Exceptional Consistency", (Modifier) null, ColorKt.Color(4283215696L), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelSmall(), composer2, 390, 0, 65530);
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
            }
        }), startRestartGroup, 196614, 8);
        CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getLarge(), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(Color.m3416copywmQWz5c$default(colorScheme.getSurfaceVariant(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14), null, BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(f5), colorScheme.getOutlineVariant()), ComposableLambdaKt.composableLambda(startRestartGroup, 916954496, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$LegacyAnalyticsTab$3$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                invoke(columnScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ColumnScope Card, Composer composer2, int i10) {
                TextStyle m5264copyp1EtxEg2;
                long j;
                float f6;
                Intrinsics.checkNotNullParameter(Card, "$this$Card");
                if ((i10 & 81) == 16 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(916954496, i10, -1, "com.example.flashcardapp.ui.LegacyAnalyticsTab.<anonymous>.<anonymous> (ReviewTab.kt:1453)");
                }
                Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(20));
                Arrangement.HorizontalOrVertical m478spacedBy0680j_42 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(12));
                ColorScheme colorScheme2 = ColorScheme.this;
                long[] jArr3 = jArr2;
                long j2 = coerceAtLeast;
                composer2.startReplaceableGroup(-483455358);
                ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_42, Alignment.INSTANCE.getStart(), composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
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
                Updater.m2954setimpl(m2947constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2954setimpl(m2947constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m2947constructorimpl2.getInserting() || !Intrinsics.areEqual(m2947constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m2947constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m2947constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                modifierMaterializerOf2.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                composer2.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer2, 54);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default2);
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
                Updater.m2954setimpl(m2947constructorimpl3, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                m5264copyp1EtxEg2 = r26.m5264copyp1EtxEg((r48 & 1) != 0 ? r26.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r26.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r26.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r26.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r26.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r26.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r26.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r26.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r26.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r26.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r26.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r26.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r26.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r26.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r26.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r26.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r26.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r26.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r26.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r26.platformStyle : null, (r48 & 1048576) != 0 ? r26.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r26.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r26.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getTitleMedium().paragraphStyle.getTextMotion() : null);
                String str2 = "C79@3979L9:Column.kt#2w3rfo";
                String str3 = "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo";
                long j3 = j2;
                TextKt.m2133Text4IGK_g("Learning Stability", (Modifier) null, colorScheme2.getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg2, composer2, 6, 0, 65530);
                float f7 = 6;
                SurfaceKt.m1985SurfaceT9BRK9s(null, RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f7)), ColorKt.Color(4279908906L), 0L, 0.0f, 0.0f, null, ComposableSingletons$ReviewTabKt.INSTANCE.m6293getLambda52$app_release(), composer2, 12583296, 121);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                TextKt.m2133Text4IGK_g("Estimated knowledge duration across active sub-decks", (Modifier) null, colorScheme2.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, 6, 0, 65530);
                List listOf = CollectionsKt.listOf((Object[]) new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"});
                Easing easing = null;
                Modifier m571paddingVpY3zN4$default = PaddingKt.m571paddingVpY3zN4$default(SizeKt.m604height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(MenuKt.InTransitionDuration)), 0.0f, Dp.m5738constructorimpl(8), 1, null);
                Arrangement.HorizontalOrVertical spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical bottom = Alignment.INSTANCE.getBottom();
                Composer composer3 = composer2;
                composer3.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                int i11 = 54;
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween2, bottom, composer3, 54);
                int i12 = -1323940314;
                composer3.startReplaceableGroup(-1323940314);
                String str4 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
                ComposerKt.sourceInformation(composer3, str4);
                int i13 = 0;
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m571paddingVpY3zN4$default);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer3.createNode(constructor4);
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
                modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer3, 0);
                composer3.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                composer3.startReplaceableGroup(-3065954);
                int i14 = 0;
                for (Object obj4 : listOf) {
                    int i15 = i14 + 1;
                    if (i14 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    String str5 = (String) obj4;
                    long j4 = jArr3[i14];
                    if (j4 > 0) {
                        j = j3;
                        f6 = Math.max(0.08f, ((float) j4) / ((float) j));
                    } else {
                        j = j3;
                        f6 = 0.05f;
                    }
                    long j5 = j;
                    State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(f6, AnimationSpecKt.tween$default(1000, i14 * 80, easing, 4, easing), 0.0f, "bar" + i14, null, composer2, 0, 20);
                    Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_43 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(4));
                    composer3.startReplaceableGroup(-483455358);
                    String str6 = str3;
                    ComposerKt.sourceInformation(composer3, str6);
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_43, centerHorizontally, composer3, i11);
                    composer3.startReplaceableGroup(i12);
                    ComposerKt.sourceInformation(composer3, str4);
                    int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer3, i13);
                    CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(companion);
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
                    Updater.m2954setimpl(m2947constructorimpl5, columnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl5.getInserting() || !Intrinsics.areEqual(m2947constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                        m2947constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                        m2947constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                    }
                    modifierMaterializerOf5.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer3, Integer.valueOf(i13));
                    composer3.startReplaceableGroup(2058660585);
                    String str7 = str2;
                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, str7);
                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                    Modifier clip = ClipKt.clip(SizeKt.fillMaxHeight(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(28)), invoke$lambda$5$lambda$4$lambda$3$lambda$1(animateFloatAsState)), RoundedCornerShapeKt.m841RoundedCornerShapea9UjIt4$default(Dp.m5738constructorimpl(f7), Dp.m5738constructorimpl(f7), 0.0f, 0.0f, 12, null));
                    Brush.Companion companion2 = Brush.INSTANCE;
                    Color[] colorArr = new Color[2];
                    colorArr[i13] = Color.m3407boximpl(colorScheme2.getPrimary());
                    colorArr[1] = Color.m3407boximpl(Color.m3416copywmQWz5c$default(colorScheme2.getPrimary(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null));
                    BoxKt.Box(BackgroundKt.background$default(clip, Brush.Companion.m3374verticalGradient8A3gB4$default(companion2, CollectionsKt.listOf((Object[]) colorArr), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), composer3, i13);
                    TextKt.m2133Text4IGK_g(str5, (Modifier) null, colorScheme2.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getLabelSmall(), composer2, 0, 0, 65530);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer3 = composer2;
                    i14 = i15;
                    j3 = j5;
                    str2 = str7;
                    str3 = str6;
                    i13 = i13;
                    str4 = str4;
                    i12 = i12;
                    i11 = i11;
                    easing = null;
                }
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
                }
            }

            private static final float invoke$lambda$5$lambda$4$lambda$3$lambda$1(State<Float> state) {
                return state.getValue().floatValue();
            }
        }), startRestartGroup, 196614, 8);
        CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getLarge(), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(Color.m3416copywmQWz5c$default(colorScheme.getSurfaceVariant(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14), null, BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(f5), colorScheme.getOutlineVariant()), ComposableLambdaKt.composableLambda(startRestartGroup, -1692112865, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$LegacyAnalyticsTab$3$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                invoke(columnScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ColumnScope Card, Composer composer2, int i10) {
                TextStyle m5264copyp1EtxEg2;
                String str2;
                Intrinsics.checkNotNullParameter(Card, "$this$Card");
                if ((i10 & 81) == 16 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1692112865, i10, -1, "com.example.flashcardapp.ui.LegacyAnalyticsTab.<anonymous>.<anonymous> (ReviewTab.kt:1514)");
                }
                Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(20));
                Arrangement.HorizontalOrVertical m478spacedBy0680j_42 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(14));
                ColorScheme colorScheme2 = ColorScheme.this;
                List<Pair<String, Integer>> list4 = list3;
                composer2.startReplaceableGroup(-483455358);
                ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_42, Alignment.INSTANCE.getStart(), composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
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
                Updater.m2954setimpl(m2947constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2954setimpl(m2947constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m2947constructorimpl2.getInserting() || !Intrinsics.areEqual(m2947constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m2947constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m2947constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                modifierMaterializerOf2.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                m5264copyp1EtxEg2 = r16.m5264copyp1EtxEg((r48 & 1) != 0 ? r16.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r16.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r16.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r16.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r16.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r16.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r16.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r16.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r16.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r16.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r16.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r16.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r16.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r16.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r16.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r16.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r16.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r16.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r16.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r16.platformStyle : null, (r48 & 1048576) != 0 ? r16.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r16.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r16.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getTitleMedium().paragraphStyle.getTextMotion() : null);
                str2 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
                TextKt.m2133Text4IGK_g("Knowledge Gaps", (Modifier) null, colorScheme2.getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg2, composer2, 6, 0, 65530);
                TextKt.m2133Text4IGK_g("Topics requiring reinforcement based on review failures.", (Modifier) null, colorScheme2.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, 6, 0, 65530);
                float f6 = 0.0f;
                int i11 = 1;
                String str3 = null;
                ButtonKt.Button(new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$LegacyAnalyticsTab$3$5$1$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                }, SizeKt.m604height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(48)), false, RoundedCornerShapeKt.RoundedCornerShape(50), ButtonDefaults.INSTANCE.m1274buttonColorsro_MJ88(ColorKt.Color(4279592384L), Color.INSTANCE.m3454getWhite0d7_KjU(), 0L, 0L, composer2, (ButtonDefaults.$stable << 12) | 54, 12), null, null, null, null, ComposableSingletons$ReviewTabKt.INSTANCE.m6294getLambda53$app_release(), composer2, 805306422, 484);
                if (list4.isEmpty()) {
                    composer2.startReplaceableGroup(-3062943);
                    TextKt.m2133Text4IGK_g("Complete more sessions to see gaps.", (Modifier) null, colorScheme2.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, 6, 0, 65530);
                    composer2.endReplaceableGroup();
                } else {
                    Composer composer3 = composer2;
                    composer3.startReplaceableGroup(-3062772);
                    Iterator<T> it6 = list4.iterator();
                    while (it6.hasNext()) {
                        Pair pair = (Pair) it6.next();
                        String str4 = (String) pair.component1();
                        final int intValue = ((Number) pair.component2()).intValue();
                        final long Color = intValue < 40 ? ColorKt.Color(4287307808L) : intValue < 60 ? ColorKt.Color(4287325472L) : intValue < 75 ? ColorKt.Color(4283071050L) : ColorKt.Color(4279592384L);
                        Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, f6, i11, str3);
                        Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer3, 54);
                        composer3.startReplaceableGroup(-1323940314);
                        String str5 = str2;
                        ComposerKt.sourceInformation(composer3, str5);
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default2);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer3.createNode(constructor3);
                        } else {
                            composer2.useNode();
                        }
                        Composer m2947constructorimpl3 = Updater.m2947constructorimpl(composer2);
                        Updater.m2954setimpl(m2947constructorimpl3, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        TextKt.m2133Text4IGK_g(StringsKt.take(StringsKt.substringAfterLast$default(str4, "::", str3, 2, str3), 24), RowScope.weight$default(RowScopeInstance.INSTANCE, Modifier.INSTANCE, 1.0f, false, 2, null), colorScheme2.getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBodyMedium(), composer2, 0, 0, 65528);
                        i11 = 1;
                        SurfaceKt.m1985SurfaceT9BRK9s(null, RoundedCornerShapeKt.RoundedCornerShape(50), Color.m3416copywmQWz5c$default(Color, 0.2f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, 434265291, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$LegacyAnalyticsTab$3$5$1$2$1$1
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

                            public final void invoke(Composer composer4, int i12) {
                                TextStyle m5264copyp1EtxEg3;
                                if ((i12 & 11) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(434265291, i12, -1, "com.example.flashcardapp.ui.LegacyAnalyticsTab.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ReviewTab.kt:1559)");
                                    }
                                    String str6 = intValue + "%";
                                    m5264copyp1EtxEg3 = r16.m5264copyp1EtxEg((r48 & 1) != 0 ? r16.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r16.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r16.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r16.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r16.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r16.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r16.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r16.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r16.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r16.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r16.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r16.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r16.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r16.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r16.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r16.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r16.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r16.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r16.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r16.platformStyle : null, (r48 & 1048576) != 0 ? r16.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r16.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r16.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getLabelMedium().paragraphStyle.getTextMotion() : null);
                                    TextKt.m2133Text4IGK_g(str6, PaddingKt.m570paddingVpY3zN4(Modifier.INSTANCE, Dp.m5738constructorimpl(10), Dp.m5738constructorimpl(4)), Color.m3416copywmQWz5c$default(Color, 1.0f, 0.0f, 0.0f, 0.0f, 14, null), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg3, composer4, 48, 0, 65528);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), composer2, 12582912, 121);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer3 = composer2;
                        str2 = str5;
                        f6 = f6;
                        str3 = null;
                    }
                    composer2.endReplaceableGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, 196614, 8);
        CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getLarge(), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(Color.m3416copywmQWz5c$default(colorScheme.getSecondaryContainer(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14), null, BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(f5), colorScheme.getOutlineVariant()), ComposableLambdaKt.composableLambda(startRestartGroup, -6212930, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$LegacyAnalyticsTab$3$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                invoke(columnScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ColumnScope Card, Composer composer2, int i10) {
                TextStyle m5264copyp1EtxEg2;
                Intrinsics.checkNotNullParameter(Card, "$this$Card");
                if ((i10 & 81) != 16 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-6212930, i10, -1, "com.example.flashcardapp.ui.LegacyAnalyticsTab.<anonymous>.<anonymous> (ReviewTab.kt:1581)");
                    }
                    Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(20));
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_42 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(16));
                    Alignment.Vertical top = Alignment.INSTANCE.getTop();
                    ColorScheme colorScheme2 = ColorScheme.this;
                    composer2.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m478spacedBy0680j_42, top, composer2, 54);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
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
                    Modifier m216backgroundbw27NRU$default = BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(48)), RoundedCornerShapeKt.getCircleShape()), colorScheme2.getSecondaryContainer(), null, 2, null);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m216backgroundbw27NRU$default);
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
                    Updater.m2954setimpl(m2947constructorimpl3, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    IconKt.m1605Iconww6aTOc(WbSunnyKt.getWbSunny(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(28)), colorScheme2.getOnSecondaryContainer(), composer2, 432, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_43 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(4));
                    composer2.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_43, Alignment.INSTANCE.getStart(), composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(companion);
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
                    Updater.m2954setimpl(m2947constructorimpl4, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    m5264copyp1EtxEg2 = r16.m5264copyp1EtxEg((r48 & 1) != 0 ? r16.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r16.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r16.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r16.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r16.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r16.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r16.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r16.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r16.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r16.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r16.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r16.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r16.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r16.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r16.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r16.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r16.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r16.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r16.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r16.platformStyle : null, (r48 & 1048576) != 0 ? r16.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r16.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r16.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getTitleMedium().paragraphStyle.getTextMotion() : null);
                    TextKt.m2133Text4IGK_g("Optimal Review Time", (Modifier) null, colorScheme2.getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg2, composer2, 6, 0, 65530);
                    TextKt.m2133Text4IGK_g("Your focus peaks between 06:00 and 10:00 AM. Completing your pending cards during this window can increase retention by up to 12%.", (Modifier) null, colorScheme2.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(18), 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, 6, 6, 64506);
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
        }), startRestartGroup, 196614, 8);
        CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getLarge(), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(Color.m3416copywmQWz5c$default(colorScheme.getSurfaceVariant(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14), null, BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(f5), colorScheme.getOutlineVariant()), ComposableLambdaKt.composableLambda(startRestartGroup, 1679687005, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$LegacyAnalyticsTab$3$7
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                invoke(columnScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ColumnScope Card, Composer composer2, int i10) {
                TextStyle m5264copyp1EtxEg2;
                Intrinsics.checkNotNullParameter(Card, "$this$Card");
                if ((i10 & 81) != 16 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1679687005, i10, -1, "com.example.flashcardapp.ui.LegacyAnalyticsTab.<anonymous>.<anonymous> (ReviewTab.kt:1611)");
                    }
                    Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(20));
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_42 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(16));
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    ColorScheme colorScheme2 = ColorScheme.this;
                    List<SessionRecordEntity> list4 = sessionRecords;
                    composer2.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m478spacedBy0680j_42, centerVertically, composer2, 54);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
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
                    Modifier m216backgroundbw27NRU$default = BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(48)), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(12))), colorScheme2.getPrimaryContainer(), null, 2, null);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m216backgroundbw27NRU$default);
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
                    Updater.m2954setimpl(m2947constructorimpl3, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    IconKt.m1605Iconww6aTOc(SyncKt.getSync(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(28)), colorScheme2.getOnPrimaryContainer(), composer2, 432, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_43 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(2));
                    Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                    composer2.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_43, Alignment.INSTANCE.getStart(), composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(weight$default);
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
                    Updater.m2954setimpl(m2947constructorimpl4, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    m5264copyp1EtxEg2 = r16.m5264copyp1EtxEg((r48 & 1) != 0 ? r16.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r16.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r16.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r16.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r16.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r16.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r16.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r16.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r16.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r16.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r16.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r16.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r16.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r16.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r16.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r16.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r16.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r16.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r16.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r16.platformStyle : null, (r48 & 1048576) != 0 ? r16.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r16.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r16.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getTitleMedium().paragraphStyle.getTextMotion() : null);
                    TextKt.m2133Text4IGK_g("Knowledge Sync", (Modifier) null, colorScheme2.getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg2, composer2, 6, 0, 65530);
                    TextKt.m2133Text4IGK_g("Last sync: ".concat(list4.isEmpty() ? "Never" : "a few minutes ago"), (Modifier) null, colorScheme2.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, 0, 0, 65530);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    IconKt.m1605Iconww6aTOc(KeyboardArrowRightKt.getKeyboardArrowRight(Icons.AutoMirrored.Filled.INSTANCE), (String) null, (Modifier) null, colorScheme2.getOnSurfaceVariant(), composer2, 48, 4);
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
        }), startRestartGroup, 196614, 8);
        SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f4)), startRestartGroup, 6);
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$LegacyAnalyticsTab$4
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

                public final void invoke(Composer composer2, int i10) {
                    ReviewTabKt.LegacyAnalyticsTab(i, sessionRecords, onMenuClicked, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    private static final boolean LegacyAnalyticsTab$lambda$122(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LegacyAnalyticsTab$lambda$123(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean LegacyAnalyticsTab$lambda$125(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LegacyAnalyticsTab$lambda$126(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void StatCard(final java.lang.String r20, final java.lang.String r21, androidx.compose.ui.Modifier r22, kotlin.jvm.functions.Function0<kotlin.Unit> r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.ui.ReviewTabKt.StatCard(java.lang.String, java.lang.String, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final float ReviewTab$lambda$35(State<Dp> state) {
        return state.getValue().m5752unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Pair<DeckNode, Integer>> ReviewTab$lambda$77(State<? extends List<Pair<DeckNode, Integer>>> state) {
        return state.getValue();
    }
}
