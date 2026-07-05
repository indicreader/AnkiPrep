package com.google.android.odml.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.provider.MediaStore;
import java.io.IOException;

/* compiled from: com.google.android.odml:image@@1.0.0-beta1 */
/* loaded from: classes3.dex */
public class BitmapMlImageBuilder {
    private final Bitmap zza;
    private int zzb;
    private Rect zzc;

    public BitmapMlImageBuilder(Context context, Uri uri) throws IOException {
        this(MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri));
    }

    public MlImage build() {
        return new MlImage(new zze(this.zza), this.zzb, this.zzc, 0L, this.zza.getWidth(), this.zza.getHeight());
    }

    public BitmapMlImageBuilder setRotation(int i) {
        MlImage.zzc(i);
        this.zzb = i;
        return this;
    }

    public BitmapMlImageBuilder(Bitmap bitmap) {
        this.zza = bitmap;
        this.zzb = 0;
        this.zzc = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
    }
}
