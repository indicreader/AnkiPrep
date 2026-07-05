package androidx.compose.foundation.text2.input.internal.selection;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TapAndDoubleTapGesture.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt", f = "TapAndDoubleTapGesture.kt", i = {0}, l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR}, m = "consumeUntilUp", n = {"$this$consumeUntilUp"}, s = {"L$0"})
/* loaded from: classes.dex */
public final class TapAndDoubleTapGestureKt$consumeUntilUp$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TapAndDoubleTapGestureKt$consumeUntilUp$1(Continuation<? super TapAndDoubleTapGestureKt$consumeUntilUp$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object consumeUntilUp;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        consumeUntilUp = TapAndDoubleTapGestureKt.consumeUntilUp(null, this);
        return consumeUntilUp;
    }
}
