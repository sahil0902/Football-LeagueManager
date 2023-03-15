package Portfolio_Challenge.Lists;

// See also: https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html

import Portfolio_Challenge.Lists.ListNode;


import java.util.Objects;

/**
 * Doubly-linked list implementation
 */
public class LinkedList implements Portfolio_Challenge.Lists.List, Portfolio_Challenge.Lists.Stack, Portfolio_Challenge.Lists.Queue {

    private final Portfolio_Challenge.Lists.ListNode header;    // A pointer to header (sentinel node)
    private final ListNode trailer;   // A pointer to trailer (sentinel node)
    private int size;           // The number of elements in the list

    /**
     * Creates a doubly linked list
     */
    public LinkedList() {

        header = new Portfolio_Challenge.Lists.ListNode(null,null,null); // Creates header node
        trailer = new Portfolio_Challenge.Lists.ListNode(null,header,null);  // Creates trailer node
        header.setNext(trailer); // Sets header's next to trailer
        size = 0; // Sets size to 0
    }

    @Override
    public String toString() {
        // Initializes a StringBuilder to hold the contents
        StringBuilder contents = new StringBuilder("Contents:{");

        // Starts at the first element in the list (after the header)
        Portfolio_Challenge.Lists.ListNode currNode = header.getNext();

        // Iterates through the list until we reach the trailer
        while(currNode != trailer){
            // Appends the element of the current node to the StringBuilder
            contents.append(currNode.getElement());

            // Moves to the next node
            currNode = currNode.getNext();

            // If the current node is not the trailer, append a comma separator
            if (currNode != trailer) contents.append(",");
        }

        // Appends the closing bracket and return the resulting string
        contents.append("}");
        return contents.toString();
    }
    @Override
    public int size() {
        // Returns the number of elements in the list, which is stored as a field
        return size;
    }


    @Override
    public boolean isEmpty() {
        // Return true if the size of the list is 0, false otherwise
        return size() == 0;
    }


    @Override
    public boolean contains(String element) {
        // Check if the list is empty
        if(!isEmpty()){
            // Start at the first element in the list (after the header)
             Portfolio_Challenge.Lists.ListNode currNode = header.getNext();

            // Iterate through the list until we reach the trailer
            do{
                // Check if the element of the current node is equal to the target element
                if(currNode.getElement().equals(element)){
                    return true;
                }

                // Move to the next node
                currNode = currNode.getNext();
            } while(currNode != trailer);
        }

        // If the element was not found, return false
        return false;
    }

    @Override
    public boolean addFirst(String element) {
        // Inserts the element at the beginning of the list (before the first element)
        return addBetween(element, header, header.getNext());
    }


    @Override
    public boolean addLast(String element) {
        // Inserts the element at the end of the list (after the last element)
        return addBetween(element, trailer.getPrev(), trailer);
    }

    @Override
    public boolean add(int index, String element) {
        // Checks if the index is valid
        checkIndex(index);

        // Inserts the element at the beginning of the list if the index is 0
        if(index == 0){
            return addFirst(element);
        } else {
            // Starts at the first element in the list (after the header)
            ListNode currNode = header.getNext();

            // Iterates through the list until we reach the correct position
            while (index > 0) {
                currNode = currNode.getNext();
                index--;
            }

            // Inserts the element between the previous and current nodes
            return addBetween(element,currNode.getPrev(),currNode);
        }
    }

    @Override
    public String first() {
        // Return the first element in the list, or null if the list is empty
        if(isEmpty()){
            return null;
        } else {
            return header.getNext().getElement();
        }
    }

    @Override
    public String last() {
        // Return the last element in the list, or null if the list is empty
        if(isEmpty()){
            return null;
        } else {
            return trailer.getPrev().getElement();
        }
    }

    @Override
    public String get(int index) {
        // Check if the index is valid
        checkIndex(index);

        // Return the first element if the index is 0
        if(index == 0){
            return header.getNext().getElement();
        }
        // Return the last element if the index is size()-1
        else if (index == size()-1) {
            return trailer.getPrev().getElement();
        }
        // Otherwise, iterate through the list to find the correct element
        else {
            ListNode currNode = header.getNext();
            while(index > 0){
                currNode = currNode.getNext();
                index--;
            }
            return currNode.getElement();
        }
    }


    @Override
    public String removeFirst() {
        // Remove and return the first element in the list, or null if the list is empty
        if(isEmpty()){
            return null;
        } else {
            return remove(header.getNext());
        }
    }

    @Override
    public String removeLast() {
        // Remove and return the last element in the list, or null if the list is empty
        if(isEmpty()){
            return null;
        } else {
            return remove(trailer.getPrev());
        }
    }

    @Override
    public boolean remove(String element) {
        // Iterate through the list to find the element and remove it
        if(!isEmpty()){
            ListNode currNode = header.getNext();
            do{
                // Check if the element of the current node is equal to the target element
                if(Objects.equals(currNode.getElement(), element)){
                    remove(currNode);
                    return true;
                }
                currNode = currNode.getNext();
            } while(currNode != trailer);
        }
        return false;
    }

    @Override
    public String remove(int index) {
        // Check if the index is valid
        checkIndex(index);

        // Remove and return the first element if the index is 0
        if(index == 0){
            return removeFirst();
        }
        // Remove and return the last element if the index is size()-1
        else if (index == size()-1) {
            return removeLast();
        }
        // Otherwise, iterate through the list to find the correct element and remove it
        else {
            ListNode currNode = header.getNext();
            while(index > 0){
                currNode = currNode.getNext();
                index--;
            }
            return remove(currNode);
        }
    }

    private String remove(ListNode currNode){
        ListNode prevNode = currNode.getPrev();
        ListNode nextNode = currNode.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        size--;

        return currNode.getElement();
    }

    /* Stack Interface */

    @Override
    public String push(String element) {
        // Add the element to the beginning of the list
        addBetween(element, header, header.getNext());
        return header.getNext().getElement();
    }

    @Override
    public String top() {
        // Return the first element in the list, or null if the list is empty
        if(isEmpty()) {
            return null;
        } else {
            return header.getNext().getElement();
        }
    }

    @Override
    public String pop() {
        // Remove and return the first element in the list, or null if the list is empty
        if(isEmpty()){
            return null;
        } else {
            return remove(header.getNext());
        }
    }

    /* Queue Interface */

    @Override
    public boolean enqueue(String element) {
        // Add the element to the end of the queue
        return addBetween(element,trailer.getPrev(),trailer);
    }

    @Override
    public String dequeue() {
        // Remove and return the first element in the queue, or null if the queue is empty
        return remove(header.getNext());
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Index "+ index + " out of bound.");
        }
    }

    private boolean addBetween(String element, ListNode prevNode, ListNode nextNode){
        ListNode newNode = new ListNode(element,prevNode,nextNode);
        prevNode.setNext(newNode);
        nextNode.setPrev(newNode);
        size++;

        return true;
    }

}