package fr.esgi.campus.data

import fr.esgi.campus.model.Event

val sampleEvents = listOf(
    Event(id = 1, title = "Conférence Kotlin", category = "TECH", location = "Salle 204", capacity = 120),
    Event(id = 2, title = "Atelier Compose", category = "TECH", location = "Lab 3", capacity = 0),
    Event(id = 3, title = "Meetup Android", category = "COMMUNAUTÉ", location = null, capacity = 40),
    Event(id = 4, title = "Initiation au design d'interface", category = "DESIGN", location = "Amphi B", capacity = 60),
    Event(id = 5, title = "Tournoi de football inter-promos", category = "SPORT", location = "Gymnase", capacity = 22)
)
