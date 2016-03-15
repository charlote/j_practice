public class SimpleThread
{
    public static void main(String[] args){
        Runnable job = new MyRunnable();
        Thread a = new Thread(job);
        Thread b = new Thread(job);
        a.start();
        b.start();

        System.out.println("go back main thread!!");
    }
}
class MyRunnable implements Runnable
{
    private int balance = 0;

    public void run(){
        for(int i=0;i<50;i++){
            go();
            System.out.println("balance = " + balance);
        }
    }
    private void go(){
        doMore();
    }
    private synchronized void doMore(){
            int i = balance;
            balance = i + 1;
    }
}

