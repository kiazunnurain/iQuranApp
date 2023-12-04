package com.kia.quranapp.network.quran

import com.kia.quranapp.network.Resource
import kotlinx.coroutines.flow.Flow

interface IQuranRepository {
    fun getListSurah() : Flow<Resource<List<Surah>>>

    fun getDetailSurahWithWithQuranEditions(number: Int) : Flow<Resource<List<QuranEdition>>>
}