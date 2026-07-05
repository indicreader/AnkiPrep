package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzggs {
    private final Class zza;
    private zzggt zzd;
    private ConcurrentMap zzb = new ConcurrentHashMap();
    private final List zzc = new ArrayList();
    private zzgrw zze = zzgrw.zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzggs(Class cls, zzggr zzggrVar) {
        this.zza = cls;
    }

    public final zzggs zza(@Nullable Object obj, @Nullable Object obj2, zzgvf zzgvfVar) throws GeneralSecurityException {
        zze(obj, obj2, zzgvfVar, false);
        return this;
    }

    public final zzggs zzb(@Nullable Object obj, @Nullable Object obj2, zzgvf zzgvfVar) throws GeneralSecurityException {
        zze(obj, obj2, zzgvfVar, true);
        return this;
    }

    public final zzggs zzc(zzgrw zzgrwVar) {
        if (this.zzb == null) {
            throw new IllegalStateException("setAnnotations cannot be called after build");
        }
        this.zze = zzgrwVar;
        return this;
    }

    public final zzggx zzd() throws GeneralSecurityException {
        ConcurrentMap concurrentMap = this.zzb;
        if (concurrentMap == null) {
            throw new IllegalStateException("build cannot be called twice");
        }
        zzggx zzggxVar = new zzggx(concurrentMap, this.zzc, this.zzd, this.zze, this.zza, null);
        this.zzb = null;
        return zzggxVar;
    }

    private final zzggs zze(@Nullable Object obj, @Nullable Object obj2, zzgvf zzgvfVar, boolean z) throws GeneralSecurityException {
        byte[] array;
        if (this.zzb == null) {
            throw new IllegalStateException("addPrimitive cannot be called after build");
        }
        if (obj != null || obj2 != null) {
            if (zzgvfVar.zzk() == 3) {
                Integer valueOf = Integer.valueOf(zzgvfVar.zza());
                if (zzgvfVar.zzf() == zzgvz.RAW) {
                    valueOf = null;
                }
                zzggc zzb = zzgoe.zzd().zzb(zzgox.zza(zzgvfVar.zzc().zzg(), zzgvfVar.zzc().zzf(), zzgvfVar.zzc().zzc(), zzgvfVar.zzf(), valueOf), zzghc.zza());
                int ordinal = zzgvfVar.zzf().ordinal();
                if (ordinal == 1) {
                    array = ByteBuffer.allocate(5).put((byte) 1).putInt(zzgvfVar.zza()).array();
                } else {
                    if (ordinal != 2) {
                        if (ordinal == 3) {
                            array = zzgfx.zza;
                        } else if (ordinal != 4) {
                            throw new GeneralSecurityException("unknown output prefix type");
                        }
                    }
                    array = ByteBuffer.allocate(5).put((byte) 0).putInt(zzgvfVar.zza()).array();
                }
                zzggt zzggtVar = new zzggt(obj, obj2, array, zzgvfVar.zzk(), zzgvfVar.zzf(), zzgvfVar.zza(), zzgvfVar.zzc().zzg(), zzb);
                ConcurrentMap concurrentMap = this.zzb;
                List list = this.zzc;
                ArrayList arrayList = new ArrayList();
                arrayList.add(zzggtVar);
                zzggv zzggvVar = new zzggv(zzggtVar.zzg(), null);
                List list2 = (List) concurrentMap.put(zzggvVar, Collections.unmodifiableList(arrayList));
                if (list2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.addAll(list2);
                    arrayList2.add(zzggtVar);
                    concurrentMap.put(zzggvVar, Collections.unmodifiableList(arrayList2));
                }
                list.add(zzggtVar);
                if (z) {
                    if (this.zzd != null) {
                        throw new IllegalStateException("you cannot set two primary primitives");
                    }
                    this.zzd = zzggtVar;
                }
                return this;
            }
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
        throw new GeneralSecurityException("at least one of the `fullPrimitive` or `primitive` must be set");
    }
}
