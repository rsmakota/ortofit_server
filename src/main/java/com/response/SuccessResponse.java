package com.response;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2018-04-16
 * Copyright  "Commercegate LTD"
 */
public class SuccessResponse implements IResponse {
    @Override
    public boolean isSuccess() {
        return true;
    }
}
