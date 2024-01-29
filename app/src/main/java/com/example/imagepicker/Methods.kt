package com.example.imagepicker

import android.net.Uri
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun Method(state: MainViewModel, Pick: ActivityResultLauncher<PickVisualMediaRequest>) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = {

            Pick.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))

        })
        {
            Text(text = "Choose image !!!")
        }
        Button(onClick = { state.uploadImage() }) {
            Text(text="Upload image")
        }

        Button(onClick = {
            state.getImage()
        }) {
            Text(text="Show")
        }

    }

}

@Composable
fun Img(link: Uri?) {

    AsyncImage(
        model = link,
        contentDescription = "lag gyi photo...",
        modifier = Modifier
            .height(200.dp)
            .width(200.dp)

    )
}