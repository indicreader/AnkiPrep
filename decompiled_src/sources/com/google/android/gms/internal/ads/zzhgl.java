package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public class zzhgl extends zzhgo implements zzarm {
    zzarn zza;
    protected final String zzb = "moov";

    public zzhgl(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final String zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final void zzb(zzhgp zzhgpVar, ByteBuffer byteBuffer, long j, zzarj zzarjVar) throws IOException {
        zzhgpVar.zzb();
        byteBuffer.remaining();
        byteBuffer.remaining();
        this.zzd = zzhgpVar;
        this.zzf = zzhgpVar.zzb();
        zzhgpVar.zze(zzhgpVar.zzb() + j);
        this.zzg = zzhgpVar.zzb();
        this.zzc = zzarjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final void zzc(zzarn zzarnVar) {
        this.zza = zzarnVar;
    }
}
