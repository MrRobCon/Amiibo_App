package com.example.amiiboapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amiiboapp.data.AmiiboEntity
import com.example.amiiboapp.data.SampleDataProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    val amiiboList = MutableLiveData<List<AmiiboEntity>>()

    init{
        amiiboList.value = SampleDataProvider.getAmiibo()
    }
}