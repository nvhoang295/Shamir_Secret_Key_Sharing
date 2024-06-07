/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viethoang.shamirsecretsharing.dto;

import java.math.BigInteger;
import lombok.Builder;

/**
 *
 * @author Lenovo
 */
@Builder
public record Share(
        BigInteger x,
        BigInteger y
) {
    
}
