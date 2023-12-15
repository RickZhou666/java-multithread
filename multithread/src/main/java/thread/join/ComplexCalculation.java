package thread.join;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Rick
 * @Date: 2023/12/14 16:53
 */

public class ComplexCalculation {
    public static void main(String[] args) throws InterruptedException {
        ComplexCalculation obj = new ComplexCalculation();
        BigInteger base1 = new BigInteger("10");
        BigInteger power1 = new BigInteger("1000");
        BigInteger base2 = new BigInteger("77");
        BigInteger power2 = new BigInteger("7777");
        System.out.println(obj.calculateResult(base1, power1, base2, power2));
    }
    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws InterruptedException {
        BigInteger result = BigInteger.ZERO;
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */
        PowerCalculatingThread thread1 = new PowerCalculatingThread(new BigInteger("10"), new BigInteger("1000"));
        PowerCalculatingThread thread2 = new PowerCalculatingThread(new BigInteger("77"), new BigInteger("7777"));

        List<Thread> threads = Arrays.asList(thread1, thread2);

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }


        for (Thread thread : threads) {
            result = result.add( ( (PowerCalculatingThread) thread).getResult());
        }
        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
           /*
           Implement the calculation of result = base ^ power
           */
            this.result = calculate();
        }

        private BigInteger calculate() {
            BigInteger tempResult = this.result;
            for (BigInteger i = this.power; i.compareTo(BigInteger.ZERO) > 0; i = i.subtract(BigInteger.ONE)) {
                tempResult = tempResult.multiply(this.base);
            }
            return tempResult;
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
