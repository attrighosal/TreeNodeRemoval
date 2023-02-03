package com.attri.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TreeTest {

    @Test
    public void testTreeConstruction() {

        Integer[][] edges = new Integer[][] {{1,2}, {1,3}, {2,4}, {2,5}};
        Tree<Integer> tree = new Tree<>(edges, 1);

        Assertions.assertEquals(tree.getRoot().getValue(), 1);
        Assertions.assertEquals(tree.getRoot().getLeft().getValue(), 2);
        Assertions.assertEquals(tree.getRoot().getRight().getValue(), 3);
        Assertions.assertEquals(tree.getRoot().getLeft().getLeft().getValue(), 4);
        Assertions.assertEquals(tree.getRoot().getLeft().getRight().getValue(), 5);
    }
}
