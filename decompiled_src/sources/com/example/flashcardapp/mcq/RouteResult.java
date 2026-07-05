package com.example.flashcardapp.mcq;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: McqRouter.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/example/flashcardapp/mcq/RouteResult;", "", "()V", "Failure", "Success", "Lcom/example/flashcardapp/mcq/RouteResult$Failure;", "Lcom/example/flashcardapp/mcq/RouteResult$Success;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public abstract class RouteResult {
    public static final int $stable = 0;

    public /* synthetic */ RouteResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RouteResult() {
    }

    /* compiled from: McqRouter.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/example/flashcardapp/mcq/RouteResult$Success;", "Lcom/example/flashcardapp/mcq/RouteResult;", "formatted", "", "mcq", "Lcom/example/flashcardapp/mcq/Mcq;", "inputType", "Lcom/example/flashcardapp/mcq/InputType;", "(Ljava/lang/String;Lcom/example/flashcardapp/mcq/Mcq;Lcom/example/flashcardapp/mcq/InputType;)V", "getFormatted", "()Ljava/lang/String;", "getInputType", "()Lcom/example/flashcardapp/mcq/InputType;", "getMcq", "()Lcom/example/flashcardapp/mcq/Mcq;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final /* data */ class Success extends RouteResult {
        public static final int $stable = 8;
        private final String formatted;
        private final InputType inputType;
        private final Mcq mcq;

        public static /* synthetic */ Success copy$default(Success success, String str, Mcq mcq, InputType inputType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = success.formatted;
            }
            if ((i & 2) != 0) {
                mcq = success.mcq;
            }
            if ((i & 4) != 0) {
                inputType = success.inputType;
            }
            return success.copy(str, mcq, inputType);
        }

        /* renamed from: component1, reason: from getter */
        public final String getFormatted() {
            return this.formatted;
        }

        /* renamed from: component2, reason: from getter */
        public final Mcq getMcq() {
            return this.mcq;
        }

        /* renamed from: component3, reason: from getter */
        public final InputType getInputType() {
            return this.inputType;
        }

        public final Success copy(String formatted, Mcq mcq, InputType inputType) {
            Intrinsics.checkNotNullParameter(formatted, "formatted");
            Intrinsics.checkNotNullParameter(mcq, "mcq");
            Intrinsics.checkNotNullParameter(inputType, "inputType");
            return new Success(formatted, mcq, inputType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(this.formatted, success.formatted) && Intrinsics.areEqual(this.mcq, success.mcq) && this.inputType == success.inputType;
        }

        public final String getFormatted() {
            return this.formatted;
        }

        public final InputType getInputType() {
            return this.inputType;
        }

        public final Mcq getMcq() {
            return this.mcq;
        }

        public int hashCode() {
            return (((this.formatted.hashCode() * 31) + this.mcq.hashCode()) * 31) + this.inputType.hashCode();
        }

        public String toString() {
            return "Success(formatted=" + this.formatted + ", mcq=" + this.mcq + ", inputType=" + this.inputType + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String formatted, Mcq mcq, InputType inputType) {
            super(null);
            Intrinsics.checkNotNullParameter(formatted, "formatted");
            Intrinsics.checkNotNullParameter(mcq, "mcq");
            Intrinsics.checkNotNullParameter(inputType, "inputType");
            this.formatted = formatted;
            this.mcq = mcq;
            this.inputType = inputType;
        }
    }

    /* compiled from: McqRouter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/example/flashcardapp/mcq/RouteResult$Failure;", "Lcom/example/flashcardapp/mcq/RouteResult;", "reason", "", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final /* data */ class Failure extends RouteResult {
        public static final int $stable = 0;
        private final String reason;

        public static /* synthetic */ Failure copy$default(Failure failure, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failure.reason;
            }
            return failure.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public final Failure copy(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new Failure(reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Failure) && Intrinsics.areEqual(this.reason, ((Failure) other).reason);
        }

        public final String getReason() {
            return this.reason;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "Failure(reason=" + this.reason + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(String reason) {
            super(null);
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }
    }
}
