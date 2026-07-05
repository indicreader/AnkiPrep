package org.jsoup.nodes;

import org.jsoup.internal.SharedConstants;

/* loaded from: classes4.dex */
public class Range {
    static final Range Untracked;
    private static final Position UntrackedPos;
    private final Position end;
    private final Position start;

    public Position end() {
        return this.end;
    }

    public boolean isTracked() {
        return this != Untracked;
    }

    public Position start() {
        return this.start;
    }

    @Deprecated
    public void track(Node node, boolean z) {
    }

    static {
        Position position = new Position(-1, -1, -1);
        UntrackedPos = position;
        Untracked = new Range(position, position);
    }

    public Range(Position position, Position position2) {
        this.start = position;
        this.end = position2;
    }

    public int startPos() {
        return this.start.pos;
    }

    public int endPos() {
        return this.end.pos;
    }

    public boolean isImplicit() {
        if (isTracked()) {
            return this.start.equals(this.end);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Range of(Node node, boolean z) {
        Object userData;
        String str = z ? SharedConstants.RangeKey : SharedConstants.EndRangeKey;
        if (node.hasAttributes() && (userData = node.attributes().userData(str)) != null) {
            return (Range) userData;
        }
        return Untracked;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Range range = (Range) obj;
        if (this.start.equals(range.start)) {
            return this.end.equals(range.end);
        }
        return false;
    }

    public int hashCode() {
        return (this.start.hashCode() * 31) + this.end.hashCode();
    }

    public String toString() {
        return this.start + "-" + this.end;
    }

    /* loaded from: classes4.dex */
    public static class Position {
        private final int columnNumber;
        private final int lineNumber;
        private final int pos;

        public int columnNumber() {
            return this.columnNumber;
        }

        public int hashCode() {
            return (((this.pos * 31) + this.lineNumber) * 31) + this.columnNumber;
        }

        public int lineNumber() {
            return this.lineNumber;
        }

        public int pos() {
            return this.pos;
        }

        public Position(int i, int i2, int i3) {
            this.pos = i;
            this.lineNumber = i2;
            this.columnNumber = i3;
        }

        public boolean isTracked() {
            return this != Range.UntrackedPos;
        }

        public String toString() {
            return this.lineNumber + "," + this.columnNumber + ":" + this.pos;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Position position = (Position) obj;
            return this.pos == position.pos && this.lineNumber == position.lineNumber && this.columnNumber == position.columnNumber;
        }
    }

    /* loaded from: classes4.dex */
    public static class AttributeRange {
        static final AttributeRange UntrackedAttr = new AttributeRange(Range.Untracked, Range.Untracked);
        private final Range nameRange;
        private final Range valueRange;

        public Range nameRange() {
            return this.nameRange;
        }

        public Range valueRange() {
            return this.valueRange;
        }

        public AttributeRange(Range range, Range range2) {
            this.nameRange = range;
            this.valueRange = range2;
        }

        public String toString() {
            return nameRange().toString() + "=" + valueRange().toString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AttributeRange attributeRange = (AttributeRange) obj;
            if (this.nameRange.equals(attributeRange.nameRange)) {
                return this.valueRange.equals(attributeRange.valueRange);
            }
            return false;
        }

        public int hashCode() {
            return (this.nameRange.hashCode() * 31) + this.valueRange.hashCode();
        }
    }
}
