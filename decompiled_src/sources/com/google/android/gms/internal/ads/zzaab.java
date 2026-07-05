package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzaab implements zzabp, zzdn, zzaax {
    private static final Executor zza = new Executor() { // from class: com.google.android.gms.internal.ads.zzzr
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
        }
    };
    private final Context zzb;
    private final zzcp zzc;
    private final zzaao zzd;
    private final zzaay zze;
    private zzel zzf;
    private zzaal zzg;
    private zzew zzh;
    private zzcq zzi;
    private zzzz zzj;
    private List zzk;
    private Pair zzl;
    private final zzabm zzm;
    private final Executor zzn;
    private int zzo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzaab(zzzs zzzsVar, zzaaa zzaaaVar) {
        Context context;
        zzcp zzcpVar;
        zzaao zzaaoVar;
        context = zzzsVar.zza;
        this.zzb = context;
        zzcpVar = zzzsVar.zzc;
        zzek.zzb(zzcpVar);
        this.zzc = zzcpVar;
        zzaaoVar = zzzsVar.zzd;
        zzek.zzb(zzaaoVar);
        this.zzd = zzaaoVar;
        this.zze = new zzaay(this, zzaaoVar);
        this.zzf = zzel.zza;
        this.zzm = zzabm.zza;
        this.zzn = zza;
        this.zzo = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzabp
    public final zzaao zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzabp
    public final zzabo zzb() {
        zzzz zzzzVar = this.zzj;
        zzek.zzb(zzzzVar);
        return zzzzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabp
    public final void zzc() {
        zzfq.zza.zzb();
        zzfq.zza.zza();
        this.zzl = null;
    }

    @Override // com.google.android.gms.internal.ads.zzabp
    public final void zzd(zzam zzamVar) throws zzabn {
        zzt zztVar;
        int i;
        zzek.zzf(this.zzo == 0);
        zzek.zzb(this.zzk);
        zzel zzelVar = this.zzf;
        Looper myLooper = Looper.myLooper();
        zzek.zzb(myLooper);
        this.zzh = zzelVar.zzb(myLooper, null);
        zzt zztVar2 = zzamVar.zzy;
        if (zztVar2 == null || ((i = zztVar2.zzf) != 7 && i != 6)) {
            zztVar2 = zzt.zza;
        }
        zzt zztVar3 = zztVar2;
        if (zztVar3.zzf == 7) {
            zzr zzc = zztVar3.zzc();
            zzc.zzd(6);
            zztVar = zzc.zzg();
        } else {
            zztVar = zztVar3;
        }
        try {
            zzcp zzcpVar = this.zzc;
            Context context = this.zzb;
            zzw zzwVar = zzw.zzb;
            final zzew zzewVar = this.zzh;
            Objects.requireNonNull(zzewVar);
            this.zzi = zzcpVar.zza(context, zztVar3, zztVar, zzwVar, this, new Executor() { // from class: com.google.android.gms.internal.ads.zzzq
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    zzew.this.zzh(runnable);
                }
            }, zzgaa.zzl(), 0L);
            Pair pair = this.zzl;
            if (pair != null) {
                zzfq zzfqVar = (zzfq) this.zzl.second;
                zzfqVar.zzb();
                zzfqVar.zza();
            }
            this.zzj = new zzzz(this.zzb, this, null);
            Pair pair2 = this.zzl;
            if (pair2 != null) {
                zzfq zzfqVar2 = (zzfq) this.zzl.second;
                zzek.zzb(null);
                zzfqVar2.zzb();
                zzfqVar2.zza();
                throw null;
            }
            this.zzk.getClass();
            throw null;
        } catch (zzdl e) {
            throw new zzabn(e, zzamVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabp
    public final void zze() {
        if (this.zzo == 2) {
            return;
        }
        zzew zzewVar = this.zzh;
        if (zzewVar != null) {
            zzewVar.zze(null);
        }
        this.zzl = null;
        this.zzo = 2;
    }

    @Override // com.google.android.gms.internal.ads.zzabp
    public final void zzf(zzel zzelVar) {
        zzek.zzf(!zzk());
        this.zzf = zzelVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabp
    public final void zzg(Surface surface, zzfq zzfqVar) {
        Pair pair = this.zzl;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((zzfq) this.zzl.second).equals(zzfqVar)) {
            return;
        }
        this.zzl = Pair.create(surface, zzfqVar);
        zzfqVar.zzb();
        zzfqVar.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzabp
    public final void zzh(long j) {
        zzek.zzb(this.zzj);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzabp
    public final void zzi(List list) {
        this.zzk = list;
        if (zzk()) {
            zzek.zzb(this.zzj);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabp
    public final void zzj(zzaal zzaalVar) {
        this.zzg = zzaalVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabp
    public final boolean zzk() {
        return this.zzo == 1;
    }
}
