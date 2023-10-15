package screens;

import core.ElementBy;
import core.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import javax.swing.plaf.PanelUI;

public class LoginIMDBScreen extends BaseMobileScreen {
    private static LoginIMDBScreen instance = null;
    private final MobileElement inputEmail = new MobileElement(ElementBy.ID, "ap_email", "Input Email");
    private final MobileElement inputPassword = new MobileElement(ElementBy.ID, "ap_password", "Input Password");
    private final MobileElement checkBoxShowPassword = new MobileElement(ElementBy.ID, "auth-show-password-checkbox", "CheckBox ShowPassword");
    private final MobileElement buttonSignIn = new MobileElement(ElementBy.ID, "signInSubmit", "button Sign In");

    public LoginIMDBScreen(AndroidDriver driver) {
        super(driver);
    }

    public static LoginIMDBScreen getInstance(AndroidDriver driver) {
        if (instance == null) {
            instance = new LoginIMDBScreen(driver);
        } else {
            instance.updateDriver(driver);
        }
        return instance;
    }

    public void enterEmail (String strEmail) {
        appiumFactory.sendKeys(inputEmail, strEmail);
    }

    public void enterPassword (String strPassword) {
        appiumFactory.sendKeys(inputPassword, strPassword);
    }

    public void clickCheckBoxShowPassword () {
        appiumFactory.click(checkBoxShowPassword);
    }

    public void clickButtonSignIn(){
        appiumFactory.click(buttonSignIn);
    }

    public void login (String strEmail, String strPassword){
        clickCheckBoxShowPassword();
        enterEmail(strEmail);
        enterPassword(strPassword);
    }
}
