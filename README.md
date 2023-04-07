# Appium Automation Framework IMDB

## Prerequisites

### Installing Appium and Appium Inspector v2

1. Install Appium: Go to [official Appium website](https://appium.io/) and download and install the latest version for
   your operating system.
2. Next, install Appium Inspector v2 by following the instructions on
   the [Appium inspector repository](https://github.com/appium/appium-inspector/releases). Appium Inspector v2 is a
   desktop application that allows you to inspect the UI of your app and automate actions on it.

### Installing Android Studio

1. Download and install Android Studio from the [official Android Studio website](https://developer.android.com/studio).
2. Open Android Studio and create a new project. This will ensure that all necessary components are installed.
3. Once the project is created, close Android Studio.

### Installing a Virtual Device Manager

1. Open Android Studio and click on the "Configure" button in the welcome screen or in the toolbar, and select "AVD
   Manager".
2. In the AVD Manager, click on the "Create Virtual Device" button.
3. Select a device definition from the list (e.g. Pixel 2), and click on "Next".
4. Choose a system image for the device (e.g. Android 11 - API Level 30), and click on "Finish" to download the image
   if it's not already installed. Follow the on-screen instructions to complete the installation.
5. The virtual device will now appear in the Device Manager. To start the device, click on the `Launch this ADV in the emulator` button in the `Actions` column.

### Setting Environment Variables for Appium

1. Open the System Properties window by right-clicking on "This PC" and selecting "Properties".
2. Click on `Advanced system settings`.
3. Click on the `Environment Variables` button.
4. Under `System variables`, click on `New`.
5. Enter `ANDROID_HOME` as the variable name and the path to your Android SDK directory as the variable value (
   e.g. `C:\Users\YourUserName\AppData\Local\Android\Sdk`).
6. Click on `OK` to save the variable.
7. In the `System variables` section, select the `Path` variable and click on "Edit".
8. Click on `New` and enter `%ANDROID_HOME%\platform-tools`.
9. Click on `New` and enter `%ANDROID_HOME%\cmdline-tools\latest\bin`.
10. Click on "OK" to save the changes.

### Installing Maven

1. Download and install Maven from the [official Maven website](https://maven.apache.org/download.cgi).
2. Extract the downloaded archive to a folder on your computer.
3. Open the System Properties window by right-clicking on "This PC" and selecting "Properties".
4. Click on `Advanced system settings`.
5. Click on the `Environment Variables` button.
6. Under `System variables`, click on `New`.
7. Enter `MAVEN_HOME` as the variable name and the path to the Maven installation directory as the variable value (
   e.g. `C:\apache-maven-3.8.3`).
8. Click on `OK` to save the variable.
9. In the `System variables` section, select the `Path` variable and click on `Edit`.
10. Click on `New` and enter `%MAVEN_HOME%\bin`.
11. Click on `OK` to save the changes.

### Installing Allure

1. Download and install Allure commandline tool from
   the [official Allure website](https://docs.qameta.io/allure/#_installing_a_commandline).
2. Extract the downloaded archive to a folder on your computer.
3. Open the System Properties window by right-clicking on `This PC` and selecting `Properties`.
4. Click on `Advanced system settings`.
5. Click on the `Environment Variables` button.
6. Under `System variables`, click on `New`.
7. Enter `ALLURE_HOME` as the variable name and the path to the Allure installation directory as the variable value (
   e.g. `C:\allure-commandline-2.14.0)`.
8. Click on `OK` to save the variable.
9. In the `System variables` section, select the `Path` variable and click on `Edit`.
10. Click on `New` and enter `%ALLURE_HOME%\bin`.
11. Click on `OK` to save the changes.

## Cloning a Project

Once you have Git installed, follow these steps to clone a project:

1. Open your terminal or command prompt.
2. Navigate to the directory where you want to clone the project.
3. Clone the project using the git clone command followed by the repository URL:

```
git clone https://github.com/Diegocortes15/appium-automation-framework-imdb.git
```

## Running the Project

### Install the IMDb App

1. Open the Google Play Store app on your Android device. 
2. In the search bar, type `iMDB` and press enter.
3. Look for the iMDB app in the search results.
4. Tap on the iMDB app to open its details page.
5. On the iMDB app details page, tap the `Install` button.
6. Review the app permissions and tap `Accept` if you agree.
7. Wait for the app to download and install.

### Start Appium Server

| Host    | Port |
|---------|------|
| 0.0.0.0 | 4723 |

Start Appium server click in `startServer` button.

### Verify Device to Run the Tests

1. Open your terminal or command prompt.
2. Enter the following command to know the list of devices attached:

```
adb devices
```

3. Copy the device identifier and replace `deviceName` in `Capabilities.json`
   file (`src/test/resources/Capabilities.json`).

```
{
  "deviceName": "",
  "appPackage": "com.imdb.mobile",
  "appActivity": "com.imdb.mobile.HomeActivity",
  "platformName": "Android"
}
```

### Running the Project with Maven

2. Open your terminal or command prompt.
3. Navigate to the root directory of the appium-automation-framework-imdb project.
4. Run the clean and verify Maven goals using the following command:

```
mvn clean verify
```

This will compile the code, run the tests, and generate an Allure report.

4. Once the command finishes running, you can view the Allure report by running the following command:

```
allure serve target/allure-results
```

This will start a local web server and open the Allure report in your default browser.
