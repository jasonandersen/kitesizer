package com.palarran.kitesizer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Loads kite size recommendations from the kitesizechart.txt file.
 */
public class KiteSizeDAO {

    private static final String CHART_PATH = "/Users/jason/dev/workspace/kitesizer-new/src/main/resources/data/kitesizechart.txt";

    private static final int WEIGHT_ROW = 0;

    private static final int WIND_COL = 12;

    private static final int MAX_ROW = 12;

    private static final int MIN_WIND_SPEED = 8;

    private static final int MAX_WEIGHT_COL = 11;

    private String[][] table;

    /**
     * @return All 144 possible kite sizes
     * @throws IOException 
     */
    public List<KiteSizeRecommendation> getAllRecommendations() {
        table = loadContentsIntoArray();
        List<KiteSizeRecommendation> output = new ArrayList<KiteSizeRecommendation>();

        for (int column = 0; column < WIND_COL; column++) {
            for (int row = 1; row <= MAX_ROW; row++) {
                int kiteSize = getKiteSize(row, column);
                int upperWindSpeed = getUpperWindSpeed(row, column);
                int lowerWindSpeed = getLowerWindSpeed(row, column);
                int upperWeight = getUpperWeight(row, column);
                int lowerWeight = getLowerWeight(row, column);

                KiteSizeRecommendation recommendation = new KiteSizeRecommendation(kiteSize, upperWindSpeed, lowerWindSpeed,
                        upperWeight, lowerWeight);
                output.add(recommendation);
            }
        }
        return output;
    }

    /**
     * @param table
     * @param row
     * @param column
     * @return pulls the kite size out of the table based on the cell passed in
     */
    private int getKiteSize(int row, int column) {
        return toInt(table[row][column]);
    }

    /**
     * @param row
     * @param column
     * @return pulls the upper wind speed boundary based on the cell of the table
     */
    private int getUpperWindSpeed(int row, int column) {
        return toInt(table[row][WIND_COL]);
    }

    /**
     * @param row
     * @param column
     * @return pulls the lower wind speed boundary based on the cell of the table
     */
    private int getLowerWindSpeed(int row, int column) {
        return row == MAX_ROW ? MIN_WIND_SPEED : toInt(table[row + 1][WIND_COL]);
    }

    /**
     * @param row
     * @param column
     * @return pulls the upper weight boundary based on the cell of the table
     */
    private int getUpperWeight(int row, int column) {
        return column == MAX_WEIGHT_COL ? Integer.MAX_VALUE : toInt(table[WEIGHT_ROW][column + 1]);
    }

    /**
     * @param row
     * @param column
     * @return pulls the lower weight boundary based on the cell of the table
     */
    private int getLowerWeight(int row, int column) {
        return toInt(table[WEIGHT_ROW][column]);
    }

    /**
     * @param string
     * @return an int from a String
     */
    private int toInt(String string) {
        return Integer.valueOf(string);
    }

    /**
     * @return create a two-dimensional array
     */
    protected String[][] loadContentsIntoArray() {
        String kiteChartData = loadFileContents();
        String[] rows = kiteChartData.split("\\n");
        String[][] output = new String[rows.length - 1][];
        int index = 0;
        for (String row : rows) {
            if (!isAllWhitespace(row)) {
                output[index] = row.split("\\s+");
                index++;
            }
        }
        return output;
    }

    /**
     * @param row
     * @return true if this row is entirely made of whitespace
     */
    private boolean isAllWhitespace(String row) {
        return row.replaceAll("\\s", "").equals("");
    }

    /**
     * @return a string containing the entire contents of the kite size chart
     * @throws IOException 
     */
    protected String loadFileContents() {
        try {
            byte[] txtFile = Files.readAllBytes(Paths.get(CHART_PATH));
            return new String(txtFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
