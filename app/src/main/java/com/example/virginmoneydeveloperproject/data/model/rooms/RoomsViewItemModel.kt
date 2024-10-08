package com.example.virginmoneydeveloperproject.data.model.rooms


import com.google.gson.annotations.SerializedName

data class RoomsViewItemModel(
    @SerializedName("createdAt")
    val createdAt: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("isOccupied")
    val isOccupied: Boolean? = false,
    @SerializedName("maxOccupancy")
    val maxOccupancy: Int? = 0
)