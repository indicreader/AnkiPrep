package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgxs;
import com.google.android.gms.internal.ads.zzgxt;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzgxt<MessageType extends zzgxt<MessageType, BuilderType>, BuilderType extends zzgxs<MessageType, BuilderType>> implements zzhbe {
    protected int zza = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public static void zzav(Iterable iterable, List list) {
        byte[] bArr = zzhae.zzd;
        iterable.getClass();
        if (iterable instanceof zzham) {
            List zzh = ((zzham) iterable).zzh();
            zzham zzhamVar = (zzham) list;
            int size = list.size();
            for (Object obj : zzh) {
                if (obj == null) {
                    String str = "Element at index " + (zzhamVar.size() - size) + " is null.";
                    int size2 = zzhamVar.size();
                    while (true) {
                        size2--;
                        if (size2 < size) {
                            break;
                        } else {
                            zzhamVar.remove(size2);
                        }
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof zzgyl) {
                    zzhamVar.zzi((zzgyl) obj);
                } else {
                    zzhamVar.add((String) obj);
                }
            }
            return;
        }
        if (!(iterable instanceof zzhbm)) {
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + iterable.size());
            }
            int size3 = list.size();
            for (Object obj2 : iterable) {
                if (obj2 != null) {
                    list.add(obj2);
                } else {
                    String str2 = "Element at index " + (list.size() - size3) + " is null.";
                    int size4 = list.size();
                    while (true) {
                        size4--;
                        if (size4 < size3) {
                            break;
                        } else {
                            list.remove(size4);
                        }
                    }
                    throw new NullPointerException(str2);
                }
            }
            return;
        }
        list.addAll(iterable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzat(zzhby zzhbyVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final zzgyl zzau() {
        try {
            int zzaz = zzaz();
            zzgyl zzgylVar = zzgyl.zzb;
            byte[] bArr = new byte[zzaz];
            zzgza zzB = zzgza.zzB(bArr, 0, zzaz);
            zzaW(zzB);
            zzB.zzC();
            return new zzgyh(bArr);
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public final void zzaw(OutputStream outputStream) throws IOException {
        int zzaz = zzaz();
        int i = zzgza.zzf;
        if (zzaz > 4096) {
            zzaz = 4096;
        }
        zzgyy zzgyyVar = new zzgyy(outputStream, zzaz);
        zzaW(zzgyyVar);
        zzgyyVar.zzH();
    }

    public final byte[] zzax() {
        try {
            int zzaz = zzaz();
            byte[] bArr = new byte[zzaz];
            zzgza zzB = zzgza.zzB(bArr, 0, zzaz);
            zzaW(zzB);
            zzB.zzC();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
