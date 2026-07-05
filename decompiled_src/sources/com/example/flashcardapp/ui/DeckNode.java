package com.example.flashcardapp.ui;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.AnkiDeck;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReviewTab.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00000\bHÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/example/flashcardapp/ui/DeckNode;", "", "deck", "Lcom/example/flashcardapp/data/AnkiDeck;", "shortName", "", "fullPath", "children", "", "(Lcom/example/flashcardapp/data/AnkiDeck;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getChildren", "()Ljava/util/List;", "getDeck", "()Lcom/example/flashcardapp/data/AnkiDeck;", "getFullPath", "()Ljava/lang/String;", "getShortName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class DeckNode {
    public static final int $stable = 8;
    private final List<DeckNode> children;
    private final AnkiDeck deck;
    private final String fullPath;
    private final String shortName;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeckNode copy$default(DeckNode deckNode, AnkiDeck ankiDeck, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            ankiDeck = deckNode.deck;
        }
        if ((i & 2) != 0) {
            str = deckNode.shortName;
        }
        if ((i & 4) != 0) {
            str2 = deckNode.fullPath;
        }
        if ((i & 8) != 0) {
            list = deckNode.children;
        }
        return deckNode.copy(ankiDeck, str, str2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final AnkiDeck getDeck() {
        return this.deck;
    }

    /* renamed from: component2, reason: from getter */
    public final String getShortName() {
        return this.shortName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFullPath() {
        return this.fullPath;
    }

    public final List<DeckNode> component4() {
        return this.children;
    }

    public final DeckNode copy(AnkiDeck deck, String shortName, String fullPath, List<DeckNode> children) {
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        Intrinsics.checkNotNullParameter(children, "children");
        return new DeckNode(deck, shortName, fullPath, children);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeckNode)) {
            return false;
        }
        DeckNode deckNode = (DeckNode) other;
        return Intrinsics.areEqual(this.deck, deckNode.deck) && Intrinsics.areEqual(this.shortName, deckNode.shortName) && Intrinsics.areEqual(this.fullPath, deckNode.fullPath) && Intrinsics.areEqual(this.children, deckNode.children);
    }

    public final List<DeckNode> getChildren() {
        return this.children;
    }

    public final AnkiDeck getDeck() {
        return this.deck;
    }

    public final String getFullPath() {
        return this.fullPath;
    }

    public final String getShortName() {
        return this.shortName;
    }

    public int hashCode() {
        AnkiDeck ankiDeck = this.deck;
        return ((((((ankiDeck == null ? 0 : ankiDeck.hashCode()) * 31) + this.shortName.hashCode()) * 31) + this.fullPath.hashCode()) * 31) + this.children.hashCode();
    }

    public String toString() {
        return "DeckNode(deck=" + this.deck + ", shortName=" + this.shortName + ", fullPath=" + this.fullPath + ", children=" + this.children + ")";
    }

    public DeckNode(AnkiDeck ankiDeck, String shortName, String fullPath, List<DeckNode> children) {
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        Intrinsics.checkNotNullParameter(children, "children");
        this.deck = ankiDeck;
        this.shortName = shortName;
        this.fullPath = fullPath;
        this.children = children;
    }

    public /* synthetic */ DeckNode(AnkiDeck ankiDeck, String str, String str2, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ankiDeck, str, str2, (i & 8) != 0 ? new ArrayList() : arrayList);
    }
}
