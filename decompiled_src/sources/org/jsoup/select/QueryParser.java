package org.jsoup.select;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.internal.StringUtil;
import org.jsoup.parser.TokenQueue;
import org.jsoup.select.CombiningEvaluator;
import org.jsoup.select.Evaluator;
import org.jsoup.select.Selector;
import org.jsoup.select.StructuralEvaluator;

/* loaded from: classes4.dex */
public class QueryParser {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final List<Evaluator> evals = new ArrayList();
    private final String query;
    private final TokenQueue tq;
    private static final char[] Combinators = {',', Typography.greater, '+', '~', ' '};
    private static final String[] AttributeEvals = {"=", "!=", "^=", "$=", "*=", "~="};
    private static final Pattern NTH_AB = Pattern.compile("(([+-])?(\\d+)?)n(\\s*([+-])?\\s*\\d+)?", 2);
    private static final Pattern NTH_B = Pattern.compile("([+-])?(\\d+)");

    public String toString() {
        return this.query;
    }

    private QueryParser(String str) {
        Validate.notEmpty(str);
        String trim = str.trim();
        this.query = trim;
        this.tq = new TokenQueue(trim);
    }

    public static Evaluator parse(String str) {
        try {
            return new QueryParser(str).parse();
        } catch (IllegalArgumentException e) {
            throw new Selector.SelectorParseException(e.getMessage());
        }
    }

