package day04;

import java.util.List;

import static java.util.Comparator.comparingInt;

public class BingoGame {

    private List<BingoBoard> boards;

    public BingoGame(List<BingoBoard> boards) {
        this.boards = boards;
    }

    public int getWinningScoreFor(int[] bingoNumbers) {
        BingoBoard winningBoard = getWinningBoard(bingoNumbers);
        return winningBoard.getBoardScore(bingoNumbers);
    }

    public int getLosingScoreFor(int[] bingoNumbers) {
        BingoBoard losingBoard = getLosingBoard(bingoNumbers);
        return losingBoard.getBoardScore(bingoNumbers);
    }

    private BingoBoard getWinningBoard(int[] bingoNumbers) {
        boards.forEach(board -> board.markTillBingo(bingoNumbers));
        return boards.stream().min(comparingInt(BingoBoard::getCallsTillWin)).orElseThrow();
    }

    private BingoBoard getLosingBoard(int[] bingoNumbers) {
        boards.forEach(board -> board.markTillBingo(bingoNumbers));
        return boards.stream().max(comparingInt(BingoBoard::getCallsTillWin)).orElseThrow();
    }
}
