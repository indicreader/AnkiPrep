package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbru {
    private static final Charset zzc = Charset.forName("UTF-8");
    public static final zzbrr zza = new zzbrt();
    public static final zzbrp zzb = new zzbrp() { // from class: com.google.android.gms.internal.ads.zzbrs
        @Override // com.google.android.gms.internal.ads.zzbrp
        public final Object zza(JSONObject jSONObject) {
            return zzbru.zza(jSONObject);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ InputStream zza(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(zzc));
    }
}
