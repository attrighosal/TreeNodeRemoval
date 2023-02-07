package com.attri.service;

import com.attri.algorithms.RemoveNodeRecursively;
import com.attri.algorithms.RemoveNodeStrategy;
import com.attri.model.Node;

import java.util.Vector;

public class RemoveNodeService {

    RemoveNodeStrategy<Integer> removeNodeStrategy;

    public RemoveNodeService() {
        removeNodeStrategy = new RemoveNodeRecursively<>();
    }

    public  Vector<Integer> removeNode(Node<Integer> root, int nodeToBeRemoved) {
        return removeNodeStrategy.removeNode(root, nodeToBeRemoved);
    }


}
