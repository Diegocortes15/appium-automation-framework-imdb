package core;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class AppiumFactory {
    private static AppiumFactory instance = null;
    private AndroidDriver driver;
    private WebDriverWait wait;

    private AppiumFactory(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(FrameworkConfig.ELEMENT_TIMEOUT));
    }

    public static AppiumFactory getInstance(AndroidDriver driver) {
        if (instance == null) {
            instance = new AppiumFactory(driver);
        } else {
            instance.updateDriver(driver);
        }
        return instance;
    }

    protected void updateDriver(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(FrameworkConfig.ELEMENT_TIMEOUT));
    }

    public WebElement getElement(MobileElement mobileElement) {
        return waitUntilVisibleElement(mobileElement);
    }

    public WebElement waitUntilVisibleElement(MobileElement mobileElement) {
        try {
            if (!mobileElement.scroll) {
                switch (mobileElement.By) {
                    case ID:
                        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(mobileElement.selector)));
                    case CLASSNAME:
                        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(mobileElement.selector)));
                    case XPATH:
                        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mobileElement.selector)));
                    case UIAUTOMATOR:
                        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(new AppiumBy.ByAndroidUIAutomator(mobileElement.selector)));
                }
            }
            switch (mobileElement.By) {
                case ID:
                    return wait.until(ExpectedConditions.visibilityOfElementLocated(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\"" + mobileElement.selector + "\").instance(0))")));
                case CLASSNAME:
                    return wait.until(ExpectedConditions.visibilityOfElementLocated(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().className(\"" + mobileElement.selector + "\").instance(0))")));
                case XPATH:
                    return wait.until(ExpectedConditions.visibilityOfElementLocated(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().xpath(\"" + mobileElement.selector + "\").instance(0))")));
                case UIAUTOMATOR:
                    return wait.until(ExpectedConditions.visibilityOfElementLocated(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + mobileElement.selector + ")")));
            }
        } catch (TimeoutException e) {
            throw new TimeoutException("Expected condition failed: waiting for visibility of element \"" + mobileElement.description + "\".\n" + e.getMessage());
        }
        return null;
    }

    /*public void scrollTo(MobileElement mobileElement) {
        getElement(mobileElement);
    }*/

    @Step("📸 {0} - 📸 Full screen screenshot")
    public void embedFullScreenScreenshot(String description) {
        Allure.addAttachment("📸 " + description + " - 📸 Full screen screenshot", new ByteArrayInputStream(((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("🐾 \"{0.description}\" Element is clicked")
    public void click(MobileElement mobileElement) {
        WebElement element = getElement(mobileElement);
        try {
            element.click();
            LoggerLoad.info(mobileElement.description + " Element is clicked");
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            this.click(mobileElement);
        }
    }

    @Step("🐾 \"{0.description}\" is entered with \"{1}\"")
    public void sendKeys(MobileElement mobileElement, String strValue) {
        WebElement element = getElement(mobileElement);
        try {
            click(mobileElement);
            element.clear();
            element.sendKeys(strValue);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
            LoggerLoad.info("⏩ " + mobileElement.description + " is entered with " + strValue);
        } catch (StaleElementReferenceException e) {
            this.sendKeys(mobileElement, strValue);
        }
    }

    @Step("🐾 Getting \"{0.description}\" element text")
    public String getText(MobileElement mobileElement) {
        WebElement element = getElement(mobileElement);
        LoggerLoad.info("⏩ Getting " + mobileElement.description + " element text");
        return element.getText();
    }

    @Step("🧪 Verifying if \"{0.description}\" text (\"{1}\") is displayed as expected {1}")
    public void verifyText(MobileElement mobileElement, String strExpectedValue) {
        String actualValue = getText(mobileElement);
        if (actualValue.contains(strExpectedValue)) {
            Allure.addAttachment("✅ " + mobileElement.description + " text is displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue, "✅ " + mobileElement.description + " text is displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
            embedFullScreenScreenshot("✅ " + mobileElement.description + " text is displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
            LoggerLoad.info("PASSED: " + mobileElement.description + " text is displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
        } else {
            Allure.addAttachment("💥 " + mobileElement.description + " text is NOT displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue, "💥 " + mobileElement.description + " text is NOT displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
            embedFullScreenScreenshot("💥 " + mobileElement.description + " text is NOT displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
            LoggerLoad.error("FAILED: " + mobileElement.description + " text is NOT displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
        }
        Assert.assertTrue(actualValue.contains(strExpectedValue));
    }

    @Step("🧪 Verifying if \"{0.description}\" text (\"{1}\") is displayed as expected {1}")
    public void verifyDisplayed(MobileElement mobileElement) {
        WebElement element = getElement(mobileElement);
        boolean booleanFlag = element.isDisplayed();
        if (booleanFlag) {
            Allure.addAttachment("✅ " + mobileElement.description + " is displayed as Expected", "✅ " + mobileElement.description + " is displayed as Expected");
            embedFullScreenScreenshot("✅ " + mobileElement.description + " is displayed as Expected");
            LoggerLoad.info("PASSED: " + mobileElement.description + " is displayed as Expected");
        } else {
            Allure.addAttachment("💥 " + mobileElement.description + " is NOT displayed as Expected", "💥 " + mobileElement.description + " text is NOT displayed as Expected ");
            embedFullScreenScreenshot("💥 " + mobileElement.description + " is NOT displayed as Expected");
            LoggerLoad.error("FAILED: " + mobileElement.description + " is NOT displayed as Expected");
        }
        Assert.assertTrue(element.isDisplayed());
    }

    public boolean isElementPresent(MobileElement mobileElement) {
         WebDriverWait innerWait = new WebDriverWait(driver, Duration.ofMillis(FrameworkConfig.EXIST_ELEMENT_TIMEOUT));
        innerWait.ignoring(TimeoutException.class);
        innerWait.ignoring(WebDriverException.class);
        try {
            return innerWait.until(innerDriver -> {
                switch (mobileElement.By) {
                    case ID:
                        return !innerDriver.findElements(By.id(mobileElement.selector)).isEmpty();
                    case CLASSNAME:
                        return !innerDriver.findElements(By.className(mobileElement.selector)).isEmpty();
                    case XPATH:
                        return !innerDriver.findElements(By.xpath(mobileElement.selector)).isEmpty();
                    case UIAUTOMATOR:
                        return !innerDriver.findElements(new AppiumBy.ByAndroidUIAutomator(mobileElement.selector)).isEmpty();
                }
                return false;
            });
        } catch (Exception e) {
            return false;
        }
    }
}
