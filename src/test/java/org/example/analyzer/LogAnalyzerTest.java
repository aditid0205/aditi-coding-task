package org.example.analyzer;

import org.example.pojo.LogEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LogAnalyzerTest {

    @Mock
    private LogEntry logEntry1;

    @Mock
    private LogEntry logEntry2;

    @Mock
    private LogEntry logEntry3;

    @Mock
    private LogEntry logEntry4;

    @Mock
    private LogEntry logEntry5;

    @Mock
    private LogEntry logEntry6;

    @BeforeEach
    void setUp() {
    }

    @Test
    void countUniqueIps_EmptyList() {
        List<LogEntry> emptyList = new ArrayList<>();
        LogAnalyzer analyzer = new LogAnalyzer(emptyList);
        long uniqueIps = analyzer.countUniqueIps();
        assertEquals(0, uniqueIps);
    }

    @Test
    public void testCountUniqueIps_SingleEntry() {
        // Arrange
        List<LogEntry> singleEntryList = new ArrayList<>();
        when(logEntry1.getIpAddress()).thenReturn("177.71.128.21");
        when(logEntry2.getIpAddress()).thenReturn("168.41.191.40");
        when(logEntry3.getIpAddress()).thenReturn("168.41.191.41");
        singleEntryList.add(logEntry1);
        singleEntryList.add(logEntry2);
        singleEntryList.add(logEntry3);
        LogAnalyzer analyzer = new LogAnalyzer(singleEntryList);

        // Act
        long uniqueIps = analyzer.countUniqueIps();

        // Assert
        assertEquals(3, uniqueIps);
    }

    @Test
    public void testCountUniqueIps_DuplicateEntry() {
        // Arrange
        List<LogEntry> singleEntryList = new ArrayList<>();
        when(logEntry1.getIpAddress()).thenReturn("177.71.128.21");
        when(logEntry2.getIpAddress()).thenReturn("168.41.191.40");
        when(logEntry3.getIpAddress()).thenReturn("168.41.191.40");
        singleEntryList.add(logEntry1);
        singleEntryList.add(logEntry2);
        singleEntryList.add(logEntry3);
        LogAnalyzer analyzer = new LogAnalyzer(singleEntryList);

        // Act
        long uniqueIps = analyzer.countUniqueIps();

        // Assert
        assertEquals(2, uniqueIps);
    }

    @Test
    void topIPs_emptyList() {

        LogAnalyzer analyzer = new LogAnalyzer(new ArrayList<>());
        List<String> topIps = analyzer.topIPs(3);
        assertEquals(0, topIps.size());
    }

    @Test
    public void testTop2IPs_multipleEntries() {

        List<LogEntry> logEntries = List.of(logEntry1, logEntry2, logEntry3,logEntry4,logEntry5,logEntry6);
        when(logEntry1.getIpAddress()).thenReturn("177.71.128.21");
        when(logEntry2.getIpAddress()).thenReturn("168.41.191.40");
        when(logEntry3.getIpAddress()).thenReturn("177.71.128.21");
        when(logEntry4.getIpAddress()).thenReturn("168.41.191.40");
        when(logEntry5.getIpAddress()).thenReturn("177.71.128.21");
        when(logEntry6.getIpAddress()).thenReturn("168.41.191.41");
        LogAnalyzer analyzer = new LogAnalyzer(logEntries);
        List<String> topIps = analyzer.topIPs(2);
        assertEquals(2, topIps.size());
        assertEquals("177.71.128.21", topIps.get(0));
        assertEquals("168.41.191.40", topIps.get(1));
    }

    @Test
    void topUrls_emptyList() {
        LogAnalyzer analyzer = new LogAnalyzer(new ArrayList<>());
        List<String> topIps = analyzer.topIPs(3);
        assertEquals(0, topIps.size());
    }

    @Test
    public void testTop2Urls_multipleEntries() {

        List<LogEntry> logEntries = List.of(logEntry1, logEntry2, logEntry3,logEntry4,logEntry5,logEntry6);
        when(logEntry1.getUrl()).thenReturn("/intranet-analytics/");
        when(logEntry2.getUrl()).thenReturn("http://example.net/faq/");
        when(logEntry3.getUrl()).thenReturn("/asset.css");
        when(logEntry4.getUrl()).thenReturn("http://example.net/faq/");
        when(logEntry5.getUrl()).thenReturn("/intranet-analytics/");
        when(logEntry6.getUrl()).thenReturn("/intranet-analytics/");
        LogAnalyzer analyzer = new LogAnalyzer(logEntries);
        List<String> topUrls = analyzer.topUrls(2);
        assertEquals(2, topUrls.size());
        assertEquals("/intranet-analytics/", topUrls.get(0));
        assertEquals("http://example.net/faq/", topUrls.get(1));
    }
}