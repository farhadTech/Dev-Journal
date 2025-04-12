package com.farhadTech.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamAPINullCheckTip {
    public static void main(String[] args) {
        // since List.of is immutable we need to create a Arrays of string using Arrays.asList()
        List<String> countries = Arrays.asList("USA", "India", null, "Canada", null, "UK", null, null, "Germany");
        List<String> capitalNames = countries
                .stream()
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("capitalNames: " + capitalNames);
    }
}
