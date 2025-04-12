package com.farhadTech.optional;

import java.util.Optional;
import java.util.Random;

public class OptionalDemo03 {
    public static void main(String[] args) {
        Optional<String> optionalMsg = sayHello();
        if (optionalMsg.isPresent()) { // if (!optionalMsg.isEmpty())
            System.out.println(optionalMsg.get().toUpperCase());
        }
    }
    public static Optional<String> sayHello() {
        int num = new Random().nextInt(10);
        System.out.println("Random number is " + num);
        String msg = null;
        if( num % 2 == 0 ) {
            msg = "Hello World";
        }
        return Optional.ofNullable(msg); // if the value is present returns the value, otherwise returns NullPointerException.
    }
}
/**
Note: Using Optional we are not getting rid of NullPointerExceptions. Using Optional we are handling the NullPointerException gracefully.
 **/