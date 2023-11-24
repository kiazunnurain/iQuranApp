package com.kia.quranapp.presentation.quran

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kia.quranapp.network.ApiConfig
import com.kia.quranapp.network.quran.AyahResponse
import com.kia.quranapp.network.quran.SurahResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuranViewModel : ViewModel(){
    private var _listSurah = MutableLiveData<SurahResponse>()

    val listSurah get() = _listSurah as LiveData<SurahResponse>

    private var _listAyah = MutableLiveData<AyahResponse>()

    val listAyah get() = _listAyah as LiveData<AyahResponse>

    fun getListSurah() {
        ApiConfig.getQuranService.getListSurah().enqueue(object : Callback<SurahResponse> {
            override fun onResponse(call: Call<SurahResponse>, response: Response<SurahResponse>) {
                if (response.isSuccessful) {
                    Log.i(
                        "QuranViewModel",
                        "onResponse: ${response.body()}"
                    )
                    _listSurah.postValue(response.body())
                } else Log.e(
                    "QuranViewModel",
                    "onResponse: Call error with HTTP status code " + response.code(),
                )
            }

            override fun onFailure(call: Call<SurahResponse>, t: Throwable) {
                Log.e("QuranViewModel",
                    "onFailure: " + t.localizedMessage)
                }
        })
    }
    fun getListAyah(number: Int) {
        ApiConfig.getQuranService.getListAyahFromSurah(number).enqueue(object :
            Callback<AyahResponse> {
            override fun onResponse(call: Call<AyahResponse>, response: Response<AyahResponse>) {
                if (response.isSuccessful) {
                    Log.i("QuranViewModel", "onResponse : ${response.body()}")
                    _listAyah.value = response.body()
                } else Log.e(
                    "QuranViewQuran",
                    "onResponse: Call error with Http status code" + response.code()
                )
            }

            override fun onFailure(call: Call<AyahResponse>, t: Throwable) {
                Log.e(
                    "QuranViewModel",
                    "onFailure: " + t.localizedMessage
                )
            }
        })
    }
}