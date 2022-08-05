package Task05_1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Counter implements Runnable {

    int num;

    public static void main(String[] args) {
        Counter count1 = new Counter(1);
        Counter count2 = new Counter(2);
        Thread odd = new Thread(count1);
        Thread even = new Thread(count2);
        odd.start();
        even.start();
    }

    public Counter(int i) {
        this.num = i;
    }

    @Override
    public void run() {
        for (int j = this.num; j <= 10; j += 2) {
            System.out.print(j + " ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Counter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
