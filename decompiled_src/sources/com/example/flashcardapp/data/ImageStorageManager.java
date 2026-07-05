package com.example.flashcardapp.data;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.util.Utils;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.common.net.HttpHeaders;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ImageStorageManager.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/example/flashcardapp/data/ImageStorageManager;", "", "()V", "IMAGES_DIR", "", "TAG", "copyImageToLocalStorage", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "deleteImageFromLocalStorage", "", "relativePath", "downloadImageFromUrl", ImagesContract.URL, "getFullFile", "Ljava/io/File;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ImageStorageManager {
    public static final int $stable = 0;
    private static final String IMAGES_DIR = "card_images";
    public static final ImageStorageManager INSTANCE = new ImageStorageManager();
    private static final String TAG = "ImageStorageManager";

    private ImageStorageManager() {
    }

    public final String copyImageToLocalStorage(Context context, Uri uri) {
        String str = "webp";
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            ContentResolver contentResolver = context.getContentResolver();
            String type = contentResolver.getType(uri);
            if (type != null && StringsKt.contains$default((CharSequence) type, (CharSequence) "png", false, 2, (Object) null)) {
                str = "png";
            } else if (type != null && StringsKt.contains$default((CharSequence) type, (CharSequence) "gif", false, 2, (Object) null)) {
                str = "gif";
            } else if (type == null || !StringsKt.contains$default((CharSequence) type, (CharSequence) "webp", false, 2, (Object) null)) {
                str = "jpg";
            }
            File file = new File(context.getFilesDir(), IMAGES_DIR);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "img_" + UUID.randomUUID() + "." + str;
            File file2 = new File(file, str2);
            InputStream openInputStream = contentResolver.openInputStream(uri);
            if (openInputStream != null) {
                FileOutputStream fileOutputStream = openInputStream;
                try {
                    InputStream inputStream = fileOutputStream;
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        long copyTo$default = ByteStreamsKt.copyTo$default(inputStream, fileOutputStream, 0, 2, null);
                        CloseableKt.closeFinally(fileOutputStream, null);
                        Long.valueOf(copyTo$default);
                        CloseableKt.closeFinally(fileOutputStream, null);
                    } finally {
                    }
                } finally {
                }
            }
            Log.d(TAG, "Copied image to local storage: " + file2.getAbsolutePath());
            return "card_images/" + str2;
        } catch (Exception e) {
            Log.e(TAG, "Failed to copy image to local storage: " + e.getMessage(), e);
            return null;
        }
    }

    public final void deleteImageFromLocalStorage(Context context, String relativePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        try {
            File file = new File(context.getFilesDir(), relativePath);
            if (file.exists() && file.isFile()) {
                Log.d(TAG, "Deleted local image file: " + relativePath + " (success: " + file.delete() + ")");
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to delete local image file " + relativePath + ": " + e.getMessage(), e);
        }
    }

    public final String downloadImageFromUrl(Context context, String url) {
        String str = "webp";
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            URLConnection openConnection = new URL(url).openConnection();
            Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, "Mozilla/5.0");
            httpURLConnection.connect();
            String contentType = httpURLConnection.getContentType();
            if (contentType == null) {
                contentType = Utils.MIME_TYPE_JPEG;
            }
            if (StringsKt.contains$default((CharSequence) contentType, (CharSequence) "png", false, 2, (Object) null)) {
                str = "png";
            } else if (StringsKt.contains$default((CharSequence) contentType, (CharSequence) "gif", false, 2, (Object) null)) {
                str = "gif";
            } else if (!StringsKt.contains$default((CharSequence) contentType, (CharSequence) "webp", false, 2, (Object) null)) {
                str = "jpg";
            }
            File file = new File(context.getFilesDir(), IMAGES_DIR);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "img_" + UUID.randomUUID() + "." + str;
            File file2 = new File(file, str2);
            FileOutputStream inputStream = httpURLConnection.getInputStream();
            try {
                InputStream inputStream2 = inputStream;
                inputStream = new FileOutputStream(file2);
                try {
                    Intrinsics.checkNotNull(inputStream2);
                    ByteStreamsKt.copyTo$default(inputStream2, inputStream, 0, 2, null);
                    CloseableKt.closeFinally(inputStream, null);
                    CloseableKt.closeFinally(inputStream, null);
                    httpURLConnection.disconnect();
                    Log.d(TAG, "Downloaded image from URL to: " + file2.getAbsolutePath());
                    return "card_images/" + str2;
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to download image from URL: " + e.getMessage(), e);
            return null;
        }
    }

    public final File getFullFile(Context context, String relativePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        return new File(context.getFilesDir(), relativePath);
    }
}
