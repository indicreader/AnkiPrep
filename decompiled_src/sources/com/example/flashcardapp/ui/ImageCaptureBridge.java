package com.example.flashcardapp.ui;

import android.webkit.JavascriptInterface;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ImageWebSearchDialog.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0004H\u0007R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/example/flashcardapp/ui/ImageCaptureBridge;", "", "onImageCaptured", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "onImageSelected", ImagesContract.URL, "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ImageCaptureBridge {
    public static final int $stable = 0;
    private final Function1<String, Unit> onImageCaptured;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageCaptureBridge(Function1<? super String, Unit> onImageCaptured) {
        Intrinsics.checkNotNullParameter(onImageCaptured, "onImageCaptured");
        this.onImageCaptured = onImageCaptured;
    }

    @JavascriptInterface
    public final void onImageSelected(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (!StringsKt.isBlank(url)) {
            this.onImageCaptured.invoke(url);
        }
    }
}
