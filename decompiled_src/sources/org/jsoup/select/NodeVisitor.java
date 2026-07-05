package org.jsoup.select;

import org.jsoup.nodes.Node;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface NodeVisitor {
    void head(Node node, int i);

    default void tail(Node node, int i) {
    }
}
