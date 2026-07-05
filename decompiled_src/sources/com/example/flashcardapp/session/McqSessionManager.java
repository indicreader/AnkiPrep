package com.example.flashcardapp.session;

import android.os.Handler;
import android.os.Looper;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.mcq.Mcq;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: McqSession.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001a\u0010\u0019\u001a\u00020\f2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nJ\u0006\u0010\u001b\u001a\u00020\fJ\u0006\u0010\u001c\u001a\u00020\u000bJ\u0006\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0006J\u0006\u0010 \u001a\u00020\u000bJ\b\u0010!\u001a\u00020\fH\u0002J\u0006\u0010\"\u001a\u00020\u000bJ\u001a\u0010#\u001a\u00020\f2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nJ\u0016\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u0006R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/example/flashcardapp/session/McqSessionManager;", "", "mode", "Lcom/example/flashcardapp/session/McqSessionMode;", "questions", "", "Lcom/example/flashcardapp/mcq/Mcq;", "(Lcom/example/flashcardapp/session/McqSessionMode;Ljava/util/List;)V", "listeners", "", "Lkotlin/Function1;", "Lcom/example/flashcardapp/session/McqSessionState;", "", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "Lkotlin/Lazy;", "onSessionFinished", "getOnSessionFinished", "()Lkotlin/jvm/functions/Function1;", "setOnSessionFinished", "(Lkotlin/jvm/functions/Function1;)V", "state", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "deleteCurrentQuestion", "finishSession", "getCurrentState", "insertNextQuestion", "newMcq", "nextQuestion", "notifyListeners", "previousQuestion", "removeListener", "selectOption", "optionIndex", "", "timeTakenMs", "", "updateCurrentQuestion", "updatedMcq", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class McqSessionManager {
    private static final String TAG = "McqSessionDiagnostics";
    private final List<Function1<McqSessionState, Unit>> listeners;

    /* renamed from: mainHandler$delegate, reason: from kotlin metadata */
    private final Lazy mainHandler;
    private final McqSessionMode mode;
    private Function1<? super McqSessionState, Unit> onSessionFinished;
    private final List<Mcq> questions;
    private McqSessionState state;
    public static final int $stable = 8;

    /* renamed from: getCurrentState, reason: from getter */
    public final McqSessionState getState() {
        return this.state;
    }

    public final Function1<McqSessionState, Unit> getOnSessionFinished() {
        return this.onSessionFinished;
    }

    public final void setOnSessionFinished(Function1<? super McqSessionState, Unit> function1) {
        this.onSessionFinished = function1;
    }

    public McqSessionManager(McqSessionMode mode, List<Mcq> questions) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(questions, "questions");
        this.mode = mode;
        this.questions = questions;
        this.state = new McqSessionState(mode, questions, 0, 0, CollectionsKt.emptyList(), MapsKt.emptyMap(), MapsKt.emptyMap(), 0L, questions.isEmpty());
        this.listeners = new ArrayList();
        SessionLogger.INSTANCE.i(TAG, "═══════════════════════════════════════════════════════");
        SessionLogger.INSTANCE.i(TAG, "  MCQ SESSION STARTED");
        SessionLogger.INSTANCE.i(TAG, "  Mode:       " + mode);
        SessionLogger.INSTANCE.i(TAG, "  Questions:  " + questions.size());
        int i = 0;
        for (Object obj : questions) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Mcq mcq = (Mcq) obj;
            SessionLogger.INSTANCE.d(TAG, "    [" + i + "] Card ID: " + mcq.getSourceCardId() + " | Q: " + StringsKt.take(mcq.getQuestion(), 40) + "...");
            i = i2;
        }
        SessionLogger.INSTANCE.i(TAG, "═══════════════════════════════════════════════════════");
        this.mainHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.example.flashcardapp.session.McqSessionManager$mainHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                try {
                    return new Handler(Looper.getMainLooper());
                } catch (Exception unused) {
                    return null;
                }
            }
        });
    }

    public final void addListener(Function1<? super McqSessionState, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
        listener.invoke(this.state);
    }

    public final void removeListener(Function1<? super McqSessionState, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    public final McqSessionState selectOption(int optionIndex, long timeTakenMs) {
        McqSessionState copy;
        McqSessionState copy2;
        if (this.state.isFinished()) {
            SessionLogger.INSTANCE.w(TAG, "Cannot select option: session is finished.");
            return this.state;
        }
        int currentQuestionIndex = this.state.getCurrentQuestionIndex();
        Mcq currentQuestion = this.state.getCurrentQuestion();
        if (currentQuestion == null) {
            return this.state;
        }
        if (this.mode == McqSessionMode.PRACTICE || this.mode == McqSessionMode.REVISION || this.mode == McqSessionMode.RATED_PRIORITY) {
            if (this.state.isQuestionAnswered(currentQuestionIndex)) {
                return this.state;
            }
            boolean z = optionIndex == currentQuestion.getCorrectIndex();
            int score = this.state.getScore();
            if (z) {
                score++;
            }
            copy = r12.copy((r22 & 1) != 0 ? r12.mode : null, (r22 & 2) != 0 ? r12.questions : null, (r22 & 4) != 0 ? r12.currentQuestionIndex : 0, (r22 & 8) != 0 ? r12.score : score, (r22 & 16) != 0 ? r12.answeredQuestions : CollectionsKt.plus((Collection<? extends AnswerRecord>) this.state.getAnsweredQuestions(), new AnswerRecord(currentQuestion, optionIndex, z, timeTakenMs)), (r22 & 32) != 0 ? r12.selections : MapsKt.plus(this.state.getSelections(), TuplesKt.to(Integer.valueOf(currentQuestionIndex), Integer.valueOf(optionIndex))), (r22 & 64) != 0 ? r12.questionTimingsMs : MapsKt.plus(this.state.getQuestionTimingsMs(), TuplesKt.to(Integer.valueOf(currentQuestionIndex), Long.valueOf(timeTakenMs))), (r22 & 128) != 0 ? r12.totalTimeTakenMs : this.state.getTotalTimeTakenMs() + timeTakenMs, (r22 & 256) != 0 ? this.state.isFinished : false);
            this.state = copy;
            SessionLogger.INSTANCE.i(TAG, "  Practice Answer Selected: Q#" + currentQuestionIndex + " -> Option " + optionIndex + " | Correct: " + z);
        } else {
            Map plus = MapsKt.plus(this.state.getSelections(), TuplesKt.to(Integer.valueOf(currentQuestionIndex), Integer.valueOf(optionIndex)));
            Long l = this.state.getQuestionTimingsMs().get(Integer.valueOf(currentQuestionIndex));
            copy2 = r11.copy((r22 & 1) != 0 ? r11.mode : null, (r22 & 2) != 0 ? r11.questions : null, (r22 & 4) != 0 ? r11.currentQuestionIndex : 0, (r22 & 8) != 0 ? r11.score : 0, (r22 & 16) != 0 ? r11.answeredQuestions : null, (r22 & 32) != 0 ? r11.selections : plus, (r22 & 64) != 0 ? r11.questionTimingsMs : MapsKt.plus(this.state.getQuestionTimingsMs(), TuplesKt.to(Integer.valueOf(currentQuestionIndex), Long.valueOf((l != null ? l.longValue() : 0L) + timeTakenMs))), (r22 & 128) != 0 ? r11.totalTimeTakenMs : this.state.getTotalTimeTakenMs() + timeTakenMs, (r22 & 256) != 0 ? this.state.isFinished : false);
            this.state = copy2;
            SessionLogger.INSTANCE.i(TAG, "  Test Option Selected: Q#" + currentQuestionIndex + " -> Option " + optionIndex + " (temporary)");
        }
        notifyListeners();
        return this.state;
    }

    public final McqSessionState nextQuestion() {
        McqSessionState copy;
        if (this.state.getCurrentQuestionIndex() < this.state.getQuestions().size() - 1) {
            McqSessionState mcqSessionState = this.state;
            copy = mcqSessionState.copy((r22 & 1) != 0 ? mcqSessionState.mode : null, (r22 & 2) != 0 ? mcqSessionState.questions : null, (r22 & 4) != 0 ? mcqSessionState.currentQuestionIndex : mcqSessionState.getCurrentQuestionIndex() + 1, (r22 & 8) != 0 ? mcqSessionState.score : 0, (r22 & 16) != 0 ? mcqSessionState.answeredQuestions : null, (r22 & 32) != 0 ? mcqSessionState.selections : null, (r22 & 64) != 0 ? mcqSessionState.questionTimingsMs : null, (r22 & 128) != 0 ? mcqSessionState.totalTimeTakenMs : 0L, (r22 & 256) != 0 ? mcqSessionState.isFinished : false);
            this.state = copy;
            SessionLogger.INSTANCE.d(TAG, "  Navigated Next to question " + this.state.getCurrentQuestionIndex());
            notifyListeners();
        } else if (this.mode == McqSessionMode.PRACTICE || this.mode == McqSessionMode.REVISION) {
            finishSession();
        }
        return this.state;
    }

    public final McqSessionState previousQuestion() {
        McqSessionState copy;
        if (this.state.getCurrentQuestionIndex() > 0) {
            copy = r1.copy((r22 & 1) != 0 ? r1.mode : null, (r22 & 2) != 0 ? r1.questions : null, (r22 & 4) != 0 ? r1.currentQuestionIndex : r1.getCurrentQuestionIndex() - 1, (r22 & 8) != 0 ? r1.score : 0, (r22 & 16) != 0 ? r1.answeredQuestions : null, (r22 & 32) != 0 ? r1.selections : null, (r22 & 64) != 0 ? r1.questionTimingsMs : null, (r22 & 128) != 0 ? r1.totalTimeTakenMs : 0L, (r22 & 256) != 0 ? this.state.isFinished : false);
            this.state = copy;
            SessionLogger.INSTANCE.d(TAG, "  Navigated Previous to question " + this.state.getCurrentQuestionIndex());
            notifyListeners();
        }
        return this.state;
    }

    public final McqSessionState finishSession() {
        McqSessionState copy;
        McqSessionState copy2;
        if (this.state.isFinished()) {
            return this.state;
        }
        if (this.mode == McqSessionMode.TEST) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            int i2 = 0;
            for (Object obj : this.state.getQuestions()) {
                int i3 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Mcq mcq = (Mcq) obj;
                Integer num = this.state.getSelections().get(Integer.valueOf(i));
                int intValue = num != null ? num.intValue() : -1;
                boolean z = intValue == mcq.getCorrectIndex();
                if (z) {
                    i2++;
                }
                Long l = this.state.getQuestionTimingsMs().get(Integer.valueOf(i));
                arrayList.add(new AnswerRecord(mcq, intValue, z, l != null ? l.longValue() : 0L));
                i = i3;
            }
            copy2 = r1.copy((r22 & 1) != 0 ? r1.mode : null, (r22 & 2) != 0 ? r1.questions : null, (r22 & 4) != 0 ? r1.currentQuestionIndex : 0, (r22 & 8) != 0 ? r1.score : i2, (r22 & 16) != 0 ? r1.answeredQuestions : arrayList, (r22 & 32) != 0 ? r1.selections : null, (r22 & 64) != 0 ? r1.questionTimingsMs : null, (r22 & 128) != 0 ? r1.totalTimeTakenMs : 0L, (r22 & 256) != 0 ? this.state.isFinished : true);
            this.state = copy2;
        } else {
            copy = r1.copy((r22 & 1) != 0 ? r1.mode : null, (r22 & 2) != 0 ? r1.questions : null, (r22 & 4) != 0 ? r1.currentQuestionIndex : 0, (r22 & 8) != 0 ? r1.score : 0, (r22 & 16) != 0 ? r1.answeredQuestions : null, (r22 & 32) != 0 ? r1.selections : null, (r22 & 64) != 0 ? r1.questionTimingsMs : null, (r22 & 128) != 0 ? r1.totalTimeTakenMs : 0L, (r22 & 256) != 0 ? this.state.isFinished : true);
            this.state = copy;
        }
        SessionLogger.INSTANCE.i(TAG, "═══════════════════════════════════════════════════════");
        SessionLogger.INSTANCE.i(TAG, "  MCQ SESSION FINISHED");
        SessionLogger.INSTANCE.i(TAG, "  Final Score: " + this.state.getScore() + "/" + this.state.getQuestions().size());
        SessionLogger.INSTANCE.i(TAG, "  Total Time:  " + this.state.getTotalTimeTakenMs() + "ms");
        SessionLogger.INSTANCE.i(TAG, "═══════════════════════════════════════════════════════");
        notifyListeners();
        Function1<? super McqSessionState, Unit> function1 = this.onSessionFinished;
        if (function1 != null) {
            function1.invoke(this.state);
        }
        return this.state;
    }

    public final void updateCurrentQuestion(Mcq updatedMcq) {
        McqSessionState copy;
        Intrinsics.checkNotNullParameter(updatedMcq, "updatedMcq");
        if (this.state.getQuestions().isEmpty()) {
            return;
        }
        List mutableList = CollectionsKt.toMutableList((Collection) this.state.getQuestions());
        mutableList.set(this.state.getCurrentQuestionIndex(), updatedMcq);
        copy = r1.copy((r22 & 1) != 0 ? r1.mode : null, (r22 & 2) != 0 ? r1.questions : mutableList, (r22 & 4) != 0 ? r1.currentQuestionIndex : 0, (r22 & 8) != 0 ? r1.score : 0, (r22 & 16) != 0 ? r1.answeredQuestions : null, (r22 & 32) != 0 ? r1.selections : null, (r22 & 64) != 0 ? r1.questionTimingsMs : null, (r22 & 128) != 0 ? r1.totalTimeTakenMs : 0L, (r22 & 256) != 0 ? this.state.isFinished : false);
        this.state = copy;
        SessionLogger.INSTANCE.d(TAG, "  Current question updated (ID: " + updatedMcq.getSourceCardId() + ")");
        notifyListeners();
    }

    public final void insertNextQuestion(Mcq newMcq) {
        McqSessionState copy;
        Intrinsics.checkNotNullParameter(newMcq, "newMcq");
        List mutableList = CollectionsKt.toMutableList((Collection) this.state.getQuestions());
        if (this.state.getQuestions().isEmpty()) {
            mutableList.add(newMcq);
        } else {
            mutableList.add(this.state.getCurrentQuestionIndex() + 1, newMcq);
        }
        copy = r3.copy((r22 & 1) != 0 ? r3.mode : null, (r22 & 2) != 0 ? r3.questions : mutableList, (r22 & 4) != 0 ? r3.currentQuestionIndex : 0, (r22 & 8) != 0 ? r3.score : 0, (r22 & 16) != 0 ? r3.answeredQuestions : null, (r22 & 32) != 0 ? r3.selections : null, (r22 & 64) != 0 ? r3.questionTimingsMs : null, (r22 & 128) != 0 ? r3.totalTimeTakenMs : 0L, (r22 & 256) != 0 ? this.state.isFinished : false);
        this.state = copy;
        SessionLogger.INSTANCE.d(TAG, "  New question inserted at index " + (this.state.getQuestions().size() == 1 ? 0 : 1 + this.state.getCurrentQuestionIndex()) + " (ID: " + newMcq.getSourceCardId() + ")");
        notifyListeners();
    }

    public final void deleteCurrentQuestion() {
        int size;
        McqSessionState copy;
        if (this.state.getQuestions().isEmpty()) {
            return;
        }
        int currentQuestionIndex = this.state.getCurrentQuestionIndex();
        List mutableList = CollectionsKt.toMutableList((Collection) this.state.getQuestions());
        Mcq currentQuestion = this.state.getCurrentQuestion();
        mutableList.remove(currentQuestionIndex);
        if (mutableList.isEmpty()) {
            size = 0;
        } else {
            size = currentQuestionIndex >= mutableList.size() ? mutableList.size() - 1 : currentQuestionIndex;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Integer, Integer> entry : this.state.getSelections().entrySet()) {
            int intValue = entry.getKey().intValue();
            int intValue2 = entry.getValue().intValue();
            if (intValue < currentQuestionIndex) {
                linkedHashMap.put(Integer.valueOf(intValue), Integer.valueOf(intValue2));
            } else if (intValue > currentQuestionIndex) {
                linkedHashMap.put(Integer.valueOf(intValue - 1), Integer.valueOf(intValue2));
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<Integer, Long> entry2 : this.state.getQuestionTimingsMs().entrySet()) {
            int intValue3 = entry2.getKey().intValue();
            long longValue = entry2.getValue().longValue();
            if (intValue3 < currentQuestionIndex) {
                linkedHashMap2.put(Integer.valueOf(intValue3), Long.valueOf(longValue));
            } else if (intValue3 > currentQuestionIndex) {
                linkedHashMap2.put(Integer.valueOf(intValue3 - 1), Long.valueOf(longValue));
            }
        }
        List<AnswerRecord> answeredQuestions = this.state.getAnsweredQuestions();
        ArrayList arrayList = new ArrayList();
        for (Object obj : answeredQuestions) {
            if (!(currentQuestion != null && ((AnswerRecord) obj).getQuestion().getSourceCardId() == currentQuestion.getSourceCardId())) {
                arrayList.add(obj);
            }
        }
        copy = r2.copy((r22 & 1) != 0 ? r2.mode : null, (r22 & 2) != 0 ? r2.questions : mutableList, (r22 & 4) != 0 ? r2.currentQuestionIndex : size, (r22 & 8) != 0 ? r2.score : 0, (r22 & 16) != 0 ? r2.answeredQuestions : arrayList, (r22 & 32) != 0 ? r2.selections : linkedHashMap, (r22 & 64) != 0 ? r2.questionTimingsMs : linkedHashMap2, (r22 & 128) != 0 ? r2.totalTimeTakenMs : 0L, (r22 & 256) != 0 ? this.state.isFinished : mutableList.isEmpty());
        this.state = copy;
        SessionLogger.INSTANCE.d(TAG, "  Current question deleted from session (index: " + currentQuestionIndex + ")");
        notifyListeners();
    }

    private final Handler getMainHandler() {
        return (Handler) this.mainHandler.getValue();
    }

    private final void notifyListeners() {
        final McqSessionState mcqSessionState = this.state;
        final List list = CollectionsKt.toList(this.listeners);
        Handler mainHandler = getMainHandler();
        if (mainHandler != null) {
            mainHandler.post(new Runnable() { // from class: com.example.flashcardapp.session.McqSessionManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    McqSessionManager.notifyListeners$lambda$6(list, mcqSessionState);
                }
            });
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(mcqSessionState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyListeners$lambda$6(List listenersCopy, McqSessionState snapshot) {
        Intrinsics.checkNotNullParameter(listenersCopy, "$listenersCopy");
        Intrinsics.checkNotNullParameter(snapshot, "$snapshot");
        Iterator it = listenersCopy.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(snapshot);
        }
    }
}
