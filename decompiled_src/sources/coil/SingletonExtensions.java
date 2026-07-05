package coil;

import android.content.Context;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.util.CoilUtils;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Extensions.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0007H\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u000f*\u00020\u0007H\u0086\b\u001a<\u0010\u0011\u001a\u00020\u0012*\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0000\u001a\u00020\u00012\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000f0\u0016¢\u0006\u0002\b\u0018H\u0086\b\u001a<\u0010\u0019\u001a\u00020\u0012*\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0000\u001a\u00020\u00012\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000f0\u0016¢\u0006\u0002\b\u0018H\u0087\b\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"!\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00078Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0018\u0010\f\u001a\u0004\u0018\u00010\u0006*\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u001a"}, d2 = {"imageLoader", "Lcoil/ImageLoader;", "Landroid/content/Context;", "getImageLoader", "(Landroid/content/Context;)Lcoil/ImageLoader;", "metadata", "Lcoil/request/ImageResult;", "Landroid/widget/ImageView;", "getMetadata$annotations", "(Landroid/widget/ImageView;)V", "getMetadata", "(Landroid/widget/ImageView;)Lcoil/request/ImageResult;", "result", "getResult", "clear", "", "dispose", "load", "Lcoil/request/Disposable;", "data", "", "builder", "Lkotlin/Function1;", "Lcoil/request/ImageRequest$Builder;", "Lkotlin/ExtensionFunctionType;", "loadAny", "coil-singleton_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: coil.-SingletonExtensions, reason: invalid class name */
/* loaded from: classes2.dex */
public final class SingletonExtensions {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate to 'result'.", replaceWith = @ReplaceWith(expression = "result", imports = {"coil.result"}))
    public static /* synthetic */ void getMetadata$annotations(ImageView imageView) {
    }

    public static final ImageLoader getImageLoader(Context context) {
        return Coil.imageLoader(context);
    }

    public static /* synthetic */ Disposable load$default(ImageView imageView, Object obj, ImageLoader imageLoader, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            imageLoader = Coil.imageLoader(imageView.getContext());
        }
        if ((i & 4) != 0) {
            function1 = new Function1<ImageRequest.Builder, Unit>() { // from class: coil.-SingletonExtensions$load$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ImageRequest.Builder builder) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ImageRequest.Builder builder) {
                    invoke2(builder);
                    return Unit.INSTANCE;
                }
            };
        }
        ImageRequest.Builder target = new ImageRequest.Builder(imageView.getContext()).data(obj).target(imageView);
        function1.invoke(target);
        return imageLoader.enqueue(target.build());
    }

    public static final Disposable load(ImageView imageView, Object obj, ImageLoader imageLoader, Function1<? super ImageRequest.Builder, Unit> function1) {
        ImageRequest.Builder target = new ImageRequest.Builder(imageView.getContext()).data(obj).target(imageView);
        function1.invoke(target);
        return imageLoader.enqueue(target.build());
    }

    public static final void dispose(ImageView imageView) {
        CoilUtils.dispose(imageView);
    }

    public static final ImageResult getResult(ImageView imageView) {
        return CoilUtils.result(imageView);
    }

    public static /* synthetic */ Disposable loadAny$default(ImageView imageView, Object obj, ImageLoader imageLoader, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            imageLoader = Coil.imageLoader(imageView.getContext());
        }
        if ((i & 4) != 0) {
            function1 = new Function1<ImageRequest.Builder, Unit>() { // from class: coil.-SingletonExtensions$loadAny$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ImageRequest.Builder builder) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ImageRequest.Builder builder) {
                    invoke2(builder);
                    return Unit.INSTANCE;
                }
            };
        }
        ImageRequest.Builder target = new ImageRequest.Builder(imageView.getContext()).data(obj).target(imageView);
        function1.invoke(target);
        return imageLoader.enqueue(target.build());
    }

    public static final ImageResult getMetadata(ImageView imageView) {
        return CoilUtils.result(imageView);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate to 'load'.", replaceWith = @ReplaceWith(expression = "load(data, imageLoader, builder)", imports = {"coil.imageLoader", "coil.load"}))
    public static final Disposable loadAny(ImageView imageView, Object obj, ImageLoader imageLoader, Function1<? super ImageRequest.Builder, Unit> function1) {
        ImageRequest.Builder target = new ImageRequest.Builder(imageView.getContext()).data(obj).target(imageView);
        function1.invoke(target);
        return imageLoader.enqueue(target.build());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate to 'dispose'.", replaceWith = @ReplaceWith(expression = "dispose()", imports = {"coil.dispose"}))
    public static final void clear(ImageView imageView) {
        CoilUtils.dispose(imageView);
    }
}
