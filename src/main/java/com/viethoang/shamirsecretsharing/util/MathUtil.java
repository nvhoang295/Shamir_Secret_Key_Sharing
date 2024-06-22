/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viethoang.shamirsecretsharing.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author Lenovo
 */
@RequiredArgsConstructor
public class MathUtil {
    private static final int BASE_2 = 2;
    private static final String BIT_ONE = "1";
    private static final int MIN_BIT_LEN = 64;
    
    private final Random random;
    
    private boolean isPrime(BigInteger n, int numIterations) {
        if (n.compareTo(BigInteger.valueOf(2)) < 0)
            return false;
        if (n.compareTo(BigInteger.valueOf(2)) == 0)
            return true;
        if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO))
            return false;

        BigInteger d = n.subtract(BigInteger.ONE);
        int s = 0;
        while (d.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            d = d.divide(BigInteger.valueOf(2));
            s++;
        }

        for (int i = 0; i < numIterations; i++) {
            BigInteger a = new BigInteger(n.bitLength(), random);
            if (a.compareTo(BigInteger.valueOf(2)) < 0 || 
                    a.compareTo(n.subtract(BigInteger.valueOf(2))) > 0
            ) 
                a = a.mod(n.subtract(BigInteger.valueOf(3)))
                        .add(BigInteger.valueOf(2));
            
            BigInteger x = modPow(a, d, n); // a.modPow(d, n);
            if (x.equals(BigInteger.ONE) || x.equals(n.subtract(BigInteger.ONE)))
                continue;
            
            boolean isComposite = true;
            for (int r = 1; r < s; r++) {
                x = modPow(x, BigInteger.TWO, n); //  x.modPow(BigInteger.valueOf(2), n);
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
    
    public BigInteger findNextPrime(BigInteger value) {
        int bitLength = value.bitLength() > MIN_BIT_LEN ? value.bitLength() : MIN_BIT_LEN;
        
        BigInteger start = new BigInteger(BIT_ONE.repeat(bitLength + getRandomValue(1, 10)), BASE_2);
        BigInteger end = new BigInteger(BIT_ONE.repeat(bitLength + 15), BASE_2);
        
        BigInteger primeCandidate = start;
        while (primeCandidate.compareTo(end) < 0) {
            if (isPrime(primeCandidate, 5)) return primeCandidate;
            primeCandidate = primeCandidate.add(BigInteger.ONE);
        }
        
        return BigInteger.valueOf(-1);
    }
    
    public int getRandomValue(int begin, int end) {
        return (int) (Math.random() * (end - begin) + begin);
    }
        
    public static BigInteger modPow(
            BigInteger x,
            BigInteger n,
            BigInteger m
    ) {
        BigInteger result = BigInteger.ONE;
        BigInteger base = x.mod(m);

        while (n.compareTo(BigInteger.ZERO) > 0) {
            if (n.testBit(0)) {
                result = result.multiply(base).mod(m);
            }
            base = base.multiply(base).mod(m);
            n = n.shiftRight(1);
        }
        
        return result;
    }
    
//    public static BigInteger modInverse(
//            BigInteger r0,
//            BigInteger r1
//    ) {
//        BigInteger[] q = new BigInteger[1000];
//        BigInteger[] s = new BigInteger[1000];
//        BigInteger[] t = new BigInteger[1000];
//
//        BigInteger m = r0;
//
//        BigInteger r2 = BigInteger.valueOf(-1);
//        BigInteger i = BigInteger.ZERO;
//        int intValue;
//        while (r2.compareTo(BigInteger.ZERO) != 0) {
//            intValue = i.intValue();
//
//            q[intValue] = r0.divide(r1);
//            r2 = r0.mod(r1);
//
//            switch (intValue) {
//                case 0 -> {
//                    s[intValue] = BigInteger.ONE;
//                    t[intValue] = BigInteger.ZERO;
//                    break;
//                }
//                case 1 -> {
//                    s[intValue] = BigInteger.ZERO;
//                    t[intValue] = BigInteger.ONE;
//                    break;
//                }
//                case 2 -> {
//                    s[intValue] = (s[intValue - 2].subtract(q[intValue - 1])).multiply(s[intValue - 1]);
//                    t[intValue] = (t[intValue - 2].subtract(q[intValue - 1])).multiply(t[intValue - 1]);
//                    break;
//                }
//            }
//
//            r0 = r1;
//            r1 = r2;
//            i = i.add(BigInteger.ONE);
//        }
//        intValue = i.intValue();
//        s[intValue] = (s[intValue - 2].subtract(q[intValue - 1])).multiply(s[intValue - 1]);
//        t[intValue] = (t[intValue - 2].subtract(q[intValue - 1])).multiply(t[intValue - 1]);
//
//        return t[intValue].compareTo(BigInteger.ZERO) < 0
//                ? t[intValue].add(m)
//                : t[intValue];
//    }

    public static BigInteger modInverse(BigInteger r0, BigInteger r1) {
        BigInteger m = r0;
        BigInteger[] q = new BigInteger[10000];
        BigInteger[] s = new BigInteger[10000];
        BigInteger[] t = new BigInteger[10000];

        int i = 0;
        BigInteger r2 = BigInteger.valueOf(-1);
        while (!r2.equals(BigInteger.ZERO)) {
            q[i + 1] = r0.divide(r1);
            r2 = r0.mod(r1);

            switch (i) {
                case 0 -> {
                    s[i] = BigInteger.ONE;
                    t[i] = BigInteger.ZERO;
                }
                case 1 -> {
                    s[i] = BigInteger.ZERO;
                    t[i] = BigInteger.ONE;
                }
                default -> {
                    s[i] = s[i - 2].subtract(q[i].multiply(s[i - 1]));
                    t[i] = t[i - 2].subtract(q[i].multiply(t[i - 1]));
                }
            }

            r0 = r1;
            r1 = r2;
            ++i;
        }
        s[i] = s[i - 2].subtract(q[i].multiply(s[i - 1]));
        t[i] = t[i - 2].subtract(q[i].multiply(t[i - 1]));

        BigInteger result = t[i].compareTo(BigInteger.ZERO) < 0 ? t[i].add(m) : t[i];

        return result;
    }
    
    public static void main(String[] args) {
//        System.out.println(new BigInteger("1".repeat(4), 2));
System.out.println(modInverse(BigInteger.valueOf(29), BigInteger.valueOf(8)));
        for (int i = 0; i <= 10; ++i) {
//            System.out.println(modPow(BigInteger.valueOf(2), BigInteger.valueOf(i), BigInteger.valueOf(9)));
        }
    }
    
}
