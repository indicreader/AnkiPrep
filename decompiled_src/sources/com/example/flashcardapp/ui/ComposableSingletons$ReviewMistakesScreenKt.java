package com.example.flashcardapp.ui;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.ArrowBackKt;
import androidx.compose.material.icons.outlined.EditKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.ui.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: ReviewMistakesScreen.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ComposableSingletons$ReviewMistakesScreenKt {
    public static final ComposableSingletons$ReviewMistakesScreenKt INSTANCE = new ComposableSingletons$ReviewMistakesScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f190lambda1 = ComposableLambdaKt.composableLambdaInstance(-1490095278, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewMistakesScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1490095278, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewMistakesScreenKt.lambda-1.<anonymous> (ReviewMistakesScreen.kt:72)");
                }
                IconKt.m1605Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, ThemeKt.getPrimaryPurple(), composer, 48, 4);
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
    public static Function2<Composer, Integer, Unit> f191lambda2 = ComposableLambdaKt.composableLambdaInstance(2031182332, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ComposableSingletons$ReviewMistakesScreenKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2031182332, i, -1, "com.example.flashcardapp.ui.ComposableSingletons$ReviewMistakesScreenKt.lambda-2.<anonymous> (ReviewMistakesScreen.kt:326)");
                }
                IconKt.m1605Iconww6aTOc(EditKt.getEdit(Icons.Outlined.INSTANCE), "Edit", SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(18)), ThemeKt.getPrimaryPurple(), composer, 432, 0);
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
    public final Function2<Composer, Integer, Unit> m6244getLambda1$app_release() {
        return f190lambda1;
    }

    /* renamed from: getLambda-2$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6245getLambda2$app_release() {
        return f191lambda2;
    }
}
