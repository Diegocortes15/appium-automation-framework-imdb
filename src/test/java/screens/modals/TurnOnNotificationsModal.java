package screens.modals;

import core.ElementBy;
import core.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import screens.BaseMobileScreen;

public class TurnOnNotificationsModal extends BaseMobileScreen {
    private static TurnOnNotificationsModal instance = null;
    private final MobileElement buttonNotNow = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/notification_not_now", "Not Now Button");

    public TurnOnNotificationsModal(AndroidDriver driver) {
        super(driver);
    }

    public static TurnOnNotificationsModal getInstance(AndroidDriver driver) {
        if (instance == null) {
            instance = new TurnOnNotificationsModal(driver);
        } else {
            instance.updateDriver(driver);
        }
        return instance;
    }

    @Step("🐾 Click on Not Now Button")
    public void clickButtonNotNow() {
        appiumFactory.click(buttonNotNow);
    }
}
