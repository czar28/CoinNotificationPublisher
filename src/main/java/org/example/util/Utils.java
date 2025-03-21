package org.example.util;

public class Utils {

    private static int userId = 0;

    public static synchronized int getUserId() {
        return ++userId;
    }
}
