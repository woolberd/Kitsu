plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    // Kapt
    // Для работы с аннотациями
    kotlin("kapt")

    // Hilt
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.kitsu"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.kitsu"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        // View Binding
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Retrofit 2
    // нужен для связи с сервером
    val retrofitVersion = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")

    // Gson
    // для преобразования данных json формата
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    // OkHttp
    // Ответы от сервера
    implementation(platform("com.squareup.okhttp3:okhttp-bom:5.0.0-alpha.6"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    // Navigation
    // Навигация между экранами
    val navVersion = "2.5.3"
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    // Glide
    // Для отображения картин с сервера
    implementation("com.github.bumptech.glide:glide:4.15.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.0")

    // ViewBindingPropertyDelegate
    // Binding в виде делегатов
    val view_binding_property_delegate = "1.5.3"
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:$view_binding_property_delegate")

    // Hilt
    // Для более легкой работы приложения
    val hilt_version = "2.45"
    implementation("com.google.dagger:hilt-android:$hilt_version")
    kapt("com.google.dagger:hilt-compiler:$hilt_version")

    // Livedata
    // Сохранение и отслеживание данных в реальном времени
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")

    // ViewModel
    // Для соединения бизнес логики и пользовательского интерфейса
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    // RecyclerView
    // Динамический список
    implementation ("androidx.recyclerview:recyclerview:1.3.0")
    implementation ("androidx.recyclerview:recyclerview-selection:1.1.0")
}