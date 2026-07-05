package com.example.flashcardapp.ui;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProfileTab.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.ui.ProfileTabKt$ProfileTab$2", f = "ProfileTab.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class ProfileTabKt$ProfileTab$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<List<ExamItem>> $exams$delegate;
    final /* synthetic */ MutableState<Integer> $examsVersion$delegate;
    final /* synthetic */ SharedPreferences $sharedPrefs;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileTabKt$ProfileTab$2(SharedPreferences sharedPreferences, Context context, MutableState<List<ExamItem>> mutableState, MutableState<Integer> mutableState2, Continuation<? super ProfileTabKt$ProfileTab$2> continuation) {
        super(2, continuation);
        this.$sharedPrefs = sharedPreferences;
        this.$context = context;
        this.$exams$delegate = mutableState;
        this.$examsVersion$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileTabKt$ProfileTab$2(this.$sharedPrefs, this.$context, this.$exams$delegate, this.$examsVersion$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileTabKt$ProfileTab$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProfileTab.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.example.flashcardapp.ui.ProfileTabKt$ProfileTab$2$1", f = "ProfileTab.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.example.flashcardapp.ui.ProfileTabKt$ProfileTab$2$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ MutableState<List<ExamItem>> $exams$delegate;
        final /* synthetic */ SharedPreferences $sharedPrefs;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SharedPreferences sharedPreferences, Context context, MutableState<List<ExamItem>> mutableState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$sharedPrefs = sharedPreferences;
            this.$context = context;
            this.$exams$delegate = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$sharedPrefs, this.$context, this.$exams$delegate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List<ExamItem> ProfileTab$lambda$25;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ProfileTab$lambda$25 = ProfileTabKt.ProfileTab$lambda$25(this.$exams$delegate);
                for (ExamItem examItem : ProfileTab$lambda$25) {
                    try {
                        URLConnection openConnection = new URL(examItem.getUrl()).openConnection();
                        Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                        httpURLConnection.setConnectTimeout(5000);
                        httpURLConnection.setReadTimeout(5000);
                        InputStream inputStream = httpURLConnection.getInputStream();
                        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
                        Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                        try {
                            String readText = TextStreamsKt.readText(bufferedReader);
                            CloseableKt.closeFinally(bufferedReader, null);
                            String valueOf = String.valueOf(readText.hashCode());
                            String string = this.$sharedPrefs.getString("exam_hash_" + examItem.getUrl(), null);
                            if (string != null && !Intrinsics.areEqual(string, valueOf)) {
                                this.$sharedPrefs.edit().putString("exam_hash_" + examItem.getUrl(), valueOf).putBoolean("exam_has_delta_" + examItem.getUrl(), true).apply();
                                ProfileTabKt.showExamNotification(this.$context, examItem.getName());
                            } else if (string == null) {
                                this.$sharedPrefs.edit().putString("exam_hash_" + examItem.getUrl(), valueOf).apply();
                            }
                        } catch (Throwable th) {
                            try {
                                throw th;
                                break;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(bufferedReader, th);
                                throw th2;
                                break;
                            }
                        }
                    } catch (Exception unused) {
                        continue;
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int ProfileTab$lambda$48;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(this.$sharedPrefs, this.$context, this.$exams$delegate, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ProfileTab$lambda$48 = ProfileTabKt.ProfileTab$lambda$48(this.$examsVersion$delegate);
        ProfileTabKt.ProfileTab$lambda$49(this.$examsVersion$delegate, ProfileTab$lambda$48 + 1);
        return Unit.INSTANCE;
    }
}
