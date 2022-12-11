package com.backend.backend.Entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name="login")
public class LoginEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;

    public LoginEntity(String username, String password){

        super();
        this.username = username;
        this.password = password;

    }




}