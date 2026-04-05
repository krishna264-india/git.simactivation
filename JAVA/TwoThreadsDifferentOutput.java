public class TwoThreadsDifferentOutput {

    public static void main(String[] args){
        Runnable printnumber= ()->{
           for(int i=1;i<=5;i++){
            System.out.println(Thread.currentThread().getName()+"prints number"+i);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
           }
        };

        Runnable printletters= ()->{
         for(char c='A';c<='E',c++){
            System.out.println(Thread.currentThread().getName()+"print letter"+ c);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
         }
        };

        Thread t1=new Thread(NumberPrinter,"Number-Thread");
        Thread t2=new Thread(printletters,"Letter-Thread");

        t1.start();
        t2.start();
    }
    
}
