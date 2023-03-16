package examplesLearning;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountKeywordStream {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Java source file: ");
        String filename = input.nextLine();

        File file = new File(filename);
        if (file.exists()) {
            System.out.println("The number of keywords in " + filename + " is " + countKeywords(file));
        }
        else {
            System.out.println("File " + filename + " does not exist ");
        }
    }

    public static long countKeywords(File file) throws Exception {
        String[] keywordString = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "extends",
                "continue", "default", "do", "double", "else", "enum", "for", "final", "finally", "float", "goto", "interface", "long", "native",
                "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this",
                "throw", "throws", "transient", "try", "void", "volatile", "while", "true", "false", "null"};

        Set<String> keywordSet =
                new HashSet<>(Arrays.asList(keywordString));

        // return sum of keywords
        return Files.lines(file.toPath()).parallel().mapToLong(line -> Stream.of(line.split("[\\s++]"))
                .filter(word -> keywordSet.contains(word)).count()).sum();
    }







}
