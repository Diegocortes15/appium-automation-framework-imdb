package screens;

import core.ElementBy;
import core.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;

public class RateMovieScreen extends BaseMobileScreen {
    private static RateMovieScreen instance = null;
    private final MobileElement rateButton = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/rate_title_button", "Rate movie button");
    private final MobileElement removeRatingButton = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/remove_rating", "Remove rating button");
    private MobileElement ratingMovie;

    public RateMovieScreen(AndroidDriver driver) {
        super(driver);
    }

    public static RateMovieScreen getInstance(AndroidDriver driver) {
        if (instance == null) {
            instance = new RateMovieScreen(driver);
        } else {
            instance.updateDriver(driver);
        }
        return instance;
    }

    @Step("🐾 Set movie rating with {0}")
    public void setMovieRating(String rating) {
        try {
            this.ratingMovie = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/star_" + rating, "Rating movie with " + rating, false);
            appiumFactory.click(ratingMovie);
            appiumFactory.click(rateButton);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element not found because of you can NOT rate a movie with \"" + rating + "\" stars", e);
        }
    }

    @Step("🐾 Remove movie rating")
    public void clickRemoveMovieRating() {
        appiumFactory.click(removeRatingButton);
    }
}
