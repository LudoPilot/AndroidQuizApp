pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        id("com.android.application") version "8.0.2"
        id("org.jetbrains.kotlin.android") version "1.8.22"
        id("com.google.devtools.ksp") version "1.8.22-1.0.11"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MyQuizApp"
include(":app")
