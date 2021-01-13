   import java.util.concurrent.ExecutorService;
   import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

   public class AddAPenny extends Thread {
     private static PiggyBank piggy = new PiggyBank();

     public void run() {
       piggy.deposit(1);
     }

    public static void main(String [] args) {
      ExecutorService executor = Executors.newCachedThreadPool();
      for (int i=0; i < 100; i++) {
        executor.execute(new AddAPenny());
//        AddAPenny aap = new AddAPenny();
//        aap.start();
      }
      executor.shutdown();//No more threads add into it
      while(!executor.isTerminated()) { // wait until all tasks are finished
      	Thread.yield();
      }
      System.out.println("Balance = " + piggy.getBalance());
    }
  }

  class PiggyBank {
    private int balance = 0;
    private Lock lock = new ReentrantLock();
    public int getBalance() {
      return balance;
    }
    public void deposit(int amount) {
    	lock.lock();
    	try {
    		int newBalance = balance + amount;
    	    Thread.yield();//When one thread wants the other thread to do something
    	    balance = newBalance;
    	} finally {//Guarantee Run unlock
    	      lock.unlock();
    	}
    }
  }