# Fitness App 🏋️‍♂️

Aplicación Android desarrollada en **Kotlin** utilizando **Jetpack Compose** y **Material 3**, orientada al seguimiento de entrenamientos, control de peso corporal y gestión de perfil de usuario.

## 🚀 Características Principales

1. **Entrenamiento (Training)**
   - Catálogo de ejercicios obtenido desde una API remota mediante **Retrofit**.
   - Carga de imágenes y GIFs animados con **Coil**.
   - Paginación y manejo de estados de carga/error.

2. **Seguimiento (Weight Tracking)**
   - Registro de peso corporal con fecha y hora.
   - Cálculo automático del **Índex de Massa Corporal (IMC)** en tiempo real mediante la utilidad `CalculadoraIMC`.
   - Historial de registros recientes con visualización en listas eficientes (`LazyColumn`).

3. **Perfil de Usuario (Profile & Settings)**
   - Visualización de datos personales (nombre, correo electrónico, fecha de nacimiento, género, altura, peso y objetivos).
   - Pantalla de edición de perfil con selectores de fecha (`CalendariPicker`) y menús desplegables (`MenuDesplegable`).
   - Almacenamiento persistente mediante `SharedPreferencesManager`.

## 🛠️ Tecnologías y Arquitectura

- **UI:** Jetpack Compose, Material 3, Material Icons Extended.
- **Navegación:** Jetpack Navigation Compose.
- **Red:** Retrofit & Gson (para consumo de API de ejercicios).
- **Carga de Imágenes:** Coil (soporte para imágenes estáticas y GIFs).
- **Pruebas (Testing):** JUnit (pruebas unitarias para `CalculadoraIMC`).
- **Lenguaje:** Kotlin 100%.

## 🧪 Pruebas Unitarias

El proyecto incluye pruebas unitarias exhaustivas para verificar el cálculo del IMC bajo diferentes escenarios (valores estándar, alturas extremas, pesos nulos o negativos, etc.):
- `CalculadoraIMCUnitTest`

## 📦 Estructura del Proyecto

```text
org.insbaixcamp.fitnessapp/
├── data/           # Modelos de datos, API clients y gestores de preferencias
├── ui/
│   ├── components/ # Componentes reutilizables (Calendario, Desplegables, Items)
│   ├── screen/     # Pantallas principales (Perfil, Edición, Seguimiento)
│   ├── theme/      # Colores, tipografía y tema Material 3
│   └── training/   # Pantalla y ViewModel de entrenamientos y ejercicios
└── utils/          # Utilidades (Calculadora IMC)
```
