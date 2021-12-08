package com.hana.wakeupcrypto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hana.wakeupcrypto.domain.model.Currency
import com.hana.wakeupcrypto.ui.theme.WakeUpCryptoTheme
import com.hana.wakeupcrypto.viewmodel.MainViewModel
import com.hana.wakeupcrypto.viewmodel.MainViewModelFactory

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WakeUpCryptoTheme {
                MainActivityScreen(viewModel)
            }
        }
    }
}

@Composable
private fun MainActivityScreen(
    viewModel: MainViewModel = MainViewModelFactory().create(MainViewModel::class.java)
) {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            HeaderView("WakeUp... Crypto!")
            SpotView(viewModel.getCurrencies())
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
            Text(name, modifier = Modifier.padding(2.dp), fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun SpotView(spotContent: List<Currency>) {
    LazyColumn (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp)
    ) {
        items (items = spotContent) { spotCurrency ->
            Row (modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = spotCurrency.name,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(horizontal = 2.dp, vertical = 2.dp)
                        .fillMaxWidth(0.5f)
                )
                Text(
                    text = "$ " + spotCurrency.value,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(horizontal = 2.dp, vertical = 2.dp)
                        .fillMaxWidth()
                )
           }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 600)
@Composable
fun DefaultPreview() {
    WakeUpCryptoTheme {
        MainActivityScreen()
    }
}