package org.jsoup.parser;

import java.util.HashMap;
import java.util.Map;
import okio.Utf8;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.internal.SharedConstants;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Range;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class Token {
    static final int Unset = -1;
    private int endPos;
    private int startPos;
    final TokenType type;

    /* loaded from: classes4.dex */
    public enum TokenType {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int endPos() {
        return this.endPos;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void endPos(int i) {
        this.endPos = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Token reset() {
        this.startPos = -1;
        this.endPos = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int startPos() {
        return this.startPos;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPos(int i) {
        this.startPos = i;
    }

    private Token(TokenType tokenType) {
        this.endPos = -1;
        this.type = tokenType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String tokenType() {
        return getClass().getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reset(StringBuilder sb) {
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    /* loaded from: classes4.dex */
    static final class Doctype extends Token {
        boolean forceQuirks;
        final StringBuilder name;
        String pubSysKey;
        final StringBuilder publicIdentifier;
        final StringBuilder systemIdentifier;

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getPubSysKey() {
            return this.pubSysKey;
        }

        public boolean isForceQuirks() {
            return this.forceQuirks;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Doctype() {
            super(TokenType.Doctype);
            this.name = new StringBuilder();
            this.pubSysKey = null;
            this.publicIdentifier = new StringBuilder();
            this.systemIdentifier = new StringBuilder();
            this.forceQuirks = false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.jsoup.parser.Token
        public Token reset() {
            super.reset();
            reset(this.name);
            this.pubSysKey = null;
            reset(this.publicIdentifier);
            reset(this.systemIdentifier);
            this.forceQuirks = false;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getName() {
            return this.name.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getPublicIdentifier() {
            return this.publicIdentifier.toString();
        }

        public String getSystemIdentifier() {
            return this.systemIdentifier.toString();
        }

        public String toString() {
            return "<!doctype " + getName() + ">";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static abstract class Tag extends Token {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int MaxAttributes = 512;
        private String attrName;
        int attrNameEnd;
        private final StringBuilder attrNameSb;
        int attrNameStart;
        int attrValEnd;
        int attrValStart;
        private String attrValue;
        private final StringBuilder attrValueSb;
        Attributes attributes;
        private boolean hasAttrName;
        private boolean hasAttrValue;
        private boolean hasEmptyAttrValue;
        protected String normalName;
        boolean selfClosing;
        protected String tagName;
        final boolean trackSource;
        final TreeBuilder treeBuilder;

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean hasAttributes() {
            return this.attributes != null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean isSelfClosing() {
            return this.selfClosing;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final String normalName() {
            return this.normalName;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void setEmptyAttributeValue() {
            this.hasEmptyAttrValue = true;
        }

        public abstract String toString();

        final String toStringName() {
            String str = this.tagName;
            return str != null ? str : "[unset]";
        }

        Tag(TokenType tokenType, TreeBuilder treeBuilder) {
            super(tokenType);
            this.selfClosing = false;
            this.attrNameSb = new StringBuilder();
            this.hasAttrName = false;
            this.attrValueSb = new StringBuilder();
            this.hasAttrValue = false;
            this.hasEmptyAttrValue = false;
            this.treeBuilder = treeBuilder;
            this.trackSource = treeBuilder.trackSourceRange;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.jsoup.parser.Token
        public Tag reset() {
            super.reset();
            this.tagName = null;
            this.normalName = null;
            this.selfClosing = false;
            this.attributes = null;
            resetPendingAttr();
            return this;
        }

        private void resetPendingAttr() {
            reset(this.attrNameSb);
            this.attrName = null;
            this.hasAttrName = false;
            reset(this.attrValueSb);
            this.attrValue = null;
            this.hasEmptyAttrValue = false;
            this.hasAttrValue = false;
            if (this.trackSource) {
                this.attrValEnd = -1;
                this.attrValStart = -1;
                this.attrNameEnd = -1;
                this.attrNameStart = -1;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void newAttribute() {
            String str;
            if (this.attributes == null) {
                this.attributes = new Attributes();
            }
            if (this.hasAttrName && this.attributes.size() < 512) {
                String trim = (this.attrNameSb.length() > 0 ? this.attrNameSb.toString() : this.attrName).trim();
                if (trim.length() > 0) {
                    if (this.hasAttrValue) {
                        str = this.attrValueSb.length() > 0 ? this.attrValueSb.toString() : this.attrValue;
                    } else {
                        str = this.hasEmptyAttrValue ? "" : null;
                    }
                    this.attributes.add(trim, str);
                    trackAttributeRange(trim);
                }
            }
            resetPendingAttr();
        }

        private void trackAttributeRange(String str) {
            if (this.trackSource && isStartTag()) {
                StartTag asStartTag = asStartTag();
                CharacterReader characterReader = asStartTag.treeBuilder.reader;
                boolean preserveAttributeCase = asStartTag.treeBuilder.settings.preserveAttributeCase();
                Map map = (Map) this.attributes.userData(SharedConstants.AttrRangeKey);
                if (map == null) {
                    map = new HashMap();
                    this.attributes.userData(SharedConstants.AttrRangeKey, map);
                }
                if (!preserveAttributeCase) {
                    str = Normalizer.lowerCase(str);
                }
                if (map.containsKey(str)) {
                    return;
                }
                if (!this.hasAttrValue) {
                    int i = this.attrNameEnd;
                    this.attrValEnd = i;
                    this.attrValStart = i;
                }
                int i2 = this.attrNameStart;
                Range.Position position = new Range.Position(i2, characterReader.lineNumber(i2), characterReader.columnNumber(this.attrNameStart));
                int i3 = this.attrNameEnd;
                Range range = new Range(position, new Range.Position(i3, characterReader.lineNumber(i3), characterReader.columnNumber(this.attrNameEnd)));
                int i4 = this.attrValStart;
                Range.Position position2 = new Range.Position(i4, characterReader.lineNumber(i4), characterReader.columnNumber(this.attrValStart));
                int i5 = this.attrValEnd;
                map.put(str, new Range.AttributeRange(range, new Range(position2, new Range.Position(i5, characterReader.lineNumber(i5), characterReader.columnNumber(this.attrValEnd)))));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean hasAttribute(String str) {
            Attributes attributes = this.attributes;
            return attributes != null && attributes.hasKey(str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean hasAttributeIgnoreCase(String str) {
            Attributes attributes = this.attributes;
            return attributes != null && attributes.hasKeyIgnoreCase(str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void finaliseTag() {
            if (this.hasAttrName) {
                newAttribute();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final String name() {
            String str = this.tagName;
            Validate.isFalse(str == null || str.length() == 0);
            return this.tagName;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final Tag name(String str) {
            this.tagName = str;
            this.normalName = ParseSettings.normalName(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendTagName(String str) {
            String replace = str.replace((char) 0, Utf8.REPLACEMENT_CHARACTER);
            String str2 = this.tagName;
            if (str2 != null) {
                replace = str2.concat(replace);
            }
            this.tagName = replace;
            this.normalName = ParseSettings.normalName(replace);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendTagName(char c) {
            appendTagName(String.valueOf(c));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendAttributeName(String str, int i, int i2) {
            String replace = str.replace((char) 0, Utf8.REPLACEMENT_CHARACTER);
            ensureAttrName(i, i2);
            if (this.attrNameSb.length() == 0) {
                this.attrName = replace;
            } else {
                this.attrNameSb.append(replace);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendAttributeName(char c, int i, int i2) {
            ensureAttrName(i, i2);
            this.attrNameSb.append(c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendAttributeValue(String str, int i, int i2) {
            ensureAttrValue(i, i2);
            if (this.attrValueSb.length() == 0) {
                this.attrValue = str;
            } else {
                this.attrValueSb.append(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendAttributeValue(char c, int i, int i2) {
            ensureAttrValue(i, i2);
            this.attrValueSb.append(c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendAttributeValue(int[] iArr, int i, int i2) {
            ensureAttrValue(i, i2);
            for (int i3 : iArr) {
                this.attrValueSb.appendCodePoint(i3);
            }
        }

        private void ensureAttrName(int i, int i2) {
            this.hasAttrName = true;
            String str = this.attrName;
            if (str != null) {
                this.attrNameSb.append(str);
                this.attrName = null;
            }
            if (this.trackSource) {
                int i3 = this.attrNameStart;
                if (i3 > -1) {
                    i = i3;
                }
                this.attrNameStart = i;
                this.attrNameEnd = i2;
            }
        }

        private void ensureAttrValue(int i, int i2) {
            this.hasAttrValue = true;
            String str = this.attrValue;
            if (str != null) {
                this.attrValueSb.append(str);
                this.attrValue = null;
            }
            if (this.trackSource) {
                int i3 = this.attrValStart;
                if (i3 > -1) {
                    i = i3;
                }
                this.attrValStart = i;
                this.attrValEnd = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class StartTag extends Tag {
        /* JADX INFO: Access modifiers changed from: package-private */
        public StartTag(TreeBuilder treeBuilder) {
            super(TokenType.StartTag, treeBuilder);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.jsoup.parser.Token.Tag, org.jsoup.parser.Token
        public Tag reset() {
            super.reset();
            this.attributes = null;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public StartTag nameAttr(String str, Attributes attributes) {
            this.tagName = str;
            this.attributes = attributes;
            this.normalName = ParseSettings.normalName(this.tagName);
            return this;
        }

        @Override // org.jsoup.parser.Token.Tag
        public String toString() {
            String str = isSelfClosing() ? "/>" : ">";
            if (hasAttributes() && this.attributes.size() > 0) {
                return "<" + toStringName() + " " + this.attributes.toString() + str;
            }
            return "<" + toStringName() + str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class EndTag extends Tag {
        /* JADX INFO: Access modifiers changed from: package-private */
        public EndTag(TreeBuilder treeBuilder) {
            super(TokenType.EndTag, treeBuilder);
        }

        @Override // org.jsoup.parser.Token.Tag
        public String toString() {
            return "</" + toStringName() + ">";
        }
    }

    /* loaded from: classes4.dex */
    static final class Comment extends Token {
        boolean bogus;
        private final StringBuilder data;
        private String dataS;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.jsoup.parser.Token
        public Token reset() {
            super.reset();
            reset(this.data);
            this.dataS = null;
            this.bogus = false;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Comment() {
            super(TokenType.Comment);
            this.data = new StringBuilder();
            this.bogus = false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getData() {
            String str = this.dataS;
            return str != null ? str : this.data.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Comment append(String str) {
            ensureData();
            if (this.data.length() == 0) {
                this.dataS = str;
            } else {
                this.data.append(str);
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Comment append(char c) {
            ensureData();
            this.data.append(c);
            return this;
        }

        private void ensureData() {
            String str = this.dataS;
            if (str != null) {
                this.data.append(str);
                this.dataS = null;
            }
        }

        public String toString() {
            return "<!--" + getData() + "-->";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class Character extends Token implements Cloneable {
        private String data;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Character data(String str) {
            this.data = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getData() {
            return this.data;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Character() {
            super(TokenType.Character);
        }

        @Override // org.jsoup.parser.Token
        Token reset() {
            super.reset();
            this.data = null;
            return this;
        }

        public String toString() {
            return getData();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Character clone() {
            try {
                return (Character) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* loaded from: classes4.dex */
    static final class CData extends Character {
        /* JADX INFO: Access modifiers changed from: package-private */
        public CData(String str) {
            data(str);
        }

        @Override // org.jsoup.parser.Token.Character
        public String toString() {
            return "<![CDATA[" + getData() + "]]>";
        }
    }

    /* loaded from: classes4.dex */
    static final class EOF extends Token {
        public String toString() {
            return "";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public EOF() {
            super(TokenType.EOF);
        }

        @Override // org.jsoup.parser.Token
        Token reset() {
            super.reset();
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isDoctype() {
        return this.type == TokenType.Doctype;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Doctype asDoctype() {
        return (Doctype) this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isStartTag() {
        return this.type == TokenType.StartTag;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final StartTag asStartTag() {
        return (StartTag) this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isEndTag() {
        return this.type == TokenType.EndTag;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final EndTag asEndTag() {
        return (EndTag) this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isComment() {
        return this.type == TokenType.Comment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Comment asComment() {
        return (Comment) this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isCharacter() {
        return this.type == TokenType.Character;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isCData() {
        return this instanceof CData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Character asCharacter() {
        return (Character) this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isEOF() {
        return this.type == TokenType.EOF;
    }
}
