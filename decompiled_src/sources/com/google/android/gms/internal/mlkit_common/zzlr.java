package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes3.dex */
public final class zzlr {
    private final String zza;
    private final String zzb;
    private final zzlp zzc;
    private final String zzd;
    private final String zze;
    private final zzlo zzf;
    private final Long zzg;
    private final Boolean zzh;
    private final Boolean zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzlr(zzln zzlnVar, zzlq zzlqVar) {
        String str;
        zzlp zzlpVar;
        String str2;
        zzlo zzloVar;
        str = zzlnVar.zza;
        this.zza = str;
        this.zzb = null;
        zzlpVar = zzlnVar.zzb;
        this.zzc = zzlpVar;
        this.zzd = null;
        str2 = zzlnVar.zzc;
        this.zze = str2;
        zzloVar = zzlnVar.zzd;
        this.zzf = zzloVar;
        this.zzg = null;
        this.zzh = null;
        this.zzi = null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzlr)) {
            return false;
        }
        zzlr zzlrVar = (zzlr) obj;
        if (Objects.equal(this.zza, zzlrVar.zza)) {
            String str = zzlrVar.zzb;
            if (Objects.equal(null, null) && Objects.equal(this.zzc, zzlrVar.zzc)) {
                String str2 = zzlrVar.zzd;
                if (Objects.equal(null, null) && Objects.equal(this.zze, zzlrVar.zze) && Objects.equal(this.zzf, zzlrVar.zzf)) {
                    Long l = zzlrVar.zzg;
                    if (Objects.equal(null, null)) {
                        Boolean bool = zzlrVar.zzh;
                        if (Objects.equal(null, null)) {
                            Boolean bool2 = zzlrVar.zzi;
                            if (Objects.equal(null, null)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, this.zzc, null, this.zze, this.zzf, null, null, null);
    }

    public final zzlo zza() {
        return this.zzf;
    }

    public final zzlp zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zze;
    }

    public final String zzd() {
        return this.zza;
    }
}
