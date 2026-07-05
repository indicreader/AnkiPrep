package com.example.flashcardapp.mcq;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.CardEntity;
import com.example.flashcardapp.mcq.RouteResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: McqRouter.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J2\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0086@¢\u0006\u0002\u0010\u0013J>\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0086@¢\u0006\u0002\u0010\u0016J.\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0082@¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/example/flashcardapp/mcq/McqRouter;", "", "engine", "Lcom/example/flashcardapp/mcq/McqEngine;", "(Lcom/example/flashcardapp/mcq/McqEngine;)V", "formatOutput", "", "mcq", "Lcom/example/flashcardapp/mcq/Mcq;", "isTypeBFormat", "", "back", "route", "Lcom/example/flashcardapp/mcq/RouteResult;", "card", "Lcom/example/flashcardapp/data/entities/CardEntity;", "allCards", "", "difficulty", "(Lcom/example/flashcardapp/data/entities/CardEntity;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "routeAll", "cards", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "routeTypeA", "routeTypeB", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class McqRouter {
    public static final int $stable = 8;
    private final McqEngine engine;

    /* JADX WARN: Multi-variable type inference failed */
    public McqRouter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public McqRouter(McqEngine engine) {
        Intrinsics.checkNotNullParameter(engine, "engine");
        this.engine = engine;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ McqRouter(com.example.flashcardapp.mcq.McqEngine r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r1 = this;
            r3 = r3 & 1
            if (r3 == 0) goto Lc
            com.example.flashcardapp.mcq.McqEngine r2 = new com.example.flashcardapp.mcq.McqEngine
            r3 = 0
            r4 = 3
            r0 = 0
            r2.<init>(r0, r3, r4, r0)
        Lc:
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.mcq.McqRouter.<init>(com.example.flashcardapp.mcq.McqEngine, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object route$default(McqRouter mcqRouter, CardEntity cardEntity, List list, String str, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 4) != 0) {
            str = null;
        }
        return mcqRouter.route(cardEntity, list, str, continuation);
    }

    public final Object route(CardEntity cardEntity, List<CardEntity> list, String str, Continuation<? super RouteResult> continuation) {
        String obj = StringsKt.trim((CharSequence) cardEntity.getBack()).toString();
        if (isTypeBFormat(obj)) {
            return routeTypeB(cardEntity, obj);
        }
        return routeTypeA(cardEntity, list, str, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0087 -> B:10:0x008c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object routeAll(java.util.List<com.example.flashcardapp.data.entities.CardEntity> r8, java.util.List<com.example.flashcardapp.data.entities.CardEntity> r9, java.lang.String r10, kotlin.coroutines.Continuation<? super java.util.List<? extends com.example.flashcardapp.mcq.RouteResult>> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.example.flashcardapp.mcq.McqRouter$routeAll$1
            if (r0 == 0) goto L14
            r0 = r11
            com.example.flashcardapp.mcq.McqRouter$routeAll$1 r0 = (com.example.flashcardapp.mcq.McqRouter$routeAll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.example.flashcardapp.mcq.McqRouter$routeAll$1 r0 = new com.example.flashcardapp.mcq.McqRouter$routeAll$1
            r0.<init>(r7, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L4a
            if (r2 != r3) goto L42
            java.lang.Object r8 = r0.L$5
            java.util.Collection r8 = (java.util.Collection) r8
            java.lang.Object r9 = r0.L$4
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r10 = r0.L$3
            java.util.Collection r10 = (java.util.Collection) r10
            java.lang.Object r2 = r0.L$2
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r4 = r0.L$1
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r0.L$0
            com.example.flashcardapp.mcq.McqRouter r5 = (com.example.flashcardapp.mcq.McqRouter) r5
            kotlin.ResultKt.throwOnFailure(r11)
            goto L8c
        L42:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L4a:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r11 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r2)
            r11.<init>(r2)
            java.util.Collection r11 = (java.util.Collection) r11
            java.util.Iterator r8 = r8.iterator()
            r5 = r7
            r6 = r9
            r9 = r8
            r8 = r11
            r11 = r10
            r10 = r6
        L66:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L95
            java.lang.Object r2 = r9.next()
            com.example.flashcardapp.data.entities.CardEntity r2 = (com.example.flashcardapp.data.entities.CardEntity) r2
            r0.L$0 = r5
            r0.L$1 = r10
            r0.L$2 = r11
            r0.L$3 = r8
            r0.L$4 = r9
            r0.L$5 = r8
            r0.label = r3
            java.lang.Object r2 = r5.route(r2, r10, r11, r0)
            if (r2 != r1) goto L87
            return r1
        L87:
            r4 = r10
            r10 = r8
            r6 = r2
            r2 = r11
            r11 = r6
        L8c:
            com.example.flashcardapp.mcq.RouteResult r11 = (com.example.flashcardapp.mcq.RouteResult) r11
            r8.add(r11)
            r8 = r10
            r11 = r2
            r10 = r4
            goto L66
        L95:
            java.util.List r8 = (java.util.List) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.mcq.McqRouter.routeAll(java.util.List, java.util.List, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object routeAll$default(McqRouter mcqRouter, List list, List list2, String str, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        if ((i & 4) != 0) {
            str = null;
        }
        return mcqRouter.routeAll(list, list2, str, continuation);
    }

    private final boolean isTypeBFormat(String back) {
        int indexOf$default = StringsKt.indexOf$default((CharSequence) back, ';', 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            back = back.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(back, "substring(...)");
        }
        String str = back;
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '|') {
                i++;
            }
        }
        return i >= 3;
    }

    private final RouteResult routeTypeB(CardEntity card, String back) {
        String str;
        String str2 = back;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str2, ';', 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            String substring = str2.substring(indexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            str = StringsKt.trim((CharSequence) substring).toString();
        } else {
            str = "";
        }
        String str3 = str;
        if (indexOf$default != -1) {
            String substring2 = str2.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            str2 = StringsKt.trim((CharSequence) substring2).toString();
        }
        List split$default = StringsKt.split$default((CharSequence) str2, new String[]{"|"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        Iterator it = split$default.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.size() < 4) {
            return new RouteResult.Failure("TYPE_B format requires exactly 4 options (1 correct + 3 distractors), got " + arrayList3.size() + " in card id=" + card.getId());
        }
        List plus = CollectionsKt.plus((Collection) CollectionsKt.listOf((String) arrayList3.get(0)), (Iterable) CollectionsKt.take(CollectionsKt.drop(arrayList3, 1), 3));
        List list = plus;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            String lowerCase = ((String) it2.next()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            arrayList4.add(lowerCase);
        }
        if (CollectionsKt.distinct(arrayList4).size() != plus.size()) {
            return new RouteResult.Failure("TYPE_B card id=" + card.getId() + " has duplicate options after normalisation.");
        }
        Mcq mcq = new Mcq(StringsKt.trim((CharSequence) card.getFront()).toString(), plus, 0, card.getId(), CollectionsKt.listOf((Object[]) new Long[]{-1L, -1L, -1L}), card.getDeckHierarchy(), str3, "medium", "concept", null, null, null, null, null, 15872, null);
        if (!mcq.isValid()) {
            return new RouteResult.Failure("TYPE_B card id=" + card.getId() + " failed MCQ invariant check.");
        }
        return new RouteResult.Success(formatOutput(mcq), mcq, InputType.TYPE_B);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object routeTypeA(com.example.flashcardapp.data.entities.CardEntity r15, java.util.List<com.example.flashcardapp.data.entities.CardEntity> r16, java.lang.String r17, kotlin.coroutines.Continuation<? super com.example.flashcardapp.mcq.RouteResult> r18) {
        /*
            r14 = this;
            r0 = r14
            r1 = r18
            boolean r2 = r1 instanceof com.example.flashcardapp.mcq.McqRouter$routeTypeA$1
            if (r2 == 0) goto L17
            r2 = r1
            com.example.flashcardapp.mcq.McqRouter$routeTypeA$1 r2 = (com.example.flashcardapp.mcq.McqRouter$routeTypeA$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L17
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1c
        L17:
            com.example.flashcardapp.mcq.McqRouter$routeTypeA$1 r2 = new com.example.flashcardapp.mcq.McqRouter$routeTypeA$1
            r2.<init>(r14, r1)
        L1c:
            r10 = r2
            java.lang.Object r1 = r10.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r10.label
            r4 = 1
            if (r3 == 0) goto L43
            if (r3 != r4) goto L3b
            java.lang.Object r2 = r10.L$2
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r10.L$1
            com.example.flashcardapp.data.entities.CardEntity r3 = (com.example.flashcardapp.data.entities.CardEntity) r3
            java.lang.Object r4 = r10.L$0
            com.example.flashcardapp.mcq.McqRouter r4 = (com.example.flashcardapp.mcq.McqRouter) r4
            kotlin.ResultKt.throwOnFailure(r1)
            r13 = r3
            goto L78
        L3b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L43:
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r16
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r3 = r1.isEmpty()
            if (r3 == 0) goto L54
            java.util.List r1 = kotlin.collections.CollectionsKt.listOf(r15)
        L54:
            java.util.List r1 = (java.util.List) r1
            com.example.flashcardapp.mcq.McqEngine r3 = r0.engine
            java.util.List r5 = kotlin.collections.CollectionsKt.listOf(r15)
            r6 = 0
            r7 = 0
            r8 = 0
            r11 = 28
            r12 = 0
            r10.L$0 = r0
            r13 = r15
            r10.L$1 = r13
            r10.L$2 = r1
            r10.label = r4
            r4 = r1
            r9 = r17
            java.lang.Object r3 = com.example.flashcardapp.mcq.McqEngine.generate$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            if (r3 != r2) goto L75
            return r2
        L75:
            r4 = r0
            r2 = r1
            r1 = r3
        L78:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L80:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L9a
            java.lang.Object r3 = r1.next()
            r5 = r3
            com.example.flashcardapp.mcq.Mcq r5 = (com.example.flashcardapp.mcq.Mcq) r5
            long r5 = r5.getSourceCardId()
            long r7 = r13.getId()
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L80
            goto L9b
        L9a:
            r3 = 0
        L9b:
            com.example.flashcardapp.mcq.Mcq r3 = (com.example.flashcardapp.mcq.Mcq) r3
            if (r3 != 0) goto Lcc
            com.example.flashcardapp.mcq.RouteResult$Failure r1 = new com.example.flashcardapp.mcq.RouteResult$Failure
            long r3 = r13.getId()
            int r2 = r2.size()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "TYPE_A generation failed for card id="
            r5.<init>(r6)
            java.lang.StringBuilder r3 = r5.append(r3)
            java.lang.String r4 = ": insufficient distractors in dataset pool (size="
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r3 = ")."
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            return r1
        Lcc:
            com.example.flashcardapp.mcq.RouteResult$Success r1 = new com.example.flashcardapp.mcq.RouteResult$Success
            java.lang.String r2 = r4.formatOutput(r3)
            com.example.flashcardapp.mcq.InputType r4 = com.example.flashcardapp.mcq.InputType.TYPE_A
            r1.<init>(r2, r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.mcq.McqRouter.routeTypeA(com.example.flashcardapp.data.entities.CardEntity, java.util.List, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String formatOutput(Mcq mcq) {
        String correctAnswer = mcq.getCorrectAnswer();
        List<String> options = mcq.getOptions();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : options) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (i != mcq.getCorrectIndex()) {
                arrayList.add(obj);
            }
            i = i2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(correctAnswer);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append(" |").append((String) it.next());
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return mcq.getQuestion() + ", " + sb2 + (!StringsKt.isBlank(mcq.getExplanation()) ? "; " + mcq.getExplanation() : "");
    }
}
