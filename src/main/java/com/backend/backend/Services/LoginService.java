package com.backend.backend.Services;

import com.backend.backend.Entities.LoginEntity;
import com.backend.backend.Repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class LoginService {
    @Autowired
    private LoginRepository repo;

    public LoginEntity login(String username, String password) {
        LoginEntity user = repo.findByUsernameAndPassword(username, password);
        return user;
    }

}