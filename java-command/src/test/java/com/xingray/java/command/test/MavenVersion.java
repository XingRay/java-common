package com.xingray.java.command.test;

import java.io.*;
import java.util.Map;

public class MavenVersion {
    public static void main(String[] args) throws IOException {
        String mavenHome = "D:\\develop\\maven\\apache-maven"; // 替换为您的Maven安装路径
        ProcessBuilder processBuilder = new ProcessBuilder("mvn", "-v");

        Map<String, String> env = processBuilder.environment();
        env.put("Path", env.get("Path") + ";" + mavenHome + "\\bin");

        Process process = processBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
