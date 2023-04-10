package screens;

import core.ElementBy;
import core.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import screens.components.NavigationComponent;

public class LoginScreen extends BaseMobileScreen {
    private static LoginScreen instance = null;
    public final NavigationComponent navigationComponent;
    private final HomeScreen homeScreen;
    private final MobileElement buttonNotNow = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/splash_not_now", "Not Now Button");
    private final MobileElement buttonLogInWithGoogle = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/google_oauth", "Google Log In");
    private final MobileElement buttonLogInWithIMDB = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/imdb_auth_portal", "IMDB Log In");

    private LoginScreen(AndroidDriver driver) {
        super(driver);
        navigationComponent = NavigationComponent.getInstance(driver);
        homeScreen = HomeScreen.getInstance(driver);
    }

    public static LoginScreen getInstance(AndroidDriver driver) {
        if (instance == null) {
            instance = new LoginScreen(driver);
        } else {
            instance.updateDriver(driver);
        }
        return instance;
    }

    @Step("🐾 Skip SignIn")
    public void skipSignIn() {
        appiumFactory.click(buttonNotNow);
    }

    @Step("🐾 SignIn with Google")
    public void singInWithGoogle() {
        appiumFactory.click(buttonLogInWithGoogle);
        homeScreen.waitVisibleVideoHeroView();
    }

    @Step("🐾 SignIn with Google")
    public void singInWithIMDB() {
        appiumFactory.click(buttonLogInWithIMDB);
    }
}
