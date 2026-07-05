package androidx.transition;

import android.os.Build;
import android.view.View;

/* loaded from: classes2.dex */
class ViewUtilsApi23 extends ViewUtilsApi22 {
    private static boolean sTryHiddenSetTransitionVisibility = true;

    @Override // androidx.transition.ViewUtilsApi19
    public void setTransitionVisibility(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.setTransitionVisibility(view, i);
        } else if (sTryHiddenSetTransitionVisibility) {
            try {
                Api29Impl.setTransitionVisibility(view, i);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSetTransitionVisibility = false;
            }
        }
    }

    /* loaded from: classes2.dex */
    static class Api29Impl {
        private Api29Impl() {
        }

        static void setTransitionVisibility(View view, int i) {
            view.setTransitionVisibility(i);
        }
    }
}
