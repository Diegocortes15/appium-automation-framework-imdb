package specs;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.MovieScreen;
import screens.SearchScreen;

public class AM_0001 extends BaseMobileTest {

    private final String storyParent = "am-0001";

    @Test
    @Story(storyParent)
    @Description("Search a movie")
    @Severity(SeverityLevel.BLOCKER)
    public void am_0002() {
        LoginScreen loginScreen = new LoginScreen(driver);
        SearchScreen searchScreen = new SearchScreen(driver);
        MovieScreen movieScreen = new MovieScreen(driver);

        loginScreen.skipSignIn();
        loginScreen.navigationScreen.goToSearchScreen();
        searchScreen.searchMovie("Interstellar");
        movieScreen.verifyMovieDescription("A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.");
    }

}
