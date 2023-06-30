package com.portiaxe.thread;

import java.util.ArrayList;
import java.util.List;

import static com.portiaxe.thread.ThreadUtil.sleep;
import static com.portiaxe.thread.ThreadUtil.waitForAllThreadsToComplete;

public class Main {
    private static final int MAX_QUEUE_CAPACITY = 5;

    public static void multipleProducerAndConsumer() {
        DataQueue dataQueue = new DataQueue(MAX_QUEUE_CAPACITY);
        int producerCount = 3;
        int consumerCount = 3;
        List<Thread> threads = new ArrayList<>();
        Producer producer = new Producer(dataQueue);
        for (int i = 0; i < producerCount; i++) {
            Thread producerThread = new Thread(producer);
            producerThread.start();
            threads.add(producerThread);
        }
        Consumer consumer = new Consumer(dataQueue);
        for (int i = 0; i < consumerCount; i++) {
            Thread consumerThread = new Thread(consumer);
            consumerThread.start();
            threads.add(consumerThread);
        }

        // let threads run for two seconds
        sleep(2000);

        // Stop threads
        producer.stop();
        consumer.stop();

        waitForAllThreadsToComplete(threads);
    }

    public static void main(String[] args) {
        multipleProducerAndConsumer();
    }
}
