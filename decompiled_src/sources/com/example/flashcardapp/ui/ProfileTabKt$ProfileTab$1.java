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
/* compiled from: ProfileTab.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ProfileTabKt$ProfileTab$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ MutableState<String> $avatarUriStr$delegate;
    final /* synthetic */ SharedPreferences $sharedPrefs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileTabKt$ProfileTab$1(SharedPreferences sharedPreferences, MutableState<String> mutableState) {
        super(1);
        this.$sharedPrefs = sharedPreferences;
        this.$avatarUriStr$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final MutableState<String> mutableState = this.$avatarUriStr$delegate;
        final SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.example.flashcardapp.ui.ProfileTabKt$ProfileTab$1$$ExternalSyntheticLambda0
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                ProfileTabKt$ProfileTab$1.invoke$lambda$0(MutableState.this, sharedPreferences, str);
            }
        };
        this.$sharedPrefs.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        final SharedPreferences sharedPreferences = this.$sharedPrefs;
        return new DisposableEffectResult() { // from class: com.example.flashcardapp.ui.ProfileTabKt$ProfileTab$1$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(MutableState avatarUriStr$delegate, SharedPreferences sharedPreferences, String str) {
        Intrinsics.checkNotNullParameter(avatarUriStr$delegate, "$avatarUriStr$delegate");
        if (str != null && str.hashCode() == -402824826 && str.equals("avatar_uri")) {
            avatarUriStr$delegate.setValue(sharedPreferences.getString("avatar_uri", null));
        }
    }
}
