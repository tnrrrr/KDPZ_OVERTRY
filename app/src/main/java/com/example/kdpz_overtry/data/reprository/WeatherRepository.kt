package com.example.kdpz_overtry.data.repository

import com.example.kdpz_overtry.data.retrofit.WeatherClass
import com.example.newnews.data.factories.ApiRun

object WeatherRepository {
    suspend fun getWeather(cityName: String): WeatherClass? {
        return ApiRun.weatherApi.getWeatherById(cityName)
    }
}