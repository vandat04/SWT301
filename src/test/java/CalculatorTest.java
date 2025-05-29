import org.junit.jupiter.api.*;
import dattv.example.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    Calculator calculator = new Calculator();
    @Test
    void testAddition() {
        assertEquals(5, calculator.add(2, 3), "Addition should return 5");
    }

    @Test
    void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });

        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @ParameterizedTest(name = "Test {index} => {0} * {1} = {2}")
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 0)
    void testMultiplyFromFile(int a, int b, int expected) {
        int result = calculator.multiply(a, b);
        assertEquals(expected, result, () -> a + " * " + b + " should be " + expected);
    }

    @BeforeAll
    static void setUpAll() {
        System.out.println("===> [BeforeAll] Khởi tạo tài nguyên dùng chung cho tất cả test");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("===> [AfterAll] Giải phóng tài nguyên sau tất cả test");
    }

    @BeforeEach
    void setUp() {
        System.out.println("---> [BeforeEach] Chuẩn bị trước mỗi test");
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("---> [AfterEach] Dọn dẹp sau mỗi test");
    }

    @Test
    @DisplayName(" Kiểm tra phép chia hai số nguyên")
    void testDivision() {
        int result = calculator.divide(10, 2);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("⚠ Kiểm tra chia cho 0: nên ném IllegalArgumentException")
    void testDivisionByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

}
