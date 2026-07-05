package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgpd {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    public zzgpd() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public final zzgpd zza(zzgnh zzgnhVar) throws GeneralSecurityException {
        zzgpf zzgpfVar = new zzgpf(zzgnhVar.zzd(), zzgnhVar.zzc(), null);
        if (this.zzb.containsKey(zzgpfVar)) {
            zzgnh zzgnhVar2 = (zzgnh) this.zzb.get(zzgpfVar);
            if (!zzgnhVar2.equals(zzgnhVar) || !zzgnhVar.equals(zzgnhVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzgpfVar.toString()));
            }
        } else {
            this.zzb.put(zzgpfVar, zzgnhVar);
        }
        return this;
    }

    public final zzgpd zzb(zzgnl zzgnlVar) throws GeneralSecurityException {
        zzgph zzgphVar = new zzgph(zzgnlVar.zzc(), zzgnlVar.zzd(), null);
        if (this.zza.containsKey(zzgphVar)) {
            zzgnl zzgnlVar2 = (zzgnl) this.zza.get(zzgphVar);
            if (!zzgnlVar2.equals(zzgnlVar) || !zzgnlVar.equals(zzgnlVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzgphVar.toString()));
            }
        } else {
            this.zza.put(zzgphVar, zzgnlVar);
        }
        return this;
    }

    public final zzgpd zzc(zzgoi zzgoiVar) throws GeneralSecurityException {
        zzgpf zzgpfVar = new zzgpf(zzgoiVar.zzd(), zzgoiVar.zzc(), null);
        if (this.zzd.containsKey(zzgpfVar)) {
            zzgoi zzgoiVar2 = (zzgoi) this.zzd.get(zzgpfVar);
            if (!zzgoiVar2.equals(zzgoiVar) || !zzgoiVar.equals(zzgoiVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzgpfVar.toString()));
            }
        } else {
            this.zzd.put(zzgpfVar, zzgoiVar);
        }
        return this;
    }

    public final zzgpd zzd(zzgom zzgomVar) throws GeneralSecurityException {
        zzgph zzgphVar = new zzgph(zzgomVar.zzc(), zzgomVar.zzd(), null);
        if (this.zzc.containsKey(zzgphVar)) {
            zzgom zzgomVar2 = (zzgom) this.zzc.get(zzgphVar);
            if (!zzgomVar2.equals(zzgomVar) || !zzgomVar.equals(zzgomVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzgphVar.toString()));
            }
        } else {
            this.zzc.put(zzgphVar, zzgomVar);
        }
        return this;
    }

    public zzgpd(zzgpj zzgpjVar) {
        this.zza = new HashMap(zzgpj.zzf(zzgpjVar));
        this.zzb = new HashMap(zzgpj.zze(zzgpjVar));
        this.zzc = new HashMap(zzgpj.zzh(zzgpjVar));
        this.zzd = new HashMap(zzgpj.zzg(zzgpjVar));
    }
}
