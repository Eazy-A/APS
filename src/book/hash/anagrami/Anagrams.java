package book.hash.anagrami;

import java.util.*;

public class Anagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        HashMap<String, Integer> wordsMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine().trim();
            char[] characters = word.toCharArray();
            Arrays.sort(characters);
            String sortedWord = "";
            for (char character : characters) {
                sortedWord += character;
            }
            System.out.println(sortedWord);
            wordsMap.put(sortedWord, wordsMap.getOrDefault(sortedWord, 0) + 1);
        }
        String anagramWord = scanner.nextLine().trim();
        char[] anagramCharacters = anagramWord.toCharArray();
        Arrays.sort(anagramCharacters);
        String sortedAnagram = "";
        for (char anagramCharacter : anagramCharacters) {
            sortedAnagram += anagramCharacter;
        }
        System.out.println(sortedAnagram);

        System.out.println(wordsMap.get(sortedAnagram));

    }
}
