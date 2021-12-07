package day01;

import java.util.stream.IntStream;

import static day01.Input.*;

public class DepthIncreaseTracker {

    public static void main(String[] args) {
        int result1 = countIncrements(getDepthLog(), 1);
        System.out.println("===== RESULT 1 =====\nIncremented " + result1 + " times.");
        int result2 = countIncrements(getDepthLog(), 3);
        System.out.println("===== RESULT 2 =====\nIncremented " + result2 + " times.");
    }

    private static int countIncrements(int[] values, int stepSize) {
        int count = 0;
        int current;
        int next;

        for (int i = 0; i < values.length - stepSize; i++) {
            current = sumRange(values, i, stepSize);
            next = sumRange(values, i + 1, stepSize);
            if (next > current) {
                count++;
            }
        }

        return count;
    }

    private static int sumRange(int[] values, int skip, int limit) {
        return IntStream.of(values).skip(skip).limit(limit).sum();
    }
}
