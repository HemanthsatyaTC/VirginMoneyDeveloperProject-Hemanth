package com.example.virginmoneydeveloperproject.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoneydeveloperproject.data.model.people.PeopleDataItemModel
import com.example.virginmoneydeveloperproject.data.remote.people.PeopleApiDetails
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
    private val _details = MutableLiveData<List<PeopleDataItemModel>>()
    val details : LiveData<List<PeopleDataItemModel>> = _details

    fun getdetails() {
        viewModelScope.launch {
            val result = PeopleApiDetails.retrofitDetails.getDetails()

            _details.postValue(result)

        }
    }
}