package Task10_1;

import java.util.Arrays;

public class ArrayTest {

    public static void main(String args[]) {
        ArrayTest at = new ArrayTest();
        double i = at.find(0, new int[]{1, 4, 2, 5, 7, 9});
        System.out.println(i);
    }

    //index 0: average, 1: minimum, 2:maximum
    public double find(int index, int[] intArray) {
        if (index < 0) {
            throw new IllegalArgumentException("index should be greater than or equal to 0");
        }
        if (intArray == null || intArray.length < 2) {
            throw new IllegalArgumentException("intArray cannot be null and the length of the array must be no less than 2");
        }
        int sum = 0;
        int count = 0;
        double result = 0;
        Arrays.sort(intArray);
        if (index == 0) {
            for (int i : intArray) {
                sum += i;
                count++;
            }
            if (count != 0) {
                result = 1.0 * sum / count;
            } else {
                result = sum / count;
            }
        } else if (index == 1) {
            result = intArray[0];
        } else if (index == 2) {
            result = intArray[intArray.length - 1];
        }
        return result;
    }

}
