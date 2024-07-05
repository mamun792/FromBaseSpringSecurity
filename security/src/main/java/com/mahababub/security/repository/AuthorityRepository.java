package com.mahababub.security.repository;

import com.mahababub.security.model.Authority;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    Authority findByAuthority(String authority);
}
