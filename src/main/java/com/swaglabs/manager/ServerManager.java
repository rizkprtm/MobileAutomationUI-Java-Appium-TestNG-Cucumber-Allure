package com.swaglabs.manager;

import com.swaglabs.utils.TestUtils;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

public class ServerManager {

    private static AppiumDriverLocalService server = null;
    private static final TestUtils utils = new TestUtils();

//    public static AppiumDriverLocalService getAppiumService() {
//        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//                .usingDriverExecutable(new File("C:\\Users\\Asus\\AppData\\Roaming\\nvm\\v22.0.0\\node.exe"))
//                .withAppiumJS(new File("C:\\Users\\Asus\\AppData\\Roaming\\nvm\\v22.0.0\\bin\\node_modules\\appium\\build\\lib\\main.js"))
//                .usingAnyFreePort()
//                .withArgument(GeneralServerFlag.SESSION_OVERRIDE));
//    }
    public static void startServer() {
        utils.log().info("Starting Appium Server");
//        AppiumDriverLocalService server = getAppiumService();
        server = AppiumDriverLocalService.buildDefaultService();
        server.start();
        if (!server.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server couldn't be started");
        }
        server.clearOutPutStreams();
        utils.log().info("Appium Server Started");
    }
    public static AppiumDriverLocalService getServer() {
        return server;
    }
}
