package com.javaclass;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DLLTest {

    DLL myDoubleLinkedList;

    @BeforeMethod

    public void setup(){
        myDoubleLinkedList = new DLL();
        myDoubleLinkedList.add("First Node");
        myDoubleLinkedList.add("Second Node");
        myDoubleLinkedList.add("Third Node");
    }

    @Test()
    public void testGetLast() {

        Node aNode = myDoubleLinkedList.getLast();

        Assert.assertEquals(aNode.getData(),"Third Node","Expected last node to be Third Node");
    }
    @Test()
    public void testSize() {

        Node aNode = myDoubleLinkedList.getLast();

        Assert.assertEquals(myDoubleLinkedList.size(),3,"Expected size to return 3");
    }

    @Test()
    public void testAdd() {

        Node aNode = myDoubleLinkedList.add("Fourth Node");

        Assert.assertEquals(aNode.getData(),"Fourth Node","Expected value to be Fourth Node");
        Assert.assertEquals(myDoubleLinkedList.getLast().getData(),"Fourth Node","Expected value to be Fourth Node");
        Assert.assertEquals(myDoubleLinkedList.size(),4,"Expected size to return 4");
    }
}
