/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viethoang.shamirsecretsharing;

/**
 *
 * @author vieth
 */


public record Pair<L, R> (
        L x,
        R fx
) {
    public Pair(L x, R fx) {
        this.x = x;
        this.fx = fx;
    }
}
