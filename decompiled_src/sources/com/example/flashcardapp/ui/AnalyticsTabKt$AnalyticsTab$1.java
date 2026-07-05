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
/* compiled from: AnalyticsTab.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class AnalyticsTabKt$AnalyticsTab$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ MutableState<String> $avatarUriStr$delegate;
    final /* synthetic */ MutableState<String> $profileBio$delegate;
    final /* synthetic */ MutableState<String> $profileGoal$delegate;
    final /* synthetic */ MutableState<String> $profileName$delegate;
    final /* synthetic */ MutableState<String> $profileRank$delegate;
    final /* synthetic */ SharedPreferences $sharedPrefs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsTabKt$AnalyticsTab$1(SharedPreferences sharedPreferences, MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4, MutableState<String> mutableState5) {
        super(1);
        this.$sharedPrefs = sharedPreferences;
        this.$profileName$delegate = mutableState;
        this.$profileGoal$delegate = mutableState2;
        this.$profileRank$delegate = mutableState3;
        this.$profileBio$delegate = mutableState4;
        this.$avatarUriStr$delegate = mutableState5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final MutableState<String> mutableState = this.$profileName$delegate;
        final MutableState<String> mutableState2 = this.$profileGoal$delegate;
        final MutableState<String> mutableState3 = this.$profileRank$delegate;
        final MutableState<String> mutableState4 = this.$profileBio$delegate;
        final MutableState<String> mutableState5 = this.$avatarUriStr$delegate;
        final SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$AnalyticsTab$1$$ExternalSyntheticLambda0
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                AnalyticsTabKt$AnalyticsTab$1.invoke$lambda$0(MutableState.this, mutableState2, mutableState3, mutableState4, mutableState5, sharedPreferences, str);
            }
        };
        this.$sharedPrefs.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        final SharedPreferences sharedPreferences = this.$sharedPrefs;
        return new DisposableEffectResult() { // from class: com.example.flashcardapp.ui.AnalyticsTabKt$AnalyticsTab$1$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(MutableState profileName$delegate, MutableState profileGoal$delegate, MutableState profileRank$delegate, MutableState profileBio$delegate, MutableState avatarUriStr$delegate, SharedPreferences sharedPreferences, String str) {
        Intrinsics.checkNotNullParameter(profileName$delegate, "$profileName$delegate");
        Intrinsics.checkNotNullParameter(profileGoal$delegate, "$profileGoal$delegate");
        Intrinsics.checkNotNullParameter(profileRank$delegate, "$profileRank$delegate");
        Intrinsics.checkNotNullParameter(profileBio$delegate, "$profileBio$delegate");
        Intrinsics.checkNotNullParameter(avatarUriStr$delegate, "$avatarUriStr$delegate");
        if (str != null) {
            switch (str.hashCode()) {
                case -402824826:
                    if (str.equals("avatar_uri")) {
                        avatarUriStr$delegate.setValue(sharedPreferences.getString("avatar_uri", null));
                        return;
                    }
                    return;
                case 178010482:
                    if (str.equals("profile_bio")) {
                        String string = sharedPreferences.getString("profile_bio", "Mastering Indian Polity & Ethics for the upcoming UPSC cycle. Focused on high-density information retrieval and consistent mock performance.");
                        profileBio$delegate.setValue(string != null ? string : "Mastering Indian Polity & Ethics for the upcoming UPSC cycle. Focused on high-density information retrieval and consistent mock performance.");
                        return;
                    }
                    return;
                case 1223512041:
                    if (str.equals("profile_goal")) {
                        String string2 = sharedPreferences.getString("profile_goal", "Civil Services");
                        profileGoal$delegate.setValue(string2 != null ? string2 : "Civil Services");
                        return;
                    }
                    return;
                case 1223707489:
                    if (str.equals("profile_name")) {
                        String string3 = sharedPreferences.getString("profile_name", "Aaryan Sharma");
                        profileName$delegate.setValue(string3 != null ? string3 : "Aaryan Sharma");
                        return;
                    }
                    return;
                case 1223826690:
                    if (str.equals("profile_rank")) {
                        String string4 = sharedPreferences.getString("profile_rank", "Master Rank");
                        profileRank$delegate.setValue(string4 != null ? string4 : "Master Rank");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
