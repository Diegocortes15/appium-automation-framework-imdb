package screens;

import core.ElementBy;
import core.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import screens.components.NavigationScreen;

public class LoginScreen extends BaseMobileScreen {

    public final NavigationScreen navigationScreen;
    private final MobileElement buttonNotNow = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/splash_not_now", "Not Now Button");
    private final MobileElement buttonLogInWithGoogle = new MobileElement(ElementBy.ID, "com.imdb.mobile:id/google_oauth", "Google Log In");

    @AndroidFindBy(id = "android:id/text1")
    private WebElement firstGoogleAccount;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement submitGoogleAccountSelectedButton;

    public LoginScreen(AndroidDriver driver) {
        super(driver);
        navigationScreen = new NavigationScreen(driver);
    }

    @Step("Skip SignIn")
    public void skipSignIn() {
        appiumFactory.click(buttonNotNow);
    }

    @Step("SignIn with Google")
    public void singInWithGoogle() {
        appiumFactory.click(buttonLogInWithGoogle);
        //appiumFactory.click(firstGoogleAccount);
        //appiumFactory.click(submitGoogleAccountSelectedButton);
    }
}
