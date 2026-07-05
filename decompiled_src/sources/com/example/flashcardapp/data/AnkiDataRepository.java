package com.example.flashcardapp.data;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.dao.AliasDao;
import com.example.flashcardapp.data.dao.CardAttemptDao;
import com.example.flashcardapp.data.dao.CardDao;
import com.example.flashcardapp.data.dao.CardOverrideDao;
import com.example.flashcardapp.data.dao.CardStateDao;
import com.example.flashcardapp.data.dao.CardUserMetadataDao;
import com.example.flashcardapp.data.dao.DeckDao;
import com.example.flashcardapp.data.dao.SessionRecordDao;
import com.example.flashcardapp.data.entities.AliasEntity;
import com.example.flashcardapp.data.entities.CardAttemptEntity;
import com.example.flashcardapp.data.entities.CardEntity;
import com.example.flashcardapp.data.entities.CardOverrideEntity;
import com.example.flashcardapp.data.entities.CardUserMetadataEntity;
import com.example.flashcardapp.data.entities.DeckEntity;
import com.example.flashcardapp.data.entities.SessionRecordEntity;
import com.example.flashcardapp.fsrs.FsrsScheduler;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: AnkiDataRepository.kt */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u009e\u00012\u00020\u0001:\u0002\u009e\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J`\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\b\b\u0002\u0010'\u001a\u00020$2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010$H\u0086@¢\u0006\u0002\u0010,J\u001e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020$H\u0086@¢\u0006\u0002\u00101J\"\u00102\u001a\b\u0012\u0004\u0012\u000204032\f\u00105\u001a\b\u0012\u0004\u0012\u00020403H\u0082@¢\u0006\u0002\u00106J\u000e\u00107\u001a\u000208H\u0086@¢\u0006\u0002\u00109J\u0016\u0010:\u001a\u0002082\u0006\u0010;\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010<J\u0016\u0010=\u001a\u0002082\u0006\u0010>\u001a\u00020$H\u0086@¢\u0006\u0002\u0010?J\u0016\u0010@\u001a\u0002082\u0006\u0010A\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010<J\u0016\u0010B\u001a\u0002082\u0006\u0010;\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010<J\u0016\u0010C\u001a\u00020D2\u0006\u0010A\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010<J&\u0010E\u001a\u00020.2\u0006\u0010;\u001a\u00020\"2\u0006\u0010>\u001a\u00020$2\u0006\u0010F\u001a\u00020GH\u0086@¢\u0006\u0002\u0010HJ\u0014\u0010I\u001a\b\u0012\u0004\u0012\u00020J03H\u0086@¢\u0006\u0002\u00109J\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00020L03H\u0086@¢\u0006\u0002\u00109J\u0014\u0010M\u001a\b\u0012\u0004\u0012\u00020403H\u0086@¢\u0006\u0002\u00109J\u0014\u0010N\u001a\b\u0012\u0004\u0012\u00020O03H\u0086@¢\u0006\u0002\u00109J\u0014\u0010P\u001a\b\u0012\u0004\u0012\u00020Q03H\u0086@¢\u0006\u0002\u00109J\u0018\u0010R\u001a\u0004\u0018\u0001042\u0006\u0010A\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010<J\u000e\u0010S\u001a\u00020DH\u0086@¢\u0006\u0002\u00109J\u0016\u0010T\u001a\u00020D2\u0006\u0010;\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010<J\u0016\u0010U\u001a\u00020Q2\u0006\u0010A\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010<J\u001c\u0010V\u001a\b\u0012\u0004\u0012\u000204032\u0006\u0010;\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010<J\u001c\u0010W\u001a\b\u0012\u0004\u0012\u000204032\u0006\u0010X\u001a\u00020$H\u0086@¢\u0006\u0002\u0010?J\u000e\u0010Y\u001a\u00020DH\u0086@¢\u0006\u0002\u00109J\u000e\u0010Z\u001a\u00020$2\u0006\u0010F\u001a\u00020GJ\u0018\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010A\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010<J\u000e\u0010]\u001a\u00020DH\u0086@¢\u0006\u0002\u00109J\u000e\u0010^\u001a\u00020DH\u0086@¢\u0006\u0002\u00109J\u0014\u0010_\u001a\b\u0012\u0004\u0012\u00020O03H\u0086@¢\u0006\u0002\u00109J\u001e\u0010`\u001a\b\u0012\u0004\u0012\u000204032\b\b\u0002\u0010a\u001a\u00020DH\u0086@¢\u0006\u0002\u0010bJ\u000e\u0010c\u001a\u00020DH\u0086@¢\u0006\u0002\u00109J\u0014\u0010d\u001a\b\u0012\u0004\u0012\u00020e03H\u0086@¢\u0006\u0002\u00109J\u001c\u0010f\u001a\b\u0012\u0004\u0012\u00020O032\u0006\u0010g\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010<J\u000e\u0010h\u001a\u00020DH\u0086@¢\u0006\u0002\u00109J\u000e\u0010i\u001a\u00020DH\u0086@¢\u0006\u0002\u00109J\u000e\u0010j\u001a\u00020DH\u0086@¢\u0006\u0002\u00109J.\u0010k\u001a\u00020l2\u0006\u0010F\u001a\u00020G2\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010n\u001a\u0004\u0018\u00010$H\u0086@¢\u0006\u0002\u0010oJ \u0010p\u001a\u00020l2\u0006\u0010F\u001a\u00020G2\b\b\u0002\u0010q\u001a\u00020$H\u0086@¢\u0006\u0002\u0010rJ0\u0010s\u001a\u00020l2\u0006\u0010F\u001a\u00020G2\u0006\u0010m\u001a\u00020\"2\u0006\u0010n\u001a\u00020$2\b\b\u0002\u0010q\u001a\u00020$H\u0086@¢\u0006\u0002\u0010tJ.\u0010u\u001a\u00020l2\u0006\u0010F\u001a\u00020G2\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010n\u001a\u0004\u0018\u00010$H\u0086@¢\u0006\u0002\u0010oJ\u0016\u0010v\u001a\u00020l2\u0006\u0010F\u001a\u00020GH\u0086@¢\u0006\u0002\u0010wJ\u000e\u0010x\u001a\u00020.H\u0086@¢\u0006\u0002\u00109J\u000e\u0010y\u001a\u000208H\u0086@¢\u0006\u0002\u00109J\u001e\u0010z\u001a\u0002082\u0006\u0010{\u001a\u00020\"2\u0006\u0010m\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010|J\u0012\u0010}\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Q030~J\u001b\u0010\u007f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L030~2\u0007\u0010\u0080\u0001\u001a\u00020\"J\u001b\u0010\u0081\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000204030~2\u0006\u0010;\u001a\u00020\"J\u0013\u0010\u0082\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020O030~J\u0017\u0010\u0083\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\\0~2\u0006\u0010A\u001a\u00020\"J\u0013\u0010\u0084\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020e030~J\u0015\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020$032\u0006\u0010'\u001a\u00020$J!\u0010\u0086\u0001\u001a\u0002082\u0006\u0010;\u001a\u00020\"2\u0007\u0010\u0087\u0001\u001a\u00020$H\u0086@¢\u0006\u0003\u0010\u0088\u0001J0\u0010\u0089\u0001\u001a\u0004\u0018\u00010\"2\u0007\u0010\u008a\u0001\u001a\u00020$2\u0014\u0010\u008b\u0001\u001a\u000f\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0\u008c\u0001H\u0002¢\u0006\u0003\u0010\u008d\u0001J\u001e\u0010\u008e\u0001\u001a\u0002082\r\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020L03H\u0086@¢\u0006\u0002\u00106J\u0019\u0010\u0090\u0001\u001a\u00020\"2\u0007\u0010\u0091\u0001\u001a\u00020eH\u0086@¢\u0006\u0003\u0010\u0092\u0001J!\u0010\u0093\u0001\u001a\u00020D2\u0006\u0010A\u001a\u00020\"2\u0007\u0010\u0094\u0001\u001a\u00020DH\u0086@¢\u0006\u0003\u0010\u0095\u0001J!\u0010\u0096\u0001\u001a\u00020D2\u0006\u0010A\u001a\u00020\"2\u0007\u0010\u0097\u0001\u001a\u00020.H\u0086@¢\u0006\u0003\u0010\u0098\u0001J\u0010\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0086@¢\u0006\u0002\u00109J\u0019\u0010\u009b\u0001\u001a\u00020D2\u0007\u0010\u009c\u0001\u001a\u00020\\H\u0086@¢\u0006\u0003\u0010\u009d\u0001R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u009f\u0001"}, d2 = {"Lcom/example/flashcardapp/data/AnkiDataRepository;", "", "context", "Landroid/content/Context;", "deckDao", "Lcom/example/flashcardapp/data/dao/DeckDao;", "cardDao", "Lcom/example/flashcardapp/data/dao/CardDao;", "sessionRecordDao", "Lcom/example/flashcardapp/data/dao/SessionRecordDao;", "cardOverrideDao", "Lcom/example/flashcardapp/data/dao/CardOverrideDao;", "cardAttemptDao", "Lcom/example/flashcardapp/data/dao/CardAttemptDao;", "cardStateDao", "Lcom/example/flashcardapp/data/dao/CardStateDao;", "aliasDao", "Lcom/example/flashcardapp/data/dao/AliasDao;", "cardUserMetadataDao", "Lcom/example/flashcardapp/data/dao/CardUserMetadataDao;", "(Landroid/content/Context;Lcom/example/flashcardapp/data/dao/DeckDao;Lcom/example/flashcardapp/data/dao/CardDao;Lcom/example/flashcardapp/data/dao/SessionRecordDao;Lcom/example/flashcardapp/data/dao/CardOverrideDao;Lcom/example/flashcardapp/data/dao/CardAttemptDao;Lcom/example/flashcardapp/data/dao/CardStateDao;Lcom/example/flashcardapp/data/dao/AliasDao;Lcom/example/flashcardapp/data/dao/CardUserMetadataDao;)V", "getAliasDao", "()Lcom/example/flashcardapp/data/dao/AliasDao;", "getCardStateDao", "()Lcom/example/flashcardapp/data/dao/CardStateDao;", "getCardUserMetadataDao", "()Lcom/example/flashcardapp/data/dao/CardUserMetadataDao;", "fsrsScheduler", "Lcom/example/flashcardapp/fsrs/FsrsScheduler;", "getFsrsScheduler", "()Lcom/example/flashcardapp/fsrs/FsrsScheduler;", "gson", "Lcom/google/gson/Gson;", "addCard", "", "deckHierarchy", "", "front", "back", "tagsJson", "frontImage", "backImage", "explanationImage", "optionImagesJson", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addCustomAlias", "", "name", "alias", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyOverrides", "", "Lcom/example/flashcardapp/data/entities/CardEntity;", "cards", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCache", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearDeckProgress", "deckId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDeck", "deckName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCard", "cardId", "deleteDeck", "deleteOverride", "", "exportApkg", "uri", "Landroid/net/Uri;", "(JLjava/lang/String;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAliases", "Lcom/example/flashcardapp/data/entities/AliasEntity;", "getAllCardAttempts", "Lcom/example/flashcardapp/data/entities/CardAttemptEntity;", "getAllCards", "getAllDecks", "Lcom/example/flashcardapp/data/entities/DeckEntity;", "getAllUserMetadataOnce", "Lcom/example/flashcardapp/data/entities/CardUserMetadataEntity;", "getCardById", "getCardCount", "getCardCountForDeck", "getCardUserMetadata", "getCardsForDeck", "getCardsForHierarchy", "rootPath", "getDeckCount", "getFileName", "getOverrideForCard", "Lcom/example/flashcardapp/data/entities/CardOverrideEntity;", "getPracticeSessionCount", "getRevisionSessionCount", "getRootDecks", "getSampleCards", "limit", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSessionCount", "getSessionRecords", "Lcom/example/flashcardapp/data/entities/SessionRecordEntity;", "getSubDecks", "parentDeckId", "getTestSessionCount", "getTotalCorrectAnswers", "getTotalQuestionsAnswered", "importApkg", "Lcom/example/flashcardapp/data/ImportResult;", "targetDeckId", "targetDeckName", "(Landroid/net/Uri;Ljava/lang/Long;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importCsv", "duplicateStrategy", "(Landroid/net/Uri;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importCsvIntoExistingDeck", "(Landroid/net/Uri;JLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importEpub", "importFile", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCachePopulated", "loadDefaultAliasesIfNeeded", "mergeDecks", "sourceDeckId", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeAllUserMetadata", "Lkotlinx/coroutines/flow/Flow;", "observeAttemptsSince", "sinceTimestamp", "observeCardsForDeck", "observeDecks", "observeOverrideForCard", "observeSessionRecords", "parseTags", "renameDeck", "newLeafName", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveSubDeckId", "deckPath", "deckPathToId", "", "(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/Long;", "saveCardAttempts", "attempts", "saveSessionRecord", "record", "(Lcom/example/flashcardapp/data/entities/SessionRecordEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCardRating", "rating", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCardStarred", "isStarred", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncFromAnkiDroid", "Lcom/example/flashcardapp/data/SyncResult;", "upsertOverride", "override", "(Lcom/example/flashcardapp/data/entities/CardOverrideEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class AnkiDataRepository {
    private static volatile AnkiDataRepository INSTANCE = null;
    private static final String TAG = "AnkiDataRepository";
    private final AliasDao aliasDao;
    private final CardAttemptDao cardAttemptDao;
    private final CardDao cardDao;
    private final CardOverrideDao cardOverrideDao;
    private final CardStateDao cardStateDao;
    private final CardUserMetadataDao cardUserMetadataDao;
    private final Context context;
    private final DeckDao deckDao;
    private final FsrsScheduler fsrsScheduler;
    private final Gson gson;
    private final SessionRecordDao sessionRecordDao;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public final AliasDao getAliasDao() {
        return this.aliasDao;
    }

    public final CardStateDao getCardStateDao() {
        return this.cardStateDao;
    }

    public final CardUserMetadataDao getCardUserMetadataDao() {
        return this.cardUserMetadataDao;
    }

    public final FsrsScheduler getFsrsScheduler() {
        return this.fsrsScheduler;
    }

    public AnkiDataRepository(Context context, DeckDao deckDao, CardDao cardDao, SessionRecordDao sessionRecordDao, CardOverrideDao cardOverrideDao, CardAttemptDao cardAttemptDao, CardStateDao cardStateDao, AliasDao aliasDao, CardUserMetadataDao cardUserMetadataDao) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(deckDao, "deckDao");
        Intrinsics.checkNotNullParameter(cardDao, "cardDao");
        Intrinsics.checkNotNullParameter(sessionRecordDao, "sessionRecordDao");
        Intrinsics.checkNotNullParameter(cardOverrideDao, "cardOverrideDao");
        Intrinsics.checkNotNullParameter(cardAttemptDao, "cardAttemptDao");
        Intrinsics.checkNotNullParameter(cardStateDao, "cardStateDao");
        Intrinsics.checkNotNullParameter(aliasDao, "aliasDao");
        Intrinsics.checkNotNullParameter(cardUserMetadataDao, "cardUserMetadataDao");
        this.context = context;
        this.deckDao = deckDao;
        this.cardDao = cardDao;
        this.sessionRecordDao = sessionRecordDao;
        this.cardOverrideDao = cardOverrideDao;
        this.cardAttemptDao = cardAttemptDao;
        this.cardStateDao = cardStateDao;
        this.aliasDao = aliasDao;
        this.cardUserMetadataDao = cardUserMetadataDao;
        this.gson = new Gson();
        this.fsrsScheduler = new FsrsScheduler(cardStateDao);
    }

    /* compiled from: AnkiDataRepository.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/example/flashcardapp/data/AnkiDataRepository$Companion;", "", "()V", "INSTANCE", "Lcom/example/flashcardapp/data/AnkiDataRepository;", "TAG", "", "getInstance", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnkiDataRepository getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            AnkiDataRepository ankiDataRepository = AnkiDataRepository.INSTANCE;
            if (ankiDataRepository == null) {
                synchronized (this) {
                    ankiDataRepository = AnkiDataRepository.INSTANCE;
                    if (ankiDataRepository == null) {
                        Companion companion = AnkiDataRepository.INSTANCE;
                        AppDatabase companion2 = AppDatabase.INSTANCE.getInstance(context);
                        Context applicationContext = context.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                        AnkiDataRepository ankiDataRepository2 = new AnkiDataRepository(applicationContext, companion2.deckDao(), companion2.cardDao(), companion2.sessionRecordDao(), companion2.cardOverrideDao(), companion2.cardAttemptDao(), companion2.cardStateDao(), companion2.aliasDao(), companion2.cardUserMetadataDao());
                        AnkiDataRepository.INSTANCE = ankiDataRepository2;
                        ankiDataRepository = ankiDataRepository2;
                    }
                }
            }
            return ankiDataRepository;
        }
    }

    public final Object syncFromAnkiDroid(Continuation<? super SyncResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$syncFromAnkiDroid$2(this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Long resolveSubDeckId(String deckPath, Map<String, Long> deckPathToId) {
        if (AnkiDroidBridge.INSTANCE.parseDeckHierarchy(deckPath).size() > 1) {
            return deckPathToId.get(deckPath);
        }
        return null;
    }

    public final Flow<List<DeckEntity>> observeDecks() {
        return this.deckDao.getAllDecks();
    }

    public final Object getAllDecks(Continuation<? super List<DeckEntity>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getAllDecks$2(this, null), continuation);
    }

    public final Object getRootDecks(Continuation<? super List<DeckEntity>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getRootDecks$2(this, null), continuation);
    }

    public final Object getSubDecks(long j, Continuation<? super List<DeckEntity>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getSubDecks$2(this, j, null), continuation);
    }

    public final Flow<List<CardEntity>> observeCardsForDeck(long deckId) {
        return FlowKt.flowCombine(this.cardDao.getCardsForDeck(deckId), this.cardOverrideDao.observeAllOverrides(), new AnkiDataRepository$observeCardsForDeck$1(null));
    }

    public final Object getCardsForDeck(long j, Continuation<? super List<CardEntity>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getCardsForDeck$2(this, j, null), continuation);
    }

    public final Object getAllCards(Continuation<? super List<CardEntity>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getAllCards$2(this, null), continuation);
    }

    public final Object getCardsForHierarchy(String str, Continuation<? super List<CardEntity>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getCardsForHierarchy$2(this, str, null), continuation);
    }

    public static /* synthetic */ Object getSampleCards$default(AnkiDataRepository ankiDataRepository, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 5;
        }
        return ankiDataRepository.getSampleCards(i, continuation);
    }

    public final Object getSampleCards(int i, Continuation<? super List<CardEntity>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getSampleCards$2(this, i, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0070 A[LOOP:0: B:11:0x006a->B:13:0x0070, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0089 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object applyOverrides(java.util.List<com.example.flashcardapp.data.entities.CardEntity> r27, kotlin.coroutines.Continuation<? super java.util.List<com.example.flashcardapp.data.entities.CardEntity>> r28) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.AnkiDataRepository.applyOverrides(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object getOverrideForCard(long j, Continuation<? super CardOverrideEntity> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getOverrideForCard$2(this, j, null), continuation);
    }

    public final Object getCardById(long j, Continuation<? super CardEntity> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getCardById$2(this, j, null), continuation);
    }

    public final Flow<CardOverrideEntity> observeOverrideForCard(long cardId) {
        return this.cardOverrideDao.observeOverrideForCard(cardId);
    }

    public final Object upsertOverride(CardOverrideEntity cardOverrideEntity, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$upsertOverride$2(this, cardOverrideEntity, null), continuation);
    }

    public final Object deleteOverride(long j, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$deleteOverride$2(this, j, null), continuation);
    }

    public final Object getDeckCount(Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getDeckCount$2(this, null), continuation);
    }

    public final Object getCardCount(Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getCardCount$2(this, null), continuation);
    }

    public final Object getCardCountForDeck(long j, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getCardCountForDeck$2(this, j, null), continuation);
    }

    public final List<String> parseTags(String tagsJson) {
        Intrinsics.checkNotNullParameter(tagsJson, "tagsJson");
        try {
            List<String> list = (List) this.gson.fromJson(tagsJson, new TypeToken<List<? extends String>>() { // from class: com.example.flashcardapp.data.AnkiDataRepository$parseTags$type$1
            }.getType());
            return list == null ? CollectionsKt.emptyList() : list;
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007a A[PHI: r14
  0x007a: PHI (r14v5 java.lang.Object) = (r14v4 java.lang.Object), (r14v1 java.lang.Object) binds: [B:17:0x0077, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object exportApkg(long r10, java.lang.String r12, android.net.Uri r13, kotlin.coroutines.Continuation<? super java.lang.Boolean> r14) {
        /*
            r9 = this;
            boolean r0 = r14 instanceof com.example.flashcardapp.data.AnkiDataRepository$exportApkg$1
            if (r0 == 0) goto L14
            r0 = r14
            com.example.flashcardapp.data.AnkiDataRepository$exportApkg$1 r0 = (com.example.flashcardapp.data.AnkiDataRepository$exportApkg$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            com.example.flashcardapp.data.AnkiDataRepository$exportApkg$1 r0 = new com.example.flashcardapp.data.AnkiDataRepository$exportApkg$1
            r0.<init>(r9, r14)
        L19:
            r8 = r0
            java.lang.Object r14 = r8.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L49
            if (r1 == r3) goto L36
            if (r1 != r2) goto L2e
            kotlin.ResultKt.throwOnFailure(r14)
            goto L7a
        L2e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L36:
            long r10 = r8.J$0
            java.lang.Object r12 = r8.L$2
            r13 = r12
            android.net.Uri r13 = (android.net.Uri) r13
            java.lang.Object r12 = r8.L$1
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r1 = r8.L$0
            com.example.flashcardapp.data.AnkiDataRepository r1 = (com.example.flashcardapp.data.AnkiDataRepository) r1
            kotlin.ResultKt.throwOnFailure(r14)
            goto L5e
        L49:
            kotlin.ResultKt.throwOnFailure(r14)
            r8.L$0 = r9
            r8.L$1 = r12
            r8.L$2 = r13
            r8.J$0 = r10
            r8.label = r3
            java.lang.Object r14 = r9.getCardsForDeck(r10, r8)
            if (r14 != r0) goto L5d
            return r0
        L5d:
            r1 = r9
        L5e:
            r3 = r10
            r5 = r12
            r7 = r13
            r6 = r14
            java.util.List r6 = (java.util.List) r6
            com.example.flashcardapp.data.ApkgExporter r10 = com.example.flashcardapp.data.ApkgExporter.INSTANCE
            android.content.Context r11 = r1.context
            r12 = 0
            r8.L$0 = r12
            r8.L$1 = r12
            r8.L$2 = r12
            r8.label = r2
            r1 = r10
            r2 = r11
            java.lang.Object r14 = r1.exportDeck(r2, r3, r5, r6, r7, r8)
            if (r14 != r0) goto L7a
            return r0
        L7a:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.AnkiDataRepository.exportApkg(long, java.lang.String, android.net.Uri, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object importApkg$default(AnkiDataRepository ankiDataRepository, Uri uri, Long l, String str, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        return ankiDataRepository.importApkg(uri, l, str, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object importApkg(android.net.Uri r10, java.lang.Long r11, java.lang.String r12, kotlin.coroutines.Continuation<? super com.example.flashcardapp.data.ImportResult> r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof com.example.flashcardapp.data.AnkiDataRepository$importApkg$1
            if (r0 == 0) goto L14
            r0 = r13
            com.example.flashcardapp.data.AnkiDataRepository$importApkg$1 r0 = (com.example.flashcardapp.data.AnkiDataRepository$importApkg$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            com.example.flashcardapp.data.AnkiDataRepository$importApkg$1 r0 = new com.example.flashcardapp.data.AnkiDataRepository$importApkg$1
            r0.<init>(r9, r13)
        L19:
            java.lang.Object r13 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L41
            if (r1 == r2) goto L39
            if (r1 != r8) goto L31
            java.lang.Object r10 = r0.L$0
            com.example.flashcardapp.data.ImportResult r10 = (com.example.flashcardapp.data.ImportResult) r10
            kotlin.ResultKt.throwOnFailure(r13)
            goto L70
        L31:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L39:
            java.lang.Object r10 = r0.L$0
            com.example.flashcardapp.data.AnkiDataRepository r10 = (com.example.flashcardapp.data.AnkiDataRepository) r10
            kotlin.ResultKt.throwOnFailure(r13)
            goto L59
        L41:
            kotlin.ResultKt.throwOnFailure(r13)
            com.example.flashcardapp.data.ApkgImporter r1 = com.example.flashcardapp.data.ApkgImporter.INSTANCE
            android.content.Context r13 = r9.context
            r0.L$0 = r9
            r0.label = r2
            r2 = r13
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r0
            java.lang.Object r13 = r1.importApkg(r2, r3, r4, r5, r6)
            if (r13 != r7) goto L58
            return r7
        L58:
            r10 = r9
        L59:
            r11 = r13
            com.example.flashcardapp.data.ImportResult r11 = (com.example.flashcardapp.data.ImportResult) r11
            boolean r12 = r11.getSuccess()
            if (r12 == 0) goto L71
            com.example.flashcardapp.fsrs.FsrsScheduler r10 = r10.fsrsScheduler
            r0.L$0 = r11
            r0.label = r8
            java.lang.Object r10 = r10.initializeNewCards(r0)
            if (r10 != r7) goto L6f
            return r7
        L6f:
            r10 = r11
        L70:
            r11 = r10
        L71:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.AnkiDataRepository.importApkg(android.net.Uri, java.lang.Long, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object importEpub$default(AnkiDataRepository ankiDataRepository, Uri uri, Long l, String str, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        return ankiDataRepository.importEpub(uri, l, str, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object importEpub(android.net.Uri r10, java.lang.Long r11, java.lang.String r12, kotlin.coroutines.Continuation<? super com.example.flashcardapp.data.ImportResult> r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof com.example.flashcardapp.data.AnkiDataRepository$importEpub$1
            if (r0 == 0) goto L14
            r0 = r13
            com.example.flashcardapp.data.AnkiDataRepository$importEpub$1 r0 = (com.example.flashcardapp.data.AnkiDataRepository$importEpub$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            com.example.flashcardapp.data.AnkiDataRepository$importEpub$1 r0 = new com.example.flashcardapp.data.AnkiDataRepository$importEpub$1
            r0.<init>(r9, r13)
        L19:
            java.lang.Object r13 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L41
            if (r1 == r2) goto L39
            if (r1 != r8) goto L31
            java.lang.Object r10 = r0.L$0
            com.example.flashcardapp.data.ImportResult r10 = (com.example.flashcardapp.data.ImportResult) r10
            kotlin.ResultKt.throwOnFailure(r13)
            goto L70
        L31:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L39:
            java.lang.Object r10 = r0.L$0
            com.example.flashcardapp.data.AnkiDataRepository r10 = (com.example.flashcardapp.data.AnkiDataRepository) r10
            kotlin.ResultKt.throwOnFailure(r13)
            goto L59
        L41:
            kotlin.ResultKt.throwOnFailure(r13)
            com.example.flashcardapp.data.EpubImporter r1 = com.example.flashcardapp.data.EpubImporter.INSTANCE
            android.content.Context r13 = r9.context
            r0.L$0 = r9
            r0.label = r2
            r2 = r13
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r0
            java.lang.Object r13 = r1.importEpub(r2, r3, r4, r5, r6)
            if (r13 != r7) goto L58
            return r7
        L58:
            r10 = r9
        L59:
            r11 = r13
            com.example.flashcardapp.data.ImportResult r11 = (com.example.flashcardapp.data.ImportResult) r11
            boolean r12 = r11.getSuccess()
            if (r12 == 0) goto L71
            com.example.flashcardapp.fsrs.FsrsScheduler r10 = r10.fsrsScheduler
            r0.L$0 = r11
            r0.label = r8
            java.lang.Object r10 = r10.initializeNewCards(r0)
            if (r10 != r7) goto L6f
            return r7
        L6f:
            r10 = r11
        L70:
            r11 = r10
        L71:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.AnkiDataRepository.importEpub(android.net.Uri, java.lang.Long, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object importCsv$default(AnkiDataRepository ankiDataRepository, Uri uri, String str, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "UPDATE";
        }
        return ankiDataRepository.importCsv(uri, str, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object importCsv(android.net.Uri r13, java.lang.String r14, kotlin.coroutines.Continuation<? super com.example.flashcardapp.data.ImportResult> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof com.example.flashcardapp.data.AnkiDataRepository$importCsv$1
            if (r0 == 0) goto L14
            r0 = r15
            com.example.flashcardapp.data.AnkiDataRepository$importCsv$1 r0 = (com.example.flashcardapp.data.AnkiDataRepository$importCsv$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L19
        L14:
            com.example.flashcardapp.data.AnkiDataRepository$importCsv$1 r0 = new com.example.flashcardapp.data.AnkiDataRepository$importCsv$1
            r0.<init>(r12, r15)
        L19:
            java.lang.Object r15 = r0.result
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r11 = 2
            r2 = 1
            if (r1 == 0) goto L41
            if (r1 == r2) goto L39
            if (r1 != r11) goto L31
            java.lang.Object r13 = r0.L$0
            com.example.flashcardapp.data.ImportResult r13 = (com.example.flashcardapp.data.ImportResult) r13
            kotlin.ResultKt.throwOnFailure(r15)
            goto L74
        L31:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L39:
            java.lang.Object r13 = r0.L$0
            com.example.flashcardapp.data.AnkiDataRepository r13 = (com.example.flashcardapp.data.AnkiDataRepository) r13
            kotlin.ResultKt.throwOnFailure(r15)
            goto L5d
        L41:
            kotlin.ResultKt.throwOnFailure(r15)
            com.example.flashcardapp.data.CsvImporter r1 = com.example.flashcardapp.data.CsvImporter.INSTANCE
            android.content.Context r15 = r12.context
            r4 = 0
            r5 = 0
            r8 = 12
            r9 = 0
            r0.L$0 = r12
            r0.label = r2
            r2 = r15
            r3 = r13
            r6 = r14
            r7 = r0
            java.lang.Object r15 = com.example.flashcardapp.data.CsvImporter.importCsv$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            if (r15 != r10) goto L5c
            return r10
        L5c:
            r13 = r12
        L5d:
            r14 = r15
            com.example.flashcardapp.data.ImportResult r14 = (com.example.flashcardapp.data.ImportResult) r14
            boolean r15 = r14.getSuccess()
            if (r15 == 0) goto L75
            com.example.flashcardapp.fsrs.FsrsScheduler r13 = r13.fsrsScheduler
            r0.L$0 = r14
            r0.label = r11
            java.lang.Object r13 = r13.initializeNewCards(r0)
            if (r13 != r10) goto L73
            return r10
        L73:
            r13 = r14
        L74:
            r14 = r13
        L75:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.AnkiDataRepository.importCsv(android.net.Uri, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object importCsvIntoExistingDeck$default(AnkiDataRepository ankiDataRepository, Uri uri, long j, String str, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = "UPDATE";
        }
        return ankiDataRepository.importCsvIntoExistingDeck(uri, j, str, str2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object importCsvIntoExistingDeck(android.net.Uri r13, long r14, java.lang.String r16, java.lang.String r17, kotlin.coroutines.Continuation<? super com.example.flashcardapp.data.ImportResult> r18) {
        /*
            r12 = this;
            r0 = r12
            r1 = r18
            boolean r2 = r1 instanceof com.example.flashcardapp.data.AnkiDataRepository$importCsvIntoExistingDeck$1
            if (r2 == 0) goto L17
            r2 = r1
            com.example.flashcardapp.data.AnkiDataRepository$importCsvIntoExistingDeck$1 r2 = (com.example.flashcardapp.data.AnkiDataRepository$importCsvIntoExistingDeck$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L17
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1c
        L17:
            com.example.flashcardapp.data.AnkiDataRepository$importCsvIntoExistingDeck$1 r2 = new com.example.flashcardapp.data.AnkiDataRepository$importCsvIntoExistingDeck$1
            r2.<init>(r12, r1)
        L1c:
            java.lang.Object r1 = r2.result
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r11 = 2
            r4 = 1
            if (r3 == 0) goto L44
            if (r3 == r4) goto L3c
            if (r3 != r11) goto L34
            java.lang.Object r2 = r2.L$0
            com.example.flashcardapp.data.ImportResult r2 = (com.example.flashcardapp.data.ImportResult) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L78
        L34:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3c:
            java.lang.Object r3 = r2.L$0
            com.example.flashcardapp.data.AnkiDataRepository r3 = (com.example.flashcardapp.data.AnkiDataRepository) r3
            kotlin.ResultKt.throwOnFailure(r1)
            goto L62
        L44:
            kotlin.ResultKt.throwOnFailure(r1)
            com.example.flashcardapp.data.CsvImporter r3 = com.example.flashcardapp.data.CsvImporter.INSTANCE
            android.content.Context r1 = r0.context
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r14)
            r2.L$0 = r0
            r2.label = r4
            r4 = r1
            r5 = r13
            r7 = r16
            r8 = r17
            r9 = r2
            java.lang.Object r1 = r3.importCsv(r4, r5, r6, r7, r8, r9)
            if (r1 != r10) goto L61
            return r10
        L61:
            r3 = r0
        L62:
            com.example.flashcardapp.data.ImportResult r1 = (com.example.flashcardapp.data.ImportResult) r1
            boolean r4 = r1.getSuccess()
            if (r4 == 0) goto L79
            com.example.flashcardapp.fsrs.FsrsScheduler r3 = r3.fsrsScheduler
            r2.L$0 = r1
            r2.label = r11
            java.lang.Object r2 = r3.initializeNewCards(r2)
            if (r2 != r10) goto L77
            return r10
        L77:
            r2 = r1
        L78:
            r1 = r2
        L79:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.AnkiDataRepository.importCsvIntoExistingDeck(android.net.Uri, long, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String getFileName(Uri uri) {
        String str;
        Cursor query;
        int columnIndex;
        Intrinsics.checkNotNullParameter(uri, "uri");
        String str2 = null;
        if (!Intrinsics.areEqual(uri.getScheme(), "content") || (query = this.context.getContentResolver().query(uri, null, null, null, null)) == null) {
            str = null;
        } else {
            Cursor cursor = query;
            try {
                Cursor cursor2 = cursor;
                str = (!cursor2.moveToFirst() || (columnIndex = cursor2.getColumnIndex("_display_name")) < 0) ? null : cursor2.getString(columnIndex);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursor, th);
                    throw th2;
                }
            }
        }
        if (str == null) {
            str = uri.getPath();
            int lastIndexOf$default = str != null ? StringsKt.lastIndexOf$default((CharSequence) str, '/', 0, false, 6, (Object) null) : -1;
            if (lastIndexOf$default != -1) {
                if (str != null) {
                    str2 = str.substring(lastIndexOf$default + 1);
                    Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
                }
                str = str2;
            }
        }
        return str == null ? "import_file" : str;
    }

    public final Object importFile(Uri uri, Continuation<? super ImportResult> continuation) {
        String lowerCase = getFileName(uri).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (StringsKt.endsWith$default(lowerCase, ".csv", false, 2, (Object) null) || StringsKt.endsWith$default(lowerCase, ".txt", false, 2, (Object) null)) {
            return importCsv$default(this, uri, null, continuation, 2, null);
        }
        if (StringsKt.endsWith$default(lowerCase, ".epub", false, 2, (Object) null)) {
            return EpubImporter.importEpub$default(EpubImporter.INSTANCE, this.context, uri, null, null, continuation, 12, null);
        }
        return importApkg$default(this, uri, null, null, continuation, 6, null);
    }

    public final Object saveSessionRecord(SessionRecordEntity sessionRecordEntity, Continuation<? super Long> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$saveSessionRecord$2(sessionRecordEntity, this, null), continuation);
    }

    public final Flow<List<SessionRecordEntity>> observeSessionRecords() {
        return this.sessionRecordDao.getAllRecordsFlow();
    }

    public final Flow<List<CardAttemptEntity>> observeAttemptsSince(long sinceTimestamp) {
        return this.cardAttemptDao.observeAttemptsSince(sinceTimestamp);
    }

    public final Object getSessionRecords(Continuation<? super List<SessionRecordEntity>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getSessionRecords$2(this, null), continuation);
    }

    public final Object saveCardAttempts(List<CardAttemptEntity> list, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$saveCardAttempts$2(this, list, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object getAllCardAttempts(Continuation<? super List<CardAttemptEntity>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getAllCardAttempts$2(this, null), continuation);
    }

    public final Object getSessionCount(Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getSessionCount$2(this, null), continuation);
    }

    public final Object getTotalQuestionsAnswered(Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getTotalQuestionsAnswered$2(this, null), continuation);
    }

    public final Object getTotalCorrectAnswers(Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getTotalCorrectAnswers$2(this, null), continuation);
    }

    public final Object getPracticeSessionCount(Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getPracticeSessionCount$2(this, null), continuation);
    }

    public final Object getRevisionSessionCount(Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getRevisionSessionCount$2(this, null), continuation);
    }

    public final Object getTestSessionCount(Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getTestSessionCount$2(this, null), continuation);
    }

    public final Object deleteDeck(long j, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$deleteDeck$2(j, this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object addCard(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Continuation<? super Long> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$addCard$2(this, str, str2, str3, str4, str5, str6, str7, str8, null), continuation);
    }

    public final Object deleteCard(long j, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$deleteCard$2(this, j, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object renameDeck(long j, String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$renameDeck$2(this, j, str, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object clearDeckProgress(long j, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$clearDeckProgress$2(j, this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object createDeck(String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$createDeck$2(str, this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object clearCache(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$clearCache$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object isCachePopulated(Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$isCachePopulated$2(this, null), continuation);
    }

    public final Object getAllAliases(Continuation<? super List<AliasEntity>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getAllAliases$2(this, null), continuation);
    }

    public final Object addCustomAlias(String str, String str2, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$addCustomAlias$2(str, str2, this, null), continuation);
    }

    public final Object loadDefaultAliasesIfNeeded(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$loadDefaultAliasesIfNeeded$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object mergeDecks(long j, long j2, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$mergeDecks$2(j, j2, this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object getCardUserMetadata(long j, Continuation<? super CardUserMetadataEntity> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getCardUserMetadata$2(this, j, null), continuation);
    }

    public final Object setCardRating(long j, int i, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$setCardRating$2(this, j, i, null), continuation);
    }

    public final Object setCardStarred(long j, boolean z, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$setCardStarred$2(this, j, z, null), continuation);
    }

    public final Flow<List<CardUserMetadataEntity>> observeAllUserMetadata() {
        return this.cardUserMetadataDao.getAllMetadataFlow();
    }

    public final Object getAllUserMetadataOnce(Continuation<? super List<CardUserMetadataEntity>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnkiDataRepository$getAllUserMetadataOnce$2(this, null), continuation);
    }
}
