package com.attri.service;

import com.attri.exceptions.EmptyTreeException;
import com.attri.model.Tree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class RemoveNodeServiceTest {

    private final static RemoveNodeService removeNodeService = new RemoveNodeService();

    @Test
    public void testEmptyTree() {

        Assertions.assertThrows(EmptyTreeException.class, () -> removeNodeService.removeNode(null, 0));

    }

    @Test
    public void testDeleteRoot() {
        Integer[][] edges = new Integer[][] {{1,2}, {1,3}, {2,4}, {2,5}};
        Tree<Integer> tree = new Tree<>(edges, 1);

        Vector<Integer> expectedResult = new Vector<>(Arrays.asList(2,3)) ;
        Assertions.assertEquals(removeNodeService.removeNode(tree.getRoot(), 1), expectedResult);
    }

    @Test
    public void testDeleteNonRootNodeWithTwoChildren() {
        Integer[][] edges = new Integer[][] {{1,2}, {1,3}, {2,4}, {2,5}};
        Tree<Integer> tree = new Tree<>(edges, 1);

        Vector<Integer> expectedResult = new Vector<>(Arrays.asList(1,4,5)) ;
        Assertions.assertEquals(removeNodeService.removeNode(tree.getRoot(), 2), expectedResult);
    }

    @Test
    public void testDeleteNonRootNodeWithZeroChildren() {
        Integer[][] edges = new Integer[][] {{1,2}, {1,3}, {2,4}, {2,5}};
        Tree<Integer> tree = new Tree<>(edges, 1);

        Vector<Integer> expectedResult = new Vector<>(List.of(1)) ;
        Assertions.assertEquals(removeNodeService.removeNode(tree.getRoot(), 3), expectedResult);
    }

    @Test
    public void testDeleteNonRootNodeWithOneChild() {
        Integer[][] edges = new Integer[][] {{1,2}, {1,3}, {2,4}, {2,5}, {3,6}};
        Tree<Integer> tree = new Tree<>(edges, 1);

        Vector<Integer> expectedResult = new Vector<>(Arrays.asList(1, 6));
        Assertions.assertEquals(removeNodeService.removeNode(tree.getRoot(), 3), expectedResult);
    }

    @Test
    public void testDeleteNonExistentNode() {
        Integer[][] edges = new Integer[][] {{1,2}, {1,3}, {2,4}, {2,5}};
        Tree<Integer> tree = new Tree<>(edges, 1);

        Vector<Integer> expectedResult = new Vector<>(List.of(1));
        Assertions.assertEquals(removeNodeService.removeNode(tree.getRoot(), 0), expectedResult);
    }
}
