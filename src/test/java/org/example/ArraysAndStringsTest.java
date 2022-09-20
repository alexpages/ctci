package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArraysAndStringsTest {

    @Test
    void isUnique() {
        Assertions.assertEquals(false, ArraysAndStrings.isUnique("hello") );
        Assertions.assertEquals(true, ArraysAndStrings.isUnique("abc") );
    }
    @Test
    void checkPermutation() {
        Assertions.assertEquals(true, ArraysAndStrings.checkPermutation("abc", "acb") );
        Assertions.assertEquals(false, ArraysAndStrings.checkPermutation("abc", "ace") );
    }
    @Test
    void URLify() {
        Assertions.assertEquals("Mr%20John%20Smith", ArraysAndStrings.URLify("Mr John Smith ", 13) );
    }

    @Test
    void palindromePermutation() {
        Assertions.assertEquals(true, ArraysAndStrings.palindromePermutation("Tact Coa") );
        Assertions.assertEquals(true, ArraysAndStrings.palindromePermutation("taccta") );
        Assertions.assertEquals(false, ArraysAndStrings.palindromePermutation("tar") );
    }
    @Test
    void oneWay() {
        Assertions.assertEquals(true, ArraysAndStrings.oneWay("pale","ple") );
        Assertions.assertEquals(true, ArraysAndStrings.oneWay("pales","pale") );
        Assertions.assertEquals(true, ArraysAndStrings.oneWay("pale","bale") );
        Assertions.assertEquals(false, ArraysAndStrings.oneWay("pale","bake") );
        Assertions.assertEquals(true, ArraysAndStrings.oneWay("pale","pale") );
    }
    @Test
    void stringCompression() {
        Assertions.assertEquals("a2b1c5a3", ArraysAndStrings.stringCompression("aabcccccaaa") );
        Assertions.assertEquals("abc", ArraysAndStrings.stringCompression("abc") );
    }
    @Test
    void stringRotation() {
        Assertions.assertEquals(true, ArraysAndStrings.stringRotation("erbottlewat","waterbottle") );
        Assertions.assertEquals(false, ArraysAndStrings.stringRotation("erbottle","waterbottle") );
        Assertions.assertEquals(false, ArraysAndStrings.stringRotation("erbottlewta","waterbottle") );
    }

}