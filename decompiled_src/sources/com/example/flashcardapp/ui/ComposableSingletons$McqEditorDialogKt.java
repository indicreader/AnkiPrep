package com.example.flashcardapp.ui;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.DeleteKt;
import androidx.compose.material.icons.outlined.ImageKt;
import androidx.compose.material.icons.outlined.SearchKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: McqEditorDialog.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ComposableSingletons$McqEditorDialogKt {
    public static final ComposableSingletons$McqEditorDialogKt INSTANCE = new ComposableSingletons$McqEditorDialogKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f102lambda1 = ComposableLambdaKt.composableLambdaInstance(-979453545, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope OutlinedButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
            if ((i & 81) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-979453545, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt.lambda-1.<anonymous> (McqEditorDialog.kt:116)");
                }
                IconKt.m1605Iconww6aTOc(ImageKt.getImage(Icons.Outlined.INSTANCE), (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(16)), 0L, composer, 432, 8);
                SpacerKt.Spacer(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(4)), composer, 6);
                TextKt.m2133Text4IGK_g("Gallery", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 3072, 122878);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f110lambda2 = ComposableLambdaKt.composableLambdaInstance(-62347392, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope OutlinedButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
            if ((i & 81) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-62347392, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt.lambda-2.<anonymous> (McqEditorDialog.kt:128)");
                }
                IconKt.m1605Iconww6aTOc(SearchKt.getSearch(Icons.Outlined.INSTANCE), (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(16)), 0L, composer, 432, 8);
                SpacerKt.Spacer(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(4)), composer, 6);
                TextKt.m2133Text4IGK_g("Search Web", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 3072, 122878);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f111lambda3 = ComposableLambdaKt.composableLambdaInstance(-2087416666, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt$lambda-3$1
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
                ComposerKt.traceEventStart(-2087416666, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt.lambda-3.<anonymous> (McqEditorDialog.kt:275)");
            }
            TextKt.m2133Text4IGK_g("One-Liner", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-4, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f112lambda4 = ComposableLambdaKt.composableLambdaInstance(-1509179363, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt$lambda-4$1
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
                ComposerKt.traceEventStart(-1509179363, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt.lambda-4.<anonymous> (McqEditorDialog.kt:285)");
            }
            TextKt.m2133Text4IGK_g("MCQ", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-5, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f113lambda5 = ComposableLambdaKt.composableLambdaInstance(2102765282, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt$lambda-5$1
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
                ComposerKt.traceEventStart(2102765282, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt.lambda-5.<anonymous> (McqEditorDialog.kt:299)");
            }
            TextKt.m2133Text4IGK_g("Tags (comma-separated)", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-6, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f114lambda6 = ComposableLambdaKt.composableLambdaInstance(-1263041919, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt$lambda-6$1
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
                ComposerKt.traceEventStart(-1263041919, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt.lambda-6.<anonymous> (McqEditorDialog.kt:301)");
            }
            TextKt.m2133Text4IGK_g("e.g. geography, capitals", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-7, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f115lambda7 = ComposableLambdaKt.composableLambdaInstance(66454169, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt$lambda-7$1
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
                ComposerKt.traceEventStart(66454169, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt.lambda-7.<anonymous> (McqEditorDialog.kt:307)");
            }
            TextKt.m2133Text4IGK_g("Question", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-8, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f116lambda8 = ComposableLambdaKt.composableLambdaInstance(-1170403878, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt$lambda-8$1
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
                ComposerKt.traceEventStart(-1170403878, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt.lambda-8.<anonymous> (McqEditorDialog.kt:323)");
            }
            TextKt.m2133Text4IGK_g("Correct Answer", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-9, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f117lambda9 = ComposableLambdaKt.composableLambdaInstance(-914409283, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt$lambda-9$1
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
                ComposerKt.traceEventStart(-914409283, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt.lambda-9.<anonymous> (McqEditorDialog.kt:339)");
            }
            TextKt.m2133Text4IGK_g("Distractors (one per line)", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-10, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f103lambda10 = ComposableLambdaKt.composableLambdaInstance(-1724030966, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt$lambda-10$1
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
                ComposerKt.traceEventStart(-1724030966, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt.lambda-10.<anonymous> (McqEditorDialog.kt:354)");
            }
            IconKt.m1605Iconww6aTOc(DeleteKt.getDelete(Icons.Outlined.INSTANCE), "Delete", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1363getError0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-11, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f104lambda11 = ComposableLambdaKt.composableLambdaInstance(292950576, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt$lambda-11$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope OutlinedButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
            if ((i & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(292950576, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt.lambda-11.<anonymous> (McqEditorDialog.kt:370)");
            }
            TextKt.m2133Text4IGK_g("+ Add Distractor Image", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-12, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f105lambda12 = ComposableLambdaKt.composableLambdaInstance(1887705371, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt$lambda-12$1
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
                ComposerKt.traceEventStart(1887705371, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt.lambda-12.<anonymous> (McqEditorDialog.kt:378)");
            }
            TextKt.m2133Text4IGK_g("Explanation (optional)", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-13, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f106lambda13 = ComposableLambdaKt.composableLambdaInstance(-1007969671, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt$lambda-13$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope OutlinedButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
            if ((i & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1007969671, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt.lambda-13.<anonymous> (McqEditorDialog.kt:410)");
            }
            TextKt.m2133Text4IGK_g("Previous", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 3072, 122878);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-14, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f107lambda14 = ComposableLambdaKt.composableLambdaInstance(250198000, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt$lambda-14$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope OutlinedButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
            if ((i & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(250198000, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt.lambda-14.<anonymous> (McqEditorDialog.kt:420)");
            }
            TextKt.m2133Text4IGK_g("Next", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 3072, 122878);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-15, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f108lambda15 = ComposableLambdaKt.composableLambdaInstance(1440965059, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt$lambda-15$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope OutlinedButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
            if ((i & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1440965059, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt.lambda-15.<anonymous> (McqEditorDialog.kt:445)");
            }
            TextKt.m2133Text4IGK_g("Cancel", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 3072, 122878);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-16, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f109lambda16 = ComposableLambdaKt.composableLambdaInstance(-764211263, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt$lambda-16$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((i & 81) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-764211263, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$McqEditorDialogKt.lambda-16.<anonymous> (McqEditorDialog.kt:456)");
                }
                String string = TranslationManager.INSTANCE.getString("save");
                if (string.length() <= 0) {
                    string = null;
                }
                if (string == null) {
                    string = "Save";
                }
                TextKt.m2133Text4IGK_g(string, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 3072, 122878);
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
    public final Function3<RowScope, Composer, Integer, Unit> m6156getLambda1$app_release() {
        return f102lambda1;
    }

    /* renamed from: getLambda-10$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6157getLambda10$app_release() {
        return f103lambda10;
    }

    /* renamed from: getLambda-11$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6158getLambda11$app_release() {
        return f104lambda11;
    }

    /* renamed from: getLambda-12$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6159getLambda12$app_release() {
        return f105lambda12;
    }

    /* renamed from: getLambda-13$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6160getLambda13$app_release() {
        return f106lambda13;
    }

    /* renamed from: getLambda-14$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6161getLambda14$app_release() {
        return f107lambda14;
    }

    /* renamed from: getLambda-15$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6162getLambda15$app_release() {
        return f108lambda15;
    }

    /* renamed from: getLambda-16$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6163getLambda16$app_release() {
        return f109lambda16;
    }

    /* renamed from: getLambda-2$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6164getLambda2$app_release() {
        return f110lambda2;
    }

    /* renamed from: getLambda-3$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6165getLambda3$app_release() {
        return f111lambda3;
    }

    /* renamed from: getLambda-4$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6166getLambda4$app_release() {
        return f112lambda4;
    }

    /* renamed from: getLambda-5$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6167getLambda5$app_release() {
        return f113lambda5;
    }

    /* renamed from: getLambda-6$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6168getLambda6$app_release() {
        return f114lambda6;
    }

    /* renamed from: getLambda-7$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6169getLambda7$app_release() {
        return f115lambda7;
    }

    /* renamed from: getLambda-8$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6170getLambda8$app_release() {
        return f116lambda8;
    }

    /* renamed from: getLambda-9$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6171getLambda9$app_release() {
        return f117lambda9;
    }
}
