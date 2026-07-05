package com.google.mlkit.common.sdkinternal.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzj;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.LocalModel;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes4.dex */
public class LocalModelLoader {
    private MappedByteBuffer zza;
    private final Context zzb;
    private final LocalModel zzc;

    public LocalModelLoader(Context context, LocalModel localModel) {
        this.zzb = context;
        this.zzc = localModel;
    }

    public LocalModel getLocalModel() {
        return this.zzc;
    }

    public MappedByteBuffer load() throws MlKitException {
        FileChannel channel;
        Preconditions.checkNotNull(this.zzb, "Context can not be null");
        Preconditions.checkNotNull(this.zzc, "Model source can not be null");
        MappedByteBuffer mappedByteBuffer = this.zza;
        if (mappedByteBuffer != null) {
            return mappedByteBuffer;
        }
        String absoluteFilePath = this.zzc.getAbsoluteFilePath();
        String assetFilePath = this.zzc.getAssetFilePath();
        Uri uri = this.zzc.getUri();
        if (absoluteFilePath != null) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(absoluteFilePath, "r");
                try {
                    FileChannel channel2 = randomAccessFile.getChannel();
                    try {
                        this.zza = channel2.map(FileChannel.MapMode.READ_ONLY, 0L, channel2.size());
                        if (channel2 != null) {
                            channel2.close();
                        }
                        randomAccessFile.close();
                        return this.zza;
                    } finally {
                    }
                } finally {
                }
            } catch (IOException e) {
                throw new MlKitException("Can not open the local file: ".concat(String.valueOf(this.zzc.getAbsoluteFilePath())), 14, e);
            }
        }
        if (assetFilePath != null) {
            try {
                AssetFileDescriptor openFd = this.zzb.getAssets().openFd(assetFilePath);
                try {
                    channel = new FileInputStream(openFd.getFileDescriptor()).getChannel();
                    try {
                        this.zza = channel.map(FileChannel.MapMode.READ_ONLY, openFd.getStartOffset(), openFd.getDeclaredLength());
                        if (channel != null) {
                            channel.close();
                        }
                        if (openFd != null) {
                            openFd.close();
                        }
                        return this.zza;
                    } finally {
                    }
                } finally {
                }
            } catch (IOException e2) {
                throw new MlKitException("Can not load the file from asset: " + assetFilePath + ". Please double check your asset file name and ensure it's not compressed. See documentation for details how to use aaptOptions to skip file compression", 14, e2);
            }
        }
        if (uri != null) {
            try {
                AssetFileDescriptor zza = zzj.zza(this.zzb, uri, "r");
                try {
                    channel = zza.createInputStream().getChannel();
                    try {
                        this.zza = channel.map(FileChannel.MapMode.READ_ONLY, zza.getStartOffset(), zza.getLength());
                        if (channel != null) {
                            channel.close();
                        }
                        if (zza != null) {
                            zza.close();
                        }
                        return this.zza;
                    } finally {
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (Throwable th) {
                                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th);
                            }
                        }
                    }
                } finally {
                }
            } catch (IOException e3) {
                throw new MlKitException("Can not load the file from URI: ".concat(uri.toString()), 14, e3);
            }
        }
        throw new MlKitException("Can not load the model. One of filePath, assetFilePath or URI must be set for the model.", 14);
    }
}
