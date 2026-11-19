package org.insbaixcamp.fitnessapp.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.insbaixcamp.fitnessapp.data.WeightTracking
import org.insbaixcamp.fitnessapp.ui.components.WeightTrackingItem
import org.insbaixcamp.fitnessapp.ui.theme.FitnessAppTheme
import org.insbaixcamp.fitnessapp.utils.CalculadoraIMC

@Composable
fun WeightTrackingScreen(pes: Double, pesObjectiu: Double, alçada: Int) {
    val TAG = "WeightTrackingScreen"
    val listPes = remember { mutableStateListOf<WeightTracking>() }

    var _pes: Double by remember { mutableStateOf(pes) }
    var _pesTemporal: Double by remember { mutableStateOf(_pes) }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
    ) {
        Text(
            text = "📊 Seguiment de Pes i IMC",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .weight(1f),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .wrapContentHeight()
                ) {
                    Text("Pes actual", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Spacer(Modifier.height(4.dp))
                    Text("$_pes Kg", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                }
            }
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .weight(1f),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .wrapContentHeight()
                ) {
                    Text("Pes objectiu", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Spacer(Modifier.height(4.dp))
                    Text("$pesObjectiu Kg", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                }
            }
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .weight(1f),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .wrapContentHeight()
                ) {
                    Text("IMC", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onPrimaryContainer)
                    Spacer(Modifier.height(4.dp))
                    val imc = CalculadoraIMC.calcularIMC(_pes, alçada)
                    Text("$imc", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onPrimaryContainer)
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Registrar un nou pes",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            label = { Text(text = "Nou pes (kg)") },
            onValueChange = {
                _pesTemporal = it.toDoubleOrNull() ?: _pesTemporal
            },
            value = _pesTemporal.toString(),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = {
                val data = System.currentTimeMillis()
                _pes = _pesTemporal
                listPes.add(WeightTracking(_pes, data))
                Log.i(TAG, "Array de pes: $listPes")
            },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Guardar pes", fontWeight = FontWeight.Bold)
        }

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Evolució del pes",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(Modifier.height(8.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "📈 Gràfica d'evolució (Pròximament)",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Últims registres",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(
                items = listPes,
                key = { weightTracking -> weightTracking.data }
            ) { weightTracking ->
                WeightTrackingItem(weightTracking)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrackingScreenPreview() {
    FitnessAppTheme {
        WeightTrackingScreen(70.0, 60.0, 170)
    }
}
