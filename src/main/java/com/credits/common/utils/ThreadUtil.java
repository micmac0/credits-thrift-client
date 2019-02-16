package com.credits.common.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

 //Utility class for multithreading purposes
public class ThreadUtil {

    public static boolean shutdownAndAwaitTermination(ExecutorService service, long timeout, TimeUnit unit) {
        long halfTimeoutNanos = unit.toNanos(timeout) / 2L;
        service.shutdown();

        try {
            if(!service.awaitTermination(halfTimeoutNanos, TimeUnit.NANOSECONDS)) {
                service.shutdownNow();
                service.awaitTermination(halfTimeoutNanos, TimeUnit.NANOSECONDS);
            }
        } catch (InterruptedException var7) {
            Thread.currentThread().interrupt();
            service.shutdownNow();
        }

        return service.isTerminated();
    }


}
