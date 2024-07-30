package org.excercise;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Consumer consumer = new Consumer();
        consumer.accept(1);
        Thread.sleep(300000);
        consumer.accept(2);
        consumer.accept(3);
        consumer.accept(4);
        System.out.println(consumer.mean());
        System.out.println(consumer.show());
    }
}
