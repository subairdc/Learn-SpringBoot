package com.subairdc.springsecuritydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.subairdc.springsecuritydemo.entity.UserInfo;
import com.subairdc.springsecuritydemo.repository.UserInfoRepository;

@Service
public class UserInfoService {
	
	@Autowired
    private UserInfoRepository repository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addNewUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added to system ";
    }
}
