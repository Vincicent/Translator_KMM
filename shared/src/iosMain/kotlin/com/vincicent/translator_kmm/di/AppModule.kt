package com.vincicent.translator_kmm.di

import com.vincicent.translator_kmm.database.TranslateDatabase
import com.vincicent.translator_kmm.translate.data.history.SqlDelightHistoryDataSource
import com.vincicent.translator_kmm.translate.data.local.DatabaseDriverFactory
import com.vincicent.translator_kmm.translate.data.remote.HttpClientFactory
import com.vincicent.translator_kmm.translate.data.translate.KtorTranslateClient
import com.vincicent.translator_kmm.translate.domain.history.HistoryDataSource
import com.vincicent.translator_kmm.translate.domain.translate.Translate
import com.vincicent.translator_kmm.translate.domain.translate.TranslateClient
import com.vincicent.voice_to_text.domain.VoiceToTextParser

interface AppModule {
    val historyDataSource: HistoryDataSource
    val client: TranslateClient
    val translateUseCase: Translate
    val voiceParser: VoiceToTextParser
}

class AppModuleImpl(
    parser: VoiceToTextParser
): AppModule {

    override val historyDataSource: HistoryDataSource by lazy {
        SqlDelightHistoryDataSource(
            TranslateDatabase(
                DatabaseDriverFactory().create()
            )
        )
    }

    override val client: TranslateClient by lazy {
        KtorTranslateClient(
            HttpClientFactory().create()
        )
    }

    override val translateUseCase: Translate by lazy {
        Translate(client, historyDataSource)
    }

    override val voiceParser = parser
}