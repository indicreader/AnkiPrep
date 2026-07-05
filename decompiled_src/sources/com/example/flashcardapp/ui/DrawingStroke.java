package com.example.flashcardapp.ui;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuizScreen.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0016\u0010\u0018\u001a\u00020\u0006HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u000bJ\t\u0010\u001a\u001a\u00020\bHÆ\u0003J7\u0010\u001b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Lcom/example/flashcardapp/ui/DrawingStroke;", "", "points", "", "Landroidx/compose/ui/geometry/Offset;", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "", "(Ljava/util/List;JFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "path", "Landroidx/compose/ui/graphics/Path;", "getPath", "()Landroidx/compose/ui/graphics/Path;", "path$delegate", "Lkotlin/Lazy;", "getPoints", "()Ljava/util/List;", "getStrokeWidth", "()F", "component1", "component2", "component2-0d7_KjU", "component3", "copy", "copy-bw27NRU", "(Ljava/util/List;JF)Lcom/example/flashcardapp/ui/DrawingStroke;", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class DrawingStroke {
    public static final int $stable = 8;
    private final long color;

    /* renamed from: path$delegate, reason: from kotlin metadata */
    private final Lazy path;
    private final List<Offset> points;
    private final float strokeWidth;

    public /* synthetic */ DrawingStroke(List list, long j, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, j, f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: copy-bw27NRU$default, reason: not valid java name */
    public static /* synthetic */ DrawingStroke m6324copybw27NRU$default(DrawingStroke drawingStroke, List list, long j, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            list = drawingStroke.points;
        }
        if ((i & 2) != 0) {
            j = drawingStroke.color;
        }
        if ((i & 4) != 0) {
            f = drawingStroke.strokeWidth;
        }
        return drawingStroke.m6326copybw27NRU(list, j, f);
    }

    public final List<Offset> component1() {
        return this.points;
    }

    /* renamed from: component2-0d7_KjU, reason: not valid java name and from getter */
    public final long getColor() {
        return this.color;
    }

    /* renamed from: component3, reason: from getter */
    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    /* renamed from: copy-bw27NRU, reason: not valid java name */
    public final DrawingStroke m6326copybw27NRU(List<Offset> points, long color, float strokeWidth) {
        Intrinsics.checkNotNullParameter(points, "points");
        return new DrawingStroke(points, color, strokeWidth, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DrawingStroke)) {
            return false;
        }
        DrawingStroke drawingStroke = (DrawingStroke) other;
        return Intrinsics.areEqual(this.points, drawingStroke.points) && Color.m3418equalsimpl0(this.color, drawingStroke.color) && Float.compare(this.strokeWidth, drawingStroke.strokeWidth) == 0;
    }

    /* renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m6327getColor0d7_KjU() {
        return this.color;
    }

    public final List<Offset> getPoints() {
        return this.points;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    public int hashCode() {
        return (((this.points.hashCode() * 31) + Color.m3424hashCodeimpl(this.color)) * 31) + Float.hashCode(this.strokeWidth);
    }

    public String toString() {
        return "DrawingStroke(points=" + this.points + ", color=" + Color.m3425toStringimpl(this.color) + ", strokeWidth=" + this.strokeWidth + ")";
    }

    private DrawingStroke(List<Offset> points, long j, float f) {
        Intrinsics.checkNotNullParameter(points, "points");
        this.points = points;
        this.color = j;
        this.strokeWidth = f;
        this.path = LazyKt.lazy(new Function0<Path>() { // from class: com.example.flashcardapp.ui.DrawingStroke$path$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Path invoke() {
                Path Path = AndroidPath_androidKt.Path();
                DrawingStroke drawingStroke = DrawingStroke.this;
                if (drawingStroke.getPoints().size() >= 2) {
                    long packedValue = ((Offset) CollectionsKt.first((List) drawingStroke.getPoints())).getPackedValue();
                    Path.moveTo(Offset.m3176getXimpl(packedValue), Offset.m3177getYimpl(packedValue));
                    int size = drawingStroke.getPoints().size();
                    for (int i = 1; i < size; i++) {
                        long packedValue2 = drawingStroke.getPoints().get(i).getPackedValue();
                        Path.lineTo(Offset.m3176getXimpl(packedValue2), Offset.m3177getYimpl(packedValue2));
                    }
                }
                return Path;
            }
        });
    }

    public /* synthetic */ DrawingStroke(List list, long j, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, j, (i & 4) != 0 ? 6.0f : f, null);
    }

    public final Path getPath() {
        return (Path) this.path.getValue();
    }
}
