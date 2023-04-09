package specs;

import core.ReadJsonData;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class AM_0001 extends BaseMobileTest {

    private final String storyParent = "am_0001";

    @Test
    @Story(storyParent)
    @Description("📘 Verify movie description")
    @Severity(SeverityLevel.BLOCKER)
    public void am_0002() {
        ReadJsonData readDataTestCase = new ReadJsonData("src/test/java/data/" + storyParent + "/am_0002.json");
        JSONObject dataTestCase = readDataTestCase.getJsonObject();
        JSONObject data = (JSONObject) dataTestCase.get("data");

        loginScreen.skipSignIn();
        loginScreen.navigationScreen.goToSearchScreen();
        searchScreen.searchMovie((String) data.get("movieTitle"));
        movieScreen.verifyMovieDescription((String) data.get("description"));
    }
}
