# Android HR Preferences App

This Android application serves as a tool for the HR department to manage employee preferences efficiently. The app allows employees to input and store their personal information such as name, age, gender, date of birth, and department.

## Key Features

- **User-Friendly Interface:** The app presents an intuitive user interface with fields for employee details and a Spinner for selecting the department.
  
- **Data Persistence:** Utilizes SharedPreferences to ensure that employee preferences persist even after the app is closed and reopened.
  
- **Error Handling & Validation:** Robust error handling mechanisms validate user inputs, ensuring accurate and complete data entry.

## Functionality Overview

1. **User Input & Validation:** Employees can input their personal information in respective fields such as name, age, gender, and date of birth. The fields have validation to ensure correct and complete entries.

2. **Department Selection:** The department field is managed via a Spinner, enabling employees to select their respective department.

3. **Preferences Saving:** Upon clicking the "Save Preferences" button, the entered details, including the department selection, are saved using SharedPreferences.

4. **Persistent Data:** The app loads the saved preferences when opened, enabling users to view their previously entered information without re-entering it.

## Usage

1. Install the app on an Android device or emulator.
2. Fill in the employee preferences and ensure accurate details.
3. Click the "Save Preferences" button to store the entered information.
4. Reopen the app, and the saved preferences will be loaded automatically.

## Code Structure

The code structure follows a standard Android project setup with key files and directories:
