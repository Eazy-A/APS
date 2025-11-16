package kol1.auds2.DLL;

public class DLLNode<E> {
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
