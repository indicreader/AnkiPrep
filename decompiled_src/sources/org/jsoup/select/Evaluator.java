package org.jsoup.select;

import java.util.Iterator;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.PseudoTextElement;
import org.jsoup.nodes.TextNode;
import org.jsoup.nodes.XmlDeclaration;
import org.jsoup.parser.ParseSettings;

/* loaded from: classes4.dex */
public abstract class Evaluator {

    /* loaded from: classes4.dex */
    public static final class AllElements extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        protected int cost() {
            return 10;
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return true;
        }

        public String toString() {
            return "*";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int cost() {
        return 5;
    }

    /* renamed from: matches, reason: merged with bridge method [inline-methods] */
    public abstract boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2);

    /* JADX INFO: Access modifiers changed from: protected */
    public void reset() {
    }

    public Predicate<Element> asPredicate(final Element element) {
        return new Predicate() { // from class: org.jsoup.select.Evaluator$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Evaluator.this.m8203lambda$asPredicate$0$orgjsoupselectEvaluator(element, (Element) obj);
            }
        };
    }

    /* loaded from: classes4.dex */
    public static final class Tag extends Evaluator {
        private final String tagName;

        @Override // org.jsoup.select.Evaluator
        protected int cost() {
            return 1;
        }

        public Tag(String str) {
            this.tagName = str;
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return element2.nameIs(this.tagName);
        }

        public String toString() {
            return String.format("%s", this.tagName);
        }
    }

    /* loaded from: classes4.dex */
    public static final class TagEndsWith extends Evaluator {
        private final String tagName;

        public TagEndsWith(String str) {
            this.tagName = str;
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return element2.normalName().endsWith(this.tagName);
        }

        public String toString() {
            return String.format("%s", this.tagName);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Id extends Evaluator {
        private final String id;

        @Override // org.jsoup.select.Evaluator
        protected int cost() {
            return 2;
        }

        public Id(String str) {
            this.id = str;
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return this.id.equals(element2.id());
        }

        public String toString() {
            return String.format("#%s", this.id);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Class extends Evaluator {
        private final String className;

        @Override // org.jsoup.select.Evaluator
        protected int cost() {
            return 6;
        }

        public Class(String str) {
            this.className = str;
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return element2.hasClass(this.className);
        }

        public String toString() {
            return String.format(".%s", this.className);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Attribute extends Evaluator {
        private final String key;

        @Override // org.jsoup.select.Evaluator
        protected int cost() {
            return 2;
        }

        public Attribute(String str) {
            this.key = str;
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return element2.hasAttr(this.key);
        }

        public String toString() {
            return String.format("[%s]", this.key);
        }
    }

    /* loaded from: classes4.dex */
    public static final class AttributeStarting extends Evaluator {
        private final String keyPrefix;

        @Override // org.jsoup.select.Evaluator
        protected int cost() {
            return 6;
        }

        public AttributeStarting(String str) {
            Validate.notNull(str);
            this.keyPrefix = Normalizer.lowerCase(str);
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            Iterator<org.jsoup.nodes.Attribute> it = element2.attributes().asList().iterator();
            while (it.hasNext()) {
                if (Normalizer.lowerCase(it.next().getKey()).startsWith(this.keyPrefix)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format("[^%s]", this.keyPrefix);
        }
    }

    /* loaded from: classes4.dex */
    public static final class AttributeWithValue extends AttributeKeyPair {
        @Override // org.jsoup.select.Evaluator
        protected int cost() {
            return 3;
        }

        public AttributeWithValue(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return element2.hasAttr(this.key) && this.value.equalsIgnoreCase(element2.attr(this.key).trim());
        }

        public String toString() {
            return String.format("[%s=%s]", this.key, this.value);
        }
    }

    /* loaded from: classes4.dex */
    public static final class AttributeWithValueNot extends AttributeKeyPair {
        @Override // org.jsoup.select.Evaluator
        protected int cost() {
            return 3;
        }

        public AttributeWithValueNot(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return !this.value.equalsIgnoreCase(element2.attr(this.key));
        }

        public String toString() {
            return String.format("[%s!=%s]", this.key, this.value);
        }
    }

    /* loaded from: classes4.dex */
    public static final class AttributeWithValueStarting extends AttributeKeyPair {
        @Override // org.jsoup.select.Evaluator
        protected int cost() {
            return 4;
        }

        public AttributeWithValueStarting(String str, String str2) {
            super(str, str2, false);
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return element2.hasAttr(this.key) && Normalizer.lowerCase(element2.attr(this.key)).startsWith(this.value);
        }

        public String toString() {
            return String.format("[%s^=%s]", this.key, this.value);
        }
    }

    /* loaded from: classes4.dex */
    public static final class AttributeWithValueEnding extends AttributeKeyPair {
        @Override // org.jsoup.select.Evaluator
        protected int cost() {
            return 4;
        }

        public AttributeWithValueEnding(String str, String str2) {
            super(str, str2, false);
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return element2.hasAttr(this.key) && Normalizer.lowerCase(element2.attr(this.key)).endsWith(this.value);
        }

        public String toString() {
            return String.format("[%s$=%s]", this.key, this.value);
        }
    }

    /* loaded from: classes4.dex */
    public static final class AttributeWithValueContaining extends AttributeKeyPair {
        @Override // org.jsoup.select.Evaluator
        protected int cost() {
            return 6;
        }

        public AttributeWithValueContaining(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return element2.hasAttr(this.key) && Normalizer.lowerCase(element2.attr(this.key)).contains(this.value);
        }

        public String toString() {
            return String.format("[%s*=%s]", this.key, this.value);
        }
    }

    /* loaded from: classes4.dex */
    public static final class AttributeWithValueMatching extends Evaluator {
        final String key;
        final Pattern pattern;

        @Override // org.jsoup.select.Evaluator
        protected int cost() {
            return 8;
        }

        public AttributeWithValueMatching(String str, Pattern pattern) {
            this.key = Normalizer.normalize(str);
            this.pattern = pattern;
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return element2.hasAttr(this.key) && this.pattern.matcher(element2.attr(this.key)).find();
        }

        public String toString() {
            return String.format("[%s~=%s]", this.key, this.pattern.toString());
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class AttributeKeyPair extends Evaluator {
        final String key;
        final String value;

        public AttributeKeyPair(String str, String str2) {
            this(str, str2, true);
        }

        public AttributeKeyPair(String str, String str2, boolean z) {
            Validate.notEmpty(str);
            Validate.notEmpty(str2);
            this.key = Normalizer.normalize(str);
            boolean z2 = (str2.startsWith("'") && str2.endsWith("'")) || (str2.startsWith("\"") && str2.endsWith("\""));
            str2 = z2 ? str2.substring(1, str2.length() - 1) : str2;
            this.value = z ? Normalizer.normalize(str2) : Normalizer.normalize(str2, z2);
        }
    }

    /* loaded from: classes4.dex */
    public static final class IndexLessThan extends IndexEvaluator {
        public IndexLessThan(int i) {
            super(i);
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return element != element2 && element2.elementSiblingIndex() < this.index;
        }

        public String toString() {
            return String.format(":lt(%d)", Integer.valueOf(this.index));
        }
    }

    /* loaded from: classes4.dex */
    public static final class IndexGreaterThan extends IndexEvaluator {
        public IndexGreaterThan(int i) {
            super(i);
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return element2.elementSiblingIndex() > this.index;
        }

        public String toString() {
            return String.format(":gt(%d)", Integer.valueOf(this.index));
        }
    }

    /* loaded from: classes4.dex */
    public static final class IndexEquals extends IndexEvaluator {
        public IndexEquals(int i) {
            super(i);
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return element2.elementSiblingIndex() == this.index;
        }

        public String toString() {
            return String.format(":eq(%d)", Integer.valueOf(this.index));
        }
    }

    /* loaded from: classes4.dex */
    public static final class IsLastChild extends Evaluator {
        public String toString() {
            return ":last-child";
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            Element parent = element2.parent();
            return (parent == null || (parent instanceof Document) || element2 != parent.lastElementChild()) ? false : true;
        }
    }

    /* loaded from: classes4.dex */
    public static final class IsFirstOfType extends IsNthOfType {
        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        public String toString() {
            return ":first-of-type";
        }

        public IsFirstOfType() {
            super(0, 1);
        }
    }

    /* loaded from: classes4.dex */
    public static final class IsLastOfType extends IsNthLastOfType {
        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        public String toString() {
            return ":last-of-type";
        }

        public IsLastOfType() {
            super(0, 1);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class CssNthEvaluator extends Evaluator {
        protected final int a;
        protected final int b;

        protected abstract int calculatePosition(Element element, Element element2);

        protected abstract String getPseudoClass();

        public CssNthEvaluator(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public CssNthEvaluator(int i) {
            this(0, i);
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            Element parent = element2.parent();
            if (parent == null || (parent instanceof Document)) {
                return false;
            }
            int calculatePosition = calculatePosition(element, element2);
            int i = this.a;
            if (i == 0) {
                return calculatePosition == this.b;
            }
            int i2 = this.b;
            return (calculatePosition - i2) * i >= 0 && (calculatePosition - i2) % i == 0;
        }

        public String toString() {
            if (this.a == 0) {
                return String.format(":%s(%d)", getPseudoClass(), Integer.valueOf(this.b));
            }
            if (this.b == 0) {
                return String.format(":%s(%dn)", getPseudoClass(), Integer.valueOf(this.a));
            }
            return String.format(":%s(%dn%+d)", getPseudoClass(), Integer.valueOf(this.a), Integer.valueOf(this.b));
        }
    }

    /* loaded from: classes4.dex */
    public static final class IsNthChild extends CssNthEvaluator {
        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected String getPseudoClass() {
            return "nth-child";
        }

        public IsNthChild(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected int calculatePosition(Element element, Element element2) {
            return element2.elementSiblingIndex() + 1;
        }
    }

    /* loaded from: classes4.dex */
    public static final class IsNthLastChild extends CssNthEvaluator {
        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected String getPseudoClass() {
            return "nth-last-child";
        }

        public IsNthLastChild(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected int calculatePosition(Element element, Element element2) {
            if (element2.parent() == null) {
                return 0;
            }
            return element2.parent().childrenSize() - element2.elementSiblingIndex();
        }
    }

    /* loaded from: classes4.dex */
    public static class IsNthOfType extends CssNthEvaluator {
        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected String getPseudoClass() {
            return "nth-of-type";
        }

        public IsNthOfType(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected int calculatePosition(Element element, Element element2) {
            Element parent = element2.parent();
            if (parent == null) {
                return 0;
            }
            int childNodeSize = parent.childNodeSize();
            int i = 0;
            for (int i2 = 0; i2 < childNodeSize; i2++) {
                Node childNode = parent.childNode(i2);
                if (childNode.normalName().equals(element2.normalName())) {
                    i++;
                }
                if (childNode == element2) {
                    break;
                }
            }
            return i;
        }
    }

    /* loaded from: classes4.dex */
    public static class IsNthLastOfType extends CssNthEvaluator {
        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected String getPseudoClass() {
            return "nth-last-of-type";
        }

        public IsNthLastOfType(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected int calculatePosition(Element element, Element element2) {
            int i = 0;
            if (element2.parent() == null) {
                return 0;
            }
            for (Element element3 = element2; element3 != null; element3 = element3.nextElementSibling()) {
                if (element3.normalName().equals(element2.normalName())) {
                    i++;
                }
            }
            return i;
        }
    }

    /* loaded from: classes4.dex */
    public static final class IsFirstChild extends Evaluator {
        public String toString() {
            return ":first-child";
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            Element parent = element2.parent();
            return (parent == null || (parent instanceof Document) || element2 != parent.firstElementChild()) ? false : true;
        }
    }

    /* loaded from: classes4.dex */
    public static final class IsRoot extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        protected int cost() {
            return 1;
        }

        public String toString() {
            return ":root";
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            if (element instanceof Document) {
                element = element.firstElementChild();
            }
            return element2 == element;
        }
    }

    /* loaded from: classes4.dex */
    public static final class IsOnlyChild extends Evaluator {
        public String toString() {
            return ":only-child";
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            Element parent = element2.parent();
            return (parent == null || (parent instanceof Document) || !element2.siblingElements().isEmpty()) ? false : true;
        }
    }

    /* loaded from: classes4.dex */
    public static final class IsOnlyOfType extends Evaluator {
        public String toString() {
            return ":only-of-type";
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            Element parent = element2.parent();
            if (parent == null || (parent instanceof Document)) {
                return false;
            }
            int i = 0;
            for (Element firstElementChild = parent.firstElementChild(); firstElementChild != null; firstElementChild = firstElementChild.nextElementSibling()) {
                if (firstElementChild.normalName().equals(element2.normalName())) {
                    i++;
                }
                if (i > 1) {
                    break;
                }
            }
            return i == 1;
        }
    }

    /* loaded from: classes4.dex */
    public static final class IsEmpty extends Evaluator {
        public String toString() {
            return ":empty";
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            for (Node node : element2.childNodes()) {
                if (node instanceof TextNode) {
                    return ((TextNode) node).isBlank();
                }
                if (!(node instanceof Comment) && !(node instanceof XmlDeclaration) && !(node instanceof DocumentType)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class IndexEvaluator extends Evaluator {
        final int index;

        public IndexEvaluator(int i) {
            this.index = i;
        }
    }

    /* loaded from: classes4.dex */
    public static final class ContainsText extends Evaluator {
        private final String searchText;

        @Override // org.jsoup.select.Evaluator
        protected int cost() {
            return 10;
        }

        public ContainsText(String str) {
            this.searchText = Normalizer.lowerCase(StringUtil.normaliseWhitespace(str));
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return Normalizer.lowerCase(element2.text()).contains(this.searchText);
        }

        public String toString() {
            return String.format(":contains(%s)", this.searchText);
        }
    }

    /* loaded from: classes4.dex */
    public static final class ContainsWholeText extends Evaluator {
        private final String searchText;

        @Override // org.jsoup.select.Evaluator
        protected int cost() {
            return 10;
        }

        public ContainsWholeText(String str) {
            this.searchText = str;
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return element2.wholeText().contains(this.searchText);
        }

        public String toString() {
            return String.format(":containsWholeText(%s)", this.searchText);
        }
    }

    /* loaded from: classes4.dex */
    public static final class ContainsWholeOwnText extends Evaluator {
        private final String searchText;

        public ContainsWholeOwnText(String str) {
            this.searchText = str;
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return element2.wholeOwnText().contains(this.searchText);
        }

        public String toString() {
            return String.format(":containsWholeOwnText(%s)", this.searchText);
        }
    }

    /* loaded from: classes4.dex */
    public static final class ContainsData extends Evaluator {
        private final String searchText;

        public ContainsData(String str) {
            this.searchText = Normalizer.lowerCase(str);
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return Normalizer.lowerCase(element2.data()).contains(this.searchText);
        }

        public String toString() {
            return String.format(":containsData(%s)", this.searchText);
        }
    }

    /* loaded from: classes4.dex */
    public static final class ContainsOwnText extends Evaluator {
        private final String searchText;

        public ContainsOwnText(String str) {
            this.searchText = Normalizer.lowerCase(StringUtil.normaliseWhitespace(str));
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return Normalizer.lowerCase(element2.ownText()).contains(this.searchText);
        }

        public String toString() {
            return String.format(":containsOwn(%s)", this.searchText);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Matches extends Evaluator {
        private final Pattern pattern;

        @Override // org.jsoup.select.Evaluator
        protected int cost() {
            return 8;
        }

        public Matches(Pattern pattern) {
            this.pattern = pattern;
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return this.pattern.matcher(element2.text()).find();
        }

        public String toString() {
            return String.format(":matches(%s)", this.pattern);
        }
    }

    /* loaded from: classes4.dex */
    public static final class MatchesOwn extends Evaluator {
        private final Pattern pattern;

        @Override // org.jsoup.select.Evaluator
        protected int cost() {
            return 7;
        }

        public MatchesOwn(Pattern pattern) {
            this.pattern = pattern;
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return this.pattern.matcher(element2.ownText()).find();
        }

        public String toString() {
            return String.format(":matchesOwn(%s)", this.pattern);
        }
    }

    /* loaded from: classes4.dex */
    public static final class MatchesWholeText extends Evaluator {
        private final Pattern pattern;

        @Override // org.jsoup.select.Evaluator
        protected int cost() {
            return 8;
        }

        public MatchesWholeText(Pattern pattern) {
            this.pattern = pattern;
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return this.pattern.matcher(element2.wholeText()).find();
        }

        public String toString() {
            return String.format(":matchesWholeText(%s)", this.pattern);
        }
    }

    /* loaded from: classes4.dex */
    public static final class MatchesWholeOwnText extends Evaluator {
        private final Pattern pattern;

        @Override // org.jsoup.select.Evaluator
        protected int cost() {
            return 7;
        }

        public MatchesWholeOwnText(Pattern pattern) {
            this.pattern = pattern;
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return this.pattern.matcher(element2.wholeOwnText()).find();
        }

        public String toString() {
            return String.format(":matchesWholeOwnText(%s)", this.pattern);
        }
    }

    /* loaded from: classes4.dex */
    public static final class MatchText extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        protected int cost() {
            return -1;
        }

        public String toString() {
            return ":matchText";
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            if (element2 instanceof PseudoTextElement) {
                return true;
            }
            for (TextNode textNode : element2.textNodes()) {
                PseudoTextElement pseudoTextElement = new PseudoTextElement(org.jsoup.parser.Tag.valueOf(element2.tagName(), element2.tag().namespace(), ParseSettings.preserveCase), element2.baseUri(), element2.attributes());
                textNode.replaceWith(pseudoTextElement);
                pseudoTextElement.appendChild(textNode);
            }
            return false;
        }
    }
}
