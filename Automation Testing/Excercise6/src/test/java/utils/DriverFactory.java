package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class DriverFactory {

    public static WebDriver createDriver() {
        ChromeDriverManager manager = new ChromeDriverManager();
        manager.setup();  // Cài đặt driver

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        return new ChromeDriver(options);
    }
}