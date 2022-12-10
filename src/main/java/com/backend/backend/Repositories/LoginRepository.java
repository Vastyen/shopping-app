package com.backend.backend.Repositories;

import com.backend.backend.Entities.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Long>{
    LoginEntity findByUsernameAndPassword(String username, String password);

}