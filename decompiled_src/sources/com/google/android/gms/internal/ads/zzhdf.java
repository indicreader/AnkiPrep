package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public enum zzhdf {
    DOUBLE(zzhdg.DOUBLE, 1),
    FLOAT(zzhdg.FLOAT, 5),
    INT64(zzhdg.LONG, 0),
    UINT64(zzhdg.LONG, 0),
    INT32(zzhdg.INT, 0),
    FIXED64(zzhdg.LONG, 1),
    FIXED32(zzhdg.INT, 5),
    BOOL(zzhdg.BOOLEAN, 0),
    STRING(zzhdg.STRING, 2),
    GROUP(zzhdg.MESSAGE, 3),
    MESSAGE(zzhdg.MESSAGE, 2),
    BYTES(zzhdg.BYTE_STRING, 2),
    UINT32(zzhdg.INT, 0),
    ENUM(zzhdg.ENUM, 0),
    SFIXED32(zzhdg.INT, 5),
    SFIXED64(zzhdg.LONG, 1),
    SINT32(zzhdg.INT, 0),
    SINT64(zzhdg.LONG, 0);

    private final zzhdg zzt;

    zzhdf(zzhdg zzhdgVar, int i) {
        this.zzt = zzhdgVar;
    }

    public final zzhdg zza() {
        return this.zzt;
    }
}
