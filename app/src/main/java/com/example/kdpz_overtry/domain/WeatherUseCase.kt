package com.example.kdpz_overtry.domain

import android.util.Log
import com.example.kdpz_overtry.data.repository.WeatherRepository
import com.example.kdpz_overtry.domain.models.MainWeatherClass

object WeatherUseCase {
    suspend fun getWeather(cityName: String): MainWeatherClass? {



        try {
            val weather = WeatherRepository.getWeather(cityName)
            Log.d("data", "data receive: success")

            val normalImageUrl = "https://openweathermap.org/img/wn/${weather!!.weather[0].icon}@2x.png"

            val temperature = String.format("%.1f", weather.main.temp)

            val temperatureWithCelsius = "$temperature°C"

            val currentWeather = weather.weather[0].copy()

            val mainWeather = MainWeatherClass(
                currentWeather.copy(icon = normalImageUrl),
                weather.main.copy(tempString = temperatureWithCelsius),
                weather.wind.copy(),
                weather.clouds.copy(),
                weather.cod,
                cityName)

            return  mainWeather
        }
        catch (e: Exception) {
            Log.d("data", e.message!!)
            return null
        }
    }
}