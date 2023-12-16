plugins {
    id("com.android.library")
}

android {
    namespace = "com.yasirkula.unity"
    compileSdk = 34

    defaultConfig {
        minSdk = 4

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    /**
     * Notes Impl: Use DomainObjectCollection#all
     */
    libraryVariants.all {
        val variant = this
        variant.outputs
            .map { it as com.android.build.gradle.internal.api.BaseVariantOutputImpl }
            .forEach { output ->
                val outputFileName = "/../../../../../../Plugins/NativeShare/Android/NativeShare.aar"
                //D:\Projects\Bin\UnityNativeShare\Plugins\NativeShare\Android
                //D:\Projects\Bin\UnityNativeShare\.github\AARProject\UnityNativeShare\build\outputs\aar
                //val outputFileName = "MyTestName.aar"
                println("OutputFileName: $outputFileName")
                output.outputFileName = outputFileName
            }
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}