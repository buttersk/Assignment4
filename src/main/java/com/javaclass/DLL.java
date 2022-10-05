package com.javaclass;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DLL {

    private Node node;
    protected static final Logger logger = LogManager.getLogger(DLL.class);
    static final String NEW_LINE = System.lineSeparator();

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Node add(String data){
        Node newNode = new Node();
        Node lastNode;

        newNode.setData(data);

        if (this.node == null) {
            node = newNode;
        }
        else {
            lastNode = getLast();
            lastNode.setNext(newNode);
            newNode.setPrevious(lastNode);
        }
        return newNode;
    }


    public Node getLast(){
        Node aNode = this.node;

        if(aNode != null) {
            while (aNode.getNext() != null) {
                aNode = aNode.getNext();
            }
        }
        return aNode;
    }

    public void deleteNode(Node delNode){
        Node prevNode = delNode.getPrevious();
        Node nextNode = delNode.getNext();

        if(prevNode != null) {
                prevNode.setNext(nextNode);
        }
        if(nextNode != null){
                nextNode.setPrevious(prevNode);
        }
    }

    public int size(){
        Node aNode = this.node;
        int listSize = 0;
        if(aNode != null) {
            listSize++;
            while (aNode.getNext() != null) {
                listSize++;
                aNode = aNode.getNext();
            }
        }
        return listSize;
    }

    public void printListForward(){
        Node aNode = this.getNode();
        int count = 0;



        while(aNode != null){
            count++;
            logger.debug("{}) {}",count,aNode.getData());
            aNode = aNode.getNext();
        }
        logger.debug("{}",NEW_LINE);
    }

    public void printListBackward(){
        Node aNode = this.getLast();
        int count = this.size();

        while(aNode != null){
            logger.debug("{}) {}",count,aNode.getData());
            aNode = aNode.getPrevious();
            count--;
        }
        logger.debug("{}",NEW_LINE);
    }
    public static void main(String[] args) {

        Node aNode;

        DLL doubleLinkedList = new DLL();

        aNode = doubleLinkedList.add("First Node");
        logger.debug("Added Node : {}",aNode.getData());

        aNode = doubleLinkedList.add("Second Node");
        logger.debug("Added Node : {}",aNode.getData());

        aNode = doubleLinkedList.add("Third Node");
        logger.debug("Added Node : {}",aNode.getData());

        aNode = doubleLinkedList.getLast();
        logger.debug("Size of list = {}{}",doubleLinkedList.size(),NEW_LINE);

        // print list forwards
        logger.debug("Print List Forwards{}",NEW_LINE);
        doubleLinkedList.printListForward();

        // print list backwards
        logger.debug("Print List Backwards{}",NEW_LINE);
        doubleLinkedList.printListBackward();

        logger.debug("Deleting Last Node{}",NEW_LINE);
        doubleLinkedList.deleteNode(doubleLinkedList.getLast());

        logger.debug("New size of list = {}", doubleLinkedList.size());
        logger.debug("New last Node is : {}", doubleLinkedList.getLast().getData());


        // print list forwards
        logger.debug("Print List Forwards{}",NEW_LINE);
        doubleLinkedList.printListForward();

        // print list backwards
        logger.debug("Print List Backwards{}",NEW_LINE);
        doubleLinkedList.printListBackward();

    }
}
