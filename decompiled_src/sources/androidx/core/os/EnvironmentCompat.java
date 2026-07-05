package androidx.core.os;

import android.os.Environment;
import java.io.File;

/* loaded from: classes2.dex */
public final class EnvironmentCompat {

    @Deprecated
    public static final String MEDIA_UNKNOWN = "unknown";

    public static String getStorageState(File file) {
        return Api21Impl.getExternalStorageState(file);
    }

    private EnvironmentCompat() {
    }

    /* loaded from: classes2.dex */
    static class Api21Impl {
        private Api21Impl() {
        }

        static String getExternalStorageState(File file) {
            return Environment.getExternalStorageState(file);
        }
    }
}
