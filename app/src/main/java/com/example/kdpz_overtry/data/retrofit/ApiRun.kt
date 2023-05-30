package com.example.newnews.data.factories

import com.example.kdpz_overtry.data.retrofit.WeatherApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiRun {

    private val BASE_URL = "https://api.openweathermap.org/data/2.5/"



    val weatherApi = createRetrofit().create(WeatherApi::class.java)

    private fun createRetrofit(): Retrofit{
        val interceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }
}

