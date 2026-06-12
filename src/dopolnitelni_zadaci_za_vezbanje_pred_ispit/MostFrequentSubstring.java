//package dopolnitelni_zadaci_za_vezbanje_pred_ispit;
//
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class MostFrequentSubstring {
//    public static void main(String[] args) throws IOException {
//        CBHT<String, Integer> tabela = new CBHT<String, Integer>(300);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String word = br.readLine().trim();
//
//        HashSet<String> allSubs = new HashSet<>();
//
//        for (int len = 1; len <= word.length(); len++) {
//            for (int start = 0; start <= word.length() - len; start++){
//                String sub = word.substring(start, start + len);
//                SLLNode<MapEntry<String, Integer>> found = tabela.search(sub);
//                if (found == null){
//                    tabela.insert(sub, 1);
//                }else{
//                    tabela.insert(sub, found.element.value + 1);
//                }
//                allSubs.add(sub);
//            }
//        }
//
//        String best = "";
//        int maxCount = 0;
//
//        for (String sub : allSubs){
//            int count = tabela.search(sub).element.value;
//            if (count > maxCount
//                    || (count == maxCount && sub.length() > best.length())
//             || (count == maxCount && sub.length() == best.length() && sub.compareTo(best) < 0)){
//                best = sub;
//                maxCount = count;
//            }
//        }
//        System.out.println(best);
//
//
//    }
//}