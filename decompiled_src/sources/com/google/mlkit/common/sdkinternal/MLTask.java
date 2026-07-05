package com.google.mlkit.common.sdkinternal;

import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTaskInput;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes4.dex */
public abstract class MLTask<T, S extends MLTaskInput> extends ModelResource {
    public MLTask() {
    }

    public abstract T run(S s) throws MlKitException;

    /* JADX INFO: Access modifiers changed from: protected */
    public MLTask(TaskQueue taskQueue) {
        super(taskQueue);
    }
}
