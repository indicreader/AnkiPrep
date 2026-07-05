package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
public final class zzrg implements zzqs {
    private final zzmx zza;
    private zzps zzb = new zzps();
    private final int zzc;

    private zzrg(zzmx zzmxVar, int i) {
        this.zza = zzmxVar;
        zzrp.zza();
        this.zzc = i;
    }

    public static zzqs zzf(zzmx zzmxVar) {
        return new zzrg(zzmxVar, 0);
    }

    public static zzqs zzg(zzmx zzmxVar, int i) {
        return new zzrg(zzmxVar, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzqs
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzqs
    public final zzqs zzb(zzmw zzmwVar) {
        this.zza.zzf(zzmwVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzqs
    public final zzqs zzc(zzps zzpsVar) {
        this.zzb = zzpsVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzqs
    public final String zzd() {
        zzpu zzf = this.zza.zzj().zzf();
        return (zzf == null || zzab.zzb(zzf.zzk())) ? "NA" : (String) Preconditions.checkNotNull(zzf.zzk());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzqs
    public final byte[] zze(int i, boolean z) {
        this.zzb.zzf(Boolean.valueOf(1 == (i ^ 1)));
        this.zzb.zze(false);
        this.zza.zzi(this.zzb.zzm());
        try {
            zzrp.zza();
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzkz.zza).ignoreNullValues(true).build().encode(this.zza.zzj()).getBytes("utf-8");
            }
            zzmz zzj = this.zza.zzj();
            zzde zzdeVar = new zzde();
            zzkz.zza.configure(zzdeVar);
            return zzdeVar.zza().zza(zzj);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}
