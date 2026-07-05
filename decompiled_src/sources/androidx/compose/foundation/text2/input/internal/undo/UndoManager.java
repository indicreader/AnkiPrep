package androidx.compose.foundation.text2.input.internal.undo;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UndoManager.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u001d*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001dB/\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\u000b\u0010\u001a\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\u000b\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bR\u0014\u0010\t\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/undo/UndoManager;", "T", "", "initialUndoStack", "", "initialRedoStack", "capacity", "", "(Ljava/util/List;Ljava/util/List;I)V", "canRedo", "", "getCanRedo$foundation_release", "()Z", "canUndo", "getCanUndo$foundation_release", "redoStack", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "size", "getSize", "()I", "undoStack", "clearHistory", "", "record", "undoableAction", "(Ljava/lang/Object;)V", "redo", "()Ljava/lang/Object;", "undo", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class UndoManager<T> {
    private final int capacity;
    private SnapshotStateList<T> redoStack;
    private SnapshotStateList<T> undoStack;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public UndoManager() {
        this(null, null, 0, 7, null);
    }

    public UndoManager(List<? extends T> list, List<? extends T> list2, int i) {
        this.capacity = i;
        SnapshotStateList<T> snapshotStateList = new SnapshotStateList<>();
        snapshotStateList.addAll(list);
        this.undoStack = snapshotStateList;
        SnapshotStateList<T> snapshotStateList2 = new SnapshotStateList<>();
        snapshotStateList2.addAll(list2);
        this.redoStack = snapshotStateList2;
        if (i < 0) {
            throw new IllegalArgumentException("Capacity must be a positive integer".toString());
        }
        if (getSize() > i) {
            throw new IllegalArgumentException(("Initial list of undo and redo operations have a size=(" + getSize() + ") greater than the given capacity=(" + i + ").").toString());
        }
    }

    public /* synthetic */ UndoManager(List list, List list2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? CollectionsKt.emptyList() : list, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 4) != 0 ? 100 : i);
    }

    public final boolean getCanUndo$foundation_release() {
        return !this.undoStack.isEmpty();
    }

    public final boolean getCanRedo$foundation_release() {
        return !this.redoStack.isEmpty();
    }

    public final int getSize() {
        return this.undoStack.size() + this.redoStack.size();
    }

    public final void record(T undoableAction) {
        this.redoStack.clear();
        while (getSize() > this.capacity - 1) {
            CollectionsKt.removeFirst(this.undoStack);
        }
        this.undoStack.add(undoableAction);
    }

    public final T undo() {
        if (!getCanUndo$foundation_release()) {
            throw new IllegalStateException("It's an error to call undo while there is nothing to undo. Please first check `canUndo` value before calling the `undo` function.".toString());
        }
        T t = (T) CollectionsKt.removeLast(this.undoStack);
        this.redoStack.add(t);
        return t;
    }

    public final T redo() {
        if (!getCanRedo$foundation_release()) {
            throw new IllegalStateException("It's an error to call redo while there is nothing to redo. Please first check `canRedo` value before calling the `redo` function.".toString());
        }
        T t = (T) CollectionsKt.removeLast(this.redoStack);
        this.undoStack.add(t);
        return t;
    }

    public final void clearHistory() {
        this.undoStack.clear();
        this.redoStack.clear();
    }

    /* compiled from: UndoManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u00020\u00010\u0004\"\u0006\b\u0001\u0010\u0006\u0018\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/undo/UndoManager$Companion;", "", "()V", "createSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text2/input/internal/undo/UndoManager;", "T", "itemSaver", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ <T> Saver<UndoManager<T>, Object> createSaver(final Saver<T, Object> itemSaver) {
            Intrinsics.needClassReification();
            return new Saver<UndoManager<T>, Object>() { // from class: androidx.compose.foundation.text2.input.internal.undo.UndoManager$Companion$createSaver$1
                @Override // androidx.compose.runtime.saveable.Saver
                public Object save(SaverScope saverScope, UndoManager<T> undoManager) {
                    int i;
                    SnapshotStateList snapshotStateList;
                    SnapshotStateList snapshotStateList2;
                    SnapshotStateList snapshotStateList3;
                    SnapshotStateList snapshotStateList4;
                    Saver<T, Object> saver = itemSaver;
                    List createListBuilder = CollectionsKt.createListBuilder();
                    i = ((UndoManager) undoManager).capacity;
                    createListBuilder.add(Integer.valueOf(i));
                    snapshotStateList = ((UndoManager) undoManager).undoStack;
                    createListBuilder.add(Integer.valueOf(snapshotStateList.size()));
                    snapshotStateList2 = ((UndoManager) undoManager).redoStack;
                    createListBuilder.add(Integer.valueOf(snapshotStateList2.size()));
                    snapshotStateList3 = ((UndoManager) undoManager).undoStack;
                    SnapshotStateList snapshotStateList5 = snapshotStateList3;
                    int size = snapshotStateList5.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        createListBuilder.add(saver.save(saverScope, snapshotStateList5.get(i2)));
                    }
                    snapshotStateList4 = ((UndoManager) undoManager).redoStack;
                    SnapshotStateList snapshotStateList6 = snapshotStateList4;
                    int size2 = snapshotStateList6.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        createListBuilder.add(saver.save(saverScope, snapshotStateList6.get(i3)));
                    }
                    return CollectionsKt.build(createListBuilder);
                }

                @Override // androidx.compose.runtime.saveable.Saver
                public UndoManager<T> restore(Object value) {
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                    List list = (List) value;
                    int intValue = ((Number) list.get(0)).intValue();
                    int intValue2 = ((Number) list.get(1)).intValue();
                    int intValue3 = ((Number) list.get(2)).intValue();
                    Saver<T, Object> saver = itemSaver;
                    List createListBuilder = CollectionsKt.createListBuilder();
                    int i = 3;
                    while (i < intValue2 + 3) {
                        T restore = saver.restore(list.get(i));
                        Intrinsics.checkNotNull(restore);
                        createListBuilder.add(restore);
                        i++;
                    }
                    List build = CollectionsKt.build(createListBuilder);
                    Saver<T, Object> saver2 = itemSaver;
                    List createListBuilder2 = CollectionsKt.createListBuilder();
                    while (i < intValue2 + intValue3 + 3) {
                        T restore2 = saver2.restore(list.get(i));
                        Intrinsics.checkNotNull(restore2);
                        createListBuilder2.add(restore2);
                        i++;
                    }
                    return new UndoManager<>(build, CollectionsKt.build(createListBuilder2), intValue);
                }
            };
        }
    }
}
