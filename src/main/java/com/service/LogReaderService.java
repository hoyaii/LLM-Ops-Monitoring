package com.service;

import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LogReaderService {

    private static final String LOG_FILE_PATH = "/path/to/buffer.b61d2f4a7a0373518cd314dbc2a03e543.log";

    @Scheduled(fixedRate = 60000) // 60초마다 실행
    public void readLogFile(String type) {
        try {
            Path path = Paths.get(LOG_FILE_PATH);
            List<String> lines = Files.readAllLines(path);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
