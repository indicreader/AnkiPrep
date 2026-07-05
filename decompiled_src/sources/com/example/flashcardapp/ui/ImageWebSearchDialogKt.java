package com.example.flashcardapp.ui;

import android.content.Context;
import android.webkit.WebView;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ImageWebSearchDialog.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001aH\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u000f\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\f\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u008a\u008e\u0002²\u0006\f\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u008a\u008e\u0002²\u0006\f\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u008a\u008e\u0002"}, d2 = {"ImageWebSearchDialog", "", "initialQuery", "", "onDismiss", "Lkotlin/Function0;", "onImageSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "relativePath", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_release", "stage", "Lcom/example/flashcardapp/ui/SearchStage;", "queryText", "capturedUrl", "saveError", "webViewRef", "Landroid/webkit/WebView;"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ImageWebSearchDialogKt {
    public static final void ImageWebSearchDialog(String str, final Function0<Unit> onDismiss, final Function1<? super String, Unit> onImageSelected, Composer composer, final int i, final int i2) {
        String str2;
        int i3;
        final String str3;
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onImageSelected, "onImageSelected");
        Composer startRestartGroup = composer.startRestartGroup(2096504666);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            str2 = str;
        } else if ((i & 14) == 0) {
            str2 = str;
            i3 = (startRestartGroup.changed(str2) ? 4 : 2) | i;
        } else {
            str2 = str;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changedInstance(onDismiss) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changedInstance(onImageSelected) ? 256 : 128;
        }
        int i5 = i3;
        if ((i5 & 731) != 146 || !startRestartGroup.getSkipping()) {
            String str4 = i4 != 0 ? "" : str2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2096504666, i5, -1, "com.example.flashcardapp.ui.ImageWebSearchDialog (ImageWebSearchDialog.kt:61)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Context context = (Context) consume;
            startRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            startRestartGroup.endReplaceableGroup();
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1312822947);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(SearchStage.SEARCH, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1312823016);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str4, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1312823081);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue4;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1312823145);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue5;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1312823285);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final MutableState mutableState5 = (MutableState) rememberedValue6;
            startRestartGroup.endReplaceableGroup();
            final String str5 = "(function() {\n    function attachListeners() {\n        document.querySelectorAll('img').forEach(function(img) {\n            if (img.dataset.ankiprepAttached) return;\n            img.dataset.ankiprepAttached = 'true';\n            img.addEventListener('contextmenu', function(e) {\n                e.preventDefault();\n                var src = img.src || img.getAttribute('data-src') || img.getAttribute('data-iurl') || '';\n                if (src && src.startsWith('http')) {\n                    Android.onImageSelected(src);\n                }\n            });\n            // Also handle touchstart + hold (500ms) for mobile long-press\n            var timer;\n            img.addEventListener('touchstart', function(e) {\n                timer = setTimeout(function() {\n                    var src = img.src || img.getAttribute('data-src') || img.getAttribute('data-iurl') || '';\n                    if (src && src.startsWith('http')) {\n                        Android.onImageSelected(src);\n                    }\n                }, 600);\n            });\n            img.addEventListener('touchend', function() { clearTimeout(timer); });\n            img.addEventListener('touchmove', function() { clearTimeout(timer); });\n        });\n    }\n    attachListeners();\n    // Re-attach when new images are lazily loaded\n    var observer = new MutationObserver(function() { attachListeners(); });\n    observer.observe(document.body, { childList: true, subtree: true });\n})();";
            final String str6 = str4;
            String str7 = str4;
            AndroidDialog_androidKt.Dialog(onDismiss, new DialogProperties(true, false, null, false, false, 20, null), ComposableLambdaKt.composableLambda(startRestartGroup, -1938211599, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ImageWebSearchDialogKt$ImageWebSearchDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    if ((i6 & 11) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1938211599, i6, -1, "com.example.flashcardapp.ui.ImageWebSearchDialog.<anonymous> (ImageWebSearchDialog.kt:116)");
                        }
                        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        long background = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getBackground();
                        final Function0<Unit> function0 = onDismiss;
                        final MutableState<SearchStage> mutableState6 = mutableState;
                        final MutableState<String> mutableState7 = mutableState3;
                        final MutableState<String> mutableState8 = mutableState2;
                        final MutableState<WebView> mutableState9 = mutableState5;
                        final String str8 = str5;
                        final String str9 = str6;
                        final MutableState<String> mutableState10 = mutableState4;
                        final CoroutineScope coroutineScope2 = coroutineScope;
                        final Function1<String, Unit> function1 = onImageSelected;
                        final Context context2 = context;
                        SurfaceKt.m1985SurfaceT9BRK9s(fillMaxSize$default, null, background, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, 693545100, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ImageWebSearchDialogKt$ImageWebSearchDialog$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:48:0x069e  */
                            /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            public final void invoke(androidx.compose.runtime.Composer r41, int r42) {
                                /*
                                    Method dump skipped, instructions count: 1698
                                    To view this dump add '--comments-level debug' option
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.ui.ImageWebSearchDialogKt$ImageWebSearchDialog$1.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                            }
                        }), composer2, 12582918, 122);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, ((i5 >> 3) & 14) | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str3 = str7;
        } else {
            startRestartGroup.skipToGroupEnd();
            str3 = str2;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ImageWebSearchDialogKt$ImageWebSearchDialog$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    ImageWebSearchDialogKt.ImageWebSearchDialog(str3, onDismiss, onImageSelected, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchStage ImageWebSearchDialog$lambda$1(MutableState<SearchStage> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ImageWebSearchDialog$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ImageWebSearchDialog$lambda$7(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ImageWebSearchDialog$lambda$10(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebView ImageWebSearchDialog$lambda$13(MutableState<WebView> mutableState) {
        return mutableState.getValue();
    }
}
