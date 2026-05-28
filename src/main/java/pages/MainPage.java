package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;
    private final By createMenu =
            By.xpath("//div[@class='desktop-bar']//li[@id='quickcreatetop']" +
                    "//a[contains(@class,'dropdown-toggle')]");
    private final By createAccountButton =
            By.xpath("//div[@class='desktop-bar']//li[@id='quickcreatetop']" +
                    "//a[text()='Create Accounts']");
    private final By createContactButton =
            By.xpath("//div[@class='desktop-bar']//li[@id='quickcreatetop']" +
                    "//a[text()='Create Contacts']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCreateAccount() {
        driver.findElement(createMenu).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(createAccountButton)).click();
    }

    public void goToCreateContact() {
        driver.findElement(createMenu).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(createContactButton)).click();
    }
}