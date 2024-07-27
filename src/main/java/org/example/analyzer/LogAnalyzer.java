package org.example.analyzer;

import org.example.pojo.LogEntry;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The type Log analyzer.
 */
public class LogAnalyzer {
    private final List<LogEntry> logEntryList;

    /**
     * Instantiates a new Log analyzer.
     * Param: logEntryList - List of LogEntry objects
     */
    public LogAnalyzer(List<LogEntry> logEntryList) {
        this.logEntryList = logEntryList;
    }

    /**
     * Count unique IP addresses present in the log file
     *Params: 0
     * Return : long - count of unique IP addresses present in the file
     */
    public long countUniqueIps(){
        return logEntryList.stream().map(LogEntry::getIpAddress).distinct().count();
    }

    /**
     * Returns top k IPAddress list.
     * Params: count - the value f k
     * Return: List<String> -  List of top K IP addresses present in the logfile
     */
    public List<String> topIPs(int count){
        return logEntryList
                .stream()
                .collect(Collectors.groupingBy(LogEntry::getIpAddress, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(count)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    /**
     * Returns top k url list.
     * Params: count - the value f k
     * Return: List<String> -  List of top k url present in the logfile
     */
    public List<String> topUrls(int count){
        return logEntryList
                .stream()
                .collect(Collectors.groupingBy(LogEntry::getUrl, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(count)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}