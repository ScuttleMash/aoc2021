package day04;

import static java.util.Arrays.stream;

public class BingoBoard {

    private int[][] board;
    private int callsTillWin;

    public BingoBoard(String rawBingoBoard) {
        board = stream(rawBingoBoard.split("\n"))
                .map(x -> stream(x.split(" "))
                        .filter(val -> !val.isBlank())
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);
    }

    public int getCallsTillWin() {
        return callsTillWin;
    }

    public int getBoardScore(int[] bingoNumbers) {
        int winningNumber = bingoNumbers[callsTillWin - 1];
        int unmarkedTotal = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] > 0) {
                    unmarkedTotal += board[i][j];
                }
            }
        }
        return unmarkedTotal * winningNumber;
    }

    public void markTillBingo(int[] bingoNumbers) {
        for (int i = 0; i < bingoNumbers.length; i++) {
            markNumberIfPresent(bingoNumbers[i]);

            if (bingoGet()) {
                callsTillWin = i + 1;
                return;
            }
        }
    }

    private boolean bingoGet() {
        for (int i = 0; i < 5; i++) {
            if (checkRow(i) || checkColumn(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumn(int columnIndex) {
        boolean marked = true;
        for (int i = 0; i < 5; i++) {
            marked = marked && board[i][columnIndex] < 0;
        }
        return marked;
    }

    private boolean checkRow(int rowIndex) {
        boolean marked = true;
        for (int i = 0; i < 5; i++) {
            marked = marked && board[rowIndex][i] < 0;
        }
        return marked;
    }

    private void markNumberIfPresent(int bingoNumber) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == bingoNumber) {
                    board[i][j] *= -1;
                }
            }
        }
    }
}
