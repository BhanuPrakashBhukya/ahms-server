package com.plea11.ahms.common.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.Date;

/**
 * @author bhukyabhanuprakash
 */
@Setter
@Getter
public class AppServerException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    private Date timestamp;
    private String message;
    private String details;

    public AppServerException(final String errorMessage) {
        super();
        this.message = errorMessage;
    }

    public AppServerException(final String errorMessage, final Throwable cause) {
        super(errorMessage, cause);
    }

    public AppServerException(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

}
