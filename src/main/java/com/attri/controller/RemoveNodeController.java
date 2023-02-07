package com.attri.controller;

import com.attri.dto.RemoveNodeResponse;
import com.attri.model.Node;
import com.attri.service.RemoveNodeService;
import com.attri.utils.Constants;

import java.util.Vector;

public class RemoveNodeController {

    private final RemoveNodeService service;

    public RemoveNodeController(final RemoveNodeService service) {
        this.service = service;
    }

    public RemoveNodeResponse<Integer> removeNode(Node<Integer> root, int nodeToBeRemoved) {

        try {
            Vector<Integer> newRoots = service.removeNode(root, nodeToBeRemoved);
            return new RemoveNodeResponse<>(Constants.HTTP_SUCCESS_STATUS_CODE,
                    newRoots, Constants.HTTP_SUCCESS_MESSAGE);
        } catch (Exception e) {
            // log here
            return new RemoveNodeResponse<>(Constants.HTTP_ERROR_STATUS_CODE,
                    null, e.getMessage());
        }
    }
}
