package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzvf implements zzup, zzuo {
    private final zzup[] zza;
    private zzuo zze;
    private zzws zzf;
    private final zzuc zzi;
    private final ArrayList zzc = new ArrayList();
    private final HashMap zzd = new HashMap();
    private zzwj zzh = new zzub(new zzwj[0]);
    private final IdentityHashMap zzb = new IdentityHashMap();
    private zzup[] zzg = new zzup[0];

    public zzvf(zzuc zzucVar, long[] jArr, zzup... zzupVarArr) {
        this.zzi = zzucVar;
        this.zza = zzupVarArr;
        for (int i = 0; i < zzupVarArr.length; i++) {
            long j = jArr[i];
            if (j != 0) {
                this.zza[i] = new zzwp(zzupVarArr[i], j);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zza(long j, zzmj zzmjVar) {
        zzup[] zzupVarArr = this.zzg;
        return (zzupVarArr.length > 0 ? zzupVarArr[0] : this.zza[0]).zza(j, zzmjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final long zzb() {
        return this.zzh.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final long zzc() {
        return this.zzh.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zzd() {
        long j = -9223372036854775807L;
        for (zzup zzupVar : this.zzg) {
            long zzd = zzupVar.zzd();
            if (zzd != -9223372036854775807L) {
                if (j == -9223372036854775807L) {
                    for (zzup zzupVar2 : this.zzg) {
                        if (zzupVar2 == zzupVar) {
                            break;
                        }
                        if (zzupVar2.zze(zzd) != zzd) {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j = zzd;
                } else if (zzd != j) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (j != -9223372036854775807L && zzupVar.zze(j) != j) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zze(long j) {
        long zze = this.zzg[0].zze(j);
        int i = 1;
        while (true) {
            zzup[] zzupVarArr = this.zzg;
            if (i >= zzupVarArr.length) {
                return zze;
            }
            if (zzupVarArr[i].zze(zze) != zze) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zzf(zzyi[] zzyiVarArr, boolean[] zArr, zzwh[] zzwhVarArr, boolean[] zArr2, long j) {
        int length;
        int length2 = zzyiVarArr.length;
        int[] iArr = new int[length2];
        int[] iArr2 = new int[length2];
        int i = 0;
        int i2 = 0;
        while (true) {
            length = zzyiVarArr.length;
            if (i2 >= length) {
                break;
            }
            zzwh zzwhVar = zzwhVarArr[i2];
            Integer num = zzwhVar != null ? (Integer) this.zzb.get(zzwhVar) : null;
            iArr[i2] = num == null ? -1 : num.intValue();
            zzyi zzyiVar = zzyiVarArr[i2];
            if (zzyiVar != null) {
                String str = zzyiVar.zze().zzc;
                iArr2[i2] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr2[i2] = -1;
            }
            i2++;
        }
        this.zzb.clear();
        zzwh[] zzwhVarArr2 = new zzwh[length];
        zzwh[] zzwhVarArr3 = new zzwh[length];
        zzyi[] zzyiVarArr2 = new zzyi[length];
        ArrayList arrayList = new ArrayList(this.zza.length);
        long j2 = j;
        int i3 = 0;
        while (i3 < this.zza.length) {
            for (int i4 = i; i4 < zzyiVarArr.length; i4++) {
                zzwhVarArr3[i4] = iArr[i4] == i3 ? zzwhVarArr[i4] : null;
                if (iArr2[i4] == i3) {
                    zzyi zzyiVar2 = zzyiVarArr[i4];
                    zzyiVar2.getClass();
                    zzcz zzczVar = (zzcz) this.zzd.get(zzyiVar2.zze());
                    zzczVar.getClass();
                    zzyiVarArr2[i4] = new zzve(zzyiVar2, zzczVar);
                } else {
                    zzyiVarArr2[i4] = null;
                }
            }
            ArrayList arrayList2 = arrayList;
            zzyi[] zzyiVarArr3 = zzyiVarArr2;
            zzwh[] zzwhVarArr4 = zzwhVarArr3;
            long zzf = this.zza[i3].zzf(zzyiVarArr2, zArr, zzwhVarArr3, zArr2, j2);
            if (i3 == 0) {
                j2 = zzf;
            } else if (zzf != j2) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for (int i5 = 0; i5 < zzyiVarArr.length; i5++) {
                if (iArr2[i5] == i3) {
                    zzwh zzwhVar2 = zzwhVarArr4[i5];
                    zzwhVar2.getClass();
                    zzwhVarArr2[i5] = zzwhVar2;
                    this.zzb.put(zzwhVar2, Integer.valueOf(i3));
                    z = true;
                } else if (iArr[i5] == i3) {
                    zzek.zzf(zzwhVarArr4[i5] == null);
                }
            }
            if (z) {
                arrayList2.add(this.zza[i3]);
            }
            i3++;
            arrayList = arrayList2;
            zzyiVarArr2 = zzyiVarArr3;
            zzwhVarArr3 = zzwhVarArr4;
            i = 0;
        }
        int i6 = i;
        System.arraycopy(zzwhVarArr2, i6, zzwhVarArr, i6, length);
        zzup[] zzupVarArr = (zzup[]) arrayList.toArray(new zzup[i6]);
        this.zzg = zzupVarArr;
        this.zzh = new zzub(zzupVarArr);
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final /* bridge */ /* synthetic */ void zzg(zzwj zzwjVar) {
        zzuo zzuoVar = this.zze;
        zzuoVar.getClass();
        zzuoVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final zzws zzh() {
        zzws zzwsVar = this.zzf;
        zzwsVar.getClass();
        return zzwsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzuo
    public final void zzi(zzup zzupVar) {
        this.zzc.remove(zzupVar);
        if (!this.zzc.isEmpty()) {
            return;
        }
        int i = 0;
        for (zzup zzupVar2 : this.zza) {
            i += zzupVar2.zzh().zzc;
        }
        zzcz[] zzczVarArr = new zzcz[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            zzup[] zzupVarArr = this.zza;
            if (i2 < zzupVarArr.length) {
                zzws zzh = zzupVarArr[i2].zzh();
                int i4 = zzh.zzc;
                int i5 = 0;
                while (i5 < i4) {
                    zzcz zzb = zzh.zzb(i5);
                    zzcz zzc = zzb.zzc(i2 + ":" + zzb.zzc);
                    this.zzd.put(zzc, zzb);
                    zzczVarArr[i3] = zzc;
                    i5++;
                    i3++;
                }
                i2++;
            } else {
                this.zzf = new zzws(zzczVarArr);
                zzuo zzuoVar = this.zze;
                zzuoVar.getClass();
                zzuoVar.zzi(this);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzj(long j, boolean z) {
        for (zzup zzupVar : this.zzg) {
            zzupVar.zzj(j, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzk() throws IOException {
        int i = 0;
        while (true) {
            zzup[] zzupVarArr = this.zza;
            if (i >= zzupVarArr.length) {
                return;
            }
            zzupVarArr[i].zzk();
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzl(zzuo zzuoVar, long j) {
        this.zze = zzuoVar;
        Collections.addAll(this.zzc, this.zza);
        int i = 0;
        while (true) {
            zzup[] zzupVarArr = this.zza;
            if (i >= zzupVarArr.length) {
                return;
            }
            zzupVarArr[i].zzl(this, j);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final void zzm(long j) {
        this.zzh.zzm(j);
    }

    public final zzup zzn(int i) {
        zzup zzupVar = this.zza[i];
        return zzupVar instanceof zzwp ? ((zzwp) zzupVar).zzn() : zzupVar;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final boolean zzo(zzlg zzlgVar) {
        if (!this.zzc.isEmpty()) {
            int size = this.zzc.size();
            for (int i = 0; i < size; i++) {
                ((zzup) this.zzc.get(i)).zzo(zzlgVar);
            }
            return false;
        }
        return this.zzh.zzo(zzlgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final boolean zzp() {
        return this.zzh.zzp();
    }
}
