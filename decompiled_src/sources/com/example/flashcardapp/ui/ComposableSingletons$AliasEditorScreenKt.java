package com.example.flashcardapp.ui;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.AddKt;
import androidx.compose.material.icons.outlined.ArrowBackKt;
import androidx.compose.material.icons.outlined.DeleteKt;
import androidx.compose.material.icons.outlined.EditKt;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AliasEditorScreen.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ComposableSingletons$AliasEditorScreenKt {
    public static final ComposableSingletons$AliasEditorScreenKt INSTANCE = new ComposableSingletons$AliasEditorScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f69lambda1 = ComposableLambdaKt.composableLambdaInstance(1321082812, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$AliasEditorScreenKt$lambda-1$1
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
                ComposerKt.traceEventStart(1321082812, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$AliasEditorScreenKt.lambda-1.<anonymous> (AliasEditorScreen.kt:38)");
            }
            TextKt.m2133Text4IGK_g("Alias Matrix Editor", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 196614, 0, 131038);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f70lambda2 = ComposableLambdaKt.composableLambdaInstance(-205938115, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$AliasEditorScreenKt$lambda-2$1
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
                ComposerKt.traceEventStart(-205938115, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$AliasEditorScreenKt.lambda-2.<anonymous> (AliasEditorScreen.kt:41)");
            }
            IconKt.m1605Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.Outlined.INSTANCE), "Back", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f71lambda3 = ComposableLambdaKt.composableLambdaInstance(-1360151547, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$AliasEditorScreenKt$lambda-3$1
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
                ComposerKt.traceEventStart(-1360151547, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$AliasEditorScreenKt.lambda-3.<anonymous> (AliasEditorScreen.kt:53)");
            }
            IconKt.m1605Iconww6aTOc(AddKt.getAdd(Icons.Outlined.INSTANCE), "Add Alias", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f72lambda4 = ComposableLambdaKt.composableLambdaInstance(21509821, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$AliasEditorScreenKt$lambda-4$1
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
                ComposerKt.traceEventStart(21509821, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$AliasEditorScreenKt.lambda-4.<anonymous> (AliasEditorScreen.kt:123)");
            }
            IconKt.m1605Iconww6aTOc(EditKt.getEdit(Icons.Outlined.INSTANCE), "Edit", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1381getPrimary0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-5, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f73lambda5 = ComposableLambdaKt.composableLambdaInstance(-938203418, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$AliasEditorScreenKt$lambda-5$1
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
                ComposerKt.traceEventStart(-938203418, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$AliasEditorScreenKt.lambda-5.<anonymous> (AliasEditorScreen.kt:126)");
            }
            IconKt.m1605Iconww6aTOc(DeleteKt.getDelete(Icons.Outlined.INSTANCE), "Delete", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1363getError0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-6, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f74lambda6 = ComposableLambdaKt.composableLambdaInstance(1304583647, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$AliasEditorScreenKt$lambda-6$1
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
                ComposerKt.traceEventStart(1304583647, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$AliasEditorScreenKt.lambda-6.<anonymous> (AliasEditorScreen.kt:177)");
            }
            TextKt.m2133Text4IGK_g("Save", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-7, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f75lambda7 = ComposableLambdaKt.composableLambdaInstance(752534704, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$AliasEditorScreenKt$lambda-7$1
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
                ComposerKt.traceEventStart(752534704, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$AliasEditorScreenKt.lambda-7.<anonymous> (AliasEditorScreen.kt:187)");
            }
            TextKt.m2133Text4IGK_g("Cancel", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-8, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f76lambda8 = ComposableLambdaKt.composableLambdaInstance(481259866, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$AliasEditorScreenKt$lambda-8$1
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
                ComposerKt.traceEventStart(481259866, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$AliasEditorScreenKt.lambda-8.<anonymous> (AliasEditorScreen.kt:152)");
            }
            TextKt.m2133Text4IGK_g("Target Word", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-9, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f77lambda9 = ComposableLambdaKt.composableLambdaInstance(-1193460285, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$AliasEditorScreenKt$lambda-9$1
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
                ComposerKt.traceEventStart(-1193460285, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$AliasEditorScreenKt.lambda-9.<anonymous> (AliasEditorScreen.kt:158)");
            }
            TextKt.m2133Text4IGK_g("Alias Configurations", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6123getLambda1$app_release() {
        return f69lambda1;
    }

    /* renamed from: getLambda-2$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6124getLambda2$app_release() {
        return f70lambda2;
    }

    /* renamed from: getLambda-3$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6125getLambda3$app_release() {
        return f71lambda3;
    }

    /* renamed from: getLambda-4$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6126getLambda4$app_release() {
        return f72lambda4;
    }

    /* renamed from: getLambda-5$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6127getLambda5$app_release() {
        return f73lambda5;
    }

    /* renamed from: getLambda-6$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6128getLambda6$app_release() {
        return f74lambda6;
    }

    /* renamed from: getLambda-7$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6129getLambda7$app_release() {
        return f75lambda7;
    }

    /* renamed from: getLambda-8$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6130getLambda8$app_release() {
        return f76lambda8;
    }

    /* renamed from: getLambda-9$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6131getLambda9$app_release() {
        return f77lambda9;
    }
}
