
plugins {
    id(Plugins.application)
    kotlin(Plugins.android)
    kotlin(Plugins.kapt)
    id(Plugins.hilt)
    id(Plugins.detekt) version Versions.detekt
}

detekt {
    config = files("$rootDir/scripts/detekt/config.yml")
}

android {
    compileSdk = ConfigData.compileSdk

    defaultConfig {
        applicationId = ConfigData.applicationId
        minSdk = ConfigData.minSdk
        targetSdk = ConfigData.targetSdk
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = ConfigData.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //Coil
    implementation(Deps.coil)
    implementation(Deps.coilLandscapist)

    //Parse SDK
    implementation(Deps.parseSdk)
    implementation(Deps.parseSdkKtx)

    //Coroutines
    implementation(Deps.coroutines)

    //Navigation
    implementation(Deps.navigation)

    //Hilt
    implementation(Deps.hiltNavigation)
    implementation(Deps.hilt)
    kapt(Deps.hiltCompiler)

    //Lifecycles ktx
    implementation(Deps.lifecycleRuntimeKtx)
    implementation(Deps.lifecycleViewmodelKtx)

    //Timber
    implementation(Deps.timber)

    // Ui
    implementation(Deps.coreKtx)
    implementation(Deps.appcompat)
    implementation(Deps.material)
    implementation(Deps.materialIconsExtended)
    implementation(Deps.composeUi)
    implementation(Deps.composeMaterial)
    implementation(Deps.composePreview)
    implementation(Deps.composeActivity)
    debugImplementation(Deps.composeUiTooling)

    //Tests
    testImplementation(platform(Deps.junitBom))
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.androidExtJunit)
    testImplementation(Deps.mockk)
    testImplementation(Deps.assertJ)
}

tasks.withType<Test> {
    useJUnitPlatform()
}
