# Nutrition Facts (Tabela Nutricional)

Nutrition Facts is a modern Android application designed to help users track nutritional information for healthy recipes. The app provides a detailed breakdown of macronutrients and micronutrients, helping users make informed dietary choices.

## 🚀 Features

- **Home Screen**: Discover wellness news and a list of healthy recipes.
- **Recipe Details**: In-depth nutritional analysis including calories, proteins, carbohydrates, and fats.
- **Interactive UI**: Smooth animations using Jetpack Compose, including an interactive dish view and nutrient bars.
- **Favorites**: Ability to mark recipes as favorites (local mock implementation).
- **Modern Design**: Built with Material 3 and follow edge-to-edge design principles.

## 🛠️ Architecture & Good Practices

The project follows modern Android development standards and **Clean Architecture** principles:

- **Layered Architecture**:
    - **UI Layer**: Built with **Jetpack Compose** and **MVVM (Model-View-ViewModel)**.
    - **Domain Layer**: Contains business logic using **UseCases** and interfaces for repositories.
    - **Data Layer**: Implements repositories and data sources (currently using a mock local implementation).
- **Dependency Injection**: Powered by **Koin** for a lightweight and idiomatic Kotlin DI.
- **Reactive UI**: State management using `MutableStateFlow` and `collectAsStateWithLifecycle`.
- **Type-Safe Navigation**: Uses the latest **Jetpack Navigation Compose** with Kotlin Serialization for type-safe routing.
- **Coroutines & Flow**: Handles asynchronous operations and data streams efficiently.

## 📚 Libraries Used

- **UI**: [Jetpack Compose](https://developer.android.com/jetpack/compose) (Material 3, Animations)
- **Dependency Injection**: [Koin](https://insert-koin.io/) (Core, Android, Compose)
- **Navigation**: [Jetpack Navigation Compose](https://developer.android.com/jetpack/compose/navigation)
- **Serialization**: [Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization)
- **Lifecycle**: [Android Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) (ViewModel, Lifecycle Compose)
- **Async**: [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)

## 🏗️ Project Structure

```text
com.github.amitcesar.nutritionfacts/
├── core/
│   ├── di/             # Koin Modules
│   └── navigation/     # Navigation Routes and Arguments
├── data/
│   ├── datasource/     # Data Sources (Local/Remote)
│   ├── mock/           # Mock data for development
│   ├── model/          # Data Models (DTOs)
│   └── repository/     # Repository Implementations
├── domain/
│   ├── model/          # Domain Entities
│   ├── repository/     # Repository Interfaces
│   └── usecase/        # Business Logic (UseCases)
└── ui/
    ├── component/      # Reusable UI Components
    ├── screen/         # Feature Screens (Home, Details)
    └── theme/          # Material 3 Design System (Theme, Type, Sizing)
```

## ⚙️ Requirements

- Android Studio Ladybug or newer.
- JDK 11+.
- Min SDK: 26.
- Target SDK: 37.

---
Developed as a study case for Modern Android Development.
