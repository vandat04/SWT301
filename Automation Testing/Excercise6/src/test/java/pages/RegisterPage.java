package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By usernameInput = By.name("userName"); // Đúng theo JSP
    private By emailInput = By.name("email");
    private By fullNameInput = By.name("fullName");
    private By passwordInput = By.name("password");
    private By rePasswordInput = By.name("rePassword");
    private By addressInput = By.name("address");
    private By phoneInput = By.name("phoneNumber");
    private By submitButton = By.cssSelector("button.btn-submit");

    // Actions
    public void enterUsername(String username) {
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterFullName(String fullName) {
        driver.findElement(fullNameInput).clear();
        driver.findElement(fullNameInput).sendKeys(fullName);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void enterConfirmPassword(String rePassword) {
        driver.findElement(rePasswordInput).clear();
        driver.findElement(rePasswordInput).sendKeys(rePassword);
    }

    public void enterAddress(String address) {
        driver.findElement(addressInput).clear();
        driver.findElement(addressInput).sendKeys(address);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneInput).clear();
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }
}
