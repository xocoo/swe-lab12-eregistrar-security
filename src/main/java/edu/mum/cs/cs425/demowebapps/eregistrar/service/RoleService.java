package edu.mum.cs.cs425.demowebapps.eregistrar.service;

import java.util.List;

import edu.mum.cs.cs425.demowebapps.eregistrar.model.Role;

public interface RoleService {

    public abstract List<Role> getAllRoles();

    public abstract Role addNewRole(Role role);
}
