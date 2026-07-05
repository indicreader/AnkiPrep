package androidx.compose.foundation.text2.input.internal;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.foundation.text2.input.InputTransformation;
import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.foundation.text2.input.TextFieldState;
import androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2;
import androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.ui.platform.PlatformTextInputMethodRequest;
import androidx.compose.ui.platform.PlatformTextInputSession;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidTextInputSession.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2", f = "AndroidTextInputSession.android.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ ComposeInputMethodManager $composeImm;
    final /* synthetic */ ImeOptions $imeOptions;
    final /* synthetic */ Function1<ImeAction, Unit> $onImeAction;
    final /* synthetic */ TransformedTextFieldState $state;
    final /* synthetic */ PlatformTextInputSession $this_platformSpecificTextInputSession;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2(PlatformTextInputSession platformTextInputSession, TransformedTextFieldState transformedTextFieldState, ComposeInputMethodManager composeInputMethodManager, ImeOptions imeOptions, Function1<? super ImeAction, Unit> function1, Continuation<? super AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2> continuation) {
        super(2, continuation);
        this.$this_platformSpecificTextInputSession = platformTextInputSession;
        this.$state = transformedTextFieldState;
        this.$composeImm = composeInputMethodManager;
        this.$imeOptions = imeOptions;
        this.$onImeAction = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2 androidTextInputSession_androidKt$platformSpecificTextInputSession$2 = new AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2(this.$this_platformSpecificTextInputSession, this.$state, this.$composeImm, this.$imeOptions, this.$onImeAction, continuation);
        androidTextInputSession_androidKt$platformSpecificTextInputSession$2.L$0 = obj;
        return androidTextInputSession_androidKt$platformSpecificTextInputSession$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        return ((AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AndroidTextInputSession.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$1", f = "AndroidTextInputSession.android.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ComposeInputMethodManager $composeImm;
        final /* synthetic */ ImeOptions $imeOptions;
        final /* synthetic */ TransformedTextFieldState $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TransformedTextFieldState transformedTextFieldState, ComposeInputMethodManager composeInputMethodManager, ImeOptions imeOptions, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = transformedTextFieldState;
            this.$composeImm = composeInputMethodManager;
            this.$imeOptions = imeOptions;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$state, this.$composeImm, this.$imeOptions, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TransformedTextFieldState transformedTextFieldState = this.$state;
                final ComposeInputMethodManager composeInputMethodManager = this.$composeImm;
                final ImeOptions imeOptions = this.$imeOptions;
                this.label = 1;
                if (transformedTextFieldState.collectImeNotifications(new TextFieldState.NotifyImeListener() { // from class: androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$1$$ExternalSyntheticLambda0
                    @Override // androidx.compose.foundation.text2.input.TextFieldState.NotifyImeListener
                    public final void onChange(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2) {
                        AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2.AnonymousClass1.invokeSuspend$lambda$0(ComposeInputMethodManager.this, imeOptions, textFieldCharSequence, textFieldCharSequence2);
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(ComposeInputMethodManager composeInputMethodManager, ImeOptions imeOptions, TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2) {
            if (!TextRange.m5231equalsimpl0(textFieldCharSequence.getSelectionInChars(), textFieldCharSequence2.getSelectionInChars()) || !Intrinsics.areEqual(textFieldCharSequence.getCompositionInChars(), textFieldCharSequence2.getCompositionInChars())) {
                int m5236getMinimpl = TextRange.m5236getMinimpl(textFieldCharSequence2.getSelectionInChars());
                int m5235getMaximpl = TextRange.m5235getMaximpl(textFieldCharSequence2.getSelectionInChars());
                TextRange compositionInChars = textFieldCharSequence2.getCompositionInChars();
                int m5236getMinimpl2 = compositionInChars != null ? TextRange.m5236getMinimpl(compositionInChars.getPackedValue()) : -1;
                TextRange compositionInChars2 = textFieldCharSequence2.getCompositionInChars();
                composeInputMethodManager.updateSelection(m5236getMinimpl, m5235getMaximpl, m5236getMinimpl2, compositionInChars2 != null ? TextRange.m5235getMaximpl(compositionInChars2.getPackedValue()) : -1);
            }
            if (textFieldCharSequence.contentEquals(textFieldCharSequence2) || KeyboardType.m5450equalsimpl0(imeOptions.getKeyboardType(), KeyboardType.INSTANCE.m5468getPasswordPjHm6EE())) {
                return;
            }
            composeInputMethodManager.restartInput();
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(this.$state, this.$composeImm, this.$imeOptions, null), 1, null);
            PlatformTextInputSession platformTextInputSession = this.$this_platformSpecificTextInputSession;
            final TransformedTextFieldState transformedTextFieldState = this.$state;
            final ImeOptions imeOptions = this.$imeOptions;
            final ComposeInputMethodManager composeInputMethodManager = this.$composeImm;
            final Function1<ImeAction, Unit> function1 = this.$onImeAction;
            this.label = 1;
            if (platformTextInputSession.startInputMethod(new PlatformTextInputMethodRequest() { // from class: androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$$ExternalSyntheticLambda0
                @Override // androidx.compose.ui.platform.PlatformTextInputMethodRequest
                public final InputConnection createInputConnection(EditorInfo editorInfo) {
                    InputConnection invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2.invokeSuspend$lambda$0(TransformedTextFieldState.this, imeOptions, composeInputMethodManager, function1, editorInfo);
                    return invokeSuspend$lambda$0;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InputConnection invokeSuspend$lambda$0(final TransformedTextFieldState transformedTextFieldState, ImeOptions imeOptions, final ComposeInputMethodManager composeInputMethodManager, final Function1 function1, EditorInfo editorInfo) {
        AndroidTextInputSession_androidKt.logDebug$default(null, new Function0<String>() { // from class: androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "createInputConnection(value=\"" + ((Object) TransformedTextFieldState.this.getText()) + "\")";
            }
        }, 1, null);
        TextInputSession textInputSession = new TextInputSession() { // from class: androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$2$textInputSession$1
            @Override // androidx.compose.foundation.text2.input.internal.TextInputSession
            public TextFieldCharSequence getText() {
                return TransformedTextFieldState.this.getText();
            }

            @Override // androidx.compose.foundation.text2.input.internal.TextInputSession
            public void sendKeyEvent(KeyEvent keyEvent) {
                composeInputMethodManager.sendKeyEvent(keyEvent);
            }

            @Override // androidx.compose.foundation.text2.input.internal.TextInputSession
            /* renamed from: onImeAction-KlQnJC8, reason: not valid java name */
            public void mo1111onImeActionKlQnJC8(int imeAction) {
                Function1<ImeAction, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(ImeAction.m5400boximpl(imeAction));
                }
            }

            @Override // androidx.compose.foundation.text2.input.internal.TextInputSession
            public void requestEdit(Function1<? super EditingBuffer, Unit> block) {
                TransformedTextFieldState transformedTextFieldState2 = TransformedTextFieldState.this;
                TextFieldState textFieldState = transformedTextFieldState2.textFieldState;
                InputTransformation inputTransformation = transformedTextFieldState2.inputTransformation;
                TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
                TextFieldCharSequence text = textFieldState.getText();
                textFieldState.getMainBuffer().getChangeTracker().clearChanges();
                block.invoke(textFieldState.getMainBuffer());
                if (textFieldState.getMainBuffer().getChangeTracker().getChangeCount() == 0 && TextRange.m5231equalsimpl0(text.getSelectionInChars(), textFieldState.getMainBuffer().m1113getSelectiond9O1mEE()) && Intrinsics.areEqual(text.getCompositionInChars(), textFieldState.getMainBuffer().m1112getCompositionMzsxiRA())) {
                    return;
                }
                textFieldState.commitEditAsUser(text, inputTransformation, false, textFieldEditUndoBehavior);
            }
        };
        AndroidTextInputSession_androidKt.update(editorInfo, transformedTextFieldState.getText(), imeOptions);
        return new StatelessInputConnection(textInputSession);
    }
}
