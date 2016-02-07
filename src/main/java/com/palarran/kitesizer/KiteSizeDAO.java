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

    /**
     * @return All 144 possible kite sizes
     * @throws IOException 
     */
    public List<KiteSizeRecommendation> getAllRecommendations() {
        String[][] matrix = loadContentsIntoArray();
        List<KiteSizeRecommendation> output = new ArrayList<KiteSizeRecommendation>();
        
        KiteSizeRecommendation recommendation = new KiteSizeRecommendation(matrix)

        return output;
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
