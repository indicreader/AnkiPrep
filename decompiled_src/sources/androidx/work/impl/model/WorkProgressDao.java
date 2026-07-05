package androidx.work.impl.model;

import androidx.work.Data;
import java.util.List;

/* loaded from: classes2.dex */
public interface WorkProgressDao {
    void delete(String workSpecId);

    void deleteAll();

    Data getProgressForWorkSpecId(String workSpecId);

    List<Data> getProgressForWorkSpecIds(List<String> workSpecIds);

    void insert(WorkProgress progress);
}
