package specs;

import core.AppiumFactory;
import core.ConfigCapabilities;
import core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import screens.LoginScreen;
import screens.MovieScreen;
import screens.ProfileScreen;
import screens.SearchScreen;
import screens.components.NavigationScreen;

public abstract class BaseMobileTest {
    protected AndroidDriver driver;
    //protected NavigationScreen navigationScreen;
    protected LoginScreen loginScreen;
    protected SearchScreen searchScreen;
    protected MovieScreen movieScreen;
    protected ProfileScreen profileScreen;
    //public RateMovieScreen rateMovieScreen;

    @BeforeMethod
    public void SetUp() {
        if (driver == null) {
            this.driver = MobileAppDriver.getMoviesAppDriver(ConfigCapabilities.getCapabilities());
            this.loginScreen = new LoginScreen(this.driver);
            this.searchScreen = new SearchScreen(this.driver);
            this.movieScreen = new MovieScreen(this.driver);
            this.profileScreen = new ProfileScreen(this.driver);
            //this.rateMovieScreen = new RateMovieScreen(this.driver);
        }
    }

    @AfterMethod
    public void TearDown() {
        if (driver != null) {
            //driver.close();
            driver.quit();
            driver = null;
            // driver.close();
        }
    }
}
