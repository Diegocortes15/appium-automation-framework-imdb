package specs;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.MovieScreen;
import screens.RateMovieScreen;
import screens.SearchScreen;

public class AM_0005 extends BaseMobileTest {

    private final String storyParent = "am-0001";

    @Test
    @Story(storyParent)
    @Description("Search a movie")
    @Severity(SeverityLevel.BLOCKER)
    public void am_0006() {
        int movieRating = 8;
        LoginScreen loginScreen = new LoginScreen(driver);
        SearchScreen searchScreen = new SearchScreen(driver);
        MovieScreen movieScreen = new MovieScreen(driver);
        RateMovieScreen rateMovieScreen = new RateMovieScreen(driver);

        loginScreen.singInWithGoogle();
        loginScreen.navigationScreen.goToSearchScreen();
        searchScreen.searchMovie("Puss in Boots: The Last Wish");
        movieScreen.clickReviewsSectionEmptyRateButton();
        rateMovieScreen.setMovieRating(movieRating);
        movieScreen.verifyUserRating(String.valueOf(movieRating));
        //movieScreen.verifyMovieDescription("A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.");
        movieScreen.clickReviewsSectionRateButton();
        rateMovieScreen.clickRemoveMovieRating();

    }
}
