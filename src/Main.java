import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        System.out.println(">Task 1");

        String stringTask1 = "abgadfaffkaa";
        System.out.println("Entered string: " + stringTask1);

        if (stringTask1.startsWith("abc")) {
            System.out.println(stringTask1.replace("abc", "www"));
        } else {
            System.out.println("Result: " + stringTask1.concat("zzz"));
        }

        System.out.println(">Task 2");

        String stringTask2 = "   asidao   ask dfpak a afkai k     aikfaoifja   iokik   ";
        System.out.println("Entered string: " + stringTask2);

        String output = stringTask2.replaceAll("\\s+", "\s").trim();
        System.out.println("Result:" + output);

        System.out.println(">Task 3");

        String stringTask3 = "Утром 14 июля толпа захватила 32000 ружей и пушки в Доме инвалидов, но пороха было недостаточно.";
        System.out.println(stringTask3);

        int largestLineWithNumbers = 0;
        String lineNumbers = null;
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(stringTask3);

        while (matcher.find()) {
            int temp = matcher.end() - matcher.start();
            if (temp > largestLineWithNumbers) {
                largestLineWithNumbers = temp;
                lineNumbers = matcher.group();
            }
        }

        System.out.println("Largest number of consecutive digits: " + lineNumbers);

        String []words = stringTask3.split("\\s*(\\s|,|!|\\.)\\s*");
        String longestWord = null;
        int longestWordLength = 0;
        int longestWordIndex = 0;
        String smallestWort = null;
        int smallestWordLength = 99999;
        int smallestWordIndex = 0;

        for (int i = 0; i < words.length; i++) {
            if (longestWordLength < words[i].length()) {
                longestWordLength = words[i].length();
                longestWordIndex = i;
                longestWord = words[i];
            }
        }

        for (int i = words.length - 1; i >= 0; i--) {
            if (smallestWordLength > words[i].length()) {
                smallestWordLength = words[i].length();
                smallestWordIndex = i;
                smallestWort = words[i];
            }
        }

        System.out.println("Replacing words:");

        for (String word : words) {
            System.out.printf("%s ", word);
        }
        System.out.println();

        words[longestWordIndex] = smallestWort;
        words[smallestWordIndex] = longestWord;

        for (String word : words) {
            System.out.printf("%s ", word);
        }
        System.out.println();

        System.out.println("Found punctuation marks:");
        int numberOfPunctuationMarks = 0;

        Pattern pattern1 = Pattern.compile("[^а-яА-Я0-9\\s]");
        Matcher matcher1 = pattern1.matcher(stringTask3);

        while (matcher1.find()) {
            System.out.println(matcher1.group());
            numberOfPunctuationMarks++;
        }

        System.out.println("Total: " + numberOfPunctuationMarks);

        System.out.println(">Task 4");

        String domainStr = "gsgs_gh.shdfa@gmail.com";

        if (domainStr.matches("([a-z0-9_.-]*)@([a-z0-9_.-]*)\\.[a-z]{2,6}")) {
            System.out.println("Correct email");
        } else {
            System.out.println("Incorrect email");
        }

        System.out.println(">Task 5");

        String ipStr = "254.100.100.100";

        if (ipStr.matches("((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]?)")) {
            System.out.println("Correct IP");
        } else {
            System.out.println("Incorrect IP");
        }
    }
}