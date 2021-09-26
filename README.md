

![GitHub license](https://img.shields.io/badge/License-MIT-blue.svg)  ![TeamCity (simple build status)](https://img.shields.io/teamcity/http/teamcity.jetbrains.com/s/Kotlin_KotlinPublic_Compiler.svg) [![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)

![banner](https://user-images.githubusercontent.com/48829161/119891055-2f80e080-bf56-11eb-96c1-4131434b5db6.png)

# BOLT

A simple ride sharing app made with **kotlin** and **Google Maps** using  [**MVVM**](https://developer.android.com/jetpack/guide#overview) architecture.


# TO RUN THIS

1. Clone the repository .
2. Go to google cloud platform enable map sdk and place api.
3. Generate api key.
4. **MAKE SURE BILLING IS ENABLE TO USE PLACE API**
5. add your google map api key in **local.properties**  like `GMP_key=YOUR_KEY`
6. you are pretty much good to go.


# FEATURES
1. Support for dark and light theme.
2. Location permission handling.
3. Google Map integration.
4. Search Places integration.


# Built With 🛠
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more..
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
  - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.

- [Dependency Injection](https://developer.android.com/training/dependency-injection)
  - [Hilt-Dagger](https://dagger.dev/hilt/) - Standard library to incorporate Dagger dependency injection into an Android application.
  - [Hilt-ViewModel](https://developer.android.com/training/dependency-injection/hilt-jetpack) - DI for injecting `ViewModel`.
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.
- [Easy Permissions](https://github.com/googlesamples/easypermissions)- To manage user permissions.
- [Google play services](https://developers.google.com/android/guides/setup)-To manage user location.
- [Google Places](https://developers.google.com/maps/documentation/places/web-service/overview)-To search places.
- [Navigation Component](https://developer.android.com/guide/navigation/navigation-getting-started) - A simple navigation for android.
- [Preferences DataStore](https://developer.android.com/topic/libraries/architecture/datastore#preferences-datastore) - Storage that allows you to store key-value pairs.
- [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) - For writing Gradle build scripts using Kotlin.
- [Sheet](https://github.com/maxkeppeler/sheets) - Liberary for creating bottom-sheet.

# Package Structure

    # Root Package

    ├── di                  # Dependency Injection
    ├── ui                  # Activity/View layer
    ├── repositories        # Single source of data
    └── others              # Utility Classes / Kotlin extensions


## Architecture
This app uses [***MVVM (Model View View-Model)***](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) architecture.

![](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)

# FEATURES UNDER PROGRESS

1. To add mobile number authentication.
2. Refactoring ui.
3. To add manual location refresh.