package labs.lab4.studentskaSluzba;

import java.util.*;

public class StudentskaSluzba {

    public static class Student {
        private String name;
        private int flagA; // prilog na dokumenti
        private int flagB; // index
        private int flagC; // dokumenti od sredno

        public Student(String name, int flagA, int flagB, int flagC) {
            this.name = name;
            this.flagA = flagA;
            this.flagB = flagB;
            this.flagC = flagC;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int flagA = scanner.nextInt();
            int flagB = scanner.nextInt();
            int flagC = scanner.nextInt();
            scanner.nextLine();
            students.add(new Student(name, flagA, flagB, flagC));
        }
        Queue<Student> prilogNaDokimenti = new LinkedList<>();
        Queue<Student> index = new LinkedList<>();
        Queue<Student> dokumentiOdSredno = new LinkedList<>();

        for (Student s : students){
            if(s.flagA == 1){
                prilogNaDokimenti.add(s);
            }else if(s.flagB == 1){
                index.add(s);
            } else if (s.flagC == 1) {
                dokumentiOdSredno.add(s);
            }
        }
        List<String> finished = new ArrayList<>();

        while (finished.size() < n){

            // ako pocnuvat od A(prilog na dokumenti)
            for (int i = 0; i < 2; i++) {
                if(prilogNaDokimenti.isEmpty()) break;
                Student s = prilogNaDokimenti.poll();

                if(s.flagB == 1){
                    index.add(s);
                }else if(s.flagC == 1){
                    dokumentiOdSredno.add(s);
                }else{
                    finished.add(s.name);
                }
            }
            for (int i = 0; i < 3; i++) {
                if (index.isEmpty()) break;
                Student s = index.poll();

                if(s.flagC == 1){
                    dokumentiOdSredno.add(s);
                }else{
                    finished.add(s.name);
                }
            }

            if(!dokumentiOdSredno.isEmpty()){
                Student s = dokumentiOdSredno.poll();
                finished.add(s.name);
            }
        }

        for(String name : finished){
            System.out.println(name);
        }

    }
}
