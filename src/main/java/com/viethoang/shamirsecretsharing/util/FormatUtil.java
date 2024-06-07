/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viethoang.shamirsecretsharing.util;

import java.util.regex.Pattern;

/**
 *
 * @author Lenovo
 */
public class FormatUtil {
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^-?\\d+$");
    
    public static boolean isInteger(String s) {
        return INTEGER_PATTERN.matcher(s).matches();
    }
    
     public static void main(String[] args) {
        String test1 = "1234";
        String test2 = "12.34";
        String test3 = "abc123";

        System.out.println(test1 + " is integer: " + isInteger(test1));
        System.out.println(test3 + " is integer: " + isInteger(test3));        
        System.out.println(test3 + " is integer: " + isInteger(test2));

    }
}
