package screens;

import core.ElementBy;
import core.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

public class PreferredServicesScreen extends BaseMobileScreen {
    private static PreferredServicesScreen instance = null;
    private final MobileElement buttonSkip = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/user_streaming_skip_save_button", "Skip Button");

    private PreferredServicesScreen(AndroidDriver driver) {
        super(driver);
    }

    public static PreferredServicesScreen getInstance(AndroidDriver driver) {
        if (instance == null) {
            instance = new PreferredServicesScreen(driver);
        } else {
            instance.updateDriver(driver);
        }
        return instance;
    }

    @Step("🐾 Click continue button")
    public void clickSkipButton() {
        if(appiumFactory.isElementPresent(buttonSkip)){
            appiumFactory.click(buttonSkip);
        }
    }
}
