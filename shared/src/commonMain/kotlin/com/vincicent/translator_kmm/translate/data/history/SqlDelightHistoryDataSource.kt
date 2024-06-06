package com.vincicent.translator_kmm.translate.data.history

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.vincicent.translator_kmm.database.TranslateDatabase
import com.vincicent.translator_kmm.core.domain.util.CommonFlow
import com.vincicent.translator_kmm.core.domain.util.toCommonFlow
import com.vincicent.translator_kmm.translate.domain.history.HistoryDataSource
import com.vincicent.translator_kmm.translate.domain.history.HistoryItem
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock
import kotlin.coroutines.CoroutineContext

class SqlDelightHistoryDataSource(
    private val db: TranslateDatabase
): HistoryDataSource {

    private val queries = db.translateQueries

    override fun getHistory(context: CoroutineContext): CommonFlow<List<HistoryItem>> {
        return queries
            .getHistory()
            .asFlow()
            .mapToList(context)
            .map {
                it.map { entity ->
                    entity.toHistoryItem()
                }
            }
            .toCommonFlow()
    }

    override fun insertHistoryItem(item: HistoryItem) {
        queries.insertHistoryEntity(
            id = item.id,
            fromLanguageCode = item.fromLanguageCode,
            fromText = item.fromText,
            toLanguageCode = item.toLanguageCode,
            toText = item.toText,
            timestamp = Clock.System.now().toEpochMilliseconds()
        )
    }
}