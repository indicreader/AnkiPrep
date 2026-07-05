package org.jsoup.select;

import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.jsoup.nodes.Element;

/* loaded from: classes4.dex */
public class Collector {
    private Collector() {
    }

    public static Elements collect(Evaluator evaluator, Element element) {
        evaluator.reset();
        return (Elements) element.stream().filter(evaluator.asPredicate(element)).collect(Collectors.toCollection(new Supplier() { // from class: org.jsoup.select.Collector$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new Elements();
            }
        }));
    }

    public static Element findFirst(Evaluator evaluator, Element element) {
        evaluator.reset();
        return element.stream().filter(evaluator.asPredicate(element)).findFirst().orElse(null);
    }
}
