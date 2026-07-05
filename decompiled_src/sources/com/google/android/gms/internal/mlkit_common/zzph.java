package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes3.dex */
final class zzph extends zzpt {
    private final zzle zza;
    private final String zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final ModelType zze;
    private final zzlk zzf;
    private final int zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzph(zzle zzleVar, String str, boolean z, boolean z2, ModelType modelType, zzlk zzlkVar, int i, zzpg zzpgVar) {
        this.zza = zzleVar;
        this.zzb = str;
        this.zzc = z;
        this.zzd = z2;
        this.zze = modelType;
        this.zzf = zzlkVar;
        this.zzg = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzpt) {
            zzpt zzptVar = (zzpt) obj;
            if (this.zza.equals(zzptVar.zzc()) && this.zzb.equals(zzptVar.zze()) && this.zzc == zzptVar.zzg() && this.zzd == zzptVar.zzf() && this.zze.equals(zzptVar.zzb()) && this.zzf.equals(zzptVar.zzd()) && this.zzg == zzptVar.zza()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
        return (((((((((hashCode * 1000003) ^ (true != this.zzc ? 1237 : 1231)) * 1000003) ^ (true == this.zzd ? 1231 : 1237)) * 1000003) ^ this.zze.hashCode()) * 1000003) ^ this.zzf.hashCode()) * 1000003) ^ this.zzg;
    }

    public final String toString() {
        return "RemoteModelLoggingOptions{errorCode=" + this.zza.toString() + ", tfliteSchemaVersion=" + this.zzb + ", shouldLogRoughDownloadTime=" + this.zzc + ", shouldLogExactDownloadTime=" + this.zzd + ", modelType=" + this.zze.toString() + ", downloadStatus=" + this.zzf.toString() + ", failureStatusCode=" + this.zzg + "}";
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpt
    public final int zza() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpt
    public final ModelType zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpt
    public final zzle zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpt
    public final zzlk zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpt
    public final String zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpt
    public final boolean zzf() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpt
    public final boolean zzg() {
        return this.zzc;
    }
}
