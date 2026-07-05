package com.google.android.gms.internal.ads;

import androidx.core.view.ViewCompat;
import coil.util.Utils;
import com.google.common.net.HttpHeaders;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzajd {
    static final String[] zza = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    public static final /* synthetic */ int zzb = 0;

    public static zzbx zza(zzfp zzfpVar) {
        String str;
        zzbx zzagcVar;
        int zzd = zzfpVar.zzd() + zzfpVar.zzg();
        int zzg = zzfpVar.zzg();
        int i = (zzg >> 24) & 255;
        zzbx zzbxVar = null;
        try {
            if (i == 169 || i == 253) {
                int i2 = zzg & ViewCompat.MEASURED_SIZE_MASK;
                if (i2 == 6516084) {
                    int zzg2 = zzfpVar.zzg();
                    if (zzfpVar.zzg() == 1684108385) {
                        zzfpVar.zzL(8);
                        String zzz = zzfpVar.zzz(zzg2 - 16);
                        zzbxVar = new zzagk("und", zzz, zzz);
                    } else {
                        zzff.zzf("MetadataUtil", "Failed to parse comment attribute: ".concat(zzaio.zzf(zzg)));
                    }
                } else {
                    if (i2 != 7233901 && i2 != 7631467) {
                        if (i2 != 6516589 && i2 != 7828084) {
                            if (i2 == 6578553) {
                                zzbxVar = zze(zzg, "TDRC", zzfpVar);
                            } else if (i2 == 4280916) {
                                zzbxVar = zze(zzg, "TPE1", zzfpVar);
                            } else if (i2 == 7630703) {
                                zzbxVar = zze(zzg, "TSSE", zzfpVar);
                            } else if (i2 == 6384738) {
                                zzbxVar = zze(zzg, "TALB", zzfpVar);
                            } else if (i2 == 7108978) {
                                zzbxVar = zze(zzg, "USLT", zzfpVar);
                            } else if (i2 == 6776174) {
                                zzbxVar = zze(zzg, "TCON", zzfpVar);
                            } else {
                                if (i2 == 6779504) {
                                    zzbxVar = zze(zzg, "TIT1", zzfpVar);
                                }
                                zzff.zzb("MetadataUtil", "Skipped unknown metadata entry: " + zzaio.zzf(zzg));
                            }
                        }
                        zzbxVar = zze(zzg, "TCOM", zzfpVar);
                    }
                    zzbxVar = zze(zzg, "TIT2", zzfpVar);
                }
            } else if (zzg == 1735291493) {
                int zzb2 = zzb(zzfpVar);
                String str2 = (zzb2 <= 0 || zzb2 > 192) ? null : zza[zzb2 - 1];
                if (str2 != null) {
                    zzagcVar = new zzagz("TCON", null, zzgaa.zzm(str2));
                    zzbxVar = zzagcVar;
                } else {
                    zzff.zzf("MetadataUtil", "Failed to parse standard genre code");
                }
            } else if (zzg == 1684632427) {
                zzbxVar = zzd(1684632427, "TPOS", zzfpVar);
            } else if (zzg == 1953655662) {
                zzbxVar = zzd(1953655662, "TRCK", zzfpVar);
            } else if (zzg == 1953329263) {
                zzbxVar = zzc(1953329263, "TBPM", zzfpVar, true, false);
            } else if (zzg == 1668311404) {
                zzbxVar = zzc(1668311404, "TCMP", zzfpVar, true, true);
            } else if (zzg == 1668249202) {
                int zzg3 = zzfpVar.zzg();
                if (zzfpVar.zzg() == 1684108385) {
                    int zzg4 = zzfpVar.zzg() & ViewCompat.MEASURED_SIZE_MASK;
                    if (zzg4 == 13) {
                        str = Utils.MIME_TYPE_JPEG;
                    } else if (zzg4 == 14) {
                        str = "image/png";
                        zzg4 = 14;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        zzff.zzf("MetadataUtil", "Unrecognized cover art flags: " + zzg4);
                    } else {
                        zzfpVar.zzL(4);
                        int i3 = zzg3 - 16;
                        byte[] bArr = new byte[i3];
                        zzfpVar.zzG(bArr, 0, i3);
                        zzagcVar = new zzagc(str, null, 3, bArr);
                        zzbxVar = zzagcVar;
                    }
                } else {
                    zzff.zzf("MetadataUtil", "Failed to parse cover art attribute");
                }
            } else if (zzg == 1631670868) {
                zzbxVar = zze(1631670868, "TPE2", zzfpVar);
            } else if (zzg == 1936682605) {
                zzbxVar = zze(1936682605, "TSOT", zzfpVar);
            } else if (zzg == 1936679276) {
                zzbxVar = zze(1936679276, "TSO2", zzfpVar);
            } else if (zzg == 1936679282) {
                zzbxVar = zze(1936679282, "TSOA", zzfpVar);
            } else if (zzg == 1936679265) {
                zzbxVar = zze(1936679265, "TSOP", zzfpVar);
            } else if (zzg == 1936679791) {
                zzbxVar = zze(1936679791, "TSOC", zzfpVar);
            } else if (zzg == 1920233063) {
                zzbxVar = zzc(1920233063, "ITUNESADVISORY", zzfpVar, false, false);
            } else if (zzg == 1885823344) {
                zzbxVar = zzc(1885823344, "ITUNESGAPLESS", zzfpVar, false, true);
            } else if (zzg == 1936683886) {
                zzbxVar = zze(1936683886, "TVSHOWSORT", zzfpVar);
            } else if (zzg == 1953919848) {
                zzbxVar = zze(1953919848, "TVSHOW", zzfpVar);
            } else {
                if (zzg == 757935405) {
                    int i4 = -1;
                    int i5 = -1;
                    String str3 = null;
                    String str4 = null;
                    while (zzfpVar.zzd() < zzd) {
                        int zzd2 = zzfpVar.zzd();
                        int zzg5 = zzfpVar.zzg();
                        int zzg6 = zzfpVar.zzg();
                        zzfpVar.zzL(4);
                        if (zzg6 == 1835360622) {
                            str3 = zzfpVar.zzz(zzg5 - 12);
                        } else {
                            int i6 = zzg5 - 12;
                            if (zzg6 == 1851878757) {
                                str4 = zzfpVar.zzz(i6);
                            } else {
                                if (zzg6 == 1684108385) {
                                    i5 = zzg5;
                                }
                                if (zzg6 == 1684108385) {
                                    i4 = zzd2;
                                }
                                zzfpVar.zzL(i6);
                            }
                        }
                    }
                    if (str3 != null && str4 != null && i4 != -1) {
                        zzfpVar.zzK(i4);
                        zzfpVar.zzL(16);
                        zzbxVar = new zzagt(str3, str4, zzfpVar.zzz(i5 - 16));
                    }
                }
                zzff.zzb("MetadataUtil", "Skipped unknown metadata entry: " + zzaio.zzf(zzg));
            }
            return zzbxVar;
        } finally {
            zzfpVar.zzK(zzd);
        }
    }

    private static int zzb(zzfp zzfpVar) {
        zzfpVar.zzL(4);
        if (zzfpVar.zzg() == 1684108385) {
            zzfpVar.zzL(8);
            return zzfpVar.zzm();
        }
        zzff.zzf("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    private static zzagr zzc(int i, String str, zzfp zzfpVar, boolean z, boolean z2) {
        int zzb2 = zzb(zzfpVar);
        if (z2) {
            zzb2 = Math.min(1, zzb2);
        }
        if (zzb2 < 0) {
            zzff.zzf("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzaio.zzf(i)));
            return null;
        }
        if (z) {
            return new zzagz(str, null, zzgaa.zzm(Integer.toString(zzb2)));
        }
        return new zzagk("und", str, Integer.toString(zzb2));
    }

    private static zzagz zzd(int i, String str, zzfp zzfpVar) {
        int zzg = zzfpVar.zzg();
        if (zzfpVar.zzg() == 1684108385 && zzg >= 22) {
            zzfpVar.zzL(10);
            int zzq = zzfpVar.zzq();
            if (zzq > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(zzq);
                String sb2 = sb.toString();
                int zzq2 = zzfpVar.zzq();
                if (zzq2 > 0) {
                    sb2 = sb2 + "/" + zzq2;
                }
                return new zzagz(str, null, zzgaa.zzm(sb2));
            }
        }
        zzff.zzf("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzaio.zzf(i)));
        return null;
    }

    private static zzagz zze(int i, String str, zzfp zzfpVar) {
        int zzg = zzfpVar.zzg();
        if (zzfpVar.zzg() == 1684108385) {
            zzfpVar.zzL(8);
            return new zzagz(str, null, zzgaa.zzm(zzfpVar.zzz(zzg - 16)));
        }
        zzff.zzf("MetadataUtil", "Failed to parse text attribute: ".concat(zzaio.zzf(i)));
        return null;
    }
}
