public class SumOfTwoNumber extends Thread{
   private final int a;
    private final int b;
    public SumOfTwoNumber(int a,int b){
        this.a=a;
        this.b=b;
    }
    @Override
    public void run(){
        int sum=a+b;
        System.out.println(Thread.currentThread().getName()+"=> sum"+sum);
        try{
            Thread.sleep(200);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        SumOfTwoNumber thread=new SumOfTwoNumber(20,50);
        thread.setName("Sum-Thread");
        thread.start();

        int a = 20;
        int b = 30;
        Runnable numberTask= ()->{
        int sum=a+b;
        System.out.println(Thread.currentThread().getName()+ "=> Sum"+sum);
       };
        Thread thread1= new Thread(numberTask, "Sum-Thread");
        thread1.start();
    }
}
