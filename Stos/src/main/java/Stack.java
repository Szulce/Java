import java.util.LinkedList;
import java.util.List;

public class Stack<T> {

    private int rozmiar;

    public int getRozmiar() {
        return rozmiar;
    }

    private List<T> Lista = new LinkedList<T>();

    public void Stack()
    {
        this.rozmiar = -1;
    }

    public void push(T element)
    {
        Lista.add(rozmiar,element);
        rozmiar++;
    }
    public T pop()
    {
        if(!Lista.isEmpty())
        {
        T element = Lista.get(rozmiar-1);
        Lista.remove(rozmiar-1);
        rozmiar--;
        return element;}
        return null;

    }
    public boolean isEmpty()
    {
        if(Lista.isEmpty()){return true;}
        else return false;
    }
    public void showall()
    {
        for (T t:Lista) {

            System.out.println(t);

        }
    }
}
