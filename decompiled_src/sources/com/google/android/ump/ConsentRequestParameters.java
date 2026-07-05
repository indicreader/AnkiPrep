package com.google.android.ump;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.2.0 */
/* loaded from: classes3.dex */
public class ConsentRequestParameters {
    private final boolean zza;
    private final String zzb;
    private final ConsentDebugSettings zzc;

    /* compiled from: com.google.android.ump:user-messaging-platform@@2.2.0 */
    /* loaded from: classes3.dex */
    public static final class Builder {
        private boolean zza;
        private String zzb;
        private ConsentDebugSettings zzc;

        public ConsentRequestParameters build() {
            return new ConsentRequestParameters(this, null);
        }

        public Builder setAdMobAppId(String str) {
            this.zzb = str;
            return this;
        }

        public Builder setConsentDebugSettings(ConsentDebugSettings consentDebugSettings) {
            this.zzc = consentDebugSettings;
            return this;
        }

        public Builder setTagForUnderAgeOfConsent(boolean z) {
            this.zza = z;
            return this;
        }
    }

    /* synthetic */ ConsentRequestParameters(Builder builder, zzb zzbVar) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = builder.zzc;
    }

    public ConsentDebugSettings getConsentDebugSettings() {
        return this.zzc;
    }

    public boolean isTagForUnderAgeOfConsent() {
        return this.zza;
    }

    public final String zza() {
        return this.zzb;
    }
}
