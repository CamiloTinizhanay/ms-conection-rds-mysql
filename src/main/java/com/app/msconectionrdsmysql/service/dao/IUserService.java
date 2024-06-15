package com.app.msconectionrdsmysql.service.dao;

import com.app.msconectionrdsmysql.jpa.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {

    List<User> findAll();


    User save(User user);

    ResponseEntity<?> findById(Integer id);

    ResponseEntity<?> deleteById(Integer id);

    ResponseEntity<?> update(User user);
}
