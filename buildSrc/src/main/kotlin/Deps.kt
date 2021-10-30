object Deps {

    //Coil
    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
    const val coilLandscapist = "com.github.skydoves:landscapist-coil:${Versions.coilLandscapist}"

    //Parse SDK
    const val parseSdk = "com.github.parse-community.Parse-SDK-Android:parse:${Versions.parseSdk}"
    const val parseSdkKtx = "com.github.parse-community.Parse-SDK-Android:ktx:${Versions.parseSdk}"

    //Network
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gsonConverterFactory = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    //Cache
    val datastore = "androidx.datastore:datastore-preferences-core:${Versions.dataStore}"

    //Coroutines
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    //Navigation
    const val navigation = "androidx.navigation:navigation-compose:${Versions.navigation}"

    //Hilt
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigation}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"

    //Lifecycles ktx
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleViewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    //Timber
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // Ui
    const val binding = "androidx.compose.ui:ui-viewbinding:${Versions.compose}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.core}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val materialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.compose}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"

    //Test
    const val junitBom = "org.junit:junit-bom:${Versions.junit}"
    const val junit = "org.junit.jupiter:junit-jupiter"
    const val androidExtJunit = "androidx.test.ext:junit:${Versions.androidExtJunit}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val assertJ = "org.assertj:assertj-core:${Versions.assertJ}"
}
