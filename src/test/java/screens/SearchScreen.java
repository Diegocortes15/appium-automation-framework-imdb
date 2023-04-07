package screens;

import core.ElementBy;
import core.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import screens.components.NavigationScreen;

public class SearchScreen extends BaseMobileScreen {
    public final NavigationScreen navigationScreen;

    private final MobileElement inputSearchBar = new MobileElement(ElementBy.CLASSNAME, "android.widget.EditText", "Input Search Bar");
    //private final MobileElement firstMovie = new MobileElement(ElementBy.XPATH, "(//*[contains(@class,'androidx.recyclerview.widget.RecyclerView')]/*[contains(@class,'android.widget.LinearLayout')]/*[contains(@class,'android.widget.ImageView')]/following-sibling::*[contains(@class,'android.widget.LinearLayout')])[1]", "List Movies");
    //private final MobileElement firstMovie = new MobileElement(ElementBy.XPATH, "//*[contains(@class,'androidx.recyclerview.widget.RecyclerView')]/*[contains(@class,'android.widget.LinearLayout')]/*[contains(@class,'android.widget.ImageView')]/following-sibling::*[contains(@class,'android.widget.LinearLayout')]", "List Movies");
    //private final MobileElement firstMovie = new MobileElement(ElementBy.XPATH, "(//*[contains(@class, 'androidx.recyclerview.widget.RecyclerView')]/*[contains(@class, 'android.widget.LinearLayout')]/*[contains(@class, 'android.widget.ImageView')]/following-sibling::*[contains(@class, 'android.widget.LinearLayout')])[1]", "List Movies");
    private final MobileElement firstMovie = new MobileElement(ElementBy.UIAUTOMATOR, "new UiSelector().className(\"androidx.recyclerview.widget.RecyclerView\").childSelector(new UiSelector().className(\"android.widget.LinearLayout\").childSelector(new UiSelector().className(\"android.widget.ImageView\").fromParent(new UiSelector().className(\"android.widget.LinearLayout\"))))", "List Movies");

    public SearchScreen(AndroidDriver driver) {
        super(driver);
        navigationScreen = new NavigationScreen(driver);
    }

    @Step("Search movie")
    public void searchMovie(String movie) {
        appiumFactory.sendKeys(inputSearchBar, movie);
        appiumFactory.click(firstMovie);
    }
}
