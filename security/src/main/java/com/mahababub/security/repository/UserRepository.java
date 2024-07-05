package com.mahababub.security.repository;

import com.mahababub.security.model.Authority;
import com.mahababub.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
  User findByUsernameIgnoreCase(String username);
}
