package com.example.virginmoneydeveloperproject.data.remote.people

import com.example.virginmoneydeveloperproject.data.model.people.PeopleDataItemModel
import retrofit2.http.GET

interface PeopleApiInterface {

    @GET(PeopleApiDetails.END_POINTS)
    suspend fun getDetails(): List<PeopleDataItemModel>
}