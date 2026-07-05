package androidx.compose.material3.pulltorefresh;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: PullToRefresh.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ComposableSingletons$PullToRefreshKt {
    public static final ComposableSingletons$PullToRefreshKt INSTANCE = new ComposableSingletons$PullToRefreshKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<PullToRefreshState, Composer, Integer, Unit> f48lambda1 = ComposableLambdaKt.composableLambdaInstance(1116780789, false, new Function3<PullToRefreshState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.ComposableSingletons$PullToRefreshKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(PullToRefreshState pullToRefreshState, Composer composer, Integer num) {
            invoke(pullToRefreshState, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(PullToRefreshState pullToRefreshState, Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C110@4798L35:PullToRefresh.kt#djiw08");
            if ((i & 6) == 0) {
                i |= composer.changed(pullToRefreshState) ? 4 : 2;
            }
            if ((i & 19) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1116780789, i, -1, "androidx.compose.material3.pulltorefresh.ComposableSingletons$PullToRefreshKt.lambda-1.<anonymous> (PullToRefresh.kt:110)");
            }
            PullToRefreshDefaults.INSTANCE.m2299IndicatorFNF3uiM(pullToRefreshState, null, 0L, composer, (i & 14) | 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$material3_release, reason: not valid java name */
    public final Function3<PullToRefreshState, Composer, Integer, Unit> m2298getLambda1$material3_release() {
        return f48lambda1;
    }
}
