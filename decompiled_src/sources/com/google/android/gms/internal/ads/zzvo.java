package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzvo implements zzzg, zzug {
    final /* synthetic */ zzvt zza;
    private final Uri zzc;
    private final zzhx zzd;
    private final zzvi zze;
    private final zzacx zzf;
    private final zzeo zzg;
    private volatile boolean zzi;
    private long zzk;
    private zzaea zzm;
    private boolean zzn;
    private final zzadr zzh = new zzadr();
    private boolean zzj = true;
    private final long zzb = zzui.zza();
    private zzhb zzl = zzi(0);

    public zzvo(zzvt zzvtVar, Uri uri, zzgw zzgwVar, zzvi zzviVar, zzacx zzacxVar, zzeo zzeoVar) {
        this.zza = zzvtVar;
        this.zzc = uri;
        this.zzd = new zzhx(zzgwVar);
        this.zze = zzviVar;
        this.zzf = zzacxVar;
        this.zzg = zzeoVar;
    }

    public static /* bridge */ /* synthetic */ void zzf(zzvo zzvoVar, long j, long j2) {
        zzvoVar.zzh.zza = j;
        zzvoVar.zzk = j2;
        zzvoVar.zzj = true;
        zzvoVar.zzn = false;
    }

    private final zzhb zzi(long j) {
        Map map;
        zzgz zzgzVar = new zzgz();
        zzgzVar.zzd(this.zzc);
        zzgzVar.zzc(j);
        zzgzVar.zza(6);
        map = zzvt.zzb;
        zzgzVar.zzb(map);
        return zzgzVar.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zza(zzfp zzfpVar) {
        long zzR;
        long max;
        if (this.zzn) {
            zzR = this.zza.zzR(true);
            max = Math.max(zzR, this.zzk);
        } else {
            max = this.zzk;
        }
        int zzb = zzfpVar.zzb();
        zzaea zzaeaVar = this.zzm;
        zzaeaVar.getClass();
        zzady.zzb(zzaeaVar, zzfpVar, zzb);
        zzaeaVar.zzt(max, 1, zzb, 0, null);
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzzg
    public final void zzg() {
        this.zzi = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01e3 A[EDGE_INSN: B:101:0x01e3->B:79:0x01e3 BREAK  A[LOOP:1: B:60:0x01a0->B:71:0x01a0], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009e A[Catch: all -> 0x0208, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000b, B:11:0x003c, B:12:0x0041, B:15:0x0057, B:17:0x005d, B:21:0x0093, B:23:0x009e, B:24:0x00aa, B:26:0x00b4, B:27:0x00c0, B:29:0x00ca, B:30:0x00d6, B:32:0x00e0, B:33:0x00f2, B:35:0x00fc, B:37:0x0102, B:41:0x0132, B:42:0x0139, B:44:0x0146, B:46:0x014e, B:47:0x016b, B:111:0x010c, B:114:0x0120, B:123:0x0069, B:126:0x007f), top: B:5:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b4 A[Catch: all -> 0x0208, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000b, B:11:0x003c, B:12:0x0041, B:15:0x0057, B:17:0x005d, B:21:0x0093, B:23:0x009e, B:24:0x00aa, B:26:0x00b4, B:27:0x00c0, B:29:0x00ca, B:30:0x00d6, B:32:0x00e0, B:33:0x00f2, B:35:0x00fc, B:37:0x0102, B:41:0x0132, B:42:0x0139, B:44:0x0146, B:46:0x014e, B:47:0x016b, B:111:0x010c, B:114:0x0120, B:123:0x0069, B:126:0x007f), top: B:5:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ca A[Catch: all -> 0x0208, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000b, B:11:0x003c, B:12:0x0041, B:15:0x0057, B:17:0x005d, B:21:0x0093, B:23:0x009e, B:24:0x00aa, B:26:0x00b4, B:27:0x00c0, B:29:0x00ca, B:30:0x00d6, B:32:0x00e0, B:33:0x00f2, B:35:0x00fc, B:37:0x0102, B:41:0x0132, B:42:0x0139, B:44:0x0146, B:46:0x014e, B:47:0x016b, B:111:0x010c, B:114:0x0120, B:123:0x0069, B:126:0x007f), top: B:5:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e0 A[Catch: all -> 0x0208, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000b, B:11:0x003c, B:12:0x0041, B:15:0x0057, B:17:0x005d, B:21:0x0093, B:23:0x009e, B:24:0x00aa, B:26:0x00b4, B:27:0x00c0, B:29:0x00ca, B:30:0x00d6, B:32:0x00e0, B:33:0x00f2, B:35:0x00fc, B:37:0x0102, B:41:0x0132, B:42:0x0139, B:44:0x0146, B:46:0x014e, B:47:0x016b, B:111:0x010c, B:114:0x0120, B:123:0x0069, B:126:0x007f), top: B:5:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fc A[Catch: all -> 0x0208, TRY_LEAVE, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000b, B:11:0x003c, B:12:0x0041, B:15:0x0057, B:17:0x005d, B:21:0x0093, B:23:0x009e, B:24:0x00aa, B:26:0x00b4, B:27:0x00c0, B:29:0x00ca, B:30:0x00d6, B:32:0x00e0, B:33:0x00f2, B:35:0x00fc, B:37:0x0102, B:41:0x0132, B:42:0x0139, B:44:0x0146, B:46:0x014e, B:47:0x016b, B:111:0x010c, B:114:0x0120, B:123:0x0069, B:126:0x007f), top: B:5:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0132 A[Catch: all -> 0x0208, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000b, B:11:0x003c, B:12:0x0041, B:15:0x0057, B:17:0x005d, B:21:0x0093, B:23:0x009e, B:24:0x00aa, B:26:0x00b4, B:27:0x00c0, B:29:0x00ca, B:30:0x00d6, B:32:0x00e0, B:33:0x00f2, B:35:0x00fc, B:37:0x0102, B:41:0x0132, B:42:0x0139, B:44:0x0146, B:46:0x014e, B:47:0x016b, B:111:0x010c, B:114:0x0120, B:123:0x0069, B:126:0x007f), top: B:5:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0146 A[Catch: all -> 0x0208, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000b, B:11:0x003c, B:12:0x0041, B:15:0x0057, B:17:0x005d, B:21:0x0093, B:23:0x009e, B:24:0x00aa, B:26:0x00b4, B:27:0x00c0, B:29:0x00ca, B:30:0x00d6, B:32:0x00e0, B:33:0x00f2, B:35:0x00fc, B:37:0x0102, B:41:0x0132, B:42:0x0139, B:44:0x0146, B:46:0x014e, B:47:0x016b, B:111:0x010c, B:114:0x0120, B:123:0x0069, B:126:0x007f), top: B:5:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0186 A[Catch: all -> 0x0205, TryCatch #1 {all -> 0x0205, blocks: (B:50:0x017b, B:52:0x0186, B:53:0x018b, B:55:0x018f), top: B:49:0x017b }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x018f A[Catch: all -> 0x0205, TRY_LEAVE, TryCatch #1 {all -> 0x0205, blocks: (B:50:0x017b, B:52:0x0186, B:53:0x018b, B:55:0x018f), top: B:49:0x017b }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0228 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[LOOP:0: B:2:0x0004->B:87:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x020e  */
    @Override // com.google.android.gms.internal.ads.zzzg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzh() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 553
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvo.zzh():void");
    }
}
