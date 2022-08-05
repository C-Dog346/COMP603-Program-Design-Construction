package Task09_1;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class SumAll {

    public static void main(String[] args) {

        SumAll sa = new SumAll();
        Vector<Integer> vec = new Vector<>();
        Scanner scan = new Scanner(System.in);
        int num = 0;

        do {
            System.out.println("Input a non-zero integer, or input 0 to stop");
            num = scan.nextInt();
            vec.add(num);
        } while (num != 0);
        System.out.println("1: " + sa.sumNums1(vec));
        System.out.println("2: " + sa.sumNums2(vec));
        Object[] intArray = vec.toArray();
        System.out.println("3: " + sa.sumNums3(intArray));

    }

    public int sumNums1(Vector v) {
        int sum = 0;
        Iterator iter;
        iter = v.iterator();

        while (iter.hasNext())
            sum += (int) iter.next();

        return sum;
    }

    public int sumNums2(Vector<Integer> v) {
        int sum = 0;

        for (int x: v)
            sum += x;

        return sum;
    }

    public int sumNums3(Object... objs) {
        int sum = 0;

        for (Object x: objs)
            sum += (int) x;

        return sum;
    }
}