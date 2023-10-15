package screens;

import core.ElementBy;
import core.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import screens.components.NavigationComponent;

public class WelcomeScreen extends BaseMobileScreen {
    private static WelcomeScreen instance = null;
    private final MobileElement buttonContinue = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/welcome_dialog_continue", "Continue Button");

    private WelcomeScreen(AndroidDriver driver) {
        super(driver);
    }

    public static WelcomeScreen getInstance(AndroidDriver driver) {
        if (instance == null) {
            instance = new WelcomeScreen(driver);
        } else {
            instance.updateDriver(driver);
        }
        return instance;
    }

    @Step("🐾 Click continue button")
    public void clickContinueButton() {
        if(appiumFactory.isElementPresent(buttonContinue)){
            appiumFactory.click(buttonContinue);
        }
    }
}
