package com.example.composepractice

import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.IntentSender
import android.content.ServiceConnection
import android.content.SharedPreferences
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.content.res.AssetManager
import android.content.res.Configuration
import android.content.res.Resources
import android.database.DatabaseErrorHandler
import android.database.sqlite.SQLiteDatabase
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.UserHandle
import android.view.Display
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.ui.theme.ComposePracticeTheme
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2()
                }
            }
        }
    }
}

@Composable
private fun validity(username: String, password: String) {
    val mContext = LocalContext.current

    if (username == "kundan" && password == "12345678") {
        Toast.makeText(mContext, "Successfully Registeration", Toast.LENGTH_SHORT).show();
    } else {
        Toast.makeText(mContext, "Invalid", Toast.LENGTH_SHORT).show();

    }

}

@Composable
fun Greeting2() {
    val username = remember { mutableSetOf("") }
    val password = remember { mutableSetOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello Again !", color = Color.Blue,
            fontSize = 26.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
        )

        Text(
            text = "Hello Again !", color = Color.Blue,
            fontSize = 26.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
        )
        Text(
            text = "Welcome", color = Color.Blue,
            fontSize = 26.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)

        )
        Text(
            text = "Back", color = Color.Blue,
            fontSize = 26.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)

        )

        Spacer(modifier = Modifier.height(22.dp))

        TextField(
            value = username.first(), // Use the first value in the set
            onValueChange = {
                username.clear() // Clear the set before adding a new value
                username.add(it)
            },
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "person")
            },
            label = { Text("Username") },
            placeholder = { Text("Enter your username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp).padding(end = 20.dp)

        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = password.first(), // Use the first value in the set
            onValueChange = {
                password.clear() // Clear the set before adding a new value
                password.add(it)
            },
            leadingIcon = {
                          Icon(Icons.Default.Person, contentDescription = "person")
            },
            label = { Text("Password") },
            placeholder = { Text("Enter your password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp).padding(end = 20.dp)

        )

        Spacer(modifier = Modifier.height(26.dp))
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Registeration", fontWeight = FontWeight.Bold, fontSize = 25.sp)
            validity(username.first(),password.first())

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ComposePracticeTheme {
        Greeting2()
    }
}