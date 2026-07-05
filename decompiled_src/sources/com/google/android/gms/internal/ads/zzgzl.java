package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public enum zzgzl {
    DOUBLE(0, 1, zzhai.DOUBLE),
    FLOAT(1, 1, zzhai.FLOAT),
    INT64(2, 1, zzhai.LONG),
    UINT64(3, 1, zzhai.LONG),
    INT32(4, 1, zzhai.INT),
    FIXED64(5, 1, zzhai.LONG),
    FIXED32(6, 1, zzhai.INT),
    BOOL(7, 1, zzhai.BOOLEAN),
    STRING(8, 1, zzhai.STRING),
    MESSAGE(9, 1, zzhai.MESSAGE),
    BYTES(10, 1, zzhai.BYTE_STRING),
    UINT32(11, 1, zzhai.INT),
    ENUM(12, 1, zzhai.ENUM),
    SFIXED32(13, 1, zzhai.INT),
    SFIXED64(14, 1, zzhai.LONG),
    SINT32(15, 1, zzhai.INT),
    SINT64(16, 1, zzhai.LONG),
    GROUP(17, 1, zzhai.MESSAGE),
    DOUBLE_LIST(18, 2, zzhai.DOUBLE),
    FLOAT_LIST(19, 2, zzhai.FLOAT),
    INT64_LIST(20, 2, zzhai.LONG),
    UINT64_LIST(21, 2, zzhai.LONG),
    INT32_LIST(22, 2, zzhai.INT),
    FIXED64_LIST(23, 2, zzhai.LONG),
    FIXED32_LIST(24, 2, zzhai.INT),
    BOOL_LIST(25, 2, zzhai.BOOLEAN),
    STRING_LIST(26, 2, zzhai.STRING),
    MESSAGE_LIST(27, 2, zzhai.MESSAGE),
    BYTES_LIST(28, 2, zzhai.BYTE_STRING),
    UINT32_LIST(29, 2, zzhai.INT),
    ENUM_LIST(30, 2, zzhai.ENUM),
    SFIXED32_LIST(31, 2, zzhai.INT),
    SFIXED64_LIST(32, 2, zzhai.LONG),
    SINT32_LIST(33, 2, zzhai.INT),
    SINT64_LIST(34, 2, zzhai.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzhai.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzhai.FLOAT),
    INT64_LIST_PACKED(37, 3, zzhai.LONG),
    UINT64_LIST_PACKED(38, 3, zzhai.LONG),
    INT32_LIST_PACKED(39, 3, zzhai.INT),
    FIXED64_LIST_PACKED(40, 3, zzhai.LONG),
    FIXED32_LIST_PACKED(41, 3, zzhai.INT),
    BOOL_LIST_PACKED(42, 3, zzhai.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzhai.INT),
    ENUM_LIST_PACKED(44, 3, zzhai.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzhai.INT),
    SFIXED64_LIST_PACKED(46, 3, zzhai.LONG),
    SINT32_LIST_PACKED(47, 3, zzhai.INT),
    SINT64_LIST_PACKED(48, 3, zzhai.LONG),
    GROUP_LIST(49, 2, zzhai.MESSAGE),
    MAP(50, 4, zzhai.VOID);

    private static final zzgzl[] zzZ;
    private final zzhai zzab;
    private final int zzac;
    private final Class zzad;

    static {
        zzgzl[] values = values();
        zzZ = new zzgzl[values.length];
        for (zzgzl zzgzlVar : values) {
            zzZ[zzgzlVar.zzac] = zzgzlVar;
        }
    }

    zzgzl(int i, int i2, zzhai zzhaiVar) {
        this.zzac = i;
        this.zzab = zzhaiVar;
        int i3 = i2 - 1;
        if (i3 == 1) {
            this.zzad = zzhaiVar.zza();
        } else if (i3 != 3) {
            this.zzad = null;
        } else {
            this.zzad = zzhaiVar.zza();
        }
        if (i2 == 1) {
            zzhai zzhaiVar2 = zzhai.VOID;
            zzhaiVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzac;
    }
}
