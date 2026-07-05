package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes3.dex */
public final class zzqb extends LazyInstanceMap {
    private zzqb() {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzpl zzplVar = (zzpl) obj;
        MlKitContext mlKitContext = MlKitContext.getInstance();
        return new zzpr(mlKitContext.getApplicationContext(), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), new zzpm(MlKitContext.getInstance().getApplicationContext(), zzplVar), zzplVar.zzb());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzqb(zzqa zzqaVar) {
    }
}
