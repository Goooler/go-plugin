/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * To learn more about Gradle by exploring our Samples at https://docs.gradle.org/8.3/samples
 */

plugins {
    id("jacoco")
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish") version "1.3.1"
    id("org.jetbrains.kotlin.jvm") version("2.1.20")
}

version = "0.7.0"
group = "com.fussionlabs.gradle"

repositories {
    mavenLocal()
    mavenCentral()
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(JavaVersion.VERSION_1_8.majorVersion))
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    reports {
        html.required = true
    }
}

gradlePlugin {
    website = "https://github.com/dm0275/go-plugin"
    vcsUrl = "https://github.com/dm0275/go-plugin.git"
    plugins {
        create("go-plugin") {
            id = "com.fussionlabs.gradle.go-plugin"
            displayName = "Go Gradle plugin"
            implementationClass = "com.fussionlabs.gradle.GoPlugin"
            tags = listOf("go", "golang")
            description = "The `Go-Plugin` is a Gradle plugin for Go projects. This plugin does not intend to replace" +
                    " Go's native dependency management system, instead this plugin focuses on replacing traditional " +
                    "task orchestrators like Make, offering a more versatile and reusable approach for task automation."
        }
    }
}