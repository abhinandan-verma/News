package com.abhinandan.news.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.abhinandan.news.R

@Composable
fun Auth(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        val auth  = remember {
            mutableStateOf(true)
        }


        Image(
            painter = painterResource(id = R.drawable.bg1),
            contentDescription = "Stay Updated",
            modifier = Modifier.padding(2.dp).clip(shape = RoundedCornerShape(10.dp))
        )


    }

}