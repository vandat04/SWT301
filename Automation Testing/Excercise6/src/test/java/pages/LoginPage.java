package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.id("fid-name");
    private By passwordField = By.id("fid-pass");
    private By rememberMeCheckbox = By.id("rememberMe");
    private By signInButton = By.cssSelector(".btn.btn-submit");

    private By errorAlert = By.cssSelector(".alert.alert-danger");

    private By forgotPasswordLink = By.xpath("//div[@class='form-row' and contains(text(), 'Forgot password')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRememberMe() {
        driver.findElement(rememberMeCheckbox).click();
    }

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public boolean isErrorDisplayed() {
        return driver.findElements(errorAlert).size() > 0;
    }

}
