package com.example.flashcardapp.ui;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.material.icons.filled.ArrowBackKt;
import androidx.compose.material.icons.filled.ArrowForwardKt;
import androidx.compose.material.icons.filled.AutoAwesomeKt;
import androidx.compose.material.icons.filled.BookKt;
import androidx.compose.material.icons.filled.CreateNewFolderKt;
import androidx.compose.material.icons.filled.DeleteKt;
import androidx.compose.material.icons.filled.EditKt;
import androidx.compose.material.icons.filled.MoreVertKt;
import androidx.compose.material.icons.filled.PlayArrowKt;
import androidx.compose.material.icons.filled.RefreshKt;
import androidx.compose.material.icons.filled.SearchKt;
import androidx.compose.material.icons.filled.SettingsKt;
import androidx.compose.material.icons.filled.ShareKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.TranslationManager;
import com.example.flashcardapp.ui.theme.ThemeKt;
import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReviewTab.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ComposableSingletons$ReviewTabKt {
    public static final ComposableSingletons$ReviewTabKt INSTANCE = new ComposableSingletons$ReviewTabKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f192lambda1 = ComposableLambdaKt.composableLambdaInstance(1781611907, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1781611907, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-1.<anonymous> (ReviewTab.kt:153)");
            }
            TextKt.m2133Text4IGK_g("Study Now", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 196614, 0, 131038);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f203lambda2 = ComposableLambdaKt.composableLambdaInstance(2015975174, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2015975174, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-2.<anonymous> (ReviewTab.kt:154)");
            }
            IconKt.m1605Iconww6aTOc(PlayArrowKt.getPlayArrow(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1381getPrimary0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f214lambda3 = ComposableLambdaKt.composableLambdaInstance(730484666, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(730484666, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-3.<anonymous> (ReviewTab.kt:158)");
            }
            TextKt.m2133Text4IGK_g("Add Card", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f225lambda4 = ComposableLambdaKt.composableLambdaInstance(-1679682435, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1679682435, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-4.<anonymous> (ReviewTab.kt:159)");
            }
            IconKt.m1605Iconww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1384getSecondary0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-5, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f236lambda5 = ComposableLambdaKt.composableLambdaInstance(-1401180421, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1401180421, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-5.<anonymous> (ReviewTab.kt:163)");
            }
            TextKt.m2133Text4IGK_g("Edit Cards", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-6, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f241lambda6 = ComposableLambdaKt.composableLambdaInstance(483619774, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(483619774, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-6.<anonymous> (ReviewTab.kt:164)");
            }
            IconKt.m1605Iconww6aTOc(EditKt.getEdit(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1384getSecondary0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-7, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f242lambda7 = ComposableLambdaKt.composableLambdaInstance(762121788, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(762121788, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-7.<anonymous> (ReviewTab.kt:168)");
            }
            TextKt.m2133Text4IGK_g("Rename Deck", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-8, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f243lambda8 = ComposableLambdaKt.composableLambdaInstance(-1648045313, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1648045313, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-8.<anonymous> (ReviewTab.kt:169)");
            }
            IconKt.m1605Iconww6aTOc(EditKt.getEdit(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1384getSecondary0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-9, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f244lambda9 = ComposableLambdaKt.composableLambdaInstance(-1369543299, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-9$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1369543299, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-9.<anonymous> (ReviewTab.kt:173)");
            }
            TextKt.m2133Text4IGK_g("Clear Progress", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-10, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f193lambda10 = ComposableLambdaKt.composableLambdaInstance(515256896, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-10$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(515256896, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-10.<anonymous> (ReviewTab.kt:174)");
            }
            IconKt.m1605Iconww6aTOc(RefreshKt.getRefresh(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1396getTertiary0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-11, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f194lambda11 = ComposableLambdaKt.composableLambdaInstance(793758910, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-11$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(793758910, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-11.<anonymous> (ReviewTab.kt:178)");
            }
            TextKt.m2133Text4IGK_g("Export Deck", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-12, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f195lambda12 = ComposableLambdaKt.composableLambdaInstance(-1616408191, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-12$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1616408191, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-12.<anonymous> (ReviewTab.kt:179)");
            }
            IconKt.m1605Iconww6aTOc(ShareKt.getShare(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1381getPrimary0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-13, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f196lambda13 = ComposableLambdaKt.composableLambdaInstance(-1337906177, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-13$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1337906177, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-13.<anonymous> (ReviewTab.kt:184)");
            }
            TextKt.m2133Text4IGK_g("Delete Deck", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1363getError0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-14, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f197lambda14 = ComposableLambdaKt.composableLambdaInstance(546894018, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-14$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(546894018, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-14.<anonymous> (ReviewTab.kt:185)");
            }
            IconKt.m1605Iconww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1363getError0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-15, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f198lambda15 = ComposableLambdaKt.composableLambdaInstance(-1192475517, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-15$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((i & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1192475517, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-15.<anonymous> (ReviewTab.kt:213)");
            }
            TextKt.m2133Text4IGK_g("Rename", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-16, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f199lambda16 = ComposableLambdaKt.composableLambdaInstance(2071902866, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-16$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            if ((i & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2071902866, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-16.<anonymous> (ReviewTab.kt:216)");
            }
            TextKt.m2133Text4IGK_g("Cancel", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1381getPrimary0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-17, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f200lambda17 = ComposableLambdaKt.composableLambdaInstance(324253335, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-17$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(324253335, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-17.<anonymous> (ReviewTab.kt:198)");
            }
            TextKt.m2133Text4IGK_g("Rename Deck", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleLarge(), composer, 196614, 0, 65502);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-18, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f201lambda18 = ComposableLambdaKt.composableLambdaInstance(-160480590, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-18$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-160480590, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-18.<anonymous> (ReviewTab.kt:202)");
            }
            TextKt.m2133Text4IGK_g("Deck name", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-19, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f202lambda19 = ComposableLambdaKt.composableLambdaInstance(1907562735, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-19$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            if ((i & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1907562735, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-19.<anonymous> (ReviewTab.kt:238)");
            }
            TextKt.m2133Text4IGK_g("Cancel", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1381getPrimary0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-20, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f204lambda20 = ComposableLambdaKt.composableLambdaInstance(827218489, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-20$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((i & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(827218489, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-20.<anonymous> (ReviewTab.kt:265)");
            }
            TextKt.m2133Text4IGK_g("Create", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-21, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f205lambda21 = ComposableLambdaKt.composableLambdaInstance(1248016010, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-21$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            if ((i & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1248016010, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-21.<anonymous> (ReviewTab.kt:268)");
            }
            TextKt.m2133Text4IGK_g("Cancel", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1381getPrimary0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-22, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f206lambda22 = ComposableLambdaKt.composableLambdaInstance(-934920027, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-22$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-934920027, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-22.<anonymous> (ReviewTab.kt:248)");
            }
            TextKt.m2133Text4IGK_g("Create Deck", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleLarge(), composer, 196614, 0, 65502);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-23, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f207lambda23 = ComposableLambdaKt.composableLambdaInstance(-1422968268, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-23$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1422968268, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-23.<anonymous> (ReviewTab.kt:253)");
            }
            TextKt.m2133Text4IGK_g("Deck name", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-24, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f208lambda24 = ComposableLambdaKt.composableLambdaInstance(820032520, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-24$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((i & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(820032520, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-24.<anonymous> (ReviewTab.kt:322)");
            }
            TextKt.m2133Text4IGK_g("Save", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-25, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f209lambda25 = ComposableLambdaKt.composableLambdaInstance(637590809, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-25$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            if ((i & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(637590809, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-25.<anonymous> (ReviewTab.kt:325)");
            }
            TextKt.m2133Text4IGK_g("Cancel", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1381getPrimary0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-26, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f210lambda26 = ComposableLambdaKt.composableLambdaInstance(653728936, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-26$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            if ((i & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(653728936, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-26.<anonymous> (ReviewTab.kt:520)");
            }
            TextKt.m2133Text4IGK_g("Cancel", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1381getPrimary0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-27, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f211lambda27 = ComposableLambdaKt.composableLambdaInstance(238589549, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-27$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(238589549, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-27.<anonymous> (ReviewTab.kt:356)");
                }
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(8));
                composer.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(composer, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m478spacedBy0680j_4, centerVertically, composer, 54);
                composer.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer m2947constructorimpl = Updater.m2947constructorimpl(composer);
                Updater.m2954setimpl(m2947constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2954setimpl(m2947constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m2947constructorimpl.getInserting() || !Intrinsics.areEqual(m2947constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m2947constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m2947constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                modifierMaterializerOf.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer)), composer, 0);
                composer.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                IconKt.m1605Iconww6aTOc(ShareKt.getShare(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1381getPrimary0d7_KjU(), composer, 48, 4);
                TextKt.m2133Text4IGK_g("Import CSV", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleLarge(), composer, 196614, 0, 65502);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-28, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f212lambda28 = ComposableLambdaKt.composableLambdaInstance(2087724395, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-28$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2087724395, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-28.<anonymous> (ReviewTab.kt:693)");
            }
            IconKt.m1605Iconww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), "Import APKG", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1381getPrimary0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-29, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f213lambda29 = ComposableLambdaKt.composableLambdaInstance(1110967980, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-29$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1110967980, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-29.<anonymous> (ReviewTab.kt:694)");
            }
            IconKt.m1605Iconww6aTOc(ShareKt.getShare(Icons.INSTANCE.getDefault()), "Import CSV", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1381getPrimary0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-30, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f215lambda30 = ComposableLambdaKt.composableLambdaInstance(1472643215, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-30$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1472643215, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-30.<anonymous> (ReviewTab.kt:696)");
            }
            IconKt.m1605Iconww6aTOc(RefreshKt.getRefresh(Icons.INSTANCE.getDefault()), HttpHeaders.REFRESH, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1381getPrimary0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-31, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f216lambda31 = ComposableLambdaKt.composableLambdaInstance(1429928465, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-31$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1429928465, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-31.<anonymous> (ReviewTab.kt:704)");
            }
            TextKt.m2133Text4IGK_g(TranslationManager.INSTANCE.getString("search_decks"), (Modifier) null, Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1376getOnSurfaceVariant0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-32, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f217lambda32 = ComposableLambdaKt.composableLambdaInstance(-313128976, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-32$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-313128976, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-32.<anonymous> (ReviewTab.kt:712)");
            }
            IconKt.m1605Iconww6aTOc(SearchKt.getSearch(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1376getOnSurfaceVariant0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-33, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f218lambda33 = ComposableLambdaKt.composableLambdaInstance(588546179, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-33$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((i & 81) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(588546179, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-33.<anonymous> (ReviewTab.kt:730)");
                }
                IconKt.m1605Iconww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1371getOnPrimary0d7_KjU(), composer, 48, 4);
                SpacerKt.Spacer(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(6)), composer, 6);
                TextKt.m2133Text4IGK_g("Import APKG", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1371getOnPrimary0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131066);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-34, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f219lambda34 = ComposableLambdaKt.composableLambdaInstance(-1379535814, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-34$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((i & 81) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1379535814, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-34.<anonymous> (ReviewTab.kt:742)");
                }
                IconKt.m1605Iconww6aTOc(ShareKt.getShare(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1374getOnSecondaryContainer0d7_KjU(), composer, 48, 4);
                SpacerKt.Spacer(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(6)), composer, 6);
                TextKt.m2133Text4IGK_g("Import CSV", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1374getOnSecondaryContainer0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131066);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-35, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f220lambda35 = ComposableLambdaKt.composableLambdaInstance(447327562, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-35$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(447327562, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-35.<anonymous> (ReviewTab.kt:1011)");
            }
            IconKt.m1605Iconww6aTOc(PlayArrowKt.getPlayArrow(Icons.INSTANCE.getDefault()), "Study", SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(18)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1381getPrimary0d7_KjU(), composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-36, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f221lambda36 = ComposableLambdaKt.composableLambdaInstance(1427161587, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-36$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1427161587, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-36.<anonymous> (ReviewTab.kt:1017)");
            }
            IconKt.m1605Iconww6aTOc(SettingsKt.getSettings(Icons.INSTANCE.getDefault()), "Settings", SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(16)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1384getSecondary0d7_KjU(), composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-37, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f222lambda37 = ComposableLambdaKt.composableLambdaInstance(-258044860, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-37$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-258044860, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-37.<anonymous> (ReviewTab.kt:1024)");
            }
            IconKt.m1605Iconww6aTOc(MoreVertKt.getMoreVert(Icons.INSTANCE.getDefault()), "Options", SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(16)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1376getOnSurfaceVariant0d7_KjU(), composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-38, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f223lambda38 = ComposableLambdaKt.composableLambdaInstance(-590200406, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-38$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-590200406, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-38.<anonymous> (ReviewTab.kt:1060)");
            }
            IconKt.m1605Iconww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), "Actions", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-39, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f224lambda39 = ComposableLambdaKt.composableLambdaInstance(678948075, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-39$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(678948075, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-39.<anonymous> (ReviewTab.kt:1067)");
            }
            TextKt.m2133Text4IGK_g("Import CSV", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-40, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f226lambda40 = ComposableLambdaKt.composableLambdaInstance(118935598, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-40$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(118935598, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-40.<anonymous> (ReviewTab.kt:1068)");
            }
            IconKt.m1605Iconww6aTOc(ShareKt.getShare(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1381getPrimary0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-41, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f227lambda41 = ComposableLambdaKt.composableLambdaInstance(-1811377694, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-41$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1811377694, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-41.<anonymous> (ReviewTab.kt:1072)");
            }
            TextKt.m2133Text4IGK_g("Import APKG", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-42, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f228lambda42 = ComposableLambdaKt.composableLambdaInstance(1182511205, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-42$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1182511205, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-42.<anonymous> (ReviewTab.kt:1073)");
            }
            IconKt.m1605Iconww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1381getPrimary0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-43, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f229lambda43 = ComposableLambdaKt.composableLambdaInstance(1894655075, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-43$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1894655075, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-43.<anonymous> (ReviewTab.kt:1077)");
            }
            TextKt.m2133Text4IGK_g("Import EPUB", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-44, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f230lambda44 = ComposableLambdaKt.composableLambdaInstance(593576678, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-44$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(593576678, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-44.<anonymous> (ReviewTab.kt:1078)");
            }
            IconKt.m1605Iconww6aTOc(BookKt.getBook(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1381getPrimary0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-45, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f231lambda45 = ComposableLambdaKt.composableLambdaInstance(1305720548, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-45$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1305720548, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-45.<anonymous> (ReviewTab.kt:1082)");
            }
            TextKt.m2133Text4IGK_g("Create New Deck", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-46, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f232lambda46 = ComposableLambdaKt.composableLambdaInstance(4642151, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-46$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(4642151, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-46.<anonymous> (ReviewTab.kt:1083)");
            }
            IconKt.m1605Iconww6aTOc(CreateNewFolderKt.getCreateNewFolder(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1381getPrimary0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-47, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f233lambda47 = ComposableLambdaKt.composableLambdaInstance(486947600, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-47$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            if ((i & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(486947600, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-47.<anonymous> (ReviewTab.kt:1117)");
            }
            TextKt.m2133Text4IGK_g("Close", (Modifier) null, ThemeKt.getPrimaryPurple(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-48, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f234lambda48 = ComposableLambdaKt.composableLambdaInstance(-1854369704, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-48$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1854369704, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-48.<anonymous> (ReviewTab.kt:1131)");
            }
            IconKt.m1605Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.INSTANCE.getDefault()), "Previous Month", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-49, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f235lambda49 = ComposableLambdaKt.composableLambdaInstance(-358641905, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-49$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-358641905, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-49.<anonymous> (ReviewTab.kt:1145)");
            }
            IconKt.m1605Iconww6aTOc(ArrowForwardKt.getArrowForward(Icons.INSTANCE.getDefault()), "Next Month", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-50, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f237lambda50 = ComposableLambdaKt.composableLambdaInstance(-27299478, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-50$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            if ((i & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-27299478, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-50.<anonymous> (ReviewTab.kt:1237)");
            }
            TextKt.m2133Text4IGK_g("Close", (Modifier) null, ThemeKt.getPrimaryPurple(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-51, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f238lambda51 = ComposableLambdaKt.composableLambdaInstance(-480790671, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-51$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-480790671, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-51.<anonymous> (ReviewTab.kt:1241)");
            }
            TextKt.m2133Text4IGK_g("Quiz History", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleMedium(), composer, 196614, 0, 65502);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-52, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f239lambda52 = ComposableLambdaKt.composableLambdaInstance(1775482539, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-52$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            TextStyle m5264copyp1EtxEg;
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1775482539, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-52.<anonymous> (ReviewTab.kt:1460)");
                }
                m5264copyp1EtxEg = r16.m5264copyp1EtxEg((r48 & 1) != 0 ? r16.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r16.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r16.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r16.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r16.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r16.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r16.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r16.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r16.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r16.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r16.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r16.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r16.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r16.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r16.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r16.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r16.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r16.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r16.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r16.platformStyle : null, (r48 & 1048576) != 0 ? r16.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r16.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r16.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelSmall().paragraphStyle.getTextMotion() : null);
                TextKt.m2133Text4IGK_g("FSRS Optimized", PaddingKt.m570paddingVpY3zN4(Modifier.INSTANCE, Dp.m5738constructorimpl(8), Dp.m5738constructorimpl(4)), ColorKt.Color(4283215696L), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg, composer, 438, 0, 65528);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-53, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f240lambda53 = ComposableLambdaKt.composableLambdaInstance(1285357049, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt$lambda-53$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((i & 81) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1285357049, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewTabKt.lambda-53.<anonymous> (ReviewTab.kt:1528)");
                }
                IconKt.m1605Iconww6aTOc(AutoAwesomeKt.getAutoAwesome(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(16)), 0L, composer, 432, 8);
                SpacerKt.Spacer(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(8)), composer, 6);
                TextKt.m2133Text4IGK_g("Generate Smart Review", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), composer, 6, 0, 65534);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: getLambda-1$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6246getLambda1$app_release() {
        return f192lambda1;
    }

    /* renamed from: getLambda-10$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6247getLambda10$app_release() {
        return f193lambda10;
    }

    /* renamed from: getLambda-11$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6248getLambda11$app_release() {
        return f194lambda11;
    }

    /* renamed from: getLambda-12$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6249getLambda12$app_release() {
        return f195lambda12;
    }

    /* renamed from: getLambda-13$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6250getLambda13$app_release() {
        return f196lambda13;
    }

    /* renamed from: getLambda-14$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6251getLambda14$app_release() {
        return f197lambda14;
    }

    /* renamed from: getLambda-15$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6252getLambda15$app_release() {
        return f198lambda15;
    }

    /* renamed from: getLambda-16$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6253getLambda16$app_release() {
        return f199lambda16;
    }

    /* renamed from: getLambda-17$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6254getLambda17$app_release() {
        return f200lambda17;
    }

    /* renamed from: getLambda-18$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6255getLambda18$app_release() {
        return f201lambda18;
    }

    /* renamed from: getLambda-19$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6256getLambda19$app_release() {
        return f202lambda19;
    }

    /* renamed from: getLambda-2$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6257getLambda2$app_release() {
        return f203lambda2;
    }

    /* renamed from: getLambda-20$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6258getLambda20$app_release() {
        return f204lambda20;
    }

    /* renamed from: getLambda-21$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6259getLambda21$app_release() {
        return f205lambda21;
    }

    /* renamed from: getLambda-22$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6260getLambda22$app_release() {
        return f206lambda22;
    }

    /* renamed from: getLambda-23$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6261getLambda23$app_release() {
        return f207lambda23;
    }

    /* renamed from: getLambda-24$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6262getLambda24$app_release() {
        return f208lambda24;
    }

    /* renamed from: getLambda-25$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6263getLambda25$app_release() {
        return f209lambda25;
    }

    /* renamed from: getLambda-26$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6264getLambda26$app_release() {
        return f210lambda26;
    }

    /* renamed from: getLambda-27$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6265getLambda27$app_release() {
        return f211lambda27;
    }

    /* renamed from: getLambda-28$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6266getLambda28$app_release() {
        return f212lambda28;
    }

    /* renamed from: getLambda-29$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6267getLambda29$app_release() {
        return f213lambda29;
    }

    /* renamed from: getLambda-3$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6268getLambda3$app_release() {
        return f214lambda3;
    }

    /* renamed from: getLambda-30$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6269getLambda30$app_release() {
        return f215lambda30;
    }

    /* renamed from: getLambda-31$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6270getLambda31$app_release() {
        return f216lambda31;
    }

    /* renamed from: getLambda-32$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6271getLambda32$app_release() {
        return f217lambda32;
    }

    /* renamed from: getLambda-33$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6272getLambda33$app_release() {
        return f218lambda33;
    }

    /* renamed from: getLambda-34$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6273getLambda34$app_release() {
        return f219lambda34;
    }

    /* renamed from: getLambda-35$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6274getLambda35$app_release() {
        return f220lambda35;
    }

    /* renamed from: getLambda-36$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6275getLambda36$app_release() {
        return f221lambda36;
    }

    /* renamed from: getLambda-37$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6276getLambda37$app_release() {
        return f222lambda37;
    }

    /* renamed from: getLambda-38$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6277getLambda38$app_release() {
        return f223lambda38;
    }

    /* renamed from: getLambda-39$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6278getLambda39$app_release() {
        return f224lambda39;
    }

    /* renamed from: getLambda-4$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6279getLambda4$app_release() {
        return f225lambda4;
    }

    /* renamed from: getLambda-40$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6280getLambda40$app_release() {
        return f226lambda40;
    }

    /* renamed from: getLambda-41$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6281getLambda41$app_release() {
        return f227lambda41;
    }

    /* renamed from: getLambda-42$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6282getLambda42$app_release() {
        return f228lambda42;
    }

    /* renamed from: getLambda-43$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6283getLambda43$app_release() {
        return f229lambda43;
    }

    /* renamed from: getLambda-44$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6284getLambda44$app_release() {
        return f230lambda44;
    }

    /* renamed from: getLambda-45$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6285getLambda45$app_release() {
        return f231lambda45;
    }

    /* renamed from: getLambda-46$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6286getLambda46$app_release() {
        return f232lambda46;
    }

    /* renamed from: getLambda-47$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6287getLambda47$app_release() {
        return f233lambda47;
    }

    /* renamed from: getLambda-48$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6288getLambda48$app_release() {
        return f234lambda48;
    }

    /* renamed from: getLambda-49$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6289getLambda49$app_release() {
        return f235lambda49;
    }

    /* renamed from: getLambda-5$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6290getLambda5$app_release() {
        return f236lambda5;
    }

    /* renamed from: getLambda-50$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6291getLambda50$app_release() {
        return f237lambda50;
    }

    /* renamed from: getLambda-51$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6292getLambda51$app_release() {
        return f238lambda51;
    }

    /* renamed from: getLambda-52$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6293getLambda52$app_release() {
        return f239lambda52;
    }

    /* renamed from: getLambda-53$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6294getLambda53$app_release() {
        return f240lambda53;
    }

    /* renamed from: getLambda-6$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6295getLambda6$app_release() {
        return f241lambda6;
    }

    /* renamed from: getLambda-7$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6296getLambda7$app_release() {
        return f242lambda7;
    }

    /* renamed from: getLambda-8$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6297getLambda8$app_release() {
        return f243lambda8;
    }

    /* renamed from: getLambda-9$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6298getLambda9$app_release() {
        return f244lambda9;
    }
}
