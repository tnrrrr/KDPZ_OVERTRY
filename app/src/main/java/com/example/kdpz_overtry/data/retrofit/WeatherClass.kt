package com.example.kdpz_overtry.data.retrofit

import android.os.Parcelable
import com.example.kdpz_overtry.data.local.weather.Clouds
import com.example.kdpz_overtry.data.local.weather.Main_
import com.example.kdpz_overtry.data.local.weather.Weather
import com.example.kdpz_overtry.data.local.weather.Wind
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherClass(
    val weather: List<Weather>,
    val main: Main_,
    val wind: Wind,
    val clouds: Clouds,
    val cod: Int,
    var cityName: String
): Parcelable