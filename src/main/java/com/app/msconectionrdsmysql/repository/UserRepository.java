package com.app.msconectionrdsmysql.repository;

import com.app.msconectionrdsmysql.jpa.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
