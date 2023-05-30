package com.example.kdpz_overtry.presentation.settings

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kdpz_overtry.domain.WeatherUseCase
import com.example.kdpz_overtry.domain.models.MainWeatherClass
import kotlinx.coroutines.launch

class SettingsViewModel : ViewModel() {
    val weatherLiveData = MutableLiveData<MainWeatherClass?>()
    fun getWeather(cityName: String) {
        viewModelScope.launch {
            val weather = WeatherUseCase.getWeather(cityName)
            weatherLiveData.postValue(weather)
        }
    }
}