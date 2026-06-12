package heshiranje;

import java.util.*;
import java.util.stream.Collectors;

class Person implements Comparable<Person> {
    private String name;
    private String lastname;
    private int budget;
    private String ipAddress;
    private String time;
    private String city;
    private int ticketPrice;

    public Person(String name, String lastname, int budget, String ipAddress, String time, String city, int ticketPrice) {
        this.name = name;
        this.lastname = lastname;
        this.budget = budget;
        this.ipAddress = ipAddress;
        this.time = time;
        this.city = city;
        this.ticketPrice = ticketPrice;
    }

    public String host(){
        String[] ipParts = ipAddress.split("\\.");
        return String.join(".", ipParts[0], ipParts[1], ipParts[2]);
    }
    @Override
    public int compareTo(Person o) {
        return 0;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getBudget() {
        return budget;
    }

    public String getTime() {
        return time;
    }

    public String getCity() {
        return city;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }
    public int getMinutes(){
        String[] timeParts = time.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        return hours * 60 + minutes;
    }

    @Override
    public String toString() {
        // Sara Dobreva with salary 2700 from address 10.73.60.29 who spent 1800
        return name + " " + lastname + " with salary " + budget + " from address " +
                ipAddress + " who spent " + ticketPrice + "\n";
    }
}

public class Zadaca5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        Set<Person> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            String lastname = scanner.next();
            int budget = scanner.nextInt();
            String ipAddress = scanner.next();
            String time = scanner.next();
            String city = scanner.next();
            int ticketPrice = scanner.nextInt();
            set.add(new Person(name, lastname, budget, ipAddress, time, city, ticketPrice));
        }

        int m = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < m; i++) {
            String name = scanner.next();
            String lastname = scanner.next();
            int budget = scanner.nextInt();
            String ipAddress = scanner.next();
            String time = scanner.next();
            String city = scanner.next();
            int ticketPrice = scanner.nextInt();

            String[] ipParts = ipAddress.split("\\.");
            String host = String.join(".", ipParts[0], ipParts[1], ipParts[2]);

            Set<Person> filtered = set.stream()
                    .filter(p -> p.host().equals(host) && p.getBudget() >= p.getTicketPrice())
                    .collect(Collectors.toSet());
            System.out.println("IP network: " + host + " has the following number of users: \n"
                    + filtered.size());
            Person paidTheMost = filtered.stream()
                    .max(Comparator.comparingInt(Person::getTicketPrice))
                    .orElseThrow();
            System.out.println("The user who spent the most from that network is: \n"
                    + paidTheMost.toString());
        }
    }
}
