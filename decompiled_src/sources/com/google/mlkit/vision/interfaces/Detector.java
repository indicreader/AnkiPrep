package com.google.mlkit.vision.interfaces;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import androidx.lifecycle.LifecycleObserver;
import com.google.android.gms.tasks.Task;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* compiled from: com.google.mlkit:vision-interfaces@@16.2.0 */
/* loaded from: classes4.dex */
public interface Detector<DetectionResultT> extends Closeable, LifecycleObserver {
    public static final int TYPE_BARCODE_SCANNING = 1;
    public static final int TYPE_DOCUMENT_DETECTION = 10;
    public static final int TYPE_FACE_DETECTION = 2;
    public static final int TYPE_IMAGE_CAPTIONING = 9;
    public static final int TYPE_IMAGE_LABELING = 3;
    public static final int TYPE_OBJECT_DETECTION = 5;
    public static final int TYPE_POSE_DETECTION = 6;
    public static final int TYPE_SEGMENTATION = 7;
    public static final int TYPE_SELFIE_FACE_DETECTION = 8;
    public static final int TYPE_TEXT_RECOGNITION = 4;

    /* compiled from: com.google.mlkit:vision-interfaces@@16.2.0 */
    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes4.dex */
    public @interface DetectorType {
    }

    int getDetectorType();

    Task<DetectionResultT> process(Bitmap bitmap, int i);

    Task<DetectionResultT> process(Image image, int i);

    Task<DetectionResultT> process(Image image, int i, Matrix matrix);

    Task<DetectionResultT> process(ByteBuffer byteBuffer, int i, int i2, int i3, int i4);
}
