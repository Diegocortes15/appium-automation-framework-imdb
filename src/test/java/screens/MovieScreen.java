package screens;

import core.ElementBy;
import core.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import screens.components.NavigationScreen;

public class MovieScreen extends BaseMobileScreen {

    public final NavigationScreen navigationScreen;
    private final MobileElement movieDescription = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/plot_overview", "Movie Description");
    private final MobileElement movieTitle = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/title", "Movie Title");
    private final MobileElement addToWatchListButton = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/state_off", "Add to Watch List Button");
    private final MobileElement personalUserRating = new MobileElement(ElementBy.UIAUTOMATOR, "new UiSelector().resourceId(\"com.imdb.mobile:id/user_rating\").childSelector(new UiSelector().resourceId(\"com.imdb.mobile:id/rating_text\"))", "Personal user rating");
    private final MobileElement reviewsSectionEmptyRateButton = new MobileElement(ElementBy.UIAUTOMATOR, "new UiSelector().resourceId(\"com.imdb.mobile:id/title_user_reviews\").childSelector(new UiSelector().resourceId(\"com.imdb.mobile:id/empty_user_rating\"))", "User reviews button");
    private final MobileElement reviewsSectionRateButton = new MobileElement(ElementBy.UIAUTOMATOR, "new UiSelector().resourceId(\"com.imdb.mobile:id/title_user_reviews\").childSelector(new UiSelector().resourceId(\"com.imdb.mobile:id/user_rating\"))", "User reviews button");

    public MovieScreen(AndroidDriver driver) {
        super(driver);
        navigationScreen = new NavigationScreen(driver);
    }

    @Step("🧪 Verify movie description: \"{0}\"")
    public void verifyMovieDescription(String strExpectedMovieDescription) {
        appiumFactory.verifyText(movieDescription, strExpectedMovieDescription);
    }

    @Step("Get movie title")
    public String getMovieTitle() {
        return appiumFactory.getText(movieTitle);
    }

    @Step("Add movie to watchlist")
    public void addToWatchList() {
        appiumFactory.click(addToWatchListButton);
    }

    @Step("Click on empty rate button")
    public void clickReviewsSectionEmptyRateButton() {
        appiumFactory.click(reviewsSectionEmptyRateButton);
    }

    @Step("Click on rate button")
    public void clickReviewsSectionRateButton() {
        appiumFactory.click(reviewsSectionRateButton);
    }

    @Step("🧪 Verify User Rating")
    public void verifyUserRating(String strExpected) {
        appiumFactory.verifyText(personalUserRating, strExpected);
    }
}
