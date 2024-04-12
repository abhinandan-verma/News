package com.abhinandan.news.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.abhinandan.news.MainActivity
import com.abhinandan.news.auth.ui.theme.NewsTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthActivity : ComponentActivity() {

    private val auth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            NewsTheme {
                Auth()
            }
        }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            //  updateUI(currentUser)
            reload(currentUser)
        }
    }

    private fun reload(currentUser: FirebaseUser) {
        Toast.makeText(this, "Authenticating ${currentUser.email}", Toast.LENGTH_LONG).show()
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}

