package com.vincicent.translator_kmm.translate.domain.translate

import com.vincicent.translator_kmm.core.domain.language.Language

interface TranslateClient {
    suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String
}