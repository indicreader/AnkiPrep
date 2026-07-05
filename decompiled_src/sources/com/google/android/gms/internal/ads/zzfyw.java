package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
abstract class zzfyw implements zzgaw {

    @CheckForNull
    private transient Set zza;

    @CheckForNull
    private transient Collection zzb;

    @CheckForNull
    private transient Map zzc;

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzgaw) {
            return zzs().equals(((zzgaw) obj).zzs());
        }
        return false;
    }

    public final int hashCode() {
        return zzs().hashCode();
    }

    public final String toString() {
        return zzs().toString();
    }

    abstract Collection zzf();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Iterator zzg() {
        throw null;
    }

    abstract Map zzj();

    abstract Set zzl();

    @Override // com.google.android.gms.internal.ads.zzgaw
    public boolean zzq(Object obj, Object obj2) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgaw
    public final Collection zzr() {
        Collection collection = this.zzb;
        if (collection != null) {
            return collection;
        }
        Collection zzf = zzf();
        this.zzb = zzf;
        return zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzgaw
    public final Map zzs() {
        Map map = this.zzc;
        if (map != null) {
            return map;
        }
        Map zzj = zzj();
        this.zzc = zzj;
        return zzj;
    }

    public final Set zzt() {
        Set set = this.zza;
        if (set != null) {
            return set;
        }
        Set zzl = zzl();
        this.zza = zzl;
        return zzl;
    }
}
