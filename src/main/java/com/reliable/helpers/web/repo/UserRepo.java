package com.reliable.helpers.web.repo;

import org.springframework.data.repository.CrudRepository;

import com.reliable.helpers.web.model.User;

public interface UserRepo extends CrudRepository<User, Integer>{

}
