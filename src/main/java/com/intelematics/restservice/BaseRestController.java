package com.intelematics.restservice;

import com.intelematics.exceptions.IntelematicsException;
import com.intelematics.exceptions.IntelematicsIllegalArgumentException;
import com.intelematics.exceptions.IntelematicsValidationException;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ian on 3/1/2016.
 */
public abstract class BaseRestController {

    static final Logger log = Logger.getLogger(BaseRestController.class);

    public static final String errorMessage = "There was a problem handling your request. Please try again or contact the engineering team";

    /**
     * Handles Custom invalid argument exception
     * @param e
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @ExceptionHandler({IntelematicsIllegalArgumentException.class})
    protected Response handleException(IntelematicsIllegalArgumentException e, HttpServletRequest request, HttpServletResponse response) {
        log.error(e.getMessage(), e);
        response.setStatus(e.getStatus());
        return new Response(e.getStatus(), e.getMessage());
    }

    /**
     * Handles a IntelematicsValidationException
     * @param e
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @ExceptionHandler({IntelematicsValidationException.class})
    protected Response handleException(IntelematicsValidationException e, HttpServletRequest request, HttpServletResponse response) {
        log.error(e.getMessage(), e);
        response.setStatus(e.getStatus());
        return new Response(e.getStatus(), e.getDisplayMessage());
    }

    /**
     * Handles an intelematics exception
     * @param e
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @ExceptionHandler({IntelematicsException.class})
    protected Response handleException(IntelematicsException e, HttpServletRequest request, HttpServletResponse response) {
        log.error(e.getMessage(), e);
        response.setStatus(e.getStatus());
        return new Response(e.getStatus(), e.getMessage());
    }

    /**
     * Handles all other exceptions
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler({Exception.class})
    protected Response handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {
        log.error(e.getMessage(), e);
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return new Response(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, errorMessage);
    }

}
