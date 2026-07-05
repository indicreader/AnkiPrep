package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzggj {
    private final List zza = new ArrayList();
    private final zzgrw zzb = zzgrw.zza;
    private boolean zzc = false;

    public final void zzd() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzggh) it.next()).zza = false;
        }
    }

    public final zzggj zza(zzggh zzgghVar) {
        zzggj zzggjVar;
        boolean z;
        zzggjVar = zzgghVar.zzf;
        if (zzggjVar != null) {
            throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
        }
        z = zzgghVar.zza;
        if (z) {
            zzd();
        }
        zzgghVar.zzf = this;
        this.zza.add(zzgghVar);
        return this;
    }

    public final zzggm zzb() throws GeneralSecurityException {
        zzggi zzggiVar;
        zzggi zzggiVar2;
        zzggi zzggiVar3;
        int i;
        zzggq zzggqVar;
        zzgpc zzf;
        boolean z;
        zzgge zzggeVar;
        zzggi zzggiVar4;
        zzggi zzggiVar5;
        zzggi zzggiVar6;
        zzggi zzggiVar7;
        zzgge unused;
        zzggi unused2;
        if (this.zzc) {
            throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
        }
        this.zzc = true;
        List list = this.zza;
        zzgvd zzd = zzgvg.zzd();
        int i2 = 0;
        while (i2 < list.size() - 1) {
            int i3 = i2 + 1;
            zzggiVar4 = ((zzggh) list.get(i2)).zze;
            zzggiVar5 = zzggi.zza;
            if (zzggiVar4 == zzggiVar5) {
                zzggiVar6 = ((zzggh) list.get(i3)).zze;
                zzggiVar7 = zzggi.zza;
                if (zzggiVar6 != zzggiVar7) {
                    throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
                }
            }
            i2 = i3;
        }
        HashSet hashSet = new HashSet();
        Integer num = null;
        for (zzggh zzgghVar : this.zza) {
            unused = zzgghVar.zzb;
            zzggiVar = zzgghVar.zze;
            if (zzggiVar != null) {
                zzggiVar2 = zzgghVar.zze;
                zzggiVar3 = zzggi.zza;
                int i4 = 3;
                if (zzggiVar2 == zzggiVar3) {
                    i = 0;
                    while (true) {
                        if (i != 0 && !hashSet.contains(Integer.valueOf(i))) {
                            break;
                        }
                        SecureRandom secureRandom = new SecureRandom();
                        byte[] bArr = new byte[4];
                        int i5 = 0;
                        while (i5 == 0) {
                            secureRandom.nextBytes(bArr);
                            i5 = ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
                        }
                        i = i5;
                    }
                } else {
                    unused2 = zzgghVar.zze;
                    i = 0;
                }
                Integer valueOf = Integer.valueOf(i);
                if (!hashSet.contains(valueOf)) {
                    hashSet.add(valueOf);
                    zzggh.zza(zzgghVar);
                    zzggqVar = zzgghVar.zzd;
                    zzgge zzc = zzgghVar.zzc();
                    if (!zzgge.zza.equals(zzc)) {
                        if (zzgge.zzb.equals(zzc)) {
                            i4 = 4;
                        } else {
                            if (!zzgge.zzc.equals(zzc)) {
                                throw new IllegalStateException("Unknown key status");
                            }
                            i4 = 5;
                        }
                    }
                    if (zzggqVar instanceof zzgnp) {
                        zzf = ((zzgnp) zzggqVar).zzb();
                    } else {
                        zzf = zzgoe.zzd().zzf(zzggqVar, zzgoy.class);
                    }
                    zzgoy zzgoyVar = (zzgoy) zzf;
                    zzgut zza = zzghb.zza(zzgoyVar.zzc());
                    zzgve zzd2 = zzgvf.zzd();
                    zzd2.zzb(i);
                    zzd2.zzd(i4);
                    zzd2.zza(zza);
                    zzd2.zzc(zzgoyVar.zzc().zzf());
                    zzd.zza((zzgvf) zzd2.zzal());
                    z = zzgghVar.zza;
                    if (z) {
                        if (num == null) {
                            zzggeVar = zzgghVar.zzb;
                            if (zzggeVar != zzgge.zza) {
                                throw new GeneralSecurityException("Primary key is not enabled");
                            }
                            num = valueOf;
                        } else {
                            throw new GeneralSecurityException("Two primaries were set");
                        }
                    }
                } else {
                    throw new GeneralSecurityException("Id " + i + " is used twice in the keyset");
                }
            } else {
                throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
            }
        }
        if (num == null) {
            throw new GeneralSecurityException("No primary was set");
        }
        zzd.zzb(num.intValue());
        return zzggm.zzb((zzgvg) zzd.zzal(), this.zzb);
    }
}
