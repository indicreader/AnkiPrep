package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzbur extends zzayh implements zzbus {
    public zzbur() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzbus zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        return queryLocalInterface instanceof zzbus ? (zzbus) queryLocalInterface : new zzbuq(iBinder);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0021. Please report as an issue. */
    @Override // com.google.android.gms.internal.ads.zzayh
    protected final boolean zzbO(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbuv zzbuvVar = null;
        zzbud zzbubVar = null;
        zzbum zzbukVar = null;
        zzbug zzbueVar = null;
        zzbup zzbunVar = null;
        zzbum zzbukVar2 = null;
        zzbup zzbunVar2 = null;
        zzbuj zzbuhVar = null;
        zzbug zzbueVar2 = null;
        if (i == 1) {
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            String readString = parcel.readString();
            Bundle bundle = (Bundle) zzayi.zza(parcel, Bundle.CREATOR);
            Bundle bundle2 = (Bundle) zzayi.zza(parcel, Bundle.CREATOR);
            com.google.android.gms.ads.internal.client.zzq zzqVar = (com.google.android.gms.ads.internal.client.zzq) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzq.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                zzbuvVar = queryLocalInterface instanceof zzbuv ? (zzbuv) queryLocalInterface : new zzbut(readStrongBinder);
            }
            zzbuv zzbuvVar2 = zzbuvVar;
            zzayi.zzc(parcel);
            zzh(asInterface, readString, bundle, bundle2, zzqVar, zzbuvVar2);
            parcel2.writeNoException();
        } else if (i == 2) {
            zzbvg zzf = zzf();
            parcel2.writeNoException();
            zzayi.zze(parcel2, zzf);
        } else if (i == 3) {
            zzbvg zzg = zzg();
            parcel2.writeNoException();
            zzayi.zze(parcel2, zzg);
        } else if (i == 5) {
            com.google.android.gms.ads.internal.client.zzdq zze = zze();
            parcel2.writeNoException();
            zzayi.zzf(parcel2, zze);
        } else if (i == 10) {
            IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzayi.zzc(parcel);
            parcel2.writeNoException();
        } else if (i != 11) {
            switch (i) {
                case 13:
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder2 = parcel.readStrongBinder();
                    if (readStrongBinder2 != null) {
                        IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        zzbueVar2 = queryLocalInterface2 instanceof zzbug ? (zzbug) queryLocalInterface2 : new zzbue(readStrongBinder2);
                    }
                    zzbug zzbugVar = zzbueVar2;
                    zzbtb zzb = zzbta.zzb(parcel.readStrongBinder());
                    com.google.android.gms.ads.internal.client.zzq zzqVar2 = (com.google.android.gms.ads.internal.client.zzq) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzq.CREATOR);
                    zzayi.zzc(parcel);
                    zzj(readString2, readString3, zzlVar, asInterface2, zzbugVar, zzb, zzqVar2);
                    parcel2.writeNoException();
                    break;
                case 14:
                    String readString4 = parcel.readString();
                    String readString5 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar2 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder3 = parcel.readStrongBinder();
                    if (readStrongBinder3 != null) {
                        IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                        zzbuhVar = queryLocalInterface3 instanceof zzbuj ? (zzbuj) queryLocalInterface3 : new zzbuh(readStrongBinder3);
                    }
                    zzbuj zzbujVar = zzbuhVar;
                    zzbtb zzb2 = zzbta.zzb(parcel.readStrongBinder());
                    zzayi.zzc(parcel);
                    zzl(readString4, readString5, zzlVar2, asInterface3, zzbujVar, zzb2);
                    parcel2.writeNoException();
                    break;
                case 15:
                    IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzayi.zzc(parcel);
                    boolean zzs = zzs(asInterface4);
                    parcel2.writeNoException();
                    parcel2.writeInt(zzs ? 1 : 0);
                    break;
                case 16:
                    String readString6 = parcel.readString();
                    String readString7 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar3 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder4 = parcel.readStrongBinder();
                    if (readStrongBinder4 != null) {
                        IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        zzbunVar2 = queryLocalInterface4 instanceof zzbup ? (zzbup) queryLocalInterface4 : new zzbun(readStrongBinder4);
                    }
                    zzbup zzbupVar = zzbunVar2;
                    zzbtb zzb3 = zzbta.zzb(parcel.readStrongBinder());
                    zzayi.zzc(parcel);
                    zzp(readString6, readString7, zzlVar3, asInterface5, zzbupVar, zzb3);
                    parcel2.writeNoException();
                    break;
                case 17:
                    IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzayi.zzc(parcel);
                    boolean zzt = zzt(asInterface6);
                    parcel2.writeNoException();
                    parcel2.writeInt(zzt ? 1 : 0);
                    break;
                case 18:
                    String readString8 = parcel.readString();
                    String readString9 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar4 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder5 = parcel.readStrongBinder();
                    if (readStrongBinder5 != null) {
                        IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        zzbukVar2 = queryLocalInterface5 instanceof zzbum ? (zzbum) queryLocalInterface5 : new zzbuk(readStrongBinder5);
                    }
                    zzbum zzbumVar = zzbukVar2;
                    zzbtb zzb4 = zzbta.zzb(parcel.readStrongBinder());
                    zzayi.zzc(parcel);
                    zzm(readString8, readString9, zzlVar4, asInterface7, zzbumVar, zzb4);
                    parcel2.writeNoException();
                    break;
                case 19:
                    String readString10 = parcel.readString();
                    zzayi.zzc(parcel);
                    zzq(readString10);
                    parcel2.writeNoException();
                    break;
                case 20:
                    String readString11 = parcel.readString();
                    String readString12 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar5 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper asInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder6 = parcel.readStrongBinder();
                    if (readStrongBinder6 != null) {
                        IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        zzbunVar = queryLocalInterface6 instanceof zzbup ? (zzbup) queryLocalInterface6 : new zzbun(readStrongBinder6);
                    }
                    zzbup zzbupVar2 = zzbunVar;
                    zzbtb zzb5 = zzbta.zzb(parcel.readStrongBinder());
                    zzayi.zzc(parcel);
                    zzo(readString11, readString12, zzlVar5, asInterface8, zzbupVar2, zzb5);
                    parcel2.writeNoException();
                    break;
                case 21:
                    String readString13 = parcel.readString();
                    String readString14 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar6 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper asInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder7 = parcel.readStrongBinder();
                    if (readStrongBinder7 != null) {
                        IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        zzbueVar = queryLocalInterface7 instanceof zzbug ? (zzbug) queryLocalInterface7 : new zzbue(readStrongBinder7);
                    }
                    zzbug zzbugVar2 = zzbueVar;
                    zzbtb zzb6 = zzbta.zzb(parcel.readStrongBinder());
                    com.google.android.gms.ads.internal.client.zzq zzqVar3 = (com.google.android.gms.ads.internal.client.zzq) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzq.CREATOR);
                    zzayi.zzc(parcel);
                    zzk(readString13, readString14, zzlVar6, asInterface9, zzbugVar2, zzb6, zzqVar3);
                    parcel2.writeNoException();
                    break;
                case 22:
                    String readString15 = parcel.readString();
                    String readString16 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar7 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper asInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder8 = parcel.readStrongBinder();
                    if (readStrongBinder8 != null) {
                        IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        zzbukVar = queryLocalInterface8 instanceof zzbum ? (zzbum) queryLocalInterface8 : new zzbuk(readStrongBinder8);
                    }
                    zzbum zzbumVar2 = zzbukVar;
                    zzbtb zzb7 = zzbta.zzb(parcel.readStrongBinder());
                    zzbjb zzbjbVar = (zzbjb) zzayi.zza(parcel, zzbjb.CREATOR);
                    zzayi.zzc(parcel);
                    zzn(readString15, readString16, zzlVar7, asInterface10, zzbumVar2, zzb7, zzbjbVar);
                    parcel2.writeNoException();
                    break;
                case 23:
                    String readString17 = parcel.readString();
                    String readString18 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar8 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper asInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder9 = parcel.readStrongBinder();
                    if (readStrongBinder9 != null) {
                        IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IAppOpenCallback");
                        zzbubVar = queryLocalInterface9 instanceof zzbud ? (zzbud) queryLocalInterface9 : new zzbub(readStrongBinder9);
                    }
                    zzbud zzbudVar = zzbubVar;
                    zzbtb zzb8 = zzbta.zzb(parcel.readStrongBinder());
                    zzayi.zzc(parcel);
                    zzi(readString17, readString18, zzlVar8, asInterface11, zzbudVar, zzb8);
                    parcel2.writeNoException();
                    break;
                case 24:
                    IObjectWrapper asInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzayi.zzc(parcel);
                    boolean zzr = zzr(asInterface12);
                    parcel2.writeNoException();
                    parcel2.writeInt(zzr ? 1 : 0);
                    break;
                default:
                    return false;
            }
        } else {
            parcel.createStringArray();
            zzayi.zzc(parcel);
            parcel2.writeNoException();
        }
        return true;
    }
}
