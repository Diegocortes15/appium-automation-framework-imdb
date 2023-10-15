package specs;

import core.ConfigCapabilities;
import core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import screens.*;
import screens.modals.RateMoreLikeThisModal;
import screens.modals.TurnOnNotificationsModal;

public abstract class BaseMobileTest {
    protected AndroidDriver driver;
    protected WelcomeScreen welcomeScreen;
    protected PreferredServicesScreen preferredServicesScreen;
    protected TurnOnNotificationsModal turnOnNotificationsModal;
    protected RateMoreLikeThisModal rateMoreLikeThisModal;
    protected LoginScreen loginScreen;
    protected LoginIMDBScreen loginIMDBScreen;
    protected SearchScreen searchScreen;
    protected MovieScreen movieScreen;
    protected RateMovieScreen rateMovieScreen;
    protected ProfileScreen profileScreen;

    @BeforeTest(alwaysRun = true)
    public void SetUp() {
        if (driver == null) {
            this.driver = MobileAppDriver.getMoviesAppDriver(ConfigCapabilities.getCapabilities());
            welcomeScreen = WelcomeScreen.getInstance(driver);
            preferredServicesScreen = PreferredServicesScreen.getInstance(driver);
            rateMoreLikeThisModal = RateMoreLikeThisModal.getInstance(driver);
            turnOnNotificationsModal = TurnOnNotificationsModal.getInstance(driver);
            loginScreen = LoginScreen.getInstance(driver);
            loginIMDBScreen = LoginIMDBScreen.getInstance(driver);
            searchScreen = SearchScreen.getInstance(driver);
            movieScreen = MovieScreen.getInstance(driver);
            rateMovieScreen = RateMovieScreen.getInstance(driver);
            profileScreen = ProfileScreen.getInstance(driver);
        }
    }

    @AfterTest(alwaysRun = true)
    public void TearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
