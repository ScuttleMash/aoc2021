package day02;

import static day02.Input.*;

public class PositionTracker {

    public static void main(String[] args) {
        int result1 = new Submarine().execute(getInstructions()).getPosition();
        System.out.println("===== RESULT 1 =====\nCurrent position is " + result1 + ".");
        int result2 = new SubmarineWithAim().execute(getInstructions()).getPosition();
        System.out.println("===== RESULT 2 =====\nCurrent position is " + result2 + ".");
    }
}
