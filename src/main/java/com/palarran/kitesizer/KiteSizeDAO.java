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

    /**
     * @return All 144 possible kite sizes
     * @throws IOException 
     */
    public List<KiteSizeRecommendation> getAllRecommendations() throws IOException {
        String[][] matrix = loadContentsIntoArray();
        /*
         * 
         */

        return new ArrayList<KiteSizeRecommendation>();
    }

    /**
     * @return create a two-dimensional array
     */
    protected String[][] loadContentsIntoArray() {
        /*
         * save file contents as a string variable
         * create a one-dimensional array that just contains the lines in the file
         * create a new two-dimensional array
         * break each line of the file into an array
         * store line array into the two-dimensional array
         */

        String kiteChartData = loadFileContents();
        String[] rows = kiteChartData.split("\\n");
        String firstRow = rows[0];
        String[] firstRowCells = firstRow.split(" +");

        return null;
    }

    /**
     * @return a string containing the entire contents of the kite size chart
     * @throws IOException 
     */
    protected String loadFileContents() {
        try {
            byte[] txtFileSize = Files.readAllBytes(Paths.get(CHART_PATH));
            return new String(txtFileSize, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
