package org.example;

import auxiliarClasses.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class LinkedListsTest {
    @Test
    void removeDups() {
        LinkedList numb = new LinkedList<>();
        numb.add(12);
        numb.add(11);
        numb.add(12);
        numb.add(21);
        numb.add(41);
        numb.add(43);
        numb.add(21);
        LinkedList numb2 = new LinkedList<>();
        numb2.add(12);
        numb2.add(11);
        numb2.add(21);
        numb2.add(41);
        numb2.add(43);
        Assertions.assertEquals(numb2, LinkedLists.removeDups(numb) );
    }
    @Test
    void returnNfromLast() {
        // input keys
        int[] keys = { 15, 21, 3, 0, 5 };
        // create single linked list
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        Assertions.assertEquals(0, LinkedLists.returnKfromLast(head, 2) );
    }
    @Test
    void deleteMiddleNode() {
        int[] keys = { 15, 21, 3, 0, 5 };
        Node head = null;
        Node inputNode = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
            if (head.data==3){
                inputNode = head;
            }
        }
        Assertions.assertEquals(true, LinkedLists.deleteMiddleNode(inputNode) );
    }
    @Test
    void deleteNode() {
        int[] keys = { 15, 21, 3, 0, 5 };
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        int suma = 15+21+0+5;
        Assertions.assertEquals(suma, LinkedLists.deleteNode(head, 3) );
    }
    @Test
    void partition() {
        int[] keys = { 3, 5, 8, 5, 10, 2, 1 };
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        int partition = 5;
        Assertions.assertEquals("1->2->3->10->5->8->5", LinkedLists.partition(head, 5) );
    }
    @Test
    void sumListsBackwards() {
        int[] keys1 = { 7, 1, 6 };
        Node n1 = null;
        for (int i = keys1.length - 1; i >= 0; i--) {
            n1 = new Node(keys1[i], n1);
        }

        int[] keys2 = { 5, 9, 2 };
        Node n2 = null;
        for (int i = keys2.length - 1; i >= 0; i--) {
            n2 = new Node(keys2[i], n2);
        }
        Assertions.assertEquals("2->1->9", LinkedLists.sumListsBackwards(n1, n2) );
    }
    @Test
    void palindromeLinkedList() {
        int[] keys = { 1, 3, 3, 1};
        Node n1 = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            n1 = new Node(keys[i], n1);
        }
        int[] keys2 = { 1, 3, 1};
        Node n2 = null;
        for (int i = keys2.length - 1; i >= 0; i--) {
            n2 = new Node(keys2[i], n2);
        }

        int[] keys3 = { 1, 3, 5, 1};
        Node n3 = null;
        for (int i = keys3.length - 1; i >= 0; i--) {
            n3 = new Node(keys3[i], n3);
        }
        Assertions.assertEquals(true, LinkedLists.palindromeLinkedList(n1) );
        Assertions.assertEquals(true, LinkedLists.palindromeLinkedList(n2) );
        Assertions.assertEquals(false, LinkedLists.palindromeLinkedList(n3) );
    }
    @Test
    void intersection() {
        //2.7
        int[] keys = { 3, 1, 5, 9};
        Node n1 = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            n1 = new Node(keys[i], n1);
        }

        int[] keys2 = {4, 6};
        Node n2 = null;
        for (int i = keys2.length - 1; i >= 0; i--) {
            n2 = new Node(keys2[i], n2);
        }

        int[] keys3 = {7, 2, 1};
        Node n3 = null;
        for (int i = keys3.length - 1; i >= 0; i--) {
            n3 = new Node(keys3[i], n3);
        }

        Node auxiliarN1 = n1;
        Node auxiliarN2 = n2;
        while(auxiliarN1!=null){
            if (auxiliarN1.next==null){
                auxiliarN1.next=n3;
                break;
            }
            auxiliarN1=auxiliarN1.next;
        }
        while(auxiliarN2!=null){
            if (auxiliarN2.next==null){
                auxiliarN2.next=n3;
                break;
            }
            auxiliarN2=auxiliarN2.next;
        }
        Assertions.assertEquals(n3, LinkedLists.intersection(n1, n2) );
        int[] keys4 = {7, 2, 1};
        Node n4 = null;
        for (int i = keys4.length - 1; i >= 0; i--) {
            n4 = new Node(keys4[i], n4);
        }

        Assertions.assertEquals(null, LinkedLists.intersection(n1, n4) );
    }
    @Test
    void loopDetection() {
        int[] keys = { 1, 3, 3, 1};
        Node n1 = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            n1 = new Node(keys[i], n1);
        }
        Node auxiliarNode = n1;

        while (auxiliarNode!=null){
            if (auxiliarNode.next==null){
                auxiliarNode.next=n1;
                break;
            }
            auxiliarNode=auxiliarNode.next;
        }
        int[] keys4 = {7, 2, 1};
        Node n4 = null;
        for (int i = keys4.length - 1; i >= 0; i--) {
            n4 = new Node(keys4[i], n4);
        }
        Assertions.assertEquals(n1, LinkedLists.loopDetection(n1) );
        Assertions.assertEquals(null, LinkedLists.loopDetection(n4) );
    }

}