package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage {
    private WebDriver driver;

    public ChangePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By currentPasswordInput = By.id("currentPassword");
    private By newPasswordInput = By.id("newPassword");
    private By confirmPasswordInput = By.id("confirmPassword");
    private By submitButton = By.cssSelector("button.btn-change");
    private By successAlert = By.cssSelector(".alert-success");
    private By errorAlert = By.cssSelector(".alert-danger");

    // Actions
    public void enterCurrentPassword(String currentPass) {
        driver.findElement(currentPasswordInput).clear();
        driver.findElement(currentPasswordInput).sendKeys(currentPass);
    }

    public void enterNewPassword(String newPass) {
        driver.findElement(newPasswordInput).clear();
        driver.findElement(newPasswordInput).sendKeys(newPass);
    }

    public void enterConfirmPassword(String confirmPass) {
        driver.findElement(confirmPasswordInput).clear();
        driver.findElement(confirmPasswordInput).sendKeys(confirmPass);
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }

    // Check result
    public boolean isSuccessMessageDisplayed() {
        return driver.findElements(successAlert).size() > 0;
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElements(errorAlert).size() > 0;
    }

    public String getErrorMessage() {
        return driver.findElement(errorAlert).getText();
    }

    public String getSuccessMessage() {
        return driver.findElement(successAlert).getText();
    }
}
