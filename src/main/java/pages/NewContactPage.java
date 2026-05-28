package pages;

import dto.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wrappers.*;

import java.time.Duration;

public class NewContactPage {
    WebDriver driver;

    public NewContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://demo.suiteondemand.com/index.php?module=Contacts&action=EditView&return_module" +
                "=Contacts&return_action=DetailView");
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(), 'First Name')]" +
                                "/following-sibling::div//input")));
    }

    public void addNewContact(Contact contact) {
        new Select(driver, "First Name").select(contact.getSalutation());
        new Input(driver, "First Name").write(contact.getFirstName());
        new Input(driver, "Office Phone").write(contact.getOfficePhone());
        new Input(driver, "Job Title").write(contact.getJobTitle());
        new Input(driver, "Account Name").write(contact.getAccountName());
        new Input(driver, "Last Name").write(contact.getLastName());
        new Input(driver, "Mobile").write(contact.getMobile());
        new Input(driver, "Department").write(contact.getDepartment());
        new Input(driver, "Fax").write(contact.getFax());
        new CheckBox(driver, "Opted Out").Click();
        new CheckBox(driver, "Invalid").Click();
        new AddressTextarea(driver, "Primary Address", "Address").write(contact.getAddress());
        new AddressTextarea(driver, "Other Address", "Other Address").write(contact.getAddress());
        new AddressInput(driver, "Primary Address", "City").write(contact.getCity());
        new AddressInput(driver, "Primary Address", "State/Region").write(contact.getState_region());
        new AddressInput(driver, "Primary Address", "Postal Code").write(contact.getPostal_code());
        new AddressInput(driver, "Primary Address", "Country").write(contact.getCountry());
        new AddressInput(driver, "Other Address", "City").write(contact.getCity());
        new AddressInput(driver, "Other Address", "State/Region").write(contact.getState_region());
        new AddressInput(driver, "Other Address", "Postal Code").write(contact.getPostal_code());
        new AddressInput(driver, "Other Address", "Country").write(contact.getCountry());
        new Textarea(driver, "Description").write(contact.getDescription());
        new Input(driver, "Assigned to").write(contact.getAssigned_to());
        new Select(driver, "Lead Source").select(contact.getLeadSource());

    }

    public void clickSave() {
        driver.findElement((By.xpath("(//*[@id='SAVE'])[2]"))).click();
    }

    public String checkNewContact() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("module-title-text"))).getText();

    }
}