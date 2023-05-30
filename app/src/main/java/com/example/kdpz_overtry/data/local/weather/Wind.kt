package com.example.kdpz_overtry.data.local.weather

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wind(
    val speed : Float,
    val deg : Float
): Parcelable