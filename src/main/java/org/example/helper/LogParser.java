package org.example.helper;

import org.example.contants.ApplicationConstant;
import org.example.pojo.LogEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {
    private static final Pattern pattern = Pattern.compile(ApplicationConstant.Log_Pattern);

    public List<LogEntry> parseLog(List<String> lines)
    {
        List<LogEntry> logEntries = new ArrayList<>();
        Matcher matcher;
        for(String line : lines ){
            matcher = pattern.matcher(line);

            while (matcher.find()) {
                LogEntry logEntry = new LogEntry();
                logEntry.setIpAddress(matcher.group(1));
                logEntry.setUrl(matcher.group(6));
                logEntries.add(logEntry);
            }
        }
        return logEntries;
    }
}
