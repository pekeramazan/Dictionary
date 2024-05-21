package com.ramazanpeker.dictionary.feature_dictionary.domain.use_case

import com.ramazanpeker.dictionary.core.util.Resource
import com.ramazanpeker.dictionary.feature_dictionary.domain.model.WordInfo
import com.ramazanpeker.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    private val repository: WordInfoRepository
) {
    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if (word.isNotBlank()) {
            return flow {  }
        }
        return repository.getWordInfo(word)
    }
}