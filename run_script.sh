#!/bin/bash

# Navigate to the project directory
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
cd "$DIR" || exit

# Path to the JavaFX SDK lib directory
JAVAFX_SDK_PATH="$DIR/lib/javafx-sdk-21.0.1/lib"

# Create a bin directory if it doesn't exist
mkdir -p bin

# Compile the Java files (include JavaFX modules)
javac --module-path "$JAVAFX_SDK_PATH" --add-modules javafx.controls,javafx.fxml -d bin src/App.java src/Shapes/*.java src/Utility/*.java

# Run the main App (include JavaFX modules)
java --module-path "$JAVAFX_SDK_PATH" --add-modules javafx.controls,javafx.fxml -cp bin App
