package com.google.mlkit.vision.text.internal;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmv;
import com.google.android.gms.internal.mlkit_vision_text_common.zzrd;
import com.google.android.gms.internal.mlkit_vision_text_common.zzrr;
import com.google.android.gms.internal.mlkit_vision_text_common.zzru;
import com.google.android.gms.internal.mlkit_vision_text_common.zzrw;
import com.google.android.gms.internal.mlkit_vision_text_common.zzry;
import com.google.android.gms.internal.mlkit_vision_text_common.zzrz;
import com.google.android.gms.internal.mlkit_vision_text_common.zzsi;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.CommonConvertUtils;
import com.google.mlkit.vision.common.internal.ImageUtils;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognizerOptionsInterface;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes4.dex */
final class zzc implements zzl {
    private final Context zza;
    private final TextRecognizerOptionsInterface zzb;
    private boolean zzc;
    private boolean zzd;
    private final zzrd zze;
    private zzrw zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzc(Context context, TextRecognizerOptionsInterface textRecognizerOptionsInterface, zzrd zzrdVar) {
        this.zza = context;
        this.zzb = textRecognizerOptionsInterface;
        this.zze = zzrdVar;
    }

    private static zzsi zzd(TextRecognizerOptionsInterface textRecognizerOptionsInterface, String str) {
        int i;
        String configLabel = textRecognizerOptionsInterface.getConfigLabel();
        String loggingLibraryNameForOptionalModule = textRecognizerOptionsInterface.getLoggingLibraryNameForOptionalModule();
        switch (textRecognizerOptionsInterface.getLoggingLanguageOption()) {
            case 1:
                i = 2;
                break;
            case 2:
                i = 3;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 5;
                break;
            case 5:
                i = 6;
                break;
            case 6:
                i = 7;
                break;
            case 7:
                i = 8;
                break;
            default:
                i = 1;
                break;
        }
        return new zzsi(configLabel, loggingLibraryNameForOptionalModule, str, true, i - 1, textRecognizerOptionsInterface.getLanguageHint());
    }

    @Override // com.google.mlkit.vision.text.internal.zzl
    public final Text zza(InputImage inputImage) throws MlKitException {
        if (this.zzf == null) {
            zzb();
        }
        zzrw zzrwVar = (zzrw) Preconditions.checkNotNull(this.zzf);
        if (!this.zzc) {
            try {
                zzrwVar.zze();
                this.zzc = true;
            } catch (RemoteException e) {
                throw new MlKitException("Failed to init text recognizer ".concat(String.valueOf(this.zzb.getLoggingLibraryName())), 13, e);
            }
        }
        try {
            return new Text(zzrwVar.zzd(ImageUtils.getInstance().getImageDataWrapper(inputImage), new zzrr(inputImage.getFormat(), inputImage.getWidth(), inputImage.getHeight(), CommonConvertUtils.convertToMVRotation(inputImage.getRotationDegrees()), SystemClock.elapsedRealtime())), inputImage.getCoordinatesMatrix());
        } catch (RemoteException e2) {
            throw new MlKitException("Failed to run text recognizer ".concat(String.valueOf(this.zzb.getLoggingLibraryName())), 13, e2);
        }
    }

    @Override // com.google.mlkit.vision.text.internal.zzl
    public final void zzb() throws MlKitException {
        zzrw zze;
        if (this.zzf == null) {
            try {
                TextRecognizerOptionsInterface textRecognizerOptionsInterface = this.zzb;
                boolean z = textRecognizerOptionsInterface instanceof zzb;
                String zza = z ? ((zzb) textRecognizerOptionsInterface).zza() : null;
                if (this.zzb.getIsThickClient()) {
                    zze = zzry.zza(DynamiteModule.load(this.zza, DynamiteModule.PREFER_LOCAL, this.zzb.getModuleId()).instantiate("com.google.mlkit.vision.text.bundled.common.BundledTextRecognizerCreator")).zze(ObjectWrapper.wrap(this.zza), zzd(this.zzb, zza));
                } else if (z) {
                    zze = zzru.zza(DynamiteModule.load(this.zza, DynamiteModule.PREFER_REMOTE, this.zzb.getModuleId()).instantiate("com.google.android.gms.vision.text.mlkit.CommonTextRecognizerCreator")).zzd(ObjectWrapper.wrap(this.zza), null, zzd(this.zzb, zza));
                } else {
                    zzrz zza2 = zzry.zza(DynamiteModule.load(this.zza, DynamiteModule.PREFER_REMOTE, this.zzb.getModuleId()).instantiate("com.google.android.gms.vision.text.mlkit.TextRecognizerCreator"));
                    if (this.zzb.getLoggingLanguageOption() == 1) {
                        zze = zza2.zzd(ObjectWrapper.wrap(this.zza));
                    } else {
                        zze = zza2.zze(ObjectWrapper.wrap(this.zza), zzd(this.zzb, zza));
                    }
                }
                this.zzf = zze;
                LoggingUtils.zzb(this.zze, this.zzb.getIsThickClient(), zzmv.NO_ERROR);
            } catch (RemoteException e) {
                LoggingUtils.zzb(this.zze, this.zzb.getIsThickClient(), zzmv.OPTIONAL_MODULE_INIT_ERROR);
                throw new MlKitException("Failed to create text recognizer ".concat(String.valueOf(this.zzb.getLoggingLibraryName())), 13, e);
            } catch (DynamiteModule.LoadingException e2) {
                LoggingUtils.zzb(this.zze, this.zzb.getIsThickClient(), zzmv.OPTIONAL_MODULE_NOT_AVAILABLE);
                if (this.zzb.getIsThickClient()) {
                    throw new MlKitException(String.format("Failed to load text module %s. %s", this.zzb.getLoggingLibraryName(), e2.getMessage()), 13, e2);
                }
                if (!this.zzd) {
                    OptionalModuleUtils.requestDownload(this.zza, TextOptionalModuleUtils.zza(this.zzb));
                    this.zzd = true;
                }
                throw new MlKitException("Waiting for the text optional module to be downloaded. Please wait.", 14);
            }
        }
    }

    @Override // com.google.mlkit.vision.text.internal.zzl
    public final void zzc() {
        zzrw zzrwVar = this.zzf;
        if (zzrwVar != null) {
            try {
                zzrwVar.zzf();
            } catch (RemoteException e) {
                Log.e("DecoupledTextDelegate", "Failed to release text recognizer ".concat(String.valueOf(this.zzb.getLoggingLibraryName())), e);
            }
            this.zzf = null;
        }
        this.zzc = false;
    }
}
