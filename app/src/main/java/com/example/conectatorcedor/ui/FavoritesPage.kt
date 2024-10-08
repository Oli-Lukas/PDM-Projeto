package com.example.conectatorcedor.ui

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.rounded.Place


@Preview(showBackground = true)
@Composable
fun FavoritesPage(modifier: Modifier = Modifier, viewModel: MainViewModel) {
    val alertasProximosList = viewModel.alertasProximos
    val activity = LocalContext.current as? Activity
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(alertasProximosList) { alerta ->
            AlertaProximoItem(alertaProximo = alerta, onClose = {
                viewModel.remove(alerta)
            }, onClick =  {
                Toast.makeText(activity, "Test click", Toast.LENGTH_LONG).show()
            })
        }
    }
}

@Composable
fun AlertaProximoItem(
    alertaProximo: AlertaProximo,
    onClick: () -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Rounded.Place,
            contentDescription = ""
        )
        Spacer(modifier = Modifier.size(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(modifier = Modifier,
                text = alertaProximo.name,
                fontSize = 24.sp)
            Text(modifier = Modifier,
                text = alertaProximo.localizacao,
                fontSize = 16.sp)
        }
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}