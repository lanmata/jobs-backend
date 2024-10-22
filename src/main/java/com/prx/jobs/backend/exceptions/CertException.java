package com.prx.jobs.backend.exceptions;

public class CertException extends Exception {
    private static final long serialVersionUID = 5398385356196282905L;

    public CertException() {
        super();
    }

    public CertException(String message) {
        super(message);
    }

    public CertException(String message, Throwable cause) {
        super(message, cause);
    }

    public CertException(Throwable cause) {
        super(cause);
    }

    public CertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
