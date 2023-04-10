package specs;

import core.ReadJsonData;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class AM_0005 extends BaseMobileTest {

    private final String storyParent = "am_0005";

    @Test
    @Story(storyParent)
    @Description("📘 Verify movie rating")
    @Severity(SeverityLevel.BLOCKER)
    public void am_0006() {
        ReadJsonData readDataTestCase = new ReadJsonData("src/test/java/data/" + storyParent + "/am_0006.json");
        JSONObject dataTestCase = readDataTestCase.getJsonObject();
        JSONObject data = (JSONObject) dataTestCase.get("data");

        loginScreen.singInWithGoogle();
        loginScreen.navigationComponent.goToSearchScreen();
        searchScreen.searchMovie((String) data.get("movieTitle"));
        movieScreen.clickReviewsSectionEmptyRateButton();
        rateMovieScreen.setMovieRating((String) data.get("movieRating"));
        rateMoreLikeThisModal.clickButtonClose();
        movieScreen.verifyUserRating((String) data.get("movieRating"));
        movieScreen.clickReviewsSectionRateButton();
        rateMovieScreen.clickRemoveMovieRating();
    }
}
