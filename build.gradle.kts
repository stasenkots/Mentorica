// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }

    }
    dependencies {
        classpath(BuildPlugins.gradle)
        classpath(BuildPlugins.kotlin)
        classpath(BuildPlugins.hilt)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
