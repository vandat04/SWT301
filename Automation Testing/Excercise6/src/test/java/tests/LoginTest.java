package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/login.csv", numLinesToSkip = 1)
    public void testLoginFromCSV(String username, String password, String expectedResult) {
        LoginPage login = new LoginPage(driver);
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickSignIn();

        if (expectedResult.equalsIgnoreCase("success")) {
            assertTrue(driver.getCurrentUrl().contains("home"), "Expected login success but failed.");
        } else if (expectedResult.equalsIgnoreCase("fail")) {
            assertTrue(login.isErrorDisplayed(), "Expected error message but none shown.");
        } else {
            fail("Invalid expected result in CSV: " + expectedResult);
        }
    }
}