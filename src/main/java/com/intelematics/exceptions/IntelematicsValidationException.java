package com.intelematics.exceptions;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Ian on 3/2/2016.
 */
public class IntelematicsValidationException extends IntelematicsException {

    private List<String> errorMessages;

    private final int status = HttpServletResponse.SC_BAD_REQUEST;

    /**
     * Constructor
     * @param message
     */
    public IntelematicsValidationException(String message) {
        super(message);
    }

    /**
     * Constructor for validation exception
     * @param message
     * @param errorMessages
     */
    public IntelematicsValidationException(String message, List<String> errorMessages) {
        super(message);
        this.errorMessages = errorMessages;
    }

    /**
     * Returns all the error messages from the validatable object
     * @return
     */
    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public String getDisplayMessage() {
        String displayMessage="";

        if(this.errorMessages == null || this.errorMessages.isEmpty()) {
            displayMessage = this.getMessage();
        } else {
            for(String message : this.errorMessages) {
                displayMessage = displayMessage + message + "<br/>";
            }
        }

        return displayMessage;
    }

    public int getStatus() {
        return this.status;
    }
}
