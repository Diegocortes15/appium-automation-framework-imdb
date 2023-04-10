package screens;

import core.ElementBy;
import core.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import screens.components.NavigationComponent;

public class HomeScreen extends BaseMobileScreen {
    private static HomeScreen instance = null;
    public final NavigationComponent navigationComponent;
    private final MobileElement videoHeroView = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/video_hero_view", "Video Hero View", false);

    private HomeScreen(AndroidDriver driver) {
        super(driver);
        navigationComponent = NavigationComponent.getInstance(driver);
    }

    public static HomeScreen getInstance(AndroidDriver driver) {
        if (instance == null) {
            instance = new HomeScreen(driver);
        } else {
            instance.updateDriver(driver);
        }
        return instance;
    }

    public void waitVisibleVideoHeroView() {
        appiumFactory.waitUntilVisibleElement(videoHeroView);
    }
}
