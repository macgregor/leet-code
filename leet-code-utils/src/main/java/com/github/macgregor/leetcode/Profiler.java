package com.github.macgregor.leetcode;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@ToString
@Accessors(fluent = true)
public class Profiler {
    @ToString.Exclude
    private OnlyOnce initialize = new OnlyOnce();

    @ToString.Exclude
    private OnlyOnce finalize = new OnlyOnce();

    @Getter private Optional<Long> startingMemory = Optional.empty();
    @Getter private Optional<Long> endingMemory = Optional.empty();
    @Getter private Optional<Long> startTime = Optional.empty();
    @Getter private Optional<Long> endTime = Optional.empty();
    @Getter private Optional<AtomicLong> iterations = Optional.empty();
    @Getter private Optional<AtomicLong> comparisons = Optional.empty();

    public Profiler begin() {
        try {
            initialize.execute(completeLatch -> {
                Runtime runtime = Runtime.getRuntime();
                startingMemory = Optional.of(runtime.totalMemory() - runtime.freeMemory());
                startTime = Optional.of(System.nanoTime());
                completeLatch.countDown();
            });
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public Profiler end(){
        try {
            finalize.execute(completeLatch -> {
                Runtime runtime = Runtime.getRuntime();
                endingMemory = Optional.of(runtime.totalMemory() - runtime.freeMemory());
                endTime = Optional.of(System.nanoTime());
                completeLatch.countDown();
            });
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public Profiler iterate(){
        if(!iterations.isPresent()){
            iterations = Optional.of(new AtomicLong(0L));
        }
        iterations.get().getAndIncrement();
        return this;
    }

    public Profiler compare(){
        if(!comparisons.isPresent()){
            comparisons = Optional.of(new AtomicLong(0L));
        }
        comparisons.get().getAndIncrement();
        return this;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Performance Profiler - ");
        if(startTime.isPresent()){
            if(endTime.isPresent()){
                sb.append(" Duration: " + Duration.ofNanos(endTime.get() - startTime.get()));
            } else{
                sb.append(" Duration: Unfinished");
            }
        }
        if(startingMemory.isPresent()){
            if(endingMemory.isPresent()){
                sb.append(", Memory Used: " + (endingMemory.get() - startingMemory.get()));
            } else{
                sb.append(", Memory Used: Unfinished");
            }
        }
        if(iterations.isPresent()){
            sb.append(", Iterations: " + iterations.get().get());
        } else {
            sb.append(", Iterations: unknown");
        }
        if(comparisons.isPresent()){
            sb.append(", Comparisons: " + comparisons.get().get());
        } else{
            sb.append(", Comparisons: unknown");
        }

        return sb.toString();
    }
}
