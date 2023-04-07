package core;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ConfigCapabilities {
    private static final String DEVICE_NAME = "deviceName";
    private static final String PLATFORM_NAME = "platformName";
    private static final String APP_PACKAGE = "appPackage";
    private static final String APP_ACTIVITY = "appActivity";
    private static final String JSON_FILE_PATH = "src/test/resources/Capabilities.json";
    private static final DesiredCapabilities capabilities = new DesiredCapabilities();

    private static void ApplicationSetUp(DesiredCapabilities capabilities) {
        capabilities.setCapability("appPackage", getJsonDataProperty(APP_PACKAGE));
        capabilities.setCapability("appActivity", getJsonDataProperty(APP_ACTIVITY));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getJsonDataProperty(DEVICE_NAME));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getJsonDataProperty(PLATFORM_NAME));
        capabilities.setCapability("automationName", "UiAutomator2");
    }

    private static String getJsonDataProperty(String property) {
        try {
            JsonObject jsonObject = (JsonObject) JsonParser.parseReader(new FileReader(JSON_FILE_PATH, StandardCharsets.UTF_8));
            return jsonObject.get(property).getAsString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static DesiredCapabilities getCapabilities() {
        ConfigCapabilities.ApplicationSetUp(capabilities);
        return capabilities;
    }
}
