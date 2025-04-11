package com.farhadTech.optional;

import java.util.Random;

public class OptionalDemo01 {
    public static void main(String[] args) {
        String message = sayHello();
        if (message != null) {
            System.out.println(message.toUpperCase());
        }
    }

    public static String sayHello() {
        int num = new Random().nextInt(0, 100);
        System.out.println("Random number is: " + num);
        if (num % 2 == 0) {
            return "Hello World!";
        }
        return null;
    }
}
