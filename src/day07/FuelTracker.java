package day07;

import java.util.function.BiFunction;

import static day07.Input.getCrabPositions;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.abs;
import static java.util.Arrays.stream;

public class FuelTracker {

    public static void main(String[] args) {
        int result1 = calculateFuelUsage(getCrabPositions(), FuelTracker::linearFuelUsage);
        System.out.println("===== RESULT 1 =====\nCrabs require " + result1 + " fuel.");
        int result2 = calculateFuelUsage(getCrabPositions(), FuelTracker::incrementalFuelUsage);
        System.out.println("===== RESULT 2 =====\nCrabs require " + result2 + " fuel.");
    }

    private static int calculateFuelUsage(int[] crabPositions, BiFunction<Integer, Integer, Integer> fuelUsage) {
        int leftestCrab = stream(crabPositions).min().orElseThrow();
        int rightestCrab = stream(crabPositions).max().orElseThrow();

        int smallestOverall = MAX_VALUE;
        for (int targetPosition = leftestCrab; targetPosition <= rightestCrab; targetPosition++) {
            int smallestForPosition = 0;

            for (int i = 0; i < crabPositions.length; i++) {
                smallestForPosition += fuelUsage.apply(crabPositions[i], targetPosition);
            }

            if (smallestOverall > smallestForPosition) {
                smallestOverall = smallestForPosition;
            }
        }

        return smallestOverall;
    }

    private static int linearFuelUsage(int start, int end) {
        return abs(start - end);
    }

    private static int incrementalFuelUsage(int start, int end) {
        int positionsMoved = abs(start - end);
        return positionsMoved * (positionsMoved + 1) / 2;
    }
}
