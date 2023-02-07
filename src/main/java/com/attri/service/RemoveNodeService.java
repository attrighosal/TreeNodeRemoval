package com.attri.service;

import com.attri.algorithms.RemoveNodeStrategy;
import com.attri.model.Node;

import java.util.Vector;

public class RemoveNodeService {

    private final RemoveNodeStrategy<Integer> removeNodeStrategy;

    public RemoveNodeService(final RemoveNodeStrategy<Integer> removeNodeStrategy) {
        this.removeNodeStrategy = removeNodeStrategy;
    }

    public  Vector<Integer> removeNode(Node<Integer> root, int nodeToBeRemoved) {
        return removeNodeStrategy.removeNode(root, nodeToBeRemoved);
    }


}
