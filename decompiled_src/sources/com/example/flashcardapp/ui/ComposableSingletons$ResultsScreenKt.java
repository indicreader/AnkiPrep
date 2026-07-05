package com.example.flashcardapp.ui;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.HomeKt;
import androidx.compose.material.icons.outlined.RefreshKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResultsScreen.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ComposableSingletons$ResultsScreenKt {
    public static final ComposableSingletons$ResultsScreenKt INSTANCE = new ComposableSingletons$ResultsScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f188lambda1 = ComposableLambdaKt.composableLambdaInstance(-806738262, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ResultsScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((i & 81) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-806738262, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ResultsScreenKt.lambda-1.<anonymous> (ResultsScreen.kt:348)");
                }
                IconKt.m1605Iconww6aTOc(RefreshKt.getRefresh(Icons.Outlined.INSTANCE), (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(20)), 0L, composer, 432, 8);
                SpacerKt.Spacer(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(8)), composer, 6);
                TextKt.m2133Text4IGK_g(TranslationManager.INSTANCE.getString("study_again"), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), composer, 0, 0, 65534);
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
    public static Function3<RowScope, Composer, Integer, Unit> f189lambda2 = ComposableLambdaKt.composableLambdaInstance(-1392968404, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ResultsScreenKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope OutlinedButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
            if ((i & 81) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1392968404, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ResultsScreenKt.lambda-2.<anonymous> (ResultsScreen.kt:360)");
                }
                IconKt.m1605Iconww6aTOc(HomeKt.getHome(Icons.Outlined.INSTANCE), (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(20)), 0L, composer, 432, 8);
                SpacerKt.Spacer(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(8)), composer, 6);
                TextKt.m2133Text4IGK_g(TranslationManager.INSTANCE.getString("back_to_decks"), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), composer, 0, 0, 65534);
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
    public final Function3<RowScope, Composer, Integer, Unit> m6242getLambda1$app_release() {
        return f188lambda1;
    }

    /* renamed from: getLambda-2$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6243getLambda2$app_release() {
        return f189lambda2;
    }
}
