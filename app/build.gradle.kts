plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android") version "2.48" apply false
}

android {
    namespace = "com.example.fliesbook"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.fliesbook"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation(libs.androidx.lifecycle.runtime.ktx.v262) // Ajoute le runtime pour les composants Lifecycle, nécessaire pour gérer les ViewModels et les cycles de vie
    implementation("androidx.activity:activity-compose:1.8.0") // Utilisé pour faciliter l'intégration de Compose dans les activités Android
    implementation("androidx.compose.ui:ui:1.5.1") // Librairie de base pour utiliser Jetpack Compose
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.1") // Utilisé pour la prévisualisation de l'interface utilisateur dans Android Studio
    implementation("androidx.compose.material3:material3:1.2.0") // Composants Material Design 3 pour Jetpack Compose
    implementation("androidx.room:room-runtime:2.5.2")
    implementation(libs.junit.junit)
    implementation(libs.androidx.junit.ktx)
    implementation(libs.androidx.monitor)
    implementation(libs.androidx.runner)
    implementation(libs.androidx.ui.test.junit4.android) // Runtime de Room pour accéder à la base de données
    kapt("androidx.room:room-compiler:2.5.2") // Générateur de code pour Room, utilisé pour les annotations des entités
    implementation("androidx.room:room-ktx:2.5.2") // Extensions Kotlin pour simplifier l'utilisation de Room
    implementation("androidx.datastore:datastore-preferences:1.1.0-alpha05") // Utilisé pour stocker des préférences simples avec DataStore
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2") // Intégration des ViewModels avec Jetpack Compose

    // Dependencies for testing
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.1") // Dépendance pour tester les composants Jetpack Compose
    debugImplementation("androidx.compose.ui:ui-tooling:1.5.1") // Outil de débogage pour visualiser l'interface utilisateur
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.1") // Utilisé pour les tests d'interface utilisateur en mode débogage

    testImplementation("junit:junit:4.13.2") // Dépendance pour les tests unitaires JUnit
    androidTestImplementation("androidx.test.ext:junit:1.1.5") // Extension JUnit pour les tests Android
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1") // Espresso pour tester l'interface utilisateur
}
