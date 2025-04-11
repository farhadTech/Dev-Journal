package com.farhadTech.optional;

public class OptionalDemo01 {
    public static void main(String[] args) {
        String message = sayHello();
        System.out.println(message.toUpperCase());
    }

    public static String sayHello() {
        String message = "Hello World!";
        return message;
    }
}
