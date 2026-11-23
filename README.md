# Fitness App 🏋️‍♂️🔥

Aplicación Android profesional desarrollada en **Kotlin** utilizando **Jetpack Compose** y **Material 3**, orientada al fitness, control de entrenamientos, seguimiento de peso corporal y gestión integral del perfil de usuario con una interfaz moderna de estilo gimnasio y deportes.

## 🚀 Características Principales

1. **Entrenamiento (Training)**
   - Catálogo de ejercicios dinámico obtenido desde una API remota mediante **Retrofit 3**.
   - Carga avanzada de imágenes y GIFs animados utilizando **Coil 3**.
   - Paginación infinita (`loadMore`), manejo de estados de carga y reconexión ante errores.

2. **Seguimiento (Weight Tracking & IMC)**
   - Registro de peso corporal con fecha y hora.
   - Cálculo automático del **Índex de Massa Corporal (IMC)** en tiempo real mediante la utilidad `CalculadoraIMC`.
   - Historial detallado de registros recientes mediante listas eficientes (`LazyColumn`).

3. **Perfil de Usuario (Profile & Settings)**
   - Visualización y edición de datos personales (nombre, correo electrónico, fecha de nacimiento, género, altura, peso y objetivos de fitness).
   - Componentes interactivos personalizados como selector de fecha modal (`CalendariPicker`) y menús desplegables (`MenuDesplegable`).
   - Almacenamiento persistente mediante `SharedPreferencesManager`.

## 🎨 Diseño y Estética (Gym & Sports Theme)
- Paleta de colores personalizada de alta energía atlética (naranja primario, acentos modernos y temas oscuros y claros optimizados para deportistas).
- Tarjetas con bordes redondeados, tipografía clara y componentes optimizados para navegación fluida mediante `BottomNavigation`.

## 🛠️ Tecnologías y Arquitectura

- **UI & Diseño:** Jetpack Compose, Material 3, Material Icons Extended, tema deportivo personalizado.
- **Navegación:** Jetpack Navigation Compose con múltiples backstacks.
- **Red:** Retrofit 3 & Gson (consumo de API de ejercicios).
- **Carga de Imágenes:** Coil 3 (`coil-compose` y `coil-network-okhttp`).
- **Gestión de Estado & ViewModel:** Arquitectura MVVM con `TrainingViewModel` (`ui.vm`).
- **Pruebas (Testing):** JUnit (pruebas unitarias para `CalculadoraIMCUnitTest`).
- **Permisos de Red:** Configuración en `AndroidManifest.xml` (`INTERNET` y `ACCESS_NETWORK_STATE`).

## 🧪 Pruebas Unitarias

El proyecto incluye un conjunto completo de pruebas unitarias para validar con precisión el cálculo del IMC bajo diferentes escenarios (valores estándar, alturas extremas, datos nulos o negativos):
- `CalculadoraIMCUnitTest`

## 📦 Estructura del Proyecto

```text
org.insbaixcamp.fitnessapp/
├── data/           # Modelos de datos (Exercise, Profile, WeightTracking), API client y SharedPreferences
├── ui/
│   ├── component/  # Componentes reutilizables (CalendariPicker, MenuDesplegable, ExerciseItem, WeightTrackingItem)
│   ├── screen/     # Pantallas principales (ProfileScreen, EditProfileScreen, WeightTrackingScreen, TrainingScreen)
│   ├── theme/      # Colores atléticos, tipografía y tema Material 3
│   └── vm/         # ViewModels (TrainingViewModel)
└── utils/          # Utilidades lógicas (CalculadoraIMC)
```
