package com.example.hellocompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hellocompose.ui.theme.HelloComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloComposeTheme {
                // Scaffold menyediakan struktur dasar tampilan seperti padding dan layout utama
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Memanggil fungsi composable utama untuk menampilkan UI
                    HelloToastScreenRowButtons(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
// Fungsi Composable utama yang menampilkan layar aplikasi
@Preview(showBackground = true)
@Composable
fun HelloToastScreenRowButtons(modifier: Modifier = Modifier) {
    // Mengambil konteks untuk menampilkan Toast
    val ctx = LocalContext.current
    // State 'count' disimpan agar tidak hilang saat rotasi layar
    var count by rememberSaveable { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(vertical = 16.dp)
                .background(color = colorResource(id =
                    R.color.yellow)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = count.toString(),
                fontSize = 64.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { Toast.makeText(ctx, "Count $count",
                    Toast.LENGTH_SHORT).show() },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = stringResource(id = R.string.toast))
            }
            Button(
                onClick = { count++ },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = stringResource(id = R.string.count))
            }
        }
    }
}

