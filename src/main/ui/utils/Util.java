package main.ui.utils;

import com.github.javafaker.Faker;

public class Util {
    public static String generatePWD() {
        Faker faker = new Faker();
        String password = faker.internet().password();
        return password;
    }
}
