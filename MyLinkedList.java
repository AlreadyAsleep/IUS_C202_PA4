
package PA4;

/**This class creates Linked Lists in the way discussed in class
 *      it has two member variables as follows:
 *      head: Node - the beginning of the list
 *      size: int - the numerical size of the list
 *      it also has a type specifier field that can be any Object type
 *      E: Object - the type of list and node
 * @author BenHeil
 * @since 06272017
 */
public class MyLinkedList<E> extends MyAbstractList<E> {

    private Node<E> head, tail;
    int size;

    /** Create a default list */
    public MyLinkedList() {
        size = 0;
    }

    /** Create a list from an array of objects */
    public MyLinkedList(E[] objects) {
        super(objects);
    }

    /** Return the head element in the list */
    public E getFirst() {
       if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    /** Return the last element in the list */
    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    /** Add an element to the beginning of the list */
    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e); // Create a new node
        newNode.next = head; // link the new node with the head
        head = newNode; // head points to the new node
        size++; // Increase list size

        if (tail == null) // the new node is the only node in list
        {
            tail = head;
        }

    }

    /** Add an element to the end of the list */
    public void addLast(E e) {
        Node<E> newNode = new Node<E>(e); // Create a new for element e
        if (tail == null) {
            head = tail = newNode; // The new node is the only node in list
        } else {
            tail.next = newNode; // Link the new with the last node
            tail = tail.next; // tail now points to the last node
        }
        size++; // Increase size
    }

    /** Add a new element at the specified index in this list
     * The index of the head element is 0 */
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            size++;
        }

    }

    /** Remove the head node and
     *  return the object that is contained in the removed node. */
    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return temp.element;
        }
    }

    /** Remove the last node and
     * return the object that is contained in the removed node. */
    public E removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        } else {
            Node<E> current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    /** Remove the element at the specified position in this list.
     *  Return the element that was removed from the list. */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    /** Override toString() to return elements in the list */
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            } else {
                result.append("]"); // Insert the closing ] in the string
            }
        }
        return result.toString();
    }

    /** Clear the list */
    public void clear() {
        head = tail = null;
    }

     /*
      @param e: E - The element to be searched 
      @return boolean - true/false depending the element is found
      @requires - <pre> the element must be of type E or cast to type E</pre>
      @ensures - a valid boolean describing whether the list contains e
    */
    @Override
    public boolean contains(E e) 
    {
       
        if(size > 0)
        {
         Node<E> temp = head;
         while(temp != null)
         {
            
             if(temp.element.equals(e))
                 return true;
              temp = temp.next;
         }
         return false;
        }
        return false;
    }
    
    public boolean contains(E e, int[] i)
    {
        if(size > 0)
        {
         Node<E> temp = head;
         while(temp != null)
         {
             i[0]+=1;
             if(temp.element.equals(e))
                 return true;
              temp = temp.next;
         }
         return false;
        }
        return false;
    }
    /*
    @param index: int - the index to be queried
    @return E - the object at the index
    @requires - <pre><@code>index > 0 && index < size</pre>
    @ensures - the object at the index will be returned
    */
    @Override
    public E get(int index) 
    {
        if(index < 0 || index > size - 1)
            return null;
        Node<E> temp = head;
        for(int i = 0; i < index ; i++ )
        {
            temp = temp.next;
        }
        return temp.element;
    }
    /*
    @param e : E - the object to be searched for
    @return int - the index of e
    @requires - <pre> e is a valid object of type E</pre>
    @ensures - the accurate first index of e
    */
    @Override
    public int indexOf(E e) 
    {
         if(size > 0)
        {
            Node<E> temp = head;
           for(int i = 1; i <= size; i++)
            {
                temp = temp.next;
                    if(temp.element.equals(e))
                        return i;
            }
        }
         return -1;
    }
    /*
    @param e : E - the object to be searched for
    @return int - the last index the object is found at
     @requires - <pre> e is a valid object of type E</pre>
    @ensures - the accurate last index of e
    */
    @Override
    public int lastIndexOf(E e)
    {
        int val = -1;
        if(size > 0)
        {
           Node<E> temp = head;
           for(int i = 1; i < size; i++)
            {
                temp = temp.next;
                    if(temp.element.equals(e))
                        val = i;
            }
        }
         return val;
    }
    /*
    @param index : int - the index to set
    @param e : E - the object to be placed at index
    @requires - <pre><@code> index >= 0 && index < size</@code> e is a valid object of type E
    @ensures - the object that e is replacing
    */
    @Override
    public E set(int index, E e)
    {
         if(index < 0 || index > size)
            return null;
         else
         {
             Node<E> temp = head;
             for(int i = 0; i < index; i++)
             {
                 temp = temp.next;
             }
             E n = temp.element;
             temp.element = e;
             return n;
         }
    }
    
    /**
     methods for lab 8 should be implemented here
     */
    
    
    
    
    
    private static class Node<E> {
        E element;
        Node<E> next;
        public Node(E element) {
            this.element = element;
        }
    }
}
    
    
