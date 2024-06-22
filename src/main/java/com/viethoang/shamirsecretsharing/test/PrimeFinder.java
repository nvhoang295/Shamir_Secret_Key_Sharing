/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viethoang.shamirsecretsharing.test;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Lenovo
 */
public class PrimeFinder {
    // Miller-Rabin primality test
    public static boolean isPrime(BigInteger n, int numIterations) {
        if (n.compareTo(BigInteger.valueOf(2)) < 0)
            return false;
        if (n.compareTo(BigInteger.valueOf(2)) == 0)
            return true;
        if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO))
            return false;

        BigInteger d = n.subtract(BigInteger.ONE); // d = n - 1
        int s = 0;
        while (d.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            d = d.divide(BigInteger.valueOf(2));
            s++;
        }

        Random rand = new Random();
        for (int i = 0; i < numIterations; i++) {
            BigInteger a = new BigInteger(n.bitLength(), rand);
            if (a.compareTo(BigInteger.valueOf(2)) < 0 || 
                    a.compareTo(
                            n.subtract(BigInteger.valueOf(2))
                    ) > 0
            ) 
                a = a.mod(n.subtract(BigInteger.valueOf(3)))
                        .add(BigInteger.valueOf(2));
            
            BigInteger x = a.modPow(d, n);
            if (x.equals(BigInteger.ONE) || x.equals(n.subtract(BigInteger.ONE)))
                continue;
            boolean isComposite = true;
            for (int r = 1; r < s; r++) {
                x = x.modPow(BigInteger.valueOf(2), n);
                if (x.equals(BigInteger.ONE))
                    return false;
                if (x.equals(n.subtract(BigInteger.ONE))) {
                    isComposite = false;
                    break;
                }
            }
            if (isComposite)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        BigInteger start = new BigInteger("1234567890");
        BigInteger end = new BigInteger("9999999999");
        
        BigInteger primeCandidate = start;
        while (primeCandidate.compareTo(end) <= 0) {
            if (isPrime(primeCandidate, 5)) {
                System.out.println("Large Prime Found: " + primeCandidate);
                break; // You may remove this if you want to find all primes in the range
            }
            primeCandidate = primeCandidate.add(BigInteger.ONE); // Move to the next candidate
        }
        
        System.out.println(BigInteger.valueOf(17).bitLength());
    }
}
