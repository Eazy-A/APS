//package heshiranje;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//class Person implements Comparable<Person> {
//    private String name;
//    private String lastname;
//    private int budget;
//    private String ipAddress;
//    private String time;
//    private String city;
//    private int ticketPrice;
//
//    public Person(String name, String lastname, int budget, String ipAddress, String time, String city, int ticketPrice) {
//        this.name = name;
//        this.lastname = lastname;
//        this.budget = budget;
//        this.ipAddress = ipAddress;
//        this.time = time;
//        this.city = city;
//        this.ticketPrice = ticketPrice;
//    }
//
//    @Override
//    public int compareTo(Person o) {
//        return 0;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public int getBudget() {
//        return budget;
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public int getTicketPrice() {
//        return ticketPrice;
//    }
//
//    @Override
//    public String toString() {
//        // Sara Dobreva with salary 2700 from address 10.73.60.29 who spent 2500
//        return name + " " + lastname + " with salary " + budget + " from address " +
//                ipAddress + " who spent " + ticketPrice + "\n";
//    }
//}
//
//public class Zadaca2 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int n = scanner.nextInt();
//        scanner.nextLine();
//
//        Set<Person> set = new HashSet<>();
//
//        for (int i = 0; i < n; i++) {
//            String name = scanner.next();
//            String lastname = scanner.next();
//            int budget = scanner.nextInt();
//            String ipAddress = scanner.next();
//            String time = scanner.next();
//            String city = scanner.next();
//            int ticketPrice = scanner.nextInt();
//            set.add(new Person(name, lastname, budget, ipAddress, time, city, ticketPrice));
//        }
//
//        int m = scanner.nextInt();
//        scanner.nextLine();
//
//        for (int i = 0; i < m; i++) {
//            String name = scanner.next();
//            String lastname = scanner.next();
//            int budget = scanner.nextInt();
//            String ipAddress = scanner.next();
//            String time = scanner.next();
//            String city = scanner.next();
//            int ticketPrice = scanner.nextInt();
//
//            Set<Person> filtered = set.stream()
//                    .filter(p -> p.getCity().equals(city) && p.getBudget() >= p.getTicketPrice())
//                    .collect(Collectors.toSet());
//            System.out.println("City: " + city + " has the following number of customers: \n"
//                    + filtered.size());
//            Person maxSpentPerson = filtered.stream()
//                    .max(Comparator.comparingInt(Person::getTicketPrice))
//                    .orElseThrow();
//            System.out.println("The user who spent the most purchasing for that city is: \n"
//                    + maxSpentPerson.toString());
//        }
//    }
//}
