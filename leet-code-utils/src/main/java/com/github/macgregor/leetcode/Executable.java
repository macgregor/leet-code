package com.github.macgregor.leetcode;

import java.util.concurrent.CountDownLatch;

@FunctionalInterface
public interface Executable{
    void execute(CountDownLatch completeLatch);
}
