package core;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ConfigCapabilities {
    private static final String JSON_FILE_PATH = "src/test/resources/Capabilities.json";
    private static final DesiredCapabilities capabilities = new DesiredCapabilities();
    private static final ReadJsonData readConfigCapabilities = new ReadJsonData(JSON_FILE_PATH);

    private static void ApplicationSetUp() {
        ConfigCapabilities.capabilities.setCapability("appPackage", readConfigCapabilities.getJsonDataProperty("appPackage"));
        ConfigCapabilities.capabilities.setCapability("appActivity", readConfigCapabilities.getJsonDataProperty("appActivity"));
        ConfigCapabilities.capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, readConfigCapabilities.getJsonDataProperty("deviceName"));
        ConfigCapabilities.capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, readConfigCapabilities.getJsonDataProperty("platformName"));
        ConfigCapabilities.capabilities.setCapability("automationName", "UiAutomator2");
    }

    public static DesiredCapabilities getCapabilities() {
        ApplicationSetUp();
        return capabilities;
    }
}
