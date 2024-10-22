package com.plea11.ahms.common.exception;

import java.io.Serial;

/**
 * @author bhukyabhanuprakash
 */
public class DAOException extends AppServerException {

    @Serial
    private static final long serialVersionUID = 1L;

    public DAOException(String errorMessage) {
        super(errorMessage);
    }

    public DAOException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
