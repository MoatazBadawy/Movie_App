<h1 align="center">Movies App</h1>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=23"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://kotlinlang.org"><img alt="Kotlin" src="https://img.shields.io/badge/Kotlin-1.4.xxx-blue"/></a>
  <img alt="MVVM" src="https://img.shields.io/badge/MVVM-Architecture-orange"/>
</p>

![](https://user-images.githubusercontent.com/63272288/228627136-7f27f236-3813-402c-b840-3763f2215085.png)

## Overview
Enjoy an exclusive experience by watching the latest movies
- Most Popular Movies.
- Top Rated Movies.
- Discover Movie Details.
- Offline caching.

## Project Architecture:
This project follows the Clean Architecture structure and MVI. It has UseCases that encapsulate a single, specific task that is part of the application's business logic. Repository layer, providing a single source of truth for data. The UI layer uses all the components and classes related to the Android framework to get the data from the ViewModel layer and display it on the UI.


<img src="https://user-images.githubusercontent.com/63272288/224539374-26ea3e6b-ed81-4700-bbbe-640489aeca38.jpg" width="600" />

## App Modules:
* **Remote** - This module handles data interaction with the Network Http requests(Retrofit).
* **Local** - This module handles data interaction with the database(RoomDB).
* **Data** - This Kotlin module implements the repository interface defined in the domain layer, providing a single source of truth for data. It can only access the domain module.
* **Domain** - This Kotlin module contains UseCases that encapsulate a single, specific task that is part of the application's business logic. It cannot access any other module.
* **Presentation** - This Android module uses MVI with ViewModels exposing StateFlow that the UI consumes. The ViewModel does not know anything about its consumers. It can only access the UseCases module and it is handel the UI State. Also it has the UI layer that uses all the components and classes related to the Android framework to display data from the ViewModel layer on the UI.
* **App** - This module handles the DI(Dependency injection).


<img src="https://user-images.githubusercontent.com/63272288/224540081-69478b9d-7b3c-4225-beff-94e9f9ce64bc.jpg" width="600" />

## Data and Dependenciy Flow:
This illustration from the clean architecture book shows the dependencies between the layers in a project and the way data flows between them. (our app use the same thing).


<img src="https://user-images.githubusercontent.com/63272288/224540200-813c1fd2-1416-4f2a-b404-ac9dc93b655f.jpg" width="600" />


## Tech stack - Library:
- [Kotlin](https://kotlinlang.org/) - Kotlin is a modern statically typed programming language used by over 60% of professional Android developers that helps boost productivity, developer satisfaction, and code safety.
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Jetpack Compose is Android's recommended modern toolkit for building native UI. It simplifies and accelerates UI development on Android.
- [Room](https://kotlinlang.org/) - Room is a persistence library that provides an abstraction layer over the SQLite database to allow a more robust database.
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android.
- [OkHttp](https://square.github.io/okhttp/) - OkHttp is an efficient HTTP & HTTP/2 client for Android applications.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) - A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously
- [Dagger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - for dependency injection.
- JetPack
  - [StateFlow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow#:~:text=StateFlow%20is%20a%20state-holder,property%20of%20the%20MutableStateFlow%20class.) - For reactive style programming (from VM to UI). 
  - [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle) - Used get lifecyle event of an activity or fragment and performs some action in response to change
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
- [Material-Components](https://github.com/material-components/material-components-android) - Material design components like ripple animation, cardView.

## How to build on your environment
Add your API key for tmdb in local.properties file.
- apiKey=YOUR_API_KEY

## TODO
- [X] Movie Screen
- [X] Movie Details Screen
- [X] Ktlint or Detekt
- [X] Use Jetpack Compose
- [X] Offline caching

## Find this repository useful?
Support it by joining __[stargazers](https://github.com/MoatazBadawy/Movie_App/stargazers)__ for this repository. <br>

