package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RegistPage extends BasePage {

    public RegistPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("userEmail");

    private By genderMale = By.cssSelector("label[for='gender-radio-1']");
    private By genderFemale = By.cssSelector("label[for='gender-radio-2']");
    private By genderOther = By.cssSelector("label[for='gender-radio-3']");

    private By mobile = By.id("userNumber");
    private By dateOfBirth = By.id("dateOfBirthInput");
    private By monthSelect = By.className("react-datepicker__month-select");
    private By yearSelect = By.className("react-datepicker__year-select");

    private By subjects = By.id("subjectsInput");
    private By hobbySports = By.cssSelector("label[for='hobbies-checkbox-1']");
    private By hobbyReading = By.cssSelector("label[for='hobbies-checkbox-2']");
    private By hobbyMusic = By.cssSelector("label[for='hobbies-checkbox-3']");

    private By uploadPicture = By.id("uploadPicture");
    private By currentAddress = By.id("currentAddress");

    private By state = By.id("state");
    private By city = By.id("city");

    private By submitButton = By.id("submit");
    private By modalTitle = By.id("example-modal-sizes-title-lg");

    // Actions

    public void navigate() {
        navigateTo("https://demoqa.com/automation-practice-form");
    }

    public void fillFirstName(String value) {
        type(firstName, value);
    }

    public void fillLastName(String value) {
        type(lastName, value);
    }

    public void fillEmail(String value) {
        type(email, value);
    }

    public void selectGender(String gender) {
        switch (gender.toLowerCase()) {
            case "male":
                click(genderMale); break;
            case "female":
                click(genderFemale); break;
            case "other":
                click(genderOther); break;
        }
    }

    public void fillMobile(String value) {
        type(mobile, value);
    }

    public void setDateOfBirth(String monthValue, String yearValue, String day) {
        scrollToElement(dateOfBirth);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(dateOfBirth));
        selectByValue(monthSelect, monthValue);
        selectByValue(yearSelect, yearValue);
        String formattedDay = String.format("%02d", Integer.parseInt(day));
        By dayLocator = By.xpath("//div[contains(@class,'react-datepicker__day--0" + formattedDay + "') and not(contains(@class,'outside-month'))]");
        click(dayLocator);
    }

    public void addSubject(String subject) {
        type(subjects, subject);
        driver.findElement(subjects).sendKeys(Keys.ENTER);
    }

    public void selectHobby(String hobby) {
        switch (hobby.toLowerCase()) {
            case "sports":
                click(hobbySports); break;
            case "reading":
                click(hobbyReading); break;
            case "music":
                click(hobbyMusic); break;
        }
    }

    public void uploadPicture(String filePath) {
        driver.findElement(uploadPicture).sendKeys(filePath);
    }

    public void fillAddress(String value) {
        type(currentAddress, value);
    }

    public void selectState(String value) {
        click(state);
        click(By.xpath("//div[text()='" + value + "']"));
    }

    public void selectCity(String value) {
        click(city);
        click(By.xpath("//div[text()='" + value + "']"));
    }

    public void submitForm() {
        scrollToElement(submitButton);
        click(submitButton);
    }

    public String getModalTitle() {
        return getText(modalTitle);
    }
}
