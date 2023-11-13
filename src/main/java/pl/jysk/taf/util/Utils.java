package pl.jysk.taf.util;

import java.util.Random;

public class Utils {
    public static String generateRandomEmail() {
        int length = 10;
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        char[] username = new char[length];

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            username[i] = characters.charAt(index);
        }

        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "example.com", "test.com"};
        String domain = domains[random.nextInt(domains.length)];

        return new String(username) + "@" + domain;
    }

    public static String generatePassword() {
        int length = 8;
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password[i] = characters.charAt(index);
        }
        return new String(password);
    }
}
