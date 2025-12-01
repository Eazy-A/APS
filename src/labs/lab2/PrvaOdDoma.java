package labs.lab2;

import java.util.Scanner;

class DLL<E> {
    private DLLNode<E> first, last;

    public DLL() {
        this.first = null;
        this.last = null;
    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            DLLNode<E> temp = first;
            ret += temp.toString();
            while (temp.succ != null) {
                temp = temp.succ;
                ret += "<->" + temp.toString();
            }
        } else {
            ret = "Prazna lista! ";
        }
        return ret;
    }

    public void setFirst(DLLNode<E> first) {
        this.first = first;
    }

    public void setLast(DLLNode<E> last) {
        this.last = last;
    }

    public String toStringR() {
        String ret = new String();
        if (last != null) {
            DLLNode<E> tmp = last;
            ret += tmp.toString();
            while (tmp.pred != null) {
                tmp = tmp.pred;
                ret += "<->" + tmp.toString();
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        DLLNode<E> ins = new DLLNode<>(o, null, first);
        if (first == null)
            last = ins;
        else first.pred = ins;
        first = ins;
    }

    public void insertAfter(E o, DLLNode<E> after) {
        if (after == last) {
            insertLast(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<>(o, after, after.succ);
        after.succ.pred = ins;
        after.succ = ins;
    }

    public void insertLast(E o) {
        if (first == null) {
            insertFirst(o);
        } else {
            DLLNode<E> ins = new DLLNode<E>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }

    public void insertBefore(E o, DLLNode<E> before) {
        if (before == first) {
            insertFirst(o);
        } else {
            DLLNode<E> ins = new DLLNode<E>(o, before.pred, before);
            before.pred.succ = ins;
            before.pred = ins;
        }
    }

    public E deleteFirst() {
        if (first == null) return null;

        DLLNode<E> tmp = first;
        first = first.succ;

        if (first != null) {
            first.pred = null;
        } else {
            last = null;
        }

        return tmp.element;
    }

    public E deleteLast() {
        if (first != null) {
            if (first.succ == null) {
                return deleteFirst();
            } else {
                DLLNode<E> temp = last;
                last = last.pred;
                last.succ = null;
                return temp.element;
            }
        } else {
            return null;
        }
    }

    public E delete(DLLNode<E> node) {
        if (first == null || node == null) return null;
        if (node == first) return deleteFirst();
        if (node == last) return deleteLast();
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        node.pred = null;
        node.succ = null;
        return node.element;
    }

    public DLLNode<E> find(E o) {
        if (first == null) {
            System.out.println("Listata e prazna");
            return null;
        }
        if (o == null ? first.element == null : o.equals(first.element)) return first;
        if (o == null ? last.element == null : o.equals(last.element)) return last;

        DLLNode<E> temp = first.succ;
        while (temp != null) {
            if (o == null ? temp.element == null : o.equals(temp.element)) return temp;
            temp = temp.succ;
        }
        System.out.println("Elementot ne postoi vo listata");
        return null;
    }

    public DLLNode<E> getLast() {
        return last;
    }

    public DLLNode<E> getFirst() {
        return first;
    }

    public int getSize() {
        int size = 0;
        DLLNode<E> temp = first;
        while (temp != null) {
            size++;
            temp = temp.succ;
        }
        return size;
    }

    public void deleteList() {
        first = null;
        last = null;
    }

}

class DLLNode<E> {
    protected E element;
    protected DLLNode<E> pred, succ;

    public DLLNode(E element, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = element;
        this.pred = pred;
        this.succ = succ;
    }


    @Override
    public String toString() {
        return String.valueOf(element);
    }
}

public class PrvaOdDoma {
    public void pomestiZaKLevo(DLL<Integer> list, int m, int k) {
        DLLNode<Integer> node = list.getFirst();
        System.out.println(list.toString());

        while (node != null && !node.element.equals(m)) {
            node = node.succ;
        }
        if (node == null) {
            System.out.println("Elementot ne postoi vo listata");
            System.out.println(list.toString());
            return;
        }
        DLLNode<Integer> target = node;

        if (target.pred != null) target.pred.succ = target.succ;
        else list.setFirst(target.succ);

        if (target.succ != null) target.succ.pred = target.pred;
        else list.setLast(target.pred);

        DLLNode<Integer> current = target.pred;
        while (k > 0) {
            if(current != null){
                current = current.pred;
            }
            else{
                current = list.getLast();
            }
            k--;
        }

        if(current == null){
            target.pred = null;
            target.succ = list.getFirst();
            if(list.getFirst() != null) list.getFirst().pred = target;
            list.setFirst(target);
            if (list.getLast() == null) list.setLast(target);
        }
        else {
            target.succ = current.succ;
            target.pred = current;
            if(current.succ != null) current.succ.pred = target;
            current.succ = target;
            if(current == list.getLast()) list.setLast(target);
        }

        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DLL<Integer> list = new DLL<Integer>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        PrvaOdDoma p = new PrvaOdDoma();
        p.pomestiZaKLevo(list, m, k);
    }
}
