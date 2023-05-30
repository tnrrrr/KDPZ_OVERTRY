package com.example.kdpz_overtry.data.local.weather

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Main_(
    val temp: Float,
    val feels_like: Float,
    val temp_min: Float,
    val temp_max: Float,
    val pressure: Float,
    val humidity: Float,
    val tempString: String,
):Parcelable