package com.swaglabs.manager;

import com.swaglabs.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.Getter;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class DriverManager {
    @Getter
    static AppiumDriver driver;
    static Properties props = new Properties();
    static TestUtils utils = new TestUtils();

    public static void initializeAndroidDriver() throws MalformedURLException {
                utils.log().info("Initializing Android Driver");
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName(props.getProperty("androidPlatformName", "Android"))
                        .setPlatformVersion(props.getProperty("androidPlatformVersion", "11.0"))
                        .setAutomationName(props.getProperty("androidAutomationName","UiAutomator2"))
                        .setDeviceName(props.getProperty("androidDeviceName","nightwatch-android-11"))
                        .setUdid(props.getProperty("androidUDID","emulator-5554"))
                        .setAppPackage(props.getProperty("androidAppPackage","com.swaglabsmobileapp"))
                        .setAppActivity(props.getProperty("androidAppActivity","com.swaglabsmobileapp.MainActivity"))
                        .setAutoGrantPermissions(true);
                driver = new AppiumDriver(new URL("http://127.0.0.1:4723/"), options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
                utils.log().info("Driver is initialized");
    }
}