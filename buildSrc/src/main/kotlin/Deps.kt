object Deps {

    //Parse SDK
    const val parseSdk = "com.github.parse-community.Parse-SDK-Android:parse:${Versions.parseSdk}"
    const val parseSdkKtx = "com.github.parse-community.Parse-SDK-Android:ktx:${Versions.parseSdk}"

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
    const val coreKtx = "androidx.core:core-ktx:${Versions.core}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val materialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.compose}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
}
