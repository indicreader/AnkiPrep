package coil.compose;

import android.graphics.ColorSpace;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.memory.MemoryCache;
import coil.request.ImageRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EqualityDelegate.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"DefaultModelEqualityDelegate", "Lcoil/compose/EqualityDelegate;", "getDefaultModelEqualityDelegate", "()Lcoil/compose/EqualityDelegate;", "coil-compose-base_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class EqualityDelegateKt {
    private static final EqualityDelegate DefaultModelEqualityDelegate = new EqualityDelegate() { // from class: coil.compose.EqualityDelegateKt$DefaultModelEqualityDelegate$1
        @Override // coil.compose.EqualityDelegate
        public boolean equals(Object self, Object other) {
            if (self == other) {
                return true;
            }
            if (!(self instanceof ImageRequest) || !(other instanceof ImageRequest)) {
                return Intrinsics.areEqual(self, other);
            }
            ImageRequest imageRequest = (ImageRequest) self;
            ImageRequest imageRequest2 = (ImageRequest) other;
            return Intrinsics.areEqual(imageRequest.getContext(), imageRequest2.getContext()) && Intrinsics.areEqual(imageRequest.getData(), imageRequest2.getData()) && Intrinsics.areEqual(imageRequest.getPlaceholderMemoryCacheKey(), imageRequest2.getPlaceholderMemoryCacheKey()) && Intrinsics.areEqual(imageRequest.getMemoryCacheKey(), imageRequest2.getMemoryCacheKey()) && Intrinsics.areEqual(imageRequest.getDiskCacheKey(), imageRequest2.getDiskCacheKey()) && imageRequest.getBitmapConfig() == imageRequest2.getBitmapConfig() && Intrinsics.areEqual(imageRequest.getColorSpace(), imageRequest2.getColorSpace()) && Intrinsics.areEqual(imageRequest.getTransformations(), imageRequest2.getTransformations()) && Intrinsics.areEqual(imageRequest.getHeaders(), imageRequest2.getHeaders()) && imageRequest.getAllowConversionToBitmap() == imageRequest2.getAllowConversionToBitmap() && imageRequest.getAllowHardware() == imageRequest2.getAllowHardware() && imageRequest.getAllowRgb565() == imageRequest2.getAllowRgb565() && imageRequest.getPremultipliedAlpha() == imageRequest2.getPremultipliedAlpha() && imageRequest.getMemoryCachePolicy() == imageRequest2.getMemoryCachePolicy() && imageRequest.getDiskCachePolicy() == imageRequest2.getDiskCachePolicy() && imageRequest.getNetworkCachePolicy() == imageRequest2.getNetworkCachePolicy() && Intrinsics.areEqual(imageRequest.getSizeResolver(), imageRequest2.getSizeResolver()) && imageRequest.getScale() == imageRequest2.getScale() && imageRequest.getPrecision() == imageRequest2.getPrecision() && Intrinsics.areEqual(imageRequest.getParameters(), imageRequest2.getParameters());
        }

        @Override // coil.compose.EqualityDelegate
        public int hashCode(Object self) {
            if (!(self instanceof ImageRequest)) {
                if (self != null) {
                    return self.hashCode();
                }
                return 0;
            }
            ImageRequest imageRequest = (ImageRequest) self;
            int hashCode = ((imageRequest.getContext().hashCode() * 31) + imageRequest.getData().hashCode()) * 31;
            MemoryCache.Key placeholderMemoryCacheKey = imageRequest.getPlaceholderMemoryCacheKey();
            int hashCode2 = (hashCode + (placeholderMemoryCacheKey != null ? placeholderMemoryCacheKey.hashCode() : 0)) * 31;
            MemoryCache.Key memoryCacheKey = imageRequest.getMemoryCacheKey();
            int hashCode3 = (hashCode2 + (memoryCacheKey != null ? memoryCacheKey.hashCode() : 0)) * 31;
            String diskCacheKey = imageRequest.getDiskCacheKey();
            int hashCode4 = (((hashCode3 + (diskCacheKey != null ? diskCacheKey.hashCode() : 0)) * 31) + imageRequest.getBitmapConfig().hashCode()) * 31;
            ColorSpace colorSpace = imageRequest.getColorSpace();
            return ((((((((((((((((((((((((((hashCode4 + (colorSpace != null ? colorSpace.hashCode() : 0)) * 31) + imageRequest.getTransformations().hashCode()) * 31) + imageRequest.getHeaders().hashCode()) * 31) + Boolean.hashCode(imageRequest.getAllowConversionToBitmap())) * 31) + Boolean.hashCode(imageRequest.getAllowHardware())) * 31) + Boolean.hashCode(imageRequest.getAllowRgb565())) * 31) + Boolean.hashCode(imageRequest.getPremultipliedAlpha())) * 31) + imageRequest.getMemoryCachePolicy().hashCode()) * 31) + imageRequest.getDiskCachePolicy().hashCode()) * 31) + imageRequest.getNetworkCachePolicy().hashCode()) * 31) + imageRequest.getSizeResolver().hashCode()) * 31) + imageRequest.getScale().hashCode()) * 31) + imageRequest.getPrecision().hashCode()) * 31) + imageRequest.getParameters().hashCode();
        }
    };

    public static final EqualityDelegate getDefaultModelEqualityDelegate() {
        return DefaultModelEqualityDelegate;
    }
}
