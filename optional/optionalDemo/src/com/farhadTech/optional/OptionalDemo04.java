package com.farhadTech.optional;

import java.util.Optional;
import java.util.Random;

public class OptionalDemo04 {
    public static void main(String[] args) {
        Optional<String> res = sayHello();
//        if (!res.isEmpty()) {
//            res.get().toUpperCase();
//        }
        // If a value is present perform the given action with the value, otherwise does nothing.
        res.ifPresent(msg -> System.out.println("ifPresent: " + res.get().toUpperCase()));

        // If a value is present perform the given action with the value, otherwise given empty.
        res.ifPresentOrElse(msg -> System.out.println("ifPresentOrElse: " + res.get().toUpperCase()),
                () -> System.out.println("Value is absent."));

        // If a value is present returns the value otherwise returns other.
        String msg1 = res.orElse("Value is absent");
        System.out.println("orElse: " + msg1);

        // If a value is present returns the value otherwise returns the value produced by the supplier function.
        String msg2 = res.orElse("Value is absent");
        System.out.println("orElseGet: " + msg2);

//        String msg3 = res.orElseThrow();
//        String msg3 = res.orElseThrow(() -> new IllegalStateException("Value is absent"));
//        System.out.println("orElseThrow: " + msg3);

        Optional<String> mapOptionalStr = res.map(input -> input.toUpperCase());
        System.out.println("mapOptionalStr: " + mapOptionalStr);

        Optional<String> filterOptionalStr = res.filter(value -> value.length() > 5);
        System.out.println("filterOptionalStr: " + filterOptionalStr);
    }

    public static Optional<String> sayHello() {
        int num = new Random().nextInt(100);
        System.out.println("Random number is " + num);
        String msg = null;
        if (num % 2 == 0) {
            msg = "number is even";
        }
        return Optional.ofNullable(msg);
    }
}
