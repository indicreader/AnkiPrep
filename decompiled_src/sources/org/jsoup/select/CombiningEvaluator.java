package org.jsoup.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Element;

/* loaded from: classes4.dex */
public abstract class CombiningEvaluator extends Evaluator {
    private static final Comparator<Evaluator> costComparator = new Comparator() { // from class: org.jsoup.select.CombiningEvaluator$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return CombiningEvaluator.lambda$static$0((Evaluator) obj, (Evaluator) obj2);
        }
    };
    int cost;
    final ArrayList<Evaluator> evaluators;
    int num;
    final ArrayList<Evaluator> sortedEvaluators;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jsoup.select.Evaluator
    public int cost() {
        return this.cost;
    }

    CombiningEvaluator() {
        this.num = 0;
        this.cost = 0;
        this.evaluators = new ArrayList<>();
        this.sortedEvaluators = new ArrayList<>();
    }

    CombiningEvaluator(Collection<Evaluator> collection) {
        this();
        this.evaluators.addAll(collection);
        updateEvaluators();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jsoup.select.Evaluator
    public void reset() {
        Iterator<Evaluator> it = this.evaluators.iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
        super.reset();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Evaluator rightMostEvaluator() {
        int i = this.num;
        if (i > 0) {
            return this.evaluators.get(i - 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void replaceRightMostEvaluator(Evaluator evaluator) {
        this.evaluators.set(this.num - 1, evaluator);
        updateEvaluators();
    }

    void updateEvaluators() {
        this.num = this.evaluators.size();
        this.cost = 0;
        Iterator<Evaluator> it = this.evaluators.iterator();
        while (it.hasNext()) {
            this.cost += it.next().cost();
        }
        this.sortedEvaluators.clear();
        this.sortedEvaluators.addAll(this.evaluators);
        Collections.sort(this.sortedEvaluators, costComparator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int lambda$static$0(Evaluator evaluator, Evaluator evaluator2) {
        return evaluator.cost() - evaluator2.cost();
    }

    /* loaded from: classes4.dex */
    public static final class And extends CombiningEvaluator {
        /* JADX INFO: Access modifiers changed from: package-private */
        public And(Collection<Evaluator> collection) {
            super(collection);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public And(Evaluator... evaluatorArr) {
            this(Arrays.asList(evaluatorArr));
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            for (int i = 0; i < this.num; i++) {
                if (!this.sortedEvaluators.get(i).m8203lambda$asPredicate$0$orgjsoupselectEvaluator(element, element2)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return StringUtil.join(this.evaluators, "");
        }
    }

    /* loaded from: classes4.dex */
    public static final class Or extends CombiningEvaluator {
        Or(Collection<Evaluator> collection) {
            if (this.num > 1) {
                this.evaluators.add(new And(collection));
            } else {
                this.evaluators.addAll(collection);
            }
            updateEvaluators();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Or(Evaluator... evaluatorArr) {
            this(Arrays.asList(evaluatorArr));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Or() {
        }

        public void add(Evaluator evaluator) {
            this.evaluators.add(evaluator);
            updateEvaluators();
        }

        @Override // org.jsoup.select.Evaluator
        /* renamed from: matches */
        public boolean m8203lambda$asPredicate$0$orgjsoupselectEvaluator(Element element, Element element2) {
            for (int i = 0; i < this.num; i++) {
                if (this.sortedEvaluators.get(i).m8203lambda$asPredicate$0$orgjsoupselectEvaluator(element, element2)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return StringUtil.join(this.evaluators, ", ");
        }
    }
}
