package screens.components;

import core.ElementBy;
import core.FrameworkConfig;
import core.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import screens.BaseMobileScreen;

import java.time.Duration;

public class NavigationComponent extends BaseMobileScreen {
    private static NavigationComponent instance = null;

    protected MobileElement buttonHomeIcon = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/navigation_home", "Button Home Icon", false);
    protected MobileElement buttonSearchIcon = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/navigation_search_browse", "Button Search Icon", false);
    protected MobileElement buttonVideoIcon = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/navigation_video", "Button Video Icon", false);
    protected MobileElement buttonProfileIcon = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/navigation_you", "Button Profile Icon", false);

    private NavigationComponent(AndroidDriver driver) {
        super(driver);
    }

    public static NavigationComponent getInstance(AndroidDriver driver) {
        if (instance == null) {
            instance = new NavigationComponent(driver);
        }
        return instance;
    }

    @Step("🐾 Go to home screen")
    public void goToHomeScreen() {
        appiumFactory.click(buttonHomeIcon);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(FrameworkConfig.ELEMENT_TIMEOUT));
    }

    @Step("🐾 Go to search screen")
    public void goToSearchScreen() {
        appiumFactory.click(buttonSearchIcon);
    }

    @Step("🐾 Go to video screen")
    public void goToVideoScreen() {
        appiumFactory.click(buttonVideoIcon);
    }

    @Step("🐾 Go to profile screen")
    public void goToProfileScreen() {
        appiumFactory.click(buttonProfileIcon);
    }
}
