package edu.mum.cs.cs425.demowebapps.eregistrar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.demowebapps.eregistrar.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
