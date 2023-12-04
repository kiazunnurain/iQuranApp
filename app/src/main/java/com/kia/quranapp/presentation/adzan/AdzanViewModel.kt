package com.kia.quranapp.presentation.adzan

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kia.quranapp.network.Resource
import com.kia.quranapp.network.adzan.AdzanDataResult
import com.kia.quranapp.network.adzan.AdzanRepository

data class AdzanViewModel(
    private val adzanRepository: AdzanRepository
) : ViewModel()  {
    fun getDailyAdzanTime():
            LiveData<Resource<AdzanDataResult>> = adzanRepository
        .getResultDailyAdzanTime()
}
