package com.palarran.kitesizer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

/**
 * Testing the {@link KiteSizeDAO} class.
 */

public class KiteSizeDAOTest {

    @Test
    public void testAllPermutations() throws IOException {
        KiteSizeDAO dao = new KiteSizeDAO();
        List<KiteSizeRecommendation> allRecs = dao.getAllRecommendations();
        assertNotNull(allRecs);
        assertEquals(144, allRecs.size());
    }

    @Test
    public void testLoadFileContents() throws IOException {
        KiteSizeDAO dao = new KiteSizeDAO();
        String fileContents = dao.loadFileContents();
        assertNotNull(fileContents);
        assertTrue(fileContents.startsWith("95"));
    }

    @Test
    public void testLoadContentsIntoArray() throws IOException {
        KiteSizeDAO dao = new KiteSizeDAO();
        String[][] array = dao.loadContentsIntoArray();
        assertEquals("95", array[0][0]);
        assertEquals("9", array[0][12]);
    }
}
