package pages;

import dto.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wrappers.*;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class NewAccountPage {
    WebDriver driver;

    public NewAccountPage(WebDriver driver) {

        this.driver = driver;
    }

    public void open() {
        driver.get("https://demo.suiteondemand.com/index.php?module=Accounts&action=EditView&return_module"+
                "=Accounts&return_action=DetailView");
    }

    public void addNewAccount(Account account) {
        new Input(driver, "Name").write(account.getName());
        new Input(driver, "Office Phone").write(account.getPhone());
        new Input(driver, "Fax").write(account.getFax());
        new Input(driver, "Website").write(account.getWebsite());
        new CheckBox(driver, "Opted Out").Click();
        new CheckBox(driver, "Invalid").Click();
        new AddressTextarea(driver, "Billing Address", "Street").write(account.getStreet());
        new AddressTextarea(driver, "Shipping Address", "Street").write(account.getStreet());
        new AddressInput(driver, "Billing Address", "City").write(account.getCity());
        new AddressInput(driver, "Billing Address", "State/Region").write(account.getState_region());
        new AddressInput(driver, "Billing Address", "Postal Code").write(account.getPostal_code());
        new AddressInput(driver, "Billing Address", "Country").write(account.getCountry());
        new AddressInput(driver, "Shipping Address", "City").write(account.getCity());
        new AddressInput(driver, "Shipping Address", "State/Region").write(account.getState_region());
        new AddressInput(driver, "Shipping Address", "Postal Code").write(account.getPostal_code());
        new AddressInput(driver, "Shipping Address", "Country").write(account.getCountry());
        new Textarea(driver, "Description").write(account.getDescription());
        new Select(driver, "Type").select(account.getType());
        new Select(driver, "Industry:").select(account.getIndustry());
    }

    public void clickSave() {
        driver.findElement((By.xpath("(//*[@id='SAVE'])[2]"))).click();
    }

    public String checkNewAccountTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("module-title-text")));
        return title.getText();
    }
}
