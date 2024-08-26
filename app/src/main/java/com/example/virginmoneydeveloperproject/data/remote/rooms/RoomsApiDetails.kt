package com.example.virginmoneydeveloperproject.data.remote.rooms

import com.example.virginmoneydeveloperproject.data.remote.people.PeopleApiInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RoomsApiDetails {
    const val BASE_URL = "https://61e947967bc0550017bc61bf.mockapi.io/api/v1/"
    const val END_POINTS = "rooms"

    val retrofitDetails = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .build()
        )
        .build()
        .create(RoomsApiInterface::class.java)
}