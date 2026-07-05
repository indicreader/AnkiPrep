package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzcgc {
    private static final AtomicInteger zza = new AtomicInteger(0);
    private static final AtomicInteger zzb = new AtomicInteger(0);

    /* JADX INFO: Access modifiers changed from: protected */
    public static AtomicInteger zzD() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static AtomicInteger zzE() {
        return zzb;
    }

    public static int zzs() {
        return zza.get();
    }

    public static int zzu() {
        return zzb.get();
    }

    public abstract long zzA();

    public abstract long zzB();

    public abstract Integer zzC();

    public abstract void zzF(Uri[] uriArr, String str);

    public abstract void zzG(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z);

    public abstract void zzH();

    public abstract void zzI(long j);

    public abstract void zzJ(int i);

    public abstract void zzK(int i);

    public abstract void zzL(zzcgb zzcgbVar);

    public abstract void zzM(int i);

    public abstract void zzN(int i);

    public abstract void zzO(boolean z);

    public abstract void zzP(Integer num);

    public abstract void zzQ(boolean z);

    public abstract void zzR(int i);

    public abstract void zzS(Surface surface, boolean z) throws IOException;

    public abstract void zzT(float f, boolean z) throws IOException;

    public abstract void zzU();

    public abstract boolean zzV();

    public abstract int zzr();

    public abstract int zzt();

    public abstract long zzv();

    public abstract long zzw();

    public abstract long zzx();

    public abstract long zzy();

    public abstract long zzz();
}
