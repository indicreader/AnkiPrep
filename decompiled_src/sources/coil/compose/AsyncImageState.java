package coil.compose;

import androidx.constraintlayout.widget.ConstraintLayout;
import coil.ImageLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: utils.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcoil/compose/AsyncImageState;", "", "model", "modelEqualityDelegate", "Lcoil/compose/EqualityDelegate;", "imageLoader", "Lcoil/ImageLoader;", "(Ljava/lang/Object;Lcoil/compose/EqualityDelegate;Lcoil/ImageLoader;)V", "getImageLoader", "()Lcoil/ImageLoader;", "getModel", "()Ljava/lang/Object;", "getModelEqualityDelegate", "()Lcoil/compose/EqualityDelegate;", "equals", "", "other", "hashCode", "", "coil-compose-base_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class AsyncImageState {
    public static final int $stable = 0;
    private final ImageLoader imageLoader;
    private final Object model;
    private final EqualityDelegate modelEqualityDelegate;

    public final ImageLoader getImageLoader() {
        return this.imageLoader;
    }

    public final Object getModel() {
        return this.model;
    }

    public final EqualityDelegate getModelEqualityDelegate() {
        return this.modelEqualityDelegate;
    }

    public AsyncImageState(Object obj, EqualityDelegate equalityDelegate, ImageLoader imageLoader) {
        this.model = obj;
        this.modelEqualityDelegate = equalityDelegate;
        this.imageLoader = imageLoader;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AsyncImageState) {
            AsyncImageState asyncImageState = (AsyncImageState) other;
            if (this.modelEqualityDelegate.equals(this.model, asyncImageState.model) && Intrinsics.areEqual(this.imageLoader, asyncImageState.imageLoader)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.modelEqualityDelegate.hashCode(this.model) * 31) + this.imageLoader.hashCode();
    }
}
