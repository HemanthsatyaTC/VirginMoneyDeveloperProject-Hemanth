package com.example.virginmoneydeveloperproject.data.repository

import com.example.virginmoneydeveloperproject.data.model.people.PeopleDataItemModel
import com.example.virginmoneydeveloperproject.data.model.rooms.RoomsViewItemModel

interface Repository {
    suspend fun getDetails(): List<PeopleDataItemModel>
    suspend fun getrooms(): List<RoomsViewItemModel>
}