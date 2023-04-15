import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Random generator = new Random();
        Scanner sc = new Scanner(System.in);

        //System.out.println();
        System.out.println("In this game you have to guess the chosen word.");

        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList("car", "money", "key", "keyboard", "worker", "maize", "country", "hippopotamus", "monitor", "television"));
        String generatedWord = wordsList.get(generator.nextInt(wordsList.size()));
        char[] letter = generatedWord.toCharArray();

        char[] underline = new char[letter.length];
        Arrays.fill(underline, '_');
        displayWord(underline);
        System.out.println();

        int lives = 6;

        while (true) {
            System.out.println("Enter a letter. You have " + lives + " lives left.");
            char letterEntered = sc.next().charAt(0);
            boolean match = false;
            for (int i = 0; i < letter.length; i++) {
                if (letterEntered == letter[i]) {
                    underline[i] = letterEntered;
                    match = true;
                }
            }
            if (!match) {
                System.out.println("You did not guess. Keep trying.");
                lives--;
            } else {
                System.out.println("Excellent! You guessed it!");
            }

            displayWord(underline);

            if (lives == 0) {
                System.out.println("Phew!!! You lost the game!");
                break;
            }

            if (Arrays.equals(letter, underline)) {
                System.out.println("Bravo!!! You won the game!");
                break;
            }
        }
    }

    public static void displayWord(char[] underLines) {
        for (char c : underLines) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
