package com.agshing.trellis.optimizer.reader;

import com.agshing.trellis.reader.DataReader;
import com.agshing.trellis.reader.FileReader;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static java.text.MessageFormat.format;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class FileReaderTest {
    private String defaultFilePath = format("src{0}test{0}resources{0}sample-data.txt", File.separator);

    private DataReader underTest;

    @Before
    public void setUp() {
        underTest = new FileReader(defaultFilePath);
    }

    @Test
    public void testRead() {
        // when
        final List<String> lines = underTest.read();
        // then
        assertNotNull(lines);
        assertEquals(lines.size(), 30);
    }
}
