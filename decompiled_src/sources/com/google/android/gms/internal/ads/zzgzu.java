package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgzp;
import com.google.android.gms.internal.ads.zzgzu;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzgzu<MessageType extends zzgzu<MessageType, BuilderType>, BuilderType extends zzgzp<MessageType, BuilderType>> extends zzgxt<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzhcq zzc = zzhcq.zzc();

    private final int zza(zzhby zzhbyVar) {
        return zzhbn.zza().zzb(getClass()).zza(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgzu zzaC(Class cls) {
        Map map = zzb;
        zzgzu zzgzuVar = (zzgzu) map.get(cls);
        if (zzgzuVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzgzuVar = (zzgzu) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzgzuVar == null) {
            zzgzuVar = (zzgzu) ((zzgzu) zzhcz.zzg(cls)).zzb(6, null, null);
            if (zzgzuVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzgzuVar);
        }
        return zzgzuVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzgzu zzaE(zzgzu zzgzuVar, zzgyl zzgylVar) throws zzhag {
        zzgzf zzgzfVar = zzgzf.zza;
        zzgyt zzl = zzgylVar.zzl();
        zzgzu zzaD = zzgzuVar.zzaD();
        try {
            zzhby zzb2 = zzhbn.zza().zzb(zzaD.getClass());
            zzb2.zzh(zzaD, zzgyu.zzq(zzl), zzgzfVar);
            zzb2.zzf(zzaD);
            try {
                zzl.zzz(0);
                zzc(zzaD);
                zzc(zzaD);
                return zzaD;
            } catch (zzhag e) {
                e.zzh(zzaD);
                throw e;
            }
        } catch (zzhag e2) {
            e = e2;
            if (e.zzl()) {
                e = new zzhag(e);
            }
            e.zzh(zzaD);
            throw e;
        } catch (zzhco e3) {
            zzhag zza = e3.zza();
            zza.zzh(zzaD);
            throw zza;
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzhag) {
                throw ((zzhag) e4.getCause());
            }
            zzhag zzhagVar = new zzhag(e4);
            zzhagVar.zzh(zzaD);
            throw zzhagVar;
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof zzhag) {
                throw ((zzhag) e5.getCause());
            }
            throw e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzgzu zzaF(zzgzu zzgzuVar, byte[] bArr) throws zzhag {
        zzgzu zzd = zzd(zzgzuVar, bArr, 0, bArr.length, zzgzf.zza);
        zzc(zzd);
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzgzu zzaG(zzgzu zzgzuVar, zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        zzgyt zzl = zzgylVar.zzl();
        zzgzu zzaD = zzgzuVar.zzaD();
        try {
            zzhby zzb2 = zzhbn.zza().zzb(zzaD.getClass());
            zzb2.zzh(zzaD, zzgyu.zzq(zzl), zzgzfVar);
            zzb2.zzf(zzaD);
            try {
                zzl.zzz(0);
                zzc(zzaD);
                return zzaD;
            } catch (zzhag e) {
                e.zzh(zzaD);
                throw e;
            }
        } catch (zzhag e2) {
            e = e2;
            if (e.zzl()) {
                e = new zzhag(e);
            }
            e.zzh(zzaD);
            throw e;
        } catch (zzhco e3) {
            zzhag zza = e3.zza();
            zza.zzh(zzaD);
            throw zza;
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzhag) {
                throw ((zzhag) e4.getCause());
            }
            zzhag zzhagVar = new zzhag(e4);
            zzhagVar.zzh(zzaD);
            throw zzhagVar;
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof zzhag) {
                throw ((zzhag) e5.getCause());
            }
            throw e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzgzu zzaH(zzgzu zzgzuVar, InputStream inputStream, zzgzf zzgzfVar) throws zzhag {
        zzgyt zzH = zzgyt.zzH(inputStream, 4096);
        zzgzu zzaD = zzgzuVar.zzaD();
        try {
            zzhby zzb2 = zzhbn.zza().zzb(zzaD.getClass());
            zzb2.zzh(zzaD, zzgyu.zzq(zzH), zzgzfVar);
            zzb2.zzf(zzaD);
            zzc(zzaD);
            return zzaD;
        } catch (zzhag e) {
            e = e;
            if (e.zzl()) {
                e = new zzhag(e);
            }
            e.zzh(zzaD);
            throw e;
        } catch (zzhco e2) {
            zzhag zza = e2.zza();
            zza.zzh(zzaD);
            throw zza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzhag) {
                throw ((zzhag) e3.getCause());
            }
            zzhag zzhagVar = new zzhag(e3);
            zzhagVar.zzh(zzaD);
            throw zzhagVar;
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzhag) {
                throw ((zzhag) e4.getCause());
            }
            throw e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzgzu zzaI(zzgzu zzgzuVar, byte[] bArr, zzgzf zzgzfVar) throws zzhag {
        zzgzu zzd = zzd(zzgzuVar, bArr, 0, bArr.length, zzgzfVar);
        zzc(zzd);
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzgzz zzaJ() {
        return zzgzv.zzf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzgzz zzaK(zzgzz zzgzzVar) {
        int size = zzgzzVar.size();
        return zzgzzVar.zzd(size == 0 ? 10 : size + size);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzhac zzaL() {
        return zzhat.zzf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzhac zzaM(zzhac zzhacVar) {
        int size = zzhacVar.size();
        return zzhacVar.zzd(size == 0 ? 10 : size + size);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzhad zzaN() {
        return zzhbo.zze();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzhad zzaO(zzhad zzhadVar) {
        int size = zzhadVar.size();
        return zzhadVar.zzd(size == 0 ? 10 : size + size);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzaQ(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zzaR(zzhbe zzhbeVar, String str, Object[] objArr) {
        return new zzhbp(zzhbeVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzaU(Class cls, zzgzu zzgzuVar) {
        zzgzuVar.zzaT();
        zzb.put(cls, zzgzuVar);
    }

    private static zzgzu zzc(zzgzu zzgzuVar) throws zzhag {
        if (zzgzuVar == null || zzgzuVar.zzaX()) {
            return zzgzuVar;
        }
        zzhag zza = new zzhco(zzgzuVar).zza();
        zza.zzh(zzgzuVar);
        throw zza;
    }

    private static zzgzu zzd(zzgzu zzgzuVar, byte[] bArr, int i, int i2, zzgzf zzgzfVar) throws zzhag {
        zzgzu zzaD = zzgzuVar.zzaD();
        try {
            zzhby zzb2 = zzhbn.zza().zzb(zzaD.getClass());
            zzb2.zzi(zzaD, bArr, 0, i2, new zzgxx(zzgzfVar));
            zzb2.zzf(zzaD);
            return zzaD;
        } catch (zzhag e) {
            e = e;
            if (e.zzl()) {
                e = new zzhag(e);
            }
            e.zzh(zzaD);
            throw e;
        } catch (zzhco e2) {
            zzhag zza = e2.zza();
            zza.zzh(zzaD);
            throw zza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzhag) {
                throw ((zzhag) e3.getCause());
            }
            zzhag zzhagVar = new zzhag(e3);
            zzhagVar.zzh(zzaD);
            throw zzhagVar;
        } catch (IndexOutOfBoundsException unused) {
            zzhag zzj = zzhag.zzj();
            zzj.zzh(zzaD);
            throw zzj;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzhbn.zza().zzb(getClass()).zzj(this, (zzgzu) obj);
    }

    public final int hashCode() {
        if (zzaY()) {
            return zzay();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzay = zzay();
        this.zza = zzay;
        return zzay;
    }

    public final String toString() {
        return zzhbg.zza(this, super.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzgzp zzaA() {
        return (zzgzp) zzb(5, null, null);
    }

    public final zzgzp zzaB() {
        zzgzp zzgzpVar = (zzgzp) zzb(5, null, null);
        zzgzpVar.zzaj(this);
        return zzgzpVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzgzu zzaD() {
        return (zzgzu) zzb(4, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final /* synthetic */ zzhbd zzaP() {
        return (zzgzp) zzb(5, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzaS() {
        zzhbn.zza().zzb(getClass()).zzf(this);
        zzaT();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaT() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaV(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final void zzaW(zzgza zzgzaVar) throws IOException {
        zzhbn.zza().zzb(getClass()).zzm(this, zzgzb.zza(zzgzaVar));
    }

    public final boolean zzaX() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) zzb(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzhbn.zza().zzb(getClass()).zzk(this);
        if (!booleanValue) {
            return zzk;
        }
        zzb(2, true != zzk ? null : this, null);
        return zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzaY() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgxt
    public final int zzat(zzhby zzhbyVar) {
        if (zzaY()) {
            int zza = zzhbyVar.zza(this);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zza2 = zzhbyVar.zza(this);
        if (zza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
            return zza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
    }

    final int zzay() {
        return zzhbn.zza().zzb(getClass()).zzb(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzb(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final /* synthetic */ zzhbe zzbk() {
        return (zzgzu) zzb(6, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final int zzaz() {
        int i;
        if (zzaY()) {
            i = zza(null);
            if (i < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i);
            }
        } else {
            i = this.zzd & Integer.MAX_VALUE;
            if (i == Integer.MAX_VALUE) {
                i = zza(null);
                if (i < 0) {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i);
                }
                this.zzd = (this.zzd & Integer.MIN_VALUE) | i;
            }
        }
        return i;
    }
}
