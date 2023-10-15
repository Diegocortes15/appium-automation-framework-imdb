# Appium Automation Framework IMDB

## Prerequisites

### Installing Appium and Appium Inspector v2

1. Install Appium: Go to [official Appium website](https://appium.io/) and download and install the latest version for
   your operating system.

   ```
   npm i --location=global appium
   ```   
   
   you must install `UiAutomator2 Driver` which is a test automation framework for Android devices.

   ```
   appium driver install uiautomator2
   ```

2. Next, install Appium Inspector v2 by following the instructions on
   the [Appium inspector repository](https://github.com/appium/appium-inspector/releases). Appium Inspector v2 is a
   desktop application that allows you to inspect the UI of your app and automate actions on it.

#### Appium Inspector Example

![image](https://user-images.githubusercontent.com/60171460/231738338-1b114eb0-bbd2-41aa-ba91-65ffbb52b63e.png)

### Installing Android Studio

1. Download and install Android Studio from the [official Android Studio website](https://developer.android.com/studio).
2. Open Android Studio and create a new project. This will ensure that all necessary components are installed.
3. Once the project is created, close Android Studio.

### Installing a Virtual Device Manager

1. Open Android Studio and click on the `More Actions` dropdown in the welcome screen or in the toolbar, and select `Virtual Device Manager`.
2. In the AVD Manager, click on the `Create Device` button.
3. Select a device definition from the list (e.g. Pixel 2), and click on `Next`.
4. Choose a system image for the device (e.g. Android 11 - API Level 30), and click on `Finish` to download the image if
   it's not already installed. Follow the on-screen instructions to complete the installation.
5. The virtual device will now appear in the Device Manager. To start the device, click on
   the `Launch this ADV in the emulator` button in the `Actions` column.

![image](https://user-images.githubusercontent.com/60171460/231739201-69ed6aab-262e-4199-b31b-65d5553d07bb.png)

### Installing Java 11 - Setting Environment Variables

1. Download tha Java 11 from the [official Oracle website](https://www.oracle.com/java/technologies/downloads/#java11).
2. Install the downloaded JDK by following the installation wizard.
3. Open the `System Properties`.
4. Click on `Advanced` system settings.
5. Click on the `Environment Variables` button.
6. Under `System variables`, click on `New`.
7. Enter `JAVA_HOME` as the variable name and the path to the Maven installation directory as the variable value (e.g. `C:\Program Files\Java\jdk-11.0.11`).
8. Click on `OK` to save the variable.
9. In the `System variables` section, select the `Path` variable and click on `Edit`.
10. Click on `New` and enter `%JAVA_HOME%\bin`.
11. Click on `OK` to save the changes.

### Setting Environment Variables for Appium

1. Open the `System Properties`.
2. Click on `Advanced` system settings.
3. Click on the `Environment Variables` button.
4. Under `System variables`, click on `New`.
5. Enter `ANDROID_HOME` as the variable name and the path to your Android SDK directory as the variable value (e.g. `C:\Users\YourUserName\AppData\Local\Android\Sdk`).
6. Click on `OK` to save the variable.
7. In the `System variables` section, select the `Path` variable and click on `Edit`.
8. Click on `New` and enter `%ANDROID_HOME%\platform-tools`.
9. Click on `New` and enter `%ANDROID_HOME%\cmdline-tools\latest\bin`.
10. Click on "OK" to save the changes.

### Installing Maven - Setting Environment Variables

1. Download and install Maven from the [official Maven website](https://maven.apache.org/download.cgi).
2. Extract the downloaded archive to a folder on your computer.
3. Open the `System Properties`.
4. Click on `Advanced` system settings.
5. Click on the `Environment Variables` button.
6. Under `System variables`, click on `New`.
7. Enter `MAVEN_HOME` as the variable name and the path to the Maven installation directory as the variable value (e.g. `C:\apache-maven-3.8.3`).
8. Click on `OK` to save the variable.
9. In the `System variables` section, select the `Path` variable and click on `Edit`.
10. Click on `New` and enter `%MAVEN_HOME%\bin`.
11. Click on `OK` to save the changes.

### Installing Allure - Setting Environment Variables

1. Download and install Allure commandline tool from
   the [official Allure website](https://docs.qameta.io/allure/#_installing_a_commandline).
2. Extract the downloaded archive to a folder on your computer.
3. Open the `System Properties`.
4. Click on `Advanced` system settings.
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

![image](https://user-images.githubusercontent.com/60171460/231740680-aca3694d-6e5c-43f5-acde-184310f1273b.png)

## Running the Project

### Install the IMDb App

1. Open the Google Play Store app on your Android device.
2. In the search bar, type `IMDb` and press enter.
3. Look for the iMDB app in the search results.
4. Tap on the iMDB app to open its details page.
5. On the iMDB app details page, tap the `Install` button.
6. Review the app permissions and tap `Accept` if you agree.
7. Wait for the app to download and install.

### Start Appium Server

To start Appium server you should run the following command in your terminal

```
appium
```

### Verify Device to Run the Tests

1. Open your terminal or command prompt.
2. Enter the following command to know the list of devices attached:

```
adb devices
```

![image](https://user-images.githubusercontent.com/60171460/231738658-e36bcda4-4865-4dc6-80ad-89efc909649e.png)

3. Copy the device identifier and replace `deviceName` in `Capabilities.json`
   file (`src/test/resources/Capabilities.json`).

```
{
  "deviceName": "emulator-5554",
  "appPackage": "com.imdb.mobile",
  "appActivity": "com.imdb.mobile.HomeActivity",
  "platformName": "Android",
  "automationName": "UiAutomator2"
}
```

### Running the Project with Maven

1. Open your terminal or command prompt.
2. .Navigate to the root directory of the appium-automation-framework-imdb project.
3. Run the clean and verify Maven goals using the following command:

```
mvn clean verify
```

This will compile the code, run the tests, and generate an Allure report.

![iMDBApp](https://user-images.githubusercontent.com/60171460/231734583-699c3045-cfcc-451f-9d86-452462ee3977.gif)

4. Once the command finishes running, you can view the Allure report by running the following command:

```
allure serve target/allure-results
```

![iMDAllure](https://user-images.githubusercontent.com/60171460/231737321-43711466-cfd8-405b-8fae-dc54d1efcb1a.gif)

This will start a local web server and open the Allure report in your default browser.

### Running the Project by Test Cases

#### 📘 AM-0002 | Verify movie description

**Feature:** Verify movie description</br>
As a user I want to verify the description of a movie So that I can know more about it

**Scenario:** Verify movie description</br>
**Given** I am on the login screen</br>
**When** I skip the sign-in process</br>
**And** I navigate to the search screen</br>
**And** I search for "Interstellar"</br>
**Then** I should see the movie description "A team of explorers travel through a wormhole in space in an attempt to
ensure humanity's survival."

```
mvn test -Dtest=AM_0001#am_0002
```

#### 📘 AM-0004 | Verify movie description

**Feature**: Verify adding a movie to watchlist

**Scenario**: Add a movie to watchlist and verify</br>
**Given** the user is logged in</br>
**And** the user is on the search screen</br>
**When** the user searches for "Passengers"</br>
**And** the user adds the movie to the watchlist</br>
**And** the user navigates to the profile screen</br>
**Then** the movie title should be displayed in the watchlist

```
mvn test -Dtest=AM_0003#am_0004
```

#### 📘 AM-0006 | Verify Movie Rating

**Feature**: Verify Movie Rating</br>
As a user I want to be able to rate a movie So that I can share my opinion with other users

**Scenario:** Verify movie rating</br>
**Given** I am logged in with Google</br>
**When** I navigate to the Search screen</br>
**And** I search for "Puss in Boots: The Last Wish"</br>
**And** I click the empty rate button in the Reviews section</br>
**And** I set the movie rating to "8"</br>
**Then** I should see my user rating as "8"</br>
**When** I click the rate button in the Reviews section</br>
**And** I click the remove rating button</br>
**Then** the movie rating should be removed</br>

```
mvn test -Dtest=AM_0005#am_0006
```
