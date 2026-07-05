package com.google.android.gms.internal.mlkit_vision_text_common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
public final class zzrt extends zza implements zzrv {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrt(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.text.aidls.ICommonTextRecognizerCreator");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzrv
    public final zzrw zzd(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, zzsi zzsiVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, iObjectWrapper);
        zzrw zzrwVar = null;
        zzc.zzb(zza, null);
        zzc.zza(zza, zzsiVar);
        Parcel zzb = zzb(1, zza);
        IBinder readStrongBinder = zzb.readStrongBinder();
        if (readStrongBinder != null) {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.mlkit.vision.text.aidls.ITextRecognizer");
            zzrwVar = queryLocalInterface instanceof zzrw ? (zzrw) queryLocalInterface : new zzrw(readStrongBinder);
        }
        zzb.recycle();
        return zzrwVar;
    }
}
