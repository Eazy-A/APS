//package heshiranje;// Следните класи веќе се импортирани, не е дозволено копирање на класи овде, директно користејте ги како кога се достапни во други локални фајлови:
//
//// CBHT, OBHT, MapEntry, SLLNode веќе се импортирани
//
//import java.util.Objects;
//import java.util.Scanner;
//
//// Овде креирајте ги помошните класи за клуч и вредност
//// Исполнете ги барањата од текстот за toString методите
//// Дополнително осигурете се дека вашата клуч класа ќе ги имплементира потребните
//// hashCode и equals методи
//
//class Person implements Comparable<Person> {
//    // поставете ги потребните полиња овде
//    private String name;
//    private int age;
//
//    // имплементирајте соодветен конструктор
//    Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        // имплементирајте го toString методот според барањето во текстот
//        return "<" + name + ", " + age + ">";
//    }
//
//
//    // имплементирајте ги следните два методи за да работи табелата правилно
//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return age == person.age && Objects.equals(name, person.name);
//    }
//
//    @Override
//    public int hashCode() {
//        char firstLetter = name.charAt(0);
//        return age * firstLetter;
//    }
//
//    @Override
//    public int compareTo(Person o) {
//        return 0;
//    }
//}
//
//class Project implements Comparable<Project>{
//    private int time;
//    private int rate;
//
//    Project(int time, int rate) {
//        this.time = time;
//        this.rate = rate;
//    }
//
//    public int plata(){
//        return time * rate;
//    }
//
//    @Override
//    public String toString() {
//        return "<" + time + ", " + rate + ">";
//    }
//    @Override
//    public int compareTo(Project o) {
//        return Integer.compare(this.plata(), o.plata());
//    }
//}
//
//public class Solution {
//    public static void main(String[] args) {
//        // Креирајте ја табелата според барањата
//        CBHT<Person,Project> table = new CBHT<>(10);
//
//        // Прочитајте ги податоците од влезот и пополнете ја табелата
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        for (int i = 0; i < n; i++) {
//            String name = scanner.next();
//            int age = scanner.nextInt();
//            int time = scanner.nextInt();
//            int rate = scanner.nextInt();
//            Person person = new Person(name, age);
//            Project project = new Project(time, rate);
//
//            SLLNode<MapEntry<Person, Project>> existing = table.search(person);
//            if (existing == null){
//                table.insert(person, project);
//            } else if (project.plata() > existing.element.value.plata()) {
//                table.insert(person, project);
//            }
//        }
//
//        // отпечатете ја вашата табела
//        System.out.println(table);
//    }
//}
//
