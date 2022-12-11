package com.backend.backend.Services;

import com.backend.backend.Entities.LoginEntity;
import com.backend.backend.Repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public LoginEntity login(String username, String password) {
        return loginRepository.findByUsernameAndPassword(username, password);
    }

}