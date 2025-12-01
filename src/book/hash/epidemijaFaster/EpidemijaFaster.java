package book.hash.epidemijaFaster;

import java.util.*;

class Patient {
    private String surname;
    private boolean result;

    public Patient(String surname, boolean result) {
        this.surname = surname;
        this.result = result;
    }

    public String getSurname() {
        return surname;
    }

    public boolean getResult() {
        return result;
    }
}
public class EpidemijaFaster {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Map<String, List<Patient>> positiveMap = new HashMap<>();
        Map<String, List<Patient>> negativeMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String [] lineWords = line.split("\\s+");
            String city = lineWords[0];
            String surname = lineWords[1];
            String result = lineWords[2];

            boolean bres = result.equals("positive");

          Patient patient = new Patient(surname, bres);
          if(bres){
            positiveMap
                    .computeIfAbsent(city, k -> new ArrayList<>())
                    .add(patient);
          }else{
              negativeMap
                      .computeIfAbsent(city, k -> new ArrayList<>())
                      .add(patient);
          }
        }

        String city = scanner.nextLine();

        double positiveCounter = positiveMap.get(city).size();
        double negativeCounter = negativeMap.get(city).size();

        double riskFactor = positiveCounter / (positiveCounter + negativeCounter);

        System.out.println(riskFactor);


    }
}
