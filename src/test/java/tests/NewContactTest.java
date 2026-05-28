package tests;

import dto.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewContactTest extends BaseTest{
    Contact contact = new Contact("test","89120254545","test","nick",
            "test","89324095252","test", "85225212222", "test","Moscow",
            "test","4583265", "Russia","test", "test",
            "Email","Mr.");
    @Test
    public void checkAddNewCustomer() throws InterruptedException {
        loginPage.open();
        loginPage.login("will", "will");
        mainPage.goToCreateContact();
        newContactPade.addNewContact(contact);
        newContactPade.clickSave();

        String actualTitle = newAccountPage.checkNewAccountTitle();
        String expectedTitle = contact.getSalutation() + " " + contact.getFirstName() + " " + contact.getLastName();
        Assert.assertEquals(actualTitle.toLowerCase(), expectedTitle.toLowerCase());

    }
}
