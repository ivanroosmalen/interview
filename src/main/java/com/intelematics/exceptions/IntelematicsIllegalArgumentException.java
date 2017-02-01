package com.intelematics.exceptions;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ian on 2/29/2016.
 */
public class IntelematicsIllegalArgumentException extends IntelematicsException {

    private final int status = HttpServletResponse.SC_BAD_REQUEST;

    public IntelematicsIllegalArgumentException(String message) {
        super(message);
    }

    public int getStatus() {
        return this.status;
    }
}
