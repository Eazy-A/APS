package book.hash.epidemija;

import java.util.*;
import java.util.stream.Collectors;

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
public class Epidemic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Map<String, List<Patient>> patientMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String [] lineWords = line.split("\\s+");
            String city = lineWords[0];
            String surname = lineWords[1];
            String result = lineWords[2];

            boolean bres = result.equals("positive");

            Patient patient = new Patient(surname, bres);

            patientMap
                    .computeIfAbsent(city, k -> new ArrayList<>())
                    .add(patient);
        }

        String city = scanner.nextLine();

        double countPositive = patientMap
                .get(city)
                .stream()
                .filter(Patient::getResult)
                .count();

//        double countNegative = patientMap
//                .get(city)
//                .stream()
//                .filter(patient -> !patient.getResult())
//                .count();

//        System.out.println(countPositive);
//        System.out.println(countNegative);

        double numberOfPatients = patientMap.get(city).size();

//        double riskFactor = countPositive / (countNegative + countPositive);

        double riskFactor = countPositive / numberOfPatients;

        System.out.println(riskFactor);


    }
}
