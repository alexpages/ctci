package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.example.Node;

import java.util.LinkedList;

class MainTest {
    Main mainClass;

    @BeforeEach
    void init() {
        mainClass = new Main();
    }
}