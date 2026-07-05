package androidx.compose.foundation.text2.input;

import androidx.compose.foundation.text2.input.TextFieldBuffer;
import androidx.compose.foundation.text2.input.TextUndoManager;
import androidx.compose.foundation.text2.input.internal.EditingBuffer;
import androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldState.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0002JKB\u001b\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0015\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0014H\u0000¢\u0006\u0002\b)J\u0010\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,H\u0001J*\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\u00162\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J\"\u00105\u001a\u00020'2\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020'07¢\u0006\u0002\b8H\u0086\bJE\u00109\u001a\u00020'2\b\u0010/\u001a\u0004\u0018\u0001002\b\b\u0002\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u0002042\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020'07¢\u0006\u0002\b8H\u0080\b¢\u0006\u0002\b:J'\u0010;\u001a\u00020'2\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020'07¢\u0006\u0002\b8H\u0080\b¢\u0006\u0002\b<J\u0018\u0010=\u001a\u00020'2\u0006\u0010>\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u0016H\u0002J(\u0010?\u001a\u00020'2\u0006\u0010.\u001a\u00020\u00162\u0006\u0010@\u001a\u00020\u00162\u0006\u0010A\u001a\u00020B2\u0006\u00103\u001a\u000204H\u0002J\u0015\u0010C\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0014H\u0000¢\u0006\u0002\bDJ\u0015\u0010E\u001a\u00020'2\u0006\u0010+\u001a\u00020\u0016H\u0001¢\u0006\u0002\bFJ\u0010\u0010G\u001a\u00020,2\u0006\u0010H\u001a\u00020\u0016H\u0001J\b\u0010I\u001a\u00020\u0003H\u0016R$\u0010\n\u001a\u00020\u000b8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u00020\"8GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\r\u001a\u0004\b$\u0010%¨\u0006L"}, d2 = {"Landroidx/compose/foundation/text2/input/TextFieldState;", "", "initialText", "", "initialSelectionInChars", "Landroidx/compose/ui/text/TextRange;", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "initialTextUndoManager", "Landroidx/compose/foundation/text2/input/TextUndoManager;", "(Ljava/lang/String;JLandroidx/compose/foundation/text2/input/TextUndoManager;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "mainBuffer", "Landroidx/compose/foundation/text2/input/internal/EditingBuffer;", "getMainBuffer$foundation_release$annotations", "()V", "getMainBuffer$foundation_release", "()Landroidx/compose/foundation/text2/input/internal/EditingBuffer;", "setMainBuffer$foundation_release", "(Landroidx/compose/foundation/text2/input/internal/EditingBuffer;)V", "notifyImeListeners", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/text2/input/TextFieldState$NotifyImeListener;", "<set-?>", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "text", "getText", "()Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "setText", "(Landroidx/compose/foundation/text2/input/TextFieldCharSequence;)V", "text$delegate", "Landroidx/compose/runtime/MutableState;", "textUndoManager", "getTextUndoManager$foundation_release", "()Landroidx/compose/foundation/text2/input/TextUndoManager;", "undoState", "Landroidx/compose/foundation/text2/input/UndoState;", "getUndoState$annotations", "getUndoState", "()Landroidx/compose/foundation/text2/input/UndoState;", "addNotifyImeListener", "", "notifyImeListener", "addNotifyImeListener$foundation_release", "commitEdit", "newValue", "Landroidx/compose/foundation/text2/input/TextFieldBuffer;", "commitEditAsUser", "previousValue", "inputTransformation", "Landroidx/compose/foundation/text2/input/InputTransformation;", "notifyImeOfChanges", "", "undoBehavior", "Landroidx/compose/foundation/text2/input/internal/undo/TextFieldEditUndoBehavior;", "edit", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "editAsUser", "editAsUser$foundation_release", "editWithNoSideEffects", "editWithNoSideEffects$foundation_release", "notifyIme", "oldValue", "recordEditForUndo", "postValue", "changes", "Landroidx/compose/foundation/text2/input/TextFieldBuffer$ChangeList;", "removeNotifyImeListener", "removeNotifyImeListener$foundation_release", "resetStateAndNotifyIme", "resetStateAndNotifyIme$foundation_release", "startEdit", AppMeasurementSdk.ConditionalUserProperty.VALUE, "toString", "NotifyImeListener", "Saver", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldState {
    public static final int $stable = 0;
    private EditingBuffer mainBuffer;
    private final MutableVector<NotifyImeListener> notifyImeListeners;

    /* renamed from: text$delegate, reason: from kotlin metadata */
    private final MutableState text;
    private final TextUndoManager textUndoManager;
    private final UndoState undoState;

    /* compiled from: TextFieldState.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bà\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text2/input/TextFieldState$NotifyImeListener;", "", "onChange", "", "oldValue", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "newValue", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public interface NotifyImeListener {
        void onChange(TextFieldCharSequence oldValue, TextFieldCharSequence newValue);
    }

    /* compiled from: TextFieldState.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextFieldEditUndoBehavior.values().length];
            try {
                iArr[TextFieldEditUndoBehavior.ClearHistory.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextFieldEditUndoBehavior.MergeIfPossible.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TextFieldEditUndoBehavior.NeverMerge.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ TextFieldState(String str, long j, TextUndoManager textUndoManager, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, textUndoManager);
    }

    public /* synthetic */ TextFieldState(String str, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j);
    }

    public static /* synthetic */ void getMainBuffer$foundation_release$annotations() {
    }

    public static /* synthetic */ void getUndoState$annotations() {
    }

    /* renamed from: getMainBuffer$foundation_release, reason: from getter */
    public final EditingBuffer getMainBuffer() {
        return this.mainBuffer;
    }

    /* renamed from: getTextUndoManager$foundation_release, reason: from getter */
    public final TextUndoManager getTextUndoManager() {
        return this.textUndoManager;
    }

    public final UndoState getUndoState() {
        return this.undoState;
    }

    public final void setMainBuffer$foundation_release(EditingBuffer editingBuffer) {
        this.mainBuffer = editingBuffer;
    }

    private TextFieldState(String str, long j, TextUndoManager textUndoManager) {
        MutableState mutableStateOf$default;
        this.textUndoManager = textUndoManager;
        this.mainBuffer = new EditingBuffer(str, TextRangeKt.m5244coerceIn8ffj60Q(j, 0, str.length()), (DefaultConstructorMarker) null);
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TextFieldCharSequenceKt.m1097TextFieldCharSequenceFDrldGo(str, j), null, 2, null);
        this.text = mutableStateOf$default;
        this.undoState = new UndoState(this);
        this.notifyImeListeners = new MutableVector<>(new NotifyImeListener[16], 0);
    }

    public static final /* synthetic */ void access$commitEditAsUser(TextFieldState textFieldState, TextFieldCharSequence textFieldCharSequence, InputTransformation inputTransformation, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior) {
        textFieldState.commitEditAsUser(textFieldCharSequence, inputTransformation, z, textFieldEditUndoBehavior);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ TextFieldState(java.lang.String r1, long r2, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r5 = r4 & 1
            if (r5 == 0) goto L6
            java.lang.String r1 = ""
        L6:
            r4 = r4 & 2
            if (r4 == 0) goto L12
            int r2 = r1.length()
            long r2 = androidx.compose.ui.text.TextRangeKt.TextRange(r2)
        L12:
            r4 = 0
            r0.<init>(r1, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.TextFieldState.<init>(java.lang.String, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private TextFieldState(String str, long j) {
        this(str, j, new TextUndoManager(null, null, 3, null), (DefaultConstructorMarker) null);
    }

    public final TextFieldCharSequence getText() {
        return (TextFieldCharSequence) this.text.getValue();
    }

    public final void edit(Function1<? super TextFieldBuffer, Unit> block) {
        TextFieldBuffer startEdit = startEdit(getText());
        block.invoke(startEdit);
        commitEdit(startEdit);
    }

    public String toString() {
        return "TextFieldState(selectionInChars=" + ((Object) TextRange.m5241toStringimpl(getText().getSelectionInChars())) + ", text=\"" + ((Object) getText()) + "\")";
    }

    public final TextFieldBuffer startEdit(TextFieldCharSequence r8) {
        return new TextFieldBuffer(r8, null, null, 6, null);
    }

    public final void commitEdit(TextFieldBuffer newValue) {
        boolean z = newValue.getChanges().getChangeCount() > 0;
        boolean z2 = !TextRange.m5231equalsimpl0(newValue.getSelectionInChars(), this.mainBuffer.m1113getSelectiond9O1mEE());
        if (z || z2) {
            resetStateAndNotifyIme$foundation_release(TextFieldBuffer.m1087toTextFieldCharSequenceOEnZFl4$foundation_release$default(newValue, null, 1, null));
        }
        this.textUndoManager.clearHistory();
    }

    public static /* synthetic */ void editAsUser$foundation_release$default(TextFieldState textFieldState, InputTransformation inputTransformation, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        TextFieldCharSequence text = textFieldState.getText();
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        function1.invoke(textFieldState.getMainBuffer());
        if (textFieldState.getMainBuffer().getChangeTracker().getChangeCount() == 0 && TextRange.m5231equalsimpl0(text.getSelectionInChars(), textFieldState.getMainBuffer().m1113getSelectiond9O1mEE()) && Intrinsics.areEqual(text.getCompositionInChars(), textFieldState.getMainBuffer().m1112getCompositionMzsxiRA())) {
            return;
        }
        textFieldState.commitEditAsUser(text, inputTransformation, z, textFieldEditUndoBehavior);
    }

    public final void editAsUser$foundation_release(InputTransformation inputTransformation, boolean notifyImeOfChanges, TextFieldEditUndoBehavior undoBehavior, Function1<? super EditingBuffer, Unit> block) {
        TextFieldCharSequence text = getText();
        getMainBuffer().getChangeTracker().clearChanges();
        block.invoke(getMainBuffer());
        if (getMainBuffer().getChangeTracker().getChangeCount() == 0 && TextRange.m5231equalsimpl0(text.getSelectionInChars(), getMainBuffer().m1113getSelectiond9O1mEE()) && Intrinsics.areEqual(text.getCompositionInChars(), getMainBuffer().m1112getCompositionMzsxiRA())) {
            return;
        }
        commitEditAsUser(text, inputTransformation, notifyImeOfChanges, undoBehavior);
    }

    public final void editWithNoSideEffects$foundation_release(Function1<? super EditingBuffer, Unit> block) {
        TextFieldCharSequence text = getText();
        getMainBuffer().getChangeTracker().clearChanges();
        block.invoke(getMainBuffer());
        TextFieldCharSequence m1095TextFieldCharSequence3r_uNRQ = TextFieldCharSequenceKt.m1095TextFieldCharSequence3r_uNRQ(getMainBuffer().toString(), getMainBuffer().m1113getSelectiond9O1mEE(), getMainBuffer().m1112getCompositionMzsxiRA());
        setText(m1095TextFieldCharSequence3r_uNRQ);
        notifyIme(text, m1095TextFieldCharSequence3r_uNRQ);
    }

    public final void commitEditAsUser(TextFieldCharSequence previousValue, InputTransformation inputTransformation, boolean notifyImeOfChanges, TextFieldEditUndoBehavior undoBehavior) {
        TextFieldCharSequence m1095TextFieldCharSequence3r_uNRQ = TextFieldCharSequenceKt.m1095TextFieldCharSequence3r_uNRQ(this.mainBuffer.toString(), this.mainBuffer.m1113getSelectiond9O1mEE(), this.mainBuffer.m1112getCompositionMzsxiRA());
        if (inputTransformation == null) {
            TextFieldCharSequence text = getText();
            setText(m1095TextFieldCharSequence3r_uNRQ);
            if (notifyImeOfChanges) {
                notifyIme(text, m1095TextFieldCharSequence3r_uNRQ);
            }
            recordEditForUndo(previousValue, getText(), this.mainBuffer.getChangeTracker(), undoBehavior);
            return;
        }
        TextFieldCharSequence text2 = getText();
        if (m1095TextFieldCharSequence3r_uNRQ.contentEquals(text2) && TextRange.m5231equalsimpl0(m1095TextFieldCharSequence3r_uNRQ.getSelectionInChars(), text2.getSelectionInChars())) {
            setText(m1095TextFieldCharSequence3r_uNRQ);
            if (notifyImeOfChanges) {
                notifyIme(text2, m1095TextFieldCharSequence3r_uNRQ);
                return;
            }
            return;
        }
        TextFieldBuffer textFieldBuffer = new TextFieldBuffer(m1095TextFieldCharSequence3r_uNRQ, this.mainBuffer.getChangeTracker(), text2);
        inputTransformation.transformInput(text2, textFieldBuffer);
        TextFieldCharSequence m1092toTextFieldCharSequenceOEnZFl4$foundation_release = textFieldBuffer.m1092toTextFieldCharSequenceOEnZFl4$foundation_release(m1095TextFieldCharSequence3r_uNRQ.getCompositionInChars());
        if (Intrinsics.areEqual(m1092toTextFieldCharSequenceOEnZFl4$foundation_release, m1095TextFieldCharSequence3r_uNRQ)) {
            setText(m1092toTextFieldCharSequenceOEnZFl4$foundation_release);
            if (notifyImeOfChanges) {
                notifyIme(text2, m1095TextFieldCharSequence3r_uNRQ);
            }
        } else {
            resetStateAndNotifyIme$foundation_release(m1092toTextFieldCharSequenceOEnZFl4$foundation_release);
        }
        recordEditForUndo(previousValue, getText(), textFieldBuffer.getChanges(), undoBehavior);
    }

    private final void recordEditForUndo(TextFieldCharSequence previousValue, TextFieldCharSequence postValue, TextFieldBuffer.ChangeList changes, TextFieldEditUndoBehavior undoBehavior) {
        int i = WhenMappings.$EnumSwitchMapping$0[undoBehavior.ordinal()];
        if (i == 1) {
            this.textUndoManager.clearHistory();
        } else if (i == 2) {
            TextUndoManagerKt.recordChanges(this.textUndoManager, previousValue, postValue, changes, true);
        } else {
            if (i != 3) {
                return;
            }
            TextUndoManagerKt.recordChanges(this.textUndoManager, previousValue, postValue, changes, false);
        }
    }

    public final void addNotifyImeListener$foundation_release(NotifyImeListener notifyImeListener) {
        this.notifyImeListeners.add(notifyImeListener);
    }

    public final void removeNotifyImeListener$foundation_release(NotifyImeListener notifyImeListener) {
        this.notifyImeListeners.remove(notifyImeListener);
    }

    public final void resetStateAndNotifyIme$foundation_release(TextFieldCharSequence newValue) {
        TextFieldCharSequence m1095TextFieldCharSequence3r_uNRQ = TextFieldCharSequenceKt.m1095TextFieldCharSequence3r_uNRQ(this.mainBuffer.toString(), this.mainBuffer.m1113getSelectiond9O1mEE(), this.mainBuffer.m1112getCompositionMzsxiRA());
        boolean z = true;
        boolean z2 = !Intrinsics.areEqual(newValue.getCompositionInChars(), this.mainBuffer.m1112getCompositionMzsxiRA());
        boolean z3 = false;
        if (!m1095TextFieldCharSequence3r_uNRQ.contentEquals(newValue)) {
            this.mainBuffer = new EditingBuffer(newValue.toString(), newValue.getSelectionInChars(), (DefaultConstructorMarker) null);
        } else if (TextRange.m5231equalsimpl0(m1095TextFieldCharSequence3r_uNRQ.getSelectionInChars(), newValue.getSelectionInChars())) {
            z = false;
        } else {
            this.mainBuffer.setSelection(TextRange.m5238getStartimpl(newValue.getSelectionInChars()), TextRange.m5233getEndimpl(newValue.getSelectionInChars()));
            z3 = true;
            z = false;
        }
        TextRange compositionInChars = newValue.getCompositionInChars();
        if (compositionInChars == null || TextRange.m5232getCollapsedimpl(compositionInChars.getPackedValue())) {
            this.mainBuffer.commitComposition();
        } else {
            this.mainBuffer.setComposition(TextRange.m5236getMinimpl(compositionInChars.getPackedValue()), TextRange.m5235getMaximpl(compositionInChars.getPackedValue()));
        }
        if (z || (!z3 && z2)) {
            this.mainBuffer.commitComposition();
        }
        if (!z) {
            newValue = m1095TextFieldCharSequence3r_uNRQ;
        }
        TextFieldCharSequence m1095TextFieldCharSequence3r_uNRQ2 = TextFieldCharSequenceKt.m1095TextFieldCharSequence3r_uNRQ(newValue, this.mainBuffer.m1113getSelectiond9O1mEE(), this.mainBuffer.m1112getCompositionMzsxiRA());
        setText(m1095TextFieldCharSequence3r_uNRQ2);
        notifyIme(m1095TextFieldCharSequence3r_uNRQ, m1095TextFieldCharSequence3r_uNRQ2);
    }

    /* compiled from: TextFieldState.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003*\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/text2/input/TextFieldState$Saver;", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text2/input/TextFieldState;", "", "()V", "restore", AppMeasurementSdk.ConditionalUserProperty.VALUE, "save", "Landroidx/compose/runtime/saveable/SaverScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Saver implements androidx.compose.runtime.saveable.Saver<TextFieldState, Object> {
        public static final int $stable = 0;
        public static final Saver INSTANCE = new Saver();

        private Saver() {
        }

        @Override // androidx.compose.runtime.saveable.Saver
        public Object save(SaverScope saverScope, TextFieldState textFieldState) {
            return CollectionsKt.listOf(textFieldState.getText().toString(), Integer.valueOf(TextRange.m5238getStartimpl(textFieldState.getText().getSelectionInChars())), Integer.valueOf(TextRange.m5233getEndimpl(textFieldState.getText().getSelectionInChars())), TextUndoManager.Companion.Saver.INSTANCE.save(saverScope, textFieldState.getTextUndoManager()));
        }

        @Override // androidx.compose.runtime.saveable.Saver
        public TextFieldState restore(Object r11) {
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.collections.List<*>");
            List list = (List) r11;
            Object obj = list.get(0);
            Object obj2 = list.get(1);
            Object obj3 = list.get(2);
            Object obj4 = list.get(3);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj2).intValue();
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            long TextRange = TextRangeKt.TextRange(intValue, ((Integer) obj3).intValue());
            TextUndoManager.Companion.Saver saver = TextUndoManager.Companion.Saver.INSTANCE;
            Intrinsics.checkNotNull(obj4);
            TextUndoManager restore = saver.restore(obj4);
            Intrinsics.checkNotNull(restore);
            return new TextFieldState(str, TextRange, restore, (DefaultConstructorMarker) null);
        }
    }

    public final void setText(TextFieldCharSequence textFieldCharSequence) {
        this.text.setValue(textFieldCharSequence);
    }

    public final void notifyIme(TextFieldCharSequence oldValue, TextFieldCharSequence newValue) {
        MutableVector<NotifyImeListener> mutableVector = this.notifyImeListeners;
        int size = mutableVector.getSize();
        if (size > 0) {
            NotifyImeListener[] content = mutableVector.getContent();
            int i = 0;
            do {
                content[i].onChange(oldValue, newValue);
                i++;
            } while (i < size);
        }
    }
}
