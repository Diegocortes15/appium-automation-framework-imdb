package screens;

import core.ElementBy;
import core.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import screens.components.NavigationScreen;

public class ProfileScreen extends BaseMobileScreen {

    public final NavigationScreen navigationScreen;
    //private final MobileElement movieTitleInWishList = new MobileElement(By.UIAUTOMATOR, "new UiSelector().resourceId(\"com.imdb.mobile:id/your_watchlist_widget\").childSelector(new UiSelector().resourceId(\"com.imdb.mobile:id/recycler_view\")).childSelector(new UiSelector().className(\"android.widget.FrameLayout\").instance(0)).childSelector(new UiSelector().resourceId(\"com.imdb.mobile:id/main_line\"))", "Movie Title In Wish List");
    private final MobileElement movieTitleInWishList = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/main_line", "Movie Title In Wish List");
    private final MobileElement movieRibbonInWishList = new MobileElement(ElementBy.UIAUTOMATOR, "new UiSelector().resourceId(\"com.imdb.mobile:id/your_watchlist_widget\").childSelector(new UiSelector().resourceId(\"com.imdb.mobile:id/recycler_view\")).childSelector(new UiSelector().className(\"android.widget.FrameLayout\").instance(0)).childSelector(new UiSelector().resourceId(\"com.imdb.mobile:id/watchlist_ribbon\"))", "Movie Ribbon In Wish List");
    //@AndroidFindBy(id = "com.imdb.mobile:id/main_line")
    //private MobileElement movieTitleInWishList;

    public ProfileScreen(AndroidDriver driver) {
        super(driver);
        navigationScreen = new NavigationScreen(driver);
    }

    @Step("Verify movie title in watchlist")
    public void verifyMovieTitleInWatchlist(String movieTitle) {
        //appiumFactory.scrollTo(movieTitleInWishList, movieTitleInWishList.elementBy);
        appiumFactory.verifyText(movieTitleInWishList, movieTitle);
    }

    @Step("Remove movie from watchlist")
    public void removeMovieFromWatchlist() {
        appiumFactory.click(movieRibbonInWishList);
    }
}
