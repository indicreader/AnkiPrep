package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
/* loaded from: classes3.dex */
final class zzln implements zzlu {
    private final zzlj zza;
    private final zzml zzb;
    private final boolean zzc;
    private final zzjp zzd;

    private zzln(zzml zzmlVar, zzjp zzjpVar, zzlj zzljVar) {
        this.zzb = zzmlVar;
        this.zzc = zzjpVar.zzc(zzljVar);
        this.zzd = zzjpVar;
        this.zza = zzljVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzln zzc(zzml zzmlVar, zzjp zzjpVar, zzlj zzljVar) {
        return new zzln(zzmlVar, zzjpVar, zzljVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final int zza(Object obj) {
        zzml zzmlVar = this.zzb;
        int zzb = zzmlVar.zzb(zzmlVar.zzc(obj));
        if (!this.zzc) {
            return zzb;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzc(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final Object zze() {
        return this.zza.zzbI().zzaG();
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final void zzf(Object obj) {
        this.zzb.zzg(obj);
        this.zzd.zzb(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final void zzg(Object obj, Object obj2) {
        zzlw.zzF(this.zzb, obj, obj2);
        if (this.zzc) {
            zzlw.zzE(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzio zzioVar) throws IOException {
        zzkc zzkcVar = (zzkc) obj;
        if (zzkcVar.zzc == zzmm.zzc()) {
            zzkcVar.zzc = zzmm.zze();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final void zzi(Object obj, zznd zzndVar) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final boolean zzj(Object obj, Object obj2) {
        if (!this.zzb.zzc(obj).equals(this.zzb.zzc(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final boolean zzk(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }
}
