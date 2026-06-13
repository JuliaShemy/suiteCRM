package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Log4j2
public class LoginPage {

    WebDriver driver;
@FindBy(id = "user_name")
    private WebElement loginField;
@FindBy(id = "username_password")
    private WebElement passwordField;
@FindBy(name = "Login")
private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public LoginPage open(){
        log.info("LoginPage opening");
        driver.get("https://demo.suiteondemand.com/index.php?module=Users&action=Login");
        return this;
    }

    public MainPage login(String user, String password){
        log.info("Log in with credential : '{}', '{}'", user, password);
        loginField.sendKeys(user);
        passwordField.sendKeys(password);
        loginButton.click();
        return new MainPage(driver);
    }
}