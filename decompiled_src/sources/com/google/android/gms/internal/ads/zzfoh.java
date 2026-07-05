package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfoh extends zzfod {
    private static final Pattern zza = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final zzfof zzb;
    private final zzfoe zzc;
    private zzfqk zze;
    private zzfpi zzf;
    private final List zzd = new ArrayList();
    private boolean zzg = false;
    private boolean zzh = false;
    private final String zzi = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfoh(zzfoe zzfoeVar, zzfof zzfofVar) {
        this.zzc = zzfoeVar;
        this.zzb = zzfofVar;
        zzk(null);
        if (zzfofVar.zzd() == zzfog.HTML || zzfofVar.zzd() == zzfog.JAVASCRIPT) {
            this.zzf = new zzfpj(zzfofVar.zza());
        } else {
            this.zzf = new zzfpm(zzfofVar.zzi(), null);
        }
        this.zzf.zzk();
        zzfov.zza().zzd(this);
        zzfpb.zza().zzd(this.zzf.zza(), zzfoeVar.zzb());
    }

    private final void zzk(View view) {
        this.zze = new zzfqk(view);
    }

    @Override // com.google.android.gms.internal.ads.zzfod
    public final void zzb(View view, zzfok zzfokVar, String str) {
        zzfoy zzfoyVar;
        if (this.zzh) {
            return;
        }
        if (zza.matcher("Ad overlay").matches()) {
            Iterator it = this.zzd.iterator();
            while (true) {
                if (!it.hasNext()) {
                    zzfoyVar = null;
                    break;
                } else {
                    zzfoyVar = (zzfoy) it.next();
                    if (zzfoyVar.zzb().get() == view) {
                        break;
                    }
                }
            }
            if (zzfoyVar == null) {
                this.zzd.add(new zzfoy(view, zzfokVar, "Ad overlay"));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
    }

    @Override // com.google.android.gms.internal.ads.zzfod
    public final void zzc() {
        if (this.zzh) {
            return;
        }
        this.zze.clear();
        if (!this.zzh) {
            this.zzd.clear();
        }
        this.zzh = true;
        zzfpb.zza().zzc(this.zzf.zza());
        zzfov.zza().zze(this);
        this.zzf.zzc();
        this.zzf = null;
    }

    @Override // com.google.android.gms.internal.ads.zzfod
    public final void zzd(View view) {
        if (this.zzh || zzf() == view) {
            return;
        }
        zzk(view);
        this.zzf.zzb();
        Collection<zzfoh> zzc = zzfov.zza().zzc();
        if (zzc == null || zzc.isEmpty()) {
            return;
        }
        for (zzfoh zzfohVar : zzc) {
            if (zzfohVar != this && zzfohVar.zzf() == view) {
                zzfohVar.zze.clear();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfod
    public final void zze() {
        if (this.zzg) {
            return;
        }
        this.zzg = true;
        zzfov.zza().zzf(this);
        this.zzf.zzi(zzfpc.zzb().zza());
        this.zzf.zze(zzfot.zza().zzb());
        this.zzf.zzg(this, this.zzb);
    }

    public final View zzf() {
        return (View) this.zze.get();
    }

    public final zzfpi zzg() {
        return this.zzf;
    }

    public final String zzh() {
        return this.zzi;
    }

    public final List zzi() {
        return this.zzd;
    }

    public final boolean zzj() {
        return this.zzg && !this.zzh;
    }
}
