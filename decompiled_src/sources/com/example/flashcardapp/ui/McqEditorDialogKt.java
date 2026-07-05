package com.example.flashcardapp.ui;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: McqEditorDialog.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\f\u001aM\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\n\u001a\u001f\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001að\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\b2¨\u0001\u0010\u001d\u001a£\u0001\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b($\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(&\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00010\u001e2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020+H\u0007¢\u0006\u0002\u0010-¨\u0006.²\u0006\n\u0010/\u001a\u00020+X\u008a\u008e\u0002²\u0006\n\u00100\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u00101\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u00102\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u00103\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u00104\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u00105\u001a\u00020+X\u008a\u008e\u0002²\u0006\f\u0010$\u001a\u0004\u0018\u00010\u0003X\u008a\u008e\u0002²\u0006\f\u0010%\u001a\u0004\u0018\u00010\u0003X\u008a\u008e\u0002²\u0006\f\u0010&\u001a\u0004\u0018\u00010\u0003X\u008a\u008e\u0002²\u0006\u0010\u00106\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014X\u008a\u008e\u0002²\u0006\n\u00107\u001a\u00020+X\u008a\u008e\u0002"}, d2 = {"ImageFieldPicker", "", "label", "", "currentImagePath", "onImagePicked", "Lkotlin/Function1;", "onImageRemoved", "Lkotlin/Function0;", "searchSuggestion", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "LocalImagePreview", "relativePath", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "McqEditorDialog", "initialQuestion", "initialCorrectAnswer", "initialOptions", "", "initialExplanation", "initialTags", "initialFrontImage", "initialBackImage", "initialExplanationImage", "initialOptionImagesJson", "title", "onDismiss", "onSave", "Lkotlin/Function7;", "Lkotlin/ParameterName;", "name", "front", "back", "tagsJson", "frontImage", "backImage", "explanationImage", "optionImagesJson", "onPrevious", "onNext", "hasPrevious", "", "hasNext", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function7;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZZLandroidx/compose/runtime/Composer;III)V", "app_release", "showSearchDialog", "questionText", "correctAnswer", "distractorsText", "explanationText", "tagsText", "isMcqType", "optionImagesList", "addMoreMode"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class McqEditorDialogKt {
    /* JADX WARN: Can't wrap try/catch for region: R(26:1|(1:3)(2:72|(3:74|(1:76)(1:78)|77)(1:79))|4|(1:6)(2:65|(7:67|(1:69)(1:71)|70|8|(12:(1:20)(1:64)|21|(1:23)|24|(1:26)(1:63)|27|(5:51|52|53|(1:59)|61)|31|(1:33)(7:38|(1:40)|41|(1:43)(1:50)|44|(1:49)|48)|34|(1:36)|37)(1:12)|13|(2:15|16)(1:18)))|7|8|(1:10)|(0)(0)|21|(0)|24|(0)(0)|27|(1:29)|51|52|53|(3:55|57|59)|61|31|(0)(0)|34|(0)|37|13|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LocalImagePreview(final java.lang.String r30, androidx.compose.ui.Modifier r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 555
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.ui.McqEditorDialogKt.LocalImagePreview(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ImageFieldPicker(final java.lang.String r31, final java.lang.String r32, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r33, final kotlin.jvm.functions.Function0<kotlin.Unit> r34, java.lang.String r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 952
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.ui.McqEditorDialogKt.ImageFieldPicker(java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final boolean ImageFieldPicker$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ImageFieldPicker$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x055e  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x05e7  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x060a  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0275  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void McqEditorDialog(java.lang.String r46, java.lang.String r47, java.util.List<java.lang.String> r48, java.lang.String r49, java.lang.String r50, java.lang.String r51, java.lang.String r52, java.lang.String r53, java.lang.String r54, java.lang.String r55, final kotlin.jvm.functions.Function0<kotlin.Unit> r56, final kotlin.jvm.functions.Function7<? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, kotlin.Unit> r57, kotlin.jvm.functions.Function0<kotlin.Unit> r58, kotlin.jvm.functions.Function0<kotlin.Unit> r59, boolean r60, boolean r61, androidx.compose.runtime.Composer r62, final int r63, final int r64, final int r65) {
        /*
            Method dump skipped, instructions count: 1577
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.ui.McqEditorDialogKt.McqEditorDialog(java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function7, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, boolean, boolean, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String McqEditorDialog$lambda$10(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String McqEditorDialog$lambda$13(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String McqEditorDialog$lambda$18(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String McqEditorDialog$lambda$21(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String McqEditorDialog$lambda$24(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean McqEditorDialog$lambda$27(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void McqEditorDialog$lambda$28(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String McqEditorDialog$lambda$30(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String McqEditorDialog$lambda$33(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String McqEditorDialog$lambda$36(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<String> McqEditorDialog$lambda$40(MutableState<List<String>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean McqEditorDialog$lambda$43(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void McqEditorDialog$lambda$44(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void McqEditorDialog$saveCurrent(Function7<? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, Unit> function7, MutableState<Boolean> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4, MutableState<String> mutableState5, MutableState<List<String>> mutableState6, MutableState<String> mutableState7, MutableState<String> mutableState8, MutableState<String> mutableState9, MutableState<String> mutableState10, MutableState<Boolean> mutableState11) {
        ArrayList emptyList;
        if (McqEditorDialog$lambda$27(mutableState)) {
            List split$default = StringsKt.split$default((CharSequence) McqEditorDialog$lambda$18(mutableState2), new String[]{"\n"}, false, 0, 6, (Object) null);
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
            emptyList = arrayList2;
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        String str = StringsKt.trim((CharSequence) McqEditorDialog$lambda$13(mutableState4)).toString() + (emptyList.isEmpty() ^ true ? "|" + CollectionsKt.joinToString$default(emptyList, "|", null, null, 0, null, null, 62, null) : "") + (StringsKt.isBlank(McqEditorDialog$lambda$21(mutableState3)) ^ true ? "; " + StringsKt.trim((CharSequence) McqEditorDialog$lambda$21(mutableState3)).toString() : "");
        List split$default2 = StringsKt.split$default((CharSequence) McqEditorDialog$lambda$24(mutableState5), new String[]{","}, false, 0, 6, (Object) null);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default2, 10));
        Iterator it2 = split$default2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(StringsKt.trim((CharSequence) it2.next()).toString());
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (((String) obj2).length() > 0) {
                arrayList4.add(obj2);
            }
        }
        String json = new Gson().toJson(arrayList4);
        String json2 = (McqEditorDialog$lambda$27(mutableState) && (McqEditorDialog$lambda$40(mutableState6).isEmpty() ^ true)) ? new Gson().toJson(McqEditorDialog$lambda$40(mutableState6)) : null;
        String obj3 = StringsKt.trim((CharSequence) McqEditorDialog$lambda$10(mutableState7)).toString();
        Intrinsics.checkNotNull(json);
        function7.invoke(obj3, str, json, McqEditorDialog$lambda$30(mutableState8), McqEditorDialog$lambda$33(mutableState9), McqEditorDialog$lambda$36(mutableState10), json2);
        if (McqEditorDialog$lambda$43(mutableState11)) {
            mutableState7.setValue("");
            mutableState4.setValue("");
            mutableState2.setValue("");
            mutableState3.setValue("");
            mutableState8.setValue(null);
            mutableState9.setValue(null);
            mutableState10.setValue(null);
            mutableState6.setValue(CollectionsKt.emptyList());
        }
    }
}
