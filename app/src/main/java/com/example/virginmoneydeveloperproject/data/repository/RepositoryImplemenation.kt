package com.example.virginmoneydeveloperproject.data.repository

import com.example.virginmoneydeveloperproject.data.model.people.PeopleDataItemModel
import com.example.virginmoneydeveloperproject.data.model.rooms.RoomsViewItemModel
import com.example.virginmoneydeveloperproject.data.remote.people.PeopleApiInterface
import com.example.virginmoneydeveloperproject.data.remote.rooms.RoomsApiInterface
import javax.inject.Inject

class RepositoryImplemenation @Inject constructor(
    val apiPeople : PeopleApiInterface,
    val apiRooms : RoomsApiInterface
): Repository {
    override suspend fun getDetails(): List<PeopleDataItemModel> {
        return apiPeople.getDetails()
    }

    override suspend fun getrooms(): List<RoomsViewItemModel> {
        return apiRooms.getrooms()
    }
}