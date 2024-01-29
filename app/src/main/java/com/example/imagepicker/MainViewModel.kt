package com.example.imagepicker

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

    var image = mutableStateOf<Uri?>(null)
    var flag = mutableStateOf(0)
    var profile = mutableStateOf(Profile())
    var getImage = mutableStateOf("")

    var firebase = FirebaseRepo()


    fun uploadImage(){
        viewModelScope.launch {
            firebase.uploadImage(image.value!!,profile)
        }
    }

    fun getImage(){
        viewModelScope.launch {
              firebase.getImage().also {
                  getImage.value = it
              }
        }
    }
}

