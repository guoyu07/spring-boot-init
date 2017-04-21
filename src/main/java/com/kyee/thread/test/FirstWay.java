package com.kyee.thread.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * Created by yijun on 4/20/2017.
 */
@Slf4j
public class FirstWay {

    public static void main(String[] args) {
        log.info("Main Thread start here...");

        new FirstTask();
        new FirstTask();

        log.info("Main Thread end here...");
    }

    private FirstWay() {
        throw new IllegalAccessError("Utility class");
    }
}

@Slf4j
class FirstTask extends Thread{
    private static int count = 0;
    private int id;

    @Override
    public void run() {
        for (int i = 10; i > 0 ; i--) {
            log.info("<"+id+">"+ "Tick Tick " + i);

            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                log.error("interrupted Exception : " + e);
                // clean up state...
                Thread.currentThread().interrupt();
            }
        }
    }

    FirstTask(){
        this.id = count ++;
        this.start();
    }
}