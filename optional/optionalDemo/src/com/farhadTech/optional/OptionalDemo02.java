package com.farhadTech.optional;

import java.util.Optional;
import java.util.Random;

public class OptionalDemo02 {
    public static void main(String[] args) {
        Optional<String> OptionalMsg = sayHello2();
        if (OptionalMsg.isPresent()) {
            System.out.println(OptionalMsg.get().toUpperCase());
        }
    }
    public static Optional<String> sayHello2() {
        int num = new Random().nextInt(0, 100);
        System.out.println("Random number is: " + num);
        String message;
        if (num % 2 == 0) {
            message = "Hello World";
            return Optional.of(message); // returns an Optional describing the given value, otherwise returns null
        }
        return Optional.empty();
    }
}
