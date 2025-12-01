package zadaciZaVezbanjePrvKolokvium.kol5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class card_trick {

    public static int count(int N) {
        // Креираме шпил од 51 карта (ги чуваме нивните оригинални позиции)
        ArrayList<Integer> deck = new ArrayList<>();
        for (int i = 1; i <= 51; i++) {
            deck.add(i);
            System.out.println("added" + i + "\n");
        }

        int shuffles = 0;

        // Продолжуваме да мешаме се додека картата N не дојде на позиција 0 (врв)
        while (deck.get(0) != N) {
            shuffles++;
            deck = shuffle(deck);
            System.out.println(shuffles + " ");
        }

        return shuffles;
    }

    private static ArrayList<Integer> shuffle(ArrayList<Integer> deck) {
        ArrayList<Integer> newDeck = new ArrayList<>();

        // Земи први 7 карти
        ArrayList<Integer> firstSeven = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            firstSeven.add(deck.get(i));
        }

        // Превртиги
        Collections.reverse(firstSeven);

        // Остатокот од шпилот
        ArrayList<Integer> rest = new ArrayList<>();
        for (int i = 7; i < deck.size(); i++) {
            rest.add(deck.get(i));
        }

        // Наизменично земаме од превртените и од остатокот
        int i = 0;
        while (i < firstSeven.size() || i < rest.size()) {
            if (i < firstSeven.size()) {
                newDeck.add(firstSeven.get(i));
            }
            if (i < rest.size()) {
                newDeck.add(rest.get(i));
            }
            i++;
        }

        return newDeck;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(count(Integer.parseInt(br.readLine())));
    }
}