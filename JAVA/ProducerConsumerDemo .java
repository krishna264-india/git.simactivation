import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerDemo  {
    
    public static void main(String[] args) {
        SharedBuffer sharedBuffer=new SharedBuffer(5);
        // Producer thread
        Thread producerThread=new Thread(()->{
            for(int i=1;i<=10;i++){
                try{
                    sharedBuffer.producer(i);
                    Thread.sleep(100); // simulate time taken to produce
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        // Consumer thread
        Thread consumerThread=new Thread(()->{
            for(int i=1;i<=10;i++){
                try{
                    sharedBuffer.consumer();
                    Thread.sleep(150); // simulate time taken to consume
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        producerThread.start();
        consumerThread.start();
        try{
            producerThread.join();
            consumerThread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
       
    }
}
 class SharedBuffer{
    private Queue<Integer> buffer=new LinkedList<>();
    private int capacity;
    public SharedBuffer(int capacity){
        this.capacity=capacity;
    }
    // producer method
    public synchronized void producer(int value) throws InterruptedException{
        // wait until buffer has space
        while(buffer.size()==capacity){
            System.out.println("Buffer is full, producer is waiting...");
            wait();
        }
        buffer.add(value);
        System.out.println("Produced: "+value);
        notify();
    }
    // consumer method
    public synchronized int consumer() throws InterruptedException{
        while(buffer.isEmpty()){
            System.out.println("Buffer is empty, consumer is waiting...");
            wait();
        }
        int value=buffer.poll();
        System.out.println("Consumed: "+value);
        notify();
        return value;
    }
 }
