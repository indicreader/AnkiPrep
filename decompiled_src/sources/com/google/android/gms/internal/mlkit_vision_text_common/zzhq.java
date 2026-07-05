package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
final class zzhq implements ObjectEncoder {
    static final zzhq zza = new zzhq();
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

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("durationMs");
        zzcw zzcwVar = new zzcw();
        zzcwVar.zza(1);
        zzb = builder.withProperty(zzcwVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("errorCode");
        zzcw zzcwVar2 = new zzcw();
        zzcwVar2.zza(2);
        zzc = builder2.withProperty(zzcwVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("isColdCall");
        zzcw zzcwVar3 = new zzcw();
        zzcwVar3.zza(3);
        zzd = builder3.withProperty(zzcwVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("autoManageModelOnBackground");
        zzcw zzcwVar4 = new zzcw();
        zzcwVar4.zza(4);
        zze = builder4.withProperty(zzcwVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("autoManageModelOnLowMemory");
        zzcw zzcwVar5 = new zzcw();
        zzcwVar5.zza(5);
        zzf = builder5.withProperty(zzcwVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("isNnApiEnabled");
        zzcw zzcwVar6 = new zzcw();
        zzcwVar6.zza(6);
        zzg = builder6.withProperty(zzcwVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("eventsCount");
        zzcw zzcwVar7 = new zzcw();
        zzcwVar7.zza(7);
        zzh = builder7.withProperty(zzcwVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("otherErrors");
        zzcw zzcwVar8 = new zzcw();
        zzcwVar8.zza(8);
        zzi = builder8.withProperty(zzcwVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("remoteConfigValueForAcceleration");
        zzcw zzcwVar9 = new zzcw();
        zzcwVar9.zza(9);
        zzj = builder9.withProperty(zzcwVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isAccelerated");
        zzcw zzcwVar10 = new zzcw();
        zzcwVar10.zza(10);
        zzk = builder10.withProperty(zzcwVar10.zzb()).build();
    }

    private zzhq() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzmo zzmoVar = (zzmo) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzmoVar.zze());
        objectEncoderContext2.add(zzc, zzmoVar.zza());
        objectEncoderContext2.add(zzd, zzmoVar.zzd());
        objectEncoderContext2.add(zze, zzmoVar.zzb());
        objectEncoderContext2.add(zzf, zzmoVar.zzc());
        objectEncoderContext2.add(zzg, (Object) null);
        objectEncoderContext2.add(zzh, (Object) null);
        objectEncoderContext2.add(zzi, (Object) null);
        objectEncoderContext2.add(zzj, (Object) null);
        objectEncoderContext2.add(zzk, (Object) null);
    }
}
