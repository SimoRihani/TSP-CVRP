package util;

import java.util.Iterator;


/**
 *
 * @author fclautiaux
 *
 * CustomList implements a very simple linked list.
 * Elements can only be appended at the end of the list.
 * This implementation allows to merge two lists in O(1),
 * which cannot be done with the java.util.LinkedList class.
 *
 * @param <T> Type of the elements contained in the list.
 */
public class CustomList<T> {
    
    Link<T> first=null;
    Link<T> last=null;
    
    /**
     * creates an empty list
     */
    public CustomList(){}
    
    
    /**
     *
     * Append the element at the end of this list.
     *
     * @param element element to be added
     */
    public void add(T element){
        Link<T> newLink = new Link<T>(element);
        // first element
        if(first == null){
            first = newLink;
            last = newLink;
        }
        else{ // general case
            last.next = newLink;
            last = newLink;
        }
    }
    
    
    /**
     *
     * append list toAppend to the end of this list.
     *
     * @param toAppend
     */
    public void append(CustomList<T> toAppend){
        if(last == null) return;
        
        if(first == null){
            first = toAppend.first;
            last = toAppend.last;
        }
        else{
            last.next = toAppend.first;
            last = toAppend.last;
        }
    }
    
    /**
     *
     * @return the first element of the list
     */
    public T getFirst(){return first.element;}
    
    
    /**
     *
     * @return the last element of the list
     */
    public T getLast(){return last.element;}
    
    
    @Override
    public String toString() {
        String res="[";
        Link<T> ite = first;
        while(ite != null){
            res += ite.element.toString();
            if(ite.next != null) res += ",";
            ite = ite.next;
        }
        res += "]";
        return res;
    }
    
    
    /**
     *
     * @return a custom iterator over the elements
     */
    public Iterator<T> iterator(){
        return new CustomListIterator(this);
    }
    
    
    class CustomListIterator implements Iterator<T>{
        
        private Link<T> current;
        
        
        public CustomListIterator(CustomList<T> customList) {
            current = customList.first;
        }
        
        @Override
        public boolean hasNext() {
            return current != null;
        }
        
        @Override
        public T next() {
            T currentElement = current.element;
            current = current.next;
            return currentElement;
        }
        
    }
    
    
    class Link<P> {
        public T element;
        public Link<P> next = null;
        
        public Link(T element){
            this.element = element;
        }
        
    }
    
    
}