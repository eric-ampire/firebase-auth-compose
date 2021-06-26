plugins {
  id("com.android.application")
  id("kotlin-android")
  id("com.google.gms.google-services")
}

android {
  compileSdk = 30
  buildToolsVersion = "30.0.3"

  defaultConfig {
    applicationId = "com.ericampire.mobile.firebaseauthcompose"
    minSdk = 21
    targetSdk = 30
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
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
    useIR = true
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = rootProject.extra["compose_version"] as String
    kotlinCompilerVersion = "1.5.10"
  }
}

dependencies {

  implementation("androidx.core:core-ktx:1.5.0")
  implementation("androidx.appcompat:appcompat:1.3.0")
  implementation("com.google.android.material:material:1.3.0")
  implementation("androidx.compose.ui:ui:${rootProject.extra["compose_version"]}")
  implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")
  implementation("androidx.compose.material:material:${rootProject.extra["compose_version"]}")
  implementation("androidx.compose.ui:ui-tooling:${rootProject.extra["compose_version"]}")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
  implementation("androidx.activity:activity-compose:1.3.0-beta02")

  implementation(platform("com.google.firebase:firebase-bom:28.2.0"))
  implementation("com.google.firebase:firebase-auth-ktx")
  implementation("com.google.android.gms:play-services-auth:19.0.0")

  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.5.0")

  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.2")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
  androidTestImplementation("androidx.compose.ui:ui-test-junit4:${rootProject.extra["compose_version"]}")
}