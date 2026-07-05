package androidx.navigation.compose;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.ComposeNavGraphNavigator;
import androidx.navigation.compose.ComposeNavigator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavHost.kt */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001aµ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u001f\b\u0002\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u00102\u001f\b\u0002\u0010\u0011\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00120\f¢\u0006\u0002\b\u00102\u001f\b\u0002\u0010\u0013\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u00102\u001f\b\u0002\u0010\u0014\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00120\f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0015\u001aÚ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u001f\b\u0002\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u00102\u001f\b\u0002\u0010\u0011\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00120\f¢\u0006\u0002\b\u00102\u001f\b\u0002\u0010\u0013\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u00102\u001f\b\u0002\u0010\u0014\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00120\f¢\u0006\u0002\b\u00102\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001b\u001aL\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001c\u001a\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u000f*\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002\u001a\u001c\u0010 \u001a\u0004\u0018\u00010\u0012*\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002\u001a\u001c\u0010!\u001a\u0004\u0018\u00010\u000f*\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002\u001a\u001c\u0010\"\u001a\u0004\u0018\u00010\u0012*\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¨\u0006#²\u0006\u0010\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0%X\u008a\u0084\u0002²\u0006\u0010\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0%X\u008a\u0084\u0002²\u0006\u0010\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0%X\u008a\u0084\u0002"}, d2 = {"NavHost", "", "navController", "Landroidx/navigation/NavHostController;", "graph", "Landroidx/navigation/NavGraph;", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "contentAlignment", "Landroidx/compose/ui/Alignment;", "enterTransition", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/animation/EnterTransition;", "Lkotlin/ExtensionFunctionType;", "exitTransition", "Landroidx/compose/animation/ExitTransition;", "popEnterTransition", "popExitTransition", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "startDestination", "", "route", "builder", "Landroidx/navigation/NavGraphBuilder;", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "createEnterTransition", "Landroidx/navigation/NavDestination;", "scope", "createExitTransition", "createPopEnterTransition", "createPopExitTransition", "navigation-compose_release", "currentBackStack", "", "allVisibleEntries", "visibleEntries"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class NavHostKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports AnimatedContent")
    public static final /* synthetic */ void NavHost(final NavHostController navHostController, final String str, Modifier modifier, String str2, final Function1 function1, Composer composer, final int i, final int i2) {
        Composer startRestartGroup = composer.startRestartGroup(141827520);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavHost)P(2,4,1,3)83@3291L126,81@3251L190:NavHost.kt#opm8kd");
        final Modifier.Companion companion = (i2 & 4) != 0 ? Modifier.INSTANCE : modifier;
        final String str3 = (i2 & 8) != 0 ? null : str2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(141827520, i, -1, "androidx.navigation.compose.NavHost (NavHost.kt:80)");
        }
        startRestartGroup.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = startRestartGroup.changed(str3) | startRestartGroup.changed(str) | startRestartGroup.changed(function1);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHostController.get_navigatorProvider(), str, str3);
            function1.invoke(navGraphBuilder);
            rememberedValue = navGraphBuilder.build();
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        NavHost(navHostController, (NavGraph) rememberedValue, companion, null, null, null, null, null, startRestartGroup, (i & 896) | 72, 248);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$2
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

            public final void invoke(Composer composer2, int i3) {
                NavHostKt.NavHost(NavHostController.this, str, companion, str3, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }

    public static final void NavHost(final NavHostController navHostController, final String str, Modifier modifier, Alignment alignment, String str2, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function1, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function12, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function13, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function14, final Function1<? super NavGraphBuilder, Unit> function15, Composer composer, final int i, final int i2) {
        Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function16;
        int i3;
        Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function17;
        Composer startRestartGroup = composer.startRestartGroup(410432995);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavHost)P(5,9,4,1,8,2,3,6,7)129@5380L126,127@5340L320:NavHost.kt#opm8kd");
        final Modifier.Companion companion = (i2 & 4) != 0 ? Modifier.INSTANCE : modifier;
        final Alignment center = (i2 & 8) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        final String str3 = (i2 & 16) != 0 ? null : str2;
        final NavHostKt$NavHost$3 navHostKt$NavHost$3 = (i2 & 32) != 0 ? new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$3
            @Override // kotlin.jvm.functions.Function1
            public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
            }
        } : function1;
        final NavHostKt$NavHost$4 navHostKt$NavHost$4 = (i2 & 64) != 0 ? new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$4
            @Override // kotlin.jvm.functions.Function1
            public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
            }
        } : function12;
        if ((i2 & 128) != 0) {
            i3 = i & (-29360129);
            function16 = navHostKt$NavHost$3;
        } else {
            function16 = function13;
            i3 = i;
        }
        if ((i2 & 256) != 0) {
            i3 &= -234881025;
            function17 = navHostKt$NavHost$4;
        } else {
            function17 = function14;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(410432995, i3, -1, "androidx.navigation.compose.NavHost (NavHost.kt:126)");
        }
        startRestartGroup.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = startRestartGroup.changed(str3) | startRestartGroup.changed(str) | startRestartGroup.changed(function15);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHostController.get_navigatorProvider(), str, str3);
            function15.invoke(navGraphBuilder);
            rememberedValue = navGraphBuilder.build();
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        int i4 = (i3 & 896) | 72 | (i3 & 7168);
        int i5 = i3 >> 3;
        NavHost(navHostController, (NavGraph) rememberedValue, companion, center, navHostKt$NavHost$3, navHostKt$NavHost$4, function16, function17, startRestartGroup, i4 | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (i5 & 29360128), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function18 = function16;
        final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function19 = function17;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$6
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

            public final void invoke(Composer composer2, int i6) {
                NavHostKt.NavHost(NavHostController.this, str, companion, center, str3, navHostKt$NavHost$3, navHostKt$NavHost$4, function18, function19, function15, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports AnimatedContent")
    public static final /* synthetic */ void NavHost(final NavHostController navHostController, final NavGraph navGraph, Modifier modifier, Composer composer, final int i, final int i2) {
        Composer startRestartGroup = composer.startRestartGroup(-957014592);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavHost)P(2)163@6434L39:NavHost.kt#opm8kd");
        final Modifier modifier2 = (i2 & 4) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-957014592, i, -1, "androidx.navigation.compose.NavHost (NavHost.kt:163)");
        }
        NavHost(navHostController, navGraph, modifier2, null, null, null, null, null, startRestartGroup, (i & 896) | 72, 248);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$7
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
                NavHostKt.NavHost(NavHostController.this, navGraph, modifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }

    public static final void NavHost(final NavHostController navHostController, final NavGraph navGraph, Modifier modifier, Alignment alignment, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function1, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function12, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function13, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function14, Composer composer, final int i, final int i2) {
        final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function15;
        int i3;
        final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function16;
        Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function17;
        DialogNavigator dialogNavigator;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-1818191915);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavHost)P(5,3,4)197@8123L7,*198@8199L7,213@8790L16,215@8812L83,219@8901L172,225@9105L29,227@9194L16,230@9299L186,240@9580L42,334@14081L27:NavHost.kt#opm8kd");
        final Modifier.Companion companion = (i2 & 4) != 0 ? Modifier.INSTANCE : modifier;
        final Alignment center = (i2 & 8) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        final NavHostKt$NavHost$8 navHostKt$NavHost$8 = (i2 & 16) != 0 ? new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$8
            @Override // kotlin.jvm.functions.Function1
            public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
            }
        } : function1;
        final NavHostKt$NavHost$9 navHostKt$NavHost$9 = (i2 & 32) != 0 ? new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$9
            @Override // kotlin.jvm.functions.Function1
            public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
            }
        } : function12;
        if ((i2 & 64) != 0) {
            i3 = i & (-3670017);
            function15 = navHostKt$NavHost$8;
        } else {
            function15 = function13;
            i3 = i;
        }
        if ((i2 & 128) != 0) {
            i3 &= -29360129;
            function16 = navHostKt$NavHost$9;
        } else {
            function16 = function14;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1818191915, i3, -1, "androidx.navigation.compose.NavHost (NavHost.kt:195)");
        }
        ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(localLifecycleOwner);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final LifecycleOwner lifecycleOwner = (LifecycleOwner) consume;
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, LocalViewModelStoreOwner.$stable);
        if (current == null) {
            throw new IllegalStateException("NavHost requires a ViewModelStoreOwner to be provided via LocalViewModelStoreOwner".toString());
        }
        navHostController.setViewModelStore(current.getViewModelStore());
        navHostController.setGraph(navGraph);
        Navigator navigator = navHostController.get_navigatorProvider().getNavigator(ComposeNavigator.NAME);
        final ComposeNavigator composeNavigator = navigator instanceof ComposeNavigator ? (ComposeNavigator) navigator : null;
        if (composeNavigator == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function18 = function15;
            final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function19 = function16;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$composeNavigator$1
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

                public final void invoke(Composer composer2, int i5) {
                    NavHostKt.NavHost(NavHostController.this, navGraph, companion, center, navHostKt$NavHost$8, navHostKt$NavHost$9, function18, function19, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
            return;
        }
        BackHandlerKt.BackHandler(NavHost$lambda$3(SnapshotStateKt.collectAsState(composeNavigator.getBackStack(), null, startRestartGroup, 8, 1)).size() > 1, new Function0<Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$10
            /* JADX INFO: Access modifiers changed from: package-private */
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
                NavHostController.this.popBackStack();
            }
        }, startRestartGroup, 0, 0);
        EffectsKt.DisposableEffect(lifecycleOwner, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$11
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                NavHostController.this.setLifecycleOwner(lifecycleOwner);
                return new DisposableEffectResult() { // from class: androidx.navigation.compose.NavHostKt$NavHost$11$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                    }
                };
            }
        }, startRestartGroup, 8);
        final SaveableStateHolder rememberSaveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder(startRestartGroup, 0);
        final State collectAsState = SnapshotStateKt.collectAsState(navHostController.getVisibleEntries(), null, startRestartGroup, 8, 1);
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt.derivedStateOf(new Function0<List<? extends NavBackStackEntry>>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$visibleEntries$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends NavBackStackEntry> invoke() {
                    List NavHost$lambda$4;
                    NavHost$lambda$4 = NavHostKt.NavHost$lambda$4(collectAsState);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : NavHost$lambda$4) {
                        if (Intrinsics.areEqual(((NavBackStackEntry) obj).getDestination().getNavigatorName(), ComposeNavigator.NAME)) {
                            arrayList.add(obj);
                        }
                    }
                    return arrayList;
                }
            });
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final State state = (State) rememberedValue;
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) CollectionsKt.lastOrNull((List) NavHost$lambda$6(state));
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = (Map) new LinkedHashMap();
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        final Map map = (Map) rememberedValue2;
        startRestartGroup.startReplaceableGroup(1822177954);
        ComposerKt.sourceInformation(startRestartGroup, "243@9756L577,257@10431L577,271@11035L49,272@11104L2105,310@13218L441,320@13691L182,320@13668L205");
        if (navBackStackEntry != null) {
            startRestartGroup.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed(composeNavigator) | startRestartGroup.changed(function15) | startRestartGroup.changed(navHostKt$NavHost$8);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = (Function1) new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$finalEnter$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                        EnterTransition createEnterTransition;
                        EnterTransition createPopEnterTransition;
                        NavDestination destination = animatedContentTransitionScope.getTargetState().getDestination();
                        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
                        ComposeNavigator.Destination destination2 = (ComposeNavigator.Destination) destination;
                        EnterTransition enterTransition = null;
                        if (ComposeNavigator.this.isPop$navigation_compose_release().getValue().booleanValue()) {
                            Iterator<NavDestination> it = NavDestination.INSTANCE.getHierarchy(destination2).iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                createPopEnterTransition = NavHostKt.createPopEnterTransition(it.next(), animatedContentTransitionScope);
                                if (createPopEnterTransition != null) {
                                    enterTransition = createPopEnterTransition;
                                    break;
                                }
                            }
                            return enterTransition == null ? function15.invoke(animatedContentTransitionScope) : enterTransition;
                        }
                        Iterator<NavDestination> it2 = NavDestination.INSTANCE.getHierarchy(destination2).iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            createEnterTransition = NavHostKt.createEnterTransition(it2.next(), animatedContentTransitionScope);
                            if (createEnterTransition != null) {
                                enterTransition = createEnterTransition;
                                break;
                            }
                        }
                        return enterTransition == null ? navHostKt$NavHost$8.invoke(animatedContentTransitionScope) : enterTransition;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            final Function1 function110 = (Function1) rememberedValue3;
            startRestartGroup.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(composeNavigator) | startRestartGroup.changed(function16) | startRestartGroup.changed(navHostKt$NavHost$9);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = (Function1) new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$finalExit$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                        ExitTransition createExitTransition;
                        ExitTransition createPopExitTransition;
                        NavDestination destination = animatedContentTransitionScope.getInitialState().getDestination();
                        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
                        ComposeNavigator.Destination destination2 = (ComposeNavigator.Destination) destination;
                        ExitTransition exitTransition = null;
                        if (ComposeNavigator.this.isPop$navigation_compose_release().getValue().booleanValue()) {
                            Iterator<NavDestination> it = NavDestination.INSTANCE.getHierarchy(destination2).iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                createPopExitTransition = NavHostKt.createPopExitTransition(it.next(), animatedContentTransitionScope);
                                if (createPopExitTransition != null) {
                                    exitTransition = createPopExitTransition;
                                    break;
                                }
                            }
                            return exitTransition == null ? function16.invoke(animatedContentTransitionScope) : exitTransition;
                        }
                        Iterator<NavDestination> it2 = NavDestination.INSTANCE.getHierarchy(destination2).iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            createExitTransition = NavHostKt.createExitTransition(it2.next(), animatedContentTransitionScope);
                            if (createExitTransition != null) {
                                exitTransition = createExitTransition;
                                break;
                            }
                        }
                        return exitTransition == null ? navHostKt$NavHost$9.invoke(animatedContentTransitionScope) : exitTransition;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceableGroup();
            final Function1 function111 = (Function1) rememberedValue4;
            function17 = function16;
            i4 = 0;
            Transition updateTransition = TransitionKt.updateTransition(navBackStackEntry, "entry", startRestartGroup, 56, 0);
            final ComposeNavigator composeNavigator2 = composeNavigator;
            int i5 = ((i3 >> 3) & 112) | 221184 | (i3 & 7168);
            dialogNavigator = null;
            final ComposeNavigator composeNavigator3 = composeNavigator;
            AnimatedContentKt.AnimatedContent(updateTransition, companion, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ContentTransform>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$12
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final ContentTransform invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                    List NavHost$lambda$6;
                    float f;
                    NavHost$lambda$6 = NavHostKt.NavHost$lambda$6(state);
                    if (NavHost$lambda$6.contains(animatedContentTransitionScope.getInitialState())) {
                        Float f2 = map.get(animatedContentTransitionScope.getInitialState().getId());
                        if (f2 != null) {
                            f = f2.floatValue();
                        } else {
                            map.put(animatedContentTransitionScope.getInitialState().getId(), Float.valueOf(0.0f));
                            f = 0.0f;
                        }
                        if (!Intrinsics.areEqual(animatedContentTransitionScope.getTargetState().getId(), animatedContentTransitionScope.getInitialState().getId())) {
                            f = composeNavigator2.isPop$navigation_compose_release().getValue().booleanValue() ? f - 1.0f : f + 1.0f;
                        }
                        float f3 = f;
                        map.put(animatedContentTransitionScope.getTargetState().getId(), Float.valueOf(f3));
                        return new ContentTransform(function110.invoke(animatedContentTransitionScope), function111.invoke(animatedContentTransitionScope), f3, null, 8, null);
                    }
                    return AnimatedContentKt.togetherWith(EnterTransition.INSTANCE.getNone(), ExitTransition.INSTANCE.getNone());
                }
            }, center, new Function1<NavBackStackEntry, Object>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(NavBackStackEntry navBackStackEntry2) {
                    return navBackStackEntry2.getId();
                }
            }, ComposableLambdaKt.composableLambda(startRestartGroup, -1440061047, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$14
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry2, Composer composer2, Integer num) {
                    invoke(animatedContentScope, navBackStackEntry2, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry2, Composer composer2, int i6) {
                    List NavHost$lambda$6;
                    Object obj;
                    ComposerKt.sourceInformation(composer2, "C305@13019L180:NavHost.kt#opm8kd");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1440061047, i6, -1, "androidx.navigation.compose.NavHost.<anonymous> (NavHost.kt:301)");
                    }
                    NavHost$lambda$6 = NavHostKt.NavHost$lambda$6(state);
                    ListIterator listIterator = NavHost$lambda$6.listIterator(NavHost$lambda$6.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            obj = null;
                            break;
                        } else {
                            obj = listIterator.previous();
                            if (Intrinsics.areEqual(navBackStackEntry2, (NavBackStackEntry) obj)) {
                                break;
                            }
                        }
                    }
                    final NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) obj;
                    if (navBackStackEntry3 != null) {
                        NavBackStackEntryProviderKt.LocalOwnersProvider(navBackStackEntry3, SaveableStateHolder.this, ComposableLambdaKt.composableLambda(composer2, -1425390790, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$14.1
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
                                ComposerKt.sourceInformation(composer3, "C307@13158L27:NavHost.kt#opm8kd");
                                if ((i7 & 11) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1425390790, i7, -1, "androidx.navigation.compose.NavHost.<anonymous>.<anonymous> (NavHost.kt:306)");
                                    }
                                    NavDestination destination = NavBackStackEntry.this.getDestination();
                                    Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
                                    ((ComposeNavigator.Destination) destination).getContent$navigation_compose_release().invoke(animatedContentScope, NavBackStackEntry.this, composer3, 72);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, 456);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, i5, 0);
            EffectsKt.LaunchedEffect(updateTransition.getCurrentState(), updateTransition.getTargetState(), new NavHostKt$NavHost$15(updateTransition, map, state, composeNavigator3, null), startRestartGroup, 584);
            startRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean changed3 = startRestartGroup.changed(state) | startRestartGroup.changed(composeNavigator3);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$16$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        final State<List<NavBackStackEntry>> state2 = state;
                        final ComposeNavigator composeNavigator4 = composeNavigator3;
                        return new DisposableEffectResult() { // from class: androidx.navigation.compose.NavHostKt$NavHost$16$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                List NavHost$lambda$6;
                                NavHost$lambda$6 = NavHostKt.NavHost$lambda$6(State.this);
                                Iterator it = NavHost$lambda$6.iterator();
                                while (it.hasNext()) {
                                    composeNavigator4.onTransitionComplete((NavBackStackEntry) it.next());
                                }
                            }
                        };
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect((Object) true, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue5, startRestartGroup, 6);
        } else {
            function17 = function16;
            dialogNavigator = null;
            i4 = 0;
        }
        startRestartGroup.endReplaceableGroup();
        Navigator navigator2 = navHostController.get_navigatorProvider().getNavigator(DialogNavigator.NAME);
        DialogNavigator dialogNavigator2 = navigator2 instanceof DialogNavigator ? (DialogNavigator) navigator2 : dialogNavigator;
        if (dialogNavigator2 == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
            if (endRestartGroup2 == null) {
                return;
            }
            final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function112 = function15;
            final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function113 = function17;
            endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$dialogNavigator$1
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

                public final void invoke(Composer composer2, int i6) {
                    NavHostKt.NavHost(NavHostController.this, navGraph, companion, center, navHostKt$NavHost$8, navHostKt$NavHost$9, function112, function113, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
            return;
        }
        DialogHostKt.DialogHost(dialogNavigator2, startRestartGroup, i4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup3 = startRestartGroup.endRestartGroup();
        if (endRestartGroup3 == null) {
            return;
        }
        final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function114 = function15;
        final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function115 = function17;
        endRestartGroup3.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$17
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

            public final void invoke(Composer composer2, int i6) {
                NavHostKt.NavHost(NavHostController.this, navGraph, companion, center, navHostKt$NavHost$8, navHostKt$NavHost$9, function114, function115, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition createEnterTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> enterTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> enterTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getEnterTransition$navigation_compose_release();
            if (enterTransition$navigation_compose_release2 != null) {
                return enterTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (enterTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getEnterTransition$navigation_compose_release()) == null) {
            return null;
        }
        return enterTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition createExitTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> exitTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> exitTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getExitTransition$navigation_compose_release();
            if (exitTransition$navigation_compose_release2 != null) {
                return exitTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (exitTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getExitTransition$navigation_compose_release()) == null) {
            return null;
        }
        return exitTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition createPopEnterTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> popEnterTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> popEnterTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getPopEnterTransition$navigation_compose_release();
            if (popEnterTransition$navigation_compose_release2 != null) {
                return popEnterTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (popEnterTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getPopEnterTransition$navigation_compose_release()) == null) {
            return null;
        }
        return popEnterTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition createPopExitTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> popExitTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> popExitTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getPopExitTransition$navigation_compose_release();
            if (popExitTransition$navigation_compose_release2 != null) {
                return popExitTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (popExitTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getPopExitTransition$navigation_compose_release()) == null) {
            return null;
        }
        return popExitTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    private static final List<NavBackStackEntry> NavHost$lambda$3(State<? extends List<NavBackStackEntry>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<NavBackStackEntry> NavHost$lambda$4(State<? extends List<NavBackStackEntry>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<NavBackStackEntry> NavHost$lambda$6(State<? extends List<NavBackStackEntry>> state) {
        return state.getValue();
    }
}
