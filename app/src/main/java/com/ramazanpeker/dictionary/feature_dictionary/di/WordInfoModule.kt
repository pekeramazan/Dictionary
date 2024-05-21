package com.ramazanpeker.dictionary.feature_dictionary.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.ramazanpeker.dictionary.feature_dictionary.data.local.Converters
import com.ramazanpeker.dictionary.feature_dictionary.data.local.WordInfoDao
import com.ramazanpeker.dictionary.feature_dictionary.data.local.WordInfoDataBase
import com.ramazanpeker.dictionary.feature_dictionary.data.remote.DictionaryApi
import com.ramazanpeker.dictionary.feature_dictionary.data.repository.WordInfoRepositoryImpl
import com.ramazanpeker.dictionary.feature_dictionary.data.util.GsonParser
import com.ramazanpeker.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import com.ramazanpeker.dictionary.feature_dictionary.domain.use_case.GetWordInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {
    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(repository: WordInfoRepository): GetWordInfo {
        return GetWordInfo(repository = repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        db: WordInfoDataBase,
        api: DictionaryApi
    ): WordInfoRepository {
        return WordInfoRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WordInfoDataBase {
        return Room.databaseBuilder(
            app,
            WordInfoDataBase::class.java, "wordb"
        ).addTypeConverter(Converters(GsonParser(Gson()))).build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi {
        return Retrofit.Builder()
            .baseUrl(DictionaryApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)
    }
}