package com.example.mylearnenglish;

public class mainFuction {

    public static boolean check(String s1, String s2) {
        if (s1.trim().toLowerCase().equals(s2.trim().toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }
}
