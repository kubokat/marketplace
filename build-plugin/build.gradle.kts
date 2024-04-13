plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("build-jvm") {
            id = "build-jvm"
            implementationClass = "ru.otuskotlin.marketplace.plugin.BuildPluginJvm"
        }
        register("build-kmp") {
            id = "build-kmp"
            implementationClass = "ru.otuskotlin.marketplace.plugin.BuildPluginMultiplatform.kt"
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.plugin.kotlin)
    implementation(libs.plugin.binaryCompatibilityValidator)
}
