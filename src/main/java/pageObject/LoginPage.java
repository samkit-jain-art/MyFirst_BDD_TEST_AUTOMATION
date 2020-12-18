package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    // 1. By Locators: OR
    private final By emailId = By.id("email");
    private final By password = By.id("passwd");
    private final By signInButton = By.id("SubmitLogin");
    private final By forgotPwdLink = By.linkText("Forgot your password?111");

    // 2. Constructor of the page class:
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. page actions: features(behavior) of the page the form of methods:

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean isForgotPwdLinkExist() {
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    public void enterUserName(String username) {
        driver.findElement(emailId).sendKeys(username);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickOnLogin() {
        driver.findElement(signInButton).click();
    }



}
