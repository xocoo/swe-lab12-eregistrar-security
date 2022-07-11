package edu.mum.cs.cs425.demowebapps.eregistrar.service;

import java.util.List;

import edu.mum.cs.cs425.demowebapps.eregistrar.model.User;

public interface UserService {

    public abstract List<User> getAllUsers();

    public abstract User saveUser(User user);

    public abstract User getUserById(Integer userId);

}
