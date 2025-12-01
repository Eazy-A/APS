package labs.auds2.DLL;

public class DLL<E> {
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
