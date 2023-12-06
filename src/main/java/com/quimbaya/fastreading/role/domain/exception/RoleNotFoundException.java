package com.quimbaya.fastreading.role.domain.exception;

public class RoleNotFoundException extends RuntimeException {
    
    public RoleNotFoundException(Long roleId) {
        super("Role with ID " + roleId + " not found.");
    }
}