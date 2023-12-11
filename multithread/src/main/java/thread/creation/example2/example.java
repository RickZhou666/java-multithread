package thread.creation.example2;

/**
 * @Author: Rick
 * @Date: 2023/12/11 10:55
 */
public class example {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Thread thread = new NewThread();
            thread.start();
        }

    }

    private static class NewThread extends Thread{

        @Override
        public void run() {
            System.out.println("Hello from " + this.getName());
        }
    }
}
