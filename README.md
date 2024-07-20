**SWAGLABS MOBILE AUTOMATION UI**

**TOOLS :**
1. Java - Development Language
2. IntellIJ IDE - Development IDE
3. Android Studio - Emulator Provider
4. Maven - Package Management
5. Appium 2.0
6. Selenium
7. Cucumber BDD
8. Cucumber7JVM
8. TestNG
9. JUnit
10. Log4j2
11. AspectJ
12. Allure Report

**PREREQUISITE TO RUN THE PROJECT**
- JDK 8 Installed
- Maven Installed
- Appium & UiAutomator2 Driver Installed --> [Appium & UiAutomator2 Installation Guide](https://appium.io/docs/en/2.0/quickstart/install/)
- Android Studio Installed --> [Android Studio Installation](https://developer.android.com/studio?hl=en)
- NodeJS Installed --> [NodeJS Installation](https://www.digitalocean.com/community/tutorials/node-js-environment-setup-node-js-installation)
- Allure Installed --> [Allure Installation](https://allurereport.org/docs/install-for-windows/)
- Android SwagLabs APK --> [SwagLabs APK](https://github.com/saucelabs/sample-app-mobile/releases)
  
  Install Android APK To Emulator Using ADB INSTALL in your commandline
  ```
  adb install .\Downloads\Android.SauceLabs.Mobile.app.2.7.1.apk
  ```

>[!NOTE]
>SetUp Path Environment Variables for every Prerequisites that already installed

**Run Test**
```
mvn clean test
```

**Generate Allure Report**
```
allure serve target/allure-results
```

**Code Repository: [HERE](https://github.com/rizkprtm/SwagLabsMobileAutomationUI/)** 

