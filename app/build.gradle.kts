plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "ru.netology.nmedia"
    compileSdk = 34

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        applicationId = "ru.netology.nmedia"
        minSdk = 23
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
//    val lifecycle_version = "2.7.0"
//    val activity_version = "1.8.2"
//
//    implementation("androidx.core:core-ktx:1.12.0")
//    implementation("androidx.appcompat:appcompat:1.6.1")
//    implementation("com.google.android.material:material:1.11.0")
//    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
//    implementation("androidx.activity:activity-ktx:$activity_version")
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    val core_version = "1.12.0"
    val appcompat_version = "1.6.1"
    val mdc_version = "1.11.0"
    val constraintlayout_version = "2.1.4"
    val recyclerview_version = "1.3.2"
    val junit_version = "4.13.2"
    val ext_junit_version = "1.1.5"
    val espresso_core_version = "3.5.1"
    val activity_version = "1.8.2"
    val lifecycle_version = "2.7.0"

    implementation("androidx.core:core-ktx:$core_version")
    implementation("androidx.appcompat:appcompat:$appcompat_version")
    implementation("com.google.android.material:material:$mdc_version")
    implementation("androidx.constraintlayout:constraintlayout:$constraintlayout_version")
    implementation("androidx.recyclerview:recyclerview:$recyclerview_version")
    implementation("androidx.activity:activity-ktx:$activity_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")

    testImplementation("junit:junit:$junit_version")
    androidTestImplementation("androidx.test.ext:junit:$ext_junit_version")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espresso_core_version")

}