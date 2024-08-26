package com.example.virginmoneydeveloperproject.di

import com.example.virginmoneydeveloperproject.data.remote.people.PeopleApiDetails.BASE_URL
import com.example.virginmoneydeveloperproject.data.remote.people.PeopleApiInterface
import com.example.virginmoneydeveloperproject.data.remote.rooms.RoomsApiInterface
import com.example.virginmoneydeveloperproject.data.repository.Repository
import com.example.virginmoneydeveloperproject.data.repository.RepositoryImplemenation
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module //defines Implementation
@InstallIn(SingletonComponent::class)

class AppModule {
    @Provides
    fun getGson(): Gson { //return type is how the hilt will know what to return
        //Function Name itself serves No purpose
        return Gson()
    }

    @Provides
    fun getHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }


    @Provides
    fun getRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    @Provides
    fun getApiPeople(
        retrofit: Retrofit
    ): PeopleApiInterface {
        return retrofit.create(PeopleApiInterface::class.java)

    }
    @Provides
    fun getApiRooms(
        retrofit: Retrofit
    ): RoomsApiInterface {
        return retrofit.create(RoomsApiInterface::class.java)
    }

    @Provides
    fun getRepository(
        apiPeople: PeopleApiInterface,
        apiRooms: RoomsApiInterface
    ): Repository {
        return RepositoryImplemenation(
            apiPeople = apiPeople,
            apiRooms = apiRooms
        )

    }
}