package com.tcramer.anubis.core.exception;

import org.apache.commons.exec.ExecuteException;

public class AnubisPythonExecutionException extends ExecuteException {
    public AnubisPythonExecutionException(String message, int exitValue) {
        super(message, exitValue);
    }

    public AnubisPythonExecutionException(String message, int exitValue, Throwable cause) {
        super(message, exitValue, cause);
    }
}
