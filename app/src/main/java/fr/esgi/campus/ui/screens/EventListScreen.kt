package fr.esgi.campus.ui.screens

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.esgi.campus.R
import fr.esgi.campus.data.sampleEvents
import fr.esgi.campus.model.Event
import fr.esgi.campus.ui.components.EventCard
import fr.esgi.campus.ui.theme.CampusTheme

private const val TAG = "Campus"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventListScreen(
    events: List<Event>,
    modifier: Modifier = Modifier
) {
    val categories = events.map { it.category }.distinct()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { Text(stringResource(R.string.app_name)) })
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item(key = "categories") {
                CategoryRow(
                    categories = categories,
                    onCategoryClick = { category -> Log.d(TAG, "Filtre sur la catégorie $category") }
                )
            }
            items(events, key = { it.id }) { event ->
                EventCard(
                    event = event,
                    onClick = { Log.d(TAG, "Clic sur l'événement ${event.id} : ${event.title}") },
                    onBook = { Log.d(TAG, "Réservation de l'événement ${event.id} : ${event.title}") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
            }
        }
    }
}

@Composable
fun CategoryRow(
    categories: List<String>,
    onCategoryClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories, key = { it }) { category ->
            FilterChip(
                selected = false,
                onClick = { onCategoryClick(category) },
                label = { Text(category) }
            )
        }
    }
}

@Preview(name = "Clair", showBackground = true)
@Preview(name = "Sombre", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun EventListScreenPreview() {
    CampusTheme {
        EventListScreen(events = sampleEvents)
    }
}