    Evaluator parse() {
        this.tq.consumeWhitespace();
        if (this.tq.matchesAny(Combinators)) {
            this.evals.add(new StructuralEvaluator.Root());
            combinator(this.tq.consume());
        } else {
            this.evals.add(consumeEvaluator());
        }
        while (!this.tq.isEmpty()) {
            boolean consumeWhitespace = this.tq.consumeWhitespace();
            if (this.tq.matchesAny(Combinators)) {
                combinator(this.tq.consume());
            } else if (consumeWhitespace) {
                combinator(' ');
            } else {
                this.evals.add(consumeEvaluator());
            }
        }
        if (this.evals.size() == 1) {
            return this.evals.get(0);
        }
        return new CombiningEvaluator.And(this.evals);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void combinator(char r11) {
        /*
            r10 = this;
            org.jsoup.parser.TokenQueue r0 = r10.tq
            r0.consumeWhitespace()
            java.lang.String r0 = r10.consumeSubQuery()
            org.jsoup.select.Evaluator r0 = parse(r0)
            java.util.List<org.jsoup.select.Evaluator> r1 = r10.evals
            int r1 = r1.size()
            r2 = 44
            r3 = 0
            r4 = 1
            if (r1 != r4) goto L33
            java.util.List<org.jsoup.select.Evaluator> r1 = r10.evals
            java.lang.Object r1 = r1.get(r3)
            org.jsoup.select.Evaluator r1 = (org.jsoup.select.Evaluator) r1
            boolean r5 = r1 instanceof org.jsoup.select.CombiningEvaluator.Or
            if (r5 == 0) goto L3a
            if (r11 == r2) goto L3a
            r5 = r1
            org.jsoup.select.CombiningEvaluator$Or r5 = (org.jsoup.select.CombiningEvaluator.Or) r5
            org.jsoup.select.Evaluator r5 = r5.rightMostEvaluator()
            r6 = r4
            r9 = r5
            r5 = r1
            r1 = r9
            goto L3c
        L33:
            org.jsoup.select.CombiningEvaluator$And r1 = new org.jsoup.select.CombiningEvaluator$And
            java.util.List<org.jsoup.select.Evaluator> r5 = r10.evals
            r1.<init>(r5)
        L3a:
            r5 = r1
            r6 = r3
        L3c:
            java.util.List<org.jsoup.select.Evaluator> r7 = r10.evals
            r7.clear()
            r7 = 32
            r8 = 2
            if (r11 == r7) goto Lab
            r7 = 62
            if (r11 == r7) goto L9a
            r7 = 126(0x7e, float:1.77E-43)
            if (r11 == r7) goto L89
            r7 = 43
            if (r11 == r7) goto L78
            if (r11 != r2) goto L68
            boolean r11 = r1 instanceof org.jsoup.select.CombiningEvaluator.Or
            if (r11 == 0) goto L5b
            org.jsoup.select.CombiningEvaluator$Or r1 = (org.jsoup.select.CombiningEvaluator.Or) r1
            goto L64
        L5b:
            org.jsoup.select.CombiningEvaluator$Or r11 = new org.jsoup.select.CombiningEvaluator$Or
            r11.<init>()
            r11.add(r1)
            r1 = r11
        L64:
            r1.add(r0)
            goto Lbc
        L68:
            org.jsoup.select.Selector$SelectorParseException r0 = new org.jsoup.select.Selector$SelectorParseException
            java.lang.Character r11 = java.lang.Character.valueOf(r11)
            java.lang.Object[] r11 = new java.lang.Object[]{r11}
            java.lang.String r1 = "Unknown combinator '%s'"
            r0.<init>(r1, r11)
            throw r0
        L78:
            org.jsoup.select.CombiningEvaluator$And r11 = new org.jsoup.select.CombiningEvaluator$And
            org.jsoup.select.Evaluator[] r2 = new org.jsoup.select.Evaluator[r8]
            org.jsoup.select.StructuralEvaluator$ImmediatePreviousSibling r7 = new org.jsoup.select.StructuralEvaluator$ImmediatePreviousSibling
            r7.<init>(r1)
            r2[r3] = r7
            r2[r4] = r0
            r11.<init>(r2)
            goto Lbb
        L89:
            org.jsoup.select.CombiningEvaluator$And r11 = new org.jsoup.select.CombiningEvaluator$And
            org.jsoup.select.Evaluator[] r2 = new org.jsoup.select.Evaluator[r8]
            org.jsoup.select.StructuralEvaluator$PreviousSibling r7 = new org.jsoup.select.StructuralEvaluator$PreviousSibling
            r7.<init>(r1)
            r2[r3] = r7
            r2[r4] = r0
            r11.<init>(r2)
            goto Lbb
        L9a:
            boolean r11 = r1 instanceof org.jsoup.select.StructuralEvaluator.ImmediateParentRun
            if (r11 == 0) goto La1
            org.jsoup.select.StructuralEvaluator$ImmediateParentRun r1 = (org.jsoup.select.StructuralEvaluator.ImmediateParentRun) r1
            goto La7
        La1:
            org.jsoup.select.StructuralEvaluator$ImmediateParentRun r11 = new org.jsoup.select.StructuralEvaluator$ImmediateParentRun
            r11.<init>(r1)
            r1 = r11
        La7:
            r1.add(r0)
            goto Lbc
        Lab:
            org.jsoup.select.CombiningEvaluator$And r11 = new org.jsoup.select.CombiningEvaluator$And
            org.jsoup.select.Evaluator[] r2 = new org.jsoup.select.Evaluator[r8]
            org.jsoup.select.StructuralEvaluator$Parent r7 = new org.jsoup.select.StructuralEvaluator$Parent
            r7.<init>(r1)
            r2[r3] = r7
            r2[r4] = r0
            r11.<init>(r2)
        Lbb:
            r1 = r11
        Lbc:
            if (r6 == 0) goto Lc5
            r11 = r5
            org.jsoup.select.CombiningEvaluator$Or r11 = (org.jsoup.select.CombiningEvaluator.Or) r11
            r11.replaceRightMostEvaluator(r1)
            goto Lc6
        Lc5:
            r5 = r1
        Lc6:
            java.util.List<org.jsoup.select.Evaluator> r11 = r10.evals
            r11.add(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.select.QueryParser.combinator(char):void");
    }

    private String consumeSubQuery() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        boolean z = false;
        while (!this.tq.isEmpty()) {
            if (!this.tq.matchesAny(Combinators)) {
                if (this.tq.matches("(")) {
                    borrowBuilder.append("(").append(this.tq.chompBalanced('(', ')')).append(")");
                } else if (this.tq.matches("[")) {
                    borrowBuilder.append("[").append(this.tq.chompBalanced('[', ']')).append("]");
                } else {
                    borrowBuilder.append(this.tq.consume());
                }
                z = true;
            } else {
                if (z) {
                    break;
                }
                borrowBuilder.append(this.tq.consume());
            }
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    private Evaluator consumeEvaluator() {
        if (this.tq.matchChomp("#")) {
            return byId();
        }
        if (this.tq.matchChomp(".")) {
            return byClass();
        }
        if (this.tq.matchesWord() || this.tq.matches("*|")) {
            return byTag();
        }
        if (this.tq.matches("[")) {
            return byAttribute();
        }
        if (this.tq.matchChomp("*")) {
            return new Evaluator.AllElements();
        }
        if (this.tq.matchChomp(":")) {
            return parsePseudoSelector();
        }
        throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", this.query, this.tq.remainder());
    }

    private Evaluator parsePseudoSelector() {
        String consumeCssIdentifier = this.tq.consumeCssIdentifier();
        consumeCssIdentifier.hashCode();
        char c = 65535;
        switch (consumeCssIdentifier.hashCode()) {
            case -2141736343:
                if (consumeCssIdentifier.equals("containsData")) {
                    c = 0;
                    break;
                }
                break;
            case -2136991809:
                if (consumeCssIdentifier.equals("first-child")) {
                    c = 1;
                    break;
                }
                break;
            case -1939921007:
                if (consumeCssIdentifier.equals("matchesWholeText")) {
                    c = 2;
                    break;
                }
                break;
            case -1754914063:
                if (consumeCssIdentifier.equals("nth-child")) {
                    c = 3;
                    break;
                }
                break;
            case -1629748624:
                if (consumeCssIdentifier.equals("nth-last-child")) {
                    c = 4;
                    break;
                }
                break;
            case -947996741:
                if (consumeCssIdentifier.equals("only-child")) {
                    c = 5;
                    break;
                }
                break;
            case -897532411:
                if (consumeCssIdentifier.equals("nth-of-type")) {
                    c = 6;
                    break;
                }
                break;
            case -872629820:
                if (consumeCssIdentifier.equals("nth-last-of-type")) {
                    c = 7;
                    break;
                }
                break;
            case -567445985:
                if (consumeCssIdentifier.equals("contains")) {
                    c = '\b';
                    break;
                }
                break;
            case -55413797:
                if (consumeCssIdentifier.equals("containsWholeOwnText")) {
                    c = '\t';
                    break;
                }
                break;
            case 3244:
                if (consumeCssIdentifier.equals("eq")) {
                    c = '\n';
                    break;
                }
                break;
            case 3309:
                if (consumeCssIdentifier.equals("gt")) {
                    c = 11;
                    break;
                }
                break;
            case 3370:
                if (consumeCssIdentifier.equals("is")) {
                    c = '\f';
                    break;
                }
                break;
            case 3464:
                if (consumeCssIdentifier.equals("lt")) {
                    c = '\r';
                    break;
                }
                break;
            case 103066:
                if (consumeCssIdentifier.equals("has")) {
                    c = 14;
                    break;
                }
                break;
            case 109267:
                if (consumeCssIdentifier.equals("not")) {
                    c = 15;
                    break;
                }
                break;
            case 3506402:
                if (consumeCssIdentifier.equals("root")) {
                    c = 16;
                    break;
                }
                break;
            case 96634189:
                if (consumeCssIdentifier.equals("empty")) {
                    c = 17;
                    break;
                }
                break;
            case 208017639:
                if (consumeCssIdentifier.equals("containsOwn")) {
                    c = 18;
                    break;
                }
                break;
            case 614017170:
                if (consumeCssIdentifier.equals("matchText")) {
                    c = 19;
                    break;
                }
                break;
            case 835834661:
                if (consumeCssIdentifier.equals("last-child")) {
                    c = 20;
                    break;
                }
                break;
            case 840862003:
                if (consumeCssIdentifier.equals("matches")) {
                    c = 21;
                    break;
                }
                break;
            case 1255901423:
                if (consumeCssIdentifier.equals("matchesWholeOwnText")) {
                    c = 22;
                    break;
                }
                break;
            case 1292941139:
                if (consumeCssIdentifier.equals("first-of-type")) {
                    c = 23;
                    break;
                }
                break;
            case 1455900751:
                if (consumeCssIdentifier.equals("only-of-type")) {
                    c = 24;
                    break;
                }
                break;
            case 1870740819:
                if (consumeCssIdentifier.equals("matchesOwn")) {
                    c = 25;
                    break;
                }
                break;
            case 2014184485:
                if (consumeCssIdentifier.equals("containsWholeText")) {
                    c = 26;
                    break;
                }
                break;
            case 2025926969:
                if (consumeCssIdentifier.equals("last-of-type")) {
                    c = 27;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return containsData();
            case 1:
                return new Evaluator.IsFirstChild();
            case 2:
                return matchesWholeText(false);
            case 3:
                return cssNthChild(false, false);
            case 4:
                return cssNthChild(true, false);
            case 5:
                return new Evaluator.IsOnlyChild();
            case 6:
                return cssNthChild(false, true);
            case 7:
                return cssNthChild(true, true);
            case '\b':
                return contains(false);
            case '\t':
                return containsWholeText(true);
            case '\n':
                return new Evaluator.IndexEquals(consumeIndex());
            case 11:
                return new Evaluator.IndexGreaterThan(consumeIndex());
            case '\f':
                return is();
            case '\r':
                return new Evaluator.IndexLessThan(consumeIndex());
            case 14:
                return has();
            case 15:
                return not();
            case 16:
                return new Evaluator.IsRoot();
            case 17:
                return new Evaluator.IsEmpty();
            case 18:
                return contains(true);
            case 19:
                return new Evaluator.MatchText();
            case 20:
                return new Evaluator.IsLastChild();
            case 21:
                return matches(false);
            case 22:
                return matchesWholeText(true);
            case 23:
                return new Evaluator.IsFirstOfType();
            case 24:
                return new Evaluator.IsOnlyOfType();
            case 25:
                return matches(true);
            case 26:
                return containsWholeText(false);
            case 27:
                return new Evaluator.IsLastOfType();
            default:
                throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", this.query, this.tq.remainder());
        }
    }

    private Evaluator byId() {
        String consumeCssIdentifier = this.tq.consumeCssIdentifier();
        Validate.notEmpty(consumeCssIdentifier);
        return new Evaluator.Id(consumeCssIdentifier);
    }

    private Evaluator byClass() {
        String consumeCssIdentifier = this.tq.consumeCssIdentifier();
        Validate.notEmpty(consumeCssIdentifier);
        return new Evaluator.Class(consumeCssIdentifier.trim());
    }

    private Evaluator byTag() {
        String normalize = Normalizer.normalize(this.tq.consumeElementSelector());
        Validate.notEmpty(normalize);
        if (normalize.startsWith("*|")) {
            return new CombiningEvaluator.Or(new Evaluator.Tag(normalize.substring(2)), new Evaluator.TagEndsWith(normalize.replace("*|", ":")));
        }
        if (normalize.contains("|")) {
            normalize = normalize.replace("|", ":");
        }
        return new Evaluator.Tag(normalize);
    }

    private Evaluator byAttribute() {
        Evaluator attributeWithValueMatching;
        TokenQueue tokenQueue = new TokenQueue(this.tq.chompBalanced('[', ']'));
        String consumeToAny = tokenQueue.consumeToAny(AttributeEvals);
        Validate.notEmpty(consumeToAny);
        tokenQueue.consumeWhitespace();
        if (tokenQueue.isEmpty()) {
            if (consumeToAny.startsWith("^")) {
                return new Evaluator.AttributeStarting(consumeToAny.substring(1));
            }
            if (consumeToAny.equals("*")) {
                return new Evaluator.AttributeStarting("");
            }
            return new Evaluator.Attribute(consumeToAny);
        }
        if (tokenQueue.matchChomp("=")) {
            attributeWithValueMatching = new Evaluator.AttributeWithValue(consumeToAny, tokenQueue.remainder());
        } else if (tokenQueue.matchChomp("!=")) {
            attributeWithValueMatching = new Evaluator.AttributeWithValueNot(consumeToAny, tokenQueue.remainder());
        } else if (tokenQueue.matchChomp("^=")) {
            attributeWithValueMatching = new Evaluator.AttributeWithValueStarting(consumeToAny, tokenQueue.remainder());
        } else if (tokenQueue.matchChomp("$=")) {
            attributeWithValueMatching = new Evaluator.AttributeWithValueEnding(consumeToAny, tokenQueue.remainder());
        } else if (tokenQueue.matchChomp("*=")) {
            attributeWithValueMatching = new Evaluator.AttributeWithValueContaining(consumeToAny, tokenQueue.remainder());
        } else if (tokenQueue.matchChomp("~=")) {
            attributeWithValueMatching = new Evaluator.AttributeWithValueMatching(consumeToAny, Pattern.compile(tokenQueue.remainder()));
        } else {
            throw new Selector.SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", this.query, tokenQueue.remainder());
        }
        return attributeWithValueMatching;
    }

    private Evaluator cssNthChild(boolean z, boolean z2) {
        String normalize = Normalizer.normalize(consumeParens());
        Matcher matcher = NTH_AB.matcher(normalize);
        Matcher matcher2 = NTH_B.matcher(normalize);
        int i = 2;
        int i2 = 1;
        if (!"odd".equals(normalize)) {
            if ("even".equals(normalize)) {
                i2 = 0;
            } else if (matcher.matches()) {
                int parseInt = matcher.group(3) != null ? Integer.parseInt(matcher.group(1).replaceFirst("^\\+", "")) : 1;
                i2 = matcher.group(4) != null ? Integer.parseInt(matcher.group(4).replaceFirst("^\\+", "")) : 0;
                i = parseInt;
            } else if (matcher2.matches()) {
                i2 = Integer.parseInt(matcher2.group().replaceFirst("^\\+", ""));
                i = 0;
            } else {
                throw new Selector.SelectorParseException("Could not parse nth-index '%s': unexpected format", normalize);
            }
        }
        if (z2) {
            if (z) {
                return new Evaluator.IsNthLastOfType(i, i2);
            }
            return new Evaluator.IsNthOfType(i, i2);
        }
        if (z) {
            return new Evaluator.IsNthLastChild(i, i2);
        }
        return new Evaluator.IsNthChild(i, i2);
    }

    private String consumeParens() {
        return this.tq.chompBalanced('(', ')');
    }

    private int consumeIndex() {
        String trim = consumeParens().trim();
        Validate.isTrue(StringUtil.isNumeric(trim), "Index must be numeric");
        return Integer.parseInt(trim);
    }

    private Evaluator has() {
        String consumeParens = consumeParens();
        Validate.notEmpty(consumeParens, ":has(selector) sub-select must not be empty");
        return new StructuralEvaluator.Has(parse(consumeParens));
    }

    private Evaluator is() {
        String consumeParens = consumeParens();
        Validate.notEmpty(consumeParens, ":is(selector) sub-select must not be empty");
        return new StructuralEvaluator.Is(parse(consumeParens));
    }

    private Evaluator contains(boolean z) {
        String str = z ? ":containsOwn" : ":contains";
        String unescape = TokenQueue.unescape(consumeParens());
        Validate.notEmpty(unescape, str.concat("(text) query must not be empty"));
        if (z) {
            return new Evaluator.ContainsOwnText(unescape);
        }
        return new Evaluator.ContainsText(unescape);
    }

    private Evaluator containsWholeText(boolean z) {
        String str = z ? ":containsWholeOwnText" : ":containsWholeText";
        String unescape = TokenQueue.unescape(consumeParens());
        Validate.notEmpty(unescape, str.concat("(text) query must not be empty"));
        if (z) {
            return new Evaluator.ContainsWholeOwnText(unescape);
        }
        return new Evaluator.ContainsWholeText(unescape);
    }

    private Evaluator containsData() {
        String unescape = TokenQueue.unescape(consumeParens());
        Validate.notEmpty(unescape, ":containsData(text) query must not be empty");
        return new Evaluator.ContainsData(unescape);
    }

    private Evaluator matches(boolean z) {
        String str = z ? ":matchesOwn" : ":matches";
        String consumeParens = consumeParens();
        Validate.notEmpty(consumeParens, str.concat("(regex) query must not be empty"));
        if (z) {
            return new Evaluator.MatchesOwn(Pattern.compile(consumeParens));
        }
        return new Evaluator.Matches(Pattern.compile(consumeParens));
    }

    private Evaluator matchesWholeText(boolean z) {
        String str = z ? ":matchesWholeOwnText" : ":matchesWholeText";
        String consumeParens = consumeParens();
        Validate.notEmpty(consumeParens, str.concat("(regex) query must not be empty"));
        if (z) {
            return new Evaluator.MatchesWholeOwnText(Pattern.compile(consumeParens));
        }
        return new Evaluator.MatchesWholeText(Pattern.compile(consumeParens));
    }

    private Evaluator not() {
        String consumeParens = consumeParens();
        Validate.notEmpty(consumeParens, ":not(selector) subselect must not be empty");
        return new StructuralEvaluator.Not(parse(consumeParens));
    }
}
