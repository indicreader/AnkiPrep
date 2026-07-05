package com.google.android.gms.internal.ads;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLU;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeu {
    public static void zza() throws zzet {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                break;
            }
            if (z) {
                sb.append('\n');
            }
            String gluErrorString = GLU.gluErrorString(glGetError);
            if (gluErrorString == null) {
                gluErrorString = "error code: 0x".concat(String.valueOf(Integer.toHexString(glGetError)));
            }
            sb.append("glError: ");
            sb.append(gluErrorString);
            z = true;
        }
        if (z) {
            throw new zzet(sb.toString());
        }
    }

    public static void zzb(boolean z, String str) throws zzet {
        if (!z) {
            throw new zzet(str);
        }
    }

    public static boolean zzc(Context context) {
        if (zzfy.zza < 24) {
            return false;
        }
        if (zzfy.zza < 26 && ("samsung".equals(zzfy.zzc) || "XT1650".equals(zzfy.zzd))) {
            return false;
        }
        if (zzfy.zza >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
            return zzes.zzk("EGL_EXT_protected_content");
        }
        return false;
    }

    public static boolean zzd() {
        int i = zzfy.zza;
        return zzes.zzk("EGL_KHR_surfaceless_context");
    }
}
