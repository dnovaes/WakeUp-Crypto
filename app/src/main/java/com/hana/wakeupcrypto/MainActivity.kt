package com.hana.wakeupcrypto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hana.wakeupcrypto.ui.theme.WakeUpCryptoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WakeUpCryptoTheme {
                MainActivityScreen()
            }
        }
    }
}

@Composable
private fun MainActivityScreen() {
    // A surface container using the 'background' color from the theme
    Surface(color = MaterialTheme.colors.background) {
        Column {
            HeaderView("WakeUp...Crypto!!")
            SpotView()
        }
    }
}

@Composable
fun HeaderView(name: String) {
    Surface(color = MaterialTheme.colors.primary) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(name, modifier = Modifier.padding(2.dp))
        }
    }
}

@Composable
fun SpotView(spotContent: List<Pair<String, String>> =
                 listOf(Pair("BNB", "575.4"), Pair("BCOIN", "6.08"))
) {
    LazyColumn (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
    ) {
        items (items = spotContent) { spotCurrency ->
            Row (modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = spotCurrency.first,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(horizontal = 2.dp, vertical = 2.dp)
                        .fillMaxWidth(0.5f)
                )
                Text(
                    text = spotCurrency.second+"$",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(horizontal = 2.dp, vertical = 2.dp)
                        .fillMaxWidth()
                )
           }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    WakeUpCryptoTheme {
        MainActivityScreen()
    }
}