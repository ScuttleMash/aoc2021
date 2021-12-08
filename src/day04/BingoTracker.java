package day04;

import static day04.Input.getBingoBoards;
import static day04.Input.getBingoNumbers;

public class BingoTracker {

    public static void main(String[] args) {
        int result1 = new BingoGame(getBingoBoards()).getWinningScoreFor(getBingoNumbers());
        System.out.println("===== RESULT 1 =====\nWinning score for fastest board is " + result1 + ".");
        int result2 = new BingoGame(getBingoBoards()).getLosingScoreFor(getBingoNumbers());
        System.out.println("===== RESULT 2 =====\nWinning score for slowest board is " + result2 + ".");
    }
}
