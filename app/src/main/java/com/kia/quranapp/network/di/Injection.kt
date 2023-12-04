package com.kia.quranapp.network.di

import android.content.Context
import com.kia.quranapp.local.CalendarPreferences
import com.kia.quranapp.local.LocationPreferences
import com.kia.quranapp.network.ApiConfig
import com.kia.quranapp.network.RemoteDataSource
import com.kia.quranapp.network.adzan.AdzanRepository
import com.kia.quranapp.network.quran.QuranRepository

object Injection {
    private val quranApiService = ApiConfig.getQuranService
    private val adzanApiService = ApiConfig.getAdzanTimeService
    private val remoteDataSource = RemoteDataSource(quranApiService, adzanApiService)
    fun provideQuranRepository(): QuranRepository {
        return QuranRepository(remoteDataSource)
    }

    fun provideAdzanRepository(context: Context): AdzanRepository {
        val locationPreferences = LocationPreferences(context)
        val calendarPrefrences = CalendarPreferences()
        return AdzanRepository(remoteDataSource, locationPreferences, calendarPrefrences)
    }
}