package com.attri.exceptions;

import com.attri.utils.Constants;

public class EmptyTreeException extends RuntimeException{

    public EmptyTreeException() {
        super(Constants.EMPTY_TREE_EXCEPTION_MESSAGE);
    }
}
