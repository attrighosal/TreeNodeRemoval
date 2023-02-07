package com.attri.algorithms;

import com.attri.exceptions.EmptyTreeException;
import com.attri.model.Node;

import java.util.Vector;

public class RemoveNodeRecursively<T> implements  RemoveNodeStrategy<T> {

    @Override
    public Vector<T> removeNode(Node<T> root, int nodeToBeRemoved) {

        // 1. If root is null
        if (root==null) {
            throw new EmptyTreeException();
        }

        Vector<T> rootsAfterDeletion = new Vector<>();

        // 2. Root is not null and root is the value
        if (root.getValue().equals(nodeToBeRemoved)) {
            if (root.getLeft()!=null) {
                rootsAfterDeletion.add(root.getLeft().getValue());
            }
            if (root.getRight()!=null) {
                rootsAfterDeletion.add(root.getRight().getValue());
            }
        }
        // 3. Root is not null and root is not the value
        else {
            rootsAfterDeletion.add(root.getValue());
            root.setLeft(recursiveDelete(root.getLeft(), nodeToBeRemoved, rootsAfterDeletion));
            root.setRight(recursiveDelete(root.getRight(), nodeToBeRemoved, rootsAfterDeletion));
        }
        return rootsAfterDeletion;
    }

    private Node<T> recursiveDelete(Node<T> node, int nodeToBeRemoved,
                                          Vector<T> rootsAfterDeletion) {
        if (node!=null) {
            if (node.getValue().equals(nodeToBeRemoved)) {
                if (node.getLeft() != null) {
                    rootsAfterDeletion.add(node.getLeft().getValue());
                }
                if (node.getRight() != null) {
                    rootsAfterDeletion.add(node.getRight().getValue());
                }
                return null;
            }
            else {
                if (rootsAfterDeletion.size()<3) {
                    recursiveDelete(node.getLeft(), nodeToBeRemoved, rootsAfterDeletion);
                }
                if (rootsAfterDeletion.size()<3) {
                    recursiveDelete(node.getRight(), nodeToBeRemoved, rootsAfterDeletion);
                }
            }
        }
        return node;
    }
}
