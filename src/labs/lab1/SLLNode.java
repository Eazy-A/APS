package labs.lab1;

public class SLLNode<E> {
    public E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    public E getElement() {
        return element;
    }
}

