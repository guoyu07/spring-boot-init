package com.kyee.thread.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * Created by yijun on 4/20/2017.
 */
@Slf4j
public class SecondWay {
    public static void main(String[] args) {
        log.info("Main Thread start here...");

        new SecondTask().start();

        Thread t = new SecondTask();
        t.start();

        log.info("Main Thread end here...");
    }

    private SecondWay() {
        throw new IllegalAccessError("Utility class");
    }
}

@Slf4j
class SecondTask extends Thread {
    private static int count = 0;
    private int id;

    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            log.info("<" + id + ">" + "Tick Tick " + i);

            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                log.error("interrupted Exception : " + e);
                // clean up state...
                Thread.currentThread().interrupt();
            }
        }
    }

    SecondTask() {
        this.id = count++;
    }
}