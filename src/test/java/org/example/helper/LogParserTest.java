package org.example.helper;

import org.example.pojo.LogEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LogParserTest {

    @Mock
    private Pattern pattern;

    @Mock
    private Matcher matcher;

    @InjectMocks
    private LogParser logParser;

    @BeforeEach
    void setUp() {

        pattern = mock(Pattern.class);
        matcher = mock(Matcher.class);
    }

    @Test
    void parseLog() {

        List<String> lines = Arrays.asList(
                "177.71.128.21 - - [10/Jul/2018:22:21:28 +0200] \"GET /intranet-analytics/ HTTP/1.1\" 200 3574 \"-\" \"Mozilla/5.0 (X11; U; Linux x86_64; fr-FR) AppleWebKit/534.7 (KHTML, like Gecko) Epiphany/2.30.6 Safari/534.7\"",
                "50.112.00.11 - admin [11/Jul/2018:17:33:01 +0200] \"GET /asset.css HTTP/1.1\" 200 3574 \"-\" \"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.6 (KHTML, like Gecko) Chrome/20.0.1092.0 Safari/536.6\""
        );

        List<LogEntry> logEntries = logParser.parseLog(lines);

        assertEquals(2, logEntries.size());
        assertEquals("177.71.128.21", logEntries.get(0).getIpAddress());
        assertEquals("/intranet-analytics/", logEntries.get(0).getUrl());
        assertEquals("50.112.00.11", logEntries.get(1).getIpAddress());
        assertEquals("/asset.css", logEntries.get(1).getUrl());


    }
}