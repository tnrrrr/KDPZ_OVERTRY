package com.example.kdpz_overtry.data.local.weather

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weather(
    val main : String,
    val description : String,
    val icon : String
):Parcelable