package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class MainTest {
    Main mainClass;

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
}