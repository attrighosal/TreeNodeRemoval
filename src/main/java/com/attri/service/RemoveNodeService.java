package com.attri.service;

import com.attri.exceptions.EmptyTreeException;
import com.attri.model.Node;

import java.util.Vector;

public class RemoveNodeService {

    public  Vector<Integer> removeNode(Node<Integer> root, int nodeToBeRemoved) {
        // 1. If root is null
        if (root==null) {
            throw new EmptyTreeException();
        }

        Vector<Integer> rootsAfterDeletion = new Vector<>();

        // 2. Root is not null and root is the value
        if (root.getValue()==nodeToBeRemoved) {
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
            recursiveDelete(root.getLeft(), nodeToBeRemoved, rootsAfterDeletion);
            recursiveDelete(root.getRight(), nodeToBeRemoved, rootsAfterDeletion);
        }
        return rootsAfterDeletion;
    }

    private void recursiveDelete(Node<Integer> node, int nodeToBeRemoved, Vector<Integer> rootsAfterDeletion) {
        if (node!=null) {
            if (node.getValue()==nodeToBeRemoved) {
                if (node.getLeft() != null) {
                    rootsAfterDeletion.add(node.getLeft().getValue());
                }
                if (node.getRight() != null) {
                    rootsAfterDeletion.add(node.getRight().getValue());
                }
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
    }
}
