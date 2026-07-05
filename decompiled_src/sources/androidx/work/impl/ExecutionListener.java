package androidx.work.impl;

/* loaded from: classes2.dex */
public interface ExecutionListener {
    void onExecuted(String workSpecId, boolean needsReschedule);
}
