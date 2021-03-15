package com.movieinfo.app.security.domain;

public enum AppUserPermission {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    MOVIEDB_READ("movieDb:read"),
    MOVIEDB_WRITE("movieDb:write");

    private final String permission;

    AppUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

}
