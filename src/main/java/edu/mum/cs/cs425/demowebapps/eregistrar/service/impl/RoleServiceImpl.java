package edu.mum.cs.cs425.demowebapps.eregistrar.service.impl;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.demowebapps.eregistrar.model.Role;
import edu.mum.cs.cs425.demowebapps.eregistrar.repository.RoleRepository;
import edu.mum.cs.cs425.demowebapps.eregistrar.service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll(Sort.by("name"));
    }

    @Override
    public Role addNewRole(Role role) {
        var newRole = roleRepository.save(role);
        return newRole;
    }
}
