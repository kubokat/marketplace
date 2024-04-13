package ru.otuskotlin.marketplace.plugin

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.the
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

@Suppress("LongMethod", "MagicNumber")
private fun KotlinMultiplatformExtension.configureTargets(project: Project) {
    val libs = project.the<LibrariesForLibs>()
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(libs.versions.jvm.language.get()))
    }

    jvm {
        compilations.configureEach {
            compilerOptions.configure {
                jvmTarget.set(JvmTarget.valueOf("JVM_${libs.versions.jvm.compiler.get()}"))
            }
        }
    }
    macosArm64()
    macosX64()
    project.tasks.withType(JavaCompile::class.java) {
        sourceCompatibility = libs.versions.jvm.language.get()
        targetCompatibility = libs.versions.jvm.compiler.get()
    }
}
