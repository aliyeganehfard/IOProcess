package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        var path =
                Path.of("F:\\Java-programming\\maktabsharif\\Resource\\MAKTAB-HW17\\List.txt");
//        1
        System.out.println("1 =>");
        showFile(path);
//        2
        System.out.println("2 =>");
        StringBuilder text = new StringBuilder();
        System.out.println(saveLineByLine(path, text));
//        3
        System.out.println("3 =>");
        write(path,"new");
        write(path, Arrays.asList("1","2"));
//        4
        System.out.println("4 =>");
        System.out.println(findBiggestWord(path));
//        5
        List<String> list = new LinkedList<>();
        linkedList(path,list);
    }

    public static void showFile(Path path){
        try {
            Files.lines(path).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String saveLineByLine(Path path , StringBuilder text){
        try (var reader = new BufferedReader(new FileReader(String.valueOf(path)))){
            var line ="";
            while ((line = reader.readLine()) != null){
                text.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
    public static void write(Path path , String text) throws IOException {
        var txt = text+"\n";
        Files.write(path,txt.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
    }
    public static void write(Path path , List<String> text) throws IOException {
        Files.write(path,text,StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }
    public static String findBiggestWord(Path path) throws IOException {
        return Files.readAllLines(path).stream().max(Comparator.comparing(String::length)).get();
    }
    public static void linkedList(Path path , List<String> list){
        try (var reader = new BufferedReader(new FileReader(String.valueOf(path)))){
            var line ="";
            while ((line = reader.readLine()) != null){
            list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.reverse(list);
        list.forEach(System.out::println);
    }
}
