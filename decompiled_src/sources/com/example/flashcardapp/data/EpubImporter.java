package com.example.flashcardapp.data;

import android.content.Context;
import android.net.Uri;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: EpubImporter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\nH\u0002J6\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0086@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/example/flashcardapp/data/EpubImporter;", "", "()V", "BATCH_SIZE", "", "TAG", "", "extractSpineHtml", "", "epubBytes", "", "importEpub", "Lcom/example/flashcardapp/data/ImportResult;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "targetDeckId", "", "targetDeckName", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/Long;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class EpubImporter {
    public static final int $stable = 0;
    private static final int BATCH_SIZE = 200;
    public static final EpubImporter INSTANCE = new EpubImporter();
    private static final String TAG = "EpubImporter";

    private EpubImporter() {
    }

    public final Object importEpub(Context context, Uri uri, Long l, String str, Continuation<? super ImportResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new EpubImporter$importEpub$2(context, uri, str, l, null), continuation);
    }

    public final List<String> extractSpineHtml(byte[] epubBytes) {
        String str;
        byte[] bArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(epubBytes));
        try {
            ZipInputStream zipInputStream2 = zipInputStream;
            while (true) {
                ZipEntry nextEntry = zipInputStream2.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
                Intrinsics.checkNotNull(nextEntry);
                if (!nextEntry.isDirectory()) {
                    String name = nextEntry.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    linkedHashMap.put(name, ByteStreamsKt.readBytes(zipInputStream2));
                }
                zipInputStream2.closeEntry();
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(zipInputStream, null);
            byte[] bArr2 = (byte[]) linkedHashMap.get("META-INF/container.xml");
            if (bArr2 == null) {
                return CollectionsKt.emptyList();
            }
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            NodeList elementsByTagName = newDocumentBuilder.parse(new ByteArrayInputStream(bArr2)).getElementsByTagName("rootfile");
            if (elementsByTagName.getLength() > 0) {
                Node item = elementsByTagName.item(0);
                Intrinsics.checkNotNull(item, "null cannot be cast to non-null type org.w3c.dom.Element");
                str = ((Element) item).getAttribute("full-path");
            } else {
                str = null;
            }
            if (str == null || !linkedHashMap.containsKey(str)) {
                return CollectionsKt.emptyList();
            }
            byte[] bArr3 = (byte[]) linkedHashMap.get(str);
            if (bArr3 == null) {
                return CollectionsKt.emptyList();
            }
            Document parse = newDocumentBuilder.parse(new ByteArrayInputStream(bArr3));
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            NodeList elementsByTagName2 = parse.getElementsByTagName("item");
            int length = elementsByTagName2.getLength();
            for (int i = 0; i < length; i++) {
                Node item2 = elementsByTagName2.item(i);
                Intrinsics.checkNotNull(item2, "null cannot be cast to non-null type org.w3c.dom.Element");
                Element element = (Element) item2;
                String attribute = element.getAttribute("id");
                Intrinsics.checkNotNullExpressionValue(attribute, "getAttribute(...)");
                String attribute2 = element.getAttribute("href");
                Intrinsics.checkNotNullExpressionValue(attribute2, "getAttribute(...)");
                linkedHashMap2.put(attribute, attribute2);
            }
            ArrayList arrayList = new ArrayList();
            NodeList elementsByTagName3 = parse.getElementsByTagName("itemref");
            int length2 = elementsByTagName3.getLength();
            for (int i2 = 0; i2 < length2; i2++) {
                Node item3 = elementsByTagName3.item(i2);
                Intrinsics.checkNotNull(item3, "null cannot be cast to non-null type org.w3c.dom.Element");
                String attribute3 = ((Element) item3).getAttribute("idref");
                Intrinsics.checkNotNullExpressionValue(attribute3, "getAttribute(...)");
                arrayList.add(attribute3);
            }
            String str2 = StringsKt.contains$default((CharSequence) str, (CharSequence) "/", false, 2, (Object) null) ? StringsKt.substringBeforeLast$default(str, "/", (String) null, 2, (Object) null) + "/" : "";
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str3 = (String) linkedHashMap2.get((String) it.next());
                if (str3 != null && (bArr = (byte[]) linkedHashMap.get(str2 + str3)) != null) {
                    arrayList2.add(new String(bArr, Charsets.UTF_8));
                }
            }
            return arrayList2;
        } finally {
        }
    }
}
