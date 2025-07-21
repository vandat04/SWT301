package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.RegisterPage;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/register.csv", numLinesToSkip = 1)
    public void testRegisterFromCSV(String username, String email, String fullName,
                                    String password, String confirmPassword, String address,
                                    String phone, String expectedResult) throws InterruptedException {

        RegisterPage register = new RegisterPage(driver);
        register.enterUsername(username);
        register.enterEmail(email);
        register.enterFullName(fullName);
        register.enterPassword(password);
        register.enterConfirmPassword(confirmPassword);
        register.enterAddress(address);
        register.enterPhone(phone);
        register.submitForm();

        Thread.sleep(2000); // chỉ để test nhanh, nên thay bằng WebDriverWait

        if (expectedResult.equalsIgnoreCase("success")) {
            assertTrue(driver.getCurrentUrl().contains("login"), "Expected to be redirected to login after success.");
        } else if (expectedResult.equalsIgnoreCase("fail")) {
            assertTrue(driver.getCurrentUrl().contains("register"), "Expected to stay on register page after failure.");
        } else {
            fail("Invalid expected result in CSV: " + expectedResult);
        }
    }
}