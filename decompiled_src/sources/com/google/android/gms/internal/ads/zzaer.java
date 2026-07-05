package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzaer implements zzaej {
    public final zzgaa zza;
    private final int zzb;

    private zzaer(int i, zzgaa zzgaaVar) {
        this.zzb = i;
        this.zza = zzgaaVar;
    }

    public static zzaer zzc(int i, zzfp zzfpVar) {
        zzaej zzaesVar;
        String str;
        zzfzx zzfzxVar = new zzfzx();
        int zze = zzfpVar.zze();
        int i2 = -2;
        while (zzfpVar.zzb() > 8) {
            int zzi = zzfpVar.zzi();
            int zzd = zzfpVar.zzd() + zzfpVar.zzi();
            zzfpVar.zzJ(zzd);
            if (zzi != 1414744396) {
                zzaes zzaesVar2 = null;
                switch (zzi) {
                    case 1718776947:
                        if (i2 != 2) {
                            if (i2 == 1) {
                                int zzk = zzfpVar.zzk();
                                String str2 = zzk != 1 ? zzk != 85 ? zzk != 255 ? zzk != 8192 ? zzk != 8193 ? null : "audio/vnd.dts" : "audio/ac3" : "audio/mp4a-latm" : "audio/mpeg" : "audio/raw";
                                if (str2 == null) {
                                    zzff.zzf("StreamFormatChunk", "Ignoring track with unsupported format tag " + zzk);
                                    break;
                                } else {
                                    int zzk2 = zzfpVar.zzk();
                                    int zzi2 = zzfpVar.zzi();
                                    zzfpVar.zzL(6);
                                    int zzk3 = zzfy.zzk(zzfpVar.zzq());
                                    int zzk4 = zzfpVar.zzk();
                                    byte[] bArr = new byte[zzk4];
                                    zzfpVar.zzG(bArr, 0, zzk4);
                                    zzak zzakVar = new zzak();
                                    zzakVar.zzW(str2);
                                    zzakVar.zzy(zzk2);
                                    zzakVar.zzX(zzi2);
                                    if ("audio/raw".equals(str2) && zzk3 != 0) {
                                        zzakVar.zzQ(zzk3);
                                    }
                                    if ("audio/mp4a-latm".equals(str2) && zzk4 > 0) {
                                        zzakVar.zzL(zzgaa.zzm(bArr));
                                    }
                                    zzaesVar = new zzaes(zzakVar.zzac());
                                    break;
                                }
                            } else {
                                zzff.zzf("StreamFormatChunk", "Ignoring strf box for unsupported track type: ".concat(zzfy.zzB(i2)));
                                break;
                            }
                        } else {
                            zzfpVar.zzL(4);
                            int zzi3 = zzfpVar.zzi();
                            int zzi4 = zzfpVar.zzi();
                            zzfpVar.zzL(4);
                            int zzi5 = zzfpVar.zzi();
                            switch (zzi5) {
                                case 808802372:
                                case 877677894:
                                case 1145656883:
                                case 1145656920:
                                case 1482049860:
                                case 1684633208:
                                case 2021026148:
                                    str = "video/mp4v-es";
                                    break;
                                case 826496577:
                                case 828601953:
                                case 875967048:
                                    str = "video/avc";
                                    break;
                                case 842289229:
                                    str = "video/mp42";
                                    break;
                                case 859066445:
                                    str = "video/mp43";
                                    break;
                                case 1196444237:
                                case 1735420525:
                                    str = "video/mjpeg";
                                    break;
                                default:
                                    str = null;
                                    break;
                            }
                            if (str == null) {
                                zzff.zzf("StreamFormatChunk", "Ignoring track with unsupported compression " + zzi5);
                                break;
                            } else {
                                zzak zzakVar2 = new zzak();
                                zzakVar2.zzab(zzi3);
                                zzakVar2.zzI(zzi4);
                                zzakVar2.zzW(str);
                                zzaesVar2 = new zzaes(zzakVar2.zzac());
                                break;
                            }
                        }
                    case 1751742049:
                        zzaesVar = zzaeo.zzb(zzfpVar);
                        break;
                    case 1752331379:
                        zzaesVar = zzaep.zzb(zzfpVar);
                        break;
                    case 1852994675:
                        zzaesVar = zzaet.zzb(zzfpVar);
                        break;
                }
                zzaesVar = zzaesVar2;
            } else {
                zzaesVar = zzc(zzfpVar.zzi(), zzfpVar);
            }
            if (zzaesVar != null) {
                if (zzaesVar.zza() == 1752331379) {
                    int i3 = ((zzaep) zzaesVar).zza;
                    if (i3 == 1935960438) {
                        i2 = 2;
                    } else if (i3 == 1935963489) {
                        i2 = 1;
                    } else if (i3 != 1937012852) {
                        zzff.zzf("AviStreamHeaderChunk", "Found unsupported streamType fourCC: ".concat(String.valueOf(Integer.toHexString(i3))));
                        i2 = -1;
                    } else {
                        i2 = 3;
                    }
                }
                zzfzxVar.zzf(zzaesVar);
            }
            zzfpVar.zzK(zzd);
            zzfpVar.zzJ(zze);
        }
        return new zzaer(i, zzfzxVar.zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzaej
    public final int zza() {
        return this.zzb;
    }

    public final zzaej zzb(Class cls) {
        zzgaa zzgaaVar = this.zza;
        int size = zzgaaVar.size();
        int i = 0;
        while (i < size) {
            zzaej zzaejVar = (zzaej) zzgaaVar.get(i);
            i++;
            if (zzaejVar.getClass() == cls) {
                return zzaejVar;
            }
        }
        return null;
    }
}
