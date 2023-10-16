package org.example;

import java.util.HashMap;
import java.util.Map;

import static org.example.Main.sizeToFreq;

public class RouteCounter implements Runnable {

    @Override
    public void run() {
        String route = Generate.generateRoute("RLRFR", 100);
        int countR = countR(route);
        synchronized (sizeToFreq){
            sizeToFreq.put(countR,sizeToFreq.getOrDefault(countR,0) + 1);
        }
    }

    private int countR(String route) {
        int count = 0;
        for (int i = 0; i < route.length(); i++) {
            if (route.charAt(i) == 'R') {
                count++;
            }

        }
        return count;

    }
}
