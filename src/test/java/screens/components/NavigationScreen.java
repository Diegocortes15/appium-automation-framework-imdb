package screens.components;

import core.ElementBy;
import core.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import screens.BaseMobileScreen;

public class NavigationScreen extends BaseMobileScreen {

    protected MobileElement buttonHomeIcon = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/navigation_home", "Button Home Icon", false);
    protected MobileElement buttonSearchIcon = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/navigation_search_browse", "Button Search Icon", false);
    protected MobileElement buttonVideoIcon = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/navigation_video", "Button Video Icon", false);
    protected MobileElement buttonProfileIcon = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/navigation_you", "Button Profile Icon", false);

    public NavigationScreen(AndroidDriver driver) {
        super(driver);
    }

    @Step("Go to home screen")
    public void goToHomeScreen() {
        appiumFactory.click(buttonHomeIcon);
    }

    @Step("Go to search screen")
    public void goToSearchScreen() {
        appiumFactory.click(buttonSearchIcon);
    }

    @Step("Go to video screen")
    public void goToVideoScreen() {
        appiumFactory.click(buttonVideoIcon);
    }

    @Step("Go to profile screen")
    public void goToProfileScreen() {
        appiumFactory.click(buttonProfileIcon);
    }
}
