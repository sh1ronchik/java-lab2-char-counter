import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class CharacterCounter {
    private HashMap<Character, Integer> letterCounts;

    public CharacterCounter() {
        this.letterCounts = new HashMap<>();
    }

    public void processFile(String filePath) {
        File file = new File(filePath);

        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                for (char c : line.toCharArray()) {
                    if (Character.isLetter(c)) {
                        letterCounts.put(c, letterCounts.getOrDefault(c, 0) + 1);
                    }
                }
            }
            fileScanner.close();
        }
        catch (FileNotFoundException f) {
            System.out.println("File not found, try another path");
        }
        catch (Exception e) {
            System.out.println("An error occurred while processing the file");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Letter counts:\n");
        for (Character letter : letterCounts.keySet()) {
            sb.append(letter).append(": ").append(letterCounts.get(letter)).append("\n");
        }
        return sb.toString();
    }
}