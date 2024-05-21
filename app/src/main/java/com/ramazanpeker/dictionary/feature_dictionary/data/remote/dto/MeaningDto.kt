package com.ramazanpeker.dictionary.feature_dictionary.data.remote.dto

import com.ramazanpeker.dictionary.feature_dictionary.domain.model.Meaning

data class MeaningDto(
    val antonyms: List<String>,
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String,
    val synonyms: List<String>
) {
    fun toMeaning(): Meaning {
        return Meaning(
            antonyms = antonyms,
            definitions = definitions.map { it.toDefiniton() },
            partOfSpeech = partOfSpeech,
            synonyms = synonyms
        )
    }
}