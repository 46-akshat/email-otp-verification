package com.email.emailverification.repository;

import com.email.emailverification.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    Users findByEmail(String email);
}
