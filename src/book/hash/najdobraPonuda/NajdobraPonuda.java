package book.hash.najdobraPonuda;

import java.util.*;

class Lecture implements Comparable<Lecture>{
    private String time;
    private String city;
    private int make;

    public Lecture(String time, String city, int make) {
        this.time = time;
        this.city = city;
        this.make = make;
    }

    @Override
    public int compareTo(Lecture o) {
        return Integer.compare(this.make, o.make);
    }

    @Override
    public String toString() {
        return time + " " + city + " " + make;
    }
}

public class NajdobraPonuda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        HashMap<String, List<Lecture>> lectureHashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String offer = scanner.nextLine();
            String[] words = offer.trim().split("\\s+");
            String date = words[0];
            String makeString = words[3];
            int make = Integer.parseInt(makeString);
            String time = words[1];
            String city = words[2];
            Lecture lecture = new Lecture(time, city, make);

            lectureHashMap
                    .computeIfAbsent(date, k -> new ArrayList<>())
                    .add(lecture);
        }

        String inputDate = scanner.nextLine().trim();
        List<Lecture> list = lectureHashMap.get(inputDate);

        Lecture best = Collections.max(list);
        System.out.println(best);

    }
}
