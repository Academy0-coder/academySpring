package com.vlc2.academy.library.utility;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringUtility {

    public static String toUpperCamelCase(String string){
         return Arrays.stream(string.split(" "))
                .map(word -> StringUtility.capitalizeFirst(word))
                .collect(Collectors.joining(" "));

    }

    public static String capitalizeFirst (String string){
        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }

}
