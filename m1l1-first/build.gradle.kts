plugins {
    kotlin("jvm")
}

group = "ru.otuskotlin.marketplace"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test-junit"))
}

kotlin {
    jvmToolchain(17)
}
