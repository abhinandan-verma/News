package com.abhinandan.news.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.abhinandan.news.network.viewmodel.DetailViewModel

@Composable
fun DetailScreen() {
    val detailViewModel: DetailViewModel = hiltViewModel()
    val news = detailViewModel.news.collectAsState()

    LazyColumn(
        content = {

        item {
            Column(
                modifier = Modifier.padding(14.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "News Details",
                    style = MaterialTheme.typography.titleLarge,
                )

                Text(
                    text = "News coming from jsonbin.io",
                    color = Color.Green,
                    fontSize = 10.sp,
                    modifier = Modifier.background(
                        color = Color.DarkGray,
                        shape = RoundedCornerShape(10.dp)
                    ).padding(2.dp)
                )

            }

            Spacer(modifier = Modifier.height(20.dp))
        }
        items(news.value) { news->

            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {

                Card(
                    colors = CardDefaults.cardColors(Color.LightGray),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)

                ){
                    if(news.imageUrl != null){
                        AsyncImage(
                            model = news.imageUrl,
                            contentDescription = "News Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                        )

                    }else{
                        Text(
                            text = "No Image Found",
                            color = Color.Red
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = news.title.toString(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Blue
                    )

                    Text(
                        text = news.content.toString(),
                        fontSize = 16.sp,
                        color = Color.Black,

                    )

                    Column(
                       verticalArrangement = Arrangement.Center,
                    ){
                        Text(
                            text = "Author: ${news.author!!}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black
                        )


                        Text(
                            text = "Published At: ${news.time!!}",
                            fontSize = 12.sp,
                            fontStyle = FontStyle.Italic,
                            color = Color.Black
                        )

                    }

                    TextButton(
                        onClick = {

                        }
                    ) {
                        Text(
                            text = " Link: ${news.link!!}",
                            fontSize = 14.sp,
                            color = Color.Blue,
                            fontStyle = FontStyle.Italic
                        )
                    }


                }
            }
        }
    })
}
