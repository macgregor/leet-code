package com.github.macgregor.leetcode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class OnlyOnce {
    AtomicBoolean wasRun = new AtomicBoolean(false);
    CountDownLatch completeLatch = new CountDownLatch(1);

    public void execute(Executable executable) throws InterruptedException {
        if (!wasRun.getAndSet(true)) {
            executable.execute(completeLatch);
        } else {
            completeLatch.await();
        }
    }
}
