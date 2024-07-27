package org.example;

import org.example.analyzer.LogAnalyzer;
import org.example.contants.ApplicationConstant;
import org.example.helper.FileReadHelper;
import org.example.helper.LogParser;
import org.example.pojo.LogEntry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> lines =new ArrayList<>();
        try
        {
            lines = new FileReadHelper().readFile(ApplicationConstant.file_path);
        }
        catch(IOException e)``````````````````````
        {
            // add catch logic
        }
        List<LogEntry> logEntries = new LogParser().parseLog(lines);
        LogAnalyzer logAnalyzer = new LogAnalyzer(logEntries);

        System.out.println("Unique IPs: " + logAnalyzer.countUniqueIps());
        System.out.println("Top 3 Urls: "+ logAnalyzer.topUrls(3));
        System.out.println("Top 3 IPs: "+ logAnalyzer.topIPs(3));
    }
}
