package com.mitrais.cdc.jpabasic.repository.custom;

import com.mitrais.cdc.jpabasic.model.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> findByName(String name);

    void updateName(User user);

    void deleteById(User user);
}
