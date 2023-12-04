package com.kia.quranapp.presentation.quran

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kia.quranapp.network.ApiConfig
import com.kia.quranapp.network.quran.AyahResponse
import com.kia.quranapp.network.quran.QuranRepository
import com.kia.quranapp.network.quran.SurahResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuranViewModel(private val quranRepository: QuranRepository) : ViewModel(){
    fun getListSurah()=
        quranRepository
            .getListSurah()
            .asLiveData()

    fun getDetailSurahWithQuranEdition(number: Int) =
        quranRepository
            .getDetailSurahWithWithQuranEditions(number)
            .asLiveData()
}