package core;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileAppDriver {
    private static AndroidDriver driver;

    public static AndroidDriver getMoviesAppDriver(DesiredCapabilities capabilities) {
        if (driver == null || driver.getSessionId() == null) {
            try {
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }
}
