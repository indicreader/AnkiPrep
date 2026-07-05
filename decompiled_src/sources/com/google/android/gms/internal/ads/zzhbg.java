package com.google.android.gms.internal.ads;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhbg {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzhbe zzhbeVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzhbeVar, sb, 0);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zzc(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (Character.isUpperCase(charAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(charAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zzhcn.zza(zzgyl.zzw((String) obj)));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof zzgyl) {
            sb.append(": \"");
            sb.append(zzhcn.zza((zzgyl) obj));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof zzgzu) {
            sb.append(" {");
            zzd((zzgzu) obj, sb, i + 2);
            sb.append("\n");
            zzc(i, sb);
            sb.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            int i3 = i + 2;
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            zzb(sb, i3, "key", entry.getKey());
            zzb(sb, i3, AppMeasurementSdk.ConditionalUserProperty.VALUE, entry.getValue());
            sb.append("\n");
            zzc(i, sb);
            sb.append("}");
            return;
        }
        sb.append(": ");
        sb.append(obj);
    }

    private static void zzc(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zza, 0, i2);
            i -= i2;
        }
    }

    private static void zzd(zzhbe zzhbeVar, StringBuilder sb, int i) {
        int i2;
        boolean equals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzhbeVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i3 = 0;
        while (true) {
            i2 = 3;
            if (i3 >= length) {
                break;
            }
            Method method3 = declaredMethods[i3];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i3++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i2);
            if (!substring.endsWith("List") || substring.endsWith("OrBuilderList") || substring.equals("List") || (method2 = (Method) entry.getValue()) == null || !method2.getReturnType().equals(List.class)) {
                if (!substring.endsWith("Map") || substring.equals("Map") || (method = (Method) entry.getValue()) == null || !method.getReturnType().equals(Map.class) || method.isAnnotationPresent(Deprecated.class) || !Modifier.isPublic(method.getModifiers())) {
                    if (hashSet.contains("set".concat(String.valueOf(substring))) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                        Method method4 = (Method) entry.getValue();
                        Method method5 = (Method) hashMap.get("has".concat(String.valueOf(substring)));
                        if (method4 != null) {
                            Object zzaQ = zzgzu.zzaQ(method4, zzhbeVar, new Object[0]);
                            if (method5 == null) {
                                if (zzaQ instanceof Boolean) {
                                    if (!((Boolean) zzaQ).booleanValue()) {
                                    }
                                    zzb(sb, i, substring, zzaQ);
                                } else if (zzaQ instanceof Integer) {
                                    if (((Integer) zzaQ).intValue() == 0) {
                                    }
                                    zzb(sb, i, substring, zzaQ);
                                } else if (zzaQ instanceof Float) {
                                    if (Float.floatToRawIntBits(((Float) zzaQ).floatValue()) == 0) {
                                    }
                                    zzb(sb, i, substring, zzaQ);
                                } else if (!(zzaQ instanceof Double)) {
                                    if (zzaQ instanceof String) {
                                        equals = zzaQ.equals("");
                                    } else if (zzaQ instanceof zzgyl) {
                                        equals = zzaQ.equals(zzgyl.zzb);
                                    } else if (zzaQ instanceof zzhbe) {
                                        if (zzaQ == ((zzhbe) zzaQ).zzbk()) {
                                        }
                                        zzb(sb, i, substring, zzaQ);
                                    } else {
                                        if ((zzaQ instanceof Enum) && ((Enum) zzaQ).ordinal() == 0) {
                                        }
                                        zzb(sb, i, substring, zzaQ);
                                    }
                                    if (equals) {
                                    }
                                    zzb(sb, i, substring, zzaQ);
                                } else {
                                    if (Double.doubleToRawLongBits(((Double) zzaQ).doubleValue()) == 0) {
                                    }
                                    zzb(sb, i, substring, zzaQ);
                                }
                            } else {
                                if (!((Boolean) zzgzu.zzaQ(method5, zzhbeVar, new Object[0])).booleanValue()) {
                                }
                                zzb(sb, i, substring, zzaQ);
                            }
                        }
                    }
                } else {
                    zzb(sb, i, substring.substring(0, substring.length() - 3), zzgzu.zzaQ(method, zzhbeVar, new Object[0]));
                }
            } else {
                zzb(sb, i, substring.substring(0, substring.length() - 4), zzgzu.zzaQ(method2, zzhbeVar, new Object[0]));
            }
            i2 = 3;
        }
        if (!(zzhbeVar instanceof zzgzr)) {
            zzhcq zzhcqVar = ((zzgzu) zzhbeVar).zzc;
            if (zzhcqVar != null) {
                zzhcqVar.zzi(sb, i);
                return;
            }
            return;
        }
        zzgzk zzgzkVar = ((zzgzr) zzhbeVar).zzb;
        throw null;
    }
}
