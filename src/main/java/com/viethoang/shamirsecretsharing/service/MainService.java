/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viethoang.shamirsecretsharing.service;

import com.viethoang.shamirsecretsharing.dto.Share;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface MainService {
    
    List<Share> splitSecret(
            BigInteger secret, 
            BigInteger prime, 
            int numShares, 
            int threshold
    );
    
    BigInteger reconstructSecret(
            List<Share> shares, 
            BigInteger prime, 
            int threshold
    );
    
}
