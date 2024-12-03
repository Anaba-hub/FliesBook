# FliesBook

FliesBook est une application Android développée avec Kotlin et Jetpack Compose, permettant aux utilisateurs de rechercher des vols et de gérer leurs itinéraires favoris.

## Fonctionnalités

- **Recherche de Vols** : Les utilisateurs peuvent rechercher des aéroports par code IATA.
- **Gestion des Favoris** : Possibilité d'ajouter des itinéraires aux favoris et de les consulter facilement.
- **Sauvegarde des Recherches** : La dernière requête de recherche est sauvegardée à l'aide de DataStore, permettant de retrouver rapidement ses recherches précédentes.

## Technologies Utilisées

- **Kotlin** : Langage de programmation principal.
- **Jetpack Compose** : Framework UI moderne pour la création d'interfaces utilisateur.
- **Room** : Base de données locale pour gérer les aéroports et les itinéraires favoris.
- **DataStore** : Pour sauvegarder les préférences utilisateur, comme les dernières recherches.
- **JUnit & Espresso** : Utilisés pour les tests unitaires et les tests UI.

## Structure du Projet

- `FlightApplication.kt` : Point d'entrée de l'application, initialisant la base de données et les préférences.
- `MainActivity.kt` : Activité principale qui lance l'interface utilisateur de l'application.
- `FlightSearchViewModel.kt` : Gestion de la logique de recherche de vols et des favoris.
- `AirportDao.kt` & `FavoriteDao.kt` : Interfaces pour les opérations CRUD sur les aéroports et les favoris.
- `PreferencesManager.kt` : Gère la sauvegarde et la récupération des préférences utilisateur avec DataStore.
- `MainScreen.kt` : Écran principal de l'application, permettant la recherche de vols et la gestion des favoris.

## Installation

1. Clonez le dépôt sur votre machine locale :
   ```sh
   git clone https://github.com/votre-utilisateur/FliesBook.git
   ```
2. Ouvrez le projet dans Android Studio.
3. Assurez-vous d'avoir installé le SDK Android 34 et d'avoir configuré un émulateur ou un appareil physique pour les tests.
4. Construisez et exécutez l'application.

## Tests

- Les tests unitaires et UI sont situés dans le répertoire `test`.
- Utilisez Android Studio pour exécuter les tests, assurez-vous d'utiliser un émulateur ou un appareil physique pour les tests d'instrumentation.

## Contribution

Les contributions sont les bienvenues ! Pour toute contribution, veuillez :

1. Forker le projet.
2. Créer une nouvelle branche :
   ```sh
   git checkout -b feature/nom-fonctionnalité
   ```
3. Soumettre une Pull Request pour révision.

## Auteurs

- **Abraham Anaba** - Développeur principal

## Licence

Ce projet est sous licence MIT - voir le fichier [LICENSE](LICENSE) pour plus de détails.

