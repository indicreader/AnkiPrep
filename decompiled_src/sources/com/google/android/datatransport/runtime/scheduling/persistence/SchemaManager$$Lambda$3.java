package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

/* loaded from: classes2.dex */
final /* synthetic */ class SchemaManager$$Lambda$3 implements SchemaManager.Migration {
    private static final SchemaManager$$Lambda$3 instance = new SchemaManager$$Lambda$3();

    private SchemaManager$$Lambda$3() {
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
    public void upgrade(SQLiteDatabase sQLiteDatabase) {
        SchemaManager.lambda$static$2(sQLiteDatabase);
    }
}
