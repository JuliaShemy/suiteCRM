package pages;

import dto.Account;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wrappers.*;
import java.time.Duration;

@Log4j2
public class NewAccountPage {
    WebDriver driver;

    public NewAccountPage(WebDriver driver) {

        this.driver = driver;
    }

    public void open() {
        log.info("Opening New Account page");
        driver.get("https://demo.suiteondemand.com/index.php?module=Accounts&action=EditView&return_module"+
                "=Accounts&return_action=DetailView");
    }

    public void addNewAccount(Account account) {
        log.info("Adding new account with name: '{}'", account.getName());
        new Input(driver, "Name").write(account.getName());
        new Input(driver, "Office Phone").write(account.getPhone());
        new Input(driver, "Fax").write(account.getFax());
        new Input(driver, "Website").write(account.getWebsite());
        new CheckBox(driver, "Opted Out").Click();
        new CheckBox(driver, "Invalid").Click();
        new AddressTextarea(driver, "Billing Address", "Street").write(account.getStreet());
        new AddressTextarea(driver, "Shipping Address", "Street").write(account.getStreet());
        new AddressInput(driver, "Billing Address", "City").write(account.getCity());
        new AddressInput(driver, "Billing Address", "State/Region").write(account.getStateRegion());
        new AddressInput(driver, "Billing Address", "Postal Code").write(account.getPostalCode());
        new AddressInput(driver, "Billing Address", "Country").write(account.getCountry());
        new AddressInput(driver, "Shipping Address", "City").write(account.getCity());
        new AddressInput(driver, "Shipping Address", "State/Region").write(account.getStateRegion());
        new AddressInput(driver, "Shipping Address", "Postal Code").write(account.getPostalCode());
        new AddressInput(driver, "Shipping Address", "Country").write(account.getCountry());
        new Textarea(driver, "Description").write(account.getDescription());
        new Select(driver, "Type").select(account.getType());
        new Select(driver, "Industry:").select(account.getIndustry());
    }

    public void clickSave() {
        log.info("Clicking SAVE button");
        driver.findElement((By.xpath("(//*[@id='SAVE'])[2]"))).click();
    }

    public String checkNewAccountTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("module-title-text")));
        log.info("Account title found: '{}'", title.getText());
        return title.getText();
    }
}
