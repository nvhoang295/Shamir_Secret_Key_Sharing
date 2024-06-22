/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viethoang.shamirsecretsharing.service;

import com.viethoang.shamirsecretsharing.dto.Share;
import com.viethoang.shamirsecretsharing.util.MathUtil;
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
public class MainServiceImpl implements MainService {
    private final Random random;
    
    @Override
    public List<Share> splitSecret(
            BigInteger secret, 
            BigInteger prime, 
            int numShares, 
            int threshold
    ) {
        BigInteger[] coefficients = generateCoefficients(secret, prime, threshold);
        List<Share> shares = new ArrayList<>();
        for (int i = 1; i <= numShares; i++) {
            BigInteger x = BigInteger.valueOf(i);
            BigInteger y = evaluatePolynomial(x, prime, coefficients);
            shares.add(Share.builder().x(x).y(y).build());
        }
        return shares;
    }
    
    private BigInteger[] generateCoefficients(
            BigInteger secret, 
            BigInteger prime, 
            int threshold
    ) {
        BigInteger[] coefficients = new BigInteger[threshold];
        coefficients[0] = secret;
        for (int j = 1; j <= threshold - 1; j++)
            coefficients[j] = new BigInteger(prime.bitLength(), random).mod(prime);
        
        return coefficients;
    }
    
    private BigInteger evaluatePolynomial(
            BigInteger x, 
            BigInteger prime, 
            BigInteger[] coefficients
    ) {
        BigInteger result = coefficients[0];
        for (int j = 1; j <= coefficients.length - 1; ++j) 
            result = result.add(
                    coefficients[j].multiply(
                            MathUtil.modPow(x, BigInteger.valueOf(j), prime) //x.modPow(BigInteger.valueOf(j), prime)
                    )
            );
        
        return result;
    }

    
    @Override
    public BigInteger reconstructSecret(
            List<Share> shares, 
            BigInteger prime,  
            int threshold
    ) {
        BigInteger secret = BigInteger.ZERO;
        for (int j = 1; j <= threshold; j++) {
            BigInteger x_j = shares.get(j - 1).x();
            BigInteger y_j = shares.get(j - 1).y();

            BigInteger numerator = BigInteger.ONE;
            BigInteger denominator = BigInteger.ONE;
            for (int i = 1; i <= threshold; i++) {
                if (j == i) continue;
                
                BigInteger x_i = shares.get(i - 1).x();
                numerator = numerator.multiply(x_i.negate()).mod(prime);
                denominator = denominator.multiply(x_j.subtract(x_i)).mod(prime);
            }
            BigInteger term = y_j.multiply(numerator)
                                .multiply(MathUtil.modInverse(prime, denominator) )
                                .mod(prime);
            secret = secret.add(term).mod(prime);
        }
        return secret;
    }
   
    
}
