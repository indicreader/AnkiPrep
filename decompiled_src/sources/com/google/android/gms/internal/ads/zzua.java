package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzua extends zzts {
    private final HashMap zza = new HashMap();
    private Handler zzb;
    private zzhy zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void zzA(Object obj, zzut zzutVar, zzcx zzcxVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzB(final Object obj, zzut zzutVar) {
        zzek.zzd(!this.zza.containsKey(obj));
        zzus zzusVar = new zzus() { // from class: com.google.android.gms.internal.ads.zztx
            @Override // com.google.android.gms.internal.ads.zzus
            public final void zza(zzut zzutVar2, zzcx zzcxVar) {
                zzua.this.zzA(obj, zzutVar2, zzcxVar);
            }
        };
        zzty zztyVar = new zzty(this, obj);
        this.zza.put(obj, new zztz(zzutVar, zzusVar, zztyVar));
        Handler handler = this.zzb;
        handler.getClass();
        zzutVar.zzh(handler, zztyVar);
        Handler handler2 = this.zzb;
        handler2.getClass();
        zzutVar.zzg(handler2, zztyVar);
        zzutVar.zzm(zzusVar, this.zzc, zzb());
        if (zzu()) {
            return;
        }
        zzutVar.zzi(zzusVar);
    }

    @Override // com.google.android.gms.internal.ads.zzts
    protected final void zzj() {
        for (zztz zztzVar : this.zza.values()) {
            zztzVar.zza.zzi(zztzVar.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzts
    protected final void zzl() {
        for (zztz zztzVar : this.zza.values()) {
            zztzVar.zza.zzk(zztzVar.zzb);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzts
    public void zzn(zzhy zzhyVar) {
        this.zzc = zzhyVar;
        this.zzb = zzfy.zzw(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzts
    public void zzq() {
        for (zztz zztzVar : this.zza.values()) {
            zztzVar.zza.zzp(zztzVar.zzb);
            zztzVar.zza.zzs(zztzVar.zzc);
            zztzVar.zza.zzr(zztzVar.zzc);
        }
        this.zza.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int zzw(Object obj, int i) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long zzx(Object obj, long j, zzur zzurVar) {
        return j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzur zzy(Object obj, zzur zzurVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzut
    public void zzz() throws IOException {
        Iterator it = this.zza.values().iterator();
        while (it.hasNext()) {
            ((zztz) it.next()).zza.zzz();
        }
    }
}
