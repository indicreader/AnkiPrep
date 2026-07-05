package com.example.flashcardapp.session;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.AnkiDataRepository;
import com.example.flashcardapp.data.PersistentProgressManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionGenerationEngine.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JD\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nH\u0086@¢\u0006\u0002\u0010\u0015J@\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nH\u0086@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/example/flashcardapp/session/SessionGenerationEngine;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "progressManager", "Lcom/example/flashcardapp/data/PersistentProgressManager;", "repo", "Lcom/example/flashcardapp/data/AnkiDataRepository;", "generateSessionCards", "", "Lcom/example/flashcardapp/data/entities/CardEntity;", "deckHierarchy", "", "deckId", "", "questionLimit", "", "isStarredOnly", "", "customDeckIds", "(Ljava/lang/String;JIZLjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRemainingUniqueCards", "(Ljava/lang/String;JZLjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class SessionGenerationEngine {
    public static final int $stable = 8;
    private final Context context;
    private final PersistentProgressManager progressManager;
    private final AnkiDataRepository repo;

    public SessionGenerationEngine(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.repo = AnkiDataRepository.INSTANCE.getInstance(context);
        this.progressManager = new PersistentProgressManager(context);
    }

    public static /* synthetic */ Object getRemainingUniqueCards$default(SessionGenerationEngine sessionGenerationEngine, String str, long j, boolean z, List list, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            list = null;
        }
        return sessionGenerationEngine.getRemainingUniqueCards(str, j, z2, list, continuation);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0022. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f7 A[LOOP:4: B:87:0x00f1->B:89:0x00f7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0126 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x009f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x020d -> B:22:0x0210). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getRemainingUniqueCards(java.lang.String r10, long r11, boolean r13, java.util.List<java.lang.Long> r14, kotlin.coroutines.Continuation<? super java.util.List<com.example.flashcardapp.data.entities.CardEntity>> r15) {
        /*
            Method dump skipped, instructions count: 638
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.session.SessionGenerationEngine.getRemainingUniqueCards(java.lang.String, long, boolean, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f0 A[LOOP:4: B:78:0x00ea->B:80:0x00f0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x011c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object generateSessionCards(java.lang.String r19, long r20, int r22, boolean r23, java.util.List<java.lang.Long> r24, kotlin.coroutines.Continuation<? super java.util.List<com.example.flashcardapp.data.entities.CardEntity>> r25) {
        /*
            Method dump skipped, instructions count: 535
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.session.SessionGenerationEngine.generateSessionCards(java.lang.String, long, int, boolean, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
