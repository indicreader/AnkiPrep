package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzec {
    private static final String zzA;
    private static final String zzB;
    private static final String zzC;
    private static final String zzD;
    private static final String zzE;
    private static final String zzF;
    private static final String zzG;
    private static final String zzH;
    private static final String zzI;
    private static final String zzJ;

    @Deprecated
    public static final zzec zza;

    @Deprecated
    public static final zzn zzb;
    private static final String zzr;
    private static final String zzs;
    private static final String zzt;
    private static final String zzu;
    private static final String zzv;
    private static final String zzw;
    private static final String zzx;
    private static final String zzy;
    private static final String zzz;
    public final CharSequence zzc;
    public final Layout.Alignment zzd;
    public final Layout.Alignment zze;
    public final Bitmap zzf;
    public final float zzg;
    public final int zzh;
    public final int zzi;
    public final float zzj;
    public final int zzk;
    public final float zzl;
    public final float zzm;
    public final int zzn;
    public final float zzo;
    public final int zzp;
    public final float zzq;

    static {
        zzea zzeaVar = new zzea();
        zzeaVar.zzl("");
        zza = zzeaVar.zzp();
        zzr = Integer.toString(0, 36);
        zzs = Integer.toString(17, 36);
        zzt = Integer.toString(1, 36);
        zzu = Integer.toString(2, 36);
        zzv = Integer.toString(3, 36);
        zzw = Integer.toString(18, 36);
        zzx = Integer.toString(4, 36);
        zzy = Integer.toString(5, 36);
        zzz = Integer.toString(6, 36);
        zzA = Integer.toString(7, 36);
        zzB = Integer.toString(8, 36);
        zzC = Integer.toString(9, 36);
        zzD = Integer.toString(10, 36);
        zzE = Integer.toString(11, 36);
        zzF = Integer.toString(12, 36);
        zzG = Integer.toString(13, 36);
        zzH = Integer.toString(14, 36);
        zzI = Integer.toString(15, 36);
        zzJ = Integer.toString(16, 36);
        zzb = new zzn() { // from class: com.google.android.gms.internal.ads.zzdy
        };
    }

    public final boolean equals(Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzec zzecVar = (zzec) obj;
            if (TextUtils.equals(this.zzc, zzecVar.zzc) && this.zzd == zzecVar.zzd && this.zze == zzecVar.zze && ((bitmap = this.zzf) != null ? !((bitmap2 = zzecVar.zzf) == null || !bitmap.sameAs(bitmap2)) : zzecVar.zzf == null) && this.zzg == zzecVar.zzg && this.zzh == zzecVar.zzh && this.zzi == zzecVar.zzi && this.zzj == zzecVar.zzj && this.zzk == zzecVar.zzk && this.zzl == zzecVar.zzl && this.zzm == zzecVar.zzm && this.zzn == zzecVar.zzn && this.zzo == zzecVar.zzo && this.zzp == zzecVar.zzp && this.zzq == zzecVar.zzq) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzc, this.zzd, this.zze, this.zzf, Float.valueOf(this.zzg), Integer.valueOf(this.zzh), Integer.valueOf(this.zzi), Float.valueOf(this.zzj), Integer.valueOf(this.zzk), Float.valueOf(this.zzl), Float.valueOf(this.zzm), false, Integer.valueOf(ViewCompat.MEASURED_STATE_MASK), Integer.valueOf(this.zzn), Float.valueOf(this.zzo), Integer.valueOf(this.zzp), Float.valueOf(this.zzq)});
    }

    public final Bundle zza() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.zzc;
        if (charSequence != null) {
            bundle.putCharSequence(zzr, charSequence);
            CharSequence charSequence2 = this.zzc;
            if (charSequence2 instanceof Spanned) {
                ArrayList<? extends Parcelable> zza2 = zzef.zza((Spanned) charSequence2);
                if (!zza2.isEmpty()) {
                    bundle.putParcelableArrayList(zzs, zza2);
                }
            }
        }
        bundle.putSerializable(zzt, this.zzd);
        bundle.putSerializable(zzu, this.zze);
        bundle.putFloat(zzx, this.zzg);
        bundle.putInt(zzy, this.zzh);
        bundle.putInt(zzz, this.zzi);
        bundle.putFloat(zzA, this.zzj);
        bundle.putInt(zzB, this.zzk);
        bundle.putInt(zzC, this.zzn);
        bundle.putFloat(zzD, this.zzo);
        bundle.putFloat(zzE, this.zzl);
        bundle.putFloat(zzF, this.zzm);
        bundle.putBoolean(zzH, false);
        bundle.putInt(zzG, ViewCompat.MEASURED_STATE_MASK);
        bundle.putInt(zzI, this.zzp);
        bundle.putFloat(zzJ, this.zzq);
        if (this.zzf != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            zzek.zzf(this.zzf.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream));
            bundle.putByteArray(zzw, byteArrayOutputStream.toByteArray());
        }
        return bundle;
    }

    public final zzea zzb() {
        return new zzea(this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzec(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z, int i5, int i6, float f6, zzeb zzebVar) {
        if (charSequence == null) {
            bitmap.getClass();
        } else {
            zzek.zzd(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.zzc = SpannedString.valueOf(charSequence);
        } else {
            this.zzc = charSequence != null ? charSequence.toString() : null;
        }
        this.zzd = alignment;
        this.zze = alignment2;
        this.zzf = bitmap;
        this.zzg = f;
        this.zzh = i;
        this.zzi = i2;
        this.zzj = f2;
        this.zzk = i3;
        this.zzl = f4;
        this.zzm = f5;
        this.zzn = i4;
        this.zzo = f3;
        this.zzp = i6;
        this.zzq = f6;
    }
}
