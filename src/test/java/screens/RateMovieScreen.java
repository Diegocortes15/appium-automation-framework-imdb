package screens;

import core.ElementBy;
import core.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;

public class RateMovieScreen extends BaseMobileScreen {
    private final MobileElement rateButton = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/rate_title_button", "Rate movie button");
    private final MobileElement removeRatingButton = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/remove_rating", "Remove rating button");
    private MobileElement ratingMovie;
    //com.imdb.mobile:id/star_8
    //com.imdb.mobile:id/user_rating

    public RateMovieScreen(AndroidDriver driver) {
        super(driver);
        //navigationScreen = new NavigationScreen(driver);
    }

    public void setMovieRating(int rating) {
        try {
            this.ratingMovie = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/star_" + rating, "Rating movie with " + rating);
            appiumFactory.click(ratingMovie);
            appiumFactory.click(rateButton);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element not found because of you can NOT rate a movie with \"" + rating + "\" stars", e);
        }
    }

    public void clickRemoveMovieRating() {
        appiumFactory.click(removeRatingButton);
    }

}