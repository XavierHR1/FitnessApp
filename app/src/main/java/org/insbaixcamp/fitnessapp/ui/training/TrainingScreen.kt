package org.insbaixcamp.fitnessapp.ui.training

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

@Composable
fun TrainingScreen(
    viewModel: TrainingViewModel = viewModel()
) {
    val exercises = viewModel.exercises
    val isLoading = viewModel.isLoading
    val error = viewModel.error

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Entrenament",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = "Catàleg d'exercicis",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {

            items(
                items = exercises,
                key = { it.exerciseId }
            ) { exercise ->

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        AsyncImage(
                            model = exercise.gifUrl,
                            contentDescription = exercise.name,
                            modifier = Modifier.size(96.dp),
                            contentScale = ContentScale.Fit
                        )

                        Spacer(Modifier.width(12.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = exercise.name,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(Modifier.height(4.dp))

                            Text(
                                text = exercise.bodyParts
                                    .joinToString(", "),
                                style = MaterialTheme
                                    .typography.bodySmall
                            )

                            Text(
                                text = exercise.targetMuscles
                                    .joinToString(", "),
                                style = MaterialTheme
                                    .typography.bodySmall
                            )
                        }
                    }
                }
            }

            if (isLoading) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }

            if (error != null) {
                item {
                    Column {
                        Text(
                            text = error,
                            color = MaterialTheme.colorScheme.error
                        )

                        Button(
                            onClick = {
                                if (exercises.isEmpty()) {
                                    viewModel.loadExercises()
                                } else {
                                    viewModel.loadMore()
                                }
                            }
                        ) {
                            Text("Tornar a provar")
                        }
                    }
                }
            }

            if (viewModel.hasNextPage &&
                !isLoading &&
                error == null) {

                item {
                    Button(
                        onClick = {
                            viewModel.loadMore()
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Carregar més exercicis")
                    }
                }
            }
        }
    }
}