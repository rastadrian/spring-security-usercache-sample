package com.rastadrian.spring.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MyUserCache implements UserCache {

    private final Map<String, UserDetails> users;

    @Override
    public UserDetails getUserFromCache(String username) {
        return users.get(username);
    }

    @Override
    public void putUserInCache(UserDetails user) {
        users.put(user.getUsername(), user);
    }

    @Override
    public void removeUserFromCache(String username) {
        users.remove(username);
    }
}
