package com.abhinandan.news.view.screens

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.abhinandan.news.auth.AuthActivity
import com.abhinandan.news.network.viewmodel.CategoryViewModel
import com.abhinandan.news.ui.theme.LoadingProgressBar
import com.google.firebase.auth.FirebaseAuth

@Composable
fun CategoryScreen(onClick: (category: String) -> Unit) {
    val categoryViewModel: CategoryViewModel = hiltViewModel()
    val categories: State<List<String>> = categoryViewModel.categories.collectAsState()
    val context = LocalContext.current

    if (categories.value.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(1f),
            contentAlignment = Alignment.Center
        ) {

            Column {

                LoadingProgressBar()

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Loading...",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.Cyan,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 30.sp
                )

            }

        }
    } else {
        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            item {

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Categories",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "Select a category to view news",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                }

            }

            items(categories.value.distinct()) {
                CategoryItem(category = it, onClick)
                Log.d("TAG", it)
            }

            item{

                Column (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            val auth = FirebaseAuth.getInstance()
                            auth.signOut()
                            Toast.makeText(context, "Logged Out", Toast.LENGTH_SHORT).show()
                            val intent = Intent(context, AuthActivity::class.java)
                            context.startActivity(intent)
                        },
                        colors = ButtonDefaults.buttonColors(Color.Red)

                    ) {

                        Text(
                            text = "Log Out",
                            color = Color.White
                        )
                    }
                }

            }
        }
    }


}

@Composable
fun CategoryItem(category: String, onClick: (category: String) -> Unit) {
    Box(modifier = Modifier
        .clickable {
            onClick(category)
        }
        .padding(7.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(8.dp))
        .border(2.dp, Color(0xFFEEEEEE)),
        contentAlignment = Alignment.TopStart
    ) {


        AsyncImage(
            model = "https://static.vecteezy.com/system/resources/thumbnails/004/216/831/original/3d-world-news-background-loop-free-video.jpg",
            contentDescription = " news image",
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
                .clip(RoundedCornerShape(8.dp))
        )

        Text(
            text = category,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(8.dp),
            color = Color.White,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 35.sp
        )
    }
}