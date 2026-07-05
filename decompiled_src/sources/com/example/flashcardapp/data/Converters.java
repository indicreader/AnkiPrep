package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Converters.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\n\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/example/flashcardapp/data/Converters;", "", "()V", "gson", "Lcom/google/gson/Gson;", "fromTagsList", "", "tags", "", "toTagsList", "tagsJson", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class Converters {
    public static final int $stable = 8;
    private final Gson gson = new Gson();

    public final String fromTagsList(List<String> tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        String json = this.gson.toJson(tags);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public final List<String> toTagsList(String tagsJson) {
        Intrinsics.checkNotNullParameter(tagsJson, "tagsJson");
        if (StringsKt.isBlank(tagsJson)) {
            return CollectionsKt.emptyList();
        }
        try {
            List<String> list = (List) this.gson.fromJson(tagsJson, new TypeToken<List<? extends String>>() { // from class: com.example.flashcardapp.data.Converters$toTagsList$type$1
            }.getType());
            return list == null ? CollectionsKt.emptyList() : list;
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }
}
