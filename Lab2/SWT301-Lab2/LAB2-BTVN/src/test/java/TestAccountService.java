import dattv.example.AccountService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestAccountService {

    static AccountService account = new AccountService();

    @BeforeAll
    static void initAll() {
        account = new AccountService();
    }

    @AfterAll
    static void cleanupAll() {
        account = null;
    }

    @DisplayName("Kiểm tra xác thực mail thành công")
    @Test
    void testIsValidEmail(){
        assertTrue( account.isValidEmail("dattruong02@gmail.com"), "Mail lỗi");
    }

    @DisplayName("Kiểm tra đăng kí thành công")
    @Test
    void testRegisterAccount(){
        assertTrue(account.registerAccount("dat","dat1231", "dat123@gmail.com"));
    }

    @Test
    @DisplayName("Đăng ký với email không hợp lệ")
    void testRegisterWithInvalidEmail() {
        assertTrue( account.registerAccount("dat","dat1231", "dat123@gmail.con"), "Mail Lỗi");
    }

    @Test
    @DisplayName("Đăng ký thất bại với mật khẩu quá ngắn")
    void testRegisterWithShortPassword() {
        assertTrue(account.registerAccount("dat","dat12", "dat123@gmail.com"));
    }

    @Test
    @DisplayName("Đăng ký thất bại vì null")
    void testRegisterWithNull() {
        assertTrue(account.registerAccount(null,"dat12", "dat123@gmail.com"), "Có null");
    }

    @ParameterizedTest
    @CsvSource({
            "dat@gmail.con,true",
            "Reje@.com,false",
            "Pen@gmail.com,true"
    })
    @DisplayName("Parameterized Test - ktra list mail")
    void testIsValid(String email,boolean status) {
        boolean actual = account.isValidEmail(email);
        assertEquals(status, actual, "Kết quả kiểm tra email không đúng với mong đợi.");
    }

    @ParameterizedTest(name = "Test {index} => username={0}, password={1}, email={2}, expected={3}")
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 0)
    void testMultiplyFromFile(String username , String password, String email , Boolean expected) {
        boolean results = account.registerAccount(username,password,email);
        assertEquals(expected, results, () -> username +" , "+password+" , "+email+" , "+" , "+expected);
    }

    @Test
    @DisplayName("Test username hợp lệ")
    void testValidUsername() {
        assertTrue(account.isValidUsername("dat123"));
        assertTrue(account.isValidUsername("userABC"));
    }

    @Test
    @DisplayName("Test username không hợp lệ")
    void testInvalidUsername() {
        assertFalse(account.isValidUsername("d")); // quá ngắn
        assertFalse(account.isValidUsername("dat_123")); // có ký tự đặc biệt
    }

    @Test
    @DisplayName("Test password mạnh")
    void testStrongPassword() {
        assertTrue(account.isStrongPassword("abc123"));
        assertTrue(account.isStrongPassword("passWord1"));
    }

    @Test
    @DisplayName("Test password yếu")
    void testWeakPassword() {
        assertFalse(account.isStrongPassword("abcdef")); // không có số
        assertFalse(account.isStrongPassword("ab1")); // quá ngắn
    }
} 