package com.example.virginmoneydeveloperproject.data.remote.rooms

import com.example.virginmoneydeveloperproject.data.model.people.PeopleDataItemModel
import com.example.virginmoneydeveloperproject.data.model.rooms.RoomsViewItemModel
import com.example.virginmoneydeveloperproject.data.remote.people.PeopleApiDetails
import retrofit2.http.GET

interface RoomsApiInterface {
    @GET(RoomsApiDetails.END_POINTS)
    suspend fun getrooms(): List<RoomsViewItemModel>
}