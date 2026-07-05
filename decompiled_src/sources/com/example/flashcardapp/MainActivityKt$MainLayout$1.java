package com.example.flashcardapp;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.PeriodicWorkRequest;
import com.example.flashcardapp.data.AnkiDataRepository;
import com.example.flashcardapp.data.AnkiDroidBridge;
import com.example.flashcardapp.ui.ProfileTabKt;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.YieldKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.MainActivityKt$MainLayout$1", f = "MainActivity.kt", i = {}, l = {711}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class MainActivityKt$MainLayout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Integer> $cardCount$delegate;
    final /* synthetic */ Context $context;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ MutableState<Integer> $deckCount$delegate;
    final /* synthetic */ MutableState<Boolean> $hasPermission$delegate;
    final /* synthetic */ AnkiDataRepository $repo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivityKt$MainLayout$1(Context context, CoroutineScope coroutineScope, MutableState<Boolean> mutableState, AnkiDataRepository ankiDataRepository, MutableState<Integer> mutableState2, MutableState<Integer> mutableState3, Continuation<? super MainActivityKt$MainLayout$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$coroutineScope = coroutineScope;
        this.$hasPermission$delegate = mutableState;
        this.$repo = ankiDataRepository;
        this.$deckCount$delegate = mutableState2;
        this.$cardCount$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivityKt$MainLayout$1(this.$context, this.$coroutineScope, this.$hasPermission$delegate, this.$repo, this.$deckCount$delegate, this.$cardCount$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivityKt$MainLayout$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MainActivityKt.MainLayout$lambda$20(this.$hasPermission$delegate, AnkiDroidBridge.INSTANCE.hasPermission(this.$context));
            this.label = 1;
            if (YieldKt.yield(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        MainActivityKt.MainLayout$reloadDbStats(this.$coroutineScope, this.$repo, this.$deckCount$delegate, this.$cardCount$delegate);
        BuildersKt__Builders_commonKt.launch$default(this.$coroutineScope, Dispatchers.getIO(), null, new AnonymousClass1(this.$repo, this.$context, this.$hasPermission$delegate, this.$coroutineScope, this.$deckCount$delegate, this.$cardCount$delegate, null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(this.$coroutineScope, Dispatchers.getIO(), null, new AnonymousClass2(this.$context, null), 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.example.flashcardapp.MainActivityKt$MainLayout$1$1", f = "MainActivity.kt", i = {}, l = {718, 720, 722, 725}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.example.flashcardapp.MainActivityKt$MainLayout$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<Integer> $cardCount$delegate;
        final /* synthetic */ Context $context;
        final /* synthetic */ CoroutineScope $coroutineScope;
        final /* synthetic */ MutableState<Integer> $deckCount$delegate;
        final /* synthetic */ MutableState<Boolean> $hasPermission$delegate;
        final /* synthetic */ AnkiDataRepository $repo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AnkiDataRepository ankiDataRepository, Context context, MutableState<Boolean> mutableState, CoroutineScope coroutineScope, MutableState<Integer> mutableState2, MutableState<Integer> mutableState3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$repo = ankiDataRepository;
            this.$context = context;
            this.$hasPermission$delegate = mutableState;
            this.$coroutineScope = coroutineScope;
            this.$deckCount$delegate = mutableState2;
            this.$cardCount$delegate = mutableState3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$repo, this.$context, this.$hasPermission$delegate, this.$coroutineScope, this.$deckCount$delegate, this.$cardCount$delegate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x00c7 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0061 A[Catch: Exception -> 0x0031, TryCatch #0 {Exception -> 0x0031, blocks: (B:8:0x0018, B:14:0x0025, B:15:0x007b, B:18:0x0029, B:19:0x0058, B:21:0x0061, B:24:0x006b, B:28:0x002d, B:29:0x0045, B:33:0x0037), top: B:2:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x007a A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.String r0 = "Diagnostics done: "
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r13.label
                r3 = 4
                r4 = 3
                r5 = 2
                java.lang.String r6 = "MainActivity"
                r7 = 1
                if (r2 == 0) goto L34
                if (r2 == r7) goto L2d
                if (r2 == r5) goto L29
                if (r2 == r4) goto L25
                if (r2 != r3) goto L1d
                kotlin.ResultKt.throwOnFailure(r14)     // Catch: java.lang.Exception -> L31
                goto Lde
            L1d:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L25:
                kotlin.ResultKt.throwOnFailure(r14)     // Catch: java.lang.Exception -> L31
                goto L7b
            L29:
                kotlin.ResultKt.throwOnFailure(r14)     // Catch: java.lang.Exception -> L31
                goto L58
            L2d:
                kotlin.ResultKt.throwOnFailure(r14)     // Catch: java.lang.Exception -> L31
                goto L45
            L31:
                r14 = move-exception
                goto Lc8
            L34:
                kotlin.ResultKt.throwOnFailure(r14)
                com.example.flashcardapp.data.AnkiDataRepository r14 = r13.$repo     // Catch: java.lang.Exception -> L31
                r2 = r13
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2     // Catch: java.lang.Exception -> L31
                r13.label = r7     // Catch: java.lang.Exception -> L31
                java.lang.Object r14 = r14.loadDefaultAliasesIfNeeded(r2)     // Catch: java.lang.Exception -> L31
                if (r14 != r1) goto L45
                return r1
            L45:
                java.lang.String r14 = "Background sync + diagnostics starting…"
                android.util.Log.d(r6, r14)     // Catch: java.lang.Exception -> L31
                com.example.flashcardapp.data.AnkiDataRepository r14 = r13.$repo     // Catch: java.lang.Exception -> L31
                r2 = r13
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2     // Catch: java.lang.Exception -> L31
                r13.label = r5     // Catch: java.lang.Exception -> L31
                java.lang.Object r14 = r14.isCachePopulated(r2)     // Catch: java.lang.Exception -> L31
                if (r14 != r1) goto L58
                return r1
            L58:
                java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch: java.lang.Exception -> L31
                boolean r14 = r14.booleanValue()     // Catch: java.lang.Exception -> L31
                r2 = 0
                if (r14 != 0) goto L6a
                androidx.compose.runtime.MutableState<java.lang.Boolean> r14 = r13.$hasPermission$delegate     // Catch: java.lang.Exception -> L31
                boolean r14 = com.example.flashcardapp.MainActivityKt.access$MainLayout$lambda$19(r14)     // Catch: java.lang.Exception -> L31
                if (r14 == 0) goto L6a
                goto L6b
            L6a:
                r7 = r2
            L6b:
                com.example.flashcardapp.data.DataLayerDiagnostics r14 = com.example.flashcardapp.data.DataLayerDiagnostics.INSTANCE     // Catch: java.lang.Exception -> L31
                android.content.Context r2 = r13.$context     // Catch: java.lang.Exception -> L31
                r5 = r13
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Exception -> L31
                r13.label = r4     // Catch: java.lang.Exception -> L31
                java.lang.Object r14 = r14.runFullDiagnostics(r2, r7, r5)     // Catch: java.lang.Exception -> L31
                if (r14 != r1) goto L7b
                return r1
            L7b:
                com.example.flashcardapp.data.DiagnosticsReport r14 = (com.example.flashcardapp.data.DiagnosticsReport) r14     // Catch: java.lang.Exception -> L31
                int r2 = r14.getTotalDecks()     // Catch: java.lang.Exception -> L31
                int r14 = r14.getTotalCards()     // Catch: java.lang.Exception -> L31
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L31
                r4.<init>(r0)     // Catch: java.lang.Exception -> L31
                java.lang.StringBuilder r0 = r4.append(r2)     // Catch: java.lang.Exception -> L31
                java.lang.String r2 = " decks, "
                java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Exception -> L31
                java.lang.StringBuilder r14 = r0.append(r14)     // Catch: java.lang.Exception -> L31
                java.lang.String r0 = " cards"
                java.lang.StringBuilder r14 = r14.append(r0)     // Catch: java.lang.Exception -> L31
                java.lang.String r14 = r14.toString()     // Catch: java.lang.Exception -> L31
                android.util.Log.d(r6, r14)     // Catch: java.lang.Exception -> L31
                kotlinx.coroutines.MainCoroutineDispatcher r14 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L31
                kotlin.coroutines.CoroutineContext r14 = (kotlin.coroutines.CoroutineContext) r14     // Catch: java.lang.Exception -> L31
                com.example.flashcardapp.MainActivityKt$MainLayout$1$1$1 r0 = new com.example.flashcardapp.MainActivityKt$MainLayout$1$1$1     // Catch: java.lang.Exception -> L31
                kotlinx.coroutines.CoroutineScope r8 = r13.$coroutineScope     // Catch: java.lang.Exception -> L31
                com.example.flashcardapp.data.AnkiDataRepository r9 = r13.$repo     // Catch: java.lang.Exception -> L31
                androidx.compose.runtime.MutableState<java.lang.Integer> r10 = r13.$deckCount$delegate     // Catch: java.lang.Exception -> L31
                androidx.compose.runtime.MutableState<java.lang.Integer> r11 = r13.$cardCount$delegate     // Catch: java.lang.Exception -> L31
                r12 = 0
                r7 = r0
                r7.<init>(r8, r9, r10, r11, r12)     // Catch: java.lang.Exception -> L31
                kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0     // Catch: java.lang.Exception -> L31
                r2 = r13
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2     // Catch: java.lang.Exception -> L31
                r13.label = r3     // Catch: java.lang.Exception -> L31
                java.lang.Object r14 = kotlinx.coroutines.BuildersKt.withContext(r14, r0, r2)     // Catch: java.lang.Exception -> L31
                if (r14 != r1) goto Lde
                return r1
            Lc8:
                java.lang.String r14 = r14.getMessage()
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "Background diagnostics failed: "
                r0.<init>(r1)
                java.lang.StringBuilder r14 = r0.append(r14)
                java.lang.String r14 = r14.toString()
                android.util.Log.e(r6, r14)
            Lde:
                kotlin.Unit r14 = kotlin.Unit.INSTANCE
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.MainActivityKt$MainLayout$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MainActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(c = "com.example.flashcardapp.MainActivityKt$MainLayout$1$1$1", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.example.flashcardapp.MainActivityKt$MainLayout$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ MutableState<Integer> $cardCount$delegate;
            final /* synthetic */ CoroutineScope $coroutineScope;
            final /* synthetic */ MutableState<Integer> $deckCount$delegate;
            final /* synthetic */ AnkiDataRepository $repo;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00641(CoroutineScope coroutineScope, AnkiDataRepository ankiDataRepository, MutableState<Integer> mutableState, MutableState<Integer> mutableState2, Continuation<? super C00641> continuation) {
                super(2, continuation);
                this.$coroutineScope = coroutineScope;
                this.$repo = ankiDataRepository;
                this.$deckCount$delegate = mutableState;
                this.$cardCount$delegate = mutableState2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00641(this.$coroutineScope, this.$repo, this.$deckCount$delegate, this.$cardCount$delegate, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00641) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                MainActivityKt.MainLayout$reloadDbStats(this.$coroutineScope, this.$repo, this.$deckCount$delegate, this.$cardCount$delegate);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.example.flashcardapp.MainActivityKt$MainLayout$1$2", f = "MainActivity.kt", i = {}, l = {770}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.example.flashcardapp.MainActivityKt$MainLayout$1$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0 && i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            do {
                SharedPreferences sharedPreferences = this.$context.getSharedPreferences("AnkiPrepProfile", 0);
                String string = sharedPreferences.getString("saved_exams", null);
                if (string != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(string);
                        int length = jSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            String string2 = jSONObject.getString("name");
                            String string3 = jSONObject.getString(ImagesContract.URL);
                            URLConnection openConnection = new URL(string3).openConnection();
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
                                String string4 = sharedPreferences.getString("exam_hash_" + string3, null);
                                if (string4 != null && !Intrinsics.areEqual(string4, valueOf)) {
                                    sharedPreferences.edit().putString("exam_hash_" + string3, valueOf).putBoolean("exam_has_delta_" + string3, true).apply();
                                    Context context = this.$context;
                                    Intrinsics.checkNotNull(string2);
                                    ProfileTabKt.showExamNotification(context, string2);
                                } else if (string4 == null) {
                                    sharedPreferences.edit().putString("exam_hash_" + string3, valueOf).apply();
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
                        }
                    } catch (Exception unused) {
                    }
                }
                this.label = 1;
            } while (DelayKt.delay(PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS, this) != coroutine_suspended);
            return coroutine_suspended;
        }
    }
}
