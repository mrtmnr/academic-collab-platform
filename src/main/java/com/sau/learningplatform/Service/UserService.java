package com.sau.learningplatform.Service;

import com.sau.learningplatform.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findById(int id);
    User findByNumber(String number);

    void saveAll(List<User>users);

}
