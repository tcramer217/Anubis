package com.anubis.core.constants;

public enum Roles {
    ROLE_USER("USER", "user"),
    ROLE_ADMINISTRATOR("ADMINISTRATOR", "admin"),
    ROLE_MODERATOR("MODERATOR", "mod"),
    ROLE_CHILD("CHILD", "kid");

    String role;
    String abbr;

    Roles(String role, String abbr) {
        this.role = role;
        this.abbr = abbr;
    }

    public static Roles findRole(String roleStr) {
        for (Roles role : values()) {
            if (role.getRole().equalsIgnoreCase(roleStr) || role.getAbbr().equalsIgnoreCase(roleStr)) {
                return Roles.valueOf(role.name());
            }
        }
        return Roles.ROLE_CHILD;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }
}
