package com.sau.learningplatform.Service;

import com.sau.learningplatform.Entity.User;

import java.util.List;

public interface UserService {
    User findById(int id);

    void saveAll(List<User>users);
}
