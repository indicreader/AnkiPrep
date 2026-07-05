package org.jsoup.helper;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.internal.ControllableInputStream;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.XmlDeclaration;
import org.jsoup.parser.Parser;

/* loaded from: classes4.dex */
public final class DataUtil {
    public static final Charset UTF_8;
    static final int boundaryLength = 32;
    private static final Pattern charsetPattern = Pattern.compile("(?i)\\bcharset=\\s*(?:[\"'])?([^\\s,;\"']*)");
    static final String defaultCharsetName;
    private static final int firstReadBufferSize = 5120;
    private static final char[] mimeBoundaryChars;

    static {
        Charset forName = Charset.forName("UTF-8");
        UTF_8 = forName;
        defaultCharsetName = forName.name();
        mimeBoundaryChars = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    private DataUtil() {
    }

    public static Document load(File file, String str, String str2) throws IOException {
        return load(file, str, str2, Parser.htmlParser());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.jsoup.nodes.Document load(java.io.File r3, java.lang.String r4, java.lang.String r5, org.jsoup.parser.Parser r6) throws java.io.IOException {
        /*
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r3)
            java.lang.String r1 = r3.getName()
            java.lang.String r1 = org.jsoup.internal.Normalizer.lowerCase(r1)
            java.lang.String r2 = ".gz"
            boolean r2 = r1.endsWith(r2)
            if (r2 != 0) goto L1d
            java.lang.String r2 = ".z"
            boolean r1 = r1.endsWith(r2)
            if (r1 == 0) goto L45
        L1d:
            int r1 = r0.read()     // Catch: java.lang.Throwable -> L4a
            r2 = 31
            if (r1 != r2) goto L2f
            int r1 = r0.read()     // Catch: java.lang.Throwable -> L4a
            r2 = 139(0x8b, float:1.95E-43)
            if (r1 != r2) goto L2f
            r1 = 1
            goto L30
        L2f:
            r1 = 0
        L30:
            r0.close()
            if (r1 == 0) goto L40
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream
            java.io.FileInputStream r1 = new java.io.FileInputStream
            r1.<init>(r3)
            r0.<init>(r1)
            goto L45
        L40:
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r3)
        L45:
            org.jsoup.nodes.Document r3 = parseInputStream(r0, r4, r5, r6)
            return r3
        L4a:
            r3 = move-exception
            r0.close()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.DataUtil.load(java.io.File, java.lang.String, java.lang.String, org.jsoup.parser.Parser):org.jsoup.nodes.Document");
    }

    public static Document load(InputStream inputStream, String str, String str2) throws IOException {
        return parseInputStream(inputStream, str, str2, Parser.htmlParser());
    }

    public static Document load(InputStream inputStream, String str, String str2, Parser parser) throws IOException {
        return parseInputStream(inputStream, str, str2, parser);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void crossStreams(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[32768];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Document parseInputStream(InputStream inputStream, String str, String str2, Parser parser) throws IOException {
        Document parseInput;
        XmlDeclaration xmlDeclaration;
        if (inputStream == null) {
            return new Document(str2);
        }
        ControllableInputStream wrap = ControllableInputStream.wrap(inputStream, 32768, 0);
        try {
            wrap.mark(32768);
            ByteBuffer readToByteBuffer = readToByteBuffer(wrap, 5119);
            boolean z = wrap.read() == -1;
            wrap.reset();
            BomCharset detectCharsetFromBom = detectCharsetFromBom(readToByteBuffer);
            if (detectCharsetFromBom != null) {
                str = detectCharsetFromBom.charset;
            }
            Document document = null;
            if (str == null) {
                try {
                    CharBuffer decode = UTF_8.decode(readToByteBuffer);
                    if (decode.hasArray()) {
                        parseInput = parser.parseInput(new CharArrayReader(decode.array(), decode.arrayOffset(), decode.limit()), str2);
                    } else {
                        parseInput = parser.parseInput(decode.toString(), str2);
                    }
                    Iterator<Element> it = parseInput.select("meta[http-equiv=content-type], meta[charset]").iterator();
                    String str3 = null;
                    while (it.hasNext()) {
                        Element next = it.next();
                        if (next.hasAttr("http-equiv")) {
                            str3 = getCharsetFromContentType(next.attr("content"));
                        }
                        if (str3 == null && next.hasAttr("charset")) {
                            str3 = next.attr("charset");
                        }
                        if (str3 != null) {
                            break;
                        }
                    }
                    if (str3 == null && parseInput.childNodeSize() > 0) {
                        Node childNode = parseInput.childNode(0);
                        if (childNode instanceof XmlDeclaration) {
                            xmlDeclaration = (XmlDeclaration) childNode;
                        } else {
                            if (childNode instanceof Comment) {
                                Comment comment = (Comment) childNode;
                                if (comment.isXmlDeclaration()) {
                                    xmlDeclaration = comment.asXmlDeclaration();
                                }
                            }
                            xmlDeclaration = null;
                        }
                        if (xmlDeclaration != null && xmlDeclaration.name().equalsIgnoreCase("xml")) {
                            str3 = xmlDeclaration.attr("encoding");
                        }
                    }
                    String validateCharset = validateCharset(str3);
                    if (validateCharset != null && !validateCharset.equalsIgnoreCase(defaultCharsetName)) {
                        str = validateCharset.trim().replaceAll("[\"']", "");
                    } else if (z) {
                        document = parseInput;
                    }
                } catch (UncheckedIOException e) {
                    throw e.getCause();
                }
            } else {
                Validate.notEmpty(str, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
            }
            if (document == null) {
                if (str == null) {
                    str = defaultCharsetName;
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(wrap, Charset.forName(str)), 32768);
                if (detectCharsetFromBom != null) {
                    try {
                        if (detectCharsetFromBom.offset) {
                            Validate.isTrue(bufferedReader.skip(1L) == 1);
                        }
                    } finally {
                        bufferedReader.close();
                    }
                }
                try {
                    document = parser.parseInput(bufferedReader, str2);
                    Charset forName = str.equals(defaultCharsetName) ? UTF_8 : Charset.forName(str);
                    document.outputSettings().charset(forName);
                    if (!forName.canEncode()) {
                        document.charset(UTF_8);
                    }
                } catch (UncheckedIOException e2) {
                    throw e2.getCause();
                }
            }
            return document;
        } finally {
            wrap.close();
        }
    }

    public static ByteBuffer readToByteBuffer(InputStream inputStream, int i) throws IOException {
        return ControllableInputStream.readToByteBuffer(inputStream, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer emptyByteBuffer() {
        return ByteBuffer.allocate(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getCharsetFromContentType(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = charsetPattern.matcher(str);
        if (matcher.find()) {
            return validateCharset(matcher.group(1).trim().replace("charset=", ""));
        }
        return null;
    }

    private static String validateCharset(String str) {
        if (str != null && str.length() != 0) {
            String replaceAll = str.trim().replaceAll("[\"']", "");
            try {
                if (Charset.isSupported(replaceAll)) {
                    return replaceAll;
                }
                String upperCase = replaceAll.toUpperCase(Locale.ENGLISH);
                if (Charset.isSupported(upperCase)) {
                    return upperCase;
                }
            } catch (IllegalCharsetNameException unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String mimeBoundary() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            char[] cArr = mimeBoundaryChars;
            borrowBuilder.append(cArr[random.nextInt(cArr.length)]);
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    private static BomCharset detectCharsetFromBom(ByteBuffer byteBuffer) {
        byteBuffer.mark();
        byte[] bArr = new byte[4];
        if (byteBuffer.remaining() >= 4) {
            byteBuffer.get(bArr);
            byteBuffer.rewind();
        }
        byte b = bArr[0];
        if ((b == 0 && bArr[1] == 0 && bArr[2] == -2 && bArr[3] == -1) || (b == -1 && bArr[1] == -2 && bArr[2] == 0 && bArr[3] == 0)) {
            return new BomCharset("UTF-32", false);
        }
        if ((b == -2 && bArr[1] == -1) || (b == -1 && bArr[1] == -2)) {
            return new BomCharset("UTF-16", false);
        }
        if (b == -17 && bArr[1] == -69 && bArr[2] == -65) {
            return new BomCharset("UTF-8", true);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class BomCharset {
        private final String charset;
        private final boolean offset;

        public BomCharset(String str, boolean z) {
            this.charset = str;
            this.offset = z;
        }
    }
}
