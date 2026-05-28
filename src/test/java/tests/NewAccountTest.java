package tests;

import dto.Account;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import wrappers.AddressTextarea;
import wrappers.Input;
import wrappers.Select;

import static java.lang.Thread.sleep;

public class NewAccountTest extends BaseTest {

    Account account = new Account("test1", "+123456", "+123465", "avito.ru",
            "test", "Investor", "Banking", "Moscow", "test", "35412555",
            "Russia", "test");

    @Test(description = "Проверка добавдения нового аккаунта",
            testName = "Новый аккаунт")
    @Description("Проверка добавдения нового аккаунта")
    public void checkAddNewAccount() throws InterruptedException {
        loginPage.open();
        loginPage.login("will", "will");
        mainPage.goToCreateAccount();
        newAccountPage.addNewAccount(account);
        newAccountPage.clickSave();

        String actualTitle = newAccountPage.checkNewAccountTitle();
        String expectedTitle =account.getName();
        Assert.assertEquals(actualTitle.toLowerCase(), expectedTitle.toLowerCase());

    }
}