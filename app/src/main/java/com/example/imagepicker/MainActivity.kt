package com.example.imagepicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.net.toUri
import com.example.imagepicker.ui.theme.ImagePickerTheme

class MainActivity : ComponentActivity() {


    private val state: MainViewModel by viewModels()
    private val Pick = registerForActivityResult(ActivityResultContracts.PickVisualMedia())
    { uri ->
        state.image.value = uri

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            ImagePickerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Method(state, Pick)

                    if (state.getImage.value != null) {
                        Img(state.getImage.value.toUri())
                    }

                }
            }
        }
    }
}




