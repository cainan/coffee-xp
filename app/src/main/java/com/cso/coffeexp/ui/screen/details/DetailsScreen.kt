package com.cso.coffeexp.ui.screen.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cso.coffeexp.domain.model.Coffee
import com.cso.coffeexp.ui.theme.CoffeeXpTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    uiState: DetailsUIState,
    coffeeId: String? = null,
    onEvent: (DetailsEvent) -> Unit = {},
    onBackPressed: () -> Unit = {},
) {

    coffeeId?.let {
        LaunchedEffect(Unit) {
            onEvent(DetailsEvent.FindCoffeeById(coffeeId))
        }
    }

    val coffeeName = uiState.coffee.name
    val coffeeMethod = uiState.coffee.method
    val coffeeGrade = uiState.coffee.grade.toString()
    val coffeeNotes = uiState.coffee.notes
    var selectedImageUri = uiState.coffee.imageUrl

    val context = LocalContext.current

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Add New Coffee") },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()), // Make the column scrollable
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // --- Round Image Picker ---
            Box(
                modifier = Modifier
                    .size(150.dp) // Adjust size as needed
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .clickable {

                    }
                    .border(
                        BorderStroke(
                            2.dp,
                            MaterialTheme.colorScheme.primary
                        ),
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.AccountBox,
                    contentDescription = "Add image",
                    modifier = Modifier.size(48.dp),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // --- Coffee Name ---
            OutlinedTextField(
                value = coffeeName,
                onValueChange = { onEvent(DetailsEvent.OnCoffeeNameChanged(it)) },
                label = { Text("Coffee Name *") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // --- Coffee Method ---
            OutlinedTextField(
                value = coffeeMethod,
                onValueChange = { onEvent(DetailsEvent.OnCoffeeMethodChanged(it)) },
                label = { Text("Brewing Method *") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // --- Coffee Grade ---
            OutlinedTextField(
                value = coffeeGrade,
                onValueChange = { onEvent(DetailsEvent.OnCoffeeGradeChanged(it)) },
                label = { Text("Grade (e.g., 4.5) *") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // --- Tasting Notes (Optional) ---
            OutlinedTextField(
                value = coffeeNotes ?: "",
                onValueChange = { onEvent(DetailsEvent.OnCoffeeNotesChanged(it)) },
                label = { Text("Tasting Notes (Optional)") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 3
            )

            Spacer(modifier = Modifier.weight(1f)) // Push button to the bottom

            // --- Save Button ---
            Button(
                onClick = {
                    onEvent(DetailsEvent.SaveCoffee(onBackPressed))
                },
                enabled = coffeeName.isNotBlank() && coffeeMethod.isNotBlank() && coffeeGrade.isNotBlank(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) { Text("Save Coffee") }
        }
    }
}

// Preview for AddCoffeeScreen
@Preview(showBackground = true, device = "id:pixel_6")
@Composable
fun AddCoffeeScreenPreview() {
    CoffeeXpTheme {
        DetailsScreen(
            uiState = DetailsUIState(
                isLoading = false,
                coffee = Coffee(
                    name = "Ethiopian Yirgacheffe",
                    method = "Pour Over",
                    grade = 4.8f,
                    notes = "Bright acidity, floral notes, hints of citrus and berries."
                )
            ),
        )
    }
}
