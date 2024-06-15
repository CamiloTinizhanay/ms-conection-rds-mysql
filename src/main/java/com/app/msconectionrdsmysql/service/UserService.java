package com.app.msconectionrdsmysql.service;

import com.app.msconectionrdsmysql.jpa.User;
import com.app.msconectionrdsmysql.repository.UserRepository;
import com.app.msconectionrdsmysql.service.dao.IUserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<?> findById(Integer id) {
        return userRepository.findById(id)
                .map(user -> ResponseEntity.ok().body(user))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> deleteById(Integer id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        }).orElse(new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<?>  update(User user) {
        return userRepository.findById(user.getId())
                .map(user1 -> {
                    user1.setName(user.getName());
                    user1.setEmail(user.getEmail());
                    User updatedUser = userRepository.save(user1);
                    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
                }).orElse(ResponseEntity.notFound().build());
    }
}
