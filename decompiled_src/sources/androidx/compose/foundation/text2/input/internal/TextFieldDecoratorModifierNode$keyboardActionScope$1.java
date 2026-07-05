package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.input.ImeAction;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: TextFieldDecoratorModifier.kt */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"androidx/compose/foundation/text2/input/internal/TextFieldDecoratorModifierNode$keyboardActionScope$1", "Landroidx/compose/foundation/text/KeyboardActionScope;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "getFocusManager", "()Landroidx/compose/ui/focus/FocusManager;", "defaultKeyboardAction", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "defaultKeyboardAction-KlQnJC8", "(I)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldDecoratorModifierNode$keyboardActionScope$1 implements KeyboardActionScope {
    final /* synthetic */ TextFieldDecoratorModifierNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextFieldDecoratorModifierNode$keyboardActionScope$1(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        this.this$0 = textFieldDecoratorModifierNode;
    }

    private final FocusManager getFocusManager() {
        return (FocusManager) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, CompositionLocalsKt.getLocalFocusManager());
    }

    @Override // androidx.compose.foundation.text.KeyboardActionScope
    /* renamed from: defaultKeyboardAction-KlQnJC8 */
    public void mo868defaultKeyboardActionKlQnJC8(int imeAction) {
        SoftwareKeyboardController requireKeyboardController;
        if (ImeAction.m5403equalsimpl0(imeAction, ImeAction.INSTANCE.m5418getNexteUduSuo())) {
            getFocusManager().mo3110moveFocus3ESFkO8(FocusDirection.INSTANCE.m3106getNextdhqQ8s());
            return;
        }
        if (ImeAction.m5403equalsimpl0(imeAction, ImeAction.INSTANCE.m5420getPreviouseUduSuo())) {
            getFocusManager().mo3110moveFocus3ESFkO8(FocusDirection.INSTANCE.m3107getPreviousdhqQ8s());
            return;
        }
        if (ImeAction.m5403equalsimpl0(imeAction, ImeAction.INSTANCE.m5416getDoneeUduSuo())) {
            requireKeyboardController = this.this$0.requireKeyboardController();
            requireKeyboardController.hide();
        } else {
            if (ImeAction.m5403equalsimpl0(imeAction, ImeAction.INSTANCE.m5417getGoeUduSuo()) || ImeAction.m5403equalsimpl0(imeAction, ImeAction.INSTANCE.m5421getSearcheUduSuo()) || ImeAction.m5403equalsimpl0(imeAction, ImeAction.INSTANCE.m5422getSendeUduSuo()) || ImeAction.m5403equalsimpl0(imeAction, ImeAction.INSTANCE.m5415getDefaulteUduSuo())) {
                return;
            }
            ImeAction.m5403equalsimpl0(imeAction, ImeAction.INSTANCE.m5419getNoneeUduSuo());
        }
    }
}
