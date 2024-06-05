/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viethoang.shamirsecretsharing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author vieth
 */
public class ShamirSecretSharingApplication {
    private static final int p = 11;
    private static final int m = 3;
    private static final int t = 2;
    private static final int K = 3;
    private static final int[] x = { -99999, 1, 2, 3 };
    private static final int[] a = { K, 698 }; 
    
    public static int f(int x) {
        int ans = 0;
        for (int j = 1; j <= t - 1; ++j) {
            ans += a[j] * Math.pow(x, j);
        }
        ans += K;
        ans %= p;
        
        return ans;
    }
    
    public static int restoreK(
            List<Pair<Integer, Integer>> elems
    ) {
        int ans = 0;
        for (int j = 1; j <= t; ++j) {
            int temp = elems.get(j - 1).fx();
            for (int i = 1; i <= t; ++i) {
                if (i == j) continue;
                temp *= ((0 - x[i]) / (x[j] - x[i]));
            }
            ans += temp;
        }
        return ans > p ? ans % p : ans;
    }
    
    public static void main(String[] args) {
//        System.out.println("f(x[1]) = " + f(x[1]));
//        System.out.println("f(x[2]) = " + f(x[2]));
//        System.out.println("f(x[3]) = " + f(x[3]));
//        System.out.println("K = " + restoreK(List.of(
//                new Pair(x[1], f(x[1])),
//                new Pair(x[2], f(x[2]))
//        )));
       
        
        MainView.main(args);
    }
}
