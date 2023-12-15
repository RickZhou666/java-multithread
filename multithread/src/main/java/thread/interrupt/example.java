package thread.interrupt;

/**
 * @Author: Rick
 * @Date: 2023/12/11 12:03
 */
public class example {
    public static void main(String[] args) {
        Thread thread = new Thread(new BlockingTask());

        thread.start();

        thread.interrupt();
    }

    private static class BlockingTask implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                System.out.println("Exiting blocking method " + Thread.currentThread().getName());
            }
        }
    }
}
