package com.example.imagepicker

import android.net.Uri
import androidx.compose.runtime.MutableState
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.tasks.await

class FirebaseRepo {
    val db = Firebase.firestore
    var storageRef = Firebase.storage.reference

    suspend fun uploadImage(uri:Uri, profile: MutableState<Profile>) {
        storageRef.child("Image/usermail")
            .putFile(uri)
            .await()

    }

    suspend fun getImage() : String{
       return storageRef.child("Image/usermail")
            .downloadUrl
            .await()
           .toString()
    }



}