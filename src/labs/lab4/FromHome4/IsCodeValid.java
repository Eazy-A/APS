package labs.lab4.FromHome4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class IsCodeValid {

    public boolean isValid(List<String> functions) {
        Stack<String> stack = new Stack<>();
        for (String s : functions){
            if(!s.startsWith("end")){
                stack.push(s);
            }else{
                if(stack.isEmpty()) return false;
                String top = stack.pop();
                if(!(("end" + top).equals(s))) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> functions = new ArrayList<>();
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.equals("x")) break;
            functions.add(s);
        }

        IsCodeValid object = new IsCodeValid();

        if (object.isValid(functions)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }

    }
}
