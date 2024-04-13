pluginManagement {
    val kotlinVersion: String by settings

    plugins {
        kotlin("jvm") version kotlinVersion
    }
}

rootProject.name = "lessons"

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

include("m1l1-first")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
