package com.intelematics.exceptions;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ian on 1/31/2017.
 */
public class IntelematicsException extends RuntimeException {

    private final int status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

    public IntelematicsException(String message) {
        super(message);
    }

    public IntelematicsException(String message, Throwable cause) {
        super(message, cause);
    }

    public int getStatus() {
        return this.status;
    }
}
