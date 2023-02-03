package com.attri;

import com.attri.model.Tree;
import com.attri.service.RemoveNodeService;

public class RemoveNodeApp {

    public static void main(String[] args) {

        RemoveNodeService removeNodeService = new RemoveNodeService();

        // Create Tree
        Integer[][] edges = new Integer[][] {{1,2}, {1,3}, {2,4}, {2,5}};
        Tree<Integer> tree = new Tree<>(edges, 1);

        System.out.println(removeNodeService.removeNode(tree.getRoot(), 0));
        System.out.println(removeNodeService.removeNode(tree.getRoot(), 1));
        System.out.println(removeNodeService.removeNode(tree.getRoot(), 2));
    }
}
