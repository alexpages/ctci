package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.example.Node;

import java.util.LinkedList;

class MainTest {
    Main mainClass;
    Node node;

    @BeforeEach
    void init() {
        mainClass = new Main();
    }


    @Test
    @Order(1)
    void isUnique() {
        Assertions.assertEquals(false, mainClass.isUnique("hello") );
        Assertions.assertEquals(true, mainClass.isUnique("abc") );
    }

    @Test
    @Order(2)
    void checkPermutation() {
        Assertions.assertEquals(true, mainClass.checkPermutation("abc", "acb") );
        Assertions.assertEquals(false, mainClass.checkPermutation("abc", "ace") );
    }

    @Test
    @Order(3)
    void URLify() {
        Assertions.assertEquals("Mr%20John%20Smith", mainClass.URLify("Mr John Smith ", 13) );
    }

    @Test
    void palindromePermutation() {
        Assertions.assertEquals(true, mainClass.palindromePermutation("Tact Coa") );
        Assertions.assertEquals(true, mainClass.palindromePermutation("taccta") );
        Assertions.assertEquals(false, mainClass.palindromePermutation("tar") );
    }

    @Test
    void oneWay() {
        Assertions.assertEquals(true, mainClass.oneWay("pale","ple") );
        Assertions.assertEquals(true, mainClass.oneWay("pales","pale") );
        Assertions.assertEquals(true, mainClass.oneWay("pale","bale") );
        Assertions.assertEquals(false, mainClass.oneWay("pale","bake") );
        Assertions.assertEquals(true, mainClass.oneWay("pale","pale") );
    }

    @Test
    void stringCompression() {
        Assertions.assertEquals("a2b1c5a3", mainClass.stringCompression("aabcccccaaa") );
        Assertions.assertEquals("abc", mainClass.stringCompression("abc") );
    }

    @Test
    void stringRotation() {
        Assertions.assertEquals(true, mainClass.stringRotation("erbottlewat","waterbottle") );
        Assertions.assertEquals(false, mainClass.stringRotation("erbottle","waterbottle") );
        Assertions.assertEquals(false, mainClass.stringRotation("erbottlewta","waterbottle") );

    }
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
        Assertions.assertEquals(numb2, mainClass.removeDups(numb) );
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
        Assertions.assertEquals(0, mainClass.returnKfromLast(head, 2) );
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
        Assertions.assertEquals(true, mainClass.deleteMiddleNode(inputNode) );
    }
    @Test
    void deleteNode() {
        int[] keys = { 15, 21, 3, 0, 5 };
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        int suma = 15+21+0+5;
        Assertions.assertEquals(suma, mainClass.deleteNode(head, 3) );
    }

    @Test
    void partition() {
        int[] keys = { 3, 5, 8, 5, 10, 2, 1 };
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        int partition = 5;
        Assertions.assertEquals("1->2->3->10->5->8->5", mainClass.partition(head, 5) );
    }
}