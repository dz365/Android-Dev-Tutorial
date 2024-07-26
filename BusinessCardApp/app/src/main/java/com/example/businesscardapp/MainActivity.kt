package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardScreen(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ContactInfoItem(
    icon: ImageVector,
    iconDescription: String,
    content: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            icon,
            contentDescription = iconDescription,
            modifier = Modifier
                .width(20.dp)
                .height(20.dp)
        )
        Text(
            text = content,
            fontSize = 14.sp
        )
    }
}

@Composable
fun BusinessCardScreen(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = null,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .background(Color(0xFF2a9a5c))
                    .width(128.dp)
            )
            Text(
                text = "Daniel Zhang",
                color = Color(0xFF2a9a5c),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = "Aspiring Android Developer",
                color = Color(0xFF697375),
            )
        }
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .padding(bottom = 32.dp)
                .align(Alignment.BottomCenter)
        ) {
            ContactInfoItem(
                icon = ImageVector.vectorResource(R.drawable.phone),
                iconDescription = "Phone Number",
                content = "+1 (234) 567 8910"
            )
            ContactInfoItem(
                icon = ImageVector.vectorResource(R.drawable.email),
                iconDescription = "Email Address",
                content = "androiddev@gmail.com"
            )
            ContactInfoItem(
                icon = ImageVector.vectorResource(R.drawable.github),
                iconDescription = "Github Account",
                content = "github.com/dz365"
            )
            ContactInfoItem(
                icon = ImageVector.vectorResource(R.drawable.linkedin),
                iconDescription = "LinkedIn Account",
                content = "linkedin.com/in/dz365"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardAppTheme {
        BusinessCardScreen("Android")
    }
}