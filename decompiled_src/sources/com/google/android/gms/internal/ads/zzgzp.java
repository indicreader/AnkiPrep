package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgzp;
import com.google.android.gms.internal.ads.zzgzu;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public class zzgzp<MessageType extends zzgzu<MessageType, BuilderType>, BuilderType extends zzgzp<MessageType, BuilderType>> extends zzgxs<MessageType, BuilderType> {
    protected zzgzu zza;
    private final zzgzu zzb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzgzp(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzaY()) {
            this.zza = messagetype.zzaD();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zza(Object obj, Object obj2) {
        zzhbn.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzgxs
    /* renamed from: zzai, reason: merged with bridge method [inline-methods] */
    public final zzgzp clone() {
        zzgzp zzgzpVar = (zzgzp) this.zzb.zzb(5, null, null);
        zzgzpVar.zza = zzan();
        return zzgzpVar;
    }

    public final zzgzp zzaj(zzgzu zzgzuVar) {
        if (!this.zzb.equals(zzgzuVar)) {
            if (!this.zza.zzaY()) {
                zzaq();
            }
            zza(this.zza, zzgzuVar);
        }
        return this;
    }

    public final zzgzp zzak(byte[] bArr, int i, int i2, zzgzf zzgzfVar) throws zzhag {
        if (!this.zza.zzaY()) {
            zzaq();
        }
        try {
            zzhbn.zza().zzb(this.zza.getClass()).zzi(this.zza, bArr, 0, i2, new zzgxx(zzgzfVar));
            return this;
        } catch (zzhag e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzhag.zzj();
        }
    }

    public final MessageType zzal() {
        MessageType zzan = zzan();
        if (zzan.zzaX()) {
            return zzan;
        }
        throw new zzhco(zzan);
    }

    @Override // com.google.android.gms.internal.ads.zzhbd
    /* renamed from: zzam, reason: merged with bridge method [inline-methods] */
    public MessageType zzan() {
        if (!this.zza.zzaY()) {
            return (MessageType) this.zza;
        }
        this.zza.zzaS();
        return (MessageType) this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzap() {
        if (this.zza.zzaY()) {
            return;
        }
        zzaq();
    }

    protected void zzaq() {
        zzgzu zzaD = this.zzb.zzaD();
        zza(zzaD, this.zza);
        this.zza = zzaD;
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final /* synthetic */ zzhbe zzbk() {
        throw null;
    }
}
