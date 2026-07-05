package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes3.dex */
final class zziz implements ObjectEncoder {
    static final zziz zza = new zziz();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;
    private static final FieldDescriptor zzi;
    private static final FieldDescriptor zzj;
    private static final FieldDescriptor zzk;
    private static final FieldDescriptor zzl;
    private static final FieldDescriptor zzm;
    private static final FieldDescriptor zzn;
    private static final FieldDescriptor zzo;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("appId");
        zzbk zzbkVar = new zzbk();
        zzbkVar.zza(1);
        zzb = builder.withProperty(zzbkVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("appVersion");
        zzbk zzbkVar2 = new zzbk();
        zzbkVar2.zza(2);
        zzc = builder2.withProperty(zzbkVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("firebaseProjectId");
        zzbk zzbkVar3 = new zzbk();
        zzbkVar3.zza(3);
        zzd = builder3.withProperty(zzbkVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("mlSdkVersion");
        zzbk zzbkVar4 = new zzbk();
        zzbkVar4.zza(4);
        zze = builder4.withProperty(zzbkVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("tfliteSchemaVersion");
        zzbk zzbkVar5 = new zzbk();
        zzbkVar5.zza(5);
        zzf = builder5.withProperty(zzbkVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("gcmSenderId");
        zzbk zzbkVar6 = new zzbk();
        zzbkVar6.zza(6);
        zzg = builder6.withProperty(zzbkVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("apiKey");
        zzbk zzbkVar7 = new zzbk();
        zzbkVar7.zza(7);
        zzh = builder7.withProperty(zzbkVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("languages");
        zzbk zzbkVar8 = new zzbk();
        zzbkVar8.zza(8);
        zzi = builder8.withProperty(zzbkVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("mlSdkInstanceId");
        zzbk zzbkVar9 = new zzbk();
        zzbkVar9.zza(9);
        zzj = builder9.withProperty(zzbkVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isClearcutClient");
        zzbk zzbkVar10 = new zzbk();
        zzbkVar10.zza(10);
        zzk = builder10.withProperty(zzbkVar10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("isStandaloneMlkit");
        zzbk zzbkVar11 = new zzbk();
        zzbkVar11.zza(11);
        zzl = builder11.withProperty(zzbkVar11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("isJsonLogging");
        zzbk zzbkVar12 = new zzbk();
        zzbkVar12.zza(12);
        zzm = builder12.withProperty(zzbkVar12.zzb()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("buildLevel");
        zzbk zzbkVar13 = new zzbk();
        zzbkVar13.zza(13);
        zzn = builder13.withProperty(zzbkVar13.zzb()).build();
        FieldDescriptor.Builder builder14 = FieldDescriptor.builder("optionalModuleVersion");
        zzbk zzbkVar14 = new zzbk();
        zzbkVar14.zza(14);
        zzo = builder14.withProperty(zzbkVar14.zzb()).build();
    }

    private zziz() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzof zzofVar = (zzof) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzofVar.zzg());
        objectEncoderContext2.add(zzc, zzofVar.zzh());
        objectEncoderContext2.add(zzd, (Object) null);
        objectEncoderContext2.add(zze, zzofVar.zzj());
        objectEncoderContext2.add(zzf, zzofVar.zzk());
        objectEncoderContext2.add(zzg, (Object) null);
        objectEncoderContext2.add(zzh, (Object) null);
        objectEncoderContext2.add(zzi, zzofVar.zza());
        objectEncoderContext2.add(zzj, zzofVar.zzi());
        objectEncoderContext2.add(zzk, zzofVar.zzb());
        objectEncoderContext2.add(zzl, zzofVar.zzd());
        objectEncoderContext2.add(zzm, zzofVar.zzc());
        objectEncoderContext2.add(zzn, zzofVar.zze());
        objectEncoderContext2.add(zzo, zzofVar.zzf());
    }
}
