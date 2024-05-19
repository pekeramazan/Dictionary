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
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
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
    implementation(libs.retrofit)
    implementation(libs.retrofitConverterGson)
    implementation(libs.okhttp)
    implementation(libs.okhttpLoggingInterceptor)

    // Room
    implementation(libs.roomRuntime)
    implementation(libs.roomCompiler) {
        exclude("org.jetbrains","annotations")
        exclude("com.intellij","annotations")
    }
    implementation(libs.roomKtx)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}