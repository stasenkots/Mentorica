// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
       val compose_version = "1.0.0"

    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }

    }
    dependencies {
        classpath(BuildPlugins.gradle)
        classpath(BuildPlugins.kotlin)
        classpath(BuildPlugins.hilt)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}
