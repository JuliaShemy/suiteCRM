package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        if (checkbox.isSelected()) {
            checkbox.click();//выключаем если включен
        }
        if (!checkbox.isSelected()) {
            checkbox.click();//включаем если выключен
        }
    }
}