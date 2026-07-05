package com.example.flashcardapp.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequestKt;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.CanvasKt;
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
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.PersonKt;
import androidx.compose.material.icons.outlined.BoltKt;
import androidx.compose.material.icons.outlined.EmojiEventsKt;
import androidx.compose.material.icons.outlined.LibraryBooksKt;
import androidx.compose.material.icons.outlined.LocalFireDepartmentKt;
import androidx.compose.material.icons.outlined.NotificationsKt;
import androidx.compose.material.icons.outlined.ScheduleKt;
import androidx.compose.material.icons.outlined.TrackChangesKt;
import androidx.compose.material.icons.outlined.VerifiedKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CalendarModelKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MenuKt;
import androidx.compose.material3.OutlinedTextFieldDefaults;
import androidx.compose.material3.OutlinedTextFieldKt;
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
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
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
import androidx.core.location.LocationRequestCompat;
import androidx.profileinstaller.ProfileVerifier;
import coil.compose.SingletonAsyncImageKt;
import com.example.flashcardapp.data.TranslationManager;
import com.example.flashcardapp.data.entities.SessionRecordEntity;
import com.example.flashcardapp.session.StreakCalculator;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
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
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: AnalyticsTab.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a1\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001aa\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052$\u0010\u001a\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0007¢\u0006\u0002\u0010\u001d\u001a\u001d\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!H\u0003¢\u0006\u0002\u0010\"\u001a:\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a(\u0010+\u001a\u00020\u00012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u00102\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060²\u0006\n\u00101\u001a\u000202X\u008a\u0084\u0002²\u0006\n\u00103\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u00104\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u00105\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u00106\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\f\u00107\u001a\u0004\u0018\u00010\u0005X\u008a\u008e\u0002²\u0006\n\u00108\u001a\u00020!X\u008a\u008e\u0002²\u0006\n\u00109\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010:\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010;\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010<\u001a\u00020\u0005X\u008a\u008e\u0002"}, d2 = {"AccomplishmentCard", "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "title", "", "desc", "time", "color", "Landroidx/compose/ui/graphics/Color;", "AccomplishmentCard-qFjXxE8", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/runtime/Composer;I)V", "AnalyticsTab", "cardCount", "", "sessionRecords", "", "Lcom/example/flashcardapp/data/entities/SessionRecordEntity;", "onMenuClicked", "Lkotlin/Function0;", "(ILjava/util/List;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "EditProfileDialog", "currentName", "currentGoal", "currentRank", "currentBio", "onConfirm", "Lkotlin/Function4;", "onDismiss", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ProfileBadge", "text", "primary", "", "(Ljava/lang/String;ZLandroidx/compose/runtime/Composer;I)V", "ProfileStatCard", "modifier", "Landroidx/compose/ui/Modifier;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "label", "iconTint", "ProfileStatCard-qFjXxE8", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/runtime/Composer;I)V", "RetentionLineChart", "data", "", "RetentionLineChart-RPmYEkk", "(Ljava/util/List;JLandroidx/compose/runtime/Composer;I)V", "app_release", "currentLanguage", "Lcom/example/flashcardapp/data/AppLanguage;", "profileName", "profileGoal", "profileRank", "profileBio", "avatarUriStr", "showEditDialog", "name", "goal", "rank", "bio"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class AnalyticsTabKt {
    public static final void AnalyticsTab(final int i, final List<SessionRecordEntity> sessionRecords, final Function0<Unit> onMenuClicked, Composer composer, final int i2) {
        float f;
        String str;
        Object next;
        String str2;
        String str3;
        ManagedActivityResultLauncher managedActivityResultLauncher;
        String str4;
        String str5;
        String str6;
        float f2;
        int i3;
        float f3;
        List list;
        SharedPreferences sharedPreferences;
        String str7;
        int i4;
        String str8;
        String str9;
        float f4;
        String str10;
        String str11;
        int i5;
        Object obj;
        Intrinsics.checkNotNullParameter(sessionRecords, "sessionRecords");
        Intrinsics.checkNotNullParameter(onMenuClicked, "onMenuClicked");
        Composer startRestartGroup = composer.startRestartGroup(-709712245);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-709712245, i2, -1, "com.example.flashcardapp.ui.AnalyticsTab (AnalyticsTab.kt:54)");
        }
        SnapshotStateKt.collectAsState(TranslationManager.INSTANCE.getCurrentLanguage(), null, startRestartGroup, 8, 1);
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final Context context = (Context) consume;
        startRestartGroup.startReplaceableGroup(-1322823221);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = context.getSharedPreferences("AnkiPrepProfile", 0);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        final SharedPreferences sharedPreferences2 = (SharedPreferences) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1322823114);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            String string = sharedPreferences2.getString("profile_name", "Aaryan Sharma");
            if (string == null) {
                string = "Aaryan Sharma";
            }
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(string, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        final MutableState mutableState = (MutableState) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1322822988);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            String string2 = sharedPreferences2.getString("profile_goal", "Civil Services");
            if (string2 == null) {
                string2 = "Civil Services";
            }
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(string2, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        final MutableState mutableState2 = (MutableState) rememberedValue3;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1322822860);
        Object rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            String string3 = sharedPreferences2.getString("profile_rank", "Master Rank");
            if (string3 == null) {
                string3 = "Master Rank";
            }
            rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(string3, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue4);
        }
        final MutableState mutableState3 = (MutableState) rememberedValue4;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1322822739);
        Object rememberedValue5 = startRestartGroup.rememberedValue();
        if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
            String string4 = sharedPreferences2.getString("profile_bio", "Mastering Indian Polity & Ethics for the upcoming UPSC cycle. Focused on high-density information retrieval and consistent mock performance.");
            if (string4 == null) {
                string4 = "Mastering Indian Polity & Ethics for the upcoming UPSC cycle. Focused on high-density information retrieval and consistent mock performance.";
            }
            rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(string4, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue5);
        }
        final MutableState mutableState4 = (MutableState) rememberedValue5;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1322822359);
        Object rememberedValue6 = startRestartGroup.rememberedValue();
        if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
            rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(sharedPreferences2.getString("avatar_uri", null), null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue6);
        }
        final MutableState mutableState5 = (MutableState) rememberedValue6;
        startRestartGroup.endReplaceableGroup();
        EffectsKt.DisposableEffect(sharedPreferences2, new AnalyticsTabKt$AnalyticsTab$1(sharedPreferences2, mutableState, mutableState2, mutableState3, mutableState4, mutableState5), startRestartGroup, 8);
        String AnalyticsTab$lambda$15 = AnalyticsTab$lambda$15(mutableState5);
        startRestartGroup.startReplaceableGroup(-1322821096);
        boolean changed = startRestartGroup.changed(AnalyticsTab$lambda$15);
        Uri rememberedValue7 = startRestartGroup.rememberedValue();
        if (changed || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
            String AnalyticsTab$lambda$152 = AnalyticsTab$lambda$15(mutableState5);
            if (AnalyticsTab$lambda$152 != null) {
                Intrinsics.checkNotNull(AnalyticsTab$lambda$152);
                rememberedValue7 = StringsKt.startsWith$default(AnalyticsTab$lambda$152, "/", false, 2, (Object) null) ? new File(AnalyticsTab$lambda$152) : Uri.parse(AnalyticsTab$lambda$152);
            } else {
                rememberedValue7 = null;
            }
            startRestartGroup.updateRememberedValue(rememberedValue7);
        }
        Comparable comparable = (Comparable) rememberedValue7;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue8 = startRestartGroup.rememberedValue();
        if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
            startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue8 = compositionScopedCoroutineScopeCanceller;
        }
        startRestartGroup.endReplaceableGroup();
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue8).getCoroutineScope();
        startRestartGroup.endReplaceableGroup();
        final ManagedActivityResultLauncher rememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(new ActivityResultContracts.PickVisualMedia(), new Function1<Uri, Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$AnalyticsTab$photoPickerLauncher$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Uri uri) {
                invoke2(uri);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: AnalyticsTab.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "com.example.flashcardapp.ui.AnalyticsTabKt$AnalyticsTab$photoPickerLauncher$1$1", f = "AnalyticsTab.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.example.flashcardapp.ui.AnalyticsTabKt$AnalyticsTab$photoPickerLauncher$1$1, reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ MutableState<String> $avatarUriStr$delegate;
                final /* synthetic */ Context $context;
                final /* synthetic */ SharedPreferences $sharedPrefs;
                final /* synthetic */ Uri $uri;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Context context, Uri uri, SharedPreferences sharedPreferences, MutableState<String> mutableState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$context = context;
                    this.$uri = uri;
                    this.$sharedPrefs = sharedPreferences;
                    this.$avatarUriStr$delegate = mutableState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$context, this.$uri, this.$sharedPrefs, this.$avatarUriStr$delegate, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        try {
                            File file = new File(this.$context.getFilesDir(), "avatar_image.jpg");
                            InputStream openInputStream = this.$context.getContentResolver().openInputStream(this.$uri);
                            if (openInputStream != null) {
                                FileOutputStream fileOutputStream = openInputStream;
                                try {
                                    InputStream inputStream = fileOutputStream;
                                    fileOutputStream = new FileOutputStream(file);
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
                            this.$avatarUriStr$delegate.setValue(file.getAbsolutePath());
                            this.$sharedPrefs.edit().putString("avatar_uri", file.getAbsolutePath()).apply();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Uri uri) {
                if (uri != null) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, Dispatchers.getIO(), null, new AnonymousClass1(context, uri, sharedPreferences2, mutableState5, null), 2, null);
                }
            }
        }, startRestartGroup, 8);
        ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
        startRestartGroup.startReplaceableGroup(-1322819819);
        boolean changed2 = startRestartGroup.changed(sessionRecords);
        Object rememberedValue9 = startRestartGroup.rememberedValue();
        if (changed2 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
            rememberedValue9 = StreakCalculator.INSTANCE.calculate(sessionRecords);
            startRestartGroup.updateRememberedValue(rememberedValue9);
        }
        StreakCalculator.StreakInfo streakInfo = (StreakCalculator.StreakInfo) rememberedValue9;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1322819728);
        boolean changed3 = startRestartGroup.changed(sessionRecords);
        Object rememberedValue10 = startRestartGroup.rememberedValue();
        if (changed3 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
            List<SessionRecordEntity> list2 = sessionRecords;
            Iterator<T> it = list2.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                i6 += ((SessionRecordEntity) it.next()).getTotalQuestions();
            }
            Iterator<T> it2 = list2.iterator();
            int i7 = 0;
            while (it2.hasNext()) {
                i7 += ((SessionRecordEntity) it2.next()).getScore();
            }
            rememberedValue10 = Float.valueOf(i6 > 0 ? (i7 / i6) * 100 : 0.0f);
            startRestartGroup.updateRememberedValue(rememberedValue10);
        }
        float floatValue = ((Number) rememberedValue10).floatValue();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1322819488);
        boolean changed4 = startRestartGroup.changed(sessionRecords);
        Object rememberedValue11 = startRestartGroup.rememberedValue();
        if (changed4 || rememberedValue11 == Composer.INSTANCE.getEmpty()) {
            Iterator<T> it3 = sessionRecords.iterator();
            int i8 = 0;
            while (it3.hasNext()) {
                i8 += ((SessionRecordEntity) it3.next()).getTotalQuestions();
            }
            rememberedValue11 = Integer.valueOf(i8);
            startRestartGroup.updateRememberedValue(rememberedValue11);
        }
        int intValue = ((Number) rememberedValue11).intValue();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1322819391);
        boolean changed5 = startRestartGroup.changed(sessionRecords);
        Object rememberedValue12 = startRestartGroup.rememberedValue();
        if (changed5 || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
            Iterator<T> it4 = sessionRecords.iterator();
            long j = 0;
            while (it4.hasNext()) {
                j += ((SessionRecordEntity) it4.next()).getTimeTakenSeconds();
            }
            rememberedValue12 = Float.valueOf(((float) j) / 3600.0f);
            startRestartGroup.updateRememberedValue(rememberedValue12);
        }
        float floatValue2 = ((Number) rememberedValue12).floatValue();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1322819293);
        boolean changed6 = startRestartGroup.changed(intValue);
        Object rememberedValue13 = startRestartGroup.rememberedValue();
        if (changed6 || rememberedValue13 == Composer.INSTANCE.getEmpty()) {
            rememberedValue13 = Integer.valueOf(RangesKt.coerceIn(intValue / 50, 1, 99));
            startRestartGroup.updateRememberedValue(rememberedValue13);
        }
        int intValue2 = ((Number) rememberedValue13).intValue();
        startRestartGroup.endReplaceableGroup();
        String AnalyticsTab$lambda$9 = sessionRecords.isEmpty() ? AnalyticsTab$lambda$9(mutableState3) : floatValue >= 85.0f ? "Master Rank" : floatValue >= 65.0f ? "Gold Rank" : floatValue >= 45.0f ? "Silver Rank" : "Bronze Rank";
        Intrinsics.checkNotNull(AnalyticsTab$lambda$9);
        startRestartGroup.startReplaceableGroup(-1322818967);
        boolean changed7 = startRestartGroup.changed(sessionRecords);
        Object rememberedValue14 = startRestartGroup.rememberedValue();
        if (changed7 || rememberedValue14 == Composer.INSTANCE.getEmpty()) {
            long currentTimeMillis = System.currentTimeMillis();
            int[] iArr = new int[5];
            for (int i9 = 0; i9 < 5; i9++) {
                iArr[i9] = 0;
            }
            int[] iArr2 = new int[5];
            for (int i10 = 0; i10 < 5; i10++) {
                iArr2[i10] = 0;
            }
            Iterator it5 = sessionRecords.iterator();
            while (it5.hasNext()) {
                SessionRecordEntity sessionRecordEntity = (SessionRecordEntity) it5.next();
                Iterator it6 = it5;
                int timestamp = (int) ((currentTimeMillis - sessionRecordEntity.getTimestamp()) / CalendarModelKt.MillisecondsIn24Hours);
                char c = timestamp == 0 ? (char) 4 : (1 > timestamp || timestamp >= 8) ? (8 > timestamp || timestamp >= 15) ? (15 > timestamp || timestamp >= 22) ? (22 > timestamp || timestamp >= 29) ? (char) 65535 : (char) 0 : (char) 1 : (char) 2 : (char) 3;
                if (c != 65535) {
                    iArr[c] = iArr[c] + sessionRecordEntity.getTotalQuestions();
                    iArr2[c] = iArr2[c] + sessionRecordEntity.getScore();
                }
                it5 = it6;
            }
            ArrayList arrayList = new ArrayList(5);
            for (int i11 = 0; i11 < 5; i11++) {
                arrayList.add(Float.valueOf(75.0f));
            }
            ArrayList arrayList2 = arrayList;
            int i12 = 0;
            for (int i13 = 5; i12 < i13; i13 = 5) {
                int i14 = iArr[i12];
                if (i14 > 0) {
                    arrayList2.set(i12, Float.valueOf((iArr2[i12] / i14) * 100.0f));
                } else {
                    if (i12 == 0) {
                        f = 70.0f;
                    } else if (i12 != 1) {
                        if (i12 != 2) {
                            if (i12 == 3) {
                                f = 78.0f;
                            } else if (i12 == 4) {
                                f = 80.0f;
                            }
                        }
                        f = 75.0f;
                    } else {
                        f = 72.0f;
                    }
                    arrayList2.set(i12, Float.valueOf(f));
                }
                i12++;
            }
            rememberedValue14 = CollectionsKt.toList(arrayList2);
            startRestartGroup.updateRememberedValue(rememberedValue14);
        }
        List list3 = (List) rememberedValue14;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1322817658);
        boolean changed8 = startRestartGroup.changed(sessionRecords);
        Object rememberedValue15 = startRestartGroup.rememberedValue();
        if (changed8 || rememberedValue15 == Composer.INSTANCE.getEmpty()) {
            if (sessionRecords.isEmpty()) {
                rememberedValue15 = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("Polity", Float.valueOf(0.75f)), TuplesKt.to("Geography", Float.valueOf(0.65f)), TuplesKt.to("History", Float.valueOf(0.55f)), TuplesKt.to("Economy", Float.valueOf(0.45f)), TuplesKt.to("Ethics", Float.valueOf(0.8f)), TuplesKt.to("Aptitude", Float.valueOf(0.6f))});
            } else {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (SessionRecordEntity sessionRecordEntity2 : sessionRecords) {
                    String deckName = sessionRecordEntity2.getDeckName();
                    Integer num = (Integer) linkedHashMap.get(sessionRecordEntity2.getDeckName());
                    linkedHashMap.put(deckName, Integer.valueOf((num != null ? num.intValue() : 0) + sessionRecordEntity2.getScore()));
                    String deckName2 = sessionRecordEntity2.getDeckName();
                    Integer num2 = (Integer) linkedHashMap2.get(sessionRecordEntity2.getDeckName());
                    linkedHashMap2.put(deckName2, Integer.valueOf((num2 != null ? num2.intValue() : 0) + sessionRecordEntity2.getTotalQuestions()));
                }
                ArrayList arrayList3 = new ArrayList();
                for (Map.Entry entry : linkedHashMap2.entrySet()) {
                    String str12 = (String) entry.getKey();
                    int intValue3 = ((Number) entry.getValue()).intValue();
                    if (intValue3 > 0) {
                        arrayList3.add(TuplesKt.to(CollectionsKt.last(StringsKt.split$default((CharSequence) str12, new String[]{"::"}, false, 0, 6, (Object) null)), Float.valueOf((((Integer) linkedHashMap.get(str12)) != null ? r16.intValue() : 0) / intValue3)));
                    }
                }
                if (arrayList3.size() < 3) {
                    List listOf = CollectionsKt.listOf((Object[]) new String[]{"Polity", "Geography", "History", "Economy", "Ethics", "Aptitude"});
                    int i15 = 0;
                    while (arrayList3.size() < 5) {
                        String str13 = (String) listOf.get(i15 % listOf.size());
                        ArrayList arrayList4 = arrayList3;
                        if (!(arrayList4 instanceof Collection) || !arrayList4.isEmpty()) {
                            Iterator it7 = arrayList4.iterator();
                            while (it7.hasNext()) {
                                if (Intrinsics.areEqual(((Pair) it7.next()).getFirst(), str13)) {
                                    break;
                                }
                            }
                        }
                        arrayList3.add(TuplesKt.to(str13, Float.valueOf(0.5f)));
                        i15++;
                    }
                }
                rememberedValue15 = CollectionsKt.take(arrayList3, 6);
            }
            startRestartGroup.updateRememberedValue(rememberedValue15);
        }
        startRestartGroup.endReplaceableGroup();
        int currentStreak = streakInfo.getCurrentStreak();
        startRestartGroup.startReplaceableGroup(-1322816144);
        boolean changed9 = startRestartGroup.changed(currentStreak) | startRestartGroup.changed(sessionRecords);
        Object rememberedValue16 = startRestartGroup.rememberedValue();
        if (changed9 || rememberedValue16 == Composer.INSTANCE.getEmpty()) {
            ArrayList arrayList5 = new ArrayList();
            if (streakInfo.getCurrentStreak() > 0) {
                arrayList5.add(new Triple(LocalFireDepartmentKt.getLocalFireDepartment(Icons.Outlined.INSTANCE), "Streak Master", "Maintained a " + streakInfo.getCurrentStreak() + "-day learning streak!"));
            }
            if (!sessionRecords.isEmpty()) {
                List<SessionRecordEntity> list4 = sessionRecords;
                Iterator<T> it8 = list4.iterator();
                if (it8.hasNext()) {
                    next = it8.next();
                    if (it8.hasNext()) {
                        int score = ((SessionRecordEntity) next).getScore();
                        do {
                            Object next2 = it8.next();
                            int score2 = ((SessionRecordEntity) next2).getScore();
                            if (score < score2) {
                                next = next2;
                                score = score2;
                            }
                        } while (it8.hasNext());
                    }
                } else {
                    next = null;
                }
                SessionRecordEntity sessionRecordEntity3 = (SessionRecordEntity) next;
                if (sessionRecordEntity3 != null) {
                    str = AnalyticsTab$lambda$9;
                    arrayList5.add(new Triple(EmojiEventsKt.getEmojiEvents(Icons.Outlined.INSTANCE), "Top Quiz Score", "Scored " + sessionRecordEntity3.getScore() + "/" + sessionRecordEntity3.getTotalQuestions() + " on " + CollectionsKt.last(StringsKt.split$default((CharSequence) sessionRecordEntity3.getDeckName(), new String[]{"::"}, false, 0, 6, (Object) null))));
                } else {
                    str = AnalyticsTab$lambda$9;
                }
                Iterator<T> it9 = list4.iterator();
                int i16 = 0;
                while (it9.hasNext()) {
                    i16 += ((SessionRecordEntity) it9.next()).getTotalQuestions();
                }
                if (i16 >= 100) {
                    arrayList5.add(new Triple(BoltKt.getBolt(Icons.Outlined.INSTANCE), "Century Solver", "Answered more than 100 custom deck questions."));
                }
            } else {
                str = AnalyticsTab$lambda$9;
            }
            if (arrayList5.size() < 2) {
                arrayList5.add(new Triple(EmojiEventsKt.getEmojiEvents(Icons.Outlined.INSTANCE), "Getting Started", "Practice your first quiz to unlock accomplishments."));
                arrayList5.add(new Triple(BoltKt.getBolt(Icons.Outlined.INSTANCE), "Quick Learner", "Complete a session in under 10 minutes to earn Speed Demon."));
            }
            rememberedValue16 = CollectionsKt.take(arrayList5, 2);
            startRestartGroup.updateRememberedValue(rememberedValue16);
        } else {
            str = AnalyticsTab$lambda$9;
        }
        List<Triple> list5 = (List) rememberedValue16;
        startRestartGroup.endReplaceableGroup();
        Modifier m216backgroundbw27NRU$default = BackgroundKt.m216backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
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
        float f5 = 20;
        Modifier m571paddingVpY3zN4$default = PaddingKt.m571paddingVpY3zN4$default(ScrollKt.verticalScroll$default(SizeKt.m625widthInVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m5738constructorimpl(600), 1, null), rememberScrollState, false, null, false, 14, null), Dp.m5738constructorimpl(f5), 0.0f, 2, null);
        Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f5));
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
        float f6 = 10;
        Arrangement.HorizontalOrVertical m478spacedBy0680j_42 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f6));
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
        Modifier m251clickableXHw0xAI$default = ClickableKt.m251clickableXHw0xAI$default(BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(38)), RoundedCornerShapeKt.getCircleShape()), Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getPrimary(), 0.15f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), false, null, null, new Function0<Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$AnalyticsTab$2$1$1$1$1
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
                rememberLauncherForActivityResult.launch(PickVisualMediaRequestKt.PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE));
            }
        }, 7, null);
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
        if (comparable != null) {
            startRestartGroup.startReplaceableGroup(-102982290);
            str7 = str;
            i3 = intValue2;
            f3 = f6;
            str2 = "C92@4661L9:Row.kt#2w3rfo";
            i4 = intValue;
            managedActivityResultLauncher = rememberLauncherForActivityResult;
            str4 = "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo";
            str5 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
            sharedPreferences = sharedPreferences2;
            str3 = "C73@3426L9:Box.kt#2w3rfo";
            str6 = "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo";
            f2 = f5;
            list = list3;
            SingletonAsyncImageKt.m6078AsyncImagegl8XCv8(comparable, "Avatar", ClipKt.clip(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.getCircleShape()), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, false, null, startRestartGroup, 1572920, 0, 4024);
            startRestartGroup.endReplaceableGroup();
        } else {
            str2 = "C92@4661L9:Row.kt#2w3rfo";
            str3 = "C73@3426L9:Box.kt#2w3rfo";
            managedActivityResultLauncher = rememberLauncherForActivityResult;
            str4 = "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo";
            str5 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
            str6 = "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo";
            f2 = f5;
            i3 = intValue2;
            f3 = f6;
            list = list3;
            sharedPreferences = sharedPreferences2;
            str7 = str;
            i4 = intValue;
            startRestartGroup.startReplaceableGroup(-102982081);
            IconKt.m1605Iconww6aTOc(PersonKt.getPerson(Icons.Filled.INSTANCE), (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(22)), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getPrimary(), startRestartGroup, 432, 0);
            startRestartGroup.endReplaceableGroup();
        }
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
        Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
        float f7 = 8;
        Arrangement.HorizontalOrVertical m478spacedBy0680j_43 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f7));
        startRestartGroup.startReplaceableGroup(693286680);
        String str14 = str4;
        ComposerKt.sourceInformation(startRestartGroup, str14);
        Modifier.Companion companion2 = Modifier.INSTANCE;
        MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m478spacedBy0680j_43, centerVertically3, startRestartGroup, 54);
        startRestartGroup.startReplaceableGroup(-1323940314);
        String str15 = str5;
        ComposerKt.sourceInformation(startRestartGroup, str15);
        int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap6 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(companion2);
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
        String str16 = str2;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, str16);
        RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
        Modifier m570paddingVpY3zN4 = PaddingKt.m570paddingVpY3zN4(BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.RoundedCornerShape(50)), ColorKt.Color(4293457390L), null, 2, null), Dp.m5738constructorimpl(f3), Dp.m5738constructorimpl(5));
        Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
        float f8 = 4;
        Arrangement.HorizontalOrVertical m478spacedBy0680j_44 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f8));
        startRestartGroup.startReplaceableGroup(693286680);
        ComposerKt.sourceInformation(startRestartGroup, str14);
        MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(m478spacedBy0680j_44, centerVertically4, startRestartGroup, 54);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, str15);
        int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap7 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf7 = LayoutKt.modifierMaterializerOf(m570paddingVpY3zN4);
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
        Updater.m2954setimpl(m2947constructorimpl7, rowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl7.getInserting() || !Intrinsics.areEqual(m2947constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
            m2947constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
            m2947constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
        }
        modifierMaterializerOf7.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, str16);
        RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
        TextKt.m2133Text4IGK_g("🔥", (Modifier) null, 0L, TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, 3078, 0, 131062);
        TextKt.m2133Text4IGK_g(String.valueOf(streakInfo.getCurrentStreak()), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getPrimary(), TextUnitKt.getSp(13), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, 199680, 0, 131026);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        IconKt.m1605Iconww6aTOc(NotificationsKt.getNotifications(Icons.Outlined.INSTANCE), "Notifications", SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(22)), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant(), startRestartGroup, 432, 0);
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
        Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
        Arrangement.HorizontalOrVertical m478spacedBy0680j_45 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f3));
        startRestartGroup.startReplaceableGroup(-483455358);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_45, centerHorizontally, startRestartGroup, 54);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, str15);
        int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap8 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf8 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default2);
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
        Updater.m2954setimpl(m2947constructorimpl8, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl8.getInserting() || !Intrinsics.areEqual(m2947constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
            m2947constructorimpl8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
            m2947constructorimpl8.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
        }
        modifierMaterializerOf8.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        Alignment bottomCenter = Alignment.INSTANCE.getBottomCenter();
        startRestartGroup.startReplaceableGroup(733328855);
        String str17 = str6;
        ComposerKt.sourceInformation(startRestartGroup, str17);
        Modifier.Companion companion3 = Modifier.INSTANCE;
        MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(bottomCenter, false, startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, str15);
        int currentCompositeKeyHash9 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap9 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor9 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf9 = LayoutKt.modifierMaterializerOf(companion3);
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
        Updater.m2954setimpl(m2947constructorimpl9, rememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash9 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl9.getInserting() || !Intrinsics.areEqual(m2947constructorimpl9.rememberedValue(), Integer.valueOf(currentCompositeKeyHash9))) {
            m2947constructorimpl9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash9));
            m2947constructorimpl9.apply(Integer.valueOf(currentCompositeKeyHash9), setCompositeKeyHash9);
        }
        modifierMaterializerOf9.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        String str18 = str3;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, str18);
        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
        Modifier clip = ClipKt.clip(SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(90)), RoundedCornerShapeKt.getCircleShape());
        Brush.Companion companion4 = Brush.INSTANCE;
        long secondary = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getSecondary();
        startRestartGroup.startReplaceableGroup(345521617);
        startRestartGroup.endReplaceableGroup();
        float f9 = 3;
        final ManagedActivityResultLauncher managedActivityResultLauncher2 = managedActivityResultLauncher;
        Modifier m251clickableXHw0xAI$default2 = ClickableKt.m251clickableXHw0xAI$default(BorderKt.m228borderxT4_qwU(BackgroundKt.background$default(clip, Brush.Companion.m3368linearGradientmHitzGk$default(companion4, CollectionsKt.listOf((Object[]) new Color[]{Color.m3407boximpl(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getPrimary()), Color.m3407boximpl(secondary)}), 0L, 0L, 0, 14, (Object) null), null, 0.0f, 6, null), Dp.m5738constructorimpl(f9), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getPrimary(), RoundedCornerShapeKt.getCircleShape()), false, null, null, new Function0<Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$AnalyticsTab$2$1$2$1$1
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
                managedActivityResultLauncher2.launch(PickVisualMediaRequestKt.PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE));
            }
        }, 7, null);
        Alignment center2 = Alignment.INSTANCE.getCenter();
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, str17);
        MeasurePolicy rememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(center2, false, startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, str15);
        int currentCompositeKeyHash10 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap10 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor10 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf10 = LayoutKt.modifierMaterializerOf(m251clickableXHw0xAI$default2);
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
        Updater.m2954setimpl(m2947constructorimpl10, rememberBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl10, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash10 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl10.getInserting() || !Intrinsics.areEqual(m2947constructorimpl10.rememberedValue(), Integer.valueOf(currentCompositeKeyHash10))) {
            m2947constructorimpl10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash10));
            m2947constructorimpl10.apply(Integer.valueOf(currentCompositeKeyHash10), setCompositeKeyHash10);
        }
        modifierMaterializerOf10.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, str18);
        BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
        if (comparable != null) {
            startRestartGroup.startReplaceableGroup(-102979795);
            str8 = str17;
            str9 = str15;
            f4 = f9;
            str10 = str18;
            SingletonAsyncImageKt.m6078AsyncImagegl8XCv8(comparable, "Avatar", ClipKt.clip(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.getCircleShape()), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, false, null, startRestartGroup, 1572920, 0, 4024);
            startRestartGroup.endReplaceableGroup();
            str11 = "toUpperCase(...)";
        } else {
            str8 = str17;
            str9 = str15;
            f4 = f9;
            str10 = str18;
            startRestartGroup.startReplaceableGroup(-102979586);
            String AnalyticsTab$lambda$3 = AnalyticsTab$lambda$3(mutableState);
            Intrinsics.checkNotNullExpressionValue(AnalyticsTab$lambda$3, "AnalyticsTab$lambda$3(...)");
            String upperCase = StringsKt.take(AnalyticsTab$lambda$3, 1).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            str11 = "toUpperCase(...)";
            TextKt.m2133Text4IGK_g(upperCase, (Modifier) null, Color.INSTANCE.m3454getWhite0d7_KjU(), TextUnitKt.getSp(36), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, 200064, 0, 131026);
            startRestartGroup.endReplaceableGroup();
        }
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        Modifier m570paddingVpY3zN42 = PaddingKt.m570paddingVpY3zN4(BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(OffsetKt.m530offsetVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m5738constructorimpl(f7), 1, null), RoundedCornerShapeKt.RoundedCornerShape(50)), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getPrimary(), null, 2, null), Dp.m5738constructorimpl(f7), Dp.m5738constructorimpl(f4));
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, str8);
        MeasurePolicy rememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        String str19 = str9;
        ComposerKt.sourceInformation(startRestartGroup, str19);
        int currentCompositeKeyHash11 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap11 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor11 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf11 = LayoutKt.modifierMaterializerOf(m570paddingVpY3zN42);
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
        Updater.m2954setimpl(m2947constructorimpl11, rememberBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash11 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl11.getInserting() || !Intrinsics.areEqual(m2947constructorimpl11.rememberedValue(), Integer.valueOf(currentCompositeKeyHash11))) {
            m2947constructorimpl11.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash11));
            m2947constructorimpl11.apply(Integer.valueOf(currentCompositeKeyHash11), setCompositeKeyHash11);
        }
        modifierMaterializerOf11.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, str10);
        BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
        TextKt.m2133Text4IGK_g("LVL " + i3, (Modifier) null, Color.INSTANCE.m3454getWhite0d7_KjU(), TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, 200064, 0, 131026);
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
        SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f7)), startRestartGroup, 6);
        Alignment.Vertical centerVertically5 = Alignment.INSTANCE.getCenterVertically();
        Arrangement.HorizontalOrVertical center3 = Arrangement.INSTANCE.getCenter();
        startRestartGroup.startReplaceableGroup(693286680);
        ComposerKt.sourceInformation(startRestartGroup, str14);
        Modifier.Companion companion5 = Modifier.INSTANCE;
        MeasurePolicy rowMeasurePolicy5 = RowKt.rowMeasurePolicy(center3, centerVertically5, startRestartGroup, 54);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, str19);
        int currentCompositeKeyHash12 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap12 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor12 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf12 = LayoutKt.modifierMaterializerOf(companion5);
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
        Updater.m2954setimpl(m2947constructorimpl12, rowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash12 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl12.getInserting() || !Intrinsics.areEqual(m2947constructorimpl12.rememberedValue(), Integer.valueOf(currentCompositeKeyHash12))) {
            m2947constructorimpl12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash12));
            m2947constructorimpl12.apply(Integer.valueOf(currentCompositeKeyHash12), setCompositeKeyHash12);
        }
        modifierMaterializerOf12.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, str16);
        RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
        String AnalyticsTab$lambda$32 = AnalyticsTab$lambda$3(mutableState);
        long sp = TextUnitKt.getSp(24);
        FontWeight bold = FontWeight.INSTANCE.getBold();
        long onBackground = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnBackground();
        Intrinsics.checkNotNull(AnalyticsTab$lambda$32);
        TextKt.m2133Text4IGK_g(AnalyticsTab$lambda$32, (Modifier) null, onBackground, sp, (FontStyle) null, bold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, 199680, 0, 131026);
        SpacerKt.Spacer(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f7)), startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(345523338);
        Object rememberedValue17 = startRestartGroup.rememberedValue();
        if (rememberedValue17 == Composer.INSTANCE.getEmpty()) {
            i5 = 2;
            obj = null;
            rememberedValue17 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue17);
        } else {
            i5 = 2;
            obj = null;
        }
        final MutableState mutableState6 = (MutableState) rememberedValue17;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(345523414);
        Object rememberedValue18 = startRestartGroup.rememberedValue();
        if (rememberedValue18 == Composer.INSTANCE.getEmpty()) {
            rememberedValue18 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$AnalyticsTab$2$1$2$2$1$1
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
                    AnalyticsTabKt.AnalyticsTab$lambda$61$lambda$60$lambda$53$lambda$51$lambda$48(mutableState6, true);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue18);
        }
        startRestartGroup.endReplaceableGroup();
        IconButtonKt.IconButton((Function0) rememberedValue18, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(24)), false, null, null, ComposableSingletons$AnalyticsTabKt.INSTANCE.m6132getLambda1$app_release(), startRestartGroup, 196662, 28);
        startRestartGroup.startReplaceableGroup(1185297598);
        if (AnalyticsTab$lambda$61$lambda$60$lambda$53$lambda$51$lambda$47(mutableState6)) {
            String AnalyticsTab$lambda$33 = AnalyticsTab$lambda$3(mutableState);
            Intrinsics.checkNotNullExpressionValue(AnalyticsTab$lambda$33, "AnalyticsTab$lambda$3(...)");
            String AnalyticsTab$lambda$6 = AnalyticsTab$lambda$6(mutableState2);
            Intrinsics.checkNotNullExpressionValue(AnalyticsTab$lambda$6, "AnalyticsTab$lambda$6(...)");
            String AnalyticsTab$lambda$92 = AnalyticsTab$lambda$9(mutableState3);
            Intrinsics.checkNotNullExpressionValue(AnalyticsTab$lambda$92, "AnalyticsTab$lambda$9(...)");
            String AnalyticsTab$lambda$12 = AnalyticsTab$lambda$12(mutableState4);
            Intrinsics.checkNotNullExpressionValue(AnalyticsTab$lambda$12, "AnalyticsTab$lambda$12(...)");
            final SharedPreferences sharedPreferences3 = sharedPreferences;
            Function4<String, String, String, String, Unit> function4 = new Function4<String, String, String, String, Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$AnalyticsTab$2$1$2$2$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(String str20, String str21, String str22, String str23) {
                    invoke2(str20, str21, str22, str23);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String name, String goal, String rank, String bio) {
                    Intrinsics.checkNotNullParameter(name, "name");
                    Intrinsics.checkNotNullParameter(goal, "goal");
                    Intrinsics.checkNotNullParameter(rank, "rank");
                    Intrinsics.checkNotNullParameter(bio, "bio");
                    mutableState.setValue(name);
                    mutableState2.setValue(goal);
                    mutableState3.setValue(rank);
                    mutableState4.setValue(bio);
                    sharedPreferences3.edit().putString("profile_name", name).putString("profile_goal", goal).putString("profile_rank", rank).putString("profile_bio", bio).apply();
                    AnalyticsTabKt.AnalyticsTab$lambda$61$lambda$60$lambda$53$lambda$51$lambda$48(mutableState6, false);
                }
            };
            startRestartGroup.startReplaceableGroup(345524727);
            Object rememberedValue19 = startRestartGroup.rememberedValue();
            if (rememberedValue19 == Composer.INSTANCE.getEmpty()) {
                rememberedValue19 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$AnalyticsTab$2$1$2$2$3$1
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
                        AnalyticsTabKt.AnalyticsTab$lambda$61$lambda$60$lambda$53$lambda$51$lambda$48(mutableState6, false);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue19);
            }
            startRestartGroup.endReplaceableGroup();
            EditProfileDialog(AnalyticsTab$lambda$33, AnalyticsTab$lambda$6, AnalyticsTab$lambda$92, AnalyticsTab$lambda$12, function4, (Function0) rememberedValue19, startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
        }
        startRestartGroup.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        Arrangement.HorizontalOrVertical m478spacedBy0680j_46 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f7));
        startRestartGroup.startReplaceableGroup(693286680);
        ComposerKt.sourceInformation(startRestartGroup, str14);
        Modifier.Companion companion6 = Modifier.INSTANCE;
        MeasurePolicy rowMeasurePolicy6 = RowKt.rowMeasurePolicy(m478spacedBy0680j_46, Alignment.INSTANCE.getTop(), startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, str19);
        int currentCompositeKeyHash13 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap13 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor13 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf13 = LayoutKt.modifierMaterializerOf(companion6);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor13);
        } else {
            startRestartGroup.useNode();
        }
        Composer m2947constructorimpl13 = Updater.m2947constructorimpl(startRestartGroup);
        Updater.m2954setimpl(m2947constructorimpl13, rowMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash13 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl13.getInserting() || !Intrinsics.areEqual(m2947constructorimpl13.rememberedValue(), Integer.valueOf(currentCompositeKeyHash13))) {
            m2947constructorimpl13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash13));
            m2947constructorimpl13.apply(Integer.valueOf(currentCompositeKeyHash13), setCompositeKeyHash13);
        }
        modifierMaterializerOf13.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, str16);
        RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
        ProfileBadge(str7, true, startRestartGroup, 48);
        String AnalyticsTab$lambda$62 = AnalyticsTab$lambda$6(mutableState2);
        Intrinsics.checkNotNullExpressionValue(AnalyticsTab$lambda$62, "AnalyticsTab$lambda$6(...)");
        ProfileBadge(AnalyticsTab$lambda$62, false, startRestartGroup, 48);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        TextKt.m2133Text4IGK_g("\"" + AnalyticsTab$lambda$12(mutableState4) + "\"", PaddingKt.m571paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m5738constructorimpl(f7), 0.0f, i5, obj), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant(), TextUnitKt.getSp(13), FontStyle.m5345boximpl(FontStyle.INSTANCE.m5354getItalic_LCdwA()), (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m5623boximpl(TextAlign.INSTANCE.m5630getCentere0LSkKk()), TextUnitKt.getSp(19), 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, 3120, 6, 129504);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        float f10 = 12;
        Arrangement.HorizontalOrVertical m478spacedBy0680j_47 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f10));
        startRestartGroup.startReplaceableGroup(-483455358);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
        Modifier.Companion companion7 = Modifier.INSTANCE;
        MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_47, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, str19);
        int currentCompositeKeyHash14 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap14 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor14 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf14 = LayoutKt.modifierMaterializerOf(companion7);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor14);
        } else {
            startRestartGroup.useNode();
        }
        Composer m2947constructorimpl14 = Updater.m2947constructorimpl(startRestartGroup);
        Updater.m2954setimpl(m2947constructorimpl14, columnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl14, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash14 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl14.getInserting() || !Intrinsics.areEqual(m2947constructorimpl14.rememberedValue(), Integer.valueOf(currentCompositeKeyHash14))) {
            m2947constructorimpl14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash14));
            m2947constructorimpl14.apply(Integer.valueOf(currentCompositeKeyHash14), setCompositeKeyHash14);
        }
        modifierMaterializerOf14.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
        Modifier fillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
        Arrangement.HorizontalOrVertical m478spacedBy0680j_48 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f10));
        startRestartGroup.startReplaceableGroup(693286680);
        ComposerKt.sourceInformation(startRestartGroup, str14);
        MeasurePolicy rowMeasurePolicy7 = RowKt.rowMeasurePolicy(m478spacedBy0680j_48, Alignment.INSTANCE.getTop(), startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, str19);
        int currentCompositeKeyHash15 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap15 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor15 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf15 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default3);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor15);
        } else {
            startRestartGroup.useNode();
        }
        Composer m2947constructorimpl15 = Updater.m2947constructorimpl(startRestartGroup);
        Updater.m2954setimpl(m2947constructorimpl15, rowMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl15, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash15 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl15.getInserting() || !Intrinsics.areEqual(m2947constructorimpl15.rememberedValue(), Integer.valueOf(currentCompositeKeyHash15))) {
            m2947constructorimpl15.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash15));
            m2947constructorimpl15.apply(Integer.valueOf(currentCompositeKeyHash15), setCompositeKeyHash15);
        }
        modifierMaterializerOf15.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, str16);
        RowScopeInstance rowScopeInstance7 = RowScopeInstance.INSTANCE;
        Modifier weight$default = RowScope.weight$default(rowScopeInstance7, Modifier.INSTANCE, 1.0f, false, 2, null);
        ImageVector libraryBooks = LibraryBooksKt.getLibraryBooks(Icons.Outlined.INSTANCE);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%,d", Arrays.copyOf(new Object[]{Integer.valueOf(i4)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        String upperCase2 = TranslationManager.INSTANCE.getString("cards_studied").toUpperCase(Locale.ROOT);
        String str20 = str11;
        Intrinsics.checkNotNullExpressionValue(upperCase2, str20);
        m6118ProfileStatCardqFjXxE8(weight$default, libraryBooks, format, upperCase2, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getPrimary(), startRestartGroup, 0);
        Modifier weight$default2 = RowScope.weight$default(rowScopeInstance7, Modifier.INSTANCE, 1.0f, false, 2, null);
        ImageVector trackChanges = TrackChangesKt.getTrackChanges(Icons.Outlined.INSTANCE);
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("%.1f%%", Arrays.copyOf(new Object[]{Float.valueOf(floatValue)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        String upperCase3 = TranslationManager.INSTANCE.getString("accuracy").toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase3, str20);
        m6118ProfileStatCardqFjXxE8(weight$default2, trackChanges, format2, upperCase3, ColorKt.Color(4280391411L), startRestartGroup, 24576);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        Modifier fillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
        Arrangement.HorizontalOrVertical m478spacedBy0680j_49 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f10));
        startRestartGroup.startReplaceableGroup(693286680);
        ComposerKt.sourceInformation(startRestartGroup, str14);
        MeasurePolicy rowMeasurePolicy8 = RowKt.rowMeasurePolicy(m478spacedBy0680j_49, Alignment.INSTANCE.getTop(), startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, str19);
        int currentCompositeKeyHash16 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap16 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor16 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf16 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default4);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor16);
        } else {
            startRestartGroup.useNode();
        }
        Composer m2947constructorimpl16 = Updater.m2947constructorimpl(startRestartGroup);
        Updater.m2954setimpl(m2947constructorimpl16, rowMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl16, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash16 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl16.getInserting() || !Intrinsics.areEqual(m2947constructorimpl16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash16))) {
            m2947constructorimpl16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash16));
            m2947constructorimpl16.apply(Integer.valueOf(currentCompositeKeyHash16), setCompositeKeyHash16);
        }
        modifierMaterializerOf16.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, str16);
        RowScopeInstance rowScopeInstance8 = RowScopeInstance.INSTANCE;
        Modifier weight$default3 = RowScope.weight$default(rowScopeInstance8, Modifier.INSTANCE, 1.0f, false, 2, null);
        ImageVector localFireDepartment = LocalFireDepartmentKt.getLocalFireDepartment(Icons.Outlined.INSTANCE);
        String str21 = streakInfo.getCurrentStreak() + " Days";
        String upperCase4 = TranslationManager.INSTANCE.getString("streak").toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase4, str20);
        m6118ProfileStatCardqFjXxE8(weight$default3, localFireDepartment, str21, upperCase4, ColorKt.Color(4294940672L), startRestartGroup, 24576);
        Modifier weight$default4 = RowScope.weight$default(rowScopeInstance8, Modifier.INSTANCE, 1.0f, false, 2, null);
        ImageVector schedule = ScheduleKt.getSchedule(Icons.Outlined.INSTANCE);
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String format3 = String.format("%.1fh", Arrays.copyOf(new Object[]{Float.valueOf(floatValue2)}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
        String upperCase5 = TranslationManager.INSTANCE.getString("time_taken").toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase5, str20);
        m6118ProfileStatCardqFjXxE8(weight$default4, schedule, format3, upperCase5, ColorKt.Color(4288423856L), startRestartGroup, 24576);
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
        final List list6 = list;
        CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f2)), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getSurface(), 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14), CardDefaults.INSTANCE.m1296cardElevationaqJV_2Y(Dp.m5738constructorimpl(0), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, (CardDefaults.$stable << 18) | 6, 62), BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(1), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOutlineVariant()), ComposableLambdaKt.composableLambda(startRestartGroup, -1053045127, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$AnalyticsTab$2$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num3) {
                invoke(columnScope, composer2, num3.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ColumnScope Card, Composer composer2, int i17) {
                Intrinsics.checkNotNullParameter(Card, "$this$Card");
                if ((i17 & 81) == 16 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1053045127, i17, -1, "com.example.flashcardapp.ui.AnalyticsTab.<anonymous>.<anonymous>.<anonymous> (AnalyticsTab.kt:409)");
                }
                float f11 = 16;
                Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f11));
                Arrangement.HorizontalOrVertical m478spacedBy0680j_410 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(4));
                List<Float> list7 = list6;
                composer2.startReplaceableGroup(-483455358);
                ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_410, Alignment.INSTANCE.getStart(), composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash17 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap17 = composer2.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor17 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf17 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor17);
                } else {
                    composer2.useNode();
                }
                Composer m2947constructorimpl17 = Updater.m2947constructorimpl(composer2);
                Updater.m2954setimpl(m2947constructorimpl17, columnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2954setimpl(m2947constructorimpl17, currentCompositionLocalMap17, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash17 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m2947constructorimpl17.getInserting() || !Intrinsics.areEqual(m2947constructorimpl17.rememberedValue(), Integer.valueOf(currentCompositeKeyHash17))) {
                    m2947constructorimpl17.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash17));
                    m2947constructorimpl17.apply(Integer.valueOf(currentCompositeKeyHash17), setCompositeKeyHash17);
                }
                modifierMaterializerOf17.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                Modifier fillMaxWidth$default5 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical centerVertically6 = Alignment.INSTANCE.getCenterVertically();
                composer2.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy9 = RowKt.rowMeasurePolicy(spaceBetween2, centerVertically6, composer2, 54);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash18 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap18 = composer2.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor18 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf18 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default5);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor18);
                } else {
                    composer2.useNode();
                }
                Composer m2947constructorimpl18 = Updater.m2947constructorimpl(composer2);
                Updater.m2954setimpl(m2947constructorimpl18, rowMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2954setimpl(m2947constructorimpl18, currentCompositionLocalMap18, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash18 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m2947constructorimpl18.getInserting() || !Intrinsics.areEqual(m2947constructorimpl18.rememberedValue(), Integer.valueOf(currentCompositeKeyHash18))) {
                    m2947constructorimpl18.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash18));
                    m2947constructorimpl18.apply(Integer.valueOf(currentCompositeKeyHash18), setCompositeKeyHash18);
                }
                modifierMaterializerOf18.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance9 = RowScopeInstance.INSTANCE;
                composer2.startReplaceableGroup(-483455358);
                ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                Modifier.Companion companion8 = Modifier.INSTANCE;
                MeasurePolicy columnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash19 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap19 = composer2.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor19 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf19 = LayoutKt.modifierMaterializerOf(companion8);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor19);
                } else {
                    composer2.useNode();
                }
                Composer m2947constructorimpl19 = Updater.m2947constructorimpl(composer2);
                Updater.m2954setimpl(m2947constructorimpl19, columnMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2954setimpl(m2947constructorimpl19, currentCompositionLocalMap19, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash19 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m2947constructorimpl19.getInserting() || !Intrinsics.areEqual(m2947constructorimpl19.rememberedValue(), Integer.valueOf(currentCompositeKeyHash19))) {
                    m2947constructorimpl19.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash19));
                    m2947constructorimpl19.apply(Integer.valueOf(currentCompositeKeyHash19), setCompositeKeyHash19);
                }
                modifierMaterializerOf19.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                TextKt.m2133Text4IGK_g("Retention Mastery", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurface(), TextUnitKt.getSp(16), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 199686, 0, 131026);
                TextKt.m2133Text4IGK_g("Knowledge decay over the last 30 days", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant(), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 3078, 0, 131058);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                Modifier m216backgroundbw27NRU$default2 = BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(28)), RoundedCornerShapeKt.getCircleShape()), Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
                Alignment center4 = Alignment.INSTANCE.getCenter();
                composer2.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(center4, false, composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash20 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap20 = composer2.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor20 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf20 = LayoutKt.modifierMaterializerOf(m216backgroundbw27NRU$default2);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor20);
                } else {
                    composer2.useNode();
                }
                Composer m2947constructorimpl20 = Updater.m2947constructorimpl(composer2);
                Updater.m2954setimpl(m2947constructorimpl20, rememberBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2954setimpl(m2947constructorimpl20, currentCompositionLocalMap20, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash20 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m2947constructorimpl20.getInserting() || !Intrinsics.areEqual(m2947constructorimpl20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash20))) {
                    m2947constructorimpl20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash20));
                    m2947constructorimpl20.apply(Integer.valueOf(currentCompositeKeyHash20), setCompositeKeyHash20);
                }
                modifierMaterializerOf20.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                TextKt.m2133Text4IGK_g("••", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary(), TextUnitKt.getSp(12), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 199686, 0, 131026);
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
                Composer composer3 = composer2;
                SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f11)), composer3, 6);
                AnalyticsTabKt.m6119RetentionLineChartRPmYEkk(list7, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), composer3, 8);
                SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(8)), composer3, 6);
                Modifier fillMaxWidth$default6 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical spaceBetween3 = Arrangement.INSTANCE.getSpaceBetween();
                composer3.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy10 = RowKt.rowMeasurePolicy(spaceBetween3, Alignment.INSTANCE.getTop(), composer3, 6);
                composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash21 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap21 = composer2.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor21 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf21 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default6);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer3.createNode(constructor21);
                } else {
                    composer2.useNode();
                }
                Composer m2947constructorimpl21 = Updater.m2947constructorimpl(composer2);
                Updater.m2954setimpl(m2947constructorimpl21, rowMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2954setimpl(m2947constructorimpl21, currentCompositionLocalMap21, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash21 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m2947constructorimpl21.getInserting() || !Intrinsics.areEqual(m2947constructorimpl21.rememberedValue(), Integer.valueOf(currentCompositeKeyHash21))) {
                    m2947constructorimpl21.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash21));
                    m2947constructorimpl21.apply(Integer.valueOf(currentCompositeKeyHash21), setCompositeKeyHash21);
                }
                modifierMaterializerOf21.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer3, 0);
                composer3.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance10 = RowScopeInstance.INSTANCE;
                composer3.startReplaceableGroup(345529617);
                Iterator it10 = CollectionsKt.listOf((Object[]) new String[]{"Week 1", "Week 2", "Week 3", "Week 4", "Today"}).iterator();
                while (it10.hasNext()) {
                    TextKt.m2133Text4IGK_g((String) it10.next(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurfaceVariant(), TextUnitKt.getSp(9), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 3072, 0, 131058);
                    composer3 = composer2;
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
        }), startRestartGroup, 196614, 0);
        Arrangement.HorizontalOrVertical m478spacedBy0680j_410 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f10));
        startRestartGroup.startReplaceableGroup(-483455358);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
        Modifier.Companion companion8 = Modifier.INSTANCE;
        MeasurePolicy columnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_410, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, str19);
        int currentCompositeKeyHash17 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap17 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor17 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf17 = LayoutKt.modifierMaterializerOf(companion8);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor17);
        } else {
            startRestartGroup.useNode();
        }
        Composer m2947constructorimpl17 = Updater.m2947constructorimpl(startRestartGroup);
        Updater.m2954setimpl(m2947constructorimpl17, columnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl17, currentCompositionLocalMap17, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash17 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl17.getInserting() || !Intrinsics.areEqual(m2947constructorimpl17.rememberedValue(), Integer.valueOf(currentCompositeKeyHash17))) {
            m2947constructorimpl17.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash17));
            m2947constructorimpl17.apply(Integer.valueOf(currentCompositeKeyHash17), setCompositeKeyHash17);
        }
        modifierMaterializerOf17.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
        Modifier fillMaxWidth$default5 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
        Alignment.Vertical centerVertically6 = Alignment.INSTANCE.getCenterVertically();
        Arrangement.HorizontalOrVertical m478spacedBy0680j_411 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f7));
        startRestartGroup.startReplaceableGroup(693286680);
        ComposerKt.sourceInformation(startRestartGroup, str14);
        MeasurePolicy rowMeasurePolicy9 = RowKt.rowMeasurePolicy(m478spacedBy0680j_411, centerVertically6, startRestartGroup, 54);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, str19);
        int currentCompositeKeyHash18 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap18 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor18 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf18 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default5);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor18);
        } else {
            startRestartGroup.useNode();
        }
        Composer m2947constructorimpl18 = Updater.m2947constructorimpl(startRestartGroup);
        Updater.m2954setimpl(m2947constructorimpl18, rowMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl18, currentCompositionLocalMap18, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash18 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl18.getInserting() || !Intrinsics.areEqual(m2947constructorimpl18.rememberedValue(), Integer.valueOf(currentCompositeKeyHash18))) {
            m2947constructorimpl18.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash18));
            m2947constructorimpl18.apply(Integer.valueOf(currentCompositeKeyHash18), setCompositeKeyHash18);
        }
        modifierMaterializerOf18.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, str16);
        RowScopeInstance rowScopeInstance9 = RowScopeInstance.INSTANCE;
        BoxKt.Box(BackgroundKt.m215backgroundbw27NRU(SizeKt.m604height3ABfNKs(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f8)), Dp.m5738constructorimpl(f2)), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getPrimary(), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(2))), startRestartGroup, 0);
        TextKt.m2133Text4IGK_g("Recent Accomplishments", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnBackground(), TextUnitKt.getSp(18), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, 199686, 0, 131026);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-336309061);
        for (Triple triple : list5) {
            m6117AccomplishmentCardqFjXxE8((ImageVector) triple.getFirst(), (String) triple.getSecond(), (String) triple.getThird(), "ACTIVE", MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getPrimary(), startRestartGroup, 3072);
        }
        startRestartGroup.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(100)), startRestartGroup, 6);
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$AnalyticsTab$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num3) {
                    invoke(composer2, num3.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i17) {
                    AnalyticsTabKt.AnalyticsTab(i, sessionRecords, onMenuClicked, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    private static final String AnalyticsTab$lambda$3(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String AnalyticsTab$lambda$6(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String AnalyticsTab$lambda$9(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String AnalyticsTab$lambda$12(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String AnalyticsTab$lambda$15(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean AnalyticsTab$lambda$61$lambda$60$lambda$53$lambda$51$lambda$47(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AnalyticsTab$lambda$61$lambda$60$lambda$53$lambda$51$lambda$48(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileBadge(final String str, final boolean z, Composer composer, final int i) {
        int i2;
        long surfaceVariant;
        long onSurfaceVariant;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1050104294);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1050104294, i3, -1, "com.example.flashcardapp.ui.ProfileBadge (AnalyticsTab.kt:462)");
            }
            if (z) {
                startRestartGroup.startReplaceableGroup(-1540013777);
                surfaceVariant = Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getPrimary(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
            } else {
                startRestartGroup.startReplaceableGroup(-1540013726);
                surfaceVariant = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getSurfaceVariant();
            }
            startRestartGroup.endReplaceableGroup();
            long j = surfaceVariant;
            if (z) {
                startRestartGroup.startReplaceableGroup(-1540013652);
                onSurfaceVariant = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getPrimary();
            } else {
                startRestartGroup.startReplaceableGroup(-1540013613);
                onSurfaceVariant = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant();
            }
            startRestartGroup.endReplaceableGroup();
            long j2 = onSurfaceVariant;
            float f = 4;
            Modifier m570paddingVpY3zN4 = PaddingKt.m570paddingVpY3zN4(BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.RoundedCornerShape(50)), j, null, 2, null), Dp.m5738constructorimpl(10), Dp.m5738constructorimpl(f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f));
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m478spacedBy0680j_4, centerVertically, startRestartGroup, 54);
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
            startRestartGroup.startReplaceableGroup(-1219274450);
            if (z) {
                IconKt.m1605Iconww6aTOc(VerifiedKt.getVerified(Icons.Outlined.INSTANCE), (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(12)), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getPrimary(), startRestartGroup, 432, 0);
            }
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            TextKt.m2133Text4IGK_g(str, (Modifier) null, j2, TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, (i3 & 14) | 199680, 0, 131026);
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$ProfileBadge$2
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
                    AnalyticsTabKt.ProfileBadge(str, z, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ProfileStatCard-qFjXxE8, reason: not valid java name */
    public static final void m6118ProfileStatCardqFjXxE8(final Modifier modifier, final ImageVector imageVector, final String str, final String str2, final long j, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1732413730);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(imageVector) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changed(str2) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= startRestartGroup.changed(j) ? 16384 : 8192;
        }
        if ((46811 & i2) != 9362 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1732413730, i2, -1, "com.example.flashcardapp.ui.ProfileStatCard (AnalyticsTab.kt:485)");
            }
            CardKt.Card(modifier, RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(16)), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getSurface(), 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14), CardDefaults.INSTANCE.m1296cardElevationaqJV_2Y(Dp.m5738constructorimpl(0), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, (CardDefaults.$stable << 18) | 6, 62), BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(1), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOutlineVariant()), ComposableLambdaKt.composableLambda(startRestartGroup, 1465352944, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$ProfileStatCard$1
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

                public final void invoke(ColumnScope Card, Composer composer2, int i3) {
                    Intrinsics.checkNotNullParameter(Card, "$this$Card");
                    if ((i3 & 81) == 16 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1465352944, i3, -1, "com.example.flashcardapp.ui.ProfileStatCard.<anonymous> (AnalyticsTab.kt:493)");
                    }
                    Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(16));
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(8));
                    ImageVector imageVector2 = ImageVector.this;
                    long j2 = j;
                    String str3 = str;
                    String str4 = str2;
                    composer2.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
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
                    IconKt.m1605Iconww6aTOc(imageVector2, (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(22)), j2, composer2, 432, 0);
                    TextKt.m2133Text4IGK_g(str3, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurface(), TextUnitKt.getSp(28), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 199680, 0, 131026);
                    TextKt.m2133Text4IGK_g(str4, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant(), TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, TextUnitKt.getSp(1), (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 12782592, 0, 130898);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, (i2 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$ProfileStatCard$2
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
                    AnalyticsTabKt.m6118ProfileStatCardqFjXxE8(Modifier.this, imageVector, str, str2, j, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: AccomplishmentCard-qFjXxE8, reason: not valid java name */
    public static final void m6117AccomplishmentCardqFjXxE8(final ImageVector imageVector, final String str, final String str2, final String str3, final long j, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-644409128);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(imageVector) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(str2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changed(str3) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= startRestartGroup.changed(j) ? 16384 : 8192;
        }
        if ((46811 & i2) != 9362 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-644409128, i2, -1, "com.example.flashcardapp.ui.AccomplishmentCard (AnalyticsTab.kt:508)");
            }
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(16)), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getSurface(), 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14), CardDefaults.INSTANCE.m1296cardElevationaqJV_2Y(Dp.m5738constructorimpl(0), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, (CardDefaults.$stable << 18) | 6, 62), BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(1), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOutlineVariant()), ComposableLambdaKt.composableLambda(startRestartGroup, -333358902, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$AccomplishmentCard$1
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

                public final void invoke(ColumnScope Card, Composer composer2, int i3) {
                    Intrinsics.checkNotNullParameter(Card, "$this$Card");
                    if ((i3 & 81) != 16 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-333358902, i3, -1, "com.example.flashcardapp.ui.AccomplishmentCard.<anonymous> (AnalyticsTab.kt:516)");
                        }
                        Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(16));
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(14));
                        long j2 = j;
                        String str4 = str3;
                        ImageVector imageVector2 = imageVector;
                        String str5 = str;
                        String str6 = str2;
                        composer2.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m478spacedBy0680j_4, centerVertically, composer2, 54);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
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
                        Updater.m2954setimpl(m2947constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl.getInserting() || !Intrinsics.areEqual(m2947constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m2947constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m2947constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        Modifier m216backgroundbw27NRU$default = BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(44)), RoundedCornerShapeKt.getCircleShape()), Color.m3416copywmQWz5c$default(j2, 0.1f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m216backgroundbw27NRU$default);
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
                        Updater.m2954setimpl(m2947constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl2.getInserting() || !Intrinsics.areEqual(m2947constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m2947constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m2947constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        modifierMaterializerOf2.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        IconKt.m1605Iconww6aTOc(imageVector2, (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(22)), j2, composer2, 432, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                        Arrangement.HorizontalOrVertical m478spacedBy0680j_42 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(2));
                        composer2.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_42, Alignment.INSTANCE.getStart(), composer2, 6);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(weight$default);
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
                        Updater.m2954setimpl(m2947constructorimpl3, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        TextKt.m2133Text4IGK_g(str5, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurface(), TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 199680, 0, 131026);
                        TextKt.m2133Text4IGK_g(str6, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(16), 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 3072, 6, 130034);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        TextKt.m2133Text4IGK_g(str4, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant(), TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 199680, 0, 131026);
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
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$AccomplishmentCard$2
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
                    AnalyticsTabKt.m6117AccomplishmentCardqFjXxE8(ImageVector.this, str, str2, str3, j, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: RetentionLineChart-RPmYEkk, reason: not valid java name */
    public static final void m6119RetentionLineChartRPmYEkk(final List<Float> list, final long j, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-2117924452);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2117924452, i, -1, "com.example.flashcardapp.ui.RetentionLineChart (AnalyticsTab.kt:540)");
        }
        final long m3416copywmQWz5c$default = Color.m3416copywmQWz5c$default(j, 0.08f, 0.0f, 0.0f, 0.0f, 14, null);
        CanvasKt.Canvas(SizeKt.m604height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(140)), new Function1<DrawScope, Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$RetentionLineChart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope Canvas) {
                int i2;
                Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                if (list.isEmpty()) {
                    return;
                }
                int i3 = 0;
                for (int i4 = 0; i4 < 6; i4++) {
                    float m3242getHeightimpl = Size.m3242getHeightimpl(Canvas.mo3966getSizeNHjbRc()) - ((i4 / 5) * Size.m3242getHeightimpl(Canvas.mo3966getSizeNHjbRc()));
                    DrawScope.m3953drawLineNGM6Ib0$default(Canvas, Color.m3416copywmQWz5c$default(Color.INSTANCE.m3449getLightGray0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, null), androidx.compose.ui.geometry.OffsetKt.Offset(0.0f, m3242getHeightimpl), androidx.compose.ui.geometry.OffsetKt.Offset(Size.m3245getWidthimpl(Canvas.mo3966getSizeNHjbRc()), m3242getHeightimpl), 1.0f, 0, null, 0.0f, null, 0, 496, null);
                }
                List<Float> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    int i5 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    arrayList.add(Offset.m3165boximpl(androidx.compose.ui.geometry.OffsetKt.Offset((i3 / (r2.size() - 1)) * Size.m3245getWidthimpl(Canvas.mo3966getSizeNHjbRc()), Size.m3242getHeightimpl(Canvas.mo3966getSizeNHjbRc()) - ((((Number) next).floatValue() / 100.0f) * Size.m3242getHeightimpl(Canvas.mo3966getSizeNHjbRc())))));
                    i3 = i5;
                }
                ArrayList arrayList2 = arrayList;
                if (arrayList2.size() >= 2) {
                    Path Path = AndroidPath_androidKt.Path();
                    Path.moveTo(Offset.m3176getXimpl(((Offset) CollectionsKt.first((List) arrayList2)).getPackedValue()), Size.m3242getHeightimpl(Canvas.mo3966getSizeNHjbRc()));
                    ArrayList arrayList3 = arrayList2;
                    Iterator it2 = arrayList3.iterator();
                    while (it2.hasNext()) {
                        long packedValue = ((Offset) it2.next()).getPackedValue();
                        Path.lineTo(Offset.m3176getXimpl(packedValue), Offset.m3177getYimpl(packedValue));
                    }
                    Path.lineTo(Offset.m3176getXimpl(((Offset) CollectionsKt.last((List) arrayList2)).getPackedValue()), Size.m3242getHeightimpl(Canvas.mo3966getSizeNHjbRc()));
                    Path.close();
                    DrawScope.m3957drawPathLG529CI$default(Canvas, Path, m3416copywmQWz5c$default, 0.0f, null, null, 0, 60, null);
                    Path Path2 = AndroidPath_androidKt.Path();
                    Path2.moveTo(Offset.m3176getXimpl(((Offset) CollectionsKt.first((List) arrayList2)).getPackedValue()), Offset.m3177getYimpl(((Offset) CollectionsKt.first((List) arrayList2)).getPackedValue()));
                    int size = arrayList2.size();
                    for (i2 = 1; i2 < size; i2++) {
                        int i6 = i2 - 1;
                        Path2.quadraticBezierTo((Offset.m3176getXimpl(((Offset) arrayList2.get(i6)).getPackedValue()) + Offset.m3176getXimpl(((Offset) arrayList2.get(i2)).getPackedValue())) / 2, Offset.m3177getYimpl(((Offset) arrayList2.get(i6)).getPackedValue()), Offset.m3176getXimpl(((Offset) arrayList2.get(i2)).getPackedValue()), Offset.m3177getYimpl(((Offset) arrayList2.get(i2)).getPackedValue()));
                    }
                    DrawScope.m3957drawPathLG529CI$default(Canvas, Path2, j, 0.0f, new Stroke(4.0f, 0.0f, StrokeCap.INSTANCE.m3770getRoundKaPHkGw(), 0, null, 26, null), null, 0, 52, null);
                    long j2 = j;
                    Iterator it3 = arrayList3.iterator();
                    while (it3.hasNext()) {
                        long packedValue2 = ((Offset) it3.next()).getPackedValue();
                        long j3 = j2;
                        DrawScope.m3948drawCircleVaOC9Bg$default(Canvas, Color.INSTANCE.m3454getWhite0d7_KjU(), 7.0f, packedValue2, 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
                        DrawScope.m3948drawCircleVaOC9Bg$default(Canvas, j3, 5.0f, packedValue2, 0.0f, new Stroke(3.0f, 0.0f, 0, 0, null, 30, null), null, 0, LocationRequestCompat.QUALITY_LOW_POWER, null);
                        j2 = j3;
                    }
                }
            }
        }, startRestartGroup, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$RetentionLineChart$2
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
                    AnalyticsTabKt.m6119RetentionLineChartRPmYEkk(list, j, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void EditProfileDialog(final String currentName, final String currentGoal, final String currentRank, final String currentBio, final Function4<? super String, ? super String, ? super String, ? super String, Unit> onConfirm, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(currentName, "currentName");
        Intrinsics.checkNotNullParameter(currentGoal, "currentGoal");
        Intrinsics.checkNotNullParameter(currentRank, "currentRank");
        Intrinsics.checkNotNullParameter(currentBio, "currentBio");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(-1220242126);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(currentName) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(currentGoal) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(currentRank) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changed(currentBio) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(onConfirm) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 131072 : 65536;
        }
        int i3 = i2;
        if ((374491 & i3) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1220242126, i3, -1, "com.example.flashcardapp.ui.EditProfileDialog (AnalyticsTab.kt:596)");
            }
            startRestartGroup.startReplaceableGroup(683779031);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(currentName, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(683779088);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(currentGoal, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(683779145);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(currentRank, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(683779201);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(currentBio, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue4;
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            AndroidAlertDialog_androidKt.m1232AlertDialogOix01E0(onDismiss, ComposableLambdaKt.composableLambda(startRestartGroup, -1390592022, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$EditProfileDialog$1
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
                            ComposerKt.traceEventStart(-1390592022, i4, -1, "com.example.flashcardapp.ui.EditProfileDialog.<anonymous> (AnalyticsTab.kt:650)");
                        }
                        composer3.startReplaceableGroup(-551070511);
                        boolean changedInstance = composer3.changedInstance(onConfirm);
                        final Function4<String, String, String, String, Unit> function4 = onConfirm;
                        final MutableState<String> mutableState5 = mutableState;
                        final MutableState<String> mutableState6 = mutableState2;
                        final MutableState<String> mutableState7 = mutableState3;
                        final MutableState<String> mutableState8 = mutableState4;
                        Object rememberedValue5 = composer3.rememberedValue();
                        if (changedInstance || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue5 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$EditProfileDialog$1$1$1
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
                                    String EditProfileDialog$lambda$64;
                                    String EditProfileDialog$lambda$67;
                                    String EditProfileDialog$lambda$70;
                                    String EditProfileDialog$lambda$73;
                                    Function4<String, String, String, String, Unit> function42 = function4;
                                    EditProfileDialog$lambda$64 = AnalyticsTabKt.EditProfileDialog$lambda$64(mutableState5);
                                    String obj = StringsKt.trim((CharSequence) EditProfileDialog$lambda$64).toString();
                                    EditProfileDialog$lambda$67 = AnalyticsTabKt.EditProfileDialog$lambda$67(mutableState6);
                                    String obj2 = StringsKt.trim((CharSequence) EditProfileDialog$lambda$67).toString();
                                    EditProfileDialog$lambda$70 = AnalyticsTabKt.EditProfileDialog$lambda$70(mutableState7);
                                    String obj3 = StringsKt.trim((CharSequence) EditProfileDialog$lambda$70).toString();
                                    EditProfileDialog$lambda$73 = AnalyticsTabKt.EditProfileDialog$lambda$73(mutableState8);
                                    function42.invoke(obj, obj2, obj3, StringsKt.trim((CharSequence) EditProfileDialog$lambda$73).toString());
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue5);
                        }
                        composer3.endReplaceableGroup();
                        ButtonKt.Button((Function0) rememberedValue5, null, false, null, ButtonDefaults.INSTANCE.m1274buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, composer3, ButtonDefaults.$stable << 12, 14), null, null, null, null, ComposableSingletons$AnalyticsTabKt.INSTANCE.m6133getLambda2$app_release(), composer3, 805306368, 494);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), null, ComposableLambdaKt.composableLambda(startRestartGroup, 1581196328, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$EditProfileDialog$2
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
                            ComposerKt.traceEventStart(1581196328, i4, -1, "com.example.flashcardapp.ui.EditProfileDialog.<anonymous> (AnalyticsTab.kt:658)");
                        }
                        ButtonKt.TextButton(onDismiss, null, false, null, null, null, null, null, null, ComposableSingletons$AnalyticsTabKt.INSTANCE.m6134getLambda3$app_release(), composer3, 805306368, 510);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), null, ComposableSingletons$AnalyticsTabKt.INSTANCE.m6135getLambda4$app_release(), ComposableLambdaKt.composableLambda(composer2, -403572091, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$EditProfileDialog$3
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
                    String EditProfileDialog$lambda$64;
                    String EditProfileDialog$lambda$67;
                    String EditProfileDialog$lambda$70;
                    String EditProfileDialog$lambda$73;
                    if ((i4 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-403572091, i4, -1, "com.example.flashcardapp.ui.EditProfileDialog.<anonymous> (AnalyticsTab.kt:606)");
                        }
                        Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(12));
                        final MutableState<String> mutableState5 = mutableState;
                        final MutableState<String> mutableState6 = mutableState2;
                        final MutableState<String> mutableState7 = mutableState3;
                        final MutableState<String> mutableState8 = mutableState4;
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
                        EditProfileDialog$lambda$64 = AnalyticsTabKt.EditProfileDialog$lambda$64(mutableState5);
                        composer3.startReplaceableGroup(-1615754323);
                        Object rememberedValue5 = composer3.rememberedValue();
                        if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue5 = (Function1) new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$EditProfileDialog$3$1$1$1
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
                                    mutableState5.setValue(it);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue5);
                        }
                        composer3.endReplaceableGroup();
                        OutlinedTextFieldKt.OutlinedTextField(EditProfileDialog$lambda$64, (Function1<? super String, Unit>) rememberedValue5, (Modifier) null, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AnalyticsTabKt.INSTANCE.m6136getLambda5$app_release(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, OutlinedTextFieldDefaults.INSTANCE.m1735colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer3, 0, 0, 0, 0, 3072, 2139092991, 4095), composer3, 1572912, 12582912, 0, 4063164);
                        EditProfileDialog$lambda$67 = AnalyticsTabKt.EditProfileDialog$lambda$67(mutableState6);
                        composer3.startReplaceableGroup(-1615753857);
                        Object rememberedValue6 = composer3.rememberedValue();
                        if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue6 = (Function1) new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$EditProfileDialog$3$1$2$1
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
                                    mutableState6.setValue(it);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue6);
                        }
                        composer3.endReplaceableGroup();
                        OutlinedTextFieldKt.OutlinedTextField(EditProfileDialog$lambda$67, (Function1<? super String, Unit>) rememberedValue6, (Modifier) null, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AnalyticsTabKt.INSTANCE.m6137getLambda6$app_release(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, OutlinedTextFieldDefaults.INSTANCE.m1735colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer3, 0, 0, 0, 0, 3072, 2139092991, 4095), composer3, 1572912, 12582912, 0, 4063164);
                        EditProfileDialog$lambda$70 = AnalyticsTabKt.EditProfileDialog$lambda$70(mutableState7);
                        composer3.startReplaceableGroup(-1615753384);
                        Object rememberedValue7 = composer3.rememberedValue();
                        if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue7 = (Function1) new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$EditProfileDialog$3$1$3$1
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
                                    mutableState7.setValue(it);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue7);
                        }
                        composer3.endReplaceableGroup();
                        OutlinedTextFieldKt.OutlinedTextField(EditProfileDialog$lambda$70, (Function1<? super String, Unit>) rememberedValue7, (Modifier) null, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AnalyticsTabKt.INSTANCE.m6138getLambda7$app_release(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, OutlinedTextFieldDefaults.INSTANCE.m1735colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer3, 0, 0, 0, 0, 3072, 2139092991, 4095), composer3, 1572912, 12582912, 0, 4063164);
                        EditProfileDialog$lambda$73 = AnalyticsTabKt.EditProfileDialog$lambda$73(mutableState8);
                        composer3.startReplaceableGroup(-1615752913);
                        Object rememberedValue8 = composer3.rememberedValue();
                        if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue8 = (Function1) new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$EditProfileDialog$3$1$4$1
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
                                    mutableState8.setValue(it);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue8);
                        }
                        composer3.endReplaceableGroup();
                        OutlinedTextFieldKt.OutlinedTextField(EditProfileDialog$lambda$73, (Function1<? super String, Unit>) rememberedValue8, (Modifier) null, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AnalyticsTabKt.INSTANCE.m6139getLambda8$app_release(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 3, 0, (MutableInteractionSource) null, (Shape) null, OutlinedTextFieldDefaults.INSTANCE.m1735colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer3, 0, 0, 0, 0, 3072, 2139092991, 4095), composer3, 1572912, 100663296, 0, 3932092);
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
            }), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, ((i3 >> 15) & 14) | 1772592, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$EditProfileDialog$4
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
                    AnalyticsTabKt.EditProfileDialog(currentName, currentGoal, currentRank, currentBio, onConfirm, onDismiss, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String EditProfileDialog$lambda$64(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String EditProfileDialog$lambda$67(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String EditProfileDialog$lambda$70(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String EditProfileDialog$lambda$73(MutableState<String> mutableState) {
        return mutableState.getValue();
    }
}
