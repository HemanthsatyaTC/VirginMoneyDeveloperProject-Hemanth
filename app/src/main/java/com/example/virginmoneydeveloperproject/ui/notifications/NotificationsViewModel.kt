package com.example.virginmoneydeveloperproject.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoneydeveloperproject.data.model.rooms.RoomsViewItemModel
import com.example.virginmoneydeveloperproject.data.remote.people.PeopleApiDetails
import com.example.virginmoneydeveloperproject.data.remote.rooms.RoomsApiDetails
import kotlinx.coroutines.launch

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text

    private val _details = MutableLiveData<List<RoomsViewItemModel>>()
    val details : LiveData<List<RoomsViewItemModel>> = _details

    fun getrooms() {
        viewModelScope.launch {
            val result = RoomsApiDetails.retrofitDetails.getrooms()

            _details.postValue(result)

        }
    }
}