package androidx.compose.foundation.text2;

import androidx.compose.foundation.text2.input.ImeActionHandler;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasicSecureTextField.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
/* synthetic */ class BasicSecureTextFieldKt$BasicSecureTextField$3$1$1 implements ImeActionHandler, FunctionAdapter {
    final /* synthetic */ ImeActionHandler $tmp0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BasicSecureTextFieldKt$BasicSecureTextField$3$1$1(ImeActionHandler imeActionHandler) {
        this.$tmp0 = imeActionHandler;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof ImeActionHandler) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(1, this.$tmp0, ImeActionHandler.class, "onImeAction", "onImeAction-KlQnJC8(I)Z", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.compose.foundation.text2.input.ImeActionHandler
    /* renamed from: onImeAction-KlQnJC8, reason: not valid java name */
    public final boolean mo1080onImeActionKlQnJC8(int i) {
        return this.$tmp0.mo1080onImeActionKlQnJC8(i);
    }
}
