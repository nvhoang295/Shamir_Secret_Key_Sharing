/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viethoang.shamirsecretsharing.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Lenovo
 */
public class MultiThreadedSum {
    private static final int ARRAY_SIZE = 1_000_000_000;
    private static final int NUM_THREADS = 16; // Adjusted to match your CPU's capability

    public static void main(String[] args) {
        int[] array = new int[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = i + 1;
        }

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        Future<Integer>[] results = new Future[NUM_THREADS];

        int partSize = ARRAY_SIZE / NUM_THREADS;
        for (int i = 0; i < NUM_THREADS; i++) {
            int start = i * partSize;
            int end = (i == NUM_THREADS - 1) ? ARRAY_SIZE : start + partSize;
            results[i] = executor.submit(new SumTask(array, start, end));
        }
        
        long start = System.currentTimeMillis();
        int totalSum = 0;
        for (Future<Integer> result : results) {
            try {
                totalSum += result.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        
        long end = System.currentTimeMillis();
        System.out.println("Total Sum: " + totalSum);
        System.out.println("Excecution time: " + (end - start));
        
       int totalSum2 = 0;
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < ARRAY_SIZE; ++i) {
            totalSum2 += i;
        }
        long end2 = System.currentTimeMillis();
        System.out.println("Total Sum: " + totalSum2);
        System.out.println("Excecution time: " + (end2 - start2));
    }
}

class SumTask implements Callable<Integer> {
    private final int[] array;
    private final int start;
    private final int end;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        System.out.println("Current thread id: " + Thread.currentThread().getName());
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }
}
