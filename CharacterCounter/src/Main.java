import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {
    public static String readFilePathFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");

        return scanner.nextLine();
    }

    public static void outputLetterCountsToFile(String letterCounts) {
        Scanner scanner = new Scanner(System.in);
        String outputFileName = null;
        boolean fileExists = true;

        while (fileExists) {
            System.out.println("Enter the desired name for the output file:");
            outputFileName = scanner.nextLine();
            File outputFile = new File(outputFileName);
            fileExists = outputFile.exists();

            if (fileExists) {
                System.out.println("A file with this name already exists. Do you want to overwrite it? (yes/no)");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("yes")) {
                    fileExists = false;
                }
            }
        }

        try (PrintWriter writer = new PrintWriter(outputFileName)) {
            writer.print(letterCounts);
        } catch (IOException e) {
            System.out.println("Problems with writing in file");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred");
        }
    }

    public static void main(String[] args) {
        String filePath = readFilePathFromConsole();
        CharacterCounter counter = new CharacterCounter();
        counter.processFile(filePath);
        outputLetterCountsToFile(counter.toString());
    }
}

// /home/sh1ron/IdeaProjects/CharacterCounter/1.txt