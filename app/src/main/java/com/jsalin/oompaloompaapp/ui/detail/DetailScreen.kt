package com.jsalin.oompaloompaapp.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jsalin.oompaloompaapp.domain.item.OompaLoompaItem


@Composable
fun DetailScreen(modifier: Modifier = Modifier) {
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        buttons = {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Cerrar")
            }
        }, modifier = modifier, title = {
            Text(text = "Detalle Oompa-Loompa")
        }
    )
}

@Composable
fun OompaLoompaDetailsAlertDialog(
    oompaLoompa: OompaLoompaItem,
    onDismiss: () -> Unit
) {
    AlertDialog(
        title = { Text(text =("Detalle Oompa-Loompa")) },
        buttons = {
            OutlinedButton(
                onClick = { onDismiss() },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.Gray),
            ) {
                Text(text = "Cerrar")
            }
        },
        onDismissRequest = { onDismiss() },
        shape = RoundedCornerShape(4.dp),
        text = {
            OompaLoompaDetailsContent(oompaLoompa = oompaLoompa)
        }
    )
}

@Composable
fun OompaLoompaDetailsContent(oompaLoompa: OompaLoompaItem) {
    Column() {
        Text(
            text = "Nombre: ${oompaLoompa.first_name}",
            style = MaterialTheme.typography.body2,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.Start)
        )
        Text(
            text = "Apellido: ${oompaLoompa.last_name}",
            style = MaterialTheme.typography.body2,
            color = Color.Gray
        )
        Text(
            text = "Correo: ${oompaLoompa.email}",
            style = MaterialTheme.typography.body2,
            color = Color.Gray
        )
        Text(
            text = "Profesión: ${oompaLoompa.profession}",
            style = MaterialTheme.typography.body2,
            color = Color.Gray
        )
        Text(
            text = "País: ${oompaLoompa.country}",
            style = MaterialTheme.typography.body2,
            color = Color.Gray
        )
        Text(
            text = "Género: ${oompaLoompa.gender}",
            style = MaterialTheme.typography.body2,
            color = Color.Gray
        )
        Text(
            text = "Comida favorita: ${oompaLoompa.favorite.food}",
            style = MaterialTheme.typography.body2,
            color = Color.Gray
        )
    }
}
