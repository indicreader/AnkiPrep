package com.google.mlkit.vision.text;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.mlkit_vision_text_common.zzbx;
import com.google.android.gms.internal.mlkit_vision_text_common.zzsa;
import com.google.android.gms.internal.mlkit_vision_text_common.zzsc;
import com.google.android.gms.internal.mlkit_vision_text_common.zzse;
import com.google.android.gms.internal.mlkit_vision_text_common.zzsg;
import com.google.android.gms.internal.mlkit_vision_text_common.zzsk;
import com.google.android.gms.internal.mlkit_vision_text_common.zzu;
import com.google.mlkit.vision.common.internal.CommonConvertUtils;
import com.google.mlkit.vision.text.Text;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes4.dex */
public class Text {
    private final List zza;
    private final String zzb;

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
    /* loaded from: classes4.dex */
    public static class Symbol extends TextBase {
        private final float zza;
        private final float zzb;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Symbol(zzsk zzskVar, Matrix matrix) {
            super(zzskVar.zzd(), zzskVar.zzc(), zzskVar.zze(), "", matrix);
            this.zza = zzskVar.zzb();
            this.zzb = zzskVar.zza();
        }

        public float getAngle() {
            return this.zzb;
        }

        public float getConfidence() {
            return this.zza;
        }

        public String getText() {
            return zza();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
    /* loaded from: classes4.dex */
    public static class TextBase {
        private final String zza;
        private final Rect zzb;
        private final Point[] zzc;
        private final String zzd;

        TextBase(String str, Rect rect, List list, String str2, Matrix matrix) {
            this.zza = str;
            Rect rect2 = new Rect(rect);
            if (matrix != null) {
                CommonConvertUtils.transformRect(rect2, matrix);
            }
            this.zzb = rect2;
            Point[] pointArr = new Point[list.size()];
            for (int i = 0; i < list.size(); i++) {
                pointArr[i] = new Point((Point) list.get(i));
            }
            if (matrix != null) {
                CommonConvertUtils.transformPointArray(pointArr, matrix);
            }
            this.zzc = pointArr;
            this.zzd = str2;
        }

        public Rect getBoundingBox() {
            return this.zzb;
        }

        public Point[] getCornerPoints() {
            return this.zzc;
        }

        public String getRecognizedLanguage() {
            return this.zzd;
        }

        protected final String zza() {
            String str = this.zza;
            return str == null ? "" : str;
        }
    }

    public Text(zzsg zzsgVar, final Matrix matrix) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        this.zzb = zzsgVar.zza();
        arrayList.addAll(zzbx.zza(zzsgVar.zzb(), new zzu() { // from class: com.google.mlkit.vision.text.zza
            @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzu
            public final Object zza(Object obj) {
                return new Text.TextBlock((zzsa) obj, matrix);
            }
        }));
    }

    public String getText() {
        return this.zzb;
    }

    public List<TextBlock> getTextBlocks() {
        return Collections.unmodifiableList(this.zza);
    }

    public Text(String str, List list) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        arrayList.addAll(list);
        this.zzb = str;
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
    /* loaded from: classes4.dex */
    public static class Line extends TextBase {
        private final List zza;
        private final float zzb;
        private final float zzc;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Line(zzse zzseVar, final Matrix matrix, float f, float f2) {
            super(zzseVar.zze(), zzseVar.zzc(), zzseVar.zzf(), zzseVar.zzd(), matrix);
            this.zza = zzbx.zza(zzseVar.zzg(), new zzu() { // from class: com.google.mlkit.vision.text.zzc
                @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzu
                public final Object zza(Object obj) {
                    return new Text.Element((zzsc) obj, matrix);
                }
            });
            this.zzb = f;
            this.zzc = f2;
        }

        public float getAngle() {
            return this.zzc;
        }

        public float getConfidence() {
            return this.zzb;
        }

        public synchronized List<Element> getElements() {
            return this.zza;
        }

        public String getText() {
            return zza();
        }

        public Line(String str, Rect rect, List list, String str2, Matrix matrix, List list2, float f, float f2) {
            super(str, rect, list, str2, matrix);
            this.zza = list2;
            this.zzb = f;
            this.zzc = f2;
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
    /* loaded from: classes4.dex */
    public static class TextBlock extends TextBase {
        private final List zza;

        /* JADX INFO: Access modifiers changed from: package-private */
        public TextBlock(zzsa zzsaVar, final Matrix matrix) {
            super(zzsaVar.zzc(), zzsaVar.zza(), zzsaVar.zzd(), zzsaVar.zzb(), matrix);
            this.zza = zzbx.zza(zzsaVar.zze(), new zzu() { // from class: com.google.mlkit.vision.text.zzd
                @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzu
                public final Object zza(Object obj) {
                    zzse zzseVar = (zzse) obj;
                    return new Text.Line(zzseVar, matrix, zzseVar.zzb(), zzseVar.zza());
                }
            });
        }

        public synchronized List<Line> getLines() {
            return this.zza;
        }

        public String getText() {
            return zza();
        }

        public TextBlock(String str, Rect rect, List list, String str2, Matrix matrix, List list2) {
            super(str, rect, list, str2, matrix);
            this.zza = list2;
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
    /* loaded from: classes4.dex */
    public static class Element extends TextBase {
        private final List zza;
        private final float zzb;
        private final float zzc;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Element(zzsc zzscVar, final Matrix matrix) {
            super(zzscVar.zze(), zzscVar.zzc(), zzscVar.zzf(), zzscVar.zzd(), matrix);
            this.zzb = zzscVar.zzb();
            this.zzc = zzscVar.zza();
            List zzg = zzscVar.zzg();
            this.zza = zzbx.zza(zzg == null ? new ArrayList() : zzg, new zzu() { // from class: com.google.mlkit.vision.text.zzb
                @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzu
                public final Object zza(Object obj) {
                    return new Text.Symbol((zzsk) obj, matrix);
                }
            });
        }

        public float getAngle() {
            return this.zzc;
        }

        public float getConfidence() {
            return this.zzb;
        }

        public synchronized List<Symbol> getSymbols() {
            return this.zza;
        }

        public String getText() {
            return zza();
        }

        public Element(String str, Rect rect, List list, String str2, Matrix matrix, float f, float f2, List list2) {
            super(str, rect, list, str2, matrix);
            this.zzb = f;
            this.zzc = f2;
            this.zza = list2;
        }
    }
}
