package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzgza extends zzgya {
    private static final Logger zza = Logger.getLogger(zzgza.class.getName());
    private static final boolean zzb = zzhcz.zzA();
    public static final /* synthetic */ int zzf = 0;
    zzgzb zze;

    private zzgza() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgza(zzgyz zzgyzVar) {
    }

    public static int zzA(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static zzgza zzB(byte[] bArr, int i, int i2) {
        return new zzgyw(bArr, 0, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zzw(int i, zzhbe zzhbeVar, zzhby zzhbyVar) {
        int zzz = zzz(i << 3);
        return zzz + zzz + ((zzgxt) zzhbeVar).zzat(zzhbyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(zzhbe zzhbeVar, zzhby zzhbyVar) {
        int zzat = ((zzgxt) zzhbeVar).zzat(zzhbyVar);
        return zzz(zzat) + zzat;
    }

    public static int zzy(String str) {
        int length;
        try {
            length = zzhde.zze(str);
        } catch (zzhdd unused) {
            length = str.getBytes(zzhae.zzb).length;
        }
        return zzz(length) + length;
    }

    public static int zzz(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public final void zzC() {
        if (zzb() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzD(String str, zzhdd zzhddVar) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzhddVar);
        byte[] bytes = str.getBytes(zzhae.zzb);
        try {
            int length = bytes.length;
            zzs(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzgyx(e);
        }
    }

    public abstract void zzH() throws IOException;

    public abstract void zzI(byte b) throws IOException;

    public abstract void zzJ(int i, boolean z) throws IOException;

    public abstract void zzK(int i, zzgyl zzgylVar) throws IOException;

    @Override // com.google.android.gms.internal.ads.zzgya
    public abstract void zza(byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzi(int i) throws IOException;

    public abstract void zzj(int i, long j) throws IOException;

    public abstract void zzk(long j) throws IOException;

    public abstract void zzl(int i, int i2) throws IOException;

    public abstract void zzm(int i) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzn(int i, zzhbe zzhbeVar, zzhby zzhbyVar) throws IOException;

    public abstract void zzo(int i, String str) throws IOException;

    public abstract void zzq(int i, int i2) throws IOException;

    public abstract void zzr(int i, int i2) throws IOException;

    public abstract void zzs(int i) throws IOException;

    public abstract void zzt(int i, long j) throws IOException;

    public abstract void zzu(long j) throws IOException;
}
