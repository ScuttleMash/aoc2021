package day03;

import static java.lang.Math.round;
import static java.lang.String.valueOf;
import static java.util.Arrays.stream;

public class DiagnosticsReport {

    /**
     * Not too happy with this data structure, but it's a bit more readable than a 2D array.
     */
    private final String[] data;

    public DiagnosticsReport(String[] data) {
        this.data = data;
    }

    public int getPowerConsumption() {
        return getGammaRate() * getEpsilonRate();
    }

    public int getLifeSupportRating() {
        return getOxygenGeneratorRating() * getCO2ScrubbingRating();
    }

    /**
     * Here be lots of duplication. I'll be cleaning this... later.
     */

    private int getGammaRate() {
        String result = "";
        for (int col = 0; col < data[0].length(); col++) {
            result = result.concat(getRelevantBitForColumn(data, col, true));
        }
        return Integer.parseInt(result, 2);
    }

    private int getEpsilonRate() {
        String result = "";
        for (int col = 0; col < data[0].length(); col++) {
            result = result.concat(getRelevantBitForColumn(data, col, false));
        }
        return Integer.parseInt(result, 2);
    }

    private int getOxygenGeneratorRating() {
        String[] tempData = data;
        for (int col = 0; col < data[0].length(); col++) {
            final char tempResult = getRelevantBitForColumn(tempData, col, true).charAt(0);
            final int currentCol = col;
            tempData = stream(tempData).filter(x -> x.charAt(currentCol) == tempResult).toArray(String[]::new);
        }
        return Integer.parseInt(tempData[0], 2);
    }

    private int getCO2ScrubbingRating() {
        String[] tempData = data;
        for (int col = 0; col < data[0].length(); col++) {
            final char tempResult = getRelevantBitForColumn(tempData, col, false).charAt(0);
            final int currentCol = col;
            tempData = stream(tempData).filter(x -> x.charAt(currentCol) == tempResult).toArray(String[]::new);
            if (tempData.length == 1)
                break;
        }
        return Integer.parseInt(tempData[0], 2);
    }

    private static String getRelevantBitForColumn(String[] data, int column, boolean useMostCommon) {
        if (useMostCommon) {
            return valueOf(round(stream(data).map(line -> line.substring(column, column + 1)).mapToInt(Integer::valueOf).average().orElseThrow()));
        } else {
            return valueOf(1 - round(stream(data).map(line -> line.substring(column, column + 1)).mapToInt(Integer::valueOf).average().orElseThrow()));
        }
    }
}
