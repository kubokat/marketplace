plugins {
    kotlin("jvm")
    application
}

application {
    mainClass.set("ru.otuskotlin.m1l1.MainKt")
}

dependencies {
    testImplementation(kotlin("test-junit"))
}

kotlin {
    jvmToolchain(17)
}
