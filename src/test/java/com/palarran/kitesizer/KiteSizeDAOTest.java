package com.palarran.kitesizer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

/**
 * Testing the {@link KiteSizeDAO} class.
 */

public class KiteSizeDAOTest {

    private KiteSizeDAO dao = new KiteSizeDAO();

    @Test
    public void testAllPermutations() {
        List<KiteSizeRecommendation> allRecs = dao.getAllRecommendations();
        assertNotNull(allRecs);
        assertEquals(144, allRecs.size());
    }

    @Test
    public void testFirstRecommendation() {
        List<KiteSizeRecommendation> allRecs = dao.getAllRecommendations();
        KiteSizeRecommendation first = allRecs.get(0);
        assertEquals(3, first.getKiteSize());
        assertEquals(95, first.getLowerWeight());
        assertEquals(110, first.getUpperWeight());
        assertEquals(28, first.getLowerWindSpeed());
        assertEquals(34, first.getUpperWindSpeed());
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
