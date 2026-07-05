package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.core.view.PointerIconCompat;
import java.util.Map;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzxu extends zzdg {
    public static final zzxu zzF;

    @Deprecated
    public static final zzxu zzG;

    @Deprecated
    public static final zzn zzH;
    private static final String zzW;
    private static final String zzX;
    private static final String zzY;
    private static final String zzZ;
    private static final String zzaa;
    private static final String zzab;
    private static final String zzac;
    private static final String zzad;
    private static final String zzae;
    private static final String zzaf;
    private static final String zzag;
    private static final String zzah;
    private static final String zzai;
    private static final String zzaj;
    private static final String zzak;
    private static final String zzal;
    private static final String zzam;
    private static final String zzan;
    private static final String zzao;
    public final boolean zzI;
    public final boolean zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final boolean zzQ;
    public final boolean zzR;
    public final boolean zzS;
    public final boolean zzT;
    public final boolean zzU;
    public final boolean zzV;
    private final SparseArray zzap;
    private final SparseBooleanArray zzaq;

    static {
        zzxu zzxuVar = new zzxu(new zzxs());
        zzF = zzxuVar;
        zzG = zzxuVar;
        zzW = Integer.toString(1000, 36);
        zzX = Integer.toString(1001, 36);
        zzY = Integer.toString(PointerIconCompat.TYPE_HAND, 36);
        zzZ = Integer.toString(PointerIconCompat.TYPE_HELP, 36);
        zzaa = Integer.toString(PointerIconCompat.TYPE_WAIT, 36);
        zzab = Integer.toString(WebSocketProtocol.CLOSE_NO_STATUS_CODE, 36);
        zzac = Integer.toString(PointerIconCompat.TYPE_CELL, 36);
        zzad = Integer.toString(PointerIconCompat.TYPE_CROSSHAIR, 36);
        zzae = Integer.toString(PointerIconCompat.TYPE_TEXT, 36);
        zzaf = Integer.toString(PointerIconCompat.TYPE_VERTICAL_TEXT, 36);
        zzag = Integer.toString(PointerIconCompat.TYPE_ALIAS, 36);
        zzah = Integer.toString(PointerIconCompat.TYPE_COPY, 36);
        zzai = Integer.toString(PointerIconCompat.TYPE_NO_DROP, 36);
        zzaj = Integer.toString(PointerIconCompat.TYPE_ALL_SCROLL, 36);
        zzak = Integer.toString(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, 36);
        zzal = Integer.toString(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, 36);
        zzam = Integer.toString(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, 36);
        zzan = Integer.toString(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 36);
        zzao = Integer.toString(PointerIconCompat.TYPE_ZOOM_IN, 36);
        zzH = new zzn() { // from class: com.google.android.gms.internal.ads.zzxq
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public zzxu(zzxs zzxsVar) {
        super(zzxsVar);
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        SparseArray sparseArray;
        SparseBooleanArray sparseBooleanArray;
        z = zzxsVar.zza;
        this.zzI = z;
        this.zzJ = false;
        z2 = zzxsVar.zzb;
        this.zzK = z2;
        this.zzL = false;
        z3 = zzxsVar.zzc;
        this.zzM = z3;
        this.zzN = false;
        this.zzO = false;
        this.zzP = false;
        this.zzQ = false;
        z4 = zzxsVar.zzd;
        this.zzR = z4;
        z5 = zzxsVar.zze;
        this.zzS = z5;
        z6 = zzxsVar.zzf;
        this.zzT = z6;
        this.zzU = false;
        z7 = zzxsVar.zzg;
        this.zzV = z7;
        sparseArray = zzxsVar.zzh;
        this.zzap = sparseArray;
        sparseBooleanArray = zzxsVar.zzi;
        this.zzaq = sparseBooleanArray;
    }

    public /* synthetic */ zzxu(zzxs zzxsVar, zzxt zzxtVar) {
        this(zzxsVar);
    }

    public static zzxu zzd(Context context) {
        return new zzxu(new zzxs(context));
    }

    @Override // com.google.android.gms.internal.ads.zzdg
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzxu zzxuVar = (zzxu) obj;
            if (super.equals(zzxuVar) && this.zzI == zzxuVar.zzI && this.zzK == zzxuVar.zzK && this.zzM == zzxuVar.zzM && this.zzR == zzxuVar.zzR && this.zzS == zzxuVar.zzS && this.zzT == zzxuVar.zzT && this.zzV == zzxuVar.zzV) {
                SparseBooleanArray sparseBooleanArray = this.zzaq;
                SparseBooleanArray sparseBooleanArray2 = zzxuVar.zzaq;
                int size = sparseBooleanArray.size();
                if (sparseBooleanArray2.size() == size) {
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                                break;
                            }
                            i++;
                        } else {
                            SparseArray sparseArray = this.zzap;
                            SparseArray sparseArray2 = zzxuVar.zzap;
                            int size2 = sparseArray.size();
                            if (sparseArray2.size() == size2) {
                                for (int i2 = 0; i2 < size2; i2++) {
                                    int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                                    if (indexOfKey >= 0) {
                                        Map map = (Map) sparseArray.valueAt(i2);
                                        Map map2 = (Map) sparseArray2.valueAt(indexOfKey);
                                        if (map2.size() == map.size()) {
                                            for (Map.Entry entry : map.entrySet()) {
                                                zzws zzwsVar = (zzws) entry.getKey();
                                                if (map2.containsKey(zzwsVar) && zzfy.zzF(entry.getValue(), map2.get(zzwsVar))) {
                                                }
                                            }
                                        }
                                    }
                                }
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdg
    public final int hashCode() {
        return (((((((((((((((super.hashCode() + 31) * 31) + (this.zzI ? 1 : 0)) * 961) + (this.zzK ? 1 : 0)) * 961) + (this.zzM ? 1 : 0)) * 28629151) + (this.zzR ? 1 : 0)) * 31) + (this.zzS ? 1 : 0)) * 31) + (this.zzT ? 1 : 0)) * 961) + (this.zzV ? 1 : 0)) * 31;
    }

    public final zzxs zzc() {
        return new zzxs(this, null);
    }

    @Deprecated
    public final zzxw zze(int i, zzws zzwsVar) {
        Map map = (Map) this.zzap.get(i);
        if (map != null) {
            return (zzxw) map.get(zzwsVar);
        }
        return null;
    }

    public final boolean zzf(int i) {
        return this.zzaq.get(i);
    }

    @Deprecated
    public final boolean zzg(int i, zzws zzwsVar) {
        Map map = (Map) this.zzap.get(i);
        return map != null && map.containsKey(zzwsVar);
    }
}
