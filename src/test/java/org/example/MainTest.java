package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

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
}