package com.kyee.thread.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * Created by yijun on 4/20/2017.
 */
@Slf4j
public class FourthWay {
    public static void main(String[] args) {
        log.info("Main Thread start here...");

//        Anonymous inner classes containing only one method should become lambdas
        Thread t = new Thread(() -> {
            for (int i = 10; i > 0 ; i--) {
                log.info("Tick Tick " + i);

                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    log.error("interrupted Exception : " + e);
                    // clean up state...
                    Thread.currentThread().interrupt();
                }
            }
        });

//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 10; i > 0 ; i--) {
//                    log.info("Tick Tick " + i);
//
//                    try {
//                        TimeUnit.MILLISECONDS.sleep(200);
//                    } catch (InterruptedException e) {
//                        log.error("interrupted Exception : " + e);
//                        // clean up state...
//                        Thread.currentThread().interrupt();
//                    }
//                }
//            }
//        });
        t.start();

        log.info("Main Thread end here...");
    }

    private FourthWay() {
        throw new IllegalAccessError("Utility class");
    }
}
