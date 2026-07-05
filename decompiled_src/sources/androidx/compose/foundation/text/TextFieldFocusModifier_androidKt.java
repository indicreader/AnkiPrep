package androidx.compose.foundation.text;

import android.view.InputDevice;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: TextFieldFocusModifier.android.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"interceptDPadAndMoveFocus", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/text/TextFieldState;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "isKeyCode", "", "Landroidx/compose/ui/input/key/KeyEvent;", "keyCode", "", "isKeyCode-YhN2O0w", "(Landroid/view/KeyEvent;I)Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldFocusModifier_androidKt {
    public static final Modifier interceptDPadAndMoveFocus(Modifier modifier, final TextFieldState textFieldState, final FocusManager focusManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.TextFieldFocusModifier_androidKt$interceptDPadAndMoveFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m923invokeZmokQxo(keyEvent.m4414unboximpl());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m923invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean m922isKeyCodeYhN2O0w;
                boolean m922isKeyCodeYhN2O0w2;
                boolean m922isKeyCodeYhN2O0w3;
                boolean m922isKeyCodeYhN2O0w4;
                boolean m922isKeyCodeYhN2O0w5;
                InputDevice device = keyEvent.getDevice();
                boolean z = false;
                if (device != null && device.supportsSource(InputDeviceCompat.SOURCE_DPAD) && !device.isVirtual() && KeyEventType.m4418equalsimpl0(KeyEvent_androidKt.m4426getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m4422getKeyDownCS__XNY())) {
                    m922isKeyCodeYhN2O0w = TextFieldFocusModifier_androidKt.m922isKeyCodeYhN2O0w(keyEvent, 19);
                    if (m922isKeyCodeYhN2O0w) {
                        z = FocusManager.this.mo3110moveFocus3ESFkO8(FocusDirection.INSTANCE.m3109getUpdhqQ8s());
                    } else {
                        m922isKeyCodeYhN2O0w2 = TextFieldFocusModifier_androidKt.m922isKeyCodeYhN2O0w(keyEvent, 20);
                        if (m922isKeyCodeYhN2O0w2) {
                            z = FocusManager.this.mo3110moveFocus3ESFkO8(FocusDirection.INSTANCE.m3102getDowndhqQ8s());
                        } else {
                            m922isKeyCodeYhN2O0w3 = TextFieldFocusModifier_androidKt.m922isKeyCodeYhN2O0w(keyEvent, 21);
                            if (m922isKeyCodeYhN2O0w3) {
                                z = FocusManager.this.mo3110moveFocus3ESFkO8(FocusDirection.INSTANCE.m3105getLeftdhqQ8s());
                            } else {
                                m922isKeyCodeYhN2O0w4 = TextFieldFocusModifier_androidKt.m922isKeyCodeYhN2O0w(keyEvent, 22);
                                if (m922isKeyCodeYhN2O0w4) {
                                    z = FocusManager.this.mo3110moveFocus3ESFkO8(FocusDirection.INSTANCE.m3108getRightdhqQ8s());
                                } else {
                                    m922isKeyCodeYhN2O0w5 = TextFieldFocusModifier_androidKt.m922isKeyCodeYhN2O0w(keyEvent, 23);
                                    if (m922isKeyCodeYhN2O0w5) {
                                        SoftwareKeyboardController keyboardController = textFieldState.getKeyboardController();
                                        if (keyboardController != null) {
                                            keyboardController.show();
                                        }
                                        z = true;
                                    }
                                }
                            }
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isKeyCode-YhN2O0w, reason: not valid java name */
    public static final boolean m922isKeyCodeYhN2O0w(android.view.KeyEvent keyEvent, int i) {
        return Key_androidKt.m4432getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m4425getKeyZmokQxo(keyEvent)) == i;
    }
}
