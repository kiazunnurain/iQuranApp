package com.kia.quranapp.network.adzan

import com.kia.quranapp.network.Resource
data class AdzanDataResult(
    val listLocation: List<String>,
    val dailyAdzan: Resource<DailyAdzan>,
    val listCalendar: List<String>
)
