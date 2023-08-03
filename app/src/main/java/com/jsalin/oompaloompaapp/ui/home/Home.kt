package com.jsalin.oompaloompaapp.ui.home

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.jsalin.oompaloompaapp.domain.item.OompaLoompaItem
import com.jsalin.oompaloompaapp.ui.detail.OompaLoompaDetailsAlertDialog

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel = hiltViewModel()) {
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    var selectedOompaLoompa by remember { mutableStateOf<OompaLoompaItem?>(null) }
    // val homeViewModel: HomeViewModel = hiltViewModel()
    // val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val oompaLoompas by homeViewModel.oompaLoompas.collectAsState()
    var oompaLoompaItems by remember {
        mutableStateOf(oompaLoompas)
    }

    Column {
        FilterButtons(
            onFilter1Click = {
                Toast.makeText(context, "Filtrado Profesión", Toast.LENGTH_LONG).show()

            },
            onFilter2Click = {
                Toast.makeText(context, "Filtrado Género", Toast.LENGTH_LONG).show()
            }
        )

        LazyVerticalGrid(GridCells.Fixed(2)) {
            items(oompaLoompas) { loompa: OompaLoompaItem ->
                OompaLoompaCard(loompa) {
                    selectedOompaLoompa = loompa
                    showDialog = true
                }
            }
        }

        if (showDialog && selectedOompaLoompa != null) {
            OompaLoompaDetailsAlertDialog(
                oompaLoompa = selectedOompaLoompa!!,
                onDismiss = {
                    showDialog = false
                    selectedOompaLoompa = null
                }
            )
        }
    }
}

@Composable
fun FilterButtons(onFilter1Click: () -> Unit, onFilter2Click: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Button(
            onClick = onFilter1Click,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "Profesión")
        }
        Spacer(modifier = Modifier.width(16.dp))
        Button(
            onClick = onFilter2Click,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "Género")
        }
    }
}

@Composable
fun OompaLoompaCard(oompaLoompa: OompaLoompaItem, onItemSelected: (OompaLoompaItem) -> Unit) {
    Card(
        modifier = Modifier
            .clickable { onItemSelected(oompaLoompa) }
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 4.dp,
        shape = RoundedCornerShape(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            AsyncImage(
                model = oompaLoompa.image,
                "Oompa-Loompa image",
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp))
            )
            Row(
                modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = oompaLoompa.first_name,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.paddingFromBaseline(top = 24.dp)
                )
                Text(
                    text = oompaLoompa.gender,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.paddingFromBaseline(top = 24.dp)
                )
            }

            Text(
                text = oompaLoompa.last_name,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.paddingFromBaseline(top = 8.dp)
            )
        }
    }
}
