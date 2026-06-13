package tests;

import dto.Contact;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewContactTest extends BaseTest{
    String uniqueId = String.valueOf(System.currentTimeMillis());
       Contact contact = Contact.builder()
               .salutation("Mr.")
               .firstName("Test_" + uniqueId)
               .lastName("User")
               .officePhone("89120254554")
               .mobile("89990001122")
               .jobTitle("QA")
               .accountName("Test Account")
               .department("QA")
               .fax("123456789")
               .city("Moscow")
               .stateRegion("Test")
               .postalCode("123456")
               .country("Russia")
               .address("Test")
               .description("Test")
               .assigned_to("Test")
               .leadSource("Mail")
               .build();
    @Test(description = "Проверка добавдения нового контакта",
            testName = "Новый контакт")
    @Description("Проверка добавления нового контакта")
    public void checkAddNewCustomer() throws InterruptedException {
        loginStep.auth("will", "will")
                .goToCreateContact()
                .addNewContact(contact);
        newContactPade.clickSave();

        String actualTitle = newContactPade.checkNewContact();
        String expectedTitle = contact.getSalutation() + " " + contact.getFirstName() + " " + contact.getLastName();
        Assert.assertEquals(actualTitle.toLowerCase(), expectedTitle.toLowerCase());

    }
}
