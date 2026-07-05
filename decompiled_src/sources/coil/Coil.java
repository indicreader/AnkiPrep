package coil;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;

/* compiled from: Coil.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0087@¢\u0006\u0002\u0010\rJ\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcoil/Coil;", "", "()V", "imageLoader", "Lcoil/ImageLoader;", "imageLoaderFactory", "Lcoil/ImageLoaderFactory;", "enqueue", "Lcoil/request/Disposable;", "request", "Lcoil/request/ImageRequest;", "execute", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "context", "Landroid/content/Context;", "newImageLoader", "reset", "", "setImageLoader", "factory", "coil-singleton_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class Coil {
    public static final Coil INSTANCE = new Coil();
    private static ImageLoader imageLoader;
    private static ImageLoaderFactory imageLoaderFactory;

    private Coil() {
    }

    @JvmStatic
    public static final ImageLoader imageLoader(Context context) {
        ImageLoader imageLoader2 = imageLoader;
        return imageLoader2 == null ? INSTANCE.newImageLoader(context) : imageLoader2;
    }

    @JvmStatic
    public static final synchronized void setImageLoader(ImageLoader imageLoader2) {
        synchronized (Coil.class) {
            imageLoaderFactory = null;
            imageLoader = imageLoader2;
        }
    }

    @JvmStatic
    public static final synchronized void setImageLoader(ImageLoaderFactory factory) {
        synchronized (Coil.class) {
            imageLoaderFactory = factory;
            imageLoader = null;
        }
    }

    @JvmStatic
    public static final synchronized void reset() {
        synchronized (Coil.class) {
            imageLoader = null;
            imageLoaderFactory = null;
        }
    }

    private final synchronized ImageLoader newImageLoader(Context context) {
        ImageLoader newImageLoader;
        ImageLoader imageLoader2 = imageLoader;
        if (imageLoader2 != null) {
            return imageLoader2;
        }
        ImageLoaderFactory imageLoaderFactory2 = imageLoaderFactory;
        if (imageLoaderFactory2 == null || (newImageLoader = imageLoaderFactory2.newImageLoader()) == null) {
            Object applicationContext = context.getApplicationContext();
            ImageLoaderFactory imageLoaderFactory3 = applicationContext instanceof ImageLoaderFactory ? (ImageLoaderFactory) applicationContext : null;
            newImageLoader = imageLoaderFactory3 != null ? imageLoaderFactory3.newImageLoader() : ImageLoaders.create(context);
        }
        imageLoaderFactory = null;
        imageLoader = newImageLoader;
        return newImageLoader;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Replace with 'context.imageLoader.enqueue(request)'.", replaceWith = @ReplaceWith(expression = "request.context.imageLoader.enqueue(request)", imports = {"coil.imageLoader"}))
    @JvmStatic
    public static final Disposable enqueue(ImageRequest request) {
        throw new IllegalStateException("Unsupported".toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Replace with 'context.imageLoader.execute(request)'.", replaceWith = @ReplaceWith(expression = "request.context.imageLoader.execute(request)", imports = {"coil.imageLoader"}))
    @JvmStatic
    public static final Object execute(ImageRequest imageRequest, Continuation<? super ImageResult> continuation) {
        throw new IllegalStateException("Unsupported".toString());
    }
}
