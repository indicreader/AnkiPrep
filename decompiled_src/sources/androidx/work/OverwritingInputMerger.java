package androidx.work;

import androidx.work.Data;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class OverwritingInputMerger extends InputMerger {
    @Override // androidx.work.InputMerger
    public Data merge(List<Data> inputs) {
        Data.Builder builder = new Data.Builder();
        HashMap hashMap = new HashMap();
        Iterator<Data> it = inputs.iterator();
        while (it.hasNext()) {
            hashMap.putAll(it.next().getKeyValueMap());
        }
        builder.putAll(hashMap);
        return builder.build();
    }
}
