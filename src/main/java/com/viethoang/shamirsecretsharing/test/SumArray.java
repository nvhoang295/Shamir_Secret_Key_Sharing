/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viethoang.shamirsecretsharing.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Lenovo
 */
public class SumArray {
    private static final int NUM_THREADS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Example array
        int[] array = new int[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1; // For simplicity, fill array with 1s
        }
        
        long startTime = System.nanoTime();
        int totalSum = parallelSum(array);
        long endTime = System.nanoTime();
        
        System.out.println("Total sum: " + totalSum);
        System.out.println("Parallel execution time: " + (endTime - startTime) + " ns");
        
        startTime = System.nanoTime();
        int singleThreadSum = singleThreadSum(array);
        endTime = System.nanoTime();
        
        System.out.println("Single thread sum: " + singleThreadSum);
        System.out.println("Single thread execution time: " + (endTime - startTime) + " ns");
    }

    public static int parallelSum(int[] array) throws InterruptedException, ExecutionException {
        int length = array.length;
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        int chunkSize = (int) Math.ceil((double) length / NUM_THREADS);

        Future<Integer>[] futures = new Future[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, length);

            futures[i] = executor.submit(() -> {
                int sum = 0;
                for (int j = start; j < end; j++) {
                    sum += array[j];
                }
                return sum;
            });
        }

        int totalSum = 0;
        for (Future<Integer> future : futures) {
            totalSum += future.get();
        }

        executor.shutdown();
        return totalSum;
    }
    
    public static int singleThreadSum(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }
}

