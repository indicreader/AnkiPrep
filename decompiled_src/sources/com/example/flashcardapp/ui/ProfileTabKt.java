package com.example.flashcardapp.ui;

import android.R;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileTab.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001a#\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010\n\u001a1\u0010\u000b\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\u0012\u001a\u0015\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001a\u0016\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003\u001a\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b¨\u0006\u001c²\u0006\n\u0010\u001d\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u001e\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u001f\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010 \u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010!\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\u0010\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\rX\u008a\u008e\u0002²\u0006\f\u0010%\u001a\u0004\u0018\u00010\u0003X\u008a\u008e\u0002²\u0006\n\u0010&\u001a\u00020\u001bX\u008a\u008e\u0002²\u0006\n\u0010'\u001a\u00020\u001bX\u008a\u008e\u0002²\u0006\f\u0010(\u001a\u0004\u0018\u00010\u0007X\u008a\u008e\u0002²\u0006\n\u0010)\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010*\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010+\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010,\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010-\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010.\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u00100\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u00101\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u00102\u001a\u00020\u001bX\u008a\u008e\u0002²\u0006\n\u00103\u001a\u00020\u001bX\u008a\u008e\u0002²\u0006\n\u00104\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u00105\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u00106\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u00107\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u00108\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u00109\u001a\u00020\u001bX\u008a\u008e\u0002²\u0006\n\u0010:\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"CriteriaTag", "", "text", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "OpportunityCard", "opp", "Lcom/example/flashcardapp/ui/Opportunity;", "onClick", "Lkotlin/Function0;", "(Lcom/example/flashcardapp/ui/Opportunity;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ProfileTab", "sessionRecords", "", "Lcom/example/flashcardapp/data/entities/SessionRecordEntity;", "cardCount", "", "onBackPressed", "(Ljava/util/List;ILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "TargetTag", "showExamNotification", "context", "Landroid/content/Context;", "examName", "rotateVertically", "Landroidx/compose/ui/Modifier;", "clockwise", "", "app_release", "profileName", "profileGoal", "profileDegree", "profileRank", "profileAge", "profileBio", "exams", "Lcom/example/flashcardapp/ui/ExamItem;", "avatarUriStr", "showEditDialog", "showAddExamDialog", "editingOpp", "recommendationsVersion", "examsVersion", "examUrl", "tempName", "tempAge", "tempDegree", "tempGoal", "tempRank", "tempBio", "degreeExpanded", "goalExpanded", "title", "subtitle", "matchPercentage", "labelText", "progressPercent", "showProgress", "selectedColorHex"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ProfileTabKt {
    public static final Modifier rotateVertically(Modifier modifier, final boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return LayoutModifierKt.layout(modifier, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: com.example.flashcardapp.ui.ProfileTabKt$rotateVertically$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m6332invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m6332invoke3p2s80s(MeasureScope layout, Measurable measurable, long j) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Intrinsics.checkNotNullParameter(measurable, "measurable");
                final Placeable mo4687measureBRTryo0 = measurable.mo4687measureBRTryo0(j);
                int height = mo4687measureBRTryo0.getHeight();
                int width = mo4687measureBRTryo0.getWidth();
                final boolean z2 = z;
                return MeasureScope.layout$default(layout, height, width, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.example.flashcardapp.ui.ProfileTabKt$rotateVertically$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope layout2) {
                        Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                        Placeable placeable = Placeable.this;
                        int height2 = z2 ? placeable.getHeight() : 0;
                        int width2 = z2 ? 0 : Placeable.this.getWidth();
                        final boolean z3 = z2;
                        Placeable.PlacementScope.placeWithLayer$default(layout2, placeable, height2, width2, 0.0f, new Function1<GraphicsLayerScope, Unit>() { // from class: com.example.flashcardapp.ui.ProfileTabKt.rotateVertically.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                                invoke2(graphicsLayerScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GraphicsLayerScope placeWithLayer) {
                                Intrinsics.checkNotNullParameter(placeWithLayer, "$this$placeWithLayer");
                                placeWithLayer.setRotationZ(z3 ? 90.0f : -90.0f);
                            }
                        }, 4, null);
                    }
                }, 4, null);
            }
        });
    }

    public static /* synthetic */ Modifier rotateVertically$default(Modifier modifier, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return rotateVertically(modifier, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0180, code lost:
    
        if (r3 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0694  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x07c7  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0697  */
    /* JADX WARN: Type inference failed for: r4v142 */
    /* JADX WARN: Type inference failed for: r4v143, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r4v234 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ProfileTab(final java.util.List<com.example.flashcardapp.data.entities.SessionRecordEntity> r66, final int r67, final kotlin.jvm.functions.Function0<kotlin.Unit> r68, androidx.compose.runtime.Composer r69, final int r70) {
        /*
            Method dump skipped, instructions count: 7234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.ui.ProfileTabKt.ProfileTab(java.util.List, int, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileTab$lambda$2(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileTab$lambda$5(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileTab$lambda$8(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileTab$lambda$11(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ProfileTab$lambda$14(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileTab$lambda$15(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileTab$lambda$17(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<ExamItem> ProfileTab$lambda$25(MutableState<List<ExamItem>> mutableState) {
        return mutableState.getValue();
    }

    private static final String ProfileTab$lambda$31(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ProfileTab$lambda$36(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileTab$lambda$37(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean ProfileTab$lambda$39(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileTab$lambda$40(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Opportunity ProfileTab$lambda$42(MutableState<Opportunity> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ProfileTab$lambda$45(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileTab$lambda$46(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ProfileTab$lambda$48(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileTab$lambda$49(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileTab$lambda$53(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileTab$lambda$56(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileTab$lambda$60(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileTab$lambda$63(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileTab$lambda$66(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileTab$lambda$69(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileTab$lambda$72(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileTab$lambda$75(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ProfileTab$lambda$78(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileTab$lambda$79(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ProfileTab$lambda$81(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileTab$lambda$82(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileTab$lambda$100(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileTab$lambda$103(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ProfileTab$lambda$106(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileTab$lambda$107(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileTab$lambda$109(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ProfileTab$lambda$112(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileTab$lambda$113(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ProfileTab$lambda$115(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileTab$lambda$116(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileTab$lambda$118(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CriteriaTag(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1476202456);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1476202456, i2, -1, "com.example.flashcardapp.ui.CriteriaTag (ProfileTab.kt:815)");
            }
            Modifier m570paddingVpY3zN4 = PaddingKt.m570paddingVpY3zN4(BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(8))), ColorKt.Color(4293781494L), null, 2, null), Dp.m5738constructorimpl(12), Dp.m5738constructorimpl(6));
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
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
            composer2 = startRestartGroup;
            TextKt.m2133Text4IGK_g(str, (Modifier) null, ColorKt.Color(4284364209L), TextUnitKt.getSp(12), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, (i2 & 14) | 200064, 0, 131026);
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ProfileTabKt$CriteriaTag$2
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

                public final void invoke(Composer composer3, int i3) {
                    ProfileTabKt.CriteriaTag(str, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TargetTag(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1816961370);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1816961370, i2, -1, "com.example.flashcardapp.ui.TargetTag (ProfileTab.kt:827)");
            }
            Modifier m570paddingVpY3zN4 = PaddingKt.m570paddingVpY3zN4(BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(8))), ColorKt.Color(4293454582L), null, 2, null), Dp.m5738constructorimpl(16), Dp.m5738constructorimpl(6));
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
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
            composer2 = startRestartGroup;
            TextKt.m2133Text4IGK_g(str, (Modifier) null, ColorKt.Color(4279903102L), TextUnitKt.getSp(12), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, (i2 & 14) | 200064, 0, 131026);
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ProfileTabKt$TargetTag$2
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

                public final void invoke(Composer composer3, int i3) {
                    ProfileTabKt.TargetTag(str, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OpportunityCard(final Opportunity opportunity, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1232491880);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(opportunity) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1232491880, i2, -1, "com.example.flashcardapp.ui.OpportunityCard (ProfileTab.kt:839)");
            }
            composer2 = startRestartGroup;
            CardKt.Card(ClickableKt.m251clickableXHw0xAI$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, null, null, function0, 7, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(16)), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getSurface(), 0L, 0L, 0L, composer2, CardDefaults.$stable << 12, 14), CardDefaults.INSTANCE.m1296cardElevationaqJV_2Y(Dp.m5738constructorimpl(0), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, (CardDefaults.$stable << 18) | 6, 62), BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(1), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOutlineVariant()), ComposableLambdaKt.composableLambda(composer2, -1193208102, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ProfileTabKt$OpportunityCard$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope Card, Composer composer3, int i3) {
                    final Opportunity opportunity2;
                    Composer composer4;
                    boolean z;
                    Object obj;
                    float f;
                    Intrinsics.checkNotNullParameter(Card, "$this$Card");
                    if ((i3 & 81) != 16 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1193208102, i3, -1, "com.example.flashcardapp.ui.OpportunityCard.<anonymous> (ProfileTab.kt:847)");
                        }
                        Modifier height = IntrinsicKt.height(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), IntrinsicSize.Min);
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Opportunity opportunity3 = Opportunity.this;
                        composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(height);
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
                        Updater.m2954setimpl(m2947constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl.getInserting() || !Intrinsics.areEqual(m2947constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m2947constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m2947constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        Modifier m216backgroundbw27NRU$default = BackgroundKt.m216backgroundbw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(32)), 0.0f, 1, null), opportunity3.m6331getLabelColor0d7_KjU(), null, 2, null);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer3, 6);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m216backgroundbw27NRU$default);
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
                        Updater.m2954setimpl(m2947constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl2.getInserting() || !Intrinsics.areEqual(m2947constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m2947constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m2947constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        modifierMaterializerOf2.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        float f2 = 4;
                        TextKt.m2133Text4IGK_g(opportunity3.getLabelText(), PaddingKt.m571paddingVpY3zN4$default(ProfileTabKt.rotateVertically(Modifier.INSTANCE, false), 0.0f, Dp.m5738constructorimpl(f2), 1, null), Color.INSTANCE.m3454getWhite0d7_KjU(), TextUnitKt.getSp(9), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m5623boximpl(TextAlign.INSTANCE.m5630getCentere0LSkKk()), 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 200064, 3072, 122320);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        Modifier weight$default = RowScope.weight$default(rowScopeInstance, PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(16)), 1.0f, false, 2, null);
                        Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(8));
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer3, 6);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(weight$default);
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
                        Updater.m2954setimpl(m2947constructorimpl3, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                        Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                        composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween, centerVertically2, composer3, 54);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
                        Updater.m2954setimpl(m2947constructorimpl4, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                        }
                        modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                        float f3 = 6;
                        Arrangement.HorizontalOrVertical m478spacedBy0680j_42 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f3));
                        composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m478spacedBy0680j_42, centerVertically3, composer3, 54);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap5 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(companion);
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
                        Updater.m2954setimpl(m2947constructorimpl5, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl5.getInserting() || !Intrinsics.areEqual(m2947constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                            m2947constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                            m2947constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                        }
                        modifierMaterializerOf5.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                        Modifier m570paddingVpY3zN4 = PaddingKt.m570paddingVpY3zN4(BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f3))), Color.m3416copywmQWz5c$default(opportunity3.m6331getLabelColor0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m5738constructorimpl(f3), Dp.m5738constructorimpl(2));
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap6 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(m570paddingVpY3zN4);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor6);
                        } else {
                            composer3.useNode();
                        }
                        Composer m2947constructorimpl6 = Updater.m2947constructorimpl(composer3);
                        Updater.m2954setimpl(m2947constructorimpl6, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl6.getInserting() || !Intrinsics.areEqual(m2947constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                            m2947constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                            m2947constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
                        }
                        modifierMaterializerOf6.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        TextKt.m2133Text4IGK_g("MATCH " + opportunity3.getMatchPercentage() + "%", (Modifier) null, opportunity3.m6331getLabelColor0d7_KjU(), TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199680, 0, 131026);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        TextKt.m2133Text4IGK_g(opportunity3.getTitle(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurface(), TextUnitKt.getSp(16), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199680, 0, 131026);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        IconKt.m1605Iconww6aTOc(opportunity3.getIcon(), (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(18)), opportunity3.m6331getLabelColor0d7_KjU(), composer3, 432, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        TextKt.m2133Text4IGK_g(opportunity3.getSubtitle(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurfaceVariant(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3072, 0, 131058);
                        composer3.startReplaceableGroup(1381725245);
                        if (opportunity3.getShowProgress()) {
                            Arrangement.HorizontalOrVertical m478spacedBy0680j_43 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f2));
                            composer3.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_43, Alignment.INSTANCE.getStart(), composer3, 6);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap7 = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf7 = LayoutKt.modifierMaterializerOf(companion2);
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor7);
                            } else {
                                composer3.useNode();
                            }
                            Composer m2947constructorimpl7 = Updater.m2947constructorimpl(composer3);
                            Updater.m2954setimpl(m2947constructorimpl7, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m2954setimpl(m2947constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m2947constructorimpl7.getInserting() || !Intrinsics.areEqual(m2947constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                                m2947constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                                m2947constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
                            }
                            modifierMaterializerOf7.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            Arrangement.HorizontalOrVertical spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
                            composer3.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(spaceBetween2, Alignment.INSTANCE.getTop(), composer3, 6);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap8 = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf8 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default2);
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
                            Updater.m2954setimpl(m2947constructorimpl8, rowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m2954setimpl(m2947constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m2947constructorimpl8.getInserting() || !Intrinsics.areEqual(m2947constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
                                m2947constructorimpl8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                                m2947constructorimpl8.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
                            }
                            modifierMaterializerOf8.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                            TextKt.m2133Text4IGK_g("Syllabus Mastery", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurfaceVariant(), TextUnitKt.getSp(10), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3078, 0, 131058);
                            TextKt.m2133Text4IGK_g(((int) (opportunity3.getProgress() * 100)) + "%", (Modifier) null, opportunity3.m6331getLabelColor0d7_KjU(), TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199680, 0, 131026);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer4 = composer3;
                            composer4.startReplaceableGroup(-934909005);
                            opportunity2 = opportunity3;
                            boolean changed = composer4.changed(opportunity2);
                            Object rememberedValue = composer3.rememberedValue();
                            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = (Function0) new Function0<Float>() { // from class: com.example.flashcardapp.ui.ProfileTabKt$OpportunityCard$1$1$2$2$2$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        return Float.valueOf(Opportunity.this.getProgress());
                                    }
                                };
                                composer4.updateRememberedValue(rememberedValue);
                            }
                            composer3.endReplaceableGroup();
                            z = true;
                            obj = null;
                            f = 0.0f;
                            ProgressIndicatorKt.m1758LinearProgressIndicator_5eSRE((Function0<Float>) rememberedValue, ClipKt.clip(SizeKt.m604height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(f3)), RoundedCornerShapeKt.RoundedCornerShape(50)), opportunity2.m6331getLabelColor0d7_KjU(), Color.m3416copywmQWz5c$default(opportunity2.m6331getLabelColor0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), 0, composer3, 0, 16);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                        } else {
                            opportunity2 = opportunity3;
                            composer4 = composer3;
                            z = true;
                            obj = null;
                            f = 0.0f;
                        }
                        composer3.endReplaceableGroup();
                        composer4.startReplaceableGroup(-1401251521);
                        if (opportunity2.getButtonText() != null) {
                            boolean z2 = z;
                            ButtonColors m1274buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1274buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, composer3, ButtonDefaults.$stable << 12, 14);
                            ButtonKt.Button(new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ProfileTabKt$OpportunityCard$1$1$2$3
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }
                            }, SizeKt.m604height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, f, z2 ? 1 : 0, obj), Dp.m5738constructorimpl(38)), false, RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(10)), m1274buttonColorsro_MJ88, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, -917152906, z2, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ProfileTabKt$OpportunityCard$1$1$2$4
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer5, Integer num) {
                                    invoke(rowScope, composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RowScope Button, Composer composer5, int i4) {
                                    Intrinsics.checkNotNullParameter(Button, "$this$Button");
                                    if ((i4 & 81) == 16 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-917152906, i4, -1, "com.example.flashcardapp.ui.OpportunityCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProfileTab.kt:920)");
                                    }
                                    TextKt.m2133Text4IGK_g(Opportunity.this.getButtonText(), (Modifier) null, Color.INSTANCE.m3454getWhite0d7_KjU(), TextUnitKt.getSp(12), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer5, 200064, 0, 131026);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer3, 805306422, 484);
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
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ProfileTabKt$OpportunityCard$2
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

                public final void invoke(Composer composer3, int i3) {
                    ProfileTabKt.OpportunityCard(Opportunity.this, function0, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void showExamNotification(Context context, String examName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(examName, "examName");
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        NotificationChannel notificationChannel = new NotificationChannel("exam_updates_channel", "Exam Tracker Updates", 3);
        notificationChannel.setDescription("Channel for exam update alerts");
        notificationManager.createNotificationChannel(notificationChannel);
        NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(context, "exam_updates_channel").setSmallIcon(R.drawable.ic_dialog_info).setContentTitle("Official Exam Tracker Alert").setContentText("New announcement detected on: " + examName).setPriority(0).setAutoCancel(true);
        Intrinsics.checkNotNullExpressionValue(autoCancel, "setAutoCancel(...)");
        notificationManager.notify(examName.hashCode(), autoCancel.build());
    }
}
