package cold;

/**
 * Created by cold on 2017/8/8.
 */

public class multiThread {
//    public static class myT extends Thread{
//
//        volatile private int count = 10;
//        @Override
//        public void run() {
//            try {
//
//                while (count > 0) {
//                    Thread.sleep(1000);
//                    count--;
//                    System.out.println(Thread.currentThread().getName()+"卖掉了票，还剩："+count);
//                }
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    public static class myThread implements Runnable{
        volatile private int count = 10;
        public void run() {
            try {

                while (count > 0) {
                    synchronized (this) {
                        count--;
                    }
                    System.out.println(Thread.currentThread().getName() + "卖掉了票，还剩：" + count);
                    Thread.sleep(1000);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        Runnable dz= new myThread();
        Thread t1 = new Thread(dz,"t1");
        Thread t2 = new Thread(dz,"t2");
        t1.start();
        t2.start();
    }
}
