package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes3.dex */
public final class zzpu implements zzpi {
    private final zzlg zza;
    private zzod zzb = new zzod();

    private zzpu(zzlg zzlgVar, int i) {
        this.zza = zzlgVar;
        zzqf.zza();
    }

    public static zzpi zzf(zzlg zzlgVar) {
        return new zzpu(zzlgVar, 0);
    }

    public static zzpi zzg() {
        return new zzpu(new zzlg(), 0);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpi
    public final zzpi zza(zzlf zzlfVar) {
        this.zza.zzf(zzlfVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpi
    public final zzpi zzb(zzlm zzlmVar) {
        this.zza.zzi(zzlmVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpi
    public final zzpi zzc(zzod zzodVar) {
        this.zzb = zzodVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpi
    public final String zzd() {
        zzof zzf = this.zza.zzk().zzf();
        return (zzf == null || zzag.zzc(zzf.zzk())) ? "NA" : (String) Preconditions.checkNotNull(zzf.zzk());
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpi
    public final byte[] zze(int i, boolean z) {
        this.zzb.zzf(Boolean.valueOf(1 == (i ^ 1)));
        this.zzb.zze(false);
        this.zza.zzj(this.zzb.zzm());
        try {
            zzqf.zza();
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzjj.zza).ignoreNullValues(true).build().encode(this.zza.zzk()).getBytes("utf-8");
            }
            zzli zzk = this.zza.zzk();
            zzbs zzbsVar = new zzbs();
            zzjj.zza.configure(zzbsVar);
            return zzbsVar.zza().zza(zzk);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}
