package com.busysimulator;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Executor {
    private Connection conn;
    private int numThreads = 30;

    public Executor() {
        Database db = Database.getInstance();
        this.conn = db.getConnection();
    }

    public void executeQuery(String query) {
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        try {
            Instant start = Instant.now();

            for (int i = 0; i < numThreads; i++) {
                executorService.submit(() -> {
                    try (Statement stmt = this.conn.createStatement()) {
                        stmt.executeQuery(query);
                    } catch (SQLException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                });
            }

            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

            Instant end = Instant.now();
            System.out.println("Query processed in: " + Duration.between(start, end).toMillis() + "ms");
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}