package tests;

import dto.Account;
import dto.AccountFactory;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewAccountTest extends BaseTest {

    Account account = Account.builder()
            .name("test1")
            .phone("+123456")
            .fax("+123465")
            .website("avito.ru")
            .street("test")
            .type("Investor")
            .industry("Banking")
            .city("Moscow")
            .stateRegion("test")
            .postalCode("35412555")
            .country("Russia")
            .description("test")
            .build()
            ;
    Account account1 = AccountFactory.getAccount("Investor","Banking");
    @Test(description = "Проверка добавдения нового аккаунта",
            testName = "Новый аккаунт")
    @Description("Проверка добавдения нового аккаунта")
    public void checkAddNewAccount() throws InterruptedException {
        loginStep.auth("will", "will")
                .goToCreateAccount()
                .addNewAccount(account1);
               newAccountPage.clickSave();

        String actualTitle = newAccountPage.checkNewAccountTitle();
        String expectedTitle =account1.getName();
        Assert.assertEquals(actualTitle.toLowerCase(), expectedTitle.toLowerCase());

    }
}