package org.jsoup.internal;

import androidx.compose.animation.core.AnimationKt;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import org.jsoup.helper.Validate;

/* loaded from: classes4.dex */
public class ControllableInputStream extends FilterInputStream {
    private final BufferedInputStream buff;
    private final boolean capped;
    private boolean interrupted;
    private int markPos;
    private final int maxSize;
    private int remaining;
    private long startTime;
    private long timeout;

    public BufferedInputStream inputStream() {
        return this.buff;
    }

    public ControllableInputStream timeout(long j, long j2) {
        this.startTime = j;
        this.timeout = j2 * AnimationKt.MillisToNanos;
        return this;
    }

    private ControllableInputStream(BufferedInputStream bufferedInputStream, int i) {
        super(bufferedInputStream);
        this.timeout = 0L;
        Validate.isTrue(i >= 0);
        this.buff = bufferedInputStream;
        this.capped = i != 0;
        this.maxSize = i;
        this.remaining = i;
        this.markPos = -1;
        this.startTime = System.nanoTime();
    }

    public static ControllableInputStream wrap(InputStream inputStream, int i, int i2) {
        if (inputStream instanceof ControllableInputStream) {
            return (ControllableInputStream) inputStream;
        }
        if (inputStream instanceof BufferedInputStream) {
            return new ControllableInputStream((BufferedInputStream) inputStream, i2);
        }
        return new ControllableInputStream(new BufferedInputStream(inputStream, i), i2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (this.interrupted || (this.capped && this.remaining <= 0)) {
            return -1;
        }
        if (Thread.currentThread().isInterrupted()) {
            this.interrupted = true;
            return -1;
        }
        if (expired()) {
            throw new SocketTimeoutException("Read timeout");
        }
        if (this.capped && i2 > (i3 = this.remaining)) {
            i2 = i3;
        }
        try {
            int read = super.read(bArr, i, i2);
            this.remaining -= read;
            return read;
        } catch (SocketTimeoutException unused) {
            return 0;
        }
    }

    public static ByteBuffer readToByteBuffer(InputStream inputStream, int i) throws IOException {
        Validate.isTrue(i >= 0, "maxSize must be 0 (unlimited) or larger");
        Validate.notNull(inputStream);
        boolean z = i > 0;
        int i2 = 32768;
        if (z && i < 32768) {
            i2 = i;
        }
        byte[] bArr = new byte[i2];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2);
        while (true) {
            int read = inputStream.read(bArr, 0, z ? Math.min(i, i2) : i2);
            if (read == -1) {
                break;
            }
            if (z) {
                if (read >= i) {
                    byteArrayOutputStream.write(bArr, 0, i);
                    break;
                }
                i -= read;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        this.remaining = this.maxSize - this.markPos;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        super.mark(i);
        this.markPos = this.maxSize - this.remaining;
    }

    private boolean expired() {
        return this.timeout != 0 && System.nanoTime() - this.startTime > this.timeout;
    }
}
