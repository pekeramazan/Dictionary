package com.ramazanpeker.dictionary.feature_dictionary.data.repository

import com.ramazanpeker.dictionary.core.util.Resource
import com.ramazanpeker.dictionary.feature_dictionary.data.local.WordInfoDao
import com.ramazanpeker.dictionary.feature_dictionary.data.remote.DictionaryApi
import com.ramazanpeker.dictionary.feature_dictionary.domain.model.WordInfo
import com.ramazanpeker.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
) : WordInfoRepository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())
        val wordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Loading(data = wordInfos))

        try {
            val remoWordInfos = api.getWordInfo(word)
            dao.deleteWordInfos(remoWordInfos.map { it.word })
            dao.insertWordInfos(remoWordInfos.map { it.toWordInfoEntity() })

        } catch (e: retrofit2.HttpException) {
            emit(Resource.Error(message = "Oops, something went wrong!",
                data = wordInfos))

        } catch (e: IOException) {
            emit(Resource.Error(message = "Couldn't reach server, check your internet connection.",
                data = wordInfos))
        }

        val newWorInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Success(newWorInfos))

    }

}