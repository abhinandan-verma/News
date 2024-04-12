package com.abhinandan.news.auth

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhinandan.news.MainActivity
import com.abhinandan.news.R
import com.abhinandan.news.getActivity

@Composable
fun Auth(modifier: Modifier = Modifier) {

    var auth  by remember {
        mutableStateOf(true)
    }

    val context = LocalContext.current

    Column(

    ) {


        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .weight(weight = 1F, fill = false)
                .fillMaxSize()
                .padding(10.dp)
                .background(
                    Brush.linearGradient(
                        listOf(
                            Color.White,
                            Color.Cyan
                        )
                    )
                ),
            verticalArrangement = Arrangement.Center,
        ) {

            Spacer(modifier = Modifier.height(30.dp))


            Image(
                painter = painterResource(id = R.drawable.bg1),
                contentDescription = "Stay Updated",
                modifier = Modifier
                    .padding(2.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "How would you like to join us?",
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        auth = true
                    },
                    colors = ButtonDefaults.buttonColors(Color.Magenta)
                ) {
                    Text(
                        text = "SIGN IN",
                        color = Color.White
                    )
                }
                Button(
                    onClick = {
                        auth = false
                    },
                    colors = ButtonDefaults.buttonColors(Color.Blue)
                ) {
                    Text(
                        text = "SIGN UP",
                        color = Color.White
                    )
                }

                TextButton(
                    onClick = {
                        val intent = Intent(context.getActivity(), MainActivity::class.java)
                        context.startActivity(intent)
                    },

                ) {
                    Text(
                        text = "Skip",
                        color = Color.Black
                    )
                }
            }

            if (auth) {
                Login()
            } else {
                SignUp()
            }

        }



    }
}