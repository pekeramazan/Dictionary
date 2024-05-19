import org.jetbrains.kotlin.gradle.utils.extendsFrom

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.ramazanpeker.dictionary"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ramazanpeker.dictionary"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    // Compose dependencies
    //
    // Coroutines
    implementation(libs.kotlinCoroutinesCore)
    implementation(libs.kotlinCoroutinesAndroid)

    // Coroutine Lifecycle Scopes
    implementation(libs.lifecycleViewModelKtx)

    // Dagger - Hilt
    implementation(libs.daggerHiltAndroid)
    implementation(platform(libs.daggerHiltCompiler))
    implementation(libs.hiltNavigationCompose)
    implementation(libs.hiltLifecycleViewModel)
   // implementation(libs.hiltCompiler)

    // Retrofit
// Retrofit
    implementation(libs.retrofit) {
        exclude("org.jetbrains","annotations")
        exclude("com.intellij","annotations")
    }
    implementation(libs.retrofitConverterGson)
    implementation(libs.okhttp)
    implementation(libs.okhttpLoggingInterceptor)

    // Room
    implementation(libs.roomRuntime) {
        exclude("org.jetbrains","annotations")
        exclude("com.intellij","annotations")
    }
    implementation(libs.roomCompiler) {
        exclude("org.jetbrains","annotations")
        exclude("com.intellij","annotations")
    }
    implementation(libs.roomKtx)
}