package labs.auds1.Arrays;

import labs.auds1.ArrayList.Array;

public class ChangeArrays <E>{

    public void CompareAndChangeArrays(Array<E> array1, Array<E> array2){
        if(array1.getSize() != array2.getSize()) {
            System.out.println("nizite ne se ednakvi");
            return;
        }
        for (int i = array1.getSize() - 1; i >= 0; i--) {
            if(array1.get(i).equals(array2.get(i))){
                array1.delete(i);
                array2.delete(i);
            }
        }
    }
    public static void main(String[] args) {
        Array<String> array1 = new Array<String>(4);
        array1.insertLast("nb11");
        array1.insertLast("b1");

        Array<String> array2 = new Array<String>(4);
        array2.insertLast("nb21");
        array2.insertLast("b1");


        System.out.println("nizite pred primenuvanjeto na funkcijata: ");
        System.out.println(array1.toString());
        System.out.println(array2.toString());

        ChangeArrays<String> pom = new ChangeArrays<String>();
        pom.CompareAndChangeArrays(array1, array2);

        System.out.println(array1.toString());
        System.out.println(array2.toString());

    }
}
