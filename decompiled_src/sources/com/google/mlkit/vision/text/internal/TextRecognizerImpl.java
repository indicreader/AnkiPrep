package com.google.mlkit.vision.text.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmu;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmw;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmx;
import com.google.android.gms.internal.mlkit_vision_text_common.zzpe;
import com.google.android.gms.internal.mlkit_vision_text_common.zzph;
import com.google.android.gms.internal.mlkit_vision_text_common.zzrd;
import com.google.android.gms.internal.mlkit_vision_text_common.zzrg;
import com.google.android.gms.tasks.Task;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.TextRecognizerOptionsInterface;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes4.dex */
public class TextRecognizerImpl extends MobileVisionBase<Text> implements TextRecognizer {
    private final TextRecognizerOptionsInterface zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextRecognizerImpl(TextRecognizerTaskWithResource textRecognizerTaskWithResource, Executor executor, zzrd zzrdVar, TextRecognizerOptionsInterface textRecognizerOptionsInterface) {
        super(textRecognizerTaskWithResource, executor);
        this.zzb = textRecognizerOptionsInterface;
        zzmx zzmxVar = new zzmx();
        zzmxVar.zze(textRecognizerOptionsInterface.getIsThickClient() ? zzmu.TYPE_THICK : zzmu.TYPE_THIN);
        zzpe zzpeVar = new zzpe();
        zzph zzphVar = new zzph();
        zzphVar.zza(LoggingUtils.zza(textRecognizerOptionsInterface.getLoggingLanguageOption()));
        zzpeVar.zze(zzphVar.zzc());
        zzmxVar.zzh(zzpeVar.zzf());
        zzrdVar.zzd(zzrg.zzg(zzmxVar, 1), zzmw.ON_DEVICE_TEXT_CREATE);
    }

    @Override // com.google.mlkit.vision.interfaces.Detector
    public final int getDetectorType() {
        return 4;
    }

    @Override // com.google.android.gms.common.api.OptionalModuleApi
    public final Feature[] getOptionalFeatures() {
        return TextOptionalModuleUtils.zza(this.zzb);
    }

    @Override // com.google.mlkit.vision.text.TextRecognizer
    public final Task<Text> process(MlImage mlImage) {
        return super.processBase(mlImage);
    }

    @Override // com.google.mlkit.vision.text.TextRecognizer
    public final Task<Text> process(InputImage inputImage) {
        return super.processBase(inputImage);
    }
}
