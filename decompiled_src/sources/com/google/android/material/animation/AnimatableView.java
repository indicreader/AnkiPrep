package com.google.android.material.animation;

/* loaded from: classes3.dex */
public interface AnimatableView {

    /* loaded from: classes3.dex */
    public interface Listener {
        void onAnimationEnd();
    }

    void startAnimation(Listener listener);

    void stopAnimation();
}
