public class Mutlithreading {

    static class NumberPrinter extends Thread {
        private final String threadName;

        public NumberPrinter(String threadName){
            this.threadName = threadName;
        }

        @Override
        public void run(){
            for(int i=0;i<5;i++){
                System.out.println(threadName + "print"+i);
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                     System.out.println(threadName + " interrupted.");
                }
            }

        }
    }
    public static void main(String [] args){
      NumberPrinter thread1 = new NumberPrinter("Thread-1");
      NumberPrinter thread2 = new NumberPrinter("Thread-2");
      thread1.start();
      thread2.start();
// by using runnable interface
      Runnable task =() -> {
         String threadName = Thread.currentThread().getName();
         for(int i=0;i<5;i++){
            System.out.println(threadName+"print"+i);
            try{
                Thread.sleep(400);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
         }
      };
    }
    
}
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;

    Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                queue.put(i);
                System.out.println("Produced: " + i);
                Thread.sleep(1000);// Simulate time taken to produce an item
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer item = queue.take();// Blocks if queue is empty
                System.out.println("Consumed: " + item);
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();
    }
}

