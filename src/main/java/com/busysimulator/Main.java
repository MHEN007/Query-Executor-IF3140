package com.busysimulator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Executor exec = new Executor();
        String query = "";

        try {
            query = new String(Files.readAllBytes(Paths.get("query.sql")));
        } catch (IOException e) {
            query = "SELECT 1";
        }

        exec.executeQuery(query);
    }
}