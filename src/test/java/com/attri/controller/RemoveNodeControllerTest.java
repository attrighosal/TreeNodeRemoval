package com.attri.controller;

import com.attri.dto.RemoveNodeResponse;
import com.attri.exceptions.EmptyTreeException;
import com.attri.model.Node;
import com.attri.service.RemoveNodeService;
import com.attri.utils.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Vector;

@RunWith(MockitoJUnitRunner.class)
public class RemoveNodeControllerTest {

    @Mock
    private RemoveNodeService removeNodeService;

    private static RemoveNodeController removeNodeController;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        removeNodeController = new RemoveNodeController(removeNodeService);
    }

    @Test
    public void testWhenServiceThrowsException() {
        Mockito
                .when(removeNodeService.removeNode(Mockito.isNull(), Mockito.anyInt()))
                .thenThrow(new EmptyTreeException());

        RemoveNodeResponse<Integer> expectedResponse =
                new RemoveNodeResponse<>(Constants.HTTP_ERROR_STATUS_CODE,
                        null, Constants.EMPTY_TREE_EXCEPTION_MESSAGE);

        RemoveNodeResponse<Integer> actualResponse = removeNodeController.removeNode(null, 0);

        Assertions.assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        Assertions.assertEquals(expectedResponse.getObject(), actualResponse.getObject());
        Assertions.assertEquals(expectedResponse.getMessage(), actualResponse.getMessage());
    }

    @Test
    public void testWhenServiceReturnsOutput() {

        Vector<Integer> result = new Vector<>(Arrays.asList(1,2,3));

        Mockito
                .when(removeNodeService.removeNode(Mockito.any(), Mockito.anyInt()))
                .thenReturn(result);

        RemoveNodeResponse<Integer> expectedResponse =
                new RemoveNodeResponse<>(Constants.HTTP_SUCCESS_STATUS_CODE,
                        result, Constants.HTTP_SUCCESS_MESSAGE);

        RemoveNodeResponse<Integer> actualResponse = removeNodeController.removeNode(new Node<>(1), 0);

        Assertions.assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        Assertions.assertEquals(expectedResponse.getObject(), actualResponse.getObject());
        Assertions.assertEquals(expectedResponse.getMessage(), actualResponse.getMessage());
    }
}
