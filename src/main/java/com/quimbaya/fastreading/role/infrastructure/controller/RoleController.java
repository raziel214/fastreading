package com.quimbaya.fastreading.role.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quimbaya.fastreading.role.application.service.RoleService;
import com.quimbaya.fastreading.role.domain.exception.RoleNotFoundException;
import com.quimbaya.fastreading.role.domain.model.Role;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> fetchAllRoles() {
        List<Role> roles = roleService.fetchAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role createdRole = roleService.createdRole(role);
        return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
    }
    
    @PostMapping("/{id}")
    public ResponseEntity<Role>finByIdRole(@PathVariable Long id) {
    	Role findIdRole = roleService.findById(id)
    			.orElseThrow(()->new RoleNotFoundException(id));
    	return new ResponseEntity<>(findIdRole, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRole(@PathVariable Long id, @RequestBody Role role) {
        // No need to recreate the Role object, you can directly use the received 'role'.
        Role updatedRole = roleService.updateRole(id, role);
        
        return new ResponseEntity<>(updatedRole, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        boolean isDeleted = roleService.deleteById(id);
        if(isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // HTTP 204 (No Content)
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // HTTP 404 (Not Found)
        }
    }
}
