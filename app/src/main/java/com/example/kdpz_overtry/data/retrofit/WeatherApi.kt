package com.example.kdpz_overtry.data.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

var myApiKey = "87d7ef369324355c8bf0a9eca4b13c70"

interface WeatherApi {
    @GET("weather")
    suspend fun getWeatherById(
        @Query("q")city_name: String,
        @Query("appid") apiKey: String = myApiKey,
        @Query("units") units: String = "metric",
        @Query("lang") lang: String = "ua"
    ): WeatherClass

}
