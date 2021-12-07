package day03;

public class SubmarineConditionTracker {

    public static void main(String[] args) {
        int result1 = Input.getDiagnosticsReport().getPowerConsumption();
        System.out.println("===== RESULT 1 =====\nPower consumption is " + result1 + ".");
        int result2 = Input.getDiagnosticsReport().getLifeSupportRating();
        System.out.println("===== RESULT 2 =====\nLife support rating is " + result2 + ".");
    }
}
