package com.example.flashcardapp.mcq;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: McqDiagnostics.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\u0004J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/example/flashcardapp/mcq/McqDiagnostics;", "", "()V", "SEPARATOR", "", "TAG", "THIN_SEP", "printReport", "", "mcqs", "", "Lcom/example/flashcardapp/mcq/Mcq;", "label", "printSingleMcq", "mcq", "number", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class McqDiagnostics {
    public static final int $stable = 0;
    public static final McqDiagnostics INSTANCE = new McqDiagnostics();
    private static final String SEPARATOR = "═══════════════════════════════════════════════════════";
    private static final String TAG = "McqDiagnostics";
    private static final String THIN_SEP = "───────────────────────────────────────────────────────";

    private McqDiagnostics() {
    }

    public static /* synthetic */ void printReport$default(McqDiagnostics mcqDiagnostics, List list, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "MCQ Batch";
        }
        mcqDiagnostics.printReport(list, str);
    }

    public final void printReport(List<Mcq> mcqs, String label) {
        boolean z;
        int i;
        Intrinsics.checkNotNullParameter(mcqs, "mcqs");
        Intrinsics.checkNotNullParameter(label, "label");
        Log.i(TAG, "");
        Log.i(TAG, SEPARATOR);
        Log.i(TAG, "  MCQ ENGINE — DIAGNOSTICS REPORT");
        Log.i(TAG, "  Batch: " + label);
        Log.i(TAG, SEPARATOR);
        Log.i(TAG, "");
        Log.i(TAG, "▶ Generation Summary");
        Log.i(TAG, THIN_SEP);
        Log.i(TAG, "  Total MCQs generated: " + mcqs.size());
        List<Mcq> list = mcqs;
        boolean z2 = list instanceof Collection;
        int i2 = 0;
        if (!z2 || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!((Mcq) it.next()).isValid()) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        Log.i(TAG, "  All valid: " + z);
        if (z2 && list.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it2 = list.iterator();
            i = 0;
            while (it2.hasNext()) {
                if ((!((Mcq) it2.next()).isValid()) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (i > 0) {
            Log.w(TAG, "  ⚠️ " + i + " invalid MCQs detected!");
        } else {
            Log.i(TAG, "  ✅ All MCQs pass validation");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            String question = ((Mcq) obj).getQuestion();
            Object obj2 = linkedHashMap.get(question);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(question, obj2);
            }
            ((List) obj2).add(obj);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((List) entry.getValue()).size() > 1) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        if (true ^ linkedHashMap2.isEmpty()) {
            Log.w(TAG, "  ⚠️ " + linkedHashMap2.size() + " duplicate questions found");
        } else {
            Log.i(TAG, "  ✅ No duplicate questions");
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Object obj3 : list) {
            Integer valueOf = Integer.valueOf(((Mcq) obj3).getCorrectIndex());
            Object obj4 = linkedHashMap3.get(valueOf);
            if (obj4 == null) {
                obj4 = (List) new ArrayList();
                linkedHashMap3.put(valueOf, obj4);
            }
            ((List) obj4).add(obj3);
        }
        LinkedHashMap linkedHashMap4 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap3.size()));
        for (Map.Entry entry2 : linkedHashMap3.entrySet()) {
            linkedHashMap4.put(entry2.getKey(), Integer.valueOf(((List) entry2.getValue()).size()));
        }
        Log.i(TAG, "  Correct answer position distribution: " + linkedHashMap4);
        Log.i(TAG, "");
        Log.i(TAG, "▶ Sample MCQs (first " + Math.min(3, mcqs.size()) + ")");
        Log.i(TAG, THIN_SEP);
        for (Object obj5 : CollectionsKt.take(list, 3)) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            INSTANCE.printSingleMcq((Mcq) obj5, i3);
            i2 = i3;
        }
        Log.i(TAG, "");
        Log.i(TAG, "▶ Distractor Source Breakdown");
        Log.i(TAG, THIN_SEP);
        Log.i(TAG, "  (Distractor source levels tracked internally by engine)");
        Log.i(TAG, "  Total distractor slots filled: " + (mcqs.size() * 3));
        Log.i(TAG, "");
        Log.i(TAG, SEPARATOR);
        Log.i(TAG, "  STATUS: ".concat(i == 0 ? "MCQ ENGINE HEALTHY ✅" : "NEEDS ATTENTION ⚠️"));
        Log.i(TAG, SEPARATOR);
        Log.i(TAG, "");
    }

    public static /* synthetic */ void printSingleMcq$default(McqDiagnostics mcqDiagnostics, Mcq mcq, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        mcqDiagnostics.printSingleMcq(mcq, i);
    }

    public final void printSingleMcq(Mcq mcq, int number) {
        Intrinsics.checkNotNullParameter(mcq, "mcq");
        Log.i(TAG, "  MCQ #" + number + ":");
        Log.i(TAG, "    Source Card: " + mcq.getSourceCardId());
        Log.i(TAG, "    Deck:        " + mcq.getDeckHierarchy());
        Log.i(TAG, "    Question:    " + StringsKt.take(mcq.getQuestion(), 100) + (mcq.getQuestion().length() > 100 ? "..." : ""));
        Log.i(TAG, "    Options:");
        int i = 0;
        for (Object obj : mcq.getOptions()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Log.i(TAG, "      " + ((char) (i + 65)) + ") " + StringsKt.take((String) obj, 80) + (i == mcq.getCorrectIndex() ? " ✅" : ""));
            i = i2;
        }
        Log.i(TAG, "    Correct:     " + ((char) (mcq.getCorrectIndex() + 65)) + " (index " + mcq.getCorrectIndex() + ")");
        Log.i(TAG, "    Distractor source card IDs: " + mcq.getDistractorSourceIds());
        Log.i(TAG, "    Valid:       " + mcq.isValid());
        Log.i(TAG, "    ---");
    }
}
