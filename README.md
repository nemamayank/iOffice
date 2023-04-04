# iOffice Mobile

- Application which display's images whatever you searched.
- Also shows you the detail image enlarged of selected content.

**Dependency Used In The Project**

 **Retrofit** |
 **Lifecycle** |
 **LiveData** |
 **Glide** |
 **Coroutines**
```
dependencies {
    ...
    def lifecycle_version = "2.6.1"
    def test_version = "1.12.0"

    implementation 'androidx.core:core-ktx:1.9.0'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.8.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    // Lifecycles only (without ViewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")

    // Saved state module for ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycle_version")

    // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
    implementation("androidx.lifecycle:lifecycle-process:$lifecycle_version")

    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))

    //Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.google.code.gson:gson:2.8.9'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:4.9.0'

    //Glide
    implementation 'com.github.bumptech.glide:glide:4.12.0'

    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    testImplementation "io.mockk:mockk:${test_version}"
    implementation "io.mockk:mockk-android:${test_version}"
    implementation 'javax.inject:javax.inject:1'
}
```

- Used **MVVM** clean architecture for loose coupling of classes and components
- Structured with the following heirarchy:
  **Data (API | Models)**,
  **UI (View | ViewModel | Adapter)**
  **Repository**
  **Utility**
- Display images in list and representing them using the **Glide** library
- Used DI for avoiding the boiler plate dependency
