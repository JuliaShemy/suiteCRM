package dto;

import com.github.javafaker.Faker;

public class AccountFactory {
    public static Account getAccount(String type, String industry) {
        Faker faker = new Faker();
        return new Account(faker.company().name()+ "_" + System.currentTimeMillis(),
                faker.phoneNumber().phoneNumber(),
                faker.phoneNumber().phoneNumber(),
                faker.internet().url(),
                faker.address().streetAddress(),
                type,
                industry,
                faker.address().city(),
                faker.address().state(),
                faker.address().zipCode(),
                faker.address().country(),
                faker.lorem().paragraph());
    }
}