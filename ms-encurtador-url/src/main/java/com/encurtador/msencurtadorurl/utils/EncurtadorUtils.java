package com.encurtador.msencurtadorurl.utils;

import java.security.SecureRandom;

public final class EncurtadorUtils {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public EncurtadorUtils() {
        super();
    }

    public static String generateString(int length) {
        final SecureRandom random = new SecureRandom();
        final StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return builder.toString();
    }
}
