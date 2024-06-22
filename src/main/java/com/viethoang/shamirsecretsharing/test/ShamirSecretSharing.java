/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viethoang.shamirsecretsharing.test;

import com.viethoang.shamirsecretsharing.dto.Share;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Lenovo
 */
public class ShamirSecretSharing {
    private static final Random random = new SecureRandom();
//    private static final BigInteger PRIME = new BigInteger("208351617316091241234326746312124448251235562226470491514186331217050270460481");    
    private static final BigInteger PRIME = new BigInteger("31");


    // Function to compute the polynomial
    private static BigInteger evaluatePolynomial(BigInteger x, BigInteger[] coefficients) {
        BigInteger result = BigInteger.ZERO;
        for (int i = coefficients.length - 1; i >= 0; i--) {
            result = result.multiply(x).add(coefficients[i]).mod(PRIME);
        }
        return result;
    }

    // Function to generate random coefficients for the polynomial
    private static BigInteger[] generateCoefficients(BigInteger secret, int threshold) {
        BigInteger[] coefficients = new BigInteger[threshold];
        coefficients[0] = secret;
        for (int j = 1; j <= threshold - 1; j++) {
//            coefficients[j] = new BigInteger(PRIME.bitLength(), random).mod(PRIME);
//            coefficients[j] = BigInteger.valueOf(j);
            coefficients[j] = new BigInteger(PRIME.bitLength(), random).mod(PRIME);

        }
        return coefficients;
    }

    // Function to split the secret into shares
    public static List<Share> splitSecret(BigInteger secret, int numShares, int threshold) {
        BigInteger[] coefficients = generateCoefficients(secret, threshold);
        List<Share> shares = new ArrayList<>();
        for (int i = 1; i <= numShares; i++) {
            BigInteger x = BigInteger.valueOf(i);
            BigInteger y = evaluatePolynomial(x, coefficients);
            shares.add(Share.builder().x(x).y(y).build());
        }
        return shares;
    }

    // Function to reconstruct the secret from shares
    public static BigInteger reconstructSecret(List<Share> shares, int threshold) {
        BigInteger secret = BigInteger.ZERO;
        for (int j = 1; j <= threshold; j++) {
            BigInteger x_j = shares.get(j - 1).x();
            BigInteger y_j = shares.get(j - 1).y();

            BigInteger numerator = BigInteger.ONE;
            BigInteger denominator = BigInteger.ONE;
            for (int i = 1; i <= threshold; i++) {
                if (j == i) continue;
                
                BigInteger x_i = shares.get(i - 1).x();
                numerator = numerator.multiply(x_i.negate()).mod(PRIME);
                denominator = denominator.multiply(x_j.subtract(x_i)).mod(PRIME);
            }
            BigInteger term = y_j.multiply(numerator)
                    .multiply(denominator.modInverse(PRIME))
                    .mod(PRIME);
            secret = secret.add(term).mod(PRIME);
        }
        return secret;
    }

    public static void main(String[] args) {
        // Secret to be shared
//        BigInteger secret = new BigInteger("12345678901234567890");
//        System.out.println(secret.bitLength());
        BigInteger secret = new BigInteger("24");


        // Number of shares
        int numShares = 5;

        // Threshold to reconstruct the secret
        int threshold = 3;
        
        System.out.println("Initial secret: " + secret);
        
        // Split the secret
        List<Share> shares = splitSecret(secret, numShares, threshold);
        for (Share share : shares) {
            System.out.println("Share: x = " + share.x() + ", y = " + share.y());
        }

        // Reconstruct the secret from shares
        int offset = 1;
        List<Share> subsetOfShares = shares.subList(0 + offset, threshold + offset);
        BigInteger reconstructedSecret = reconstructSecret(subsetOfShares, threshold);
        System.out.println("Reconstructed Secret: " + reconstructedSecret);
        
        System.out.println(BigInteger.valueOf(7).modInverse(BigInteger.valueOf(11)));
    }
}

