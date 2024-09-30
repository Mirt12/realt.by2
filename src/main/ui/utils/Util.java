package main.ui.utils;

import com.github.javafaker.Faker;

public class Util {
    public static String generateEmail() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        return email;
    }
    public static String generatePassword() {
        Faker faker = new Faker();
        String password = faker.internet().password();
        return password;
    }
}
