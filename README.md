# JapCrd

**JapCrd** is a clean, focused Android flashcard application designed for mastering Japanese Hiragana. Built with modern
Android practices, it provides an intuitive interface for deck-based practice, featuring flipping mechanics, navigation,
and randomized study sessions.

## 🌟 Features

* **Practice Hiragana**: Focused flashcard drills for Japanese characters.
* **Flip Mechanics**: Tap cards to reveal romanization and pronunciation hints.
* **Navigation**: Seamlessly move through cards with **Prev** and **Next**.
* **Shuffle**: Randomize the current deck to break "muscle memory" during study.
* **Deck Selection**: Switch between different Hiragana categories via a drawer menu.
* **Material 3 UI**: A modern, responsive design featuring custom typography (Alegreya and Almarai).

## 🎴 Decks Included

* Basic Hiragana
* Voiced Hiragana (Dakuten)
* Contracted Hiragana (Yōon)
* All Hiragana (Comprehensive)

## 🛠️ Tech Stack

* **Language**: Kotlin
* **UI Framework**: Jetpack Compose
* **Design System**: Material 3
* **Architecture**: MVVM (Model-View-ViewModel)
* **Layout**: ConstraintLayout Compose
* **External Assets**: Google Fonts API (Downloadable Fonts)

## 📋 Requirements

* **Android Studio**: Ladybug or newer (using IntelliJ IDEA)
* **Android SDK**: 36 (Target)
* **Minimum SDK**: 30
* **JDK**: 17+

## 🚀 Getting Started

### Clone the repository

```bash
git clone [https://github.com/tabbycat444/JapCrd.git](https://github.com/tabbycat444/JapCrd.git)
cd JapCrd
```

### Open the project

Open the project in IntelliJ IDEA (preferred) or Android Studio and allow Gradle to sync dependencies.

### Build & Run

### On Linux/macOS

```bash
./gradlew build
```

### On Windows

```bash
.\gradlew.bat build
```

Start an emulator or connect a device, then click **Run** from your IDE.

## 📖 Usage

1. **Open the app** to the default Hiragana deck.
2. **Tap a flashcard** to flip between the character and its pronunciation.
3. **Navigate** using the bottom control bar.
4. **Shuffle** to randomize the deck order.
5. **Drawer Menu**: Use the menu to switch between different decks.

## 📂 Project Structure

```JapCrd/
├── app/
│ └── src/main/
│ ├── java/io/github/tabbycat444/japcrd/
│ │ ├── data/ # Data Models & Repository
│ │ ├── ui/ # UI Layer
│ │ │ ├── components/ # Reusable UI widgets (CardItem, TitleText)
│ │ │ ├── screens/ # Full-screen Composables (FlashcardScreen)
│ │ │ └── theme/ # Color, Type, and Theme definitions
│ │ └── viewmodel/ # JapCrdViewModel logic
│ └── res/ # XML Resources (font_certs, strings, colors)
├── build.gradle.kts
└── README.md
```

## 🗺️ Roadmap

*   [ ] Break down FlashcardScreen into smaller function files for modularity
*   [ ] Implement Favorites
*   [ ] Better launcher icon
*   [ ] User-created custom decks (from existing cards)
*   [ ] Study progress tracking & statistics
*   [ ] Quiz Mode with scoring
*   [ ] Audio pronunciation playback
*   [ ] Writing practice

## 🤝 Contributing

Contributions are welcome!

1. Fork the repository.
2. Create a feature branch: ```bash git checkout -b feature/my-feature```
3. Commit your changes.
4. Open a pull request.

## 📄 License

This project does not yet have a specified license.

## ✍️ Author

Created by [tabbycat444](https://github.com/tabbycat444).