package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.RegistPage;

public class RegistTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/regist.csv", numLinesToSkip = 0)
    public void testSubmitFormFromCSV(
            String firstName,
            String lastName,
            String email,
            String gender,
            String mobile,
            String month,
            String year,
            String day,
            String subject,
            String hobby,
            String address,
            String state,
            String city
    ) {
        RegistPage form = new RegistPage(driver);

        form.navigate();
//        form.hideAds();  // tránh lỗi click do iframe
        form.fillFirstName(firstName);
        form.fillLastName(lastName);
        form.fillEmail(email);
        form.selectGender(gender);
        form.fillMobile(mobile);
        form.setDateOfBirth(month, year, day);
        form.addSubject(subject);
        form.selectHobby(hobby);
        form.fillAddress(address);
        form.selectState(state);
        form.selectCity(city);
        form.submitForm();

        Assertions.assertEquals("Thanks for submitting the form", form.getModalTitle());
    }
}
