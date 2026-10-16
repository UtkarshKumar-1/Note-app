📝 Note App
A clean and minimal note-taking Android application built with Kotlin and Jetpack Compose. The app provides a simple interface for creating and managing notes, with colorful note cards and sorting options.

![image alt](https://github.com/UtkarshKumar-1/Note-app/blob/ec7189749b1bac5e7059883b22d5fa26f1de9e6e/app-ui.png)

		


✨ Features
- Create notes with a title and description
- Choose a color for each note
- View notes in a colorful card layout
- Sort notes by title, date, or color
- Sort in ascending or descending order
- Delete notes from the list
- Minimal, dark-themed interface built with Jetpack Compose
  
🛠️ Tech Stack
- Language: Kotlin
- UI: Jetpack Compose
- Architecture: MVVM
- Local database: Room
- Dependency injection: Koin

🏗️ Architecture
The project is organized around the MVVM pattern:
- UI layer: Compose screens and reusable UI components
- ViewModel: Manages screen state and coordinates UI actions
- Data layer: Handles note data and local persistence
- Dependency injection: Koin provides required dependencies
