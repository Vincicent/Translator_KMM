package com.vincicent.translator_kmm.translate.domain.translate

import com.vincicent.translator_kmm.core.domain.language.Language
import com.vincicent.translator_kmm.core.domain.util.Resource
import com.vincicent.translator_kmm.translate.domain.history.HistoryDataSource
import com.vincicent.translator_kmm.translate.domain.history.HistoryItem

class Translate(
    private val client: TranslateClient,
    private val historyDataSource: HistoryDataSource
) {
    suspend fun execute(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): Resource<String> {
        return try {
            val translatedText = client.translate(
                fromLanguage = fromLanguage,
                fromText = fromText,
                toLanguage = toLanguage
            )

            historyDataSource.insertHistoryItem(
                item = HistoryItem(
                    id = null,
                    fromLanguageCode = fromLanguage.langCode,
                    fromText = fromText,
                    toLanguageCode = toLanguage.langCode,
                    toText = translatedText
                )
            )

            Resource.Success(translatedText)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e)
        }
    }
}