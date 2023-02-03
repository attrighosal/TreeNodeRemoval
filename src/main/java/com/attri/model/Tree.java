package com.attri.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Tree<T> {

    private final Node<T> root;

    public Tree(T[][] edges, T root) {
        this.root = constructTreeRecursively(createAdjacencyMap(edges), root);
    }

    private Map<T, List<T>> createAdjacencyMap(T[][] edges) {
        Map<T, List<T>> adjacencyMap = new HashMap<>();
        for (T[] edge: edges) {
            adjacencyMap.putIfAbsent(edge[0], new LinkedList<>());
            adjacencyMap.putIfAbsent(edge[1], new LinkedList<>());
            adjacencyMap.get(edge[0]).add(edge[1]);
        }
        return adjacencyMap;
    }

    private Node<T> constructTreeRecursively(Map<T, List<T>> adjacencyMap, T nodeValue) {
        Node<T> node = new Node<>(nodeValue);

        // Construct left node
        if (adjacencyMap.get(nodeValue).size()>0) {
            node.setLeft(constructTreeRecursively(adjacencyMap, adjacencyMap.get(nodeValue).get(0)));
        }

        // Construct right node
        if (adjacencyMap.get(nodeValue).size()>1) {
            node.setRight(constructTreeRecursively(adjacencyMap, adjacencyMap.get(nodeValue).get(1)));
        }

        return node;
    }

    public Node<T> getRoot() {
        return root;
    }
}
