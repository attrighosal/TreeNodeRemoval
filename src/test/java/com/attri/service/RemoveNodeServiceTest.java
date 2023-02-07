package com.attri.service;

import com.attri.algorithms.RemoveNodeRecursively;
import com.attri.exceptions.EmptyTreeException;
import com.attri.model.Node;
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
public class RemoveNodeServiceTest {

    @Mock
    private RemoveNodeRecursively<Integer> removeNodeRecursively;
    private static RemoveNodeService removeNodeService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        removeNodeService = new RemoveNodeService(removeNodeRecursively);
    }

    @Test
    public void testEmptyTree() {

        Mockito
                .when(removeNodeRecursively.removeNode(Mockito.isNull(), Mockito.anyInt()))
                .thenThrow(new EmptyTreeException());

        Assertions
                .assertThrows(EmptyTreeException.class, () -> removeNodeService.removeNode(null, 0));
    }

    @Test
    public void testWithValidInput() {

        Mockito
                .when(removeNodeRecursively.removeNode(Mockito.any(), Mockito.anyInt()))
                .thenReturn(new Vector<>(Arrays.asList(1,2,3)));

        Vector<Integer> expectedResult = new Vector<>(Arrays.asList(1,2,3));

        Assertions.assertEquals(expectedResult, removeNodeService.removeNode(new Node<>(1), 0));
    }
}
