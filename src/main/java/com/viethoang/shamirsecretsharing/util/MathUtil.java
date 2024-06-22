/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viethoang.shamirsecretsharing.util;

import java.math.BigInteger;
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
        
    public static BigInteger modPow(BigInteger x, BigInteger n, BigInteger m) {
        BigInteger result = BigInteger.ONE;
        BigInteger base = x.mod(m); // lấy x modulo m ban đầu

        while (n.compareTo(BigInteger.ZERO) > 0) {
            // nếu bit cuối cùng của n là 1
            if (n.testBit(0)) {
                result = result.multiply(base).mod(m); // result = (result * base) % m
            }
            base = base.multiply(base).mod(m); // base = (base * base) % m
            n = n.shiftRight(1); // dịch phải n (tương đương n = n / 2)
        }
        
        return result;
    }
    
    public static void main(String[] args) {
//        System.out.println(new BigInteger("1".repeat(4), 2));
        for (int i = 0; i <= 10; ++i) {
            System.out.println(modPow(BigInteger.valueOf(2), BigInteger.valueOf(i), BigInteger.valueOf(9)));
        }
    }
    
}
