package com.vincicent.translator_kmm.android.translate.data.remote

import com.vincicent.translator_kmm.core.domain.language.Language
import com.vincicent.translator_kmm.translate.domain.translate.TranslateClient

class FakeTranslateClient: TranslateClient {

    var translatedText = "test translation"

    override suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String {
        return translatedText
    }
}