package com.palarran.kitesizer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing the {@link KiteSizeDAO} class.
 */
public class KiteSizeDAOTest {

    private KiteSizeDAO dao = new KiteSizeDAO();

    private List<KiteSizeRecommendation> allRecs;

    @Before
    public void loadAllRecommendations() {
        allRecs = dao.getAllRecommendations();
    }

    @Test
    public void testAllPermutations() {
        assertNotNull(allRecs);
        assertEquals(144, allRecs.size());
    }

    @Test
    public void testFirstRecommendation() {
        KiteSizeRecommendation first = allRecs.get(0);
        assertEquals(3, first.getKiteSize());
        assertEquals(95, first.getLowerWeight());
        assertEquals(110, first.getUpperWeight());
        assertEquals(28, first.getLowerWindSpeed());
        assertEquals(34, first.getUpperWindSpeed());
    }

    @Test
    public void testSecondRecommendation() {
        KiteSizeRecommendation second = allRecs.get(1);
        assertEquals(3, second.getKiteSize());
        assertEquals(95, second.getLowerWeight());
        assertEquals(110, second.getUpperWeight());
        assertEquals(24, second.getLowerWindSpeed());
        assertEquals(28, second.getUpperWindSpeed());
    }

    @Test
    public void testLastRecommendation() {
        KiteSizeRecommendation last = allRecs.get(143);
        assertEquals(24, last.getKiteSize());
        assertEquals(260, last.getLowerWeight());
        assertEquals(Integer.MAX_VALUE, last.getUpperWeight());
        assertEquals(10, last.getUpperWindSpeed());
        assertEquals(8, last.getLowerWindSpeed());
    }

    @Test
    public void spotCheckRecommendations() {
        validateRecommendationExists(95, 110, 19, 21, 4);
    }

    /**
     * Validates that a recommendation exists with the following attributes. Will throw an assertion error
     * if that recommendation is not found.
     * @param lowerWeight
     * @param upperWeight
     * @param lowerWindSpeed
     * @param upperWindSpeed
     * @param size
     */
    private void validateRecommendationExists(int lowerWeight, int upperWeight, int lowerWindSpeed, int upperWindSpeed,
            int size) {
        for (KiteSizeRecommendation rec : allRecs) {
            if (rec.getLowerWeight() == lowerWeight &&
                    rec.getUpperWeight() == upperWeight &&
                    rec.getLowerWindSpeed() == lowerWindSpeed &&
                    rec.getUpperWindSpeed() == upperWindSpeed &&
                    rec.getKiteSize() == size) {
                return;
            }
        }
        fail("No specified recommendation was found.");
    }

    @Test
    public void testLoadFileContents() {
        String fileContents = dao.loadFileContents();
        assertNotNull(fileContents);
        assertTrue(fileContents.startsWith("95"));
    }

    @Test
    public void testLoadContentsIntoArrayFirstRow() {
        String[][] array = dao.loadContentsIntoArray();
        String[] firstRow = array[0];
        String[] expectedFirstRow = { "95", "110", "125", "140", "155", "170", "185", "200", "215", "230", "245", "260", "Knt",
                "Mph", "Kph" };
        assertArrayEquals(firstRow, expectedFirstRow);
    }

    @Test
    public void testLoadContentsIntoArrayLastRow() {
        String[][] array = dao.loadContentsIntoArray();
        String[] lastRow = array[array.length - 1];
        String[] expectedLastRow = { "9", "10", "12", "13", "15", "16", "17", "19", "20", "22", "23", "24", "10", "12", "19" };
        assertArrayEquals(expectedLastRow, lastRow);
    }

    @Test
    public void testLoadContentsIntoArrayRemoveEmptyRow() {
        String[][] array = dao.loadContentsIntoArray();
        String[] secondRow = array[1];
        assertEquals(13, array.length);
        assertEquals("3", secondRow[0]);
    }
}
