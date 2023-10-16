package org.example;


import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();

    public static void main(String[] args) {

        Thread[] threads = new Thread[1000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new RouteCounter());
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int frequentSize = 0;
        int frequentCount = 0;
        System.out.println("Количество повторений: ");
        for (Map.Entry<Integer,Integer> entry : sizeToFreq.entrySet()){
            int size = entry.getKey();
            int count = entry.getValue();
            System.out.println(size + " (" + count + " раз)");
            if(count > frequentCount){
                frequentCount = count;
                frequentSize = size;
            }
        }
        System.out.println("Самое частое количество повторений: " + frequentSize + "(встретилось " + frequentCount + " раз)");

    }

}