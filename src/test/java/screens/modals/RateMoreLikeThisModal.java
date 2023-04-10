package screens.modals;

import core.ElementBy;
import core.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import screens.BaseMobileScreen;

public class RateMoreLikeThisModal extends BaseMobileScreen {
    private static RateMoreLikeThisModal instance = null;
    private final MobileElement buttonClose = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/rate_more_like_this_close", "Close Button");

    public RateMoreLikeThisModal(AndroidDriver driver) {
        super(driver);
    }

    public static RateMoreLikeThisModal getInstance(AndroidDriver driver) {
        if (instance == null) {
            instance = new RateMoreLikeThisModal(driver);
        } else {
            instance.updateDriver(driver);
        }
        return instance;
    }

    @Step("🐾 Click on Not Now Button")
    public void clickButtonClose() {
        appiumFactory.click(buttonClose);
    }
}
