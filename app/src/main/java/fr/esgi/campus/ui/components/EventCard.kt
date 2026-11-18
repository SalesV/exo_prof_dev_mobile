package fr.esgi.campus.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.esgi.campus.R
import fr.esgi.campus.data.sampleEvents
import fr.esgi.campus.model.Event
import fr.esgi.campus.ui.theme.CampusTheme

@Composable
fun EventCard(
    event: Event,
    onClick: () -> Unit,
    onBook: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(onClick = onClick, modifier = modifier) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.Top) {
                Text(
                    text = event.title,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = event.category,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Text(
                text = event.location ?: stringResource(R.string.location_to_be_confirmed),
                style = MaterialTheme.typography.bodyMedium
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SeatsLabel(
                    capacity = event.capacity,
                    modifier = Modifier.weight(1f)
                )
                Button(onClick = onBook, enabled = event.capacity > 0) {
                    Text(stringResource(R.string.book))
                }
            }
        }
    }
}

@Composable
fun SeatsLabel(
    capacity: Int,
    modifier: Modifier = Modifier
) {
    if (capacity == 0) {
        Text(
            text = stringResource(R.string.event_full),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.error,
            modifier = modifier
        )
    } else {
        Text(
            text = pluralStringResource(R.plurals.available_seats, capacity, capacity),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = modifier
        )
    }
}

@Preview(name = "Clair", showBackground = true)
@Preview(name = "Sombre", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun EventCardPreview() {
    CampusTheme {
        Surface {
            EventCard(
                event = sampleEvents[0],
                onClick = {},
                onBook = {},
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(name = "Complet clair", showBackground = true)
@Preview(name = "Complet sombre", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun EventCardFullPreview() {
    CampusTheme {
        Surface {
            EventCard(
                event = sampleEvents[1],
                onClick = {},
                onBook = {},
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
