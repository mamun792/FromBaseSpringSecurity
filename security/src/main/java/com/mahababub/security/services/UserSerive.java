package com.mahababub.security.services;

import com.mahababub.security.model.User;

public interface UserSerive {
    public   User findByUsername(String username);
    public void saveUser(User user);

    public void saveAdmin(User user);

}
