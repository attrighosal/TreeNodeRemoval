package com.attri.algorithms;

import com.attri.model.Node;

import java.util.Vector;

public interface RemoveNodeStrategy<T> {

    Vector<T> removeNode(Node<T> root, int valueToBeRemoved);
}
