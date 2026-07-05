package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextFieldCursorKt;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionLayout;
import androidx.compose.foundation.text.selection.SelectionLayoutKt;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.foundation.text.selection.TextSelectionDelegateKt;
import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.foundation.text2.input.TextFieldCharSequenceKt;
import androidx.compose.foundation.text2.input.internal.TextLayoutState;
import androidx.compose.foundation.text2.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text2.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: TextFieldSelectionState.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\b\u0010Z\u001a\u00020[H\u0002J\u0010\u0010\\\u001a\u00020[2\b\b\u0002\u0010]\u001a\u00020\tJ\u0006\u0010^\u001a\u00020[J\u0006\u0010_\u001a\u00020[J\u0006\u0010`\u001a\u00020[J\b\u0010a\u001a\u00020\u001eH\u0002J\u001d\u0010b\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\u00142\u0006\u0010c\u001a\u00020\tH\u0002J<\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020:2\u0006\u0010j\u001a\u00020:2\b\u0010k\u001a\u0004\u0018\u00010h2\u0006\u0010c\u001a\u00020\t2\u0006\u0010l\u001a\u00020mH\u0002ø\u0001\u0000¢\u0006\u0004\bn\u0010oJ\b\u0010p\u001a\u00020[H\u0002J\b\u0010q\u001a\u00020[H\u0002J\u000e\u0010r\u001a\u00020[H\u0086@¢\u0006\u0002\u0010sJ\u000e\u0010t\u001a\u00020[H\u0082@¢\u0006\u0002\u0010sJ\u000e\u0010u\u001a\u00020[H\u0082@¢\u0006\u0002\u0010sJ\u0006\u0010v\u001a\u00020[J\u0010\u0010w\u001a\u00020[2\u0006\u0010x\u001a\u00020\u001eH\u0002J6\u0010y\u001a\u00020[2\u0006\u00102\u001a\u0002032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010Q\u001a\u00020R2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\"\u0010z\u001a\u00020[2\u0006\u0010{\u001a\u00020#2\u0006\u0010|\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b}\u0010~JN\u0010\u007f\u001a\u00020h2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020:2\u0007\u0010\u0083\u0001\u001a\u00020:2\u0006\u0010c\u001a\u00020\t2\u0006\u0010l\u001a\u00020m2\t\b\u0002\u0010\u0084\u0001\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u000f\u0010\u0087\u0001\u001a\u00020[2\u0006\u0010T\u001a\u00020SJ\u0015\u0010\u0088\u0001\u001a\u00020[*\u00030\u0089\u0001H\u0086@¢\u0006\u0003\u0010\u008a\u0001J\u0015\u0010\u008b\u0001\u001a\u00020[*\u00030\u0089\u0001H\u0082@¢\u0006\u0003\u0010\u008a\u0001J\u001d\u0010\u008c\u0001\u001a\u00020[*\u00030\u0089\u00012\u0006\u0010c\u001a\u00020\tH\u0082@¢\u0006\u0003\u0010\u008d\u0001J%\u0010\u008e\u0001\u001a\u00020[*\u00030\u0089\u00012\u000e\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020[0\u0090\u0001H\u0082@¢\u0006\u0003\u0010\u0091\u0001J5\u0010\u0092\u0001\u001a\u00020[*\u00030\u0089\u00012\u000e\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020[0\u0090\u00012\u000e\u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u00020[0\u0090\u0001H\u0082@¢\u0006\u0003\u0010\u0094\u0001J\u0015\u0010\u0095\u0001\u001a\u00020[*\u00030\u0089\u0001H\u0082@¢\u0006\u0003\u0010\u008a\u0001J\u001d\u0010\u0096\u0001\u001a\u00020[*\u00030\u0089\u00012\u0006\u0010c\u001a\u00020\tH\u0086@¢\u0006\u0003\u0010\u008d\u0001J5\u0010\u0097\u0001\u001a\u00020[*\u00030\u0089\u00012\u000e\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020[0\u0090\u00012\u000e\u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u00020[0\u0090\u0001H\u0086@¢\u0006\u0003\u0010\u0094\u0001R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0018\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\"\u001a\u0004\u0018\u00010#8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u001bR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0018\u001a\u0004\b.\u0010\u0016R\u0017\u00100\u001a\u00020\u00108Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b1\u0010\u0012R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u001b\"\u0004\b4\u00105R+\u00106\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010*\u001a\u0004\b6\u0010\u001b\"\u0004\b7\u00105R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010=\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00108B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bA\u0010*\u001a\u0004\b>\u0010\u0012\"\u0004\b?\u0010@R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010B\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010*\u001a\u0004\bC\u0010\u001b\"\u0004\bD\u00105R1\u0010F\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00108B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bI\u0010*\u001a\u0004\bG\u0010\u0012\"\u0004\bH\u0010@R\u001b\u0010J\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u0018\u001a\u0004\bK\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010M\u001a\u0004\u0018\u00010N8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010T\u001a\u00020S2\u0006\u0010\"\u001a\u00020S8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bY\u0010*\u001a\u0004\bU\u0010V\"\u0004\bW\u0010X\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0098\u0001"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;", "", "textFieldState", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text2/input/internal/TextLayoutState;", "density", "Landroidx/compose/ui/unit/Density;", "enabled", "", "readOnly", "isFocused", "(Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text2/input/internal/TextLayoutState;Landroidx/compose/ui/unit/Density;ZZZ)V", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "currentContentVisibleOffset", "Landroidx/compose/ui/geometry/Offset;", "getCurrentContentVisibleOffset-F1C5BW0", "()J", "cursorHandle", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldHandleState;", "getCursorHandle", "()Landroidx/compose/foundation/text2/input/internal/selection/TextFieldHandleState;", "cursorHandle$delegate", "Landroidx/compose/runtime/State;", "cursorHandleInBounds", "getCursorHandleInBounds", "()Z", "cursorHandleInBounds$delegate", "cursorRect", "Landroidx/compose/ui/geometry/Rect;", "getCursorRect", "()Landroidx/compose/ui/geometry/Rect;", "cursorRect$delegate", "<set-?>", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "Landroidx/compose/runtime/MutableState;", "editable", "getEditable", "endSelectionHandle", "getEndSelectionHandle", "endSelectionHandle$delegate", "handleDragPosition", "getHandleDragPosition-F1C5BW0", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setFocused", "(Z)V", "isInTouchMode", "setInTouchMode", "isInTouchMode$delegate", "previousRawDragOffset", "", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "rawHandleDragPosition", "getRawHandleDragPosition-F1C5BW0", "setRawHandleDragPosition-k-4lQ0M", "(J)V", "rawHandleDragPosition$delegate", "showCursorHandle", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle$delegate", "startContentVisibleOffset", "getStartContentVisibleOffset-F1C5BW0", "setStartContentVisibleOffset-k-4lQ0M", "startContentVisibleOffset$delegate", "startSelectionHandle", "getStartSelectionHandle", "startSelectionHandle$delegate", "textLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getTextLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "Landroidx/compose/foundation/text2/input/internal/selection/TextToolbarState;", "textToolbarState", "getTextToolbarState", "()Landroidx/compose/foundation/text2/input/internal/selection/TextToolbarState;", "setTextToolbarState", "(Landroidx/compose/foundation/text2/input/internal/selection/TextToolbarState;)V", "textToolbarState$delegate", "clearHandleDragging", "", "copy", "cancelSelection", "cut", "deselect", "dispose", "getContentRect", "getHandlePosition", "isStartHandle", "getHandlePosition-tuRUvjQ", "(Z)J", "getSelectionHandleState", "getTextFieldSelection", "Landroidx/compose/ui/text/TextRange;", "rawStartOffset", "rawEndOffset", "previousSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getTextFieldSelection-qeG_v_k", "(IILandroidx/compose/ui/text/TextRange;ZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)J", "hideTextToolbar", "markStartContentVisibleOffset", "observeChanges", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeTextChanges", "observeTextToolbarVisibility", "paste", "showTextToolbar", "contentRect", "update", "updateHandleDragging", "handle", "position", "updateHandleDragging-Uv8p0NA", "(Landroidx/compose/foundation/text/Handle;J)V", "updateSelection", "textFieldCharSequence", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "startOffset", "endOffset", "allowPreviousSelectionCollapsed", "updateSelection-QNhciaU", "(Landroidx/compose/foundation/text2/input/TextFieldCharSequence;IIZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "updateTextToolbarState", "cursorHandleGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectCursorHandleDragGestures", "detectSelectionHandleDragGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTextFieldLongPressAndAfterDrag", "requestFocus", "Lkotlin/Function0;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTextFieldTapGestures", "showKeyboard", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTouchMode", "selectionHandleGestures", "textFieldGestures", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldSelectionState {
    public static final int $stable = 8;
    private ClipboardManager clipboardManager;

    /* renamed from: cursorHandle$delegate, reason: from kotlin metadata */
    private final State cursorHandle;

    /* renamed from: cursorHandleInBounds$delegate, reason: from kotlin metadata */
    private final State cursorHandleInBounds;

    /* renamed from: cursorRect$delegate, reason: from kotlin metadata */
    private final State cursorRect;
    private Density density;

    /* renamed from: draggingHandle$delegate, reason: from kotlin metadata */
    private final MutableState draggingHandle;
    private boolean enabled;

    /* renamed from: endSelectionHandle$delegate, reason: from kotlin metadata */
    private final State endSelectionHandle;
    private HapticFeedback hapticFeedBack;
    private boolean isFocused;

    /* renamed from: isInTouchMode$delegate, reason: from kotlin metadata */
    private final MutableState isInTouchMode;
    private int previousRawDragOffset;
    private SelectionLayout previousSelectionLayout;

    /* renamed from: rawHandleDragPosition$delegate, reason: from kotlin metadata */
    private final MutableState rawHandleDragPosition;
    private boolean readOnly;

    /* renamed from: showCursorHandle$delegate, reason: from kotlin metadata */
    private final MutableState showCursorHandle;

    /* renamed from: startContentVisibleOffset$delegate, reason: from kotlin metadata */
    private final MutableState startContentVisibleOffset;

    /* renamed from: startSelectionHandle$delegate, reason: from kotlin metadata */
    private final State startSelectionHandle;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;
    private TextToolbar textToolbar;

    /* renamed from: textToolbarState$delegate, reason: from kotlin metadata */
    private final MutableState textToolbarState;

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getEditable() {
        return this.enabled && !this.readOnly;
    }

    /* renamed from: isFocused, reason: from getter */
    public final boolean getIsFocused() {
        return this.isFocused;
    }

    public final void setFocused(boolean z) {
        this.isFocused = z;
    }

    public TextFieldSelectionState(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, Density density, boolean z, boolean z2, boolean z3) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        this.textFieldState = transformedTextFieldState;
        this.textLayoutState = textLayoutState;
        this.density = density;
        this.enabled = z;
        this.readOnly = z2;
        this.isFocused = z3;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this.isInTouchMode = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3165boximpl(Offset.INSTANCE.m3191getUnspecifiedF1C5BW0()), null, 2, null);
        this.startContentVisibleOffset = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3165boximpl(Offset.INSTANCE.m3191getUnspecifiedF1C5BW0()), null, 2, null);
        this.rawHandleDragPosition = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggingHandle = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.showCursorHandle = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TextToolbarState.None, null, 2, null);
        this.textToolbarState = mutableStateOf$default6;
        this.previousRawDragOffset = -1;
        this.cursorHandle = SnapshotStateKt.derivedStateOf(new Function0<TextFieldHandleState>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$cursorHandle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:
            
                if (r0 != false) goto L12;
             */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState invoke() {
                /*
                    r8 = this;
                    androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r0 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.this
                    androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r0 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.access$getTextFieldState$p(r0)
                    androidx.compose.foundation.text2.input.TextFieldCharSequence r0 = r0.getText()
                    androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r1 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.this
                    boolean r1 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.access$getShowCursorHandle(r1)
                    if (r1 == 0) goto L4c
                    long r1 = r0.getSelectionInChars()
                    boolean r1 = androidx.compose.ui.text.TextRange.m5232getCollapsedimpl(r1)
                    if (r1 == 0) goto L4c
                    java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                    int r0 = r0.length()
                    if (r0 <= 0) goto L4c
                    androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r0 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.this
                    androidx.compose.foundation.text.Handle r0 = r0.getDraggingHandle()
                    androidx.compose.foundation.text.Handle r1 = androidx.compose.foundation.text.Handle.Cursor
                    if (r0 == r1) goto L36
                    androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r0 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.this
                    boolean r0 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.access$getCursorHandleInBounds(r0)
                    if (r0 == 0) goto L4c
                L36:
                    androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState r0 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState
                    r2 = 1
                    androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r1 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.this
                    androidx.compose.ui.geometry.Rect r1 = r1.getCursorRect()
                    long r3 = r1.m3203getBottomCenterF1C5BW0()
                    androidx.compose.ui.text.style.ResolvedTextDirection r5 = androidx.compose.ui.text.style.ResolvedTextDirection.Ltr
                    r6 = 0
                    r7 = 0
                    r1 = r0
                    r1.<init>(r2, r3, r5, r6, r7)
                    return r0
                L4c:
                    androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState$Companion r0 = androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState.INSTANCE
                    androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState r0 = r0.getHidden()
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$cursorHandle$2.invoke():androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState");
            }
        });
        this.cursorHandleInBounds = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$cursorHandleInBounds$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                LayoutCoordinates textLayoutCoordinates;
                Rect visibleBounds;
                Snapshot.Companion companion = Snapshot.INSTANCE;
                TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
                Snapshot createNonObservableSnapshot = companion.createNonObservableSnapshot();
                try {
                    Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
                    try {
                        long m3203getBottomCenterF1C5BW0 = textFieldSelectionState.getCursorRect().m3203getBottomCenterF1C5BW0();
                        createNonObservableSnapshot.dispose();
                        textLayoutCoordinates = TextFieldSelectionState.this.getTextLayoutCoordinates();
                        return Boolean.valueOf((textLayoutCoordinates == null || (visibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) ? false : SelectionManagerKt.m1048containsInclusiveUv8p0NA(visibleBounds, m3203getBottomCenterF1C5BW0));
                    } finally {
                        createNonObservableSnapshot.restoreCurrent(makeCurrent);
                    }
                } catch (Throwable th) {
                    createNonObservableSnapshot.dispose();
                    throw th;
                }
            }
        });
        this.cursorRect = SnapshotStateKt.derivedStateOf(new Function0<Rect>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$cursorRect$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Rect invoke() {
                TextLayoutState textLayoutState2;
                TransformedTextFieldState transformedTextFieldState2;
                Density density2;
                float right;
                textLayoutState2 = TextFieldSelectionState.this.textLayoutState;
                TextLayoutResult layoutResult = textLayoutState2.getLayoutResult();
                if (layoutResult == null) {
                    return Rect.INSTANCE.getZero();
                }
                transformedTextFieldState2 = TextFieldSelectionState.this.textFieldState;
                TextFieldCharSequence text = transformedTextFieldState2.getText();
                if (!TextRange.m5232getCollapsedimpl(text.getSelectionInChars())) {
                    return Rect.INSTANCE.getZero();
                }
                Rect cursorRect = layoutResult.getCursorRect(TextRange.m5238getStartimpl(text.getSelectionInChars()));
                density2 = TextFieldSelectionState.this.density;
                float mo320toPx0680j_4 = density2.mo320toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
                if (layoutResult.getLayoutInput().getLayoutDirection() == LayoutDirection.Ltr) {
                    right = cursorRect.getLeft() + (mo320toPx0680j_4 / 2);
                } else {
                    right = cursorRect.getRight() - (mo320toPx0680j_4 / 2);
                }
                float f = mo320toPx0680j_4 / 2;
                float coerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(right, IntSize.m5908getWidthimpl(layoutResult.getSize()) - f), f);
                return new Rect(coerceAtLeast - f, cursorRect.getTop(), coerceAtLeast + f, cursorRect.getBottom());
            }
        });
        this.startSelectionHandle = SnapshotStateKt.derivedStateOf(new Function0<TextFieldHandleState>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$startSelectionHandle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextFieldHandleState invoke() {
                TextFieldHandleState selectionHandleState;
                selectionHandleState = TextFieldSelectionState.this.getSelectionHandleState(true);
                return selectionHandleState;
            }
        });
        this.endSelectionHandle = SnapshotStateKt.derivedStateOf(new Function0<TextFieldHandleState>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$endSelectionHandle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextFieldHandleState invoke() {
                TextFieldHandleState selectionHandleState;
                selectionHandleState = TextFieldSelectionState.this.getSelectionHandleState(false);
                return selectionHandleState;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setInTouchMode(boolean z) {
        this.isInTouchMode.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isInTouchMode() {
        return ((Boolean) this.isInTouchMode.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getStartContentVisibleOffset-F1C5BW0, reason: not valid java name */
    private final long m1190getStartContentVisibleOffsetF1C5BW0() {
        return ((Offset) this.startContentVisibleOffset.getValue()).getPackedValue();
    }

    /* renamed from: setStartContentVisibleOffset-k-4lQ0M, reason: not valid java name */
    private final void m1193setStartContentVisibleOffsetk4lQ0M(long j) {
        this.startContentVisibleOffset.setValue(Offset.m3165boximpl(j));
    }

    /* renamed from: getCurrentContentVisibleOffset-F1C5BW0, reason: not valid java name */
    private final long m1187getCurrentContentVisibleOffsetF1C5BW0() {
        Rect visibleBounds;
        LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
        return (textLayoutCoordinates == null || (visibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) ? Offset.INSTANCE.m3191getUnspecifiedF1C5BW0() : visibleBounds.m3211getTopLeftF1C5BW0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getRawHandleDragPosition-F1C5BW0, reason: not valid java name */
    private final long m1189getRawHandleDragPositionF1C5BW0() {
        return ((Offset) this.rawHandleDragPosition.getValue()).getPackedValue();
    }

    /* renamed from: setRawHandleDragPosition-k-4lQ0M, reason: not valid java name */
    private final void m1192setRawHandleDragPositionk4lQ0M(long j) {
        this.rawHandleDragPosition.setValue(Offset.m3165boximpl(j));
    }

    /* renamed from: getHandleDragPosition-F1C5BW0, reason: not valid java name */
    public final long m1197getHandleDragPositionF1C5BW0() {
        if (OffsetKt.m3197isUnspecifiedk4lQ0M(m1189getRawHandleDragPositionF1C5BW0())) {
            return Offset.INSTANCE.m3191getUnspecifiedF1C5BW0();
        }
        if (OffsetKt.m3197isUnspecifiedk4lQ0M(m1190getStartContentVisibleOffsetF1C5BW0())) {
            return TextLayoutStateKt.m1155fromDecorationToTextLayoutUv8p0NA(this.textLayoutState, m1189getRawHandleDragPositionF1C5BW0());
        }
        return Offset.m3180minusMKHz9U(Offset.m3181plusMKHz9U(m1189getRawHandleDragPositionF1C5BW0(), m1187getCurrentContentVisibleOffsetF1C5BW0()), m1190getStartContentVisibleOffsetF1C5BW0());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getShowCursorHandle() {
        return ((Boolean) this.showCursorHandle.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setShowCursorHandle(boolean z) {
        this.showCursorHandle.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final TextToolbarState getTextToolbarState() {
        return (TextToolbarState) this.textToolbarState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getTextLayoutCoordinates() {
        LayoutCoordinates textLayoutNodeCoordinates = this.textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates == null || !textLayoutNodeCoordinates.isAttached()) {
            return null;
        }
        return textLayoutNodeCoordinates;
    }

    public final void update(HapticFeedback hapticFeedBack, ClipboardManager clipboardManager, TextToolbar textToolbar, Density density, boolean enabled, boolean readOnly) {
        if (!enabled) {
            hideTextToolbar();
        }
        this.hapticFeedBack = hapticFeedBack;
        this.clipboardManager = clipboardManager;
        this.textToolbar = textToolbar;
        this.density = density;
        this.enabled = enabled;
        this.readOnly = readOnly;
    }

    public final Object cursorHandleGestures(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TextFieldSelectionState$cursorHandleGestures$2(this, pointerInputScope, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public final Object textFieldGestures(PointerInputScope pointerInputScope, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TextFieldSelectionState$textFieldGestures$2(this, pointerInputScope, function0, function02, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public final Object selectionHandleGestures(PointerInputScope pointerInputScope, boolean z, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TextFieldSelectionState$selectionHandleGestures$2(this, pointerInputScope, z, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object observeChanges(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$1
            if (r0 == 0) goto L14
            r0 = r6
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$1 r0 = (androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$1 r0 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$1
            r0.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L31
            java.lang.Object r0 = r0.L$0
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r0 = (androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L2f
            goto L51
        L2f:
            r6 = move-exception
            goto L64
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$2 r6 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$2     // Catch: java.lang.Throwable -> L62
            r2 = 0
            r6.<init>(r5, r2)     // Catch: java.lang.Throwable -> L62
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch: java.lang.Throwable -> L62
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L62
            r0.label = r4     // Catch: java.lang.Throwable -> L62
            java.lang.Object r6 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r6, r0)     // Catch: java.lang.Throwable -> L62
            if (r6 != r1) goto L50
            return r1
        L50:
            r0 = r5
        L51:
            r0.setShowCursorHandle(r3)
            androidx.compose.foundation.text2.input.internal.selection.TextToolbarState r6 = r0.getTextToolbarState()
            androidx.compose.foundation.text2.input.internal.selection.TextToolbarState r1 = androidx.compose.foundation.text2.input.internal.selection.TextToolbarState.None
            if (r6 == r1) goto L5f
            r0.hideTextToolbar()
        L5f:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L62:
            r6 = move-exception
            r0 = r5
        L64:
            r0.setShowCursorHandle(r3)
            androidx.compose.foundation.text2.input.internal.selection.TextToolbarState r1 = r0.getTextToolbarState()
            androidx.compose.foundation.text2.input.internal.selection.TextToolbarState r2 = androidx.compose.foundation.text2.input.internal.selection.TextToolbarState.None
            if (r1 == r2) goto L72
            r0.hideTextToolbar()
        L72:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.observeChanges(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void updateTextToolbarState(TextToolbarState textToolbarState) {
        setTextToolbarState(textToolbarState);
    }

    public final void dispose() {
        hideTextToolbar();
        this.textToolbar = null;
        this.clipboardManager = null;
        this.hapticFeedBack = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object detectTouchMode(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        Object awaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new TextFieldSelectionState$detectTouchMode$2(this, null), continuation);
        return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object detectTextFieldTapGestures(PointerInputScope pointerInputScope, final Function0<Unit> function0, final Function0<Unit> function02, Continuation<? super Unit> continuation) {
        Object detectTapAndDoubleTap = TapAndDoubleTapGestureKt.detectTapAndDoubleTap(pointerInputScope, new TapOnPosition() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2
            @Override // androidx.compose.foundation.text2.input.internal.selection.TapOnPosition
            /* renamed from: onEvent-k-4lQ0M */
            public final void mo1170onEventk4lQ0M(long j) {
                boolean editable;
                TransformedTextFieldState transformedTextFieldState;
                TextLayoutState textLayoutState;
                TransformedTextFieldState transformedTextFieldState2;
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onTapTextField";
                    }
                });
                function0.invoke();
                editable = this.getEditable();
                if (editable && this.getIsFocused()) {
                    function02.invoke();
                    transformedTextFieldState = this.textFieldState;
                    if (transformedTextFieldState.getText().length() > 0) {
                        this.setShowCursorHandle(true);
                    }
                    this.updateTextToolbarState(TextToolbarState.None);
                    textLayoutState = this.textLayoutState;
                    int m1148getOffsetForPosition3MmeM6k$default = TextLayoutState.m1148getOffsetForPosition3MmeM6k$default(textLayoutState, j, false, 2, null);
                    if (m1148getOffsetForPosition3MmeM6k$default >= 0) {
                        transformedTextFieldState2 = this.textFieldState;
                        transformedTextFieldState2.placeCursorBeforeCharAt(m1148getOffsetForPosition3MmeM6k$default);
                    }
                }
            }
        }, new TapOnPosition() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$3
            @Override // androidx.compose.foundation.text2.input.internal.selection.TapOnPosition
            /* renamed from: onEvent-k-4lQ0M */
            public final void mo1170onEventk4lQ0M(long j) {
                TextLayoutState textLayoutState;
                TransformedTextFieldState transformedTextFieldState;
                TransformedTextFieldState transformedTextFieldState2;
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$3.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onDoubleTapTextField";
                    }
                });
                TextFieldSelectionState.this.setShowCursorHandle(false);
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
                textLayoutState = TextFieldSelectionState.this.textLayoutState;
                int m1148getOffsetForPosition3MmeM6k$default = TextLayoutState.m1148getOffsetForPosition3MmeM6k$default(textLayoutState, j, false, 2, null);
                TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
                transformedTextFieldState = textFieldSelectionState.textFieldState;
                long m1196updateSelectionQNhciaU$default = TextFieldSelectionState.m1196updateSelectionQNhciaU$default(textFieldSelectionState, TextFieldCharSequenceKt.m1096TextFieldCharSequence3r_uNRQ$default(transformedTextFieldState.getText(), TextRange.INSTANCE.m5243getZerod9O1mEE(), null, 4, null), m1148getOffsetForPosition3MmeM6k$default, m1148getOffsetForPosition3MmeM6k$default, false, SelectionAdjustment.INSTANCE.getWord(), false, 32, null);
                transformedTextFieldState2 = TextFieldSelectionState.this.textFieldState;
                transformedTextFieldState2.m1164selectCharsIn5zctL8(m1196updateSelectionQNhciaU$default);
            }
        }, continuation);
        return detectTapAndDoubleTap == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapAndDoubleTap : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object detectCursorHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1
            if (r0 == 0) goto L14
            r0 = r11
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1 r0 = (androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1 r0 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1
            r0.<init>(r9, r11)
        L19:
            r6 = r0
            java.lang.Object r11 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L43
            if (r1 != r2) goto L3a
            java.lang.Object r10 = r6.L$2
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref.LongRef) r10
            java.lang.Object r0 = r6.L$1
            kotlin.jvm.internal.Ref$LongRef r0 = (kotlin.jvm.internal.Ref.LongRef) r0
            java.lang.Object r1 = r6.L$0
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r1 = (androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState) r1
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L37
            goto L97
        L37:
            r11 = move-exception
            goto La2
        L3a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L43:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.jvm.internal.Ref$LongRef r11 = new kotlin.jvm.internal.Ref$LongRef
            r11.<init>()
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r3 = r1.m3191getUnspecifiedF1C5BW0()
            r11.element = r3
            kotlin.jvm.internal.Ref$LongRef r7 = new kotlin.jvm.internal.Ref$LongRef
            r7.<init>()
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r3 = r1.m3191getUnspecifiedF1C5BW0()
            r7.element = r3
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$2 r1 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$2     // Catch: java.lang.Throwable -> L9d
            r1.<init>()     // Catch: java.lang.Throwable -> L9d
            r3 = r1
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3     // Catch: java.lang.Throwable -> L9d
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$3 r1 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$3     // Catch: java.lang.Throwable -> L9d
            r1.<init>()     // Catch: java.lang.Throwable -> L9d
            r4 = r1
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4     // Catch: java.lang.Throwable -> L9d
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$4 r1 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$4     // Catch: java.lang.Throwable -> L9d
            r1.<init>()     // Catch: java.lang.Throwable -> L9d
            r5 = r1
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5     // Catch: java.lang.Throwable -> L9d
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$5 r1 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$5     // Catch: java.lang.Throwable -> L9d
            r1.<init>()     // Catch: java.lang.Throwable -> L9d
            r8 = r1
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8     // Catch: java.lang.Throwable -> L9d
            r6.L$0 = r9     // Catch: java.lang.Throwable -> L9d
            r6.L$1 = r11     // Catch: java.lang.Throwable -> L9d
            r6.L$2 = r7     // Catch: java.lang.Throwable -> L9d
            r6.label = r2     // Catch: java.lang.Throwable -> L9d
            r1 = r10
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r8
            java.lang.Object r10 = androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L9d
            if (r10 != r0) goto L94
            return r0
        L94:
            r1 = r9
            r0 = r11
            r10 = r7
        L97:
            detectCursorHandleDragGestures$onDragStop(r0, r10, r1)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L9d:
            r10 = move-exception
            r1 = r9
            r0 = r11
            r11 = r10
            r10 = r7
        La2:
            detectCursorHandleDragGestures$onDragStop(r0, r10, r1)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.detectCursorHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectCursorHandleDragGestures$onDragStop(Ref.LongRef longRef, Ref.LongRef longRef2, TextFieldSelectionState textFieldSelectionState) {
        if (OffsetKt.m3195isSpecifiedk4lQ0M(longRef.element)) {
            longRef.element = Offset.INSTANCE.m3191getUnspecifiedF1C5BW0();
            longRef2.element = Offset.INSTANCE.m3191getUnspecifiedF1C5BW0();
            textFieldSelectionState.clearHandleDragging();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.compose.foundation.text.Handle, T] */
    public final Object detectTextFieldLongPressAndAfterDrag(PointerInputScope pointerInputScope, final Function0<Unit> function0, Continuation<? super Unit> continuation) {
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = Offset.INSTANCE.m3191getUnspecifiedF1C5BW0();
        final Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.element = Offset.INSTANCE.m3192getZeroF1C5BW0();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = Handle.SelectionEnd;
        Object detectDragGesturesAfterLongPress = DragGestureDetectorKt.detectDragGesturesAfterLongPress(pointerInputScope, new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                m1203invokek4lQ0M(offset.getPackedValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m1203invokek4lQ0M(final long j) {
                TextLayoutState textLayoutState;
                TransformedTextFieldState transformedTextFieldState;
                TextLayoutState textLayoutState2;
                TransformedTextFieldState transformedTextFieldState2;
                TransformedTextFieldState transformedTextFieldState3;
                TextLayoutState textLayoutState3;
                HapticFeedback hapticFeedback;
                TransformedTextFieldState transformedTextFieldState4;
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onDragStart after longPress " + ((Object) Offset.m3184toStringimpl(j));
                    }
                });
                function0.invoke();
                this.m1194updateHandleDraggingUv8p0NA(objectRef.element, j);
                longRef.element = j;
                longRef2.element = Offset.INSTANCE.m3192getZeroF1C5BW0();
                this.previousRawDragOffset = -1;
                textLayoutState = this.textLayoutState;
                if (!textLayoutState.m1151isPositionOnTextk4lQ0M(j)) {
                    textLayoutState3 = this.textLayoutState;
                    int m1148getOffsetForPosition3MmeM6k$default = TextLayoutState.m1148getOffsetForPosition3MmeM6k$default(textLayoutState3, j, false, 2, null);
                    hapticFeedback = this.hapticFeedBack;
                    if (hapticFeedback != null) {
                        hapticFeedback.mo4088performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4097getTextHandleMove5zf0vsI());
                    }
                    transformedTextFieldState4 = this.textFieldState;
                    transformedTextFieldState4.placeCursorBeforeCharAt(m1148getOffsetForPosition3MmeM6k$default);
                    this.setShowCursorHandle(true);
                    this.updateTextToolbarState(TextToolbarState.Cursor);
                    return;
                }
                transformedTextFieldState = this.textFieldState;
                if (transformedTextFieldState.getText().length() == 0) {
                    return;
                }
                textLayoutState2 = this.textLayoutState;
                int m1148getOffsetForPosition3MmeM6k$default2 = TextLayoutState.m1148getOffsetForPosition3MmeM6k$default(textLayoutState2, j, false, 2, null);
                TextFieldSelectionState textFieldSelectionState = this;
                transformedTextFieldState2 = textFieldSelectionState.textFieldState;
                long m1196updateSelectionQNhciaU$default = TextFieldSelectionState.m1196updateSelectionQNhciaU$default(textFieldSelectionState, TextFieldCharSequenceKt.m1096TextFieldCharSequence3r_uNRQ$default(transformedTextFieldState2.getText(), TextRange.INSTANCE.m5243getZerod9O1mEE(), null, 4, null), m1148getOffsetForPosition3MmeM6k$default2, m1148getOffsetForPosition3MmeM6k$default2, false, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate(), false, 32, null);
                transformedTextFieldState3 = this.textFieldState;
                transformedTextFieldState3.m1164selectCharsIn5zctL8(m1196updateSelectionQNhciaU$default);
                this.updateTextToolbarState(TextToolbarState.Selection);
                intRef.element = TextRange.m5238getStartimpl(m1196updateSelectionQNhciaU$default);
            }
        }, new Function0<Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TextFieldSelectionState.detectTextFieldLongPressAndAfterDrag$onDragStop$1(Ref.LongRef.this, this, intRef, longRef2);
            }
        }, new Function0<Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TextFieldSelectionState.detectTextFieldLongPressAndAfterDrag$onDragStop$1(Ref.LongRef.this, this, intRef, longRef2);
            }
        }, new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                m1204invokeUv8p0NA(pointerInputChange, offset.getPackedValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:15:0x00de  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x00fd  */
            /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void m1204invokeUv8p0NA(androidx.compose.ui.input.pointer.PointerInputChange r10, long r11) {
                /*
                    Method dump skipped, instructions count: 369
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$5.m1204invokeUv8p0NA(androidx.compose.ui.input.pointer.PointerInputChange, long):void");
            }
        }, continuation);
        return detectDragGesturesAfterLongPress == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectDragGesturesAfterLongPress : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectTextFieldLongPressAndAfterDrag$onDragStop$1(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.IntRef intRef, Ref.LongRef longRef2) {
        if (OffsetKt.m3195isSpecifiedk4lQ0M(longRef.element)) {
            textFieldSelectionState.clearHandleDragging();
            intRef.element = -1;
            longRef.element = Offset.INSTANCE.m3191getUnspecifiedF1C5BW0();
            longRef2.element = Offset.INSTANCE.m3192getZeroF1C5BW0();
            textFieldSelectionState.previousRawDragOffset = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object detectSelectionHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope r18, final boolean r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectSelectionHandleDragGestures$onDragStop$2(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.LongRef longRef2) {
        if (OffsetKt.m3195isSpecifiedk4lQ0M(longRef.element)) {
            textFieldSelectionState.clearHandleDragging();
            longRef.element = Offset.INSTANCE.m3191getUnspecifiedF1C5BW0();
            longRef2.element = Offset.INSTANCE.m3192getZeroF1C5BW0();
            textFieldSelectionState.previousRawDragOffset = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object observeTextChanges(Continuation<? super Unit> continuation) {
        Object collect = FlowKt.drop(FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0<TextFieldCharSequence>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeTextChanges$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextFieldCharSequence invoke() {
                TransformedTextFieldState transformedTextFieldState;
                transformedTextFieldState = TextFieldSelectionState.this.textFieldState;
                return transformedTextFieldState.getText();
            }
        }), TextFieldSelectionState$observeTextChanges$3.INSTANCE), 1).collect(new FlowCollector() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeTextChanges$4
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((TextFieldCharSequence) obj, (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(TextFieldCharSequence textFieldCharSequence, Continuation<? super Unit> continuation2) {
                TextFieldSelectionState.this.setShowCursorHandle(false);
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.None);
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object observeTextToolbarVisibility(Continuation<? super Unit> continuation) {
        Object collect = SnapshotStateKt.snapshotFlow(new Function0<Rect>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeTextToolbarVisibility$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Code restructure failed: missing block: B:10:0x0041, code lost:
            
                if (r0 == null) goto L16;
             */
            /* JADX WARN: Code restructure failed: missing block: B:11:0x0043, code lost:
            
                r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:12:0x0049, code lost:
            
                if (r0 == null) goto L30;
             */
            /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
            
                r2 = r6.this$0.getTextLayoutCoordinates();
             */
            /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
            
                if (r2 == null) goto L21;
             */
            /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
            
                r2 = androidx.compose.ui.geometry.Offset.m3165boximpl(r2.mo4696localToRootMKHz9U(r0.m3211getTopLeftF1C5BW0()));
             */
            /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
            
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
                r0 = androidx.compose.ui.geometry.RectKt.m3216Recttz77jQw(r2.getPackedValue(), r0.m3209getSizeNHjbRc());
                r2 = r6.this$0.getContentRect();
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x007a, code lost:
            
                if (r0.overlaps(r2) == false) goto L25;
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x007c, code lost:
            
                r1 = r2;
             */
            /* JADX WARN: Code restructure failed: missing block: B:19:0x007d, code lost:
            
                if (r1 == null) goto L29;
             */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x007f, code lost:
            
                r0 = r1.intersect(r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x0083, code lost:
            
                if (r0 == null) goto L29;
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
            
                return r0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
            
                return androidx.compose.ui.geometry.Rect.INSTANCE.getZero();
             */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x0060, code lost:
            
                r2 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
            
                return androidx.compose.ui.geometry.Rect.INSTANCE.getZero();
             */
            /* JADX WARN: Code restructure failed: missing block: B:29:0x0048, code lost:
            
                r0 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:34:0x0028, code lost:
            
                if (r0 == androidx.compose.foundation.text2.input.internal.selection.TextToolbarState.Selection) goto L9;
             */
            /* JADX WARN: Code restructure failed: missing block: B:4:0x001c, code lost:
            
                if (r1 != androidx.compose.foundation.text2.input.internal.selection.TextToolbarState.Cursor) goto L6;
             */
            /* JADX WARN: Code restructure failed: missing block: B:6:0x0030, code lost:
            
                if (r6.this$0.getDraggingHandle() != null) goto L31;
             */
            /* JADX WARN: Code restructure failed: missing block: B:8:0x0038, code lost:
            
                if (r6.this$0.isInTouchMode() == false) goto L31;
             */
            /* JADX WARN: Code restructure failed: missing block: B:9:0x003a, code lost:
            
                r0 = r6.this$0.getTextLayoutCoordinates();
                r1 = null;
             */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final androidx.compose.ui.geometry.Rect invoke() {
                /*
                    r6 = this;
                    androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r0 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.this
                    androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r0 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.access$getTextFieldState$p(r0)
                    androidx.compose.foundation.text2.input.TextFieldCharSequence r0 = r0.getText()
                    long r0 = r0.getSelectionInChars()
                    boolean r0 = androidx.compose.ui.text.TextRange.m5232getCollapsedimpl(r0)
                    if (r0 == 0) goto L1e
                    androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r1 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.this
                    androidx.compose.foundation.text2.input.internal.selection.TextToolbarState r1 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.access$getTextToolbarState(r1)
                    androidx.compose.foundation.text2.input.internal.selection.TextToolbarState r2 = androidx.compose.foundation.text2.input.internal.selection.TextToolbarState.Cursor
                    if (r1 == r2) goto L2a
                L1e:
                    if (r0 != 0) goto L94
                    androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r0 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.this
                    androidx.compose.foundation.text2.input.internal.selection.TextToolbarState r0 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.access$getTextToolbarState(r0)
                    androidx.compose.foundation.text2.input.internal.selection.TextToolbarState r1 = androidx.compose.foundation.text2.input.internal.selection.TextToolbarState.Selection
                    if (r0 != r1) goto L94
                L2a:
                    androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r0 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.this
                    androidx.compose.foundation.text.Handle r0 = r0.getDraggingHandle()
                    if (r0 != 0) goto L94
                    androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r0 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.this
                    boolean r0 = r0.isInTouchMode()
                    if (r0 == 0) goto L94
                    androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r0 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.this
                    androidx.compose.ui.layout.LayoutCoordinates r0 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.access$getTextLayoutCoordinates(r0)
                    r1 = 0
                    if (r0 == 0) goto L48
                    androidx.compose.ui.geometry.Rect r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r0)
                    goto L49
                L48:
                    r0 = r1
                L49:
                    if (r0 == 0) goto L8d
                    androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r2 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.this
                    androidx.compose.ui.layout.LayoutCoordinates r2 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.access$getTextLayoutCoordinates(r2)
                    if (r2 == 0) goto L60
                    long r3 = r0.m3211getTopLeftF1C5BW0()
                    long r2 = r2.mo4696localToRootMKHz9U(r3)
                    androidx.compose.ui.geometry.Offset r2 = androidx.compose.ui.geometry.Offset.m3165boximpl(r2)
                    goto L61
                L60:
                    r2 = r1
                L61:
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                    long r2 = r2.getPackedValue()
                    long r4 = r0.m3209getSizeNHjbRc()
                    androidx.compose.ui.geometry.Rect r0 = androidx.compose.ui.geometry.RectKt.m3216Recttz77jQw(r2, r4)
                    androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r2 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.this
                    androidx.compose.ui.geometry.Rect r2 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.access$getContentRect(r2)
                    boolean r3 = r0.overlaps(r2)
                    if (r3 == 0) goto L7d
                    r1 = r2
                L7d:
                    if (r1 == 0) goto L86
                    androidx.compose.ui.geometry.Rect r0 = r1.intersect(r0)
                    if (r0 == 0) goto L86
                    goto L9a
                L86:
                    androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.INSTANCE
                    androidx.compose.ui.geometry.Rect r0 = r0.getZero()
                    goto L9a
                L8d:
                    androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.INSTANCE
                    androidx.compose.ui.geometry.Rect r0 = r0.getZero()
                    goto L9a
                L94:
                    androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.INSTANCE
                    androidx.compose.ui.geometry.Rect r0 = r0.getZero()
                L9a:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeTextToolbarVisibility$2.invoke():androidx.compose.ui.geometry.Rect");
            }
        }).collect(new FlowCollector() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeTextToolbarVisibility$3
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((Rect) obj, (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(Rect rect, Continuation<? super Unit> continuation2) {
                if (Intrinsics.areEqual(rect, Rect.INSTANCE.getZero())) {
                    TextFieldSelectionState.this.hideTextToolbar();
                } else {
                    TextFieldSelectionState.this.showTextToolbar(rect);
                }
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect getContentRect() {
        float f;
        Rect cursorRect;
        Rect cursorRect2;
        TextFieldCharSequence text = this.textFieldState.getText();
        if (TextRange.m5232getCollapsedimpl(text.getSelectionInChars())) {
            LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            return RectKt.m3216Recttz77jQw(textLayoutCoordinates != null ? textLayoutCoordinates.mo4696localToRootMKHz9U(getCursorRect().m3211getTopLeftF1C5BW0()) : Offset.INSTANCE.m3192getZeroF1C5BW0(), getCursorRect().m3209getSizeNHjbRc());
        }
        LayoutCoordinates textLayoutCoordinates2 = getTextLayoutCoordinates();
        long mo4696localToRootMKHz9U = textLayoutCoordinates2 != null ? textLayoutCoordinates2.mo4696localToRootMKHz9U(m1188getHandlePositiontuRUvjQ(true)) : Offset.INSTANCE.m3192getZeroF1C5BW0();
        LayoutCoordinates textLayoutCoordinates3 = getTextLayoutCoordinates();
        long mo4696localToRootMKHz9U2 = textLayoutCoordinates3 != null ? textLayoutCoordinates3.mo4696localToRootMKHz9U(m1188getHandlePositiontuRUvjQ(false)) : Offset.INSTANCE.m3192getZeroF1C5BW0();
        LayoutCoordinates textLayoutCoordinates4 = getTextLayoutCoordinates();
        float f2 = 0.0f;
        if (textLayoutCoordinates4 != null) {
            TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
            f = Offset.m3177getYimpl(textLayoutCoordinates4.mo4696localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult == null || (cursorRect2 = layoutResult.getCursorRect(TextRange.m5238getStartimpl(text.getSelectionInChars()))) == null) ? 0.0f : cursorRect2.getTop())));
        } else {
            f = 0.0f;
        }
        LayoutCoordinates textLayoutCoordinates5 = getTextLayoutCoordinates();
        if (textLayoutCoordinates5 != null) {
            TextLayoutResult layoutResult2 = this.textLayoutState.getLayoutResult();
            f2 = Offset.m3177getYimpl(textLayoutCoordinates5.mo4696localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult2 == null || (cursorRect = layoutResult2.getCursorRect(TextRange.m5233getEndimpl(text.getSelectionInChars()))) == null) ? 0.0f : cursorRect.getTop())));
        }
        return new Rect(Math.min(Offset.m3176getXimpl(mo4696localToRootMKHz9U), Offset.m3176getXimpl(mo4696localToRootMKHz9U2)), Math.min(f, f2), Math.max(Offset.m3176getXimpl(mo4696localToRootMKHz9U), Offset.m3176getXimpl(mo4696localToRootMKHz9U2)), Math.max(Offset.m3177getYimpl(mo4696localToRootMKHz9U), Offset.m3177getYimpl(mo4696localToRootMKHz9U2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextFieldHandleState getSelectionHandleState(boolean isStartHandle) {
        Rect visibleBounds;
        LayoutCoordinates textLayoutCoordinates;
        Rect visibleBounds2;
        Handle handle = isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextFieldHandleState.INSTANCE.getHidden();
        }
        long selectionInChars = this.textFieldState.getText().getSelectionInChars();
        if (TextRange.m5232getCollapsedimpl(selectionInChars)) {
            return TextFieldHandleState.INSTANCE.getHidden();
        }
        long m1188getHandlePositiontuRUvjQ = m1188getHandlePositiontuRUvjQ(isStartHandle);
        if (getDraggingHandle() != handle && ((textLayoutCoordinates = getTextLayoutCoordinates()) == null || (visibleBounds2 = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null || !SelectionManagerKt.m1048containsInclusiveUv8p0NA(visibleBounds2, m1188getHandlePositiontuRUvjQ))) {
            return TextFieldHandleState.INSTANCE.getHidden();
        }
        ResolvedTextDirection bidiRunDirection = layoutResult.getBidiRunDirection(isStartHandle ? TextRange.m5238getStartimpl(selectionInChars) : Math.max(TextRange.m5233getEndimpl(selectionInChars) - 1, 0));
        boolean m5237getReversedimpl = TextRange.m5237getReversedimpl(selectionInChars);
        LayoutCoordinates textLayoutCoordinates2 = getTextLayoutCoordinates();
        if (textLayoutCoordinates2 != null && (visibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates2)) != null) {
            m1188getHandlePositiontuRUvjQ = TextLayoutStateKt.m1154coerceIn3MmeM6k(m1188getHandlePositiontuRUvjQ, visibleBounds);
        }
        return new TextFieldHandleState(true, m1188getHandlePositiontuRUvjQ, bidiRunDirection, m5237getReversedimpl, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getHandlePosition-tuRUvjQ, reason: not valid java name */
    public final long m1188getHandlePositiontuRUvjQ(boolean isStartHandle) {
        int m5233getEndimpl;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Offset.INSTANCE.m3192getZeroF1C5BW0();
        }
        long selectionInChars = this.textFieldState.getText().getSelectionInChars();
        if (isStartHandle) {
            m5233getEndimpl = TextRange.m5238getStartimpl(selectionInChars);
        } else {
            m5233getEndimpl = TextRange.m5233getEndimpl(selectionInChars);
        }
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(layoutResult, m5233getEndimpl, isStartHandle, TextRange.m5237getReversedimpl(selectionInChars));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateHandleDragging-Uv8p0NA, reason: not valid java name */
    public final void m1194updateHandleDraggingUv8p0NA(Handle handle, long position) {
        setDraggingHandle(handle);
        m1192setRawHandleDragPositionk4lQ0M(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markStartContentVisibleOffset() {
        Rect visibleBounds;
        LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
        m1193setStartContentVisibleOffsetk4lQ0M((textLayoutCoordinates == null || (visibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) ? Offset.INSTANCE.m3191getUnspecifiedF1C5BW0() : visibleBounds.m3211getTopLeftF1C5BW0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearHandleDragging() {
        setDraggingHandle(null);
        m1192setRawHandleDragPositionk4lQ0M(Offset.INSTANCE.m3191getUnspecifiedF1C5BW0());
        m1193setStartContentVisibleOffsetk4lQ0M(Offset.INSTANCE.m3191getUnspecifiedF1C5BW0());
    }

    public final void cut() {
        TextFieldCharSequence text = this.textFieldState.getText();
        if (TextRange.m5232getCollapsedimpl(text.getSelectionInChars())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(text).toString(), null, null, 6, null));
        }
        this.textFieldState.deleteSelectedText();
    }

    public static /* synthetic */ void copy$default(TextFieldSelectionState textFieldSelectionState, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionState.copy(z);
    }

    public final void copy(boolean cancelSelection) {
        TextFieldCharSequence text = this.textFieldState.getText();
        if (TextRange.m5232getCollapsedimpl(text.getSelectionInChars())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(text).toString(), null, null, 6, null));
        }
        if (cancelSelection) {
            this.textFieldState.collapseSelectionToMax();
        }
    }

    public final void paste() {
        AnnotatedString text;
        String text2;
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager == null || (text = clipboardManager.getText()) == null || (text2 = text.getText()) == null) {
            return;
        }
        TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, text2, false, TextFieldEditUndoBehavior.NeverMerge, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showTextToolbar(Rect contentRect) {
        ClipboardManager clipboardManager;
        long selectionInChars = this.textFieldState.getText().getSelectionInChars();
        Function0<Unit> function0 = (getEditable() && (clipboardManager = this.clipboardManager) != null && clipboardManager.hasText()) ? new Function0<Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$paste$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TextFieldSelectionState.this.paste();
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.None);
            }
        } : null;
        Function0<Unit> function02 = !TextRange.m5232getCollapsedimpl(selectionInChars) ? new Function0<Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$copy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TextFieldSelectionState.copy$default(TextFieldSelectionState.this, false, 1, null);
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.None);
            }
        } : null;
        Function0<Unit> function03 = (TextRange.m5232getCollapsedimpl(selectionInChars) || !getEditable()) ? null : new Function0<Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$cut$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TextFieldSelectionState.this.cut();
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.None);
            }
        };
        Function0<Unit> function04 = TextRange.m5234getLengthimpl(selectionInChars) != this.textFieldState.getText().length() ? new Function0<Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$selectAll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TransformedTextFieldState transformedTextFieldState;
                transformedTextFieldState = TextFieldSelectionState.this.textFieldState;
                transformedTextFieldState.selectAll();
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
            }
        } : null;
        TextToolbar textToolbar = this.textToolbar;
        if (textToolbar != null) {
            textToolbar.showMenu(contentRect, function02, function0, function03, function04);
        }
    }

    public final void deselect() {
        if (!TextRange.m5232getCollapsedimpl(this.textFieldState.getText().getSelectionInChars())) {
            this.textFieldState.collapseSelectionToEnd();
        }
        setShowCursorHandle(false);
        updateTextToolbarState(TextToolbarState.None);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideTextToolbar() {
        TextToolbar textToolbar;
        TextToolbar textToolbar2 = this.textToolbar;
        if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
            return;
        }
        textToolbar.hide();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: updateSelection-QNhciaU$default, reason: not valid java name */
    public static /* synthetic */ long m1196updateSelectionQNhciaU$default(TextFieldSelectionState textFieldSelectionState, TextFieldCharSequence textFieldCharSequence, int i, int i2, boolean z, SelectionAdjustment selectionAdjustment, boolean z2, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            z2 = false;
        }
        return textFieldSelectionState.m1195updateSelectionQNhciaU(textFieldCharSequence, i, i2, z, selectionAdjustment, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateSelection-QNhciaU, reason: not valid java name */
    public final long m1195updateSelectionQNhciaU(TextFieldCharSequence textFieldCharSequence, int startOffset, int endOffset, boolean isStartHandle, SelectionAdjustment adjustment, boolean allowPreviousSelectionCollapsed) {
        HapticFeedback hapticFeedback;
        TextRange m5226boximpl = TextRange.m5226boximpl(textFieldCharSequence.getSelectionInChars());
        long packedValue = m5226boximpl.getPackedValue();
        if (!allowPreviousSelectionCollapsed && TextRange.m5232getCollapsedimpl(packedValue)) {
            m5226boximpl = null;
        }
        long m1191getTextFieldSelectionqeG_v_k = m1191getTextFieldSelectionqeG_v_k(startOffset, endOffset, m5226boximpl, isStartHandle, adjustment);
        if (TextRange.m5231equalsimpl0(m1191getTextFieldSelectionqeG_v_k, textFieldCharSequence.getSelectionInChars())) {
            return m1191getTextFieldSelectionqeG_v_k;
        }
        boolean z = TextRange.m5237getReversedimpl(m1191getTextFieldSelectionqeG_v_k) != TextRange.m5237getReversedimpl(textFieldCharSequence.getSelectionInChars()) && TextRange.m5231equalsimpl0(TextRangeKt.TextRange(TextRange.m5233getEndimpl(m1191getTextFieldSelectionqeG_v_k), TextRange.m5238getStartimpl(m1191getTextFieldSelectionqeG_v_k)), textFieldCharSequence.getSelectionInChars());
        if (isInTouchMode() && !z && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.mo4088performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4097getTextHandleMove5zf0vsI());
        }
        return m1191getTextFieldSelectionqeG_v_k;
    }

    /* renamed from: getTextFieldSelection-qeG_v_k, reason: not valid java name */
    private final long m1191getTextFieldSelectionqeG_v_k(int rawStartOffset, int rawEndOffset, TextRange previousSelection, boolean isStartHandle, SelectionAdjustment adjustment) {
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextRange.INSTANCE.m5243getZerod9O1mEE();
        }
        if (previousSelection == null && Intrinsics.areEqual(adjustment, SelectionAdjustment.INSTANCE.getCharacter())) {
            return TextRangeKt.TextRange(rawStartOffset, rawEndOffset);
        }
        SelectionLayout m1014getTextFieldSelectionLayoutRcvTLA = SelectionLayoutKt.m1014getTextFieldSelectionLayoutRcvTLA(layoutResult, rawStartOffset, rawEndOffset, this.previousRawDragOffset, previousSelection != null ? previousSelection.getPackedValue() : TextRange.INSTANCE.m5243getZerod9O1mEE(), previousSelection == null, isStartHandle);
        if (previousSelection != null && !m1014getTextFieldSelectionLayoutRcvTLA.shouldRecomputeSelection(this.previousSelectionLayout)) {
            return previousSelection.getPackedValue();
        }
        long m1002toTextRanged9O1mEE = adjustment.adjust(m1014getTextFieldSelectionLayoutRcvTLA).m1002toTextRanged9O1mEE();
        this.previousSelectionLayout = m1014getTextFieldSelectionLayoutRcvTLA;
        if (!isStartHandle) {
            rawStartOffset = rawEndOffset;
        }
        this.previousRawDragOffset = rawStartOffset;
        return m1002toTextRanged9O1mEE;
    }

    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle.setValue(handle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextToolbarState(TextToolbarState textToolbarState) {
        this.textToolbarState.setValue(textToolbarState);
    }

    public final TextFieldHandleState getCursorHandle() {
        return (TextFieldHandleState) this.cursorHandle.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getCursorHandleInBounds() {
        return ((Boolean) this.cursorHandleInBounds.getValue()).booleanValue();
    }

    public final Rect getCursorRect() {
        return (Rect) this.cursorRect.getValue();
    }

    public final TextFieldHandleState getStartSelectionHandle() {
        return (TextFieldHandleState) this.startSelectionHandle.getValue();
    }

    public final TextFieldHandleState getEndSelectionHandle() {
        return (TextFieldHandleState) this.endSelectionHandle.getValue();
    }
}
