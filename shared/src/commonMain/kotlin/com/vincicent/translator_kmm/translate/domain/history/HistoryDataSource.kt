package com.vincicent.translator_kmm.translate.domain.history

import com.vincicent.translator_kmm.core.domain.util.CommonFlow
import kotlin.coroutines.CoroutineContext

interface HistoryDataSource {
    fun getHistory(context: CoroutineContext): CommonFlow<List<HistoryItem>>
    fun insertHistoryItem(item: HistoryItem)
}