plugins {
    id("com.android.application") version "8.7.3" apply false
    id("com.google.dagger.hilt.android") version "2.52" apply false
    id("org.jetbrains.kotlin.kapt") version "2.0.0" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.2")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.52")
        classpath("com.android.tools.build:gradle:8.7.3")
    }
}
