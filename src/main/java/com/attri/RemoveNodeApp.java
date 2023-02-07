package com.attri;

import com.attri.algorithms.RemoveNodeRecursively;
import com.attri.algorithms.RemoveNodeStrategy;
import com.attri.controller.RemoveNodeController;
import com.attri.model.Tree;
import com.attri.service.RemoveNodeService;

public class RemoveNodeApp {

    public static void main(String[] args) {

        // Dependency Injection
        RemoveNodeStrategy<Integer> removeNodeRecursively = new RemoveNodeRecursively<>();
        RemoveNodeService removeNodeService = new RemoveNodeService(removeNodeRecursively);
        RemoveNodeController controller = new RemoveNodeController(removeNodeService);

        // Create Tree
        Integer[][] edges = new Integer[][] {{1,2}, {1,3}, {2,4}, {2,5}};
        Tree<Integer> tree = new Tree<>(edges, 1);

        // Run use cases
        System.out.println(controller.removeNode(tree.getRoot(), 0));
        System.out.println(controller.removeNode(tree.getRoot(), 1));
        System.out.println(controller.removeNode(tree.getRoot(), 2));
    }
}
