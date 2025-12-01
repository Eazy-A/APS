package book.hash.zastapenostNaIminja;

import java.util.*;

class Baby {
    private String name;
    private String sex;

    public Baby(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }
}

public class Zastapenost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Map<String, List<Baby>> babiesBySex = new HashMap<>();
        Map<String, List<Baby>> babiesByName = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] words = scanner.nextLine()
                    .trim()
                    .split("\\s+");

            String name = words[0];
            String sex = words[1];

            Baby baby = new Baby(name, sex);

            babiesBySex.computeIfAbsent(sex, k -> new ArrayList<>())
                    .add(baby);

            babiesByName.computeIfAbsent(name, k -> new ArrayList<>())
                    .add(baby);
        }


        String searchingForSex = scanner.nextLine();

        while (!scanner.nextLine().equals("END")){
            String searchingForName = scanner.nextLine();
            String letters = searchingForName.substring(0, 1);



        }



    }
}
