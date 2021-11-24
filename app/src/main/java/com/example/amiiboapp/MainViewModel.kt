package com.example.amiiboapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.amiiboapp.data.AmiiboEntity
import com.example.amiiboapp.data.SampleDataProvider

class MainViewModel : ViewModel() {
    val amiiboList = MutableLiveData<List<AmiiboEntity>>()

    init{
        amiiboList.value = SampleDataProvider.getAmiibo()
    }
}