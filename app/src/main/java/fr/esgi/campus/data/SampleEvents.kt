package fr.esgi.campus.data

import fr.esgi.campus.model.Event

val sampleEvents = listOf(
    Event(
        id = 1,
        title = "Conférence Kotlin",
        category = "TECH",
        location = "Salle 204",
        capacity = 120,
        description = "Une plongée dans les nouveautés du langage Kotlin : coroutines, flows, multiplateforme et bonnes pratiques pour écrire un code plus sûr et plus lisible. La conférence se termine par une session de questions-réponses avec les intervenants."
    ),
    Event(
        id = 2,
        title = "Atelier Compose",
        category = "TECH",
        location = "Lab 3",
        capacity = 0,
        description = "Un atelier pratique pour construire pas à pas une interface Android avec Jetpack Compose : composables, Modifier, layouts, listes et thème Material 3. Venez avec votre ordinateur et Android Studio installé."
    ),
    Event(
        id = 3,
        title = "Meetup Android",
        category = "COMMUNAUTÉ",
        location = null,
        capacity = 1,
        description = "Rencontre informelle entre étudiants et développeurs Android du campus. Retours d'expérience, démonstrations de projets personnels et échanges autour des outils du quotidien."
    ),
    Event(
        id = 4,
        title = "Initiation au design d'interface",
        category = "DESIGN",
        location = "Amphi B",
        capacity = 60,
        description = "Les bases du design d'interface mobile : hiérarchie visuelle, couleurs, typographie, accessibilité et prototypage rapide. Aucun prérequis, ouvert à toutes les filières."
    ),
    Event(
        id = 5,
        title = "Tournoi de football inter-promos",
        category = "SPORT",
        location = "Gymnase",
        capacity = 22,
        description = "Le traditionnel tournoi de football entre promotions. Formez votre équipe, venez supporter vos camarades et profitez du goûter offert à la fin des matchs."
    )
)
