package com.chidha.rps.data;

import com.chidha.rps.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
