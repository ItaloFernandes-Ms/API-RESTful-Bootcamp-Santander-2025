package com.bootcamp_santander_2025.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bootcamp_santander_2025.domain.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsbyAccountNumber(String accountNumber);
}
