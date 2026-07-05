package com.example.flashcardapp.ui;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.SessionRecordEntity;
import com.example.flashcardapp.session.StreakCalculator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HomeScreenState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/example/flashcardapp/ui/HomeStats;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.ui.HomeScreenStateKt$computeHomeStats$2", f = "HomeScreenState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class HomeScreenStateKt$computeHomeStats$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HomeStats>, Object> {
    final /* synthetic */ int $cardCount;
    final /* synthetic */ List<SessionRecordEntity> $sessionRecords;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeScreenStateKt$computeHomeStats$2(int i, List<SessionRecordEntity> list, Continuation<? super HomeScreenStateKt$computeHomeStats$2> continuation) {
        super(2, continuation);
        this.$cardCount = i;
        this.$sessionRecords = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeScreenStateKt$computeHomeStats$2(this.$cardCount, this.$sessionRecords, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HomeStats> continuation) {
        return ((HomeScreenStateKt$computeHomeStats$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int i = this.$cardCount;
            Iterator<T> it = this.$sessionRecords.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                i2 += ((SessionRecordEntity) it.next()).getTotalQuestions();
            }
            int coerceAtLeast = RangesKt.coerceAtLeast(i - i2, 0);
            Iterator<T> it2 = this.$sessionRecords.iterator();
            int i3 = 0;
            while (it2.hasNext()) {
                i3 += ((SessionRecordEntity) it2.next()).getTotalQuestions();
            }
            Iterator<T> it3 = this.$sessionRecords.iterator();
            int i4 = 0;
            while (it3.hasNext()) {
                i4 += ((SessionRecordEntity) it3.next()).getScore();
            }
            float f = i3 > 0 ? (i4 / i3) * 100.0f : 0.0f;
            Iterator<T> it4 = this.$sessionRecords.iterator();
            long j = 0;
            while (it4.hasNext()) {
                j += ((SessionRecordEntity) it4.next()).getTimeTakenSeconds();
            }
            float f2 = i3 > 0 ? ((float) j) / i3 : 0.0f;
            long currentTimeMillis = System.currentTimeMillis();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            Calendar calendar = Calendar.getInstance();
            for (SessionRecordEntity sessionRecordEntity : this.$sessionRecords) {
                long j2 = currentTimeMillis;
                long timestamp = (currentTimeMillis - sessionRecordEntity.getTimestamp()) / 86400000;
                if (0 <= timestamp && timestamp < 7) {
                    calendar.setTimeInMillis(sessionRecordEntity.getTimestamp());
                    String format = simpleDateFormat.format(calendar.getTime());
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    linkedHashSet.add(format);
                }
                currentTimeMillis = j2;
            }
            StreakCalculator.StreakInfo calculate = StreakCalculator.INSTANCE.calculate(this.$sessionRecords);
            List<SessionRecordEntity> list = this.$sessionRecords;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (SessionRecordEntity sessionRecordEntity2 : list) {
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTimeInMillis(sessionRecordEntity2.getTimestamp());
                calendar2.set(11, 0);
                calendar2.set(12, 0);
                calendar2.set(13, 0);
                calendar2.set(14, 0);
                arrayList.add(Boxing.boxLong(calendar2.getTimeInMillis()));
            }
            return new HomeStats(coerceAtLeast, f, f2, linkedHashSet.size(), calculate, CollectionsKt.toHashSet(arrayList));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
