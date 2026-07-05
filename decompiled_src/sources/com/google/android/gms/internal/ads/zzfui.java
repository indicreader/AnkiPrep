package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfui {
    public static ListenableFuture zza(Task task, CancellationTokenSource cancellationTokenSource) {
        final zzfuh zzfuhVar = new zzfuh(task, null);
        task.addOnCompleteListener(zzgfe.zzb(), new OnCompleteListener() { // from class: com.google.android.gms.internal.ads.zzfug
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                zzfuh zzfuhVar2 = zzfuh.this;
                if (task2.isCanceled()) {
                    zzfuhVar2.cancel(false);
                    return;
                }
                if (task2.isSuccessful()) {
                    zzfuhVar2.zzc(task2.getResult());
                    return;
                }
                Exception exception = task2.getException();
                if (exception != null) {
                    zzfuhVar2.zzd(exception);
                    return;
                }
                throw new IllegalStateException();
            }
        });
        return zzfuhVar;
    }
}
