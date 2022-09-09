package com.example.springboot.utils;

public final class StringHelper {

    public static Boolean isNullOrEmpty(String s) {
        return s==null || s.isEmpty();
    }

    public static Boolean isNullOrWhiteSpace(String s) {
        return s==null || s.isBlank();
    }

    public static Boolean isValorized(String s) {
        return !(isNullOrEmpty(s) || isNullOrWhiteSpace(s));
    }
}
