package tests;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.ChangePasswordPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class ChangePasswordTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/change-password.csv", numLinesToSkip = 1)
    public void testChangePassword(String username, String currentPassword, String newPassword,
                                   String confirmPassword, String expectedResult) throws InterruptedException {

        // B1: Đăng nhập trước
        driver.get("http://localhost:8080/CraftVillage/login"); // Sửa nếu khác
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(currentPassword);
        loginPage.clickSignIn();

        // B2: Vào trang đổi mật khẩu
        Thread.sleep(1000);
        driver.get("http://localhost:8080/CraftVillage/changePassword.jsp");

        ChangePasswordPage changePage = new ChangePasswordPage(driver);
        changePage.enterCurrentPassword(currentPassword);
        changePage.enterNewPassword(newPassword);
        changePage.enterConfirmPassword(confirmPassword);
        changePage.submitForm();

        Thread.sleep(2000); // Chờ phản hồi

        if (expectedResult.equalsIgnoreCase("success")) {
            assertTrue(changePage.isSuccessMessageDisplayed(), "Expected success message but none shown.");
        } else if (expectedResult.equalsIgnoreCase("fail")) {
            assertTrue(changePage.isErrorMessageDisplayed(), "Expected error message but none shown.");
        } else {
            fail("Invalid expectedResult in CSV: " + expectedResult);
        }
    }
}
