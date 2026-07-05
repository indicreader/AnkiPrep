package com.example.flashcardapp.ui;

import android.content.SharedPreferences;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DashboardTab.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class DashboardTabKt$DashboardTab$3 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ MutableState<String> $avatarUriStr$delegate;
    final /* synthetic */ MutableState<String> $profileName$delegate;
    final /* synthetic */ SharedPreferences $sharedPrefs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DashboardTabKt$DashboardTab$3(SharedPreferences sharedPreferences, MutableState<String> mutableState, MutableState<String> mutableState2) {
        super(1);
        this.$sharedPrefs = sharedPreferences;
        this.$avatarUriStr$delegate = mutableState;
        this.$profileName$delegate = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final MutableState<String> mutableState = this.$avatarUriStr$delegate;
        final MutableState<String> mutableState2 = this.$profileName$delegate;
        final SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.example.flashcardapp.ui.DashboardTabKt$DashboardTab$3$$ExternalSyntheticLambda0
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                DashboardTabKt$DashboardTab$3.invoke$lambda$0(MutableState.this, mutableState2, sharedPreferences, str);
            }
        };
        this.$sharedPrefs.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        final SharedPreferences sharedPreferences = this.$sharedPrefs;
        return new DisposableEffectResult() { // from class: com.example.flashcardapp.ui.DashboardTabKt$DashboardTab$3$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(MutableState avatarUriStr$delegate, MutableState profileName$delegate, SharedPreferences sharedPreferences, String str) {
        Intrinsics.checkNotNullParameter(avatarUriStr$delegate, "$avatarUriStr$delegate");
        Intrinsics.checkNotNullParameter(profileName$delegate, "$profileName$delegate");
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode == -402824826) {
                if (str.equals("avatar_uri")) {
                    avatarUriStr$delegate.setValue(sharedPreferences.getString("avatar_uri", null));
                }
            } else if (hashCode == 1223707489 && str.equals("profile_name")) {
                String string = sharedPreferences.getString("profile_name", "User");
                profileName$delegate.setValue(string != null ? string : "User");
            }
        }
    }
}
