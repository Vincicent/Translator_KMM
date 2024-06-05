package com.vincicent.translator_kmm.translate.presentation

import com.vincicent.translator_kmm.core.presentation.UiLanguage
import com.vincicent.translator_kmm.translate.domain.translate.TranslateError

data class TranslateState(
    val fromText: String = "",
    val toText: String? = null,
    val isTranslating: Boolean = false,
    val fromLanguage: UiLanguage = UiLanguage.byCode("fr"),
    val toLanguage: UiLanguage = UiLanguage.byCode("en"),
    val isChoosingFromLanguage: Boolean = false,
    val isChoosingToLanguage: Boolean = false,
    val error: TranslateError? = null,
    val history: List<UiHistoryItem> = emptyList()
)
