package com.attri.exceptions;

public class EmptyTreeException extends RuntimeException{

    public EmptyTreeException() {
        super("The root of the given tree is null");
    }
}
