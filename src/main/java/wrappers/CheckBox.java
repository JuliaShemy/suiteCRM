package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@Log4j2
public class CheckBox {
    WebDriver driver;
    String label;

    public CheckBox(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;

    }

    public void Click() {
        WebElement checkbox = driver.findElement(
                By.xpath(String.format("//div[contains(@class,'email-address-line-container')][last()]" +
                                "//label[.='%s']/following::input[@type='checkbox'][1]",
                        label)));
        log.info("Checkbox '{}' initial state: {}", label, checkbox.isSelected());

        if (checkbox.isSelected()) {
            checkbox.click();//выключаем если включен
        }
        if (!checkbox.isSelected()) {
            checkbox.click();//включаем если выключен
        }
        log.info("Checkbox '{}' final state: {}", label, checkbox.isSelected());
    }
}