package com.example.flashcardapp.ui;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.DateRangeKt;
import androidx.compose.material.icons.outlined.EditKt;
import androidx.compose.material.icons.outlined.NotificationsKt;
import androidx.compose.material.icons.outlined.PersonKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.OutlinedTextFieldDefaults;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SwitchDefaults;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.example.flashcardapp.data.SettingsRepository;
import com.example.flashcardapp.receiver.ReminderScheduler;
import com.example.flashcardapp.ui.theme.ThemeKt;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* compiled from: ProfileScreen.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u001a,\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0012H\u0002\u001a:\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u0017H\u0002¨\u0006\u0018²\u0006\n\u0010\u0019\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\n\u0010\u001a\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\n\u0010\u001c\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\n\u0010\u001d\u001a\u00020\u001eX\u008a\u008e\u0002²\u0006\n\u0010\u001f\u001a\u00020\rX\u008a\u008e\u0002²\u0006\n\u0010 \u001a\u00020\rX\u008a\u008e\u0002²\u0006\u0010\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\"X\u008a\u008e\u0002²\u0006\n\u0010#\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\n\u0010$\u001a\u00020\u0006X\u008a\u008e\u0002"}, d2 = {"ProfileScreen", "", "onBackPressed", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "copyUriToInternalStorage", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "formatTime", "hour", "", "minute", "showDatePicker", "currentDateStr", "onDateSelected", "Lkotlin/Function1;", "showTimePicker", "initialHour", "initialMinute", "onTimeSelected", "Lkotlin/Function2;", "app_release", "userName", "imagePath", "dateOfBirth", "importantDatesJson", "reminderEnabled", "", "reminderHour", "reminderMinute", "reminderDays", "", "newDateLabel", "newDateValue"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ProfileScreenKt {
    public static final void ProfileScreen(final Function0<Unit> onBackPressed, Composer composer, final int i) {
        int i2;
        List emptyList;
        ImageBitmap imageBitmap;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onBackPressed, "onBackPressed");
        Composer startRestartGroup = composer.startRestartGroup(1175192154);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(onBackPressed) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1175192154, i2, -1, "com.example.flashcardapp.ui.ProfileScreen (ProfileScreen.kt:54)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Context context = (Context) consume;
            startRestartGroup.startReplaceableGroup(1776274182);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SettingsRepository.INSTANCE.getInstance(context);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final SettingsRepository settingsRepository = (SettingsRepository) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1776274250);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Gson();
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final Gson gson = (Gson) rememberedValue2;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1776274337);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            ImageBitmap imageBitmap2 = null;
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(settingsRepository.getUserName(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1776274409);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(settingsRepository.getUserProfileImageUri(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue4;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1776274494);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(settingsRepository.getUserDateOfBirth(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue5;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1776274582);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(settingsRepository.getUserImportantDatesJson(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue6;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1776274675);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(settingsRepository.getReminderEnabled()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final MutableState mutableState5 = (MutableState) rememberedValue7;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1776274757);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(settingsRepository.getReminderHour()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            final MutableState mutableState6 = (MutableState) rememberedValue8;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1776274838);
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                rememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(settingsRepository.getReminderMinute()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            final MutableState mutableState7 = (MutableState) rememberedValue9;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1776274919);
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                rememberedValue10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(settingsRepository.getReminderDays(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            final MutableState mutableState8 = (MutableState) rememberedValue10;
            startRestartGroup.endReplaceableGroup();
            final ManagedActivityResultLauncher rememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(new ActivityResultContracts.RequestPermission(), new Function1<Boolean, Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$permissionLauncher$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    if (!z) {
                        ProfileScreenKt.ProfileScreen$lambda$16(mutableState5, false);
                        settingsRepository.setReminderEnabled(false);
                        Toast.makeText(context, "Notification permission is required for reminders", 0).show();
                        return;
                    }
                    ReminderScheduler.INSTANCE.scheduleNextReminder(context);
                }
            }, startRestartGroup, 8);
            String ProfileScreen$lambda$12 = ProfileScreen$lambda$12(mutableState4);
            startRestartGroup.startReplaceableGroup(1776275509);
            boolean changed = startRestartGroup.changed(ProfileScreen$lambda$12);
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                try {
                    emptyList = (List) gson.fromJson(ProfileScreen$lambda$12(mutableState4), new TypeToken<List<? extends ImportantDate>>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$importantDatesList$1$type$1
                    }.getType());
                    if (emptyList == null) {
                        emptyList = CollectionsKt.emptyList();
                    } else {
                        Intrinsics.checkNotNull(emptyList);
                    }
                } catch (Exception unused) {
                    emptyList = CollectionsKt.emptyList();
                }
                rememberedValue11 = emptyList;
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            final List list = (List) rememberedValue11;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1776275875);
            Object rememberedValue12 = startRestartGroup.rememberedValue();
            if (rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                rememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            final MutableState mutableState9 = (MutableState) rememberedValue12;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1776275931);
            Object rememberedValue13 = startRestartGroup.rememberedValue();
            if (rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                rememberedValue13 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue13);
            }
            final MutableState mutableState10 = (MutableState) rememberedValue13;
            startRestartGroup.endReplaceableGroup();
            final ManagedActivityResultLauncher rememberLauncherForActivityResult2 = ActivityResultRegistryKt.rememberLauncherForActivityResult(new ActivityResultContracts.GetContent(), new Function1<Uri, Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$imagePickerLauncher$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Uri uri) {
                    invoke2(uri);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Uri uri) {
                    String copyUriToInternalStorage;
                    if (uri != null) {
                        Context context2 = context;
                        SettingsRepository settingsRepository2 = settingsRepository;
                        MutableState<String> mutableState11 = mutableState2;
                        copyUriToInternalStorage = ProfileScreenKt.copyUriToInternalStorage(context2, uri);
                        if (copyUriToInternalStorage != null) {
                            mutableState11.setValue(copyUriToInternalStorage);
                            settingsRepository2.setUserProfileImageUri(copyUriToInternalStorage);
                        }
                    }
                }
            }, startRestartGroup, 8);
            String ProfileScreen$lambda$6 = ProfileScreen$lambda$6(mutableState2);
            startRestartGroup.startReplaceableGroup(1776276456);
            boolean changed2 = startRestartGroup.changed(ProfileScreen$lambda$6);
            Object rememberedValue14 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                if (ProfileScreen$lambda$6(mutableState2).length() > 0) {
                    try {
                        File file = new File(ProfileScreen$lambda$6(mutableState2));
                        if (file.exists()) {
                            Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                            if (decodeFile != null) {
                                Intrinsics.checkNotNull(decodeFile);
                                imageBitmap2 = AndroidImageBitmap_androidKt.asImageBitmap(decodeFile);
                            }
                        } else {
                            InputStream openInputStream = context.getContentResolver().openInputStream(Uri.parse(ProfileScreen$lambda$6(mutableState2)));
                            if (openInputStream != null) {
                                InputStream inputStream = openInputStream;
                                try {
                                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                                    if (decodeStream != null) {
                                        Intrinsics.checkNotNull(decodeStream);
                                        imageBitmap = AndroidImageBitmap_androidKt.asImageBitmap(decodeStream);
                                    } else {
                                        imageBitmap = null;
                                    }
                                    CloseableKt.closeFinally(inputStream, null);
                                    imageBitmap2 = imageBitmap;
                                } finally {
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                startRestartGroup.updateRememberedValue(imageBitmap2);
                rememberedValue14 = imageBitmap2;
            }
            final ImageBitmap imageBitmap3 = (ImageBitmap) rememberedValue14;
            startRestartGroup.endReplaceableGroup();
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -905121770, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    if ((i3 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-905121770, i3, -1, "com.example.flashcardapp.ui.ProfileScreen.<anonymous> (ProfileScreen.kt:133)");
                        }
                        Function2<Composer, Integer, Unit> m6172getLambda1$app_release = ComposableSingletons$ProfileScreenKt.INSTANCE.m6172getLambda1$app_release();
                        final Function0<Unit> function0 = onBackPressed;
                        AppBarKt.TopAppBar(m6172getLambda1$app_release, null, ComposableLambdaKt.composableLambda(composer3, -1822151716, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i4) {
                                if ((i4 & 11) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1822151716, i4, -1, "com.example.flashcardapp.ui.ProfileScreen.<anonymous>.<anonymous> (ProfileScreen.kt:136)");
                                    }
                                    IconButtonKt.IconButton(function0, null, false, null, null, ComposableSingletons$ProfileScreenKt.INSTANCE.m6177getLambda2$app_release(), composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), null, null, TopAppBarDefaults.INSTANCE.m2292topAppBarColorszjMxDiM(ThemeKt.getBackgroundLavender(), 0L, 0L, 0L, 0L, composer3, TopAppBarDefaults.$stable << 15, 30), null, composer3, 390, 90);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            });
            long backgroundLavender = ThemeKt.getBackgroundLavender();
            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(startRestartGroup, 907998763, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer3, Integer num) {
                    invoke(paddingValues, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PaddingValues paddingValues, Composer composer3, int i3) {
                    int i4;
                    ManagedActivityResultLauncher<String, Boolean> managedActivityResultLauncher;
                    MutableState<Integer> mutableState11;
                    String str;
                    BoxScopeInstance boxScopeInstance;
                    MutableState<String> mutableState12;
                    SettingsRepository settingsRepository2;
                    MutableState<String> mutableState13;
                    MutableState<Set<String>> mutableState14;
                    final Context context2;
                    final List<ImportantDate> list2;
                    final MutableState<String> mutableState15;
                    final MutableState<String> mutableState16;
                    MutableState<Boolean> mutableState17;
                    MutableState<Integer> mutableState18;
                    float f;
                    final MutableState<String> mutableState19;
                    Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                    if ((i3 & 14) == 0) {
                        i4 = i3 | (composer3.changed(paddingValues) ? 4 : 2);
                    } else {
                        i4 = i3;
                    }
                    if ((i4 & 91) != 18 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(907998763, i4, -1, "com.example.flashcardapp.ui.ProfileScreen.<anonymous> (ProfileScreen.kt:145)");
                        }
                        float f2 = 24;
                        Modifier verticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m571paddingVpY3zN4$default(PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues), Dp.m5738constructorimpl(f2), 0.0f, 2, null), ScrollKt.rememberScrollState(0, composer3, 0, 1), false, null, false, 14, null);
                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                        Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f2));
                        final ManagedActivityResultLauncher<String, Uri> managedActivityResultLauncher2 = rememberLauncherForActivityResult2;
                        ImageBitmap imageBitmap4 = imageBitmap3;
                        MutableState<String> mutableState20 = mutableState;
                        SettingsRepository settingsRepository3 = settingsRepository;
                        MutableState<String> mutableState21 = mutableState3;
                        Context context3 = context;
                        List<ImportantDate> list3 = list;
                        MutableState<String> mutableState22 = mutableState9;
                        MutableState<String> mutableState23 = mutableState10;
                        final Gson gson2 = gson;
                        MutableState<String> mutableState24 = mutableState4;
                        MutableState<Boolean> mutableState25 = mutableState5;
                        ManagedActivityResultLauncher<String, Boolean> managedActivityResultLauncher3 = rememberLauncherForActivityResult;
                        MutableState<Integer> mutableState26 = mutableState6;
                        MutableState<Integer> mutableState27 = mutableState7;
                        MutableState<Set<String>> mutableState28 = mutableState8;
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_4, centerHorizontally, composer3, 54);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(verticalScroll$default);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer m2947constructorimpl = Updater.m2947constructorimpl(composer3);
                        Updater.m2954setimpl(m2947constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl.getInserting() || !Intrinsics.areEqual(m2947constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m2947constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m2947constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(8)), composer3, 6);
                        Modifier m251clickableXHw0xAI$default = ClickableKt.m251clickableXHw0xAI$default(BorderKt.m228borderxT4_qwU(BackgroundKt.background$default(ClipKt.clip(SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(130)), RoundedCornerShapeKt.getCircleShape()), Brush.Companion.m3370radialGradientP_VxKs$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m3407boximpl(ColorKt.Color(4293781494L)), Color.m3407boximpl(ColorKt.Color(4291937513L))}), 0L, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), Dp.m5738constructorimpl(2), ThemeKt.getPrimaryPurple(), RoundedCornerShapeKt.getCircleShape()), false, null, null, new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$1
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
                                managedActivityResultLauncher2.launch("image/*");
                            }
                        }, 7, null);
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m251clickableXHw0xAI$default);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor2);
                        } else {
                            composer3.useNode();
                        }
                        Composer m2947constructorimpl2 = Updater.m2947constructorimpl(composer3);
                        Updater.m2954setimpl(m2947constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl2.getInserting() || !Intrinsics.areEqual(m2947constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m2947constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m2947constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        modifierMaterializerOf2.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        if (imageBitmap4 != null) {
                            composer3.startReplaceableGroup(1336305113);
                            str = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
                            boxScopeInstance = boxScopeInstance2;
                            mutableState12 = mutableState21;
                            settingsRepository2 = settingsRepository3;
                            mutableState13 = mutableState20;
                            managedActivityResultLauncher = managedActivityResultLauncher3;
                            mutableState11 = mutableState26;
                            mutableState14 = mutableState28;
                            context2 = context3;
                            list2 = list3;
                            mutableState15 = mutableState22;
                            mutableState16 = mutableState23;
                            mutableState17 = mutableState25;
                            mutableState18 = mutableState27;
                            f = f2;
                            mutableState19 = mutableState24;
                            ImageKt.m273Image5hnEew(imageBitmap4, "Profile Photo", SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, composer3, 25016, 232);
                            composer3.endReplaceableGroup();
                        } else {
                            managedActivityResultLauncher = managedActivityResultLauncher3;
                            mutableState11 = mutableState26;
                            str = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
                            boxScopeInstance = boxScopeInstance2;
                            mutableState12 = mutableState21;
                            settingsRepository2 = settingsRepository3;
                            mutableState13 = mutableState20;
                            mutableState14 = mutableState28;
                            context2 = context3;
                            list2 = list3;
                            mutableState15 = mutableState22;
                            mutableState16 = mutableState23;
                            mutableState17 = mutableState25;
                            mutableState18 = mutableState27;
                            f = f2;
                            mutableState19 = mutableState24;
                            composer3.startReplaceableGroup(1336305406);
                            IconKt.m1605Iconww6aTOc(PersonKt.getPerson(Icons.Outlined.INSTANCE), "Placeholder", boxScopeInstance.align(SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(72)), Alignment.INSTANCE.getCenter()), ThemeKt.getPrimaryPurple(), composer3, 48, 0);
                            composer3.endReplaceableGroup();
                        }
                        Modifier m228borderxT4_qwU = BorderKt.m228borderxT4_qwU(boxScopeInstance.align(BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(32)), RoundedCornerShapeKt.getCircleShape()), ThemeKt.getPrimaryPurple(), null, 2, null), Alignment.INSTANCE.getBottomEnd()), Dp.m5738constructorimpl((float) 1.5d), Color.INSTANCE.m3454getWhite0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
                        Alignment center = Alignment.INSTANCE.getCenter();
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, false, composer3, 6);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, str);
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m228borderxT4_qwU);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor3);
                        } else {
                            composer3.useNode();
                        }
                        Composer m2947constructorimpl3 = Updater.m2947constructorimpl(composer3);
                        Updater.m2954setimpl(m2947constructorimpl3, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        IconKt.m1605Iconww6aTOc(EditKt.getEdit(Icons.Outlined.INSTANCE), "Edit Profile Pic", SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(16)), Color.INSTANCE.m3454getWhite0d7_KjU(), composer3, 3504, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        float f3 = 1;
                        final MutableState<String> mutableState29 = mutableState12;
                        final SettingsRepository settingsRepository4 = settingsRepository2;
                        final MutableState<String> mutableState30 = mutableState13;
                        CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f)), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(ThemeKt.getCardBackgroundLight(), 0L, 0L, 0L, composer3, CardDefaults.$stable << 12, 14), null, BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(f3), ColorKt.Color(4293452524L)), ComposableLambdaKt.composableLambda(composer3, -1479820781, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$3
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer4, Integer num) {
                                invoke(columnScope, composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ColumnScope Card, Composer composer4, int i5) {
                                String ProfileScreen$lambda$3;
                                String ProfileScreen$lambda$9;
                                Intrinsics.checkNotNullParameter(Card, "$this$Card");
                                if ((i5 & 81) != 16 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1479820781, i5, -1, "com.example.flashcardapp.ui.ProfileScreen.<anonymous>.<anonymous>.<anonymous> (ProfileScreen.kt:209)");
                                    }
                                    Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(20));
                                    float f4 = 16;
                                    Arrangement.HorizontalOrVertical m478spacedBy0680j_42 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f4));
                                    final MutableState<String> mutableState31 = mutableState30;
                                    final SettingsRepository settingsRepository5 = settingsRepository4;
                                    final MutableState<String> mutableState32 = mutableState29;
                                    final Context context4 = context2;
                                    composer4.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_42, Alignment.INSTANCE.getStart(), composer4, 6);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap4 = composer4.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor4);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m2947constructorimpl4 = Updater.m2947constructorimpl(composer4);
                                    Updater.m2954setimpl(m2947constructorimpl4, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                        m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                        m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                    }
                                    modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                    composer4.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                    TextKt.m2133Text4IGK_g("Personal Details", (Modifier) null, ThemeKt.getPrimaryPurple(), TextUnitKt.getSp(16), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 199686, 0, 131026);
                                    ProfileScreen$lambda$3 = ProfileScreenKt.ProfileScreen$lambda$3(mutableState31);
                                    OutlinedTextFieldKt.OutlinedTextField(ProfileScreen$lambda$3, (Function1<? super String, Unit>) new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$3$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                                            invoke2(str2);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(String it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            mutableState31.setValue(it);
                                            SettingsRepository.this.setUserName(it);
                                        }
                                    }, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ProfileScreenKt.INSTANCE.m6178getLambda3$app_release(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ProfileScreenKt.INSTANCE.m6179getLambda4$app_release(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f4)), OutlinedTextFieldDefaults.INSTANCE.m1735colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, ThemeKt.getPrimaryPurple(), ColorKt.Color(4291280341L), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer4, 0, 384, 0, 0, 3072, 2147477503, 4095), composer4, 14156160, 12582912, 0, 1965880);
                                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    composer4.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap5 = composer4.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor5);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m2947constructorimpl5 = Updater.m2947constructorimpl(composer4);
                                    Updater.m2954setimpl(m2947constructorimpl5, rememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m2954setimpl(m2947constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m2947constructorimpl5.getInserting() || !Intrinsics.areEqual(m2947constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                                        m2947constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                                        m2947constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                                    }
                                    modifierMaterializerOf5.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                    composer4.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                                    ProfileScreen$lambda$9 = ProfileScreenKt.ProfileScreen$lambda$9(mutableState32);
                                    OutlinedTextFieldKt.OutlinedTextField(ProfileScreen$lambda$9, (Function1<? super String, Unit>) new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$3$1$2$2
                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(String it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                                            invoke2(str2);
                                            return Unit.INSTANCE;
                                        }
                                    }, ClickableKt.m251clickableXHw0xAI$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, null, null, new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$3$1$2$1
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
                                            String ProfileScreen$lambda$92;
                                            Context context5 = context4;
                                            ProfileScreen$lambda$92 = ProfileScreenKt.ProfileScreen$lambda$9(mutableState32);
                                            final SettingsRepository settingsRepository6 = settingsRepository5;
                                            final MutableState<String> mutableState33 = mutableState32;
                                            ProfileScreenKt.showDatePicker(context5, ProfileScreen$lambda$92, new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$3$1$2$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                                                    invoke2(str2);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(String selectedDate) {
                                                    Intrinsics.checkNotNullParameter(selectedDate, "selectedDate");
                                                    mutableState33.setValue(selectedDate);
                                                    SettingsRepository.this.setUserDateOfBirth(selectedDate);
                                                }
                                            });
                                        }
                                    }, 7, null), false, true, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ProfileScreenKt.INSTANCE.m6180getLambda5$app_release(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ProfileScreenKt.INSTANCE.m6181getLambda6$app_release(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ProfileScreenKt.INSTANCE.m6182getLambda7$app_release(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f4)), OutlinedTextFieldDefaults.INSTANCE.m1735colors0hiis_0(0L, 0L, ThemeKt.getTextPrimaryDeep(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, ColorKt.Color(4291280341L), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, ThemeKt.getTextSecondaryGray(), 0L, 0L, 0L, ThemeKt.getTextSecondaryGray(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer4, 0, 3072, 0, 0, 3072, 1577050107, 4095), composer4, 819489840, 0, 0, 2096416);
                                    BoxKt.Box(ClickableKt.m251clickableXHw0xAI$default(boxScopeInstance4.matchParentSize(Modifier.INSTANCE), false, null, null, new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$3$1$2$3
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
                                            String ProfileScreen$lambda$92;
                                            Context context5 = context4;
                                            ProfileScreen$lambda$92 = ProfileScreenKt.ProfileScreen$lambda$9(mutableState32);
                                            final SettingsRepository settingsRepository6 = settingsRepository5;
                                            final MutableState<String> mutableState33 = mutableState32;
                                            ProfileScreenKt.showDatePicker(context5, ProfileScreen$lambda$92, new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$3$1$2$3.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                                                    invoke2(str2);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(String selectedDate) {
                                                    Intrinsics.checkNotNullParameter(selectedDate, "selectedDate");
                                                    mutableState33.setValue(selectedDate);
                                                    SettingsRepository.this.setUserDateOfBirth(selectedDate);
                                                }
                                            });
                                        }
                                    }, 7, null), composer4, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endReplaceableGroup();
                                    composer4.endNode();
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endReplaceableGroup();
                                    composer4.endNode();
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), composer3, 221190, 8);
                        final Context context4 = context2;
                        CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f)), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(ThemeKt.getCardBackgroundLight(), 0L, 0L, 0L, composer3, CardDefaults.$stable << 12, 14), null, BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(f3), ColorKt.Color(4293452524L)), ComposableLambdaKt.composableLambda(composer3, -1306444982, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$4
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer4, Integer num) {
                                invoke(columnScope, composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ColumnScope Card, Composer composer4, int i5) {
                                String ProfileScreen$lambda$28;
                                final MutableState<String> mutableState31;
                                String ProfileScreen$lambda$31;
                                Intrinsics.checkNotNullParameter(Card, "$this$Card");
                                if ((i5 & 81) != 16 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1306444982, i5, -1, "com.example.flashcardapp.ui.ProfileScreen.<anonymous>.<anonymous>.<anonymous> (ProfileScreen.kt:291)");
                                    }
                                    float f4 = 20;
                                    Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f4));
                                    Arrangement.HorizontalOrVertical m478spacedBy0680j_42 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(16));
                                    final List<ImportantDate> list4 = list2;
                                    MutableState<String> mutableState32 = mutableState15;
                                    final MutableState<String> mutableState33 = mutableState16;
                                    final Context context5 = context4;
                                    final Gson gson3 = gson2;
                                    final SettingsRepository settingsRepository5 = settingsRepository4;
                                    final MutableState<String> mutableState34 = mutableState19;
                                    composer4.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_42, Alignment.INSTANCE.getStart(), composer4, 6);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap4 = composer4.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor4);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m2947constructorimpl4 = Updater.m2947constructorimpl(composer4);
                                    Updater.m2954setimpl(m2947constructorimpl4, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                        m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                        m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                    }
                                    modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                    composer4.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                    String str2 = "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo";
                                    String str3 = "C79@3979L9:Column.kt#2w3rfo";
                                    TextKt.m2133Text4IGK_g("Mark Important Dates", (Modifier) null, ThemeKt.getPrimaryPurple(), TextUnitKt.getSp(16), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 199686, 0, 131026);
                                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    float f5 = 10;
                                    Arrangement.HorizontalOrVertical m478spacedBy0680j_43 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f5));
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    composer4.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m478spacedBy0680j_43, centerVertically, composer4, 54);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap5 = composer4.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor5);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m2947constructorimpl5 = Updater.m2947constructorimpl(composer4);
                                    Updater.m2954setimpl(m2947constructorimpl5, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m2954setimpl(m2947constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m2947constructorimpl5.getInserting() || !Intrinsics.areEqual(m2947constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                                        m2947constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                                        m2947constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                                    }
                                    modifierMaterializerOf5.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                    composer4.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    ProfileScreen$lambda$28 = ProfileScreenKt.ProfileScreen$lambda$28(mutableState32);
                                    Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.2f, false, 2, null);
                                    float f6 = 12;
                                    RoundedCornerShape m839RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f6));
                                    String str4 = "C92@4661L9:Row.kt#2w3rfo";
                                    String str5 = "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo";
                                    TextFieldColors m1735colors0hiis_0 = OutlinedTextFieldDefaults.INSTANCE.m1735colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, ThemeKt.getPrimaryPurple(), ColorKt.Color(4291280341L), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer4, 0, 384, 0, 0, 3072, 2147477503, 4095);
                                    composer4.startReplaceableGroup(923907669);
                                    Object rememberedValue15 = composer4.rememberedValue();
                                    if (rememberedValue15 == Composer.INSTANCE.getEmpty()) {
                                        mutableState31 = mutableState32;
                                        rememberedValue15 = (Function1) new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$4$1$1$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(String str6) {
                                                invoke2(str6);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(String it) {
                                                Intrinsics.checkNotNullParameter(it, "it");
                                                mutableState31.setValue(it);
                                            }
                                        };
                                        composer4.updateRememberedValue(rememberedValue15);
                                    } else {
                                        mutableState31 = mutableState32;
                                    }
                                    composer4.endReplaceableGroup();
                                    final MutableState<String> mutableState35 = mutableState31;
                                    OutlinedTextFieldKt.OutlinedTextField(ProfileScreen$lambda$28, (Function1<? super String, Unit>) rememberedValue15, weight$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ProfileScreenKt.INSTANCE.m6183getLambda8$app_release(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ProfileScreenKt.INSTANCE.m6184getLambda9$app_release(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) m839RoundedCornerShape0680j_4, m1735colors0hiis_0, composer4, 14155824, 12582912, 0, 1965880);
                                    Modifier weight$default2 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                    composer4.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap6 = composer4.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(weight$default2);
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor6);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m2947constructorimpl6 = Updater.m2947constructorimpl(composer4);
                                    Updater.m2954setimpl(m2947constructorimpl6, rememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m2954setimpl(m2947constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m2947constructorimpl6.getInserting() || !Intrinsics.areEqual(m2947constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                                        m2947constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                                        m2947constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
                                    }
                                    modifierMaterializerOf6.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                    composer4.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                                    ProfileScreen$lambda$31 = ProfileScreenKt.ProfileScreen$lambda$31(mutableState33);
                                    String str6 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
                                    OutlinedTextFieldKt.OutlinedTextField(ProfileScreen$lambda$31, (Function1<? super String, Unit>) new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$4$1$1$2$2
                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(String it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(String str7) {
                                            invoke2(str7);
                                            return Unit.INSTANCE;
                                        }
                                    }, ClickableKt.m251clickableXHw0xAI$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, null, null, new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$4$1$1$2$1
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
                                            String ProfileScreen$lambda$312;
                                            Context context6 = context5;
                                            ProfileScreen$lambda$312 = ProfileScreenKt.ProfileScreen$lambda$31(mutableState33);
                                            final MutableState<String> mutableState36 = mutableState33;
                                            ProfileScreenKt.showDatePicker(context6, ProfileScreen$lambda$312, new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$4$1$1$2$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(String str7) {
                                                    invoke2(str7);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(String selectedDate) {
                                                    Intrinsics.checkNotNullParameter(selectedDate, "selectedDate");
                                                    mutableState36.setValue(selectedDate);
                                                }
                                            });
                                        }
                                    }, 7, null), false, true, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ProfileScreenKt.INSTANCE.m6173getLambda10$app_release(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ProfileScreenKt.INSTANCE.m6174getLambda11$app_release(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f6)), OutlinedTextFieldDefaults.INSTANCE.m1735colors0hiis_0(0L, 0L, ThemeKt.getTextPrimaryDeep(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, ColorKt.Color(4291280341L), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, ThemeKt.getTextSecondaryGray(), 0L, 0L, 0L, ThemeKt.getTextSecondaryGray(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer4, 0, 3072, 0, 0, 3072, 1577050107, 4095), composer4, 14183472, 0, 0, 2096928);
                                    Composer composer5 = composer4;
                                    int i6 = 0;
                                    BoxKt.Box(ClickableKt.m251clickableXHw0xAI$default(boxScopeInstance4.matchParentSize(Modifier.INSTANCE), false, null, null, new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$4$1$1$2$3
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
                                            String ProfileScreen$lambda$312;
                                            Context context6 = context5;
                                            ProfileScreen$lambda$312 = ProfileScreenKt.ProfileScreen$lambda$31(mutableState33);
                                            final MutableState<String> mutableState36 = mutableState33;
                                            ProfileScreenKt.showDatePicker(context6, ProfileScreen$lambda$312, new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$4$1$1$2$3.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(String str7) {
                                                    invoke2(str7);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(String selectedDate) {
                                                    Intrinsics.checkNotNullParameter(selectedDate, "selectedDate");
                                                    mutableState36.setValue(selectedDate);
                                                }
                                            });
                                        }
                                    }, 7, null), composer5, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endReplaceableGroup();
                                    composer4.endNode();
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                    IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$4$1$1$3
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
                                            String ProfileScreen$lambda$282;
                                            String ProfileScreen$lambda$312;
                                            String ProfileScreen$lambda$283;
                                            String ProfileScreen$lambda$313;
                                            ProfileScreen$lambda$282 = ProfileScreenKt.ProfileScreen$lambda$28(mutableState35);
                                            if (!StringsKt.isBlank(ProfileScreen$lambda$282)) {
                                                ProfileScreen$lambda$312 = ProfileScreenKt.ProfileScreen$lambda$31(mutableState33);
                                                if (!StringsKt.isBlank(ProfileScreen$lambda$312)) {
                                                    List<ImportantDate> list5 = list4;
                                                    ProfileScreen$lambda$283 = ProfileScreenKt.ProfileScreen$lambda$28(mutableState35);
                                                    ProfileScreen$lambda$313 = ProfileScreenKt.ProfileScreen$lambda$31(mutableState33);
                                                    String json = gson3.toJson(CollectionsKt.plus((Collection<? extends ImportantDate>) list5, new ImportantDate(ProfileScreen$lambda$283, ProfileScreen$lambda$313)));
                                                    MutableState<String> mutableState36 = mutableState34;
                                                    Intrinsics.checkNotNull(json);
                                                    mutableState36.setValue(json);
                                                    settingsRepository5.setUserImportantDatesJson(json);
                                                    mutableState35.setValue("");
                                                    mutableState33.setValue("");
                                                }
                                            }
                                        }
                                    }, BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(48)), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f6))), ThemeKt.getPrimaryPurple(), null, 2, null), false, null, null, ComposableSingletons$ProfileScreenKt.INSTANCE.m6175getLambda12$app_release(), composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endReplaceableGroup();
                                    composer4.endNode();
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                    composer5.startReplaceableGroup(1336315238);
                                    boolean isEmpty = list4.isEmpty();
                                    int i7 = 1;
                                    if (!isEmpty) {
                                        float f7 = 0.0f;
                                        Object obj = null;
                                        DividerKt.m1532HorizontalDivider9IZ8Weo(PaddingKt.m571paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m5738constructorimpl(4), 1, null), 0.0f, ColorKt.Color(4293649402L), composer4, 390, 2);
                                        int i8 = 0;
                                        for (Object obj2 : list4) {
                                            int i9 = i8 + 1;
                                            if (i8 < 0) {
                                                CollectionsKt.throwIndexOverflow();
                                            }
                                            ImportantDate importantDate = (ImportantDate) obj2;
                                            Modifier m570paddingVpY3zN4 = PaddingKt.m570paddingVpY3zN4(BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, f7, i7, obj), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f6))), ColorKt.Color(4294571772L), null, 2, null), Dp.m5738constructorimpl(14), Dp.m5738constructorimpl(f5));
                                            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                                            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                            composer5.startReplaceableGroup(693286680);
                                            String str7 = str5;
                                            ComposerKt.sourceInformation(composer5, str7);
                                            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween, centerVertically2, composer5, 54);
                                            composer5.startReplaceableGroup(-1323940314);
                                            String str8 = str6;
                                            ComposerKt.sourceInformation(composer5, str8);
                                            int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(composer5, i6);
                                            CompositionLocalMap currentCompositionLocalMap7 = composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf7 = LayoutKt.modifierMaterializerOf(m570paddingVpY3zN4);
                                            if (!(composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer4.startReusableNode();
                                            if (composer4.getInserting()) {
                                                composer5.createNode(constructor7);
                                            } else {
                                                composer4.useNode();
                                            }
                                            Composer m2947constructorimpl7 = Updater.m2947constructorimpl(composer4);
                                            Updater.m2954setimpl(m2947constructorimpl7, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m2954setimpl(m2947constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m2947constructorimpl7.getInserting() || !Intrinsics.areEqual(m2947constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                                                m2947constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                                                m2947constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
                                            }
                                            modifierMaterializerOf7.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer5, Integer.valueOf(i6));
                                            composer5.startReplaceableGroup(2058660585);
                                            String str9 = str4;
                                            ComposerKt.sourceInformationMarkerStart(composer5, -326681643, str9);
                                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                            Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                            Arrangement.HorizontalOrVertical m478spacedBy0680j_44 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(8));
                                            composer5.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer5, str7);
                                            Modifier.Companion companion = Modifier.INSTANCE;
                                            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m478spacedBy0680j_44, centerVertically3, composer5, 54);
                                            composer5.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer5, str8);
                                            int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(composer5, i6);
                                            CompositionLocalMap currentCompositionLocalMap8 = composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf8 = LayoutKt.modifierMaterializerOf(companion);
                                            if (!(composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer4.startReusableNode();
                                            if (composer4.getInserting()) {
                                                composer5.createNode(constructor8);
                                            } else {
                                                composer4.useNode();
                                            }
                                            Composer m2947constructorimpl8 = Updater.m2947constructorimpl(composer4);
                                            Updater.m2954setimpl(m2947constructorimpl8, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m2954setimpl(m2947constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m2947constructorimpl8.getInserting() || !Intrinsics.areEqual(m2947constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
                                                m2947constructorimpl8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                                                m2947constructorimpl8.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
                                            }
                                            modifierMaterializerOf8.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer5, Integer.valueOf(i6));
                                            composer5.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer5, -326681643, str9);
                                            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                                            str4 = str9;
                                            IconKt.m1605Iconww6aTOc(DateRangeKt.getDateRange(Icons.Outlined.INSTANCE), "Event icon", SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f4)), ThemeKt.getPrimaryPurple(), composer4, 432, 0);
                                            composer5.startReplaceableGroup(-483455358);
                                            String str10 = str2;
                                            ComposerKt.sourceInformation(composer5, str10);
                                            Modifier.Companion companion2 = Modifier.INSTANCE;
                                            MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer5, i6);
                                            composer5.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer5, str8);
                                            int currentCompositeKeyHash9 = ComposablesKt.getCurrentCompositeKeyHash(composer5, i6);
                                            CompositionLocalMap currentCompositionLocalMap9 = composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor9 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf9 = LayoutKt.modifierMaterializerOf(companion2);
                                            if (!(composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer4.startReusableNode();
                                            if (composer4.getInserting()) {
                                                composer5.createNode(constructor9);
                                            } else {
                                                composer4.useNode();
                                            }
                                            Composer m2947constructorimpl9 = Updater.m2947constructorimpl(composer4);
                                            Updater.m2954setimpl(m2947constructorimpl9, columnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m2954setimpl(m2947constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash9 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m2947constructorimpl9.getInserting() || !Intrinsics.areEqual(m2947constructorimpl9.rememberedValue(), Integer.valueOf(currentCompositeKeyHash9))) {
                                                m2947constructorimpl9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash9));
                                                m2947constructorimpl9.apply(Integer.valueOf(currentCompositeKeyHash9), setCompositeKeyHash9);
                                            }
                                            modifierMaterializerOf9.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer5, Integer.valueOf(i6));
                                            composer5.startReplaceableGroup(2058660585);
                                            String str11 = str3;
                                            ComposerKt.sourceInformationMarkerStart(composer5, 276693656, str11);
                                            ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                                            TextKt.m2133Text4IGK_g(importantDate.getLabel(), (Modifier) null, ThemeKt.getTextPrimaryDeep(), TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 199680, 0, 131026);
                                            TextKt.m2133Text4IGK_g(importantDate.getDate(), (Modifier) null, ThemeKt.getTextSecondaryGray(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 3072, 0, 131058);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            composer4.endReplaceableGroup();
                                            composer4.endNode();
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            composer4.endReplaceableGroup();
                                            composer4.endNode();
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            final int i10 = i8;
                                            IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$4$1$2$1$2
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
                                                    List mutableList = CollectionsKt.toMutableList((Collection) list4);
                                                    mutableList.remove(i10);
                                                    String json = gson3.toJson(mutableList);
                                                    MutableState<String> mutableState36 = mutableState34;
                                                    Intrinsics.checkNotNull(json);
                                                    mutableState36.setValue(json);
                                                    settingsRepository5.setUserImportantDatesJson(json);
                                                }
                                            }, null, false, null, null, ComposableSingletons$ProfileScreenKt.INSTANCE.m6176getLambda13$app_release(), composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            composer4.endReplaceableGroup();
                                            composer4.endNode();
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            composer5 = composer4;
                                            i8 = i9;
                                            str5 = str7;
                                            str3 = str11;
                                            str2 = str10;
                                            f7 = 0.0f;
                                            obj = null;
                                            i7 = 1;
                                            str6 = str8;
                                            i6 = i6;
                                        }
                                    }
                                    composer4.endReplaceableGroup();
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endReplaceableGroup();
                                    composer4.endNode();
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), composer3, 221190, 8);
                        final MutableState<Boolean> mutableState31 = mutableState17;
                        final Context context5 = context2;
                        final ManagedActivityResultLauncher<String, Boolean> managedActivityResultLauncher4 = managedActivityResultLauncher;
                        final MutableState<Integer> mutableState32 = mutableState11;
                        final MutableState<Integer> mutableState33 = mutableState18;
                        final MutableState<Set<String>> mutableState34 = mutableState14;
                        CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f)), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(ThemeKt.getCardBackgroundLight(), 0L, 0L, 0L, composer3, CardDefaults.$stable << 12, 14), null, BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(f3), ColorKt.Color(4293452524L)), ComposableLambdaKt.composableLambda(composer3, -299522293, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$5
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer4, Integer num) {
                                invoke(columnScope, composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Type inference failed for: r11v24 */
                            /* JADX WARN: Type inference failed for: r11v25, types: [boolean, int] */
                            /* JADX WARN: Type inference failed for: r11v26 */
                            public final void invoke(ColumnScope Card, Composer composer4, int i5) {
                                boolean ProfileScreen$lambda$15;
                                boolean ProfileScreen$lambda$152;
                                int ProfileScreen$lambda$18;
                                int ProfileScreen$lambda$21;
                                String formatTime;
                                Set ProfileScreen$lambda$24;
                                Intrinsics.checkNotNullParameter(Card, "$this$Card");
                                if ((i5 & 81) != 16 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-299522293, i5, -1, "com.example.flashcardapp.ui.ProfileScreen.<anonymous>.<anonymous>.<anonymous> (ProfileScreen.kt:442)");
                                    }
                                    Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(20));
                                    float f4 = 16;
                                    Arrangement.HorizontalOrVertical m478spacedBy0680j_42 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f4));
                                    final MutableState<Boolean> mutableState35 = mutableState31;
                                    final Context context6 = context5;
                                    final ManagedActivityResultLauncher<String, Boolean> managedActivityResultLauncher5 = managedActivityResultLauncher4;
                                    final SettingsRepository settingsRepository5 = settingsRepository4;
                                    final MutableState<Integer> mutableState36 = mutableState32;
                                    final MutableState<Integer> mutableState37 = mutableState33;
                                    final MutableState<Set<String>> mutableState38 = mutableState34;
                                    composer4.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_42, Alignment.INSTANCE.getStart(), composer4, 6);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap4 = composer4.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor4);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m2947constructorimpl4 = Updater.m2947constructorimpl(composer4);
                                    Updater.m2954setimpl(m2947constructorimpl4, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                        m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                        m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                    }
                                    modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                    composer4.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    composer4.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer4, 54);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap5 = composer4.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor5);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m2947constructorimpl5 = Updater.m2947constructorimpl(composer4);
                                    Updater.m2954setimpl(m2947constructorimpl5, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m2954setimpl(m2947constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m2947constructorimpl5.getInserting() || !Intrinsics.areEqual(m2947constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                                        m2947constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                                        m2947constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                                    }
                                    modifierMaterializerOf5.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                    composer4.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                    Modifier weight$default = RowScope.weight$default(RowScopeInstance.INSTANCE, Modifier.INSTANCE, 1.0f, false, 2, null);
                                    composer4.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap6 = composer4.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(weight$default);
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor6);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m2947constructorimpl6 = Updater.m2947constructorimpl(composer4);
                                    Updater.m2954setimpl(m2947constructorimpl6, columnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m2954setimpl(m2947constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m2947constructorimpl6.getInserting() || !Intrinsics.areEqual(m2947constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                                        m2947constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                                        m2947constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
                                    }
                                    modifierMaterializerOf6.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                    composer4.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                                    TextKt.m2133Text4IGK_g("Study Reminders", (Modifier) null, ThemeKt.getPrimaryPurple(), TextUnitKt.getSp(16), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 199686, 0, 131026);
                                    TextKt.m2133Text4IGK_g("Receive reminders to review flashcards.", (Modifier) null, ThemeKt.getTextSecondaryGray(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 3078, 0, 131058);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endReplaceableGroup();
                                    composer4.endNode();
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                    ProfileScreen$lambda$15 = ProfileScreenKt.ProfileScreen$lambda$15(mutableState35);
                                    SwitchKt.Switch(ProfileScreen$lambda$15, new Function1<Boolean, Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$5$1$1$2
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                            invoke(bool.booleanValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(boolean z) {
                                            if (!z) {
                                                ProfileScreenKt.ProfileScreen$lambda$16(mutableState35, false);
                                                settingsRepository5.setReminderEnabled(false);
                                                ReminderScheduler.INSTANCE.scheduleNextReminder(context6);
                                            } else if (Build.VERSION.SDK_INT < 33) {
                                                ProfileScreenKt.ProfileScreen$lambda$16(mutableState35, true);
                                                settingsRepository5.setReminderEnabled(true);
                                                ReminderScheduler.INSTANCE.scheduleNextReminder(context6);
                                            } else if (ContextCompat.checkSelfPermission(context6, "android.permission.POST_NOTIFICATIONS") == 0) {
                                                ProfileScreenKt.ProfileScreen$lambda$16(mutableState35, true);
                                                settingsRepository5.setReminderEnabled(true);
                                                ReminderScheduler.INSTANCE.scheduleNextReminder(context6);
                                            } else {
                                                managedActivityResultLauncher5.launch("android.permission.POST_NOTIFICATIONS");
                                                ProfileScreenKt.ProfileScreen$lambda$16(mutableState35, true);
                                                settingsRepository5.setReminderEnabled(true);
                                            }
                                        }
                                    }, null, null, false, SwitchDefaults.INSTANCE.m2016colorsV1nXRL4(Color.INSTANCE.m3454getWhite0d7_KjU(), ThemeKt.getPrimaryPurple(), 0L, 0L, Color.INSTANCE.m3447getGray0d7_KjU(), ColorKt.Color(4293781494L), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer4, 221190, SwitchDefaults.$stable << 18, 65484), null, composer4, 0, 92);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endReplaceableGroup();
                                    composer4.endNode();
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                    composer4.startReplaceableGroup(1336322176);
                                    ProfileScreen$lambda$152 = ProfileScreenKt.ProfileScreen$lambda$15(mutableState35);
                                    if (ProfileScreen$lambda$152) {
                                        float f5 = 4;
                                        DividerKt.m1532HorizontalDivider9IZ8Weo(PaddingKt.m571paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m5738constructorimpl(f5), 1, null), 0.0f, ColorKt.Color(4293649402L), composer4, 390, 2);
                                        Modifier m570paddingVpY3zN4 = PaddingKt.m570paddingVpY3zN4(ClickableKt.m251clickableXHw0xAI$default(BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f4))), ColorKt.Color(4294571772L), null, 2, null), false, null, null, new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$5$1$2
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
                                                int ProfileScreen$lambda$182;
                                                int ProfileScreen$lambda$212;
                                                Context context7 = context6;
                                                ProfileScreen$lambda$182 = ProfileScreenKt.ProfileScreen$lambda$18(mutableState36);
                                                ProfileScreen$lambda$212 = ProfileScreenKt.ProfileScreen$lambda$21(mutableState37);
                                                final SettingsRepository settingsRepository6 = settingsRepository5;
                                                final Context context8 = context6;
                                                final MutableState<Integer> mutableState39 = mutableState36;
                                                final MutableState<Integer> mutableState40 = mutableState37;
                                                ProfileScreenKt.showTimePicker(context7, ProfileScreen$lambda$182, ProfileScreen$lambda$212, new Function2<Integer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$5$1$2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                                                        invoke(num.intValue(), num2.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(int i6, int i7) {
                                                        ProfileScreenKt.ProfileScreen$lambda$19(mutableState39, i6);
                                                        ProfileScreenKt.ProfileScreen$lambda$22(mutableState40, i7);
                                                        SettingsRepository.this.setReminderHour(i6);
                                                        SettingsRepository.this.setReminderMinute(i7);
                                                        ReminderScheduler.INSTANCE.scheduleNextReminder(context8);
                                                    }
                                                });
                                            }
                                        }, 7, null), Dp.m5738constructorimpl(f4), Dp.m5738constructorimpl(14));
                                        Arrangement.HorizontalOrVertical spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
                                        Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                        composer4.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween2, centerVertically2, composer4, 54);
                                        composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap7 = composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf7 = LayoutKt.modifierMaterializerOf(m570paddingVpY3zN4);
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor7);
                                        } else {
                                            composer4.useNode();
                                        }
                                        Composer m2947constructorimpl7 = Updater.m2947constructorimpl(composer4);
                                        Updater.m2954setimpl(m2947constructorimpl7, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m2954setimpl(m2947constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m2947constructorimpl7.getInserting() || !Intrinsics.areEqual(m2947constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                                            m2947constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                                            m2947constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
                                        }
                                        modifierMaterializerOf7.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                        composer4.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                        Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                        Arrangement.HorizontalOrVertical m478spacedBy0680j_43 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(12));
                                        composer4.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                        Modifier.Companion companion = Modifier.INSTANCE;
                                        MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m478spacedBy0680j_43, centerVertically3, composer4, 54);
                                        composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap8 = composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf8 = LayoutKt.modifierMaterializerOf(companion);
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor8);
                                        } else {
                                            composer4.useNode();
                                        }
                                        Composer m2947constructorimpl8 = Updater.m2947constructorimpl(composer4);
                                        Updater.m2954setimpl(m2947constructorimpl8, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m2954setimpl(m2947constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m2947constructorimpl8.getInserting() || !Intrinsics.areEqual(m2947constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
                                            m2947constructorimpl8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                                            m2947constructorimpl8.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
                                        }
                                        modifierMaterializerOf8.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                        composer4.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                        IconKt.m1605Iconww6aTOc(NotificationsKt.getNotifications(Icons.Outlined.INSTANCE), "Notification Time", SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(24)), ThemeKt.getPrimaryPurple(), composer4, 432, 0);
                                        composer4.startReplaceableGroup(-483455358);
                                        ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                        MeasurePolicy columnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                        composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash9 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap9 = composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor9 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf9 = LayoutKt.modifierMaterializerOf(companion2);
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor9);
                                        } else {
                                            composer4.useNode();
                                        }
                                        Composer m2947constructorimpl9 = Updater.m2947constructorimpl(composer4);
                                        Updater.m2954setimpl(m2947constructorimpl9, columnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m2954setimpl(m2947constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash9 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m2947constructorimpl9.getInserting() || !Intrinsics.areEqual(m2947constructorimpl9.rememberedValue(), Integer.valueOf(currentCompositeKeyHash9))) {
                                            m2947constructorimpl9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash9));
                                            m2947constructorimpl9.apply(Integer.valueOf(currentCompositeKeyHash9), setCompositeKeyHash9);
                                        }
                                        modifierMaterializerOf9.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                        composer4.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                        ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                                        TextKt.m2133Text4IGK_g("Reminder Time", (Modifier) null, ThemeKt.getTextPrimaryDeep(), TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 199686, 0, 131026);
                                        TextKt.m2133Text4IGK_g("Select when to get notified", (Modifier) null, ThemeKt.getTextSecondaryGray(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 3078, 0, 131058);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        composer4.endReplaceableGroup();
                                        composer4.endNode();
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        composer4.endReplaceableGroup();
                                        composer4.endNode();
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        ProfileScreen$lambda$18 = ProfileScreenKt.ProfileScreen$lambda$18(mutableState36);
                                        ProfileScreen$lambda$21 = ProfileScreenKt.ProfileScreen$lambda$21(mutableState37);
                                        formatTime = ProfileScreenKt.formatTime(ProfileScreen$lambda$18, ProfileScreen$lambda$21);
                                        TextKt.m2133Text4IGK_g(formatTime, (Modifier) null, ThemeKt.getPrimaryPurple(), TextUnitKt.getSp(16), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 199680, 0, 131026);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        composer4.endReplaceableGroup();
                                        composer4.endNode();
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        Arrangement.HorizontalOrVertical m478spacedBy0680j_44 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(8));
                                        composer4.startReplaceableGroup(-483455358);
                                        ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                        Modifier.Companion companion3 = Modifier.INSTANCE;
                                        MeasurePolicy columnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_44, Alignment.INSTANCE.getStart(), composer4, 6);
                                        composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash10 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap10 = composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor10 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf10 = LayoutKt.modifierMaterializerOf(companion3);
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor10);
                                        } else {
                                            composer4.useNode();
                                        }
                                        Composer m2947constructorimpl10 = Updater.m2947constructorimpl(composer4);
                                        Updater.m2954setimpl(m2947constructorimpl10, columnMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m2954setimpl(m2947constructorimpl10, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash10 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m2947constructorimpl10.getInserting() || !Intrinsics.areEqual(m2947constructorimpl10.rememberedValue(), Integer.valueOf(currentCompositeKeyHash10))) {
                                            m2947constructorimpl10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash10));
                                            m2947constructorimpl10.apply(Integer.valueOf(currentCompositeKeyHash10), setCompositeKeyHash10);
                                        }
                                        modifierMaterializerOf10.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                        composer4.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                        ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                                        TextKt.m2133Text4IGK_g("Repeat on", (Modifier) null, ThemeKt.getTextPrimaryDeep(), TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 199686, 0, 131026);
                                        List<String> listOf = CollectionsKt.listOf((Object[]) new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"});
                                        Object obj = null;
                                        Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        Arrangement.HorizontalOrVertical m478spacedBy0680j_45 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f5));
                                        Composer composer5 = composer4;
                                        composer5.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer5, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                        int i6 = 6;
                                        MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(m478spacedBy0680j_45, Alignment.INSTANCE.getTop(), composer5, 6);
                                        int i7 = -1323940314;
                                        composer5.startReplaceableGroup(-1323940314);
                                        String str2 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
                                        ComposerKt.sourceInformation(composer5, str2);
                                        boolean z = 0;
                                        int currentCompositeKeyHash11 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                        CompositionLocalMap currentCompositionLocalMap11 = composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor11 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf11 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default2);
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer5.createNode(constructor11);
                                        } else {
                                            composer4.useNode();
                                        }
                                        Composer m2947constructorimpl11 = Updater.m2947constructorimpl(composer4);
                                        Updater.m2954setimpl(m2947constructorimpl11, rowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m2954setimpl(m2947constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash11 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m2947constructorimpl11.getInserting() || !Intrinsics.areEqual(m2947constructorimpl11.rememberedValue(), Integer.valueOf(currentCompositeKeyHash11))) {
                                            m2947constructorimpl11.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash11));
                                            m2947constructorimpl11.apply(Integer.valueOf(currentCompositeKeyHash11), setCompositeKeyHash11);
                                        }
                                        modifierMaterializerOf11.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer5, 0);
                                        int i8 = 2058660585;
                                        composer5.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer5, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                        RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                                        composer5.startReplaceableGroup(923921903);
                                        for (final String str3 : listOf) {
                                            ProfileScreen$lambda$24 = ProfileScreenKt.ProfileScreen$lambda$24(mutableState38);
                                            final boolean contains = ProfileScreen$lambda$24.contains(str3);
                                            Modifier m251clickableXHw0xAI$default2 = ClickableKt.m251clickableXHw0xAI$default(BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(AspectRatioKt.aspectRatio$default(RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), 1.0f, z, 2, obj), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(10))), contains ? ThemeKt.getPrimaryPurple() : ColorKt.Color(4293781494L), null, 2, null), false, null, null, new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$2$1$5$1$4$1$1$1
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
                                                    Set ProfileScreen$lambda$242;
                                                    Set<String> plus;
                                                    Set ProfileScreen$lambda$243;
                                                    if (contains) {
                                                        ProfileScreen$lambda$243 = ProfileScreenKt.ProfileScreen$lambda$24(mutableState38);
                                                        plus = SetsKt.minus((Set<? extends String>) ProfileScreen$lambda$243, str3);
                                                    } else {
                                                        ProfileScreen$lambda$242 = ProfileScreenKt.ProfileScreen$lambda$24(mutableState38);
                                                        plus = SetsKt.plus((Set<? extends String>) ProfileScreen$lambda$242, str3);
                                                    }
                                                    mutableState38.setValue(plus);
                                                    settingsRepository5.setReminderDays(plus);
                                                    ReminderScheduler.INSTANCE.scheduleNextReminder(context6);
                                                }
                                            }, 7, null);
                                            Alignment center2 = Alignment.INSTANCE.getCenter();
                                            composer5.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(center2, z, composer5, i6);
                                            composer5.startReplaceableGroup(i7);
                                            ComposerKt.sourceInformation(composer5, str2);
                                            int currentCompositeKeyHash12 = ComposablesKt.getCurrentCompositeKeyHash(composer5, z);
                                            CompositionLocalMap currentCompositionLocalMap12 = composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor12 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf12 = LayoutKt.modifierMaterializerOf(m251clickableXHw0xAI$default2);
                                            if (!(composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer4.startReusableNode();
                                            if (composer4.getInserting()) {
                                                composer5.createNode(constructor12);
                                            } else {
                                                composer4.useNode();
                                            }
                                            Composer m2947constructorimpl12 = Updater.m2947constructorimpl(composer4);
                                            Updater.m2954setimpl(m2947constructorimpl12, rememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m2954setimpl(m2947constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash12 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m2947constructorimpl12.getInserting() || !Intrinsics.areEqual(m2947constructorimpl12.rememberedValue(), Integer.valueOf(currentCompositeKeyHash12))) {
                                                m2947constructorimpl12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash12));
                                                m2947constructorimpl12.apply(Integer.valueOf(currentCompositeKeyHash12), setCompositeKeyHash12);
                                            }
                                            modifierMaterializerOf12.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer5, Integer.valueOf((int) z));
                                            composer5.startReplaceableGroup(i8);
                                            ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                                            TextKt.m2133Text4IGK_g(str3, (Modifier) null, contains ? Color.INSTANCE.m3454getWhite0d7_KjU() : ThemeKt.getPrimaryPurple(), TextUnitKt.getSp(12), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 199680, 0, 131026);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            composer4.endReplaceableGroup();
                                            composer4.endNode();
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            composer5 = composer4;
                                            str2 = str2;
                                            z = z;
                                            i7 = i7;
                                            i6 = i6;
                                            obj = obj;
                                            i8 = i8;
                                        }
                                        composer4.endReplaceableGroup();
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        composer4.endReplaceableGroup();
                                        composer4.endNode();
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        composer4.endReplaceableGroup();
                                        composer4.endNode();
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                    }
                                    composer4.endReplaceableGroup();
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endReplaceableGroup();
                                    composer4.endNode();
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), composer3, 221190, 8);
                        SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f)), composer3, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            });
            composer2 = startRestartGroup;
            ScaffoldKt.m1788ScaffoldTvnljyQ(null, composableLambda, null, null, null, 0, backgroundLavender, 0L, null, composableLambda2, startRestartGroup, 805306416, 445);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$ProfileScreen$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    ProfileScreenKt.ProfileScreen(onBackPressed, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileScreen$lambda$3(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String ProfileScreen$lambda$6(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileScreen$lambda$9(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String ProfileScreen$lambda$12(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ProfileScreen$lambda$15(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileScreen$lambda$16(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ProfileScreen$lambda$18(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileScreen$lambda$19(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ProfileScreen$lambda$21(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileScreen$lambda$22(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set<String> ProfileScreen$lambda$24(MutableState<Set<String>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileScreen$lambda$28(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileScreen$lambda$31(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDatePicker(Context context, String str, final Function1<? super String, Unit> function1) {
        Calendar calendar = Calendar.getInstance();
        String str2 = str;
        if (str2.length() > 0) {
            List split$default = StringsKt.split$default((CharSequence) str2, new String[]{"/"}, false, 0, 6, (Object) null);
            if (split$default.size() == 3) {
                try {
                    int parseInt = Integer.parseInt((String) split$default.get(0));
                    int parseInt2 = Integer.parseInt((String) split$default.get(1)) - 1;
                    calendar.set(1, Integer.parseInt((String) split$default.get(2)));
                    calendar.set(2, parseInt2);
                    calendar.set(5, parseInt);
                } catch (Exception unused) {
                }
            }
        }
        new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$$ExternalSyntheticLambda1
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                ProfileScreenKt.showDatePicker$lambda$35(Function1.this, datePicker, i, i2, i3);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDatePicker$lambda$35(Function1 onDateSelected, DatePicker datePicker, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(onDateSelected, "$onDateSelected");
        onDateSelected.invoke(i3 + "/" + (i2 + 1) + "/" + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTimePicker(Context context, int i, int i2, final Function2<? super Integer, ? super Integer, Unit> function2) {
        new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() { // from class: com.example.flashcardapp.ui.ProfileScreenKt$$ExternalSyntheticLambda0
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public final void onTimeSet(TimePicker timePicker, int i3, int i4) {
                ProfileScreenKt.showTimePicker$lambda$36(Function2.this, timePicker, i3, i4);
            }
        }, i, i2, false).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTimePicker$lambda$36(Function2 onTimeSelected, TimePicker timePicker, int i, int i2) {
        Intrinsics.checkNotNullParameter(onTimeSelected, "$onTimeSelected");
        onTimeSelected.invoke(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String formatTime(int i, int i2) {
        String str = i >= 12 ? "PM" : "AM";
        if (i == 0) {
            i = 12;
        } else if (i > 12) {
            i -= 12;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d %s", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String copyUriToInternalStorage(Context context, Uri uri) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return null;
            }
            File file = new File(context.getFilesDir(), "profile_pic_" + System.currentTimeMillis() + ".jpg");
            FileOutputStream fileOutputStream = openInputStream;
            try {
                InputStream inputStream = fileOutputStream;
                fileOutputStream = new FileOutputStream(file);
                try {
                    ByteStreamsKt.copyTo$default(inputStream, fileOutputStream, 0, 2, null);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    return file.getAbsolutePath();
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
