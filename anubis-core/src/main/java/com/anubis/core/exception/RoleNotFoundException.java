package com.anubis.core.exception;

public class RoleNotFoundException extends RuntimeException {
    public static final String EX_ROLE_NOT_FOUND = "Error: Role is not found.";

    public RoleNotFoundException() {
        super(EX_ROLE_NOT_FOUND);
    }
}
