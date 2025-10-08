package com.cso.coffeexp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cso.coffeexp.R
import com.cso.coffeexp.ui.theme.CoffeeXpTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetImageSource(
    onSelectCamera: () -> Unit = {},
    onSelectGallery: () -> Unit = {},
    onBack: () -> Unit = {},
) {
    val sheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        sheetState = sheetState,
        containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
        onDismissRequest = onBack,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Selecionar imagem",
                style = androidx.compose.material3.MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                BottomSheetItem(
                    text = stringResource(id = R.string.label_camera),
                    icon = {
                        Icon(
                            Icons.Default.DateRange,
                            contentDescription = stringResource(id = R.string.label_camera)
                        )
                    },
                    onClick = { onSelectCamera() }
                )
                BottomSheetItem(
                    text = stringResource(id = R.string.label_gallery),
                    icon = {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = stringResource(id = R.string.label_gallery)
                        )
                    },
                    onClick = { onSelectGallery() }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun BottomSheetItem(text: String, icon: @Composable () -> Unit, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        icon()
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = text)
    }
}

@Preview()
@Composable
fun BottomSheetPhotoPreview() {
    CoffeeXpTheme {
        BottomSheetImageSource()
    }
}
