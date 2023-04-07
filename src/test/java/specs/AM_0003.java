package specs;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.MovieScreen;
import screens.SearchScreen;

public class AM_0003 extends BaseMobileTest {

    private final String storyParent = "am-0002";

    @Test
    @Story(storyParent)
    @Description("Search a movie")
    @Severity(SeverityLevel.NORMAL)
    public void am_0004() {
        LoginScreen loginScreen = new LoginScreen(driver);
        SearchScreen searchScreen = new SearchScreen(driver);
        MovieScreen movieScreen = new MovieScreen(driver);

        loginScreen.singInWithGoogle();
        loginScreen.navigationScreen.goToSearchScreen();
        searchScreen.searchMovie("Passengers");
        String movieTitle = movieScreen.getMovieTitle();
        movieScreen.addToWatchList();
        movieScreen.navigationScreen.goToProfileScreen();
        profileScreen.verifyMovieTitleInWatchlist(movieTitle);
        profileScreen.removeMovieFromWatchlist();
    }
}
