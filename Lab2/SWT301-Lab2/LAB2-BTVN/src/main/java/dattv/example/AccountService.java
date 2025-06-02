package dattv.example;

import java.util.regex.Pattern;

public class AccountService {

    public boolean registerAccount(String username, String password, String email){
        if (username == null || password == null || email == null) {
            return false;
        }
        if (password.length() <= 6) {
            System.out.println("Mật khẩu phải lớn hơn 6 ký tự.");
            return false;
        }
        if (!isValidEmail(email)) {
            System.out.println("Email không hợp lệ.");
            return false;
        }
        return true;
    };

    public boolean isValidEmail(String email) {
        if (email == null) return false;
        return Pattern.compile("^[a-zA-Z0-9](?!.*[.]{2})[a-zA-Z0-9._]{0,62}[a-zA-Z0-9]@gmail\\.com$").matcher(email).matches();
    };

    // user = 3-15
    public boolean isValidUsername(String username) {
        if (username == null) return false;
        return username.matches("^[a-zA-Z0-9]{3,15}$");
    }

    // pass 1 letter + 1 digit
    public boolean isStrongPassword(String password) {
        if (password == null || password.length() < 6) return false;
        boolean hasLetter = password.matches(".*[a-zA-Z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        return hasLetter && hasDigit;
    }
}