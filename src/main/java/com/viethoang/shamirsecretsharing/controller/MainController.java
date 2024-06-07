/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viethoang.shamirsecretsharing.controller;

import com.viethoang.shamirsecretsharing.dto.Share;
import com.viethoang.shamirsecretsharing.service.MainService;
import java.math.BigInteger;
import java.util.List;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author Lenovo
 */
@RequiredArgsConstructor
public class MainController {
    private final MainService service;
    
    public List<Share> splitSecret(
            BigInteger secret, 
            BigInteger prime, 
            int numShares, 
            int threshold
    ) {
       return service.splitSecret(secret, prime, numShares, threshold);
    }
    
    public BigInteger reconstructSecret(
            List<Share> shares, 
            BigInteger prime, 
            int threshold
    ) {
        return service.reconstructSecret(shares, prime, threshold);
    }
}
