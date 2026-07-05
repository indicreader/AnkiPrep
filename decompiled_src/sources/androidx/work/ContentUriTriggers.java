package androidx.work;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class ContentUriTriggers {
    private final Set<Trigger> mTriggers = new HashSet();

    public Set<Trigger> getTriggers() {
        return this.mTriggers;
    }

    public void add(Uri uri, boolean triggerForDescendants) {
        this.mTriggers.add(new Trigger(uri, triggerForDescendants));
    }

    public int size() {
        return this.mTriggers.size();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return this.mTriggers.equals(((ContentUriTriggers) o).mTriggers);
    }

    public int hashCode() {
        return this.mTriggers.hashCode();
    }

    /* loaded from: classes2.dex */
    public static final class Trigger {
        private final boolean mTriggerForDescendants;
        private final Uri mUri;

        public Uri getUri() {
            return this.mUri;
        }

        public boolean shouldTriggerForDescendants() {
            return this.mTriggerForDescendants;
        }

        Trigger(Uri uri, boolean triggerForDescendants) {
            this.mUri = uri;
            this.mTriggerForDescendants = triggerForDescendants;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Trigger trigger = (Trigger) o;
            return this.mTriggerForDescendants == trigger.mTriggerForDescendants && this.mUri.equals(trigger.mUri);
        }

        public int hashCode() {
            return (this.mUri.hashCode() * 31) + (this.mTriggerForDescendants ? 1 : 0);
        }
    }
}
