package screens;

import core.ElementBy;
import core.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import screens.components.NavigationComponent;

public class SearchScreen extends BaseMobileScreen {
    private static SearchScreen instance = null;
    public final NavigationComponent navigationComponent;

    private final MobileElement firstMovie = new MobileElement(ElementBy.UIAUTOMATOR, "new UiSelector().className(\"androidx.recyclerview.widget.RecyclerView\").childSelector(new UiSelector().className(\"android.widget.LinearLayout\").childSelector(new UiSelector().className(\"android.widget.ImageView\").fromParent(new UiSelector().className(\"android.widget.LinearLayout\"))))", "List Movies", false);
    private final MobileElement inputSearchBar = new MobileElement(ElementBy.CLASSNAME, "android.widget.EditText", "Input Search Bar");

    private SearchScreen(AndroidDriver driver) {
        super(driver);
        navigationComponent = NavigationComponent.getInstance(driver);
    }

    public static SearchScreen getInstance(AndroidDriver driver) {
        if (instance == null) {
            instance = new SearchScreen(driver);
        } else {
            instance.updateDriver(driver);
        }
        return instance;
    }

    @Step("🐾 Search movie \"{0}\"")
    public void searchMovie(String movie) {
        appiumFactory.sendKeys(inputSearchBar, movie);
        appiumFactory.click(firstMovie);
    }
}
