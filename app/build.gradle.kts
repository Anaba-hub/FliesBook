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
    implementation(libs.androidx.core.ktx.v1120)
    implementation(libs.androidx.lifecycle.runtime.ktx.v262) // Ajoute le runtime pour les composants Lifecycle, nécessaire pour gérer les ViewModels et les cycles de vie
    implementation(libs.androidx.activity.compose.v180) // Utilisé pour faciliter l'intégration de Compose dans les activités Android
    implementation(libs.ui) // Librairie de base pour utiliser Jetpack Compose
    implementation(libs.ui.tooling.preview) // Utilisé pour la prévisualisation de l'interface utilisateur dans Android Studio
    implementation(libs.material3) // Composants Material Design 3 pour Jetpack Compose
    implementation(libs.androidx.room.runtime.v252)
    implementation(libs.junit.junit)
    implementation(libs.androidx.junit.ktx)
    implementation(libs.androidx.monitor)
    implementation(libs.androidx.runner)
    implementation(libs.androidx.ui.test.junit4.android) // Runtime de Room pour accéder à la base de données
    kapt(libs.androidx.room.compiler.v252) // Générateur de code pour Room, utilisé pour les annotations des entités
    implementation(libs.androidx.room.ktx.v252) // Extensions Kotlin pour simplifier l'utilisation de Room
    implementation(libs.androidx.datastore.preferences.v110alpha05) // Utilisé pour stocker des préférences simples avec DataStore
    implementation(libs.androidx.lifecycle.viewmodel.compose.v287) // Intégration des ViewModels avec Jetpack Compose

    // Dependencies for testing
    androidTestImplementation(libs.androidx.ui.test.junit4.v175) // Dépendance pour tester les composants Jetpack Compose
    debugImplementation(libs.androidx.ui.tooling.v175) // Outil de débogage pour visualiser l'interface utilisateur
    debugImplementation(libs.androidx.ui.test.manifest.v175) // Utilisé pour les tests d'interface utilisateur en mode débogage

    androidTestImplementation(libs.espresso.core)
    testImplementation(libs.junit) // Dépendance pour les tests unitaires JUnit
    androidTestImplementation(libs.androidx.junit.v115) // Extension JUnit pour les tests Android
    androidTestImplementation(libs.androidx.espresso.core.v351) // Espresso pour tester l'interface utilisateur
}
