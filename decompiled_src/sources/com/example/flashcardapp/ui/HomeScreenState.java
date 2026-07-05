package com.example.flashcardapp.ui;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.AnkiDeck;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HomeScreenState.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/example/flashcardapp/ui/HomeScreenState;", "", "()V", "Loaded", "Loading", "Lcom/example/flashcardapp/ui/HomeScreenState$Loaded;", "Lcom/example/flashcardapp/ui/HomeScreenState$Loading;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public abstract class HomeScreenState {
    public static final int $stable = 0;

    public /* synthetic */ HomeScreenState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private HomeScreenState() {
    }

    /* compiled from: HomeScreenState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/example/flashcardapp/ui/HomeScreenState$Loading;", "Lcom/example/flashcardapp/ui/HomeScreenState;", "()V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final class Loading extends HomeScreenState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }
    }

    /* compiled from: HomeScreenState.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/example/flashcardapp/ui/HomeScreenState$Loaded;", "Lcom/example/flashcardapp/ui/HomeScreenState;", "stats", "Lcom/example/flashcardapp/ui/HomeStats;", "decks", "", "Lcom/example/flashcardapp/data/AnkiDeck;", "(Lcom/example/flashcardapp/ui/HomeStats;Ljava/util/List;)V", "getDecks", "()Ljava/util/List;", "getStats", "()Lcom/example/flashcardapp/ui/HomeStats;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final /* data */ class Loaded extends HomeScreenState {
        public static final int $stable = 8;
        private final List<AnkiDeck> decks;
        private final HomeStats stats;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Loaded copy$default(Loaded loaded, HomeStats homeStats, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                homeStats = loaded.stats;
            }
            if ((i & 2) != 0) {
                list = loaded.decks;
            }
            return loaded.copy(homeStats, list);
        }

        /* renamed from: component1, reason: from getter */
        public final HomeStats getStats() {
            return this.stats;
        }

        public final List<AnkiDeck> component2() {
            return this.decks;
        }

        public final Loaded copy(HomeStats stats, List<AnkiDeck> decks) {
            Intrinsics.checkNotNullParameter(stats, "stats");
            Intrinsics.checkNotNullParameter(decks, "decks");
            return new Loaded(stats, decks);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Loaded)) {
                return false;
            }
            Loaded loaded = (Loaded) other;
            return Intrinsics.areEqual(this.stats, loaded.stats) && Intrinsics.areEqual(this.decks, loaded.decks);
        }

        public final List<AnkiDeck> getDecks() {
            return this.decks;
        }

        public final HomeStats getStats() {
            return this.stats;
        }

        public int hashCode() {
            return (this.stats.hashCode() * 31) + this.decks.hashCode();
        }

        public String toString() {
            return "Loaded(stats=" + this.stats + ", decks=" + this.decks + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Loaded(HomeStats stats, List<AnkiDeck> decks) {
            super(null);
            Intrinsics.checkNotNullParameter(stats, "stats");
            Intrinsics.checkNotNullParameter(decks, "decks");
            this.stats = stats;
            this.decks = decks;
        }
    }
}
