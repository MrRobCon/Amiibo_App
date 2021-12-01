package com.example.breakingbad

import android.util.Log
import androidx.lifecycle.*
import com.example.breakingbad.data.CharacterEntity
import com.example.breakingbad.dataaccess.RetrofitInstance
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _character: MutableLiveData<List<CharacterEntity>> = MutableLiveData()

    val character: LiveData<List<CharacterEntity>>

        get() = _character

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            _isLoading.value = true
            val fetchedCharacters = RetrofitInstance.api.getCharacters()
            Log.i(TAG, "List of Characters: $fetchedCharacters")
            _character.value = fetchedCharacters
            _isLoading.value = false
        }
    }
}