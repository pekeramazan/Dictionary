package com.ramazanpeker.dictionary.feature_dictionary.domain.model

import com.ramazanpeker.dictionary.feature_dictionary.data.remote.dto.License

data class WordInfo(
    val license: License? = null,
    val meanings: List<Meaning>? = null,
    val phonetic: String,
    val sourceUrls: List<String>? = null,
    val word: String
)
