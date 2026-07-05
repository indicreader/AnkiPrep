package org.jsoup.select;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.function.Supplier;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.NodeIterator;
import org.jsoup.select.StructuralEvaluator;

/* loaded from: classes4.dex */
abstract class StructuralEvaluator extends Evaluator {
    final Evaluator evaluator;
    final ThreadLocal<IdentityHashMap<Element, IdentityHashMap<Element, Boolean>>> threadMemo = ThreadLocal.withInitial(new Supplier() { // from class: org.jsoup.select.StructuralEvaluator$$ExternalSyntheticLambda0
        @Override // java.util.function.Supplier
        public final Object get() {
            return StructuralEvaluator.$r8$lambda$yuj6C5RPrSJ9yr0pJh0ShEfnyRg();
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class Root extends Evaluator {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jsoup.select.Evaluator
        public int cost() {
            return 1;
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return element == element2;
        }

        public String toString() {
            return "";
        }
    }

    public static /* synthetic */ IdentityHashMap $r8$lambda$yuj6C5RPrSJ9yr0pJh0ShEfnyRg() {
        return new IdentityHashMap();
    }

    public StructuralEvaluator(Evaluator evaluator) {
        this.evaluator = evaluator;
    }

    boolean memoMatches(Element element, Element element2) {
        IdentityHashMap<Element, IdentityHashMap<Element, Boolean>> identityHashMap = this.threadMemo.get();
        IdentityHashMap<Element, Boolean> identityHashMap2 = identityHashMap.get(element);
        if (identityHashMap2 == null) {
            identityHashMap2 = new IdentityHashMap<>();
            identityHashMap.put(element, identityHashMap2);
        }
        Boolean bool = identityHashMap2.get(element2);
        if (bool == null) {
            bool = Boolean.valueOf(this.evaluator.m8203lambda$asPredicate$0$orgjsoupselectEvaluator(element, element2));
            identityHashMap2.put(element2, bool);
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jsoup.select.Evaluator
    public void reset() {
        this.threadMemo.get().clear();
        super.reset();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class Has extends StructuralEvaluator {
        static final ThreadLocal<NodeIterator<Element>> ThreadElementIter = ThreadLocal.withInitial(new Supplier() { // from class: org.jsoup.select.StructuralEvaluator$Has$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return StructuralEvaluator.Has.lambda$static$0();
            }
        });

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ NodeIterator lambda$static$0() {
            return new NodeIterator(new Element("html"), Element.class);
        }

        public Has(Evaluator evaluator) {
            super(evaluator);
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            NodeIterator<Element> nodeIterator = ThreadElementIter.get();
            nodeIterator.restart(element2);
            while (nodeIterator.hasNext()) {
                Element next = nodeIterator.next();
                if (next != element2 && this.evaluator.m8203lambda$asPredicate$0$orgjsoupselectEvaluator(element2, next)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jsoup.select.Evaluator
        public int cost() {
            return this.evaluator.cost() * 10;
        }

        public String toString() {
            return String.format(":has(%s)", this.evaluator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class Is extends StructuralEvaluator {
        public Is(Evaluator evaluator) {
            super(evaluator);
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return this.evaluator.m8203lambda$asPredicate$0$orgjsoupselectEvaluator(element, element2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jsoup.select.Evaluator
        public int cost() {
            return this.evaluator.cost() + 2;
        }

        public String toString() {
            return String.format(":is(%s)", this.evaluator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class Not extends StructuralEvaluator {
        public Not(Evaluator evaluator) {
            super(evaluator);
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            return !memoMatches(element, element2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jsoup.select.Evaluator
        public int cost() {
            return this.evaluator.cost() + 2;
        }

        public String toString() {
            return String.format(":not(%s)", this.evaluator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class Parent extends StructuralEvaluator {
        public Parent(Evaluator evaluator) {
            super(evaluator);
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            for (Element parent = element2.parent(); parent != null; parent = parent.parent()) {
                if (memoMatches(element, parent)) {
                    return true;
                }
                if (parent == element) {
                    break;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jsoup.select.Evaluator
        public int cost() {
            return this.evaluator.cost() * 2;
        }

        public String toString() {
            return String.format("%s ", this.evaluator);
        }
    }

    @Deprecated
    /* loaded from: classes4.dex */
    static class ImmediateParent extends StructuralEvaluator {
        public ImmediateParent(Evaluator evaluator) {
            super(evaluator);
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            Element parent;
            return (element == element2 || (parent = element2.parent()) == null || !memoMatches(element, parent)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jsoup.select.Evaluator
        public int cost() {
            return this.evaluator.cost() + 1;
        }

        public String toString() {
            return String.format("%s > ", this.evaluator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class ImmediateParentRun extends Evaluator {
        int cost;
        final ArrayList<Evaluator> evaluators;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jsoup.select.Evaluator
        public int cost() {
            return this.cost;
        }

        public ImmediateParentRun(Evaluator evaluator) {
            ArrayList<Evaluator> arrayList = new ArrayList<>();
            this.evaluators = arrayList;
            this.cost = 2;
            arrayList.add(evaluator);
            this.cost += evaluator.cost();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void add(Evaluator evaluator) {
            this.evaluators.add(evaluator);
            this.cost += evaluator.cost();
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            if (element2 == element) {
                return false;
            }
            for (int size = this.evaluators.size() - 1; size >= 0; size--) {
                if (element2 == null || !this.evaluators.get(size).m8203lambda$asPredicate$0$orgjsoupselectEvaluator(element, element2)) {
                    return false;
                }
                element2 = element2.parent();
            }
            return true;
        }

        public String toString() {
            return StringUtil.join(this.evaluators, " > ");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class PreviousSibling extends StructuralEvaluator {
        public PreviousSibling(Evaluator evaluator) {
            super(evaluator);
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            for (Element firstElementSibling = element2.firstElementSibling(); firstElementSibling != null && firstElementSibling != element2; firstElementSibling = firstElementSibling.nextElementSibling()) {
                if (memoMatches(element, firstElementSibling)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jsoup.select.Evaluator
        public int cost() {
            return this.evaluator.cost() * 3;
        }

        public String toString() {
            return String.format("%s ~ ", this.evaluator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class ImmediatePreviousSibling extends StructuralEvaluator {
        public ImmediatePreviousSibling(Evaluator evaluator) {
            super(evaluator);
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            Element previousElementSibling;
            return (element == element2 || (previousElementSibling = element2.previousElementSibling()) == null || !memoMatches(element, previousElementSibling)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jsoup.select.Evaluator
        public int cost() {
            return this.evaluator.cost() + 2;
        }

        public String toString() {
            return String.format("%s + ", this.evaluator);
        }
    }
}
