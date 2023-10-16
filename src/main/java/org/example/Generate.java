package org.example;

import java.util.Random;

public class Generate {
    public static String generateRoute(String letters, int length){
        Random random = new Random();
        StringBuilder route = new StringBuilder();
        for (int i = 0; i < length; i++) {
            route.append(letters.charAt(random.nextInt(letters.length())));
        }
        return route.toString();
    }
}
