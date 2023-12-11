package thread.creation.example1;

/**
 * @Author: Rick
 * @Date: 2023/12/9 14:20
 */
public class example {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("we are in thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Current thread priority id " + Thread.currentThread().getPriority());
            }
        });

        thread.setName("New worker Thread");
        // priority [1, 10]
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread");
        thread.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread");

    }
}
