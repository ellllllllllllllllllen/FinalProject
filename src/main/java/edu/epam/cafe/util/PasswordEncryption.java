package edu.epam.cafe.util;

import java.util.Base64;

public class PasswordEncryption {
    public static String encrypt(String string) {
        return Base64.getEncoder().encodeToString(string.getBytes());
    }

    public static String decrypt(String string) {
        byte[] decrypt = Base64.getDecoder().decode(string.getBytes());
        String decryptString = new String(decrypt);
        return decryptString;
    }
}
