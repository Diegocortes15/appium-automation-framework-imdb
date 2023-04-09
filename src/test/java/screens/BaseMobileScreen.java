package screens;

import core.AppiumFactory;
import core.FrameworkConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public abstract class BaseMobileScreen {
    protected AndroidDriver driver;
    protected AppiumFactory appiumFactory;

    public BaseMobileScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofMillis(FrameworkConfig.ELEMENT_TIMEOUT)), this);
        this.appiumFactory = AppiumFactory.getInstance(driver);
    }

    protected void updateDriver(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofMillis(FrameworkConfig.ELEMENT_TIMEOUT)), this);
        this.appiumFactory = AppiumFactory.getInstance(driver);
    }
}
