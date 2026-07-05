package org.jsoup.parser;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;

/* loaded from: classes4.dex */
public class Tag implements Cloneable {
    private static final Map<String, Tag> Tags = new HashMap();
    private static final String[] blockTags;
    private static final String[] emptyTags;
    private static final String[] formListedTags;
    private static final String[] formSubmitTags;
    private static final String[] formatAsInlineTags;
    private static final String[] inlineTags;
    private static final Map<String, String[]> namespaces;
    private static final String[] preserveWhitespaceTags;
    private String namespace;
    private final String normalName;
    private String tagName;
    private boolean isBlock = true;
    private boolean formatAsBlock = true;
    private boolean empty = false;
    private boolean selfClosing = false;
    private boolean preserveWhitespace = false;
    private boolean formList = false;
    private boolean formSubmit = false;

    public boolean formatAsBlock() {
        return this.formatAsBlock;
    }

    public String getName() {
        return this.tagName;
    }

    public boolean isBlock() {
        return this.isBlock;
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public boolean isFormListed() {
        return this.formList;
    }

    public boolean isFormSubmittable() {
        return this.formSubmit;
    }

    public boolean isInline() {
        return !this.isBlock;
    }

    public boolean isSelfClosing() {
        return this.empty || this.selfClosing;
    }

    public String namespace() {
        return this.namespace;
    }

    public String normalName() {
        return this.normalName;
    }

    public boolean preserveWhitespace() {
        return this.preserveWhitespace;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tag setSelfClosing() {
        this.selfClosing = true;
        return this;
    }

    public String toString() {
        return this.tagName;
    }

    static {
        String[] strArr = {"html", "head", "body", "frameset", "script", "noscript", "style", "meta", "link", "title", "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", "audio", "canvas", "details", "menu", "plaintext", "template", "article", "main", "svg", "math", "center", "template", "dir", "applet", "marquee", "listing"};
        blockTags = strArr;
        String[] strArr2 = {"object", "base", "font", "tt", "i", "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "rtc", "a", "img", "br", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", NotificationCompat.CATEGORY_PROGRESS, "meter", "area", "param", "source", "track", "summary", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track", "data", "bdi", "s", "strike", "nobr", "rb", "text", "mi", "mo", "msup", "mn", "mtext"};
        inlineTags = strArr2;
        String[] strArr3 = {"meta", "link", "base", "frame", "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track"};
        emptyTags = strArr3;
        String[] strArr4 = {"title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", "style", "ins", "del", "s"};
        formatAsInlineTags = strArr4;
        String[] strArr5 = {"pre", "plaintext", "title", "textarea"};
        preserveWhitespaceTags = strArr5;
        String[] strArr6 = {"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"};
        formListedTags = strArr6;
        String[] strArr7 = {"input", "keygen", "object", "select", "textarea"};
        formSubmitTags = strArr7;
        HashMap hashMap = new HashMap();
        namespaces = hashMap;
        hashMap.put(Parser.NamespaceMathml, new String[]{"math", "mi", "mo", "msup", "mn", "mtext"});
        hashMap.put(Parser.NamespaceSvg, new String[]{"svg", "text"});
        setupTags(strArr, new Consumer() { // from class: org.jsoup.parser.Tag$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Tag.lambda$static$0((Tag) obj);
            }
        });
        setupTags(strArr2, new Consumer() { // from class: org.jsoup.parser.Tag$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Tag.lambda$static$1((Tag) obj);
            }
        });
        setupTags(strArr3, new Consumer() { // from class: org.jsoup.parser.Tag$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Tag) obj).empty = true;
            }
        });
        setupTags(strArr4, new Consumer() { // from class: org.jsoup.parser.Tag$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Tag) obj).formatAsBlock = false;
            }
        });
        setupTags(strArr5, new Consumer() { // from class: org.jsoup.parser.Tag$$ExternalSyntheticLambda4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Tag) obj).preserveWhitespace = true;
            }
        });
        setupTags(strArr6, new Consumer() { // from class: org.jsoup.parser.Tag$$ExternalSyntheticLambda5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Tag) obj).formList = true;
            }
        });
        setupTags(strArr7, new Consumer() { // from class: org.jsoup.parser.Tag$$ExternalSyntheticLambda6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Tag) obj).formSubmit = true;
            }
        });
        for (final Map.Entry entry : hashMap.entrySet()) {
            setupTags((String[]) entry.getValue(), new Consumer() { // from class: org.jsoup.parser.Tag$$ExternalSyntheticLambda7
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((Tag) obj).namespace = (String) entry.getKey();
                }
            });
        }
    }

    private Tag(String str, String str2) {
        this.tagName = str;
        this.normalName = Normalizer.lowerCase(str);
        this.namespace = str2;
    }

    public static Tag valueOf(String str, String str2, ParseSettings parseSettings) {
        Validate.notEmpty(str);
        Validate.notNull(str2);
        Map<String, Tag> map = Tags;
        Tag tag = map.get(str);
        if (tag != null && tag.namespace.equals(str2)) {
            return tag;
        }
        String normalizeTag = parseSettings.normalizeTag(str);
        Validate.notEmpty(normalizeTag);
        String lowerCase = Normalizer.lowerCase(normalizeTag);
        Tag tag2 = map.get(lowerCase);
        if (tag2 != null && tag2.namespace.equals(str2)) {
            if (!parseSettings.preserveTagCase() || normalizeTag.equals(lowerCase)) {
                return tag2;
            }
            Tag clone = tag2.clone();
            clone.tagName = normalizeTag;
            return clone;
        }
        Tag tag3 = new Tag(normalizeTag, str2);
        tag3.isBlock = false;
        return tag3;
    }

    public static Tag valueOf(String str) {
        return valueOf(str, Parser.NamespaceHtml, ParseSettings.preserveCase);
    }

    public static Tag valueOf(String str, ParseSettings parseSettings) {
        return valueOf(str, Parser.NamespaceHtml, parseSettings);
    }

    public boolean isKnownTag() {
        return Tags.containsKey(this.tagName);
    }

    public static boolean isKnownTag(String str) {
        return Tags.containsKey(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        return this.tagName.equals(tag.tagName) && this.empty == tag.empty && this.formatAsBlock == tag.formatAsBlock && this.isBlock == tag.isBlock && this.preserveWhitespace == tag.preserveWhitespace && this.selfClosing == tag.selfClosing && this.formList == tag.formList && this.formSubmit == tag.formSubmit;
    }

    public int hashCode() {
        return (((((((((((((this.tagName.hashCode() * 31) + (this.isBlock ? 1 : 0)) * 31) + (this.formatAsBlock ? 1 : 0)) * 31) + (this.empty ? 1 : 0)) * 31) + (this.selfClosing ? 1 : 0)) * 31) + (this.preserveWhitespace ? 1 : 0)) * 31) + (this.formList ? 1 : 0)) * 31) + (this.formSubmit ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Tag clone() {
        try {
            return (Tag) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void setupTags(String[] strArr, Consumer<Tag> consumer) {
        for (String str : strArr) {
            Map<String, Tag> map = Tags;
            Tag tag = map.get(str);
            if (tag == null) {
                tag = new Tag(str, Parser.NamespaceHtml);
                map.put(tag.tagName, tag);
            }
            consumer.accept(tag);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$static$0(Tag tag) {
        tag.isBlock = true;
        tag.formatAsBlock = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$static$1(Tag tag) {
        tag.isBlock = false;
        tag.formatAsBlock = false;
    }
}
