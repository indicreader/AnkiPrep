package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes3.dex */
final class zzpf extends zzps {
    private zzle zza;
    private String zzb;
    private boolean zzc;
    private boolean zzd;
    private ModelType zze;
    private zzlk zzf;
    private int zzg;
    private byte zzh;

    @Override // com.google.android.gms.internal.mlkit_common.zzps
    public final zzps zza(zzlk zzlkVar) {
        if (zzlkVar == null) {
            throw new NullPointerException("Null downloadStatus");
        }
        this.zzf = zzlkVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzps
    public final zzps zzb(zzle zzleVar) {
        if (zzleVar == null) {
            throw new NullPointerException("Null errorCode");
        }
        this.zza = zzleVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzps
    public final zzps zzc(int i) {
        this.zzg = i;
        this.zzh = (byte) (this.zzh | 4);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzps
    public final zzps zzd(ModelType modelType) {
        if (modelType == null) {
            throw new NullPointerException("Null modelType");
        }
        this.zze = modelType;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzps
    public final zzps zze(boolean z) {
        this.zzd = z;
        this.zzh = (byte) (this.zzh | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzps
    public final zzps zzf(boolean z) {
        this.zzc = z;
        this.zzh = (byte) (this.zzh | 1);
        return this;
    }

    public final zzps zzg(String str) {
        this.zzb = "NA";
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzps
    public final zzpt zzh() {
        zzle zzleVar;
        String str;
        ModelType modelType;
        zzlk zzlkVar;
        if (this.zzh != 7 || (zzleVar = this.zza) == null || (str = this.zzb) == null || (modelType = this.zze) == null || (zzlkVar = this.zzf) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.zza == null) {
                sb.append(" errorCode");
            }
            if (this.zzb == null) {
                sb.append(" tfliteSchemaVersion");
            }
            if ((this.zzh & 1) == 0) {
                sb.append(" shouldLogRoughDownloadTime");
            }
            if ((this.zzh & 2) == 0) {
                sb.append(" shouldLogExactDownloadTime");
            }
            if (this.zze == null) {
                sb.append(" modelType");
            }
            if (this.zzf == null) {
                sb.append(" downloadStatus");
            }
            if ((this.zzh & 4) == 0) {
                sb.append(" failureStatusCode");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        }
        return new zzph(zzleVar, str, this.zzc, this.zzd, modelType, zzlkVar, this.zzg, null);
    }
}
