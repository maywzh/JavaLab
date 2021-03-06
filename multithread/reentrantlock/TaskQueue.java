package com.maywzh.reen;

import java.util.*;
import java.util.concurrent.*;

class TaskQueue {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<String> queue = new LinkedList<>();

    public void addTask(String s) {
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String getTask() {
        // if (condition.await(1, TimeUnit.SECOND)) {
        // // 被其他线程唤醒
        // } else {
        // // 指定时间内没有被其他线程唤醒
        // }

        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }
}