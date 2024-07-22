# Java FX Module Selection Tool

## Overview

The Java FX Module Selection Tool is a Java application designed to help students select their final year modules. It provides an interface for creating a student profile, selecting mandatory and optional modules, and reviewing the selected modules.

## Features

- **Student Profile Management**: Create and manage student profiles.
- **Module Selection**: Select mandatory and optional modules for the final year.
- **Overview and Review**: Review selected modules and confirm choices.
- **Persistence**: Save and load student profiles and selected modules.

## Project Structure

The project is divided into several main components:

### `src` Directory

- **controller**: Contains the controller classes responsible for handling user interactions and updating the model.
  - `FinalYearOptionsController.java`: Handles interactions in the final year options view.
  
- **main**: Contains the main application loader.
  - `ApplicationLoader.java`: Entry point of the application.
  
- **model**: Contains the data models used in the application.
  - `Block.java`: Represents a block in the academic year.
  - `Course.java`: Represents a course with associated modules.
  - `Module.java`: Represents an individual module.
  - `Name.java`: Represents a student's name.
  - `StudentProfile.java`: Represents a student's profile.
  
- **view**: Contains the view classes responsible for the graphical user interface.
  - `CreateStudentProfilePane.java`: GUI pane for creating a student profile.
  - `FinalYearOptionsMenuBar.java`: Menu bar for the final year options window.
  - `FinalYearOptionsRootPane.java`: Root pane for the final year options window.
  - `OverviewSelectionPane.java`: Pane for reviewing selected modules.
  - `ReserveModulesPane.java`: Pane for selecting reserve modules.
  - `SelectModulesPane.java`: Pane for selecting primary modules.

### `bin` Directory

Contains the compiled class files corresponding to the source files in the `src` directory.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- JavaFX SDK

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/Java-FX-Module-Selection-Tool.git
    cd Java-FX-Module-Selection-Tool
    ```

2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).

3. Configure the project to use the JavaFX SDK.

4. Build the project to ensure all dependencies are resolved.

### Running the Application

1. Locate the `ApplicationLoader.java` file in the `src/main` directory.

2. Run `ApplicationLoader.java` as a Java application.

This will launch the Java FX Module Selection Tool, allowing you to create a student profile, select modules, and review your selections.

## Usage

### Creating a Student Profile

1. Launch the application.
2. Navigate to the "Create Profile" section.
3. Enter the student's name, ID, and course information.
4. Save the profile.

### Selecting Modules

1. Navigate to the "Select Modules" section.
2. Choose the mandatory and optional modules for the final year.
3. Optionally, select reserve modules in case primary choices are unavailable.

### Reviewing Selections

1. Navigate to the "Overview" section.
2. Review the selected modules and confirm your choices.
3. Save the overview for future reference.

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Make your changes.
4. Submit a pull request.


