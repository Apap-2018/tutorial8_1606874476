package com.apap.tutorial6.repository;

import com.apap.tutorial6.model.UserRoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleDB extends JpaRepository<UserRoleModel, Long> {
    UserRoleModel findByUsername(String username);
}
