package com.attri.dto;

import java.util.Vector;

public class RemoveNodeResponse<T> extends BaseResponse {

    public RemoveNodeResponse(int statusCode, Vector<T> newRoots, String message) {
        super(statusCode, newRoots, message);
    }
}
