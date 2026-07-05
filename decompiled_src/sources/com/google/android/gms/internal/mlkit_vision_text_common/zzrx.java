package com.google.android.gms.internal.mlkit_vision_text_common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
public final class zzrx extends zza implements zzrz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrx(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.text.aidls.ITextRecognizerCreator");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzrz
    public final zzrw zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzrw zzrwVar;
        Parcel zza = zza();
        zzc.zzb(zza, iObjectWrapper);
        Parcel zzb = zzb(1, zza);
        IBinder readStrongBinder = zzb.readStrongBinder();
        if (readStrongBinder == null) {
            zzrwVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.mlkit.vision.text.aidls.ITextRecognizer");
            zzrwVar = queryLocalInterface instanceof zzrw ? (zzrw) queryLocalInterface : new zzrw(readStrongBinder);
        }
        zzb.recycle();
        return zzrwVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzrz
    public final zzrw zze(IObjectWrapper iObjectWrapper, zzsi zzsiVar) throws RemoteException {
        zzrw zzrwVar;
        Parcel zza = zza();
        zzc.zzb(zza, iObjectWrapper);
        zzc.zza(zza, zzsiVar);
        Parcel zzb = zzb(2, zza);
        IBinder readStrongBinder = zzb.readStrongBinder();
        if (readStrongBinder == null) {
            zzrwVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.mlkit.vision.text.aidls.ITextRecognizer");
            zzrwVar = queryLocalInterface instanceof zzrw ? (zzrw) queryLocalInterface : new zzrw(readStrongBinder);
        }
        zzb.recycle();
        return zzrwVar;
    }
}
