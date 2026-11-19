package org.insbaixcamp.fitnessapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.insbaixcamp.fitnessapp.R
import org.insbaixcamp.fitnessapp.ui.components.CalendariPicker
import org.insbaixcamp.fitnessapp.ui.components.MenuDesplegable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(
    nom: String,
    email: String,
    dataNaixement: Long,
    genere: String,
    pes: Double,
    pesObjectiu: Double,
    alçada: Int,
    objectiu: String,
    onSave: (
        nom: String,
        email: String,
        dataNaixement: Long,
        genere: String,
        pes: Double,
        pesObjectiu: Double,
        alçada: Int
    ) -> Unit
) {
    var nomNou: String by remember { mutableStateOf(nom) }
    var emailNou: String by remember { mutableStateOf(email) }
    var dataNaixementNou: Long by remember { mutableStateOf(dataNaixement) }
    var genereNou: String by remember { mutableStateOf(genere) }
    var pesNou: Double by remember { mutableStateOf(pes) }
    var pesObjectiuNou: Double by remember { mutableStateOf(pesObjectiu) }
    var alçadaNou: Int by remember { mutableStateOf(alçada) }

    val opcionsGenere = listOf("Masculí", "Femení", "Prefereixo no dir-ho")

    Column(Modifier.fillMaxWidth()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.Black)
            )
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                Button(onClick = {}) { Text("Canviar foto") }
                Button(onClick = {}) { Text("Eliminar foto") }
            }
        }
        Text("Dades personals", modifier = Modifier.padding(8.dp))
        OutlinedTextField(
            value = nomNou,
            onValueChange = { nomNou = it },
            label = { Text("Nom complet") },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        )
        OutlinedTextField(
            value = emailNou,
            onValueChange = { emailNou = it },
            label = { Text("Email") },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        )

        // Calendari
        CalendariPicker(
            label = "Data de naixement",
            selectedDateMillis = dataNaixementNou,
            onDateSelected = { dataNaixementNou = it },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        // Genere
        MenuDesplegable(
            label = "Gènere",
            opcions = opcionsGenere,
            valorSeleccionat = genereNou,
            onValorSeleccionat = { genereNou = it },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        Text("Dades físiques", modifier = Modifier.padding(8.dp))
        Row(Modifier.padding(8.dp)) {
            OutlinedTextField(
                value = alçadaNou.toString(),
                onValueChange = { alçadaNou = it.toIntOrNull() ?: alçadaNou },
                label = { Text("Alçada") },
                modifier = Modifier.weight(1f),
            )
            OutlinedTextField(
                value = pesNou.toString(),
                onValueChange = { pesNou = it.toDoubleOrNull() ?: pesNou },
                label = { Text("Pes") },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp, end = 8.dp),
            )
            OutlinedTextField(
                value = pesObjectiuNou.toString(),
                onValueChange = { pesObjectiuNou = it.toDoubleOrNull() ?: pesObjectiuNou },
                label = { Text("Pes objectiu") },
                modifier = Modifier.weight(1f),
            )
        }
        Button(
            onClick = {
                onSave(
                    nomNou,
                    emailNou,
                    dataNaixementNou,
                    genereNou,
                    pesNou,
                    pesObjectiuNou,
                    alçadaNou
                )
            },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text("Guardar canvis")
        }
    }
}
