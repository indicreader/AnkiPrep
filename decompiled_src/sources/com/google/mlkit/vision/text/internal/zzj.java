package com.google.mlkit.vision.text.internal;

import android.graphics.Matrix;
import android.graphics.Point;
import android.util.SparseArray;
import com.google.android.gms.internal.mlkit_vision_text_common.zzab;
import com.google.android.gms.internal.mlkit_vision_text_common.zzbk;
import com.google.android.gms.internal.mlkit_vision_text_common.zzbn;
import com.google.android.gms.internal.mlkit_vision_text_common.zzbx;
import com.google.android.gms.internal.mlkit_vision_text_common.zzcs;
import com.google.android.gms.internal.mlkit_vision_text_common.zzu;
import com.google.android.gms.internal.mlkit_vision_text_common.zzv;
import com.google.mlkit.vision.text.Text;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes4.dex */
final class zzj {
    static final zzv zza = zzv.zza("\n");
    private static final Comparator zzb = new Comparator() { // from class: com.google.mlkit.vision.text.internal.zzi
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((Integer) ((Map.Entry) obj).getValue()).compareTo((Integer) ((Map.Entry) obj2).getValue());
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Text zza(com.google.android.gms.internal.mlkit_vision_text_common.zzl[] zzlVarArr, final Matrix matrix) {
        SparseArray sparseArray = new SparseArray();
        int i = 0;
        for (com.google.android.gms.internal.mlkit_vision_text_common.zzl zzlVar : zzlVarArr) {
            SparseArray sparseArray2 = (SparseArray) sparseArray.get(zzlVar.zzj);
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                sparseArray.append(zzlVar.zzj, sparseArray2);
            }
            sparseArray2.append(zzlVar.zzk, zzlVar);
        }
        zzbk zzbkVar = new zzbk();
        int i2 = 0;
        while (i2 < sparseArray.size()) {
            SparseArray sparseArray3 = (SparseArray) sparseArray.valueAt(i2);
            zzbk zzbkVar2 = new zzbk();
            for (int i3 = i; i3 < sparseArray3.size(); i3++) {
                zzbkVar2.zza((com.google.android.gms.internal.mlkit_vision_text_common.zzl) sparseArray3.valueAt(i3));
            }
            zzbn zzb2 = zzbkVar2.zzb();
            List zza2 = zzbx.zza(zzb2, new zzu() { // from class: com.google.mlkit.vision.text.internal.zze
                @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzu
                public final Object zza(Object obj) {
                    final Matrix matrix2 = matrix;
                    com.google.android.gms.internal.mlkit_vision_text_common.zzl zzlVar2 = (com.google.android.gms.internal.mlkit_vision_text_common.zzl) obj;
                    List zzb3 = zza.zzb(zzlVar2.zzb);
                    return new Text.Line(zzab.zzb(zzlVar2.zze) ? "" : zzlVar2.zze, zza.zza(zzb3), zzb3, zzab.zzb(zzlVar2.zzg) ? "und" : zzlVar2.zzg, matrix2, zzbx.zza(Arrays.asList(zzlVar2.zza), new zzu() { // from class: com.google.mlkit.vision.text.internal.zzh
                        @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzu
                        public final Object zza(Object obj2) {
                            Matrix matrix3 = matrix2;
                            com.google.android.gms.internal.mlkit_vision_text_common.zzr zzrVar = (com.google.android.gms.internal.mlkit_vision_text_common.zzr) obj2;
                            List zzb4 = zza.zzb(zzrVar.zzb);
                            return new Text.Element(zzab.zzb(zzrVar.zzd) ? "" : zzrVar.zzd, zza.zza(zzb4), zzb4, zzab.zzb(zzrVar.zzf) ? "und" : zzrVar.zzf, matrix3, zzrVar.zze, zzrVar.zzb.zze, zzbn.zzh());
                        }
                    }), zzlVar2.zzf, zzlVar2.zzb.zze);
                }
            });
            com.google.android.gms.internal.mlkit_vision_text_common.zzf zzfVar = ((com.google.android.gms.internal.mlkit_vision_text_common.zzl) zzb2.get(i)).zzb;
            zzcs listIterator = zzb2.listIterator(i);
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MIN_VALUE;
            while (listIterator.hasNext()) {
                com.google.android.gms.internal.mlkit_vision_text_common.zzf zzfVar2 = ((com.google.android.gms.internal.mlkit_vision_text_common.zzl) listIterator.next()).zzb;
                int i8 = -zzfVar.zza;
                int i9 = -zzfVar.zzb;
                zzcs zzcsVar = listIterator;
                double sin = Math.sin(Math.toRadians(zzfVar.zze));
                SparseArray sparseArray4 = sparseArray;
                int i10 = i2;
                double cos = Math.cos(Math.toRadians(zzfVar.zze));
                zzbk zzbkVar3 = zzbkVar;
                List list = zza2;
                Point point = new Point(zzfVar2.zza, zzfVar2.zzb);
                point.offset(i8, i9);
                int i11 = (int) ((r13[0].x * cos) + (r13[0].y * sin));
                r13[0].x = i11;
                int i12 = (int) (((-r13[0].x) * sin) + (r13[0].y * cos));
                r13[0].y = i12;
                Point[] pointArr = {point, new Point(zzfVar2.zzc + i11, i12), new Point(zzfVar2.zzc + i11, zzfVar2.zzd + i12), new Point(i11, i12 + zzfVar2.zzd)};
                i7 = i7;
                i4 = i4;
                for (int i13 = 0; i13 < 4; i13++) {
                    Point point2 = pointArr[i13];
                    i5 = Math.min(i5, point2.x);
                    i4 = Math.max(i4, point2.x);
                    i6 = Math.min(i6, point2.y);
                    i7 = Math.max(i7, point2.y);
                }
                listIterator = zzcsVar;
                sparseArray = sparseArray4;
                i2 = i10;
                zzbkVar = zzbkVar3;
                zza2 = list;
            }
            zzbk zzbkVar4 = zzbkVar;
            SparseArray sparseArray5 = sparseArray;
            int i14 = i2;
            int i15 = i4;
            int i16 = i7;
            List list2 = zza2;
            int i17 = zzfVar.zza;
            int i18 = zzfVar.zzb;
            double sin2 = Math.sin(Math.toRadians(zzfVar.zze));
            double cos2 = Math.cos(Math.toRadians(zzfVar.zze));
            Point[] pointArr2 = {new Point(i5, i6), new Point(i15, i6), new Point(i15, i16), new Point(i5, i16)};
            int i19 = 0;
            for (int i20 = 4; i19 < i20; i20 = 4) {
                pointArr2[i19].x = (int) ((pointArr2[i19].x * cos2) - (pointArr2[i19].y * sin2));
                pointArr2[i19].y = (int) ((pointArr2[i19].x * sin2) + (pointArr2[i19].y * cos2));
                pointArr2[i19].offset(i17, i18);
                i19++;
            }
            List asList = Arrays.asList(pointArr2);
            zzbkVar4.zza(new Text.TextBlock(zza.zzb(zzbx.zza(list2, new zzu() { // from class: com.google.mlkit.vision.text.internal.zzf
                @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzu
                public final Object zza(Object obj) {
                    return ((Text.Line) obj).getText();
                }
            })), zza.zza(asList), asList, zzb(list2), matrix, list2));
            i2 = i14 + 1;
            zzbkVar = zzbkVar4;
            sparseArray = sparseArray5;
            i = 0;
        }
        zzbn zzb3 = zzbkVar.zzb();
        return new Text(zza.zzb(zzbx.zza(zzb3, new zzu() { // from class: com.google.mlkit.vision.text.internal.zzg
            @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzu
            public final Object zza(Object obj) {
                return ((Text.TextBlock) obj).getText();
            }
        })), zzb3);
    }

    private static String zzb(List list) {
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String recognizedLanguage = ((Text.Line) it.next()).getRecognizedLanguage();
            hashMap.put(recognizedLanguage, Integer.valueOf((hashMap.containsKey(recognizedLanguage) ? ((Integer) hashMap.get(recognizedLanguage)).intValue() : 0) + 1));
        }
        Set entrySet = hashMap.entrySet();
        if (entrySet.isEmpty()) {
            return "und";
        }
        String str = (String) ((Map.Entry) Collections.max(entrySet, zzb)).getKey();
        return zzab.zzb(str) ? "und" : str;
    }
}
