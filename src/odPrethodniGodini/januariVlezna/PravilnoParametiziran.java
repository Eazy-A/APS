//package odPrethodniGodini.januariVlezna;
//
////vlezna zadaca
////stack
////
////Dadeni se nekolku stringovi, inputi na vlez (n na broj) i treba da se proveri dali parametriziranjeto
////na html dokumentot e pravilen
////imaj vo predvid deka postoat section subsection subsubsection
////so sekoj section moze da se dodade text pole nesto da se napise
////Ako e tocno paramteriziranjeto pecate true ako ne false
////
////test primer:
////4
///// begin{section}
///// begin{subsection}
///// end{subsection}
///// end{section}
////true
////
////3
///// begin{section}
///// begin{subsubsection}
///// end{subsubsection}
////false //ne e prazen steko
////
////4
///// begin{section}
///// begin{subsubsection}
///// end{subsubsection}
///// end{section}
////false  //ne e dobro parametriziranjeto section->subsection->subsubsection
//
//
//import javax.swing.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//import java.util.Stack;
//
//public class PravilnoParametiziran {
//
//    public boolean isParameterizationValid(List<String> strings) {
//        Stack<String> stack = new Stack<>();
//
//        for (String s : strings){
//            if(s.startsWith("begin{")){
//
//            }
//        }
//
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        scanner.nextLine();
//        List<String> strings = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            String line = scanner.nextLine();
//            strings.add(line);
//        }
//        PravilnoParametiziran pp = new PravilnoParametiziran();
//        System.out.println(pp.isParameterizationValid(strings));
//    }
//}
