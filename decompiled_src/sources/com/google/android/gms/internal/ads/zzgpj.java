package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgpj {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    public /* synthetic */ zzgpj(zzgpd zzgpdVar, zzgpi zzgpiVar) {
        Map map;
        Map map2;
        Map map3;
        Map map4;
        map = zzgpdVar.zza;
        this.zza = new HashMap(map);
        map2 = zzgpdVar.zzb;
        this.zzb = new HashMap(map2);
        map3 = zzgpdVar.zzc;
        this.zzc = new HashMap(map3);
        map4 = zzgpdVar.zzd;
        this.zzd = new HashMap(map4);
    }

    public final zzggc zza(zzgpc zzgpcVar, @Nullable zzghc zzghcVar) throws GeneralSecurityException {
        zzgpf zzgpfVar = new zzgpf(zzgpcVar.getClass(), zzgpcVar.zzd(), null);
        if (!this.zzb.containsKey(zzgpfVar)) {
            throw new GeneralSecurityException("No Key Parser for requested key type " + zzgpfVar.toString() + " available");
        }
        return ((zzgnh) this.zzb.get(zzgpfVar)).zza(zzgpcVar, zzghcVar);
    }

    public final zzggq zzb(zzgpc zzgpcVar) throws GeneralSecurityException {
        zzgpf zzgpfVar = new zzgpf(zzgpcVar.getClass(), zzgpcVar.zzd(), null);
        if (!this.zzd.containsKey(zzgpfVar)) {
            throw new GeneralSecurityException("No Parameters Parser for requested key type " + zzgpfVar.toString() + " available");
        }
        return ((zzgoi) this.zzd.get(zzgpfVar)).zza(zzgpcVar);
    }

    public final zzgpc zzc(zzggc zzggcVar, Class cls, @Nullable zzghc zzghcVar) throws GeneralSecurityException {
        zzgph zzgphVar = new zzgph(zzggcVar.getClass(), cls, null);
        if (!this.zza.containsKey(zzgphVar)) {
            throw new GeneralSecurityException("No Key serializer for " + zzgphVar.toString() + " available");
        }
        return ((zzgnl) this.zza.get(zzgphVar)).zza(zzggcVar, zzghcVar);
    }

    public final zzgpc zzd(zzggq zzggqVar, Class cls) throws GeneralSecurityException {
        zzgph zzgphVar = new zzgph(zzggqVar.getClass(), cls, null);
        if (!this.zzc.containsKey(zzgphVar)) {
            throw new GeneralSecurityException("No Key Format serializer for " + zzgphVar.toString() + " available");
        }
        return ((zzgom) this.zzc.get(zzgphVar)).zza(zzggqVar);
    }

    public final boolean zzi(zzgpc zzgpcVar) {
        return this.zzb.containsKey(new zzgpf(zzgpcVar.getClass(), zzgpcVar.zzd(), null));
    }

    public final boolean zzj(zzgpc zzgpcVar) {
        return this.zzd.containsKey(new zzgpf(zzgpcVar.getClass(), zzgpcVar.zzd(), null));
    }
}
