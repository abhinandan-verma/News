package com.abhinandan.news.ui.theme



import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.widget.ContentLoadingProgressBar
import com.abhinandan.news.R
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun LoadingProgressBar(modifier: Modifier = Modifier) {

    val progress = remember {
        Animatable(0f)
    }

    LaunchedEffect(Unit) {
        progress.animateTo(1f, animationSpec = tween(durationMillis = 1000))
    }

    Box(
        modifier = modifier
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loding))

        val progressState = animateLottieCompositionAsState(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            isPlaying = true,
            speed = 1f,
            reverseOnRepeat = true,
            restartOnPlay = true,
        )
        LottieAnimation(
            composition = composition,
            progress = progressState.progress,
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center)
        )

    }
}

