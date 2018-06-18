package com.mitrais.cdc.jpabasic.repository;

import com.mitrais.cdc.jpabasic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
