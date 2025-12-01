package labs.auds2.DLL;

public class DLLTester {
    public static void main(String[] args) {
        DLL<Integer> list = new DLL<Integer>();
        list.insertLast(5);
        System.out.println("Listata po vmetnuvanje na 5 kako posleden element: ");
        System.out.println(list.toString() + " i obratno " + list.toStringR());

        list.insertFirst(3);
        System.out.println("Listata po vmetnuvanje na 3 kako prv element: ");
        System.out.println(list.toString() + " i obratno " + list.toStringR());

        list.insertLast(1);
        System.out.println("Listata po vmetnuvanje na 1 kako posleden element: ");
        System.out.println(list.toString() + " i obratno " + list.toStringR());

        list.deleteFirst();
        System.out.println("Listata po brisenje na prviot element: ");
        System.out.println(list.toString() + " i obratno " + list.toStringR());

        DLLNode<Integer> pom = list.find(5);
        list.insertBefore(2, pom);
        System.out.println("Listata po vmetnuvanje na elementot 2 pred elementot 5: ");
        System.out.println(list.toString() + " i obratno " + list.toStringR());

        pom = list.find(1);
        list.insertAfter(3, pom);
        System.out.println("Listata po vmetnuvanje na elementot 3 posle elementot 1: ");
        System.out.println(list.toString() + " i obratno " + list.toStringR());

        pom = list.find(1);
        list.insertAfter(6, pom);
        System.out.println("Listata po vmetnuvanje na elementot 6 posle elementot 1: ");
        System.out.println(list.toString() + " i obratno " + list.toStringR());

        pom = list.find(3);
        list.delete(pom);
        System.out.println("Listata po brisenje na elementot 3: ");
        System.out.println(list.toString() + " i obratno " + list.toStringR());

        System.out.println("Momentalnata dolzina na listata: " + list.getSize());

        list.deleteList();
        System.out.println("Pecatenje na listata ppo nejzino brishenje: ");
        System.out.println(list.toString() + " i obratno " + list.toStringR());
        System.out.println("Momentalnata dolzina na listata: " + list.getSize());
    }
}
