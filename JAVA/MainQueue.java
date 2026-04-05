public class MainQueue {
    public static void main(String[] args){
        CustomQueue queue = new CustomQueue(5);
        queue.add(10);
        queue.add(23);
        queue.add(1);
        queue.add(88);
        queue.add(123);

        queue.display();

    }
}
