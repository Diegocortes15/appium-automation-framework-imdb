package specs;

import core.ReadJsonData;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class AM_0003 extends BaseMobileTest {

    private final String storyParent = "am_0003";

    @Test
    @Story(storyParent)
    @Description("📘 Verify movie added in watchlist")
    @Severity(SeverityLevel.NORMAL)
    public void am_0004() {
        ReadJsonData readDataTestCase = new ReadJsonData("src/test/java/data/" + storyParent + "/am_0004.json");
        JSONObject dataTestCase = readDataTestCase.getJsonObject();
        JSONObject data = (JSONObject) dataTestCase.get("data");

        loginScreen.singInWithGoogle();
        loginScreen.navigationComponent.goToSearchScreen();
        searchScreen.searchMovie((String) data.get("movieTitle"));
        String movieTitle = movieScreen.getMovieTitle();
        movieScreen.addToWatchList();
        turnOnNotificationsModal.clickButtonNotNow();
        movieScreen.navigationComponent.goToProfileScreen();
        profileScreen.verifyMovieTitleInWatchlist(movieTitle);
        profileScreen.removeMovieFromWatchlist();
    }
}
