package com.metrowest.util;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/// Random password generation utility.
public class PasswordGenerator
{ private PasswordGenerator(){}

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String OTHER_CHAR = "!@#$%&*()_+-=[]?";
    private static final String PASSWORD_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;

    private static final SecureRandom random = new SecureRandom();

    public static String generateRandomPassword(int length)
    {
        if (length < 4) { throw new IllegalArgumentException("Length must be at least 4 chars."); }

        StringBuilder sb = new StringBuilder(length);
        sb.append(CHAR_LOWER.charAt(random.nextInt(CHAR_LOWER.length())));
        sb.append(CHAR_UPPER.charAt(random.nextInt(CHAR_UPPER.length())));
        sb.append(NUMBER.charAt(random.nextInt(NUMBER.length())));
        sb.append(OTHER_CHAR.charAt(random.nextInt(OTHER_CHAR.length())));

        for (int i = 4; i < length; i++)
        {
            int rndCharAt = random.nextInt(PASSWORD_ALLOW_BASE.length());
            sb.append(PASSWORD_ALLOW_BASE.charAt(rndCharAt));
        }

        List<Character> charList = sb.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Collections.shuffle(charList);

        return charList.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
