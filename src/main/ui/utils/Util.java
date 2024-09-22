package main.ui.utils;

import com.github.javafaker.Faker;

public class Util {
    public static String generateEmail() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        return email;
    }
}
