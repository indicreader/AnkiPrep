package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;

/* loaded from: classes4.dex */
public class TextNode extends LeafNode {
    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#text";
    }

    @Override // org.jsoup.nodes.Node
    void outerHtmlTail(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
    }

    public TextNode(String str) {
        this.value = str;
    }

    public String text() {
        return StringUtil.normaliseWhitespace(getWholeText());
    }

    public TextNode text(String str) {
        coreValue(str);
        return this;
    }

    public String getWholeText() {
        return coreValue();
    }

    public boolean isBlank() {
        return StringUtil.isBlank(coreValue());
    }

    public TextNode splitText(int i) {
        String coreValue = coreValue();
        Validate.isTrue(i >= 0, "Split offset must be not be negative");
        Validate.isTrue(i < coreValue.length(), "Split offset must not be greater than current text length");
        String substring = coreValue.substring(0, i);
        String substring2 = coreValue.substring(i);
        text(substring);
        TextNode textNode = new TextNode(substring2);
        if (this.parentNode != null) {
            this.parentNode.addChildren(siblingIndex() + 1, textNode);
        }
        return textNode;
    }

    @Override // org.jsoup.nodes.Node
    void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        boolean z;
        boolean z2;
        boolean prettyPrint = outputSettings.prettyPrint();
        Element element = this.parentNode instanceof Element ? (Element) this.parentNode : null;
        boolean z3 = prettyPrint && !Element.preserveWhitespace(this.parentNode);
        boolean z4 = element != null && (element.tag().isBlock() || element.tag().formatAsBlock());
        if (z3) {
            boolean z5 = (z4 && this.siblingIndex == 0) || (this.parentNode instanceof Document);
            boolean z6 = z4 && nextSibling() == null;
            Node nextSibling = nextSibling();
            Node previousSibling = previousSibling();
            boolean isBlank = isBlank();
            if ((((nextSibling instanceof Element) && ((Element) nextSibling).shouldIndent(outputSettings)) || (((nextSibling instanceof TextNode) && ((TextNode) nextSibling).isBlank()) || ((previousSibling instanceof Element) && (((Element) previousSibling).isBlock() || previousSibling.nameIs("br"))))) && isBlank) {
                return;
            }
            if ((previousSibling == null && element != null && element.tag().formatAsBlock() && !isBlank) || ((outputSettings.outline() && siblingNodes().size() > 0 && !isBlank) || (previousSibling != null && previousSibling.nameIs("br")))) {
                indent(appendable, i, outputSettings);
            }
            z2 = z6;
            z = z5;
        } else {
            z = false;
            z2 = false;
        }
        Entities.escape(appendable, coreValue(), outputSettings, false, z3, z, z2);
    }

    @Override // org.jsoup.nodes.Node
    public String toString() {
        return outerHtml();
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: clone */
    public TextNode mo8199clone() {
        return (TextNode) super.mo8199clone();
    }

    public static TextNode createFromEncoded(String str) {
        return new TextNode(Entities.unescape(str));
    }

    static String normaliseWhitespace(String str) {
        return StringUtil.normaliseWhitespace(str);
    }

    static String stripLeadingWhitespace(String str) {
        return str.replaceFirst("^\\s+", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean lastCharIsWhitespace(StringBuilder sb) {
        return sb.length() != 0 && sb.charAt(sb.length() - 1) == ' ';
    }
}
