package com.google.common.util.concurrent;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public interface FutureCallback<V> {
    void onFailure(Throwable th);

    void onSuccess(@ParametricNullness V v);
}
