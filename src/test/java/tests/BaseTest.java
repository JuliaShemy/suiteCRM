package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.MainPage;
import pages.NewAccountPage;
import pages.NewContactPage;
import step.LoginStep;

public class BaseTest {

    protected WebDriver driver;
    protected NewAccountPage newAccountPage;
    protected NewContactPage newContactPade;
    protected MainPage mainPage;
    protected LoginStep loginStep;

    @BeforeMethod(alwaysRun = true, description = "Настройка браузера")
    public void setUp() throws IOException {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        newAccountPage = new NewAccountPage(driver);
        newContactPade = new NewContactPage(driver);
        mainPage = new MainPage(driver);
        loginStep = new LoginStep(driver);

    }

    @AfterMethod(alwaysRun = true, description = "Закрытие браузера")
    public void tearDawn() {
        driver.quit();
    }
}